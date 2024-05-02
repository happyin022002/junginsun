/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.08.20 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD별 Budget / Expense Plan Detail 비용을 조회한다.
	  * ======================================
	  * History
	  * 2012.08.20 진마리아 CHM-201219078-01 사업계획 - 시나리오 연도 추가
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cls",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL").append("\n"); 
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
		query.append("SELECT mm yyyy_mm, vvd, " ).append("\n"); 
		query.append("decode(@[gubun], 0, lane, 1, loc) LANE, " ).append("\n"); 
		query.append("acct account_code, ACT_AMT BUDGET, EST_AMT ESTIMATE   " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(        " ).append("\n"); 
		query.append("     SELECT mm, vvd, lane, loc, acct, SUM(DECODE(tp,'1',amt,0)) ACT_AMT,  SUM(DECODE(tp,'2',amt,0)) EST_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (    " ).append("\n"); 
		query.append("        select  '1' tp, t11.rev_yrmon mm, t10.vsl_cd||t10.skd_voy_no||t10.skd_dir_cd vvd, t10.vsl_slan_cd lane,cst.acct_cd acct, substr(t11.yd_cd,1,5) loc, SUM(inv_usd_amt) AMT" ).append("\n"); 
		query.append("                from    pso_tgt_vvd t10, pso_tgt_yd_expn t11, mdm_vsl_cntr vsl, tes_lgs_cost cst     " ).append("\n"); 
		query.append("                where   1 = 1" ).append("\n"); 
		query.append("                and     t10.vsl_cd     = t11.vsl_cd" ).append("\n"); 
		query.append("                and     t10.skd_voy_no = t11.skd_voy_no" ).append("\n"); 
		query.append("                and     t10.skd_dir_cd = t11.skd_dir_cd" ).append("\n"); 
		query.append("                and     t10.pso_bztp_cd = '1'" ).append("\n"); 
		query.append("				and     t10.pso_bztp_cd = t11.pso_bztp_cd" ).append("\n"); 
		query.append("                and     t10.BUD_SCNR_NO = t11.BUD_SCNR_NO" ).append("\n"); 
		query.append("                and     t11.rev_yrmon between replace(@[cre_dt_fr],'-','') AND replace(@[cre_dt_to],'-','')" ).append("\n"); 
		query.append("                AND     TO_CHAR(t10.CRE_DT,'YYYYMM') = (SELECT MAX(TO_CHAR(CRE_DT,'YYYYMM')) FROM PSO_TGT_VVD WHERE PSO_BZTP_CD='1')--BUD_SCNR_NO 조건 없이 가장 최근 생성된 VVD만을 대상으로 함" ).append("\n"); 
		query.append("                and     t10.vsl_cd      = vsl.vsl_cd" ).append("\n"); 
		query.append("                and     t11.lgs_cost_cd = cst.lgs_cost_cd" ).append("\n"); 
		query.append("                and     cst.acct_cd     = @[acct_cd]" ).append("\n"); 
		query.append("				#if(${vsl_cls}!='')" ).append("\n"); 
		query.append("                and     vsl.CNTR_VSL_CLSS_CAPA  = @[vsl_cls]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${lane_cd}!='')" ).append("\n"); 
		query.append("                and     t10.vsl_slan_cd = @[lane_cd]  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${loc_cd}!='')" ).append("\n"); 
		query.append("                and     SUBSTR(t11.yd_cd,1,5)       = @[loc_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("        group by  t11.rev_yrmon , t10.vsl_cd, t10.skd_voy_no, t10.skd_dir_cd, t10.vsl_slan_cd,cst.acct_cd,substr(t11.yd_cd,1,5)                    " ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        select  '2' tp,est.rev_yrmon mm, est.vsl_cd||est.skd_voy_no||est.skd_dir_cd vvd, vsk.vsl_slan_cd lane, est.acct_cd acct, est.loc_cd loc,  SUM(ESTM_AMT) AMT" ).append("\n"); 
		query.append("                from    gl_estm_if_erp est, mdm_vsl_cntr vsl,  vsk_vsl_skd  vsk" ).append("\n"); 
		query.append("                where   sys_src_id      = 'PSO'" ).append("\n"); 
		query.append("                and     est.rev_yrmon between replace(@[cre_dt_fr],'-','') AND replace(@[cre_dt_to],'-','')" ).append("\n"); 
		query.append("                and     est.vsl_cd      = vsl.vsl_cd" ).append("\n"); 
		query.append("                and     vsk.vsl_cd      = est.vsl_cd" ).append("\n"); 
		query.append("                and     vsk.skd_voy_no  = est.skd_voy_no" ).append("\n"); 
		query.append("                and     vsk.skd_dir_cd  = est.skd_dir_cd" ).append("\n"); 
		query.append("                and    est.acct_cd      = @[acct_cd]" ).append("\n"); 
		query.append("				#if(${vsl_cls}!='')" ).append("\n"); 
		query.append("                and     vsl.CNTR_VSL_CLSS_CAPA  = @[vsl_cls]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${lane_cd}!='')" ).append("\n"); 
		query.append("                and     vsk.vsl_slan_cd = @[lane_cd]  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${loc_cd}!='')" ).append("\n"); 
		query.append("                and     est.loc_cd      = @[loc_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("          group by  est.rev_yrmon, est.vsl_cd, est.skd_voy_no, est.skd_dir_cd, vsk.vsl_slan_cd,est.acct_cd , est.loc_cd                 " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY mm, vvd, lane, loc, acct" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY mm, lane, loc, vvd" ).append("\n"); 

	}
}