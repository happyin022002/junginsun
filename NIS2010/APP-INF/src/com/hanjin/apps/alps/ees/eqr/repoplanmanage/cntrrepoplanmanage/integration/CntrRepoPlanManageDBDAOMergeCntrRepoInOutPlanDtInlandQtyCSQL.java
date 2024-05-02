/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtInlandQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtInlandQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0052 최적화된 REPO InOut 계획 수량 조회/수정>
	  * EQR_INLND_TRSP_PLN_QTY         테이블에 VOL, AMOUNT 정보 수정 혹은 입력
	  * 
	  * <Change History>
	  * 1	2009.08.31	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtInlandQtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtInlandQtyCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_INLND_TRSP_PLN_QTY I" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[repo_pln_id] AS REPO_PLN_ID" ).append("\n"); 
		query.append(",@[pln_yrwk] AS PLN_YRWK" ).append("\n"); 
		query.append(",@[pln_seq] AS PLN_SEQ" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd] AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.REPO_PLN_ID       = M.REPO_PLN_ID" ).append("\n"); 
		query.append("AND I.PLN_YRWK 		    = M.PLN_YRWK" ).append("\n"); 
		query.append("AND I.PLN_SEQ 		    = M.PLN_SEQ" ).append("\n"); 
		query.append("AND I.CNTR_TPSZ_CD  	= M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("I.CNTR_QTY    	= @[cntr_qty]," ).append("\n"); 
		query.append("I.UPD_USR_ID      	= @[upd_usr_id]," ).append("\n"); 
		query.append("I.UPD_DT    	  	= SYSDATE," ).append("\n"); 
		query.append("I.TRSP_COST_AMT     = (I.FM_ECC_COST_AMT / DECODE(I.CNTR_QTY, 0, 1 ,I.CNTR_QTY)) * @[cntr_qty] +  (I.TO_ECC_COST_AMT / DECODE(I.CNTR_QTY, 0, 1 ,I.CNTR_QTY)) * @[cntr_qty] ," ).append("\n"); 
		query.append("I.PLN_UC_AMT        = (I.FM_ECC_COST_AMT / DECODE(I.CNTR_QTY, 0, 1 ,I.CNTR_QTY)) +  (I.TO_ECC_COST_AMT / DECODE(I.CNTR_QTY, 0, 1 ,I.CNTR_QTY))," ).append("\n"); 
		query.append("I.FM_ECC_COST_AMT   = (I.FM_ECC_COST_AMT / DECODE(I.CNTR_QTY, 0, 1 ,I.CNTR_QTY)) * DECODE(@[cntr_qty], 0, 1 ,@[cntr_qty]) ," ).append("\n"); 
		query.append("I.TO_ECC_COST_AMT   = (I.TO_ECC_COST_AMT / DECODE(I.CNTR_QTY, 0, 1 ,I.CNTR_QTY)) * DECODE(@[cntr_qty], 0, 1 ,@[cntr_qty])" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.REPO_PLN_ID" ).append("\n"); 
		query.append(",I.PLN_YRWK" ).append("\n"); 
		query.append(",I.PLN_SEQ" ).append("\n"); 
		query.append(",I.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",I.CNTR_QTY" ).append("\n"); 
		query.append(",I.CRE_USR_ID" ).append("\n"); 
		query.append(",I.CRE_DT" ).append("\n"); 
		query.append(",I.UPD_USR_ID" ).append("\n"); 
		query.append(",I.UPD_DT" ).append("\n"); 
		query.append(",I.TRSP_COST_AMT" ).append("\n"); 
		query.append(",I.PLN_UC_AMT" ).append("\n"); 
		query.append(",I.FM_ECC_COST_AMT" ).append("\n"); 
		query.append(",I.TO_ECC_COST_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[repo_pln_id]" ).append("\n"); 
		query.append(", @[pln_yrwk]" ).append("\n"); 
		query.append(", @[pln_seq]" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(", @[cntr_qty]" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[trsp_cost_amt]" ).append("\n"); 
		query.append(", @[pln_uc_amt]" ).append("\n"); 
		query.append(", @[fm_ecc_cost_amt]" ).append("\n"); 
		query.append(", @[to_ecc_cost_amt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}