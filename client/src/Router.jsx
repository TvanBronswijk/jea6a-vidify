import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import "./Router.css";
import Home from "./modules/views/Home/Home";
import Videos from "./modules/views/Videos/Videos";
import Playlist from "./modules/views/Playlist/Playlist";

class Router extends Component {
    render() {
        return (
            <BrowserRouter>
                <div className="page-container">
                    <Route exact path='/'
                           component={(props) => <Home {...props} />} />
                    <Route exact path='/videos'
                           component={(props) => <Videos {...props} />} />
                    <Route exact path='/playlist/:id'
                           component={({ match, props }) => <Playlist id={match.params.id} {...props} />} />
                </div>
            </BrowserRouter>
        );
    }
}

export default Router;