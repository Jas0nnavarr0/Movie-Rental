import { useSelector } from "react-redux";
import { Navigate, Outlet } from "react-router-dom";

const HiddenRoute = ({ isAvailable = false }) => {

    const { user } = useSelector((state) => state.auth);

    if (isAvailable) {
        return user ? <Navigate to="/userhome"/> : <Outlet />;
    }

    return user ? <Outlet /> : <Navigate to="/"/>;
}

export default HiddenRoute;