/*
 * Copyright (C) 2014 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.cassandra.lucene.builder.search.condition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A {@link Condition} implementation that matches documents containing a value for a field.
 *
 * @author Andres de la Pena {@literal <adelapena@stratio.com>}
 */
public class MatchCondition extends Condition<MatchCondition> {

    /** The name of the field to be matched. */
    @JsonProperty("field")
    final String field;

    /** The value of the field to be matched. */
    @JsonProperty("value")
    final Object value;

    /** If the generated query should use doc values. */
    @JsonProperty("doc_values")
    Boolean docValues;

    /**
     * Creates a new {@link MatchCondition} for the specified field and value.
     *
     * @param field the name of the field to be matched
     * @param value the value of the field to be matched
     */
    @JsonCreator
    public MatchCondition(@JsonProperty("field") String field, @JsonProperty("value") Object value) {
        this.field = field;
        this.value = value;
    }

    /**
     * Sets if the generated query should use doc values. Doc values queries are typically slower, but they can be
     * faster in the dense case where most rows match the search.
     *
     * @param docValues if the generated query should use doc values
     * @return this builder with the specified use doc values option
     */
    public MatchCondition docValues(Boolean docValues) {
        this.docValues = docValues;
        return this;
    }
}
