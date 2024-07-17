package com.rsc.loggingmanagerclient.enums;

public enum Views {
    LOGIN{
        @Override
        public String toString() {
            return "login.fxml";
        }
    },

    HOME{
        @Override
        public String toString() { return "home.fxml";}
    },
    
    LOGOUT_MODAL{
        @Override
        public String toString() {
            return "logout-popup.fxml";
        }
    },

    SERVER_OFF_MODAL{
        @Override
        public String toString() {
            return "server-off-popup.fxml";
        }
    }
}
