/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbNextSeqRSQL.java
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

public class AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbNextSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get Next Code Combination Sequence No for AP DTL IF
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbNextSeqRSQL(){
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
		query.append("FileName : AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbNextSeqRSQL").append("\n"); 
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
		query.append("SELECT SLCC2.CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB SLCC1, " ).append("\n"); 
		query.append("	 SCO_LEGR_CD_CMB SLCC2," ).append("\n"); 
		query.append("     SAR_ACCT_MTX SAM" ).append("\n"); 
		query.append("WHERE SLCC1.SGM_CTNT1 = SLCC2.SGM_CTNT1" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT2 = SLCC2.SGM_CTNT2" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT3 = SLCC2.SGM_CTNT3" ).append("\n"); 
		query.append("#if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("	AND SLCC2.SGM_CTNT4 = DECODE(SUBSTR(${gain_and_lss_amt} ,1,1), '-', SAM.LEGR_XCH_DIFF_INCM_ACCT_CD, SAM.LEGR_XCH_DIFF_LSS_ACCT_CD )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND SLCC2.SGM_CTNT4 = DECODE(SUBSTR(${gain_and_lss_amt} ,1,1), '-', SAM.LEGR_XCH_DIFF_LSS_ACCT_CD, SAM.LEGR_XCH_DIFF_INCM_ACCT_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT5 = SLCC2.SGM_CTNT5" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT6 = SLCC2.SGM_CTNT6" ).append("\n"); 
		query.append("AND SLCC1.CD_CMB_SEQ = @[dtrb_cd_cmb_seq]" ).append("\n"); 
		query.append("AND SAM.ACCT_CTNT1 ='ADJ'" ).append("\n"); 
		query.append("AND SAM.ACCT_TP_CD = @[adj_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sys_tp_cd} == 'OFF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SLCC2.CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB SLCC1, " ).append("\n"); 
		query.append("	 SCO_LEGR_CD_CMB SLCC2," ).append("\n"); 
		query.append("     SAR_ACCT_MTX SAM" ).append("\n"); 
		query.append("WHERE SLCC1.SGM_CTNT1 = SLCC2.SGM_CTNT1" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT2 = SLCC2.SGM_CTNT2" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT3 = SLCC2.SGM_CTNT3" ).append("\n"); 
		query.append("AND SLCC2.SGM_CTNT4 = @[off_gain_and_lss_acct_cd]" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT5 = SLCC2.SGM_CTNT5" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT6 = SLCC2.SGM_CTNT6" ).append("\n"); 
		query.append("AND SLCC1.CD_CMB_SEQ = @[dtrb_cd_cmb_seq]" ).append("\n"); 
		query.append("AND SAM.ACCT_CTNT1 ='ADJ'" ).append("\n"); 
		query.append("AND SAM.ACCT_TP_CD = @[adj_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}