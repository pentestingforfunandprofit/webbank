/*
 * Copyright 2007-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tuskmutual.web.servlet.mvc;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tuskmutual.web.orm.entity.Stock;
import com.tuskmutual.web.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StockController {

    final Logger logger = LoggerFactory.getLogger(getClass());
    
    
    private static final String SEARCH_VIEW_KEY = "redirect:search.html";
    private static final String SEARCH_MODEL_KEY = "stocks";

    private final StockService service;

    @Autowired
    public StockController(StockService service) {
        this.service = service;
    }

    /**
     * For every request for this controller, this will 
     * create a stock instance for the form.
     */
    @ModelAttribute
    public Stock newRequest(@RequestParam(required=false) Integer id) {
        return (new Stock());
    }

    /*
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public @ModelAttribute(SEARCH_MODEL_KEY) Collection<Stock> form() {
        return service.find();
    }
*/
    /**
     * <p>Saves a stock.</p>
     */
    @RequestMapping(value="/stock/add", method=RequestMethod.GET)
    public Stock form(Stock stock, Model model) {
        Stock result = service.save(stock);
        
        model.addAttribute("statusMessageKey", "person.form.msg.success");
        
        return result;
    }

    /*
    @RequestMapping(value="/images/protected/publish")
    public PressRelease publish(Model model) {

        PressRelease pressRelease = new PressRelease();
        pressRelease.setReleaseText("Tusk Mutual enters definitive agreement to acquire controlling interest in Bank of Greenland");
        pressRelease.setCreated(new Date());

        PressRelease result = service.save(pressRelease);
        
        model.addAttribute("statusMessageKey", "person.form.msg.success");
        
        return result;
    }
    */
}
