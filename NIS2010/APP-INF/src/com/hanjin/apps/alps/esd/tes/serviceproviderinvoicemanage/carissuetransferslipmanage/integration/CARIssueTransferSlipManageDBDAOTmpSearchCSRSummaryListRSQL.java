/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.12 
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

public class CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TmpSearchCSRSummaryList
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL(){
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
		query.append("FileName : CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL").append("\n"); 
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
		query.append("select tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", tml_so_seq" ).append("\n"); 
		query.append(", inv_no" ).append("\n"); 
		query.append(", vndr_seq" ).append("\n"); 
		query.append(", ttl_inv_amt" ).append("\n"); 
		query.append(", vat_amt" ).append("\n"); 
		query.append(", nvl(whld_tax_amt,0) whld_tax_amt" ).append("\n"); 
		query.append(", (ttl_inv_amt+vat_amt-nvl(whld_tax_amt,0)) inv_total_amt" ).append("\n"); 
		query.append(", tml_inv_tp_cd" ).append("\n"); 
		query.append(", H.EDI_FLG" ).append("\n"); 
		query.append(",   NVL(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.EDI_FLG = 'Y'" ).append("\n"); 
		query.append("THEN  (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN F.FILE_SEQ IS NOT NULL AND F.ORG_FILE_NM IS NOT NULL AND F.FILE_SAV_ID IS NOT NULL AND C.FILE_SAV_ID IS NOT NULL" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END FILE_CHK" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR E, TES_EDI_SO_FILE F, COM_UPLD_FILE C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND E.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND E.TML_SO_SEQ = H.TML_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND ((E.TML_EDI_SO_OFC_CTY_CD = F.TML_EDI_SO_OFC_CTY_CD AND E.TML_EDI_SO_SEQ = F.TML_EDI_SO_SEQ)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(E.TML_SO_OFC_CTY_CD = F.TML_SO_OFC_CTY_CD AND E.TML_SO_SEQ = F.TML_SO_SEQ))" ).append("\n"); 
		query.append("AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END,'N') FILE_CHK" ).append("\n"); 
		query.append("from tes_tml_so_hdr H" ).append("\n"); 
		query.append("where csr_no = @[csr_no]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}