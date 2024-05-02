/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetBlRevInfoRSQL.java
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

public class ACMSimulationDBDAOGetBlRevInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetBlRevInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOGetBlRevInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetBlRevInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(count(rownum),0) count, " ).append("\n"); 
		query.append("       NVL(ROUND(SUM(DECODE(a.frt_term_cd, 'P', DECODE(a.chg_cd, 'OFT',    (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0), 0)), 13), 0) ppd_oft_amt, " ).append("\n"); 
		query.append("       NVL(ROUND(SUM(DECODE(a.frt_term_cd, 'P', DECODE(a.chg_cd, 'OFT', 0, (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0)))), 0)), 13), 0)    ppd_oth_amt, " ).append("\n"); 
		query.append("       NVL(ROUND(SUM(DECODE(a.frt_term_cd, 'C', DECODE(a.chg_cd, 'OFT',    (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0), 0)), 13), 0) cct_oft_amt, " ).append("\n"); 
		query.append("       NVL(ROUND(SUM(DECODE(a.frt_term_cd, 'C', DECODE(a.chg_cd, 'OFT', 0, (a.chg_amt/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0)))), 0)), 13), 0)    cct_oth_amt" ).append("\n"); 
		query.append("  FROM bkg_CHG_rt a, gl_mon_xch_rt b " ).append("\n"); 
		query.append(" WHERE a.bkg_no = @[bkg_no] " ).append("\n"); 
		query.append("   AND a.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("   AND a.curr_cd = b.curr_cd " ).append("\n"); 
		query.append("   AND b.acct_xch_rt_yrmon = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR (@[sa_dt], 1, 6))), 1, SUBSTR (@[sa_dt], 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) " ).append("\n"); 
		query.append("   AND b.acct_xch_rt_lvl = '1'" ).append("\n"); 

	}
}