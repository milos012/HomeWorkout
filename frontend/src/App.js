import logo from './logo.svg';
import './App.css';
import UserDataEdit from './components/UserDataComponent';
import ChooseCardio from './components/CardioComponent';
import ChooseStrength from './components/StrengthComponent';
import WorkoutGenerator from './components/WorkoutComponent';
import Navbar from './components/Navbar';
import Home from './components/HomeComponent';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <div className="content">
          <Switch>
            <Route exact path="/">
              <Home/>
            </Route>
            <Route path="/editUser">
              <UserDataEdit/>
            </Route>
            <Route path="/chooseCardio">
              <ChooseCardio/>
            </Route>
            <Route path="/chooseStrength">
              <ChooseStrength/>
            </Route>
            <Route path="/generateWO">
              <WorkoutGenerator/>
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  );
}

export default App;
