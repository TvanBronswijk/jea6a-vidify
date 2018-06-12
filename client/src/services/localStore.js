export default class localStore {
    static USER_ID = 'user_id';
    static PLAYLIST_ID = 'playlist_id';

    static save(id, object) {
        localStorage.setItem(id, JSON.stringify(object));
    }

    static get(id) {
        return JSON.parse(localStorage.getItem(id));
    }

    static remove(id) {
        localStorage.removeItem(id);
    }

    static saveUser(user) {
        localStore.save(this.USER_ID, user);
    }

    static getUser() {
        return localStore.get(this.USER_ID);
    }

    static loggedIn() {
        return !!localStore.getUser();
    }

    static removeUser() {
        localStore.remove(this.USER_ID);
    }
}
