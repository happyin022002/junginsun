/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandRouteManageDBDAOEmptySaveInlandRouteMstRSQL.java
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

public class InlandRouteManageDBDAOEmptySaveInlandRouteMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptySaveInlandRouteMst
	  * </pre>
	  */
	public InlandRouteManageDBDAOEmptySaveInlandRouteMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOEmptySaveInlandRouteMstRSQL").append("\n"); 
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
		query.append("'' rout_org_nod_cd" ).append("\n"); 
		query.append(",'' rout_dest_nod_cd" ).append("\n"); 
		query.append(",'' rout_seq" ).append("\n"); 
		query.append(",'' wrs_chk" ).append("\n"); 
		query.append(",'' d2_flg" ).append("\n"); 
		query.append(",'' d4_flg" ).append("\n"); 
		query.append(",'' d5_flg" ).append("\n"); 
		query.append(",'' d7_flg" ).append("\n"); 
		query.append(",'' o2_flg" ).append("\n"); 
		query.append(",'' o4_flg" ).append("\n"); 
		query.append(",'' a2_flg" ).append("\n"); 
		query.append(",'' a4_flg" ).append("\n"); 
		query.append(",'' r2_flg" ).append("\n"); 
		query.append(",'' r5_flg" ).append("\n"); 
		query.append(",'' i_del_flag" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' cre_ofc_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}