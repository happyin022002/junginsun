/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOEmptySaveInlandRouteDetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOEmptySaveInlandRouteDetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptySaveInlandRouteDet
	  * </pre>
	  */
	public InlandRouteManageDBDAOEmptySaveInlandRouteDetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOEmptySaveInlandRouteDetRSQL").append("\n"); 
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
		query.append("'' wrs_chk" ).append("\n"); 
		query.append(",'' i_rout_seq" ).append("\n"); 
		query.append(",'' i_route_rmk" ).append("\n"); 
		query.append(",'' r_inbound" ).append("\n"); 
		query.append(",'' nod_tp_cd1" ).append("\n"); 
		query.append(",'' nod_tp_cd2" ).append("\n"); 
		query.append(",'' i_inv" ).append("\n"); 
		query.append(",'' i_wrs_mt_cd" ).append("\n"); 
		query.append(",'' i_bkg_flg " ).append("\n"); 
		query.append(",'' i_new_route_cd" ).append("\n"); 
		query.append(",'' i_rout_pln_cd" ).append("\n"); 
		query.append(",'' prio_seq" ).append("\n"); 
		query.append(",'' rout_dtl_seq" ).append("\n"); 
		query.append(",'' cty_cd" ).append("\n"); 
		query.append(",'' agmt_seq" ).append("\n"); 
		query.append(",'' i_agmt_seq" ).append("\n"); 
		query.append(",'' i_rout_org_nod_cd" ).append("\n"); 
		query.append(",'' i_rout_dest_nod_cd" ).append("\n"); 
		query.append(",'' io_gb" ).append("\n"); 
		query.append(",'' ibflag" ).append("\n"); 
		query.append(",'' lnk_org_loc" ).append("\n"); 
		query.append(",'' lnk_org_type" ).append("\n"); 
		query.append(",'' lnk_dest_loc" ).append("\n"); 
		query.append(",'' lnk_dest_type" ).append("\n"); 
		query.append(",'' trsp_mod_cd" ).append("\n"); 
		query.append(",'' vndr_seq	" ).append("\n"); 
		query.append(",'' inlnd_rout_junc_nm" ).append("\n"); 
		query.append(",'' inlnd_rout_cmb_flg" ).append("\n"); 
		query.append(",'' rail_crr_tp_cd	" ).append("\n"); 
		query.append(",'' agmt_no	" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' cre_ofc_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}