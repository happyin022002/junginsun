/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOMultiAverageCM2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.12.23 최성민
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

public class NetworkCostDBDAOMultiAverageCM2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Average U/C (CM2) 수정
	  * </pre>
	  */
	public NetworkCostDBDAOMultiAverageCM2CSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiAverageCM2CSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_OP_AVG_UT_COST A USING" ).append("\n"); 
		query.append("(SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("      , @[trd_cd] TRD_CD" ).append("\n"); 
		query.append("      , @[rlane_cd] RLANE_CD" ).append("\n"); 
		query.append("      , @[stnd_cost_cd] STND_COST_CD" ).append("\n"); 
		query.append("      , @[op_uc_amt] OP_UC_AMT" ).append("\n"); 
		query.append("      , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE CRE_DT" ).append("\n"); 
		query.append("      , @[cre_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE UPD_DT" ).append("\n"); 
		query.append("      , @[cost_use_tp_cd] COST_USE_TP_CD" ).append("\n"); 
		query.append("      , @[dir_cd] DIR_CD" ).append("\n"); 
		query.append("   FROM DUAL ) B " ).append("\n"); 
		query.append("	 ON (A.COST_YRMON     	= B.COST_YRMON " ).append("\n"); 
		query.append("	AND A.TRD_CD 			= B.TRD_CD " ).append("\n"); 
		query.append("	AND A.RLANE_CD 			= B.RLANE_CD " ).append("\n"); 
		query.append("	AND A.STND_COST_CD 		= B.STND_COST_CD " ).append("\n"); 
		query.append("	AND A.DIR_CD 			= B.DIR_CD" ).append("\n"); 
		query.append("	AND A.COST_USE_TP_CD	= B.COST_USE_TP_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("      		SET A.OP_UC_AMT		= B.OP_UC_AMT" ).append("\n"); 
		query.append("              , A.UPD_USR_ID 	= B.UPD_USR_ID" ).append("\n"); 
		query.append("              , A.UPD_DT     	= B.UPD_DT " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("         INSERT" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        A.COST_YRMON" ).append("\n"); 
		query.append("                      , A.TRD_CD" ).append("\n"); 
		query.append("                      , A.RLANE_CD" ).append("\n"); 
		query.append("                      , A.STND_COST_CD" ).append("\n"); 
		query.append("                      , A.OP_UC_AMT" ).append("\n"); 
		query.append("                      , A.CRE_USR_ID" ).append("\n"); 
		query.append("                      , A.CRE_DT" ).append("\n"); 
		query.append("                      , A.UPD_USR_ID" ).append("\n"); 
		query.append("                      , A.UPD_DT" ).append("\n"); 
		query.append("                      , A.COST_USE_TP_CD" ).append("\n"); 
		query.append("                      , A.DIR_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                VALUES" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        B.COST_YRMON" ).append("\n"); 
		query.append("                      , B.TRD_CD" ).append("\n"); 
		query.append("                      , B.RLANE_CD" ).append("\n"); 
		query.append("                      , B.STND_COST_CD" ).append("\n"); 
		query.append("                      , B.OP_UC_AMT" ).append("\n"); 
		query.append("                      , B.CRE_USR_ID" ).append("\n"); 
		query.append("                      , B.CRE_DT" ).append("\n"); 
		query.append("                      , B.UPD_USR_ID" ).append("\n"); 
		query.append("                      , B.UPD_DT" ).append("\n"); 
		query.append("                      , B.COST_USE_TP_CD" ).append("\n"); 
		query.append("                      , B.DIR_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}