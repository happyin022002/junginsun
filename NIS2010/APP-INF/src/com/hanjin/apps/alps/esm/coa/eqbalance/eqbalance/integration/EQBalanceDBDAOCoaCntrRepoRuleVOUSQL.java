/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQBalanceDBDAOCoaCntrRepoRuleVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOCoaCntrRepoRuleVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EQBalanceDBDAOCoaCntrRepoRuleVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mb_fm_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opb_to_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mb_to_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_repo_cr_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imbal_fm_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opb_fm_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imbal_to_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOCoaCntrRepoRuleVOUSQL").append("\n"); 
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
		query.append("UPDATE  COA_CNTR_REPO_RULE" ).append("\n"); 
		query.append("SET  IMBAL_FM_RTO   = NVL(DECODE(@[eq_repo_cr_lvl], 'X', @[imbal_fm_rto],  @[imbal_fm_rto]/100), 0)" ).append("\n"); 
		query.append(",IMBAL_TO_RTO   = NVL(DECODE(@[eq_repo_cr_lvl], 'X', @[imbal_to_rto],  @[imbal_to_rto]/100), 0)" ).append("\n"); 
		query.append(",OPB_FM_AMT     = @[opb_fm_amt]" ).append("\n"); 
		query.append(",OPB_TO_AMT     = @[opb_to_amt]" ).append("\n"); 
		query.append(",MB_FM_RTO      = NVL(@[mb_fm_rto]/100, 0)" ).append("\n"); 
		query.append(",MB_TO_RTO      = NVL(@[mb_to_rto]/100, 0)" ).append("\n"); 
		query.append(",UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE  COST_YRMON     = @[cost_yrmon]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD    = REPLACE(@[cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("AND EQ_REPO_CR_LVL  = @[eq_repo_cr_lvl]" ).append("\n"); 

	}
}