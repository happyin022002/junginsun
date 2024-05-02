/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAORsltSearchMOTSSEFilingListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchMOTSSEFilingListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성 SQL
	  * * 2013.08.29 송호진 [CHM-201431591] MOT Filing 양식 변경 - O.EIC, O.SLF 추가
	  * * 2016.01.13 [CHM-201539514] SSE Agreement Filing 상 Surcharge 추가 요청 Requested By SELCMA / Kim GyungUk -- OBS, BCC, BLR, LBP, CTC, LSI 추가
	  * </pre>
	  */
	public SCReportDBDAORsltSearchMOTSSEFilingListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchMOTSSEFilingListVORSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("		'' AS SEQ" ).append("\n"); 
		query.append("    ,   '' AS BAT_EXE_DT" ).append("\n"); 
		query.append("    ,   '' AS CARRIER" ).append("\n"); 
		query.append("    ,   '' AS CTRT_NO" ).append("\n"); 
		query.append("    ,   '' AS CTRT_HLD_NM" ).append("\n"); 
		query.append("    ,   '' AS BKG_NO" ).append("\n"); 
		query.append("    ,   '' AS BKG_SRC_TP_CD" ).append("\n"); 
		query.append("    ,   '' AS SHPR_NM" ).append("\n"); 
		query.append("    ,   '' AS LANE" ).append("\n"); 
		query.append("    ,   '' AS POR_CD" ).append("\n"); 
		query.append("    ,   '' AS DEL_CD" ).append("\n"); 
		query.append("    ,   '' AS CNTR_TP" ).append("\n"); 
		query.append("    ,   '' AS CMDT_TP" ).append("\n"); 
		query.append("    ,   '' AS ACT_CUST_NM" ).append("\n"); 
		query.append("    ,   '' AS CNTR_SZ" ).append("\n"); 
		query.append("    ,   '' AS MQC1" ).append("\n"); 
		query.append("    ,   '' AS MQC2" ).append("\n"); 
		query.append("    ,   '' AS OFT_RT" ).append("\n"); 
		query.append("    ,   '' AS BLNK1" ).append("\n"); 
		query.append("    ,   '' AS BAF_AMT" ).append("\n"); 
		query.append("    ,   '' AS CAF_AMT" ).append("\n"); 
		query.append("    ,   '' AS OTHC_AMT" ).append("\n"); 
		query.append("    ,   '' AS DTHC_AMT" ).append("\n"); 
		query.append("    ,   '' AS APS_AMT" ).append("\n"); 
		query.append("    ,   '' AS CSR_AMT" ).append("\n"); 
		query.append("    ,   '' AS PSC_AMT" ).append("\n"); 
		query.append("    ,   '' AS PCC_AMT" ).append("\n"); 
		query.append("    ,   '' AS PCS_AMT" ).append("\n"); 
		query.append("    ,   '' AS STF_AMT" ).append("\n"); 
		query.append("    ,   '' AS DACT_AMT" ).append("\n"); 
		query.append("    ,   '' AS DDDC_AMT" ).append("\n"); 
		query.append("    ,   '' AS DDDF_AMT" ).append("\n"); 
		query.append("    ,   '' AS DNFC_AMT" ).append("\n"); 
		query.append("    ,   '' AS OENS_AMT" ).append("\n"); 
		query.append("    ,   '' AS OD_AMT" ).append("\n"); 
		query.append("    ,   '' AS TDIS_AMT" ).append("\n"); 
		query.append("    ,   '' AS TGOH_AMT" ).append("\n"); 
		query.append("    ,   '' AS TWSC_AMT" ).append("\n"); 
		query.append("    ,   '' AS EFF_DT" ).append("\n"); 
		query.append("    ,   '' AS EXP_DT" ).append("\n"); 
		query.append("    ,   '' AS REMARK" ).append("\n"); 
		query.append("    ,   '' AS EXEC_DT" ).append("\n"); 
		query.append("    ,   '' AS TEST_EXEC_DT" ).append("\n"); 
		query.append("    ,   '' AS INQ_TP_CD" ).append("\n"); 
		query.append("    ,   '' AS CRE_USR_ID" ).append("\n"); 
		query.append("    ,   '' AS UPD_USR_ID" ).append("\n"); 
		query.append("    ,   '' AS FR_FILE_DT" ).append("\n"); 
		query.append("    ,   '' AS TO_FILE_DT" ).append("\n"); 
		query.append("    ,   '' AS CFM_DT" ).append("\n"); 
		query.append("    ,   '' AS CFM_FLG" ).append("\n"); 
		query.append("    ,   '' AS FILE_DT" ).append("\n"); 
		query.append("    ,   '' AS MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_CHG_AMT" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_CHG_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_CMDT_TP_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_CNTR_SZ_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_CNTR_TP_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_DEST_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_ORG_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_RMK" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_RT_AMT" ).append("\n"); 
		query.append("    ,   '' AS MOT_TRF_SEQ" ).append("\n"); 
		query.append("    ,   '' AS RT_SEQ" ).append("\n"); 
		query.append("    ,   '' AS SCG_SEQ" ).append("\n"); 
		query.append("    ,   '' AS SVC_SCP_CD" ).append("\n"); 
		query.append("    ,   '' AS BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("    ,   '' AS MOT_FILE_TS_PORT_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_FILE_PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_FILE_PST_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,   '' AS F_LANE_CD" ).append("\n"); 
		query.append("    ,   '' AS F_CNTR_TP_CD" ).append("\n"); 
		query.append("    ,   '' AS F_CNTR_SZ_CD" ).append("\n"); 
		query.append("    ,   '' AS F_CMDT_TP_CD" ).append("\n"); 
		query.append("    ,   '' AS F_ORG_CD" ).append("\n"); 
		query.append("    ,   '' AS F_DEST_CD" ).append("\n"); 
		query.append("    ,   '' AS OEIC_AMT" ).append("\n"); 
		query.append("    ,   '' AS OSLF_AMT" ).append("\n"); 
		query.append("    ,   '' AS MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("    ,   '' AS MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("    ,   '' AS BUC_AMT " ).append("\n"); 
		query.append("    ,   '' AS EIC_AMT " ).append("\n"); 
		query.append("    ,   '' AS OSLF_AMT " ).append("\n"); 
		query.append("    ,   '' AS OOBS_AMT " ).append("\n"); 
		query.append("    ,   '' AS ODHF_AMT " ).append("\n"); 
		query.append("    ,   '' AS ODCS_AMT   " ).append("\n"); 
		query.append("    ,   '' AS DDTS_AMT " ).append("\n"); 
		query.append("    ,   '' AS OCMS_AMT " ).append("\n"); 
		query.append("    ,   '' AS DOCP_AMT " ).append("\n"); 
		query.append("    ,   '' AS OBS_AMT" ).append("\n"); 
		query.append("    ,   '' AS BCC_AMT" ).append("\n"); 
		query.append("    ,   '' AS BLR_AMT" ).append("\n"); 
		query.append("    ,   '' AS LBP_AMT" ).append("\n"); 
		query.append("    ,   '' AS CTC_AMT" ).append("\n"); 
		query.append("    ,   '' AS LSI_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}