/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckCurVvdBkgPolPodYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.16 
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

public class VesselScheduleMgtDBDAOCheckCurVvdBkgPolPodYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정VVD에 매핑된BKG 목록추출
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckCurVvdBkgPolPodYardRSQL(){
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
		query.append("FileName : VesselScheduleMgtDBDAOCheckCurVvdBkgPolPodYardRSQL").append("\n"); 
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
		query.append("SELECT 		DISTINCT " ).append("\n"); 
		query.append("    		BFR_VSL_CD" ).append("\n"); 
		query.append("		,	BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("		,	BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("		,	BFR_VPS_PORT_CD" ).append("\n"); 
		query.append("		,	BFR_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		,	BFR_YD_CD" ).append("\n"); 
		query.append("		,	BFR_VSL_SLAN_CD" ).append("\n"); 
		query.append("		,	BFR_VPS_ETA_DT" ).append("\n"); 
		query.append("		,	BFR_VPS_ETB_DT" ).append("\n"); 
		query.append("		,	BFR_VPS_ETD_DT" ).append("\n"); 
		query.append("		,	VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("FROM 		(" ).append("\n"); 
		query.append("			SELECT 		T1.VSL_CD 		BFR_VSL_CD" ).append("\n"); 
		query.append("					,	T1.SKD_VOY_NO 	BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("					,	T1.SKD_DIR_CD 	BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("					,	T1.VPS_PORT_CD 	BFR_VPS_PORT_CD" ).append("\n"); 
		query.append("					,	T1.CLPT_IND_SEQ BFR_CLPT_IND_SEQ" ).append("\n"); 
		query.append("					,	T1.YD_CD 		BFR_YD_CD" ).append("\n"); 
		query.append("					,	T1.SLAN_CD 		BFR_VSL_SLAN_CD" ).append("\n"); 
		query.append("					,	TO_CHAR(T1.VPS_ETA_DT, 'YYYYMMDDHH24MI') BFR_VPS_ETA_DT" ).append("\n"); 
		query.append("					,	TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MI') BFR_VPS_ETB_DT" ).append("\n"); 
		query.append("					,	TO_CHAR(T1.VPS_ETD_DT, 'YYYYMMDDHH24MI') BFR_VPS_ETD_DT" ).append("\n"); 
		query.append("					,	T1.VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append("			FROM   		VSK_VSL_PORT_SKD 	T1" ).append("\n"); 
		query.append("					,	BKG_VVD 			T2" ).append("\n"); 
		query.append("					,	BKG_BOOKING 		T3" ).append("\n"); 
		query.append("			WHERE  		1 = 1" ).append("\n"); 
		query.append("			AND    		T1.VSL_CD 			= T2.VSL_CD" ).append("\n"); 
		query.append("			AND    		T1.SKD_VOY_NO 		= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND    		T1.SKD_DIR_CD 		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND    		T1.VPS_PORT_CD 		= T2.POL_CD" ).append("\n"); 
		query.append("			AND    		T2.BKG_NO 			= T3.BKG_NO" ).append("\n"); 
		query.append("			AND    		T3.BKG_STS_CD 		IN ('F','W')" ).append("\n"); 
		query.append("			AND    		T1.VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("			AND    		T1.SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("			AND    		T1.SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 
		query.append("			AND    		T1.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("			ORDER BY 	CLPT_SEQ" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}