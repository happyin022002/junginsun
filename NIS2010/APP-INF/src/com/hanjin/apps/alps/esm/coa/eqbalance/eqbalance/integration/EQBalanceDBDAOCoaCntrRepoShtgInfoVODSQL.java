/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EQBalanceDBDAOCoaCntrRepoShtgInfoVODSQL.java
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

public class EQBalanceDBDAOCoaCntrRepoShtgInfoVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -COA_CNTR_REPO_SHTG_INFO 테이블의 삭제
	  * </pre>
	  */
	public EQBalanceDBDAOCoaCntrRepoShtgInfoVODSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.integration").append("\n"); 
		query.append("FileName : EQBalanceDBDAOCoaCntrRepoShtgInfoVODSQL").append("\n"); 
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
		query.append("DELETE COA_CNTR_REPO_SHTG_INFO" ).append("\n"); 
		query.append(" WHERE COST_YRMON    = @[cost_yrmon]" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD   = REPLACE(@[cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("   AND ECC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("   AND CNTR_ORG_DEST_CD = @[cntr_org_dest_cd]" ).append("\n"); 

	}
}