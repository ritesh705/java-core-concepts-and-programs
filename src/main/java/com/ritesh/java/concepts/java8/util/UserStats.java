package com.ritesh.java.concepts.java8.util;

import java.util.Optional;

public class UserStats {

    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

    Optional<Long> visitCount;
}
