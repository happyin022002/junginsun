/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommAgreementDBDAOAddAgentRateMasterHistoryListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2014.09.30 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOAddAgentRateMasterHistoryListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAgentRateMasterHistoryList
	  * </pre>
	  */
	public AGNCommAgreementDBDAOAddAgentRateMasterHistoryListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_fm_dt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_his_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_to_dt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOAddAgentRateMasterHistoryListCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_AGMT_MST_HIS" ).append("\n"); 
		query.append("       (AGN_CD," ).append("\n"); 
		query.append("        AGN_AGMT_NO," ).append("\n"); 
		query.append("        AGMT_HIS_NO," ).append("\n"); 
		query.append("        AGMT_FM_DT_CD," ).append("\n"); 
		query.append("        AGMT_FM_DT," ).append("\n"); 
		query.append("        AGMT_TO_DT_CD," ).append("\n"); 
		query.append("        AGMT_TO_DT," ).append("\n"); 
		query.append("        AGN_AGMT_RMK," ).append("\n"); 
		query.append("        DELT_FLG," ).append("\n"); 
		query.append("        CRE_GDT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT,AGMT_DOC_NO,AGMT_DOC_DESC)" ).append("\n"); 
		query.append("VALUES (@[agn_cd]," ).append("\n"); 
		query.append("        @[agn_agmt_no],        " ).append("\n"); 
		query.append("        @[agmt_his_no]," ).append("\n"); 
		query.append("        @[agmt_fm_dt_cd]," ).append("\n"); 
		query.append("        @[agmt_fm_dt]," ).append("\n"); 
		query.append("        @[agmt_to_dt_cd]," ).append("\n"); 
		query.append("        @[agmt_to_dt]," ).append("\n"); 
		query.append("        @[agn_agmt_rmk]," ).append("\n"); 
		query.append("        @[delt_flg]," ).append("\n"); 
		query.append("        GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'GMT')," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[usr_id]," ).append("\n"); 
		query.append("        SYSDATE,@[agmt_doc_no],@[agmt_doc_desc])" ).append("\n"); 

	}
}