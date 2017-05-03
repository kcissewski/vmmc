package org.itech.vmmc;

/**
 * Created by rossumg on 5/3/2017.
 */

public class User {

    int _id;
    String _username;
    String _password;
    String _email;
    String _first_name;
    String _last_name;
    String _national_id;
    String _phone;
    int _region_id;
    int _user_type_id;
    String _locale;
    int _modified_by;
    int _created_by;
    int _is_blocked;
    String _timestamp_updated;
    String _timestamp_created;
    String _timestamp_last_login;

    public User(){}

    public User(int _id, String _username, String _password, String _email, String _first_name, String _last_name, String _national_id, String _phone, int _region_id, int _user_type_id, String _locale, int _modified_by, int _created_by, int _is_blocked, String _timestamp_updated, String _timestamp_created, String _timestamp_last_login) {
        this._id = _id;
        this._username = _username;
        this._password = _password;
        this._email = _email;
        this._first_name = _first_name;
        this._last_name = _last_name;
        this._national_id = _national_id;
        this._phone = _phone;
        this._region_id = _region_id;
        this._user_type_id = _user_type_id;
        this._locale = _locale;
        this._modified_by = _modified_by;
        this._created_by = _created_by;
        this._is_blocked = _is_blocked;
        this._timestamp_updated = _timestamp_updated;
        this._timestamp_created = _timestamp_created;
        this._timestamp_last_login = _timestamp_last_login;
    }

    public User(String _username, String _password, String _email, String _first_name, String _last_name, String _national_id, String _phone, int _region_id, int _user_type_id, String _locale, int _modified_by, int _created_by, int _is_blocked, String _timestamp_updated, String _timestamp_created, String _timestamp_last_login) {
        this._username = _username;
        this._password = _password;
        this._email = _email;
        this._first_name = _first_name;
        this._last_name = _last_name;
        this._national_id = _national_id;
        this._phone = _phone;
        this._region_id = _region_id;
        this._user_type_id = _user_type_id;
        this._locale = _locale;
        this._modified_by = _modified_by;
        this._created_by = _created_by;
        this._is_blocked = _is_blocked;
        this._timestamp_updated = _timestamp_updated;
        this._timestamp_created = _timestamp_created;
        this._timestamp_last_login = _timestamp_last_login;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_first_name() {
        return _first_name;
    }

    public void set_first_name(String _first_name) {
        this._first_name = _first_name;
    }

    public String get_last_name() {
        return _last_name;
    }

    public void set_last_name(String _last_name) {
        this._last_name = _last_name;
    }

    public String get_national_id() {
        return _national_id;
    }

    public void set_national_id(String _national_id) {
        this._national_id = _national_id;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public int get_region_id() {
        return _region_id;
    }

    public void set_region_id(int _region_id) {
        this._region_id = _region_id;
    }

    public int get_user_type_id() {
        return _user_type_id;
    }

    public void set_user_type_id(int _user_type_id) {
        this._user_type_id = _user_type_id;
    }

    public String get_locale() {
        return _locale;
    }

    public void set_locale(String _locale) {
        this._locale = _locale;
    }

    public int get_modified_by() {
        return _modified_by;
    }

    public void set_modified_by(int _modified_by) {
        this._modified_by = _modified_by;
    }

    public int get_created_by() {
        return _created_by;
    }

    public void set_created_by(int _created_by) {
        this._created_by = _created_by;
    }

    public int get_is_blocked() {
        return _is_blocked;
    }

    public void set_is_blocked(int _is_blocked) {
        this._is_blocked = _is_blocked;
    }

    public String get_timestamp_updated() {
        return _timestamp_updated;
    }

    public void set_timestamp_updated(String _timestamp_updated) {
        this._timestamp_updated = _timestamp_updated;
    }

    public String get_timestamp_created() {
        return _timestamp_created;
    }

    public void set_timestamp_created(String _timestamp_created) {
        this._timestamp_created = _timestamp_created;
    }

    public String get_timestamp_last_login() {
        return _timestamp_last_login;
    }

    public void set_timestamp_last_login(String _timestamp_last_login) {
        this._timestamp_last_login = _timestamp_last_login;
    }
}
