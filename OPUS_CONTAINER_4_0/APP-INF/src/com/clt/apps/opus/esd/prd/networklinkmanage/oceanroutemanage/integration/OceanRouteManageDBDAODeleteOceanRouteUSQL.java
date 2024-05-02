/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OceanRouteManageDBDAODeleteOceanRouteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAODeleteOceanRouteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteOceanRoute
	  * </pre>
	  */
	public OceanRouteManageDBDAODeleteOceanRouteUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_route_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAODeleteOceanRouteUSQL").append("\n"); 
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
		query.append("UPDATE PRD_OCN_ROUT " ).append("\n"); 
		query.append("SET    UPD_IND_CD = 'D'," ).append("\n"); 
		query.append("       OCN_ROUT_UPD_DT     = sysdate," ).append("\n"); 
		query.append("       UPD_OFC_CD = @[cre_ofc_id] ," ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("       ocn_rout_rmk = SYSDATE||','|| @[cre_usr_id] ||' OCN ROUT MGM MENU'," ).append("\n"); 
		query.append("       ocn_rout_delt_rmk = SYSDATE||','|| @[cre_usr_id] ||' : OCN ROUT MGM MENU' , " ).append("\n"); 
		query.append("       OCN_ROUT_USR_RMK = REPLACE(REPLACE(REPLACE( @[s_route_rmk] , CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' ') " ).append("\n"); 
		query.append("WHERE  ORG_LOC_CD  = @[s_pol]" ).append("\n"); 
		query.append("AND    DEST_LOC_CD = @[s_pod] " ).append("\n"); 
		query.append("AND    ROUT_SEQ    = @[s_rout_seq]" ).append("\n"); 

	}
}