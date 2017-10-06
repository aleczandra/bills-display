package bills.billsdisplay.controller;

import java.io.IOException;

import bills.billsdisplay.service.BillsReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndexController {

    @Autowired
    BillsReader billsReader;
    ObjectMapper mapper = new ObjectMapper();


    @RequestMapping(value = "bills", method = RequestMethod.GET)
    public String getBills() throws IOException {
        String s = billsReader.performSearch();
        return s;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String itWorks() throws IOException {
        return "It works Ta na na na!";
    }

}
