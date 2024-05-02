///*=========================================================
//*Copyright(c) 2006 CyberLogitec
//*@FileName : TraceLogger.java
//*@FileTitle : TraceLogger
//*Open Issues :
//*Change history :
//*@LastModifyDate : 2006-12-20
//*@LastModifier : leebh
//*@LastVersion : 1.0
//* 2006-12-20 leebh
//* 1.0 최초 생성
//=========================================================*/
//package com.clt.apps.opus.esd.trs.servicesio.railbilling.common;
//
//import java.sql.PreparedStatement;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.log4j.Logger;
//
//import com.clt.framework.component.util.loggable.LoggableStatement;
//
///**
// * WebService TraceLogger Class<br>
// * - RailBilling의 TraceLogger Class<br>
// * - RailBilling에서 사용<br>
// *
// * @author leebh
// * @see  참조
// * @version 1.0
// * @since J2EE 1.4
// */
//public class TraceLogger {
//	public static final boolean TRACE_ENABLED = true;
//	
//	public static final double LIMIT_01  = 0.1;
//	public static final double LIMIT_02  = 0.2;
//	public static final double LIMIT_03  = 0.3;
//	public static final double LIMIT_04  = 0.4;
//	public static final double LIMIT_05  = 0.5;
//	public static final double LIMIT_10  = 1.0;
//	public static final double LIMIT_15  = 1.5;
//	public static final double LIMIT_20  = 2.0;
//	public static final double LIMIT_25  = 2.5;
//	public static final double LIMIT_30  = 3.0;
//	public static final double LIMIT_35  = 3.5;
//	public static final double LIMIT_40  = 4.0;
//	public static final double LIMIT_45  = 4.5;
//	public static final double LIMIT_50  = 5.0;
//	
//	private Logger log = null;
//	private StringBuffer traceLogBuff = null;
//    private String moduleName = "";
//    private String traceMstName = "";
//    private String traceDtlName = "";
//    private long beginMstTime = 0L;
//    private long endMstTime = 0L;
//    private long beginDtlTime = 0L;
//    private long endDtlTime = 0L;
//    private double procMstTime = 0.0;
//    private double procDtlTime = 0.0;
//    
//    /**
//     * TraceLogger
//     * @param moduleName
//     */
//	public TraceLogger(String moduleName) {
//        this.log = Logger.getLogger(getClass().getName());
//        this.traceLogBuff = new StringBuffer();
//        
//        if(moduleName != null && !Constants.EMPTY.equals(moduleName)) {
//        	this.moduleName = moduleName;
//        } else {
//        	this.moduleName = "UnKnown";
//        }
//	}	
//	
//	/**
//	 * TraceLogger
//	 * @param log
//	 * @param moduleName
//	 */
//	public TraceLogger(Logger log, String moduleName) {
//		this.log = log;
//		if(this.log == null) {
//			this.log = Logger.getLogger(getClass().getName());
//		}
//		
//        this.traceLogBuff = new StringBuffer();
//        
//        if(moduleName != null && !Constants.EMPTY.equals(moduleName)) {
//        	this.moduleName = moduleName;
//        } else {
//        	this.moduleName = "UnKnown";
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
//	 * masterBegin
//	 * @param value
//	 */
//	public void masterBegin(String value) {
//		if(!TRACE_ENABLED) return;
//		
//		try {
//			this.traceMstName = value;
//			this.beginMstTime = System.currentTimeMillis();
//			traceLogBuff.append("\n<trace module=").append(this.moduleName);
//			traceLogBuff.append(" mode=info type=master proc=begin");		
//			traceLogBuff.append(" time=").append(getCurrDateTime());
//			traceLogBuff.append(" name=\"").append(this.traceMstName).append("\"");
//			traceLogBuff.append(" />");
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}
//	}
//	
//	/**
//	 * masterEnd
//	 * @param limitTime
//	 */
//	public void masterEnd(double limitTime) {
//		if(!TRACE_ENABLED) return;
//		
//		try {
//			this.endMstTime = System.currentTimeMillis();
//			this.procMstTime = (double)(this.endMstTime-this.beginMstTime)/(double)1000;
//			traceLogBuff.append("\n<trace module=").append(this.moduleName);
//			traceLogBuff.append(" mode=info type=master proc=end  ");		
//			traceLogBuff.append(" time=").append(getCurrDateTime());		
//			traceLogBuff.append(" limitTime=").append(limitTime);
//			traceLogBuff.append(" procTime=").append(this.procMstTime);
//			traceLogBuff.append(" name=\"").append(this.traceMstName).append("\"");
//			traceLogBuff.append(" />");
//			
//			if(isMasterLimitTimeOver(limitTime)) {
//				log.error(traceLogBuff.toString());
//			}
//			traceLogBuff.setLength(0);
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}
//	}
//	
//	/**
//	 * detailBegin
//	 * @param value
//	 */
//	public void detailBegin(String value) {
//		if(!TRACE_ENABLED) return;
//
//		try {
//			this.traceDtlName = value;
//			this.beginDtlTime = System.currentTimeMillis();
//			traceLogBuff.append("\n\t<trace module=").append(this.moduleName);
//			traceLogBuff.append(" mode=info type=detail proc=begin");		
//			traceLogBuff.append(" time=").append(getCurrDateTime());
//			traceLogBuff.append(" name=\"").append(this.traceDtlName).append("\"");
//			traceLogBuff.append(" />");
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}		
//	}
//	
//	/**
//	 * detailEnd
//	 *
//	 */
//	public void detailEnd() {
//		if(!TRACE_ENABLED) return;
//		
//		try {
//			this.endDtlTime = System.currentTimeMillis();
//			this.procDtlTime = (double)(this.endDtlTime-this.beginDtlTime)/(double)1000;
//			traceLogBuff.append("\n\t<trace module=").append(this.moduleName);
//			traceLogBuff.append(" mode=info type=detail proc=end  ");		
//			traceLogBuff.append(" time=").append(getCurrDateTime());		
//			traceLogBuff.append(" procTime=").append(this.procDtlTime);
//			traceLogBuff.append(" name=\"").append(this.traceDtlName).append("\"");
//			traceLogBuff.append(" />");
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}			
//	}	
//	
//	/**
//	 * isMasterLimitTimeOver
//	 * @param limitTime
//	 * @return
//	 */
//	public boolean isMasterLimitTimeOver(double limitTime) {
//		if(!TRACE_ENABLED) return false;
//		
//		boolean result = false;
//		Double double1 = new Double(limitTime);
//		Double double2 = new Double( this.procMstTime);
//		double1.compareTo(double2);
//		
//		try {
//			result = this.procMstTime > limitTime;
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}			
//		return result;
//	}
//	
//	/**
//	 * isDetailLimitTimeOver
//	 * @param limitTime
//	 * @return
//	 */
//	public boolean isDetailLimitTimeOver(double limitTime) {
//		if(!TRACE_ENABLED) return false;
//		
//		boolean result = false;
//		
//		try {
//			result = this.procDtlTime > limitTime;
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}		
//		return result;
//	}
//	
//	/**
//	 * addVarInfo
//	 * @param name
//	 * @param value
//	 */
//	public void addVarInfo(String name, String value) {
//		if(!TRACE_ENABLED) return;
//		
//		try {
//			traceLogBuff.append("\n\t<trace module=").append(this.moduleName);
//			traceLogBuff.append(" mode=info type=detail proc=var  ");
//			traceLogBuff.append(" time=").append(getCurrDateTime());
//			if(name != null) {
//				traceLogBuff.append(" name=\"").append(name).append("\"");
//			}
//			traceLogBuff.append(" value=\"").append(value).append("\"");
//			traceLogBuff.append(" />");
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}			
//    }
//	
//	/**
//	 * addVarInfo
//	 * @param proc
//	 * @param limitTime
//	 * @param name
//	 * @param value
//	 */
//	private void addVarInfo(String proc, double limitTime, double procTime, String name, String value) {
//		if(!TRACE_ENABLED) return;
//		
//		try {
//			if(isDetailLimitTimeOver(limitTime)) {
//				traceLogBuff.append("\n\t<trace module=").append(this.moduleName);
//				traceLogBuff.append(" mode=warn type=detail");
//				traceLogBuff.append(" proc=").append(proc);
//				traceLogBuff.append(" time=").append(getCurrDateTime());
//				traceLogBuff.append(" limitTime=").append(limitTime);
//				traceLogBuff.append(" procTime=").append(procTime);
//				if(name != null) {
//					traceLogBuff.append(" name=\"").append(name).append("\"");
//				} else {
//					traceLogBuff.append(" name=\"").append("UnKnown").append("\"");
//				}
//				traceLogBuff.append(" value=\"").append(value).append("\"");
//				traceLogBuff.append(" />");
//			}
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}			
//    }	
//	
//	/**
//	 * addSQLInfo
//	 * @param limitTime
//	 * @param procTime
//	 * @param name
//	 * @param ps
//	 */
//	private void addSQLInfo(double limitTime, double procTime, String name, PreparedStatement ps) {
//		if(!TRACE_ENABLED) return;
//		
//		try {
//			if(isDetailLimitTimeOver(limitTime)) {
//				traceLogBuff.append("\n\t<trace module=").append(this.moduleName);
//				traceLogBuff.append(" mode=warn type=detail proc=sql  ");
//				traceLogBuff.append(" time=").append(getCurrDateTime());
//				traceLogBuff.append(" limitTime=").append(limitTime);
//				traceLogBuff.append(" procTime=").append(procTime);
//				if(name != null) {
//					traceLogBuff.append(" name=\"").append(name).append("\"");
//				} else {
//					traceLogBuff.append(" name=\"").append("UnKnown").append("\"");
//				}
//				traceLogBuff.append(" value=\"").append(((LoggableStatement)ps).getQueryString()).append("\"");
//				traceLogBuff.append(" />");
//			}
//		}catch(Exception e) {
//			log.error(e.getMessage(), e);
//		}			
//    }	
//	
//	/**
//	 * queryBegin
//	 * @param value
//	 */
//	public void queryBegin(String value) {
//		if(!TRACE_ENABLED) return;
//
//		detailBegin(value);
//	}
//	
//	/**
//	 * queryEnd
//	 * @param limitTime
//	 * @param ps
//	 */
//	public void queryEnd(double limitTime, PreparedStatement ps) {
//		if(!TRACE_ENABLED) return;
//		
//		detailEnd();
//		
//		addSQLInfo(limitTime, this.procDtlTime, this.traceDtlName, ps);
//	}
//	
//	/**
//	 * queryEnd
//	 * @param limitTime
//	 * @param sql
//	 */
//	public void queryEnd(double limitTime, String sql) {
//		if(!TRACE_ENABLED) return;
//		
//		detailEnd();
//		
//		addVarInfo("sql  ", limitTime, this.procDtlTime, this.traceDtlName, sql);
//	}	
//}
