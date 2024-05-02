/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOAddReverseCancelDistributionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.30 
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

public class AccountReceivableReceiptDBDAOAddReverseCancelDistributionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add reverse or cancel distribution
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOAddReverseCancelDistributionCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOAddReverseCancelDistributionCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_CLT_DTRB" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	CLT_DTRB_SEQ" ).append("\n"); 
		query.append("	, DTRB_SRC_SEQ" ).append("\n"); 
		query.append("	, DTRB_SRC_TBL_CD" ).append("\n"); 
		query.append("	, DTRB_SRC_TP_CD" ).append("\n"); 
		query.append("	, DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("	, INP_DR_AMT" ).append("\n"); 
		query.append("	, INP_CR_AMT" ).append("\n"); 
		query.append("	, ACCT_DR_AMT" ).append("\n"); 
		query.append("	, ACCT_CR_AMT" ).append("\n"); 
		query.append("	, ORZ_SEQ" ).append("\n"); 
		query.append("	, FM_DTRB_SRC_SEQ" ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, CONV_XCH_RT" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("	, CUST_CNT_CD" ).append("\n"); 
		query.append("	, CUST_SEQ" ).append("\n"); 
		query.append("	, RVS_SRC_SEQ" ).append("\n"); 
		query.append("	, FM_INP_DR_AMT" ).append("\n"); 
		query.append("	, FM_INP_CR_AMT" ).append("\n"); 
		query.append("	, FM_ACCT_DR_AMT" ).append("\n"); 
		query.append("	, FM_ACCT_CR_AMT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, AR_IF_SEQ" ).append("\n"); 
		query.append("	, AR_IF_STS_CD" ).append("\n"); 
		query.append("	, AR_IF_ERR_DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SAR_CLT_DTRB_SEQ.NEXTVAL" ).append("\n"); 
		query.append("	   , @[rcv_appl_seq]" ).append("\n"); 
		query.append("	   , DTRB_SRC_TBL_CD" ).append("\n"); 
		query.append("	   , DTRB_SRC_TP_CD" ).append("\n"); 
		query.append("	   , DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("	   , INP_CR_AMT" ).append("\n"); 
		query.append("	   , INP_DR_AMT" ).append("\n"); 
		query.append("	   , ACCT_CR_AMT" ).append("\n"); 
		query.append("	   , ACCT_DR_AMT" ).append("\n"); 
		query.append("	   , '-1'" ).append("\n"); 
		query.append("	   , DECODE(FM_DTRB_SRC_SEQ, NULL, NULL, @[rcv_appl_seq] - 1)" ).append("\n"); 
		query.append("	   , CURR_CD" ).append("\n"); 
		query.append("	   , CONV_XCH_RT" ).append("\n"); 
		query.append("	   , ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("	   , ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("	   , CUST_CNT_CD" ).append("\n"); 
		query.append("	   , CUST_SEQ" ).append("\n"); 
		query.append("	   , @[tgt_rcv_appl_seq]" ).append("\n"); 
		query.append("	   , NULL" ).append("\n"); 
		query.append("	   , NULL" ).append("\n"); 
		query.append("	   , NULL" ).append("\n"); 
		query.append("	   , NULL" ).append("\n"); 
		query.append("	   , @[cre_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("	   , @[upd_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("	   , NULL" ).append("\n"); 
		query.append("       , 'P'" ).append("\n"); 
		query.append("       , NULL" ).append("\n"); 
		query.append("FROM SAR_CLT_DTRB" ).append("\n"); 
		query.append("WHERE DTRB_SRC_SEQ = @[tgt_rcv_appl_seq]" ).append("\n"); 
		query.append("AND DTRB_SRC_TBL_CD = 'RCT'" ).append("\n"); 

	}
}