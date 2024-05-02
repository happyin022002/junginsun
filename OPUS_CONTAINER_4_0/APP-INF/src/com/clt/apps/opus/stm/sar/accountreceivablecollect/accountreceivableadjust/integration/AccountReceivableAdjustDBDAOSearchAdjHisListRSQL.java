/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchAdjHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
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

public class AccountReceivableAdjustDBDAOSearchAdjHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get Adjust History List
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchAdjHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchAdjHisListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    ADJ_HIS_SEQ," ).append("\n"); 
		query.append("    ADJ_NO," ).append("\n"); 
		query.append("    ADJ_STS_CD," ).append("\n"); 
		query.append("    ADJ_AMT," ).append("\n"); 
		query.append("    ADJ_APLY_DT," ).append("\n"); 
		query.append("    ADJ_GL_DT," ).append("\n"); 
		query.append("    ADJ_CD_CMB_SEQ," ).append("\n"); 
		query.append("    CHG_TP_CD," ).append("\n"); 
		query.append("    ADJ_TP_CD," ).append("\n"); 
		query.append("    ADJ_RMK," ).append("\n"); 
		query.append("    GL_TRNS_SEQ," ).append("\n"); 
		query.append("    GL_TRNS_DT," ).append("\n"); 
		query.append("    ADJ_ACCT_AMT," ).append("\n"); 
		query.append("    ORZ_SEQ," ).append("\n"); 
		query.append("    ACCTG_EVNT_SEQ," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    OTS_HIS_SEQ," ).append("\n"); 
		query.append("    ACCT_MTX_SEQ," ).append("\n"); 
		query.append("    ADJ_KEY_NO," ).append("\n"); 
		query.append("	ADJ_CRS_CURR_AMT," ).append("\n"); 
		query.append("    ADJ_CRS_CURR_CD," ).append("\n"); 
		query.append("	GL_CRS_CURR_AMT," ).append("\n"); 
		query.append("    GL_CRS_CURR_CD," ).append("\n"); 
		query.append("	GL_CRS_EX_RATE " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    SAR_ADJ_HIS" ).append("\n"); 
		query.append("WHERE ADJ_HIS_SEQ = @[adj_his_seq]" ).append("\n"); 

	}
}