/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselUtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.03.03 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ock, KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCVesselUtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AverageUCVesselUt
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselUtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration ").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselUtCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_POOL_UT_COST" ).append("\n"); 
		query.append("      (COST_YRMON,   STND_COST_CD, TRD_CD,      SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD,     DIR_CD,       HUL_BND_CD,  EFF_FM_YRMON," ).append("\n"); 
		query.append("       EFF_TO_YRMON, TTL_AMT,      TGT_LOD_QTY, TEU_UC_AMT," ).append("\n"); 
		query.append("       CRE_USR_ID,   CRE_DT,       UPD_USR_ID,  UPD_DT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT COST_YRMON," ).append("\n"); 
		query.append("      STND_COST_CD," ).append("\n"); 
		query.append("      TRD_CD," ).append("\n"); 
		query.append("      SUB_TRD_CD," ).append("\n"); 
		query.append("      RLANE_CD," ).append("\n"); 
		query.append("      DIR_CD," ).append("\n"); 
		query.append("      HUL_BND_CD,                                  " ).append("\n"); 
		query.append("      MIN(EFF_FM_YRMON) AS EFF_FM_YRMON," ).append("\n"); 
		query.append("      MAX(EFF_TO_YRMON) AS EFF_TO_YRMON," ).append("\n"); 
		query.append("      NVL(SUM(TTL_AMT),0)      AS TTL_AMT," ).append("\n"); 
		query.append("      NVL(SUM(VVD_BSA_CAPA),0) AS TGT_LOD_QTY," ).append("\n"); 
		query.append("      DECODE(NVL(SUM(VVD_BSA_CAPA),0),0,0,NVL(SUM(TTL_AMT),0)/NVL(SUM(VVD_BSA_CAPA),0)) AS TEU_UC_AMT," ).append("\n"); 
		query.append("      @[cre_usr_id]," ).append("\n"); 
		query.append("      SYSDATE," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      SYSDATE" ).append("\n"); 
		query.append(" FROM MAS_POOL_UT_COST_DTL" ).append("\n"); 
		query.append("WHERE COST_YRMON   = REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("  AND STND_COST_CD = @[f_cobcost] " ).append("\n"); 
		query.append("GROUP BY COST_YRMON," ).append("\n"); 
		query.append("      STND_COST_CD," ).append("\n"); 
		query.append("      TRD_CD," ).append("\n"); 
		query.append("      SUB_TRD_CD," ).append("\n"); 
		query.append("      RLANE_CD," ).append("\n"); 
		query.append("      DIR_CD," ).append("\n"); 
		query.append("      HUL_BND_CD" ).append("\n"); 

	}
}