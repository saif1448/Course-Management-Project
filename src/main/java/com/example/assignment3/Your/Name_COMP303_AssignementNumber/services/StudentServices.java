package com.example.assignment3.Your.Name_COMP303_AssignementNumber.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Student;

@Service
public class StudentServices {

    List <Student> studentList = new ArrayList<>();

    public Student insertStudent(Student student) {
        studentList.add(student);
        return student;
        
    }

    public Student getById(int id) {
        for(Student student: studentList)
        {
            if(student.getId()==id)
            {
                return student;
            }
        }
        return null;

    }

    public List<Student> getAll() {
        return studentList;
    }

    public Student modifyStudent(int id, Student student) {
        for(int i = 0; i<studentList.size(); i++)
        {
            if(studentList.get(i).getId()==id)
            {
               studentList.set(i, student);
               return studentList.get(i);
            }
        }
        return null;
    }
   

    public boolean removeStudent(int id) {

        if(getById(id)!= null)
        {
            studentList.remove(getById(id));
            return true;
        }
        else
        {
            return false;
        }
     
    }

    
}
