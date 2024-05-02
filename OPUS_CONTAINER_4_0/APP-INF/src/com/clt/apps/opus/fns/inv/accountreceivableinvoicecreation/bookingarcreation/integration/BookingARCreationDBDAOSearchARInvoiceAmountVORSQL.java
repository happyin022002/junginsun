/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchARInvoiceAmountVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.28 최도순
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

public class BookingARCreationDBDAOSearchARInvoiceAmountVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] BookingARCreationDBDAO::searchARInvoiceAmount ( ifNo )  INV_AR_AMT에서 AR_IF_NO로 조회함.  InvArAmtVO[]
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchARInvoiceAmountVORSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchARInvoiceAmountVORSQL").append("\n"); 
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
		query.append("SELECT AR_IF_NO" ).append("\n"); 
		query.append(",AR_IF_SER_NO" ).append("\n"); 
		query.append(",TJ_SRC_NM" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",INV_AMT" ).append("\n"); 
		query.append(",INV_ERP_IF_STS_CD" ).append("\n"); 
		query.append(",ERP_IF_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",ERR_DESC" ).append("\n"); 
		query.append(",AR_INV_SRC_CD" ).append("\n"); 
		query.append(",INV_COA_CO_CD" ).append("\n"); 
		query.append(",INV_COA_RGN_CD" ).append("\n"); 
		query.append(",INV_COA_CTR_CD" ).append("\n"); 
		query.append(",INV_COA_ACCT_CD" ).append("\n"); 
		query.append(",INV_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",INV_COA_VSL_CD" ).append("\n"); 
		query.append(",INV_COA_VOY_NO" ).append("\n"); 
		query.append(",INV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append(",INV_COA_REV_DIR_CD" ).append("\n"); 
		query.append(",ERP_IF_GL_DT" ).append("\n"); 
		query.append(",ERP_IF_OFC_CD" ).append("\n"); 
		query.append("FROM INV_AR_AMT" ).append("\n"); 
		query.append("WHERE	AR_IF_NO = @[if_no]" ).append("\n"); 

	}
}