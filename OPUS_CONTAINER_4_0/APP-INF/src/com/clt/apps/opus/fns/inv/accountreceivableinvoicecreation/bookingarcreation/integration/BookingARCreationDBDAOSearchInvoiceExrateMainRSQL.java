/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchInvoiceExrateMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.02.16 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchInvoiceExrateMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchInvoiceExrateMainRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchInvoiceExrateMainRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchInvoiceExrateMainRSQL").append("\n"); 
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
		query.append("SELECT AR_IF_NO," ).append("\n"); 
		query.append("	   BL_SRC_NO," ).append("\n"); 
		query.append("	   BKG_NO," ).append("\n"); 
		query.append("   	   ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("	   ACT_CUST_SEQ," ).append("\n"); 
		query.append("	   AR_OFC_CD," ).append("\n"); 
		query.append("	   VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("	   POR_CD," ).append("\n"); 
		query.append("	   POL_CD," ).append("\n"); 
		query.append("	   POD_CD," ).append("\n"); 
		query.append("	   DEL_CD," ).append("\n"); 
		query.append("	   SVC_SCP_CD," ).append("\n"); 
		query.append("	   SAIL_DT," ).append("\n"); 
		query.append("	   SAIL_ARR_DT," ).append("\n"); 
		query.append("	   USD_XCH_RT," ).append("\n"); 
		query.append("	   INV_TTL_LOCL_AMT " ).append("\n"); 
		query.append("  FROM INV_AR_MN" ).append("\n"); 
		query.append(" WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}