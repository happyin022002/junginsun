/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchOutstandingForApplyAdjustRvsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
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

public class AccountReceivableAdjustDBDAOsearchOutstandingForApplyAdjustRvsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Target OTS for Apply and Adjust Reverse
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchOutstandingForApplyAdjustRvsRSQL(){
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
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchOutstandingForApplyAdjustRvsRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    A.ADJ_NO," ).append("\n"); 
		query.append("    A.ADJ_AMT * (-1) AS ADJ_AMT," ).append("\n"); 
		query.append("    A.ADJ_GL_DT," ).append("\n"); 
		query.append("    A.ADJ_CD_CMB_SEQ, " ).append("\n"); 
		query.append("    A.CHG_TP_CD," ).append("\n"); 
		query.append("    A.ADJ_TP_CD," ).append("\n"); 
		query.append("    A.ADJ_RMK," ).append("\n"); 
		query.append("    A.GL_TRNS_SEQ," ).append("\n"); 
		query.append("    A.GL_TRNS_DT," ).append("\n"); 
		query.append("    A.ORZ_SEQ," ).append("\n"); 
		query.append("    A.ACCTG_EVNT_SEQ," ).append("\n"); 
		query.append("    A.CRE_USR_ID," ).append("\n"); 
		query.append("    A.UPD_USR_ID," ).append("\n"); 
		query.append("    A.OTS_HIS_SEQ," ).append("\n"); 
		query.append("    A.ACCT_MTX_SEQ," ).append("\n"); 
		query.append("    A.ADJ_KEY_NO," ).append("\n"); 
		query.append("    C.ADJ_SRC_CURR_CD," ).append("\n"); 
		query.append("	A.ADJ_ACCT_AMT * (-1) AS ADJ_ACCT_AMT," ).append("\n"); 
		query.append("	A.ADJ_CRS_CURR_AMT * (-1) AS ADJ_CRS_CURR_AMT," ).append("\n"); 
		query.append("	A.ADJ_CRS_CURR_CD," ).append("\n"); 
		query.append("	A.AP_RMK," ).append("\n"); 
		query.append("	A.ADJ_OFC_CD, " ).append("\n"); 
		query.append("	A.GL_CRS_CURR_AMT * (-1) AS GL_CRS_CURR_AMT," ).append("\n"); 
		query.append("	A.GL_CRS_CURR_CD," ).append("\n"); 
		query.append("	A.GL_CRS_EX_RATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    SAR_ADJ_HIS A," ).append("\n"); 
		query.append("    SAR_ADJ_HDR B," ).append("\n"); 
		query.append("    SAR_ADJ_DTL C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.ADJ_NO = B.ADJ_NO" ).append("\n"); 
		query.append("AND A.CHG_TP_CD = C.CHG_TP_CD" ).append("\n"); 
		query.append("AND B.OTS_ADJ_SEQ = C.OTS_ADJ_SEQ" ).append("\n"); 
		query.append("AND A.ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("AND C.ADJ_SRC_CURR_CD = @[bl_curr_cd]" ).append("\n"); 
		query.append("AND C.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("     ADJ_HIS_SEQ" ).append("\n"); 

	}
}