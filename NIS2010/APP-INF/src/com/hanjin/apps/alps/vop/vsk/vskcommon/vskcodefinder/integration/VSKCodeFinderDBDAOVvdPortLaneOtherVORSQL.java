/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDBDAOVvdPortLaneOtherVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.10.07 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOVvdPortLaneOtherVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VSKCodeFinderDBDAOVvdPortLaneOtherVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOVvdPortLaneOtherVORSQL").append("\n"); 
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
		query.append("vsl_cd" ).append("\n"); 
		query.append(",	skd_voy_no" ).append("\n"); 
		query.append(",	sub_trd_dir_cd" ).append("\n"); 
		query.append(",	act_inp_yrmon" ).append("\n"); 
		query.append(",   '' as diff_rmk" ).append("\n"); 
		query.append(",   '' as vskd_tp_cd" ).append("\n"); 
		query.append(",   '' as vskd_cng_tp_cd" ).append("\n"); 
		query.append(",   '' as ctrl_cd" ).append("\n"); 
		query.append(",   '' as fm_dt" ).append("\n"); 
		query.append(",   '' as to_dt" ).append("\n"); 
		query.append(",   '' as skd_dir_cd" ).append("\n"); 
		query.append(",   '' as vsl_slan_cd" ).append("\n"); 
		query.append(",   '' as VPS_PORT_CD" ).append("\n"); 
		query.append(",   '' as vps_eta_dt" ).append("\n"); 
		query.append("FROM vsk_vsl_skd_rslt" ).append("\n"); 
		query.append("WHERE	vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("ORDER BY act_inp_yrmon" ).append("\n"); 

	}
}