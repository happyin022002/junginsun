/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusListSpecialCargoOutVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.02.19 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusListSpecialCargoOutVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusListSpecialCargoOutVO1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusListSpecialCargoOutVO1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusListSpecialCargoOutVO1RSQL").append("\n"); 
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
		query.append("/* StatusReportSpecialCargoOutVO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("' ' AS 	AKREP_CMDT" ).append("\n"); 
		query.append(", ' ' AS 	ANTY_NAME" ).append("\n"); 
		query.append(", ' ' AS 	AWK_CGO_FLG" ).append("\n"); 
		query.append(", ' ' AS 	BB_CGO_FLG" ).append("\n"); 
		query.append(", ' ' AS 	BB_CMDT" ).append("\n"); 
		query.append(", ' ' AS 	BDR_FLG" ).append("\n"); 
		query.append(", ' ' AS 	BKG_CLZ_FLG" ).append("\n"); 
		query.append(", ' ' AS 	BKG_CRE_DT" ).append("\n"); 
		query.append(", ' ' AS 	BKG_MEA_QTY" ).append("\n"); 
		query.append(", ' ' AS 	BKG_NO" ).append("\n"); 
		query.append(", ' ' AS 	BKG_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS 	BKG_STF" ).append("\n"); 
		query.append(", ' ' AS 	BL_NO" ).append("\n"); 
		query.append(", ' ' AS 	BST_FLG" ).append("\n"); 
		query.append(", ' ' AS 	CDO_TEMP" ).append("\n"); 
		query.append(", ' ' AS 	CMDT_CD" ).append("\n"); 
		query.append(", ' ' AS 	CNTR_NO" ).append("\n"); 
		query.append(", ' ' AS 	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", ' ' AS 	CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(", ' ' AS 	COMMODITY" ).append("\n"); 
		query.append(", ' ' AS 	CONSIGNEE" ).append("\n"); 
		query.append(", ' ' AS 	CONSIGNEE_NAME" ).append("\n"); 
		query.append(", ' ' AS 	CTRL_ATMS_FLG" ).append("\n"); 
		query.append(", ' ' AS 	CUST_TO_ORD_FLG" ).append("\n"); 
		query.append(", ' ' AS 	DCGO_FLG" ).append("\n"); 
		query.append(", ' ' AS 	DEST_SVC_ROUTE" ).append("\n"); 
		query.append(", ' ' AS 	DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(", ' ' AS 	DE_TERM_CD" ).append("\n"); 
		query.append(", ' ' AS 	DG_CNTR_SEQ" ).append("\n"); 
		query.append(", ' ' AS 	DIM_HGT" ).append("\n"); 
		query.append(", ' ' AS 	DIM_LEN" ).append("\n"); 
		query.append(", ' ' AS 	DIM_WDT" ).append("\n"); 
		query.append(", ' ' AS 	EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(", ' ' AS 	EQ_SUBST_FLG" ).append("\n"); 
		query.append(", ' ' AS 	EXPT_NAME" ).append("\n"); 
		query.append(", ' ' AS 	FDO_TEMP" ).append("\n"); 
		query.append(", ' ' AS 	FFDR" ).append("\n"); 
		query.append(", ' ' AS 	FFDR_NAME" ).append("\n"); 
		query.append(", ' ' AS 	FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(", ' ' AS 	GRS_WGT" ).append("\n"); 
		query.append(", ' ' AS 	HNGR_FLG" ).append("\n"); 
		query.append(", ' ' AS 	HOT_DE_FLG" ).append("\n"); 
		query.append(", ' ' AS 	HUMID_CTRL_FLG" ).append("\n"); 
		query.append(", ' ' AS 	HUMID_NO" ).append("\n"); 
		query.append(", ' ' AS 	IMDG_CLSS_CD" ).append("\n"); 
		query.append(", ' ' AS 	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(", ' ' AS 	IMDG_UN_NO" ).append("\n"); 
		query.append(", ' ' AS 	MEAS_QTY" ).append("\n"); 
		query.append(", ' ' AS 	MODI_ATMS_FLG" ).append("\n"); 
		query.append(", ' ' AS 	NET_WGT" ).append("\n"); 
		query.append(", ' ' AS 	NTFY" ).append("\n"); 
		query.append(", ' ' AS 	NTFY_NAME" ).append("\n"); 
		query.append(", ' ' AS 	OB_SLS_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS 	OB_SREP_CD" ).append("\n"); 
		query.append(", ' ' AS 	ORG_SVC_ROUTE" ).append("\n"); 
		query.append(", ' ' AS 	ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(", ' ' AS 	OVR_BKWD_LEN" ).append("\n"); 
		query.append(", ' ' AS 	OVR_FWRD_LEN" ).append("\n"); 
		query.append(", ' ' AS 	OVR_HGT" ).append("\n"); 
		query.append(", ' ' AS 	OVR_LF_LEN" ).append("\n"); 
		query.append(", ' ' AS 	OVR_RT_LEN" ).append("\n"); 
		query.append(", ' ' AS 	OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append(", ' ' AS 	PCK_QTY" ).append("\n"); 
		query.append(", ' ' AS 	PCK_TP_CD" ).append("\n"); 
		query.append(", ' ' AS 	PKG" ).append("\n"); 
		query.append(", ' ' AS 	POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_1_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_1_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_1_VVD" ).append("\n"); 
		query.append(", ' ' AS 	POST_2_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_2_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_2_VVD" ).append("\n"); 
		query.append(", ' ' AS 	POST_3_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_3_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_3_VVD" ).append("\n"); 
		query.append(", ' ' AS 	POST_4_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_4_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	POST_4_VVD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_1_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_1_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_1_VVD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_2_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_2_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_2_VVD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_3_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_3_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_3_VVD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_4_POD_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_4_POL_CD" ).append("\n"); 
		query.append(", ' ' AS 	PRE_4_VVD" ).append("\n"); 
		query.append(", ' ' AS 	PRP_SHP_NM" ).append("\n"); 
		query.append(", ' ' AS 	PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(", ' ' AS 	RCV_TERM_CD" ).append("\n"); 
		query.append(", ' ' AS 	RC_FLG" ).append("\n"); 
		query.append(", ' ' AS 	RD_CGO_FLG" ).append("\n"); 
		query.append(", ' ' AS 	REMARK" ).append("\n"); 
		query.append(", ' ' AS 	REMARK_DETAIL" ).append("\n"); 
		query.append(", ' ' AS 	REP" ).append("\n"); 
		query.append(", ' ' AS 	RF_CMDT" ).append("\n"); 
		query.append(", ' ' AS 	SHIPPER" ).append("\n"); 
		query.append(", ' ' AS 	SHPR_NAME" ).append("\n"); 
		query.append(", ' ' AS 	SI_FLG" ).append("\n"); 
		query.append(", ' ' AS 	SLAN_CD" ).append("\n"); 
		query.append(", ' ' AS 	SOC_FLG" ).append("\n"); 
		query.append(", ' ' AS 	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(", ' ' AS 	SPCL_CGO_AUTH_KNT" ).append("\n"); 
		query.append(", ' ' AS 	SPLIT_FLG" ).append("\n"); 
		query.append(", ' ' AS 	TRUNK_VVD" ).append("\n"); 
		query.append(", ' ' AS 	VLTG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' PCK_QTY" ).append("\n"); 
		query.append(", '' ORDERBY_TITLE_SQL" ).append("\n"); 
		query.append(", '' ORDERBY_TITLE" ).append("\n"); 
		query.append(", '' TOTAL_CNT" ).append("\n"); 
		query.append(", '' ORDERBY_CNT" ).append("\n"); 
		query.append(", '' LAST_ORDERBY" ).append("\n"); 
		query.append(", '' ORDERBY" ).append("\n"); 
		query.append(", '' ROWS_PER_PAGE" ).append("\n"); 
		query.append(", '' CURR_PAGE" ).append("\n"); 
		query.append(", '' RNUM" ).append("\n"); 
		query.append(", '' CONTACT" ).append("\n"); 
		query.append(", '' TEL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' total_bkg" ).append("\n"); 
		query.append(", ' ' total_bl" ).append("\n"); 
		query.append(", ' ' total_teu" ).append("\n"); 
		query.append(", ' ' total_feu" ).append("\n"); 
		query.append(", ' ' total_wgt" ).append("\n"); 
		query.append(", ' ' total_mea" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_D2" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_Q4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_D4" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_R2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_D5" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_R4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_D7" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_R5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_F2" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_T2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_F4" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_T4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_F5" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_P2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_O2" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_P4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_O4" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_Z4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_Q2" ).append("\n"); 
		query.append(", ' ' RD_TOTAL_Z2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS D2" ).append("\n"); 
		query.append(", ' ' AS Q4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS D4" ).append("\n"); 
		query.append(", ' ' AS R2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS D5" ).append("\n"); 
		query.append(", ' ' AS R4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS D7" ).append("\n"); 
		query.append(", ' ' AS R5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS F2" ).append("\n"); 
		query.append(", ' ' AS T2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS F4" ).append("\n"); 
		query.append(", ' ' AS T4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS F5" ).append("\n"); 
		query.append(", ' ' AS P2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS O2" ).append("\n"); 
		query.append(", ' ' AS P4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS O4" ).append("\n"); 
		query.append(", ' ' AS Z4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS Q2" ).append("\n"); 
		query.append(", ' ' AS Z2" ).append("\n"); 
		query.append(", ' ' AS TEU" ).append("\n"); 
		query.append(", ' ' AS FEU" ).append("\n"); 
		query.append(", ' ' AS BKG_CNT" ).append("\n"); 
		query.append(", ' ' AS BL_CNT" ).append("\n"); 
		query.append(", ' ' NO" ).append("\n"); 
		query.append(", ' ' ROW_SEQ" ).append("\n"); 
		query.append(", ' ' CNTR_VOL_QTY" ).append("\n"); 
		query.append(", ' ' STOWAGE" ).append("\n"); 
		query.append(", ' ' CGO_SEQ" ).append("\n"); 
		query.append(", ' ' DG_CMDT" ).append("\n"); 
		query.append(", COUNT(1) OVER() TOTAL_CNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}