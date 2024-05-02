/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOsearchReceivableForOTSChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOsearchReceivableForOTSChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OTS Charge 반영대상 Receivable 정보 조회
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOsearchReceivableForOTSChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOsearchReceivableForOTSChargeRSQL").append("\n"); 
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
		query.append("SELECT A.OTS_HIS_SEQ" ).append("\n"); 
		query.append("	   , A.CHG_TP_CD" ).append("\n"); 
		query.append("       , A.APLY_AMT * (-1) BAL_AMT" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM SAR_RCV_APPL A," ).append("\n"); 
		query.append("	 SAR_RCV_APPL_SEQ_TMP B" ).append("\n"); 
		query.append("WHERE A.RCV_APPL_SEQ = B.RCV_APPL_SEQ" ).append("\n"); 
		query.append("AND A.OTS_HIS_SEQ IS NOT NULL" ).append("\n"); 

	}
}