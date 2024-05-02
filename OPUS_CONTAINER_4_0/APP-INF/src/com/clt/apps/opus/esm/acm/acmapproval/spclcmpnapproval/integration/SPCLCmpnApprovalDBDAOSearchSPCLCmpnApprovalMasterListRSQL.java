/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalMasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCLCmpnApprovalMaster
	  * 
	  * 2016.05.16 박다은 [CSR:#13041] [Split - 2] Insert CSR Creation Date column in all CSR I/F screens
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalMasterListRSQL(){
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
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_opt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration").append("\n"); 
		query.append("FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalMasterListRSQL").append("\n"); 
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
		query.append("           A.CUST_CNT_CD," ).append("\n"); 
		query.append("           TO_CHAR(A.CUST_SEQ,'FM000000') AS CUST_SEQ," ).append("\n"); 
		query.append("           A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000')         AS CUST_CNT_SEQ," ).append("\n"); 
		query.append("           TO_CHAR(A.VNDR_SEQ,'FM000000')                        AS VNDR_SEQ," ).append("\n"); 
		query.append("           B.CUST_LGL_ENG_NM                                     AS FWDR_NAME," ).append("\n"); 
		query.append("           COUNT(*)                                              AS TOT_CNT," ).append("\n"); 
		query.append("           ROUND(SUM(IF_AMT), 2)                                 AS NET_AMT," ).append("\n"); 
		query.append("           NVL(AVG(INV_TAX_RT), 0)                               AS VAT," ).append("\n"); 
		query.append("           ROUND(SUM(IF_AMT + (IF_AMT * NVL(INV_TAX_RT, 0) / 100)), 2) AS TOT_AMT," ).append("\n"); 
		query.append("           A.PAY_XCH_RT                                          AS PAY_XCH_RT," ).append("\n"); 
		query.append("           A.CURR_CD                                             AS CURR_CD," ).append("\n"); 
		query.append("           ROUND(SUM(A.PAY_IF_AMT + (A.PAY_IF_AMT * NVL(A.INV_TAX_RT, 0) / 100)), 2) AS PAY_TOT_AMT," ).append("\n"); 
		query.append("           A.VNDR_SEQ," ).append("\n"); 
		query.append("           A.AP_OFC_CD," ).append("\n"); 
		query.append("           A.CSR_NO," ).append("\n"); 
		query.append("           TO_CHAR(A.IF_DT,'YYYYMMDD')                           AS IF_DATE," ).append("\n"); 
		query.append("           DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN)           AS IF_RSN," ).append("\n"); 
		query.append("           DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN)     AS RCV_RSN," ).append("\n"); 
		query.append("           D.IF_FLG                                              AS IF_FLG," ).append("\n"); 
		query.append("           D.RCV_ERR_FLG                                         AS RCV_FLG," ).append("\n"); 
		query.append("           D.PAY_AMT," ).append("\n"); 
		query.append("           D.PAY_DT," ).append("\n"); 
		query.append("           D.FTU_USE_CTNT1," ).append("\n"); 
		query.append("           D.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("           F.GEN_PAY_TERM_CD                                     AS VNDR_TERM_NM," ).append("\n"); 
		query.append("           NVL(LTRIM(F.subs_co_cd),'00')                         AS COA_INTER_COMPY_CD ," ).append("\n"); 
		query.append("           NVL(LTRIM(F.vndr_locl_lang_nm),F.vndr_lgl_eng_nm)     AS INV_DESC," ).append("\n"); 
		query.append("           D.CRE_DT 			 AS CSR_CRE_DT," ).append("\n"); 
		query.append("           MAX (CSR.RQST_USR_ID) AS RQST_USR_ID," ).append("\n"); 
		query.append("           MAX (CSR.RQST_USR_NM) AS RQST_USR_NM," ).append("\n"); 
		query.append("           MAX (CSR.APRO_USR_ID) AS APRO_USR_ID," ).append("\n"); 
		query.append("           MAX (CSR.APRO_USR_NM) AS APRO_USR_NM	" ).append("\n"); 
		query.append("      FROM ACM_SPCL_CMPN      A," ).append("\n"); 
		query.append("           MDM_CUSTOMER       B," ).append("\n"); 
		query.append("           ACM_AGN_BKG_INFO   C," ).append("\n"); 
		query.append("           AP_INV_HDR         D," ).append("\n"); 
		query.append("           MDM_VENDOR         F," ).append("\n"); 
		query.append("           (SELECT H.RQST_USR_ID AS RQST_USR_ID" ).append("\n"); 
		query.append("                 , H.RQST_USR_NM AS RQST_USR_NM" ).append("\n"); 
		query.append("                 , R.APRO_USR_ID AS APRO_USR_ID" ).append("\n"); 
		query.append("                 , R.APRO_USR_NM AS APRO_USR_NM" ).append("\n"); 
		query.append("                 , D.CSR_NO      AS CSR_NO" ).append("\n"); 
		query.append("              FROM COM_APRO_RQST_HDR H" ).append("\n"); 
		query.append("                 , COM_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("                 , COM_APRO_CSR_DTL D" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND H.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("               AND H.CRNT_APRO_SEQ = R.APRO_RQST_SEQ" ).append("\n"); 
		query.append("               AND R.APRO_RQST_NO = D.APRO_RQST_NO" ).append("\n"); 
		query.append("             ) CSR " ).append("\n"); 
		query.append("     WHERE A.CUST_CNT_CD      = B.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND A.CUST_SEQ         = B.CUST_SEQ" ).append("\n"); 
		query.append("       AND A.BKG_NO           = C.BKG_NO" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID      != 'COST'" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD        IS NOT NULL" ).append("\n"); 
		query.append("       AND C.BL_NO            IS NOT NULL" ).append("\n"); 
		query.append("       AND A.CSR_NO           = D.CSR_NO(+)" ).append("\n"); 
		query.append("       AND D.CSR_NO           = CSR.CSR_NO(+)" ).append("\n"); 
		query.append("       AND A.VNDR_SEQ         = F.VNDR_SEQ" ).append("\n"); 
		query.append("       AND A.AR_OFC_CD        = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#if(${date_div} == 'C')" ).append("\n"); 
		query.append("       AND C.BKG_CRE_DT" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')" ).append("\n"); 
		query.append("       AND A.VSL_DEP_DT" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')" ).append("\n"); 
		query.append("       AND A.IF_DT" ).append("\n"); 
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_opt} == 'CS')" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD     = 'CS'" ).append("\n"); 
		query.append("       AND NVL(A.PAY_CHK_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'PS')" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD IN ( 'IF', @[if_opt] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND D.IF_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ff_cnt_seq} != '')" ).append("\n"); 
		query.append("       AND A.CUST_CNT_CD      = substr(@[ff_cnt_seq], 0, 2)" ).append("\n"); 
		query.append("       AND A.CUST_SEQ         = substr(@[ff_cnt_seq], 3, 6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '')" ).append("\n"); 
		query.append("       AND C.BL_NO" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         ( $bl_no" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY A.CUST_CNT_CD," ).append("\n"); 
		query.append("          A.CUST_SEQ," ).append("\n"); 
		query.append("          A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000')," ).append("\n"); 
		query.append("          TO_CHAR(A.VNDR_SEQ,'FM000000')," ).append("\n"); 
		query.append("          B.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("          A.VNDR_SEQ," ).append("\n"); 
		query.append("          A.PAY_XCH_RT," ).append("\n"); 
		query.append("          A.CURR_CD,     " ).append("\n"); 
		query.append("          A.AP_OFC_CD," ).append("\n"); 
		query.append("          A.CSR_NO," ).append("\n"); 
		query.append("          TO_CHAR(A.IF_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("          DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN)," ).append("\n"); 
		query.append("          DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN)," ).append("\n"); 
		query.append("          D.IF_FLG," ).append("\n"); 
		query.append("          D.RCV_ERR_FLG," ).append("\n"); 
		query.append("          D.PAY_AMT," ).append("\n"); 
		query.append("          D.PAY_DT," ).append("\n"); 
		query.append("          D.FTU_USE_CTNT1," ).append("\n"); 
		query.append("          D.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("          F.GEN_PAY_TERM_CD," ).append("\n"); 
		query.append("          NVL(LTRIM(F.subs_co_cd),'00')," ).append("\n"); 
		query.append("          NVL(LTRIM(F.vndr_locl_lang_nm),F.vndr_lgl_eng_nm)," ).append("\n"); 
		query.append("          D.CRE_DT" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}