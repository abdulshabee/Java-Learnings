package learnings.classAndObjs.Nested;

public class LocalClassExample {

    static String regExp = "[^0-9]";


    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2){

        int numberLength = 10;

        class PhoneNumber{

            String formatterNumber = null;

            public PhoneNumber(String phoneNumber){
              String currenNumber = phoneNumber.replaceAll(regExp,"");

               if(currenNumber.length() == 10){
                   formatterNumber = currenNumber;
               }
            }

            public void printPhoneNumber(){
                System.out.printf("Original numbers are %s and %s %n",phoneNumber1,phoneNumber2);
            }

            public String getNumber(){
                return formatterNumber;
            }
        }

        PhoneNumber phone1 = new PhoneNumber(phoneNumber1);
        PhoneNumber phone2 = new PhoneNumber(phoneNumber2);

        phone1.printPhoneNumber();;
        if (phone1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + phone1.getNumber());
        if (phone2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + phone2.getNumber());
    }

    public static void main(String[] args) {
        validatePhoneNumber("99887 76655","1234 1234");
    }
}
