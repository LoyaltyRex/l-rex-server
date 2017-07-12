package org.loyaltyrex.server.webapp.server.impl;

import org.loyaltyrex.server.core.domain.model.Business;
import org.loyaltyrex.server.core.rest.api.BusinessRequestPaths;
import org.loyaltyrex.server.core.rest.util.ContentTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BusinessRestServer {

    /**
     * <p>
     * Status codes:
     * <ul>
     * <li>200 OK - if result was successfully retrieved</li>
     * </ul>
     * 
     * @param id
     *            The ID of the business to look up
     * @return A representation of the business
     * @since 0.1.0
     */
    @ResponseBody
    @RequestMapping(path = BusinessRequestPaths.BUSINESS, method = RequestMethod.GET, produces = { ContentTypes.APPLICATION_V1, ContentTypes.APPLICATION_JSON })
    public ResponseEntity<Business> getBusiness(@RequestParam(name = "id", required = true) String id) {
        return null;
    }
    
}
