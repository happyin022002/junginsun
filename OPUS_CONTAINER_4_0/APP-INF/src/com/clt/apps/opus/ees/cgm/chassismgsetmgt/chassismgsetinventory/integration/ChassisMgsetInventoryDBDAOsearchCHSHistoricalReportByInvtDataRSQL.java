/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByInvtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.08.04 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByInvtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass()); 
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090824 1113 start
	  * 
	  * [CHM-201004960-01] Genset Ineventory Logic error 수정건
	  *     : [EES_CGM_1113] UI에 RCC멀티콤보 기능 및 조회조건 추가 by 김상수
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByInvtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByInvtDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${period_type} == 'Q')" ).append("\n"); 
		query.append("	TO_CHAR(t1.SMRY_DT, 'YYYY-MM') AS PERIOD" ).append("\n"); 
		query.append("#elseif (${period_type} == 'M')" ).append("\n"); 
		query.append("	TO_CHAR(t1.SMRY_DT, 'YYYY-MM') AS PERIOD" ).append("\n"); 
		query.append("#elseif (${period_type} == 'W')" ).append("\n"); 
		query.append("	t4.PLN_YR||'-'||t4.PLN_WK AS PERIOD" ).append("\n"); 
		query.append("#elseif (${period_type} == 'D')" ).append("\n"); 
		query.append("	TO_CHAR(t1.SMRY_DT, 'YYYY-MM-DD') AS PERIOD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_type} == 'Q')" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) /3/ TO_NUMBER(TO_CHAR(LAST_DAY(TO_DATE(TO_CHAR(t1.SMRY_DT, 'YYYY-MM'), 'YYYY-MM')),'DD'))  ,2) AS CHSS_20FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) / 3/ TO_NUMBER(TO_CHAR(LAST_DAY(TO_DATE(TO_CHAR(t1.SMRY_DT, 'YYYY-MM'), 'YYYY-MM')),'DD'))  ,2) AS CHSS_40FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) / 3/ TO_NUMBER(TO_CHAR(LAST_DAY(TO_DATE(TO_CHAR(t1.SMRY_DT, 'YYYY-MM'), 'YYYY-MM')),'DD'))  ,2) AS CHSS_45FT_QTY" ).append("\n"); 
		query.append("#elseif (${period_type} == 'M')" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) / TO_NUMBER(TO_CHAR(LAST_DAY(TO_DATE(TO_CHAR(t1.SMRY_DT, 'YYYY-MM'), 'YYYY-MM')),'DD'))  ,2) AS CHSS_20FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) / TO_NUMBER(TO_CHAR(LAST_DAY(TO_DATE(TO_CHAR(t1.SMRY_DT, 'YYYY-MM'), 'YYYY-MM')),'DD'))  ,2) AS CHSS_40FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) / TO_NUMBER(TO_CHAR(LAST_DAY(TO_DATE(TO_CHAR(t1.SMRY_DT, 'YYYY-MM'), 'YYYY-MM')),'DD'))  ,2) AS CHSS_45FT_QTY" ).append("\n"); 
		query.append("#elseif (${period_type} == 'W')" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) / 7,2) AS CHSS_20FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) / 7,2) AS CHSS_40FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) / 7,2) AS CHSS_45FT_QTY" ).append("\n"); 
		query.append("#elseif (${period_type} == 'D')" ).append("\n"); 
		query.append(", SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) CHSS_20FT_QTY" ).append("\n"); 
		query.append(", SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) CHSS_40FT_QTY" ).append("\n"); 
		query.append(", SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("            WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("            ELSE 0 END ) CHSS_45FT_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_DLY_INVT_SMRY t1, CGM_CHSS_UTL_EG5_KNT T2, CGM_EQ_TP_SZ T3" ).append("\n"); 
		query.append("#if (${period_type} == 'W')" ).append("\n"); 
		query.append(", EQR_WK_PRD t4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.LOC_CD IN ( SELECT t2.LOC_CD" ).append("\n"); 
		query.append("                 FROM MDM_LOCATION t2, MDM_EQ_ORZ_CHT t3" ).append("\n"); 
		query.append("                WHERE t2.SCC_CD = t3.SCC_CD" ).append("\n"); 
		query.append("                #if (${crnt_lcc_cd} != '')" ).append("\n"); 
		query.append("                  AND t3.LCC_CD IN (${crnt_lcc_cd})" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${crnt_scc_cd} != '')" ).append("\n"); 
		query.append("                  AND t3.SCC_CD IN (${crnt_scc_cd})" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND t1.YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND T1.YD_CD= T2.YD_CD(+)" ).append("\n"); 
		query.append("AND T1.EQ_TPSZ_CD = T3.EQ_TPSZ_cD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_type} == 'Q')" ).append("\n"); 
		query.append("AND t1.SMRY_DT BETWEEN TO_DATE(@[inq_fm_dys],'YYYYMMDD') AND TO_DATE(@[inq_to_dys],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif (${period_type} == 'M')" ).append("\n"); 
		query.append("AND t1.SMRY_DT BETWEEN TO_DATE(@[inq_fm_dys],'YYYYMMDD') AND TO_DATE(@[inq_to_dys],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#elseif (${period_type} == 'W')" ).append("\n"); 
		query.append("AND TO_CHAR(t1.SMRY_DT, 'YYYYMMDD') BETWEEN t4.WK_ST_DT AND t4.WK_END_DT" ).append("\n"); 
		query.append("AND t1.SMRY_DT BETWEEN" ).append("\n"); 
		query.append("	(SELECT TO_DATE( t4.WK_ST_DT,'YYYYMMDD') FROM EQR_WK_PRD t4 WHERE t4.PLN_YR||t4.PLN_WK = @[inq_fm_dys] )" ).append("\n"); 
		query.append("	AND" ).append("\n"); 
		query.append("	(SELECT TO_DATE( t4.WK_END_DT,'YYYYMMDD') FROM EQR_WK_PRD t4 WHERE t4.PLN_YR||t4.PLN_WK = @[inq_to_dys] )" ).append("\n"); 
		query.append("#elseif (${period_type} == 'D')" ).append("\n"); 
		query.append("AND t1.SMRY_DT BETWEEN TO_DATE(@[inq_fm_dys],'YYYYMMDD') AND TO_DATE(@[inq_to_dys],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_type} == 'Q')" ).append("\n"); 
		query.append("GROUP BY TO_CHAR(t1.SMRY_DT, 'YYYY-MM')" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(t1.SMRY_DT, 'YYYY-MM') DESC" ).append("\n"); 
		query.append("#elseif (${period_type} == 'M')" ).append("\n"); 
		query.append("GROUP BY TO_CHAR(t1.SMRY_DT, 'YYYY-MM')" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(t1.SMRY_DT, 'YYYY-MM') DESC" ).append("\n"); 
		query.append("#elseif (${period_type} == 'W')" ).append("\n"); 
		query.append("GROUP BY t4.PLN_YR||'-'||t4.PLN_WK" ).append("\n"); 
		query.append("ORDER BY t4.PLN_YR||'-'||t4.PLN_WK DESC" ).append("\n"); 
		query.append("#elseif (${period_type} == 'D')" ).append("\n"); 
		query.append("GROUP BY TO_CHAR(t1.SMRY_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(t1.SMRY_DT, 'YYYY-MM-DD') DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}