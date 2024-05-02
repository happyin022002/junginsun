/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOSearchPairVVDforVipsIfMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalDBDAOSearchPairVVDforVipsIfMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Searching Pair VVD for VIPS I/F
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOSearchPairVVDforVipsIfMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOSearchPairVVDforVipsIfMstRSQL").append("\n"); 
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
		query.append("SELECT		X.VSL_CD" ).append("\n"); 
		query.append("       	,  	X.SKD_VOY_NO" ).append("\n"); 
		query.append("       	,  	X.SKD_DIR_CD" ).append("\n"); 
		query.append("	   	,  	X.VSL_SLAN_CD" ).append("\n"); 
		query.append("		,	X.PF_SKD_TP_CD		AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("FROM      	VSK_VSL_SKD         X" ).append("\n"); 
		query.append("WHERE     	(X.VSL_CD,X.SKD_VOY_NO)" ).append("\n"); 
		query.append("          	IN" ).append("\n"); 
		query.append("          	(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach(${param} in ${targetVoyage})" ).append("\n"); 
		query.append("	#if($velocityCount < $targetVoyage.size())" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}')," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND       	EXISTS         	(SELECT  ''" ).append("\n"); 
		query.append("--                          	 FROM    VSK_PF_SKD_DIR  	PD" ).append("\n"); 
		query.append("--                          	 WHERE   PD.VSL_SLAN_CD  	= X.VSL_SLAN_CD" ).append("\n"); 
		query.append("--                          	 AND     PD.PF_SVC_TP_CD 	= X.PF_SKD_TP_CD" ).append("\n"); 
		query.append("--                          	 AND     PD.VSL_SLAN_DIR_CD = X.SKD_DIR_CD" ).append("\n"); 
		query.append("--                          	 AND     PD.VSL_SLAN_CD  	= [vsl_slan_cd]" ).append("\n"); 
		query.append("--                          	 AND     PD.PF_SVC_TP_CD 	= NVL([pf_svc_tp_cd],[pf_skd_tp_cd])" ).append("\n"); 
		query.append("--							)" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT		X.VSL_CD" ).append("\n"); 
		query.append("       	,  	X.SKD_VOY_NO" ).append("\n"); 
		query.append("       	,  	X.SKD_DIR_CD" ).append("\n"); 
		query.append("	   	,  	X.VSL_SLAN_CD" ).append("\n"); 
		query.append("		,	X.PF_SKD_TP_CD		AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("FROM      	VSK_VSL_SKD         X" ).append("\n"); 
		query.append("WHERE     	(X.VSL_CD,X.SKD_VOY_NO,X.SKD_DIR_CD)" ).append("\n"); 
		query.append("          	IN" ).append("\n"); 
		query.append("          	(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach(${param} in ${targetVoyage})" ).append("\n"); 
		query.append("	#if($velocityCount < $targetVoyage.size())" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}