/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchSplitCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchSplitCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Split Cust Info
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchSplitCustInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchSplitCustInfoRSQL").append("\n"); 
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
		query.append("SELECT ACT_CUST_CNT_CD||ACT_CUST_SEQ CUST_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE OLD_AR_IF_NO IN (SELECT MAX(OLD_AR_IF_NO)" ).append("\n"); 
		query.append("                       FROM INV_AR_MN" ).append("\n"); 
		query.append("                       WHERE (AR_OFC_CD, BL_SRC_NO) IN (SELECT AR_OFC_CD, BL_SRC_NO" ).append("\n"); 
		query.append("                                                        FROM INV_AR_MN" ).append("\n"); 
		query.append("                                                        WHERE AR_IF_NO = @[ar_if_no]))" ).append("\n"); 
		query.append("AND (AR_OFC_CD, BL_SRC_NO) IN (SELECT AR_OFC_CD, BL_SRC_NO" ).append("\n"); 
		query.append("                               FROM INV_AR_MN" ).append("\n"); 
		query.append("                               WHERE AR_IF_NO = @[ar_if_no])" ).append("\n"); 
		query.append("ORDER BY AR_IF_NO" ).append("\n"); 

	}
}