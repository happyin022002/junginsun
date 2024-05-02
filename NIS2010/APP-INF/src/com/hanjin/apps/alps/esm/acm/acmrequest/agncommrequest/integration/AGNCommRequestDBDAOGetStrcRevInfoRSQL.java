/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetStrcRevInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetStrcRevInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetStrcRevInfo
	  * 
	  * 2014.04.16 박다은 [CHM-201429851] Gross Ocean Freight 기반의 계산건(IZMBA, DARBA) FRC중복계산되지 않도록 로직 변경 요청
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetStrcRevInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetStrcRevInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(SUM(DECODE(a.frt_term_cd, 'P', (A.CHG_AMT/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0)), 13), 0) ppd_strc_rev, " ).append("\n"); 
		query.append("       NVL(ROUND(SUM(DECODE(a.frt_term_cd, 'C', (A.CHG_AMT/DECODE(a.curr_cd, 'USD', 1, nvl(b.usd_locl_xch_rt, 0))), 0)), 13), 0) cct_strc_rev " ).append("\n"); 
		query.append("  FROM BKG_CHG_RT a, gl_mon_xch_rt b " ).append("\n"); 
		query.append(" WHERE a.bkg_no = @[bkg_no] " ).append("\n"); 
		query.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n"); 
		query.append("   AND a.curr_cd = b.curr_cd " ).append("\n"); 
		query.append("   AND b.acct_xch_rt_yrmon = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR (@[sa_dt], 1, 6))), 1, SUBSTR (@[sa_dt], 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) " ).append("\n"); 
		query.append("   AND b.acct_xch_rt_lvl = '1' " ).append("\n"); 
		query.append("   AND a.CHG_CD IN (" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT DISTINCT(CHG_CD)" ).append("\n"); 
		query.append("        FROM ACM_AGN_SET_REV_CHG_CD R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND R.REV_FM_DT <=" ).append("\n"); 
		query.append("            CASE WHEN R.REV_FM_DT_CD = 'S' THEN @[sa_dt] " ).append("\n"); 
		query.append("                 WHEN R.REV_FM_DT_CD = 'B' THEN @[bkg_cre_dt]" ).append("\n"); 
		query.append("                 WHEN R.REV_FM_DT_CD = 'R' THEN @[rev_mon]||'01'" ).append("\n"); 
		query.append("            END  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND R.REV_TO_DT >=" ).append("\n"); 
		query.append("            CASE WHEN R.REV_TO_DT_CD = 'S' THEN @[sa_dt] " ).append("\n"); 
		query.append("                 WHEN R.REV_TO_DT_CD = 'B' THEN @[bkg_cre_dt]" ).append("\n"); 
		query.append("                 WHEN R.REV_TO_DT_CD = 'R' THEN @[rev_mon]||'01'" ).append("\n"); 
		query.append("            END  " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        AND NVL(R.RHQ_CD,     @[rhq_cd])     = @[rhq_cd]" ).append("\n"); 
		query.append("        AND NVL(R.SVC_SCP_CD, @[svc_scp_cd]) = @[svc_scp_cd]" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   AND 'N' = @[rev_div_cd] -- Gross 일 경우엔 Revenue Add 하지 않도록 한다." ).append("\n"); 

	}
}