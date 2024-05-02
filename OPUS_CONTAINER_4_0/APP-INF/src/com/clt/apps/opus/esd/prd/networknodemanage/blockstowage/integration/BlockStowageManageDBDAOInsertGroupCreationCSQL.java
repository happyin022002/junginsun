/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlockStowageManageDBDAOInsertGroupCreationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25 
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

public class BlockStowageManageDBDAOInsertGroupCreationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertGroupCreation
	  * </pre>
	  */
	public BlockStowageManageDBDAOInsertGroupCreationCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration").append("\n"); 
		query.append("FileName : BlockStowageManageDBDAOInsertGroupCreationCSQL").append("\n"); 
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
		query.append("INSERT INTO prd_blck_stwg (" ).append("\n"); 
		query.append("     port_cd" ).append("\n"); 
		query.append("	,vsl_slan_cd" ).append("\n"); 
		query.append("	,hub_loc_cd" ).append("\n"); 
		query.append("	,blck_stwg_cd" ).append("\n"); 
		query.append("	,delt_flg" ).append("\n"); 
		query.append("	,cre_usr_id" ).append("\n"); 
		query.append("	,cre_dt" ).append("\n"); 
		query.append("	,upd_usr_id" ).append("\n"); 
		query.append("	,upd_dt" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("     @[pod_code]" ).append("\n"); 
		query.append("	,@[lane_code]" ).append("\n"); 
		query.append("	,@[hub_code]" ).append("\n"); 
		query.append("	,@[group_code]" ).append("\n"); 
		query.append("	,'N'" ).append("\n"); 
		query.append("	,@[user_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[user_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}