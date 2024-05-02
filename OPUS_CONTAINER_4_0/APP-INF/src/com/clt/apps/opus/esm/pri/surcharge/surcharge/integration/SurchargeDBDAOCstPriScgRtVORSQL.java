/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SurchargeDBDAOCstPriScgRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.05.04 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOCstPriScgRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Inquiry 조회 조건 생성
	  * </pre>
	  */
	public SurchargeDBDAOCstPriScgRtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOCstPriScgRtVORSQL").append("\n"); 
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
		query.append("		 '' SCG_RMK             " ).append("\n"); 
		query.append("		,'' SCG_IMDG_CLSS_CD    " ).append("\n"); 
		query.append("		,'' ORG_TRSP_MOD_CD     " ).append("\n"); 
		query.append("		,'' SVC_SCP_CD          " ).append("\n"); 
		query.append("		,'' PAY_TERM_CD         " ).append("\n"); 
		query.append("		,'' LVL2                " ).append("\n"); 
		query.append("		,'' TML_CD              " ).append("\n"); 
		query.append("		,'' LVL3                " ).append("\n"); 
		query.append("		,'' LVL4                " ).append("\n"); 
		query.append("		,'' CHG_CD                      " ).append("\n"); 
		query.append("		,'' DEL_DEF_CD          " ).append("\n"); 
		query.append("		,'' EFF_DT              " ).append("\n"); 
		query.append("		,'' LVL1                " ).append("\n"); 
		query.append("		,'' DEST_TRSP_MOD_CD    " ).append("\n"); 
		query.append("		,'' DEL_TP_CD           " ).append("\n"); 
		query.append("		,'' UPD_USR_ID          " ).append("\n"); 
		query.append("		,'' DIR_CALL_FLG        " ).append("\n"); 
		query.append("		,'' PRC_DE_TERM_CD      " ).append("\n"); 
		query.append("		,'' IO_GA_CD            " ).append("\n"); 
		query.append("		,'' RAT_UT_CD           " ).append("\n"); 
		query.append("		,'' CRE_USR_ID          " ).append("\n"); 
		query.append("		,'' POD_DEF_CD          " ).append("\n"); 
		query.append("		,'' POR_TP_CD           " ).append("\n"); 
		query.append("		,'' SUB_TRD_CD          " ).append("\n"); 
		query.append("		,'' POL_TP_CD           " ).append("\n"); 
		query.append("		,'' CURR_CD             " ).append("\n"); 
		query.append("		,'' PRC_CGO_TP_CD       " ).append("\n"); 
		query.append("		,'' DELT_FLG            " ).append("\n"); 
		query.append("		,'' WDR_FLG             " ).append("\n"); 
		query.append("		,'' CRE_DT              " ).append("\n"); 
		query.append("		,'' VSL_SLAN_CD         " ).append("\n"); 
		query.append("		,'' POL_DEF_CD          " ).append("\n"); 
		query.append("		,'' USA_SVC_MOD_CD                 " ).append("\n"); 
		query.append("		,'' CMDT_CD             " ).append("\n"); 
		query.append("		,'' EXP_DT              " ).append("\n"); 
		query.append("		,'' CNL_TZ_CD           " ).append("\n"); 
		query.append("		,'' MAX_CGO_WGT         " ).append("\n"); 
		query.append("		,'' UPD_DT              " ).append("\n"); 
		query.append("		,'' TS_PORT_CD          " ).append("\n"); 
		query.append("		,'' POD_TP_CD           " ).append("\n"); 
		query.append("		,'' SCG_SEQ             " ).append("\n"); 
		query.append("		,'' POR_DEF_CD          " ).append("\n"); 
		query.append("		,'' SCG_GRP_CMDT_CD     " ).append("\n"); 
		query.append("		,'' PRC_RCV_TERM_CD     " ).append("\n"); 
		query.append("		,'' SOC_FLG             " ).append("\n"); 
		query.append("		,'' PRC_HNGR_BAR_TP_CD  " ).append("\n"); 
		query.append("		,'' MIN_CGO_WGT         " ).append("\n"); 
		query.append("		,'' SCG_AMT             " ).append("\n"); 
		query.append("		,'' SEQ       " ).append("\n"); 
		query.append("		,'' UPD_USR_NM" ).append("\n"); 
		query.append("FROM DUAL		 	          		    " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("  PriScgRtVO" ).append("\n"); 
		query.append("*/    " ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT '' AS SVC_SCP_CD" ).append("\n"); 
		query.append("     , '' AS CHG_CD" ).append("\n"); 
		query.append("     , '' AS POR_DEF_CD" ).append("\n"); 
		query.append("     , '' AS POL_DEF_CD" ).append("\n"); 
		query.append("     , '' AS POD_DEF_CD" ).append("\n"); 
		query.append("     , '' AS DEL_DEF_CD" ).append("\n"); 
		query.append("     , '' AS PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , '' AS PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , '' AS EFF_DT" ).append("\n"); 
		query.append("     , '' AS UPD_DT" ).append("\n"); 
		query.append("     , '' AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , '' AS SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , '' AS RAT_UT_CD" ).append("\n"); 
		query.append("     , '' AS CNTR_SZ_CD" ).append("\n"); 
		query.append("	 , '' AS WDR_FLG" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("SURCHARGE INQUIRY 조회조건 생성 CstPriScgRtVO" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}