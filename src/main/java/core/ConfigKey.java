package core;

public enum ConfigKey {
    BaseUrl("https://www.masterteam.sa/contact-us");

    private final String key;

    ConfigKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
