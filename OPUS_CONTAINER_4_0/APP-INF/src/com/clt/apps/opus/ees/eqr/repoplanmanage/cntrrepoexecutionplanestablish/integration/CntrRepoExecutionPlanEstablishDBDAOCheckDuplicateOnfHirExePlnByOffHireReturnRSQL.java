/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOCheckDuplicateOnfHirExePlnByOffHireReturnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.12.03 정은호
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

public class CntrRepoExecutionPlanEstablishDBDAOCheckDuplicateOnfHirExePlnByOffHireReturnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 직반납 관련 요청된 데이터 중복 검색 이후 
	  * REF_ID , 
	  * REF_SEQ  
	  * 를 리턴한다.
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOCheckDuplicateOnfHirExePlnByOffHireReturnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOCheckDuplicateOnfHirExePlnByOffHireReturnRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(REF_ID , 'NaN') REF_ID" ).append("\n"); 
		query.append(",   NVL(REF_SEQ , -1) REF_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.REF_ID" ).append("\n"); 
		query.append(",   NVL((" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(S.REF_SEQ)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF S" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("S.REPO_PLN_ID   = A.REPO_PLN_ID" ).append("\n"); 
		query.append("AND S.PLN_YRWK  = A.PLN_YRWK" ).append("\n"); 
		query.append("AND S.PLN_SEQ   = A.PLN_SEQ" ).append("\n"); 
		query.append("AND S.REF_ID    = A.REF_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") , -1 ) REF_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_EXE_PLN A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SUBSTR(A.REF_ID , 1 , LENGTH(A.REF_ID) - 4) = SUBSTR(@[ref_id] , 1 , LENGTH(@[ref_id]) - 4)" ).append("\n"); 
		query.append("AND	A.REPO_PLN_ID 	= @[repo_pln_id]" ).append("\n"); 
		query.append("AND	A.PLN_YRWK 		= @[pln_yrwk]" ).append("\n"); 
		query.append("AND A.FM_YD_CD      = @[fm_yd_cd]" ).append("\n"); 
		query.append("AND A.FM_LOC_DT     = @[fm_loc_dt]" ).append("\n"); 
		query.append("AND A.TO_YD_CD      = @[to_yd_cd]" ).append("\n"); 
		query.append("AND A.TO_LOC_DT     = @[to_loc_dt]" ).append("\n"); 
		query.append("AND A.UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("REF_ID DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}