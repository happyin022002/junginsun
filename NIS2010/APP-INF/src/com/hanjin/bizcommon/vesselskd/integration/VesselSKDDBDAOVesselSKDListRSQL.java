/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselSKDDBDAOVesselSKDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.vesselskd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselSKDDBDAOVesselSKDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel schedule list
	  * </pre>
	  */
	public VesselSKDDBDAOVesselSKDListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("CALLING_SEQ," ).append("\n"); 
		query.append("VESSEL," ).append("\n"); 
		query.append("VOYAGE_NO," ).append("\n"); 
		query.append("DIR_CD," ).append("\n"); 
		query.append("CALLING_IND," ).append("\n"); 
		query.append("PORT," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("VPS_ETA_DT," ).append("\n"); 
		query.append("VPS_ETD_DT," ).append("\n"); 
		query.append("TURN_PORT_IND_CD," ).append("\n"); 
		query.append("SKD_CNG_STS_CD" ).append("\n"); 
		query.append("FROM (SELECT ROW_NUMBER() OVER (ORDER BY VSL_CD ASC) no," ).append("\n"); 
		query.append("CLPT_SEQ CALLING_SEQ," ).append("\n"); 
		query.append("VSL_CD VESSEL," ).append("\n"); 
		query.append("SKD_VOY_NO VOYAGE_NO," ).append("\n"); 
		query.append("SKD_DIR_CD DIR_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ CALLING_IND," ).append("\n"); 
		query.append("VPS_PORT_CD PORT," ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("TO_CHAR(VPS_ETA_DT, 'YYYYMMDD HH24:mi' ) VPS_ETA_DT," ).append("\n"); 
		query.append("TO_CHAR(VPS_ETD_DT, 'YYYYMMDD HH24:mi' ) VPS_ETD_DT," ).append("\n"); 
		query.append("TURN_PORT_IND_CD," ).append("\n"); 
		query.append("SKD_CNG_STS_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CD = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = substr(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ ASC" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.vesselskd.integration").append("\n"); 
		query.append("FileName : VesselSKDDBDAOVesselSKDListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}