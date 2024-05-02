/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchFFAGMTRateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOSearchFFAGMTRateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOSearchFFAGMTRateInfoRSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchFFAGMTRateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cust_seq_tmp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOSearchFFAGMTRateInfoRSQL").append("\n"); 
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
		query.append("SELECT A.FF_CNT_CD, TO_CHAR(A.FF_SEQ,'FM000000') FF_SEQ, " ).append("\n"); 
		query.append("	A.SHPR_CNT_CD, TO_CHAR(A.SHPR_SEQ, 'FM000000') SHPR_SEQ, " ).append("\n"); 
		query.append("	A.FF_DIV_CD, A.FF_BKG_RT, NVL(RTRIM(A.FF_CHG_CTNT), ' ') FF_CHG_CTNT, " ).append("\n"); 
		query.append("	NVL(A.FF_BX_AMT, 0) FF_BX_AMT, NVL(A.FF_TEU_AMT, 0) FF_TEU_AMT, NVL(A.FF_FEU_AMT, 0) FF_FEU_AMT, " ).append("\n"); 
		query.append("	NVL(A.FF_RF_AMT, 0) FF_RF_AMT, A.FM_EFF_DT, A.TO_EFF_DT, FF_AGMT_SEQ " ).append("\n"); 
		query.append("FROM ACM_FF_AGMT A " ).append("\n"); 
		query.append("WHERE A.FF_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n"); 
		query.append("	AND A.FF_SEQ = TO_NUMBER(NVL(@[ff_cust_seq_tmp],@[bkg_ff_seq]))" ).append("\n"); 
		query.append("	AND NVL(A.SHPR_CNT_CD, '*')||NVL(A.SHPR_SEQ, 0 ) = ( /* SHIPPER가 존재하는지 */ " ).append("\n"); 
		query.append("		SELECT MAX(X) " ).append("\n"); 
		query.append("		FROM ( " ).append("\n"); 
		query.append("				SELECT	NVL(SHPR_CNT_CD, '*')||NVL(SHPR_SEQ, 0 ) X " ).append("\n"); 
		query.append("				FROM ACM_FF_AGMT " ).append("\n"); 
		query.append("				WHERE FF_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n"); 
		query.append("					AND FF_SEQ = TO_NUMBER(NVL(@[ff_cust_seq_tmp],@[bkg_ff_seq]))" ).append("\n"); 
		query.append("					AND NVL(SHPR_CNT_CD, '*') IN (@[shpr_cnt_cd], '*') " ).append("\n"); 
		query.append("					AND NVL(SHPR_SEQ, 0 ) IN (@[shpr_cust_seq], 0) " ).append("\n"); 
		query.append("					AND FM_EFF_DT <= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND TO_EFF_DT >= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND NVL(SC_NO, '*') IN (@[sc_no], '*') " ).append("\n"); 
		query.append("					AND NVL(RFA_NO, '*') IN (@[rfa_no], '*') " ).append("\n"); 
		query.append("					AND NVL(CMDT_CD, '*') IN ('*',DECODE(CMDT_TP_CD, '2', @[rep_cmdt_cd], '3', @[cmdt_cd])) " ).append("\n"); 
		query.append("					AND NVL(POR_ROUT_CD, '*') = DECODE(NVL(POR_GRP_TP_CD, '*'), '5', @[por_cd], '4', @[por_rgn_cd], '3', @[por_cnt_cd], '2', @[por_sconti_cd], '1', @[por_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POL_ROUT_CD, '*') = DECODE(NVL(POL_GRP_TP_CD, '*'), '5', @[pol_cd], '4', @[pol_rgn_cd], '3', @[pol_cnt_cd], '2', @[pol_sconti_cd], '1', @[pol_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POD_ROUT_CD, '*') = DECODE(NVL(POD_GRP_TP_CD, '*'), '5', @[pod_cd], '4', @[pod_rgn_cd], '3', @[pod_cnt_cd], '2', @[pod_sconti_cd], '1', @[pod_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("	AND A.FM_EFF_DT <= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("	AND A.TO_EFF_DT >= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("	AND NVL(A.SC_NO, '*') = ( /* SC NO가 존재하는지 */ " ).append("\n"); 
		query.append("		SELECT MAX(X) " ).append("\n"); 
		query.append("		FROM ( " ).append("\n"); 
		query.append("				SELECT NVL(SC_NO, '*') X " ).append("\n"); 
		query.append("				FROM ACM_FF_AGMT " ).append("\n"); 
		query.append("				WHERE FF_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n"); 
		query.append("					AND FF_SEQ = TO_NUMBER(NVL(@[ff_cust_seq_tmp],@[bkg_ff_seq]))" ).append("\n"); 
		query.append("					AND NVL(SHPR_CNT_CD, '*') IN (@[shpr_cnt_cd], '*') " ).append("\n"); 
		query.append("					AND NVL(SHPR_SEQ, 0 ) IN (TO_NUMBER(@[shpr_cust_seq]), 0) " ).append("\n"); 
		query.append("					AND FM_EFF_DT <= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND TO_EFF_DT >= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND NVL(SC_NO, '*') IN (@[sc_no], '*') " ).append("\n"); 
		query.append("					AND NVL(RFA_NO, '*') IN (@[rfa_no], '*') " ).append("\n"); 
		query.append("					AND NVL(CMDT_CD, '*') IN ('*',DECODE(CMDT_TP_CD, '2', @[rep_cmdt_cd], '3', @[cmdt_cd])) " ).append("\n"); 
		query.append("					AND NVL(POR_ROUT_CD, '*') = DECODE(NVL(POR_GRP_TP_CD, '*'), '5', @[por_cd], '4', @[por_rgn_cd], '3', @[por_cnt_cd], '2', @[por_sconti_cd], '1', @[por_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POL_ROUT_CD, '*') = DECODE(NVL(POL_GRP_TP_CD, '*'), '5', @[pol_cd], '4', @[pol_rgn_cd], '3', @[pol_cnt_cd], '2', @[pol_sconti_cd], '1', @[pol_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POD_ROUT_CD, '*') = DECODE(NVL(POD_GRP_TP_CD, '*'), '5', @[pod_cd], '4', @[pod_rgn_cd], '3', @[pod_cnt_cd], '2', @[pod_sconti_cd], '1', @[pod_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("	AND NVL(A.RFA_NO, '*') = ( /* RFA가 존재하는지 */ " ).append("\n"); 
		query.append("		SELECT MAX(X) " ).append("\n"); 
		query.append("		FROM ( " ).append("\n"); 
		query.append("				SELECT NVL(RFA_NO, '*') X " ).append("\n"); 
		query.append("				FROM ACM_FF_AGMT " ).append("\n"); 
		query.append("				WHERE FF_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n"); 
		query.append("					AND FF_SEQ = TO_NUMBER(NVL(@[ff_cust_seq_tmp],@[bkg_ff_seq]))" ).append("\n"); 
		query.append("					AND NVL(SHPR_CNT_CD, '*') IN (@[shpr_cnt_cd], '*') " ).append("\n"); 
		query.append("					AND NVL(SHPR_SEQ, 0 ) IN (TO_NUMBER(@[shpr_cust_seq]), 0) " ).append("\n"); 
		query.append("					AND FM_EFF_DT <= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND TO_EFF_DT >= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND NVL(SC_NO, '*') IN (@[sc_no], '*') " ).append("\n"); 
		query.append("					AND NVL(RFA_NO, '*') IN (@[rfa_no], '*') " ).append("\n"); 
		query.append("					AND NVL(CMDT_CD, '*') IN ('*',DECODE(CMDT_TP_CD, '2', @[rep_cmdt_cd], '3', @[cmdt_cd]))" ).append("\n"); 
		query.append("					AND NVL(POR_ROUT_CD, '*') = DECODE(NVL(POR_GRP_TP_CD, '*'), '5', @[por_cd], '4', @[por_rgn_cd], '3', @[por_cnt_cd], '2', @[por_sconti_cd], '1', @[por_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POL_ROUT_CD, '*') = DECODE(NVL(POL_GRP_TP_CD, '*'), '5', @[pol_cd], '4', @[pol_rgn_cd], '3', @[pol_cnt_cd], '2', @[pol_sconti_cd], '1', @[pol_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POD_ROUT_CD, '*') = DECODE(NVL(POD_GRP_TP_CD, '*'), '5', @[pod_cd], '4', @[pod_rgn_cd], '3', @[pod_cnt_cd], '2', @[pod_sconti_cd], '1', @[pod_conti_cd], '*', '*')" ).append("\n"); 
		query.append("					AND NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("	AND NVL(A.CMDT_CD, '*') = ( /* REP COMMODITY가  존재하는지 */ " ).append("\n"); 
		query.append("		SELECT MAX(X) " ).append("\n"); 
		query.append("		FROM ( " ).append("\n"); 
		query.append("				SELECT NVL(CMDT_CD, '*') X " ).append("\n"); 
		query.append("				FROM ACM_FF_AGMT " ).append("\n"); 
		query.append("				WHERE FF_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n"); 
		query.append("					AND FF_SEQ = TO_NUMBER(NVL(@[ff_cust_seq_tmp],@[bkg_ff_seq]))" ).append("\n"); 
		query.append("					AND NVL(SHPR_CNT_CD, '*') IN (@[shpr_cnt_cd], '*') " ).append("\n"); 
		query.append("					AND NVL(SHPR_SEQ, 0 ) IN (TO_NUMBER(@[shpr_cust_seq]), 0) " ).append("\n"); 
		query.append("					AND FM_EFF_DT <= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND TO_EFF_DT >= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("					AND NVL(SC_NO, '*') IN (@[sc_no], '*') " ).append("\n"); 
		query.append("					AND NVL(RFA_NO, '*') IN (@[rfa_no], '*') " ).append("\n"); 
		query.append("					AND NVL(CMDT_CD, '*') IN ('*',DECODE(CMDT_TP_CD, '2' , @[rep_cmdt_cd], '3', @[cmdt_cd]))" ).append("\n"); 
		query.append("					AND NVL(POR_ROUT_CD, '*') = DECODE(NVL(POR_GRP_TP_CD, '*'), '5', @[por_cd], '4', @[por_rgn_cd], '3', @[por_cnt_cd], '2', @[por_sconti_cd], '1', @[por_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POL_ROUT_CD, '*') = DECODE(NVL(POL_GRP_TP_CD, '*'), '5', @[pol_cd], '4', @[pol_rgn_cd], '3', @[pol_cnt_cd], '2', @[pol_sconti_cd], '1', @[pol_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POD_ROUT_CD, '*') = DECODE(NVL(POD_GRP_TP_CD, '*'), '5', @[pod_cd], '4', @[pod_rgn_cd], '3', @[pod_cnt_cd], '2', @[pod_sconti_cd], '1', @[pod_conti_cd], '*', '*')" ).append("\n"); 
		query.append("					AND NVL(DELT_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("	AND NVL(A.CMDT_TP_CD, '*') IN ( " ).append("\n"); 
		query.append("		SELECT MAX(NVL(CMDT_TP_CD, '*')) " ).append("\n"); 
		query.append("		FROM ACM_FF_AGMT " ).append("\n"); 
		query.append("		WHERE FF_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n"); 
		query.append("			AND FF_SEQ = TO_NUMBER(NVL(@[ff_cust_seq_tmp],@[bkg_ff_seq]))" ).append("\n"); 
		query.append("			AND NVL(SHPR_CNT_CD, '*') IN (@[shpr_cnt_cd], '*') " ).append("\n"); 
		query.append("			AND NVL(SHPR_SEQ, 0 ) IN (TO_NUMBER(@[shpr_cust_seq]), 0) " ).append("\n"); 
		query.append("			AND FM_EFF_DT <= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("			AND TO_EFF_DT >= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("			AND NVL(SC_NO, '*') IN (@[sc_no], '*') " ).append("\n"); 
		query.append("			AND NVL(RFA_NO, '*') IN (@[rfa_no], '*') " ).append("\n"); 
		query.append("			AND NVL(CMDT_CD, '*') IN ('*',DECODE(CMDT_TP_CD, '2' , @[rep_cmdt_cd], '3', @[cmdt_cd]))" ).append("\n"); 
		query.append("					AND NVL(POR_ROUT_CD, '*') = DECODE(NVL(POR_GRP_TP_CD, '*'), '5', @[por_cd], '4', @[por_rgn_cd], '3', @[por_cnt_cd], '2', @[por_sconti_cd], '1', @[por_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POL_ROUT_CD, '*') = DECODE(NVL(POL_GRP_TP_CD, '*'), '5', @[pol_cd], '4', @[pol_rgn_cd], '3', @[pol_cnt_cd], '2', @[pol_sconti_cd], '1', @[pol_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POD_ROUT_CD, '*') = DECODE(NVL(POD_GRP_TP_CD, '*'), '5', @[pod_cd], '4', @[pod_rgn_cd], '3', @[pod_cnt_cd], '2', @[pod_sconti_cd], '1', @[pod_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("	/* 해당 ROUTE별로 존재하는지 */ " ).append("\n"); 
		query.append("					AND NVL(POR_ROUT_CD, '*') = DECODE(NVL(POR_GRP_TP_CD, '*'), '5', @[por_cd], '4', @[por_rgn_cd], '3', @[por_cnt_cd], '2', @[por_sconti_cd], '1', @[por_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POL_ROUT_CD, '*') = DECODE(NVL(POL_GRP_TP_CD, '*'), '5', @[pol_cd], '4', @[pol_rgn_cd], '3', @[pol_cnt_cd], '2', @[pol_sconti_cd], '1', @[pol_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POD_ROUT_CD, '*') = DECODE(NVL(POD_GRP_TP_CD, '*'), '5', @[pod_cd], '4', @[pod_rgn_cd], '3', @[pod_cnt_cd], '2', @[pod_sconti_cd], '1', @[pod_conti_cd], '*', '*') " ).append("\n"); 
		query.append("	AND NVL(A.POR_GRP_TP_CD, '*')||NVL(A.POL_GRP_TP_CD, '*')||NVL(A.POD_GRP_TP_CD, '*') IN ( " ).append("\n"); 
		query.append("		SELECT MAX(NVL(POR_GRP_TP_CD, '*'))||MAX(NVL(POL_GRP_TP_CD, '*'))||MAX(NVL(POD_GRP_TP_CD, '*')) " ).append("\n"); 
		query.append("		FROM ACM_FF_AGMT " ).append("\n"); 
		query.append("		WHERE FF_CNT_CD = @[bkg_ff_cnt_cd]" ).append("\n"); 
		query.append("			AND FF_SEQ = TO_NUMBER(NVL(@[ff_cust_seq_tmp],@[bkg_ff_seq]))" ).append("\n"); 
		query.append("			AND NVL(SHPR_CNT_CD, '*') IN (@[shpr_cnt_cd], '*') " ).append("\n"); 
		query.append("			AND NVL(SHPR_SEQ, 0 ) IN (TO_NUMBER(@[shpr_cust_seq]), 0) " ).append("\n"); 
		query.append("			AND FM_EFF_DT <= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("			AND TO_EFF_DT >= SUBSTR(@[trunk_etd_dt], 1, 8) " ).append("\n"); 
		query.append("			AND NVL(SC_NO, '*') IN (@[sc_no], '*') " ).append("\n"); 
		query.append("			AND NVL(RFA_NO, '*') IN (@[rfa_no], '*') " ).append("\n"); 
		query.append("			AND NVL(CMDT_CD, '*') IN ('*',DECODE(CMDT_TP_CD, '2', @[rep_cmdt_cd], '3', @[cmdt_cd]))" ).append("\n"); 
		query.append("					AND NVL(POR_ROUT_CD, '*') = DECODE(NVL(POR_GRP_TP_CD, '*'), '5', @[por_cd], '4', @[por_rgn_cd], '3', @[por_cnt_cd], '2', @[por_sconti_cd], '1', @[por_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POL_ROUT_CD, '*') = DECODE(NVL(POL_GRP_TP_CD, '*'), '5', @[pol_cd], '4', @[pol_rgn_cd], '3', @[pol_cnt_cd], '2', @[pol_sconti_cd], '1', @[pol_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(POD_ROUT_CD, '*') = DECODE(NVL(POD_GRP_TP_CD, '*'), '5', @[pod_cd], '4', @[pod_rgn_cd], '3', @[pod_cnt_cd], '2', @[pod_sconti_cd], '1', @[pod_conti_cd], '*', '*') " ).append("\n"); 
		query.append("					AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}