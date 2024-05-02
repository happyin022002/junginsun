/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchApplyOutstandingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.05 
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

public class AccountReceivableOutstandingDBDAOsearchApplyOutstandingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Apply 대상 OTS 정보 조회
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchApplyOutstandingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_due_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_due_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tj_src_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rct_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_smry_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("as_of_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchApplyOutstandingListRSQL").append("\n"); 
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
		query.append("SELECT RHQ_CD" ).append("\n"); 
		query.append("       , OTS_OFC_CD" ).append("\n"); 
		query.append("       , BL_NO " ).append("\n"); 
		query.append("       , BKG_NO" ).append("\n"); 
		query.append("       , INV_NO" ).append("\n"); 
		query.append("       , OTS_SRC_CD" ).append("\n"); 
		query.append("       , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , BIL_TO_CUST_CD" ).append("\n"); 
		query.append("       , CUST_NM" ).append("\n"); 
		query.append("       , SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , SHP_TO_CUST_SEQ   " ).append("\n"); 
		query.append("       , SHP_TO_CUST_CD" ).append("\n"); 
		query.append("       , LOCL_VVD_CD" ).append("\n"); 
		query.append("       , CHG_TP_CD" ).append("\n"); 
		query.append("       , BL_CURR_CD" ).append("\n"); 
		query.append("	   , SAR_GET_FMT_MASK_FNC(BL_CURR_CD, NVL(SUM(BAL_AMT), 0)) OTS_BAL_AMT" ).append("\n"); 
		query.append("       , SAR_GET_FMT_MASK_FNC(OFC_CURR_CD, SUM(LOCL_BAL_AMT)) LOCL_BAL_AMT" ).append("\n"); 
		query.append("       , SAR_GET_FMT_MASK_FNC('USD', SUM(USD_BAL_AMT)) USD_BAL_AMT" ).append("\n"); 
		query.append("       , DUE_DT" ).append("\n"); 
		query.append("       , OVER_DUE" ).append("\n"); 
		query.append("	   , OTS_RMK" ).append("\n"); 
		query.append("	   , OTS_SMRY_CD" ).append("\n"); 
		query.append("	   , OTS_CD" ).append("\n"); 
		query.append("	   , REP_OTS_OFC_CD    " ).append("\n"); 
		query.append("       , RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("       , RCT_APLY_FLG" ).append("\n"); 
		query.append("       , OFC_CD" ).append("\n"); 
		query.append("       , TRNK_VVD_CD" ).append("\n"); 
		query.append("       , SAIL_ARR_DT" ).append("\n"); 
		query.append("       , IO_BND_CD" ).append("\n"); 
		query.append("       , SREP_CD" ).append("\n"); 
		query.append("       , XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , XCH_RT_DT" ).append("\n"); 
		query.append("       , CR_FLG" ).append("\n"); 
		query.append("       , AR_FINC_SRC_CD" ).append("\n"); 
		query.append("       , MAX_AR_IF_NO" ).append("\n"); 
		query.append("       , INV_DT" ).append("\n"); 
		query.append("       , RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("       , RCT_APLY_SRC_CURR_CD" ).append("\n"); 
		query.append("       , NVL(SUM(BAL_AMT), 0) OTS_APLY_AMT" ).append("\n"); 
		query.append("       , OTS_XCH_RT" ).append("\n"); 
		query.append("	   , RCT_APLY_XCH_RT" ).append("\n"); 
		query.append("       , RCT_CURR_CD" ).append("\n"); 
		query.append("       , ROUND(NVL(SUM(BAL_AMT), 0) * NVL(DECODE(@[rct_curr_cd], OFC_CURR_CD, LOCL_XCH_RT, 'USD', USD_XCH_RT, DECODE(@[rct_curr_cd], BL_CURR_CD, 1, 0)), 0), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[rct_curr_cd])) RCT_APLY_AMT" ).append("\n"); 
		query.append("       , DP_PRCS_KNT" ).append("\n"); 
		query.append("	   , HDR_DUP_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT Q.RHQ_CD" ).append("\n"); 
		query.append("               , S.INV_OFC_CD OTS_OFC_CD" ).append("\n"); 
		query.append("               , Q.BL_NO " ).append("\n"); 
		query.append("               , Q.BKG_NO" ).append("\n"); 
		query.append("               , Q.INV_NO" ).append("\n"); 
		query.append("               , S.OTS_SRC_CD" ).append("\n"); 
		query.append("               , Q.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("               , Q.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("               , Q.BIL_TO_CUST_CNT_CD||'-'||LPAD(Q.BIL_TO_CUST_SEQ, 6, '0') BIL_TO_CUST_CD" ).append("\n"); 
		query.append("               , NVL(U.LOCL_NM, T.CUST_LGL_ENG_NM) CUST_NM" ).append("\n"); 
		query.append("               , Q.SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("               , Q.SHP_TO_CUST_SEQ   " ).append("\n"); 
		query.append("               , Q.SHP_TO_CUST_CNT_CD||'-'||LPAD(Q.SHP_TO_CUST_SEQ, 6, '0') SHP_TO_CUST_CD" ).append("\n"); 
		query.append("               , Q.VSL_CD||Q.SKD_VOY_NO||Q.DIR_CD LOCL_VVD_CD" ).append("\n"); 
		query.append("               , P.CHG_TP_CD" ).append("\n"); 
		query.append("               , P.BL_CURR_CD" ).append("\n"); 
		query.append("               , P.BAL_AMT" ).append("\n"); 
		query.append("               , ROUND(NVL(P.BAL_AMT, 0) * NVL(R.LOCL_XCH_RT, 0), V.DP_PRCS_KNT) LOCL_BAL_AMT" ).append("\n"); 
		query.append("               , ROUND(NVL(P.BAL_AMT, 0) * NVL(R.USD_XCH_RT, 0), 2) USD_BAL_AMT" ).append("\n"); 
		query.append("               , Q.DUE_DT" ).append("\n"); 
		query.append("               , TO_DATE(REPLACE(@[as_of_date], '-', ''), 'YYYYMMDD') - TO_DATE(Q.DUE_DT, 'YYYYMMDD') OVER_DUE" ).append("\n"); 
		query.append("               , Q.OTS_RMK" ).append("\n"); 
		query.append("               , @[ots_smry_cd] OTS_SMRY_CD" ).append("\n"); 
		query.append("               , @[ots_cd] OTS_CD" ).append("\n"); 
		query.append("               , @[rep_ots_ofc_cd] REP_OTS_OFC_CD    " ).append("\n"); 
		query.append("               , S.INV_OFC_CD||Q.BL_NO||Q.INV_NO RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("               , 'N' RCT_APLY_FLG" ).append("\n"); 
		query.append("               , Q.OTS_OFC_CD OFC_CD" ).append("\n"); 
		query.append("               , Q.TRNK_VVD_CD" ).append("\n"); 
		query.append("               , Q.SAIL_ARR_DT" ).append("\n"); 
		query.append("               , Q.BKG_IO_BND_CD IO_BND_CD" ).append("\n"); 
		query.append("               , Q.CUST_SREP_CD SREP_CD" ).append("\n"); 
		query.append("               , Q.XCH_RT_TP_CD" ).append("\n"); 
		query.append("               , Q.XCH_RT_DT" ).append("\n"); 
		query.append("               , Q.CR_MK_FLG CR_FLG" ).append("\n"); 
		query.append("               , Q.OTS_SRC_CD AR_FINC_SRC_CD" ).append("\n"); 
		query.append("               , Q.MAX_AR_IF_NO" ).append("\n"); 
		query.append("               , Q.INV_DT" ).append("\n"); 
		query.append("               , P.CHG_TP_CD RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("               , P.BL_CURR_CD RCT_APLY_SRC_CURR_CD" ).append("\n"); 
		query.append("               , DECODE(@[rct_curr_cd], Q.OFC_CURR_CD, R.LOCL_XCH_RT, 'USD', R.USD_XCH_RT, DECODE(@[rct_curr_cd], P.BL_CURR_CD, 1, 0)) OTS_XCH_RT" ).append("\n"); 
		query.append("               , DECODE(@[rct_curr_cd], Q.OFC_CURR_CD, R.LOCL_XCH_RT, 'USD', R.USD_XCH_RT, DECODE(@[rct_curr_cd], P.BL_CURR_CD, 1, 0)) RCT_APLY_XCH_RT" ).append("\n"); 
		query.append("               , @[rct_curr_cd] RCT_CURR_CD" ).append("\n"); 
		query.append("               , Q.OFC_CURR_CD" ).append("\n"); 
		query.append("               , R.LOCL_XCH_RT" ).append("\n"); 
		query.append("               , R.USD_XCH_RT" ).append("\n"); 
		query.append("               , (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = P.BL_CURR_CD) DP_PRCS_KNT" ).append("\n"); 
		query.append("            #if (${ots_dtl_flg} == 'Y') " ).append("\n"); 
		query.append("               , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SAR_OTS_RCT_TMP" ).append("\n"); 
		query.append("                      WHERE OTS_RCT_TMP_SEQ = @[ots_rct_tmp_seq]" ).append("\n"); 
		query.append("                      AND RCT_APLY_HDR_NO = S.INV_OFC_CD||Q.BL_NO||Q.INV_NO" ).append("\n"); 
		query.append("                      AND RCT_APLY_FLG = 'N'" ).append("\n"); 
		query.append("                      AND ROWNUM = 1), 'N') HDR_DUP_FLG" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("               , 'N' HDR_DUP_FLG" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("               , SUM(NVL(P.BAL_AMT, 0)) OVER (PARTITION BY S.INV_OFC_CD, Q.BL_NO, Q.BIL_TO_CUST_CNT_CD, Q.BIL_TO_CUST_SEQ, Q.VSL_CD, Q.SKD_VOY_NO, Q.DIR_CD, P.BL_CURR_CD) OFFSET_AMT" ).append("\n"); 
		query.append("        FROM SAR_OTS_CHG P," ).append("\n"); 
		query.append("             SAR_OTS_HDR Q," ).append("\n"); 
		query.append("             SAR_OTS_DTL R," ).append("\n"); 
		query.append("             SAR_OTS_HIS S," ).append("\n"); 
		query.append("             MDM_CUSTOMER T," ).append("\n"); 
		query.append("             MDM_CR_CUST U," ).append("\n"); 
		query.append("             MDM_CURRENCY V" ).append("\n"); 
		query.append("        WHERE P.RHQ_CD = Q.RHQ_CD" ).append("\n"); 
		query.append("        AND P.OTS_OFC_CD = Q.OTS_OFC_CD" ).append("\n"); 
		query.append("        AND P.BL_NO = Q.BL_NO" ).append("\n"); 
		query.append("        AND P.INV_NO = Q.INV_NO" ).append("\n"); 
		query.append("        AND P.RHQ_CD = R.RHQ_CD" ).append("\n"); 
		query.append("        AND P.OTS_OFC_CD = R.OTS_OFC_CD" ).append("\n"); 
		query.append("        AND P.BL_NO = R.BL_NO" ).append("\n"); 
		query.append("        AND P.INV_NO = R.INV_NO" ).append("\n"); 
		query.append("        AND P.BL_CURR_CD = R.BL_CURR_CD" ).append("\n"); 
		query.append("        AND P.CHG_TP_CD = R.CHG_TP_CD" ).append("\n"); 
		query.append("        AND Q.RHQ_CD = S.RHQ_CD" ).append("\n"); 
		query.append("        AND Q.OTS_OFC_CD = S.OTS_OFC_CD" ).append("\n"); 
		query.append("        AND Q.BL_NO = S.BL_NO" ).append("\n"); 
		query.append("        AND Q.INV_NO = S.INV_NO   " ).append("\n"); 
		query.append("        AND P.OTS_HIS_SEQ = S.OTS_HIS_SEQ" ).append("\n"); 
		query.append("        AND Q.BIL_TO_CUST_CNT_CD = T.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND Q.BIL_TO_CUST_SEQ = T.CUST_SEQ" ).append("\n"); 
		query.append("        AND Q.BIL_TO_CUST_CNT_CD = U.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("        AND Q.BIL_TO_CUST_SEQ = U.CUST_SEQ(+)" ).append("\n"); 
		query.append("        AND Q.OFC_CURR_CD = V.CURR_CD" ).append("\n"); 
		query.append("        AND Q.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("        #if(${ots_cd} == 'COU')" ).append("\n"); 
		query.append("            AND Q.OTS_OFC_CD = @[rep_ots_ofc_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND Q.OTS_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bil_to_cust_cnt_cd} != '' )" ).append("\n"); 
		query.append("            AND Q.BIL_TO_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bil_to_cust_seq} != '') " ).append("\n"); 
		query.append("            AND Q.BIL_TO_CUST_SEQ = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("        #if (${vvd_cd1} != '' || ${vvd_cd2} != '' || ${vvd_cd3} != '' || ${vvd_cd4} != '' || ${vvd_cd5} != '' || ${vvd_cd6} != '' || ${vvd_cd7} != '' ||" ).append("\n"); 
		query.append("             ${vvd_cd8} != '' || ${vvd_cd9} != '' || ${vvd_cd10} != '' || ${vvd_cd11} != '' || ${vvd_cd12} != '' || ${vvd_cd13} != '' || ${vvd_cd14} != '') " ).append("\n"); 
		query.append("            AND Q.VSL_CD||Q.SKD_VOY_NO||Q.DIR_CD IN (@[vvd_cd1], @[vvd_cd2], @[vvd_cd3], @[vvd_cd4], @[vvd_cd5], @[vvd_cd6], @[vvd_cd7], @[vvd_cd8], @[vvd_cd9], @[vvd_cd10], @[vvd_cd11], @[vvd_cd12], @[vvd_cd13], @[vvd_cd14])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${local_chg_flag} == 'Y')" ).append("\n"); 
		query.append("                #if (${invoice_type} == 'NFRT')" ).append("\n"); 
		query.append("                    #if (${bkg_io_bnd_cd} == 'L')" ).append("\n"); 
		query.append("                    AND S.REV_TP_SRC_CD IN ('MIV','MIC','MOS')" ).append("\n"); 
		query.append("                    AND (P.CHG_TP_CD IN ( SELECT D.LU_CD" ).append("\n"); 
		query.append("                                          FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                                          WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                                          AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                                          AND    D.LU_TP_CD = 'TH LOCAL CHARGE'" ).append("\n"); 
		query.append("                                          AND    D.ENBL_FLG = 'Y') " ).append("\n"); 
		query.append("                         OR P.TJ_SRC_NM  = 'VAT')" ).append("\n"); 
		query.append("                    #else  " ).append("\n"); 
		query.append("                    AND S.REV_TP_SRC_CD LIKE 'M%'          " ).append("\n"); 
		query.append("                    AND S.REV_TP_SRC_CD NOT IN ('MDM','MDT')" ).append("\n"); 
		query.append("                    AND (P.CHG_TP_CD NOT IN ( SELECT D.LU_CD" ).append("\n"); 
		query.append("                                              FROM   SCO_LU_HDR H,  SCO_LU_DTL D" ).append("\n"); 
		query.append("                                              WHERE  H.LU_TP_CD = D.LU_TP_CD" ).append("\n"); 
		query.append("                                              AND    H.LU_APPL_CD = 'SAR'" ).append("\n"); 
		query.append("                                              AND    D.LU_TP_CD = 'TH LOCAL CHARGE'" ).append("\n"); 
		query.append("                                              AND    D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                        )  " ).append("\n"); 
		query.append("                    AND P.TJ_SRC_NM  != 'VAT'" ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                AND Q.BKG_IO_BND_CD = @[bkg_io_bnd_cd]   " ).append("\n"); 
		query.append("                AND ( S.REV_TP_SRC_CD IN ('MDM','MDT','MOS') OR S.REV_TP_SRC_CD LIKE 'B%' OR S.REV_TP_SRC_CD LIKE 'C%' )  " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                #if (${bkg_io_bnd_cd} != 'A') " ).append("\n"); 
		query.append("                AND Q.BKG_IO_BND_CD = @[bkg_io_bnd_cd]       " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${over_due_fm} != '')" ).append("\n"); 
		query.append("            AND TO_DATE(REPLACE(@[as_of_date], '-', ''), 'YYYYMMDD') - TO_DATE(Q.DUE_DT, 'YYYYMMDD') >= @[over_due_fm]    " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${over_due_to} != '')" ).append("\n"); 
		query.append("            AND TO_DATE(REPLACE(@[as_of_date], '-', ''), 'YYYYMMDD') - TO_DATE(Q.DUE_DT, 'YYYYMMDD') <= @[over_due_to]    " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${ots_src_cd} != '')" ).append("\n"); 
		query.append("            AND S.OTS_SRC_CD = @[ots_src_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${if_from_dt} != '')" ).append("\n"); 
		query.append("            AND TO_CHAR(S.IF_DT, 'YYYYMMDD') >= REPLACE(@[if_from_dt], '-', '')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${if_to_dt} != '')" ).append("\n"); 
		query.append("            AND TO_CHAR(S.IF_DT, 'YYYYMMDD') <= REPLACE(@[if_to_dt], '-', '')" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${bl_no1} != '' || ${bl_no2} != '' || ${bl_no3} != '' || ${bl_no4} != '' || ${bl_no5} != '' || ${bl_no6} != '' || ${bl_no7} != '') " ).append("\n"); 
		query.append("            #if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("                AND Q.INV_NO IN (@[bl_no1], @[bl_no2], @[bl_no3], @[bl_no4], @[bl_no5], @[bl_no6], @[bl_no7])" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND Q.BL_NO IN (@[bl_no1], @[bl_no2], @[bl_no3], @[bl_no4], @[bl_no5], @[bl_no6], @[bl_no7])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end    " ).append("\n"); 
		query.append("        #if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("            AND Q.INV_NO <> '**********'" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND Q.INV_NO = '**********'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chg_tp_cd} != '')" ).append("\n"); 
		query.append("            AND P.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${tj_src_nm} != '')    	" ).append("\n"); 
		query.append("            AND P.TJ_SRC_NM = @[tj_src_nm]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND S.OTS_HIS_TP_CD = 'OTS'" ).append("\n"); 
		query.append("        AND Q.STL_FLG = 'N'" ).append("\n"); 
		query.append("        #if (${ots_dtl_flg} == 'Y')   " ).append("\n"); 
		query.append("        AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM SAR_OTS_RCT_TMP" ).append("\n"); 
		query.append("                        WHERE OTS_RCT_TMP_SEQ = @[ots_rct_tmp_seq]" ).append("\n"); 
		query.append("                        AND RCT_APLY_HDR_NO = S.INV_OFC_CD||Q.BL_NO||Q.INV_NO" ).append("\n"); 
		query.append("                        AND RCT_APLY_CHG_CD = P.CHG_TP_CD " ).append("\n"); 
		query.append("                        AND RCT_APLY_SRC_CURR_CD = P.BL_CURR_CD" ).append("\n"); 
		query.append("                        AND RCT_APLY_FLG = 'N')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${ofst_chk} == 'Y')  " ).append("\n"); 
		query.append("    WHERE OFFSET_AMT = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY RHQ_CD" ).append("\n"); 
		query.append("       , OTS_OFC_CD" ).append("\n"); 
		query.append("       , BL_NO" ).append("\n"); 
		query.append("       , BKG_NO" ).append("\n"); 
		query.append("       , INV_NO" ).append("\n"); 
		query.append("       , OTS_SRC_CD" ).append("\n"); 
		query.append("       , BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , BIL_TO_CUST_CD" ).append("\n"); 
		query.append("       , CUST_NM" ).append("\n"); 
		query.append("       , SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , SHP_TO_CUST_SEQ   " ).append("\n"); 
		query.append("       , SHP_TO_CUST_CD" ).append("\n"); 
		query.append("       , LOCL_VVD_CD" ).append("\n"); 
		query.append("       , CHG_TP_CD" ).append("\n"); 
		query.append("       , BL_CURR_CD" ).append("\n"); 
		query.append("       , OFC_CURR_CD" ).append("\n"); 
		query.append("       , DUE_DT" ).append("\n"); 
		query.append("       , OVER_DUE" ).append("\n"); 
		query.append("	   , OTS_RMK" ).append("\n"); 
		query.append("       , OTS_SMRY_CD" ).append("\n"); 
		query.append("	   , OTS_CD" ).append("\n"); 
		query.append("	   , REP_OTS_OFC_CD" ).append("\n"); 
		query.append("       , RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("       , RCT_APLY_FLG" ).append("\n"); 
		query.append("       , OFC_CD" ).append("\n"); 
		query.append("       , TRNK_VVD_CD" ).append("\n"); 
		query.append("       , SAIL_ARR_DT" ).append("\n"); 
		query.append("       , IO_BND_CD" ).append("\n"); 
		query.append("       , SREP_CD" ).append("\n"); 
		query.append("       , XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , XCH_RT_DT" ).append("\n"); 
		query.append("       , CR_FLG" ).append("\n"); 
		query.append("       , AR_FINC_SRC_CD" ).append("\n"); 
		query.append("       , MAX_AR_IF_NO" ).append("\n"); 
		query.append("       , INV_DT" ).append("\n"); 
		query.append("       , LOCL_XCH_RT" ).append("\n"); 
		query.append("       , USD_XCH_RT" ).append("\n"); 
		query.append("       , RCT_APLY_CHG_CD" ).append("\n"); 
		query.append("       , RCT_APLY_SRC_CURR_CD" ).append("\n"); 
		query.append("       , OTS_XCH_RT" ).append("\n"); 
		query.append("	   , RCT_APLY_XCH_RT" ).append("\n"); 
		query.append("       , RCT_CURR_CD" ).append("\n"); 
		query.append("       , DP_PRCS_KNT" ).append("\n"); 
		query.append("	   , HDR_DUP_FLG" ).append("\n"); 
		query.append("HAVING NVL(SUM(BAL_AMT), 0) != 0" ).append("\n"); 
		query.append("ORDER BY OTS_OFC_CD" ).append("\n"); 
		query.append("         , BL_NO" ).append("\n"); 
		query.append("         , INV_NO" ).append("\n"); 
		query.append("         , CHG_TP_CD" ).append("\n"); 
		query.append("         , BL_CURR_CD" ).append("\n"); 

	}
}