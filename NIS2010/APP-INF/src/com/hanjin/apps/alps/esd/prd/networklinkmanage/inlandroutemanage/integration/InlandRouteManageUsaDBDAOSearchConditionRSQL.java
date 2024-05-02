/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteManageUsaDBDAOSearchConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.21 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageUsaDBDAOSearchConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 검색조건 VO
	  * </pre>
	  */
	public InlandRouteManageUsaDBDAOSearchConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageUsaDBDAOSearchConditionRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("'1' i_rout_org_nod_cd" ).append("\n"); 
		query.append(", '1'  i_rout_dest_nod_cd" ).append("\n"); 
		query.append(",'1' i_rout_seq" ).append("\n"); 
		query.append(",'1' i_hub_search_gb" ).append("\n"); 
		query.append(",'1' i_front_gb" ).append("\n"); 
		query.append(",'1' i_undefine_nod" ).append("\n"); 
		query.append(",'1' i_newRouteCd" ).append("\n"); 
		query.append(",'1' i_selRow" ).append("\n"); 
		query.append(",'1' disable_bkg_flg" ).append("\n"); 
		query.append(",'1' prio_seq_combo" ).append("\n"); 
		query.append(",'1' detail_org_i_inv" ).append("\n"); 
		query.append(",'1' detail_org_i_rout_pln_cd" ).append("\n"); 
		query.append(",'1' detail_org_i_bkg_flg" ).append("\n"); 
		query.append(",'1' i_mcntr_rout_flg" ).append("\n"); 
		query.append(",'1' detail_org_i_wrs_fl_cd" ).append("\n"); 
		query.append(",'1' detail_org_i_wrs_mt_cd" ).append("\n"); 
		query.append(",'1' r_btn_nod_ty_cd" ).append("\n"); 
		query.append(",'' from_cd" ).append("\n"); 
		query.append(",'' to_cd" ).append("\n"); 
		query.append(",''  wrs_flg" ).append("\n"); 
		query.append(",'' i_del_flg" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}