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

    UPDATE_SYSTEM{
        @Override
        public String toString() {
            return "update-system.fxml";
        }
    },

    ERROR_LOGS{
        @Override
        public String toString() {
            return "error-logs.fxml";
        }
    },
    TRACKING_LOGS{
        @Override
        public String toString() {
            return "tracking-logs.fxml";
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
    },

    SUCCESSFULLY_UPDATED_SYSTEM{
        @Override
        public String toString() {
            return "modals/successfully-updated-system.fxml";
        }
    },
    SUCCESSFULLY_DELETED_SYSTEM{
        @Override
        public String toString() {
            return "modals/successfully-deleted-system.fxml";
        }
    },

    DELETE_SYSTEM_MODAL{
        @Override
        public String toString() {
            return "modals/delete-system-popup.fxml";
        }
    }
}
