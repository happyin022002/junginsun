/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchSlsRepAcctListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.05.02 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchSlsRepAcctListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep별 화주 정보 조회
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.05.02 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - Sub Trade 조회시 Trade 조회조건 누락
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchSlsRepAcctListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchSlsRepAcctListRSQL").append("\n"); 
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
		query.append("SELECT   A.SREP_CD" ).append("\n"); 
		query.append("         , A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ, 'FM000000') AS CUST_CD" ).append("\n"); 
		query.append("         , A.CUST_CNT_CD" ).append("\n"); 
		query.append("         , A.CUST_SEQ" ).append("\n"); 
		query.append("         , A.CUST_NM" ).append("\n"); 
		query.append("         , A.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("         , A.SLS_OFC_CD" ).append("\n"); 
		query.append("         , A.SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("         , MAX(A.CUST_INDIV_FLG) AS CUST_INDIV_FLG" ).append("\n"); 
		query.append("         , DECODE(A.CUST_CNT_CD||A.CUST_SEQ, 'XX999999', 'Y', NVL((SELECT MAX('Y')" ).append("\n"); 
		query.append("                                                                     FROM BKG_CUST_SLS_REP" ).append("\n"); 
		query.append("                                                                    WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                      AND CUST_SEQ    = A.CUST_SEQ" ).append("\n"); 
		query.append("                                                                      AND DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                                                                      AND SREP_CD     = A.SREP_CD), 'N')) AS EXIST_FLG" ).append("\n"); 
		query.append("         , MAX(SUB_TRD_CD) AS SUB_TRD_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT --20130422 추가" ).append("\n"); 
		query.append("                   A.SREP_CD" ).append("\n"); 
		query.append("                   , NVL((SELECT MAX(INDIV_CUST_USE_FLG)" ).append("\n"); 
		query.append("                            FROM SPC_SLS_REP_CUST" ).append("\n"); 
		query.append("                           WHERE TRD_CD      = @[trade]" ).append("\n"); 
		query.append("                             AND SREP_CD     = A.SREP_CD" ).append("\n"); 
		query.append("                             AND CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST_SEQ    = A.CUST_SEQ), 'N') AS CUST_INDIV_FLG" ).append("\n"); 
		query.append("                   , A.CUST_CNT_CD" ).append("\n"); 
		query.append("                   , A.CUST_SEQ" ).append("\n"); 
		query.append("                   , C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("                   , C.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                   , M.OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("                   , I.SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("              FROM SPC_SLS_REP_CUST    A," ).append("\n"); 
		query.append("                   MDM_SLS_REP         M," ).append("\n"); 
		query.append("                   MDM_CUSTOMER        C," ).append("\n"); 
		query.append("                   SPC_SLS_REP_TEAM_IF I" ).append("\n"); 
		query.append("             WHERE A.SREP_CD     = M.SREP_CD" ).append("\n"); 
		query.append("               AND A.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND A.CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("               AND A.TRD_CD IN ('*', @[trade])" ).append("\n"); 
		query.append("               AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("               AND A.SREP_CD     = I.SREP_USR_ID(+)" ).append("\n"); 
		query.append("               AND A.CUST_CNT_CD||A.CUST_SEQ <> 'XX999999'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${srep_cd} != '')" ).append("\n"); 
		query.append("               AND A.SREP_CD     = @[srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("               AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("               AND C.CUST_SEQ    = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("               AND UPPER(C.CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("            SELECT   A.SREP_CD" ).append("\n"); 
		query.append("                   , 'N' AS CUST_INDIV_FLG" ).append("\n"); 
		query.append("                   , A.CUST_CNT_CD" ).append("\n"); 
		query.append("                   , A.CUST_SEQ" ).append("\n"); 
		query.append("                   , C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("                   , C.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                   , M.OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("                   , I.SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("              FROM BKG_CUST_SLS_REP    A," ).append("\n"); 
		query.append("                   MDM_SLS_REP         M," ).append("\n"); 
		query.append("                   MDM_CUSTOMER        C," ).append("\n"); 
		query.append("                   SPC_SLS_REP_TEAM_IF I" ).append("\n"); 
		query.append("             WHERE A.SREP_CD     = M.SREP_CD" ).append("\n"); 
		query.append("               AND A.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND A.CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("               AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("               AND A.SREP_CD     = I.SREP_USR_ID(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${srep_cd} != '')" ).append("\n"); 
		query.append("               AND A.SREP_CD     = @[srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("               AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("               AND C.CUST_SEQ    = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("               AND UPPER(C.CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("            SELECT   @[srep_cd] AS SREP_CD" ).append("\n"); 
		query.append("                   , NVL((SELECT MAX(INDIV_CUST_USE_FLG)" ).append("\n"); 
		query.append("                            FROM SPC_SLS_REP_CUST" ).append("\n"); 
		query.append("                           WHERE TRD_CD      = @[trade]" ).append("\n"); 
		query.append("                             AND SREP_CD     = @[srep_cd]" ).append("\n"); 
		query.append("                             AND CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("                             AND CUST_SEQ    = 999999), 'Y') AS CUST_INDIV_FLG" ).append("\n"); 
		query.append("                   , 'XX' AS CUST_CNT_CD" ).append("\n"); 
		query.append("                   , 999999 AS CUST_SEQ" ).append("\n"); 
		query.append("                   , 'OTHERS' AS CUST_NM" ).append("\n"); 
		query.append("                   , 'N' AS RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                   , @[sls_ofc_cd] AS SLS_OFC_CD" ).append("\n"); 
		query.append("                   , NULL AS SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT   SREP_CD" ).append("\n"); 
		query.append("                   , CUST_INDIV_FLG" ).append("\n"); 
		query.append("                   , CUST_CNT_CD" ).append("\n"); 
		query.append("                   , CUST_SEQ" ).append("\n"); 
		query.append("                   , CUST_NM" ).append("\n"); 
		query.append("                   , RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                   , SLS_OFC_CD" ).append("\n"); 
		query.append("                   , SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("                   , SUBSTR(MAX(SYS_CONNECT_BY_PATH(SUB_TRD_CD, ',')), 2) AS SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT   DISTINCT" ).append("\n"); 
		query.append("                               A.SREP_CD" ).append("\n"); 
		query.append("                             , NVL((SELECT MAX(INDIV_CUST_USE_FLG)" ).append("\n"); 
		query.append("                                      FROM SPC_SLS_REP_CUST" ).append("\n"); 
		query.append("                                     WHERE TRD_CD      = @[trade]" ).append("\n"); 
		query.append("                                       AND SREP_CD     = A.SREP_CD" ).append("\n"); 
		query.append("                                       AND CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                                       AND CUST_SEQ    = A.CUST_SEQ), 'N') AS CUST_INDIV_FLG" ).append("\n"); 
		query.append("                             , A.CUST_CNT_CD" ).append("\n"); 
		query.append("                             , A.CUST_SEQ" ).append("\n"); 
		query.append("                             , C.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("                             , C.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                             , M.OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("                             , I.SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("                             , A.SUB_TRD_CD" ).append("\n"); 
		query.append("                             , DENSE_RANK() OVER (PARTITION BY A.CUST_CNT_CD, A.CUST_SEQ ORDER BY SUB_TRD_CD) AS RNUM" ).append("\n"); 
		query.append("                        FROM SPC_SLS_REP_CUST      A," ).append("\n"); 
		query.append("                             MDM_SLS_REP           M," ).append("\n"); 
		query.append("                             MDM_CUSTOMER          C," ).append("\n"); 
		query.append("                             SPC_SLS_REP_TEAM_IF   I" ).append("\n"); 
		query.append("                       WHERE A.SREP_CD     = M.SREP_CD" ).append("\n"); 
		query.append("                         AND A.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                         AND A.CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("                         AND A.TRD_CD IN ('*', @[trade])" ).append("\n"); 
		query.append("                         AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                         AND A.SREP_CD     = I.SREP_USR_ID(+)" ).append("\n"); 
		query.append("                         AND A.CUST_CNT_CD||A.CUST_SEQ <> 'XX999999'" ).append("\n"); 
		query.append("                         AND A.SUB_TRD_CD <> '*'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${srep_cd} != '')" ).append("\n"); 
		query.append("                         AND A.SREP_CD     = @[srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                         AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("                         AND C.CUST_SEQ    = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("                         AND UPPER(C.CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT DISTINCT --20130422 추가" ).append("\n"); 
		query.append("                             SREP_CD" ).append("\n"); 
		query.append("                             , INDIV_CUST_USE_FLG" ).append("\n"); 
		query.append("                             , CUST_CNT_CD" ).append("\n"); 
		query.append("                             , CUST_SEQ" ).append("\n"); 
		query.append("                             , 'OTHERS' AS CUST_NM" ).append("\n"); 
		query.append("                             , RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                             , SLS_OFC_CD" ).append("\n"); 
		query.append("                             , NULL AS SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("                             , SUB_TRD_CD" ).append("\n"); 
		query.append("                             , DENSE_RANK() OVER (PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY SUB_TRD_CD) AS RNUM" ).append("\n"); 
		query.append("                        FROM SPC_SLS_REP_CUST" ).append("\n"); 
		query.append("                       WHERE TRD_CD  = @[trade]" ).append("\n"); 
		query.append("                         AND SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("                         AND CUST_CNT_CD||CUST_SEQ= 'XX999999'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("        START WITH RNUM = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CNT_CD = CUST_CNT_CD AND PRIOR CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("          GROUP BY   SREP_CD" ).append("\n"); 
		query.append("                   , CUST_INDIV_FLG" ).append("\n"); 
		query.append("                   , CUST_CNT_CD" ).append("\n"); 
		query.append("                   , CUST_SEQ" ).append("\n"); 
		query.append("                   , CUST_NM" ).append("\n"); 
		query.append("                   , RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                   , SLS_OFC_CD" ).append("\n"); 
		query.append("                   , SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND A.SREP_CD              = B.SREP_CD             (+)" ).append("\n"); 
		query.append("     AND A.CUST_INDIV_FLG       = B.CUST_INDIV_FLG      (+)" ).append("\n"); 
		query.append("     AND A.CUST_CNT_CD          = B.CUST_CNT_CD         (+)" ).append("\n"); 
		query.append("     AND A.CUST_SEQ             = B.CUST_SEQ            (+)" ).append("\n"); 
		query.append("     AND A.CUST_NM              = B.CUST_NM             (+)" ).append("\n"); 
		query.append("     AND A.RVIS_CNTR_CUST_TP_CD = B.RVIS_CNTR_CUST_TP_CD(+)" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD           = B.SLS_OFC_CD          (+)" ).append("\n"); 
		query.append("     AND NVL(A.SLS_REP_OFC_TEAM_CD, 'X') = NVL(B.SLS_REP_OFC_TEAM_CD (+) , NVL(A.SLS_REP_OFC_TEAM_CD, 'X'))" ).append("\n"); 
		query.append("GROUP BY   A.SREP_CD" ).append("\n"); 
		query.append("         , A.CUST_CNT_CD" ).append("\n"); 
		query.append("         , A.CUST_SEQ" ).append("\n"); 
		query.append("         , A.CUST_NM" ).append("\n"); 
		query.append("         , A.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("         , A.SLS_OFC_CD" ).append("\n"); 
		query.append("         , A.SLS_REP_OFC_TEAM_CD" ).append("\n"); 
		query.append("ORDER BY   A.SREP_CD" ).append("\n"); 
		query.append("         , DECODE(A.CUST_CNT_CD, 'XX', 0)         " ).append("\n"); 
		query.append("         , CUST_INDIV_FLG DESC" ).append("\n"); 
		query.append("         , A.CUST_CNT_CD" ).append("\n"); 
		query.append("         , A.CUST_SEQ" ).append("\n"); 

	}
}