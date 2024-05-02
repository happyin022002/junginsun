/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchVesselLaneLastPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchVesselLaneLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel / Lane 에 대해서 마지막 Port 의 정보를 조회한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchVesselLaneLastPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchVesselLaneLastPortRSQL").append("\n"); 
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
		query.append("	MAX(VSL_CD) KEEP(DENSE_RANK FIRST ORDER BY VSK.SKD_VOY_NO DESC, MDM.VSL_SLAN_DIR_SEQ DESC, VSK.CLPT_SEQ DESC) AS VSL_CD" ).append("\n"); 
		query.append("	,MAX(SKD_VOY_NO) KEEP(DENSE_RANK FIRST ORDER BY VSK.SKD_VOY_NO DESC, MDM.VSL_SLAN_DIR_SEQ DESC, VSK.CLPT_SEQ DESC) AS SKD_VOY_NO" ).append("\n"); 
		query.append("	,MAX(SKD_DIR_CD) KEEP(DENSE_RANK FIRST ORDER BY VSK.SKD_VOY_NO DESC, MDM.VSL_SLAN_DIR_SEQ DESC, VSK.CLPT_SEQ DESC) AS SKD_DIR_CD" ).append("\n"); 
		query.append("	,MAX(VPS_PORT_CD) KEEP(DENSE_RANK FIRST ORDER BY VSK.SKD_VOY_NO DESC, MDM.VSL_SLAN_DIR_SEQ DESC, VSK.CLPT_SEQ DESC) AS VPS_PORT_CD" ).append("\n"); 
		query.append("	,MAX(CLPT_IND_SEQ) KEEP(DENSE_RANK FIRST ORDER BY VSK.SKD_VOY_NO DESC, MDM.VSL_SLAN_DIR_SEQ DESC, VSK.CLPT_SEQ DESC) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,MAX(TO_CHAR(VPS_ETA_DT, 'YYYYMMDD')) KEEP(DENSE_RANK FIRST ORDER BY VSK.SKD_VOY_NO DESC, MDM.VSL_SLAN_DIR_SEQ DESC, VSK.CLPT_SEQ DESC) AS VPS_ETA_DT" ).append("\n"); 
		query.append("	,MAX(SKD_CNG_STS_CD) KEEP(DENSE_RANK FIRST ORDER BY VSK.SKD_VOY_NO DESC, MDM.VSL_SLAN_DIR_SEQ DESC, VSK.CLPT_SEQ DESC) AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VSK, MDM_VSL_SVC_LANE_DIR MDM" ).append("\n"); 
		query.append("WHERE VSK.SLAN_CD = MDM.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND VSK.SKD_DIR_CD = MDM.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND VSK.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND VSK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("AND VSK.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 

	}
}