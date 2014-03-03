/**
 * Created by yodatak on 27/02/14.
 */
class Main {
    //please met des commentaires !!!!!!!!!
    public static void main (String[] args){
        System.out.println("Hello World");

        if(args.length >= 2 && args[0] == "--level"){
            System.out.println("Play level" + args[1]);
        }
        else if(args.length >= 1 && args[0] == "--create"){
            System.out.println("Create");
        }
        else{
            System.out.println("Play from the beginning");
        }
    }
}