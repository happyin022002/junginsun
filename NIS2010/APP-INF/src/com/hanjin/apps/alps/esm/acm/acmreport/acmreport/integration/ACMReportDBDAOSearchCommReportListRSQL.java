/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ACMReportDBDAOSearchCommReportListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOSearchCommReportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ACMReportDBDAOSearchCommReportListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration").append("\n"); 
		query.append("FileName : ACMReportDBDAOSearchCommReportListRSQL").append("\n"); 
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
		query.append("SELECT LIS.BL_NO," ).append("\n"); 
		query.append("  LIS.BKG_NO," ).append("\n"); 
		query.append("  LIS.IO_BND_CD," ).append("\n"); 
		query.append("  LIS.COMM_VVD," ).append("\n"); 
		query.append("  LIS.REV_VVD," ).append("\n"); 
		query.append("  LIS.SAIL_ARR_DT," ).append("\n"); 
		query.append("  LIS.POR_CD," ).append("\n"); 
		query.append("  LIS.POL_CD," ).append("\n"); 
		query.append("  LIS.POD_CD," ).append("\n"); 
		query.append("  LIS.DEL_CD," ).append("\n"); 
		query.append("  LIS.TEU_FEU," ).append("\n"); 
		query.append("  LIS.FAC_AMT," ).append("\n"); 
		query.append("  LIS.COM_I," ).append("\n"); 
		query.append("  LIS.COM_II," ).append("\n"); 
		query.append("  LIS.BROKERAGE_AMT," ).append("\n"); 
		query.append("  LIS.CHF_AMT," ).append("\n"); 
		query.append("  LIS.TS_AMT," ).append("\n"); 
		query.append("  LIS.TR_AMT," ).append("\n"); 
		query.append("  LIS.SOC_AMT," ).append("\n"); 
		query.append("  LIS.CROSS_AMT," ).append("\n"); 
		query.append("  LIS.DOC_AMT," ).append("\n"); 
		query.append("  LIS.DDCT_AMT," ).append("\n"); 
		query.append("  LIS.USD_AMT," ).append("\n"); 
		query.append("  LIS.CURR_CD," ).append("\n"); 
		query.append("  LIS.CALC_DT," ).append("\n"); 
		query.append("  LIS.RQST_DT," ).append("\n"); 
		query.append("  LIS.APRO_DT," ).append("\n"); 
		query.append("  LIS.IF_DT," ).append("\n"); 
		query.append("  LIS.PPD_FRT_AMT," ).append("\n"); 
		query.append("  LIS.CLT_FRT_AMT," ).append("\n"); 
		query.append("  LIS.PPD_OTR_AMT," ).append("\n"); 
		query.append("  LIS.CLT_OTR_AMT," ).append("\n"); 
		query.append("  LIS.NET_AMT," ).append("\n"); 
		query.append("  LIS.GROSS_AMT," ).append("\n"); 
		query.append("  LIS.PYMT_AMT," ).append("\n"); 
		query.append("  LIS.FF_CD," ).append("\n"); 
		query.append("  LIS.FF_NAME," ).append("\n"); 
		query.append("  LIS.FF_ADDR," ).append("\n"); 
		query.append("  LIS.BRO_ADDR1," ).append("\n"); 
		query.append("  LIS.BRO_ADDR2," ).append("\n"); 
		query.append("  LIS.BRO_ADDR3," ).append("\n"); 
		query.append("  LIS.BRO_ADDR4," ).append("\n"); 
		query.append("  LIS.BRO_ADDR5," ).append("\n"); 
		query.append("  LIS.BRO_ADDR6," ).append("\n"); 
		query.append("  LIS.PAN_CODE," ).append("\n"); 
		query.append("  LIS.TRD_CD," ).append("\n"); 
		query.append("  LIS.RLANE_CD," ).append("\n"); 
		query.append("  LIS.DIR_CD," ).append("\n"); 
		query.append("  LIS.TEU," ).append("\n"); 
		query.append("  LIS.FEU," ).append("\n"); 
		query.append("  LIS.AUD_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT /*+ PARALLEL(AGN, 16) */" ).append("\n"); 
		query.append("#if (${report_item} != '')" ).append("\n"); 
		query.append("    DENSE_RANK() OVER(ORDER BY ${report_item}) AS RANK," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    DENSE_RANK() OVER(ORDER BY 1) AS RANK," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    MAX(INF.BL_NO) AS BL_NO," ).append("\n"); 
		query.append("    MAX(AGN.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("    MAX(AGN.IO_BND_CD) AS IO_BND_CD," ).append("\n"); 
		query.append("    MAX(AGN.AC_VSL_CD || AGN.AC_SKD_VOY_NO || AGN.AC_SKD_DIR_CD) AS COMM_VVD," ).append("\n"); 
		query.append("    MAX(INF.REV_VVD_CD) AS REV_VVD," ).append("\n"); 
		query.append("    MAX(TO_CHAR(TO_DATE(SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD')) AS SAIL_ARR_DT," ).append("\n"); 
		query.append("    MAX(INF.POR_CD) AS POR_CD," ).append("\n"); 
		query.append("    MAX(INF.POL_CD) AS POL_CD," ).append("\n"); 
		query.append("    MAX(INF.POD_CD) AS POD_CD," ).append("\n"); 
		query.append("    MAX(INF.DEL_CD) AS DEL_CD," ).append("\n"); 
		query.append("    NVL(MAX((SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0))" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY" ).append("\n"); 
		query.append("             WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ), 0" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    || '/' ||" ).append("\n"); 
		query.append("    NVL(MAX((SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY))" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY" ).append("\n"); 
		query.append("             WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ), 0" ).append("\n"); 
		query.append("    ) AS TEU_FEU," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM((SELECT CRNT_AMT" ).append("\n"); 
		query.append("                     FROM ACM_FAC_COMM" ).append("\n"); 
		query.append("                     WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("                       AND FAC_SEQ = (SELECT /*+INDEX_DESC(X XPKACM_FAC_COMM) */" ).append("\n"); 
		query.append("                                        X.FAC_SEQ" ).append("\n"); 
		query.append("                                      FROM ACM_FAC_COMM X" ).append("\n"); 
		query.append("                                      WHERE ROWNUM < 2 AND X.BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                ), 0" ).append("\n"); 
		query.append("            ), '999,999,999,999,990.99'" ).append("\n"); 
		query.append("    ) AS FAC_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'G', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS COM_I," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'N', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS COM_II," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'K', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS BROKERAGE_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'H', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS CHF_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'S', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS TS_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'R', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS TR_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'O', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS SOC_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'C', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS CROSS_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'D', AGN.IF_AMT, 0 )), 0), '999,999,999,999,990.99') AS DOC_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(MAX(AGN.DDCT_CHG_AMT + AGN.DDCT_TRSP_AMT + AGN.DDCT_SPCL_CMPN_AMT), 0), '999,999,999,999,990.99') AS DDCT_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'G', AGN.IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'N', AGN.IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'K', AGN.IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'H', AGN.IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'S', AGN.IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'R', AGN.IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'O', AGN.IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'T', AGN.IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'C', AGN.IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'D', AGN.IF_AMT, 0)" ).append("\n"); 
		query.append("                ), 0" ).append("\n"); 
		query.append("            ), '999,999,999,999,990.99'" ).append("\n"); 
		query.append("    ) AS USD_AMT," ).append("\n"); 
		query.append("    MAX(AGN.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("    MAX(TO_CHAR(AGN.CRE_DT, 'YYYY-MM-DD')) AS CALC_DT," ).append("\n"); 
		query.append("    MAX(TO_CHAR(AGN.RQST_DT, 'YYYY-MM-DD')) AS RQST_DT," ).append("\n"); 
		query.append("    MAX(TO_CHAR(AGN.APRO_DT, 'YYYY-MM-DD')) AS APRO_DT," ).append("\n"); 
		query.append("    MAX(TO_CHAR(AGN.IF_DT, 'YYYY-MM-DD')) AS IF_DT," ).append("\n"); 
		query.append("    TO_CHAR(MAX(INF.PPD_OFRT_AMT), '999,999,999,999,990.99') AS PPD_FRT_AMT," ).append("\n"); 
		query.append("    TO_CHAR(MAX(INF.CLT_OFRT_AMT), '999,999,999,999,990.99') AS CLT_FRT_AMT," ).append("\n"); 
		query.append("    TO_CHAR(MAX(INF.PPD_CHG_AMT), '999,999,999,999,990.99') AS PPD_OTR_AMT," ).append("\n"); 
		query.append("    TO_CHAR(MAX(INF.CLT_CHG_AMT), '999,999,999,999,990.99') AS CLT_OTR_AMT," ).append("\n"); 
		query.append("    TO_CHAR(MAX(INF.PPD_OFRT_AMT + INF.CLT_OFRT_AMT), '999,999,999,999,990.99') AS NET_AMT," ).append("\n"); 
		query.append("    TO_CHAR(MAX(INF.PPD_OFRT_AMT + INF.PPD_CHG_AMT + INF.CLT_OFRT_AMT + INF.CLT_CHG_AMT), '999,999,999,999,990.99') AS GROSS_AMT," ).append("\n"); 
		query.append("    TO_CHAR(NVL(SUM(DECODE(AGN.AC_TP_CD, 'G', AGN.PAY_IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'N', AGN.PAY_IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'K', AGN.PAY_IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'H', AGN.PAY_IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'S', AGN.PAY_IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'R', AGN.PAY_IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'O', AGN.PAY_IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'T', AGN.PAY_IF_AMT, 0)" ).append("\n"); 
		query.append("                  + DECODE(AGN.AC_TP_CD, 'C', AGN.PAY_IF_AMT, 0) + DECODE(AGN.AC_TP_CD, 'D', AGN.PAY_IF_AMT, 0)" ).append("\n"); 
		query.append("                ), 0" ).append("\n"); 
		query.append("            ), '999,999,999,999,990.99'" ).append("\n"); 
		query.append("    ) AS PYMT_AMT," ).append("\n"); 
		query.append("--  컬럼 추가 하여 조회쿼리 변경 " ).append("\n"); 
		query.append("--  (SELECT MAX (CUS.CUST_CNT_CD) || TO_CHAR (MAX (CUS.CUST_SEQ), 'FM000000')" ).append("\n"); 
		query.append("--      FROM BKG_CUSTOMER CUS" ).append("\n"); 
		query.append("--      WHERE CUS.BKG_NO = INF.BKG_NO" ).append("\n"); 
		query.append("--      AND CUS.BKG_CUST_TP_CD = 'F') AS FF_CD," ).append("\n"); 
		query.append("    (MAX (INF.FRT_FWRD_CNT_CD) || TO_CHAR (MAX (INF.FRT_FWRD_SEQ), 'FM000000')) AS FF_CD," ).append("\n"); 
		query.append("    MAX(CASE 'BOMSC' WHEN AGN.AR_OFC_CD THEN NVL((SELECT E.CUST_NM" ).append("\n"); 
		query.append("                                                  FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("                                                  WHERE INF.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                                    AND E.BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("                                                 )," ).append("\n"); 
		query.append("                                                 (SELECT E.CUST_NM" ).append("\n"); 
		query.append("                                                  FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("                                                  WHERE INF.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                                    AND E.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                     ELSE (SELECT NVL(D.CUST_LOCL_LANG_NM, D.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("                           FROM MDM_CUSTOMER D," ).append("\n"); 
		query.append("                             BKG_CUSTOMER E" ).append("\n"); 
		query.append("                           WHERE E.CUST_CNT_CD = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                             AND E.CUST_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("                             AND INF.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("                             AND E.BKG_CUST_TP_CD(+)  = 'F'" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("    ) AS FF_NAME," ).append("\n"); 
		query.append("    MAX((SELECT E.CUST_ADDR" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("         WHERE INF.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("           AND E.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS FF_ADDR," ).append("\n"); 
		query.append("    MAX((SELECT SCE_TOKEN_NL_FNC(CUST_ADDR, 1)" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("         WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("           AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS BRO_ADDR1," ).append("\n"); 
		query.append("    MAX((SELECT SCE_TOKEN_NL_FNC(CUST_ADDR, 2)" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("         WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("           AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS BRO_ADDR2," ).append("\n"); 
		query.append("    MAX((SELECT SCE_TOKEN_NL_FNC(CUST_ADDR, 3)" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("         WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("           AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS BRO_ADDR3," ).append("\n"); 
		query.append("    MAX((SELECT SCE_TOKEN_NL_FNC(CUST_ADDR, 4)" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("         WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("           AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS BRO_ADDR4," ).append("\n"); 
		query.append("    MAX((SELECT SCE_TOKEN_NL_FNC(CUST_ADDR, 5)" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("         WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("           AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS BRO_ADDR5," ).append("\n"); 
		query.append("    MAX((SELECT SCE_TOKEN_NL_FNC(CUST_ADDR, 6)" ).append("\n"); 
		query.append("         FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("         WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("           AND BKG_CUST_TP_CD = 'B'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS BRO_ADDR6," ).append("\n"); 
		query.append("    MAX((SELECT BRF.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("         FROM BKG_REFERENCE BRF" ).append("\n"); 
		query.append("         WHERE BRF.BKG_REF_TP_CD = 'BRKN'" ).append("\n"); 
		query.append("           AND BRF.BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) AS PAN_CODE," ).append("\n"); 
		query.append("    MAX(INF.TRD_CD) AS TRD_CD," ).append("\n"); 
		query.append("    MAX(INF.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("    MAX(AGN.AC_SKD_DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("    NVL(MAX((SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0))" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY" ).append("\n"); 
		query.append("             WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ), 0" ).append("\n"); 
		query.append("    ) AS TEU," ).append("\n"); 
		query.append("    NVL(MAX((SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY))" ).append("\n"); 
		query.append("             FROM BKG_QUANTITY" ).append("\n"); 
		query.append("             WHERE BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ), 0" ).append("\n"); 
		query.append("    ) AS FEU," ).append("\n"); 
		query.append("    MAX(AGN.AUD_NO) AS AUD_NO" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM AGN," ).append("\n"); 
		query.append("    ACM_AGN_BKG_INFO INF" ).append("\n"); 
		query.append("  WHERE AGN.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("    AND AGN.BKG_NO = AGN.BKG_NO" ).append("\n"); 
		query.append("    AND AGN.BKG_NO = INF.BKG_NO" ).append("\n"); 
		query.append("    AND AGN.AC_SEQ = AGN.AC_SEQ" ).append("\n"); 
		query.append("#if (${agn_cd} != '')" ).append("\n"); 
		query.append("    AND AGN.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_trd_cd} != '')" ).append("\n"); 
		query.append("    AND INF.TRD_CD = @[s_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_rlane_cd} != '')" ).append("\n"); 
		query.append("    AND INF.RLANE_CD = @[s_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_dir_cd} != '')" ).append("\n"); 
		query.append("    AND AGN.AC_SKD_DIR_CD = @[s_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND AGN.AC_TP_CD IN ('G', 'N', 'K', 'H', 'S', 'R', 'O', 'T', 'C', 'D')" ).append("\n"); 
		query.append("    AND AGN.IO_BND_CD IN (CASE @[io_bnd_cd] WHEN 'O' THEN 'O'" ).append("\n"); 
		query.append("                                            WHEN 'I' THEN 'I'" ).append("\n"); 
		query.append("                                            ELSE AGN.IO_BND_CD" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#if (${comm_vvd} != '')" ).append("\n"); 
		query.append("    AND AGN.AC_VSL_CD || AGN.AC_SKD_VOY_NO || AGN.AC_SKD_DIR_CD = @[comm_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND INF.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("    AND INF.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("    AND INF.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("    AND INF.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("    AND INF.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("    AND INF.BL_NO IN (${bl_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aud_no} != '')" ).append("\n"); 
		query.append("    AND AGN.AUD_NO = @[aud_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND AGN.AC_STS_CD <> 'CZ' -- [선처리] CZ(Calculation - ZeroAMT) 데이터는 조회 안되도록 로직 추가" ).append("\n"); 
		query.append("#if (${sts_option} == 'CS')" ).append("\n"); 
		query.append("    AND AGN.AC_STS_CD IN ('CS', 'CE', 'IC', 'CA')" ).append("\n"); 
		query.append("    AND AGN.CRE_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'RS')" ).append("\n"); 
		query.append("    AND AGN.AC_STS_CD IN ('RS','RM')" ).append("\n"); 
		query.append("    AND AGN.RQST_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'AS')" ).append("\n"); 
		query.append("    AND AGN.AC_STS_CD IN ('AS')" ).append("\n"); 
		query.append("    AND AGN.AUD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'PS')" ).append("\n"); 
		query.append("    AND AGN.AC_STS_CD IN ('PS')" ).append("\n"); 
		query.append("    AND AGN.APRO_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'IS')" ).append("\n"); 
		query.append("    AND AGN.AC_STS_CD IN ('IF')" ).append("\n"); 
		query.append("    AND AGN.IF_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'RR')" ).append("\n"); 
		query.append("    AND AGN.AC_STS_CD IN ('RR', 'AR', 'PR', 'IC')" ).append("\n"); 
		query.append("    AND AGN.UPD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND AGN.CRE_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${report_item} != '')" ).append("\n"); 
		query.append("  GROUP BY ${report_item}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") LIS" ).append("\n"); 

	}
}