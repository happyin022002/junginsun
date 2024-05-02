/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqBreakbulkDBDAOmakePriScqBbHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOmakePriScqBbHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * makePriScqBbHdrVO
	  * * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqBreakbulkDBDAOmakePriScqBbHdrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOmakePriScqBbHdrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",'' ACT_CUST_NM" ).append("\n"); 
		query.append(",'' ACT_CUST_SEQ" ).append("\n"); 
		query.append(",'' APRO_EFF_DT" ).append("\n"); 
		query.append(",'' APRO_EXP_DT" ).append("\n"); 
		query.append(",'' APRO_OFC_CD" ).append("\n"); 
		query.append(",'' APRO_RT_AMT" ).append("\n"); 
		query.append(",'' AUTH" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",'' DELT_FLG" ).append("\n"); 
		query.append(",'' DE_TERM_CD" ).append("\n"); 
		query.append(",'' IBFLAG" ).append("\n"); 
		query.append(",'' LANE_CD" ).append("\n"); 
		query.append(",'' LAST_CNTR_GRP_USR_ID" ).append("\n"); 
		query.append(",'' LAST_FLG" ).append("\n"); 
		query.append(",'' MAX_CNTR_GRP_NO" ).append("\n"); 
		query.append(",'' MEAS_SYS_CD" ).append("\n"); 
		query.append(",'' MEAS_SYS_CD_VW" ).append("\n"); 
		query.append(",'' PAGEROWS" ).append("\n"); 
		query.append(",'' PG_PROG_STS_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' POD_YD_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POL_YD_CD" ).append("\n"); 
		query.append(",'' PRE_PROG_STS_CD" ).append("\n"); 
		query.append(",'' PROG_DT" ).append("\n"); 
		query.append(",'' PROG_OFC_CD" ).append("\n"); 
		query.append(",'' PROG_RMK" ).append("\n"); 
		query.append(",'' PROG_SEQ" ).append("\n"); 
		query.append(",'' PROG_STS_CD" ).append("\n"); 
		query.append(",'' PROG_STS_NM" ).append("\n"); 
		query.append(",'' PROG_USR_ID" ).append("\n"); 
		query.append(",'' PROG_USR_NM" ).append("\n"); 
		query.append(",'' PROP_EFF_DT" ).append("\n"); 
		query.append(",'' PROP_EXP_DT" ).append("\n"); 
		query.append(",'' PROP_RT_AMT" ).append("\n"); 
		query.append(",'' RCV_TERM_CD" ).append("\n"); 
		query.append(",'' RQST_OFC_CD" ).append("\n"); 
		query.append(",'' RQST_SREP_CD" ).append("\n"); 
		query.append(",'' RQST_SREP_NM" ).append("\n"); 
		query.append(",'' RSLT_FLG" ).append("\n"); 
		query.append(",'' SCQ_BID_FLG" ).append("\n"); 
		query.append(",'' SCQ_RQST_NO" ).append("\n"); 
		query.append(",'' SCQ_VER_NO" ).append("\n"); 
		query.append(",'' SPCL_CGO_TP_CD" ).append("\n"); 
		query.append(",'' SVC_SCP_CD" ).append("\n"); 
		query.append(",'' TS_LOC_CD" ).append("\n"); 
		query.append(",'' TS_YD_CD" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' VPS_ETA_DT" ).append("\n"); 
		query.append(",'' VVD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}