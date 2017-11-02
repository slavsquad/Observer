package com.company.Observer;

import com.company.Subject.Subject;

public interface Observer  {
    public void update(Subject subject);
    public void subscribe(Subject subject);
    public void unsubscribe(Subject subject);
}
