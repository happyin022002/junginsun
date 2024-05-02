/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.24
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchFFCmpnApprovalPrintList
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n");
		query.append("FileName : FFCmpnApprovalDBDAOSearchFFCmpnApprovalPrintListRSQL").append("\n");
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
		query.append("ROWNUM SEQ," ).append("\n");
		query.append("CSR_NO," ).append("\n");
		query.append("VENDOR," ).append("\n");
		query.append("CUR," ).append("\n");
		query.append("AMOUNT," ).append("\n");
		query.append("VENDOR_NM" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("     A.CSR_NO CSR_NO," ).append("\n");
		query.append("     A.VNDR_SEQ VENDOR," ).append("\n");
		query.append("     'USD' CUR," ).append("\n");
		query.append("     SUM(A.IF_AMT) AMOUNT," ).append("\n");
		query.append("     F.VNDR_LGL_ENG_NM VENDOR_NM," ).append("\n");
		query.append("           A.BKG_FF_CNT_CD||TO_CHAR(A.BKG_FF_SEQ,'FM000000') AS FWDR," ).append("\n");
		query.append("           TO_CHAR(A.VNDR_SEQ,'FM000000')                        AS VNDR," ).append("\n");
		query.append("           B.CUST_LGL_ENG_NM                                     AS FWDR_NAME," ).append("\n");
		query.append("           COUNT(*)                                              AS TOT_CNT," ).append("\n");
		query.append("           SUM(A.IF_AMT)                                         AS TOT_AMT," ).append("\n");
		query.append("           A.VNDR_SEQ," ).append("\n");
		query.append("           A.AP_OFC_CD," ).append("\n");
		query.append("           TO_CHAR(A.IF_DT,'YYYYMMDD')                      AS IF_DATE," ).append("\n");
		query.append("           DECODE(D.IF_FLG,'Y','Success',D.IF_ERR_RSN)           AS IF_RSN," ).append("\n");
		query.append("           DECODE(D.RCV_ERR_FLG,'Y','Success',D.RCV_ERR_RSN)     AS RCV_RSN," ).append("\n");
		query.append("           D.IF_FLG                                              AS IF_FLG," ).append("\n");
		query.append("           D.RCV_ERR_FLG                                         AS RCV_FLG," ).append("\n");
		query.append("           D.PAY_AMT," ).append("\n");
		query.append("           D.PAY_DT," ).append("\n");
		query.append("           D.FTU_USE_CTNT1," ).append("\n");
		query.append("           D.PAY_MZD_LU_CD," ).append("\n");
		query.append("     F.GEN_PAY_TERM_CD AS VNDR_TERM_NM, " ).append("\n");
		query.append("     NVL(LTRIM(F.SUBS_CO_CD),'00') AS COA_INTER_COMPY_CD , " ).append("\n");
		query.append("     NVL(LTRIM(F.VNDR_LOCL_LANG_NM),F.VNDR_LGL_ENG_NM) AS INV_DESC" ).append("\n");
		query.append("      FROM ACM_FF_CMPN      A," ).append("\n");
		query.append("           MDM_CUSTOMER       B," ).append("\n");
		query.append("           ACM_AGN_BKG_INFO  C," ).append("\n");
		query.append("           AP_INV_HDR D," ).append("\n");
		query.append("     MDM_VENDOR F" ).append("\n");
		query.append("     WHERE A.BKG_FF_CNT_CD        = B.CUST_CNT_CD" ).append("\n");
		query.append("       AND A.BKG_FF_SEQ           = B.CUST_SEQ" ).append("\n");
		query.append("       AND A.BKG_NO           = C.BKG_NO" ).append("\n");
		query.append("       AND A.CRE_USR_ID      != 'COST'" ).append("\n");
		query.append("       AND A.AP_OFC_CD       IS NOT NULL" ).append("\n");
		query.append("       AND C.BL_NO           IS NOT NULL" ).append("\n");
		query.append("       AND A.CSR_NO           = D.CSR_NO(+)" ).append("\n");
		query.append("    AND A.VNDR_SEQ = F.VNDR_SEQ" ).append("\n");
		query.append("#if(${bl_no} != '')" ).append("\n");
		query.append("       AND C.BL_NO" ).append("\n");
		query.append("        IN" ).append("\n");
		query.append("         ( $bl_no" ).append("\n");
		query.append("         )" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${ff_cnt_seq} != '')" ).append("\n");
		query.append("       AND A.BKG_FF_CNT_CD = substr(@[ff_cnt_seq], 0, 2)" ).append("\n");
		query.append("       AND A.BKG_FF_SEQ    = substr(@[ff_cnt_seq], 3, 6)" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("       AND A.FF_CMPN_STS_CD" ).append("\n");
		query.append("        IN" ).append("\n");
		query.append("         ( 'IF'" ).append("\n");
		query.append("         )" ).append("\n");
		query.append("       AND A.IF_DT" ).append("\n");
		query.append("   BETWEEN TO_DATE(REPLACE(@[date_fm],'-', ''),'YYYYMMDD')" ).append("\n");
		query.append("       AND TO_DATE(REPLACE(@[date_to],'-', ''),'YYYYMMDD')+0.999999" ).append("\n");
		query.append(" GROUP BY " ).append("\n");
		query.append("    A.BKG_FF_CNT_CD||TO_CHAR(A.BKG_FF_SEQ,'FM000000')," ).append("\n");
		query.append("          TO_CHAR(A.VNDR_SEQ,'FM000000')," ).append("\n");
		query.append("          B.CUST_LGL_ENG_NM," ).append("\n");
		query.append("          A.VNDR_SEQ," ).append("\n");
		query.append("    F.VNDR_LGL_ENG_NM," ).append("\n");
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
		query.append("    F.GEN_PAY_TERM_CD, " ).append("\n");
		query.append("    NVL(LTRIM(F.SUBS_CO_CD),'00'), " ).append("\n");
		query.append("    NVL(LTRIM(F.VNDR_LOCL_LANG_NM),F.VNDR_LGL_ENG_NM) " ).append("\n");
		query.append(" ORDER BY 1" ).append("\n");
		query.append(")" ).append("\n");

	}
}