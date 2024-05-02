/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOCreateYearlyCostCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOCreateYearlyCostCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateYearlyCostCode
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOCreateYearlyCostCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOCreateYearlyCostCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO LEA_YRY_COST_BUD (" ).append("\n"); 
		query.append("	BSE_YR,                      " ).append("\n"); 
		query.append("	CTRL_OFC_CD,       " ).append("\n"); 
		query.append("	COA_COST_SRC_CD," ).append("\n"); 
		query.append("	ACCT_CD,       " ).append("\n"); 
		query.append("	TTL_USD_AMT,       " ).append("\n"); 
		query.append("	MON_BUD_USD_AMT,      " ).append("\n"); 
		query.append("	MNL_FLG," ).append("\n"); 
		query.append("	CRE_USR_ID,       " ).append("\n"); 
		query.append("	CRE_DT,       " ).append("\n"); 
		query.append("	UPD_USR_ID,       " ).append("\n"); 
		query.append("	UPD_DT               " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("  @[bse_yr]," ).append("\n"); 
		query.append("  @[ctrl_ofc_cd]," ).append("\n"); 
		query.append("  @[coa_cost_src_cd]," ).append("\n"); 
		query.append(" (SELECT  ACCT_CD FROM LEA_LGS_COST WHERE COA_COST_SRC_CD = @[coa_cost_src_cd] AND DELT_FLG ='N')," ).append("\n"); 
		query.append("  0,  " ).append("\n"); 
		query.append("  0," ).append("\n"); 
		query.append("  'N'," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}