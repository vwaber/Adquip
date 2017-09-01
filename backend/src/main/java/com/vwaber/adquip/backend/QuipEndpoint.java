/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.vwaber.adquip.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.vwaber.quips.Quip;
import com.vwaber.quips.QuipGenerator;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "quipService",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.adquip.vwaber.com",
                ownerName = "backend.adquip.vwaber.com"
        )
)
public class QuipEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getQuip")
    public QuipData getQuip() {
        QuipData response = new QuipData();

        QuipGenerator generator = new QuipGenerator();
        Quip quip = generator.getNext();

        response.setSetup(quip.getSetup());
        response.setPunchline(quip.getPunchline());

        return response;
    }

}
