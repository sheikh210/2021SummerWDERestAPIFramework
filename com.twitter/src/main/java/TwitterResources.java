public class TwitterResources {

    private static final String DELETE_TWEET_ENDPOINT = "/statuses/destroy/";
    private static final String CREATE_TWEET_ENDPOINT = "/statuses/update.json";

    public static String getDeleteTweetEndpoint(String tweetID) {
        return DELETE_TWEET_ENDPOINT + tweetID + ".json";
    }

    public static String getCreateTweetEndpoint() {
        return CREATE_TWEET_ENDPOINT;
    }
}
