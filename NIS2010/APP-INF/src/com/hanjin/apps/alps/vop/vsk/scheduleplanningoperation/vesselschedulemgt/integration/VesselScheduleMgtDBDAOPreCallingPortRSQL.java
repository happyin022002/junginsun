/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOPreCallingPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.03 정진우
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

public class VesselScheduleMgtDBDAOPreCallingPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOPreCallingPortRSQL(){
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
		query.append("FileName : VesselScheduleMgtDBDAOPreCallingPortRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ, CLPT_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ, CLPT_SEQ" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND TURN_PORT_IND_CD NOT IN ('V', 'D', 'F')" ).append("\n"); 
		query.append("           AND ( VSL_CD, SKD_VOY_NO, SKD_DIR_CD ) IN" ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("					SELECT VSL_CD, TURN_SKD_VOY_NO, TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("					  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("					 WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("					   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("					   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("					   AND TURN_PORT_IND_CD = 'Y'" ).append("\n"); 
		query.append("					   AND ROWNUM = 1" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, VPS_PORT_CD, CLPT_IND_SEQ, CLPT_SEQ + 100" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("		SELECT '' AS VSL_CD, '' AS SKD_VOY_NO, '' AS SKD_DIR_CD, 'OCEAN' AS VPS_PORT_CD, NULL, 998" ).append("\n"); 
		query.append("		  FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("		SELECT '' AS VSL_CD, '' AS SKD_VOY_NO, '' AS SKD_DIR_CD, 'OTHER' AS VPS_PORT_CD, NULL, 999" ).append("\n"); 
		query.append("		  FROM DUAL" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}