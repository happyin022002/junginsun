/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOsearchPoolMvmtCompareSmryDataRSQL.java
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

public class PoolChassisHistoryDBDAOsearchPoolMvmtCompareSmryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOsearchPoolMvmtCompareSmryDataRSQL(){
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
		query.append("FileName : PoolChassisHistoryDBDAOsearchPoolMvmtCompareSmryDataRSQL").append("\n"); 
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
		query.append("'SML_MVMT' COM_DIVISION" ).append("\n"); 
		query.append(", CASE WHEN  CNTR_OWNR_CO_CD ='H'   THEN 'For SML CNTR'" ).append("\n"); 
		query.append("WHEN  CHSS_OWNR_CO_CD ='H'   THEN 'For SML CHSS'" ).append("\n"); 
		query.append("ELSE 'For Other CNTR'" ).append("\n"); 
		query.append("END  AS DIVISON" ).append("\n"); 
		query.append(", CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(", CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(", CNTR_OWNR_CO_CD ||'+'|| CHSS_OWNR_CO_CD CNTR_CHSS" ).append("\n"); 
		query.append(",count(DISTINCT CHSS_NO) CHSS_NO" ).append("\n"); 
		query.append(",SUM(HJS_USDY)  HJS_CHSS_USD_DYS" ).append("\n"); 
		query.append(",NVL(MAX(BB.RATE),0) RATE" ).append("\n"); 
		query.append(",SUM(HJS_USDY)  * NVL(MAX(BB.RATE),0) TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("AA.CHSS_NO" ).append("\n"); 
		query.append(",AA.CNTR_NO" ).append("\n"); 
		query.append("--,AA.CHSS_OWNR_CO_CD" ).append("\n"); 
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
		query.append("AND H.STS_EVNT_DT < TO_DATE( REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' )" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append(",'O')" ).append("\n"); 
		query.append("END CHSS_OWNR_CO_CD" ).append("\n"); 
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
		query.append(",A.ONH_DT" ).append("\n"); 
		query.append(",A.OFFH_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.ONH_DT,'YYYYMMDDHH24MISS') || A.ONH_YD_CD ONH_YDDT" ).append("\n"); 
		query.append(",TO_CHAR(A.OFFH_DT,'YYYYMMDDHH24MISS') || A.OFFH_YD_CD OFFH_YDDT" ).append("\n"); 
		query.append(",POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM CGM_POOL_CHSS_USD_DYS_SMRY A ,CGM_CHSS_POOL_LOC_MTCH B" ).append("\n"); 
		query.append("WHERE A.COST_YRMON = TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ), 'YYYYMM')" ).append("\n"); 
		query.append("--AND SUBSTR(A.ONH_YD_CD, 1, 5) = B.HJS_POOL_LOC_CD" ).append("\n"); 
		query.append("AND     A.ONH_YD_CD LIKE B.HJS_POOL_LOC_CD || '%'" ).append("\n"); 
		query.append("AND B.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("ORDER BY A.CHSS_NO" ).append("\n"); 
		query.append(",ONH_DT" ).append("\n"); 
		query.append(") HJSDYS" ).append("\n"); 
		query.append("GROUP BY HJSDYS.CHSS_NO" ).append("\n"); 
		query.append(",HJSDYS.CNTR_NO" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(") ,(" ).append("\n"); 
		query.append("SELECT MAX(RATE) RATE FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ INDEX(AA XAK3CGM_PAY_INV) */" ).append("\n"); 
		query.append("AA.PAY_INV_SEQ" ).append("\n"); 
		query.append(",SUM(BB.POOL_BSRT_AMT) RATE" ).append("\n"); 
		query.append("FROM CGM_PAY_INV AA" ).append("\n"); 
		query.append(", CGM_PAY_INV_POOL_DTL BB" ).append("\n"); 
		query.append("WHERE AA.PAY_INV_SEQ = BB.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND AA.CHSS_MGST_INV_KND_CD = 'CP'" ).append("\n"); 
		query.append("AND AA.CHSS_MGST_INV_STS_CD IN( 'S','C')" ).append("\n"); 
		query.append("AND BB.DTL_POOL_COST_ITM_CD IN ('CA','CB','CC','CD')" ).append("\n"); 
		query.append("AND AA.COST_YRMON =TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt], '-',''),'YYYYMM' ),'YYYYMM' )" ).append("\n"); 
		query.append("AND AA.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("GROUP BY AA.PAY_INV_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY  CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(", CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'MGMT' COM_DIVISION" ).append("\n"); 
		query.append(", CASE WHEN  CNTR_OWNR_CO_CD ='H'   THEN 'For SML CNTR'" ).append("\n"); 
		query.append("WHEN  CHSS_OWNR_CO_CD ='H'   THEN 'For SML CHSS'" ).append("\n"); 
		query.append("ELSE 'For Other CNTR'" ).append("\n"); 
		query.append("END  AS DIVISON" ).append("\n"); 
		query.append(", CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(", CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(", CNTR_OWNR_CO_CD ||'+'|| CHSS_OWNR_CO_CD CNTR_CHSS" ).append("\n"); 
		query.append(",count( CHSS_NO) CHSS_NO" ).append("\n"); 
		query.append(",SUM(POOL_CHSS_USD_DYS)  HJS_CHSS_USD_DYS" ).append("\n"); 
		query.append(",NVL(MAX(BB.RATE),0) RATE" ).append("\n"); 
		query.append(",SUM(POOL_CHSS_USD_DYS)  * NVL(MAX(BB.RATE),0) TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CHSS_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(", CASE WHEN EXISTS (SELECT /*+ INDEX(H XAK4CGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("'X' FROM CGM_EQ_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.EQ_NO = CHSS_NO" ).append("\n"); 
		query.append("AND H.EQ_ASET_STS_CD IN ('LSI','OWN','DII')" ).append("\n"); 
		query.append("AND H.STS_EVNT_DT BETWEEN  TO_DATE( REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ) AND ADD_MONTHS( TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ),1)" ).append("\n"); 
		query.append(") THEN 'H'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL( (SELECT /*+ INDEX_DESC(H XAK4CGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("CASE WHEN EQ_ASET_STS_CD IN ('LSI','OWN','DII') THEN 'H'" ).append("\n"); 
		query.append("ELSE 'O'" ).append("\n"); 
		query.append("END CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.EQ_NO =  CHSS_NO" ).append("\n"); 
		query.append("AND H.EQ_ASET_STS_CD IN ('LSI','OWN','DII','LSO','TLL','SCR','SLD')" ).append("\n"); 
		query.append("AND H.STS_EVNT_DT < TO_DATE( REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' )" ).append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MGMTDYS.CHSS_NO" ).append("\n"); 
		query.append(",MGMTDYS.CNTR_NO" ).append("\n"); 
		query.append(",MAX(MGMTDYS.CHSS_OWNR_CO_CD    ) CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",MAX(MGMTDYS.CNTR_OWNR_CO_CD    ) CNTR_OWNR_CO_CD" ).append("\n"); 
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
		query.append(",A.ONH_DT" ).append("\n"); 
		query.append(",A.OFFH_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.ONH_DT,'YYYYMMDDHH24MISS') || A.ONH_LOC_NM ONH_YDDT" ).append("\n"); 
		query.append(",TO_CHAR(A.OFFH_DT,'YYYYMMDDHH24MISS') || A.OFFH_LOC_NM OFFH_YDDT" ).append("\n"); 
		query.append(",POOL_CHSS_USD_DYS" ).append("\n"); 
		query.append("FROM CGM_POOL_CO_CHSS_USE_HIS A ,CGM_POOL_CHSS_IMP_FILE B" ).append("\n"); 
		query.append("WHERE B.COST_YRMON = TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt], '-',''), 'YYYYMM' ), 'YYYYMM')" ).append("\n"); 
		query.append("AND B.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("--AND CHSS_NO='HJCZ146202'" ).append("\n"); 
		query.append("--AND CNTR_NO='TRIU8371839'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.FILE_SEQ = B.FILE_SEQ) MGMTDYS" ).append("\n"); 
		query.append("GROUP BY MGMTDYS.CHSS_NO" ).append("\n"); 
		query.append(",MGMTDYS.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(") ,(" ).append("\n"); 
		query.append("SELECT MAX(RATE) RATE FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT /*+ INDEX(AA XAK2CGM_PAY_INV) */" ).append("\n"); 
		query.append("AA.PAY_INV_SEQ" ).append("\n"); 
		query.append(",SUM(BB.POOL_BSRT_AMT) RATE" ).append("\n"); 
		query.append("FROM CGM_PAY_INV AA" ).append("\n"); 
		query.append(", CGM_PAY_INV_POOL_DTL BB" ).append("\n"); 
		query.append("WHERE AA.PAY_INV_SEQ = BB.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND AA.CHSS_MGST_INV_KND_CD = 'CP'" ).append("\n"); 
		query.append("AND AA.CHSS_MGST_INV_STS_CD IN( 'S','C')" ).append("\n"); 
		query.append("AND BB.DTL_POOL_COST_ITM_CD IN ('CA','CB','CC','CD')" ).append("\n"); 
		query.append("AND AA.COST_YRMON =TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt], '-',''),'YYYYMM' ),'YYYYMM' )" ).append("\n"); 
		query.append("AND AA.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("GROUP BY AA.PAY_INV_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY  CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(", CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY COM_DIVISION,CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(",CHSS_OWNR_CO_CD" ).append("\n"); 

	}
}