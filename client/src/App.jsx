import React, {Component} from 'react';
import NavBar from "./modules/views/NavBar/NavBar";
import "./App.css";

class App extends Component {


    render() {
        return <div className="background">
            <NavBar />
            <div className="flex-container" style={{margin: "5px 5px 5px 5px"}}>
            {
                this.props.children
            }
            </div>
        </div>;
    }
}

export default App;
