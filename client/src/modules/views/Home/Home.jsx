import React, {Component} from 'react';
import {Segment} from "semantic-ui-react";
import ReactPlayer from 'react-player';
import localStore from "../../../services/localStore";

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            playlist: [],
            video: '',
            index: 0,
            error: false,
        }
    }

    componentDidMount() {
        const playlist = localStore.get(localStore.PLAYLIST_ID);
        if(playlist === null) {
            this.setState({
                error: true
            });
        }else {
            this.setState({
                playlist,
                video: playlist[this.state.index],
            });
        }
    }

    update() {
        let {index, playlist} = this.state;
        index++;
        this.setState({index, video: playlist[index]})
    }


    renderVideo() {
        return <ReactPlayer url={this.state.video} controls playing onEnded={this.update.bind(this)}/>;
    }

    //RENDERING
    render() {
        const {error} = this.state;
        return <Segment loading={error} size="massive" style={{margin: "5px 5px 5px 5px"}}>
            { error ? false : this.renderVideo() }
        </Segment>;
    }
}

export default Home;