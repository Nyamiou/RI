/**
 *  Copyright 2011 Terracotta, Inc.
 *  Copyright 2011 Oracle America Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package javax.cache.implementation.interceptor;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

import javax.cache.Cache;
import javax.cache.interceptor.CacheKeyGenerator;
import javax.cache.interceptor.CacheResult;

/**
 * Details for a method annotated with {@link CacheResult}
 * 
 * @author Eric Dalquist
 * @version $Revision$
 */
class CacheResultMethodDetails extends KeyedMethodDetails {
    private final CacheResult cacheResultAnnotation;

    /**
     * @param cache The cache to use
     * @param methodAnotations All annotations that exist on the method
     * @param cacheKeyGenerator The key generator to use
     * @param allParameters All parameter details
     * @param keyParameters Parameter details to use for key generation
     * @param cacheResultAnnotation the annotation
     */
    public CacheResultMethodDetails(Cache<Object, Object> cache, Set<Annotation> methodAnotations,
            CacheKeyGenerator cacheKeyGenerator, 
            List<CacheParameterDetails> allParameters,
            List<CacheParameterDetails> keyParameters, 
            CacheResult cacheResultAnnotation) {
        
        super(cache, methodAnotations, cacheKeyGenerator, allParameters, keyParameters);
        
        if (cacheResultAnnotation == null) {
            throw new IllegalArgumentException("cacheResultAnnotation cannot be null");
        }

        this.cacheResultAnnotation = cacheResultAnnotation;
    }



    /* (non-Javadoc)
     * @see javax.cache.implementation.interceptor.MethodDetails#getInterceptorType()
     */
    @Override
    public InterceptorType getInterceptorType() {
        return InterceptorType.CACHE_RESULT;
    }



    /**
     * @return the cacheResultAnnotation
     */
    public CacheResult getCacheResultAnnotation() {
        return this.cacheResultAnnotation;
    }
}