package oops.multi_level_inheritance;
//Base Class - User
class User {
    String name;
    String email;

    void setDetails(String n,String e){
        name = n;
        email= e;
    }
    void displayIntro(){
        System.out.println("You are NOT A PRIME user");
        System.out.println("Name: "+name+", Email: "+email);
    }
    void seeContent(){
        System.out.println("You can browse the contents");
    }
    void watchFreeVideos() {
        System.out.println("You can watch free videos");
    }
}

//Sub Class - PrimeUser extends User - Single Inheritance
class PrimeUser extends User {
    int subscription;
    int months;

    void initData(int s, int m){
        subscription = s;
        months = m;
    }
    void displayIntro(){
        System.out.println("You are a PRIME user");
        System.out.println("Name: "+name+", Email: "+email);
    }
    void watchPremiumVideos(){
        System.out.println("You can watch premium videos, You are subscribed at $ "+subscription+" for "+months+" months");
    }
}

// Sub Class - VipUser extends User - MultiLevel Inheritance
class VipUser extends PrimeUser{
    void displayIntro(){
        System.out.println("You are a VIP user");
        System.out.println("Name: "+name+", Email: "+email);
    }
    void watchLocationRestrictedContent(){
        System.out.println("You can watch location restricted content");
    }
}

public class AmazonPrimeMultiLevelInheritance {
    public static void main(String[] args) {

        System.out.println("----------------------------------------------------------");
        User u1 = new User();
        u1.setDetails("Dennis","dennis@gmail.com");
        u1.displayIntro();
        u1.seeContent();
        u1.watchFreeVideos();
        // u1.watchPremiumVideos(); // ERROR

        System.out.println("----------------------------------------------------------");
        PrimeUser pu1 = new PrimeUser();
        pu1.initData(299,3);
        pu1.setDetails("John","john@gmail.com");
        pu1.displayIntro();
        pu1.seeContent();
        pu1.watchFreeVideos();
        pu1.watchPremiumVideos();

        System.out.println("----------------------------------------------------------");
        VipUser v1 = new VipUser();
        v1.initData(1000,6);
        v1.setDetails("Marcus","marcus@gmail.com");
        v1.displayIntro();
        v1.seeContent();
        v1.watchFreeVideos();
        v1.watchPremiumVideos();
        v1.watchLocationRestrictedContent();
    }
}
