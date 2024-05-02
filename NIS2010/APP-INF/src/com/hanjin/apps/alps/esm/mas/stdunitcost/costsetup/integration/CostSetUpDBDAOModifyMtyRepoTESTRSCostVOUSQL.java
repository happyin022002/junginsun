/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOModifyMtyRepoTESTRSCostVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.12.24 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOModifyMtyRepoTESTRSCostVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 데이터 수정
	  * </pre>
	  */
	public CostSetUpDBDAOModifyMtyRepoTESTRSCostVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_adj_pl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_tml_mnl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_trsp_mnl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOModifyMtyRepoTESTRSCostVOUSQL").append("\n"); 
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
		query.append("--================================" ).append("\n"); 
		query.append("-- SAVE - SEL 미 체크시 업데이트" ).append("\n"); 
		query.append("--================================" ).append("\n"); 
		query.append("MERGE INTO MAS_MTY_REPO_COST_DTL A USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT @[cost_yrmon] AS COST_YRMON" ).append("\n"); 
		query.append("             , @[cost_wk] AS COST_WK" ).append("\n"); 
		query.append("             , DECODE(@[aply_adj_pl_flg], '1', 'Y', 'N') AS APLY_ADJ_PL_FLG" ).append("\n"); 
		query.append("             , NVL(@[mty_tml_mnl_amt], 0) AS MTY_TML_MNL_AMT" ).append("\n"); 
		query.append("             , NVL(@[mty_trsp_mnl_amt], 0) AS MTY_TRSP_MNL_AMT" ).append("\n"); 
		query.append("          FROM DUAL      " ).append("\n"); 
		query.append(") B ON ( A.COST_YRMON = B.COST_YRMON " ).append("\n"); 
		query.append("        AND A.COST_WK = B.COST_WK )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET A.MTY_TML_MNL_AMT  = B.MTY_TML_MNL_AMT" ).append("\n"); 
		query.append("           , A.MTY_TRSP_MNL_AMT = B.MTY_TRSP_MNL_AMT" ).append("\n"); 
		query.append("           , A.APLY_ADJ_PL_FLG  = B.APLY_ADJ_PL_FLG" ).append("\n"); 
		query.append("           , A.UPD_USR_ID       = @[user_id]" ).append("\n"); 
		query.append("           , A.UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("          A.COST_YRMON" ).append("\n"); 
		query.append("        , A.COST_WK" ).append("\n"); 
		query.append("        , A.APLY_ADJ_PL_FLG" ).append("\n"); 
		query.append("        , A.MTY_TML_MNL_AMT" ).append("\n"); 
		query.append("        , A.MTY_TRSP_MNL_AMT" ).append("\n"); 
		query.append("        , A.CRE_USR_ID" ).append("\n"); 
		query.append("        , A.CRE_DT" ).append("\n"); 
		query.append("        , A.UPD_USR_ID" ).append("\n"); 
		query.append("        , A.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("          B.COST_YRMON" ).append("\n"); 
		query.append("        , B.COST_WK" ).append("\n"); 
		query.append("        , B.APLY_ADJ_PL_FLG" ).append("\n"); 
		query.append("        , B.MTY_TML_MNL_AMT" ).append("\n"); 
		query.append("        , B.MTY_TRSP_MNL_AMT" ).append("\n"); 
		query.append("        , @[user_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[user_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}