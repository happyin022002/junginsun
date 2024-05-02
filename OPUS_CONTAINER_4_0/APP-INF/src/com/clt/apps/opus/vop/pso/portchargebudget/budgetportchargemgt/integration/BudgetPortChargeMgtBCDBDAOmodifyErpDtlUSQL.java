/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOmodifyErpDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOmodifyErpDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyErpDtl
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOmodifyErpDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_src_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_seq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("estm_amt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOmodifyErpDtlUSQL").append("\n"); 
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
		query.append("UPDATE GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("   SET ESTM_AMT     = @[estm_amt]" ).append("\n"); 
		query.append("     , ACT_AMT      = @[act_amt]" ).append("\n"); 
		query.append("     , ACCL_AMT     = (TO_NUMBER(@[estm_amt]) - TO_NUMBER(@[act_amt]))" ).append("\n"); 
		query.append("     , UPD_RMK      = 'Y'|| NVL((SELECT '|Updated from last accrual. calculated amount ['||NVL(ESTM_AMT,0)||'].'" ).append("\n"); 
		query.append("                                  FROM GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("                                 WHERE EXE_YRMON    = @[exe_yrmon]" ).append("\n"); 
		query.append("                                   AND SYS_SRC_ID   = @[sys_src_id]" ).append("\n"); 
		query.append("                                   AND REV_YRMON    = @[rev_yrmon]" ).append("\n"); 
		query.append("                                   AND ACCT_CD      = @[acct_cd]" ).append("\n"); 
		query.append("                                   AND ESTM_SEQ_NO  = @[estm_seq_no])" ).append("\n"); 
		query.append("                                , NULL) /*2016.07.19 Add*/" ).append("\n"); 
		query.append("     , UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("     , ACCL_FLG     = DECODE(SIGN(TO_NUMBER(@[estm_amt]) - TO_NUMBER(@[act_amt])), -1, 'N', NULL) /*2016.09.07 minus amount N flag*/" ).append("\n"); 
		query.append(" WHERE EXE_YRMON    = @[exe_yrmon]" ).append("\n"); 
		query.append("   AND SYS_SRC_ID   = @[sys_src_id]" ).append("\n"); 
		query.append("   AND REV_YRMON    = @[rev_yrmon]" ).append("\n"); 
		query.append("   AND ACCT_CD      = @[acct_cd]" ).append("\n"); 
		query.append("   AND ESTM_SEQ_NO  = @[estm_seq_no]" ).append("\n"); 

	}
}