/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VSKCodeFinderDBDAOCheckSvcLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.20 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author RYU HYUK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOCheckSvcLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckSvcLane
	  * </pre>
	  */
	public VSKCodeFinderDBDAOCheckSvcLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOCheckSvcLaneRSQL").append("\n"); 
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
		query.append("SELECT 	VSL_SLAN_NM, VSL_SVC_TP_CD, FDR_DIV_CD" ).append("\n"); 
		query.append("FROM   	MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("and	VSL_SLAN_CD = UPPER(@[vsl_slan_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("AND  DELT_FLG = 'N'" ).append("\n"); 

	}
}