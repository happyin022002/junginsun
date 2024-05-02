/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchDupChkInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchDupChkInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * invoice 중복 체크
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchDupChkInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchDupChkInvoiceRSQL").append("\n"); 
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
		query.append("SELECT 							" ).append("\n"); 
		query.append("  A.INV_NO							" ).append("\n"); 
		query.append("  , A.INV_VNDR_SEQ					" ).append("\n"); 
		query.append("  , B.VNDR_LGL_ENG_NM AS INV_VNDR_NM		" ).append("\n"); 
		query.append("  , A.TRSP_INV_AUD_STS_CD				" ).append("\n"); 
		query.append("  , A.GEN_PAY_TERM_CD					" ).append("\n"); 
		query.append("  , TO_CHAR(A.INV_CFM_DT, 'YYYYMMDD') INV_CFM_DT	" ).append("\n"); 
		query.append("  , A.WO_VNDR_SEQ						" ).append("\n"); 
		query.append("  , C.VNDR_LGL_ENG_NM AS WO_VNDR_NM		" ).append("\n"); 
		query.append("  , A.INV_CURR_CD						" ).append("\n"); 
		query.append("  , A.INV_BZC_AMT						" ).append("\n"); 
		query.append("  , A.INV_VAT_AMT						" ).append("\n"); 
		query.append("  , A.INV_SBC_AMT" ).append("\n"); 
		query.append("  , A.INV_WHLD_TAX_AMT				" ).append("\n"); 
		query.append("  , A.INV_TTL_AMT					" ).append("\n"); 
		query.append("  , A.RGST_NO							" ).append("\n"); 
		query.append("  , A.INV_PAY_MZD_CD					" ).append("\n"); 
		query.append("  , A.INV_CHK_TRNS_NO					" ).append("\n"); 
		query.append("  , TO_CHAR(A.PAY_DT, 'YYYYMMDD') PAY_DT		" ).append("\n"); 
		query.append("  , A.INV_RJCT_FLG					" ).append("\n"); 
		query.append("  , TO_CHAR(A.INV_RCV_DT, 'YYYYMMDD') INV_RCV_DT	" ).append("\n"); 
		query.append("  , TO_CHAR(A.INV_EFF_DT, 'YYYYMMDD') INV_EFF_DT	" ).append("\n"); 
		query.append("  , TO_CHAR(A.INV_RJCT_DT, 'YYYYMMDD') INV_RJCT_DT	" ).append("\n"); 
		query.append("  , TO_CHAR(A.INV_ISS_DT, 'YYYYMMDD') INV_ISS_DT	" ).append("\n"); 
		query.append("  , A.IF_SYS_KND_CD" ).append("\n"); 
		query.append("  , A.AP_RVS_CNG_FLG" ).append("\n"); 
		query.append("  , A.IDA_CGST_AMT" ).append("\n"); 
		query.append("  , A.IDA_SGST_AMT" ).append("\n"); 
		query.append("  , A.IDA_IGST_AMT" ).append("\n"); 
		query.append("  , A.IDA_UGST_AMT				" ).append("\n"); 
		query.append(" FROM TRS_TRSP_INV_WRK A			" ).append("\n"); 
		query.append(" , MDM_VENDOR B						" ).append("\n"); 
		query.append(" , MDM_VENDOR C						" ).append("\n"); 
		query.append(" WHERE A.INV_NO = @[inv_no]				" ).append("\n"); 
		query.append(" AND A.INV_VNDR_SEQ = @[paymt_sp_cd]		" ).append("\n"); 
		query.append(" AND A.INV_VNDR_SEQ = B.VNDR_SEQ(+)		" ).append("\n"); 
		query.append(" AND A.WO_VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 

	}
}