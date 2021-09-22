public class TestApp {
    public static void main(String[] args) {
        StudentDao dao = StudentDao.getInstance();
        for (int i = 0; i < 1000; i++) {
            Student student = new Student("name" + i, i);
            dao.createStudent(student);
        }
        System.out.println(dao.getStudentById(3L));
        Student student1 = dao.getStudentById(5L);
        student1.setName("Vasya");
        dao.updateStudent(student1);
        System.out.println(dao.getStudentById(5L));
        dao.deleteStudent(dao.getStudentById(6L));
        dao.getAllStudents().forEach(System.out::println);
    }
}
