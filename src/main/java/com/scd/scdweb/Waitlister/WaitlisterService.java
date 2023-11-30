package com.scd.scdweb.Waitlister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitlisterService {
    @Autowired
    WaitlisterRepository waitlisterRepository;
    public void save(Waitlister waitlister) {
        waitlisterRepository.save(waitlister);
    }
}
