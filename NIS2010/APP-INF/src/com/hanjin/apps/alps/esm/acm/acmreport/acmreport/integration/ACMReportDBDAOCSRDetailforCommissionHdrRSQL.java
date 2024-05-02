/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMReportDBDAOCSRDetailforCommissionHdrRSQL.java
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

public class ACMReportDBDAOCSRDetailforCommissionHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSRDetailforCommissionHdr
	  * 
	  * 2014.06.11 박다은 [CHM-201428456] Comm 모듈의 ACM 발행 CSR Detail 기능 로직 변경
	  * </pre>
	  */
	public ACMReportDBDAOCSRDetailforCommissionHdrRSQL(){
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
		query.append("FileName : ACMReportDBDAOCSRDetailforCommissionHdrRSQL").append("\n"); 
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
		query.append("	A.TJ_OFC_CD AS TJ_OFC_CD," ).append("\n"); 
		query.append("    TO_CHAR(TO_DATE(A.INV_DT,'YYYYMMDD'),'YYYY-MM-DD') AS INV_DT," ).append("\n"); 
		query.append("    B.VNDR_CNT_CD||TO_CHAR(B.VNDR_SEQ,'FM000000') AS VNDR_SEQ," ).append("\n"); 
		query.append("    B.VNDR_LOCL_LANG_NM AS VNDR_LOCL_LANG_NM," ).append("\n"); 
		query.append("    (SELECT COUNT(DISTINCT ATTR_CTNT1) FROM AP_INV_DTRB WHERE CSR_NO = A.CSR_NO) AS ATTR_CTNT1," ).append("\n"); 
		query.append("    CSR_CURR_CD AS CSR_CURR_CD," ).append("\n"); 
		query.append("    CSR_AMT     AS CSR_AMT," ).append("\n"); 
		query.append("    TO_CHAR(TO_DATE(INV_TERM_DT,'YYYYMMDD'),'YYYY-MM-DD') AS INV_TERM_DT," ).append("\n"); 
		query.append("	ATTR_CTNT2	AS ATTR_CTNT2" ).append("\n"); 
		query.append("FROM AP_INV_HDR A," ).append("\n"); 
		query.append("    MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no] --//:csrNo" ).append("\n"); 
		query.append("AND A.VNDR_NO = B.VNDR_SEQ(+)" ).append("\n"); 

	}
}