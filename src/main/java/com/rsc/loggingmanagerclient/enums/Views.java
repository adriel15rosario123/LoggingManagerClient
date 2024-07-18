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

    ENROLL_SYSTEM{
        @Override
        public String toString() {
            return "enroll-system.fxml";
        }
    },

    //MODALS
    LOGOUT_MODAL{
        @Override
        public String toString() {
            return "modals/logout-popup.fxml";
        }
    },

    SERVER_OFF_MODAL{
        @Override
        public String toString() {
            return "modals/server-off-popup.fxml";
        }
    },

    SUCCESSFULLY_CREATED_SYSTEM{
        @Override
        public String toString() {
            return "modals/successfully-created-system.fxml";
        }
    }
}
