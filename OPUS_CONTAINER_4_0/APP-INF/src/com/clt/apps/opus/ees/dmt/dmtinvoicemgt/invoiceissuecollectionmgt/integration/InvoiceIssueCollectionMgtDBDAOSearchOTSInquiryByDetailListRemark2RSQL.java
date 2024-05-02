/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemark2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.29
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.29 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemark2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemark2RSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemark2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_usr_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tftp2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemark2RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SH_ADDR1       ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_ADDR2       ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_ADDR3       ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N1ST_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N2ND_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N3RD_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N4TH_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N5TH_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N6TH_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N7TH_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N8TH_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N9TH_MSG ,' ')||'|'||" ).append("\n"); 
		query.append("NVL(SH_HD_N10TH_MSG,' ')||'|'||" ).append("\n"); 
		query.append("NVL((SELECT BIL_TO_LOC_DIV_CD FROM DMT_OFC_SH_OPT WHERE OFC_CD = @[h_usr_off]),'L')||'|'||" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT AA.CSTMZ_TIT_DESC FROM DMT_CSTMZ_TIT_OPT AA, DMT_CSTMZ_TIT_TRF_OPT BB" ).append("\n"); 
		query.append("WHERE AA.OFC_CD = BB.OFC_CD(+) AND AA.CR_TERM_SEQ = BB.CR_TERM_SEQ(+) AND AA.OFC_CD = @[h_usr_off]" ).append("\n"); 
		query.append("AND BB.DMDT_TRF_CD = @[tftp2] AND AA.DMDT_SH_TP_CD = 'O'" ).append("\n"); 
		query.append("),'STATEMENT OF ACCOUNT')" ).append("\n"); 
		query.append("FROM DUAL)||'|'||" ).append("\n"); 
		query.append("NVL((SELECT CUST_REF_PRN_FLG FROM DMT_OFC_SH_OPT WHERE OFC_CD = @[h_usr_off]),'Y')||'|'||" ).append("\n"); 
		query.append("NVL((SELECT PHN_FAX_PRN_FLG FROM DMT_OFC_SH_OPT WHERE OFC_CD = @[h_usr_off]),'Y')||'|'||" ).append("\n"); 
		query.append("NVL((SELECT CUST_VAT_PRN_FLG FROM DMT_OFC_SH_OPT WHERE OFC_CD = @[h_usr_off]),'Y') AS XXX" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_SH_SET" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("DMDT_SH_TP_CD ='O'" ).append("\n"); 
		query.append("AND     OFC_CD = @[h_usr_off]" ).append("\n"); 
		query.append("AND     DMDT_TRF_CD = @[tftp2]" ).append("\n"); 

	}
}