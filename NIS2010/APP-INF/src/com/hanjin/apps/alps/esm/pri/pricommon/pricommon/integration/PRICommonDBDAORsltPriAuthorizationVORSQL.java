/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAORsltPriAuthorizationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.02.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltPriAuthorizationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriAuthorization [PRS]
	  * </pre>
	  */
	public PRICommonDBDAORsltPriAuthorizationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltPriAuthorizationVORSQL").append("\n"); 
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
		query.append("		PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("	,	SVC_SCP_CD" ).append("\n"); 
		query.append("	,	USR_ID" ).append("\n"); 
		query.append("	,	EFF_DT" ).append("\n"); 
		query.append("	,	EXP_DT" ).append("\n"); 
		query.append("	,	CRE_USR_ID" ).append("\n"); 
		query.append("	,	CRE_DT" ).append("\n"); 
		query.append("	,	UPD_USR_ID" ).append("\n"); 
		query.append("	,	UPD_DT" ).append("\n"); 
		query.append("FROM PRI_AUTHORIZATION" ).append("\n"); 
		query.append("WHERE	PRC_CTRT_TP_CD = @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("	AND	USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("	AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN TO_CHAR(EFF_DT, 'YYYYMMDD') AND TO_CHAR(EXP_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 

	}
}