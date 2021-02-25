package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.math.BigInteger;
import java.security.MessageDigest;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {


    public static final String APPLICATION_SECRET_KEY = "12345";

    public Result index() {
        return ok(views.html.index.render());
    }

    public Result encrypt(Http.Request request) throws NoSuchAlgorithmException, InvalidKeyException {
        String valueToDigest = request.body().asJson().findPath("unencrypted").textValue();

        byte[] key = APPLICATION_SECRET_KEY.getBytes();

        HmacUtils hm = new HmacUtils();
        String encrypted = hm.generateHmac256(valueToDigest, key);

        ObjectNode result = Json.newObject();
        result.put("encrypted", encrypted);
        return ok(result);
    }

    public Result decrypt(Http.Request request) {

        return ok(views.html.index.render());
    }
}


