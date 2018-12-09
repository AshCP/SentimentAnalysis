/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapplication;

import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.List;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
//import javafx.animation.Animation.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 */
public class TwitterApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {
        // TODO code application logic here
        ConfigurationBuilder cf = new ConfigurationBuilder();
                
        cf.setDebugEnabled(true)                
                .setOAuthConsumerKey("CzDedjpnsQ9uPjZSkuUVAD4dE")
                .setOAuthConsumerSecret("lZn6yQ5BJPedTc0rdZtfnffwNd7Of4CyFbiaoPh9FKgIBPHFUs")
                .setOAuthAccessToken("710124266352545792-w4lNgI901TpWF9ciXGleTiVl5n3wg3N")
                .setOAuthAccessTokenSecret("7D82gawaQJP7QcFPRS4qICvdXwS5d4YG1mxWhWSPynGU4");
        
            //<editor-fold defaultstate="collapsed" desc="TEST CODE FOR LIVE TIME LINE">
        
        TwitterFactory tf = new TwitterFactory(cf.build());
        twitter4j.Twitter twitter = tf.getInstance();
        List<Status> status = twitter.getHomeTimeline();
        System.out.println("************************* TIMELINE TWEETS STARTS  ********************************************");
        System.out.println();
        for(Status st : status)
        {
            System.out.println(st.getUser().getName()+"----"+st.getText());
        }
        System.out.println();
        System.out.println("************************* TIMELINE TWEETS END  ********************************************");
        System.out.println();
        
        //</editor-fold>
        
                        
            //<editor-fold defaultstate="collapsed" desc="CODE FOR TWEET SEARCH">
            //TwitterFactory tf = new TwitterFactory(cf.build());
            //Twitter twitter = tf.getInstance();
           try {
            Query query = new Query("Peace");
            query.setLang("en");
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
                System.out.println();
                System.out.println("************************* SEARCH TWEETS STARTS  ********************************************");
                System.out.println();
            for (Status tweet : tweets) {                
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }

            System.exit(0);
            }
            catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
            }
            
            
            //</editor-fold>
            
            }
            }
