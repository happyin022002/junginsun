/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCheckFirstDirForLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.28 
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

public class VesselScheduleMgtDBDAOCheckFirstDirForLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FIRST DIRECTION FOR LANE
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCheckFirstDirForLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCheckFirstDirForLaneRSQL").append("\n"); 
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
		query.append("SELECT   COUNT(1)  AS KNT" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("         --=============================================================" ).append("\n"); 
		query.append("          SELECT   X.VSL_SLAN_CD" ).append("\n"); 
		query.append("                ,  X.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                ,  X.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,  DECODE(X.MIN_PORT_ROTN_SEQ,1,1,2)  AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("          FROM     (" ).append("\n"); 
		query.append("                   -----------------------------------------------------         " ).append("\n"); 
		query.append("                    SELECT   PD.VSL_SLAN_CD" ).append("\n"); 
		query.append("                          ,  PD.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                          ,  PD.SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,  MIN(PD.PORT_ROTN_SEQ) AS MIN_PORT_ROTN_SEQ" ).append("\n"); 
		query.append("                    FROM     VSK_PF_SKD_DTL     PD   " ).append("\n"); 
		query.append("                    GROUP BY PD.VSL_SLAN_CD" ).append("\n"); 
		query.append("                          ,  PD.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                          ,  PD.SKD_DIR_CD         " ).append("\n"); 
		query.append("                   -----------------------------------------------------" ).append("\n"); 
		query.append("                   ) X" ).append("\n"); 
		query.append("         --=============================================================" ).append("\n"); 
		query.append("         ) XX" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      XX.VSL_SLAN_DIR_SEQ   = '2'" ).append("\n"); 
		query.append("AND      (XX.VSL_SLAN_CD,XX.PF_SVC_TP_CD,XX.SKD_DIR_CD)" ).append("\n"); 
		query.append("         IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("         --------------------------------------------" ).append("\n"); 
		query.append("         SELECT             VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                         ,  VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                         ,  VS.SKD_DIR_CD" ).append("\n"); 
		query.append("         FROM               VSK_VSL_SKD   VS" ).append("\n"); 
		query.append("         WHERE              VS.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("         AND                VS.SKD_VOY_NO = @[turn_skd_voy_no]" ).append("\n"); 
		query.append("         AND                VS.SKD_DIR_CD = @[turn_skd_dir_cd]" ).append("\n"); 
		query.append("         --------------------------------------------         " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SELECT    	COUNT(1)	AS KNT" ).append("\n"); 
		query.append("--FROM      	VSK_PF_SKD_DIR        	PR" ).append("\n"); 
		query.append("--WHERE     	1 = 1" ).append("\n"); 
		query.append("--AND       	PR.VSL_SLAN_DIR_SEQ   	= '2'      " ).append("\n"); 
		query.append("--AND			(PR.VSL_SLAN_CD,PR.PF_SVC_TP_CD,PR.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("--			IN" ).append("\n"); 
		query.append("--			(SELECT VS.VSL_SLAN_CD, VS.PF_SKD_TP_CD, VS.SKD_DIR_CD " ).append("\n"); 
		query.append("--			 FROM	VSK_VSL_SKD 	VS " ).append("\n"); 
		query.append("--			 WHERE 	VS.VSL_CD 		= [vsl_cd]" ).append("\n"); 
		query.append("--			 AND 	VS.SKD_VOY_NO 	= [turn_skd_voy_no]" ).append("\n"); 
		query.append("--			 AND 	VS.SKD_DIR_CD 	= [turn_skd_dir_cd]" ).append("\n"); 
		query.append("--			 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SELECT    	COUNT(1)	AS KNT" ).append("\n"); 
		query.append("--FROM      	VSK_PF_SKD_DIR        	PR" ).append("\n"); 
		query.append("--WHERE     	1 = 1" ).append("\n"); 
		query.append("--AND       	PR.VSL_SLAN_DIR_SEQ   	= '1' " ).append("\n"); 
		query.append("--AND       	PR.VSL_SLAN_CD			= [vsl_slan_cd]" ).append("\n"); 
		query.append("--AND			PR.PF_SVC_TP_CD			= NVL([pf_skd_tp_cd],[pf_svc_tp_cd])             " ).append("\n"); 
		query.append("--AND       	PR.VSL_SLAN_DIR_CD     	= [skd_dir_cd]" ).append("\n"); 

	}
}