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

import com.tuskmutual.web.orm.entity.Stock;
import com.tuskmutual.web.orm.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;
    
    @Autowired
    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Stock> find() {
        return repository.findAll();
    }

    @Override
    public Stock save(Stock stock) {
        return repository.saveAndFlush(stock);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
    
}
