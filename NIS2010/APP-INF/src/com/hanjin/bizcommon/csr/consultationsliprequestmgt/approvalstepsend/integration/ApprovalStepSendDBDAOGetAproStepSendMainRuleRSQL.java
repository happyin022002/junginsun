/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalStepSendDBDAOGetAproStepSendMainRuleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalStepSendDBDAOGetAproStepSendMainRuleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AproStep 대상 I/F 선정 RULE 조회
	  * </pre>
	  */
	public ApprovalStepSendDBDAOGetAproStepSendMainRuleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration").append("\n"); 
		query.append("FileName : ApprovalStepSendDBDAOGetAproStepSendMainRuleRSQL").append("\n"); 
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
		query.append("SRC_CTNT" ).append("\n"); 
		query.append(", SUB_SYS_ID" ).append("\n"); 
		query.append(", EXE_ACT_TP_CD" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", TO_CHAR(CFM_DT,'YYYYMMDD') CFM_DT" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", TO_CHAR(DELT_DT,'YYYYMMDD') DELT_DT" ).append("\n"); 
		query.append(", EXE_ROW_KNT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM COM_APRO_SND_MN_RULE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EXE_ACT_TP_CD = @[act_tp_cd]" ).append("\n"); 
		query.append("AND NVL(CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--AND SRC_CTNT IN ('SO_TERMINAL')--,'SO_TRANS')" ).append("\n"); 

	}
}