/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.json;

import org.apache.sqoop.common.SqoopException;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 */
public class TestJSONUtils {

  @Test
  public void testString() {
    JSONObject object = JSONUtils.parse("{\"id\":3}");
    assertEquals((long)3, object.get("id"));
  }

  @Test(expected = SqoopException.class)
  public void testStringInvalid() {
    JSONUtils.parse("{");
  }

  @Test(expected = NullPointerException.class)
  public void testStringNull() {
    JSONUtils.parse((String)null);
  }

  @Test
  public void testReader() {
    JSONObject object = JSONUtils.parse(new StringReader("{\"id\":3}"));
    assertEquals((long)3, object.get("id"));
  }

  @Test(expected = SqoopException.class)
  public void testReaderInvalid() {
    JSONUtils.parse(new StringReader("{"));
  }

  @Test(expected = NullPointerException.class)
  public void testReaderNull() {
    JSONUtils.parse((Reader)null);
  }
}
