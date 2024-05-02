/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOsearchPoolMvmtCompareMatchingSmryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.19 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisHistoryDBDAOsearchPoolMvmtCompareMatchingSmryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOsearchPoolMvmtCompareMatchingSmryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOsearchPoolMvmtCompareMatchingSmryDataRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' COM_DIVISION" ).append("\n"); 
		query.append("--    	, DECODE(  CHSS_OWNR_CO_CD,'H','FOR SML CNTR','FOR SML CHSS') DIVISON" ).append("\n"); 
		query.append(", DECODE(  CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",'H',DECODE(CNTR_OWNR_CO_CD, 'O', 'FOR SML CHSS','FOR SML CNTR'), DECODE( CNTR_OWNR_CO_CD, 'O', 'For Other CNTR', 'FOR SML CNTR')) DIVISON" ).append("\n"); 
		query.append(", CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(", CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(", CNTR_OWNR_CO_CD ||'+'||  CHSS_OWNR_CO_CD CNTR_CHSS" ).append("\n"); 
		query.append(", SUM( CASE WHEN HJS_USDY = MGMT_USDDYS THEN 1 ELSE 0 END)  MATCHING" ).append("\n"); 
		query.append(", SUM( CASE WHEN HJS_USDY = MGMT_USDDYS THEN 0 ELSE 1 END) UNMATCHING" ).append("\n"); 
		query.append(", SUM( CASE WHEN HJS_USDY = MGMT_USDDYS THEN MGMT_USDDYS ELSE 0 END)  MATCHING_DAY" ).append("\n"); 
		query.append(", SUM( CASE WHEN HJS_USDY = MGMT_USDDYS THEN 0 ELSE  ABS( NVL(HJS_USDY,0) - NVL(MGMT_USDDYS,0) ) END) UNMATCHING_DAY" ).append("\n"); 
		query.append("from(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CHSS_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(", CASE WHEN EXISTS (SELECT /*+ INDEX(H XAK4CGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("'X' FROM CGM_EQ_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.EQ_NO = AA.CHSS_NO" ).append("\n"); 
		query.append("AND H.EQ_ASET_STS_CD IN ('LSI','OWN','DII')" ).append("\n"); 
		query.append("AND H.STS_EVNT_DT BETWEEN  TO_DATE( REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ) AND ADD_MONTHS( TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ),1)" ).append("\n"); 
		query.append(") THEN 'H'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL( (SELECT /*+ INDEX_DESC(H XAK4CGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("CASE WHEN EQ_ASET_STS_CD IN ('LSI','OWN','DII') THEN 'H'" ).append("\n"); 
		query.append("ELSE 'O'" ).append("\n"); 
		query.append("END CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.EQ_NO =  AA.CHSS_NO" ).append("\n"); 
		query.append("AND H.EQ_ASET_STS_CD IN ('LSI','OWN','DII','LSO','TLL','SCR','SLD')" ).append("\n"); 
		query.append("AND H.STS_EVNT_DT < TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' )" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append(",'O')" ).append("\n"); 
		query.append("END CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE WHEN EXISTS (SELECT /*+ INDEX(H XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("'X' FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.CNTR_NO = AA.CNTR_NO" ).append("\n"); 
		query.append("AND H.CNTR_STS_CD IN ('LSI','OWN','DII')" ).append("\n"); 
		query.append("AND H.CNTR_STS_EVNT_DT BETWEEN  TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ) AND ADD_MONTHS( TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ),1)" ).append("\n"); 
		query.append(") THEN 'H'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL( (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("CASE WHEN CNTR_STS_CD IN ('LSI','OWN','DII') THEN 'H'" ).append("\n"); 
		query.append("ELSE 'O'" ).append("\n"); 
		query.append("END CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.CNTR_NO = AA.CNTR_NO" ).append("\n"); 
		query.append("AND H.CNTR_STS_CD IN ('LSI','OWN','DII','LSO','TLL','SCR','SLD')" ).append("\n"); 
		query.append("AND H.CNTR_STS_EVNT_DT < TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' )" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append(",'O')" ).append("\n"); 
		query.append("END CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", MAX( HJS_ONHDT )  HJS_ONHDT" ).append("\n"); 
		query.append(",MAX( HJS_ONHYD ) HJS_ONHYD" ).append("\n"); 
		query.append(", MAX( HJS_OFFHDT )  HJS_OFFHDT" ).append("\n"); 
		query.append(",MAX( HJS_OFFYD ) HJS_OFFHYD" ).append("\n"); 
		query.append(", MAX( HJS_USDY)  HJS_USDY" ).append("\n"); 
		query.append(", MAX( MGMT_ONHDT)  MGMT_ONHDT" ).append("\n"); 
		query.append(",MAX( MGMT_ONHYD) MGMT_ONHYD" ).append("\n"); 
		query.append(", MAX( MGMT_OFFHDT)  MGMT_OFFHDT" ).append("\n"); 
		query.append(",MAX( MGMT_OFFHYD) MGMT_OFFHYD" ).append("\n"); 
		query.append(", MAX( MGMT_USDDYS)MGMT_USDDYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AA.CHSS_NO" ).append("\n"); 
		query.append(",AA.CNTR_NO" ).append("\n"); 
		query.append(",'1'||AA.CHSS_OWNR_CO_CD CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",'1'||AA.CNTR_OWNR_CO_CD CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(",AA.ONH_DT HJS_ONHDT" ).append("\n"); 
		query.append(",AA.ONH_YD HJS_ONHYD" ).append("\n"); 
		query.append(", AA.OFFH_DT  HJS_OFFHDT" ).append("\n"); 
		query.append(",AA.OFFH_YD  HJS_OFFYD" ).append("\n"); 
		query.append(",AA.POOL_CHSS_USD_DYS HJS_USDY" ).append("\n"); 
		query.append(",NULL MGMT_ONHDT" ).append("\n"); 
		query.append(",NULL MGMT_ONHYD" ).append("\n"); 
		query.append(",NULL MGMT_OFFHDT" ).append("\n"); 
		query.append(",NULL MGMT_OFFHYD" ).append("\n"); 
		query.append(",NULL MGMT_USDDYS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("HJSDYS.CHSS_NO" ).append("\n"); 
		query.append(",HJSDYS.CNTR_NO" ).append("\n"); 
		query.append(",MAX(CHSS_OWNR_CO_CD) CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",MAX(CNTR_OWNR_CO_CD) CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(", SUBSTR( MIN(HJSDYS.ONH_YDDT)  , 1,14) ONH_dt" ).append("\n"); 
		query.append(", SUBSTR( MIN(HJSDYS.ONH_YDDT)  , 15) ONH_YD" ).append("\n"); 
		query.append(", SUBSTR( MAX(HJSDYS.OFFH_YDDT)  , 1,14) OFFH_DT" ).append("\n"); 
		query.append(", SUBSTR( MAX(HJSDYS.OFFH_YDDT)  , 15) OFFH_YD" ).append("\n"); 
		query.append(", SUM(POOL_CHSS_USD_DYS) POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CHSS_NO" ).append("\n"); 
		query.append(",A.CNTR_NO" ).append("\n"); 
		query.append(",CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",A.ONH_DT" ).append("\n"); 
		query.append(",A.OFFH_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.ONH_DT,'YYYYMMDDHH24MISS') || A.ONH_YD_CD ONH_YDDT" ).append("\n"); 
		query.append(",TO_CHAR(A.OFFH_DT,'YYYYMMDDHH24MISS') || A.OFFH_YD_CD OFFH_YDDT" ).append("\n"); 
		query.append(",POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM CGM_POOL_CHSS_USD_DYS_SMRY A ,CGM_CHSS_POOL_LOC_MTCH B" ).append("\n"); 
		query.append("WHERE A.COST_YRMON = TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ), 'YYYYMM')" ).append("\n"); 
		query.append("--AND SUBSTR(A.ONH_YD_CD, 1, 5) = B.HJS_POOL_LOC_CD" ).append("\n"); 
		query.append("AND A.ONH_YD_CD LIKE B.HJS_POOL_LOC_CD || '%'" ).append("\n"); 
		query.append("AND B.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("ORDER BY A.CHSS_NO" ).append("\n"); 
		query.append(",ONH_DT" ).append("\n"); 
		query.append(") HJSDYS" ).append("\n"); 
		query.append("GROUP BY HJSDYS.CHSS_NO" ).append("\n"); 
		query.append(",HJSDYS.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CHSS_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",'2'||CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",'2'||CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",NULL" ).append("\n"); 
		query.append(",ONH_DT   MGMT_ONH_DT" ).append("\n"); 
		query.append(",ONH_YD" ).append("\n"); 
		query.append(", OFFH_DT  MGMT_OFFHDT" ).append("\n"); 
		query.append(",OFFH_YD" ).append("\n"); 
		query.append(",POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MGMTDYS.CHSS_NO" ).append("\n"); 
		query.append(",MGMTDYS.CNTR_NO" ).append("\n"); 
		query.append(",MAX(MGMTDYS.CHSS_OWNR_CO_CD) CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",MAX(MGMTDYS.CNTR_OWNR_CO_CD ) CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUBSTR( MIN(MGMTDYS.ONH_YDDT)  , 1,14) ONH_DT" ).append("\n"); 
		query.append(", SUBSTR( MIN(MGMTDYS.ONH_YDDT)  , 15) ONH_YD" ).append("\n"); 
		query.append(", SUBSTR( MAX(MGMTDYS.OFFH_YDDT)  , 1,14) OFFH_DT" ).append("\n"); 
		query.append(", SUBSTR( MAX(MGMTDYS.OFFH_YDDT)  , 15) OFFH_YD" ).append("\n"); 
		query.append(", SUM(POOL_CHSS_USD_DYS) POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CHSS_NO" ).append("\n"); 
		query.append(",A.CNTR_NO" ).append("\n"); 
		query.append(",A.CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",nvl(A.CNTR_OWNR_CO_CD, 'O') CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",A.ONH_DT" ).append("\n"); 
		query.append(",A.OFFH_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.ONH_DT,'YYYYMMDDHH24MISS') || A.ONH_LOC_NM ONH_YDDT" ).append("\n"); 
		query.append(",TO_CHAR(A.OFFH_DT,'YYYYMMDDHH24MISS') || A.OFFH_LOC_NM OFFH_YDDT" ).append("\n"); 
		query.append(",POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM CGM_POOL_CO_CHSS_USE_HIS A ,CGM_POOL_CHSS_IMP_FILE B" ).append("\n"); 
		query.append("WHERE B.COST_YRMON = TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ), 'YYYYMM')" ).append("\n"); 
		query.append("AND B.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.FILE_SEQ = B.FILE_SEQ" ).append("\n"); 
		query.append(") MGMTDYS" ).append("\n"); 
		query.append("GROUP BY MGMTDYS.CHSS_NO" ).append("\n"); 
		query.append(",MGMTDYS.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("CHSS_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append("--,NVL(HJS_ONHDT , MGMT_ONHDT)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("group by CNTR_OWNR_CO_CD, CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append("ORDER BY CNTR_OWNR_CO_CD, CHSS_OWNR_CO_CD" ).append("\n"); 

	}
}