/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOStndUseQtyCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2014.12.17 김종옥
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

public class NetworkCostDBDAOStndUseQtyCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StndUseQtyCopy
	  * </pre>
	  */
	public NetworkCostDBDAOStndUseQtyCopyCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration ").append("\n"); 
		query.append("FileName : NetworkCostDBDAOStndUseQtyCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_STND_USE_QTY (" ).append("\n"); 
		query.append("  COST_YRMON" ).append("\n"); 
		query.append(", COST_WK" ).append("\n"); 
		query.append(", TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", SUB_TRD_CD" ).append("\n"); 
		query.append(", HUL_BND_CD" ).append("\n"); 
		query.append(", VVD_BSA_CAPA" ).append("\n"); 
		query.append(", AVG_TS_QTY" ).append("\n"); 
		query.append(", ORG_LOD_QTY" ).append("\n"); 
		query.append(", LOD_QTY" ).append("\n"); 
		query.append(", LDF_RTO " ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(" ) " ).append("\n"); 
		query.append("SELECT @[f_tar_mon] COST_YRMON" ).append("\n"); 
		query.append(", COST_WK" ).append("\n"); 
		query.append(", TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", SUB_TRD_CD" ).append("\n"); 
		query.append(", HUL_BND_CD" ).append("\n"); 
		query.append(", VVD_BSA_CAPA" ).append("\n"); 
		query.append(", AVG_TS_QTY" ).append("\n"); 
		query.append(", ORG_LOD_QTY" ).append("\n"); 
		query.append(", LOD_QTY" ).append("\n"); 
		query.append(", LDF_RTO " ).append("\n"); 
		query.append(", @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE CRE_DT" ).append("\n"); 
		query.append(", @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE UPD_DT" ).append("\n"); 
		query.append("   FROM MAS_STND_USE_QTY " ).append("\n"); 
		query.append("  WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}