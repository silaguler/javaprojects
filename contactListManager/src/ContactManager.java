public class ContactManager {
    Contact[] myFriends;
    int numOfFriends;
    ContactManager(){
        this.myFriends = new Contact[500];
        this.numOfFriends = 0;
    }

    void addContact(Contact newContact){
        myFriends[numOfFriends] = newContact;
        numOfFriends ++;
    }
    Contact searchContact(String nameToBeSearched){
        for(int i =0; i<numOfFriends; i ++){
            if(myFriends[i].name.equals(nameToBeSearched)){
                return myFriends[i];
            }
        }
        return null;
    }



}
