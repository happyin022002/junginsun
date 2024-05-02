/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EventParamToStringBuilder.java
*@FileTitle : EventParamToStringBuilder
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.common;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.RailBillingIWSProxy;

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
public class EventParamToStringBuilder {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
    private final StringBuffer buffer;
    private final EventParamStyle style;
    private final Object object;
    
    /**
     * EventParamToStringBuilder
     * @param object
     */
    public EventParamToStringBuilder(Object object) {
        this(object, null);
    }
    
    /**
     * EventParamToStringBuilder
     * @param object
     * @param buffer
     */
    public EventParamToStringBuilder(Object object, StringBuffer buffer) {
        super();
        //if (object == null) {
            //throw new IllegalArgumentException("The object to create a toString for must not be null");
        //}

        if (buffer == null) {
            buffer = new StringBuffer(512);
        }
        this.buffer = buffer;
        this.object = object;
        this.style = new EventParamStyle();
        
        if (object == null) { 
	        this.buffer.append("\n");
	        this.style.appendStart(buffer, object);
        }
    }
    
    /**
     * reflectionToString
     * @param objNm
     * @param object
     * @return
     */
//    public String objectToString(String objNm, Object object) {
//        return objectToString(objNm, object, false);
//    }

    /**
     * reflectionToString
     * @param object
     * @param objNm
     * @param outputTransients
     * @return
     */
//    public String objectToString(String objNm, Object object, boolean outputTransients) {
//        if (object == null) {
//            throw new IllegalArgumentException("The object must not be null");
//        }
//        Field[] fields = object.getClass().getDeclaredFields();
//        Field.setAccessible(fields, true);
//        //EventParamToStringBuilder builder = new EventParamToStringBuilder(object);
//        for (int i = 0; i < fields.length; ++i) {
//            Field f = fields[i];
//            if (outputTransients || !Modifier.isTransient(f.getModifiers())) {
//                try {
//                	this.append(objNm+"."+f.getName(), f.get(object));
//                } catch (IllegalAccessException ex) {
//                	log.error(ex.getMessage());
//                    throw new InternalError("Unexpected IllegalAccessException");
//                }
//            }
//        }
//        return this.toString();
//    }

    /**
     * objectToString
     * @return
     */
    public String objectToString() {
        if (object != null) {
	        Field[] fields = object.getClass().getDeclaredFields();
	        Field.setAccessible(fields, true);
	
	        for (int i = 0; i < fields.length; i++) {
	            Field f = fields[i];
	            try {
	            	this.append("\n"+f.getName(), f.get(object));
	            } catch (IllegalAccessException ex) {
	            	log.error("Error EventParamToString : IllegalAccessException.");
	            	log.error(ex.getMessage());
	                //throw new InternalError("Unexpected IllegalAccessException");
	            } catch (Exception e) {
	            	log.error("Error EventParamToString : Exception.");
	            	log.error(e.getMessage());            	
	            }
	        }
        }
        return this.toString();
    }    

    /**
     * append
     * @param object
     * @return
     */
    public EventParamToStringBuilder append(Object object) {
        style.append(buffer, null, object, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param object
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, Object object) {
        style.append(buffer, fieldName, object, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param object
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, Object object, boolean fullDetail) {
        style.append(buffer, fieldName, object, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(long value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, long value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(int value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, int value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(short value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, short value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(char value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, char value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(byte value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, byte value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(double value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, double value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(float value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, float value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(boolean value) {
        style.append(buffer, null, value);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param value
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, boolean value) {
        style.append(buffer, fieldName, value);
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(Object[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, Object[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, Object[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(long[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, long[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, long[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    //----------------------------------------------------------------------------
    
    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(int[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, int[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, int[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(short[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, short[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, short[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(char[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, char[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, char[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(byte[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, byte[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, byte[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(double[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, double[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, double[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(float[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, float[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, float[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * append
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(boolean[] array) {
        style.append(buffer, null, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, boolean[] array) {
        style.append(buffer, fieldName, array, null);
        return this;
    }

    /**
     * append
     * @param fieldName
     * @param array
     * @param fullDetail
     * @return
     */
    public EventParamToStringBuilder append(String fieldName, boolean[] array, boolean fullDetail) {
        style.append(buffer, fieldName, array, new Boolean(fullDetail));
        return this;
    }

    /**
     * getStringBuffer
     * @return
     */
    public StringBuffer getStringBuffer() {
        return buffer;
    }

    /**
     * toString
     */  
    public String toString() {
        style.appendEnd(buffer);
        return buffer.toString();
    }
}
