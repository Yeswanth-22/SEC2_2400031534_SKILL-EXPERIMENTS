import { useState } from 'react'

const initialStudents = [
  { id: '101', name: 'Aarav Sharma', course: 'Computer Science' },
  { id: '102', name: 'Neha Verma', course: 'Mathematics' },
  { id: '103', name: 'Rohan Patel', course: 'Physics' },
  { id: '104', name: 'Isha Nair', course: 'Biotechnology' },
  { id: '105', name: 'Kabir Singh', course: 'Economics' },
]

const emptyStudent = {
  id: '',
  name: '',
  course: '',
}

function StudentManager() {
  const [students, setStudents] = useState(initialStudents)
  const [newStudent, setNewStudent] = useState(emptyStudent)

  const handleChange = (event) => {
    const { name, value } = event.target
    setNewStudent((prevStudent) => ({
      ...prevStudent,
      [name]: value,
    }))
  }

  const handleAddStudent = () => {
    const trimmedStudent = {
      id: newStudent.id.trim(),
      name: newStudent.name.trim(),
      course: newStudent.course.trim(),
    }

    if (!trimmedStudent.id || !trimmedStudent.name || !trimmedStudent.course) {
      return
    }

    setStudents((prevStudents) => [...prevStudents, trimmedStudent])
    setNewStudent(emptyStudent)
  }

  const handleDeleteStudent = (studentId) => {
    setStudents((prevStudents) =>
      prevStudents.filter((student) => student.id !== studentId),
    )
  }

  return (
    <main className="student-manager">
      <h1>Student Manager</h1>

      <section className="form-card" aria-label="Add new student">
        <div className="input-grid">
          <input
            type="text"
            name="id"
            placeholder="Student ID"
            value={newStudent.id}
            onChange={handleChange}
          />
          <input
            type="text"
            name="name"
            placeholder="Student Name"
            value={newStudent.name}
            onChange={handleChange}
          />
          <input
            type="text"
            name="course"
            placeholder="Course"
            value={newStudent.course}
            onChange={handleChange}
          />
          <button type="button" onClick={handleAddStudent}>
            Add Student
          </button>
        </div>
      </section>

      <section className="table-card" aria-label="Student list">
        {students.length === 0 ? (
          <p className="empty-message">No students available</p>
        ) : (
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Course</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {students.map((student) => (
                <tr key={`${student.id}-${student.name}`}>
                  <td>{student.id}</td>
                  <td>{student.name}</td>
                  <td>{student.course}</td>
                  <td>
                    <button
                      type="button"
                      className="delete-button"
                      onClick={() => handleDeleteStudent(student.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </section>
    </main>
  )
}

export default StudentManager
