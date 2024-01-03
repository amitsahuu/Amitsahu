import java.util.HashMap;
import java.util.Map;
public class URLShortener{
        private Map<String, String> shortToLongMap;
        private Map<String, String> longToShortMap;
        private int counter;

        public URLShortener() {
            this.shortToLongMap = new HashMap<>();
            this.longToShortMap = new HashMap<>();
            this.counter = 1;
        }

        public String shortenURL(String longURL) {
            if (longToShortMap.containsKey(longURL)) {
                return longToShortMap.get(longURL);
            }

            String shortURL = generateShortURL();
            shortToLongMap.put(shortURL, longURL);
            longToShortMap.put(longURL, shortURL);
            return shortURL;
        }

        public String expandURL(String shortURL) {
            return shortToLongMap.getOrDefault(shortURL, "Invalid short URL");
        }

        private String generateShortURL() {
            // Basic hash function using a counter
            return "short_" + counter++;
        }

        public static void main(String[] args) {
            URLShortener urlShortener = new URLShortener();

            // Example usage
            String longURL = "https://www.example.com";
            String shortURL = urlShortener.shortenURL(longURL);
            System.out.println("Shortened URL: " + shortURL);

            String expandedURL = urlShortener.expandURL(shortURL);
            System.out.println("Expanded URL: " + expandedURL);
        }
    }
