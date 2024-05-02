/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PerformanceDBDAOFcmMonFoilSavCostVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.04 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.performance.performance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceDBDAOFcmMonFoilSavCostVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Monthly Fuel Oil Saving Cost 정보를 삭제한다.
	  * 
	  * History
	  * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
	  * </pre>
	  */
	public PerformanceDBDAOFcmMonFoilSavCostVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_cost_cre_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sav_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.performance.performance.integration").append("\n"); 
		query.append("FileName : PerformanceDBDAOFcmMonFoilSavCostVODSQL").append("\n"); 
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
		query.append("/* Monthly Fuel Oil Saving Cost 정보를 삭제한다.*/" ).append("\n"); 
		query.append("DELETE FROM FCM_MON_FUEL_OIL_SAV_COST" ).append("\n"); 
		query.append("WHERE 1=1                                   " ).append("\n"); 
		query.append("AND SAV_ITM_CD=@[sav_itm_cd]" ).append("\n"); 
		query.append("AND SAV_COST_CRE_YRMON=@[sav_cost_cre_yrmon]" ).append("\n"); 
		query.append("#if (${inq_vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND VSL_SLAN_CD=@[inq_vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}