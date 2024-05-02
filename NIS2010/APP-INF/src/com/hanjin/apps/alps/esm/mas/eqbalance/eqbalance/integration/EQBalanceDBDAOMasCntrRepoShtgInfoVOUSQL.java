/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQBalanceDBDAOMasCntrRepoShtgInfoVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOMasCntrRepoShtgInfoVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EQBalanceDBDAOMasCntrRepoShtgInfoVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_repo_cr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mb_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imbal_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOMasCntrRepoShtgInfoVOUSQL").append("\n"); 
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
		query.append("UPDATE  MAS_CNTR_REPO_SHTG_INFO" ).append("\n"); 
		query.append("   SET  IMBAL_AMT = @[imbal_amt] " ).append("\n"); 
		query.append("	   ,MB_AMT = @[mb_amt] / 100 " ).append("\n"); 
		query.append("	   ,EQ_REPO_CR_RTO = @[eq_repo_cr_rto]/100" ).append("\n"); 
		query.append("       ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE  COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("   AND  CNTR_TPSZ_CD = REPLACE(@[cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("   AND  ECC_CD = @[ecc_cd]" ).append("\n"); 

	}
}