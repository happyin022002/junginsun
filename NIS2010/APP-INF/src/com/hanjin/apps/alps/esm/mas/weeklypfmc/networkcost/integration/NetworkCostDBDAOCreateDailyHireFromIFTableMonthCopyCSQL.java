/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkCostDBDAOCreateDailyHireFromIFTableMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 성미영
*@LastVersion : 1.0
* 2013.05.08 성미영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SUNG Mi YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateDailyHireFromIFTableMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.05.08 성미영 [CHM-201324182] Dailyhire by Cht-VSL (PA) 전월 COPY 기능 추가
	  * </pre>
	  */
	public NetworkCostDBDAOCreateDailyHireFromIFTableMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateDailyHireFromIFTableMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO MAS_CHRG_VSL_DLY_HIR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("       COST_YRMON," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       CHRG_DHIR_AMT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] COST_YRMON," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       CHRG_DHIR_AMT," ).append("\n"); 
		query.append("       @[user_id] CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE CRE_DT," ).append("\n"); 
		query.append("       @[user_id] UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_CHRG_VSL_DLY_HIR" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}