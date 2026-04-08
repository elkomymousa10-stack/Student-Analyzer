import java.util.ArrayList;
public class StudentAnalyzer{
    private ArrayList<Student> studentList;
    public StudentAnalyzer(ArrayList<Student> list){
        studentList = list;
    }
    public int countAbove(int threshold){
        int count=0;
        //enhanced for loop for more effecient and less coding 
        for(Student s: studentList){
            //if statement to find quantity of people above threshold
            if(s.getMarks()>threshold){
                count++;
            }
        }
        return count;
    }
    public void removeFailing(int passMark){
        //reverse loop in order to make sure we traverse through each student and not skip any in the removing process
        for(int i=studentList.size()-1;i>=0;i--){
            if(studentList.get(i).getMarks()<passMark){
                studentList.remove(i);
            }
        }
    }
    public Student findTopStudent(){
        Student top = studentList.get(0);
        for(Student s: studentList){
            if(s.getMarks()>top.getMarks()){
                top=s;
            }
        }
        return top;
    }
    
    public ArrayList<Student> getTopStudents(int threshold){
        //creating a new list to sture the students who scored higher
        ArrayList <Student> list= new ArrayList<Student>();
        for(Student s:studentList){
            if(s.getMarks()>=threshold){
                list.add(s);
            }
        }
        return list;
    }

    public boolean hasDuplicateNames(){
        //nested for loop to compare element with each one and we skip last one since itll already be compared to all of them each time
        for(int i=0;i<studentList.size()-1;i++){
            String current = studentList.get(i).getName();
            for(int x=i+1;x<studentList.size();x++){
                if(current.equals(studentList.get(x).getName())){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isSorted(){
        //-1 in the loop condition to prevent arrayoutofindexbound in the i+1
        for(int i=0;i<studentList.size()-1;i++){
            if(studentList.get(i).getMarks()>studentList.get(i+1).getMarks()){
                return false;
            }
        }
        return true;
    }
    public int countImprovingPairs(){
        int count=0;
        for(int i=0;i<studentList.size()-1;i++){
            if(studentList.get(i).getMarks()<studentList.get(i+1).getMarks()){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<Student>();//creating new list of Student type
        list.add(new Student("ali",55));
        list.add(new Student("ahmed",67));
        list.add(new Student("mohanad",44));
        list.add(new Student("mohamed",56));
        list.add(new Student("hamida",88));
        list.add(new Student("abdulla",43));
        list.add(new Student("sara",12));
        list.add(new Student("hani",16));
        list.add(new Student("malak",78));
        list.add(new Student("salma",11));
        StudentAnalyzer analyzer= new StudentAnalyzer(list);//creating the analyzer to use the methods i created
        System.out.println("test:");//testing out all the methods to ensure its correct
        System.out.println("Students who scored more than 50: "+analyzer.countAbove(50));
        System.out.println("The stuent with highest mark is: "+analyzer.findTopStudent());
        System.out.println("Students with marks more than 60 are: "+analyzer.getTopStudents(60));
        System.out.println("Is there a duplicate name in the list? "+analyzer.hasDuplicateNames());
        System.out.println("is the list sorted in non decreasing order of marks? "+analyzer.isSorted());
        System.out.println("How many students have marks greater than the previous sutdent in list? "+analyzer.countImprovingPairs());
        analyzer.removeFailing(50);
        System.out.println("students that passed are: "+analyzer);
    }
}    

