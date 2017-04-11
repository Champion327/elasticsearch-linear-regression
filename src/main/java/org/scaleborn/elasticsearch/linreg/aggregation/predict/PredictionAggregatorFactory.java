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

package org.scaleborn.elasticsearch.linreg.aggregation.predict;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.elasticsearch.search.MultiValueMode;
import org.elasticsearch.search.aggregations.Aggregator;
import org.elasticsearch.search.aggregations.AggregatorFactories;
import org.elasticsearch.search.aggregations.AggregatorFactory;
import org.elasticsearch.search.aggregations.pipeline.PipelineAggregator;
import org.elasticsearch.search.aggregations.support.MultiValuesSourceAggregatorFactory;
import org.elasticsearch.search.aggregations.support.NamedValuesSourceConfigSpec;
import org.elasticsearch.search.aggregations.support.NamedValuesSourceSpec;
import org.elasticsearch.search.aggregations.support.ValuesSource.Numeric;
import org.elasticsearch.search.internal.SearchContext;

/**
 * Created by mbok on 11.04.17.
 */
public class PredictionAggregatorFactory extends
    MultiValuesSourceAggregatorFactory<Numeric, PredictionAggregatorFactory> {

  private final MultiValueMode multiValueMode;

  public PredictionAggregatorFactory(final String name,
      final List<NamedValuesSourceConfigSpec<Numeric>> configs, final MultiValueMode multiValueMode,
      final SearchContext context, final AggregatorFactory<?> parent,
      final AggregatorFactories.Builder subFactoriesBuilder,
      final Map<String, Object> metaData) throws IOException {
    super(name, configs, context, parent, subFactoriesBuilder, metaData);
    this.multiValueMode = multiValueMode;
  }

  @Override
  protected Aggregator createUnmapped(final Aggregator parent,
      final List<PipelineAggregator> pipelineAggregators, final Map<String, Object> metaData)
      throws IOException {
    return new PredictionAggregator(this.name, null, this.context, parent, this.multiValueMode,
        pipelineAggregators, metaData);
  }

  @Override
  protected Aggregator doCreateInternal(final List<NamedValuesSourceSpec<Numeric>> valuesSources,
      final Aggregator parent, final boolean collectsFromSingleBucket,
      final List<PipelineAggregator> pipelineAggregators, final Map<String, Object> metaData)
      throws IOException {
    return new PredictionAggregator(this.name, valuesSources, this.context, parent,
        this.multiValueMode,
        pipelineAggregators, metaData);
  }
}
