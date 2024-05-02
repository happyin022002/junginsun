/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOEmptySaveInlandRouteMstVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOEmptySaveInlandRouteMstVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptySaveInlandRouteMstVO VO 생성쿼리
	  * </pre>
	  */
	public InlandRouteManageDBDAOEmptySaveInlandRouteMstVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOEmptySaveInlandRouteMstVORSQL").append("\n"); 
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
		query.append("SELECT '' AS r5_flg" ).append("\n"); 
		query.append("     , '' AS d2_flg" ).append("\n"); 
		query.append("     , '' AS rout_org_nod_cd" ).append("\n"); 
		query.append("     , '' AS d4_flg" ).append("\n"); 
		query.append("     , '' AS a2_flg" ).append("\n"); 
		query.append("     , '' AS a4_flg" ).append("\n"); 
		query.append("     , '' AS a5_flg" ).append("\n"); 
		query.append("     , '' AS rout_seq" ).append("\n"); 
		query.append("     , '' AS d5_flg" ).append("\n"); 
		query.append("     , '' AS cre_usr_id" ).append("\n"); 
		query.append("     , '' AS o4_flg" ).append("\n"); 
		query.append("     , '' AS o5_flg" ).append("\n"); 
		query.append("     , '' AS o2_flg" ).append("\n"); 
		query.append("     , '' AS cre_ofc_cd" ).append("\n"); 
		query.append("     , '' AS i_del_flag" ).append("\n"); 
		query.append("     , '' AS d7_flg" ).append("\n"); 
		query.append("     , '' AS rout_dest_nod_cd" ).append("\n"); 
		query.append("     , '' AS r2_flg" ).append("\n"); 
		query.append("     , '' AS upd_usr_id" ).append("\n"); 
		query.append("     , '' AS wrs_chk" ).append("\n"); 
		query.append("     , '' AS r8_flg" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}