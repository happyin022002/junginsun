/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceExcelPrintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2009.10.28 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceExcelPrintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Invoice 내역을 EXCEL 또는 PDF 파일로 출력한다.
	  * </pre>
	  */
	public TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceExcelPrintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration").append("\n"); 
		query.append("FileName : TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceExcelPrintRSQL").append("\n"); 
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
		query.append("SELECT   YD_CD" ).append("\n"); 
		query.append(",YD_NM" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",VAT_AMT" ).append("\n"); 
		query.append(",TTL_INV_AMT" ).append("\n"); 
		query.append(",TTL_AMT" ).append("\n"); 
		query.append(",ISS_DT" ).append("\n"); 
		query.append(",RCV_DT" ).append("\n"); 
		query.append(",TML_INV_STS_CD" ).append("\n"); 
		query.append(",TML_INV_STS_NM" ).append("\n"); 
		query.append(",RJCT_STS" ).append("\n"); 
		query.append(",TML_INV_RJCT_STS_NM" ).append("\n"); 
		query.append(",INV_RJCT_RMK" ).append("\n"); 
		query.append(",TES_TML_SO_HDR_CSR_NO" ).append("\n"); 
		query.append(",AP_INV_HDR_CSR_NO" ).append("\n"); 
		query.append(",INV_PAY_MZD_CD" ).append("\n"); 
		query.append(",INV_CHK_TRNS_NO" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append("FROM (SELECT  H.YD_CD" ).append("\n"); 
		query.append(",(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = H.YD_CD) YD_NM" ).append("\n"); 
		query.append(",H.INV_NO" ).append("\n"); 
		query.append(",H.CURR_CD" ).append("\n"); 
		query.append(",H.VAT_AMT" ).append("\n"); 
		query.append(",H.TTL_INV_AMT" ).append("\n"); 
		query.append(",NVL (H.VAT_AMT, 0) + NVL (H.TTL_INV_AMT, 0) TTL_AMT" ).append("\n"); 
		query.append(",TO_CHAR (H.ISS_DT, 'YYYY-MM-DD HH24:MI:SS') ISS_DT" ).append("\n"); 
		query.append(",TO_CHAR (H.RCV_DT, 'YYYY-MM-DD HH24:MI:SS') RCV_DT" ).append("\n"); 
		query.append(",H.TML_INV_STS_CD" ).append("\n"); 
		query.append(",DECODE (H.TML_INV_STS_CD,'R', 'AUDITING'" ).append("\n"); 
		query.append(",'C', 'AUDITING'" ).append("\n"); 
		query.append(",'A', 'AUDITING'" ).append("\n"); 
		query.append(",'P', 'PROCESSING'" ).append("\n"); 
		query.append(",'D', 'PAID'      ) TML_INV_STS_NM" ).append("\n"); 
		query.append(",DECODE(H.TML_INV_RJCT_STS_CD,'NL','N'" ).append("\n"); 
		query.append(",NULL,'N'" ).append("\n"); 
		query.append(",'','N','Y'   ) RJCT_STS" ).append("\n"); 
		query.append(",DECODE(H.TML_INV_RJCT_STS_CD,'NL','Normal'" ).append("\n"); 
		query.append(",'RJ','Rejected'" ).append("\n"); 
		query.append(",'RL','Normal') TML_INV_RJCT_STS_NM" ).append("\n"); 
		query.append(",H.INV_RJCT_RMK" ).append("\n"); 
		query.append(",H.CSR_NO TES_TML_SO_HDR_CSR_NO" ).append("\n"); 
		query.append(",A.CSR_NO AP_INV_HDR_CSR_NO" ).append("\n"); 
		query.append(",A.PAY_MZD_LU_CD INV_PAY_MZD_CD" ).append("\n"); 
		query.append(",A.FTU_USE_CTNT1 INV_CHK_TRNS_NO" ).append("\n"); 
		query.append(",H.VNDR_SEQ" ).append("\n"); 
		query.append("FROM  TES_TML_SO_HDR H" ).append("\n"); 
		query.append(",AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL (h.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.CSR_NO = A.CSR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($r_serviceOrderNo.size() > 0)" ).append("\n"); 
		query.append("AND (H.TML_SO_OFC_CTY_CD,H.TML_SO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach(${sonoKey} in ${r_serviceOrderNo})" ).append("\n"); 
		query.append("#if(${velocityCount} < $r_serviceOrderNo.size())" ).append("\n"); 
		query.append("(SUBSTR('${sonoKey}',0,3),TO_NUMBER(SUBSTR('${sonoKey}',4,LENGTH('${sonoKey}'))))," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(SUBSTR('${sonoKey}',0,3),TO_NUMBER(SUBSTR('${sonoKey}',4,LENGTH('${sonoKey}'))))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  E.YD_CD" ).append("\n"); 
		query.append(",(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = E.YD_CD) YD_NM" ).append("\n"); 
		query.append(",E.INV_NO" ).append("\n"); 
		query.append(",E.CURR_CD" ).append("\n"); 
		query.append(",E.VAT_AMT" ).append("\n"); 
		query.append(",E.TTL_INV_AMT" ).append("\n"); 
		query.append(",NVL (E.VAT_AMT, 0) + NVL (E.TTL_INV_AMT, 0) TTL_AMT" ).append("\n"); 
		query.append(",NULL ISS_DT" ).append("\n"); 
		query.append(",TO_CHAR (E.RCV_DT, 'YYYY-MM-DD HH24:MI:SS') RCV_DT" ).append("\n"); 
		query.append(",E.TML_INV_STS_CD" ).append("\n"); 
		query.append(",DECODE(E.TML_INV_STS_CD,'R','EDI Received') TML_INV_STS_NM" ).append("\n"); 
		query.append(",DECODE(E.TML_INV_RJCT_STS_CD,'NL','N'" ).append("\n"); 
		query.append(",NULL,'N'" ).append("\n"); 
		query.append(",'','N','Y') RJCT_STS" ).append("\n"); 
		query.append(",DECODE(E.TML_INV_RJCT_STS_CD,'NL','Normal'" ).append("\n"); 
		query.append(",'RJ','Rejected') TML_INV_RJCT_STS_NM" ).append("\n"); 
		query.append(",E.INV_RJCT_RMK" ).append("\n"); 
		query.append(",NULL TES_TML_SO_HDR_CSR_NO" ).append("\n"); 
		query.append(",NULL AP_INV_HDR_CSR_NO" ).append("\n"); 
		query.append(",NULL INV_PAY_MZD_CD" ).append("\n"); 
		query.append(",NULL INV_CHK_TRNS_NO" ).append("\n"); 
		query.append(",E.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR E" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(E.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND E.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND E.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($r_serviceOrderNo.size() > 0)" ).append("\n"); 
		query.append("AND (E.TML_SO_OFC_CTY_CD,E.TML_SO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach(${sonoKey} in ${r_serviceOrderNo})" ).append("\n"); 
		query.append("#if(${velocityCount} < $r_serviceOrderNo.size())" ).append("\n"); 
		query.append("(SUBSTR('${sonoKey}',0,3),TO_NUMBER(SUBSTR('${sonoKey}',4,LENGTH('${sonoKey}'))))," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(SUBSTR('${sonoKey}',0,3),TO_NUMBER(SUBSTR('${sonoKey}',4,LENGTH('${sonoKey}'))))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY VNDR_SEQ, INV_NO DESC" ).append("\n"); 

	}
}