import java.util.*;

class OpenClosedDemo {
    public static void main(String[] args) {
        List<Educator> lecturers = new ArrayList<>();
        
        lecturers.add(new Engineer("John"));
        lecturers.add(new Lawyer("Jane"));
        lecturers.add(new Engineer("Tom"));
        lecturers.add(new Lawyer("Jack"));
        lecturers.add(new Lawyer("Alan"));
        lecturers.add(new Engineer("Anne"));
        
        EducationInstitute apiit = new EducationInstitute();
        apiit.setLecturers(lecturers);
        
        for(Educator e : apiit.getLecturers()) {
            e.teach();
        }
    }
}

class EducationInstitute {
    private List<Educator> lecturers;
    
    public void setLecturers(List<Educator> lecturers) {
        this.lecturers = lecturers;
    }
    
    public List<Educator> getLecturers() {
        return this.lecturers;
    }
}

interface Educator {
    void teach();

    void research();
}

class Engineer implements Educator {
    public final String name;
    public final Designation designation;
    
    public Engineer(String name) {
        this.name = name;
        this.designation = Designation.ENGINEER;
    }

    public void teach() {
        System.out.printf("%s(Designation: %s) is teaching...\n", this.name, this.designation);
    }

    public void research() {
        System.out.printf("%s(Designation: %s) is doing research...\n", this.name, this.designation);
    }
}

class Lawyer implements Educator {
    public final String name;
    public final Designation designation;
    
    public Lawyer(String name) {
        this.name = name;
        this.designation = Designation.LAWYER;
    }

    public void teach() {
        System.out.printf("%s(Designation: %s) is teaching...\n", this.name, this.designation);
    }

    public void research() {
        System.out.printf("%s(Designation: %s) is doing research...\n", this.name, this.designation);
    }
}

enum Designation {
    ENGINEER,
    LAWYER
}