/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WeeklyCMDBDAOCreateSMUPfmcMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.09
*@LastModifier : 성미영
*@LastVersion : 1.0
* 2013.05.09 성미영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SUNG Mi YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCreateSMUPfmcMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.05.08 성미영 [CHM-201324182] SMU Cost (RA) 전월 COPY 기능 추가
	  * </pre>
	  */
	public WeeklyCMDBDAOCreateSMUPfmcMonthCopyCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCreateSMUPfmcMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_SLT_MGMT_UT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("       COST_YRMON," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       VSL_SLAN_DIR_CD," ).append("\n"); 
		query.append("       COST_LANE_TP_CD," ).append("\n"); 
		query.append("       LANE_GRP_CD," ).append("\n"); 
		query.append("       BSE_UC_AMT," ).append("\n"); 
		query.append("       PLCY_PRC_UT_AMT," ).append("\n"); 
		query.append("       VSL_AVG_DYS," ).append("\n"); 
		query.append("       VSL_SLT_DYS_UC_AMT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] COST_YRMON," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       VSL_SLAN_DIR_CD," ).append("\n"); 
		query.append("       COST_LANE_TP_CD," ).append("\n"); 
		query.append("       LANE_GRP_CD," ).append("\n"); 
		query.append("       BSE_UC_AMT," ).append("\n"); 
		query.append("       PLCY_PRC_UT_AMT," ).append("\n"); 
		query.append("       VSL_AVG_DYS," ).append("\n"); 
		query.append("       VSL_SLT_DYS_UC_AMT," ).append("\n"); 
		query.append("       @[user_id] CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE CRE_DT," ).append("\n"); 
		query.append("       @[user_id] UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE UPD_DT " ).append("\n"); 
		query.append("  FROM MAS_SLT_MGMT_UT" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}