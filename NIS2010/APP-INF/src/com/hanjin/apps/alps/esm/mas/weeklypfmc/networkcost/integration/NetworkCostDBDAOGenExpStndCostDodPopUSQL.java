/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOGenExpStndCostDodPopUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOGenExpStndCostDodPopUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * General Expense Cost Modification의 수정 정보를 저장한다.
	  * 2015.03.18 컬럼 속성명 변경으로 수정(ADD_EXPN_AMT)
	  * 2015.07.03 신규 Lane인 경우 여기에서 넣을 수 있도록 Merge into로 변경
	  * </pre>
	  */
	public NetworkCostDBDAOGenExpStndCostDodPopUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_expn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOGenExpStndCostDodPopUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_STND_GEN_EXPN A1" ).append("\n"); 
		query.append("  USING (" ).append("\n"); 
		query.append("         SELECT  REPLACE(@[cost_yrmon],'-','') AS COST_YRMON" ).append("\n"); 
		query.append("                ,@[trd_cd]                 AS TRD_CD" ).append("\n"); 
		query.append("                ,@[rlane_cd]               AS RLANE_CD" ).append("\n"); 
		query.append("                ,@[dir_cd]                 AS DIR_CD" ).append("\n"); 
		query.append("                ,@[sub_trd_cd]             AS SUB_TRD_CD" ).append("\n"); 
		query.append("                ,@[hul_bnd_cd]             AS HUL_BND_CD" ).append("\n"); 
		query.append("                ,REPLACE(@[add_expn], ',') AS ADD_EXPN_AMT" ).append("\n"); 
		query.append("                ,NVL((SELECT MAX(LANE_SUM_EXPN_AMT) FROM MAS_STND_GEN_EXPN " ).append("\n"); 
		query.append("                       WHERE COST_YRMON = REPLACE(@[cost_yrmon],'-','') AND TRD_CD = @[trd_cd] AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                    ),0) AS LANE_SUM_EXPN_AMT" ).append("\n"); 
		query.append("                ,NVL((SELECT MAX(STRD_SUM_EXPN_AMT) FROM MAS_STND_GEN_EXPN " ).append("\n"); 
		query.append("                   WHERE COST_YRMON = REPLACE(@[cost_yrmon],'-','') AND TRD_CD = @[trd_cd] AND SUB_TRD_CD = @[sub_trd_cd]),0) AS STRD_SUM_EXPN_AMT  " ).append("\n"); 
		query.append("                ,@[upd_usr_id] AS UPD_USR_ID             " ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("        ) A2" ).append("\n"); 
		query.append("  ON (    A1.COST_YRMON     = A2.COST_YRMON" ).append("\n"); 
		query.append("      AND A1.TRD_CD         = A2.TRD_CD" ).append("\n"); 
		query.append("      AND A1.RLANE_CD       = A2.RLANE_CD" ).append("\n"); 
		query.append("      AND A1.DIR_CD         = A2.DIR_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT(A1.COST_YRMON, A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.SUB_TRD_CD" ).append("\n"); 
		query.append("           ,A1.HUL_BND_CD, A1.EFF_FM_YRMON, A1.EFF_TO_YRMON, A1.ADD_EXPN_AMT, A1.GEN_EXPN_AMT, A1.GEN_EXPN_RTO" ).append("\n"); 
		query.append("           ,A1.ADD_TTL_EXPN_AMT, A1.LANE_SUM_EXPN_AMT, A1.STRD_SUM_EXPN_AMT" ).append("\n"); 
		query.append("           ,A1.CRE_USR_ID, A1.CRE_DT, A1.UPD_USR_ID, A1.UPD_DT)" ).append("\n"); 
		query.append("     VALUES(A2.COST_YRMON, A2.TRD_CD, A2.RLANE_CD, A2.DIR_CD, A2.SUB_TRD_CD" ).append("\n"); 
		query.append("           ,A2.HUL_BND_CD, A2.COST_YRMON, A2.COST_YRMON, A2.ADD_EXPN_AMT, 0, 0" ).append("\n"); 
		query.append("           ,A2.ADD_EXPN_AMT, A2.LANE_SUM_EXPN_AMT, A2.STRD_SUM_EXPN_AMT" ).append("\n"); 
		query.append("           ,A2.UPD_USR_ID, SYSDATE,A2.UPD_USR_ID, SYSDATE )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("       SET A1.ADD_EXPN_AMT = A2.ADD_EXPN_AMT" ).append("\n"); 
		query.append("    	 , A1.UPD_USR_ID   = A2.UPD_USR_ID" ).append("\n"); 
		query.append("         , A1.UPD_DT       = SYSDATE" ).append("\n"); 

	}
}