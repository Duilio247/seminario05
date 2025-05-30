import LoginForm from '../components/LoginForm';
import fondoLogin from '../../../assets/FondoLogin.jpg';

const LoginPage = () => {
  return (
    <div
      style={{
        minHeight: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        backgroundImage: `url(${fondoLogin})`,
        backgroundSize: "cover",
        backgroundPosition: "center",
        backgroundRepeat: "no-repeat",
      }}
    >
      <LoginForm />
    </div>
  );
};

export default LoginPage;
