package com.sda.comparison2.scraper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexScraper {


    private String url = "http://www.emag.com/search/boxa";

    private EmagScraper scraper;

    Pattern titelPatern = Pattern.compile("(<h1 class=\"page-title\">)((.|\\n)*)(<\\/h1>)");
    Matcher matcher = titelPatern.matcher((CharSequence) scraper);


}
