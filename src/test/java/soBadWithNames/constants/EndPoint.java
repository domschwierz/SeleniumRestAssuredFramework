package soBadWithNames.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");

    public String url;

    EndPoint(String url) {
        this.url = url;
    }
}
