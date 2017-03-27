/*
 * Copyright (c) 2017 Scaleborn UG, www.scaleborn.com
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
 * limitations under the License.
 */

package org.scaleborn.elasticsearch.linreg.aggregation.stats;

import java.io.IOException;
import java.util.List;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.search.aggregations.AggregatorFactories.Builder;
import org.elasticsearch.search.aggregations.AggregatorFactory;
import org.elasticsearch.search.aggregations.InternalAggregation;
import org.elasticsearch.search.aggregations.InternalAggregation.Type;
import org.elasticsearch.search.aggregations.support.ValuesSource.Numeric;
import org.elasticsearch.search.aggregations.support.ValuesSourceConfig;
import org.elasticsearch.search.internal.SearchContext;
import org.scaleborn.elasticsearch.linreg.aggregation.support.BaseAggregationBuilder;
import org.scaleborn.elasticsearch.linreg.aggregation.support.BaseAggregatorFactory;

/**
 * Created by mbok on 21.03.17.
 */
public class StatsAggregationBuilder extends BaseAggregationBuilder<StatsAggregationBuilder> {

  public static final String NAME = "linreg_stats";
  private static final InternalAggregation.Type TYPE = new InternalAggregation.Type(NAME);

  protected StatsAggregationBuilder(final StreamInput in,
      final Type type) throws IOException {
    super(in, type);
  }

  @Override
  protected BaseAggregatorFactory<?> innerBuild(final SearchContext context,
      final List<ValuesSourceConfig<Numeric>> featureConfigs,
      final ValuesSourceConfig<Numeric> responseConfig,
      final AggregatorFactory<?> parent, final Builder subFactoriesBuilder) throws IOException {
    return null;
  }


  @Override
  public String getWriteableName() {
    return NAME;
  }
}
