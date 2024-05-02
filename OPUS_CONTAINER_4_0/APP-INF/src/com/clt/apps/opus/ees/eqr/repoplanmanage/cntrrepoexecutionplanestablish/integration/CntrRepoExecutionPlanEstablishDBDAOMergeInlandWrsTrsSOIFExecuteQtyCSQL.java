/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOMergeInlandWrsTrsSOIFExecuteQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.03 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOMergeInlandWrsTrsSOIFExecuteQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS에서 1개씩 S/O 입력되는 것중에 동일 ROUTE로 이동하는 것은 N개로 집합 WRS-->TRS--> EQR 로 전해진 SO IF EXECUTE 정보 qty 수정 혹은 입력
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOMergeInlandWrsTrsSOIFExecuteQtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOMergeInlandWrsTrsSOIFExecuteQtyCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_INLND_TRSP_EXE_PLN_QTY I" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[repo_pln_id] AS REPO_PLN_ID" ).append("\n"); 
		query.append(",@[pln_yrwk] AS PLN_YRWK" ).append("\n"); 
		query.append(",@[pln_seq] AS PLN_SEQ" ).append("\n"); 
		query.append(",@[ref_id] AS REF_ID" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.REPO_PLN_ID   = M.REPO_PLN_ID" ).append("\n"); 
		query.append("AND I.PLN_YRWK 		= M.PLN_YRWK" ).append("\n"); 
		query.append("AND I.PLN_SEQ 		= M.PLN_SEQ" ).append("\n"); 
		query.append("AND I.REF_ID        = M.REF_ID" ).append("\n"); 
		query.append("AND I.CNTR_TPSZ_CD  = M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("I.CNTR_QTY          = I.CNTR_QTY      + @[cntr_qty]," ).append("\n"); 
		query.append("I.TRSP_COST_AMT     = I.TRSP_COST_AMT + @[trsp_cost_amt] ," ).append("\n"); 
		query.append("I.UPD_USR_ID        = @[user_id]," ).append("\n"); 
		query.append("I.UPD_DT    	    = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.EXE_RQST_DT" ).append("\n"); 
		query.append(",	I.REPO_PLN_ID" ).append("\n"); 
		query.append(",	I.PLN_YRWK" ).append("\n"); 
		query.append(",	I.PLN_SEQ" ).append("\n"); 
		query.append(",	I.REF_ID" ).append("\n"); 
		query.append(",	I.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	I.CNTR_QTY" ).append("\n"); 
		query.append(",	I.TRSP_COST_AMT" ).append("\n"); 
		query.append(",	I.PLN_UC_AMT" ).append("\n"); 
		query.append(",	I.FM_ECC_UC_AMT" ).append("\n"); 
		query.append(",	I.TO_ECC_UC_AMT" ).append("\n"); 
		query.append(",	I.CRE_USR_ID" ).append("\n"); 
		query.append(",	I.CRE_DT" ).append("\n"); 
		query.append(",	I.UPD_USR_ID" ).append("\n"); 
		query.append(",	I.UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(",	@[repo_pln_id]" ).append("\n"); 
		query.append(",	@[pln_yrwk]" ).append("\n"); 
		query.append(",	@[pln_seq]" ).append("\n"); 
		query.append(",	@[ref_id]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[cntr_qty]" ).append("\n"); 
		query.append(",	@[trsp_cost_amt]" ).append("\n"); 
		query.append(",	@[pln_uc_amt]" ).append("\n"); 
		query.append(",	@[fm_ecc_uc_amt]" ).append("\n"); 
		query.append(",	@[to_ecc_uc_amt]" ).append("\n"); 
		query.append(",	@[user_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[user_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}