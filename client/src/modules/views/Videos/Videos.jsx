import React, {Component} from 'react';
import {Redirect} from 'react-router';
import repo from "../../../services/repo";
import PrefabLoader from "../../components/Loader/PrefabLoader";
import {Button, Icon, Item, Dropdown, Modal} from 'semantic-ui-react';
import localStore from "../../../services/localStore";

class Videos extends Component {

    constructor(props) {
        super(props);
        this.state = {
            ready: false,
            data: null,
            playlist: [],
            playlistsOptions: [],
            reroute: false,
            selectedVideo: null,
        }
    }

    async componentDidMount() {
        await this.fetchPlaylists();
        await this.fetchVideos();
        this.setState({ready: true});
    }

    async fetchVideos() {
            await repo.fetch( `/videos`)
                .then((videos) => {
                    this.setState({data: videos});
                    return Promise.resolve(videos);
                });
    }

    async fetchPlaylists() {
        await repo.fetch( `/playlists/user/${localStore.getUser().id}`)
            .then((playlists) => {
                let playlistsOptions = playlists.map(playlist => { return {
                    key: playlist.id,
                    text: playlist.name,
                    value: playlist
                }});

                console.log(playlistsOptions);

                this.setState({playlists, playlistsOptions});
                return Promise.resolve(playlists);
            });
    }

    play(video) {
        let singletonPlaylist = [video];
        localStore.save(localStore.PLAYLIST_ID, singletonPlaylist);
        this.setState({reroute: true})
    }

    addToPlaylist(e, obj) {
        let playlist = obj.value;
        playlist.videos.push(this.state.selectedVideo);
        let body = JSON.stringify(playlist);
        repo.fetch( `/playlists`, {
            method: 'put',
            body: body,
        }).then(playlist => Promise.resolve(playlist));
    }

    selectVideo(video) {
        this.setState({selectedVideo: video});
    }

    addModal(video) {
        console.log(this.state.playlistsOptions);
        return <Modal style={{
            marginTop: '0px !important',
            marginLeft: 'auto',
            marginRight: 'auto'
        }} centered trigger={<Item.Extra as={Button} onClick={() => this.selectVideo(video)}><Icon name="plus" />Add to playlist</Item.Extra>}>
            <Modal.Header>Add to Playlist</Modal.Header>
            <Modal.Content>
                <Dropdown placeholder='Playlist' options={this.state.playlistsOptions} onChange={this.addToPlaylist.bind(this)}/>
            </Modal.Content>
        </Modal>;
    }

    //RENDERING
    render() {
        const {ready, data, reroute} = this.state;
        if(reroute){
            return <Redirect to="/"/>
        }

        return ready ? <Item.Group>{data.map(video => <Item>
            <Item.Content>
                <Item.Header>{video.name}</Item.Header>
                    <Item.Extra as={Button} onClick={() => this.play(video.url)}><Icon name="play" />Play</Item.Extra>
                {this.addModal(video)}
            </Item.Content>
        </Item>)}</Item.Group> : <PrefabLoader/>;
    }
}

export default Videos;