/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOInsertBkgCancelHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.17 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOInsertBkgCancelHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_BKG_CXL_HIS 테이블에 bkg cancel history 입력
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOInsertBkgCancelHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOInsertBkgCancelHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO	EQR_BKG_CXL_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN_YRWK" ).append("\n"); 
		query.append(",PLN_SEQ" ).append("\n"); 
		query.append(",REF_ID" ).append("\n"); 
		query.append(",MTY_BKG_NO" ).append("\n"); 
		query.append(",TRSP_MOD_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	 DISTINCT REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN_YRWK" ).append("\n"); 
		query.append(",PLN_SEQ" ).append("\n"); 
		query.append(",REF_ID" ).append("\n"); 
		query.append(",@[mty_bkg_no] MTY_BKG_NO" ).append("\n"); 
		query.append(",TRSP_MOD_CD" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM	${table_name}" ).append("\n"); 
		query.append("WHERE	MTY_BKG_NO	= @[mty_bkg_no]" ).append("\n"); 

	}
}