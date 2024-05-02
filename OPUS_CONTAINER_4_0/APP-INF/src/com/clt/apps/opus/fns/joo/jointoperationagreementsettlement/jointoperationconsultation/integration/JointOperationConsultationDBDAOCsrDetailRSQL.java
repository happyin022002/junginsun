/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCsrDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
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

public class JointOperationConsultationDBDAOCsrDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Detail 조회
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCsrDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCsrDetailRSQL").append("\n"); 
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
		query.append("SELECT A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO AS CSR_NO" ).append("\n"); 
		query.append("     , A.SLP_TP_CD" ).append("\n"); 
		query.append("     , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("     , A.SLP_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT,'YYYYMMDD') AS SLP_ISS_DT" ).append("\n"); 
		query.append("     , A.SLP_SER_NO" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , A.SLP_ISS_OFC_CD" ).append("\n"); 
		query.append("     , A.CSR_DESC" ).append("\n"); 
		query.append("     , A.CSR_LOCL_CURR_CD" ).append("\n"); 
		query.append("     , A.CSR_LOCL_AMT" ).append("\n"); 
		query.append("     , A.CSR_USD_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT,'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , A.EVID_TP_CD" ).append("\n"); 
		query.append("     , A.APRO_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(A.APRO_DT,'YYYYMMDDHH24MISS') AS APRO_DT" ).append("\n"); 
		query.append("     , A.CXL_FLG" ).append("\n"); 
		query.append("     , A.CXL_DESC" ).append("\n"); 
		query.append("     , A.CSR_OFFST_NO" ).append("\n"); 
		query.append("     , A.DDCT_FLG" ).append("\n"); 
		query.append("     , A.DDCT_LOCL_AMT" ).append("\n"); 
		query.append("     , A.DDCT_DESC" ).append("\n"); 
		query.append("     , A.RQST_LOCL_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(A.RQST_DT,'YYYYMMDD') AS RQST_DT" ).append("\n"); 
		query.append("     , A.CSR_TP_CD" ).append("\n"); 
		query.append("     , A.SLP_ISS_RGN_CD" ).append("\n"); 
		query.append("     , A.SLP_ISS_INTER_CO_CD" ).append("\n"); 
		query.append("     , A.RVS_CSR_FLG" ).append("\n"); 
		query.append("     , A.ORG_SLP_TP_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_FUNC_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_OFC_CD" ).append("\n"); 
		query.append("     , A.ORG_SLP_ISS_DT" ).append("\n"); 
		query.append("     , A.ORG_SLP_SER_NO" ).append("\n"); 
		query.append("     , D.ACCT_YRMON" ).append("\n"); 
		query.append("     , D.JO_CRR_CD" ).append("\n"); 
		query.append("     , D.INV_NO" ).append("\n"); 
		query.append("     , D.RE_DIVR_CD" ).append("\n"); 
		query.append("     , D.RVS_CMB_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , B.USR_NM AS ISSUER" ).append("\n"); 
		query.append("     , C.NAME AS EVID_TP_NM" ).append("\n"); 
		query.append("     , CASE WHEN A.SLP_TP_CD = '06' THEN ''||LPAD(A.VNDR_SEQ,6,'0')" ).append("\n"); 
		query.append("            WHEN A.SLP_TP_CD = '18' THEN A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS VNDR_CUST_SEQ" ).append("\n"); 
		query.append("     , CASE WHEN A.SLP_TP_CD = '06' THEN NVL((SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR   X WHERE X.VNDR_SEQ    = A.VNDR_SEQ),'')" ).append("\n"); 
		query.append("            WHEN A.SLP_TP_CD = '18' THEN NVL((SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = A.CUST_CNT_CD AND X.CUST_SEQ = A.CUST_SEQ),'')" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS LGL_ENG_NM" ).append("\n"); 
		query.append("     , NVL(E.CLZ_STS_CD,'C') AS CLZ_STS_CD" ).append("\n"); 
		query.append("     , A.RJCT_CSR_FLG" ).append("\n"); 
		query.append("     , D.RJCT_CMB_FLG" ).append("\n"); 
		query.append("     , '' AS RCV_ERR_RSN" ).append("\n"); 
		query.append("     , '' AS EFF_DT_FR" ).append("\n"); 
		query.append("     , '' AS EFF_DT_TO" ).append("\n"); 
		query.append("     , '' AS AUTH_OFC_CD" ).append("\n"); 
		query.append("      -- 같은 CSR의 rlane별로 Read와 ,Write권한이 같이 있을 수 있나 있다는 가정하에 섞여있으면 Read가 우선하도록 하기 위해 Min를 썼다." ).append("\n"); 
		query.append("     , NVL((SELECT MIN(Z.JO_CRR_AUTH_CD)" ).append("\n"); 
		query.append("             FROM JOO_INV_DTL     X" ).append("\n"); 
		query.append("                , JOO_STL_TGT     Y" ).append("\n"); 
		query.append("                , JOO_CRR_AUTH    Z" ).append("\n"); 
		query.append("            WHERE  X.VSL_CD        = Y.VSL_CD" ).append("\n"); 
		query.append("              AND X.SKD_VOY_NO     = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND X.SKD_DIR_CD     = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND X.REV_DIR_CD     = Y.REV_DIR_CD" ).append("\n"); 
		query.append("              AND X.REV_YRMON      = Y.REV_YRMON" ).append("\n"); 
		query.append("              AND X.STL_VVD_SEQ    = Y.STL_VVD_SEQ" ).append("\n"); 
		query.append("              AND Y.JO_CRR_CD      = Z.JO_CRR_CD" ).append("\n"); 
		query.append("              AND Y.RLANE_CD       = Z.RLANE_CD" ).append("\n"); 
		query.append("              AND Z.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("              AND Z.AUTH_OFC_CD    = @[auth_ofc_cd]" ).append("\n"); 
		query.append("              AND X.ACCT_YRMON     = D.ACCT_YRMON" ).append("\n"); 
		query.append("              AND X.JO_CRR_CD      = D.JO_CRR_CD" ).append("\n"); 
		query.append("              AND X.INV_NO         = D.INV_NO" ).append("\n"); 
		query.append("              AND X.RE_DIVR_CD     = D.RE_DIVR_CD), 'R') AUTH_CD" ).append("\n"); 
		query.append("      -- csr reject시 필요한 flag" ).append("\n"); 
		query.append("      -- I/F가 제대로 되어도 Error가 날 경우도 있으므로 RCV_ERR_FLG를 Check한다." ).append("\n"); 
		query.append("     , DECODE(NVL(H.IF_FLG,'E'),'Y', NVL(H.RCV_ERR_FLG,'Y'), NVL(H.IF_FLG,'E')) AS IF_FLG" ).append("\n"); 
		query.append("     , '' AS APRO_STEP -- REVERSE 결재선 지정시 필요함 " ).append("\n"); 
		query.append("     , H.RCV_ERR_FLG AS RCV_ERR_FLG" ).append("\n"); 
		query.append("     , H.RCV_ERR_RSN AS RCV_ERR_RSN" ).append("\n"); 
		query.append("     , NULL AS LST_APRO_FLG -- 최종결재자여부" ).append("\n"); 
		query.append("     , NULL AS APRO_RQST_NO" ).append("\n"); 
		query.append("     , NULL AS APRO_RQST_SEQ" ).append("\n"); 
		query.append("  FROM JOO_CSR  A" ).append("\n"); 
		query.append("     , COM_USER B" ).append("\n"); 
		query.append("     , (SELECT SLD.LU_CD AS CODE" ).append("\n"); 
		query.append("              , SLD.LU_DESC AS NAME" ).append("\n"); 
		query.append("              , SLD.ATTR_CTNT1 AS TAX_RATE" ).append("\n"); 
		query.append("              , SLD.ATTR_CTNT2 AS TAX_INCOME_FLAG" ).append("\n"); 
		query.append("              , DP_SEQ" ).append("\n"); 
		query.append("           FROM SCO_LU_HDR SLH" ).append("\n"); 
		query.append("              , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("          WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("            AND SLH.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("            AND NVL(SLD.ENBL_FLG, 'Y') = 'Y') C" ).append("\n"); 
		query.append("     , JOO_INVOICE D" ).append("\n"); 
		query.append("     , (SELECT CLZ_STS_CD --EFF.DT 마감여부" ).append("\n"); 
		query.append("             , SLP_TP_CD" ).append("\n"); 
		query.append("             , SLP_FUNC_CD" ).append("\n"); 
		query.append("             , SLP_OFC_CD" ).append("\n"); 
		query.append("             , SLP_ISS_DT" ).append("\n"); 
		query.append("             , SLP_SER_NO" ).append("\n"); 
		query.append("          FROM (SELECT '1' AS SEQ" ).append("\n"); 
		query.append("                     , A.SLP_TP_CD" ).append("\n"); 
		query.append("                     , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("                     , A.SLP_OFC_CD" ).append("\n"); 
		query.append("                     , A.SLP_ISS_DT" ).append("\n"); 
		query.append("                     , A.SLP_SER_NO" ).append("\n"); 
		query.append("                     , MAX(X.CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("                  FROM AP_PERIOD X" ).append("\n"); 
		query.append("                     , JOO_CSR A" ).append("\n"); 
		query.append("                 WHERE A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("                   AND X.SYS_DIV_CD     = DECODE(X.AR_AP_DIV_CD,'R','18','19')" ).append("\n"); 
		query.append("                   AND X.EFF_YRMON      = TO_CHAR(A.EFF_DT,'YYYYMM')" ).append("\n"); 
		query.append("                   AND X.AR_AP_DIV_CD   = DECODE(A.SLP_TP_CD,'18','R','P')" ).append("\n"); 
		query.append("                   AND X.OFC_CD         = A.SLP_OFC_CD" ).append("\n"); 
		query.append("                 GROUP BY A.SLP_TP_CD" ).append("\n"); 
		query.append("                     , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("                     , A.SLP_OFC_CD" ).append("\n"); 
		query.append("                     , A.SLP_ISS_DT" ).append("\n"); 
		query.append("                     , A.SLP_SER_NO" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT '2' AS SEQ" ).append("\n"); 
		query.append("                     , A.SLP_TP_CD" ).append("\n"); 
		query.append("                     , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("                     , A.SLP_OFC_CD" ).append("\n"); 
		query.append("                     , A.SLP_ISS_DT" ).append("\n"); 
		query.append("                     , A.SLP_SER_NO" ).append("\n"); 
		query.append("                     , MAX(X.CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("                  FROM AP_PERIOD X" ).append("\n"); 
		query.append("                     , JOO_CSR A" ).append("\n"); 
		query.append("                 WHERE A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("                   AND X.SYS_DIV_CD     = DECODE(X.AR_AP_DIV_CD,'R','18','19')" ).append("\n"); 
		query.append("                   AND X.EFF_YRMON      = TO_CHAR(A.EFF_DT,'YYYYMM')" ).append("\n"); 
		query.append("                   AND X.AR_AP_DIV_CD   = DECODE(A.SLP_TP_CD,'18','R','P')" ).append("\n"); 
		query.append("                   AND X.OFC_CD         = (SELECT X.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION X WHERE X.OFC_CD = A.SLP_OFC_CD)" ).append("\n"); 
		query.append("                 GROUP BY A.SLP_TP_CD" ).append("\n"); 
		query.append("                     , A.SLP_FUNC_CD" ).append("\n"); 
		query.append("                     , A.SLP_OFC_CD" ).append("\n"); 
		query.append("                     , A.SLP_ISS_DT" ).append("\n"); 
		query.append("                     , A.SLP_SER_NO" ).append("\n"); 
		query.append("                 ORDER BY 1 ) X" ).append("\n"); 
		query.append("         WHERE CLZ_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND ROWNUM = 1 ) E" ).append("\n"); 
		query.append("     , AP_INV_HDR H" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID    = B.USR_ID(+)" ).append("\n"); 
		query.append("   AND A.EVID_TP_CD    = C.CODE(+)" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD     = D.SLP_TP_CD" ).append("\n"); 
		query.append("   AND A.SLP_FUNC_CD   = D.SLP_FUNC_CD" ).append("\n"); 
		query.append("   AND A.SLP_OFC_CD    = D.SLP_OFC_CD" ).append("\n"); 
		query.append("   AND A.SLP_ISS_DT    = D.SLP_ISS_DT" ).append("\n"); 
		query.append("   AND A.SLP_SER_NO    = D.SLP_SER_NO" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD     = E.SLP_TP_CD  (+)" ).append("\n"); 
		query.append("   AND A.SLP_FUNC_CD   = E.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("   AND A.SLP_OFC_CD    = E.SLP_OFC_CD (+) " ).append("\n"); 
		query.append("   AND A.SLP_ISS_DT    = E.SLP_ISS_DT (+)" ).append("\n"); 
		query.append("   AND A.SLP_SER_NO    = E.SLP_SER_NO (+)" ).append("\n"); 
		query.append("   AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO = H.CSR_NO(+)" ).append("\n"); 

	}
}