/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckFirstDirForVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.17 
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

public class VesselScheduleMgtDBDAOCheckFirstDirForVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD에 대한 FIRST DIRECTION 추출
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckFirstDirForVVDRSQL(){
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
		query.append("FileName : VesselScheduleMgtDBDAOCheckFirstDirForVVDRSQL").append("\n"); 
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
		query.append("SELECT    	COUNT(1)	AS KNT" ).append("\n"); 
		query.append("FROM      	VSK_PF_SKD_DIR        	PR" ).append("\n"); 
		query.append("        ,   VSK_VSL_SKD             VS" ).append("\n"); 
		query.append("WHERE     	1 = 1" ).append("\n"); 
		query.append("AND         VS.VSL_SLAN_CD			= PR.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND         VS.PF_SKD_TP_CD         = PR.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND         VS.SKD_DIR_CD           = PR.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("AND         PR.VSL_SLAN_DIR_SEQ     = '1'       " ).append("\n"); 
		query.append("AND         VS.VSL_CD               = @[vsl_cd] " ).append("\n"); 
		query.append("AND         VS.SKD_VOY_NO           = @[skd_voy_no]" ).append("\n"); 
		query.append("AND         VS.SKD_DIR_CD           = @[skd_dir_cd]" ).append("\n"); 

	}
}