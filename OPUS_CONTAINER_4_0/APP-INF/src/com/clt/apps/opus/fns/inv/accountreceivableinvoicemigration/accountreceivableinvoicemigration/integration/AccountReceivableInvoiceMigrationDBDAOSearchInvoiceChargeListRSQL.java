/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchInvoiceChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOSearchInvoiceChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Invoice Charge List
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchInvoiceChargeListRSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchInvoiceChargeListRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       PER_TP_CD," ).append("\n"); 
		query.append("       TRF_RT_AMT," ).append("\n"); 
		query.append("       RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("       CHG_AMT," ).append("\n"); 
		query.append("       INV_XCH_RT," ).append("\n"); 
		query.append("       TRF_NO," ).append("\n"); 
		query.append("	   DE_TERM_CD," ).append("\n"); 
		query.append("	   AUTO_RAT_CD," ).append("\n"); 
		query.append("	   WHF_FLG" ).append("\n"); 
		query.append("  FROM MIGADM.MIG_INV_BKG_IF_CHG" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 
		query.append("   AND OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                       WHERE AR_OFC_CD = ( SELECT AR_OFC_CD " ).append("\n"); 
		query.append("                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE OFC_CD = @[ofc_cd] ))" ).append("\n"); 
		query.append("   AND NVL(CHG_AMT,0) <> 0 " ).append("\n"); 
		query.append(" ORDER BY CURR_CD" ).append("\n"); 

	}
}