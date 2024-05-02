/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainDBDAOSearchClaimMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.05.12 정행룡
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchClaimMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim Main 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchClaimMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchClaimMainRSQL").append("\n"); 
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
		query.append("   A.CGO_CLM_NO" ).append("\n"); 
		query.append(",  A.HDLR_USR_ID" ).append("\n"); 
		query.append(",  A.HDLR_OFC_CD" ).append("\n"); 
		query.append(",  A.CS_CLZ_DT" ).append("\n"); 
		query.append(",  A.CLM_TM_BAR_DT" ).append("\n"); 
		query.append(",  A.LABL_TM_BAR_DT" ).append("\n"); 
		query.append(",  A.PRLM_CLM_NTC_DT" ).append("\n"); 
		query.append(",  A.CGO_CLM_ACKNAK_DT" ).append("\n"); 
		query.append(",  (TO_DATE(NVL(A.CS_CLZ_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -" ).append("\n"); 
		query.append("    TO_DATE(A.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS HPD" ).append("\n"); 
		query.append(",  (TO_DATE(NVL(A.CGO_CLM_STL_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -" ).append("\n"); 
		query.append("    TO_DATE(A.FMAL_CLM_RCV_DT,'YYYYMMDD')) + 1  AS NHP" ).append("\n"); 
		query.append(",  A.FACT_FND_DT" ).append("\n"); 
		query.append(",  A.FACT_FND_DESC" ).append("\n"); 
		query.append(",  A.TRNS_FLG" ).append("\n"); 
		query.append(",  I.CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append(",  I.TRNS_SEQ" ).append("\n"); 
		query.append(",  A.CS_CLZ_ROPN_DT" ).append("\n"); 
		query.append(",  A.CGO_CLM_DIV_CD" ).append("\n"); 
		query.append(",  A.CP_DESC" ).append("\n"); 
		query.append(",  A.CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append(",  A.CLMT_CLM_TP_CD" ).append("\n"); 
		query.append(",  A.CLMT_REF_NO" ).append("\n"); 
		query.append(",  A.FMAL_CLM_RCV_OFC_CD" ).append("\n"); 
		query.append(",  A.FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append(",  A.CGO_CLM_TP_CD" ).append("\n"); 
		query.append(",  A.MJR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append(",  A.MINR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append(",  A.CGO_CLM_INCI_NO" ).append("\n"); 
		query.append(",  A.CLMT_LOCL_AMT" ).append("\n"); 
		query.append(",  A.CLMT_LOCL_CURR_CD" ).append("\n"); 
		query.append(",  A.CLMT_LOCL_XCH_RT" ).append("\n"); 
		query.append(",  A.CLMT_USD_AMT" ).append("\n"); 
		query.append(",  A.CLM_CUZ_DESC" ).append("\n"); 
		query.append(",  A.CLM_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append(",  A.INSUR_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append(",  A.CLMT_AGN_TP_CD" ).append("\n"); 
		query.append(",  A.CLMT_AGN_APNT_DT" ).append("\n"); 
		query.append(",  A.CLMT_AGN_REF_NO" ).append("\n"); 
		query.append(",  A.CLM_RVW_DESC" ).append("\n"); 
		query.append(",  A.CGO_CLM_STS_CD" ).append("\n"); 
		query.append(",  CNI_GET_CLM_MISC_NM_FNC('08',A.CGO_CLM_STS_CD ,'2') AS CGO_CLM_STS_NM" ).append("\n"); 
		query.append(",  A.BFR_CGO_CLM_STS_CD" ).append("\n"); 
		query.append(",  A.CGO_CLM_CLZ_CD" ).append("\n"); 
		query.append(",  A.PRE_CGO_CLM_CLZ_CD" ).append("\n"); 
		query.append(",  A.CRM_VOC_NO" ).append("\n"); 
		query.append(",  A.UPD_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",  A.TRNK_REF_VVD_NO" ).append("\n"); 
		query.append(",  A.CLM_CGO_TP_CD" ).append("\n"); 
		query.append(",  A.CGO_QLTY_DESC" ).append("\n"); 
		query.append(",  A.CRR_TERM_CD" ).append("\n"); 
		query.append(",  A.CLM_OFRT_AMT" ).append("\n"); 
		query.append(",  A.CLM_OFRT_TERM_CD" ).append("\n"); 
		query.append(",  A.CLM_OFRT_FLG" ).append("\n"); 
		query.append(",  A.POR_CD" ).append("\n"); 
		query.append(",  A.RCT_DT" ).append("\n"); 
		query.append(",  A.POL_CD" ).append("\n"); 
		query.append(",  A.LODG_DT" ).append("\n"); 
		query.append(",  A.POD_CD" ).append("\n"); 
		query.append(",  A.DCHG_DT" ).append("\n"); 
		query.append(",  A.DEL_CD" ).append("\n"); 
		query.append(",  A.DE_DT" ).append("\n"); 
		query.append(",  A.N1ST_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(",  A.N2ND_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(",  A.N3RD_PRE_REF_VVD_NO" ).append("\n"); 
		query.append(",  A.N1ST_PRE_TS_LOC_CD" ).append("\n"); 
		query.append(",  A.N1ST_PRE_TS_DT" ).append("\n"); 
		query.append(",  A.N2ND_PRE_TS_LOC_CD" ).append("\n"); 
		query.append(",  A.N2ND_PRE_TS_DT" ).append("\n"); 
		query.append(",  A.N1ST_PST_REF_VVD_NO" ).append("\n"); 
		query.append(",  A.N2ND_PST_REF_VVD_NO" ).append("\n"); 
		query.append(",  A.N3RD_PST_REF_VVD_NO" ).append("\n"); 
		query.append(",  A.N1ST_PST_TS_LOC_CD" ).append("\n"); 
		query.append(",  A.N1ST_PST_TS_DT" ).append("\n"); 
		query.append(",  A.N2ND_PST_TS_LOC_CD" ).append("\n"); 
		query.append(",  A.N2ND_PST_TS_DT" ).append("\n"); 
		query.append(",  A.SLAN_CD" ).append("\n"); 
		query.append(",  A.CLM_INCI_PLC_TP_CD AS INCI_PLC_TP_CD" ).append("\n"); 
		query.append(",  A.CLM_INCI_OCCR_DT AS INCI_OCCR_DT" ).append("\n"); 
		query.append(",  A.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",  A.INSUR_REF_NO" ).append("\n"); 
		query.append(",  A.AGN_CRSPN_TP_CD" ).append("\n"); 
		query.append(",  A.AGN_CRSPN_APNT_DT" ).append("\n"); 
		query.append(",  A.AGN_CRSPN_REF_NO" ).append("\n"); 
		query.append(",  A.LABL_PTY_FMAL_CLM_DT" ).append("\n"); 
		query.append(",  A.LABL_PTY_DMND_USD_AMT" ).append("\n"); 
		query.append(",  A.LABL_CLM_PTY_NO" ).append("\n"); 
		query.append(",  CNI_GET_PTY_NM_FNC( A.LABL_CLM_PTY_NO, '1') AS LABL_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",  A.SVEY_CLM_PTY_NO" ).append("\n"); 
		query.append(",  CNI_GET_PTY_NM_FNC( A.SVEY_CLM_PTY_NO, '1') AS SVEY_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",  A.CGO_CLM_STL_TP_CD" ).append("\n"); 
		query.append(",  A.SVYR_TP_CD" ).append("\n"); 
		query.append(",  A.SVEY_INP_DT" ).append("\n"); 
		query.append(",  A.CLM_AREA_CD" ).append("\n"); 
		query.append(",  A.PLT_NM" ).append("\n"); 
		query.append(",  A.DEFT_NM" ).append("\n"); 
		query.append(",  A.DEFT_ATTY_CLM_PTY_NO" ).append("\n"); 
		query.append(",  A.DEFT_ATTY_APNT_DT" ).append("\n"); 
		query.append(",  A.REF_DEFT_ATTY_NO" ).append("\n"); 
		query.append(",  A.CRT_NM" ).append("\n"); 
		query.append(",  A.CRT_CS_NO" ).append("\n"); 
		query.append(",  A.CPLN_FILE_DT" ).append("\n"); 
		query.append(",  A.JMT_RSLT_CD" ).append("\n"); 
		query.append(",  A.JMT_RSLT_DT" ).append("\n"); 
		query.append(",  A.SMNS_SVE_DT" ).append("\n"); 
		query.append(",  A.LTGT_CS_DESC" ).append("\n"); 
		query.append(",  (SELECT WM_CONCAT(CGO_CLM_REF_CNTR_NO)" ).append("\n"); 
		query.append("    FROM CNI_CGO_CLM_CNTR_DTL" ).append("\n"); 
		query.append("    WHERE CGO_CLM_NO = @[cgo_clm_no])" ).append("\n"); 
		query.append("   AS CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append(",  B.UPD_USR_ID AS LIGT_UPD_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(B.UPD_DT,'YYYYMMDD') AS LIGT_UPD_DT" ).append("\n"); 
		query.append(",  C.CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append(",  C.MN_BL_FLG" ).append("\n"); 
		query.append(",  D.CLM_PTY_ABBR_NM AS CLM_AGN_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",  D.PTY_NM AS CLM_AGN_CLM_PTY_NM" ).append("\n"); 
		query.append(",  D.INTL_PHN_NO AS CLM_AGN_INTL_PHN_NO" ).append("\n"); 
		query.append(",  D.PHN_NO AS CLM_AGN_PHN_NO" ).append("\n"); 
		query.append(",  D.PTY_EML AS CLM_AGN_PTY_EML" ).append("\n"); 
		query.append(",  E.CLM_PTY_ABBR_NM AS INSUR_AGN_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",  E.PTY_NM AS INSUR_AGN_CLM_PTY_NM" ).append("\n"); 
		query.append(",  E.INTL_PHN_NO AS INSUR_AGN_INTL_PHN_NO" ).append("\n"); 
		query.append(",  E.PHN_NO AS INSUR_AGN_PHN_NO" ).append("\n"); 
		query.append(",  E.PTY_EML AS INSUR_AGN_PTY_EML" ).append("\n"); 
		query.append(",  F.CLM_PTY_ABBR_NM AS DEFT_ATTY_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",  F.PTY_NM AS DEFT_ATTY_CLM_PTY_NM" ).append("\n"); 
		query.append(",  G.CLM_PTY_ABBR_NM AS INSUR_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",  H.CLM_PTY_ABBR_NM AS CLMT_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append(",  H.PTY_NM AS CLMT_CLM_PTY_NM" ).append("\n"); 
		query.append(",  J.VSL_ENG_NM" ).append("\n"); 
		query.append(",  ( SELECT" ).append("\n"); 
		query.append("           INSUR_VSL_TP_CD" ).append("\n"); 
		query.append("      FROM CNI_INSUR_CTRT_DTL" ).append("\n"); 
		query.append("     WHERE VSL_CD = SUBSTR(A.TRNK_REF_VVD_NO,1,4)" ).append("\n"); 
		query.append("       AND INSUR_CLM_PTY_NO = A.INSUR_CLM_PTY_NO " ).append("\n"); 
		query.append("       AND INSUR_EFF_DT = ( SELECT" ).append("\n"); 
		query.append("                                  MAX(INSUR_EFF_DT)" ).append("\n"); 
		query.append("                              FROM CNI_INSUR_CTRT_DTL" ).append("\n"); 
		query.append("                             WHERE VSL_CD = SUBSTR(A.TRNK_REF_VVD_NO,1,4)" ).append("\n"); 
		query.append("                              AND INSUR_CLM_PTY_NO = A.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("    ) AS INSUR_VSL_TP_CD" ).append("\n"); 
		query.append(",   ( SELECT" ).append("\n"); 
		query.append("           INSUR_VSL_OSHP_CD" ).append("\n"); 
		query.append("      FROM CNI_INSUR_CTRT_DTL" ).append("\n"); 
		query.append("     WHERE VSL_CD = SUBSTR(A.TRNK_REF_VVD_NO,1,4)" ).append("\n"); 
		query.append("       AND INSUR_CLM_PTY_NO = A.INSUR_CLM_PTY_NO " ).append("\n"); 
		query.append("       AND INSUR_EFF_DT = ( SELECT" ).append("\n"); 
		query.append("                                  MAX(INSUR_EFF_DT)" ).append("\n"); 
		query.append("                              FROM CNI_INSUR_CTRT_DTL" ).append("\n"); 
		query.append("                             WHERE VSL_CD = SUBSTR(A.TRNK_REF_VVD_NO,1,4)" ).append("\n"); 
		query.append("                              AND INSUR_CLM_PTY_NO = A.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("    ) AS INSUR_VSL_OSHP_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("FROM CNI_CLM_V A" ).append("\n"); 
		query.append(",    CNI_CGO_CLM_LTGT B" ).append("\n"); 
		query.append(",    CNI_CGO_CLM_BL_DTL C" ).append("\n"); 
		query.append(",    CNI_PARTY D" ).append("\n"); 
		query.append(",    CNI_PARTY E" ).append("\n"); 
		query.append(",    CNI_PARTY F" ).append("\n"); 
		query.append(",    CNI_PARTY G" ).append("\n"); 
		query.append(",    CNI_PARTY H" ).append("\n"); 
		query.append(",    ( SELECT CGO_CLM_NO" ).append("\n"); 
		query.append("            , TRNS_SEQ" ).append("\n"); 
		query.append("            , CLM_TRNS_AUTH_CD " ).append("\n"); 
		query.append("         FROM CNI_CGO_CLM_TRNS" ).append("\n"); 
		query.append("        WHERE CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append("          AND CLM_TRNS_AUTH_CD IN ('W','R') " ).append("\n"); 
		query.append("          AND TRNS_SEQ = (SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("                            FROM CNI_CGO_CLM_TRNS" ).append("\n"); 
		query.append("                           WHERE CGO_CLM_NO = @[cgo_clm_no])" ).append("\n"); 
		query.append("      ) I" ).append("\n"); 
		query.append(",     MDM_VSL_CNTR J " ).append("\n"); 
		query.append("WHERE A.CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append("AND   A.CGO_CLM_NO = B.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("AND   A.CGO_CLM_NO = C.CGO_CLM_NO" ).append("\n"); 
		query.append("AND   A.CGO_CLM_NO = I.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("AND   C.MN_BL_FLG  = 'Y'" ).append("\n"); 
		query.append("AND   A.CLM_AGN_CLM_PTY_NO   = D.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND   A.INSUR_AGN_CLM_PTY_NO = E.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND   A.DEFT_ATTY_CLM_PTY_NO = F.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND   A.INSUR_CLM_PTY_NO     = G.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND   A.CLMT_CLM_PTY_NO      = H.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("AND   SUBSTR(A.TRNK_REF_VVD_NO,1,4) = J.VSL_CD(+)" ).append("\n"); 

	}
}