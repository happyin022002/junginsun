/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchReFindSakuraIfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOsearchReFindSakuraIfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchReFindSakuraIfNo
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchReFindSakuraIfNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchReFindSakuraIfNoRSQL").append("\n"); 
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
		query.append("     WHERE SOH.OTS_HIS_SEQ IN ( " ).append("\n"); 
		query.append("        #foreach( $key IN ${ots_his_list}) " ).append("\n"); 
		query.append("            #if($velocityCount < $ots_his_list.size())" ).append("\n"); 
		query.append("                '$key'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$key'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("       AND SOH.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("GROUP BY REF_NO,CURR_CD" ).append("\n"); 

	}
}