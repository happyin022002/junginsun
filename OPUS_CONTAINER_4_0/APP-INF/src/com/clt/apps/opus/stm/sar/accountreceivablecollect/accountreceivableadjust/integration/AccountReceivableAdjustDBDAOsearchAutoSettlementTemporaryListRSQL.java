/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAutoSettlementTemporaryListRSQL.java
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

public class AccountReceivableAdjustDBDAOsearchAutoSettlementTemporaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve Temporary Autosettlement Entry
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAutoSettlementTemporaryListRSQL(){
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
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAutoSettlementTemporaryListRSQL").append("\n"); 
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
		query.append("SELECT BAT_SEQ," ).append("\n"); 
		query.append("       ADJ_TP_CD," ).append("\n"); 
		query.append("       CLT_OFC_CD,  " ).append("\n"); 
		query.append("       BL_NO ," ).append("\n"); 
		query.append("       INV_NO , " ).append("\n"); 
		query.append("       BL_CURR_CD," ).append("\n"); 
		query.append("	   CHG_TP_CD," ).append("\n"); 
		query.append("       BIL_TO_CUST_CNT_CD AS BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(BIL_TO_CUST_SEQ,6, '0') AS BIL_TO_CUST_SEQ," ).append("\n"); 
		query.append("       BIL_TO_CUST_CNT_CD||'-'||LPAD(BIL_TO_CUST_SEQ,6, '0') AS CUST_CD, " ).append("\n"); 
		query.append("       LOCL_VVD_CD," ).append("\n"); 
		query.append("       SAIL_ARR_DT," ).append("\n"); 
		query.append("       OTS_SRC_CD," ).append("\n"); 
		query.append("       OTS_RMK," ).append("\n"); 
		query.append("       BAL_AMT AS OTS_BAL_AMT," ).append("\n"); 
		query.append("       BAL_LOCL_AMT AS OTS_BAL_LOCL_AMT," ).append("\n"); 
		query.append("       BAL_USD_AMT AS OTS_BAL_USD_AMT," ).append("\n"); 
		query.append("	   SAR_GET_FMT_MASK_FNC(BL_CURR_CD, BAL_AMT) FMT_OTS_BAL_AMT," ).append("\n"); 
		query.append("       SAR_GET_FMT_MASK_FNC((SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = CLT_OFC_CD), BAL_LOCL_AMT) FMT_OTS_BAL_LOCL_AMT," ).append("\n"); 
		query.append("       SAR_GET_FMT_MASK_FNC('USD', BAL_USD_AMT) FMT_OTS_BAL_USD_AMT," ).append("\n"); 
		query.append("       OTS_TP_CD," ).append("\n"); 
		query.append("       'N' AS DEL_FLAG," ).append("\n"); 
		query.append("       MISC_LSS_LMT_AMT," ).append("\n"); 
		query.append("       MISC_INCM_LMT_AMT," ).append("\n"); 
		query.append("       RHQ_CD," ).append("\n"); 
		query.append("       OTS_OFC_CD," ).append("\n"); 
		query.append("	   ADJ_TP_CD||RHQ_CD||OTS_OFC_CD||CLT_OFC_CD||BL_NO||INV_NO AS ADJ_NO_KEY" ).append("\n"); 
		query.append("FROM   SAR_AUTO_STL_TMP" ).append("\n"); 
		query.append("WHERE  BAT_SEQ = @[bat_seq] " ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("       ADJ_TP_CD," ).append("\n"); 
		query.append("       RHQ_CD, " ).append("\n"); 
		query.append("       OTS_OFC_CD," ).append("\n"); 
		query.append("       CLT_OFC_CD," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       INV_NO," ).append("\n"); 
		query.append("       BL_CURR_CD" ).append("\n"); 

	}
}