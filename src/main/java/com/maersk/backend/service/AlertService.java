package com.maersk.backend.service;

import com.maersk.backend.DAO.AlertDAO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AlertService {

    private AlertDAO alertDAO;

    public AlertService(AlertDAO alertDAO) {
        this.alertDAO = alertDAO;
    }

    public UUID raiseAlert() {
        return this.alertDAO.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.alertDAO.getAlert(id);
    }

}
