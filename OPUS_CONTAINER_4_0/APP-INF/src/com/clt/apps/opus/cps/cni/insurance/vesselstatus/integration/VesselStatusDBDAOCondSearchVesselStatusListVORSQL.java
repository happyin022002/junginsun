/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselStatusDBDAOCondSearchVesselStatusListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.27 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselStatusDBDAOCondSearchVesselStatusListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Status Entry 조회 검색 조건
	  * </pre>
	  */
	public VesselStatusDBDAOCondSearchVesselStatusListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration").append("\n"); 
		query.append("FileName : VesselStatusDBDAOCondSearchVesselStatusListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'' INSUR_PERIOD" ).append("\n"); 
		query.append(",	'' INSUR_TP_CD" ).append("\n"); 
		query.append(",	'' VSL_CD" ).append("\n"); 
		query.append(",   '' VSL_ENG_NM" ).append("\n"); 
		query.append(",	'' INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' INSUR_EFF_DT" ).append("\n"); 
		query.append(",	'' INSUR_EXP_DT" ).append("\n"); 
		query.append(",	'' INSUR_VSL_TP_CD" ).append("\n"); 
		query.append(",	'' INSUR_VSL_OSHP_CD" ).append("\n"); 
		query.append(",	'' INSUR_CVRG_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}