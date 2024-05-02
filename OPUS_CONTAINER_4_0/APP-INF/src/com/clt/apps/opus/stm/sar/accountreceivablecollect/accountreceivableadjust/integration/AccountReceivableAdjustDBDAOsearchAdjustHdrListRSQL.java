/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAdjustHdrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.14 
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

public class AccountReceivableAdjustDBDAOsearchAdjustHdrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve Outstanding Adjustment 
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAdjustHdrListRSQL(){
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
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAdjustHdrListRSQL").append("\n"); 
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
		query.append("SELECT SAH.BL_NO," ).append("\n"); 
		query.append("	   SAH.BKG_NO," ).append("\n"); 
		query.append("	   SAH.INV_NO," ).append("\n"); 
		query.append("	   SAH.INV_OFC_CD," ).append("\n"); 
		query.append("	   SAH.SHP_TO_CUST_CNT_CD||'-'||LPAD(SAH.BIL_TO_CUST_SEQ, 6, '0') AS BIL_TO_CUST_CD," ).append("\n"); 
		query.append("	   SAH.LOCL_VVD_CD," ).append("\n"); 
		query.append("	   SAH.OTS_ADJ_SEQ," ).append("\n"); 
		query.append("	   SAH.SHP_TO_CUST_CNT_CD AS BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("	   SAH.BIL_TO_CUST_SEQ," ).append("\n"); 
		query.append("	   SAH.ADJ_RMK," ).append("\n"); 
		query.append("	   SAH.RVS_FLG," ).append("\n"); 
		query.append("	   SAH.AP_OFC_CD," ).append("\n"); 
		query.append("	   SAH.ASA_NO," ).append("\n"); 
		query.append("	   SAH.VNDR_NO," ).append("\n"); 
		query.append("	   SAH.AP_CURR_CD," ).append("\n"); 
		query.append("	   SAH.AP_CRS_CURR_AMT," ).append("\n"); 
		query.append("	   SAH.GAIN_AND_LSS_AMT," ).append("\n"); 
		query.append("	   SAH.AP_RMK," ).append("\n"); 
		query.append("	   SAH.ADJ_DT," ).append("\n"); 
		query.append("	   ADJ_TP_CD" ).append("\n"); 
		query.append("	FROM SAR_ADJ_HDR SAH" ).append("\n"); 
		query.append(" WHERE SAH.ADJ_NO = @[adj_no]  " ).append("\n"); 
		query.append("#if (${adjt_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND sah.adj_ofc_cd =  @[adjt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}