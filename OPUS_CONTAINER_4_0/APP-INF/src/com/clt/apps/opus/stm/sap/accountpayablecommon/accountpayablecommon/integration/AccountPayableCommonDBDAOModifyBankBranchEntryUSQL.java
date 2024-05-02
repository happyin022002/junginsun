/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOModifyBankBranchEntryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.07 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOModifyBankBranchEntryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableCommonDBDAOModifyBankBranchEntryUSQL
	  * </pre>
	  */
	public AccountPayableCommonDBDAOModifyBankBranchEntryUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_brnc_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_altn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_brnc_altn_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_brnc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_brnc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration ").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOModifyBankBranchEntryUSQL").append("\n"); 
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
		query.append("UPDATE SAP_BANK_BRNC" ).append("\n"); 
		query.append("SET  BANK_NM = @[bank_nm]" ).append("\n"); 
		query.append("    ,BANK_ALTN_NM = @[bank_altn_nm]" ).append("\n"); 
		query.append("    ,BANK_NO = @[bank_no]" ).append("\n"); 
		query.append("    ,BANK_BRNC_NM = @[bank_brnc_nm]" ).append("\n"); 
		query.append("    ,BANK_BRNC_ALTN_NM = @[bank_brnc_altn_nm]" ).append("\n"); 
		query.append("    ,BRNC_NO = @[brnc_no]" ).append("\n"); 
		query.append("    ,BANK_BRNC_TP_NM = @[bank_brnc_tp_nm]" ).append("\n"); 
		query.append("    ,BANK_END_DT = REPLACE(@[bank_end_dt], '-', '')" ).append("\n"); 
		query.append("    ,BANK_BRNC_DESC = @[bank_brnc_desc]" ).append("\n"); 
		query.append("    ,BRNC_CNT_CD = @[brnc_cnt_cd]" ).append("\n"); 
		query.append("    ,BANK_ADDR1 = @[bank_addr1]" ).append("\n"); 
		query.append("    ,CNTC_NM = @[cntc_nm]" ).append("\n"); 
		query.append("    ,CNTC_TIT_NM = @[cntc_tit_nm]" ).append("\n"); 
		query.append("    ,CNTC_PFX_CD = @[cntc_pfx_cd]" ).append("\n"); 
		query.append("    ,CNTC_PHN_NO = @[cntc_phn_no]" ).append("\n"); 
		query.append("    ,CNTC_EML = @[cntc_eml]" ).append("\n"); 
		query.append("    ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,UPD_DT = SYSDATE   " ).append("\n"); 
		query.append("WHERE BANK_BRNC_SEQ = @[bank_brnc_seq]" ).append("\n"); 

	}
}