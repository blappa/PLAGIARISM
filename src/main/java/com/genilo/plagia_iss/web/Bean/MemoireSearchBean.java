/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genilo.plagia_iss.web.Bean;

import org.apache.lucene.queryParser.ParseException;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author lappa
 */
public class MemoireSearchBean {

    // location where the index will be stored.
    private static final String INDEX_DIR = "/home/lappa/NetBeansProjects/a/Plagiat/src/main/webapp/index";
    private static final String FILE_DIR = "/home/lappa/Documents/TPE.pdf";
    private static final int DEFAULT_RESULT_SIZE = 100;

    public static void main(String[] args) throws IOException, ParseException {

        File pdfFile = new File(FILE_DIR);
        IndexItem pdfIndexItem = index(pdfFile);

        // creating an instance of the indexer class and indexing the items
        Indexer indexer = new Indexer(INDEX_DIR);
        indexer.index(pdfIndexItem);
        indexer.close();

        // creating an instance of the Searcher class to the query the index
        Searcher searcher = new Searcher(INDEX_DIR);
        int result = searcher.findByContent("Java", DEFAULT_RESULT_SIZE);
        print(result);
        searcher.close();
    }

    //Extract text from PDF document
    public static IndexItem index(File file) throws IOException {
        PDDocument doc = PDDocument.load(file);
        String content = new PDFTextStripper().getText(doc);
        doc.close();
        return new IndexItem((long) file.getName().hashCode(), file.getName(), content);
    }

    //Print the results
    private static void print(int result) {
        if (result == 1) {
            System.out.println("The document contains the search keyword");
        } else {
            System.out.println("The document does not contain the search keyword");
        }

    }
}
