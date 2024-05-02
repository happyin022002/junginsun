/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchPortListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchPortListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD로 PORT조회
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchPortListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchPortListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD         AS VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO     AS SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD     AS SKD_DIR_CD" ).append("\n"); 
		query.append("     , SLAN_CD        AS VSL_SLAN_CD" ).append("\n"); 
		query.append("     , VPS_PORT_CD    AS VPS_PORT_CD" ).append("\n"); 
		query.append("     , IB_CSSM_VOY_NO AS IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , OB_CSSM_VOY_NO AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE VSL_CD     	 = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO 	 = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD 	 = @[skd_dir_cd]" ).append("\n"); 
		query.append("   #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("   AND VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND CLPT_IND_SEQ  = 1" ).append("\n"); 

	}
}