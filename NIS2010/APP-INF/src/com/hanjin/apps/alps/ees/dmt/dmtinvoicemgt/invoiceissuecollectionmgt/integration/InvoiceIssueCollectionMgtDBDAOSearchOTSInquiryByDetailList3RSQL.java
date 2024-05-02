/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.25
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.06.25 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1111
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList3RSQL").append("\n"); 
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
		query.append("        M.DMDT_INV_NO                                           INVNOO ,        /*  INVOICE NO                  */" ).append("\n"); 
		query.append("        M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD                    VVDCDD ,        /*  VVD                         */" ).append("\n"); 
		query.append("        M.BKG_NO                                                BKGNOO ,        /*  BKG NO                      */" ).append("\n"); 
		query.append("        M.BL_NO                                                 BLNOOO ,        /*  BL NO                       */" ).append("\n"); 
		query.append("		D.CNTR_NO                                               CNTRNO ," ).append("\n"); 
		query.append("		D.CNTR_TPSZ_CD                                          TPSZCD ," ).append("\n"); 
		query.append("        M.INV_CURR_CD                                           CURRCY ,        /*  INVOICE CURRENCY            */" ).append("\n"); 
		query.append("        M.INV_CHG_AMT                                           BILAMT ,        /*  INVOICE BILLING AMOUNT      */" ).append("\n"); 
		query.append("        M.TAX_AMT                                               TAXAMT ,        /*  INVOICE TAX AMOUNT          */" ).append("\n"); 
		query.append("--      M.DIM_COMM_AMT                                          COMAMT ,        /*  INVOICE COMMISSION AMOUNT   */" ).append("\n"); 
		query.append("        M.INV_AMT                                               INVAMT ,        /*  INVOICE AMOUNT              */" ).append("\n"); 
		query.append("        M.DMDT_TRF_CD                                           TARFTP ,        /*  TARIFF TYPE                 */" ).append("\n"); 
		query.append("        TO_CHAR(M.CRE_DT,'DDMonYY','NLS_DATE_LANGUAGE=ENGLISH') ISSEDT ,        /*  INVOICE ISSUE DATE          */" ).append("\n"); 
		query.append("        M.CRE_OFC_CD                                            ISSEOF ,        /*  INVOICE ISSUE OFFICE        */" ).append("\n"); 
		query.append("--      M.ACT_CNT_CD||TO_CHAR(M.ACT_CUST_CD,'FM000000')         PAYRCD ,        /*  PAYER CODE                  */" ).append("\n"); 
		query.append("        TO_DATE(TO_CHAR(SYSDATE ,'YYYYMMDD'),'YYYYMMDD') -" ).append("\n"); 
		query.append("        TO_DATE(TO_CHAR(M.CRE_DT,'YYYYMMDD'),'YYYYMMDD')  		INVOVD ,        /*  INVOICE OVER DAY = SYSDATE - ISSUE DATE #ADD 2007.12.03 */" ).append("\n"); 
		query.append("        M.POR_CD, M.POL_CD, M.POD_CD, M.DEL_CD    " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        DMT_INV_MN M" ).append("\n"); 
		query.append("		, DMT_INV_DTL D" ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("		M.DMDT_INV_NO = D.DMDT_INV_NO" ).append("\n"); 
		query.append("AND		M.CRE_OFC_CD = D.CRE_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${invno} != '' )" ).append("\n"); 
		query.append("AND     M.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_inv_no_p in ${tempINVNOList}) " ).append("\n"); 
		query.append("        #if($velocityCount < $tempINVNOList.size()) " ).append("\n"); 
		query.append("           '$dmdt_inv_no_p', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_inv_no_p' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	1 = 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER   BY  M.DMDT_INV_NO" ).append("\n"); 

	}
}