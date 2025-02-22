package Common;

public class Locators {

    public static class Landingpage{
        public static String loginButtonXpath = "//div[contains(@class,'nI-gNb-header')]//a[text()='Login']";
        public static String singInWithGoogleButtonXpath = "//div[@class='login-layer']//span[text()='Sign in with Google']";
    }

    public static class googleSignIn{
        public static String emailFieldXpath = "//input[@type='email']";
        public static String passwordFieldXpath = "//input[@type='password']";
        public static String nextButtonXpath = "//span[text()='Next']";
    }

    public static class LoggedInPage{
        public static String sideMenuDrawerButtonXpath = "//div[@class='nI-gNb-drawer__icon']";
        public static String viewAndUpdateProfileButtonXpath = "//div[@class='nI-gNb-drawer__expand']//a[text()='View & Update Profile']";
    }

    public static class UpdateNaurkiDetailsPage{
        public static String updateResumeButtonXpath = "//input[@value='Update resume']";
        public static String updatedDateLabelXpath = "//div[contains(@class,'updateOn')]";
    }
}
