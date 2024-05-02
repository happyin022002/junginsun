/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDPCSTurnTimeSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDPCSTurnTimeSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 : B/L Turn Time Report (ESM_BKG_0067) Summary Sheet추가 및 로직 변경으로 신규생성
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDPCSTurnTimeSummaryRSQL(){
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDPCSTurnTimeSummaryRSQL").append("\n"); 
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
		query.append("#if (${period} == 'OTH')" ).append("\n"); 
		query.append("SELECT RGN," ).append("\n"); 
		query.append("       RGN_CD," ).append("\n"); 
		query.append("       BKG_OFC_CD," ).append("\n"); 
		query.append("       TTL_BKG," ).append("\n"); 
		query.append("       INPUT_TTL_EVENT," ).append("\n"); 
		query.append("       INPUT_TTL_PIC," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_HOUR_DD," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_HOUR_HH," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_HOUR_MI," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_HOUR_SS," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_AVER_DD," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_AVER_HH," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_AVER_MI," ).append("\n"); 
		query.append("       '00' AS INPUT_TTL_AVER_SS," ).append("\n"); 
		query.append("       RATE_TTL_EVENT," ).append("\n"); 
		query.append("       RATE_TTL_PIC," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_HOUR_DD," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_HOUR_HH," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_HOUR_MI," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_HOUR_SS," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_AVER_DD," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_AVER_HH," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_AVER_MI," ).append("\n"); 
		query.append("       '00' AS RATE_TTL_AVER_SS," ).append("\n"); 
		query.append("       QA_TTL_EVENT," ).append("\n"); 
		query.append("       QA_TTL_PIC," ).append("\n"); 
		query.append("       '00' AS QA_TTL_HOUR_DD," ).append("\n"); 
		query.append("       '00' AS QA_TTL_HOUR_HH," ).append("\n"); 
		query.append("       '00' AS QA_TTL_HOUR_MI," ).append("\n"); 
		query.append("       '00' AS QA_TTL_HOUR_SS," ).append("\n"); 
		query.append("       '00' AS QA_TTL_AVER_DD," ).append("\n"); 
		query.append("       '00' AS QA_TTL_AVER_HH," ).append("\n"); 
		query.append("       '00' AS QA_TTL_AVER_MI," ).append("\n"); 
		query.append("       '00' AS QA_TTL_AVER_SS," ).append("\n"); 
		query.append("       TOTAL_TTL_EVENT," ).append("\n"); 
		query.append("       TOTAL_TTL_PIC," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_HOUR_DD," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_HOUR_HH," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_HOUR_MI," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_HOUR_SS," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_AVER_DD," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_AVER_HH," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_AVER_MI," ).append("\n"); 
		query.append("       '00' AS TOTAL_TTL_AVER_SS" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("       (SELECT NVL((SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                      FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                     WHERE INTG_CD_ID = 'CD01603'" ).append("\n"); 
		query.append("                       AND INTG_CD_VAL_CTNT = DECODE(RGN_CD, 'E', 'DE', 'J', 'JP', 'K', 'KR', 'N', 'US', 'S', 'PK', 'C','CN', 'XX'))," ).append("\n"); 
		query.append("                   '('||BKG_OFC_CD||')') AS RGN,    -- RGN," ).append("\n"); 
		query.append("               RGN_CD," ).append("\n"); 
		query.append("               BKG_OFC_CD," ).append("\n"); 
		query.append("			   TTL_BKG," ).append("\n"); 
		query.append("               '0' AS INPUT_TTL_EVENT," ).append("\n"); 
		query.append("               '0' AS INPUT_TTL_PIC," ).append("\n"); 
		query.append("               '0' AS INPUT_TTL_HOUR," ).append("\n"); 
		query.append("               '0' AS RATE_TTL_EVENT," ).append("\n"); 
		query.append("               '0' AS RATE_TTL_PIC," ).append("\n"); 
		query.append("               '0' AS  RATE_TTL_HOUR," ).append("\n"); 
		query.append("               '0' AS QA_TTL_EVENT," ).append("\n"); 
		query.append("               '0' AS QA_TTL_PIC," ).append("\n"); 
		query.append("               '0' AS QA_TTL_HOUR," ).append("\n"); 
		query.append("               '0' AS TOTAL_TTL_EVENT," ).append("\n"); 
		query.append("               '0' AS TOTAL_TTL_PIC," ).append("\n"); 
		query.append("               '0' AS TOTAL_TTL_HOUR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("               (SELECT " ).append("\n"); 
		query.append("                       COUNT(DISTINCT(BKG.BKG_NO)) TTL_BKG," ).append("\n"); 
		query.append("                       (SELECT DISTINCT RGN_OFC_CD" ).append("\n"); 
		query.append("                          FROM BKG_EML_ACCT_STUP" ).append("\n"); 
		query.append("                         WHERE BKG_OFC_CD = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS RGN_CD,    -- RGN_CD" ).append("\n"); 
		query.append("                       BKG.BKG_OFC_CD    -- BKG Ofc." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  FROM BKG_SR_CRNT_RQST SCR," ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${rgn_cd} != '')" ).append("\n"); 
		query.append("                       BKG_EML_ACCT_STUP EAS," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       BKG_BOOKING BKG," ).append("\n"); 
		query.append("                       BKG_SR_HIS HIS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bkg_no} == '')" ).append("\n"); 
		query.append("     #if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("          #if (${period} == 'WRK')" ).append("\n"); 
		query.append("                   /*    Working    */" ).append("\n"); 
		query.append("                   AND SCR.SR_WRK_STS_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                             AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                   AND (SCR.BL_DOC_INP_FLG  <> 'Y' OR SCR.BL_RT_FLG <> 'Y' OR SCR.BL_AUD_FLG <> 'Y')" ).append("\n"); 
		query.append("          #elseif (${period} == 'CPT')" ).append("\n"); 
		query.append("                   /*    Complete    */" ).append("\n"); 
		query.append("                   AND SCR.BL_AUD_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                         AND TO_DATE(@[to_dt], 'YYYY-MM-DD') +  0.99999" ).append("\n"); 
		query.append("                   AND (SCR.BL_DOC_INP_FLG  = 'Y' AND SCR.BL_RT_FLG = 'Y' AND SCR.BL_AUD_FLG = 'Y')" ).append("\n"); 
		query.append("		  #elseif (${period} == 'OTH')" ).append("\n"); 
		query.append("				   /*	 Other		*/" ).append("\n"); 
		query.append("                   AND SCR.SR_WRK_STS_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                         AND TO_DATE(@[to_dt], 'YYYY-MM-DD') +  0.99999" ).append("\n"); 
		query.append("                   AND (SCR.BL_DOC_INP_FLG  = 'N' AND SCR.BL_RT_FLG = 'N' AND SCR.BL_AUD_FLG = 'N')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${dpcs_ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND SCR.DPCS_OFC_CD = @[dpcs_ofc_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD LIKE @[vvd_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.BKG_OFC_CD LIKE '%'||@[bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${rgn_cd} != '')" ).append("\n"); 
		query.append("                   AND EAS.BKG_OFC_CD = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("                   AND EAS.RGN_OFC_CD IN (${rgn_cd})" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                   AND SCR.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND SCR.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = SCR.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                   AND HIS.SR_KND_CD = SCR.SR_KND_CD" ).append("\n"); 
		query.append("                   AND HIS.SR_NO = SCR.SR_NO" ).append("\n"); 
		query.append("                   AND HIS.BKG_NO = SCR.BKG_NO" ).append("\n"); 
		query.append("	 #if (${period} != 'OTH')" ).append("\n"); 
		query.append("                   AND HIS.SR_STS_CD IN ('ID', 'RD', 'AD')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("				  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 GROUP BY BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY RGN_CD," ).append("\n"); 
		query.append("          BKG_OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT RGN," ).append("\n"); 
		query.append("       RGN_CD," ).append("\n"); 
		query.append("       BKG_OFC_CD," ).append("\n"); 
		query.append("       TTL_BKG," ).append("\n"); 
		query.append("       INPUT_TTL_EVENT," ).append("\n"); 
		query.append("       INPUT_TTL_PIC," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR, 'DD'), '00') AS INPUT_TTL_HOUR_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR, 'HH'), '00') AS INPUT_TTL_HOUR_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR, 'MM'), '00') AS INPUT_TTL_HOUR_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR, 'SS'), '00') AS INPUT_TTL_HOUR_SS," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR / TTL_BKG, 'DD'), '00') AS INPUT_TTL_AVER_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR / TTL_BKG, 'HH'), '00') AS INPUT_TTL_AVER_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR / TTL_BKG, 'MM'), '00') AS INPUT_TTL_AVER_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(INPUT_TTL_HOUR / TTL_BKG, 'SS'), '00') AS INPUT_TTL_AVER_SS," ).append("\n"); 
		query.append("       RATE_TTL_EVENT," ).append("\n"); 
		query.append("       RATE_TTL_PIC," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR, 'DD'), '00') AS RATE_TTL_HOUR_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR, 'HH'), '00') AS RATE_TTL_HOUR_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR, 'MM'), '00') AS RATE_TTL_HOUR_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR, 'SS'), '00') AS RATE_TTL_HOUR_SS," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR / TTL_BKG, 'DD'), '00') AS RATE_TTL_AVER_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR / TTL_BKG, 'HH'), '00') AS RATE_TTL_AVER_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR / TTL_BKG, 'MM'), '00') AS RATE_TTL_AVER_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(RATE_TTL_HOUR / TTL_BKG, 'SS'), '00') AS RATE_TTL_AVER_SS," ).append("\n"); 
		query.append("       QA_TTL_EVENT," ).append("\n"); 
		query.append("       QA_TTL_PIC," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR, 'DD'), '00') AS QA_TTL_HOUR_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR, 'HH'), '00') AS QA_TTL_HOUR_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR, 'MM'), '00') AS QA_TTL_HOUR_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR, 'SS'), '00') AS QA_TTL_HOUR_SS," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR / TTL_BKG, 'DD'), '00') AS QA_TTL_AVER_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR / TTL_BKG, 'HH'), '00') AS QA_TTL_AVER_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR / TTL_BKG, 'MM'), '00') AS QA_TTL_AVER_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(QA_TTL_HOUR / TTL_BKG, 'SS'), '00') AS QA_TTL_AVER_SS," ).append("\n"); 
		query.append("       TOTAL_TTL_EVENT," ).append("\n"); 
		query.append("       TOTAL_TTL_PIC," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR, 'DD'), '00') AS TOTAL_TTL_HOUR_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR, 'HH'), '00') AS TOTAL_TTL_HOUR_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR, 'MM'), '00') AS TOTAL_TTL_HOUR_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR, 'SS'), '00') AS TOTAL_TTL_HOUR_SS," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR / TTL_BKG, 'DD'), '00') AS TOTAL_TTL_AVER_DD," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR / TTL_BKG, 'HH'), '00') AS TOTAL_TTL_AVER_HH," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR / TTL_BKG, 'MM'), '00') AS TOTAL_TTL_AVER_MI," ).append("\n"); 
		query.append("       NVL(BKG_GET_CONV_INTVAL_TIME_FNC(TOTAL_TTL_HOUR / TTL_BKG, 'SS'), '00') AS TOTAL_TTL_AVER_SS" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT NVL((SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                      FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                     WHERE INTG_CD_ID = 'CD01603'" ).append("\n"); 
		query.append("                       AND INTG_CD_VAL_CTNT = DECODE(RGN_CD, 'E', 'DE', 'J', 'JP', 'K', 'KR', 'N', 'US', 'S', 'PK', 'C', 'CN','XX'))," ).append("\n"); 
		query.append("                   '('||BKG_OFC_CD||')') AS RGN,    -- RGN," ).append("\n"); 
		query.append("               RGN_CD," ).append("\n"); 
		query.append("               BKG_OFC_CD," ).append("\n"); 
		query.append("               SUM(DECODE(SR_STS_CD, 'ID', TTL_BKG, 0)) AS TTL_BKG," ).append("\n"); 
		query.append("               SUM(INPUT_TTL_EVENT) AS INPUT_TTL_EVENT," ).append("\n"); 
		query.append("               SUM(DECODE(SR_STS_CD, 'ID', USER_ID, 0)) AS INPUT_TTL_PIC," ).append("\n"); 
		query.append("               SUM(INPUT_TTL_HOUR) AS INPUT_TTL_HOUR," ).append("\n"); 
		query.append("               SUM(RATE_TTL_EVENT) AS RATE_TTL_EVENT," ).append("\n"); 
		query.append("               SUM(DECODE(SR_STS_CD, 'RD', USER_ID, 0)) AS RATE_TTL_PIC," ).append("\n"); 
		query.append("               SUM(RATE_TTL_HOUR) AS  RATE_TTL_HOUR," ).append("\n"); 
		query.append("               SUM(QA_TTL_EVENT) AS QA_TTL_EVENT," ).append("\n"); 
		query.append("               SUM(DECODE(SR_STS_CD, 'AD', USER_ID, 0)) AS QA_TTL_PIC," ).append("\n"); 
		query.append("               SUM(QA_TTL_HOUR) AS QA_TTL_HOUR," ).append("\n"); 
		query.append("               SUM(INPUT_TTL_EVENT) + SUM(RATE_TTL_EVENT) + SUM(QA_TTL_EVENT) AS TOTAL_TTL_EVENT," ).append("\n"); 
		query.append("               SUM(DECODE(SR_STS_CD, 'ID', USER_ID, 0)) + SUM(DECODE(SR_STS_CD, 'RD', USER_ID, 0)) + SUM(DECODE(SR_STS_CD, 'AD', USER_ID, 0)) AS TOTAL_TTL_PIC," ).append("\n"); 
		query.append("               SUM(INPUT_TTL_HOUR) + SUM(RATE_TTL_HOUR) + SUM(QA_TTL_HOUR) AS TOTAL_TTL_HOUR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("               (SELECT HIS.SR_STS_CD," ).append("\n"); 
		query.append("                       (SELECT DISTINCT RGN_OFC_CD" ).append("\n"); 
		query.append("                          FROM BKG_EML_ACCT_STUP" ).append("\n"); 
		query.append("                         WHERE BKG_OFC_CD = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1) AS RGN_CD,    -- RGN_CD" ).append("\n"); 
		query.append("                       BKG.BKG_OFC_CD,    -- BKG Ofc." ).append("\n"); 
		query.append("                       COUNT(DISTINCT BKG.BKG_NO) TTL_BKG," ).append("\n"); 
		query.append("                       SUM(DECODE(SR_STS_CD, 'ID', 1, 0)) AS INPUT_TTL_EVENT,    -- INPUT_TTL_EVENT" ).append("\n"); 
		query.append("                       COUNT(DISTINCT BKG.BKG_OFC_CD||SR_STS_CD||ATND_USR_ID) USER_ID," ).append("\n"); 
		query.append("                       SUM(DECODE(SR_STS_CD, 'ID', SR_PROC_HRS, 0)) AS INPUT_TTL_HOUR,   -- INPUT_TTL_HOUR" ).append("\n"); 
		query.append("                       SUM(DECODE(SR_STS_CD, 'RD', 1, 0)) AS RATE_TTL_EVENT,   -- RATE_TTL_EVENT" ).append("\n"); 
		query.append("                       SUM(DECODE(SR_STS_CD, 'RD', SR_PROC_HRS, 0)) AS RATE_TTL_HOUR,   -- RATE_TTL_HOUR" ).append("\n"); 
		query.append("                       SUM(DECODE(SR_STS_CD, 'AD', 1, 0)) AS QA_TTL_EVENT,   -- QA_TTL_EVENT" ).append("\n"); 
		query.append("                       SUM(DECODE(SR_STS_CD, 'AD', SR_PROC_HRS, 0)) AS QA_TTL_HOUR    -- QA_TTL_HOUR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  FROM BKG_SR_CRNT_RQST SCR," ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${rgn_cd} != '')" ).append("\n"); 
		query.append("                       BKG_EML_ACCT_STUP EAS," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       BKG_BOOKING BKG," ).append("\n"); 
		query.append("                       BKG_SR_HIS HIS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bkg_no} == '')" ).append("\n"); 
		query.append("     #if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("          #if (${period} == 'WRK')" ).append("\n"); 
		query.append("                   /*    Working    */" ).append("\n"); 
		query.append("                   AND SCR.SR_WRK_STS_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                             AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                   AND (SCR.BL_DOC_INP_FLG  <> 'Y' OR SCR.BL_RT_FLG <> 'Y' OR SCR.BL_AUD_FLG <> 'Y')" ).append("\n"); 
		query.append("          #elseif (${period} == 'CPT')" ).append("\n"); 
		query.append("                   /*    Complete    */" ).append("\n"); 
		query.append("                   AND SCR.BL_AUD_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                         AND TO_DATE(@[to_dt], 'YYYY-MM-DD') +  0.99999" ).append("\n"); 
		query.append("                   AND (SCR.BL_DOC_INP_FLG  = 'Y' AND SCR.BL_RT_FLG = 'Y' AND SCR.BL_AUD_FLG = 'Y')" ).append("\n"); 
		query.append("		  #elseif (${period} == 'OTH')" ).append("\n"); 
		query.append("				   /*	 Other		*/" ).append("\n"); 
		query.append("                   AND SCR.SR_WRK_STS_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                         AND TO_DATE(@[to_dt], 'YYYY-MM-DD') +  0.99999" ).append("\n"); 
		query.append("                   AND (SCR.BL_DOC_INP_FLG  = 'N' AND SCR.BL_RT_FLG = 'N' AND SCR.BL_AUD_FLG = 'N')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${dpcs_ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND SCR.DPCS_OFC_CD = @[dpcs_ofc_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD LIKE @[vvd_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                   AND BKG.BKG_OFC_CD LIKE '%'||@[bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${rgn_cd} != '')" ).append("\n"); 
		query.append("                   AND EAS.BKG_OFC_CD = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("                   AND EAS.RGN_OFC_CD IN (${rgn_cd})" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                   AND SCR.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND SCR.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = SCR.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                   AND HIS.SR_KND_CD = SCR.SR_KND_CD" ).append("\n"); 
		query.append("                   AND HIS.SR_NO = SCR.SR_NO" ).append("\n"); 
		query.append("                   AND HIS.BKG_NO = SCR.BKG_NO" ).append("\n"); 
		query.append("	 #if (${period} != 'OTH')" ).append("\n"); 
		query.append("                   AND HIS.SR_STS_CD IN ('ID', 'RD', 'AD')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("				  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 GROUP BY BKG.BKG_OFC_CD," ).append("\n"); 
		query.append("                          HIS.SR_STS_CD" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         GROUP BY RGN_CD," ).append("\n"); 
		query.append("                  BKG_OFC_CD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY RGN_CD," ).append("\n"); 
		query.append("          BKG_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}