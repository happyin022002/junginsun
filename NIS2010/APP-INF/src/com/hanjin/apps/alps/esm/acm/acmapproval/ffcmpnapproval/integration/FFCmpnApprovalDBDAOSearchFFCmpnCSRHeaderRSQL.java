/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOSearchFFCmpnCSRHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
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

public class FFCmpnApprovalDBDAOSearchFFCmpnCSRHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFFCmpnApprovalMasterList
	  * 
	  * 2015.08.05 Sang-Hyun Kim [CHM-201537067] Split01-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  *   - NYCNA > NYCRA
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOSearchFFCmpnCSRHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_div",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_em",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOSearchFFCmpnCSRHeaderRSQL").append("\n"); 
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
		query.append("(/* 3.GET CSR_NO */" ).append("\n"); 
		query.append("SELECT '08'|| A.CSR_AMT_CD ||@[ap_ofc_cd]||SUBSTR(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE, 'USNYC' ),'YYYYMMDD'),3,6)||TO_CHAR(" ).append("\n"); 
		query.append("        NVL(MAX(TO_NUMBER(SUBSTR(CSR_NO,LENGTH(CSR_NO)-4)))+1,10001) ,'FM00000') AS CSR_NO" ).append("\n"); 
		query.append("FROM AP_CSR_NO " ).append("\n"); 
		query.append("WHERE CSR_NO LIKE '08'|| A.CSR_AMT_CD ||@[ap_ofc_cd]||SUBSTR(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE, 'USNYC' ),'YYYYMMDD'),3,6)||'%'" ).append("\n"); 
		query.append(") AS CSR_NO" ).append("\n"); 
		query.append(", DECODE(SIGN(A.CSR_AMT),-1,'CREDIT','STANDARD') AS CSR_TP_CD" ).append("\n"); 
		query.append(", NVL(REPLACE(@[inv_dt], '-'),TO_CHAR(SYSDATE,'YYYYMMDD')) AS INV_DT" ).append("\n"); 
		query.append(", NVL(REPLACE(@[inv_dt], '-'),TO_CHAR(SYSDATE,'YYYYMMDD')) AS INV_TERM_DT" ).append("\n"); 
		query.append(",'20120523' AS GL_DT " ).append("\n"); 
		query.append(", @[vndr_seq] AS VNDR_NO" ).append("\n"); 
		query.append(", ROUND(A.CSR_AMT,2) AS CSR_AMT  " ).append("\n"); 
		query.append(", 0 AS PAY_AMT" ).append("\n"); 
		query.append(", null AS PAY_DT" ).append("\n"); 
		query.append(", 'USD' AS CSR_CURR_CD" ).append("\n"); 
		query.append(", '3' AS VNDR_TERM_NM" ).append("\n"); 
		query.append(", C.INV_DESC" ).append("\n"); 
		query.append(", 'Invoices' AS ATTR_CATE_NM" ).append("\n"); 
		query.append(", null AS ATTR_CTNT1, null AS ATTR_CTNT2, null AS ATTR_CTNT3, null AS ATTR_CTNT4, null AS ATTR_CTNT5, null AS ATTR_CTNT6, null AS ATTR_CTNT7" ).append("\n"); 
		query.append(", TO_CHAR(sysdate,'yyyymmddhh24miss') AS ATTR_CTNT8, null AS ATTR_CTNT9, @[usr_nm] AS ATTR_CTNT10" ).append("\n"); 
		query.append(", null AS ATTR_CTNT11, null AS ATTR_CTNT12, null AS ATTR_CTNT13, null AS ATTR_CTNT14, null AS ATTR_CTNT15, null AS GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(", null AS GLO_ATTR_CTNT2, null AS GLO_ATTR_CTNT3, null AS GLO_ATTR_CTNT4, null AS GLO_ATTR_CTNT5, null AS GLO_ATTR_CTNT6, null AS GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(", null AS GLO_ATTR_CTNT8, null AS GLO_ATTR_CTNT9, null AS GLO_ATTR_CTNT10, null AS GLO_ATTR_CTNT11, null AS GLO_ATTR_CTNT12, null AS GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(", null AS GLO_ATTR_CTNT14, null AS GLO_ATTR_CTNT15, null AS GLO_ATTR_CTNT16, null AS GLO_ATTR_CTNT17, null AS GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(", 'BROKERAGE' AS SRC_CTNT--srcCtnt" ).append("\n"); 
		query.append(", D.PAY_MZD_LU_CD --payMzdLuCd" ).append("\n"); 
		query.append(", D.PAY_GRP_LU_CD --payGrpLuCd" ).append("\n"); 
		query.append(", '01' AS COA_CO_CD" ).append("\n"); 
		query.append(", D.COA_RGN_CD --coaRgnCd" ).append("\n"); 
		query.append(", D.COA_CTR_CD --coaCtrCd" ).append("\n"); 
		query.append(",'210111' AS COA_ACCT_CD, '0000000000' AS COA_VVD_CD" ).append("\n"); 
		query.append(", C.COA_INTER_COMPY_CD AS COA_INTER_CO_CD--coaIntrCmpyCd" ).append("\n"); 
		query.append(", '000000' AS COA_FTU_N1ST_CD, '000000' AS COA_FTU_N2ND_CD, null AS PPD_NO, null AS PPD_DTRB_NO, null AS PPD_APLY_AMT, null AS PPD_GL_DT" ).append("\n"); 
		query.append(", 'Y' AS APRO_FLG, 'N' AS TAX_DECL_FLG, null AS ERR_CSR_NO, null AS IF_FLG, null AS IF_DT, null AS IF_ERR_RSN, 'N' AS PPAY_APLY_FLG" ).append("\n"); 
		query.append(", @[ap_ofc_cd] AS TJ_OFC_CD --ap_ofc_cd" ).append("\n"); 
		query.append(", null AS ACT_XCH_RT, null AS IMP_ERR_FLG, null AS RCV_ERR_FLG, null AS TAX_CURR_XCH_FLG, @[usr_em] AS USR_EML--userEm" ).append("\n"); 
		query.append(", null AS IMP_ERR_RSN, null AS RCV_ERR_RSN, null AS FTU_USE_CTNT1, null AS FTU_USE_CTNT2, null AS FTU_USE_CTNT3, null AS FTU_USE_CTNT4, null AS FTU_USE_CTNT5" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT, @[usr_id] AS CRE_USR_ID, SYSDATE AS EAI_EVNT_DT" ).append("\n"); 
		query.append(", D.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", @[ap_ofc_cd] AS AP_OFC_CD" ).append("\n"); 
		query.append(", @[vndr_seq] AS VNDR_SEQ" ).append("\n"); 
		query.append(", @[ff_cnt_seq] AS FF_CNT_SEQ" ).append("\n"); 
		query.append(", @[date_div] AS DATE_DIV" ).append("\n"); 
		query.append(", @[date_fm] AS DATE_FM" ).append("\n"); 
		query.append(", @[date_to] AS DATE_TO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("/* 7.GET CSR_AMOUNT */" ).append("\n"); 
		query.append("(SELECT NVL(SUM(ROUND(A.IF_AMT,2)),0) AS CSR_AMT," ).append("\n"); 
		query.append("CASE WHEN NVL(SUM(ROUND(A.IF_AMT,2)),0) >= 0 THEN 'S'" ).append("\n"); 
		query.append("ELSE 'C' END CSR_AMT_CD" ).append("\n"); 
		query.append(" FROM ACM_FF_CMPN A, ACM_AGN_BKG_INFO B " ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("  AND A.BKG_FF_CNT_CD||TO_CHAR(A.BKG_FF_SEQ,'FM000000') = @[ff_cnt_seq]" ).append("\n"); 
		query.append("  AND A.AP_OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("  /* 날짜 조회 조건 */	" ).append("\n"); 
		query.append("#if(${date_div} == 'B')	" ).append("\n"); 
		query.append("   AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("   AND B.BKG_CRE_DT	" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')	" ).append("\n"); 
		query.append("   AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("   AND A.VSL_DEP_DT	" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'C')	" ).append("\n"); 
		query.append("   AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("   AND A.UPD_DT	" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'P')	" ).append("\n"); 
		query.append("   AND A.IF_DT IS NULL" ).append("\n"); 
		query.append("   AND A.APRO_DT	" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')	" ).append("\n"); 
		query.append("   AND A.IF_DT	" ).append("\n"); 
		query.append("BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("   AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND A.FF_CMPN_STS_CD IN('CS','CM','CA') " ).append("\n"); 
		query.append("  AND B.BKG_STS_CD <> 'A'" ).append("\n"); 
		query.append("  AND A.BKG_NO       = B.BKG_NO " ).append("\n"); 
		query.append("  AND A.CRE_USR_ID != 'COST' " ).append("\n"); 
		query.append("  AND B.BL_NO IS NOT NULL " ).append("\n"); 
		query.append("--  AND A.CSR_NO        = '08SNYCNA12051610001' " ).append("\n"); 
		query.append("  AND (A.BKG_NO, A.FF_CMPN_SEQ) IN  " ).append("\n"); 
		query.append("      (SELECT BKG_NO, FF_CMPN_SEQ  " ).append("\n"); 
		query.append("         FROM ACM_FF_CMPN " ).append("\n"); 
		query.append("         WHERE FF_CMPN_STS_CD IN('CS','CM','CA') " ).append("\n"); 
		query.append("         /* 날짜 조회 조건 */	" ).append("\n"); 
		query.append("#if(${date_div} == 'B')	" ).append("\n"); 
		query.append("           AND IF_DT IS NULL" ).append("\n"); 
		query.append("           AND BKG_CRE_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')	" ).append("\n"); 
		query.append("           AND IF_DT IS NULL" ).append("\n"); 
		query.append("           AND VSL_DEP_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'C')	" ).append("\n"); 
		query.append("           AND IF_DT IS NULL" ).append("\n"); 
		query.append("           AND UPD_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'P')	" ).append("\n"); 
		query.append("           AND IF_DT IS NULL" ).append("\n"); 
		query.append("           AND APRO_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')	" ).append("\n"); 
		query.append("           AND IF_DT	" ).append("\n"); 
		query.append("        BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')	" ).append("\n"); 
		query.append("           AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--          AND CSR_NO     = '08SNYCNA12051610001' " ).append("\n"); 
		query.append("          AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("          AND BKG_FF_CNT_CD||TO_CHAR(BKG_FF_SEQ,'FM000000') = @[ff_cnt_seq] 	--:frt_fwrd_cnt_cd        " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/* GET VNDR_TERM_NM, COA_INTER_COMPY_CD, INV_DESC */" ).append("\n"); 
		query.append(" SELECT GEN_PAY_TERM_CD, " ).append("\n"); 
		query.append("       NVL(LTRIM(SUBS_CO_CD),'00') AS COA_INTER_COMPY_CD, " ).append("\n"); 
		query.append("       NVL(LTRIM(VNDR_LOCL_LANG_NM),VNDR_LGL_ENG_NM) AS INV_DESC" ).append("\n"); 
		query.append("  FROM MDM_VENDOR " ).append("\n"); 
		query.append(" WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/* 8.GET PAY_MZD_LU_CD, PAY_GRP_LU_CD, COA_RGN_CD, COA_CTR_CD */" ).append("\n"); 
		query.append("SELECT DECODE(B.CONTI_CD,'M','CMS CHECK(O/EXP)','E','CMS WIRE','WIRE') AS PAY_MZD_LU_CD, " ).append("\n"); 
		query.append("       'NYCRA_BROKERAGE' AS PAY_GRP_LU_CD," ).append("\n"); 
		query.append("        NVL(A.FINC_RGN_CD,'00') AS COA_RGN_CD," ).append("\n"); 
		query.append("        A.AP_CTR_CD AS COA_CTR_CD," ).append("\n"); 
		query.append("        A.AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append(" FROM MDM_ORGANIZATION A, MDM_LOCATION B " ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("  AND A.LOC_CD = B.LOC_CD(+)" ).append("\n"); 
		query.append("  AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append(") D" ).append("\n"); 

	}
}