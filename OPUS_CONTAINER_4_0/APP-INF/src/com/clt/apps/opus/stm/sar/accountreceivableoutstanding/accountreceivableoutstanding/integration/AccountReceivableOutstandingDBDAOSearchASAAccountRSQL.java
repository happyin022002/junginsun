/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchASAAccountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.14 
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

public class AccountReceivableOutstandingDBDAOSearchASAAccountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search ASA Account
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchASAAccountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rec_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_acct_mtx_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchASAAccountRSQL").append("\n"); 
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
		query.append("SELECT B.SGM_CTNT1" ).append("\n"); 
		query.append("       , B.SGM_CTNT2" ).append("\n"); 
		query.append("       , DECODE(@[acct_ctnt1], 'SYS', DECODE(A.ACCT_CTNT2, '', B.SGM_CTNT3, A.ACCT_CTNT2), B.SGM_CTNT3) SGM_CTNT3" ).append("\n"); 
		query.append("       , DECODE(@[acct_tp_cd], 'EXCH_GAIN', A.LEGR_XCH_DIFF_INCM_ACCT_CD, 'EXCH_LOSS', A.LEGR_XCH_DIFF_LSS_ACCT_CD, A.AR_ACCT_CD) SGM_CTNT4" ).append("\n"); 
		query.append("       , DECODE(@[acct_ctnt1], 'SYS', DECODE(A.ACCT_CTNT3, '', B.SGM_CTNT5, A.ACCT_CTNT3), B.SGM_CTNT5) SGM_CTNT5" ).append("\n"); 
		query.append("       , B.SGM_CTNT6" ).append("\n"); 
		query.append("	   , @[gl_dt] GL_DT" ).append("\n"); 
		query.append("FROM SAR_ACCT_MTX A," ).append("\n"); 
		query.append("     SCO_LEGR_CD_CMB B" ).append("\n"); 
		query.append("WHERE B.CD_CMB_SEQ = @[rec_cd_cmb_seq]" ).append("\n"); 
		query.append("#if (${acct_ctnt1} == 'REV')" ).append("\n"); 
		query.append("	AND A.ACCT_MTX_SEQ = @[rev_acct_mtx_seq]" ).append("\n"); 
		query.append("#elseif (${acct_ctnt1} == 'SYS')" ).append("\n"); 
		query.append("    AND A.ACCT_CTNT1 = @[acct_ctnt1]" ).append("\n"); 
		query.append("    AND A.ACCT_TP_CD = @[acct_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND @[gl_dt] BETWEEN NVL(A.ACCT_ST_DT, @[gl_dt]) AND NVL(A.ACCT_END_DT, @[gl_dt])" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND @[gl_dt] BETWEEN NVL(B.COA_ST_DT, @[gl_dt]) AND NVL(B.COA_END_DT, @[gl_dt])" ).append("\n"); 
		query.append("AND B.ENBL_FLG = 'Y'" ).append("\n"); 

	}
}