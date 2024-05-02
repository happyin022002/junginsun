/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchSoCancelCheckCntrRepoPlnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    DECODE(COUNT(*), 0, 'Y', 'N') EXEFLG -- 'Y' 삭제가능 'N' 삭제불가능 	" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    EQR_REPO_EXE_SO_IF                    								" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    REPO_PLN_ID = @[repo_pln_id]      												" ).append("\n"); 
		query.append("    AND   PLN_YRWK   = @[pln_yrwk]    												" ).append("\n"); 
		query.append("    AND   PLN_SEQ    = @[pln_seq]         												" ).append("\n"); 
		query.append("    AND   REF_ID     = @[ref_id]          											" ).append("\n"); 
		query.append("    								" ).append("\n"); 
		query.append("    AND   TRSP_SO_STS_CD NOT IN ('P', 'D')" ).append("\n"); 

	}
}