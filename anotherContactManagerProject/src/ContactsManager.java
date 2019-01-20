public class ContactsManager {
    Contact[] contactList;
    int numOfContacts;

    ContactsManager(){
        contactList = new Contact[10];
        numOfContacts = 0;
    }
    void addContact(Contact newContactToAdd){
        this.contactList[numOfContacts] = newContactToAdd;
        numOfContacts ++;
    }

    Contact searchContact(String keyword){
        Contact theContact = new Contact();
        for(int i =0; i < numOfContacts; i ++){
            if (contactList[i].name.equals(keyword) || contactList[i].phone.equals(keyword) || contactList[i].email.equals(keyword)){
                theContact = contactList[i];
            }
        }
        return theContact;
    }


}
