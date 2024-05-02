/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchBKGCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.01.26 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchBKGCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchBKGCustomerListRSQL(){
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
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchBKGCustomerListRSQL").append("\n"); 
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
		query.append("SELECT SHPR.CUST_CNT_CD SHPR_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(SHPR.CUST_SEQ,6,0) SHPR_CUST_SEQ," ).append("\n"); 
		query.append("       SHPR.CUST_NM SHPR_CUST_NM," ).append("\n"); 
		query.append("       FWDR.CUST_CNT_CD FWDR_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(FWDR.CUST_SEQ,6,0) FWDR_CUST_SEQ," ).append("\n"); 
		query.append("       FWDR.CUST_NM FWDR_CUST_NM    " ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER SHPR," ).append("\n"); 
		query.append("       BKG_CUSTOMER FWDR" ).append("\n"); 
		query.append(" WHERE SHPR.BKG_CUST_TP_CD  = DECODE(SUBSTR(@[bnd],1,1),'O','S','C')" ).append("\n"); 
		query.append("   AND FWDR.BKG_CUST_TP_CD  = DECODE(SUBSTR(@[bnd],1,1),'O','F','N') " ).append("\n"); 
		query.append("   AND SHPR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND FWDR.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}