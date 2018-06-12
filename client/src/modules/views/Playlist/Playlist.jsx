import React, {Component} from 'react';
import {Redirect} from 'react-router';
import repo from "../../../services/repo";
import PrefabLoader from "../../components/Loader/PrefabLoader";
import {Button, Container, Header, Icon, Input, Item} from 'semantic-ui-react';
import localStore from "../../../services/localStore";

class Playlist extends Component {

    constructor(props) {
        super(props);
        this.state = {
            ready: false,
            playlist: null,
            reroute: false,
            edit: false,
        }
    }

    componentDidMount() {
        this.fetchPlaylist();
    }

    fetchPlaylist() {
        const {id} = this.props;
        repo.fetch( `/playlists/${id}`)
                .then((playlist) => {
                    this.setState({playlist: playlist, ready: true});
                    return Promise.resolve(playlist);
                });
    }

    updatePlaylist() {
        let body = JSON.stringify(this.state.playlist);
        repo.fetch( `/playlists`, {
            method: 'put',
            body: body,
        }).then(playlist => Promise.resolve(playlist));
    }

    playAll() {
        const {playlist} = this.state;
        let videos = playlist.videos.map(vid => vid.url);
        localStore.save(localStore.PLAYLIST_ID, videos);
        this.setState({reroute: true});
    }

    play(video) {
        let singletonPlaylist = [video];
        localStore.save(localStore.PLAYLIST_ID, singletonPlaylist);
        this.setState({reroute: true});
    }

    edit() {
        const {edit} = this.state;
        if(edit) {
            this.updatePlaylist();
        }
        this.setState({edit: !edit});
    }

    handleChange(e) {
        let {playlist} = this.state;
        playlist[e.target.name]= e.target.value;
        this.setState(
            {
                playlist
            }
        )
    }

    //RENDERING
    render() {
        const {edit, ready, playlist, reroute} = this.state;
        if(reroute){
            return <Redirect to="/"/>
        }

        return ready ? <Container>
            {edit ? <Input name='name' onChange={this.handleChange.bind(this)}/> : <Header>{playlist.name}</Header>}
            <Button onClick={this.edit.bind(this)} circular size='tiny' icon>{edit ? <Icon name='save'/> : <Icon name="edit" />}</Button>
            <Button onClick={this.playAll.bind(this)}><Icon name='play'/>Play</Button>
            <Item.Group>{playlist.videos.map(video => <Item>
            <Item.Content>
                <Item.Header>{video.name}</Item.Header>
                <Item.Extra as={Button} onClick={() => this.play(video.url)}><Icon name="play" />Play</Item.Extra>
            </Item.Content>
        </Item>)}</Item.Group>
        </Container> : <PrefabLoader/>;
    }
}

export default Playlist;