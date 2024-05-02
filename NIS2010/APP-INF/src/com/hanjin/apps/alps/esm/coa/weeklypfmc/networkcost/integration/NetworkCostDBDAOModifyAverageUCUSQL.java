/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOModifyAverageUCUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.12.22 최성민
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

public class NetworkCostDBDAOModifyAverageUCUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average UC단가를 생성한다
	  * </pre>
	  */
	public NetworkCostDBDAOModifyAverageUCUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_use_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOModifyAverageUCUSQL").append("\n"); 
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
		query.append("UPDATE COA_OP_AVG_UT_COST_IF T1" ).append("\n"); 
		query.append("SET T1.BSA_CAPA = (" ).append("\n"); 
		query.append("    			SELECT T2.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("    			  FROM BSA_VVD_MST T2" ).append("\n"); 
		query.append("    			 WHERE T1.TRD_CD=T2.TRD_CD" ).append("\n"); 
		query.append("      			   AND T1.RLANE_CD=T2.RLANE_CD" ).append("\n"); 
		query.append("     			   AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("      			   AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("      			   AND T1.DIR_CD=T2.SKD_DIR_CD)" ).append("\n"); 
		query.append("  ,T1.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("  ,T1.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE T1.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("  AND T1.COST_USE_TP_CD = @[cost_use_tp_cd]" ).append("\n"); 

	}
}