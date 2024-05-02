/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommAgreementDBDAOSearchAgmtAttach2RSQL.java
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

public class AGNCommAgreementDBDAOSearchAgmtAttach2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.11.04 ACM CSR I/F용
	  * </pre>
	  */
	public AGNCommAgreementDBDAOSearchAgmtAttach2RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOSearchAgmtAttach2RSQL").append("\n"); 
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
		query.append("SELECT C.CSR_NO AS CSR_NO," ).append("\n"); 
		query.append("       B.AUD_NO AS INV_NO," ).append("\n"); 
		query.append("       C.VNDR_NO       AS VNDR_SEQ," ).append("\n"); 
		query.append("       AGMT_DOC_NO AS L_ASSETCD, " ).append("\n"); 
		query.append("       AGMT_DOC_DESC AS L_DOCUMENT_TITLE" ).append("\n"); 
		query.append("  FROM ACM_AGN_AGMT_MST A, ACM_AGN_COMM B, AP_INV_HDR C" ).append("\n"); 
		query.append("WHERE A.AGN_CD = B.AGN_CD(+)" ).append("\n"); 
		query.append("    AND A.AGN_AGMT_NO = B.AGN_AGMT_NO(+)" ).append("\n"); 
		query.append("    AND B.CSR_NO = C.CSR_NO" ).append("\n"); 
		query.append("    AND B.CSR_NO = @[csr_no] " ).append("\n"); 
		query.append("    AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    --AND AGMT_DOC_NO IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY C.CSR_NO, B.AUD_NO, C.VNDR_NO, A.AGMT_DOC_DESC, A.AGMT_DOC_NO" ).append("\n"); 
		query.append("ORDER BY C.CSR_NO, B.AUD_NO, C.VNDR_NO, A.AGMT_DOC_DESC" ).append("\n"); 

	}
}