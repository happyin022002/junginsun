/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyCsrHeaderApInvHdrInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyCsrHeaderApInvHdrInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_INV_HDR 데이터를 업데이트한다.
	  * 
	  * 20141017 수정 : approved_yn 가 Y 이면 기존Approval로직 사용 즉, Approved 단계임
	  * pproved_yn 가 N 이면 기존Approval로직 사용안함 즉, GW결재라인요청상태임 > Approval 단계임
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyCsrHeaderApInvHdrInfoUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOModifyCsrHeaderApInvHdrInfoUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR" ).append("\n"); 
		query.append("   SET IF_DT      = SYSDATE," ).append("\n"); 
		query.append("	   ACCT_XCH_RT_YRMON = SUBSTR(GL_DT,1,6)," ).append("\n"); 
		query.append("       CSR_USD_AMT = AP_COM_GET_USD_XCH_AMT_FNC(CSR_CURR_CD, CSR_AMT, SUBSTR(GL_DT,1,6))," ).append("\n"); 
		query.append("#if (${approved_yn} == 'Y')" ).append("\n"); 
		query.append("  	   IF_ERR_RSN = 'Approval Request!'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  	   IF_ERR_RSN = 'Requesting Approval'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE CSR_NO     = @[csr_no] " ).append("\n"); 

	}
}