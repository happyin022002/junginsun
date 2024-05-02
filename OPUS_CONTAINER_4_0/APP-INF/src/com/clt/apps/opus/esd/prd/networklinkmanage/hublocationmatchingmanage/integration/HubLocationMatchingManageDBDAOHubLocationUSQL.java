/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HubLocationMatchingManageDBDAOHubLocationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.07.28 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HubLocationMatchingManageDBDAOHubLocationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public HubLocationMatchingManageDBDAOHubLocationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_mtch_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.integration ").append("\n"); 
		query.append("FileName : HubLocationMatchingManageDBDAOHubLocationUSQL").append("\n"); 
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
		query.append("UPDATE prd_hub_loc_mtch" ).append("\n"); 
		query.append("SET    hub_loc_cd       = @[hub_loc_cd] ," ).append("\n"); 
		query.append("upd_usr_id       = @[upd_usr_id] ," ).append("\n"); 
		query.append("upd_dt           = sysdate ," ).append("\n"); 
		query.append("TRSP_MOD_CD      = @[trsp_mod_cd]       ," ).append("\n"); 
		query.append("HUB_LOC_MTCH_RMK = @[hub_loc_mtch_rmk]" ).append("\n"); 
		query.append("WHERE  port_cd          = @[port_cd]" ).append("\n"); 
		query.append("AND    loc_cd           = @[loc_cd]" ).append("\n"); 

	}
}