/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchActualCustomerCodeRSQL.java
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

public class AccountReceivableInvoiceMigrationDBDAOSearchActualCustomerCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Actual Customer Code
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchActualCustomerCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchActualCustomerCodeRSQL").append("\n"); 
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
		query.append("SELECT A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("  FROM MDM_CR_CUST A," ).append("\n"); 
		query.append("       MDM_CUSTOMER B" ).append("\n"); 
		query.append(" WHERE A.CUST_CNT_CD = @[inv_cust_cnt_cd]" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = @[inv_cust_seq]" ).append("\n"); 
		query.append("   AND A.ACT_CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND A.ACT_CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("   AND NVL(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND NVL(B.NMD_CUST_FLG,'N') ='N' " ).append("\n"); 
		query.append("   AND NVL(B.CNTR_DIV_FLG,'N') ='Y'" ).append("\n"); 

	}
}