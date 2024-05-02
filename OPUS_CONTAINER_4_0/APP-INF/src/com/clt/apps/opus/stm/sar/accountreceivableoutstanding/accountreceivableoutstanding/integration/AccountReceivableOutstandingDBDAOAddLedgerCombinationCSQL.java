/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOAddLedgerCombinationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOAddLedgerCombinationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add ledger combination info
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOAddLedgerCombinationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgm_ctnt12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOAddLedgerCombinationCSQL").append("\n"); 
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
		query.append("INSERT INTO SCO_LEGR_CD_CMB ( " ).append("\n"); 
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
		query.append("    , SGM_CTNT7" ).append("\n"); 
		query.append("    , SGM_CTNT8" ).append("\n"); 
		query.append("    , SGM_CTNT9" ).append("\n"); 
		query.append("    , SGM_CTNT10" ).append("\n"); 
		query.append("    , SGM_CTNT11" ).append("\n"); 
		query.append("    , SGM_CTNT12" ).append("\n"); 
		query.append("    , SGM_CTNT13" ).append("\n"); 
		query.append("    , SGM_CTNT14" ).append("\n"); 
		query.append("    , SGM_CTNT15" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , COA_ST_DT" ).append("\n"); 
		query.append("    , COA_END_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    SCO_LEGR_CD_CMB_SEQ.NEXTVAL" ).append("\n"); 
		query.append("    , '1'" ).append("\n"); 
		query.append("    , (SELECT ACCTG_MNG_TP_CD FROM MDM_ACCOUNT MA WHERE MA.ACCT_CD = @[sgm_ctnt4] )" ).append("\n"); 
		query.append("    , 'Y'" ).append("\n"); 
		query.append("    , @[sgm_ctnt1]" ).append("\n"); 
		query.append("    , @[sgm_ctnt2]" ).append("\n"); 
		query.append("    , @[sgm_ctnt3]" ).append("\n"); 
		query.append("    , @[sgm_ctnt4]" ).append("\n"); 
		query.append("    , @[sgm_ctnt5]" ).append("\n"); 
		query.append("    , NVL((SELECT ATTR_CTNT3" ).append("\n"); 
		query.append("		   FROM SCO_LU_DTL" ).append("\n"); 
		query.append("		   WHERE LU_TP_CD = 'NO REV VVD ACCT'" ).append("\n"); 
		query.append("		   AND @[sgm_ctnt4] BETWEEN ATTR_CTNT1 AND ATTR_CTNT2), @[sgm_ctnt6])" ).append("\n"); 
		query.append("    , @[sgm_ctnt7]" ).append("\n"); 
		query.append("    , @[sgm_ctnt8]" ).append("\n"); 
		query.append("    , @[sgm_ctnt9]" ).append("\n"); 
		query.append("    , @[sgm_ctnt10]" ).append("\n"); 
		query.append("    , @[sgm_ctnt11]" ).append("\n"); 
		query.append("    , @[sgm_ctnt12]" ).append("\n"); 
		query.append("    , @[sgm_ctnt13]" ).append("\n"); 
		query.append("    , @[sgm_ctnt14]" ).append("\n"); 
		query.append("    , @[sgm_ctnt15]" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , 'SYSTEM'" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[coa_st_dt]" ).append("\n"); 
		query.append("    , @[coa_end_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}