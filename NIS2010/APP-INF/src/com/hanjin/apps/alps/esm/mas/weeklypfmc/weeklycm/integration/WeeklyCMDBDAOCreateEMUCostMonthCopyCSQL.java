/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WeeklyCMDBDAOCreateEMUCostMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCreateEMUCostMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
	  * </pre>
	  */
	public WeeklyCMDBDAOCreateEMUCostMonthCopyCSQL(){
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
		query.append("FileName : WeeklyCMDBDAOCreateEMUCostMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO  MAS_REPO_IF_MGMT" ).append("\n"); 
		query.append("(COST_YR,COST_MON,VER_TP_CD,COST_LOC_GRP_CD,IF_VER_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD,CNTR_ORG_DEST_CD,LOC_CD,ACT_UT_PRC_AMT,ADJ_RT_AMT," ).append("\n"); 
		query.append("PLCY_PRC_AMT,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    SUBSTR(@[f_tar_mon],1,4) AS COST_YR," ).append("\n"); 
		query.append("    SUBSTR(@[f_tar_mon],5,2) AS COST_MON," ).append("\n"); 
		query.append("    VER_TP_CD,COST_LOC_GRP_CD,IF_VER_CD," ).append("\n"); 
		query.append("    CNTR_TPSZ_CD,CNTR_ORG_DEST_CD,LOC_CD,ACT_UT_PRC_AMT,ADJ_RT_AMT," ).append("\n"); 
		query.append("    PLCY_PRC_AMT," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[user_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("  FROM  MAS_REPO_IF_MGMT" ).append("\n"); 
		query.append("WHERE COST_YR = SUBSTR(@[f_src_mon],1,4)" ).append("\n"); 
		query.append("  AND COST_MON = SUBSTR(@[f_src_mon],5,2)" ).append("\n"); 

	}
}