/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchInvoiceChgForExrateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.22 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchInvoiceChgForExrateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchInvoiceChgForExrateListRSQL(){
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
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchInvoiceChgForExrateListRSQL").append("\n"); 
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
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("MN.INV_CUST_CNT_CD," ).append("\n"); 
		query.append("MN.INV_CUST_SEQ," ).append("\n"); 
		query.append("MN.AR_OFC_CD," ).append("\n"); 
		query.append("MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("MN.SAIL_DT," ).append("\n"); 
		query.append("MN.VSL_CD," ).append("\n"); 
		query.append("MN.SKD_VOY_NO," ).append("\n"); 
		query.append("MN.SKD_DIR_CD," ).append("\n"); 
		query.append("MN.IO_BND_CD," ).append("\n"); 
		query.append("MN.POL_CD," ).append("\n"); 
		query.append("MN.POD_CD," ).append("\n"); 
		query.append("MN.BKG_NO," ).append("\n"); 
		query.append("MN.SVC_SCP_CD," ).append("\n"); 
		query.append("MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("CHG.AR_IF_SER_NO," ).append("\n"); 
		query.append("CHG.CHG_SEQ," ).append("\n"); 
		query.append("CHG.CURR_CD," ).append("\n"); 
		query.append("CHG.TRF_RT_AMT," ).append("\n"); 
		query.append("CHG.CHG_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN MN," ).append("\n"); 
		query.append("INV_AR_CHG CHG" ).append("\n"); 
		query.append("WHERE MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("AND MN.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("ORDER BY CHG.AR_IF_NO,CHG.AR_IF_SER_NO,CHG.CHG_SEQ" ).append("\n"); 

	}
}