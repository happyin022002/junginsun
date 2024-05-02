/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOCreateDefExpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.10.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOCreateDefExpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이연수지 생성
	  * </pre>
	  */
	public CostSetUpDBDAOCreateDefExpCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOCreateDefExpCSQL").append("\n"); 
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
		query.append("merge INTO mas_mnl_cost_stup a USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         SELECT SUBSTR(cost_yrmon, 1, 4)||eq_wk cost_yrmon" ).append("\n"); 
		query.append("              , cost_wk" ).append("\n"); 
		query.append("              , trd_cd" ).append("\n"); 
		query.append("              , 'CNTTS' rlane_cd" ).append("\n"); 
		query.append("              , 'O' ioc_cd" ).append("\n"); 
		query.append("              , 'M' dir_cd" ).append("\n"); 
		query.append("              , 'OT' sub_trd_cd" ).append("\n"); 
		query.append("              , SUM(dd * day_cnt) otr_expn_amt" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                 SELECT c.cost_yrmon" ).append("\n"); 
		query.append("                      , a.eq_wk" ).append("\n"); 
		query.append("                      , a.cost_wk" ).append("\n"); 
		query.append("                      , c.trd_cd" ).append("\n"); 
		query.append("                      , CASE" ).append("\n"); 
		query.append("                                WHEN SUBSTR(a.sls_to_dt, 5, 2) = SUBSTR(a.sls_fm_dt, 5, 2)" ).append("\n"); 
		query.append("                                THEN to_date(a.sls_to_dt, 'YYYYMMDD') - to_date(a.sls_fm_dt, 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("                                ELSE DECODE(b.chr_cpy_no, SUBSTR(a.sls_to_dt, 5, 2), (to_date(a.sls_to_dt, 'YYYYMMDD') - to_date(SUBSTR(a.sls_to_dt, 1, 6)||'01', 'YYYYMMDD') + 1), ( to_date(" ).append("\n"); 
		query.append("                                        SUBSTR(a.sls_fm_dt, 1, 6)||TO_CHAR(last_day(to_date(a.sls_fm_dt, 'YYYYMMDD')), 'DD'), 'YYYYMMDD') - to_date(a.sls_fm_dt, 'YYYYMMDD') + 1) )" ).append("\n"); 
		query.append("                        END day_cnt" ).append("\n"); 
		query.append("                      , c.dd" ).append("\n"); 
		query.append("                   FROM mas_wk_prd a" ).append("\n"); 
		query.append("                      , com_cpy_no b" ).append("\n"); 
		query.append("                      , (" ).append("\n"); 
		query.append("                                -- MAS는 월데이터를 저장하고 있음 COST_WK = 'XX'" ).append("\n"); 
		query.append("                                 SELECT cost_yrmon" ).append("\n"); 
		query.append("                                      , cost_wk" ).append("\n"); 
		query.append("                                      , trd_cd" ).append("\n"); 
		query.append("                                      , rlane_cd" ).append("\n"); 
		query.append("                                      , otr_expn_amt" ).append("\n"); 
		query.append("                                      , otr_expn_amt/TO_CHAR(last_day(to_date(cost_yrmon, 'yyyymm')), 'dd') dd" ).append("\n"); 
		query.append("                                   FROM mas_mnl_cost_stup" ).append("\n"); 
		query.append("                                  WHERE rlane_cd = 'CNTTS'" ).append("\n"); 
		query.append("                                    AND cost_wk = 'XX'" ).append("\n"); 
		query.append("                        ) c" ).append("\n"); 
		query.append("                  WHERE a.cost_yr = SUBSTR(@[cost_yrweek], 1, 4)" ).append("\n"); 
		query.append("                    AND a.cost_wk = SUBSTR(@[cost_yrweek], 5, 2)" ).append("\n"); 
		query.append("                    AND b.chr_cpy_no BETWEEN SUBSTR(sls_fm_dt, 5, 2) AND SUBSTR(sls_to_dt, 5, 2)" ).append("\n"); 
		query.append("                    AND c.cost_yrmon = a.cost_yr||b.chr_cpy_no" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       GROUP BY SUBSTR(cost_yrmon, 1, 4)||eq_wk" ).append("\n"); 
		query.append("              , cost_wk" ).append("\n"); 
		query.append("              , trd_cd" ).append("\n"); 
		query.append(") b " ).append("\n"); 
		query.append("ON (        a.cost_yrmon = b.cost_yrmon " ).append("\n"); 
		query.append("        AND a.cost_wk    = b.cost_wk " ).append("\n"); 
		query.append("        AND a.trd_cd     = b.trd_cd " ).append("\n"); 
		query.append("        AND a.rlane_cd   = b.rlane_cd )" ).append("\n"); 
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