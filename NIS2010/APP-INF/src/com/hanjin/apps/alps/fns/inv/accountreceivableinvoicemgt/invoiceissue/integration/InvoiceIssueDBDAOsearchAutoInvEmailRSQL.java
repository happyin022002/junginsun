/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchAutoInvEmailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchAutoInvEmailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchAutoInvEmailRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchAutoInvEmailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchAutoInvEmailRSQL").append("\n"); 
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
		query.append("SELECT  NVL(DECODE(T1.IO_BND_CD, 'O', DECODE(T1.AR_OFC_CD,'VLCSC',    NVL(T33.AUTO_INV_EML, T55.CNTC_PSON_EML) --2010-06-22" ).append("\n"); 
		query.append("              ,'HAMSC', NVL(T33.AUTO_INV_EML, NVL(T5.CNTC_PSON_EML,T55.CNTC_PSON_EML))" ).append("\n"); 
		query.append("              ,'ANRSO', NVL(T33.AUTO_INV_EML, NVL(T5.CNTC_PSON_EML,T55.CNTC_PSON_EML))" ).append("\n"); 
		query.append("              ,'RTMSC', NVL(T33.AUTO_INV_EML, NVL(T5.CNTC_PSON_EML,T55.CNTC_PSON_EML))" ).append("\n"); 
		query.append("              ,'PRGSC', NVL(T33.AUTO_INV_EML, NVL(T5.CNTC_PSON_EML,T55.CNTC_PSON_EML))" ).append("\n"); 
		query.append("              ,'WRPSC', NVL(T33.AUTO_INV_EML, NVL(T5.CNTC_PSON_EML,T55.CNTC_PSON_EML))" ).append("\n"); 
		query.append("              ,'FXTSC', NVL(T33.AUTO_INV_EML, NVL(T5.CNTC_PSON_EML,T55.CNTC_PSON_EML))" ).append("\n"); 
		query.append("              ,'LEHSC', T33.AUTO_INV_EML ||';'|| T5.CNTC_PSON_EML ||';'|| T55.CNTC_PSON_EML " ).append("\n"); 
		query.append("                       ,DECODE(T5.CNTC_PSON_EML, '', DECODE(T55.CNTC_PSON_EML, '', DECODE(T33.AUTO_INV_EML, '', T3.AUTO_INV_OB_EML, T33.AUTO_INV_EML),T55.CNTC_PSON_EML), T5.CNTC_PSON_EML))" ).append("\n"); 
		query.append("                       , 'I', DECODE(T33.AUTO_INV_EML, '', T3.AUTO_INV_IB_EML, T33.AUTO_INV_EML)), '') CUST_EML" ).append("\n"); 
		query.append("FROM   INV_AR_MN T1  " ).append("\n"); 
		query.append("     , MDM_CR_CUST T3" ).append("\n"); 
		query.append("	 , MDM_CUST_REP T33" ).append("\n"); 
		query.append("     , BKG_BOOKING T4" ).append("\n"); 
		query.append("     , BKG_CNTC_PSON T5" ).append("\n"); 
		query.append("     , BKG_CNTC_PSON T55 " ).append("\n"); 
		query.append("WHERE  1=1 " ).append("\n"); 
		query.append("   AND T1.ACT_CUST_CNT_CD = T3.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND T1.ACT_CUST_SEQ = T3.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND T1.ACT_CUST_CNT_CD = T33.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND T1.ACT_CUST_SEQ = T33.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND T1.AR_OFC_CD = T33.OFC_CD(+)" ).append("\n"); 
		query.append("   AND T1.IO_BND_CD = T33.IO_BND_CD(+)" ).append("\n"); 
		query.append("   AND T1.BL_SRC_NO = T4.BL_NO(+)" ).append("\n"); 
		query.append("   AND T4.BKG_NO = T5.BKG_NO(+)" ).append("\n"); 
		query.append("   AND T5.BKG_CNTC_PSON_TP_CD(+) = 'BK'" ).append("\n"); 
		query.append("   AND T4.BKG_NO = T55.BKG_NO(+)" ).append("\n"); 
		query.append("   AND T55.BKG_CNTC_PSON_TP_CD(+) = 'SI'" ).append("\n"); 
		query.append("   AND T1.AR_IF_NO =  @[ar_if_no]" ).append("\n"); 

	}
}