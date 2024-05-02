/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACommAgreementDBDAOSearchFACAgreementDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.01.06 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACommAgreementDBDAOSearchFACAgreementDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFACAgreementDup
	  * </pre>
	  */
	public FACommAgreementDBDAOSearchFACAgreementDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_sgl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("all_in_rt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_dbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.facommagreement.integration").append("\n"); 
		query.append("FileName : FACommAgreementDBDAOSearchFACAgreementDupRSQL").append("\n"); 
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
		query.append("SELECT FRT_CNT_SEQ ," ).append("\n"); 
		query.append("  SHPR_CNT_SEQ ," ).append("\n"); 
		query.append("  POR_GRP_TP_CD ," ).append("\n"); 
		query.append("  POR_ROUT_CD ," ).append("\n"); 
		query.append("  POL_GRP_TP_CD ," ).append("\n"); 
		query.append("  POL_ROUT_CD ," ).append("\n"); 
		query.append("  POD_GRP_TP_CD ," ).append("\n"); 
		query.append("  POD_ROUT_CD ," ).append("\n"); 
		query.append("  DEL_GRP_TP_CD ," ).append("\n"); 
		query.append("  DEL_ROUT_CD ," ).append("\n"); 
		query.append("  BKG_RCV_TERM_CD ," ).append("\n"); 
		query.append("  BKG_DE_TERM_CD ," ).append("\n"); 
		query.append("  FAC_SGL_FLG ," ).append("\n"); 
		query.append("  FAC_DBL_FLG ," ).append("\n"); 
		query.append("  ALL_IN_RT_CD ," ).append("\n"); 
		query.append("  SVC_SCP_CD ," ).append("\n"); 
		query.append("  FM_EFF_DT ," ).append("\n"); 
		query.append("  TO_EFF_DT ," ).append("\n"); 
		query.append("  SC_NO ," ).append("\n"); 
		query.append("  RFA_NO ," ).append("\n"); 
		query.append("  CMDT_TP_CD ," ).append("\n"); 
		query.append("  CMDT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.FF_CNT_CD||TO_CHAR(A.FF_SEQ, 'FM000000') AS FRT_CNT_SEQ," ).append("\n"); 
		query.append("      DECODE( TO_CHAR(A.FF_SEQ, 'FM000000'), '999999', 'REP. CUSTOMER', NVL(REPLACE(REPLACE(B.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' '), ' ')) AS FF_LGL_ENG_NM," ).append("\n"); 
		query.append("      NVL(DECODE(A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000'), '*000000', '*', A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000')), '*') AS SHPR_CNT_SEQ," ).append("\n"); 
		query.append("      NVL(REPLACE(REPLACE(C.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' '), ' ') AS SHPR_LGL_ENG_NM," ).append("\n"); 
		query.append("      NVL(A.POR_GRP_TP_CD, '*') AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("      NVL(A.POR_ROUT_CD, '*') AS POR_ROUT_CD," ).append("\n"); 
		query.append("      NVL(A.POL_GRP_TP_CD, '*') AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("      NVL(A.POL_ROUT_CD, '*') AS POL_ROUT_CD," ).append("\n"); 
		query.append("      NVL(A.POD_GRP_TP_CD, '*') AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("      NVL(A.POD_ROUT_CD, '*') AS POD_ROUT_CD," ).append("\n"); 
		query.append("      NVL(A.DEL_GRP_TP_CD, '*') AS DEL_GRP_TP_CD," ).append("\n"); 
		query.append("      NVL(A.DEL_ROUT_CD, '*') AS DEL_ROUT_CD," ).append("\n"); 
		query.append("      NVL(A.BKG_RCV_TERM_CD, '*') AS BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("      NVL(a.bkg_de_term_cd, '*') AS BKG_DE_TERM_CD," ).append("\n"); 
		query.append("      NVL(a.fac_sgl_flg, '*') AS FAC_SGL_FLG," ).append("\n"); 
		query.append("      NVL(A.FAC_DBL_FLG, '*') AS FAC_DBL_FLG," ).append("\n"); 
		query.append("      A.ALL_IN_RT_CD," ).append("\n"); 
		query.append("      NVL(A.SVC_SCP_CD, '*') AS SVC_SCP_CD," ).append("\n"); 
		query.append("      NVL(A.FM_EFF_DT, '20000101') AS FM_EFF_DT," ).append("\n"); 
		query.append("      NVL(A.TO_EFF_DT, '29990101') AS TO_EFF_DT," ).append("\n"); 
		query.append("      NVL(A.SC_NO, '*') AS SC_NO," ).append("\n"); 
		query.append("      NVL(A.RFA_NO, '*') AS RFA_NO," ).append("\n"); 
		query.append("      NVL(A.CMDT_TP_CD, '*') AS CMDT_TP_CD," ).append("\n"); 
		query.append("      NVL(A.CMDT_CD, '*') AS CMDT_CD," ).append("\n"); 
		query.append("      DECODE(A.CMDT_TP_CD, '2', E.REP_CMDT_NM, '3', F.CMDT_NM) AS CMDT_NM," ).append("\n"); 
		query.append("      NVL(A.FAC_DIV_CD, ' ') AS FAC_DIV_CD," ).append("\n"); 
		query.append("      DECODE (A.FAC_DIV_CD, 'BL', 0, NVL(A.FAC_BKG_RT, 0)) AS BKG_FAC_RT," ).append("\n"); 
		query.append("      NVL(A.FAC_SPCL_CNTR_TP_CTNT1, ' ') AS FAC_SPCL_CNTR_TP_CTNT1," ).append("\n"); 
		query.append("      NVL(A.FAC_SPCL_CNTR_RT1, 0) AS FAC_SPCL_CNTR_RT1," ).append("\n"); 
		query.append("      NVL(A.FAC_SPCL_CNTR_TP_CTNT2, ' ') AS FAC_SPCL_CNTR_TP_CTNT2," ).append("\n"); 
		query.append("      NVL(A.FAC_SPCL_CNTR_RT2, 0) AS FAC_SPCL_CNTR_RT2," ).append("\n"); 
		query.append("      NVL(A.CURR_CD, 'USD') AS CURR_CD," ).append("\n"); 
		query.append("      DECODE (A.FAC_DIV_CD, 'BL', NVL(A.FAC_BKG_RT, 0), 0) AS BKG_FAC_BL_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_BX_AMT, 0) AS FAC_BX_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_TEU_AMT, 0) AS FAC_TEU_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_FEU_AMT, 0) AS FAC_FEU_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_RF_TEU_AMT, 0) AS FAC_RF_TEU_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_RF_FEU_AMT, 0) AS FAC_RF_FEU_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_SPCL_TEU_AMT, 0) AS FAC_SPCL_TEU_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_SPCL_FEU_AMT, 0) AS FAC_SPCL_FEU_AMT," ).append("\n"); 
		query.append("      NVL(A.FAC_CHG_CTNT, ' ') AS FAC_CHG_CTNT," ).append("\n"); 
		query.append("      NVL(A.FAC_STS_CD, 'RN') AS FAC_STS_CD," ).append("\n"); 
		query.append("      A.FAC_RQST_USR_ID," ).append("\n"); 
		query.append("      A.FAC_APRO_USR_ID," ).append("\n"); 
		query.append("      TO_CHAR(A.FAC_APRO_DT, 'yyyyMMdd') AS FAC_APRO_DT," ).append("\n"); 
		query.append("      A.FAC_RMK," ).append("\n"); 
		query.append("      A.FAC_AGMT_SEQ," ).append("\n"); 
		query.append("      A.FAC_OFC_CD," ).append("\n"); 
		query.append("      A.FAC_RQST_USR_EML," ).append("\n"); 
		query.append("      A.FAC_APRO_USR_EML," ).append("\n"); 
		query.append("      G.USR_NM FAC_RQST_USR_NAME," ).append("\n"); 
		query.append("      A.CRE_USR_ID," ).append("\n"); 
		query.append("      TO_CHAR(A.CRE_DT, 'yyyyMMddHH24miss') AS CRE_DT," ).append("\n"); 
		query.append("      A.UPD_USR_ID," ).append("\n"); 
		query.append("      TO_CHAR(A.UPD_DT, 'yyyyMMddHH24miss') AS UPD_DT" ).append("\n"); 
		query.append("    FROM ACM_FAC_AGMT A," ).append("\n"); 
		query.append("      MDM_CUSTOMER B," ).append("\n"); 
		query.append("      MDM_CUSTOMER C," ).append("\n"); 
		query.append("      MDM_REP_CMDT E," ).append("\n"); 
		query.append("      MDM_COMMODITY F," ).append("\n"); 
		query.append("      COM_USER G" ).append("\n"); 
		query.append("    WHERE A.FAC_OFC_CD = @[fac_ofc_cd]" ).append("\n"); 
		query.append("      AND A.FF_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("      AND A.FF_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("      AND A.SHPR_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("      AND A.SHPR_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("      AND A.CMDT_CD = E.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("      AND A.CMDT_CD = F.CMDT_CD(+)" ).append("\n"); 
		query.append("      AND A.FAC_RQST_USR_ID = G.USR_ID(+) )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND FRT_CNT_SEQ = @[frt_cnt_seq]" ).append("\n"); 
		query.append("  AND SHPR_CNT_SEQ = @[shpr_cnt_seq]" ).append("\n"); 
		query.append("  AND POR_GRP_TP_CD = @[por_grp_tp_cd]" ).append("\n"); 
		query.append("  AND POR_ROUT_CD = @[por_rout_cd]" ).append("\n"); 
		query.append("  AND POL_GRP_TP_CD = @[pol_grp_tp_cd]" ).append("\n"); 
		query.append("  AND POL_ROUT_CD = @[pol_rout_cd]" ).append("\n"); 
		query.append("  AND POD_GRP_TP_CD = @[pod_grp_tp_cd]" ).append("\n"); 
		query.append("  AND POD_ROUT_CD = @[pod_rout_cd]" ).append("\n"); 
		query.append("  AND DEL_GRP_TP_CD = @[del_grp_tp_cd]" ).append("\n"); 
		query.append("  AND DEL_ROUT_CD = @[del_rout_cd]" ).append("\n"); 
		query.append("  AND BKG_RCV_TERM_CD = @[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("  AND BKG_DE_TERM_CD = @[bkg_de_term_cd]" ).append("\n"); 
		query.append(" #if (${fac_sgl_flg} != '')" ).append("\n"); 
		query.append("  AND FAC_SGL_FLG = @[fac_sgl_flg]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${fac_dbl_flg} != '')" ).append("\n"); 
		query.append("  AND FAC_DBL_FLG = @[fac_dbl_flg]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${all_in_rt_cd} != '')" ).append("\n"); 
		query.append("  AND ALL_IN_RT_CD = @[all_in_rt_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("  AND FM_EFF_DT = @[fm_eff_dt]" ).append("\n"); 
		query.append("  AND TO_EFF_DT = @[to_eff_dt]" ).append("\n"); 
		query.append("  AND SC_NO = @[sc_no]" ).append("\n"); 
		query.append("  AND RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("  AND CMDT_TP_CD = @[cmdt_tp_cd]" ).append("\n"); 
		query.append("  AND CMDT_CD = @[cmdt_cd]" ).append("\n"); 

	}
}