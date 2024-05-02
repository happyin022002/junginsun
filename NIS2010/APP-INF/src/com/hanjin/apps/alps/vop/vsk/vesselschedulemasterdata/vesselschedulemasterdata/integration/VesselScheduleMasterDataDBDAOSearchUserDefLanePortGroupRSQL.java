/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchUserDefLanePortGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
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

public class VesselScheduleMasterDataDBDAOSearchUserDefLanePortGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VOP_VSK_9001오픈시 Group별 lane, port 정보를 조회합니다.
	  * 
	  * * History
	  * 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchUserDefLanePortGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchUserDefLanePortGroupRSQL").append("\n"); 
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
		query.append("SELECT   D.USR_ID" ).append("\n"); 
		query.append("      ,  D.USR_DEF_GRP_NM" ).append("\n"); 
		query.append("      ,  D.USE_PGM_NM" ).append("\n"); 
		query.append("      ,  D.VSL_SLAN_CD" ).append("\n"); 
		query.append("--      ,  SL.VSL_SLAN_NM    " ).append("\n"); 
		query.append("      , (SELECT L.VSL_SLAN_NM" ).append("\n"); 
		query.append("         FROM   MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("         AND    L.VSL_SLAN_CD = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("         AND    L.VSL_TP_CD          = 'C'    /* Container Vessel */) AS VSL_SLAN_NM  " ).append("\n"); 
		query.append("      ,  D.DIR_CD" ).append("\n"); 
		query.append("      ,  D.PORT_CD            AS PORT_CD" ).append("\n"); 
		query.append("--      ,  ML.LOC_NM            AS PORT_NM" ).append("\n"); 
		query.append("      , (SELECT M.LOC_NM" ).append("\n"); 
		query.append("         FROM   MDM_LOCATION M" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("         AND    M.LOC_CD = D.PORT_CD" ).append("\n"); 
		query.append("         AND    M.CALL_PORT_FLG      = 'Y'   /* Port Indicator   */ ) AS PORT_NM" ).append("\n"); 
		query.append("      ,  D.CRE_USR_ID" ).append("\n"); 
		query.append("      ,  D.UPD_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,  D.USR_DEF_GRP_NM     AS ORG_USR_DEF_GRP_NM " ).append("\n"); 
		query.append("      ,  D.USE_PGM_NM         AS ORG_USE_PGM_NM" ).append("\n"); 
		query.append("      ,  D.VSL_SLAN_CD        AS ORG_VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,  D.DIR_CD        	  AS ORG_DIR_CD" ).append("\n"); 
		query.append("      ,  D.PORT_CD            AS ORG_PORT_CD" ).append("\n"); 
		query.append("	  ,  D.AMP_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM     VSK_USR_DEF_COND_HDR  H" ).append("\n"); 
		query.append("      ,  VSK_USR_DEF_COND_DTL  D" ).append("\n"); 
		query.append("--      ,  MDM_VSL_SVC_LANE      SL" ).append("\n"); 
		query.append("--      ,  MDM_LOCATION          ML" ).append("\n"); 
		query.append("WHERE    H.USR_ID              = D.USR_ID" ).append("\n"); 
		query.append("AND      H.USR_DEF_GRP_NM      = D.USR_DEF_GRP_NM" ).append("\n"); 
		query.append("AND      H.USE_PGM_NM          = D.USE_PGM_NM" ).append("\n"); 
		query.append("AND      H.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("AND      D.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("--AND      D.VSL_SLAN_CD         = SL.VSL_SLAN_CD  " ).append("\n"); 
		query.append("--AND      SL.VSL_TP_CD          = 'C'                   /* Container Vessel */" ).append("\n"); 
		query.append("--AND      D.PORT_CD             = ML.LOC_CD " ).append("\n"); 
		query.append("--AND      ML.CALL_PORT_FLG      = 'Y'                   /* Port Indicator   */" ).append("\n"); 
		query.append("AND      H.USR_ID              = @[usr_id]" ).append("\n"); 
		query.append("AND      H.USE_PGM_NM          = 'VOP_VSK_0021' " ).append("\n"); 
		query.append("ORDER BY H.USR_DEF_GRP_NM" ).append("\n"); 

	}
}