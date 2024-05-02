/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOChkBkgVolumeTargetExeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.12.01 이행지
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

public class CntrRepoExecutionPlanEstablishDBDAOChkBkgVolumeTargetExeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bkg No.로 해당 실행 테이블 조회하기.
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOChkBkgVolumeTargetExeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOChkBkgVolumeTargetExeRSQL").append("\n"); 
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
		query.append("SELECT	 REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN_YRWK" ).append("\n"); 
		query.append(",PLN_SEQ" ).append("\n"); 
		query.append(",REF_ID" ).append("\n"); 
		query.append(",FM_YD_CD" ).append("\n"); 
		query.append(",TO_YD_CD" ).append("\n"); 
		query.append(",TRSP_MOD_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",FM_YD_CD" ).append("\n"); 
		query.append(",TO_YD_CD" ).append("\n"); 
		query.append("FROM	${table_name}" ).append("\n"); 
		query.append("WHERE	MTY_BKG_NO	= @[mty_bkg_no]" ).append("\n"); 

	}
}