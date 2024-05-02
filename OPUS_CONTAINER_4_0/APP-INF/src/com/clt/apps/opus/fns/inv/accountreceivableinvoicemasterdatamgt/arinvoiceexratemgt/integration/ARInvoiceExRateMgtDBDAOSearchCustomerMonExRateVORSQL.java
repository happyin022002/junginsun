/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchCustomerMonExRateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.03 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchCustomerMonExRateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * customer per month duplicate check
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchCustomerMonExRateVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("COUNT(*) CNT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("WHERE	CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND	CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SUBSTR(FM_DT,0,6) = @[mon]" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("SUBSTR(TO_DT,0,6) = @[mon]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchCustomerMonExRateVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}