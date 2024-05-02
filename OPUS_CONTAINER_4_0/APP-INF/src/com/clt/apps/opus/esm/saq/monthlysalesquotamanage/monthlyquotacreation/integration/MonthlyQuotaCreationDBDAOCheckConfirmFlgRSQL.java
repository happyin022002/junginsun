/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOCheckConfirmFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOCheckConfirmFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Base Data Confirm 전에 Office, Lane 이 잘못된 경우가 있을 경우 먼저 처리하도록 체크 한다
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOCheckConfirmFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOCheckConfirmFlgRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN MAX(CNT1) > 0 AND MAX(CNT2) > 0 THEN 'OL' " ).append("\n"); 
		query.append("                 WHEN MAX(CNT1) = 0 AND MAX(CNT2) > 0 THEN 'L' " ).append("\n"); 
		query.append("                 WHEN MAX(CNT1) > 0 AND MAX(CNT2) = 0 THEN 'O' ELSE 'Y' END AS CNF_YN " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT COUNT(MQTA_MDL_VER_NO) AS CNT1 " ).append("\n"); 
		query.append("            , 0 AS CNT2 " ).append("\n"); 
		query.append("            , 0 AS GRP " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                   , T1.CTRT_RHQ_CD " ).append("\n"); 
		query.append("                   , T1.CTRT_OFC_CD " ).append("\n"); 
		query.append("                   , T1.SLS_RHQ_CD " ).append("\n"); 
		query.append("                   , T1.SLS_OFC_CD " ).append("\n"); 
		query.append("                   , 'Y' AS CTRT_FLG " ).append("\n"); 
		query.append("                   , '' AS SLS_FLG " ).append("\n"); 
		query.append("                FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("                   , SAQ_ORGANIZATION_V T2 " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]  " ).append("\n"); 
		query.append("                     AND T1.CTRT_OFC_CD = T2.OFC_CD (+) " ).append("\n"); 
		query.append("                     AND 'N' = T2.DELT_FLG (+) " ).append("\n"); 
		query.append("                     AND T2.OFC_CD IS NULL " ).append("\n"); 
		query.append("                     AND " ).append("\n"); 
		query.append("                     ( " ).append("\n"); 
		query.append("                         T1.FCAST_TRNS_STS_CD = '0' " ).append("\n"); 
		query.append("                         OR T1.FCAST_TRNS_STS_CD IS NULL " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                  UNION ALL " ).append("\n"); 
		query.append("              SELECT T1.MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                   , T1.CTRT_RHQ_CD " ).append("\n"); 
		query.append("                   , T1.CTRT_OFC_CD " ).append("\n"); 
		query.append("                   , T1.SLS_RHQ_CD " ).append("\n"); 
		query.append("                   , T1.SLS_OFC_CD " ).append("\n"); 
		query.append("                   , '' AS CTRT_FLG " ).append("\n"); 
		query.append("                   , 'Y' AS SLS_FLG " ).append("\n"); 
		query.append("                FROM SAQ_MON_FCAST_TRNS T1 " ).append("\n"); 
		query.append("                   , SAQ_ORGANIZATION_V T2 " ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                     AND T1.MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]  " ).append("\n"); 
		query.append("                     AND T1.SLS_OFC_CD = T2.OFC_CD (+) " ).append("\n"); 
		query.append("                     AND 'N' = T2.DELT_FLG (+) " ).append("\n"); 
		query.append("                     AND T2.OFC_CD IS NULL " ).append("\n"); 
		query.append("                     AND " ).append("\n"); 
		query.append("                     ( " ).append("\n"); 
		query.append("                         T1.FCAST_TRNS_STS_CD = '0' " ).append("\n"); 
		query.append("                         OR T1.FCAST_TRNS_STS_CD IS NULL " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("           UNION ALL " ).append("\n"); 
		query.append("       SELECT 0 AS CNT1 " ).append("\n"); 
		query.append("            , COUNT(MQTA_MDL_VER_NO) AS CNT2 " ).append("\n"); 
		query.append("            , 0 AS GRP " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT NVL(T1.MQTA_MDL_VER_NO, SUBSTR(T2.BSE_YR, 3,2)||BSE_QTR_CD||'01') AS MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                   , NVL(T1.TRD_CD, T2.TRD_CD) AS TRD_CD " ).append("\n"); 
		query.append("                   , NVL(T1.SUB_TRD_CD, T2.SUB_TRD_CD) AS SUB_TRD_CD " ).append("\n"); 
		query.append("                   , NVL(T1.RLANE_CD, T2.RLANE_CD) AS ORG_RLANE_CD " ).append("\n"); 
		query.append("                   , NVL(T1.RLANE_CD, T2.RLANE_CD) AS RLANE_CD " ).append("\n"); 
		query.append("                   , DECODE(T1.RLANE_CD, NULL, 'BLUE', DECODE(T2.RLANE_CD, NULL, 'RED', 'ALL')) AS ROW_CLR " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                     (SELECT MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                          , TRD_CD " ).append("\n"); 
		query.append("                          , SUB_TRD_CD " ).append("\n"); 
		query.append("                          , IOC_CD " ).append("\n"); 
		query.append("                          , RLANE_CD " ).append("\n"); 
		query.append("                          , RLANE_CD AS ORG_RLANE_CD " ).append("\n"); 
		query.append("                       FROM SAQ_MON_FCAST_TRNS " ).append("\n"); 
		query.append("                      WHERE 1=1 " ).append("\n"); 
		query.append("                            AND MQTA_MDL_VER_NO = @[mqta_mdl_ver_no]  " ).append("\n"); 
		query.append("                            AND " ).append("\n"); 
		query.append("                            ( " ).append("\n"); 
		query.append("                                FCAST_TRNS_STS_CD = '0' " ).append("\n"); 
		query.append("                                OR FCAST_TRNS_STS_CD IS NULL " ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("                      GROUP BY MQTA_MDL_VER_NO " ).append("\n"); 
		query.append("                          , TRD_CD " ).append("\n"); 
		query.append("                          , SUB_TRD_CD " ).append("\n"); 
		query.append("                          , IOC_CD " ).append("\n"); 
		query.append("                          , RLANE_CD " ).append("\n"); 
		query.append("                     ) T1 " ).append("\n"); 
		query.append("                 FULL OUTER JOIN " ).append("\n"); 
		query.append("                     (SELECT BSE_YR " ).append("\n"); 
		query.append("                          , BSE_QTR_CD " ).append("\n"); 
		query.append("                          , TRD_CD " ).append("\n"); 
		query.append("                          , SUB_TRD_CD " ).append("\n"); 
		query.append("                          , RLANE_CD " ).append("\n"); 
		query.append("                       FROM SAQ_MON_TGT_VVD " ).append("\n"); 
		query.append("                      WHERE 1=1 " ).append("\n"); 
		query.append("                            AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("                            AND TGT_VVD_STS_CD = 'N'" ).append("\n"); 
		query.append("                            AND BSE_YR = @[year] " ).append("\n"); 
		query.append("                            AND BSE_QTR_CD = @[bse_qtr_cd]               " ).append("\n"); 
		query.append("                      GROUP BY BSE_YR " ).append("\n"); 
		query.append("                          , BSE_QTR_CD " ).append("\n"); 
		query.append("                          , TRD_CD " ).append("\n"); 
		query.append("                          , SUB_TRD_CD " ).append("\n"); 
		query.append("                          , RLANE_CD " ).append("\n"); 
		query.append("                     ) T2 " ).append("\n"); 
		query.append("                     ON ( " ).append("\n"); 
		query.append("                         T1.MQTA_MDL_VER_NO = SUBSTR(T2.BSE_YR, 3,2)||BSE_QTR_CD||'01' " ).append("\n"); 
		query.append("                         AND T1.TRD_CD = T2.TRD_CD " ).append("\n"); 
		query.append("                         AND T1.SUB_TRD_CD = T2.SUB_TRD_CD " ).append("\n"); 
		query.append("                         AND T1.RLANE_CD = T2.RLANE_CD " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND ROW_CLR IN ('RED', 'BLUE') " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append(" GROUP BY GRP" ).append("\n"); 

	}
}