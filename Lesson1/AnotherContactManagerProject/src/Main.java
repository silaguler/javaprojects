public class Main {
    public static void main(String[] args){
        ContactsManager myContactManager = new ContactsManager();
        Contact firstFriend = new Contact();
        firstFriend.name = "Gizem";
        firstFriend.phone = "123";
        firstFriend.email = "gizem@gmail.com";
        myContactManager.addContact(firstFriend);

        // for 2nd and 3rd contacts
        Contact secFriend = new Contact();
        secFriend.name = "Bilge";
        secFriend.phone = "123";
        secFriend.email = "bilge@gmail.com";
        Contact thiFriend = new Contact();
        thiFriend.name = "Merve";
        thiFriend.phone = "123";
        thiFriend.email = "merve@gmail.com";

        //add contacts to the list
        myContactManager.addContact(secFriend);
        myContactManager.addContact(thiFriend);

        System.out.println(myContactManager.contactList[0].name);

        Contact theContact = myContactManager.searchContact("fuck");
        System.out.println(theContact.phone);

    }
}
