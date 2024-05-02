/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LseCommonDBDAOSearchRentalCostAccountOrdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.04.26 이은섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author EUN-SUP LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOSearchRentalCostAccountOrdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public LseCommonDBDAOSearchRentalCostAccountOrdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration").append("\n"); 
		query.append("FileName : LseCommonDBDAOSearchRentalCostAccountOrdDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX (A XPKLSE_RNTL_COST_ACCT_ORD) */" ).append("\n"); 
		query.append("       A.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("       A.LSTM_CD," ).append("\n"); 
		query.append("       A.ACCT_CD," ).append("\n"); 
		query.append("       A.COST_CD," ).append("\n"); 
		query.append("       A.LGS_COST_FULL_NM," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       A.CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.UPD_DT" ).append("\n"); 
		query.append("  FROM LSE_RNTL_COST_ACCT_ORD A" ).append("\n"); 

	}
}