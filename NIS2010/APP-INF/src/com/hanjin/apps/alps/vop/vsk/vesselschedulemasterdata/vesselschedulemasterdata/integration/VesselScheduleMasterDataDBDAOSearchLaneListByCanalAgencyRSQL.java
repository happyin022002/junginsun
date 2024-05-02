/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchLaneListByCanalAgencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
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
		query.append("SELECT  T5.VSL_SLAN_CD" ).append("\n"); 
		query.append("        , T5.VSL_SLAN_NM" ).append("\n"); 
		query.append("        , TO_CHAR(T5.VNDR_SEQ, '000000') AS VNDR_SEQ" ).append("\n"); 
		query.append("        , TO_CHAR(T6.CNL_AGN_VNDR_SEQ, '000000') AS CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("        , T5.NORTH_DIR" ).append("\n"); 
		query.append("        , T5.SOUTH_DIR" ).append("\n"); 
		query.append("        , T5.BOUND1" ).append("\n"); 
		query.append("        , T5.BOUND2" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                , T3.VSL_SLAN_NM" ).append("\n"); 
		query.append("                , TO_CHAR(T3.VNDR_SEQ, '000000') AS VNDR_SEQ" ).append("\n"); 
		query.append("        		, MAX(DECODE(T4.SVC_SCP_BND_CD, 'N', T4.VSL_SLAN_DIR_CD)) AS NORTH_DIR" ).append("\n"); 
		query.append("        		, MAX(DECODE(T4.SVC_SCP_BND_CD, 'S', T4.VSL_SLAN_DIR_CD)) AS SOUTH_DIR" ).append("\n"); 
		query.append("                , MAX(DECODE(MOD(T4.VSL_SLAN_DIR_SEQ, 2), 1, T4.VSL_SLAN_DIR_CD)) AS BOUND1" ).append("\n"); 
		query.append("                , MAX(DECODE(MOD(T4.VSL_SLAN_DIR_SEQ, 2), 0, T4.VSL_SLAN_DIR_CD)) AS BOUND2" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  T1.VSL_SLAN_CD, T1.VSL_SLAN_NM, T2.VNDR_SEQ" ).append("\n"); 
		query.append("                FROM    MDM_VSL_SVC_LANE T1, MDM_VENDOR T2" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND     T1.VSL_SVC_TP_CD IN ('I', 'J', 'S')" ).append("\n"); 
		query.append("                AND     T1.VSL_TP_CD    = 'C'" ).append("\n"); 
		query.append("                AND     T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND     T2.CNL_AGN_FLG = 'Y'" ).append("\n"); 
		query.append("                ORDER BY T1.VSL_SLAN_CD, T2.VNDR_SEQ" ).append("\n"); 
		query.append("                ) T3" ).append("\n"); 
		query.append("                , MDM_VSL_SVC_LANE_DIR T4" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T3.VSL_SLAN_CD  = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND     T4.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        GROUP BY T3.VSL_SLAN_CD, T3.VSL_SLAN_NM, T3.VNDR_SEQ" ).append("\n"); 
		query.append("        ORDER BY T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("        ) T5" ).append("\n"); 
		query.append("        , VSK_CNL_VNDR T6" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T5.VSL_SLAN_CD = T6.VSL_SLAN_CD (+)" ).append("\n"); 
		query.append("AND     T5.VNDR_SEQ =  T6.CNL_AGN_VNDR_SEQ (+)" ).append("\n"); 
		query.append("ORDER BY T5.VSL_SLAN_CD" ).append("\n"); 

	}
}