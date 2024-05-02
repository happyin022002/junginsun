/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchUnitPriceDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchUnitPriceDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUnitPriceData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchUnitPriceDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("request_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchUnitPriceDataRSQL").append("\n"); 
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
		query.append("WITH TEMP_DROP AS (" ).append("\n"); 
		query.append("    SELECT  A.TRF_EFF_YR, A.TRF_EFF_QTR_NO, A.MNR_DISP_TRF_SEQ, A.EQ_KND_CD, " ).append("\n"); 
		query.append("            A.EQ_TPSZ_CD, A.LOC_CD, B.SCC_CD, B.LCC_CD, B.RCC_CD, A.CURR_CD, " ).append("\n"); 
		query.append("            A.MNR_DISP_TRF_AMT, A.MNR_TRF_RMK , A.UPD_DT       " ).append("\n"); 
		query.append("    FROM    MNR_DISP_TRF A," ).append("\n"); 
		query.append("           (SELECT  A.LOC_CD, A.RGN_CD, A.SCC_CD, A.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("                    C.LCC_CD, C.ECC_CD, C.RCC_CD" ).append("\n"); 
		query.append("            FROM    MDM_LOCATION A,  " ).append("\n"); 
		query.append("                    MDM_EQ_ORZ_CHT C        " ).append("\n"); 
		query.append("            WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("            AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("            ) B" ).append("\n"); 
		query.append("            WHERE A.TRF_EFF_YR = SUBSTR(REPLACE(@[request_dt],'-',''), 1,4)" ).append("\n"); 
		query.append("             AND  A.TRF_EFF_QTR_NO = TO_CHAR(TO_DATE(REPLACE(@[request_dt],'-',''),'YYYYMMDD'), 'Q')" ).append("\n"); 
		query.append("             AND  A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("             AND  A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append("SELECT  A.MATCH_TYPE," ).append("\n"); 
		query.append("        A.MATCH_CNT," ).append("\n"); 
		query.append("		CASE WHEN TD.CURR_CD = @[curr_cd] THEN TD.MNR_DISP_TRF_AMT" ).append("\n"); 
		query.append("             ELSE MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), 'USD', @[curr_cd], NVL(A.MNR_DISP_TRF_TOT,0)) END AS MNR_DISP_TRF_TOT, " ).append("\n"); 
		query.append("        CASE WHEN TD.CURR_CD = @[curr_cd] THEN TD.MNR_DISP_TRF_AMT" ).append("\n"); 
		query.append("             ELSE MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), 'USD', @[curr_cd], NVL(A.MNR_DISP_TRF_AVG,0)) END AS MNR_DISP_TRF_AVG,  " ).append("\n"); 
		query.append("        @[curr_cd] AS CURR_CD              " ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT  'LOC_CD' AS MATCH_TYPE, COUNT(*) AS MATCH_CNT," ).append("\n"); 
		query.append("                SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_TOT,                                                                           " ).append("\n"); 
		query.append("                AVG(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_AVG" ).append("\n"); 
		query.append("        FROM    TEMP_DROP A" ).append("\n"); 
		query.append("        WHERE   A.LOC_CD = SUBSTR(@[crnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  'SCC_CD' AS MATCH_TYPE, COUNT(*) AS MATCH_CNT," ).append("\n"); 
		query.append("                SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_TOT,                                                                           " ).append("\n"); 
		query.append("                AVG(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_AVG" ).append("\n"); 
		query.append("        FROM    TEMP_DROP A" ).append("\n"); 
		query.append("        WHERE   A.SCC_CD = (SELECT  C.SCC_CD" ).append("\n"); 
		query.append("                            FROM    MDM_LOCATION A, MDM_EQ_ORZ_CHT C     " ).append("\n"); 
		query.append("                            WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("                            AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                            AND     A.LOC_CD = SUBSTR(@[crnt_yd_cd], 1, 5))                " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  'LCC_CD' AS MATCH_TYPE, COUNT(*) AS MATCH_CNT," ).append("\n"); 
		query.append("                SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_TOT,                                                                           " ).append("\n"); 
		query.append("                AVG(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_AVG" ).append("\n"); 
		query.append("        FROM    TEMP_DROP A " ).append("\n"); 
		query.append("        WHERE   A.LCC_CD = (SELECT  C.LCC_CD" ).append("\n"); 
		query.append("                            FROM    MDM_LOCATION A, MDM_EQ_ORZ_CHT C        " ).append("\n"); 
		query.append("                            WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("                            AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                            AND     A.LOC_CD = SUBSTR(@[crnt_yd_cd], 1, 5))                       " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  'RCC_CD' AS MATCH_TYPE, COUNT(*) AS MATCH_CNT," ).append("\n"); 
		query.append("                 SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_TOT,                                                                           " ).append("\n"); 
		query.append("                 AVG(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(SUBSTR(REPLACE(@[request_dt],'-',''), 1,6), CURR_CD, 'USD', NVL(MNR_DISP_TRF_AMT,0))) AS MNR_DISP_TRF_AVG" ).append("\n"); 
		query.append("        FROM    TEMP_DROP A " ).append("\n"); 
		query.append("        WHERE   A.RCC_CD = (SELECT  C.RCC_CD" ).append("\n"); 
		query.append("                            FROM    MDM_LOCATION A, MDM_EQ_ORZ_CHT C        " ).append("\n"); 
		query.append("                            WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("                            AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                            AND     A.LOC_CD = SUBSTR(@[crnt_yd_cd], 1, 5))                    " ).append("\n"); 
		query.append("        ) A, TEMP_DROP TD" ).append("\n"); 
		query.append("WHERE   A.MATCH_CNT > 0" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}