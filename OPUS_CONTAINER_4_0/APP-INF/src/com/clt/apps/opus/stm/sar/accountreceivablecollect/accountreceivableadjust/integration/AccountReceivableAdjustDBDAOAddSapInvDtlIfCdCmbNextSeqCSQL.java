/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOAddSapInvDtlIfCdCmbNextSeqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
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

public class AccountReceivableAdjustDBDAOAddSapInvDtlIfCdCmbNextSeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임시 로직 Insert SCO_LEGR_CD_CMB table
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOAddSapInvDtlIfCdCmbNextSeqCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_gain_and_lss_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOAddSapInvDtlIfCdCmbNextSeqCSQL").append("\n"); 
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
		query.append("#if(${sys_tp_cd} == 'ADJ')" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("	, SGM_CTNT6" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    SCO_LEGR_CD_CMB_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , '1'" ).append("\n"); 
		query.append("	#if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("    	, (SELECT ACCTG_MNG_TP_CD FROM MDM_ACCOUNT MA WHERE MA.ACCT_CD = (SELECT DECODE(SUBSTR(${gain_and_lss_amt} ,1,1), '-', LEGR_XCH_DIFF_INCM_ACCT_CD, LEGR_XCH_DIFF_LSS_ACCT_CD ) FROM SAR_ACCT_MTX WHERE ACCT_CTNT1 = 'ADJ' AND ACCT_TP_CD = @[adj_tp_cd]))" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		, (SELECT ACCTG_MNG_TP_CD FROM MDM_ACCOUNT MA WHERE MA.ACCT_CD = (SELECT DECODE(SUBSTR(${gain_and_lss_amt} ,1,1), '-', LEGR_XCH_DIFF_LSS_ACCT_CD, LEGR_XCH_DIFF_INCM_ACCT_CD ) FROM SAR_ACCT_MTX WHERE ACCT_CTNT1 = 'ADJ' AND ACCT_TP_CD = @[adj_tp_cd]))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , SGM_CTNT1" ).append("\n"); 
		query.append("    , SGM_CTNT2" ).append("\n"); 
		query.append("    , SGM_CTNT3" ).append("\n"); 
		query.append("	#if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("    	, (SELECT DECODE(SUBSTR(${gain_and_lss_amt} ,1,1), '-', LEGR_XCH_DIFF_INCM_ACCT_CD, LEGR_XCH_DIFF_LSS_ACCT_CD ) FROM SAR_ACCT_MTX WHERE ACCT_CTNT1 = 'ADJ' AND ACCT_TP_CD = @[adj_tp_cd])" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		, (SELECT DECODE(SUBSTR(${gain_and_lss_amt} ,1,1), '-', LEGR_XCH_DIFF_LSS_ACCT_CD, LEGR_XCH_DIFF_INCM_ACCT_CD ) FROM SAR_ACCT_MTX WHERE ACCT_CTNT1 = 'ADJ' AND ACCT_TP_CD = @[adj_tp_cd])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    , SGM_CTNT5" ).append("\n"); 
		query.append("	, SGM_CTNT6" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB" ).append("\n"); 
		query.append("WHERE CD_CMB_SEQ = @[dtrb_cd_cmb_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sys_tp_cd} == 'OFF')" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("	, SGM_CTNT6" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    SCO_LEGR_CD_CMB_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , '1'" ).append("\n"); 
		query.append("    , (SELECT ACCTG_MNG_TP_CD FROM MDM_ACCOUNT MA WHERE MA.ACCT_CD = @[off_gain_and_lss_acct_cd])" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , SGM_CTNT1" ).append("\n"); 
		query.append("    , SGM_CTNT2" ).append("\n"); 
		query.append("    , SGM_CTNT3" ).append("\n"); 
		query.append("    , @[off_gain_and_lss_acct_cd]" ).append("\n"); 
		query.append("    , SGM_CTNT5" ).append("\n"); 
		query.append("	, SGM_CTNT6" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB" ).append("\n"); 
		query.append("WHERE CD_CMB_SEQ = @[dtrb_cd_cmb_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}