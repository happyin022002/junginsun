/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingBucketRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.02 
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

public class AccountReceivableOutstandingDBDAOSearchOTSAgingBucketRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select OTS aging by bucket days blow
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOTSAgingBucketRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bk5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bk6",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bk1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bk2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bk3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_mk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bk4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingBucketRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS SAIL_ARR_DT" ).append("\n"); 
		query.append(", '' AS STL_FLG" ).append("\n"); 
		query.append(", '' AS CR_MK_FLG" ).append("\n"); 
		query.append(", '' AS OTS_GRP_TP_CD" ).append("\n"); 
		query.append(", '' AS OTS_RT_FLG" ).append("\n"); 
		query.append(", '' AS DUE_DT" ).append("\n"); 
		query.append(", '' AS OTS_SRC_CD" ).append("\n"); 
		query.append(", '' AS BL_SUM_TP" ).append("\n"); 
		query.append(", '' AS BL_INV_TP" ).append("\n"); 
		query.append(", '' AS SUM_TP" ).append("\n"); 
		query.append(", '' AS BL_CURR_CD" ).append("\n"); 
		query.append(", '' AS MULTI_CLT_OFC_CD" ).append("\n"); 
		query.append(", '' AS SUM_OFC_CUST_TP" ).append("\n"); 
		query.append(", '' AS BK1" ).append("\n"); 
		query.append(", '' AS BK2" ).append("\n"); 
		query.append(", '' AS BK3" ).append("\n"); 
		query.append(", '' AS BK4" ).append("\n"); 
		query.append(", '' AS BK5" ).append("\n"); 
		query.append(", '' AS BK6" ).append("\n"); 
		query.append("#if(${sum_ofc_cust_tp} == 'OFC')" ).append("\n"); 
		query.append("  #if(${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("  , CLT_OFC_CD" ).append("\n"); 
		query.append("  , PRIMARY_KEY" ).append("\n"); 
		query.append("  #else " ).append("\n"); 
		query.append("  , MAX(CLT_OFC_CD) AS CLT_OFC_CD" ).append("\n"); 
		query.append("  , MAX(CUST_LGL_ENG_NM) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("  , MAX(PRIMARY_KEY) AS PRIMARY_KEY" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append(", CLT_OFC_CD" ).append("\n"); 
		query.append(", BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append(", BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append(", PRIMARY_KEY" ).append("\n"); 
		query.append(", CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",COUNT(DISTINCT IB_BK1_CNT) AS IB_BK1_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT OB_BK1_CNT) AS OB_BK1_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT TOT_BK1_CNT) AS TOT_BK1_CNT" ).append("\n"); 
		query.append(",SUM(IB_BK1_BAL_LOCL_AMT) AS IB_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK1_BAL_LOCL_AMT) AS OB_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK1_BAL_LOCL_AMT) AS TOT_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(IB_BK1_BAL_USD_AMT) AS IB_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK1_BAL_USD_AMT) AS OB_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK1_BAL_USD_AMT) AS TOT_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append(",COUNT(DISTINCT IB_BK2_CNT) AS IB_BK2_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT OB_BK2_CNT) AS OB_BK2_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT TOT_BK2_CNT) AS TOT_BK2_CNT" ).append("\n"); 
		query.append(",SUM(IB_BK2_BAL_LOCL_AMT) AS IB_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK2_BAL_LOCL_AMT) AS OB_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK2_BAL_LOCL_AMT) AS TOT_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(IB_BK2_BAL_USD_AMT) AS IB_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK2_BAL_USD_AMT) AS OB_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK2_BAL_USD_AMT) AS TOT_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append(",COUNT(DISTINCT IB_BK3_CNT) AS IB_BK3_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT OB_BK3_CNT) AS OB_BK3_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT TOT_BK3_CNT) AS TOT_BK3_CNT" ).append("\n"); 
		query.append(",SUM(IB_BK3_BAL_LOCL_AMT) AS IB_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK3_BAL_LOCL_AMT) AS OB_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK3_BAL_LOCL_AMT) AS TOT_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(IB_BK3_BAL_USD_AMT) AS IB_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK3_BAL_USD_AMT) AS OB_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK3_BAL_USD_AMT) AS TOT_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append(",COUNT(DISTINCT IB_BK4_CNT) AS IB_BK4_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT OB_BK4_CNT) AS OB_BK4_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT TOT_BK4_CNT) AS TOT_BK4_CNT" ).append("\n"); 
		query.append(",SUM(IB_BK4_BAL_LOCL_AMT) AS IB_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK4_BAL_LOCL_AMT) AS OB_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK4_BAL_LOCL_AMT) AS TOT_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(IB_BK4_BAL_USD_AMT) AS IB_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK4_BAL_USD_AMT) AS OB_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK4_BAL_USD_AMT) AS TOT_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append(",COUNT(DISTINCT IB_BK5_CNT) AS IB_BK5_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT OB_BK5_CNT) AS OB_BK5_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT TOT_BK5_CNT) AS TOT_BK5_CNT" ).append("\n"); 
		query.append(",SUM(IB_BK5_BAL_LOCL_AMT) AS IB_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK5_BAL_LOCL_AMT) AS OB_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK5_BAL_LOCL_AMT) AS TOT_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(IB_BK5_BAL_USD_AMT) AS IB_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK5_BAL_USD_AMT) AS OB_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK5_BAL_USD_AMT) AS TOT_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append(",COUNT(DISTINCT IB_BK6_CNT) AS IB_BK6_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT OB_BK6_CNT) AS OB_BK6_CNT" ).append("\n"); 
		query.append(",COUNT(DISTINCT TOT_BK6_CNT) AS TOT_BK6_CNT" ).append("\n"); 
		query.append(",SUM(IB_BK6_BAL_LOCL_AMT) AS IB_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK6_BAL_LOCL_AMT) AS OB_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK6_BAL_LOCL_AMT) AS TOT_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(IB_BK6_BAL_USD_AMT) AS IB_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(OB_BK6_BAL_USD_AMT) AS OB_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append(",SUM(TOT_BK6_BAL_USD_AMT) AS TOT_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' AS SORT_SEQ       " ).append("\n"); 
		query.append("#if(${sum_ofc_cust_tp} == 'OFC')" ).append("\n"); 
		query.append("  #if(${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("  , A.CLT_OFC_CD" ).append("\n"); 
		query.append("  , A.CLT_OFC_CD AS PRIMARY_KEY" ).append("\n"); 
		query.append("  #else " ).append("\n"); 
		query.append("  , MAX(CLT_OFC_CD) AS CLT_OFC_CD" ).append("\n"); 
		query.append("  , '' AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("  , MAX(A.CLT_OFC_CD) AS PRIMARY_KEY" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append(", A.CLT_OFC_CD" ).append("\n"); 
		query.append(", A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append(", A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append(", A.CLT_OFC_CD || A.BIL_TO_CUST_CNT_CD || A.BIL_TO_CUST_SEQ AS PRIMARY_KEY" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("   SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("   FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("   WHERE CUST_CNT_CD = A.BIL_TO_CUST_CNT_CD AND CUST_SEQ = A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("   ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN A.BL_NO || A.INV_NO ELSE '' END              AS IB_BK1_CNT" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN A.BL_NO || A.INV_NO ELSE '' END              AS OB_BK1_CNT" ).append("\n"); 
		query.append(", CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN A.BL_NO || A.INV_NO ELSE '' END              AS TOT_BK1_CNT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS IB_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS OB_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS TOT_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS IB_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS OB_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk1] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS TOT_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN A.BL_NO || A.INV_NO ELSE '' END              AS IB_BK2_CNT" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN A.BL_NO || A.INV_NO ELSE '' END              AS OB_BK2_CNT" ).append("\n"); 
		query.append(", CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN A.BL_NO || A.INV_NO ELSE '' END              AS TOT_BK2_CNT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS IB_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS OB_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS TOT_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS IB_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS OB_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk1] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk2] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS TOT_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN A.BL_NO || A.INV_NO ELSE '' END              AS IB_BK3_CNT" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN A.BL_NO || A.INV_NO ELSE '' END              AS OB_BK3_CNT" ).append("\n"); 
		query.append(", CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN A.BL_NO || A.INV_NO ELSE '' END              AS TOT_BK3_CNT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS IB_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS OB_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS TOT_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS IB_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS OB_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk2] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk3] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS TOT_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN A.BL_NO || A.INV_NO ELSE '' END              AS IB_BK4_CNT" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN A.BL_NO || A.INV_NO ELSE '' END              AS OB_BK4_CNT" ).append("\n"); 
		query.append(", CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN A.BL_NO || A.INV_NO ELSE '' END              AS TOT_BK4_CNT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS IB_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS OB_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS TOT_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS IB_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS OB_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk3] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk4] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS TOT_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN A.BL_NO || A.INV_NO ELSE '' END              AS IB_BK5_CNT" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN A.BL_NO || A.INV_NO ELSE '' END              AS OB_BK5_CNT" ).append("\n"); 
		query.append(", CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN A.BL_NO || A.INV_NO ELSE '' END              AS TOT_BK5_CNT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS IB_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS OB_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS TOT_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS IB_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS OB_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk4] AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') <= @[bk5] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS TOT_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN A.BL_NO || A.INV_NO ELSE '' END              AS IB_BK6_CNT" ).append("\n"); 
		query.append(", CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN A.BL_NO || A.INV_NO ELSE '' END              AS OB_BK6_CNT" ).append("\n"); 
		query.append(", CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN A.BL_NO || A.INV_NO ELSE '' END              AS TOT_BK6_CNT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS IB_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS OB_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN ROUND(B.BAL_LOCL_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = B.BL_CURR_CD),0)) ELSE 0 END) AS TOT_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='I' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS IB_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN A.BKG_IO_BND_CD ='O' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS OB_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append(", SUM(CASE WHEN 1 = 1                AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') > @[bk6] THEN ROUND(B.BAL_USD_AMT,NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = 'USD'),2)) ELSE 0 END)  AS TOT_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR A" ).append("\n"); 
		query.append(", SAR_OTS_DTL B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("AND A.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("AND A.STL_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(A.OTS_GRP_TP_CD,'XX') <>  '01' " ).append("\n"); 
		query.append("AND A.DUE_DT < @[due_dt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cr_mk_flg} != '')" ).append("\n"); 
		query.append("AND A.CR_MK_FLG = @[cr_mk_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bl_sum_tp} == 'OTS')" ).append("\n"); 
		query.append("AND EXISTS(SELECT 'X'" ).append("\n"); 
		query.append("             FROM  SAR_OTS_DTL SOD2" ).append("\n"); 
		query.append("            WHERE  SOD2.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("              AND  SOD2.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND  SOD2.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("              AND  SOD2.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("            HAVING " ).append("\n"); 
		query.append("                   SUM(SOD2.BAL_AMT) > 0)" ).append("\n"); 
		query.append("#elseif(${bl_sum_tp} == 'OPY')" ).append("\n"); 
		query.append("AND EXISTS(SELECT 'X'" ).append("\n"); 
		query.append("             FROM  SAR_OTS_DTL SOD2" ).append("\n"); 
		query.append("            WHERE  SOD2.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("              AND  SOD2.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND  SOD2.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("              AND  SOD2.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("            HAVING " ).append("\n"); 
		query.append("                   SUM(SOD2.BAL_AMT) < 0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bl_inv_tp} == 'INV')" ).append("\n"); 
		query.append("AND A.INV_NO <> '**********'" ).append("\n"); 
		query.append("#elseif(${bl_inv_tp} == 'BL')" ).append("\n"); 
		query.append("AND A.INV_NO = '**********'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ots_src_cd} != '')" ).append("\n"); 
		query.append("  #if(${ots_src_cd} == 'OTHER')" ).append("\n"); 
		query.append("    AND (A.OTS_SRC_CD IN (SELECT LU_CD " ).append("\n"); 
		query.append("                           FROM SCO_LU_DTL " ).append("\n"); 
		query.append("                          WHERE LU_TP_CD = 'OTS SRC CD'  " ).append("\n"); 
		query.append("                            AND LU_CD NOT IN ('INVAR','BMS','JO','CDAM','AGENT','3RD')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("         OR A.OTS_SRC_CD IS NULL " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  #else   " ).append("\n"); 
		query.append("	AND A.OTS_SRC_CD = @[ots_src_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${clt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.CLT_OFC_CD IN (${clt_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("AND A.RHQ_CD IN (${rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ots_rt_flg} != '')" ).append("\n"); 
		query.append("AND A.OTS_RT_FLG = @[ots_rt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bil_to_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.BIL_TO_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bil_to_cust_seq} != '')" ).append("\n"); 
		query.append("AND A.BIL_TO_CUST_SEQ = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sum_ofc_cust_tp} == 'OFC')" ).append("\n"); 
		query.append("	#if(${sum_tp} == 'OFC') " ).append("\n"); 
		query.append("    GROUP BY" ).append("\n"); 
		query.append("    A.CLT_OFC_CD," ).append("\n"); 
		query.append("    A.BKG_IO_BND_CD," ).append("\n"); 
		query.append("    A.DUE_DT," ).append("\n"); 
		query.append("    A.BL_NO || A.INV_NO  " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    GROUP BY " ).append("\n"); 
		query.append("    A.BKG_IO_BND_CD," ).append("\n"); 
		query.append("    A.DUE_DT," ).append("\n"); 
		query.append("    A.BL_NO || A.INV_NO  " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("  A.CLT_OFC_CD," ).append("\n"); 
		query.append("  A.BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("  A.BIL_TO_CUST_SEQ," ).append("\n"); 
		query.append("  A.BKG_IO_BND_CD," ).append("\n"); 
		query.append("  A.DUE_DT," ).append("\n"); 
		query.append("  A.BL_NO || A.INV_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_sum_tp} != 'OTS')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' AS SORT_SEQ " ).append("\n"); 
		query.append("#if(${sum_ofc_cust_tp} == 'OFC')" ).append("\n"); 
		query.append("  #if(${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("      , SR.RCT_OFC_CD    AS CLT_OFC_CD" ).append("\n"); 
		query.append("      , SR.RCT_OFC_CD    AS PRIMARY_KEY" ).append("\n"); 
		query.append("  #else " ).append("\n"); 
		query.append("      , SR.RCT_OFC_CD    AS CLT_OFC_CD" ).append("\n"); 
		query.append("      , '' AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SR.RCT_OFC_CD    AS PRIMARY_KEY" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append("      , SR.RCT_OFC_CD    AS CLT_OFC_CD" ).append("\n"); 
		query.append("      , SR.RCT_CUST_CNT_CD AS BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("      , SR.RCT_CUST_SEQ AS BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("      , SR.RCT_OFC_CD || SR.RCT_CUST_CNT_CD || SR.RCT_CUST_SEQ AS PRIMARY_KEY" ).append("\n"); 
		query.append("      , MC.CUST_LGL_ENG_NM AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '30' THEN SR.RCT_NO ELSE '' END            AS IB_BK1_CNT" ).append("\n"); 
		query.append("      , '' AS OB_BK1_CNT" ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '30' THEN SR.RCT_NO ELSE '' END              AS TOT_BK1_CNT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '30' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS IB_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '30' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS TOT_BK1_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '30' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS IB_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > 0 AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '30' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS TOT_BK1_BAL_USD_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '30' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '60' THEN SR.RCT_NO ELSE '' END              AS IB_BK2_CNT" ).append("\n"); 
		query.append("      , '' AS OB_BK2_CNT" ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '30' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '60' THEN SR.RCT_NO ELSE '' END              AS TOT_BK2_CNT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '30' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '60' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS IB_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '30' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '60' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS TOT_BK2_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '30' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '60' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS IB_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '30' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '60' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS TOT_BK2_BAL_USD_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '60' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '90' THEN SR.RCT_NO ELSE '' END              AS IB_BK3_CNT" ).append("\n"); 
		query.append("      , '' AS OB_BK3_CNT" ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '60' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '90' THEN SR.RCT_NO ELSE '' END              AS TOT_BK3_CNT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '60' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '90' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS IB_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '60' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '90' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS TOT_BK3_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '60' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '90' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS IB_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '60' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '90' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS TOT_BK3_BAL_USD_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '90' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '120' THEN SR.RCT_NO ELSE '' END              AS IB_BK4_CNT" ).append("\n"); 
		query.append("      , '' AS OB_BK4_CNT" ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '90' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '120' THEN SR.RCT_NO ELSE '' END              AS TOT_BK4_CNT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '90' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '120' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS IB_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '90' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '120' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS TOT_BK4_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '90' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '120' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS IB_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '90' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '120' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS TOT_BK4_BAL_USD_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '120' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '180' THEN SR.RCT_NO ELSE '' END              AS IB_BK5_CNT" ).append("\n"); 
		query.append("      , '' AS OB_BK5_CNT" ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '120' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '180' THEN SR.RCT_NO ELSE '' END              AS TOT_BK5_CNT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '120' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '180' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS IB_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '120' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '180' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS TOT_BK5_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '120' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '180' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS IB_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '120' AND TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') <= '180' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS TOT_BK5_BAL_USD_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '180' THEN SR.RCT_NO ELSE '' END              AS IB_BK6_CNT" ).append("\n"); 
		query.append("      , '' AS OB_BK6_CNT" ).append("\n"); 
		query.append("      , CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '180' THEN SR.RCT_NO ELSE '' END              AS TOT_BK6_CNT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '180' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS IB_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '180' THEN ROUND((SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, MO.AR_CURR_CD)),NVL((SELECT A.DP_PRCS_KNT FROM MDM_CURRENCY A WHERE A.CURR_CD = MO.AR_CURR_CD),0)) ELSE 0 END) AS TOT_BK6_BAL_LOCL_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '180' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS IB_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append("      , 0 AS OB_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append("      , ROUND(SUM(CASE WHEN TO_DATE(@[due_dt], 'YYYYMMDD') - TO_DATE(SR.RCT_DT, 'YYYYMMDD') > '180' THEN (SR.BAL_RCT_AMT*-1*SAR_GET_GL_XCH_RT_FNC('1', SR.RCT_DT, SR.RCT_CURR_CD, 'USD')) ELSE 0 END), (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = 'USD'))  AS TOT_BK6_BAL_USD_AMT" ).append("\n"); 
		query.append("FROM   SAR_RECEIPT SR," ).append("\n"); 
		query.append("       MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("       MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE  SR.RCT_OFC_CD = MO.OFC_CD   " ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND    SR.RCT_DT < @[due_dt]" ).append("\n"); 
		query.append("AND    SR.BAL_RCT_AMT <> 0 " ).append("\n"); 
		query.append("#if(${clt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    SR.RCT_OFC_CD IN (${clt_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("AND	   MO.AR_HD_QTR_OFC_CD IN (${rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bil_to_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND SR.RCT_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bil_to_cust_seq} != '')" ).append("\n"); 
		query.append("AND SR.RCT_CUST_SEQ  = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    SR.RCT_STS_CD = 'UNAPP'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("      SR.RCT_OFC_CD         " ).append("\n"); 
		query.append("      ,SR.RCT_CUST_CNT_CD  " ).append("\n"); 
		query.append("      ,SR.RCT_CUST_SEQ " ).append("\n"); 
		query.append("      ,SR.RCT_OFC_CD || SR.RCT_CUST_CNT_CD || SR.RCT_CUST_SEQ" ).append("\n"); 
		query.append("      ,MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,SR.RCT_NO" ).append("\n"); 
		query.append("      ,SR.RCT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if(${sum_ofc_cust_tp} == 'OFC')" ).append("\n"); 
		query.append("  #if(${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("  GROUP BY " ).append("\n"); 
		query.append("    CLT_OFC_CD" ).append("\n"); 
		query.append("  , PRIMARY_KEY" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("  CLT_OFC_CD" ).append("\n"); 
		query.append(", BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append(", BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append(", PRIMARY_KEY" ).append("\n"); 
		query.append(", CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}