/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOaddZoneToPrdNodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOaddZoneToPrdNodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Zone Code를 생성할 때 Prd Node에도 추가
	  * </pre>
	  */
	public LocationDBDAOaddZoneToPrdNodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOaddZoneToPrdNodeCSQL").append("\n"); 
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
		query.append("INSERT INTO prd_node (                                      					" ).append("\n"); 
		query.append("     nod_cd 	       " ).append("\n"); 
		query.append("   , nod_nm 	       " ).append("\n"); 
		query.append("   , nod_tp_cd      " ).append("\n"); 
		query.append("   , loc_cd 	       " ).append("\n"); 
		query.append("   , onf_hir_yd_flg " ).append("\n"); 
		query.append("   , delt_flg       " ).append("\n"); 
		query.append("   , cre_usr_id     " ).append("\n"); 
		query.append("   , cre_dt 	       " ).append("\n"); 
		query.append("   , upd_usr_id     " ).append("\n"); 
		query.append("   , upd_dt 	       " ).append("\n"); 
		query.append(") VALUES (													 					" ).append("\n"); 
		query.append("     @[zn_cd] " ).append("\n"); 
		query.append("   , @[zn_nm] " ).append("\n"); 
		query.append("   , 'Z' " ).append("\n"); 
		query.append("   , SUBSTR(@[zn_cd],1,5)" ).append("\n"); 
		query.append("   , 'N' " ).append("\n"); 
		query.append("   , @[delt_flg] " ).append("\n"); 
		query.append("   , @[usr_id] " ).append("\n"); 
		query.append("   , sysdate" ).append("\n"); 
		query.append("   , @[usr_id] " ).append("\n"); 
		query.append("   , sysdate " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}