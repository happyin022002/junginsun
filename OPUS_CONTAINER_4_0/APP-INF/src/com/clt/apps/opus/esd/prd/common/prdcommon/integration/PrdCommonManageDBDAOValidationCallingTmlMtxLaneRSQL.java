/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCommonManageDBDAOValidationCallingTmlMtxLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.03 노승배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOValidationCallingTmlMtxLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ValidationCallingTmlMtxLane
	  * </pre>
	  */
	public PrdCommonManageDBDAOValidationCallingTmlMtxLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_data",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOValidationCallingTmlMtxLaneRSQL").append("\n"); 
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
		query.append("SELECT @[check_data] kind, vsl_slan_nm lane_code, 'Y' chk" ).append("\n"); 
		query.append("FROM mdm_vsl_svc_lane" ).append("\n"); 
		query.append("WHERE vsl_slan_cd = @[check_data]" ).append("\n"); 
		query.append("AND NVL( delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("AND vsl_svc_tp_cd <> 'O'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'FDR' kind, vsl_slan_nm lane_code, decode(@[check_data] , 'FDR', 'Y', 'N') chk" ).append("\n"); 
		query.append("FROM mdm_vsl_svc_lane" ).append("\n"); 
		query.append("WHERE  vsl_slan_cd = @[check_data]" ).append("\n"); 
		query.append("AND NVL( delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("AND vsl_svc_tp_cd = 'O'" ).append("\n"); 

	}
}