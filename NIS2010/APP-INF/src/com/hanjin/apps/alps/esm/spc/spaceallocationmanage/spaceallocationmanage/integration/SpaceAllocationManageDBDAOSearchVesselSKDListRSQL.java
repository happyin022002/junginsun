/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchVesselSKDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchVesselSKDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SKD Inquiry
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchVesselSKDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchVesselSKDListRSQL").append("\n"); 
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
		query.append("SELECT CLPT_SEQ     AS CALLING_SEQ," ).append("\n"); 
		query.append("         VSL_CD       AS VESSEL     ," ).append("\n"); 
		query.append("         SKD_VOY_NO   AS VOYAGE_NO  ," ).append("\n"); 
		query.append("         SKD_DIR_CD   AS DIR_CD     ," ).append("\n"); 
		query.append("         CLPT_IND_SEQ AS CALLING_IND," ).append("\n"); 
		query.append("         VPS_PORT_CD  AS PORT       ," ).append("\n"); 
		query.append("         YD_CD  ," ).append("\n"); 
		query.append("         SLAN_CD," ).append("\n"); 
		query.append("         TO_CHAR(VPS_ETA_DT, 'YYYYMMDD HH24:MI') AS VPS_ETA_DT," ).append("\n"); 
		query.append("         TO_CHAR(VPS_ETD_DT, 'YYYYMMDD HH24:MI') AS VPS_ETD_DT," ).append("\n"); 
		query.append("         TO_CHAR(VPS_ETB_DT, 'YYYYMMDD HH24:MI') AS VPS_ETB_DT," ).append("\n"); 
		query.append("         TURN_PORT_IND_CD," ).append("\n"); 
		query.append("         SKD_CNG_STS_CD" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ ASC" ).append("\n"); 

	}
}