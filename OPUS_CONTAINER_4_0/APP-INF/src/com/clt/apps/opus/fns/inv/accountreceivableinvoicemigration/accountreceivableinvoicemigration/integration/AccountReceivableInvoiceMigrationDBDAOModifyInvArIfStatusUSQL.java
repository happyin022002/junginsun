/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOModifyInvArIfStatusUSQL.java
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

public class AccountReceivableInvoiceMigrationDBDAOModifyInvArIfStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify InvAr If Status
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOModifyInvArIfStatusUSQL(){
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
		params.put("inv_ar_if_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_err_rsn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOModifyInvArIfStatusUSQL").append("\n"); 
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
		query.append("UPDATE MIGADM.MIG_INV_BKG_IF_MN " ).append("\n"); 
		query.append("   SET INV_AR_IF_CD = NVL(@[inv_ar_if_cd],'N')," ).append("\n"); 
		query.append("       AR_IF_ERR_RSN = substr(@[ar_if_err_rsn],1,100)," ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 

	}
}