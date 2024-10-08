import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import RegistrationForm from './components/RegistrationForm';
import Home from './components/Home'; // Import Home component

function App() {
  return (
    <Router>
      <div>
        {/* Navigation buttons */}
        <nav>
          <a href="/home">
            <button>Home</button>
          </a>
          <a href="/login">
            <button>Login</button>
          </a>
          <a href="/register">
            <button>Register</button>
          </a>
        </nav>

        {/* Define the routes */}
        <Routes>
          <Route path="/" element={<Navigate to="/home" />} /> {/* Redirect root to home */}
          <Route path="/home" Component={Home} />
          <Route path="/login" Component={LoginForm} />
          <Route path="/register" Component={RegistrationForm} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
