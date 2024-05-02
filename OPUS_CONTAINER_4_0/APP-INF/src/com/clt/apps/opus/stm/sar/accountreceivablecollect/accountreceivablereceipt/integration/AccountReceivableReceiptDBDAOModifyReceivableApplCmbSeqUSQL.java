/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOModifyReceivableApplCmbSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.19 
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

public class AccountReceivableReceiptDBDAOModifyReceivableApplCmbSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify receivable application's combination sequence
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOModifyReceivableApplCmbSeqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_appl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_mtx_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_rcv_appl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOModifyReceivableApplCmbSeqUSQL").append("\n"); 
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
		query.append("UPDATE SAR_RCV_APPL SET" ).append("\n"); 
		query.append("	RCV_CD_CMB_SEQ = DECODE(@[rcv_cd_cmb_seq], '-1', (SELECT RCV_CD_CMB_SEQ FROM SAR_RCV_APPL WHERE RCV_APPL_SEQ = @[tgt_rcv_appl_seq]), @[rcv_cd_cmb_seq])" ).append("\n"); 
		query.append("	, ACCT_MTX_SEQ = DECODE(@[acct_mtx_seq], '', (SELECT ACCT_MTX_SEQ FROM SAR_RCV_APPL WHERE RCV_APPL_SEQ = @[tgt_rcv_appl_seq]), @[acct_mtx_seq])" ).append("\n"); 
		query.append("WHERE RCV_APPL_SEQ = @[rcv_appl_seq]" ).append("\n"); 

	}
}