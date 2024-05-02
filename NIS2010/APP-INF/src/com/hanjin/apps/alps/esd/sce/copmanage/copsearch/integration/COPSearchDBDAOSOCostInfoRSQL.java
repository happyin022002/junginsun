/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COPSearchDBDAOSOCostInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSOCostInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SOCostInfo VO 생성
	  * </pre>
	  */
	public COPSearchDBDAOSOCostInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSOCostInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'' so_dt," ).append("\n"); 
		query.append("'' cop_no," ).append("\n"); 
		query.append("'' so_num," ).append("\n"); 
		query.append("'' ctrl_ofc_cd," ).append("\n"); 
		query.append("'' fm_to," ).append("\n"); 
		query.append("'' cost_act_grp_seq," ).append("\n"); 
		query.append("'' user_id," ).append("\n"); 
		query.append("'' so_rmk2," ).append("\n"); 
		query.append("'' wo_no," ).append("\n"); 
		query.append("'' so_rmk3," ).append("\n"); 
		query.append("'' sp_h_no," ).append("\n"); 
		query.append("'' vndr_abbr_nm," ).append("\n"); 
		query.append("'' so_rmk1," ).append("\n"); 
		query.append("'' wo_dt," ).append("\n"); 
		query.append("'' trsp_so_sts," ).append("\n"); 
		query.append("'' trsp_so_sts_cd," ).append("\n"); 
		query.append("'' cost_act_grp_nm," ).append("\n"); 
		query.append("'' vndr_abbr_nm_act" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}