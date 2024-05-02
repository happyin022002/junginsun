/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TraceLogUtil.java
*@FileTitle : TraceLog Util
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.log4j.Logger;
//
///**
// * WebService TraceLog Util Class<br>
// * - RailBilling의 TraceLog Util Class<br>
// * - RailBilling에서 사용<br>
// *
// * @author leebh
// * @see  참조
// * @version 1.0
// * @since J2EE 1.4
// */
public class TraceLogUtil {
//	public static final boolean TRACE_ENABLED = true;
//	
//	public static final int TRACE_GROUP = 1; 
//	public static final int TRACE_STEP  = 2;
//	
//	public static final double LIMIT_TIME_05  = 0.5;
//	public static final double LIMIT_TIME_10  = 1.0;
//	public static final double LIMIT_TIME_15  = 1.5;
//	public static final double LIMIT_TIME_20  = 2.0;
//	public static final double LIMIT_TIME_25  = 2.5;
//	public static final double LIMIT_TIME_30  = 3.0;
//	public static final double LIMIT_TIME_35  = 3.5;
//	public static final double LIMIT_TIME_40  = 4.0;
//	public static final double LIMIT_TIME_45  = 4.5;
//	public static final double LIMIT_TIME_50  = 5.0;
//	
//    private String module = "";
//    private StringBuffer traceLogBuff = null;
//    private long startGrpTime = 0L;
//    private long endGrpTime = 0L;
//    private double procGrpTime = 0.0;
//    private long startStpTime = 0L;
//    private long endStpTime = 0L;
//    private double procStpTime = 0.0;
//    
//	/**
//	 * TraceLogUtil생성자
//	 * 
//	 * @param module
//	 */
//	public TraceLogUtil(String module) {
//		super();
//        traceLogBuff = new StringBuffer();
//        
//        if(module != null && !Constants.EMPTY.equals(module)) {
//        	this.module = module;
//        } else {
//        	this.module = "UnKnown";
//        }
//	}
//	
//	/**
//	 * getCurrDateTime
//	 * @return
//	 */
//	public String getCurrDateTime() {
//		SimpleDateFormat fmt = new SimpleDateFormat("\"yyyy-MM-dd HH:mm:ss:SSS\"");
//		return fmt.format(new Date());		
//	}
//	
//	/**
//	 * setTraceStart
//	 * @param traceType
//	 * @param value
//	 */
//	public void setTraceStart(int traceType, String value) {
//		if(!TRACE_ENABLED) return;
//		
//		if(TRACE_STEP == traceType) {
//			this.startStpTime = System.currentTimeMillis();
//			traceLogBuff.append("\n\t<trace:"+this.module+" mode=info type=step  proc=start");
//		} else if(TRACE_GROUP == traceType) {
//			this.startGrpTime = System.currentTimeMillis();
//			traceLogBuff.append("\n<trace:"+this.module+" mode=info type=group proc=start");			
//		} else {
//			return;
//		}
//		
//		traceLogBuff.append(" time="+getCurrDateTime());
//		traceLogBuff.append(" name=\""+value+"\"");
//		traceLogBuff.append(" />");
//	}
//	
//	/**
//	 * setTraceEnd
//	 * @param traceType
//	 * @param value
//	 */
//	public void setTraceEnd(int traceType, String value) {
//		if(!TRACE_ENABLED) return;
//		
//		if(TRACE_STEP == traceType) {
//			this.endStpTime = System.currentTimeMillis();
//			this.procStpTime = (double)(this.endStpTime-this.startStpTime)/(double)1000;
//			traceLogBuff.append("\n\t<trace:"+this.module+" mode=info type=step  proc=end  ");
//			traceLogBuff.append(" time="+getCurrDateTime());
//			traceLogBuff.append(" procTime="+this.procStpTime);			
//		} else if(TRACE_GROUP == traceType) {
//			this.endGrpTime = System.currentTimeMillis();
//			this.procGrpTime = (double)(this.endGrpTime-this.startGrpTime)/(double)1000;
//			traceLogBuff.append("\n<trace:"+this.module+" mode=info type=group proc=end  ");		
//			traceLogBuff.append(" time="+getCurrDateTime());
//			traceLogBuff.append(" procTime="+this.procGrpTime);			
//		} else {
//			return;
//		}		
//
//		traceLogBuff.append(" name=\""+value+"\"");
//		traceLogBuff.append(" />");
//	}
//	
//	/**
//	 * isLimitTimeOver
//	 * 
//	 * @param traceType
//	 * @param limitTime
//	 * @return
//	 */
//	public boolean isLimitTimeOver(int traceType, double limitTime) {
//		if(!TRACE_ENABLED) return false;
//		
//		boolean result = false;
//		
//		if(TRACE_GROUP == traceType && this.procGrpTime > limitTime) {
//			result = true;
//		} else if(TRACE_STEP == traceType && this.procStpTime > limitTime) {
//			result = true;
//		} else {
//			result = false;
//		}
//		return result;
//	}
//	
//	/**
//	 * addInfo
//	 * @param name
//	 * @param value
//	 */
//	public void addInfo(String name, String value) {
//		if(!TRACE_ENABLED) return;
//		
//		traceLogBuff.append("\n\t<trace:"+this.module+" mode=info type=      proc=     ");
//		traceLogBuff.append(" time="+getCurrDateTime());
//		if(name != null) {
//			traceLogBuff.append(" name=\""+name+"\"");
//		}
//		traceLogBuff.append(" value=\""+value+"\"");
//		traceLogBuff.append(" />");
//    }
//	
//	/**
//	 * addWarning
//	 * @param traceType
//	 * @param limitTime
//	 * @param name
//	 * @param value
//	 */
//	public void addInfo(int traceType, double limitTime, String name, String value) {
//		if(!TRACE_ENABLED) return;
//		
//		if(isLimitTimeOver(traceType, limitTime)) {
//			traceLogBuff.append("\n\t<trace:"+this.module+" mode=warn type=      proc=     ");
//			traceLogBuff.append(" time="+getCurrDateTime());
//			if(name != null) {
//				traceLogBuff.append(" name=\""+name+"\"");
//			}
//			traceLogBuff.append(" value=\""+value+"\"");
//			traceLogBuff.append(" />");
//		}
//    }	
//	
//	/**
//	 * logWrite
//	 * @param logger
//	 * @param limitTime
//	 */
//	public void logWrite(Logger logger, double limitTime) {
//		if(!TRACE_ENABLED) return;
//		
//		if(this.procGrpTime > limitTime) {
//			logger.error(traceLogBuff.toString());
//		}
//		traceLogBuff.setLength(0);
//	}
}
