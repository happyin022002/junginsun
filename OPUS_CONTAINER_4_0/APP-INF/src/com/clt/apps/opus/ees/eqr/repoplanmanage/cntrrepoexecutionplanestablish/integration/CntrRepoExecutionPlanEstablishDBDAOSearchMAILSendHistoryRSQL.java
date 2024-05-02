/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchMAILSendHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2010.01.11 정은호
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchMAILSendHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_FAX_SND_INFO 테이블에서 MAIL SEND HISTORY 조회
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchMAILSendHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_appl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchMAILSendHistoryRSQL").append("\n"); 
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
		query.append("DISTINCT TRIM(TO_CHAR(TO_EML_CTNT)) VALUE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_EML_SND_INFO A" ).append("\n"); 
		query.append(",	COM_RPT_DSGN_XPT_INFO B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.EML_SND_NO = B.EML_SND_NO" ).append("\n"); 
		query.append("AND A.RD_SUB_SYS_CD = 'EQR'" ).append("\n"); 
		query.append("AND B.RD_APPL_CD	=  @[rd_appl_cd]" ).append("\n"); 
		query.append("AND B.CRE_USR_ID 	=  @[user_id]" ).append("\n"); 

	}
}