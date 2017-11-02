package com.company.Subject;

import com.company.Content.Content;
import com.company.Observer.Observer;

import java.io.Serializable;

public interface Subject {
    public void register(Observer observer);
    public void delete(Observer observer);
    public void inform();
    public Content getLastContent();
    public void addContent(Content content);
}
