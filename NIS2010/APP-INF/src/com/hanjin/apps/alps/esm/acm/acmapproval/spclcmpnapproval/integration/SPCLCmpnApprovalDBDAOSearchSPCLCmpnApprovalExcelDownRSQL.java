/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalExcelDownRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.15 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalExcelDownRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSPCLCmpnApprovalExcelDown
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalExcelDownRSQL(){
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
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.integration").append("\n"); 
		query.append("FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnApprovalExcelDownRSQL").append("\n"); 
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
		query.append("SELECT 		" ).append("\n"); 
		query.append("		   A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000') AS CUST_CNT_SEQ," ).append("\n"); 
		query.append("           TO_CHAR(A.VNDR_SEQ,'FM000000') AS VNDR_SEQ,		" ).append("\n"); 
		query.append("           B.CUST_LGL_ENG_NM AS CUST_LGL_ENG_NM,		" ).append("\n"); 
		query.append("           A.CSR_NO,		" ).append("\n"); 
		query.append("           '' BKG_NO,		" ).append("\n"); 
		query.append("           '' BL_NO,		" ).append("\n"); 
		query.append("           COUNT(*) AS TOT_CNT,		" ).append("\n"); 
		query.append("		   ROUND(SUM(A.IF_AMT), 2) AS NET_AMT," ).append("\n"); 
		query.append("		   ROUND(SUM(A.IF_AMT * NVL(A.INV_TAX_RT, 0) / 100), 2) AS VAT," ).append("\n"); 
		query.append("		   ROUND(SUM(A.IF_AMT + (A.IF_AMT * NVL(A.INV_TAX_RT, 0) / 100)), 2) AS TOT_AMT," ).append("\n"); 
		query.append("           A.AP_OFC_CD,		" ).append("\n"); 
		query.append("           TO_CHAR(A.IF_DT,'YYYYMMDD') AS IF_DT,		" ).append("\n"); 
		query.append("           DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN) AS IF_RSN,		" ).append("\n"); 
		query.append("           DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN) AS RCV_RSN,		" ).append("\n"); 
		query.append("           D.IF_FLG AS IF_FLG,		" ).append("\n"); 
		query.append("           D.RCV_ERR_FLG AS RCV_FLG,		" ).append("\n"); 
		query.append("           D.PAY_AMT,		" ).append("\n"); 
		query.append("           D.PAY_DT,		" ).append("\n"); 
		query.append("           D.FTU_USE_CTNT1,		" ).append("\n"); 
		query.append("           D.PAY_MZD_LU_CD		" ).append("\n"); 
		query.append("      FROM ACM_SPCL_CMPN A,		" ).append("\n"); 
		query.append("           MDM_CUSTOMER B,		" ).append("\n"); 
		query.append("           ACM_AGN_BKG_INFO C,		" ).append("\n"); 
		query.append("           AP_INV_HDR D		" ).append("\n"); 
		query.append("     WHERE A.CUST_CNT_CD = B.CUST_CNT_CD		" ).append("\n"); 
		query.append("       AND A.CUST_SEQ = B.CUST_SEQ		" ).append("\n"); 
		query.append("       AND A.BKG_NO = C.BKG_NO		" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID != 'COST'		" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD IS NOT NULL		" ).append("\n"); 
		query.append("       AND C.BL_NO IS NOT NULL		" ).append("\n"); 
		query.append("       AND A.CSR_NO = D.CSR_NO(+)		" ).append("\n"); 
		query.append("       AND A.AR_OFC_CD = @[ar_ofc_cd]     		" ).append("\n"); 
		query.append("#if(${date_div} == 'C')		" ).append("\n"); 
		query.append("       AND A.CRE_DT		" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')		" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999		" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')		" ).append("\n"); 
		query.append("       AND A.VSL_DEP_DT		" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')		" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999		" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')		" ).append("\n"); 
		query.append("       AND A.IF_DT		" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')		" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if(${if_opt} == 'NI')		" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD <> 'IF'		" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'IF')		" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD = 'IF'		" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'PR')		" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD = 'PR'		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if(${cust_cnt_seq} != '')		" ).append("\n"); 
		query.append("       AND A.CUST_CNT_CD = substr(@[cust_cnt_seq], 0, 2)		" ).append("\n"); 
		query.append("       AND A.CUST_SEQ    = substr(@[cust_cnt_seq], 3, 6)		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if(${bl_no} != '')		" ).append("\n"); 
		query.append("       AND C.BL_NO		" ).append("\n"); 
		query.append("        IN		" ).append("\n"); 
		query.append("         ( $bl_no		" ).append("\n"); 
		query.append("         )		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("  GROUP BY 		" ).append("\n"); 
		query.append("		   A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000')," ).append("\n"); 
		query.append("           TO_CHAR(A.VNDR_SEQ,'FM000000'), 		" ).append("\n"); 
		query.append("           B.CUST_LGL_ENG_NM, A.CSR_NO, A.AP_OFC_CD, 		" ).append("\n"); 
		query.append("           TO_CHAR(A.IF_DT,'YYYYMMDD'),		" ).append("\n"); 
		query.append("           DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN),		" ).append("\n"); 
		query.append("           DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN),		" ).append("\n"); 
		query.append("           D.IF_FLG, D.RCV_ERR_FLG,		" ).append("\n"); 
		query.append("           D.PAY_AMT, D.PAY_DT, D.FTU_USE_CTNT1, D.PAY_MZD_LU_CD		" ).append("\n"); 
		query.append(" UNION ALL		" ).append("\n"); 
		query.append("    SELECT 		" ).append("\n"); 
		query.append("		   A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000') AS CUST_CNT_SEQ," ).append("\n"); 
		query.append("           TO_CHAR(A.VNDR_SEQ,'FM000000') AS VNDR_SEQ,		" ).append("\n"); 
		query.append("           B.CUST_LGL_ENG_NM AS CUST_LGL_ENG_NM,		" ).append("\n"); 
		query.append("           A.CSR_NO AS CSR_NO,		" ).append("\n"); 
		query.append("           A.BKG_NO,		" ).append("\n"); 
		query.append("           C.BL_NO,		" ).append("\n"); 
		query.append("           COUNT(*) AS TOT_CNT,		" ).append("\n"); 
		query.append("		   ROUND(SUM(A.IF_AMT), 2) AS NET_AMT," ).append("\n"); 
		query.append("		   ROUND(SUM(A.IF_AMT * NVL(A.INV_TAX_RT, 0) / 100), 2) AS VAT," ).append("\n"); 
		query.append("		   ROUND(SUM(A.IF_AMT + (A.IF_AMT * NVL(A.INV_TAX_RT, 0) / 100)), 2) AS TOT_AMT," ).append("\n"); 
		query.append("           '' AS AP_OFC_CD,		" ).append("\n"); 
		query.append("           NULL AS IF_DT,		" ).append("\n"); 
		query.append("           '' AS IF_RSN,		" ).append("\n"); 
		query.append("           '' AS RCV_RSN,		" ).append("\n"); 
		query.append("           '' AS IF_FLG,		" ).append("\n"); 
		query.append("           '' AS RCV_FLG,		" ).append("\n"); 
		query.append("           NULL AS PAY_AMT,		" ).append("\n"); 
		query.append("           NULL AS PAY_DT,		" ).append("\n"); 
		query.append("           '' AS FTU_USE_CTNT1,		" ).append("\n"); 
		query.append("           '' AS PAY_MZD_LU_CD		" ).append("\n"); 
		query.append("      FROM ACM_SPCL_CMPN A, 		" ).append("\n"); 
		query.append("           MDM_CUSTOMER B,		" ).append("\n"); 
		query.append("           ACM_AGN_BKG_INFO C,		" ).append("\n"); 
		query.append("           AP_INV_HDR D		" ).append("\n"); 
		query.append("     WHERE A.CUST_CNT_CD = B.CUST_CNT_CD		" ).append("\n"); 
		query.append("       AND A.CUST_SEQ = B.CUST_SEQ		" ).append("\n"); 
		query.append("       AND A.BKG_NO = C.BKG_NO		" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID != 'COST'		" ).append("\n"); 
		query.append("       AND A.AP_OFC_CD IS NOT NULL		" ).append("\n"); 
		query.append("       AND C.BL_NO IS NOT NULL		" ).append("\n"); 
		query.append("       AND A.CSR_NO = D.CSR_NO(+)		" ).append("\n"); 
		query.append("       AND A.AR_OFC_CD = @[ar_ofc_cd]     		" ).append("\n"); 
		query.append("#if(${date_div} == 'C')		" ).append("\n"); 
		query.append("       AND A.CRE_DT		" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')		" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999		" ).append("\n"); 
		query.append("#elseif(${date_div} == 'E')		" ).append("\n"); 
		query.append("       AND A.VSL_DEP_DT		" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')		" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999		" ).append("\n"); 
		query.append("#elseif(${date_div} == 'I')		" ).append("\n"); 
		query.append("       AND A.IF_DT		" ).append("\n"); 
		query.append("    BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')		" ).append("\n"); 
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.99999		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if(${if_opt} == 'NI')		" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD <> 'IF'		" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'IF')		" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD = 'IF'		" ).append("\n"); 
		query.append("#elseif(${if_opt} == 'PR')		" ).append("\n"); 
		query.append("       AND A.SPCL_CMPN_STS_CD = 'PR'		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if(${cust_cnt_seq} != '')		" ).append("\n"); 
		query.append("       AND A.CUST_CNT_CD = substr(@[cust_cnt_seq], 0, 2)		" ).append("\n"); 
		query.append("       AND A.CUST_SEQ    = substr(@[cust_cnt_seq], 3, 6)		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if(${bl_no} != '')		" ).append("\n"); 
		query.append("       AND C.BL_NO		" ).append("\n"); 
		query.append("        IN		" ).append("\n"); 
		query.append("         ( $bl_no		" ).append("\n"); 
		query.append("         )		" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("  GROUP BY 		" ).append("\n"); 
		query.append("		   A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ,'FM000000')," ).append("\n"); 
		query.append("           TO_CHAR(A.VNDR_SEQ,'FM000000'),		" ).append("\n"); 
		query.append("           B.CUST_LGL_ENG_NM, A.CSR_NO, A.BKG_NO, C.BL_NO		" ).append("\n"); 
		query.append("  ORDER BY CUST_CNT_SEQ, CSR_NO, BKG_NO DESC, TOT_CNT DESC" ).append("\n"); 

	}
}