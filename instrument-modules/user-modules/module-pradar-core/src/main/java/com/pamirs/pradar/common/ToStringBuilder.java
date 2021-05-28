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
package com.pamirs.pradar.common;


import java.util.Collection;
import java.util.Map;

public class ToStringBuilder implements Builder<String> {

    /**
     * The default style of output to use, not null.
     */
    private static volatile ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;

    //----------------------------------------------------------------------------

    /**
     * <p>Gets the default <code>ToStringStyle</code> to use.</p> <p> <p>This method gets a
     * singleton default value, typically for the whole JVM. Changing this default should generally
     * only be done during application startup. It is recommended to pass a
     * <code>ToStringStyle</code> to the constructor instead of using this global default.</p> <p>
     * <p>This method can be used from multiple threads. Internally, a <code>volatile</code>
     * variable is used to provide the guarantee that the latest value set using {@link
     * #setDefaultStyle} is the value returned. It is strongly recommended that the default style is
     * only changed during application startup.</p> <p> <p>One reason for changing the default could
     * be to have a verbose style during development and a compact style in production.</p>
     *
     * @return the default <code>ToStringStyle</code>, never null
     */
    public static ToStringStyle getDefaultStyle() {
        return defaultStyle;
    }

    /**
     * <p>Sets the default <code>ToStringStyle</code> to use.</p> <p> <p>This method sets a
     * singleton default value, typically for the whole JVM. Changing this default should generally
     * only be done during application startup. It is recommended to pass a
     * <code>ToStringStyle</code> to the constructor instead of changing this global default.</p>
     * <p> <p>This method is not intended for use from multiple threads. Internally, a
     * <code>volatile</code> variable is used to provide the guarantee that the latest value set is
     * the value returned from {@link #getDefaultStyle}.</p>
     *
     * @param style the default <code>ToStringStyle</code>
     * @throws IllegalArgumentException if the style is <code>null</code>
     */
    public static void setDefaultStyle(final ToStringStyle style) {
        if (style == null) {
            throw new IllegalArgumentException("The style must not be null");
        }
        defaultStyle = style;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Uses <code>ReflectionToStringBuilder</code> to generate a <code>toString</code> for the
     * specified object.</p>
     *
     * @param object the Object to be output
     * @return the String result
     * @see ReflectionToStringBuilder#toString(Object)
     */
    public static String reflectionToString(final Object object) {
        return ReflectionToStringBuilder.toString(object);
    }

    /**
     * <p>Uses <code>ReflectionToStringBuilder</code> to generate a <code>toString</code> for the
     * specified object.</p>
     *
     * @param object the Object to be output
     * @param style  the style of the <code>toString</code> to create, may be <code>null</code>
     * @return the String result
     */
    public static String reflectionToString(final Object object, final ToStringStyle style) {
        return ReflectionToStringBuilder.toString(object, style);
    }

    /**
     * <p>Uses <code>ReflectionToStringBuilder</code> to generate a <code>toString</code> for the
     * specified object.</p>
     *
     * @param object           the Object to be output
     * @param style            the style of the <code>toString</code> to create, may be
     *                         <code>null</code>
     * @param outputTransients whether to include transient fields
     * @return the String result
     * @see ReflectionToStringBuilder#toString(Object, ToStringStyle, boolean)
     */
    public static String reflectionToString(final Object object, final ToStringStyle style, final boolean outputTransients) {
        return ReflectionToStringBuilder.toString(object, style, outputTransients, false, null);
    }

    /**
     * <p>Uses <code>ReflectionToStringBuilder</code> to generate a <code>toString</code> for the
     * specified object.</p>
     *
     * @param <T>              the type of the object
     * @param object           the Object to be output
     * @param style            the style of the <code>toString</code> to create, may be
     *                         <code>null</code>
     * @param outputTransients whether to include transient fields
     * @param reflectUpToClass the superclass to reflect up to (inclusive), may be
     *                         <code>null</code>
     * @return the String result
     * @see ReflectionToStringBuilder#toString(Object, ToStringStyle, boolean, boolean, Class)
     * @since 2.0
     */
    public static <T> String reflectionToString(
            final T object,
            final ToStringStyle style,
            final boolean outputTransients,
            final Class<? super T> reflectUpToClass) {
        return ReflectionToStringBuilder.toString(object, style, outputTransients, false, reflectUpToClass);
    }

    //----------------------------------------------------------------------------

    /**
     * Current toString buffer, not null.
     */
    private final StringBuffer buffer;
    /**
     * The object being output, may be null.
     */
    private final Object object;
    /**
     * The style of output to use, not null.
     */
    private final ToStringStyle style;

    /**
     * <p>Constructs a builder for the specified object using the default output style.</p> <p>
     * <p>This default style is obtained from {@link #getDefaultStyle()}.</p>
     *
     * @param object the Object to build a <code>toString</code> for, not recommended to be null
     */
    public ToStringBuilder(final Object object) {
        this(object, null, null);
    }

    /**
     * <p>Constructs a builder for the specified object using the a defined output style.</p> <p>
     * <p>If the style is <code>null</code>, the default style is used.</p>
     *
     * @param object the Object to build a <code>toString</code> for, not recommended to be null
     * @param style  the style of the <code>toString</code> to create, null uses the default style
     */
    public ToStringBuilder(final Object object, final ToStringStyle style) {
        this(object, style, null);
    }

    /**
     * <p>Constructs a builder for the specified object.</p> <p> <p>If the style is
     * <code>null</code>, the default style is used.</p> <p> <p>If the buffer is <code>null</code>,
     * a new one is created.</p>
     *
     * @param object the Object to build a <code>toString</code> for, not recommended to be null
     * @param style  the style of the <code>toString</code> to create, null uses the default style
     * @param buffer the <code>StringBuffer</code> to populate, may be null
     */
    public ToStringBuilder(final Object object, ToStringStyle style, StringBuffer buffer) {
        if (style == null) {
            style = getDefaultStyle();
        }
        if (buffer == null) {
            buffer = new StringBuffer(512);
        }
        this.buffer = buffer;
        this.style = style;
        this.object = object;

        style.appendStart(buffer, object);
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>boolean</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final boolean value) {
        style.append(buffer, null, value);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>boolean</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final boolean[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>byte</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final byte value) {
        style.append(buffer, null, value);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>byte</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final byte[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>char</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final char value) {
        style.append(buffer, null, value);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>char</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final char[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>double</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final double value) {
        style.append(buffer, null, value);
        return this;
    }


    /**
     * <p>Append to the <code>toString</code> a <code>double</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final Collection<?> value) {
        style.append(buffer, null, value, true);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>double</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final Map<?, ?> value) {
        style.append(buffer, null, value, true);
        return this;
    }


    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>double</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final double[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>float</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final float value) {
        style.append(buffer, null, value);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>float</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final float[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> an <code>int</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final int value) {
        style.append(buffer, null, value);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> an <code>int</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final int[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>long</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final long value) {
        style.append(buffer, null, value);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>long</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final long[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> an <code>Object</code> value.</p>
     *
     * @param obj the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final Object obj) {
        style.append(buffer, null, obj, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> an <code>Object</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final Object[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>short</code> value.</p>
     *
     * @param value the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final short value) {
        style.append(buffer, null, value);
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append to the <code>toString</code> a <code>short</code> array.</p>
     *
     * @param array the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final short[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>boolean</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final boolean value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>boolean</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>hashCode</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final boolean[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>boolean</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.</p>
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final boolean[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>byte</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final byte value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>byte</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final byte[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>byte</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final byte[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>char</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final char value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>char</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final char[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>char</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.</p>
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final char[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>double</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final double value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>double</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final double[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>double</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.</p>
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final double[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>float</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final float value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>float</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final float[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>float</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.</p>
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final float[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>int</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final int value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>int</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final int[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>int</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.</p>
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final int[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>long</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final long value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>long</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final long[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>long</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.</p>
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final long[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>Object</code> value.</p>
     *
     * @param fieldName the field name
     * @param obj       the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final Object obj) {
        style.append(buffer, fieldName, obj, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>Object</code> value.</p>
     *
     * @param fieldName  the field name
     * @param obj        the value to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final Object obj, final boolean fullDetail) {
        style.append(buffer, fieldName, obj, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>Object</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final Object[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>Object</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.</p>
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final Object[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>short</code> value.</p>
     *
     * @param fieldName the field name
     * @param value     the value to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final short value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>short</code> array.</p>
     *
     * @param fieldName the field name
     * @param array     the array to add to the <code>toString</code>
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final short[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * <p>Append to the <code>toString</code> a <code>short</code> array.</p> <p> <p>A boolean
     * parameter controls the level of detail to show. Setting <code>true</code> will output the
     * array in full. Setting <code>false</code> will output a summary, typically the size of the
     * array.
     *
     * @param fieldName  the field name
     * @param array      the array to add to the <code>toString</code>
     * @param fullDetail <code>true</code> for detail, <code>false</code> for summary info
     * @return this
     */
    public ToStringBuilder append(final String fieldName, final short[] array, final boolean fullDetail) {
        style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail));
        return this;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Append the <code>toString</code> from the superclass.</p> <p> <p>This method assumes that
     * the superclass uses the same <code>ToStringStyle</code> as this one.</p> <p> <p>If
     * <code>superToString</code> is <code>null</code>, no change is made.</p>
     *
     * @param superToString the result of <code>super.toString()</code>
     * @return this
     * @since 2.0
     */
    public ToStringBuilder appendSuper(final String superToString) {
        if (superToString != null) {
            style.appendSuper(buffer, superToString);
        }
        return this;
    }

    /**
     * <p>Append the <code>toString</code> from another object.</p> <p> <p>This method is useful
     * where a class delegates most of the implementation of its properties to another class. You
     * can then call <code>toString()</code> on the other class and pass the result into this
     * method.</p> <p>
     * <pre>
     *   private AnotherObject delegate;
     *   private String fieldInThisClass;
     *
     *   public String toString() {
     *     return new ToStringBuilder(this).
     *       appendToString(delegate.toString()).
     *       append(fieldInThisClass).
     *       toString();
     *   }</pre>
     * <p> <p>This method assumes that the other object uses the same <code>ToStringStyle</code> as
     * this one.</p> <p> <p>If the <code>toString</code> is <code>null</code>, no change is
     * made.</p>
     *
     * @param toString the result of <code>toString()</code> on another object
     * @return this
     * @since 2.0
     */
    public ToStringBuilder appendToString(final String toString) {
        if (toString != null) {
            style.appendToString(buffer, toString);
        }
        return this;
    }

    /**
     * <p>Returns the <code>Object</code> being output.</p>
     *
     * @return The object being output.
     * @since 2.0
     */
    public Object getObject() {
        return object;
    }

    /**
     * <p>Gets the <code>StringBuffer</code> being populated.</p>
     *
     * @return the <code>StringBuffer</code> being populated
     */
    public StringBuffer getStringBuffer() {
        return buffer;
    }

    //----------------------------------------------------------------------------

    /**
     * <p>Gets the <code>ToStringStyle</code> being used.</p>
     *
     * @return the <code>ToStringStyle</code> being used
     * @since 2.0
     */
    public ToStringStyle getStyle() {
        return style;
    }

    /**
     * <p>Returns the built <code>toString</code>.</p> <p> <p>This method appends the end of data
     * indicator, and can only be called once. Use {@link #getStringBuffer} to get the current
     * string state.</p> <p> <p>If the object is <code>null</code>, return the style's
     * <code>nullText</code></p>
     *
     * @return the String <code>toString</code>
     */
    @Override
    public String toString() {
        if (this.getObject() == null) {
            this.getStringBuffer().append(this.getStyle().getNullText());
        } else {
            style.appendEnd(this.getStringBuffer(), this.getObject());
        }
        return this.getStringBuffer().toString();
    }

    /**
     * Returns the String that was build as an object representation. The default implementation
     * utilizes the {@link #toString()} implementation.
     *
     * @return the String <code>toString</code>
     * @see #toString()
     * @since 3.0
     */
    @Override
    public String build() {
        return toString();
    }
}
