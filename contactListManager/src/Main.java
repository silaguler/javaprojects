public class Main {
    public static void main(String [] args){
        ContactManager contMan = new ContactManager();
        System.out.println(contMan.numOfFriends);
        Contact friend1 = new Contact("Sila", "0627058339", "s.guler@tue.nl");
        contMan.addContact(friend1);
        System.out.println(contMan.numOfFriends);
        for(int i =0; i < contMan.numOfFriends; i++){
            System.out.print(contMan.myFriends[i].name +" "+ contMan.myFriends[i].phonenumber +" "+ contMan.myFriends[i].email);
        }

        System.out.println();
        Contact foundContact = contMan.searchContact("sila");
        if(foundContact!=null){
            System.out.println(foundContact.name);
        };
    }
}

