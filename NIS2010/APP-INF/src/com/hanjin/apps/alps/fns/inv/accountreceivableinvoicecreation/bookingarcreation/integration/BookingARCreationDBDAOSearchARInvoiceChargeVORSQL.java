/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchARInvoiceChargeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.16 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchARInvoiceChargeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] BookingARCreationDBDAO::searchARInvoiceCharge ( ifNo )  searchARInvoiceCharge   InvArChgVO[]
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchARInvoiceChargeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchARInvoiceChargeVORSQL").append("\n"); 
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
		query.append("AR_IF_NO" ).append("\n"); 
		query.append(", AR_IF_SER_NO" ).append("\n"); 
		query.append(", CHG_SEQ" ).append("\n"); 
		query.append(", CHG_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", PER_TP_CD" ).append("\n"); 
		query.append(", TRF_RT_AMT" ).append("\n"); 
		query.append(", RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append(", INV_XCH_RT" ).append("\n"); 
		query.append(", INV_XCH_RT_DT" ).append("\n"); 
		query.append(", REP_CHG_CD" ).append("\n"); 
		query.append(", CHG_FULL_NM" ).append("\n"); 
		query.append(", TRF_NO" ).append("\n"); 
		query.append(", INV_ISS_FLG" ).append("\n"); 
		query.append(", INV_CLR_FLG" ).append("\n"); 
		query.append(", SOB_ID" ).append("\n"); 
		query.append(", INV_REV_TP_SRC_CD" ).append("\n"); 
		query.append(", REV_COA_CO_CD" ).append("\n"); 
		query.append(", REV_COA_RGN_CD" ).append("\n"); 
		query.append(", REV_COA_CTR_CD" ).append("\n"); 
		query.append(", REV_COA_ACCT_CD" ).append("\n"); 
		query.append(", REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append(", REV_COA_VSL_CD" ).append("\n"); 
		query.append(", REV_COA_VOY_NO" ).append("\n"); 
		query.append(", REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append(", REV_COA_DIR_CD" ).append("\n"); 
		query.append(", ACCT_CD" ).append("\n"); 
		query.append(", TVA_FLG" ).append("\n"); 
		query.append(", CHG_RMK" ).append("\n"); 
		query.append(", MNL_FLG" ).append("\n"); 
		query.append(", MF_DIV_CD" ).append("\n"); 
		query.append(", AR_IF_CHG_SEQ" ).append("\n"); 
		query.append(", TJ_SRC_NM" ).append("\n"); 
		query.append("FROM INV_AR_CHG" ).append("\n"); 
		query.append("WHERE	AR_IF_NO = @[if_no]" ).append("\n"); 

	}
}