/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOAddInvBkgIfChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.20 최도순
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

public class BookingARCreationDBDAOAddInvBkgIfChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOAddInvBkgIfChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOAddInvBkgIfChgCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO INV_BKG_IF_CHG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO ," ).append("\n"); 
		query.append("BKG_SEQ ," ).append("\n"); 
		query.append("CHG_SEQ ," ).append("\n"); 
		query.append("CHG_CD ," ).append("\n"); 
		query.append("CURR_CD ," ).append("\n"); 
		query.append("PER_TP_CD ," ).append("\n"); 
		query.append("TRF_RT_AMT ," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY ," ).append("\n"); 
		query.append("CHG_AMT ," ).append("\n"); 
		query.append("INV_XCH_RT ," ).append("\n"); 
		query.append("TRF_NO ," ).append("\n"); 
		query.append("OFC_CD ," ).append("\n"); 
		query.append("CUST_CNT_CD ," ).append("\n"); 
		query.append("CUST_SEQ ," ).append("\n"); 
		query.append("IO_BND_CD ," ).append("\n"); 
		query.append("N3RD_FLG ," ).append("\n"); 
		query.append("CRE_USR_ID ," ).append("\n"); 
		query.append("CRE_DT ," ).append("\n"); 
		query.append("UPD_USR_ID ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO ," ).append("\n"); 
		query.append("@[bkg_seq] ," ).append("\n"); 
		query.append("CHG_SEQ ," ).append("\n"); 
		query.append("CHG_CD ," ).append("\n"); 
		query.append("CURR_CD ," ).append("\n"); 
		query.append("PER_TP_CD ," ).append("\n"); 
		query.append("TRF_RT_AMT ," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY ," ).append("\n"); 
		query.append("CHG_AMT ," ).append("\n"); 
		query.append("INV_XCH_RT ," ).append("\n"); 
		query.append("TRF_NO ," ).append("\n"); 
		query.append("OFC_CD ," ).append("\n"); 
		query.append("CUST_CNT_CD ," ).append("\n"); 
		query.append("CUST_SEQ ," ).append("\n"); 
		query.append("IO_BND_CD ," ).append("\n"); 
		query.append("N3RD_FLG ," ).append("\n"); 
		query.append("@[user_id] ," ).append("\n"); 
		query.append("SYSDATE ," ).append("\n"); 
		query.append("@[user_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM TABLE (BKG_INV_IF_PKG.BKG_IF_CHARGE_TBL_FUNC(@[bkg_no]))" ).append("\n"); 

	}
}