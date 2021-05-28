/**
 * Copyright 2021 Shulie Technology, Co.Ltd
 * Email: shulie@shulie.io
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pamirs.attach.plugin.es.common.impl;

import com.pamirs.pradar.Pradar;
import com.pamirs.pradar.exception.PressureMeasureError;
import com.pamirs.pradar.pressurement.agent.shared.service.GlobalConfig;
import com.shulie.instrument.simulator.api.reflect.Reflect;
import com.shulie.instrument.simulator.api.reflect.ReflectException;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.client.indices.AnalyzeRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author xiaobin.zfb
 * @mail xiaobin@shulie.io
 * @Date 2020/7/13 6:07 下午
 */
public class AnalyzeRequestIndexRename0 extends AbstractReadRequestIndexRename {
    @Override
    public String getName() {
        return "analyze";
    }

    @Override
    public List<String> reindex0(Object target) {
        AnalyzeRequest req = (AnalyzeRequest) target;
        String index = req.index();
        /**
         * 如果在白名单中则不允许写
         */
        if (GlobalConfig.getInstance().getSearchWhiteList().contains(index)) {
            return Arrays.asList(index);
        }
        if (!Pradar.isClusterTestPrefix(index)) {
            index = Pradar.addClusterTestPrefixLower(index);
        }
        try {
            Reflect.on(req).set("index", index);
        } catch (ReflectException e) {
            throw new PressureMeasureError("can't found field index from " + AnalyzeRequest.class.getName());
        }
        return Arrays.asList(index);
    }

    @Override
    public List<String> getIndex0(Object target) {
        GetAliasesRequest req = (GetAliasesRequest) target;
        return (req.indices() == null || req.indices().length == 0) ? Collections.EMPTY_LIST : Arrays.asList(req.indices());
    }
}