/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOmodifyReceiptMainUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOmodifyReceiptMainUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receipt Main 정보 Update
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOmodifyReceiptMainUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_rct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOmodifyReceiptMainUSQL").append("\n"); 
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
		query.append("UPDATE SAR_RECEIPT SET" ).append("\n"); 
		query.append("	RCT_CUST_CNT_CD = @[rct_cust_cnt_cd]" ).append("\n"); 
		query.append("	, RCT_CUST_SEQ = TO_NUMBER(@[rct_cust_seq])" ).append("\n"); 
		query.append("	, BAL_RCT_AMT = @[bal_rct_amt]" ).append("\n"); 
		query.append("	, RCT_STS_CD = @[rct_sts_cd]" ).append("\n"); 
		query.append("	, RCT_RMK = @[rct_rmk]" ).append("\n"); 
		query.append("	, BANK_CHG_AMT = @[bank_chg_amt]" ).append("\n"); 
		query.append("	, AGN_OFC_CD = @[agn_ofc_cd]" ).append("\n"); 
		query.append("	, AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("	, ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("	, UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	, UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE RCT_SEQ = @[rct_seq]" ).append("\n"); 

	}
}