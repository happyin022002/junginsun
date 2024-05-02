/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerCargoClaimReportDBDAOSearchStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerCargoClaimReportDBDAOSearchStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Status 목록 조회
	  * 2010.11.05 이준범 [CHM-201006881-01]
	  * 1. 대상  UI : UI_CNI_0018
	  * 2. 요청사항 : Status Dropdown 에서 "All" 을 선택하여 조회 시, Status XX or X는 조회 대상에서 제외 함
	  *                       대상 List에서 제외되므로 "계산"시에도 제외 시킴.
	  * </pre>
	  */
	public ContainerCargoClaimReportDBDAOSearchStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_plc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_clmt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pre_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_cgo_clm_stl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmal_clm_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svey_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_period",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_inci_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mjr_clm_dmg_lss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slv_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_agn_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cgo_clm_stl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_clmt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pst_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("minr_clm_dmg_lss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_period",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration").append("\n"); 
		query.append("FileName : ContainerCargoClaimReportDBDAOSearchStatusListRSQL").append("\n"); 
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
		query.append("    CGO_CLM_DIV_CD" ).append("\n"); 
		query.append("  , CGO_CLM_NO" ).append("\n"); 
		query.append("  , CLM_AREA_CD" ).append("\n"); 
		query.append("  , HDLR_OFC_CD" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_OFC_CD" ).append("\n"); 
		query.append("  , HDLR_USR_ID1" ).append("\n"); 
		query.append("  , HDLR_USR_ID2" ).append("\n"); 
		query.append("  , CGO_CLM_STS_CD" ).append("\n"); 
		query.append("  , LIT" ).append("\n"); 
		query.append("  , CS_CLZ_DT" ).append("\n"); 
		query.append("  , HPD" ).append("\n"); 
		query.append("  , NHP" ).append("\n"); 
		query.append("  , PRLM_CLM_NTC_DT" ).append("\n"); 
		query.append("  , FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , CLMT_CLM_TP_CD" ).append("\n"); 
		query.append("  , CLM_PTY_ABBR_NM1" ).append("\n"); 
		query.append("  , CLM_PTY_ABBR_NM2" ).append("\n"); 
		query.append("  , SLAN_CD" ).append("\n"); 
		query.append("  , TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("  , CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("  , CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("  , TP_SZ" ).append("\n"); 
		query.append("  , CNT" ).append("\n"); 
		query.append("  , CRR_TERM_CD" ).append("\n"); 
		query.append("  , POR_CD" ).append("\n"); 
		query.append("  , RCT_DT" ).append("\n"); 
		query.append("  , POL_CD" ).append("\n"); 
		query.append("  , POD_CD" ).append("\n"); 
		query.append("  , DEL_CD" ).append("\n"); 
		query.append("  , DE_DT" ).append("\n"); 
		query.append("  , CLM_TM_BAR_DT" ).append("\n"); 
		query.append("  , LABL_TM_BAR_DT" ).append("\n"); 
		query.append("  , FVD" ).append("\n"); 
		query.append("  , N1ST_PRE_TS_LOC_CD" ).append("\n"); 
		query.append("  , N1ST_PST_TS_LOC_CD" ).append("\n"); 
		query.append("  , CLM_CGO_TP_NM " ).append("\n"); 
		query.append("  , CGO_CLM_TP_CD" ).append("\n"); 
		query.append("  , MJR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append("  , MINR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append("  , CLMT_USD_AMT -- Claim Amount" ).append("\n"); 
		query.append("  , CGO_CLM_ACKNAK_DT -- DOAK" ).append("\n"); 
		query.append("  , FACT_FND_DT -- DOFF" ).append("\n"); 
		query.append("  , CGO_CLM_STL_TP_CD -- TOS" ).append("\n"); 
		query.append("  , CGO_CLM_STL_DT" ).append("\n"); 
		query.append("  , CGO_CLM_STL_USD_AMT" ).append("\n"); 
		query.append("  , INCI_PLC_TP_CD" ).append("\n"); 
		query.append("  , LABL_CLM_PTY_NO" ).append("\n"); 
		query.append("  , HNDL_OFC_CD" ).append("\n"); 
		query.append("  , LABL_PTY_FMAL_CLM_DT" ).append("\n"); 
		query.append("  , LABL_PTY_DMND_USD_AMT LABL_PTY_DMND_AMT  -- LP CAMT" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_DT -- LP DOR" ).append("\n"); 
		query.append("  , LABL_PTY_RCVR_USD_AMT -- LP RAMT" ).append("\n"); 
		query.append("  , INSUR_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , INSUR_FMAL_CLM_DT -- INS DOF" ).append("\n"); 
		query.append("  , INSUR_DMND_AMT -- INS CAMT" ).append("\n"); 
		query.append("  , INS_DOR" ).append("\n"); 
		query.append("  , INSUR_RCVR_AMT -- INS RMAT" ).append("\n"); 
		query.append("  , SVEY_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , SVEY_INP_DT -- DOSV" ).append("\n"); 
		query.append("  , SVYR_FEE_USD_AMT" ).append("\n"); 
		query.append("  , SLAVER_CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , SLV_DT" ).append("\n"); 
		query.append("  , SLV_USD_AMT" ).append("\n"); 
		query.append("  , APPLICANT" ).append("\n"); 
		query.append("  , APOFC" ).append("\n"); 
		query.append("  , DOAP" ).append("\n"); 
		query.append("  , APPROVER" ).append("\n"); 
		query.append("  , AVSTS" ).append("\n"); 
		query.append("  , AVOFC" ).append("\n"); 
		query.append("  , DOAV" ).append("\n"); 
		query.append("  , APPROVAL_NO" ).append("\n"); 
		query.append("  , PLT_NM" ).append("\n"); 
		query.append("  , AGN_CLM_PTY_ABBR_NM -- PL Attorney" ).append("\n"); 
		query.append("  , CRT_NM" ).append("\n"); 
		query.append("  , CRT_CS_NO" ).append("\n"); 
		query.append("  , SMNS_SVE_DT" ).append("\n"); 
		query.append("  , DEFT_NM" ).append("\n"); 
		query.append("  , CLM_PTY_ABBR_NM3" ).append("\n"); 
		query.append("  , DEFT_ATTY_APNT_DT" ).append("\n"); 
		query.append("  , LEGAL_COSTS" ).append("\n"); 
		query.append("  , CGO_CLM_INCI_NO" ).append("\n"); 
		query.append("  , CRM_VOC_NO" ).append("\n"); 
		query.append("  , PERIOD1" ).append("\n"); 
		query.append("  , PERIOD2" ).append("\n"); 
		query.append("  , PERIOD3" ).append("\n"); 
		query.append("  , PERIOD4" ).append("\n"); 
		query.append("  , PERIOD5" ).append("\n"); 
		query.append("  , PERIOD6" ).append("\n"); 
		query.append("  , ROW_NUM" ).append("\n"); 
		query.append("  , TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("   SELECT " ).append("\n"); 
		query.append("     DECODE (CLM_V.CGO_CLM_DIV_CD, 'G', 'GEN', 'I', 'INC', 'O', 'OTH') AS CGO_CLM_DIV_CD -- VT" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_NO  -- Claim No" ).append("\n"); 
		query.append("   , CLM_V.CLM_AREA_CD -- A" ).append("\n"); 
		query.append("   , CLM_V.HDLR_OFC_CD  -- HOFC" ).append("\n"); 
		query.append("   , CLM_V.FMAL_CLM_RCV_OFC_CD  -- ROFC " ).append("\n"); 
		query.append("   , CLM_V.HDLR_USR_ID AS HDLR_USR_ID1 -- Handler" ).append("\n"); 
		query.append("   , MGR.HDLR_USR_ID AS HDLR_USR_ID2  -- Manager" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_CLZ_CD||CLM_V.CGO_CLM_STS_CD  AS CGO_CLM_STS_CD -- STS" ).append("\n"); 
		query.append("   , DECODE(CLM_V.SMNS_SVE_DT, NULL, 'N', 'Y') AS  LIT -- LIT" ).append("\n"); 
		query.append("   , CLM_V.CS_CLZ_DT  -- DOC" ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.CS_CLZ_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -" ).append("\n"); 
		query.append("      TO_DATE(CLM_V.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS HPD" ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.CGO_CLM_STL_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') -" ).append("\n"); 
		query.append("     TO_DATE(CLM_V.FMAL_CLM_RCV_DT,'YYYYMMDD')) + 1  AS NHP" ).append("\n"); 
		query.append("   , CLM_V.PRLM_CLM_NTC_DT -- NOPC DT" ).append("\n"); 
		query.append("   , CLM_V.FMAL_CLM_RCV_DT -- DOF" ).append("\n"); 
		query.append("   , TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD') AS UPD_DT -- Updated" ).append("\n"); 
		query.append("   , CLM_V.CLMT_CLM_TP_CD -- Claimant Type Cd" ).append("\n"); 
		query.append("   , PARTY1.PTY_NM AS CLM_PTY_ABBR_NM1 -- Claimant Nm" ).append("\n"); 
		query.append("   , PARTY2.CLM_PTY_ABBR_NM AS CLM_PTY_ABBR_NM2 -- Claimants Agent" ).append("\n"); 
		query.append("   , CLM_V.SLAN_CD -- Lane" ).append("\n"); 
		query.append("   , CLM_V.TRNK_REF_VVD_NO -- VVD" ).append("\n"); 
		query.append("   , BL_DTL.CGO_CLM_REF_BL_NO -- B/L No." ).append("\n"); 
		query.append("   , CNTR_DTL.CGO_CLM_REF_CNTR_NO -- CNTR NO." ).append("\n"); 
		query.append("   , CNTR_DTL.CNTR_TPSZ_CD AS TP_SZ -- TP/SZ" ).append("\n"); 
		query.append("   , CASE WHEN SUBSTR(CNTR_DTL.CNTR_TPSZ_CD,2,1) = '2' THEN 1 " ).append("\n"); 
		query.append("          WHEN SUBSTR(CNTR_DTL.CNTR_TPSZ_CD,2,1) IN ('4', '5', '7') THEN 2" ).append("\n"); 
		query.append("          ELSE 0   " ).append("\n"); 
		query.append("      END AS CNT -- CNT" ).append("\n"); 
		query.append("   , CLM_V.CRR_TERM_CD -- CT" ).append("\n"); 
		query.append("   , CLM_V.POR_CD  -- POR" ).append("\n"); 
		query.append("   , CLM_V.RCT_DT  -- DOR" ).append("\n"); 
		query.append("   , CLM_V.POL_CD  -- POL" ).append("\n"); 
		query.append("   , CLM_V.POD_CD  -- POD" ).append("\n"); 
		query.append("   , CLM_V.DEL_CD  -- DEL" ).append("\n"); 
		query.append("   , CLM_V.DE_DT   -- DDL" ).append("\n"); 
		query.append("   , CLM_V.CLM_TM_BAR_DT  -- T/B" ).append("\n"); 
		query.append("   , CLM_V.LABL_TM_BAR_DT -- LP T/B" ).append("\n"); 
		query.append("   , CLM_V.N1ST_PRE_REF_VVD_NO AS FVD -- FVD" ).append("\n"); 
		query.append("   , CLM_V.N1ST_PRE_TS_LOC_CD AS N1ST_PRE_TS_LOC_CD -- PRE_POT" ).append("\n"); 
		query.append("   , CLM_V.N1ST_PST_TS_LOC_CD AS N1ST_PST_TS_LOC_CD -- PST_POT" ).append("\n"); 
		query.append("   , CLM_V.CLM_CGO_TP_CD -- Cargo" ).append("\n"); 
		query.append("   , CNI_GET_CLM_MISC_NM_FNC('15',CLM_V.CLM_CGO_TP_CD ,'2') AS CLM_CGO_TP_NM -- Cargo Name" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_TP_CD -- TOC" ).append("\n"); 
		query.append("   , CLM_V.MJR_CLM_DMG_LSS_CD -- CODL1" ).append("\n"); 
		query.append("   , CLM_V.MINR_CLM_DMG_LSS_CD -- CODL2" ).append("\n"); 
		query.append("   , CLM_V.CLMT_USD_AMT -- Claim Amount" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_ACKNAK_DT -- DOAK" ).append("\n"); 
		query.append("   , CLM_V.FACT_FND_DT -- DOFF" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_STL_TP_CD -- TOS" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_STL_DT  -- DOS" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_STL_USD_AMT -- Settled Amount" ).append("\n"); 
		query.append("   , CLM_V.INCI_PLC_TP_CD -- POI" ).append("\n"); 
		query.append("   , PARTY7.CLM_PTY_ABBR_NM AS LABL_CLM_PTY_NO -- Liable Party" ).append("\n"); 
		query.append("   , CLM_V.HNDL_OFC_CD AS HNDL_OFC_CD -- LP_HOFC" ).append("\n"); 
		query.append("   , CLM_V.LABL_PTY_FMAL_CLM_DT -- LP DOF" ).append("\n"); 
		query.append("   , CLM_V.LABL_PTY_DMND_USD_AMT  -- LP CAMT" ).append("\n"); 
		query.append("   , CLM_V.LABL_PTY_RCVR_DT -- LP DOR" ).append("\n"); 
		query.append("   , CLM_V.LABL_PTY_RCVR_USD_AMT -- LP RAMT" ).append("\n"); 
		query.append("   , PARTY4.CLM_PTY_ABBR_NM AS INSUR_PTY_ABBR_NM -- INSURER" ).append("\n"); 
		query.append("   , CLM_V.INSUR_FMAL_CLM_DT  -- INS DOF" ).append("\n"); 
		query.append("   , CLM_V.INSUR_DMND_AMT  -- INS CAMT" ).append("\n"); 
		query.append("   , CLM_V.INSUR_RCVR_DT AS INS_DOR -- INS DOR" ).append("\n"); 
		query.append("   , CLM_V.INSUR_RCVR_AMT -- INS RMAT" ).append("\n"); 
		query.append("   , PARTY6.CLM_PTY_ABBR_NM AS SVEY_CLM_PTY_ABBR_NM  --  SURVEYOR " ).append("\n"); 
		query.append("   , CLM_V.SVEY_INP_DT -- DOSV" ).append("\n"); 
		query.append("   , CLM_V.SVYR_FEE_USD_AMT  -- Survey Fee" ).append("\n"); 
		query.append("   , PARTY5.CLM_PTY_ABBR_NM AS SLAVER_CLM_PTY_ABBR_NM -- SALVAGER" ).append("\n"); 
		query.append("   , CLM_V.SLV_DT -- DOSL" ).append("\n"); 
		query.append("   , CLM_V.SLV_USD_AMT -- SL Amount" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_APPL_USR_ID AS APPLICANT  -- Applicant" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_APPL_OFC_CD AS APOFC -- APOFC" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_APPL_DT AS DOAP -- DOAP" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_AUTH_USR_ID AS APPROVER -- Approver" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_AUTH_CD AS AVSTS -- AVSTS" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_AUTH_OFC_CD AS AVOFC -- AVOFC" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_AUTH_DT AS DOAV -- DOAV" ).append("\n"); 
		query.append("   , CLM_V.CLM_STL_AUTH_NO AS APPROVAL_NO -- Approval No. " ).append("\n"); 
		query.append("   , CLM_V.PLT_NM -- Plaintiff" ).append("\n"); 
		query.append("   , PARTY2.CLM_PTY_ABBR_NM AS AGN_CLM_PTY_ABBR_NM  -- PL Attorney" ).append("\n"); 
		query.append("   , CLM_V.CRT_NM -- Court" ).append("\n"); 
		query.append("   , CLM_V.CRT_CS_NO -- Case No." ).append("\n"); 
		query.append("   , CLM_V.SMNS_SVE_DT -- DOSSV" ).append("\n"); 
		query.append("   , CLM_V.DEFT_NM  -- Defendant" ).append("\n"); 
		query.append("   , PARTY3.CLM_PTY_ABBR_NM AS CLM_PTY_ABBR_NM3  -- Def. Attorney" ).append("\n"); 
		query.append("   , CLM_V.DEFT_ATTY_APNT_DT  -- DODAA" ).append("\n"); 
		query.append("   , ( SELECT SUM(CLM_COST.INV_USD_AMT)" ).append("\n"); 
		query.append("         FROM CNI_CGO_CLM_COST CLM_COST" ).append("\n"); 
		query.append("        WHERE CLM_V.CGO_CLM_NO = CLM_COST.CGO_CLM_NO" ).append("\n"); 
		query.append("          AND CLM_COST.CLM_COST_TP_CD = 'L' ) AS  LEGAL_COSTS -- Legal Costs" ).append("\n"); 
		query.append("   , CLM_V.CGO_CLM_INCI_NO -- INC No." ).append("\n"); 
		query.append("   , CLM_V.CRM_VOC_NO -- VOC No." ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.FMAL_CLM_RCV_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM_V.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS PERIOD1" ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.CGO_CLM_ACKNAK_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM_V.FMAL_CLM_RCV_DT,'YYYYMMDD')) + 1 AS PERIOD2" ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.FACT_FND_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM_V.PRLM_CLM_NTC_DT,'YYYYMMDD')) + 1 AS PERIOD3" ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.CGO_CLM_STL_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM_V.FACT_FND_DT,'YYYYMMDD')) + 1 AS PERIOD4" ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.LABL_PTY_PRLM_CLM_NTFY_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM_V.CGO_CLM_STL_DT,'YYYYMMDD')) + 1 AS PERIOD5" ).append("\n"); 
		query.append("   , (TO_DATE(NVL(CLM_V.INSUR_RCVR_DT, TO_CHAR(SYSDATE,'YYYYMMDD')),'YYYYMMDD') - TO_DATE(CLM_V.CGO_CLM_STL_DT,'YYYYMMDD')) + 1 AS PERIOD6" ).append("\n"); 
		query.append("   , ROW_NUMBER () OVER (ORDER BY CLM_v.CGO_CLM_NO DESC) ROW_NUM" ).append("\n"); 
		query.append("   , COUNT (*) OVER () TOTAL" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("     CNI_CLM_V  CLM_V" ).append("\n"); 
		query.append("   , CNI_AREA_OFC B" ).append("\n"); 
		query.append("   , CNI_PARTY PARTY1" ).append("\n"); 
		query.append("   , CNI_PARTY PARTY2" ).append("\n"); 
		query.append("   , CNI_PARTY PARTY3" ).append("\n"); 
		query.append("   , CNI_PARTY PARTY4" ).append("\n"); 
		query.append("   , CNI_PARTY PARTY5" ).append("\n"); 
		query.append("   , CNI_PARTY PARTY6" ).append("\n"); 
		query.append("   , CNI_PARTY PARTY7" ).append("\n"); 
		query.append("   , (SELECT  A.CGO_CLM_NO" ).append("\n"); 
		query.append("             ,A.CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("        FROM  CNI_CGO_CLM_BL_DTL A" ).append("\n"); 
		query.append("             ,BKG_BOOKING B" ).append("\n"); 
		query.append("       WHERE A.CGO_CLM_REF_BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("         AND A.MN_BL_FLG = 'Y' --대표 B/L 번호 -- 3326 -- 33506" ).append("\n"); 
		query.append("     ) BL_DTL" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("      SELECT A.CGO_CLM_NO" ).append("\n"); 
		query.append("            ,A.CGO_CLM_REF_BL_NO " ).append("\n"); 
		query.append("            ,A.CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("            ,B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT A.CGO_CLM_NO" ).append("\n"); 
		query.append("                  ,A.CGO_CLM_REF_BL_NO " ).append("\n"); 
		query.append("                  ,A.CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("                  ,B.BKG_NO      " ).append("\n"); 
		query.append("              FROM CNI_CGO_CLM_CNTR_DTL A" ).append("\n"); 
		query.append("                  ,BKG_BOOKING B" ).append("\n"); 
		query.append("             WHERE A.CGO_CLM_REF_BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("               -- Status by Container" ).append("\n"); 
		query.append("#if(${report_id} != '69') -- Status by Container" ).append("\n"); 
		query.append("               AND A.MN_CNTR_FLG = 'Y' --대표 컨테이너 번호" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append("          ,BKG_CONTAINER B" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("       AND A.CGO_CLM_REF_CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("     ) CNTR_DTL" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("       SELECT A.CGO_CLM_NO, A.HDLR_USR_ID " ).append("\n"); 
		query.append("        FROM CNI_CGO_CLM_HDLR_HIS A ," ).append("\n"); 
		query.append("             (SELECT CGO_CLM_NO, MAX(CGO_CLM_HDLR_HIS_SEQ) CGO_CLM_HDLR_HIS_SEQ FROM  CNI_CGO_CLM_HDLR_HIS WHERE MGR_HDLR_DIV_CD = 'M' GROUP BY CGO_CLM_NO) B" ).append("\n"); 
		query.append("       WHERE A.CGO_CLM_NO = B.CGO_CLM_NO" ).append("\n"); 
		query.append("         AND A.MGR_HDLR_DIV_CD = 'M'" ).append("\n"); 
		query.append("         AND A.CGO_CLM_HDLR_HIS_SEQ = B.CGO_CLM_HDLR_HIS_SEQ" ).append("\n"); 
		query.append("     ) MGR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("      CLM_V.CRE_OFC_CD           = B.OFC_CD(+)" ).append("\n"); 
		query.append("  AND CLM_V.CLMT_CLM_PTY_NO      = PARTY1.CLM_PTY_NO(+)    " ).append("\n"); 
		query.append("  AND CLM_V.CLM_AGN_CLM_PTY_NO   = PARTY2.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("  AND CLM_V.DEFT_ATTY_CLM_PTY_NO = PARTY3.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("  AND CLM_V.INSUR_CLM_PTY_NO     = PARTY4.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("  AND CLM_V.SLV_CLM_PTY_NO       = PARTY5.CLM_PTY_NO(+)  " ).append("\n"); 
		query.append("  AND CLM_V.SVEY_CLM_PTY_NO      = PARTY6.CLM_PTY_NO(+) " ).append("\n"); 
		query.append("  AND CLM_V.LABL_CLM_PTY_NO      = PARTY7.CLM_PTY_NO(+) " ).append("\n"); 
		query.append("  AND CLM_V.CGO_CLM_NO           = BL_DTL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("  AND CLM_V.CGO_CLM_NO           = CNTR_DTL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("  AND CLM_V.CGO_CLM_NO           = MGR.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.UPD_DT BETWEEN TO_DATE(@[from_period],'YYYYMMDD') AND TO_DATE(@[to_period] || '235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.INCI_OCCR_DT BETWEEN @[from_period]  AND @[to_period]  -- 나중확인" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.SVEY_INP_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.PRLM_CLM_NTC_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CLM_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.LABL_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.FMAL_CLM_RCV_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.FACT_FND_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.SMNS_SVE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_STL_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.LABL_PTY_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.INSUR_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.RCT_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.LODG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.DCHG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.DE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CS_CLZ_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${area} != 'All' && ${area} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CLM_AREA_CD = @[area] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${status} == 'O')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_CLZ_CD = 'O' " ).append("\n"); 
		query.append("  #elseif(${status} != 'All' && ${status} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_STS_CD = @[status] " ).append("\n"); 
		query.append("  #elseif(${status} == 'All')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_STS_CD <> 'X'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${vt} != 'All' && ${vt} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_DIV_CD = @[vt] " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${hdlr_ofc_cd} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.HDLR_OFC_CD = @[hdlr_ofc_cd] -- HOFC" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if(${hdlr_usr_id} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.HDLR_USR_ID = @[hdlr_usr_id] -- Handler" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${mgr_usr_id} != '')  " ).append("\n"); 
		query.append("      AND MGR.HDLR_USR_ID = @[mgr_usr_id] -- Manager" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if(${hndl_ofc_cd} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.HNDL_OFC_CD = @[hndl_ofc_cd] -- LP HOFC" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${labl_clm_pty_no} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.LABL_CLM_PTY_NO = @[labl_clm_pty_no] -- Liable Party" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${svey_clm_pty_no} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.SVEY_CLM_PTY_NO = @[svey_clm_pty_no] -- Surveyor" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if(${fmal_clm_rcv_ofc_cd} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.FMAL_CLM_RCV_OFC_CD = @[fmal_clm_rcv_ofc_cd] -- ROFC" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if(${clmt_clm_pty_no} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.CLMT_CLM_PTY_NO = @[clmt_clm_pty_no] -- Claimant" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${clmt_clm_agn_pty_no} != '') " ).append("\n"); 
		query.append("      AND CLM_V.CLM_AGN_CLM_PTY_NO = @[clmt_clm_agn_pty_no] -- Agent" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${slv_clm_pty_no} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.SLV_CLM_PTY_NO = @[slv_clm_pty_no] -- Salvager" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${insur_clm_pty_no} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.INSUR_CLM_PTY_NO = @[insur_clm_pty_no] -- Insurer" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${clm_stl_auth_usr_id} != '')  " ).append("\n"); 
		query.append("      AND CLM_V.CLM_STL_AUTH_USR_ID = @[clm_stl_auth_usr_id] -- Approver " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${trnk_ref_vvd_no} != '') " ).append("\n"); 
		query.append("      AND CLM_V.TRNK_REF_VVD_NO LIKE @[trnk_ref_vvd_no]||'%' -- VVD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${por_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.POR_CD = @[por_cd]  -- POR" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${pol_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.POL_CD = @[pol_cd]  -- POL" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${pod_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.POD_CD = @[pod_cd] -- POD" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if(${del_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.DEL_CD = @[del_cd] -- DEL" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  #if(${fvd} != '') " ).append("\n"); 
		query.append("      AND CLM_V.N1ST_PRE_REF_VVD_NO = @[fvd]  -- FVD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${n1st_pre_ts_loc_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.N1ST_PRE_TS_LOC_CD = @[n1st_pre_ts_loc_cd] -- PRE_POT" ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("  #if(${n1st_pst_ts_loc_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.N1ST_PST_TS_LOC_CD = @[n1st_pst_ts_loc_cd]  -- POS_POT" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${crr_term_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CRR_TERM_CD = @[crr_term_cd] -- CT" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${inci_plc_tp_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.INCI_PLC_TP_CD = @[inci_plc_tp_cd] --POI " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${slan_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.SLAN_CD = @[slan_cd]  -- Lane" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${clm_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CLM_CGO_TP_CD = @[clm_cgo_tp_cd]  --Cargo" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${cgo_clm_tp_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_TP_CD = @[cgo_clm_tp_cd]  -- TOC" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${mjr_clm_dmg_lss_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.MJR_CLM_DMG_LSS_CD = @[mjr_clm_dmg_lss_cd]  --CODL1" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${minr_clm_dmg_lss_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.MINR_CLM_DMG_LSS_CD = @[minr_clm_dmg_lss_cd] --CODL2" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${lit} == 'Y')" ).append("\n"); 
		query.append("      AND CLM_V.SMNS_SVE_DT IS NOT NULL  -- Litigation" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${cgo_clm_stl_tp_cd} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_STL_TP_CD = @[cgo_clm_stl_tp_cd]  -- TOS" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${from_clmt_usd_amt} != '' &&  ${to_clmt_usd_amt} !='')" ).append("\n"); 
		query.append("      AND CLM_V.CLMT_USD_AMT BETWEEN @[from_clmt_usd_amt] AND @[to_clmt_usd_amt] -- Claim Amount" ).append("\n"); 
		query.append("  #elseif(${from_clmt_usd_amt} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CLMT_USD_AMT >= @[from_clmt_usd_amt] -- Claim Amount" ).append("\n"); 
		query.append("  #elseif(${to_clmt_usd_amt} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CLMT_USD_AMT < @[to_clmt_usd_amt] -- Claim Amount" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${from_cgo_clm_stl_usd_amt} != '' &&  ${to_cgo_clm_stl_usd_amt} !='')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_STL_USD_AMT BETWEEN @[from_cgo_clm_stl_usd_amt]  AND @[to_cgo_clm_stl_usd_amt]   -- Settled Amount" ).append("\n"); 
		query.append("  #elseif(${from_cgo_clm_stl_usd_amt} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_STL_USD_AMT >= @[from_cgo_clm_stl_usd_amt] -- Settled Amount" ).append("\n"); 
		query.append("  #elseif(${to_cgo_clm_stl_usd_amt} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_STL_USD_AMT < @[to_cgo_clm_stl_usd_amt] -- Settled Amount" ).append("\n"); 
		query.append("  #end   " ).append("\n"); 
		query.append("  #if(${cgo_clm_inci_no} != '')" ).append("\n"); 
		query.append("      AND CLM_V.CGO_CLM_INCI_NO = @[cgo_clm_inci_no]  -- INC No." ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${start_page} != '') " ).append("\n"); 
		query.append("  WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}