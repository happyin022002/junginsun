/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetWorkCostDBDAOCoaLaneTsBsaCmmtCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.20
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.12.20 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetWorkCostDBDAOCoaLaneTsBsaCmmtCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA Commitment 복사한다.
	  * </pre>
	  */
	public NetWorkCostDBDAOCoaLaneTsBsaCmmtCopyCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetWorkCostDBDAOCoaLaneTsBsaCmmtCopyCSQL").append("\n"); 
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
		query.append("   INSERT" ).append("\n"); 
		query.append("   INTO COA_LANE_TS_BSA_CMMT" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                COST_YRMON" ).append("\n"); 
		query.append("              , FM_TRD_CD" ).append("\n"); 
		query.append("              , FM_RLANE_CD" ).append("\n"); 
		query.append("              , FM_IOC_CD" ).append("\n"); 
		query.append("              , FM_DIR_CD" ).append("\n"); 
		query.append("              , TO_TRD_CD" ).append("\n"); 
		query.append("              , FM_HUL_BND_CD" ).append("\n"); 
		query.append("              , TO_HUL_BND_CD" ).append("\n"); 
		query.append("              , BSA_CMMT_AMT" ).append("\n"); 
		query.append("              , BSA_CMMT_RTO" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" SELECT @[f_tar_mon] AS COST_YRMON" ).append("\n"); 
		query.append("      , FM_TRD_CD" ).append("\n"); 
		query.append("      , FM_RLANE_CD" ).append("\n"); 
		query.append("      , FM_IOC_CD" ).append("\n"); 
		query.append("      , FM_DIR_CD" ).append("\n"); 
		query.append("      , TO_TRD_CD" ).append("\n"); 
		query.append("      , FM_HUL_BND_CD" ).append("\n"); 
		query.append("      , TO_HUL_BND_CD" ).append("\n"); 
		query.append("      , BSA_CMMT_AMT" ).append("\n"); 
		query.append("      , BSA_CMMT_RTO" ).append("\n"); 
		query.append("      , @[user_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("      , @[user_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("   FROM COA_LANE_TS_BSA_CMMT" ).append("\n"); 
		query.append("  WHERE COST_YRMON = @[f_src_mon] " ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}