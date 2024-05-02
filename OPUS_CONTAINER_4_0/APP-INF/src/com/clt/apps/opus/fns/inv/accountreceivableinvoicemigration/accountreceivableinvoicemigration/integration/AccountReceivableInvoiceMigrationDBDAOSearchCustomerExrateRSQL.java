/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchCustomerExrateRSQL.java
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

public class AccountReceivableInvoiceMigrationDBDAOSearchCustomerExrateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Customer Exrate
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchCustomerExrateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcl_curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cntry_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ex_rate_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchCustomerExrateRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(B.XCH_RT_RVS_FLG, 'N', A.INV_XCH_RT, A.IVS_XCH_RT), '0') EX_RATE" ).append("\n"); 
		query.append("FROM  OPUSADM_TMP.INV_CUST_AND_DLY_XCH_RT A, INV_AR_STUP_OFC B " ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = @[inv_cntry_cd]" ).append("\n"); 
		query.append("AND   A.CUST_SEQ  = @[inv_cust_cd]" ).append("\n"); 
		query.append("AND   A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("AND   replace(@[ex_rate_date],'-','') BETWEEN A.FM_DT AND A.TO_DT" ).append("\n"); 
		query.append("AND   A.CHG_CURR_CD = @[curr]" ).append("\n"); 
		query.append("AND   A.LOCL_CURR_CD = @[lcl_curr]" ).append("\n"); 
		query.append("AND   A.XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("AND   B.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}