/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOApInvDTRBLineNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.08.06 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOApInvDTRBLineNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOApInvDTRBLineNoRSQL(){
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
		query.append("FileName : ConsultationSlipRequestMgtDBDAOApInvDTRBLineNoRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1" ).append("\n"); 
		query.append(", DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(", DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(", ROWNUM LINE_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT DISTINCT ATTR_CTNT1" ).append("\n"); 
		query.append(", DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(", DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("FROM             AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE            CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("ORDER BY         ATTR_CTNT1" ).append("\n"); 
		query.append(", DTRB_COA_VVD_CD DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}