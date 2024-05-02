/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingIFDBDAOsearchReFindSakuraIfNoForBatchRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingIFDBDAOsearchReFindSakuraIfNoForBatchRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchReFindSakuraIfNoForBatchRSQL
	  * </pre>
	  */
	public AccountReceivableOutstandingIFDBDAOsearchReFindSakuraIfNoForBatchRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.integration ").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingIFDBDAOsearchReFindSakuraIfNoForBatchRSQLRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR( XMLAGG (XMLELEMENT (X, ',', IF_NO )" ).append("\n"); 
		query.append("                 ORDER BY IF_NO ).EXTRACT( '//text()' ) , 2) AS IF_NO" ).append("\n"); 
		query.append("      ,REF_NO" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SELECT DISTINCT SOH.IF_NO" ).append("\n"); 
		query.append("         ,SOH.REF_NO" ).append("\n"); 
		query.append("         ,SOC.BL_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("      FROM SAR_OTS_HIS SOH" ).append("\n"); 
		query.append("         ,SAR_OTS_CHG SOC" ).append("\n"); 
		query.append("       WHERE SOH.OTS_HIS_SEQ IN (" ).append("\n"); 
		query.append("           SELECT DISTINCT OTS_HIS_SEQ" ).append("\n"); 
		query.append("              FROM SAR_OTS_DTRB" ).append("\n"); 
		query.append("           WHERE AR_IF_STS_CD = 'T'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       AND SOH.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("GROUP BY REF_NO,CURR_CD" ).append("\n"); 

	}
}