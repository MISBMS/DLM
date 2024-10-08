/**
 * Copyright (c) 2024 Original Author(s), PhonePe India Pvt. Ltd.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.phonepe.dlm.lock.mode;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LockMode {
    EXCLUSIVE(LockMode.EXCLUSIVE_TEXT) {
        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visitExclusive();
        }
    };

    static final String EXCLUSIVE_TEXT = "EXCLUSIVE";

    @Getter
    private final String value;

    public abstract <T> T accept(Visitor<T> visitor);

    public interface Visitor<T> {
        T visitExclusive();
    }
}
