/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOSearchLaneListByVendorRSQL.java
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

public class VesselScheduleMasterDataDBDAOSearchLaneListByVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLaneListByVendor
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOSearchLaneListByVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_agn_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOSearchLaneListByVendorRSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD AS LANE_CD" ).append("\n"); 
		query.append("FROM   MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND CNL_AGN_VNDR_SEQ = @[cnl_agn_vndr_seq]" ).append("\n"); 
		query.append("AND VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 

	}
}