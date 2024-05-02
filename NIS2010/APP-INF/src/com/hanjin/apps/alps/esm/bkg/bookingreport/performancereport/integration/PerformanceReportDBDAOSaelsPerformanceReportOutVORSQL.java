/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOSaelsPerformanceReportOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.04.19 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSaelsPerformanceReportOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOSaelsPerformanceReportOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSaelsPerformanceReportOutVORSQL").append("\n"); 
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
		query.append("/* SaelsPerformanceReportOut VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' VVD" ).append("\n"); 
		query.append(",'' BKG_POD" ).append("\n"); 
		query.append(",'' SLAN_CD" ).append("\n"); 
		query.append(",'' POR_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' TEU" ).append("\n"); 
		query.append(",'' FEU" ).append("\n"); 
		query.append(",'' VOID_TEU" ).append("\n"); 
		query.append(",'' VOID_FEU" ).append("\n"); 
		query.append(",'' TTL" ).append("\n"); 
		query.append(",'' GROSS" ).append("\n"); 
		query.append(",'' NET" ).append("\n"); 
		query.append(",'' NON_NET" ).append("\n"); 
		query.append(",'' MISC" ).append("\n"); 
		query.append(",'' NON_REV" ).append("\n"); 
		query.append(",'' TEU_GROSS" ).append("\n"); 
		query.append(",'' FEU_GROSS" ).append("\n"); 
		query.append(",'' REP_KND" ).append("\n"); 
		query.append(",'' GRP_BY" ).append("\n"); 
		query.append(",'' VOID_RPB" ).append("\n"); 
		query.append(",'' EQ_RPB" ).append("\n"); 
		query.append(",'' VOID_SLOT" ).append("\n"); 
		query.append(",'' OFT" ).append("\n"); 
		query.append(",'' BAF" ).append("\n"); 
		query.append(",'' CAF" ).append("\n"); 
		query.append(",'' OTH" ).append("\n"); 
		query.append(",'' DTH" ).append("\n"); 
		query.append(",'' DOC" ).append("\n"); 
		query.append(",'' TAC" ).append("\n"); 
		query.append(",'' R_OTHER" ).append("\n"); 
		query.append(",'' D2" ).append("\n"); 
		query.append(",'' D4" ).append("\n"); 
		query.append(",'' D5" ).append("\n"); 
		query.append(",'' R2" ).append("\n"); 
		query.append(",'' R4" ).append("\n"); 
		query.append(",'' S2" ).append("\n"); 
		query.append(",'' S4" ).append("\n"); 
		query.append(",'' RD2" ).append("\n"); 
		query.append(",'' RD4" ).append("\n"); 
		query.append(",'' SLS_RHQ_CD" ).append("\n"); 
		query.append(",'' SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(",'' OB_SLS_OFC_CD" ).append("\n"); 
		query.append(",'' RGN_CNT" ).append("\n"); 
		query.append(",'' OFC_CNT" ).append("\n"); 
		query.append(",'' REP_CMDT_CD" ).append("\n"); 
		query.append(",'' REP_CMDT_NM" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",'' CUST_NM" ).append("\n"); 
		query.append(",'' CUST_GRP_ID" ).append("\n"); 
		query.append(",'' OB_SREP_CD" ).append("\n"); 
		query.append(",'' OB_SREP_NM" ).append("\n"); 
		query.append(",'' EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS sub_tot_teu" ).append("\n"); 
		query.append(", ' ' AS sub_tot_feu" ).append("\n"); 
		query.append(", ' ' AS sub_tot_ttl" ).append("\n"); 
		query.append(", ' ' AS sub_tot_void_teu" ).append("\n"); 
		query.append(", ' ' AS sub_tot_void_feu" ).append("\n"); 
		query.append(", ' ' AS sub_tot_gross" ).append("\n"); 
		query.append(", ' ' AS sub_tot_net" ).append("\n"); 
		query.append(", ' ' AS sub_tot_non_net" ).append("\n"); 
		query.append(", ' ' AS sub_tot_misc" ).append("\n"); 
		query.append(", ' ' AS sub_tot_non_rev" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS sub_tot_oth" ).append("\n"); 
		query.append(", ' ' AS sub_tot_20" ).append("\n"); 
		query.append(", ' ' AS sub_tot_40" ).append("\n"); 
		query.append(", ' ' AS sub_tot_slo" ).append("\n"); 
		query.append(", ' ' AS sub_tot_oft" ).append("\n"); 
		query.append(", ' ' AS sub_tot_baf" ).append("\n"); 
		query.append(", ' ' AS sub_tot_caf" ).append("\n"); 
		query.append(", ' ' AS sub_tot_dth" ).append("\n"); 
		query.append(", ' ' AS sub_tot_doc" ).append("\n"); 
		query.append(", ' ' AS sub_tot_tac" ).append("\n"); 
		query.append(", ' ' AS sub_tot_rth" ).append("\n"); 
		query.append(", ' ' AS sub_tot_d2" ).append("\n"); 
		query.append(", ' ' AS sub_tot_d4" ).append("\n"); 
		query.append(", ' ' AS sub_tot_d5" ).append("\n"); 
		query.append(", ' ' AS sub_tot_r2" ).append("\n"); 
		query.append(", ' ' AS sub_tot_r4" ).append("\n"); 
		query.append(", ' ' AS sub_tot_s2" ).append("\n"); 
		query.append(", ' ' AS sub_tot_s4" ).append("\n"); 
		query.append(", ' ' AS sub_tot_rd2" ).append("\n"); 
		query.append(", ' ' AS sub_tot_rd4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS tot_teu" ).append("\n"); 
		query.append(", ' ' AS tot_feu" ).append("\n"); 
		query.append(", ' ' AS tot_ttl" ).append("\n"); 
		query.append(", ' ' AS tot_void_teu" ).append("\n"); 
		query.append(", ' ' AS tot_void_feu" ).append("\n"); 
		query.append(", ' ' AS tot_gross" ).append("\n"); 
		query.append(", ' ' AS tot_net" ).append("\n"); 
		query.append(", ' ' AS tot_non_net" ).append("\n"); 
		query.append(", ' ' AS tot_misc" ).append("\n"); 
		query.append(", ' ' AS tot_non_rev" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS tot_oth" ).append("\n"); 
		query.append(", ' ' AS tot_20" ).append("\n"); 
		query.append(", ' ' AS tot_40" ).append("\n"); 
		query.append(", ' ' AS tot_slo" ).append("\n"); 
		query.append(", ' ' AS tot_oft" ).append("\n"); 
		query.append(", ' ' AS tot_baf" ).append("\n"); 
		query.append(", ' ' AS tot_caf" ).append("\n"); 
		query.append(", ' ' AS tot_dth" ).append("\n"); 
		query.append(", ' ' AS tot_doc" ).append("\n"); 
		query.append(", ' ' AS tot_tac" ).append("\n"); 
		query.append(", ' ' AS tot_rth" ).append("\n"); 
		query.append(", ' ' AS tot_d2" ).append("\n"); 
		query.append(", ' ' AS tot_d4" ).append("\n"); 
		query.append(", ' ' AS tot_d5" ).append("\n"); 
		query.append(", ' ' AS tot_r2" ).append("\n"); 
		query.append(", ' ' AS tot_r4" ).append("\n"); 
		query.append(", ' ' AS tot_s2" ).append("\n"); 
		query.append(", ' ' AS tot_s4" ).append("\n"); 
		query.append(", ' ' AS tot_rd2" ).append("\n"); 
		query.append(", ' ' AS tot_rd4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS BKG_NO" ).append("\n"); 
		query.append(", ' ' AS BL_NO" ).append("\n"); 
		query.append(", ' ' AS SLS_YRMON" ).append("\n"); 
		query.append(", ' ' AS SLS_WK" ).append("\n"); 
		query.append(", ' ' AS IO" ).append("\n"); 
		query.append(", ' ' AS TEU_TTL" ).append("\n"); 
		query.append(", ' ' AS TOT_SUM" ).append("\n"); 
		query.append(", ' ' AS RPB" ).append("\n"); 
		query.append(", ' ' AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", ' ' AS F2" ).append("\n"); 
		query.append(", ' ' AS F4" ).append("\n"); 
		query.append(", ' ' AS O2" ).append("\n"); 
		query.append(", ' ' AS O4" ).append("\n"); 
		query.append(", ' ' AS P2" ).append("\n"); 
		query.append(", ' ' AS P4" ).append("\n"); 
		query.append(", ' ' AS T2" ).append("\n"); 
		query.append(", ' ' AS T4" ).append("\n"); 
		query.append(", ' ' AS Q2" ).append("\n"); 
		query.append(", ' ' AS Q4" ).append("\n"); 
		query.append(",	' ' AS REV_D2" ).append("\n"); 
		query.append(",	' ' AS REV_D4" ).append("\n"); 
		query.append(",	' ' AS REV_R2" ).append("\n"); 
		query.append(",	' ' AS REV_R4" ).append("\n"); 
		query.append(",	' ' AS REV_RD2" ).append("\n"); 
		query.append(",	' ' AS REV_RD4" ).append("\n"); 
		query.append(",	' ' AS REV_F2" ).append("\n"); 
		query.append(",	' ' AS REV_F4" ).append("\n"); 
		query.append(",	' ' AS REV_O2" ).append("\n"); 
		query.append(",	' ' AS REV_O4" ).append("\n"); 
		query.append(",	' ' AS REV_P2" ).append("\n"); 
		query.append(",	' ' AS REV_P4" ).append("\n"); 
		query.append(",	' ' AS REV_T2" ).append("\n"); 
		query.append(",	' ' AS REV_T4" ).append("\n"); 
		query.append(",	' ' AS REV_Q2" ).append("\n"); 
		query.append(",	' ' AS REV_Q4" ).append("\n"); 
		query.append(",   ' ' AS BOX" ).append("\n"); 
		query.append(",   ' ' AS FRT_TERM_CD" ).append("\n"); 
		query.append(",   ' ' AS FIRST_VVD" ).append("\n"); 
		query.append(",   ' ' AS BL_OBRD_DT" ).append("\n"); 
		query.append(",   ' ' AS BL_OBRD_WK" ).append("\n"); 
		query.append(",   ' ' AS IBS_OFC_NT" ).append("\n"); 
		query.append(",   ' ' AS IB_SLS_OFC_CD" ).append("\n"); 
		query.append(",   ' ' AS ORG_SVC" ).append("\n"); 
		query.append(",   ' ' AS DST_SVC" ).append("\n"); 
		query.append(",	' ' AS CNNF_CD" ).append("\n"); 
		query.append(",   ' ' AS CNNF_NM" ).append("\n"); 
		query.append(",   ' ' AS REP_CUST_CD" ).append("\n"); 
		query.append(",   ' ' AS REP_ACCT_NM" ).append("\n"); 
		query.append(",   ' ' AS RHQ" ).append("\n"); 
		query.append(",   ' ' AS GSO" ).append("\n"); 
		query.append(",   ' ' AS REV_DIR_CD" ).append("\n"); 
		query.append(",   ' ' AS RFA_NO" ).append("\n"); 
		query.append(",   ' ' AS SC_NO" ).append("\n"); 
		query.append(",	' ' AS CTRT_OFC_CD" ).append("\n"); 
		query.append(",	' ' AS CTRT_SREP_CD" ).append("\n"); 
		query.append(",   ' ' AS BKG_OFC_CD" ).append("\n"); 
		query.append(",   ' ' AS IB_WK_POD_CD" ).append("\n"); 
		query.append(",   ' ' AS IB_WK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}