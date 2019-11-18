package igal.m.triviac;

public class Users {

        String userName, userEmail, userPhoneNumber;

        public Users(){}

        public Users(String userName,String userEmail, String userPhoneNumber) {
            this.userName = userName;
            this.userEmail = userEmail;
            this.userPhoneNumber = userPhoneNumber;
        }

        public String getUserName() {
            return userName;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public String getUserPhoneNumber() {
            return userPhoneNumber;
        }

}
