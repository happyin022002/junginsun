/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOMAKERDAOTesAwkCgoTrfMngVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VOMAKERDAOTesAwkCgoTrfMngVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO MAKER
	  * </pre>
	  */
	public VOMAKERDAOTesAwkCgoTrfMngVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo").append("\n"); 
		query.append("FileName : VOMAKERDAOTesAwkCgoTrfMngVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' cre_usr_id" ).append("\n"); 
		query.append(", '' cre_dt" ).append("\n"); 
		query.append(", '' upd_usr_id" ).append("\n"); 
		query.append(", '' upd_dt" ).append("\n"); 
		query.append(", '' calc_usd_amt_40ft" ).append("\n"); 
		query.append(", '' man_locl_amt_20ft" ).append("\n"); 
		query.append(", '' mn_yd_flg" ).append("\n"); 
		query.append(", '' calc_usd_amt_20ft" ).append("\n"); 
		query.append(", '' tml_cd" ).append("\n"); 
		query.append(", '' vndr_nm" ).append("\n"); 
		query.append(", '' trf_cond" ).append("\n"); 
		query.append(", '' fm_loc_cd" ).append("\n"); 
		query.append(", '' auto_usd_amt_20ft" ).append("\n"); 
		query.append(", '' tml_awk_ts_cd" ).append("\n"); 
		query.append(", '' man_usd_amt_40ft" ).append("\n"); 
		query.append(", '' fml_locl_curr_cd" ).append("\n"); 
		query.append(", '' fm_nod_yd_no" ).append("\n"); 
		query.append(", '' man_usd_amt_20ft" ).append("\n"); 
		query.append(", '' auto_usd_amt_40ft" ).append("\n"); 
		query.append(", '' calc_rmk" ).append("\n"); 
		query.append(", '' to_loc_cd" ).append("\n"); 
		query.append(", '' fml_locl_amt_20ft" ).append("\n"); 
		query.append(", '' io_ga_cd" ).append("\n"); 
		query.append(", '' lst_upd_usr_id" ).append("\n"); 
		query.append(", '' io_bnd_cd" ).append("\n"); 
		query.append(", '' aply_rto" ).append("\n"); 
		query.append(", '' man_locl_amt_40ft" ).append("\n"); 
		query.append(", '' chk_flg" ).append("\n"); 
		query.append(", '' to_nod_yd_no" ).append("\n"); 
		query.append(", '' yd_cd" ).append("\n"); 
		query.append(", '' man_locl_curr_cd" ).append("\n"); 
		query.append(", '' fml_locl_amt_40ft" ).append("\n"); 
		query.append(", '' lst_upd_dt" ).append("\n"); 
		query.append(", '' year_month" ).append("\n"); 
		query.append(", '' tml_awk_cgo_trf_tp_cd" ).append("\n"); 
		query.append(", '' port_cd" ).append("\n"); 
		query.append(", '' lg_ofc_cd" ).append("\n"); 
		query.append(", '' chk_auth_yn" ).append("\n"); 
		query.append(", '' usd_xch_dt" ).append("\n"); 
		query.append(", '' amt" ).append("\n"); 
		query.append(", '' curr_cd" ).append("\n"); 
		query.append(", '' lcl_amt" ).append("\n"); 
		query.append(", '' cond_no" ).append("\n"); 
		query.append(", '' cond_no_t3" ).append("\n"); 
		query.append(", '' ttl_locl_curr_cd" ).append("\n"); 
		query.append(", '' ttl_locl_amt_20ft" ).append("\n"); 
		query.append(", '' ttl_locl_amt_40ft" ).append("\n"); 
		query.append(", '' select_col" ).append("\n"); 
		query.append(", '' select_row" ).append("\n"); 
		query.append(", '' tml_act_cost_seq" ).append("\n"); 
		query.append(", '' spcl_cgo_ref_seq" ).append("\n"); 
		query.append(", '' tml_awk_trf_ver_no" ).append("\n"); 
		query.append(", '' sum_usd_amt_20ft" ).append("\n"); 
		query.append(", '' sum_usd_amt_40ft" ).append("\n"); 
		query.append(", '' cond_desc" ).append("\n"); 
		query.append(", '' chk_spcl_cgo_ref_seq" ).append("\n"); 
		query.append(", '' ttl_usd_amt_20ft" ).append("\n"); 
		query.append(", '' ttl_usd_amt_40ft" ).append("\n"); 
		query.append(", '' fml_usd_amt_20ft" ).append("\n"); 
		query.append(", '' fml_usd_amt_40ft" ).append("\n"); 
		query.append(", '' act_yd_ofc_auth_yn" ).append("\n"); 
		query.append(", '' fm_yd_cd" ).append("\n"); 
		query.append(", '' to_yd_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}