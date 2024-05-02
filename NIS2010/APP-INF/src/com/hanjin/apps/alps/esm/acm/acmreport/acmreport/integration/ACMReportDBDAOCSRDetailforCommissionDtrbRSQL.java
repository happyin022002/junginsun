/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMReportDBDAOCSRDetailforCommissionDtrbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOCSRDetailforCommissionDtrbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSRDetailforCommissionDtrb
	  * 
	  * 2014.06.11 박다은 [CHM-201428456] Comm 모듈의 ACM 발행 CSR Detail 기능 로직 변경
	  * </pre>
	  */
	public ACMReportDBDAOCSRDetailforCommissionDtrbRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmreport.acmreport.integration").append("\n"); 
		query.append("FileName : ACMReportDBDAOCSRDetailforCommissionDtrbRSQL").append("\n"); 
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
		query.append("    INV_NO," ).append("\n"); 
		query.append("    NET_AMT," ).append("\n"); 
		query.append("    TAX_AMT," ).append("\n"); 
		query.append("    TOT_AMT" ).append("\n"); 
		query.append("FROM (SELECT ATTR_CTNT1 AS INV_NO," ).append("\n"); 
		query.append("        SUM(DECODE(DTRB_COA_ACCT_CD,'111821',0,INV_AMT)) NET_AMT," ).append("\n"); 
		query.append("        SUM(DECODE(DTRB_COA_ACCT_CD,'111821',INV_AMT,0)) TAX_AMT," ).append("\n"); 
		query.append("        SUM(INV_AMT) TOT_AMT" ).append("\n"); 
		query.append("    FROM AP_INV_DTRB" ).append("\n"); 
		query.append("    WHERE CSR_NO = @[csr_no] -- //:csrNo" ).append("\n"); 
		query.append("    GROUP BY ATTR_CTNT1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}