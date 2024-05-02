/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOCSRDetailforCommissionDtrbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOCSRDetailforCommissionDtrbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT-0043 화면 조회
	  * </pre>
	  */
	public AGTAuditDBDAOCSRDetailforCommissionDtrbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOCSRDetailforCommissionDtrbRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM SEQ," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("NET_AMT," ).append("\n"); 
		query.append("TAX_AMT," ).append("\n"); 
		query.append("TOT_AMT" ).append("\n"); 
		query.append("FROM (SELECT ATTR_CTNT1 AS INV_NO," ).append("\n"); 
		query.append("SUM(DECODE(DTRB_COA_ACCT_CD,'111821',0,INV_AMT)) NET_AMT," ).append("\n"); 
		query.append("SUM(DECODE(DTRB_COA_ACCT_CD,'111821',INV_AMT,0)) TAX_AMT," ).append("\n"); 
		query.append("SUM(INV_AMT) TOT_AMT" ).append("\n"); 
		query.append("FROM AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no] -- //:csrNo" ).append("\n"); 
		query.append("GROUP BY ATTR_CTNT1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}