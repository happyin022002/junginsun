/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOCreateVSLMarketRtCSQL.java
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

public class CostSetUpDBDAOCreateVSLMarketRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 용선료 시장가 차액 생성
	  * </pre>
	  */
	public CostSetUpDBDAOCreateVSLMarketRtCSQL(){
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
		query.append("FileName : CostSetUpDBDAOCreateVSLMarketRtCSQL").append("\n"); 
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
		query.append(" SELECT cost_yrmon" ).append("\n"); 
		query.append("      , cost_wk" ).append("\n"); 
		query.append("      , trd_cd" ).append("\n"); 
		query.append("      , 'CNTMR' rlane_cd" ).append("\n"); 
		query.append("      , 'O' ioc_cd" ).append("\n"); 
		query.append("      , 'M' dir_cd" ).append("\n"); 
		query.append("      , 'OT' sub_trd_cd" ).append("\n"); 
		query.append("      , SUM(chrg_dhir_diff_amt) otr_expn_amt" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("         SELECT b.cost_yrmon" ).append("\n"); 
		query.append("              , cost_wk" ).append("\n"); 
		query.append("              , a.trd_cd" ).append("\n"); 
		query.append("              , a.slan_cd" ).append("\n"); 
		query.append("              , a.vsl_cd" ).append("\n"); 
		query.append("              , a.count_dt" ).append("\n"); 
		query.append("              , b.diff_amt" ).append("\n"); 
		query.append("              , (a.count_dt * b.diff_amt) chrg_dhir_diff_amt" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                 -- IES->AES, IMS->EMS 로 귀속" ).append("\n"); 
		query.append("                 -- 주차에 해당하는 VESSEL의 운항 일수를 구한다." ).append("\n"); 
		query.append("                 SELECT a.slan_cd" ).append("\n"); 
		query.append("                      , a.vsl_cd" ).append("\n"); 
		query.append("                      , DECODE(a.trd_cd, 'IES', 'AES', 'IMS', 'EMS', a.trd_cd) trd_cd" ).append("\n"); 
		query.append("                      , (b.cost_yr||b.eq_wk) cost_yrmon" ).append("\n"); 
		query.append("                      , b.cost_wk" ).append("\n"); 
		query.append("                      , (CASE WHEN a.end_dt < b.sls_to_dt THEN to_date(a.end_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("                              ELSE to_date(b.sls_to_dt, 'YYYYMMDD') END) - " ).append("\n"); 
		query.append("                        (CASE WHEN a.start_dt > b.sls_fm_dt THEN to_date(a.start_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("                              ELSE to_date(b.sls_fm_dt, 'YYYYMMDD') END ) +1 count_dt" ).append("\n"); 
		query.append("                   FROM (" ).append("\n"); 
		query.append("                        -- start, end date 는 정오를 기준으로 start date가 정오를 넘을 경우 +1 일" ).append("\n"); 
		query.append("                         SELECT slan_cd" ).append("\n"); 
		query.append("                              , vsl_cd" ).append("\n"); 
		query.append("                              , trd_cd" ).append("\n"); 
		query.append("                              , vps_etb_dt" ).append("\n"); 
		query.append("                              , vps_etd_dt" ).append("\n"); 
		query.append("                              , CASE" ).append("\n"); 
		query.append("                                        WHEN vps_etb_dt > to_date(TO_CHAR(vps_etb_dt, 'YYYYMMDD')||'1200', 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                        THEN TO_CHAR(vps_etb_dt + 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                        ELSE TO_CHAR(vps_etb_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                END AS start_dt" ).append("\n"); 
		query.append("                              , CASE" ).append("\n"); 
		query.append("                                        WHEN vps_etd_dt > to_date(TO_CHAR(vps_etd_dt, 'YYYYMMDD')||'1200', 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                        THEN TO_CHAR(vps_etd_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                        ELSE TO_CHAR(vps_etd_dt - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                END AS end_dt" ).append("\n"); 
		query.append("                           FROM (" ).append("\n"); 
		query.append("                                        -- service lane별 vessel의 start, end date를 가져온다." ).append("\n"); 
		query.append("                                         SELECT A.slan_cd" ).append("\n"); 
		query.append("                                              , A.vsl_cd" ).append("\n"); 
		query.append("                                              , B.trd_cd" ).append("\n"); 
		query.append("                                              , MIN(A.vps_etb_dt) vps_etb_dt" ).append("\n"); 
		query.append("                                              , MAX(A.vps_etd_dt) vps_etd_dt" ).append("\n"); 
		query.append("                                           FROM vsk_vsl_port_skd A" ).append("\n"); 
		query.append("                                              , coa_lane_rgst B" ).append("\n"); 
		query.append("                                          WHERE A.slan_cd = B.slan_cd" ).append("\n"); 
		query.append("                                            AND A.turn_port_ind_cd NOT IN ('V', 'D')" ).append("\n"); 
		query.append("                                            AND NVL(B.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                                            AND NVL(B.trnk_ipt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                                            AND B.mkt_rt_flg = 'Y'" ).append("\n"); 
		query.append("                                            --   AND a.vsl_cd='HNPR'" ).append("\n"); 
		query.append("                                       GROUP BY A.slan_cd" ).append("\n"); 
		query.append("                                              , A.vsl_cd" ).append("\n"); 
		query.append("                                              , B.trd_cd" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                        ) a" ).append("\n"); 
		query.append("                      , coa_wk_prd b" ).append("\n"); 
		query.append("                  WHERE b.cost_yr = SUBSTR(@[cost_yrweek],1,4)" ).append("\n"); 
		query.append("                    AND b.cost_wk = SUBSTR(@[cost_yrweek],5,2)--20" ).append("\n"); 
		query.append("                    AND a.start_dt <= b.sls_to_dt" ).append("\n"); 
		query.append("                    AND a.end_dt >= b.sls_fm_dt" ).append("\n"); 
		query.append("                ) a" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                 SELECT cost_yrmon" ).append("\n"); 
		query.append("                      , vsl_cd" ).append("\n"); 
		query.append("                      , SUM (NVL(a.hir_rt, 0) / DECODE (a.curr_cd, 'USD', 1, NULL, 1, NVL (b.usd_locl_xch_rt, 0))) dhir_amt -- 용선료 실적" ).append("\n"); 
		query.append("                      , MIN(chrg_dhir_amt) chrg_dhir_amt  -- 용선료 시장가" ).append("\n"); 
		query.append("                      , MIN(chrg_dhir_amt) - SUM (NVL(a.hir_rt, 0) / DECODE (a.curr_cd, 'USD', 1, NULL, 1, NVL (b.usd_locl_xch_rt, 0))) diff_amt" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                         SELECT cost_yrmon" ).append("\n"); 
		query.append("                              , vsl_cd" ).append("\n"); 
		query.append("                              , DECODE(no, 1, n1st_hir_rt, n2nd_hir_rt) hir_rt" ).append("\n"); 
		query.append("                              , DECODE(no, 1, n1st_curr_cd, n2nd_curr_cd) curr_cd" ).append("\n"); 
		query.append("                              , chrg_dhir_amt" ).append("\n"); 
		query.append("                           FROM" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                 SELECT cost_yrmon" ).append("\n"); 
		query.append("                                      , vsl_cd" ).append("\n"); 
		query.append("                                      , n1st_hir_rt" ).append("\n"); 
		query.append("                                      , n1st_curr_cd" ).append("\n"); 
		query.append("                                      , n2nd_hir_rt" ).append("\n"); 
		query.append("                                      , n2nd_curr_cd" ).append("\n"); 
		query.append("                                      , chrg_dhir_amt" ).append("\n"); 
		query.append("                                      , DECODE(n2nd_curr_cd, NULL, 1, 2) seq" ).append("\n"); 
		query.append("                                   FROM" ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                                 SELECT c1.cost_yrmon" ).append("\n"); 
		query.append("                                                      , c1.vsl_cd" ).append("\n"); 
		query.append("                                                      , c2.n1st_hir_rt" ).append("\n"); 
		query.append("                                                      , c2.n1st_curr_cd" ).append("\n"); 
		query.append("                                                      , c2.n2nd_hir_rt" ).append("\n"); 
		query.append("                                                      , c2.n2nd_curr_cd" ).append("\n"); 
		query.append("                                                      , NVL (c1.chrg_dhir_amt, 0) chrg_dhir_amt" ).append("\n"); 
		query.append("                                                   FROM coa_chrg_vsl_dly_hir c1" ).append("\n"); 
		query.append("                                                      , coa_vsl_chrg_if c2" ).append("\n"); 
		query.append("                                                  WHERE c1.cost_yrmon = c2.cost_yrmon(+)" ).append("\n"); 
		query.append("                                                    AND c1.vsl_cd = c2.vsl_cd(+)" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                              , (" ).append("\n"); 
		query.append("                                         SELECT cpy_no no" ).append("\n"); 
		query.append("                                           FROM com_cpy_no" ).append("\n"); 
		query.append("                                          WHERE cpy_no BETWEEN 1 AND 2" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                          WHERE seq >= no" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        a" ).append("\n"); 
		query.append("                      , gl_mon_xch_rt b" ).append("\n"); 
		query.append("                  WHERE a.curr_cd = b.curr_cd(+)" ).append("\n"); 
		query.append("                    AND b.acct_xch_rt_lvl(+) = '1'" ).append("\n"); 
		query.append("                    AND b.acct_xch_rt_yrmon(+) = a.cost_yrmon" ).append("\n"); 
		query.append("               GROUP BY cost_yrmon" ).append("\n"); 
		query.append("                      , vsl_cd" ).append("\n"); 
		query.append("                ) b" ).append("\n"); 
		query.append("          WHERE a.vsl_cd = b.vsl_cd" ).append("\n"); 
		query.append("            AND a.cost_yrmon = b.cost_yrmon" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY cost_yrmon" ).append("\n"); 
		query.append("      , cost_wk" ).append("\n"); 
		query.append("      , trd_cd" ).append("\n"); 
		query.append("     " ).append("\n"); 
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