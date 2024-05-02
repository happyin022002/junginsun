/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OceanRouteConditionManageDBDAOCheckDupTmlMtxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteConditionManageDBDAOCheckDupTmlMtxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OceanRouteConditionManageDBDAOCheckDupTmlMtxRSQL
	  * </pre>
	  */
	public OceanRouteConditionManageDBDAOCheckDupTmlMtxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration").append("\n"); 
		query.append("FileName : OceanRouteConditionManageDBDAOCheckDupTmlMtxRSQL").append("\n"); 
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
		query.append("select count(1) dup_cnt from prd_port_tml_mtx                          " ).append("\n"); 
		query.append("where port_cd = @[port_cd] " ).append("\n"); 
		query.append("and vsl_slan_cd = @[vsl_slan_cd]" ).append("\n"); 
		query.append("and skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("and crr_cd = @[crr_cd]" ).append("\n"); 

	}
}