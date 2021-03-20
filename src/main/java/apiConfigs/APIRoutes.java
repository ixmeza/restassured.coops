package apiConfigs;

import utils.ReadProperties;

public class APIRoutes {
    public static final class apiRoutes{
        public static final String UNLOCK_BARN = "/api/"+ new ReadProperties().getUserId()  +"/barn-unlock";
        public static final String FEED_CHICKENS = "/api/"+ new ReadProperties().getUserId() +"/chickens-feed";
        public static final String COLLECT_EGGS = "/api/"+ new ReadProperties().getUserId() +"/eggs-collect";
        public static final String EGG_COUNT = "/api/"+ new ReadProperties().getUserId() +"/eggs-count";
        public static final String TOKEN = "/token";
    }
}
