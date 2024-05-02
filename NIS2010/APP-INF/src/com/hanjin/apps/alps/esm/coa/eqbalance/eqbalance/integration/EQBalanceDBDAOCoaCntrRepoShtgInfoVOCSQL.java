/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQBalanceDBDAOCoaCntrRepoShtgInfoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQBalanceDBDAOCoaCntrRepoShtgInfoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 - COA_CNTR_REPO_SHTG_INFO 테이블의 인서트
	  * </pre>
	  */
	public EQBalanceDBDAOCoaCntrRepoShtgInfoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_repo_cr_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imbal_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOCoaCntrRepoShtgInfoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_CNTR_REPO_SHTG_INFO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" COST_YRMON      " ).append("\n"); 
		query.append(",CNTR_TPSZ_CD    " ).append("\n"); 
		query.append(",ECC_CD          " ).append("\n"); 
		query.append(",LCC_CD          " ).append("\n"); 
		query.append(",RCC_CD          " ).append("\n"); 
		query.append(",EQ_REPO_CR_RTO" ).append("\n"); 
		query.append(",IMBAL_AMT       " ).append("\n"); 
		query.append(",MB_AMT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",CRE_USR_ID      " ).append("\n"); 
		query.append(",CRE_DT          " ).append("\n"); 
		query.append(",CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("		@[cost_yrmon]" ).append("\n"); 
		query.append("	   ,REPLACE(@[cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("	   ,@[ecc_cd]" ).append("\n"); 
		query.append("	   ,(SELECT DISTINCT LCC_CD FROM COA_LOCATION_V WHERE ECC_CD =@[ecc_cd] )" ).append("\n"); 
		query.append("	   ,(SELECT DISTINCT RCC_CD FROM COA_LOCATION_V WHERE ECC_CD =@[ecc_cd] )" ).append("\n"); 
		query.append("	   ,@[eq_repo_cr_rto] / 100 " ).append("\n"); 
		query.append("	   ,@[imbal_amt] " ).append("\n"); 
		query.append("	   ,@[mb_amt] / 100 " ).append("\n"); 
		query.append(" 	   ,@[upd_usr_id]" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]" ).append("\n"); 
		query.append("	   ,SYSDATE" ).append("\n"); 
		query.append("	   ,@[cntr_org_dest_cd]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}