/**
 * Copyright (c) 2011 Yahoo! Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */

package com.yahoo.omid.client;

import com.yahoo.omid.tso.RowKey;
import org.apache.hadoop.hbase.KeyValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RowKeyFamily extends RowKey {
   
   private Map<byte[], List<KeyValue>> families;
   
   public RowKeyFamily() {
      super();
   }
   
   public RowKeyFamily(byte [] r, byte [] t, Map<byte[], List<KeyValue>> families) {
      super(r, t);
      this.families = families;
   }
   
   public Map<byte[], List<KeyValue>> getFamilies() {
      return families;
   }
   
   public void setFamilies(Map<byte[], List<KeyValue>> families) {
      this.families = families;
   }
   
   public void addFamily(byte [] row, KeyValue kv) {
      List<KeyValue> kvs = families.get(row);
      if (kvs == null) {
         kvs = new ArrayList<KeyValue>();
         families.put(row, kvs);
      }
      kvs.add(kv);
   }

}
