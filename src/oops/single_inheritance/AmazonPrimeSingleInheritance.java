package oops.single_inheritance;

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

//Sub Class - PrimeUser extends User
class PrimeUser extends User{
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



public class AmazonPrimeSingleInheritance {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------");
        User u1 = new User();
        u1.setDetails("Dennis","dennis@gmail.com");
        u1.displayIntro();
        u1.seeContent();
        u1.watchFreeVideos();
        // u1.watchPremiumVideos(); // ERROR
        PrimeUser pu1 = new PrimeUser();
        pu1.initData(299,3);
        pu1.setDetails("John","john@gmail.com");
        pu1.displayIntro();
        pu1.seeContent();
        pu1.watchFreeVideos();
        pu1.watchPremiumVideos();
        System.out.println("----------------------------------------------------------");
    }
}
