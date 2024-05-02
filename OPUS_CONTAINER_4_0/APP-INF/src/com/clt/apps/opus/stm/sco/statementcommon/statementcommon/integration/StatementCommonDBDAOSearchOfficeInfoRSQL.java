/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchOfficeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Combo Search
	  * </pre>
	  */
	public StatementCommonDBDAOSearchOfficeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchOfficeInfoRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD," ).append("\n"); 
		query.append("       OFC_ENTR_LVL_CD," ).append("\n"); 
		query.append("       OFC_INQ_LVL_CD," ).append("\n"); 
		query.append("       OFC_BRNC_AGN_TP_CD," ).append("\n"); 
		query.append("       BANK_CTRL_CD," ).append("\n"); 
		query.append("       BANK_CHG_ACCT_CD," ).append("\n"); 
		query.append("       LOCL_CURR_CD," ).append("\n"); 
		query.append("       AGN_CMB_CD," ).append("\n"); 
		query.append("       AGN_PFX_CD," ).append("\n"); 
		query.append("       AGN_CURR_CD," ).append("\n"); 
		query.append("       AGN_OTS_LMT_AMT," ).append("\n"); 
		query.append("       AGN_OTS_LMT_FLG," ).append("\n"); 
		query.append("       OTS_CATE_CD," ).append("\n"); 
		query.append("       OTS_CD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       OVPAY_TP_CD," ).append("\n"); 
		query.append("       MISC_LSS_LMT_AMT," ).append("\n"); 
		query.append("       MISC_INCM_LMT_AMT," ).append("\n"); 
		query.append("       OTS_IF_FLG," ).append("\n"); 
		query.append("       REP_OTS_OFC_CD," ).append("\n"); 
		query.append("       ENBL_FLG," ).append("\n"); 
		query.append("       RCT_TP_CD," ).append("\n"); 
		query.append("       RCT_DOC_CD," ).append("\n"); 
		query.append("       RCT_UNAPY_FLG," ).append("\n"); 
		query.append("       BANK_OFC," ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("       RCT_OFC_TIT_NM," ).append("\n"); 
		query.append("       RCT_OFC_ADDR," ).append("\n"); 
		query.append("       RCT_OFC_TELCM_FAX_NO_CTNT," ).append("\n"); 
		query.append("       RCT_TIT_NM," ).append("\n"); 
		query.append("       RCT_RMK," ).append("\n"); 
		query.append("       RCT_SPCL_RMK," ).append("\n"); 
		query.append("       RCT_OFC_SPCL_NO_CTNT,  " ).append("\n"); 
		query.append("       AR_PRN_TIT_NM," ).append("\n"); 
		query.append("       AR_CR_CUST_PRN_CTNT," ).append("\n"); 
		query.append("       AR_PRN_CTNT,        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       OFC_WRTF_TP_CD1," ).append("\n"); 
		query.append("       OFC_WRTF_TP_CD2," ).append("\n"); 
		query.append("       OFC_WRTF_TP_CD3," ).append("\n"); 
		query.append("       OFC_WRTF_TP_CD4," ).append("\n"); 
		query.append("       OFC_WRTF_TP_CD5," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   OFC_ADJ_TP_CD1," ).append("\n"); 
		query.append("       OFC_ADJ_TP_CD2," ).append("\n"); 
		query.append("       OFC_ADJ_TP_CD3," ).append("\n"); 
		query.append("       OFC_ADJ_TP_CD4," ).append("\n"); 
		query.append("       OFC_ADJ_TP_CD5," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT," ).append("\n"); 
		query.append("       REF_EML" ).append("\n"); 
		query.append("  FROM SCO_OFC_INFO" ).append("\n"); 
		query.append(" WHERE OFC_CD = @[mdm_ofc_cd]" ).append("\n"); 

	}
}