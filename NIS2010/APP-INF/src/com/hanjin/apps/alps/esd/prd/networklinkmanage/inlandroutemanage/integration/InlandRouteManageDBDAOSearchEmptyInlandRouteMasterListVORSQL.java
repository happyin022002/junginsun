/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOSearchEmptyInlandRouteMasterListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOSearchEmptyInlandRouteMasterListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEmptyInlandRouteMasterListVO VO 생성쿼리
	  * </pre>
	  */
	public InlandRouteManageDBDAOSearchEmptyInlandRouteMasterListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOSearchEmptyInlandRouteMasterListVORSQL").append("\n"); 
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
		query.append("SELECT '' AS rn" ).append("\n"); 
		query.append("     , '' AS rail_crr_tp_cd" ).append("\n"); 
		query.append("     , '' AS cre_dt" ).append("\n"); 
		query.append("     , '' AS wrs_mty_cmdt_cd" ).append("\n"); 
		query.append("     , '' AS rout_org_nod_cd" ).append("\n"); 
		query.append("     , '' AS a2_flg" ).append("\n"); 
		query.append("     , '' AS d4_flg" ).append("\n"); 
		query.append("     , '' AS a4_flg" ).append("\n"); 
		query.append("     , '' AS a5_flg" ).append("\n"); 
		query.append("     , '' AS d5_flg" ).append("\n"); 
		query.append("     , '' AS o2_flg" ).append("\n"); 
		query.append("     , '' AS cre_ofc_cd" ).append("\n"); 
		query.append("     , '' AS rout_dest_nod_cd" ).append("\n"); 
		query.append("     , '' AS org_loc" ).append("\n"); 
		query.append("     , '' AS upd_usr_id" ).append("\n"); 
		query.append("     , '' AS upd_dt" ).append("\n"); 
		query.append("     , '' AS r5_flg" ).append("\n"); 
		query.append("     , '' AS d2_flg" ).append("\n"); 
		query.append("     , '' AS dest_loc_type" ).append("\n"); 
		query.append("     , '' AS o5_flg" ).append("\n"); 
		query.append("     , '' AS dest_loc" ).append("\n"); 
		query.append("     , '' AS rout_pln_cd" ).append("\n"); 
		query.append("     , '' AS rout_seq" ).append("\n"); 
		query.append("     , '' AS inlnd_rout_junc_nm" ).append("\n"); 
		query.append("     , '' AS inlnd_rout_inv_bil_patt_cd" ).append("\n"); 
		query.append("     , '' AS inlnd_rout_rmk" ).append("\n"); 
		query.append("     , '' AS o4_flg" ).append("\n"); 
		query.append("     , '' AS cre_usr_id" ).append("\n"); 
		query.append("     , '' AS d7_flg" ).append("\n"); 
		query.append("     , '' AS prio_seq" ).append("\n"); 
		query.append("     , '' AS r2_flg" ).append("\n"); 
		query.append("     , '' AS org_loc_type" ).append("\n"); 
		query.append("     , '' AS r8_flg" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}