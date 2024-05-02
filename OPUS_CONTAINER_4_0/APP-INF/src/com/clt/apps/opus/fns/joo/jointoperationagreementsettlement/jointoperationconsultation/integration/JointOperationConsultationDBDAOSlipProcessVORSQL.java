/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlipProcessVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlipProcessVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP CSR Creation   
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlipProcessVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ap_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlipProcessVORSQL").append("\n"); 
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
		query.append("       'I' AS IBFLAG" ).append("\n"); 
		query.append("      ,A.ACCT_YRMON" ).append("\n"); 
		query.append("      ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,A.STL_SEQ" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD" ).append("\n"); 
		query.append("      ,J.STL_CMB_SEQ" ).append("\n"); 
		query.append("      ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("#if (${re_divr_cd}=='E')" ).append("\n"); 
		query.append("      ,LPAD(C.VNDR_SEQ,6,'0') AS CUST_VNDR_SEQ" ).append("\n"); 
		query.append("      ,D.VNDR_CNT_CD AS CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("      ,D.VNDR_LGL_ENG_NM AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("      ,D.VNDR_LOCL_LANG_NM AS CUST_VNDR_KOR_NM" ).append("\n"); 
		query.append("      ,D.RGST_NO AS CUST_VNDR_RGST_NO" ).append("\n"); 
		query.append("      ,NVL(D.SUBS_CO_CD,'00') AS SLP_ISS_INTER_CO_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,LPAD(C.CUST_SEQ,6,'0') AS CUST_VNDR_SEQ" ).append("\n"); 
		query.append("      ,C.CUST_CNT_CD AS CUST_VNDR_CNT_CD" ).append("\n"); 
		query.append("      ,D.CUST_LGL_ENG_NM AS CUST_VNDR_ENG_NM" ).append("\n"); 
		query.append("      ,D.CUST_LOCL_LANG_NM AS CUST_VNDR_KOR_NM" ).append("\n"); 
		query.append("      ,D.CUST_RGST_NO AS CUST_VNDR_RGST_NO" ).append("\n"); 
		query.append("      ,NVL(D.SUBS_CO_CD,'00') AS SLP_ISS_INTER_CO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,E.SLP_TP_CD" ).append("\n"); 
		query.append("      ,E.SLP_FUNC_CD" ).append("\n"); 
		query.append("      ,I.AP_OFC_CD AS SLP_OFC_CD" ).append("\n"); 
		query.append("      ,E.SLP_ISS_DT" ).append("\n"); 
		query.append("      ,E.SLP_SER_NO" ).append("\n"); 
		query.append("      ,'' AS ISSUER_ID" ).append("\n"); 
		query.append("      ,'' AS ISSUER_NM" ).append("\n"); 
		query.append("      ,'' AS CSR_DESC" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.STL_LOCL_AMT" ).append("\n"); 
		query.append("      ,'F0' AS EVID_TP_CD" ).append("\n"); 
		query.append("      ,''  AS CSR_TP_CD" ).append("\n"); 
		query.append("      ,B.REV_YRMON      " ).append("\n"); 
		query.append("      ,CASE WHEN B.REV_YRMON IS NULL THEN " ).append("\n"); 
		query.append("                 TO_CHAR(B.EAI_EVNT_DT -1, 'YYYYMMDD')" ).append("\n"); 
		query.append("            ELSE TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("       END AS EFF_DT" ).append("\n"); 
		query.append("      ,''  AS RQST_DT" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.REV_DIR_CD" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,I.AP_CTR_CD AS DR_CTR_CD" ).append("\n"); 
		query.append("      ,I.AP_CTR_CD AS CR_CTR_CD" ).append("\n"); 
		query.append("      ,I.LOC_CD AS DR_LOC_CD" ).append("\n"); 
		query.append("      ,I.LOC_CD AS CR_LOC_CD" ).append("\n"); 
		query.append("      ,F.DR_CTR_CD AS CHK_CTR_CD" ).append("\n"); 
		query.append("      ,F.DR_LOC_CD AS CHK_LOC_CD" ).append("\n"); 
		query.append("      ,G.DR_ACCT_CD" ).append("\n"); 
		query.append("      ,G.CR_ACCT_CD" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD||'/'||H.JO_STL_ITM_NM AS SLP_DESC" ).append("\n"); 
		query.append("      ,DECODE(B.REV_YRMON,NULL,'Y','N') AS VVD_CXL_FLG" ).append("\n"); 
		query.append("      ,A.STL_LOCL_AMT AS TOT_AMOUNT" ).append("\n"); 
		query.append("      ,'DR' AS DR_CR_CD" ).append("\n"); 
		query.append("      ,'' AS KEY_NO" ).append("\n"); 
		query.append("      ,@[ar_ap_div_cd] AS AR_AP_DIV_CD" ).append("\n"); 
		query.append("      ,I.FINC_RGN_CD AS SLP_ISS_RGN_CD" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD||'J'||TO_CHAR(TO_DATE(A.ACCT_YRMON,'YYYYMM'),'RRMM')||LPAD(J.STL_CMB_SEQ,2,'0') AS CSR_OFFST_NO" ).append("\n"); 
		query.append("      ,I.OFC_CD AS SLP_ISS_OFC_CD" ).append("\n"); 
		query.append("      ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("      ,F.JO_STL_ITM_CD AS FIN_JO_STL_ITM_CD-- NULL 인것을 CHECK하기 위함...(FINANCIAL MATRIX 에 없는 것을 알려주기 위함)" ).append("\n"); 
		query.append("      ,A.BSA_QTY" ).append("\n"); 
		query.append("      ,A.BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,'' AS APRO_STEP --Approval 결재라인에 필요" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT   A," ).append("\n"); 
		query.append("       AR_MST_REV_VVD   B," ).append("\n"); 
		query.append("       JOO_CARRIER      C," ).append("\n"); 
		query.append("#if (${re_divr_cd}=='E')" ).append("\n"); 
		query.append("       MDM_VENDOR       D," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       MDM_CUSTOMER     D," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       JOO_STL_CMB      E," ).append("\n"); 
		query.append("       JOO_FINC_MTX     F," ).append("\n"); 
		query.append("       JOO_STL_ITM_ACCT G," ).append("\n"); 
		query.append("       JOO_STL_ITM      H,  " ).append("\n"); 
		query.append("       MDM_ORGANIZATION I," ).append("\n"); 
		query.append("       JOO_STL_CMB_DTL  J    " ).append("\n"); 
		query.append("WHERE  A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    A.REV_DIR_CD    = B.RLANE_DIR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = C.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = C.RLANE_CD" ).append("\n"); 
		query.append("#if (${re_divr_cd}=='E')" ).append("\n"); 
		query.append("AND    C.VNDR_SEQ      = D.VNDR_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    C.CUST_CNT_CD   = D.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    C.CUST_SEQ      = D.CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = F.JO_CRR_CD    (+)" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = F.RLANE_CD     (+)" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = F.RE_DIVR_CD   (+)" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = F.JO_STL_ITM_CD(+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = J.ACCT_YRMON" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ   = J.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND    A.STL_SEQ       = J.STL_SEQ" ).append("\n"); 
		query.append("AND    J.ACCT_YRMON    = E.ACCT_YRMON" ).append("\n"); 
		query.append("AND    J.JO_CRR_CD     = E.JO_CRR_CD" ).append("\n"); 
		query.append("AND    J.STL_CMB_SEQ   = E.STL_CMB_SEQ" ).append("\n"); 
		query.append("AND    J.RE_DIVR_CD    = E.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = G.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = G.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = H.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON    = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    J.STL_CMB_SEQ   = TO_NUMBER(@[stl_cmb_seq])" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    I.OFC_CD        = (SELECT AP_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD =@[slp_iss_ofc_cd])" ).append("\n"); 
		query.append("--2010.03.29 STL_LOCL_AMT = 0인 것은 제외 => 박효숙 차장" ).append("\n"); 
		query.append("AND    A.STL_LOCL_AMT <> 0" ).append("\n"); 

	}
}