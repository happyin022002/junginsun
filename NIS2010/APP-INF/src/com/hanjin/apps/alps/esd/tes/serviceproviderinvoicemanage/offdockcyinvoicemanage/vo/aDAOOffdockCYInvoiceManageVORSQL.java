/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : aDAOOffdockCYInvoiceManageVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class aDAOOffdockCYInvoiceManageVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * a
	  * </pre>
	  */
	public aDAOOffdockCYInvoiceManageVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo").append("\n"); 
		query.append("FileName : aDAOOffdockCYInvoiceManageVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("  '' mode_ --you should change 'mode_' to 'mode'" ).append("\n"); 
		query.append(", '' tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", '' tml_so_seq" ).append("\n"); 
		query.append(", '' tml_so_dtl_seq" ).append("\n"); 
		query.append(", '' vndr_seq" ).append("\n"); 
		query.append(", '' inv_no" ).append("\n"); 
		query.append(", '' calc_tp_cd" ).append("\n"); 
		query.append(", '' dcgo_clss_cd" ).append("\n"); 
		query.append(", '' cntr_tpsz_cd" ).append("\n"); 
		query.append(", '' rc_flg" ).append("\n"); 
		query.append(", '' io_bnd_cd" ).append("\n"); 
		query.append(", '' lgs_cost_cd" ).append("\n"); 
		query.append(", '' tml_cost_grp_cd" ).append("\n"); 
		query.append(", '' tml_calc_ind_cd" ).append("\n"); 
		query.append(", '' param_cntr_tpsz_cd" ).append("\n"); 
		query.append(", '' param_dcgo_clss_cd" ).append("\n"); 
		query.append(", '' param_rc_flg" ).append("\n"); 
		query.append(", '' param_lgs_cost_cd" ).append("\n"); 
		query.append(", '' fm_prd_dt" ).append("\n"); 
		query.append(", '' to_prd_dt" ).append("\n"); 
		query.append(", '' sto_dys_ind_cd" ).append("\n"); 
		query.append(", '' yd_cd" ).append("\n"); 
		query.append(", '' dtl_by_pool_only_mode" ).append("\n"); 
		query.append(", '' inv_vol_qty" ).append("\n"); 
		query.append(", '' wrk_dt" ).append("\n"); 
		query.append(", '' tmp_dtl_seq" ).append("\n"); 
		query.append(", '' calc_cost_grp_cd" ).append("\n"); 
		query.append(", '' tml_so_cntr_list_seq" ).append("\n"); 
		query.append(", '' tml_if_seq" ).append("\n"); 
		query.append(", '' n3pty_flg" ).append("\n"); 
		query.append(", '' del_if_seq" ).append("\n"); 
		query.append(", '' del_cntr_seq" ).append("\n"); 
		query.append(", '' param_cntr_no" ).append("\n"); 
		query.append(", '' param_rvis_cntr_tpsz_cd" ).append("\n"); 
		query.append(", '' param_rvis_cntr_sty_cd" ).append("\n"); 
		query.append(", '' param_rvis_gate_in_out_cd" ).append("\n"); 
		query.append(", '' coin_cntr_flg" ).append("\n"); 
		query.append(", '' rf_mntr_dys" ).append("\n"); 
		query.append(", '' plug_term" ).append("\n"); 
		query.append(", '' semi_auto_calc_flg" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}