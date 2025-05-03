package com.ptit.ttcs.bookstore.JsonViews;


public class View {
    public static class Basic{};

    public static class BookInfo extends Basic{};

    public static class AuthorWithBook extends Basic {}
    public static class AllBooksInCategory extends Basic {}
    public static class AllBookOfPublisher extends Basic {}
    public static class AllBookInLanguage extends Basic {}

    public static class UserInfo extends Basic {}
    public static class CartInfo extends Basic {}
    public static class AllInvoicesOfUser extends Basic {}


}
