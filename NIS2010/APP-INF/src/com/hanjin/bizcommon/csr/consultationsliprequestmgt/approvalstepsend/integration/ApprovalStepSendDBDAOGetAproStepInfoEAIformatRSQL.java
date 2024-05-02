/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalStepSendDBDAOGetAproStepInfoEAIformatRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.14 
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

public class ApprovalStepSendDBDAOGetAproStepInfoEAIformatRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAI 형식에 맞게 AproStep 상세 정보 조회
	  * </pre>
	  */
	public ApprovalStepSendDBDAOGetAproStepInfoEAIformatRSQL(){
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
		query.append("FileName : ApprovalStepSendDBDAOGetAproStepInfoEAIformatRSQL").append("\n"); 
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
		query.append("COUNT(A.CSR_NO) OVER (PARTITION BY A.CSR_NO) TTL_ROW_KNT," ).append("\n"); 
		query.append("ROWNUM              ROW_KNT," ).append("\n"); 
		query.append("A.CSR_NO            CSR_NO," ).append("\n"); 
		query.append("A.CSR_TP_CD         CSR_TP_CD," ).append("\n"); 
		query.append("A.SRC_CTNT          SRC_CTNT," ).append("\n"); 
		query.append("X.APRO_DT           APRO_DT," ).append("\n"); 
		query.append("X.APRO_OFC_CD       APRO_OFC_CD," ).append("\n"); 
		query.append("X.APRO_USR_ID       APRO_USR_ID," ).append("\n"); 
		query.append("''                  ATTR_CTNT1," ).append("\n"); 
		query.append("''                  ATTR_CTNT2," ).append("\n"); 
		query.append("''                  ATTR_CTNT3," ).append("\n"); 
		query.append("''                  ATTR_CTNT4," ).append("\n"); 
		query.append("''                  ATTR_CTNT5" ).append("\n"); 
		query.append("FROM AP_INV_HDR A, (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.CSR_NO, H.CRNT_APRO_SEQ, R.APRO_RQST_SEQ," ).append("\n"); 
		query.append("TO_CHAR(R.APRO_DT,'YYYYMMDD') APRO_DT, R.APRO_OFC_CD, R.APRO_USR_ID" ).append("\n"); 
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
		query.append("ORDER BY D.CSR_NO, R.APRO_RQST_SEQ" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CSR_NO = X.CSR_NO" ).append("\n"); 
		query.append("AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND A.IF_FLG IS NOT NULL" ).append("\n"); 
		query.append("AND A.IF_DT IS NOT NULL" ).append("\n"); 

	}
}