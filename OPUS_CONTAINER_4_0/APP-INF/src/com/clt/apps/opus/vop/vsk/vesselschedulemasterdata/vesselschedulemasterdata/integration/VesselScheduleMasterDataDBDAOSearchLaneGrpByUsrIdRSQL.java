/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchLaneGrpByUsrIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.10.23 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOSearchLaneGrpByUsrIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLaneGrpByUsrId
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchLaneGrpByUsrIdRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchLaneGrpByUsrIdRSQL").append("\n"); 
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
		query.append("SELECT LANE_GRP_NM" ).append("\n"); 
		query.append("FROM VSK_USR_LANE_GRP" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("GROUP BY LANE_GRP_NM" ).append("\n"); 
		query.append("ORDER BY LANE_GRP_NM" ).append("\n"); 

	}
}