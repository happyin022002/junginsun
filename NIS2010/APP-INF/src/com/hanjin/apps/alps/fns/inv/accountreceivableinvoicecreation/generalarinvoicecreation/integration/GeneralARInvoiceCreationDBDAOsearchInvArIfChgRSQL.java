/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchInvArIfChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.03.31 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchInvArIfChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchInvArIfChgRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchInvArIfChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchInvArIfChgRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   I.SRC_IF_DT, I.SRC_IF_SEQ, I.CHG_SEQ, " ).append("\n"); 
		query.append("   I.CHG_CD, I.CURR_CD, I.PER_TP_CD, " ).append("\n"); 
		query.append("   I.TRF_RT_AMT, I.RAT_AS_CNTR_QTY, I.CHG_AMT, " ).append("\n"); 
		query.append("   I.INV_XCH_RT, I.CHG_FULL_NM, I.TRF_NO, " ).append("\n"); 
		query.append("   I.TVA_FLG, I.REP_CHG_CD, I.CHG_RMK, " ).append("\n"); 
		query.append("   I.CRE_USR_ID, I.CRE_DT, I.UPD_USR_ID, " ).append("\n"); 
		query.append("   I.UPD_DT" ).append("\n"); 
		query.append("FROM NISADM.INV_AR_IF_CHG I" ).append("\n"); 
		query.append("WHERE SRC_IF_DT = @[src_if_dt]" ).append("\n"); 
		query.append("  AND SRC_IF_SEQ = @[src_if_seq]" ).append("\n"); 
		query.append("  AND NVL(CHG_AMT,0) <> 0" ).append("\n"); 

	}
}