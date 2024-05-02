/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchAPCInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchAPCInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAPCInvoice
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchAPCInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchAPCInvoiceRSQL").append("\n"); 
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
		query.append("SELECT AR_IF_NO MERGE_CHK " ).append("\n"); 
		query.append("    , EDI_HDR_SEQ" ).append("\n"); 
		query.append("    , AR_IF_NO" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , AR_OFC_CD" ).append("\n"); 
		query.append("    , REV_TP_SRC_CD" ).append("\n"); 
		query.append("    , ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , ACT_CUST_SEQ" ).append("\n"); 
		query.append("	, ACT_CUST_CNT_CD||'-'||LPAD(ACT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("    , (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("       WHERE CUST_CNT_CD = ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("       AND CUST_SEQ = ACT_CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , VVD " ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , SLAN_CD" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , IO_BND_CD" ).append("\n"); 
		query.append("    , POR_CD" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , POD_CD" ).append("\n"); 
		query.append("    , DEL_CD" ).append("\n"); 
		query.append("    , SC_NO" ).append("\n"); 
		query.append("    , RFA_NO" ).append("\n"); 
		query.append("    , INV_DT" ).append("\n"); 
		query.append("    , LOCL_CURR_CD" ).append("\n"); 
		query.append("    , INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("    , INV_DELT_DIV_CD" ).append("\n"); 
		query.append("    , EDI_SND_FLG" ).append("\n"); 
		query.append("    , TO_CHAR(EDI_SND_DT, 'YYYY-MM-DD HH24:MI:SS') EDI_SND_DT" ).append("\n"); 
		query.append("    , EDI_TP_CD" ).append("\n"); 
		query.append("    , CHG_SEQ" ).append("\n"); 
		query.append("    , CHG_CD " ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , PER_TP_CD" ).append("\n"); 
		query.append("    , TRF_RT_AMT" ).append("\n"); 
		query.append("    , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("    , CHG_AMT" ).append("\n"); 
		query.append("    , TVA_FLG" ).append("\n"); 
		query.append("    , CUST_CR_FLG" ).append("\n"); 
		query.append("    , CR_TERM_DYS AS PAY_COND" ).append("\n"); 
		query.append("    , CHG_REF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    #if(${gubun} == 'S')" ).append("\n"); 
		query.append("        SELECT NULL EDI_HDR_SEQ " ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("	        , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , A.INV_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.ISS_DT INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , A.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , 'APC' EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , SAR_GET_FMT_MASK_FNC(B.CURR_CD,B.CHG_AMT) AS CHG_AMT   " ).append("\n"); 
		query.append("            , B.TVA_FLG" ).append("\n"); 
		query.append("            , A.CUST_CR_FLG " ).append("\n"); 
		query.append("            , A.DUE_DT" ).append("\n"); 
		query.append("			, A.CR_TERM_DYS" ).append("\n"); 
		query.append("            , '' CHG_REF_NO" ).append("\n"); 
		query.append("        FROM INV_AR_MN A,   " ).append("\n"); 
		query.append("             INV_AR_CHG B" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO      " ).append("\n"); 
		query.append("        AND A.AR_IF_NO IN (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                           FROM INV_AR_MN" ).append("\n"); 
		query.append("                           WHERE AR_OFC_CD = 'BUEBA'" ).append("\n"); 
		query.append("                           AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                           AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                           AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                           AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                           --AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')" ).append("\n"); 
		query.append("                           AND OTS_PAY_CD IS NULL AND ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("                           GROUP BY BL_SRC_NO, DECODE(NVL(INV_SPLIT_CD, 'M'), 'S', AR_IF_NO, BL_SRC_NO))" ).append("\n"); 
		query.append("        AND A.INV_DELT_DIV_CD = 'N'                   " ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X' FROM BKG_CNTR_RT WHERE BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("        AND NOT EXISTS (SELECT 'X' FROM INV_EDI_HDR WHERE AR_IF_NO = A.AR_IF_NO AND EDI_TP_CD = 'APC' )  " ).append("\n"); 
		query.append("		AND B.CHG_AMT <> 0" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NULL EDI_HDR_SEQ " ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("	        , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , A.INV_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.ISS_DT INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , A.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , 'APC' EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , SAR_GET_FMT_MASK_FNC(B.CURR_CD,B.CHG_AMT) AS CHG_AMT   " ).append("\n"); 
		query.append("            , B.TVA_FLG" ).append("\n"); 
		query.append("            , A.CUST_CR_FLG " ).append("\n"); 
		query.append("            , A.DUE_DT" ).append("\n"); 
		query.append("			, A.CR_TERM_DYS" ).append("\n"); 
		query.append("            , '' CHG_REF_NO" ).append("\n"); 
		query.append("        FROM INV_AR_MN A,  " ).append("\n"); 
		query.append("             INV_AR_CHG B,       " ).append("\n"); 
		query.append("             (" ).append("\n"); 
		query.append("                    SELECT (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                            FROM INV_AR_MN" ).append("\n"); 
		query.append("                            WHERE BL_SRC_NO = IAM.BL_SRC_NO" ).append("\n"); 
		query.append("                            AND AR_OFC_CD = IAM.AR_OFC_CD" ).append("\n"); 
		query.append("                            AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                            AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')  " ).append("\n"); 
		query.append("                            AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                            AND INV_DELT_DIV_CD = 'N' " ).append("\n"); 
		query.append("                            AND AR_IF_NO < IAM.AR_IF_NO) AS MAX_AR_IF_NO, IAM.AR_IF_NO AS CXL_AR_IF_NO" ).append("\n"); 
		query.append("                    FROM INV_AR_MN IAM" ).append("\n"); 
		query.append("                    WHERE AR_OFC_CD = 'BUEBA'" ).append("\n"); 
		query.append("                    AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                    AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                    AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')" ).append("\n"); 
		query.append("                    AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                    AND INV_DELT_DIV_CD = 'X' " ).append("\n"); 
		query.append("                    AND IAM.OTS_PAY_CD IS NULL AND IAM.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("                    AND AR_IF_NO NOT IN (SELECT AR_IF_NO   " ).append("\n"); 
		query.append("                                         FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                         WHERE EDI_TP_CD = 'APC')                               " ).append("\n"); 
		query.append("             ) C" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        AND   A.AR_IF_NO = C.CXL_AR_IF_NO" ).append("\n"); 
		query.append("        AND   C.MAX_AR_IF_NO IN (SELECT AR_IF_NO   " ).append("\n"); 
		query.append("                                 FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                 WHERE EDI_TP_CD = 'APC')    " ).append("\n"); 
		query.append("        AND   B.CHG_AMT <> 0" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT NULL EDI_HDR_SEQ " ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("	        , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , A.INV_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.ISS_DT INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , A.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , 'APC' EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , SAR_GET_FMT_MASK_FNC(B.CURR_CD,B.CHG_AMT) AS CHG_AMT   " ).append("\n"); 
		query.append("            , B.TVA_FLG" ).append("\n"); 
		query.append("            , A.CUST_CR_FLG " ).append("\n"); 
		query.append("            , A.DUE_DT" ).append("\n"); 
		query.append("			, A.CR_TERM_DYS" ).append("\n"); 
		query.append("            , '' CHG_REF_NO" ).append("\n"); 
		query.append("        FROM INV_AR_MN A,   " ).append("\n"); 
		query.append("             INV_AR_CHG B" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        AND A.OTS_PAY_CD IS NULL AND A.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("        AND A.AR_OFC_CD = 'BUEBA'" ).append("\n"); 
		query.append("        AND A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("        AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("        AND A.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("        AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("        AND NOT EXISTS (SELECT 'X' FROM INV_EDI_HDR WHERE AR_IF_NO = A.AR_IF_NO AND EDI_TP_CD = 'APC' )  " ).append("\n"); 
		query.append("		AND B.CHG_AMT <> 0" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT A.EDI_HDR_SEQ" ).append("\n"); 
		query.append("	        , A.AR_IF_NO" ).append("\n"); 
		query.append("            , A.BL_NO" ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , A.INV_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD " ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VVD_CD AS VVD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , (SELECT INV_DELT_DIV_CD FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO) INV_DELT_DIV_CD" ).append("\n"); 
		query.append("            , A.EDI_SND_FLG" ).append("\n"); 
		query.append("            , A.EDI_SND_DT" ).append("\n"); 
		query.append("            , A.EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , SAR_GET_FMT_MASK_FNC(B.CURR_CD,B.CHG_AMT) AS CHG_AMT   " ).append("\n"); 
		query.append("            , B.TVA_FLG" ).append("\n"); 
		query.append("            , (SELECT CUST_CR_FLG FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO) AS CUST_CR_FLG  " ).append("\n"); 
		query.append("	        , (SELECT DUE_DT FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO) AS DUE_DT " ).append("\n"); 
		query.append("			, (SELECT CR_TERM_DYS FROM INV_AR_MN WHERE AR_IF_NO = A.AR_IF_NO) AS CR_TERM_DYS " ).append("\n"); 
		query.append("            , '' CHG_REF_NO" ).append("\n"); 
		query.append("        FROM INV_EDI_HDR A," ).append("\n"); 
		query.append("             INV_AR_CHG B " ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        AND A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("        #if(${gubun} == 'S')" ).append("\n"); 
		query.append("            AND SUBSTR(A.REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND SUBSTR(A.REV_TP_SRC_CD, 1, 1) = 'M'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND A.EDI_TP_CD = 'APC'    " ).append("\n"); 
		query.append("        AND B.CHG_AMT <> 0" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("ORDER BY AR_OFC_CD" ).append("\n"); 
		query.append("        , BL_NO" ).append("\n"); 
		query.append("        , AR_IF_NO" ).append("\n"); 
		query.append("        , CHG_SEQ" ).append("\n"); 

	}
}