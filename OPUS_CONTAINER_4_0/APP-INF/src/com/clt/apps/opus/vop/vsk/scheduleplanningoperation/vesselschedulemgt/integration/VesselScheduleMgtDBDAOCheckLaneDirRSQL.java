/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckLaneDirRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.25 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author RYU HYUK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCheckLaneDirRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckLaneDirRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckLaneDirRSQL").append("\n"); 
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
		query.append("SELECT 'X' AS FLAG" ).append("\n"); 
		query.append("FROM  MDM_VSL_SVC_LANE T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("WHERE T1.VSL_SLAN_CD      = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND   T1.VSL_SLAN_CD      = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND   T1.VSL_TP_CD        = 'C'" ).append("\n"); 
		query.append("AND   T2.VSL_SLAN_DIR_CD  = @[vsl_slan_dir_cd]" ).append("\n"); 
		query.append("AND   T1.DELT_FLG         = 'N'" ).append("\n"); 

	}
}