/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListInternalRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListInternalRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListInternalRemarkRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListInternalRemarkRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListInternalRemarkRSQL").append("\n"); 
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
		query.append("SELECT INTER_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_PAYR_INFO PAYR" ).append("\n"); 
		query.append(",COM_SYS_AREA_GRP_ID    CS" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     PAYR.CUST_CNT_CD    = DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), PAYR.CUST_CNT_CD), 6, PAYR.CUST_CNT_CD, PAYR.CUST_CNT_CD)" ).append("\n"); 
		query.append("AND     PAYR.CUST_SEQ       = DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), PAYR.CUST_SEQ),  6, @[payc], PAYR.CUST_SEQ)" ).append("\n"); 
		query.append("AND     PAYR.SYS_AREA_GRP_ID= CS.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     CS.CO_IND_CD        = 'H'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${payc} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
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