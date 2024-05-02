/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DailyForecastManageDBDAOAddMultiOfficeLevelManageCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.04.25 이은섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author EUN-SUP LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOAddMultiOfficeLevelManageCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert
	  * </pre>
	  */
	public DailyForecastManageDBDAOAddMultiOfficeLevelManageCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOAddMultiOfficeLevelManageCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_OFC_LVL" ).append("\n"); 
		query.append("  (OFC_CD," ).append("\n"); 
		query.append("   OFC_APLY_FM_YRWK," ).append("\n"); 
		query.append("   OFC_APLY_TO_YRWK," ).append("\n"); 
		query.append("   OFC_TP_CD," ).append("\n"); 
		query.append("   OFC_ENG_NM," ).append("\n"); 
		query.append("   OFC_LOCL_NM," ).append("\n"); 
		query.append("   PRNT_OFC_CD," ).append("\n"); 
		query.append("   OFC_KND_CD," ).append("\n"); 
		query.append("   DELT_FLG," ).append("\n"); 
		query.append("   OFC_SLS_DELT_FLG," ).append("\n"); 
		query.append("   OFC_LVL," ).append("\n"); 
		query.append("   N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("   N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("   N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("   N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("   N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("   N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("   N7TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("   SAQ_RGN_OFC_CD," ).append("\n"); 
		query.append("   SPC_SLS_OFC_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("  SELECT Z.OFC_CD," ).append("\n"); 
		query.append("         '100000'," ).append("\n"); 
		query.append("         '999953'," ).append("\n"); 
		query.append("         Z.OFC_TP_CD," ).append("\n"); 
		query.append("         Z.OFC_ENG_NM," ).append("\n"); 
		query.append("         Z.OFC_LOCL_NM," ).append("\n"); 
		query.append("         Z.PRNT_OFC_CD," ).append("\n"); 
		query.append("         Z.OFC_KND_CD," ).append("\n"); 
		query.append("         Z.DELT_FLG," ).append("\n"); 
		query.append("         NVL(Z.OFC_SLS_DELT_FLG, 'N')," ).append("\n"); 
		query.append("         DECODE(Z.OFC_TP_CD, 'QT', 3, 'SQ', 3, LENGTH(Z.OFC) / 6) LVL," ).append("\n"); 
		query.append("         DECODE(Z.OFC_TP_CD, 'QT', 'CSCHO', 'SQ', 'CSCHO', TRIM(SUBSTR(Z.OFC, 1, 6))) N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("         DECODE(Z.OFC_TP_CD, 'QT', Z.PRNT_OFC_CD, 'SQ', Z.PRNT_OFC_CD, TRIM(SUBSTR(Z.OFC, 7, 6))) N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("         DECODE(Z.OFC_TP_CD, 'QT', Z.OFC_CD, TRIM(SUBSTR(Z.OFC, 13, 6))) N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("         TRIM(SUBSTR(Z.OFC, 19, 6)) N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("         TRIM(SUBSTR(Z.OFC, 25, 6)) N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("         TRIM(SUBSTR(Z.OFC, 31, 6)) N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("         TRIM(SUBSTR(Z.OFC, 37, 6)) N7TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("         NVL((SELECT C.CONV_RGN_OFC_CD FROM SPC_RGN_OFC_CONV C WHERE C.SLS_RGN_OFC_CD = Z.OFC_CD), Z.OFC_CD) SAQ_RGN_OFC_CD," ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("           WHEN LENGTH(Z.OFC) / 6 >= 5 THEN" ).append("\n"); 
		query.append("            TRIM(SUBSTR(Z.OFC, 25, 6))" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("            Z.OFC_CD" ).append("\n"); 
		query.append("         END SPC_SLS_OFC_CD," ).append("\n"); 
		query.append("         'SYSTEM'," ).append("\n"); 
		query.append("         SYSDATE," ).append("\n"); 
		query.append("         'SYSTEM'," ).append("\n"); 
		query.append("         SYSDATE" ).append("\n"); 
		query.append("    FROM (SELECT M.OFC_TP_CD," ).append("\n"); 
		query.append("                 M.OFC_CD," ).append("\n"); 
		query.append("                 M.OFC_ENG_NM," ).append("\n"); 
		query.append("                 M.OFC_LOCL_NM," ).append("\n"); 
		query.append("                 M.PRNT_OFC_CD," ).append("\n"); 
		query.append("                 M.OFC_KND_CD," ).append("\n"); 
		query.append("                 M.DELT_FLG," ).append("\n"); 
		query.append("                 M.OFC_SLS_DELT_FLG," ).append("\n"); 
		query.append("                 (SELECT CASE" ).append("\n"); 
		query.append("                           WHEN (COUNT(1) = 1 AND MAX(DECODE(O.OFC_TP_CD, 'HO', 'Y')) = 'Y') OR" ).append("\n"); 
		query.append("                                MAX(DECODE(O.OFC_TP_CD, 'HO', 'Y', 'N')) || MAX(DECODE(O.OFC_TP_CD, 'HQ', 'Y', 'N')) = 'YY' THEN" ).append("\n"); 
		query.append("                            DECODE(MAX(DECODE(O.OFC_TP_CD, 'AQ', 'Y', 'N'))," ).append("\n"); 
		query.append("                                   'Y'," ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 9, O.OFC_CD)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 8, O.OFC_CD)), 6, ' ') ||" ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 7, O.OFC_CD)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 6, O.OFC_CD)), 6, ' ') ||" ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 5, O.OFC_CD)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 4, O.OFC_CD)), 6, ' ') ||" ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 3, O.OFC_CD)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 2, O.OFC_CD)), 6, ' ') ||" ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 1, O.OFC_CD)), 6, ' ')," ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 9, O.OFC_CD)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 8, O.OFC_CD)), 6, ' ') || DECODE(COUNT(1), 9, '      ', '') ||" ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 7, O.OFC_CD)), 6, ' ') || DECODE(COUNT(1), 8, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 6, O.OFC_CD)), 6, ' ') ||" ).append("\n"); 
		query.append("                                   DECODE(COUNT(1), 7, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 5, O.OFC_CD)), 6, ' ') || DECODE(COUNT(1), 6, '      ', '') ||" ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 4, O.OFC_CD)), 6, ' ') || DECODE(COUNT(1), 5, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 3, O.OFC_CD)), 6, ' ') ||" ).append("\n"); 
		query.append("                                   DECODE(COUNT(1), 4, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 2, O.OFC_CD)), 6, ' ') || DECODE(COUNT(1), 3, '      ', '') ||" ).append("\n"); 
		query.append("                                   RPAD(MAX(DECODE(ROWNUM, 1, O.OFC_CD)), 6, ' '))" ).append("\n"); 
		query.append("                           ELSE" ).append("\n"); 
		query.append("                            ''" ).append("\n"); 
		query.append("                         END OFC_CD" ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                   WHERE O.OFC_TP_CD IN ('HO', 'HQ', 'AQ', 'BB', 'BA', 'BS', 'AF') --NYCNA의 LAXDD, CHIND를 AREA처럼 취급하기위해 추가" ).append("\n"); 
		query.append("                     AND NOT EXISTS (SELECT 1 FROM SPC_RGN_OFC_CONV C WHERE C.SLS_RGN_OFC_CD = O.OFC_CD)" ).append("\n"); 
		query.append("                  CONNECT BY NOCYCLE PRIOR O.PRNT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                   START WITH O.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("                          AND O.OFC_TP_CD IN ('HO', 'HQ', 'AQ', 'BB', 'BA', 'BS', 'AF') --NYCNA의 LAXDD, CHIND를 AREA처럼 취급하기위해 추가" ).append("\n"); 
		query.append("                          AND NOT EXISTS (SELECT 1 FROM SPC_RGN_OFC_CONV C WHERE C.SLS_RGN_OFC_CD = O.OFC_CD)) OFC" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION M) Z" ).append("\n"); 

	}
}