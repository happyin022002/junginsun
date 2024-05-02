/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeDBDAOPriScgRtExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOPriScgRtExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201431588] Surcharge Inquiry 화면의 surcharge 개정 이력 관리 추가
	  * 2015.04.10 전지예 [CHM-201535041] Arrival Date 항목 추가
	  * 2015.05.18 전지예 [CHM-201535941] [Surcharge Inquiry] 조회화면 중 Arrival Date 컬럼 추가
	  * </pre>
	  */
	public SurchargeDBDAOPriScgRtExcelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgRtExcelRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       SVC_SCP_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("     , POR_DEF_CD" ).append("\n"); 
		query.append("     , POL_DEF_CD" ).append("\n"); 
		query.append("     , POD_DEF_CD" ).append("\n"); 
		query.append("     , DEL_DEF_CD" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , PSA_NO" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , SCG_AMT" ).append("\n"); 
		query.append("     , PAY_TERM_CD" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("     , CTRT_DT" ).append("\n"); 
		query.append("     , ARR_DT" ).append("\n"); 
		query.append("     , ACT_RAT_FLG" ).append("\n"); 
		query.append("     , PRN_HDN_FLG" ).append("\n"); 
		query.append("     , CNT_CD" ).append("\n"); 
		query.append("     , STE_CD" ).append("\n"); 
		query.append("     , CNL_TZ_CD" ).append("\n"); 
		query.append("     , MIN_CGO_WGT" ).append("\n"); 
		query.append("     , MAX_CGO_WGT     " ).append("\n"); 
		query.append("     , ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , VSL_SLAN_CD" ).append("\n"); 
		query.append("     , DIR_CALL_FLG" ).append("\n"); 
		query.append("     , TML_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , IO_GA_CD" ).append("\n"); 
		query.append("     , TS_PORT_CD" ).append("\n"); 
		query.append("     , SOC_FLG" ).append("\n"); 
		query.append("     , CG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , FD_GRD_FLG" ).append("\n"); 
		query.append("     , RC_AIR_COND_TP_CD         " ).append("\n"); 
		query.append("     , USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , WDR_FLG" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append("     , SCG_PRD_TP_CD" ).append("\n"); 
		query.append("     , SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("     , UPD_USR_NM" ).append("\n"); 
		query.append("     , SCG_RMK  " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '0' AS SEQ_ORDER" ).append("\n"); 
		query.append("     , 'Scope' AS SVC_SCP_CD" ).append("\n"); 
		query.append("     , 'Charge' AS CHG_CD" ).append("\n"); 
		query.append("     , 'POR' AS POR_DEF_CD" ).append("\n"); 
		query.append("     , 'POL' AS POL_DEF_CD" ).append("\n"); 
		query.append("     , 'POD' AS POD_DEF_CD" ).append("\n"); 
		query.append("     , 'DEL' AS DEL_DEF_CD" ).append("\n"); 
		query.append("     , 'PER' AS RAT_UT_CD" ).append("\n"); 
		query.append("     , 'Cargo Type' AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , 'IMDG Class' AS SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , 'PSA Group' AS PSA_NO" ).append("\n"); 
		query.append("     , 'Cur.' AS CURR_CD" ).append("\n"); 
		query.append("     , 'Amount/Percentage(%)' AS SCG_AMT" ).append("\n"); 
		query.append("     , 'Pay Term' AS PAY_TERM_CD" ).append("\n"); 
		query.append("     , '     Effective Date     ' AS EFF_DT" ).append("\n"); 
		query.append("     , 'Expiration Date     ' AS EXP_DT" ).append("\n"); 
		query.append("     , 'Contract Date     ' AS CTRT_DT" ).append("\n"); 
		query.append("     , 'Arrival Date     ' AS ARR_DT" ).append("\n"); 
		query.append("     , 'Auto' AS ACT_RAT_FLG" ).append("\n"); 
		query.append("     , 'Hide' AS PRN_HDN_FLG" ).append("\n"); 
		query.append("     , 'Country' AS CNT_CD" ).append("\n"); 
		query.append("     , 'State' AS STE_CD" ).append("\n"); 
		query.append("     , 'Canal' AS CNL_TZ_CD" ).append("\n"); 
		query.append("     , 'Weight MIN <= TON' AS MIN_CGO_WGT" ).append("\n"); 
		query.append("     , 'Weight MAX > TON' AS MAX_CGO_WGT     " ).append("\n"); 
		query.append("     , 'Trans. Mode Origin' AS ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , 'Trans. Mode Dest' AS DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , 'R/D Term Origin' AS PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , 'R/D Term Dest' AS PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , 'Bar Type' AS PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , 'Sub trade' AS  SUB_TRD_CD" ).append("\n"); 
		query.append("     , 'Lane' AS VSL_SLAN_CD" ).append("\n"); 
		query.append("     , 'Direct Call' AS DIR_CALL_FLG" ).append("\n"); 
		query.append("     , 'Terminal' AS TML_CD" ).append("\n"); 
		query.append("     , 'Commodity' AS CMDT_CD" ).append("\n"); 
		query.append("     , 'In/Out Gauge' AS IO_GA_CD" ).append("\n"); 
		query.append("     , 'T/S Port' AS TS_PORT_CD" ).append("\n"); 
		query.append("     , 'Shippers Own Container(S.O.C)' AS SOC_FLG" ).append("\n"); 
		query.append("     , 'Commodity Group' AS CG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , 'Food Grade' AS FD_GRD_FLG" ).append("\n"); 
		query.append("     , 'RF Condition' AS RC_AIR_COND_TP_CD         " ).append("\n"); 
		query.append("     , 'US Service Mode' AS USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , 'Del Mark' AS WDR_FLG" ).append("\n"); 
		query.append("     , 'Update Date      ' AS  UPD_DT" ).append("\n"); 
		query.append("     , 'Days' AS SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append("     , 'Period Type' AS SCG_PRD_TP_CD" ).append("\n"); 
		query.append("     , 'Period Criteria' AS SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("     , 'User Name' AS UPD_USR_NM" ).append("\n"); 
		query.append("     , 'Remark(s)' AS SCG_RMK     " ).append("\n"); 
		query.append("FROM DUAL  " ).append("\n"); 
		query.append("UNION ALL     " ).append("\n"); 
		query.append("SELECT '1' AS SEQ_ORDER" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD AS SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.CHG_CD AS CHG_CD" ).append("\n"); 
		query.append("     , A.POR_DEF_CD AS POR_DEF_CD" ).append("\n"); 
		query.append("     , A.POL_DEF_CD AS POL_DEF_CD" ).append("\n"); 
		query.append("     , A.POD_DEF_CD AS POD_DEF_CD" ).append("\n"); 
		query.append("     , A.DEL_DEF_CD AS DEL_DEF_CD" ).append("\n"); 
		query.append("     , A.RAT_UT_CD AS RAT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.SCG_IMDG_CLSS_CD AS SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , A.PSA_NO AS PSA_NO" ).append("\n"); 
		query.append("     , A.CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("     , '' || (CASE (SELECT FLT_PCT_TP_CD FROM PRI_SCG_PRF WHERE SVC_SCP_CD = A.SVC_SCP_CD AND CHG_CD = A.CHG_CD) " ).append("\n"); 
		query.append("          WHEN 'F' THEN DECODE(SCG_AMT, 0, TO_CHAR(SCG_AMT), TO_CHAR(SCG_AMT, '999,999,999.99'))" ).append("\n"); 
		query.append("          ELSE TO_CHAR(SCG_AMT) || '%'" ).append("\n"); 
		query.append("       END) AS SCG_AMT" ).append("\n"); 
		query.append("    -- , A.PAY_TERM_CD AS PAY_TERM_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01713' AND INTG_CD_VAL_CTNT(+) = A.PAY_TERM_CD) AS PAY_TERM_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , DECODE(TO_CHAR(A.EXP_DT, 'YYYYMMDD'), '99991231', NULL, TO_CHAR(A.EXP_DT, 'YYYY-MM-DD')) AS EXP_DT   " ).append("\n"); 
		query.append("     , TO_CHAR(A.CTRT_DT, 'YYYY-MM-DD') AS CTRT_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.ARR_DT, 'YYYY-MM-DD') AS ARR_DT" ).append("\n"); 
		query.append("     , DECODE(A.ACT_RAT_FLG, 'Y', 'YES', 'N', 'NO') AS ACT_RAT_FLG" ).append("\n"); 
		query.append("     , A.PRN_HDN_FLG AS PRN_HDN_FLG" ).append("\n"); 
		query.append("     , A.CNT_CD AS CNT_CD" ).append("\n"); 
		query.append("     , A.STE_CD AS STE_CD" ).append("\n"); 
		query.append("     , A.CNL_TZ_CD AS CNL_TZ_CD" ).append("\n"); 
		query.append("     , '' || A.MIN_CGO_WGT AS MIN_CGO_WGT" ).append("\n"); 
		query.append("     , '' || A.MAX_CGO_WGT AS MAX_CGO_WGT" ).append("\n"); 
		query.append("--     , A.ORG_TRSP_MOD_CD AS ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("--     , A.DEST_TRSP_MOD_CD AS DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT(+) = A.ORG_TRSP_MOD_CD) AS ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT(+) = A.DEST_TRSP_MOD_CD) AS DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("--     , A.PRC_RCV_TERM_CD AS PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("--     , A.PRC_DE_TERM_CD AS PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02070' AND INTG_CD_VAL_CTNT(+) = A.PRC_RCV_TERM_CD) AS PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02071' AND INTG_CD_VAL_CTNT(+) = A.PRC_DE_TERM_CD) AS PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("--     , A.PRC_HNGR_BAR_TP_CD AS PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01708' AND INTG_CD_VAL_CTNT(+) = A.PRC_HNGR_BAR_TP_CD) AS PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , A.SUB_TRD_CD AS SUB_TRD_CD" ).append("\n"); 
		query.append("     , A.VSL_SLAN_CD AS VSL_SLAN_CD   " ).append("\n"); 
		query.append("     , DECODE(A.DIR_CALL_FLG, 'Y', 'YES', 'N', 'NO') AS DIR_CALL_FLG" ).append("\n"); 
		query.append("     , A.TML_CD AS TML_CD" ).append("\n"); 
		query.append("     , A.CMDT_CD AS CMDT_CD" ).append("\n"); 
		query.append("--     , A.IO_GA_CD AS IO_GA_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02142' AND INTG_CD_VAL_CTNT(+) = A.IO_GA_CD) AS IO_GA_CD" ).append("\n"); 
		query.append("     , A.TS_PORT_CD AS TS_PORT_CD" ).append("\n"); 
		query.append("     , DECODE(A.SOC_FLG, 'Y', 'YES', 'N', 'NO') AS SOC_FLG" ).append("\n"); 
		query.append("     , A.SCG_GRP_CMDT_CD AS SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , DECODE(A.FD_GRD_FLG, 'Y', 'YES', 'N', 'NO') AS FD_GRD_FLG" ).append("\n"); 
		query.append("--     , A.RC_AIR_COND_TP_CD AS RC_AIR_COND_TP_CD    " ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03187' AND INTG_CD_VAL_CTNT(+) = A.RC_AIR_COND_TP_CD) AS RC_AIR_COND_TP_CD" ).append("\n"); 
		query.append("--     , A.USA_SVC_MOD_CD AS USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01729' AND INTG_CD_VAL_CTNT(+) = A.USA_SVC_MOD_CD) AS USA_SVC_MOD_CD" ).append("\n"); 
		query.append("--     , DECODE(A.WDR_FLG, 'Y', '1', 'N', '0') AS WDR_FLG" ).append("\n"); 
		query.append("     , A.WDR_FLG AS WDR_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("     , '' || A.SCG_CRTE_DY_KNT AS SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append("--     , A.SCG_PRD_TP_CD AS SCG_PRD_TP_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02955' AND INTG_CD_VAL_CTNT(+) = A.SCG_PRD_TP_CD) AS SCG_PRD_TP_CD" ).append("\n"); 
		query.append("--     , A.SCG_PRD_CRTE_CD AS SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02957' AND INTG_CD_VAL_CTNT(+) = A.SCG_PRD_CRTE_CD) AS SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) AS UPD_USR_NM" ).append("\n"); 
		query.append("     , TRIM(A.SCG_RMK) AS SCG_RMK" ).append("\n"); 
		query.append("FROM PRI_SCG_RT A" ).append("\n"); 
		query.append("#if (${por_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT @[por_def_cd] AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("                 WHERE LENGTH (@[por_def_cd]) = 4" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POR_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POR_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POR_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POR_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[por_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[por_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                  WHERE A.DTL_LOC_DEF_CD = B.POR_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT @[pol_def_cd] AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("                 WHERE LENGTH (@[pol_def_cd]) = 4" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pol_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pol_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                  WHERE A.DTL_LOC_DEF_CD = B.POL_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT @[pod_def_cd] AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("                 WHERE LENGTH (@[pod_def_cd]) = 4" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS POD_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS POD_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT POD_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS POD_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[pod_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[pod_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                  WHERE A.DTL_LOC_DEF_CD = B.POD_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT @[del_def_cd] AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("                 WHERE LENGTH (@[del_def_cd]) = 4" ).append("\n"); 
		query.append("                UNION " ).append("\n"); 
		query.append("                SELECT 'NULL' AS DEL_DEF_CD" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT A1.SCG_GRP_LOC_CD AS DEL_DEF_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_GRP_LOC A1" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                     , CHG_CD" ).append("\n"); 
		query.append("                     , GRP_LOC_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_SCG_GRP_LOC_DTL A" ).append("\n"); 
		query.append("                     , (SELECT DEL_DEF_CD" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT(LOC_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(RGN_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                UNION" ).append("\n"); 
		query.append("                                SELECT DISTINCT(CNT_CD) AS DEL_DEF_CD" ).append("\n"); 
		query.append("                                  FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                 WHERE DECODE(LENGTH(@[del_def_cd]), 5, LOC_CD, 3, RGN_CD, 2, CNT_CD) = @[del_def_cd]" ).append("\n"); 
		query.append("                                   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.DTL_LOC_DEF_CD = B.DEL_DEF_CD" ).append("\n"); 
		query.append("				 #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("				   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if (${chg_cd} != '') " ).append("\n"); 
		query.append("                   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("         WHERE A1.SVC_SCP_CD = B1.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("           AND A1.GRP_LOC_SEQ = B1.GRP_LOC_SEQ" ).append("\n"); 
		query.append("           AND A1.DELT_FLG = 'N'      " ).append("\n"); 
		query.append("       ) E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_sz_cd} != '')" ).append("\n"); 
		query.append("   , PRI_RAT_UT F" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '') " ).append("\n"); 
		query.append("AND	A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POR_DEF_CD, 'NULL') = B.POR_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POL_DEF_CD, 'NULL') = C.POL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '') " ).append("\n"); 
		query.append("   AND NVL(A.POD_DEF_CD, 'NULL') = D.POD_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("   AND NVL(A.DEL_DEF_CD, 'NULL') = E.DEL_DEF_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_rcv_term_cd} != '')" ).append("\n"); 
		query.append("AND	NVL(A.PRC_RCV_TERM_CD, 'NULL') IN (@[prc_rcv_term_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_de_term_cd} != '')" ).append("\n"); 
		query.append("AND	NVL(A.PRC_DE_TERM_CD, 'NULL') IN (@[prc_de_term_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_dt} != '')" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[eff_dt],'-',''), 'YYYYMMDD') <= A.EXP_DT  " ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[exp_dt],'-',''), 'YYYYMMDD') >= A.EFF_DT " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${upd_dt} != '')" ).append("\n"); 
		query.append("AND	A.UPD_DT BETWEEN TO_DATE(REPLACE(@[upd_dt],'-','')||'000000', 'YYYYMMDDHH24MISS') AND TO_DATE(REPLACE(@[upd_dt],'-','')||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND	NVL(A.PRC_CGO_TP_CD, 'NULL') IN (@[prc_cgo_tp_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("AND NVL(A.SCG_IMDG_CLSS_CD, 'NULL') IN (@[scg_imdg_clss_cd], 'NULL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("AND A.RAT_UT_CD IN (" ).append("\n"); 
		query.append("					SELECT   @[rat_ut_cd] RAT_UT_CD FROM DUAL" ).append("\n"); 
		query.append("#if (${is_num} == 'Y')" ).append("\n"); 
		query.append("					UNION" ).append("\n"); 
		query.append("					SELECT   RAT_UT_CD" ).append("\n"); 
		query.append("					FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("					WHERE    CNTR_SZ_CD = (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("                       					   FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                       					   WHERE    RAT_UT_CD = @[rat_ut_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					UNION" ).append("\n"); 
		query.append("					SELECT RAT_UT_CD" ).append("\n"); 
		query.append("					FROM(" ).append("\n"); 
		query.append("						SELECT   RAT_UT_CD, RANK() OVER (ORDER BY RAT_UT_CD) RNUM" ).append("\n"); 
		query.append("						FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("						WHERE    CNTR_SZ_CD = (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("                       					   		FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("                       					  		 WHERE    RAT_UT_CD = @[rat_ut_cd])" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					WHERE RNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT   RAT_UT_CD" ).append("\n"); 
		query.append("					FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("					WHERE    CNTR_SZ_CD IS NULL" ).append("\n"); 
		query.append("     				AND (SELECT   CNTR_SZ_CD" ).append("\n"); 
		query.append("          				 FROM     PRI_RAT_UT" ).append("\n"); 
		query.append("          				 WHERE    RAT_UT_CD = @[rat_ut_cd]) IS NOT NULL" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_sz_cd} != '')" ).append("\n"); 
		query.append("AND F.CNTR_SZ_CD = @[cntr_sz_cd]" ).append("\n"); 
		query.append("AND F.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.RAT_UT_CD = F.RAT_UT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wdr_flg} == '')" ).append("\n"); 
		query.append("AND A.WDR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${type_cd} == 'L')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD IN" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				SELECT   A.SVC_SCP_CD" ).append("\n"); 
		query.append("				FROM     MDM_SVC_SCP A" ).append("\n"); 
		query.append("        			   ,(SELECT   DISTINCT (B.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("          				 FROM     MDM_LOCATION A, MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append("          				 WHERE    A.LOC_CD = @[por_def_cd]" ).append("\n"); 
		query.append("               			 AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               			 AND B.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("               		  	 AND B.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("               			 AND B.DELT_FLG = 'N') O" ).append("\n"); 
		query.append("        			   ,(SELECT   DISTINCT (B.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("          				 FROM     MDM_LOCATION A, MDM_SVC_SCP_LMT B" ).append("\n"); 
		query.append("          				 WHERE    A.LOC_CD = @[del_def_cd]" ).append("\n"); 
		query.append("               			 AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               			 AND B.RGN_CD = A.RGN_CD" ).append("\n"); 
		query.append("               			 AND B.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("               			 AND B.DELT_FLG = 'N') D" ).append("\n"); 
		query.append("				WHERE    A.SVC_SCP_CD = O.SVC_SCP_CD" ).append("\n"); 
		query.append("     			AND O.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("     			AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#elseif(${type_cd} == 'R')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD IN" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("                SELECT   A.SVC_SCP_CD" ).append("\n"); 
		query.append("                FROM     MDM_SVC_SCP A" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("                          WHERE    RGN_CD = @[por_def_cd]" ).append("\n"); 
		query.append("                               AND ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("                               AND DELT_FLG = 'N') O" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_SVC_SCP_LMT" ).append("\n"); 
		query.append("                          WHERE    RGN_CD = @[del_def_cd]" ).append("\n"); 
		query.append("                               AND ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("                               AND DELT_FLG = 'N') D" ).append("\n"); 
		query.append("                WHERE    A.SVC_SCP_CD = O.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND O.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#elseif (${type_cd} == 'C')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD IN" ).append("\n"); 
		query.append("				(				" ).append("\n"); 
		query.append("				SELECT   A.SVC_SCP_CD" ).append("\n"); 
		query.append("                FROM     MDM_SVC_SCP A" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (C.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_COUNTRY A, MDM_REGION B, MDM_SVC_SCP_LMT C" ).append("\n"); 
		query.append("                          WHERE    A.CNT_CD = @[por_def_cd]" ).append("\n"); 
		query.append("                               AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND C.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("                               AND C.ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("                               AND C.DELT_FLG = 'N') O" ).append("\n"); 
		query.append("                        ,(SELECT   DISTINCT (C.SVC_SCP_CD) AS SVC_SCP_CD" ).append("\n"); 
		query.append("                          FROM     MDM_COUNTRY A, MDM_REGION B, MDM_SVC_SCP_LMT C" ).append("\n"); 
		query.append("                          WHERE    A.CNT_CD = @[del_def_cd]" ).append("\n"); 
		query.append("                               AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND C.RGN_CD = B.RGN_CD" ).append("\n"); 
		query.append("                               AND C.ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("                               AND C.DELT_FLG = 'N') D" ).append("\n"); 
		query.append("                WHERE    A.SVC_SCP_CD = O.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND O.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("                     AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("       SEQ_ORDER" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("     , POR_DEF_CD" ).append("\n"); 
		query.append("     , POL_DEF_CD" ).append("\n"); 
		query.append("     , POD_DEF_CD" ).append("\n"); 
		query.append("     , DEL_DEF_CD" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , PSA_NO" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , PAY_TERM_CD" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("     , CTRT_DT" ).append("\n"); 
		query.append("     , ARR_DT" ).append("\n"); 
		query.append("     , ACT_RAT_FLG" ).append("\n"); 
		query.append("     , PRN_HDN_FLG" ).append("\n"); 
		query.append("     , CNT_CD" ).append("\n"); 
		query.append("     , STE_CD" ).append("\n"); 
		query.append("     , CNL_TZ_CD" ).append("\n"); 
		query.append("     , MIN_CGO_WGT" ).append("\n"); 
		query.append("     , MAX_CGO_WGT     " ).append("\n"); 
		query.append("     , ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , VSL_SLAN_CD" ).append("\n"); 
		query.append("     , DIR_CALL_FLG" ).append("\n"); 
		query.append("     , TML_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , IO_GA_CD" ).append("\n"); 
		query.append("     , TS_PORT_CD" ).append("\n"); 
		query.append("     , SOC_FLG" ).append("\n"); 
		query.append("     , CG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , FD_GRD_FLG" ).append("\n"); 
		query.append("     , RC_AIR_COND_TP_CD         " ).append("\n"); 
		query.append("     , USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , WDR_FLG" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append("     , SCG_PRD_TP_CD" ).append("\n"); 
		query.append("     , SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("     , UPD_USR_NM" ).append("\n"); 
		query.append("     , SCG_RMK" ).append("\n"); 

	}
}