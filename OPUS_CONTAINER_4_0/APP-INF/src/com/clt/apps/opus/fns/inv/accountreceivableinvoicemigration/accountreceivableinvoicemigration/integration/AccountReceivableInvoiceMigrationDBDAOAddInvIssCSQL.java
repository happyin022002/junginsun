/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOAddInvIssCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
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

public class AccountReceivableInvoiceMigrationDBDAOAddInvIssCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Inv Iss
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOAddInvIssCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOAddInvIssCSQL").append("\n"); 
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
		query.append("INSERT INTO OPUSADM_TMP.INV_AR_ISS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    INV_NO" ).append("\n"); 
		query.append("    , INV_SEQ" ).append("\n"); 
		query.append("    , INV_ISS_CMB_FLG" ).append("\n"); 
		query.append("    , ISS_OFC_CD" ).append("\n"); 
		query.append("    , ISS_DT" ).append("\n"); 
		query.append("    , USD_XCH_RT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , ISS_GRP_TP_CD" ).append("\n"); 
		query.append(")    " ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[inv_no]" ).append("\n"); 
		query.append(" 	, '1'" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , @[ofc_cd]" ).append("\n"); 
		query.append("    , @[iss_dt]" ).append("\n"); 
		query.append("    , '0'" ).append("\n"); 
		query.append("    , @[user_id] " ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[user_id] " ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[iss_grp_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}