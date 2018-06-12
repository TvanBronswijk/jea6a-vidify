import React, {Component} from 'react';
import {Button, Icon, Input, Menu} from "semantic-ui-react";
import localStore from "../../../services/localStore";
import PrefabLoader from "../../components/Loader/PrefabLoader";
import repo from "../../../services/repo";

class NavBar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            playlists: [],
            ready: false
        }
    }

    handleChange(e) {
        this.setState(
            {
                [e.target.name]: e.target.value
            }
        )
    }

    componentDidMount() {
        this.fetchPlaylists();
    }

    fetchPlaylists() {
        repo.fetch( `/playlists/user/${localStore.getUser().id}`)
            .then((playlists) => {
                this.setState({playlists: playlists, ready: true});
                return Promise.resolve(playlists);
            });
    }

    login() {
        repo.fetch( `/users/username/sternold`)
            .then((user) => {
                localStore.saveUser(user);
                return Promise.resolve(user);
            });
    }

    createPlaylist() {
        let body = JSON.stringify({name: "new playlist", userId: localStore.getUser().id});
        this.setState({ready: false});
        repo.fetch( `/playlists`, {
            method: 'POST',
            body: body,
        }).then(playlist => Promise.resolve(playlist));
        this.fetchPlaylists();
    }

    render() {
        return <Menu fixed='left' inverted vertical borderless>
            <Menu.Item as='a' href="/" header>Vidify</Menu.Item>
            <Menu.Item>
                <Input icon='search' placeholder="Search..."/>
            </Menu.Item>
            <Menu.Item as='a' href='/videos' content="Videos"/>
            <Menu.Menu>
                {
                    this.state.ready
                        ? this.state.playlists.map(playlist => <Menu.Item content={playlist.name} href={`/playlist/${playlist.id}`}/>)
                        : <PrefabLoader/>
                }
                <Menu.Item onClick={this.createPlaylist.bind(this)}>
                    <Icon name='add' />
                    Add Playlist
                </Menu.Item>
            </Menu.Menu>
            {
                localStore.loggedIn()
                    ? <Menu.Item content={localStore.getUser().username} position='right'/>
                    : <Menu.Item as={Button} onClick={this.login.bind(this)} content="Login" position='right'/>
            }
        </Menu>;
    }
}

export default NavBar;