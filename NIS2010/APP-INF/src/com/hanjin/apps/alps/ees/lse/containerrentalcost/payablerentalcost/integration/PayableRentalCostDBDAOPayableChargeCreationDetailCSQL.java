/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeCreationDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOPayableChargeCreationDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Charge Creation Detail Data Insert
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeCreationDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pd_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeCreationDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_PAY_RNTL_CHG_DTL (" ).append("\n"); 
		query.append("         CHG_SEQ" ).append("\n"); 
		query.append("       , CNTR_NO" ).append("\n"); 
		query.append("       , LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , DTL_SEQ" ).append("\n"); 
		query.append("       , AGMT_CTY_CD                             --05" ).append("\n"); 
		query.append("       , AGMT_SEQ" ).append("\n"); 
		query.append("       , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , ONH_DT" ).append("\n"); 
		query.append("       , OFFH_DT" ).append("\n"); 
		query.append("       , ONH_LOC_CD                              --10" ).append("\n"); 
		query.append("       , OFFH_LOC_CD" ).append("\n"); 
		query.append("       , CHG_FREE_DYS" ).append("\n"); 
		query.append("       , PD_RT_AMT" ).append("\n"); 
		query.append("       , TTL_COST_AMT" ).append("\n"); 
		query.append("       , CR_AMT                                  --15" ).append("\n"); 
		query.append("       , CNTR_AUD_STS_CD" ).append("\n"); 
		query.append("       , COST_DYS" ).append("\n"); 
		query.append("       , BIL_DYS" ).append("\n"); 
		query.append("       , DSCR_RT_AMT" ).append("\n"); 
		query.append("       , DSCR_COST_AMT                           --20" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       , ACCT_CD                                 --25" ).append("\n"); 
		query.append("       , COST_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   @[chg_seq]" ).append("\n"); 
		query.append("       , @[cntr_no]" ).append("\n"); 
		query.append("       , T21.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , NVL(MAX(T23.DTL_SEQ), 0) + 1" ).append("\n"); 
		query.append("       , T21.AGMT_CTY_CD                        --05" ).append("\n"); 
		query.append("       , T21.AGMT_SEQ" ).append("\n"); 
		query.append("       , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("       , TO_DATE(@[onh_dt] ,'YYYYMMDD')" ).append("\n"); 
		query.append("       , TO_DATE(@[offh_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("       , @[onh_loc_cd]                          --10" ).append("\n"); 
		query.append("       , @[offh_loc_cd]" ).append("\n"); 
		query.append("       , @[chg_free_dys]" ).append("\n"); 
		query.append("       , @[pd_rt_amt]" ).append("\n"); 
		query.append("       , @[ttl_cost_amt]" ).append("\n"); 
		query.append("       , 0                                      --15" ).append("\n"); 
		query.append("       , 'H'" ).append("\n"); 
		query.append("       , @[cost_dys]" ).append("\n"); 
		query.append("       , @[bil_dys]" ).append("\n"); 
		query.append("       , 0" ).append("\n"); 
		query.append("       , 0                                      --20" ).append("\n"); 
		query.append("       , @[cre_usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[upd_usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , NVL(T21.ACCT_CD, T22.ACCT_CD)          --25" ).append("\n"); 
		query.append("       , NVL(T21.COST_CD, T22.COST_CD)" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   T11.AGMT_CTY_CD" ).append("\n"); 
		query.append("                  , T11.AGMT_SEQ" ).append("\n"); 
		query.append("                  , T11.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                  , T11.LSTM_CD" ).append("\n"); 
		query.append("                  , T12.ACCT_CD" ).append("\n"); 
		query.append("                  , T12.COST_CD" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   @[agmt_cty_cd]          AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                             , @[agmt_seq]             AS AGMT_SEQ" ).append("\n"); 
		query.append("                             , @[lse_pay_chg_tp_cd]    AS LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                             , LSTM_CD" ).append("\n"); 
		query.append("                      FROM     LSE_AGREEMENT" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      AGMT_CTY_CD          = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                      AND      AGMT_SEQ             = @[agmt_seq]" ).append("\n"); 
		query.append("                    ) T11" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   LSE_RCV_CHG_TP_CD" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , LSTM_CD" ).append("\n"); 
		query.append("                             , COST_CD" ).append("\n"); 
		query.append("                      FROM     LSE_RNTL_COST_ACCT_ORD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT   LSE_RCV_CHG_TP_CD" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , 'BX'" ).append("\n"); 
		query.append("                             , COST_CD" ).append("\n"); 
		query.append("                      FROM     LSE_RNTL_COST_ACCT_ORD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT   LSE_RCV_CHG_TP_CD" ).append("\n"); 
		query.append("                             , ACCT_CD" ).append("\n"); 
		query.append("                             , LSTM_CD" ).append("\n"); 
		query.append("                             , COST_CD" ).append("\n"); 
		query.append("                      FROM     (" ).append("\n"); 
		query.append("                                 SELECT   T1.LSE_RCV_CHG_TP_CD" ).append("\n"); 
		query.append("                                        , T1.LSTM_CD    AS ZZZ" ).append("\n"); 
		query.append("                                        , T1.ACCT_CD" ).append("\n"); 
		query.append("                                        , T1.COST_CD" ).append("\n"); 
		query.append("                                        , T2.LSTM_CD" ).append("\n"); 
		query.append("                                 FROM     LSE_RNTL_COST_ACCT_ORD T1" ).append("\n"); 
		query.append("                                        , MST_LSE_TERM           T2" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      T1.LSTM_CD IN('XX', T2.LSTM_CD)" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      ( LSE_RCV_CHG_TP_CD, ZZZ, LSTM_CD ) NOT IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT   S1.LSE_RCV_CHG_TP_CD" ).append("\n"); 
		query.append("                                        , 'XX'" ).append("\n"); 
		query.append("                                        , S2.LSTM_CD" ).append("\n"); 
		query.append("                                 FROM     LSE_RNTL_COST_ACCT_ORD S1" ).append("\n"); 
		query.append("                                        , MST_LSE_TERM           S2" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      S1.LSTM_CD = S2.LSTM_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                    ) T12" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      T11.LSTM_CD              = T12.LSTM_CD          (+)" ).append("\n"); 
		query.append("           AND      T11.LSE_PAY_CHG_TP_CD    = T12.LSE_RCV_CHG_TP_CD(+)" ).append("\n"); 
		query.append("         )                       T21" ).append("\n"); 
		query.append("       , LSE_RNTL_COST_ACCT_ORD  T22" ).append("\n"); 
		query.append("       , LSE_PAY_RNTL_CHG_DTL    T23" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      NVL2(T21.ACCT_CD, T21.LSE_PAY_CHG_TP_CD, 'XXX') = T22.LSE_RCV_CHG_TP_CD (+)" ).append("\n"); 
		query.append("AND      CASE WHEN T21.ACCT_CD IS NULL AND T21.LSTM_CD IN('ST', 'LT') THEN T21.LSTM_CD ELSE 'XX' END = T22.LSTM_CD (+)" ).append("\n"); 
		query.append("AND      T23.CHG_SEQ             (+) = @[chg_seq]" ).append("\n"); 
		query.append("AND      T23.CNTR_NO             (+) = @[cntr_no]" ).append("\n"); 
		query.append("AND      T23.LSE_PAY_CHG_TP_CD   (+) = T21.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("GROUP BY T21.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("       , T21.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , T21.AGMT_SEQ" ).append("\n"); 
		query.append("       , NVL(T21.ACCT_CD, T22.ACCT_CD)" ).append("\n"); 
		query.append("       , NVL(T21.COST_CD, T22.COST_CD)" ).append("\n"); 

	}
}