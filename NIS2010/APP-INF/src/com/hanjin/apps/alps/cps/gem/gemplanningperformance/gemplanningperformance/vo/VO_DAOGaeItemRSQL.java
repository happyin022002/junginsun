/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VO_DAOGaeItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.13 진윤오
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

public class VO_DAOGaeItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GaeItem
	  * </pre>
	  */
	public VO_DAOGaeItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo").append("\n"); 
		query.append("FileName : VO_DAOGaeItemRSQL").append("\n"); 
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
		query.append(",'' gen_expn_apro_auth_ofc_cd" ).append("\n"); 
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
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' cre_dt" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' upd_dt" ).append("\n"); 
		query.append(",'' tic_cd" ).append("\n"); 
		query.append(",'' itm_upd_dt" ).append("\n"); 
		query.append(",'' req_upd_dt" ).append("\n"); 
		query.append("from gem_item" ).append("\n"); 

	}
}