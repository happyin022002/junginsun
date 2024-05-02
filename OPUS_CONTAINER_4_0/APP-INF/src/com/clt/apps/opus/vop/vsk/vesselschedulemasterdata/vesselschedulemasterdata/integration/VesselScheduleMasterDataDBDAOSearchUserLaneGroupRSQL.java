/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchUserLaneGroupRSQL.java
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

public class VesselScheduleMasterDataDBDAOSearchUserLaneGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port별 관리하고 Lane을 Group하기 위해 조회한다
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchUserLaneGroupRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchUserLaneGroupRSQL").append("\n"); 
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
		query.append("T1.USR_ID" ).append("\n"); 
		query.append(",T1.LANE_GRP_NM" ).append("\n"); 
		query.append(",T1.LANE_GRP_NM SRC_LANE_GRP_NM" ).append("\n"); 
		query.append(",T1.VSL_SLAN_CD" ).append("\n"); 
		query.append(",T1.VSL_SLAN_CD SRC_VSL_SLAN_CD" ).append("\n"); 
		query.append(",T2.VSL_SLAN_NM" ).append("\n"); 
		query.append(",T1.CRE_USR_ID" ).append("\n"); 
		query.append(",T1.UPD_USR_ID" ).append("\n"); 
		query.append("FROM VSK_USR_LANE_GRP T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD=T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND T1.USR_ID=@[usr_id]" ).append("\n"); 
		query.append("AND T2.VSL_TP_CD='C' /*컨테이너선*/" ).append("\n"); 
		query.append("ORDER BY T1.LANE_GRP_NM" ).append("\n"); 

	}
}