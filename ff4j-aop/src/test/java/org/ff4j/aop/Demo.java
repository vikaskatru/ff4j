package org.ff4j.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * #%L
 * ff4j-aop
 * %%
 * Copyright (C) 2013 - 2015 Ff4J
 * %%
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
 * #L%
 */

import org.springframework.stereotype.Component;

public class Demo {
    
    /** Information relative to logging. */
    private static Logger logger = LoggerFactory.getLogger(Demo.class);
    
    @Flip(name = "myFeature", alterBean = "fr")
    public interface Greeting { void sayHello(); }
    
    @Component("fr")
    private static class HelloFR implements Greeting {
        public void sayHello() { logger.info("Bonjour"); }
    }
    
    @Component("en")
    private static class HelloEN implements Greeting {
        public void sayHello() { logger.info("Hello"); }
    }

}