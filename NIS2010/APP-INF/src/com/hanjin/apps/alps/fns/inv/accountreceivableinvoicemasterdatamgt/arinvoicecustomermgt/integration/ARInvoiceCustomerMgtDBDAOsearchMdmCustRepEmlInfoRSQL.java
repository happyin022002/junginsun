/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchMdmCustRepEmlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOsearchMdmCustRepEmlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMdmCustRepEmlInfo
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchMdmCustRepEmlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchMdmCustRepEmlInfoRSQL").append("\n"); 
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
		query.append("SELECT  OFC_CD AS AR_OFC_CD " ).append("\n"); 
		query.append("       ,MAX(DECODE(IO_BND_CD, 'O', 'O/B','O/B'))OUT_BOUND" ).append("\n"); 
		query.append("       ,MAX(DECODE(IO_BND_CD, 'O', AUTO_INV_EML, NULL)) OUT_EML" ).append("\n"); 
		query.append("       ,MAX(DECODE(IO_BND_CD, 'I', 'I/B','I/B'))IN_BOUND" ).append("\n"); 
		query.append("       ,MAX(DECODE(IO_BND_CD, 'I', AUTO_INV_EML, NULL)) IN_EML" ).append("\n"); 
		query.append("FROM MDM_CUST_REP" ).append("\n"); 
		query.append("WHERE     CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND       CUST_SEQ    = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("AND DELT_FLG ='N'" ).append("\n"); 
		query.append("AND AUTO_INV_EML IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY OFC_CD " ).append("\n"); 

	}
}