/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFFCmpnCSRDetail
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOSearchFFCmpnCSRDetailRSQL").append("\n"); 
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
		query.append("SELECT Y.CSR_NO" ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_SEQ" ).append("\n"); 
		query.append("       ,DENSE_RANK() OVER(ORDER BY X.ATT1, X.COMPANY, X.REGION, X.CENTER, X.ACCT, X.VVD) AS LINE_NO" ).append("\n"); 
		query.append("       ,X.LOOKUP AS LINE_TP_LU_CD, X.INV_AMT, X.INV_DESC, X.TAX_CD AS INV_TAX_CD, X.COMPANY AS DTRB_COA_CO_CD, X.REGION AS DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("       ,X.CENTER AS DTRB_COA_CTR_CD, X.ACCT AS DTRB_COA_ACCT_CD, X.VVD AS DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("       ,X.INTR_CMPY AS DTRB_COA_INTER_CO_CD, X.FUTURE1 AS DTRB_COA_FTU_N1ST_CD, X.FUTURE2 AS DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append("       ,X.ATT_CTLG AS ATTR_CATE_NM, X.ATT1 AS ATTR_CTNT1, X.ATT2 AS ATTR_CTNT2, X.ATT3 AS ATTR_CTNT3, X.ATT4 AS ATTR_CTNT2" ).append("\n"); 
		query.append("       ,X.ATT5 AS ATTR_CTNT5, X.ATT6 AS ATTR_CTNT6, X.ATT7 AS ATTR_CTNT7, X.ATT8 AS ATTR_CTNT8, X.ATT9 AS ATTR_CTNT9" ).append("\n"); 
		query.append("       ,X.ATT10 AS ATTR_CTNT10, X.ATT11 AS ATTR_CTNT11, X.ATT12 AS ATTR_CTNT12, X.ATT13 AS ATTR_CTNT13, X.ATT14 AS ATTR_CTNT14" ).append("\n"); 
		query.append("       ,X.ATT15 AS ATTR_CTNT15, X.BKG_NO, X.TPSZ AS CNTR_TPSZ_CD, X.REV_VVD AS ACT_VVD_CD, X.DIV_CD AS PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append("       ,X.CARRIER AS SO_CRR_CD, X.YARD AS YD_CD, X.COST_CODE AS FTU_USE_CTNT1, X.QTY AS FTU_USE_CTNT2, X.TMNL_CD AS FTU_USE_CTNT3" ).append("\n"); 
		query.append("       ,X.AGNT AS FTU_USE_CTNT4, X.SUB_FLG AS FTU_USE_CTNT5, X.BL_NO,  SYSDATE AS CRE_DT, @[cre_usr_id] AS CRE_USR_ID, SYSDATE AS EAI_EVNT_DT" ).append("\n"); 
		query.append("  FROM (SELECT A.VNDR_SEQ VNDR, " ).append("\n"); 
		query.append("               'ITEM' AS LOOKUP, " ).append("\n"); 
		query.append("               ROUND(NVL(B.IF_DTRB_AMT,A.IF_AMT),2) AS INV_AMT, " ).append("\n"); 
		query.append("               (SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = A.COMM_STND_COST_CD)||'/'||A.BKG_NO AS INV_DESC, " ).append("\n"); 
		query.append("               '' AS TAX_CD, " ).append("\n"); 
		query.append("               '01' AS COMPANY, " ).append("\n"); 
		query.append("               NVL((SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD),'00') AS REGION, " ).append("\n"); 
		query.append("               (SELECT AP_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD) AS CENTER, A.COMM_STND_COST_CD ACCT, " ).append("\n"); 
		query.append("        	   (SELECT DECODE(SUBSTR(REV_VVD_CD,0,2),'FD','CFDR'||SUBSTR(REV_VVD_CD,3,4)||'EE',REV_VVD_CD) FROM ACM_AGN_BKG_INFO WHERE BKG_NO = A.BKG_NO ) AS VVD, " ).append("\n"); 
		query.append("               (SELECT NVL(LTRIM(SUBS_CO_CD),'00') FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS INTR_CMPY, " ).append("\n"); 
		query.append("               '000000' AS FUTURE1, " ).append("\n"); 
		query.append("               '000000' AS FUTURE2, " ).append("\n"); 
		query.append("               A.COMM_STND_COST_CD AS ATT_CTLG, " ).append("\n"); 
		query.append("               C.BL_NO||SUBSTR(TO_CHAR(A.FF_CMPN_SEQ,'FM000000'),4,6) AS ATT1, " ).append("\n"); 
		query.append("               SUBSTR(@[gl_dt], 0, 4)||'/'||SUBSTR(@[gl_dt], 5, 2)||'/'||SUBSTR(@[gl_dt], 7, 2)||' 00:00:00' AS ATT2," ).append("\n"); 
		query.append("               A.FF_OCCR_INFO_CD AS ATT3, " ).append("\n"); 
		query.append("               '' AS ATT4, '' AS ATT5, '' AS ATT6, '' AS ATT7, '' AS ATT8, '' AS ATT9, " ).append("\n"); 
		query.append("               '' AS ATT10, '' AS ATT11, '' AS ATT12, '' AS ATT13, '' AS ATT14, '' AS ATT15, " ).append("\n"); 
		query.append("               A.BKG_NO, " ).append("\n"); 
		query.append("               B.CNTR_TPSZ_CD AS TPSZ, " ).append("\n"); 
		query.append("               DECODE(A.FF_SLAN_CD||SUBSTR(A.FF_VSL_CD,0,2),'RBCFD','CFDR'||SUBSTR(A.FF_VSL_CD,3,2)||SUBSTR(A.FF_SKD_VOY_NO,0,2)||'EE',  " ).append("\n"); 
		query.append("                      A.FF_VSL_CD||A.FF_SKD_VOY_NO||A.FF_SKD_DIR_CD||NVL(A.FF_REV_DIR_CD,A.FF_SKD_DIR_CD)) AS REV_VVD, " ).append("\n"); 
		query.append("               'C' AS DIV_CD, " ).append("\n"); 
		query.append("               '' AS CARRIER, " ).append("\n"); 
		query.append("               '' AS YARD, " ).append("\n"); 
		query.append("               '' AS COST_CODE, " ).append("\n"); 
		query.append("               B.BKG_VOL_QTY AS QTY, " ).append("\n"); 
		query.append("               '' AS TMNL_CD, " ).append("\n"); 
		query.append("               '' AS AGNT, " ).append("\n"); 
		query.append("               '' AS SUB_FLG, " ).append("\n"); 
		query.append("               C.BL_NO AS BL_NO, " ).append("\n"); 
		query.append("               A.CSR_NO AS CSR_NO " ).append("\n"); 
		query.append("          FROM ACM_FF_CMPN A, ACM_FF_CMPN_DTL B, ACM_AGN_BKG_INFO C " ).append("\n"); 
		query.append("         WHERE A.BKG_FF_CNT_CD||TO_CHAR(A.BKG_FF_SEQ,'FM000000') = @[ff_cnt_seq]" ).append("\n"); 
		query.append("/* 날짜 조회 조건 */	" ).append("\n"); 
		query.append("#if(${date_div} == 'B')	" ).append("\n"); 
		query.append("           AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("           AND C.BKG_CRE_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')	" ).append("\n"); 
		query.append("           AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("           AND A.VSL_DEP_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'C')	" ).append("\n"); 
		query.append("           AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("           AND A.UPD_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'P')	" ).append("\n"); 
		query.append("           AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("           AND A.APRO_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')	" ).append("\n"); 
		query.append("           AND A.IF_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A.FF_CMPN_STS_CD IN('CS','CM','CA') " ).append("\n"); 
		query.append("		   AND C.BKG_STS_CD <> 'A'" ).append("\n"); 
		query.append("           AND A.VNDR_SEQ  = @[vndr_seq]" ).append("\n"); 
		query.append("           AND A.AP_OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("           AND A.CRE_USR_ID != 'COST' " ).append("\n"); 
		query.append("           AND A.CSR_NO IS NOT NULL " ).append("\n"); 
		query.append("           AND C.BL_NO IS NOT NULL " ).append("\n"); 
		query.append("           AND (A.BKG_NO, A.FF_CMPN_SEQ) IN " ).append("\n"); 
		query.append("               (SELECT BKG_NO,   FF_CMPN_SEQ " ).append("\n"); 
		query.append("                  FROM ACM_FF_CMPN " ).append("\n"); 
		query.append("                 WHERE IF_DT IS NULL " ).append("\n"); 
		query.append("                   AND FF_CMPN_STS_CD IN('CS','CM','CA') " ).append("\n"); 
		query.append("                   AND VNDR_SEQ  = @[vndr_seq]" ).append("\n"); 
		query.append("                   AND BKG_FF_CNT_CD||TO_CHAR(BKG_FF_SEQ,'FM000000') = @[ff_cnt_seq]" ).append("\n"); 
		query.append("                   AND AP_OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("                   AND CSR_NO IS NOT NULL " ).append("\n"); 
		query.append("                   AND CRE_USR_ID != 'COST' " ).append("\n"); 
		query.append("                 ) " ).append("\n"); 
		query.append("           AND A.BKG_NO       = B.BKG_NO(+) " ).append("\n"); 
		query.append("           AND A.FF_CMPN_SEQ     = B.FF_CMPN_SEQ(+) " ).append("\n"); 
		query.append("           AND A.BKG_NO       = C.BKG_NO(+) " ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("       , " ).append("\n"); 
		query.append("       (SELECT CSR_NO, VNDR_NO " ).append("\n"); 
		query.append("          FROM AP_INV_HDR " ).append("\n"); 
		query.append("         WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("       ) Y " ).append("\n"); 
		query.append(" WHERE X.VNDR = Y.VNDR_NO " ).append("\n"); 
		query.append(" AND   X.CSR_NO = Y.CSR_NO" ).append("\n"); 

	}
}