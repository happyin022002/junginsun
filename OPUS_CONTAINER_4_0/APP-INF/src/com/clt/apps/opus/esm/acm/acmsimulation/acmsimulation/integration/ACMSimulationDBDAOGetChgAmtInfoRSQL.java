/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetChgAmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetChgAmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetChgAmtInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOGetChgAmtInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetChgAmtInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    NVL(ROUND(SUM( " ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'P' AND R.CHG_CD = 'OFT' AND R.CURR_CD     = 'USD' " ).append("\n"); 
		query.append("            THEN R.CHG_AMT " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'P' AND R.CHG_CD = 'OFT' AND NVL(G.USD_LOCL_XCH_RT, 0) <> 0 " ).append("\n"); 
		query.append("            THEN R.CHG_AMT / G.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("            ELSE 0 " ).append("\n"); 
		query.append("        END),2),0)                                      AS PPD_OFRT_AMT, " ).append("\n"); 
		query.append("    NVL(ROUND(SUM (" ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'P' AND R.CHG_CD  = 'OFT' " ).append("\n"); 
		query.append("            THEN 0 " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'P' AND R.CURR_CD = 'USD' " ).append("\n"); 
		query.append("            THEN R.CHG_AMT " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'P' AND NVL (G.USD_LOCL_XCH_RT, 0) <> 0 " ).append("\n"); 
		query.append("            THEN R.CHG_AMT / G.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("            ELSE 0 " ).append("\n"); 
		query.append("        END),2),0)                                       AS PPD_CHG_AMT, " ).append("\n"); 
		query.append("    NVL(ROUND(SUM( " ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'C' AND R.CHG_CD = 'OFT' AND R.CURR_CD     = 'USD' " ).append("\n"); 
		query.append("            THEN R.CHG_AMT " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'C' AND R.CHG_CD = 'OFT' AND NVL (G.USD_LOCL_XCH_RT, 0) <> 0 " ).append("\n"); 
		query.append("            THEN R.CHG_AMT / G.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("            ELSE 0 " ).append("\n"); 
		query.append("        END),2),0)                                       AS CLT_OFRT_AMT, " ).append("\n"); 
		query.append("    NVL(ROUND(SUM( " ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'C' AND R.CHG_CD  = 'OFT' " ).append("\n"); 
		query.append("            THEN 0 " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'C' AND R.CURR_CD = 'USD' " ).append("\n"); 
		query.append("            THEN R.CHG_AMT " ).append("\n"); 
		query.append("            WHEN R.FRT_TERM_CD = 'C' AND NVL (G.USD_LOCL_XCH_RT, 0) <> 0 " ).append("\n"); 
		query.append("            THEN R.CHG_AMT / G.USD_LOCL_XCH_RT " ).append("\n"); 
		query.append("            ELSE 0 " ).append("\n"); 
		query.append("        END),2),0)                                       AS CLT_CHG_AMT " ).append("\n"); 
		query.append("FROM BKG_CHG_RT R, GL_MON_XCH_RT G" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND R.FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("AND G.ACCT_XCH_RT_LVL      = '1' " ).append("\n"); 
		query.append("AND G.CURR_CD = R.CURR_CD" ).append("\n"); 
		query.append("AND G.ACCT_XCH_RT_YRMON = substr(@[rt_aply_dt],1,6)" ).append("\n"); 

	}
}