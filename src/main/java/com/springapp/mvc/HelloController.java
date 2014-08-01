package com.springapp.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.sun.xml.internal.ws.encoding.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.List;


@Controller
@RequestMapping("/api/ssd/ads/")  // @RequestMapping("/")
public class HelloController {
    @Autowired
    private ADRepository adRepository;

	@RequestMapping(method = RequestMethod.GET)
	public
    @ResponseBody
    ResponseEntity<String> printWelcome(ModelMap model) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        model.addAttribute("ad", new AD());

        List<AD> store = adRepository.findAll();

        AD record = adRepository.findOne(1L);

        // convert to JSON
        model.addAttribute("ads", store);

		model.addAttribute("message", "Hello world!");

        JSONObject adJSON = new JSONObject();
        adJSON.put("id", record.getId());

        JSONArray adArray = new JSONArray();
        for(AD ad : store){
            JSONObject _adJSON = new JSONObject();
            _adJSON.put("id", ad.getId());
            _adJSON.put("ads_id", ad.getAdsId());
            _adJSON.put("Ads_Image", ad.getAdsImage());
            adArray.put(_adJSON);
        }

		// return "hello" // chagne view;
        // return "ads";
        // return adJSON.toString();
        // return adArray.toString();
        return new ResponseEntity<String>(adArray.toString(), headers, HttpStatus.ACCEPTED);
	}
}