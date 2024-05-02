/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOsearchPoolMvmtExpenseListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.07 조재성
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

public class PoolChassisHistoryDBDAOsearchPoolMvmtExpenseListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOsearchPoolMvmtExpenseListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOsearchPoolMvmtExpenseListDataRSQL").append("\n"); 
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
		query.append("SELECT AAA.CHSS_POOL_CD ," ).append("\n"); 
		query.append("AAA.MVMT_DT ," ).append("\n"); 
		query.append("AAA.CHSS_POOL_NM ," ).append("\n"); 
		query.append("AAA.EST_AMOUNT ," ).append("\n"); 
		query.append("AAA.INV_AMOUNT ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AAA.EST_AMOUNT- AAA.INV_AMOUNT >=0 THEN (AAA.EST_AMOUNT- AAA.INV_AMOUNT)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS CREDIT ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AAA.INV_AMOUNT- AAA.EST_AMOUNT >=0 THEN (AAA.INV_AMOUNT- AAA.EST_AMOUNT)" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS DEBIT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT AA.CHSS_POOL_CD ," ).append("\n"); 
		query.append("AA.MVMT_DT ," ).append("\n"); 
		query.append("AA.CHSS_POOL_NM ," ).append("\n"); 
		query.append("AA.INV_AMOUNT ," ).append("\n"); 
		query.append("AA.HJS_CHSS_USD_DYS ," ).append("\n"); 
		query.append("AA.RATE ," ).append("\n"); 
		query.append("AA.HJS_CHSS_USD_DYS * AA.RATE EST_AMOUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MAX(CHK) ," ).append("\n"); 
		query.append("INV.CHSS_POOL_CD ," ).append("\n"); 
		query.append("INV.MVMT_DT ," ).append("\n"); 
		query.append("B.CHSS_POOL_NM ," ).append("\n"); 
		query.append("NVL( MAX(INV.HJS_CHSS_USD_DYS ),0) HJS_CHSS_USD_DYS ," ).append("\n"); 
		query.append("NVL( MAX(INV.INV_AMT),0) INV_AMOUNT ," ).append("\n"); 
		query.append("NVL( MAX(RATE),0) RATE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '2' CHK ," ).append("\n"); 
		query.append("B.CHSS_POOL_CD AS CHSS_POOL_CD ," ).append("\n"); 
		query.append("A.COST_YRMON AS MVMT_DT ," ).append("\n"); 
		query.append("SUM(A.POOL_CHSS_USD_DYS) AS HJS_CHSS_USD_DYS," ).append("\n"); 
		query.append("NULL INV_AMT," ).append("\n"); 
		query.append("NULL RATE" ).append("\n"); 
		query.append("FROM CGM_POOL_CHSS_USD_DYS_SMRY A ," ).append("\n"); 
		query.append("CGM_CHSS_POOL_LOC_MTCH B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SUBSTR(A.ONH_YD_CD, 1, 5) = B.HJS_POOL_LOC_CD" ).append("\n"); 
		query.append("AND A.COST_YRMON BETWEEN TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt_fr],'-',''),'YYYYMM' ),'YYYYMM')" ).append("\n"); 
		query.append("AND TO_CHAR(TO_DATE(REPLACE(@[mvmt_dt_to],'-',''),'YYYYMM' ),'YYYYMM')" ).append("\n"); 
		query.append("AND B.CHSS_POOL_CD IN (${chss_pool_cd})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY b.CHSS_POOL_CD, A.COST_YRMON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '1' CHK ," ).append("\n"); 
		query.append("A.CHSS_POOL_CD AS CHSS_POOL_CD ," ).append("\n"); 
		query.append("A.COST_YRMON AS MVMT_DT ," ).append("\n"); 
		query.append("NULL HJS_CHSS_USD_DYS ," ).append("\n"); 
		query.append("SUM(A.CHG_SMRY_AMT) ," ).append("\n"); 
		query.append("MAX(B.RATE)" ).append("\n"); 
		query.append("FROM CGM_PAY_INV A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CHSS_POOL_CD," ).append("\n"); 
		query.append("COST_YRMON," ).append("\n"); 
		query.append("MAX(RATE) RATE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.PAY_INV_SEQ ," ).append("\n"); 
		query.append("A.CHSS_POOL_CD ," ).append("\n"); 
		query.append("COST_YRMON ," ).append("\n"); 
		query.append("SUM(B.POOL_BSRT_AMT) RATE" ).append("\n"); 
		query.append("FROM CGM_PAY_INV A ," ).append("\n"); 
		query.append("CGM_PAY_INV_POOL_DTL B" ).append("\n"); 
		query.append("WHERE A.CHSS_POOL_CD IN (${chss_pool_cd})" ).append("\n"); 
		query.append("AND A.COST_YRMON >= TO_CHAR(TO_DATE(@[mvmt_dt_fr],'YYYY-MM' ),'YYYYMM')" ).append("\n"); 
		query.append("AND A.COST_YRMON <= TO_CHAR(TO_DATE(@[mvmt_dt_to],'YYYY-MM' ),'YYYYMM')" ).append("\n"); 
		query.append("AND A.PAY_INV_SEQ = B.PAY_INV_SEQ" ).append("\n"); 
		query.append("GROUP BY A.PAY_INV_SEQ,A.CHSS_POOL_CD, A.COST_YRMON )" ).append("\n"); 
		query.append("GROUP BY CHSS_POOL_CD,COST_YRMON )  B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD IN (${chss_pool_cd})" ).append("\n"); 
		query.append("AND A.COST_YRMON >= TO_CHAR(TO_DATE(@[mvmt_dt_fr],'YYYY-MM' ),'YYYYMM')" ).append("\n"); 
		query.append("AND A.COST_YRMON <= TO_CHAR(TO_DATE(@[mvmt_dt_to],'YYYY-MM' ),'YYYYMM')" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD = B.CHSS_POOL_CD" ).append("\n"); 
		query.append("AND A.COST_YRMON  = B.COST_YRMON" ).append("\n"); 
		query.append("GROUP BY A.CHSS_POOL_CD,A.COST_YRMON ) INV ," ).append("\n"); 
		query.append("CGM_CHSS_POOL B" ).append("\n"); 
		query.append("WHERE INV.CHSS_POOL_CD = B.CHSS_POOL_CD" ).append("\n"); 
		query.append("GROUP BY INV.MVMT_DT,INV.CHSS_POOL_CD,B.CHSS_POOL_NM" ).append("\n"); 
		query.append("ORDER BY INV.MVMT_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 

	}
}