/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOCreateOwnDailyHireMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.08.24 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateOwnDailyHireMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.05.08 성미영 [CHM-201324182] AVG hire by Own VSL (PA) 전월 COPY 기능 추가
	  * 2015.08.24 손진환 [CHM-201537399] AVG-hire by Own-VSL (PA) Month Copy 기능 추가 생성 요청
	  * </pre>
	  */
	public NetworkCostDBDAOCreateOwnDailyHireMonthCopyCSQL(){
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
		query.append("FileName : NetworkCostDBDAOCreateOwnDailyHireMonthCopyCSQL").append("\n"); 
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
		query.append("  INTO MAS_OWN_VSL_DLY_HIR ( " ).append("\n"); 
		query.append("       COST_YRMON," ).append("\n"); 
		query.append("	   COST_WK," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       STND_COST_CD," ).append("\n"); 
		query.append("       DHIR_AMT," ).append("\n"); 
		query.append("       EFF_FM_YRMON," ).append("\n"); 
		query.append("       EFF_TO_YRMON," ).append("\n"); 
		query.append("       VSL_AMT," ).append("\n"); 
		query.append("       COM_DTRB_AMT," ).append("\n"); 
		query.append("       AVG_TEU_AMT," ).append("\n"); 
		query.append("       DHIR_ADD_AMT," ).append("\n"); 
		query.append("       DHIR_BFR_AMT," ).append("\n"); 
		query.append("       COM_TTL_AMT," ).append("\n"); 
		query.append("       VSL_AMT_RT," ).append("\n"); 
		query.append("       TTL_DYS," ).append("\n"); 
		query.append("       TTL_TEU_QTY," ).append("\n"); 
		query.append("       OWN_VSL_RMK," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT " ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  SELECT @[f_tar_mon] COST_YRMON," ).append("\n"); 
		query.append("	   COST_WK," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       STND_COST_CD," ).append("\n"); 
		query.append("       DHIR_AMT," ).append("\n"); 
		query.append("       EFF_FM_YRMON," ).append("\n"); 
		query.append("       EFF_TO_YRMON," ).append("\n"); 
		query.append("       VSL_AMT," ).append("\n"); 
		query.append("       COM_DTRB_AMT," ).append("\n"); 
		query.append("       AVG_TEU_AMT," ).append("\n"); 
		query.append("       DHIR_ADD_AMT," ).append("\n"); 
		query.append("       DHIR_BFR_AMT," ).append("\n"); 
		query.append("       COM_TTL_AMT," ).append("\n"); 
		query.append("       VSL_AMT_RT," ).append("\n"); 
		query.append("       TTL_DYS," ).append("\n"); 
		query.append("       TTL_TEU_QTY," ).append("\n"); 
		query.append("       OWN_VSL_RMK," ).append("\n"); 
		query.append("       @[user_id] CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE CRE_DT," ).append("\n"); 
		query.append("       @[user_id] UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_OWN_VSL_DLY_HIR" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}