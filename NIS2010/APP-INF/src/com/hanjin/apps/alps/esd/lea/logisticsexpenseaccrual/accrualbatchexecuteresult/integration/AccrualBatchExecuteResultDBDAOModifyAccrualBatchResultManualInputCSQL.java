/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOModifyAccrualBatchResultManualInputCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.18 
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

public class AccrualBatchExecuteResultDBDAOModifyAccrualBatchResultManualInputCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * merge
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOModifyAccrualBatchResultManualInputCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_act_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOModifyAccrualBatchResultManualInputCSQL").append("\n"); 
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
		query.append("MERGE INTO 	LEA_ACCT_COST_AMT A 										" ).append("\n"); 
		query.append("USING 		(" ).append("\n"); 
		query.append("			SELECT 		@[acct_cd]					ACCT_CD                                        " ).append("\n"); 
		query.append("         			,	REPLACE(@[exe_yrmon],'-')	EXE_YRMON                               " ).append("\n"); 
		query.append("         			,	REPLACE(@[rev_yrmon],'-')	REV_YRMON                               " ).append("\n"); 
		query.append("         	FROM 		DUAL                                               " ).append("\n"); 
		query.append("        	) B                                                       " ).append("\n"); 
		query.append("ON 			(" ).append("\n"); 
		query.append("			A.EXE_YRMON		= B.EXE_YRMON                            " ).append("\n"); 
		query.append("AND 		A.REV_YRMON		= B.REV_YRMON                            " ).append("\n"); 
		query.append("AND 		A.ACCT_CD  		= B.ACCT_CD                              " ).append("\n"); 
		query.append("AND 		A.ACCL_AUTO_CD	= CASE  WHEN @[acct_cd] IN ('512073','512075','512361') THEN 'A'" ).append("\n"); 
		query.append("									ELSE 'M'" ).append("\n"); 
		query.append("							  END                                    " ).append("\n"); 
		query.append("     		)                                                           " ).append("\n"); 
		query.append("WHEN  		MATCHED THEN                                               " ).append("\n"); 
		query.append("        	UPDATE SET 	ESTM_COST_AMT 		= @[estm_cost_amt]                           " ).append("\n"); 
		query.append("            		,	PRE_ACT_COST_AMT	= DECODE(@[acct_cd], '512181', @[pre_act_cost_amt], '512381', @[pre_act_cost_amt], PRE_ACT_COST_AMT ) " ).append("\n"); 
		query.append("            		,	ACCL_COST_AMT    	= @[accl_cost_amt]                           " ).append("\n"); 
		query.append("            		,	MNL_INP_FLG 	    = 'Y'                         " ).append("\n"); 
		query.append("            		,	UPD_USR_ID    		= @[upd_usr_id]                             " ).append("\n"); 
		query.append("            		,	UPD_DT        		= SYSDATE                       " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN                                            " ).append("\n"); 
		query.append("         	INSERT ( 	EXE_YRMON        		                          " ).append("\n"); 
		query.append("                 	,	REV_YRMON                                  " ).append("\n"); 
		query.append("                 	,	ACCT_CD                                    " ).append("\n"); 
		query.append("                 	,	ACCL_AUTO_CD                               " ).append("\n"); 
		query.append("                 	,	ESTM_COST_AMT                         " ).append("\n"); 
		query.append("                 	,	ACCL_COST_AMT " ).append("\n"); 
		query.append("					,	PRE_ACT_COST_AMT                             " ).append("\n"); 
		query.append("                 	,	MNL_INP_FLG                                " ).append("\n"); 
		query.append("                 	,	CRE_USR_ID                                 " ).append("\n"); 
		query.append("                 	,	CRE_DT                                     " ).append("\n"); 
		query.append("                 	,	UPD_USR_ID                                 " ).append("\n"); 
		query.append("                 	,	UPD_DT                                     " ).append("\n"); 
		query.append("         	)VALUES(                                                " ).append("\n"); 
		query.append("                 		REPLACE(@[exe_yrmon],'-')     /* EXE_YRMON      */" ).append("\n"); 
		query.append("                 	,	REPLACE(@[rev_yrmon],'-')     /* REV_YRMON      */                         " ).append("\n"); 
		query.append("                 	,	@[acct_cd]                    /* ACCT_CD        */                		" ).append("\n"); 
		query.append("                 	,	CASE  WHEN @[acct_cd] IN ('512073','512075','512361') THEN 'A'" ).append("\n"); 
		query.append("                 			  ELSE 'M'" ).append("\n"); 
		query.append("                 	    END                           /* ACCL_AUTO_CD   */              " ).append("\n"); 
		query.append("                 	,	@[estm_cost_amt]  	          /* ESTM_COST_AMT  */                        " ).append("\n"); 
		query.append("                 	,	@[accl_cost_amt]              /* ACCL_COST_AMT  */" ).append("\n"); 
		query.append("					,	DECODE(@[acct_cd], '512181', @[pre_act_cost_amt], '512381', @[pre_act_cost_amt], '0' )                            " ).append("\n"); 
		query.append("                 	,	'Y'                           /* MNL_INP_FLG    */              " ).append("\n"); 
		query.append("                 	,	@[cre_usr_id]                 /* CRE_USR_ID     */                          " ).append("\n"); 
		query.append("                 	,	SYSDATE                       /* CRE_DT         */              " ).append("\n"); 
		query.append("                 	,	@[upd_usr_id]                 /* UPD_USR_ID     */                          " ).append("\n"); 
		query.append("                 	,	SYSDATE                       /* UPD_DT         */              " ).append("\n"); 
		query.append("         	)" ).append("\n"); 

	}
}