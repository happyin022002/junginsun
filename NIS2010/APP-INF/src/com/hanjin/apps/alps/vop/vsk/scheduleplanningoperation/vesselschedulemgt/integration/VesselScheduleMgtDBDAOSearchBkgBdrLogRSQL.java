/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchBkgBdrLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.12.23 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchBkgBdrLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchBkgBdrLogRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchBkgBdrLogRSQL").append("\n"); 
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
		query.append("SELECT	VSL_CD				AS VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO		AS SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD		AS SKD_DIR_CD" ).append("\n"); 
		query.append(", VPS_PORT_CD		AS VPS_PORT_CD" ).append("\n"); 
		query.append(", CLPT_IND_SEQ		AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(", PORT_SKD_STS_CD	AS PORT_SKD_STS_CD" ).append("\n"); 
		query.append(", 'N'				AS DEL_FLAG" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND		1 <" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	COUNT(*)" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND		'S'				<> NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("AND		TURN_PORT_IND_CD	NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION	ALL" ).append("\n"); 
		query.append("SELECT	@[vsl_cd]" ).append("\n"); 
		query.append(", @[skd_voy_no]" ).append("\n"); 
		query.append(", @[skd_dir_cd]" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", 'Y'" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("WHERE	1 >=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	COUNT(*)" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND		VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND		SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND		SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND		'S'				<> NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("AND		TURN_PORT_IND_CD	NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}