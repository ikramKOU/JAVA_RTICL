const loginForm = document.querySelector('form');
const usernameInput = document.querySelector('#username') as HTMLInputElement;
const passwordInput = document.querySelector('#password') as HTMLInputElement;
const loginBtn = document.querySelector('#login-btn');

// Login form event listener
loginForm?.addEventListener('submit', (event) => {
  event.preventDefault(); // Prevent form submission
  const username = usernameInput.value;
  const password = passwordInput.value;
  login(username, password); // Call login function
});

// Login function
function login(username: string, password: string) {
  // Check username and password and perform login operation
  if (username === 'admin' && password === 'password') {
    // Redirect to student management page on successful login
    window.location.href = 'student-management.html';
  } else {
    // Show error message on failed login
    alert('Invalid username or password!');
  }
}
HTML code for student management page:

html
Copy code
<!DOCTYPE html>
<html>
  <head>
    <title>Student Management Page</title>
    <link rel="stylesheet" href="styles.css">
  </head>
  <body>
    <div class="container">
      <h1>Student Management</h1>
      <table>
        <thead>
          <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Student Age</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>John Doe</td>
            <td>20</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Jane Doe</td>
            <td>21</td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</html>

const studentTable = document.querySelector('table');

// Add event listener for table row click
studentTable?.addEventListener('click', (event) => {
  const target = event.target as HTMLElement;
  if (target.tagName.toLowerCase() === 'td') {
    // Get student ID from table row
    const studentId = target.parentElement?.firstElementChild?.textContent;
    // Redirect to student details page with student ID parameter
    window.location.href = `student-details.html?id=${studentId}`;

    const studentTable = document.querySelector('table');

// Add event listener for table row click
studentTable?.addEventListener('click', (event) => {
  const target = event.target ;
  if (target.tagName.toLowerCase() === 'td') {
    // Get student ID from table row
    const studentId = target.parentElement?.firstElementChild?.textContent;
    // Redirect to student details page with student ID parameter
    window.location.href = `student-details.html?id=${studentId}`;
  }
});
  }
});







