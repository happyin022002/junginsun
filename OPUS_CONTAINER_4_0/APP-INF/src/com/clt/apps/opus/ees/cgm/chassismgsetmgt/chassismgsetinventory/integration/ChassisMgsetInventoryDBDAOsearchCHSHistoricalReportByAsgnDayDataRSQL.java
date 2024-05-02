/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByAsgnDayDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.14 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByAsgnDayDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090824 1113 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByAsgnDayDataRSQL(){
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
		params.put("crnt_lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByAsgnDayDataRSQL").append("\n"); 
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
		query.append("TO_CHAR(t1.SMRY_DT, 'YYYY-MM') AS PERIOD" ).append("\n"); 
		query.append("#elseif (${period_type} == 'M')" ).append("\n"); 
		query.append("TO_CHAR(t1.SMRY_DT, 'YYYY-MM') AS PERIOD" ).append("\n"); 
		query.append("#elseif (${period_type} == 'W')" ).append("\n"); 
		query.append("t4.PLN_YR||'-'||t4.PLN_WK AS PERIOD" ).append("\n"); 
		query.append("#elseif (${period_type} == 'D')" ).append("\n"); 
		query.append("TO_CHAR(t1.SMRY_DT, 'YYYY-MM-DD') AS PERIOD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_type} == 'Q')" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) ,0) AS CHSS_20FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) ,0) AS CHSS_40FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) ,0) AS CHSS_45FT_QTY" ).append("\n"); 
		query.append("#elseif (${period_type} == 'M')" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) ,0) AS CHSS_20FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) ,0) AS CHSS_40FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) ,0) AS CHSS_45FT_QTY" ).append("\n"); 
		query.append("#elseif (${period_type} == 'W')" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) ,0) AS CHSS_20FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) ,0) AS CHSS_40FT_QTY" ).append("\n"); 
		query.append(",ROUND(SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) ,0) AS CHSS_45FT_QTY" ).append("\n"); 
		query.append("#elseif (${period_type} == 'D')" ).append("\n"); 
		query.append(",SUM( CASE WHEN EQ_TPSZ_REP_CD = 20 THEN T1.INVT_SMRY_KNT ELSE 0 END  ) AS CHSS_20FT_QTY" ).append("\n"); 
		query.append(",SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, INVT_SMRY_KNT, NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 40 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) AS CHSS_40FT_QTY" ).append("\n"); 
		query.append(",SUM( CASE WHEN T1.EQ_TPSZ_CD = 'EG5' THEN DECODE( SIGN( INVT_SMRY_KNT - NVL(EG5_PRE_KNT_QTY,0) ) , -1, 0, INVT_SMRY_KNT- NVL(EG5_PRE_KNT_QTY,0) )" ).append("\n"); 
		query.append("WHEN EQ_TPSZ_REP_CD = 45 THEN  T1.INVT_SMRY_KNT" ).append("\n"); 
		query.append("ELSE 0 END ) AS CHSS_45FT_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_DLY_INVT_SMRY t1, CGM_CHSS_UTL_EG5_KNT T2, CGM_EQ_TP_SZ T3" ).append("\n"); 
		query.append("#if (${period_type} == 'W')" ).append("\n"); 
		query.append(", EQR_WK_PRD t4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.LOC_CD IN ( SELECT" ).append("\n"); 
		query.append("t2.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION t2, MDM_EQ_ORZ_CHT t3" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t2.SCC_CD = t3.SCC_CD" ).append("\n"); 
		query.append("#if (${crnt_lcc_cd} != '')" ).append("\n"); 
		query.append("AND t3.LCC_CD = @[crnt_lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crnt_scc_cd} != '')" ).append("\n"); 
		query.append("AND t3.SCC_CD IN ($crnt_scc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
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
		query.append("(SELECT TO_DATE( t4.WK_ST_DT,'YYYYMMDD') FROM EQR_WK_PRD t4 WHERE t4.PLN_YR||t4.PLN_WK = @[inq_fm_dys] )" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(SELECT TO_DATE( t4.WK_END_DT,'YYYYMMDD') FROM EQR_WK_PRD t4 WHERE t4.PLN_YR||t4.PLN_WK = @[inq_to_dys] )" ).append("\n"); 
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