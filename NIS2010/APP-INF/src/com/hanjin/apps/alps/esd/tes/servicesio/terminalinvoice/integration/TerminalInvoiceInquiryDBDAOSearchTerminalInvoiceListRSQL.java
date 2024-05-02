/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2009.10.13 윤권영
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

public class TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Invoice를 조회한다.
	  * </pre>
	  */
	public TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_fromDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_vendorCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_invoiceStatus",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_toDt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration").append("\n"); 
		query.append("FileName : TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceListRSQL").append("\n"); 
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
		query.append(",TML_SO_OFC_CTY_CD||TML_SO_SEQ TMLSERVICEORDERNO" ).append("\n"); 
		query.append(",TML_INV_TP_CD" ).append("\n"); 
		query.append("FROM 	(SELECT H.YD_CD" ).append("\n"); 
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
		query.append(",H.TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append(",DECODE(H.TML_INV_RJCT_STS_CD,'NL','N'" ).append("\n"); 
		query.append(",NULL,'N'" ).append("\n"); 
		query.append(",'','N','Y'	  ) RJCT_STS" ).append("\n"); 
		query.append(",DECODE(H.TML_INV_RJCT_STS_CD,'RJ','Rejected','Normal') TML_INV_RJCT_STS_NM" ).append("\n"); 
		query.append(",H.INV_RJCT_RMK" ).append("\n"); 
		query.append(",H.CSR_NO TES_TML_SO_HDR_CSR_NO" ).append("\n"); 
		query.append(",A.CSR_NO AP_INV_HDR_CSR_NO" ).append("\n"); 
		query.append(",A.PAY_MZD_LU_CD INV_PAY_MZD_CD" ).append("\n"); 
		query.append(",A.FTU_USE_CTNT1 INV_CHK_TRNS_NO" ).append("\n"); 
		query.append(",H.VNDR_SEQ" ).append("\n"); 
		query.append(",H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",H.TML_SO_SEQ" ).append("\n"); 
		query.append(",H.TML_INV_TP_CD" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H ,AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL (H.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.CSR_NO = A.CSR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${r_vendorCode} != '')" ).append("\n"); 
		query.append("AND H.VNDR_SEQ = @[r_vendorCode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($r_invoiceNo.size() > 0)" ).append("\n"); 
		query.append("AND H.INV_NO IN (" ).append("\n"); 
		query.append("#foreach(${invNoKey} in ${r_invoiceNo})" ).append("\n"); 
		query.append("#if(${velocityCount} < $r_invoiceNo.size())" ).append("\n"); 
		query.append("('${invNoKey}')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("('${invNoKey}')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${r_invoiceStatus} != '')" ).append("\n"); 
		query.append("#if (${r_invoiceStatus} == 'AA')" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD IN ('R','C','A','P','D')" ).append("\n"); 
		query.append("#elseif (${r_invoiceStatus} == 'R')" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD IN ('R','C','A')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND H.TML_INV_STS_CD = @[r_invoiceStatus]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${r_fromDt} != '' && ${r_toDt} != '')" ).append("\n"); 
		query.append("#if (${r_dateGubun} == 'I')" ).append("\n"); 
		query.append("AND TO_CHAR (h.iss_dt, 'YYYYMMDD') >= @[r_fromDt]" ).append("\n"); 
		query.append("AND TO_CHAR (h.iss_dt, 'YYYYMMDD') <= @[r_toDt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND TO_CHAR (h.rcv_dt, 'YYYYMMDD') >= @[r_fromDt]" ).append("\n"); 
		query.append("AND TO_CHAR (h.rcv_dt, 'YYYYMMDD') <= @[r_toDt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append(",TO_CHAR(TO_DATE(E.ISS_DT, 'YYYY-MM-DD'),'YYYY-MM-DD') ISS_DT" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(E.RCV_DT, 'YYYY-MM-DD'),'YYYY-MM-DD') RCV_DT" ).append("\n"); 
		query.append(",E.TML_INV_STS_CD" ).append("\n"); 
		query.append(",DECODE(E.TML_INV_STS_CD,'R','EDI Received') TML_INV_STS_NM" ).append("\n"); 
		query.append(",E.TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append(",DECODE(E.TML_INV_RJCT_STS_CD,'NL','N'" ).append("\n"); 
		query.append(",NULL,'N'" ).append("\n"); 
		query.append(",'','N','Y') RJCT_STS" ).append("\n"); 
		query.append(",DECODE(E.TML_INV_RJCT_STS_CD,'NL','Normal'," ).append("\n"); 
		query.append("'AJ','Rejected') TML_INV_RJCT_STS_NM" ).append("\n"); 
		query.append(",E.INV_RJCT_RMK" ).append("\n"); 
		query.append(",NULL TES_TML_SO_HDR_CSR_NO" ).append("\n"); 
		query.append(",NULL AP_INV_HDR_CSR_NO" ).append("\n"); 
		query.append(",NULL INV_PAY_MZD_CD" ).append("\n"); 
		query.append(",NULL INV_CHK_TRNS_NO" ).append("\n"); 
		query.append(",E.VNDR_SEQ" ).append("\n"); 
		query.append(",E.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",E.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append(",E.TML_INV_TP_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR E" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND NVL (E.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND E.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND E.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${r_vendorCode} != '')" ).append("\n"); 
		query.append("AND E.VNDR_SEQ = @[r_vendorCode]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($r_invoiceNo.size() > 0)" ).append("\n"); 
		query.append("AND E.INV_NO IN (" ).append("\n"); 
		query.append("#foreach(${invNoKey} in ${r_invoiceNo})" ).append("\n"); 
		query.append("#if(${velocityCount} < $r_invoiceNo.size())" ).append("\n"); 
		query.append("('$invNoKey')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("('$invNoKey')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NVL(E.TML_INV_STS_CD,'R') <> 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${r_fromDt} != '' && ${r_toDt} != '')" ).append("\n"); 
		query.append("AND REPLACE(E.ISS_DT,'-') >= @[r_fromDt] AND REPLACE(E.ISS_DT,'-') <= @[r_toDt]" ).append("\n"); 
		query.append("AND REPLACE(E.RCV_DT,'-') >= @[r_fromDt] AND REPLACE(E.RCV_DT,'-') <= @[r_toDt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY VNDR_SEQ, INV_NO DESC" ).append("\n"); 

	}
}