/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchDryWetClaimVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.05.12 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchDryWetClaimVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dry & Wet Clamin를 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchDryWetClaimVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchDryWetClaimVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	 A.DW_CLM_NO" ).append("\n"); 
		query.append("	,A.DW_CLM_TP_CD" ).append("\n"); 
		query.append("	,A.DW_CO_CD" ).append("\n"); 
		query.append("	,A.DW_CLM_REF_VVD_NO" ).append("\n"); 
		query.append("	,A.VSL_ENG_NM" ).append("\n"); 
		query.append("	,A.INCI_PLC_TP_CD" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.INCI_OCCR_DT, 'YYYYMMDD'),'YYYY-MM-DD') INCI_OCCR_DT" ).append("\n"); 
		query.append("    ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("    ,A.HDLR_OFC_CD" ).append("\n"); 
		query.append("	,A.HDLR_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.TM_BAR_DT, 'YYYYMMDD'),'YYYY-MM-DD') TM_BAR_DT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.LIT_DT, 'YYYYMMDD'),'YYYY-MM-DD') LIT_DT" ).append("\n"); 
		query.append("	,A.DW_CLM_STS_CD" ).append("\n"); 
		query.append("	,A.DW_CLM_ATT_DEF_TP_CD" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.PRLM_CLM_NTFY_DT, 'YYYYMMDD'),'YYYY-MM-DD') PRLM_CLM_NTFY_DT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.CS_CLZ_DT, 'YYYYMMDD'),'YYYY-MM-DD') CS_CLZ_DT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.ARBT_DT, 'YYYYMMDD'),'YYYY-MM-DD') ARBT_DT" ).append("\n"); 
		query.append("	,A.CLMT_CLM_PTY_NO" ).append("\n"); 
		query.append("  ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.CLMT_CLM_PTY_NO) CLMT_CLM_PTY_NM" ).append("\n"); 
		query.append("	,A.CLMT_CTNT" ).append("\n"); 
		query.append("	,A.INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append("  ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.INSUR_CLM_PTY_NO) INSUR_CLM_PTY_NM" ).append("\n"); 
		query.append("	,TO_CHAR(A.DDCT_USD_AMT,'FM999,999,999,990.00') DDCT_USD_AMT" ).append("\n"); 
		query.append("	,A.DEFT_CLM_PTY_NO" ).append("\n"); 
		query.append("  ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.DEFT_CLM_PTY_NO) DEFT_CLM_PTY_NM" ).append("\n"); 
		query.append("	,A.DEFT_CTNT" ).append("\n"); 
		query.append("	,A.LABL_PTY_CLM_PTY_NO" ).append("\n"); 
		query.append("  ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.LABL_PTY_CLM_PTY_NO) LABL_PTY_CLM_PTY_NM" ).append("\n"); 
		query.append("	,A.LABL_PTY_CTNT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.LABL_PTY_TM_BAR_DT, 'YYYYMMDD'),'YYYY-MM-DD') LABL_PTY_TM_BAR_DT" ).append("\n"); 
		query.append("	,A.CLM_LOCL_CURR_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.CLM_LOCL_AMT,'FM999,999,999,990.00') CLM_LOCL_AMT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.FMAL_CLM_RCV_DT, 'YYYYMMDD'),'YYYY-MM-DD') FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("	,TO_CHAR(A.CLM_XCH_RT,'FM999,990.00000') CLM_XCH_RT" ).append("\n"); 
		query.append("	,TO_CHAR(A.CLM_USD_AMT,'FM999,999,999,990.00') CLM_USD_AMT" ).append("\n"); 
		query.append("	,A.CLM_STL_LOCL_CURR_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.CLM_STL_LOCL_AMT,'FM999,999,999,990.00') CLM_STL_LOCL_AMT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.CLM_STL_DT, 'YYYYMMDD'),'YYYY-MM-DD') CLM_STL_DT" ).append("\n"); 
		query.append("	,TO_CHAR(A.CLM_STL_XCH_RT,'FM999,990.00000') CLM_STL_XCH_RT" ).append("\n"); 
		query.append("	,TO_CHAR(A.CLM_STL_USD_AMT,'FM999,999,999,990.00') CLM_STL_USD_AMT" ).append("\n"); 
		query.append("	,A.LABL_PTY_FILE_LOCL_CURR_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.LABL_PTY_FILE_LOCL_AMT,'FM999,999,999,990.00') LABL_PTY_FILE_LOCL_AMT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.LABL_PTY_FILE_DT, 'YYYYMMDD'),'YYYY-MM-DD') LABL_PTY_FILE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(A.LABL_PTY_FILE_XCH_RT,'FM999,990.00000') LABL_PTY_FILE_XCH_RT" ).append("\n"); 
		query.append("	,TO_CHAR(A.LABL_PTY_FILE_USD_AMT,'FM999,999,999,990.00') LABL_PTY_FILE_USD_AMT" ).append("\n"); 
		query.append("	,A.LABL_PTY_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.LABL_PTY_RCVR_LOCL_AMT,'FM999,999,999,990.00') LABL_PTY_RCVR_LOCL_AMT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.LABL_PTY_RCVR_DT, 'YYYYMMDD'),'YYYY-MM-DD') LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append("	,TO_CHAR(A.LABL_PTY_RCVR_XCH_RT,'FM999,990.00000') LABL_PTY_RCVR_XCH_RT" ).append("\n"); 
		query.append("	,TO_CHAR(A.LABL_PTY_RCVR_USD_AMT,'FM999,999,999,990.00') LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append("	,A.INSUR_FILE_LOCL_CURR_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.INSUR_FILE_LOCL_AMT,'FM999,999,999,990.00') INSUR_FILE_LOCL_AMT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.INSUR_FILE_DT, 'YYYYMMDD'),'YYYY-MM-DD') INSUR_FILE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(A.INSUR_FILE_XCH_RT,'FM999,990.00000') INSUR_FILE_XCH_RT" ).append("\n"); 
		query.append("	,TO_CHAR(A.INSUR_FILE_USD_AMT,'FM999,999,999,990.00') INSUR_FILE_USD_AMT" ).append("\n"); 
		query.append("	,A.INSUR_RCVR_LOCL_CURR_CD" ).append("\n"); 
		query.append("	,TO_CHAR(A.INSUR_RCVR_LOCL_AMT,'FM999,999,999,990.00') INSUR_RCVR_LOCL_AMT" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.INSUR_RCVR_DT, 'YYYYMMDD'),'YYYY-MM-DD') INSUR_RCVR_DT" ).append("\n"); 
		query.append("	,TO_CHAR(A.INSUR_RCVR_XCH_RT,'FM999,990.00000') INSUR_RCVR_XCH_RT" ).append("\n"); 
		query.append("	,TO_CHAR(A.INSUR_RCVR_USD_AMT,'FM999,999,999,990.00') INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append("	,A.DW_CLM_CS_DESC" ).append("\n"); 
		query.append("	,A.INCI_DEV_DESC" ).append("\n"); 
		query.append("	,A.HDLR_STL_OPIN_DESC" ).append("\n"); 
		query.append("	,A.CLMT_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append("    ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.CLMT_AGN_CLM_PTY_NO) CLMT_AGN_CLM_PTY_NM" ).append("\n"); 
		query.append("    ,(SELECT NVL(INTL_PHN_NO,'')||'-'||NVL(PHN_NO,'') FROM CNI_PARTY WHERE CLM_PTY_NO = A.CLMT_AGN_CLM_PTY_NO) CLMT_AGN_TEL_NO" ).append("\n"); 
		query.append("    ,(SELECT PTY_EML FROM CNI_PARTY WHERE CLM_PTY_NO = A.CLMT_AGN_CLM_PTY_NO) CLMT_AGN_EMAIL" ).append("\n"); 
		query.append("	,A.CLMT_AGN_TP_CD" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.CLMT_AGN_APNT_DT, 'YYYYMMDD'),'YYYY-MM-DD') CLMT_AGN_APNT_DT" ).append("\n"); 
		query.append("	,A.CLMT_AGN_REF_NO" ).append("\n"); 
		query.append("	,A.DEFT_AGN_CLM_PTY_NO" ).append("\n"); 
		query.append("    ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.DEFT_AGN_CLM_PTY_NO) DEFT_AGN_CLM_PTY_NM" ).append("\n"); 
		query.append("    ,(SELECT NVL(INTL_PHN_NO,'')||DECODE(INTL_PHN_NO,NULL,'','-')||NVL(PHN_NO,'') FROM CNI_PARTY WHERE CLM_PTY_NO = A.DEFT_AGN_CLM_PTY_NO) DEFT_AGN_TEL_NO" ).append("\n"); 
		query.append("    ,(SELECT PTY_EML FROM CNI_PARTY WHERE CLM_PTY_NO = A.DEFT_AGN_CLM_PTY_NO) DEFT_AGN_EMAIL" ).append("\n"); 
		query.append("	,A.DEFT_AGN_TP_CD" ).append("\n"); 
		query.append("	,TO_CHAR(TO_DATE(A.DEFT_AGN_APNT_DT, 'YYYYMMDD'),'YYYY-MM-DD') DEFT_AGN_APNT_DT" ).append("\n"); 
		query.append("	,A.DEFT_AGN_REF_NO" ).append("\n"); 
		query.append("    ,A.TRNS_FLG" ).append("\n"); 
		query.append("    ,I.CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append("    ,I.TRNS_SEQ" ).append("\n"); 
		query.append("	,A.CRE_USR_ID" ).append("\n"); 
		query.append("	,A.CRE_DT" ).append("\n"); 
		query.append("	,A.UPD_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("    , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) R_HANDLER" ).append("\n"); 
		query.append("FROM    CNI_DW_CLM A" ).append("\n"); 
		query.append("    ,   ( SELECT DW_CLM_NO" ).append("\n"); 
		query.append("            , TRNS_SEQ" ).append("\n"); 
		query.append("            , CLM_TRNS_AUTH_CD " ).append("\n"); 
		query.append("         FROM CNI_DW_TRNS" ).append("\n"); 
		query.append("        WHERE DW_CLM_NO = @[dw_clm_no]" ).append("\n"); 
		query.append("          AND CLM_TRNS_AUTH_CD IN('W','R')" ).append("\n"); 
		query.append("          AND TRNS_SEQ = (SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("                            FROM CNI_DW_TRNS" ).append("\n"); 
		query.append("                           WHERE DW_CLM_NO = @[dw_clm_no])" ).append("\n"); 
		query.append("      ) I" ).append("\n"); 
		query.append("WHERE	A.DW_CLM_NO = @[dw_clm_no]" ).append("\n"); 
		query.append("  AND   A.DW_CLM_NO = I.DW_CLM_NO(+)" ).append("\n"); 

	}
}