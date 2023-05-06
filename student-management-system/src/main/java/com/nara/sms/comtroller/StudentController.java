package com.nara.sms.comtroller;

import com.nara.sms.entity.Student;
import com.nara.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler method to get list of students
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        //create student obj to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);

        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student ) {
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id , Model model) {
//        studentService.saveStudent(student);
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    //handler method to handle edit_student.html update action
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id ,
                                @ModelAttribute("student") Student student,
                                Model model) {

        //get student details from DB using by Id
        Student existingStudentDetails = studentService.getStudentById(id);
        existingStudentDetails.setId(id);
        existingStudentDetails.setFirstName(student.getFirstName());
        existingStudentDetails.setLastName(student.getLastName());
        existingStudentDetails.setEmail(student.getEmail());
        studentService.updateStudent(existingStudentDetails);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);

        return "redirect:/students";
    }
}
