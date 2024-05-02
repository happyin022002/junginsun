/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchBankBranchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.03.31 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchBankBranchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBankBranchList
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchBankBranchListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_brnc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchBankBranchListRSQL").append("\n"); 
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
		query.append("    ,A.CRE_USR_ID" ).append("\n"); 
		query.append("    ,A.CRE_DT" ).append("\n"); 
		query.append("    ,A.UPD_USR_ID" ).append("\n"); 
		query.append("    ,A.UPD_DT    " ).append("\n"); 
		query.append("FROM SAP_BANK_BRNC A, MDM_COUNTRY B" ).append("\n"); 
		query.append("WHERE  BANK_BRNC_SEQ = @[bank_brnc_seq]" ).append("\n"); 
		query.append("    AND A.BRNC_CNT_CD = B.CNT_CD(+)" ).append("\n"); 

	}
}