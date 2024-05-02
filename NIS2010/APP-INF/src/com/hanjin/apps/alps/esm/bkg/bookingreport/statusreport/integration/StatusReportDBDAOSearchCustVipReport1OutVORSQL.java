/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchCustVipReport1OutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchCustVipReport1OutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchCustVipReport1OutVORSQL
	  * 2010.09.10 김영철 [ ] VIP REPORT 부분 오류 수정 ( 반영일 : 2010.09.24 )
	  * </pre>
	  */
	public StatusReportDBDAOSearchCustVipReport1OutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchCustVipReport1OutVORSQL").append("\n"); 
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
		query.append("/* CustVipReportOut VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'CGO_RCV_DT' CGO_RCV_DT" ).append("\n"); 
		query.append(", 'BDR_FLG' BDR_FLG" ).append("\n"); 
		query.append(", 'DUE_DATE' DUE_DATE" ).append("\n"); 
		query.append(", 'OVERDUE' OVERDUE" ).append("\n"); 
		query.append(", 'RMK' RMK" ).append("\n"); 
		query.append(", 'ATD' ATD" ).append("\n"); 
		query.append(", 'ATA' ATA" ).append("\n"); 
		query.append(", 'ATD_T' ATD_T" ).append("\n"); 
		query.append(", 'ATA_T' ATA_T" ).append("\n"); 
		query.append(", 'G_CUST_SHPR' G_CUST_SHPR" ).append("\n"); 
		query.append(", 'G_CUST_CNEE' G_CUST_CNEE" ).append("\n"); 
		query.append(", 'IT_NO' IT_NO" ).append("\n"); 
		query.append(", 'SCAC' SCAC" ).append("\n"); 
		query.append(", 'CNTR_OC_DATE' CNTR_OC_DATE" ).append("\n"); 
		query.append(", 'PPD_CHARGE' PPD_CHARGE" ).append("\n"); 
		query.append(", 'CCT_CHARGE' CCT_CHARGE" ).append("\n"); 
		query.append(", 'ACT_WGT' ACT_WGT" ).append("\n"); 
		query.append(", 'CNTR_WGT' CNTR_WGT" ).append("\n"); 
		query.append(", 'MEAS_QTY' MEAS_QTY" ).append("\n"); 
		query.append(", 'PCK_QTY' PCK_QTY" ).append("\n"); 
		query.append(", 'CHG_AMT' CHG_AMT" ).append("\n"); 
		query.append(", 'PCT_QTY' PCT_QTY" ).append("\n"); 
		query.append(", 'BKG_NO' BKG_NO" ).append("\n"); 
		query.append(", 'BKG_OFC_CD' BKG_OFC_CD" ).append("\n"); 
		query.append(", 'BL_NO' BL_NO" ).append("\n"); 
		query.append(", 'POR_CD' POR_CD" ).append("\n"); 
		query.append(", 'POL_CD' POL_CD" ).append("\n"); 
		query.append(", 'BL_ISS_OFC' BL_ISS_OFC" ).append("\n"); 
		query.append(", 'SHPR_CODE' SHPR_CODE" ).append("\n"); 
		query.append(", 'POL_ETD' POL_ETD" ).append("\n"); 
		query.append(", 'CNEE_CODE' CNEE_CODE" ).append("\n"); 
		query.append(", 'SHPR_NAME' SHPR_NAME" ).append("\n"); 
		query.append(", 'CNEE_NAME' CNEE_NAME" ).append("\n"); 
		query.append(", 'POD_ETA' POD_ETA" ).append("\n"); 
		query.append(", 'CCT_OFC' CCT_OFC" ).append("\n"); 
		query.append(", 'REP_CMDT' REP_CMDT" ).append("\n"); 
		query.append(", 'CUSTOMS_RLS_DT' CUSTOMS_RLS_DT" ).append("\n"); 
		query.append(", 'BL_PO_NO' BL_PO_NO" ).append("\n"); 
		query.append(", 'CUST_REF_NO' CUST_REF_NO" ).append("\n"); 
		query.append(", 'EXPORT_REF_NO' EXPORT_REF_NO" ).append("\n"); 
		query.append(", 'CNTR_NO' CNTR_NO" ).append("\n"); 
		query.append(", 'PPD_OFC' PPD_OFC" ).append("\n"); 
		query.append(", 'POD_CD' POD_CD" ).append("\n"); 
		query.append(", 'DEL_CD' DEL_CD" ).append("\n"); 
		query.append(", 'SC_NO' SC_NO" ).append("\n"); 
		query.append(", 'RCV_TERM_CD' RCV_TERM_CD" ).append("\n"); 
		query.append(", 'DE_TERM_CD' DE_TERM_CD" ).append("\n"); 
		query.append(", 'LANE_CD' LANE_CD" ).append("\n"); 
		query.append(", 'OBL_ISS_DT' OBL_ISS_DT" ).append("\n"); 
		query.append(", 'BL_OBRD_DT' BL_OBRD_DT" ).append("\n"); 
		query.append(", 'VSL_ENG_NM' VSL_ENG_NM" ).append("\n"); 
		query.append(", 'POR_NM' POR_NM" ).append("\n"); 
		query.append(", 'POL_NM' POL_NM" ).append("\n"); 
		query.append(", 'POD_NM' POD_NM" ).append("\n"); 
		query.append(", 'DEL_NM' DEL_NM" ).append("\n"); 
		query.append(", 'MEAS_UT_CD' MEAS_UT_CD" ).append("\n"); 
		query.append(", 'WGT_UT_CD' WGT_UT_CD" ).append("\n"); 
		query.append(", 'SPC_CGO' SPC_CGO" ).append("\n"); 
		query.append(", 'POD_ATATIC_DT' POD_ATATIC_DT" ).append("\n"); 
		query.append(", 'CNTR_PO_NO' CNTR_PO_NO" ).append("\n"); 
		query.append(", 'PCK_TP_CD' PCK_TP_CD" ).append("\n"); 
		query.append(", 'CNTR_PRT_FLG' CNTR_PRT_FLG" ).append("\n"); 
		query.append(", 'CSTMS_DESC' CSTMS_DESC" ).append("\n"); 
		query.append(", 'NTFY_CODE' NTFY_CODE" ).append("\n"); 
		query.append(", 'NTFY_NAME' NTFY_NAME" ).append("\n"); 
		query.append(", 'FIRMS_CODE' FIRMS_CODE" ).append("\n"); 
		query.append(", 'TRUNK_VVD' TRUNK_VVD" ).append("\n"); 
		query.append(", 'PRE_RLY_PORT_CD' PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(", 'PST_RLY_PORT_CD' PST_RLY_PORT_CD" ).append("\n"); 
		query.append(", 'CMDT_CD' CMDT_CD" ).append("\n"); 
		query.append(", 'SCAC_CD' SCAC_CD" ).append("\n"); 
		query.append(", 'USA_CSTMS_FILE_CD' USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(", 'CND_CSTMS_FILE_CD' CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append(", 'CNTR_SEAL_NO' CNTR_SEAL_NO" ).append("\n"); 
		query.append(", 'POR_CNTY' POR_CNTY" ).append("\n"); 
		query.append(", 'DEL_CNTY' DEL_CNTY" ).append("\n"); 
		query.append(", 'AN_SEND_DT' AN_SEND_DT" ).append("\n"); 
		query.append(", 'DEL_STATE' DEL_STATE" ).append("\n"); 
		query.append(", 'IBD_TRSP_ISS_DT' IBD_TRSP_ISS_DT" ).append("\n"); 
		query.append(", 'HUB_LOC_CD' HUB_LOC_CD" ).append("\n"); 
		query.append(", 'FREE_DT' FREE_DT" ).append("\n"); 
		query.append(", 'PKUP_NO' PKUP_NO" ).append("\n"); 
		query.append(", 'PKUP_NOD_CD' PKUP_NOD_CD" ).append("\n"); 
		query.append(", 'AVAL_DT' AVAL_DT" ).append("\n"); 
		query.append(", 'DEL_ATA' DEL_ATA" ).append("\n"); 
		query.append(", 'DEL_DT' DEL_DT" ).append("\n"); 
		query.append(", 'POR_GATE_IN_DT' POR_GATE_IN_DT" ).append("\n"); 
		query.append(", 'CGO_STS_CD' CGO_STS_CD" ).append("\n"); 
		query.append(", 'DSPO_CD' DSPO_CD" ).append("\n"); 
		query.append(", 'FRT_CLT_FLG' FRT_CLT_FLG" ).append("\n"); 
		query.append(", 'OBL_RDEM_FLG' OBL_RDEM_FLG" ).append("\n"); 
		query.append(", 'CSTMS_CLR_CD' CSTMS_CLR_CD" ).append("\n"); 
		query.append(", 'F_POL_ETA' F_POL_ETA" ).append("\n"); 
		query.append(", 'F_POL_ETD' F_POL_ETD" ).append("\n"); 
		query.append(", 'F_POD_ETA' F_POD_ETA" ).append("\n"); 
		query.append(", 'F_POD_ETD' F_POD_ETD" ).append("\n"); 
		query.append(", 'T_POL_ETA' T_POL_ETA" ).append("\n"); 
		query.append(", 'T_POL_ETD' T_POL_ETD" ).append("\n"); 
		query.append(", 'T_POD_ETA' T_POD_ETA" ).append("\n"); 
		query.append(", 'T_POD_ETD' T_POD_ETD" ).append("\n"); 
		query.append(", 'EQ_CTRL_OFC' EQ_CTRL_OFC" ).append("\n"); 
		query.append(", 'MT_RETURN_DT' MT_RETURN_DT" ).append("\n"); 
		query.append(", 'DEL_ETA_DT' DEL_ETA_DT" ).append("\n"); 
		query.append(", 'CNTR_PCK_TP_CD' CNTR_PCK_TP_CD" ).append("\n"); 
		query.append(", 'CNTR_TPSZ_CD' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", 'CNTR_SIZE' CNTR_SIZE" ).append("\n"); 
		query.append(", 'CA_ITNO' CA_ITNO" ).append("\n"); 
		query.append(", 'CNRR_REF_NO' CNRR_REF_NO" ).append("\n"); 
		query.append(", 'TRUNK_VESSEL' TRUNK_VESSEL" ).append("\n"); 
		query.append(", 'TRUNK_VVD' TRUNK_VVD" ).append("\n"); 
		query.append(", 'TOTAL_CNT ' TOTAL_CNT" ).append("\n"); 
		query.append(", 'ROWS_PER_PAGE ' ROWS_PER_PAGE" ).append("\n"); 
		query.append(", 'CURR_PAGE' CURR_PAGE" ).append("\n"); 
		query.append(", 'RNUM' RNUM" ).append("\n"); 
		query.append(", 'CNTR_WGT_UT_CD' CNTR_WGT_UT_CD" ).append("\n"); 
		query.append(", 'CNTR_MEAS_UT_CD' CNTR_MEAS_UT_CD" ).append("\n"); 
		query.append(", 'TOT_MEAS' TOT_MEAS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}