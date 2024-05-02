/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExchangeRateInqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.08 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchExchangeRateInqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율조회(Foreign Exchange Rate Inquiry)
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExchangeRateInqRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT A.*" ).append("\n"); 
		query.append(", COUNT(*) OVER (PARTITION BY CURR_CD ORDER BY CURR_CD) ROW_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '1' sort1, 'Initial' sort_nm" ).append("\n"); 
		query.append(", Y.COL1 curr_cd" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'1', Y.COL2)) col_jan" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'2', Y.COL2)) col_feb" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'3', Y.COL2)) col_mar" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'4', Y.COL2)) col_apr" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'5', Y.COL2)) col_may" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'6', Y.COL2)) col_jun" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'7', Y.COL2)) col_jul" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'8', Y.COL2)) col_aug" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'9', Y.COL2)) col_sep" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'10', Y.COL2)) col_oct" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'11', Y.COL2)) col_nov" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'12', Y.COL2)) col_dec" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT LEVEL RID FROM DUAL CONNECT BY LEVEL < 13" ).append("\n"); 
		query.append(") X, (" ).append("\n"); 
		query.append("SELECT A.CURR_CD COL1" ).append("\n"); 
		query.append(", A.USD_LOCL_XCH_RT COL2" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY A.CURR_CD ORDER BY A.ACCT_XCH_RT_YRMON) RID" ).append("\n"); 
		query.append("FROM GEM_XCH_RT A, GEM_XCH_RT B" ).append("\n"); 
		query.append("WHERE A.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_YRMON LIKE @[year]||'00%'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.RID = Y.RID" ).append("\n"); 
		query.append("#if(${curr_cd} != '')" ).append("\n"); 
		query.append("AND Y.COL1 IN (${curr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY Y.COL1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' sort1, 'USD(1):LCL' sort_nm" ).append("\n"); 
		query.append(", Y.COL1 curr_cd" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'1', Y.COL2)) col_jan" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'2', Y.COL2)) col_feb" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'3', Y.COL2)) col_mar" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'4', Y.COL2)) col_apr" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'5', Y.COL2)) col_may" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'6', Y.COL2)) col_jun" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'7', Y.COL2)) col_jul" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'8', Y.COL2)) col_aug" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'9', Y.COL2)) col_sep" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'10', Y.COL2)) col_oct" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'11', Y.COL2)) col_nov" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'12', Y.COL2)) col_dec" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT LEVEL RID FROM DUAL CONNECT BY LEVEL < 13" ).append("\n"); 
		query.append(") X, (" ).append("\n"); 
		query.append("SELECT B.CURR_CD COL1" ).append("\n"); 
		query.append(", B.USD_LOCL_XCH_RT COL2" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY B.CURR_CD ORDER BY B.ACCT_XCH_RT_YRMON) RID" ).append("\n"); 
		query.append("FROM GEM_XCH_RT A, GEM_XCH_RT B" ).append("\n"); 
		query.append("WHERE B.GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_YRMON LIKE @[year]||'%'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_YRMON LIKE @[year]||'00%'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.RID = Y.RID" ).append("\n"); 
		query.append("#if(${curr_cd} != '')" ).append("\n"); 
		query.append("AND Y.COL1 IN (${curr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY Y.COL1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '3' sort1, 'LCL:KRW' sort_nm" ).append("\n"); 
		query.append(", Y.COL1 curr_cd" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'1', Y.COL2)) col_jan" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'2', Y.COL2)) col_feb" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'3', Y.COL2)) col_mar" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'4', Y.COL2)) col_apr" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'5', Y.COL2)) col_may" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'6', Y.COL2)) col_jun" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'7', Y.COL2)) col_jul" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'8', Y.COL2)) col_aug" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'9', Y.COL2)) col_sep" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'10', Y.COL2)) col_oct" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'11', Y.COL2)) col_nov" ).append("\n"); 
		query.append(", SUM(DECODE(X.RID,'12', Y.COL2)) col_dec" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT LEVEL RID FROM DUAL CONNECT BY LEVEL < 13" ).append("\n"); 
		query.append(") X, (" ).append("\n"); 
		query.append("SELECT B.CURR_CD COL1" ).append("\n"); 
		query.append(", B.LOCL_KRW_XCH_RT COL2" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY B.CURR_CD ORDER BY B.ACCT_XCH_RT_YRMON) RID" ).append("\n"); 
		query.append("FROM GEM_XCH_RT A, GEM_XCH_RT B" ).append("\n"); 
		query.append("WHERE B.GEN_EXPN_XCH_RT_DIV_CD = 'M'" ).append("\n"); 
		query.append("AND B.ACCT_XCH_RT_YRMON LIKE @[year]||'%'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.GEN_EXPN_XCH_RT_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_YRMON LIKE @[year]||'00%'" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE X.RID = Y.RID" ).append("\n"); 
		query.append("#if(${curr_cd} != '')" ).append("\n"); 
		query.append("AND Y.COL1 IN (${curr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY Y.COL1" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY CURR_CD, SORT1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExchangeRateInqRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}