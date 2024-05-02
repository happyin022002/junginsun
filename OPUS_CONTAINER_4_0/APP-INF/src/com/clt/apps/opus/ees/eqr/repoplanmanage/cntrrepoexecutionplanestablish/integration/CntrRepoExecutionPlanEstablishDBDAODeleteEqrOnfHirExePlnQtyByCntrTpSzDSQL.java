/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAODeleteEqrOnfHirExePlnQtyByCntrTpSzDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.21 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAODeleteEqrOnfHirExePlnQtyByCntrTpSzDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS OFF Hire 직반납시 전체 건수 이동시  EQR_ONF_HIR_EXE_PLN_QTY 삭제
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAODeleteEqrOnfHirExePlnQtyByCntrTpSzDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAODeleteEqrOnfHirExePlnQtyByCntrTpSzDSQL").append("\n"); 
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
		query.append("DELETE FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_EXE_PLN_QTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REF_ID = @[ref_id]" ).append("\n"); 
		query.append("AND	REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND	PLN_YRWK = @[pln_yrwk]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}