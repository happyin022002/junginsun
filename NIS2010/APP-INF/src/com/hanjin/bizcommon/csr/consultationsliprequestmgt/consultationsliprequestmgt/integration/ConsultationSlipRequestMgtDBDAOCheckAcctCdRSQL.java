/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOCheckAcctCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOCheckAcctCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOCheckAcctCdRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOCheckAcctCdRSQL").append("\n"); 
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
		query.append("SELECT DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("LINE_SEQ," ).append("\n"); 
		query.append("LINE_NO," ).append("\n"); 
		query.append("INV_AMT," ).append("\n"); 
		query.append("FTU_USE_CTNT1" ).append("\n"); 
		query.append("FROM AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}