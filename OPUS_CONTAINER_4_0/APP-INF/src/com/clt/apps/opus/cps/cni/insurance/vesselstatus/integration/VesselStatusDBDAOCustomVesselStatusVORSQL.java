/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselStatusDBDAOCustomVesselStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.12.08 윤세영
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

public class VesselStatusDBDAOCustomVesselStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Status Entry 저장 VO
	  * </pre>
	  */
	public VesselStatusDBDAOCustomVesselStatusVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.insurance.integration").append("\n"); 
		query.append("FileName : VesselStatusDBDAOCustomVesselStatusVORSQL").append("\n"); 
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
		query.append("'' VSL_CD" ).append("\n"); 
		query.append(",	'' INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' INSUR_EFF_DT" ).append("\n"); 
		query.append(",	'' INSUR_EXP_DT" ).append("\n"); 
		query.append(",	'' INSUR_VSL_TP_CD" ).append("\n"); 
		query.append(",	'' VSL_BLD_YR" ).append("\n"); 
		query.append(",	'' VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",	'' INSUR_VSL_CLSS_CD" ).append("\n"); 
		query.append(",	'' GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	'' DWT_WGT" ).append("\n"); 
		query.append(",	'' INSUR_VSL_OSHP_CD" ).append("\n"); 
		query.append(",	'' VSL_OSHP_EFF_DT" ).append("\n"); 
		query.append(",	'' VSL_OSHP_EXP_DT" ).append("\n"); 
		query.append(",	'' INSUR_CVRG_CD" ).append("\n"); 
		query.append(",	'' INSUR_TP_CD" ).append("\n"); 
		query.append(",	'' INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	'' DDCT_CGO_AMT" ).append("\n"); 
		query.append(",	'' DDCT_CRW_AMT" ).append("\n"); 
		query.append(",	'' DDCT_DMG_HL_AMT" ).append("\n"); 
		query.append(",	'' DDCT_OTR_AMT" ).append("\n"); 
		query.append(",	'' INSUR_RMK" ).append("\n"); 
		query.append(",	'' CRE_USR_ID" ).append("\n"); 
		query.append(",	'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}