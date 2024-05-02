/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAdjustDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
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

public class AccountReceivableAdjustDBDAOsearchAdjustDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve Outstanding Adjustment 
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAdjustDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adjt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAdjustDtlListRSQL").append("\n"); 
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
		query.append("SELECT SAD.CHG_TP_CD," ).append("\n"); 
		query.append("	   SAD.ADJ_SRC_CURR_CD AS BL_CURR_CD," ).append("\n"); 
		query.append("	   TRIM(SAR_GET_CUR_AMT_FNC(SAD.ADJ_SRC_CURR_CD, SAD.OTS_BAL_AMT)) AS OTS_BAL_AMT,       " ).append("\n"); 
		query.append("       TRIM(SAR_GET_CUR_AMT_FNC(SAD.ADJ_SRC_CURR_CD, SAD.ADJ_AMT)) AS OTS_ADJ_BAL_AMT,    " ).append("\n"); 
		query.append("	   SAD.ADJ_XCH_RT," ).append("\n"); 
		query.append("	   SAD.ADJ_CRS_CURR_CD," ).append("\n"); 
		query.append("	   TRIM(SAR_GET_CUR_AMT_FNC(SAD.ADJ_CRS_CURR_CD, SAD.ADJ_CRS_CURR_AMT)) AS ADJ_CRS_CURR_AMT," ).append("\n"); 
		query.append("	   SAD.OTS_ADJ_SEQ," ).append("\n"); 
		query.append("	   SAD.ADJ_TP_CD" ).append("\n"); 
		query.append("FROM SAR_ADJ_DTL SAD," ).append("\n"); 
		query.append("     SAR_ADJ_HDR SAH	     	     " ).append("\n"); 
		query.append("WHERE SAD.OTS_ADJ_SEQ = SAH.OTS_ADJ_SEQ" ).append("\n"); 
		query.append("AND SAH.ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("#if (${adjt_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND sah.adj_ofc_cd =  @[adjt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("	SAD.CHG_TP_CD," ).append("\n"); 
		query.append("	SAD.ADJ_SRC_CURR_CD" ).append("\n"); 

	}
}