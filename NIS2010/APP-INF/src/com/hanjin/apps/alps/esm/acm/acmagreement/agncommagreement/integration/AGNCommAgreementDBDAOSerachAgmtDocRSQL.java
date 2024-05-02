/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommAgreementDBDAOSerachAgmtDocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOSerachAgmtDocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014-10-11 / 함대성
	  * GW에 EAI전송하기위한 ACM 계약서 정보 가져오기
	  * </pre>
	  */
	public AGNCommAgreementDBDAOSerachAgmtDocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_csrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOSerachAgmtDocRSQL").append("\n"); 
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
		query.append("SELECT AGN_CD, AGN_AGMT_NO, " ).append("\n"); 
		query.append("	   AGMT_DOC_NO, AGMT_DOC_DESC" ).append("\n"); 
		query.append("  FROM ACM_AGN_AGMT_MST" ).append("\n"); 
		query.append("WHERE (AGN_CD,  AGN_AGMT_NO) IN ( " ).append("\n"); 
		query.append("                                  SELECT AGN_CD, AGN_AGMT_NO" ).append("\n"); 
		query.append("                                    FROM ACM_AGN_COMM A" ).append("\n"); 
		query.append("                                   WHERE 1=1" ).append("\n"); 
		query.append("                                     AND EXISTS (" ).append("\n"); 
		query.append("                                                  SELECT 'X'" ).append("\n"); 
		query.append("                                                    FROM AP_INV_HDR B" ).append("\n"); 
		query.append("                                                   WHERE A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("                                                     AND B.CSR_NO = @[h_csrno]" ).append("\n"); 
		query.append("													 AND B.RQST_APRO_STEP_FLG = 'Y'" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                   GROUP BY AGN_CD, AGN_AGMT_NO" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND AGMT_DOC_NO IS NOT NULL" ).append("\n"); 

	}
}