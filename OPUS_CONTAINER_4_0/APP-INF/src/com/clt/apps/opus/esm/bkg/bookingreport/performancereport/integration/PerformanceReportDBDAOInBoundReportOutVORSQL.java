/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOInBoundReportOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.27 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOInBoundReportOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOInBoundReportOutVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOInBoundReportOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOInBoundReportOutVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("/* For Out */" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("'TOTAL_SUM_IB_BL' TOTAL_SUM_IB_BL" ).append("\n"); 
		query.append(", 'TOTAL_SUM_D2' TOTAL_SUM_D2" ).append("\n"); 
		query.append(", 'TOTAL_SUM_D4' TOTAL_SUM_D4" ).append("\n"); 
		query.append(", 'TOTAL_SUM_D5' TOTAL_SUM_D5" ).append("\n"); 
		query.append(", 'TOTAL_SUM_D7' TOTAL_SUM_D7" ).append("\n"); 
		query.append(", 'TOTAL_SUM_R2' TOTAL_SUM_R2" ).append("\n"); 
		query.append(", 'TOTAL_SUM_R45' TOTAL_SUM_R45" ).append("\n"); 
		query.append(", 'TOTAL_SUM_O2' TOTAL_SUM_O2" ).append("\n"); 
		query.append(", 'TOTAL_SUM_O4' TOTAL_SUM_O4" ).append("\n"); 
		query.append(", 'TOTAL_SUM_F2' TOTAL_SUM_F2" ).append("\n"); 
		query.append(", 'TOTAL_SUM_F4' TOTAL_SUM_F4" ).append("\n"); 
		query.append(", 'TOTAL_SUM_T2' TOTAL_SUM_T2" ).append("\n"); 
		query.append(", 'TOTAL_SUM_T4' TOTAL_SUM_T4" ).append("\n"); 
		query.append(", 'TOTAL_SUM_TTL40' TOTAL_SUM_TTL40" ).append("\n"); 
		query.append(", 'TOTAL_SUM_TTL20' TOTAL_SUM_TTL20" ).append("\n"); 
		query.append(", 'TOTAL_SUM_TS_BL' TOTAL_SUM_TS_BL" ).append("\n"); 
		query.append(", 'TOTAL_SUM_TS40' TOTAL_SUM_TS40" ).append("\n"); 
		query.append(", 'TOTAL_SUM_TS20' TOTAL_SUM_TS20" ).append("\n"); 
		query.append(", 'TOTAL_SUM_JIK40' TOTAL_SUM_JIK40" ).append("\n"); 
		query.append(", 'TOTAL_SUM_JIK20' TOTAL_SUM_JIK20" ).append("\n"); 
		query.append(",  'SUM_IB_BL' SUM_IB_BL" ).append("\n"); 
		query.append(", 'SUM_D2' SUM_D2" ).append("\n"); 
		query.append(", 'SUM_D4' SUM_D4" ).append("\n"); 
		query.append(", 'SUM_D5' SUM_D5" ).append("\n"); 
		query.append(", 'SUM_D7' SUM_D7" ).append("\n"); 
		query.append(", 'SUM_R2' SUM_R2" ).append("\n"); 
		query.append(", 'SUM_R45' SUM_R45" ).append("\n"); 
		query.append(", 'SUM_O2' SUM_O2" ).append("\n"); 
		query.append(", 'SUM_O4' SUM_O4" ).append("\n"); 
		query.append(", 'SUM_F2' SUM_F2" ).append("\n"); 
		query.append(", 'SUM_F4' SUM_F4" ).append("\n"); 
		query.append(", 'SUM_T2' SUM_T2" ).append("\n"); 
		query.append(", 'SUM_T4' SUM_T4" ).append("\n"); 
		query.append(", 'SUM_TTL40' SUM_TTL40" ).append("\n"); 
		query.append(", 'SUM_TTL20' SUM_TTL20" ).append("\n"); 
		query.append(", 'SUM_TS_BL' SUM_TS_BL" ).append("\n"); 
		query.append(", 'SUM_TS_40' SUM_TS40" ).append("\n"); 
		query.append(", 'SUM_TS_20' SUM_TS20" ).append("\n"); 
		query.append(", 'SUM_JIK40' SUM_JIK40" ).append("\n"); 
		query.append(", 'SUM_JIK20' SUM_JIK20" ).append("\n"); 
		query.append(", 'YYYY' YYYY" ).append("\n"); 
		query.append(", 'WEEKS' WEEKS" ).append("\n"); 
		query.append(", 'LANE_CD' LANE_CD" ).append("\n"); 
		query.append(", 'POD_CD' POD_CD" ).append("\n"); 
		query.append(", 'POD_YARD_CD' POD_YARD_CD" ).append("\n"); 
		query.append(", 'DEL_CD' DEL_CD" ).append("\n"); 
		query.append(", 'STAFF_ID' STAFF_ID" ).append("\n"); 
		query.append(", 'STAFF_NM' STAFF_NM" ).append("\n"); 
		query.append(", 'VVD_CD1' VVD_CD1" ).append("\n"); 
		query.append(", 'VVD_CD2' VVD_CD2" ).append("\n"); 
		query.append(", 'ATA_CD1' ATA_CD1" ).append("\n"); 
		query.append(", 'ATA_CD2' ATA_CD2" ).append("\n"); 
		query.append(", 'IB_BL' IB_BL" ).append("\n"); 
		query.append(", 'D2' D2" ).append("\n"); 
		query.append(", 'D4' D4" ).append("\n"); 
		query.append(", 'D5' D5" ).append("\n"); 
		query.append(", 'D7' D7" ).append("\n"); 
		query.append(", 'R2' R2" ).append("\n"); 
		query.append(", 'R45' R45" ).append("\n"); 
		query.append(", 'O2' O2" ).append("\n"); 
		query.append(", 'O4' O4" ).append("\n"); 
		query.append(", 'F2' F2" ).append("\n"); 
		query.append(", 'F4' F4" ).append("\n"); 
		query.append(", 'T2' T2" ).append("\n"); 
		query.append(", 'T4' T4" ).append("\n"); 
		query.append(", 'TTL40' TTL40" ).append("\n"); 
		query.append(", 'TTL20' TTL20" ).append("\n"); 
		query.append(", 'TS_BL' TS_BL" ).append("\n"); 
		query.append(", 'TS40' TS40" ).append("\n"); 
		query.append(", 'TS20' TS20" ).append("\n"); 
		query.append(", 'JIK40' JIK40" ).append("\n"); 
		query.append(", 'JIK20' JIK20" ).append("\n"); 
		query.append(", 'DURA_CD' DURA_CD" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}