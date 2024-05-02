/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Customer 정보를 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerListRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SUBSTR(@[dmdt_trf_cd], 3, 1), 'I'," ).append("\n"); 
		query.append("DECODE(CUST_CONSIGNEE_CD, '000000'," ).append("\n"); 
		query.append("DECODE(CUST_NOTIFY_CD, '000000', '', CUST_NOTIFY_CD)" ).append("\n"); 
		query.append(", CUST_CONSIGNEE_CD)" ).append("\n"); 
		query.append(", CUST_SHIPPER_CD) AS CUST_CD" ).append("\n"); 
		query.append(",   DECODE(SUBSTR(@[dmdt_trf_cd], 3, 1), 'I'," ).append("\n"); 
		query.append("DECODE(CUST_CONSIGNEE_CD, '000000'," ).append("\n"); 
		query.append("DECODE(CUST_NOTIFY_CD, '000000', '', CUST_NOTIFY_NM)" ).append("\n"); 
		query.append(", CUST_CONSIGNEE_NM)" ).append("\n"); 
		query.append(", CUST_SHIPPER_NM) AS CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  BS.CUST_CNT_CD || LPAD(BS.CUST_SEQ, 6, '0') AS CUST_SHIPPER_CD" ).append("\n"); 
		query.append(",   BS.CUST_NM AS CUST_SHIPPER_NM" ).append("\n"); 
		query.append(",   BC.CUST_CNT_CD || LPAD(BC.CUST_SEQ, 6, '0') AS CUST_CONSIGNEE_CD" ).append("\n"); 
		query.append(",   BC.CUST_NM AS CUST_CONSIGNEE_NM" ).append("\n"); 
		query.append(",   BN.CUST_CNT_CD || LPAD(BN.CUST_SEQ, 6, '0') AS CUST_NOTIFY_CD" ).append("\n"); 
		query.append(",   BN.CUST_NM AS CUST_NOTIFY_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append(",   BKG_CUSTOMER BS" ).append("\n"); 
		query.append(",   BKG_CUSTOMER BC" ).append("\n"); 
		query.append(",   BKG_CUSTOMER BN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = BS.BKG_NO(+)" ).append("\n"); 
		query.append("AND BS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("AND BK.BKG_NO = BN.BKG_NO(+)" ).append("\n"); 
		query.append("AND BN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}