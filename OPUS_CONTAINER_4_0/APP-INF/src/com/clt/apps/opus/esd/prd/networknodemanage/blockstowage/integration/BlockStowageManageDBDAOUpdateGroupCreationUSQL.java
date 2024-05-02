/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlockStowageManageDBDAOUpdateGroupCreationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlockStowageManageDBDAOUpdateGroupCreationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateGroupCreation
	  * </pre>
	  */
	public BlockStowageManageDBDAOUpdateGroupCreationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration").append("\n"); 
		query.append("FileName : BlockStowageManageDBDAOUpdateGroupCreationUSQL").append("\n"); 
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
		query.append("UPDATE prd_blck_stwg SET" ).append("\n"); 
		query.append("port_cd = @[pod_code]" ).append("\n"); 
		query.append(", vsl_slan_cd = @[lane_code]" ).append("\n"); 
		query.append(", hub_loc_cd = @[hub_code]" ).append("\n"); 
		query.append(", blck_stwg_cd = @[group_code]" ).append("\n"); 
		query.append(", delt_flg = DECODE(@[del_flag], '1', 'Y', 'N')" ).append("\n"); 
		query.append(", upd_usr_id = @[user_id]" ).append("\n"); 
		query.append(", upd_dt = sysdate" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("port_cd = @[pod_code]" ).append("\n"); 
		query.append("AND hub_loc_cd = @[hub_code]" ).append("\n"); 
		query.append("AND vsl_slan_cd = @[lane_code]" ).append("\n"); 

	}
}