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
package com.shulie.instrument.simulator.api.event;

/**
 * 方法调用事件
 *
 * 注意: Event 的内容会在方法调用周期结束后进行清理，内部的数据将会全部清空
 * 这样做是为了内存回收的速度加快，所以如果需要在方法调用生命周期外引用 Event
 * 需要提前将内部的数据引用
 *
 * @author xiaobin.zfb|xiaobin@shulie.io
 * @since 2020/11/5 8:53 下午
 */
public class CallEvent extends InvokeEvent {
    /**
     * 是否是接口
     */
    private boolean isInterface;

    /**
     * 构造调用事件
     *
     * @param processId 调用过程ID
     * @param invokeId  调用ID
     * @param eventType 事件类型
     */
    protected CallEvent(int processId, int invokeId, boolean isInterface, EventType eventType) {
        super(processId, invokeId, eventType);
        this.isInterface = isInterface;
    }

    public boolean isInterface() {
        return isInterface;
    }
}
