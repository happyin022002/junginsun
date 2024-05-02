/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAutoSettlementSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOsearchAutoSettlementSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve Temporary Autosettlement Entry Summary
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAutoSettlementSummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAutoSettlementSummaryListRSQL").append("\n"); 
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
		query.append("SELECT A.CLT_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("	   A.BL_CURR_CD AS OFC_BL_CURR_CD," ).append("\n"); 
		query.append("	   NVL(C.DP_PRCS_KNT, 2) LCL_PRCS," ).append("\n"); 
		query.append("	   NVL(D.DP_PRCS_KNT, 2) BL_PRCS,  " ).append("\n"); 
		query.append("       COUNT(*) AS OFC_BL_CNT," ).append("\n"); 
		query.append("       SUM(A.BAL_AMT) AS OFC_BAL_AMT,   " ).append("\n"); 
		query.append("	   SUM(A.BAL_LOCL_AMT) AS OFC_LCL_AMT, " ).append("\n"); 
		query.append("       SUM(A.BAL_USD_AMT) AS OFC_USD_AMT" ).append("\n"); 
		query.append("FROM   SAR_AUTO_STL_TMP A," ).append("\n"); 
		query.append("	   MDM_ORGANIZATION B," ).append("\n"); 
		query.append("	   MDM_CURRENCY C," ).append("\n"); 
		query.append("	   MDM_CURRENCY D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.BAT_SEQ = @[bat_seq] " ).append("\n"); 
		query.append("AND A.CLT_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND B.AR_CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("AND A.BL_CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("    A.CLT_OFC_CD," ).append("\n"); 
		query.append("	A.BL_CURR_CD," ).append("\n"); 
		query.append("	C.DP_PRCS_KNT," ).append("\n"); 
		query.append("	D.DP_PRCS_KNT" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    A.CLT_OFC_CD," ).append("\n"); 
		query.append("	A.BL_CURR_CD" ).append("\n"); 

	}
}