/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.21 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_DMT_4011
	  * Outstanding Inquiry by Customer N Issue - Detail(s)
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemarkRSQL(){
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
		params.put("payc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemarkRSQL").append("\n"); 
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
		query.append("REPLACE( " ).append("\n"); 
		query.append("		NVL(PAYR.DMDT_PAYR_OTS_RMK        ,' ')||'|'||" ).append("\n"); 
		query.append("		NVL(PAYR_CNT.DMDT_PAYR_CNTC_PNT_NM,' ')||'|'||" ).append("\n"); 
		query.append("		NVL(PAYR.DMDT_PAYR_ADDR           ,' ')||'|'||" ).append("\n"); 
		query.append("		NVL(PAYR.DMDT_PAYR_PHN_NO         ,' ')||'|'||" ).append("\n"); 
		query.append("		NVL(PAYR.DMDT_PAYR_FAX_NO         ,' ')||'|'||" ).append("\n"); 
		query.append("		NVL(PAYR_CNT.PAYR_CNTC_PNT_EML    ,' ')||'|'||" ).append("\n"); 
		query.append("		NVL(CUST.CUST_RGST_NO             ,' ')" ).append("\n"); 
		query.append(",'@*',CHR(10)" ).append("\n"); 
		query.append("       ) AS DMDT_PAYR_OTS_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_PAYR_INFO PAYR" ).append("\n"); 
		query.append(",DMT_PAYR_CNTC_PNT PAYR_CNT" ).append("\n"); 
		query.append(",MDM_CUSTOMER CUST" ).append("\n"); 
		query.append(",COM_SYS_AREA_GRP_ID    CS" ).append("\n"); 
		query.append("WHERE   PAYR.CUST_CNT_CD    = CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     PAYR.CUST_SEQ       = CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     PAYR.CUST_CNT_CD    = PAYR_CNT.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     PAYR.CUST_SEQ       = PAYR_CNT.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     PAYR.CUST_CNT_CD    = DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), PAYR.CUST_CNT_CD), 6, PAYR.CUST_CNT_CD, PAYR.CUST_CNT_CD)" ).append("\n"); 
		query.append("AND     PAYR.CUST_SEQ       = DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), PAYR.CUST_SEQ),  6, @[payc], PAYR.CUST_SEQ)" ).append("\n"); 
		query.append("AND     PAYR.SYS_AREA_GRP_ID= CS.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     CS.CO_IND_CD        = 'H'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${payc} != '')" ).append("\n"); 
		query.append("	#if ($payc.length() == 8)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     CS.CNT_CD           = DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), PAYR.CUST_CNT_CD), 6, PAYR.CUST_CNT_CD, PAYR.CUST_CNT_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     CS.CNT_CD           = (" ).append("\n"); 
		query.append("                                SELECT  SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                                FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                WHERE   OFC_CD = @[h_usr_off]" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}