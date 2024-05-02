/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EventParamStyle.java
*@FileTitle : EventParamStyle
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.RailBillingIWSProxy;

/**
 * WebService EventParamUtil Class<br>
 * - RailBillingIWSProxy의 EventParamUtil Class<br>
 * - RailBilling에서 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @version 1.0
 * @since J2EE 1.4
 */
public class EventParamStyle {
    
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
    protected String contentStart = "[";
    protected String contentEnd = "]";
    protected String fieldNameValueSeparator = "=";
    protected String fieldSeparator = ",";
    protected String arrayStart = "{";
    protected String arraySeparator = ",";
    protected boolean arrayContentDetail = true;
    protected String arrayEnd = "}";
    protected boolean defaultFullDetail = true;
    protected String nullText = "<null>";
    protected String sizeStartText = "<size=";
    protected String sizeEndText = ">";
    
    /**
     * appendStart
     * @param buffer
     * @param object
     */
    public void appendStart(StringBuffer buffer, Object object) {
        appendClassName(buffer, object);
        appendIdentityHashCode(buffer, object);
        appendContentStart(buffer);
    }

    /**
    * appendEnd
    * @param buffer
    */
    public void appendEnd(StringBuffer buffer) {
        appendContentEnd(buffer);
    }
    
    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (value == null) {
            appendNullText(buffer);
            
        } else {
            appendInternal(buffer, fieldName, value, isFullDetail(fullDetail));
        }
        
