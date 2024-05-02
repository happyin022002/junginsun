/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchBankBranchCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchBankBranchCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableCommonDBDAOSearchBankBranchCodeListRSQL
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchBankBranchCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brnc_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brnc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_brnc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchBankBranchCodeListRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("    A.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("    ,A.BANK_NM" ).append("\n"); 
		query.append("    ,A.BANK_ALTN_NM" ).append("\n"); 
		query.append("    ,A.BANK_NO" ).append("\n"); 
		query.append("    ,A.BANK_BRNC_NM" ).append("\n"); 
		query.append("    ,A.BANK_BRNC_ALTN_NM" ).append("\n"); 
		query.append("    ,A.BRNC_NO" ).append("\n"); 
		query.append("    ,A.BANK_BRNC_TP_NM" ).append("\n"); 
		query.append("    ,A.BANK_END_DT" ).append("\n"); 
		query.append("    ,A.BANK_BRNC_DESC" ).append("\n"); 
		query.append("    ,A.BRNC_CNT_CD" ).append("\n"); 
		query.append("    ,B.CNT_NM AS  BRNC_CNT_NM" ).append("\n"); 
		query.append("    ,A.BANK_ADDR1" ).append("\n"); 
		query.append("    ,A.BANK_ADDR2" ).append("\n"); 
		query.append("    ,A.CNTC_NM" ).append("\n"); 
		query.append("    ,A.CNTC_TIT_NM" ).append("\n"); 
		query.append("    ,A.CNTC_PFX_CD" ).append("\n"); 
		query.append("    ,A.CNTC_PHN_NO" ).append("\n"); 
		query.append("    ,A.CNTC_EML" ).append("\n"); 
		query.append("FROM SAP_BANK_BRNC A, MDM_COUNTRY B" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("	AND A.BRNC_CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("	#if     (${bank_brnc_nm} != '')" ).append("\n"); 
		query.append("	AND A.BANK_BRNC_NM LIKE @[bank_brnc_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if     (${brnc_no} != '')" ).append("\n"); 
		query.append("	AND A.BRNC_NO LIKE @[brnc_no]||'%'  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if     (${brnc_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND A.BRNC_CNT_CD = @[brnc_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if     (${bank_nm} != '')" ).append("\n"); 
		query.append("	AND A.BANK_NM LIKE @[bank_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if     (${bank_no} != '')" ).append("\n"); 
		query.append("	AND A.BANK_NO LIKE @[bank_no]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 

	}
}