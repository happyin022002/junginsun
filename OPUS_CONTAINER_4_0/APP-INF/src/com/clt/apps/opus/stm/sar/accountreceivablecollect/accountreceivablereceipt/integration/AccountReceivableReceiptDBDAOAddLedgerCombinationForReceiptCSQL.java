/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOAddLedgerCombinationForReceiptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.30 
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

public class AccountReceivableReceiptDBDAOAddLedgerCombinationForReceiptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Ledger Combination For Receipt
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOAddLedgerCombinationForReceiptCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOAddLedgerCombinationForReceiptCSQL").append("\n"); 
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
		query.append("INSERT INTO SCO_LEGR_CD_CMB" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    CD_CMB_SEQ" ).append("\n"); 
		query.append("    , COA_SEQ" ).append("\n"); 
		query.append("    , LEGR_ACCT_TP_CD" ).append("\n"); 
		query.append("    , ENBL_FLG" ).append("\n"); 
		query.append("    , SGM_CTNT1" ).append("\n"); 
		query.append("    , SGM_CTNT2" ).append("\n"); 
		query.append("    , SGM_CTNT3" ).append("\n"); 
		query.append("    , SGM_CTNT4" ).append("\n"); 
		query.append("    , SGM_CTNT5" ).append("\n"); 
		query.append("    , SGM_CTNT6" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SCO_LEGR_CD_CMB_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , '1'" ).append("\n"); 
		query.append("    , (SELECT ACCTG_MNG_TP_CD FROM MDM_ACCOUNT MA WHERE MA.ACCT_CD = @[ar_acct_cd])" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , SGM_CTNT1" ).append("\n"); 
		query.append("    , SGM_CTNT2" ).append("\n"); 
		query.append("    , DECODE(@[acct_ctnt2], '', SGM_CTNT3, @[acct_ctnt2])" ).append("\n"); 
		query.append("    , @[ar_acct_cd]" ).append("\n"); 
		query.append("    , DECODE(@[acct_ctnt1], 'SYS', DECODE(@[acct_ctnt3], '', SGM_CTNT5, @[acct_ctnt3]), SGM_CTNT5)" ).append("\n"); 
		query.append("    , DECODE(@[acct_ctnt1], 'WRTF', DECODE(@[acct_ctnt3], 'COM', 'CNTC0000MM', SGM_CTNT6), SGM_CTNT6)" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB" ).append("\n"); 
		query.append("WHERE CD_CMB_SEQ = @[aset_cd_cmb_seq]" ).append("\n"); 

	}
}