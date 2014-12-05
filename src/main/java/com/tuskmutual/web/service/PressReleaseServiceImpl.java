/*
 * Copyright 2007-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tuskmutual.web.service;

import java.util.Collection;

import com.tuskmutual.web.orm.entity.PressRelease;
import com.tuskmutual.web.orm.repository.PressReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PressReleaseServiceImpl implements PressReleaseService {

    private final PressReleaseRepository repository;
    
    @Autowired
    public PressReleaseServiceImpl(PressReleaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<PressRelease> find() {
        return repository.findAll();
    }

    @Override
    public PressRelease save(PressRelease pressRelease) {
        return repository.saveAndFlush(pressRelease);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
