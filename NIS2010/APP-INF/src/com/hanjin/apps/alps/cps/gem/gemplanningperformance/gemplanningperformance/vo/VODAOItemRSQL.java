/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VODAOItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.12 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VODAOItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Parameter로 전달되는 gae request, item , apro_step 정보 포함
	  * </pre>
	  */
	public VODAOItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo").append("\n"); 
		query.append("FileName : VODAOItemRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' gen_expn_rqst_no" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append(",'' gen_expn_cd" ).append("\n"); 
		query.append(",'' gen_expn_itm_no" ).append("\n"); 
		query.append(",'' gen_expn_trns_div_cd" ).append("\n"); 
		query.append(",'' gen_expn_rqst_seq" ).append("\n"); 
		query.append(",'' crnt_gen_expn_apro_step_cd" ).append("\n"); 
		query.append(",'' crnt_gen_expn_apsts_cd" ).append("\n"); 
		query.append(",'' gen_expn_itm_desc" ).append("\n"); 
		query.append(",'' gen_expn_calc_bss_desc" ).append("\n"); 
		query.append(",'' rqst_opin_rmk" ).append("\n"); 
		query.append(",'' jan_amt" ).append("\n"); 
		query.append(",'' feb_amt" ).append("\n"); 
		query.append(",'' mar_amt" ).append("\n"); 
		query.append(",'' apr_amt" ).append("\n"); 
		query.append(",'' may_amt" ).append("\n"); 
		query.append(",'' jun_amt" ).append("\n"); 
		query.append(",'' jul_amt" ).append("\n"); 
		query.append(",'' aug_amt" ).append("\n"); 
		query.append(",'' sep_amt" ).append("\n"); 
		query.append(",'' oct_amt" ).append("\n"); 
		query.append(",'' nov_amt" ).append("\n"); 
		query.append(",'' dec_amt" ).append("\n"); 
		query.append(",'' req_upd_dt" ).append("\n"); 
		query.append(",'' itm_upd_dt" ).append("\n"); 
		query.append(",'' rqst_jan_amt" ).append("\n"); 
		query.append(",'' rqst_feb_amt" ).append("\n"); 
		query.append(",'' rqst_mar_amt" ).append("\n"); 
		query.append(",'' rqst_apr_amt" ).append("\n"); 
		query.append(",'' rqst_may_amt" ).append("\n"); 
		query.append(",'' rqst_jun_amt" ).append("\n"); 
		query.append(",'' rqst_jul_amt" ).append("\n"); 
		query.append(",'' rqst_aug_amt" ).append("\n"); 
		query.append(",'' rqst_sep_amt" ).append("\n"); 
		query.append(",'' rqst_oct_amt" ).append("\n"); 
		query.append(",'' rqst_nov_amt" ).append("\n"); 
		query.append(",'' rqst_dec_amt" ).append("\n"); 
		query.append(",'' chk_assigned" ).append("\n"); 
		query.append(",'' eng_abbr_nm" ).append("\n"); 
		query.append(",'' krn_abbr_nm" ).append("\n"); 
		query.append(",'' rqst_locl_amt" ).append("\n"); 
		query.append(",'' rqst_usd_amt" ).append("\n"); 
		query.append(",'' tic_cd" ).append("\n"); 
		query.append(",'' ttl" ).append("\n"); 
		query.append(",'' ofc_lvl1" ).append("\n"); 
		query.append(",'' ofc_lvl2" ).append("\n"); 
		query.append(",'' sls_ofc_div_cd" ).append("\n"); 
		query.append(",'' ttl" ).append("\n"); 
		query.append(",'' usd_locl_xch_rt" ).append("\n"); 
		query.append(",'' rqst_ut_val" ).append("\n"); 
		query.append(",'' locl_curr_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}