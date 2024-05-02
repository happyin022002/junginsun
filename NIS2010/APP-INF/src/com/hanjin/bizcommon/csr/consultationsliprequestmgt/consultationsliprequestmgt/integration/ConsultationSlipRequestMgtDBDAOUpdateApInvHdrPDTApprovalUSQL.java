/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOUpdateApInvHdrPDTApprovalUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOUpdateApInvHdrPDTApprovalUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_INV_HDR 부수작업
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOUpdateApInvHdrPDTApprovalUSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration ").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOUpdateApInvHdrPDTApprovalUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR A" ).append("\n"); 
		query.append("SET ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT,1,6), CSR_USD_AMT = AP_COM_GET_USD_XCH_AMT_FNC(A.CSR_CURR_CD, A.CSR_AMT, SUBSTR(A.GL_DT,1,6))" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}