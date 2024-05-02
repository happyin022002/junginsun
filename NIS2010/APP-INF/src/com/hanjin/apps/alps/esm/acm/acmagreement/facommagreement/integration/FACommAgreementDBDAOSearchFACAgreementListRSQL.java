/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementDBDAOSearchFACAgreementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.24 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACommAgreementDBDAOSearchFACAgreementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public FACommAgreementDBDAOSearchFACAgreementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.integration").append("\n"); 
		query.append("FileName : FACommAgreementDBDAOSearchFACAgreementListRSQL").append("\n"); 
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
		query.append("SELECT A.FF_CNT_CD||TO_CHAR(A.FF_SEQ, 'FM000000') AS FRT_CNT_SEQ," ).append("\n"); 
		query.append("       DECODE( TO_CHAR(A.FF_SEQ, 'FM000000'), '999999', 'REP. CUSTOMER', NVL(REPLACE(REPLACE(B.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' '), ' ')) AS FF_LGL_ENG_NM," ).append("\n"); 
		query.append("       NVL(DECODE(A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000'), '*000000', '*', A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000')), '*') AS SHPR_CNT_SEQ," ).append("\n"); 
		query.append("       NVL(REPLACE(REPLACE(C.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' '), ' ') AS SHPR_LGL_ENG_NM," ).append("\n"); 
		query.append("       NVL(A.POR_GRP_TP_CD, '*') AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("       NVL(A.POR_ROUT_CD, '*') AS POR_ROUT_CD," ).append("\n"); 
		query.append("       NVL(A.POL_GRP_TP_CD, '*') AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("       NVL(A.POL_ROUT_CD, '*') AS POL_ROUT_CD," ).append("\n"); 
		query.append("       NVL(A.POD_GRP_TP_CD, '*') AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("       NVL(A.POD_ROUT_CD, '*') AS POD_ROUT_CD," ).append("\n"); 
		query.append("       NVL(A.DEL_GRP_TP_CD, '*') AS DEL_GRP_TP_CD," ).append("\n"); 
		query.append("       NVL(A.DEL_ROUT_CD, '*') AS DEL_ROUT_CD," ).append("\n"); 
		query.append("       NVL(A.BKG_RCV_TERM_CD, '*') AS BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("       NVL(a.bkg_de_term_cd, '*') AS BKG_DE_TERM_CD," ).append("\n"); 
		query.append("       NVL(a.fac_sgl_flg, '*') AS FAC_SGL_FLG," ).append("\n"); 
		query.append("       NVL(A.FAC_DBL_FLG, '*') AS FAC_DBL_FLG," ).append("\n"); 
		query.append("       A.ALL_IN_RT_CD," ).append("\n"); 
		query.append("       NVL(A.SVC_SCP_CD, '*') AS SVC_SCP_CD," ).append("\n"); 
		query.append("       NVL(A.FM_EFF_DT, '20000101') AS FM_EFF_DT," ).append("\n"); 
		query.append("       NVL(A.TO_EFF_DT, '29990101') AS TO_EFF_DT," ).append("\n"); 
		query.append("       NVL(A.SC_NO, '*') AS SC_NO," ).append("\n"); 
		query.append("       NVL(A.RFA_NO, '*') AS RFA_NO," ).append("\n"); 
		query.append("       NVL(A.CMDT_TP_CD, '*') AS CMDT_TP_CD," ).append("\n"); 
		query.append("       NVL(A.CMDT_CD, '*') AS CMDT_CD," ).append("\n"); 
		query.append("       DECODE(A.CMDT_TP_CD, '2', E.REP_CMDT_NM, '3', F.CMDT_NM) AS CMDT_NM," ).append("\n"); 
		query.append("       NVL(A.FAC_DIV_CD, ' ') AS FAC_DIV_CD," ).append("\n"); 
		query.append("       DECODE (A.FAC_DIV_CD, 'BL', 0, NVL(A.FAC_BKG_RT, 0)) AS BKG_FAC_RT," ).append("\n"); 
		query.append("       NVL(A.FAC_SPCL_CNTR_TP_CTNT1, ' ') AS FAC_SPCL_CNTR_TP_CTNT1," ).append("\n"); 
		query.append("       NVL(A.FAC_SPCL_CNTR_RT1, 0) AS FAC_SPCL_CNTR_RT1," ).append("\n"); 
		query.append("       NVL(A.FAC_SPCL_CNTR_TP_CTNT2, ' ') AS FAC_SPCL_CNTR_TP_CTNT2," ).append("\n"); 
		query.append("       NVL(A.FAC_SPCL_CNTR_RT2, 0) AS FAC_SPCL_CNTR_RT2," ).append("\n"); 
		query.append("       NVL(A.CURR_CD, 'USD') AS CURR_CD," ).append("\n"); 
		query.append("       DECODE (A.FAC_DIV_CD, 'BL', NVL(A.FAC_BKG_RT, 0), 0) AS BKG_FAC_BL_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_BX_AMT, 0) AS FAC_BX_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_TEU_AMT, 0) AS FAC_TEU_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_FEU_AMT, 0) AS FAC_FEU_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_RF_TEU_AMT, 0) AS FAC_RF_TEU_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_RF_FEU_AMT, 0) AS FAC_RF_FEU_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_SPCL_TEU_AMT, 0) AS FAC_SPCL_TEU_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_SPCL_FEU_AMT, 0) AS FAC_SPCL_FEU_AMT," ).append("\n"); 
		query.append("       NVL(A.FAC_CHG_CTNT, ' ') AS FAC_CHG_CTNT," ).append("\n"); 
		query.append("       NVL(A.FAC_STS_CD, 'RN') AS FAC_STS_CD," ).append("\n"); 
		query.append("       A.FAC_RQST_USR_ID," ).append("\n"); 
		query.append("       A.FAC_APRO_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.FAC_APRO_DT, 'yyyyMMdd') AS FAC_APRO_DT," ).append("\n"); 
		query.append("       A.FAC_RMK," ).append("\n"); 
		query.append("       A.FAC_AGMT_SEQ," ).append("\n"); 
		query.append("       A.FAC_OFC_CD," ).append("\n"); 
		query.append("       A.FAC_RQST_USR_EML," ).append("\n"); 
		query.append("       A.FAC_APRO_USR_EML," ).append("\n"); 
		query.append("       G.USR_NM FAC_RQST_USR_NAME," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.CRE_DT, 'yyyyMMddHH24miss') AS CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(A.UPD_DT, 'yyyyMMddHH24miss') AS UPD_DT" ).append("\n"); 
		query.append("  FROM ACM_FAC_AGMT A," ).append("\n"); 
		query.append("       MDM_CUSTOMER B," ).append("\n"); 
		query.append("       MDM_CUSTOMER C," ).append("\n"); 
		query.append("       MDM_REP_CMDT E," ).append("\n"); 
		query.append("       MDM_COMMODITY F," ).append("\n"); 
		query.append("       COM_USER G" ).append("\n"); 
		query.append(" WHERE A.FAC_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append(" #if (${fac_sts_cd} != '')" ).append("\n"); 
		query.append("   AND A.FAC_STS_CD = @[fac_sts_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("   AND A.FF_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.FF_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND A.SHPR_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.SHPR_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CMDT_CD = E.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_CD = F.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND A.FAC_RQST_USR_ID = G.USR_ID(+)" ).append("\n"); 
		query.append(" ORDER BY CMDT_TP_CD ," ).append("\n"); 
		query.append("       CMDT_CD ," ).append("\n"); 
		query.append("       CMDT_NM ," ).append("\n"); 
		query.append("       FAC_DIV_CD ," ).append("\n"); 
		query.append("       FF_LGL_ENG_NM ," ).append("\n"); 
		query.append("       SHPR_CNT_SEQ ," ).append("\n"); 
		query.append("       SHPR_LGL_ENG_NM ," ).append("\n"); 
		query.append("       POR_GRP_TP_CD ," ).append("\n"); 
		query.append("       POR_ROUT_CD ," ).append("\n"); 
		query.append("       POL_GRP_TP_CD" ).append("\n"); 

	}
}