package com.epam.mjc;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.System.out;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        String[] resultsWidthEmpty = source.split(delimiters.toString());
        List<String> resultsWithoutEmpty = new ArrayList<>();

        for(String sub : resultsWidthEmpty) {
            if(!sub.isEmpty()) {
                resultsWithoutEmpty.add(sub);
            }
        }
        return resultsWithoutEmpty;
    }
}
