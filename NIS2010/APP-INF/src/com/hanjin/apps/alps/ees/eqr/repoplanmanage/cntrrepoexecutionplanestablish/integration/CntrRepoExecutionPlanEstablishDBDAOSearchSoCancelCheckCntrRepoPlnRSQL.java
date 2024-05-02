/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchSoCancelCheckCntrRepoPlnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.07 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchSoCancelCheckCntrRepoPlnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO Cancel 이 가능한지를 확인
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchSoCancelCheckCntrRepoPlnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchSoCancelCheckCntrRepoPlnRSQL").append("\n"); 
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
		query.append("DECODE(COUNT(*), 0, 'Y', 'N') EXEFLG -- 'Y' 삭제가능 'N' 삭제불가능" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND   PLN_YRWK   = @[pln_yrwk]" ).append("\n"); 
		query.append("AND   PLN_SEQ    = @[pln_seq]" ).append("\n"); 
		query.append("AND   REF_ID     = @[ref_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND   WO_EXE_FLG  = 'Y'" ).append("\n"); 
		query.append("-- 한개라도 WO_EXE_FLG  = 'Y' 이면 삭제불가" ).append("\n"); 
		query.append("-- modified by shin yongchan - 20081020" ).append("\n"); 
		query.append("-- CSR NO :" ).append("\n"); 
		query.append("-- 'P' - S/O Send 최초" ).append("\n"); 
		query.append("-- 'D' - TRS모듈에서 W/O 시도후 취소 상태" ).append("\n"); 
		query.append("-- P, D 모두 S/O Cancel 대상으로 포함" ).append("\n"); 
		query.append("--AND   TRSP_SO_STS_CD <> 'P'" ).append("\n"); 
		query.append("AND   TRSP_SO_STS_CD NOT IN ('P', 'D')" ).append("\n"); 

	}
}