        appendFieldEnd(buffer);
    }
    
    /**
     * appendInternal
     * @param buffer
     * @param fieldName
     * @param value
     * @param detail
     */
    protected void appendInternal(StringBuffer buffer, String fieldName, Object value, boolean detail) {
        if (value instanceof Collection) {
            if (detail) {
                appendDetail(buffer, fieldName, (Collection) value);
            } else {
                appendSummarySize(buffer, ((Collection) value).size());
            }
            
        } else if (value instanceof Map) {
            if (detail) {
                appendDetail(buffer, fieldName, (Map) value);
            } else {
                appendSummarySize(buffer, ((Map) value).size());
            }
            
        } else if (value instanceof long[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (long[]) value);
            } else {
                appendSummary(buffer, (long[]) value);
            }
            
        } else if (value instanceof int[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (int[]) value);
            } else {
                appendSummary(buffer, (int[]) value);
            }
            
        } else if (value instanceof short[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (short[]) value);
            } else {
                appendSummary(buffer, (short[]) value);
            }
            
        } else if (value instanceof byte[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (byte[]) value);
            } else {
                appendSummary(buffer, (byte[]) value);
            }
            
        } else if (value instanceof char[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (char[]) value);
            } else {
                appendSummary(buffer, (char[]) value);
            }
            
        } else if (value instanceof double[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (double[]) value);
            } else {
                appendSummary(buffer, (double[]) value);
            }
            
        } else if (value instanceof float[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (float[]) value);
            } else {
                appendSummary(buffer, (float[]) value);
            }
            
        } else if (value instanceof boolean[]) {
            if (detail) {
                appendDetail(buffer, fieldName, (boolean[]) value);
            } else {
                appendSummary(buffer, (boolean[]) value);
            }
        
        } else if (value.getClass().isArray()) {
            if (detail) {
                appendDetail(buffer, fieldName, (Object[]) value);
            } else {
                appendSummary(buffer, (Object[]) value);
            }
            
        } else {
            if (detail) {
                appendDetail(buffer, fieldName, (Object) value);
            } else {
                appendSummary(buffer, (Object) value);
            }
        }
    }
    
    /**
     * appendDetail
     * @param buffer
     * @param fieldName
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        buffer.append(value);
        // 절대로 하기 if 문을 제거 하지 말것 !!!
        if(value.getClass().getName().indexOf("com.hanjin.apps.alps.esd.trs.servicesio.railbilling")>= 0) {
	        try {
				Field[] fields = value.getClass().getDeclaredFields();
				Field.setAccessible(fields, true);
		        for (int i = 0; i < fields.length; i++) {
		        	Field f = fields[i];
		        	if(f.getName() != null && f.getName().length() > 0 && "$".equals(f.getName().substring(0,1))) {
		        		continue;
		        	}
		        	this.append(buffer, fieldName+"."+f.getName(), f.get(value), null);
		        }
		        buffer.append("\n");
	        } catch (IllegalAccessException ex) {
	        	log.error(ex.getMessage());
	            //throw new InternalError("Unexpected IllegalAccessException");
	        }	        
        }
    }
    
    /**
     * appendDetail
     * @param buffer
     * @param coll
     */
    protected void appendDetail(StringBuffer buffer, Collection coll) {
        buffer.append(coll);
    }
    
    /**
     * appendDetail
     * @param buffer
     * @param map
     */
    protected void appendDetail(StringBuffer buffer, Map map) {
        buffer.append(map);
    }
    
    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendSummary(StringBuffer buffer, Object value) {
        buffer.append('<');
        buffer.append(getShortClassName(value.getClass()));
        buffer.append('>');
    }
    
    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, long value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, long value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, int value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, int value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, short value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, short value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, byte value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, byte value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, char value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, char value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, double value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, double value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, float value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, float value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param value
     */
    public void append(StringBuffer buffer, String fieldName, boolean value) {
        appendFieldStart(buffer, fieldName);
        appendDetail(buffer, value);
        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param value
     */
    protected void appendDetail(StringBuffer buffer, boolean value) {
        buffer.append(value);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, Object[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param fieldName
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, Object[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            Object item = array[i];
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            if (item == null) {
                appendNullText(buffer);
                
            } else {
                appendInternal(buffer, fieldName, item, arrayContentDetail);
            }
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, Object[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, long[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, long[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, long[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, int[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, int[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, int[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, short[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, short[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, short[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, byte[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, byte[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, byte[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, char[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, char[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, char[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, double[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, double[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, double[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, float[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, float[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, float[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * append
     * @param buffer
     * @param fieldName
     * @param array
     * @param fullDetail
     */
    public void append(StringBuffer buffer, String fieldName, boolean[] array, Boolean fullDetail) {
        appendFieldStart(buffer, fieldName);
        
        if (array == null) {
            appendNullText(buffer);
            
        } else if (isFullDetail(fullDetail)) {
            appendDetail(buffer, fieldName, array);
            
        } else {
            appendSummary(buffer, array);
        }

        appendFieldEnd(buffer);
    }

    /**
     * appendDetail
     * @param buffer
     * @param array
     */
    protected void appendDetail(StringBuffer buffer, boolean[] array) {
        buffer.append(arrayStart);
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(arraySeparator);
            }
            appendDetail(buffer, array[i]);
        }
        buffer.append(arrayEnd);
    }

    /**
     * appendSummary
     * @param buffer
     * @param array
     */
    protected void appendSummary(StringBuffer buffer, boolean[] array) {
        appendSummarySize(buffer, array.length);
    }

    /**
     * appendClassName
     * @param buffer
     * @param object
     */
    protected void appendClassName(StringBuffer buffer, Object object) {
        buffer.append(object.getClass().getName());
    }

    /**
     * appendIdentityHashCode
     * @param buffer
     * @param object
     */
    protected void appendIdentityHashCode(StringBuffer buffer, Object object) {
        buffer.append('@');
        buffer.append(Integer.toHexString(System.identityHashCode(object)));
    }

    /**
     * appendContentStart
     * @param buffer
     */
    protected void appendContentStart(StringBuffer buffer) {
        buffer.append(contentStart);
    }
    
    /**
     * appendContentEnd
     * @param buffer
     */
    protected void appendContentEnd(StringBuffer buffer) {
        int len = buffer.length();
        int sepLen = fieldSeparator.length();
        if (len > 0 && sepLen > 0 && len >= sepLen && buffer.charAt(len - 1) == fieldSeparator.charAt(sepLen - 1)) {
            buffer.setLength(len - sepLen);
        }
        buffer.append(contentEnd);
    }
    
    /**
     * appendNullText
     * @param buffer
     */
    protected void appendNullText(StringBuffer buffer) {
        buffer.append(nullText);
    }
    
    /**
     * appendFieldSeparator
     * @param buffer
     */
    protected void appendFieldSeparator(StringBuffer buffer) {
        buffer.append(fieldSeparator);
    }
    
    /**
     * appendFieldStart
     * @param buffer
     * @param fieldName
     */
    protected void appendFieldStart(StringBuffer buffer, String fieldName) {
        if (fieldName != null) {
            buffer.append(fieldName);
            buffer.append(fieldNameValueSeparator);
        }
    }
    
    /**
     * appendFieldEnd
     * @param buffer
     */
    protected void appendFieldEnd(StringBuffer buffer) {
        appendFieldSeparator(buffer);
    }
    
    /**
     * appendSummarySize
     * @param buffer
     * @param size
     */
    protected void appendSummarySize(StringBuffer buffer, int size) {
        buffer.append(sizeStartText);
        buffer.append(size);
        buffer.append(sizeEndText);
    }

    /**
     * isFullDetail
     * @param fullDetailRequest
     * @return
     */
    protected boolean isFullDetail(Boolean fullDetailRequest) {
        if (fullDetailRequest == null) {
            return defaultFullDetail;
        }
        return fullDetailRequest.booleanValue();
    }
    
    /**
     * getShortClassName
     * @param cls
     * @return
     */
    protected String getShortClassName(Class cls) {
        String name = cls.getName();
        int pos = name.lastIndexOf('.');
        if (pos == -1) {
            return name;
        }
        return name.substring(pos + 1);
    }
    
}