/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOModifyInvArChgUSQL.java
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

public class AccountReceivableInvoiceMigrationDBDAOModifyInvArChgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify Inv Ar Chg
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOModifyInvArChgUSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOModifyInvArChgUSQL").append("\n"); 
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
		query.append("UPDATE OPUSADM_TMP.INV_AR_CHG A" ).append("\n"); 
		query.append("   SET AR_IF_SER_NO = (SELECT AR_IF_SER_NO" ).append("\n"); 
		query.append("                         FROM OPUSADM_TMP.INV_AR_AMT" ).append("\n"); 
		query.append("                        WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("                     	  AND TJ_SRC_NM = A.TJ_SRC_NM" ).append("\n"); 
		query.append("                     	  AND CURR_CD = A.CURR_CD), " ).append("\n"); 
		query.append("       AR_IF_CHG_SEQ = (SELECT AR_IF_CHG_SEQ" ).append("\n"); 
		query.append("                     FROM (SELECT ROW_NUMBER() OVER( PARTITION BY B.AR_IF_SER_NO ORDER BY B.AR_IF_SER_NO,C.CHG_SEQ) AR_IF_CHG_SEQ, C.AR_IF_NO, C.CHG_SEQ " ).append("\n"); 
		query.append("                             FROM OPUSADM_TMP.INV_AR_AMT B, OPUSADM_TMP.INV_AR_CHG C" ).append("\n"); 
		query.append("                             WHERE  B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                             AND  B.TJ_SRC_NM = C.TJ_SRC_NM" ).append("\n"); 
		query.append("                             AND  B.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                             AND  B.AR_IF_NO= @[ar_if_no]) Z" ).append("\n"); 
		query.append("                     WHERE  Z.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("                     AND   Z.CHG_SEQ = A.CHG_SEQ)         " ).append("\n"); 
		query.append(" WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}