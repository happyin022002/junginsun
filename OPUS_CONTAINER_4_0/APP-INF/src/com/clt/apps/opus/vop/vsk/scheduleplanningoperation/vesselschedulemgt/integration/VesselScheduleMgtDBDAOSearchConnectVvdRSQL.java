/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchConnectVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchConnectVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 자신에 VVD와 연결되는 Pre-VVD와 Next-VVD 정보를 찾아 온다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchConnectVvdRSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchConnectVvdRSQL").append("\n"); 
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
		query.append("SELECT 		VSL_CD" ).append("\n"); 
		query.append("		,	SKD_VOY_NO" ).append("\n"); 
		query.append("		,	SKD_DIR_CD" ).append("\n"); 
		query.append("		,	TURN_PORT_IND_CD" ).append("\n"); 
		query.append("		,	TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("		,	TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM 		VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  		VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("AND    		SKD_VOY_NO 			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND    		SKD_DIR_CD 			= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    		TURN_PORT_IND_CD	IN ('N','Y')" ).append("\n"); 
		query.append("AND    		TURN_SKD_VOY_NO		IS NOT NULL" ).append("\n"); 
		query.append("AND    		TURN_SKD_DIR_CD		IS NOT NULL" ).append("\n"); 
		query.append("AND    		ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 		VSL_CD" ).append("\n"); 
		query.append("		,	SKD_VOY_NO" ).append("\n"); 
		query.append("		,	SKD_DIR_CD" ).append("\n"); 
		query.append("		,	TURN_PORT_IND_CD" ).append("\n"); 
		query.append("		,	TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("		,	TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM 		VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  		VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    		SKD_VOY_NO 			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND    		SKD_DIR_CD 			= @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND    		TURN_SKD_VOY_NO =  [skd_voy_no]" ).append("\n"); 
		query.append("--AND    		TURN_SKD_DIR_CD =  [skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    		TURN_PORT_IND_CD	IN ('D','V','F')" ).append("\n"); 
		query.append("AND    		TURN_SKD_VOY_NO		IS NOT NULL" ).append("\n"); 
		query.append("AND    		TURN_SKD_DIR_CD		IS NOT NULL" ).append("\n"); 
		query.append("AND    		ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 	TURN_SKD_VOY_NO" ).append("\n"); 

	}
}