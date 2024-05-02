/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalStepSendDBDAOGetAproStepInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.13 
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

public class ApprovalStepSendDBDAOGetAproStepInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Step info 조회
	  * </pre>
	  */
	public ApprovalStepSendDBDAOGetAproStepInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration").append("\n"); 
		query.append("FileName : ApprovalStepSendDBDAOGetAproStepInfoRSQL").append("\n"); 
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
		query.append("D.CSR_NO, TO_CHAR(R.APRO_DT,'YYYYMMDD') APRO_DT, R.APRO_OFC_CD, R.APRO_USR_ID" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.CRNT_APRO_SEQ = (SELECT MAX(X.APRO_RQST_SEQ)" ).append("\n"); 
		query.append("FROM COM_APRO_RQST_ROUT X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.APRO_RQST_NO = H.APRO_RQST_NO)" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END CHK_VAL" ).append("\n"); 
		query.append("FROM COM_APRO_CSR_DTL D, COM_APRO_RQST_HDR H, COM_APRO_RQST_ROUT R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.APRO_RQST_NO = H.APRO_RQST_NO" ).append("\n"); 
		query.append("AND D.CSR_NO =  @[csr_no]" ).append("\n"); 
		query.append("--AND H.APRO_KND_CD = 'CSR'" ).append("\n"); 
		query.append("AND H.APSTS_CD = 'C'" ).append("\n"); 
		query.append("AND H.APRO_RQST_NO = R.APRO_RQST_NO" ).append("\n"); 
		query.append("AND R.APRO_RQST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(X.APRO_RQST_SEQ)" ).append("\n"); 
		query.append("FROM COM_APRO_RQST_ROUT X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.APRO_RQST_NO = H.APRO_RQST_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}