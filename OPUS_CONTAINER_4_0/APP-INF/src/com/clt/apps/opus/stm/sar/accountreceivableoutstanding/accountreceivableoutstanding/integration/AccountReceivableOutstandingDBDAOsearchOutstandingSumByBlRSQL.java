/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchOutstandingSumByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.15 
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

public class AccountReceivableOutstandingDBDAOsearchOutstandingSumByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding Inquiry by B/L(Invoice)  Summary
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchOutstandingSumByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchOutstandingSumByBlRSQL").append("\n"); 
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
		query.append("WITH CURRENCY" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("    SELECT MC.DP_PRCS_KNT" ).append("\n"); 
		query.append("      FROM SAR_OTS_HDR SOH," ).append("\n"); 
		query.append("           MDM_CURRENCY MC" ).append("\n"); 
		query.append("     WHERE SOH.OFC_CURR_CD = MC.CURR_CD(+)" ).append("\n"); 
		query.append("       AND SOH.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       AND SOH.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("       AND SOH.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("       AND SOH.INV_NO = @[inv_no] )" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("         A.RHQ_CD" ).append("\n"); 
		query.append("       , A.OTS_OFC_CD" ).append("\n"); 
		query.append("       , A.BL_NO" ).append("\n"); 
		query.append("       , A.INV_NO       " ).append("\n"); 
		query.append("       , SUM(ROUND(A.INV_AMT * A.LOCL_XCH_RT,CURR.DP_PRCS_KNT)) AS INV_LOCL_AMT        " ).append("\n"); 
		query.append("       , SUM(ROUND(A.INV_AMT * A.USD_XCH_RT, 2)) AS INV_USD_AMT" ).append("\n"); 
		query.append("       , SUM(ROUND(A.RCT_AMT * A.LOCL_XCH_RT, CURR.DP_PRCS_KNT)) AS RCT_LOCL_AMT        " ).append("\n"); 
		query.append("       , SUM(ROUND(A.RCT_AMT * A.USD_XCH_RT, 2)) AS RCT_USD_AMT" ).append("\n"); 
		query.append("       , SUM(ROUND(A.ADJ_AMT * A.LOCL_XCH_RT, CURR.DP_PRCS_KNT)) AS ADJ_LOCL_AMT        " ).append("\n"); 
		query.append("       , SUM(ROUND(A.ADJ_AMT * A.USD_XCH_RT, 2)) AS ADJ_USD_AMT" ).append("\n"); 
		query.append("       , SUM(ROUND(A.BAL_LOCL_AMT, CURR.DP_PRCS_KNT))  AS BAL_LOCL_AMT     " ).append("\n"); 
		query.append("       , SUM(ROUND(A.BAL_USD_AMT, 2))  AS BAL_USD_AMT" ).append("\n"); 
		query.append("FROM     SAR_OTS_DTL A,CURRENCY CURR" ).append("\n"); 
		query.append("WHERE 1 = 1      " ).append("\n"); 
		query.append("  AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND A.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("  AND A.OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("         A.RHQ_CD" ).append("\n"); 
		query.append("       , A.OTS_OFC_CD" ).append("\n"); 
		query.append("       , A.BL_NO" ).append("\n"); 
		query.append("       , A.INV_NO" ).append("\n"); 
		query.append("       , CURR.DP_PRCS_KNT" ).append("\n"); 

	}
}