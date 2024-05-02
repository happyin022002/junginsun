/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchLaneListByCanalAgencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.19 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOSearchLaneListByCanalAgencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLaneListByCanalAgency
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchLaneListByCanalAgencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchLaneListByCanalAgencyRSQL").append("\n"); 
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
		query.append("SELECT  T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("        , T1.VSL_SLAN_NM" ).append("\n"); 
		query.append("        , TO_CHAR(T1.CNL_AGN_VNDR_SEQ, '000000') AS CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("		, MAX(DECODE(T2.SVC_SCP_BND_CD, 'N', T2.VSL_SLAN_DIR_CD)) AS NORTH_DIR" ).append("\n"); 
		query.append("		, MAX(DECODE(T2.SVC_SCP_BND_CD, 'S', T2.VSL_SLAN_DIR_CD)) AS SOUTH_DIR" ).append("\n"); 
		query.append("        , MAX(DECODE(MOD(T2.VSL_SLAN_DIR_SEQ, 2), 1, T2.VSL_SLAN_DIR_CD)) AS BOUND1" ).append("\n"); 
		query.append("        , MAX(DECODE(MOD(T2.VSL_SLAN_DIR_SEQ, 2), 0, T2.VSL_SLAN_DIR_CD)) AS BOUND2" ).append("\n"); 
		query.append("FROM    MDM_VSL_SVC_LANE T1, MDM_VSL_SVC_LANE_DIR T2" ).append("\n"); 
		query.append("WHERE   1               = 1" ).append("\n"); 
		query.append("AND     T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T1.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("AND     T2.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("AND     T1.VSL_SVC_TP_CD IN ('I', 'J', 'S')" ).append("\n"); 
		query.append("AND     T1.VSL_TP_CD    = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("--AND     T2.VSL_SLAN_CD = 'MD1'" ).append("\n"); 
		query.append("GROUP BY T1.VSL_SLAN_CD, T1.VSL_SLAN_NM, T1.CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY T1.VSL_SLAN_CD" ).append("\n"); 

	}
}