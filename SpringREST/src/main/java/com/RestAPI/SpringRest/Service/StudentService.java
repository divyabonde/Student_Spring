package com.RestAPI.SpringRest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestAPI.SpringRest.Dao.StudentRepository;
import com.RestAPI.SpringRest.Entities.student;

@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;

    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public student addStudent(student student) {
        return studentRepository.save(student);
    }

    public void updateStudent(Integer id, student student) {
        Optional<student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            student existingStudent = optionalStudent.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setCity(student.getCity());
            existingStudent.setMarks(student.getMarks());
            studentRepository.save(existingStudent);
        }
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
