/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneServiceDBDAOSearchLaneServiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.05.06 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneServiceDBDAOSearchLaneServiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LaneServiceDBDAOSearchLaneServiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("partnerId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.integration").append("\n"); 
		query.append("FileName : LaneServiceDBDAOSearchLaneServiceRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_SLAN_CD," ).append("\n"); 
		query.append("( SELECT VSL_SLAN_NM" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE B" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD = A.VSL_SLAN_CD" ).append("\n"); 
		query.append(") VSL_SLAN_NM," ).append("\n"); 
		query.append("A.ROUT_RCV_DT      ," ).append("\n"); 
		query.append("A.ROUT_SEQ         ," ).append("\n"); 
		query.append("A.CUST_TRD_PRNR_ID ," ).append("\n"); 
		query.append("A.CRE_USR_ID       ," ).append("\n"); 
		query.append("A.CRE_DT           ," ).append("\n"); 
		query.append("A.UPD_USR_ID       ," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("FROM   SCE_PORT_PAIR_DTL A" ).append("\n"); 
		query.append("WHERE A.CUST_TRD_PRNR_ID = @[partnerId]" ).append("\n"); 
		query.append("AND A.USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.MNL_USE_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.ORG_LOC_CD IS NULL" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

	}
}