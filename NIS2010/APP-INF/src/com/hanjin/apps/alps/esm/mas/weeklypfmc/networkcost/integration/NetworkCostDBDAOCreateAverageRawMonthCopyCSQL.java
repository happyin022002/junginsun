/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkCostDBDAOCreateAverageRawMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.10.30 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateAverageRawMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average UC 월단가를 복사해서 생성한다.
	  * </pre>
	  */
	public NetworkCostDBDAOCreateAverageRawMonthCopyCSQL(){
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
		query.append("FileName : NetworkCostDBDAOCreateAverageRawMonthCopyCSQL").append("\n"); 
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
		query.append("   INTO MAS_OP_AVG_VSL_TP_COST" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , VSL_OSHP_CD" ).append("\n"); 
		query.append("              , STND_COST_CD" ).append("\n"); 
		query.append("              , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("              , FREQ_NO" ).append("\n"); 
		query.append("              , NTWK_HIR_COST_AMT" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" SELECT @[f_tar_mon] COST_YRMON" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VSL_OSHP_CD" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , FREQ_NO" ).append("\n"); 
		query.append("      , NTWK_HIR_COST_AMT" ).append("\n"); 
		query.append("      , @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE CRE_DT" ).append("\n"); 
		query.append("      , @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE UPD_DT" ).append("\n"); 
		query.append("   FROM MAS_OP_AVG_VSL_TP_COST " ).append("\n"); 
		query.append("  WHERE COST_YRMON     = @[f_src_mon]" ).append("\n"); 

	}
}