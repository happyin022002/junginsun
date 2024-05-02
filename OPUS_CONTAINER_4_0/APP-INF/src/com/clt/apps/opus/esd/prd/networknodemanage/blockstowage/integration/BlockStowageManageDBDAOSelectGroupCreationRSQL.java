/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlockStowageManageDBDAOSelectGroupCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.11 노승배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlockStowageManageDBDAOSelectGroupCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectGroupCreation
	  * </pre>
	  */
	public BlockStowageManageDBDAOSelectGroupCreationRSQL(){
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
		params.put("del_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.integration ").append("\n"); 
		query.append("FileName : BlockStowageManageDBDAOSelectGroupCreationRSQL").append("\n"); 
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
		query.append("DECODE(delt_flg, 'Y', '1', '0') del_flag" ).append("\n"); 
		query.append(", port_cd pod_code" ).append("\n"); 
		query.append(", hub_loc_cd hub_code" ).append("\n"); 
		query.append(", vsl_slan_cd lane_code" ).append("\n"); 
		query.append(", blck_stwg_cd group_code" ).append("\n"); 
		query.append(", cre_usr_id c_user_id" ).append("\n"); 
		query.append(", to_char(cre_dt, 'yyyy-mm-dd') c_date" ).append("\n"); 
		query.append(", upd_usr_id u_user_id" ).append("\n"); 
		query.append(", to_char(upd_dt, 'yyyy-mm-dd') u_date" ).append("\n"); 
		query.append("FROM prd_blck_stwg" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("port_cd LIKE @[pod_code] || '%'" ).append("\n"); 
		query.append("AND hub_loc_cd LIKE @[hub_code] || '%'" ).append("\n"); 
		query.append("AND vsl_slan_cd LIKE @[lane_code] || '%'" ).append("\n"); 
		query.append("AND blck_stwg_cd LIKE @[group_code] || '%'" ).append("\n"); 
		query.append("AND delt_flg LIKE DECODE(@[del_flag], 'A', '%', @[del_flag])" ).append("\n"); 

	}
}