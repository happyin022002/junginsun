/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOPrintComCsrAgmtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOPrintComCsrAgmtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Info List
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOPrintComCsrAgmtInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOPrintComCsrAgmtInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.AGMT_DOC_NO l_assetcd, " ).append("\n"); 
		query.append("	   A.AGMT_DOC_DESC l_document_title" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_AGMT_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND (H.CSR_NO, H.VNDR_SEQ, H.INV_NO) IN (" ).append("\n"); 
		query.append("    SELECT DISTINCT A.CSR_NO, A.VNDR_NO, D.ATTR_CTNT1 INV_NO" ).append("\n"); 
		query.append("    FROM AP_INV_HDR A, AP_INV_DTRB D" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("    AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("    AND A.SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD IN ('C','A','P')" ).append("\n"); 
		query.append("AND H.TML_INV_RJCT_STS_CD IN ('NL','RL')" ).append("\n"); 
		query.append("AND D.TML_AGMT_OFC_CTY_CD = A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND D.TML_AGMT_SEQ = A.TML_AGMT_SEQ" ).append("\n"); 
		query.append("AND D.TML_AGMT_VER_NO = A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND A.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("AND A.AGMT_DOC_NO IS NOT NULL" ).append("\n"); 

	}
}