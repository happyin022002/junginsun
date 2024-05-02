/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOMultiSoCodeCostMapgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.19 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOMultiSoCodeCostMapgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_ACT_GRP_COST_MAPG 등록 (Register Cost Items)
	  * </pre>
	  */
	public CostStructureDBDAOMultiSoCodeCostMapgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOMultiSoCodeCostMapgCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_ACT_GRP_COST_MAPG A" ).append("\n"); 
		query.append("USING (SELECT @[cost_act_grp_cd] COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",@[coa_cost_src_cd] COA_COST_SRC_CD" ).append("\n"); 
		query.append(",@[cost_aply_flg] COST_APLY_FLG" ).append("\n"); 
		query.append(",@[user_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[user_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("ON (A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("AND A.COA_COST_SRC_CD = B.COA_COST_SRC_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.COST_APLY_FLG = B.COST_APLY_FLG" ).append("\n"); 
		query.append(", A.UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT = B.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (A.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(", A.COA_COST_SRC_CD" ).append("\n"); 
		query.append(", A.COST_APLY_FLG" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT)" ).append("\n"); 
		query.append("VALUES (B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(", B.COA_COST_SRC_CD" ).append("\n"); 
		query.append(", B.COST_APLY_FLG" ).append("\n"); 
		query.append(", B.CRE_USR_ID" ).append("\n"); 
		query.append(", B.CRE_DT" ).append("\n"); 
		query.append(", B.UPD_USR_ID" ).append("\n"); 
		query.append(", B.UPD_DT)" ).append("\n"); 

	}
}