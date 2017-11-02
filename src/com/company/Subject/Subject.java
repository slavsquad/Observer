package com.company.Subject;

import com.company.Observer.Observer;

public interface Subject {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifу();
}
