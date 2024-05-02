/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEdiDHLCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEdiDHLCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiDHLCntr
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEdiDHLCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEdiDHLCntrRSQL").append("\n"); 
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
		query.append("SELECT CNTR.CNTR_NO CNTR_NBR," ).append("\n"); 
		query.append("CNTR.CNTR_TPSZ_CD CNTR_TYPE" ).append("\n"); 
		query.append("FROM INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("INV_AR_CNTR CNTR" ).append("\n"); 
		query.append("WHERE DTL.AR_IF_NO = CNTR.AR_IF_NO" ).append("\n"); 
		query.append("AND DTL.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND DTL.CHG_SEQ = 1" ).append("\n"); 

	}
}