/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOCreateVesselChtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.10.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOCreateVesselChtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대선수지
	  * </pre>
	  */
	public CostSetUpDBDAOCreateVesselChtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOCreateVesselChtCSQL").append("\n"); 
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
		query.append("--================================================================================" ).append("\n"); 
		query.append("-- 파라미터" ).append("\n"); 
		query.append("-- 1. 유저id" ).append("\n"); 
		query.append("-- 2. yyyywk" ).append("\n"); 
		query.append("--================================================================================" ).append("\n"); 
		query.append("MERGE INTO COA_MNL_COST_STUP A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT SUBSTR(@[cost_yrweek], 1, 4)||MIN(eq_wk) cost_yrmon" ).append("\n"); 
		query.append("             , SUBSTR(@[cost_yrweek], 5, 2) cost_wk" ).append("\n"); 
		query.append("             , 'COM' trd_cd" ).append("\n"); 
		query.append("             , 'CDMCO' rlane_cd" ).append("\n"); 
		query.append("             , 'O' ioc_cd" ).append("\n"); 
		query.append("             , 'M' dir_cd" ).append("\n"); 
		query.append("             , 'OT' sub_trd_cd" ).append("\n"); 
		query.append("             , SUM(otr_expn_amt) otr_expn_amt " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                 SELECT vsl_cd" ).append("\n"); 
		query.append("                      , eq_wk" ).append("\n"); 
		query.append("                      --, SUM( DECODE(b.flet_ctrt_tp_cd, 'TI', rt_amt, 0 )) ti_rate" ).append("\n"); 
		query.append("                      --, SUM( DECODE(b.flet_ctrt_tp_cd, 'TO', rt_amt, 0 )) to_rate" ).append("\n"); 
		query.append("                      --, SUM( DECODE(b.flet_ctrt_tp_cd, 'TO', rt_amt, 0 )) - SUM( DECODE(b.flet_ctrt_tp_cd, 'TI', rt_amt, 0 )) diff" ).append("\n"); 
		query.append("                      ,((SUM( DECODE(b.flet_ctrt_tp_cd, 'TO', rt_amt, 0 )) - SUM( DECODE(b.flet_ctrt_tp_cd, 'TI', rt_amt, 0 ))) " ).append("\n"); 
		query.append("                        * SUM(DECODE(b.flet_ctrt_tp_cd, 'TO', b.day_cnt))) otr_expn_amt" ).append("\n"); 
		query.append("                   FROM (" ).append("\n"); 
		query.append("                         SELECT a.flet_ctrt_tp_cd" ).append("\n"); 
		query.append("                              , a.vsl_cd" ).append("\n"); 
		query.append("                              , a.day_cnt" ).append("\n"); 
		query.append("                              , a.eq_wk" ).append("\n"); 
		query.append("                              , SUM(a.hir_rt_amt / DECODE (a.curr_cd, 'USD', 1, NVL (b.usd_locl_xch_rt, 0))) rt_amt" ).append("\n"); 
		query.append("                           FROM (" ).append("\n"); 
		query.append("                                 SELECT flet_ctrt_tp_cd" ).append("\n"); 
		query.append("                                      , vsl_cd" ).append("\n"); 
		query.append("                                      , flet_ctrt_no" ).append("\n"); 
		query.append("                                      , DECODE(no, 1, hir_rt_n1st_amt, hir_rt_n2nd_amt) hir_rt_amt" ).append("\n"); 
		query.append("                                      , DECODE(no, 1, hir_curr_n1st_cd, hir_curr_n2nd_cd) curr_cd" ).append("\n"); 
		query.append("                                      , eff_dt" ).append("\n"); 
		query.append("                                      , exp_dt" ).append("\n"); 
		query.append("                                      , start_dt" ).append("\n"); 
		query.append("                                      , end_dt" ).append("\n"); 
		query.append("                                      , (TO_DATE(end_dt, 'YYYYMMDD') - TO_DATE(start_dt, 'YYYYMMDD') + 1) day_cnt" ).append("\n"); 
		query.append("                                      , cost_wk" ).append("\n"); 
		query.append("                                      , eq_wk" ).append("\n"); 
		query.append("                                   FROM (" ).append("\n"); 
		query.append("                                        --대선수지 계산할때는 시간 상관하지 않고 2012.08.01 까지 USD 18720 2012.08.02 부터 18845" ).append("\n"); 
		query.append("                                        --        From Date		To Date			Daily Hire" ).append("\n"); 
		query.append("                                        --1	2011.08.01 09:24	2012.08.01 09:24	18720" ).append("\n"); 
		query.append("                                        --2	2012.08.01 09:24	2017.08.01 00:00	18845" ).append("\n"); 
		query.append("                                         SELECT fc.flet_ctrt_tp_cd" ).append("\n"); 
		query.append("                                              , fc.vsl_cd" ).append("\n"); 
		query.append("                                              , h.flet_ctrt_no" ).append("\n"); 
		query.append("                                              , h.eff_dt" ).append("\n"); 
		query.append("                                              , h.exp_dt" ).append("\n"); 
		query.append("                                              , h.hir_rt_n1st_amt" ).append("\n"); 
		query.append("                                              , h.hir_curr_n1st_cd" ).append("\n"); 
		query.append("                                              , h.hir_rt_n2nd_amt" ).append("\n"); 
		query.append("                                              , h.hir_curr_n2nd_cd" ).append("\n"); 
		query.append("                                              , DECODE(h.hir_curr_n2nd_cd, NULL, 1, 2) seq" ).append("\n"); 
		query.append("                                              , wk.cost_wk" ).append("\n"); 
		query.append("                                              , wk.sls_fm_dt" ).append("\n"); 
		query.append("                                              , wk.sls_to_dt" ).append("\n"); 
		query.append("                                              , wk.eq_wk" ).append("\n"); 
		query.append("                                              , CASE" ).append("\n"); 
		query.append("                                                        WHEN TO_CHAR(h.eff_dt, 'yyyymmdd') < wk.sls_fm_dt THEN wk.sls_fm_dt" ).append("\n"); 
		query.append("                                                        ELSE TO_CHAR(h.eff_dt, 'yyyymmdd')" ).append("\n"); 
		query.append("                                                END AS start_dt" ).append("\n"); 
		query.append("                                              , CASE" ).append("\n"); 
		query.append("                                                        WHEN TO_CHAR(h.exp_dt, 'yyyymmdd') > wk.sls_to_dt THEN wk.sls_to_dt" ).append("\n"); 
		query.append("                                                        ELSE TO_CHAR(h.exp_dt, 'yyyymmdd')" ).append("\n"); 
		query.append("                                                END AS end_dt" ).append("\n"); 
		query.append("                                           FROM fms_hire h" ).append("\n"); 
		query.append("                                              , fms_contract fc" ).append("\n"); 
		query.append("                                              , coa_vsl_rgst v" ).append("\n"); 
		query.append("                                              , COA_WK_PRD wk" ).append("\n"); 
		query.append("                                          WHERE h.flet_ctrt_no = fc.flet_ctrt_no" ).append("\n"); 
		query.append("                                            AND fc.vsl_cd = v.vsl_cd" ).append("\n"); 
		query.append("                                            AND wk.cost_yr = SUBSTR(@[cost_yrweek], 1, 4)" ).append("\n"); 
		query.append("                                            AND wk.cost_wk = SUBSTR(@[cost_yrweek], 5, 2)" ).append("\n"); 
		query.append("                                            AND NVL(fc.delt_flg,'N') = 'N'" ).append("\n"); 
		query.append("                                            AND NVL(v.delt_flg,'N') = 'N'" ).append("\n"); 
		query.append("                                            AND v.lst_flg ='Y'" ).append("\n"); 
		query.append("                                            AND v.vsl_tp_cd = 'C'" ).append("\n"); 
		query.append("                                            AND TO_DATE(TO_CHAR(h.eff_dt,'YYYYMMDD'),'YYYYMMDD') <= to_date(wk.sls_to_dt, 'yyyymmdd')" ).append("\n"); 
		query.append("                                            AND TO_DATE(TO_CHAR(h.exp_dt,'YYYYMMDD'),'YYYYMMDD') >= to_date(wk.sls_fm_dt, 'yyyymmdd')" ).append("\n"); 
		query.append("                                         --   AND fc.vsl_cd LIKE 'HJRD' || '%' --HNSA ,HNMD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                      , (" ).append("\n"); 
		query.append("                                         SELECT cpy_no no" ).append("\n"); 
		query.append("                                           FROM com_cpy_no" ).append("\n"); 
		query.append("                                          WHERE cpy_no BETWEEN 1 AND 2" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                  WHERE seq >= no" ).append("\n"); 
		query.append("                                ) a" ).append("\n"); 
		query.append("                              , gl_mon_xch_rt b" ).append("\n"); 
		query.append("                          WHERE a.curr_cd = b.curr_cd" ).append("\n"); 
		query.append("                            AND b.acct_xch_rt_lvl(+) = '1'" ).append("\n"); 
		query.append("                            AND b.acct_xch_rt_yrmon(+) = substr(@[cost_yrweek],1,4)||a.eq_wk" ).append("\n"); 
		query.append("                       GROUP BY a.flet_ctrt_tp_cd" ).append("\n"); 
		query.append("                              , a.vsl_cd" ).append("\n"); 
		query.append("                              , a.day_cnt" ).append("\n"); 
		query.append("                              , a.eq_wk" ).append("\n"); 
		query.append("                        ) b" ).append("\n"); 
		query.append("                GROUP BY vsl_cd, eq_wk" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(") b " ).append("\n"); 
		query.append("ON (        a.cost_yrmon = b.cost_yrmon " ).append("\n"); 
		query.append("        AND a.cost_wk = b.cost_wk " ).append("\n"); 
		query.append("        AND a.trd_cd = b.trd_cd " ).append("\n"); 
		query.append("        AND a.rlane_cd = b.rlane_cd )" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("        UPDATE SET a.otr_expn_amt = b.otr_expn_amt" ).append("\n"); 
		query.append("                 , a.upd_dt = SYSDATE" ).append("\n"); 
		query.append("                 , a.upd_usr_id = @[user_id]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("        INSERT (  a.cost_yrmon" ).append("\n"); 
		query.append("                , a.cost_wk" ).append("\n"); 
		query.append("                , a.trd_cd" ).append("\n"); 
		query.append("                , a.rlane_cd" ).append("\n"); 
		query.append("                , a.ioc_cd" ).append("\n"); 
		query.append("                , a.dir_cd" ).append("\n"); 
		query.append("                , a.sub_trd_cd" ).append("\n"); 
		query.append("                , a.otr_expn_amt" ).append("\n"); 
		query.append("                , a.cre_usr_id" ).append("\n"); 
		query.append("                , a.cre_dt" ).append("\n"); 
		query.append("                , a.upd_usr_id" ).append("\n"); 
		query.append("                , a.upd_dt)" ).append("\n"); 
		query.append("        VALUES (  b.cost_yrmon" ).append("\n"); 
		query.append("                , b.cost_wk" ).append("\n"); 
		query.append("                , b.trd_cd" ).append("\n"); 
		query.append("                , b.rlane_cd" ).append("\n"); 
		query.append("                , b.ioc_cd" ).append("\n"); 
		query.append("                , b.dir_cd" ).append("\n"); 
		query.append("                , b.sub_trd_cd" ).append("\n"); 
		query.append("                , b.otr_expn_amt" ).append("\n"); 
		query.append("                , @[user_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("                , @[user_id]" ).append("\n"); 
		query.append("                , SYSDATE)" ).append("\n"); 

	}
}