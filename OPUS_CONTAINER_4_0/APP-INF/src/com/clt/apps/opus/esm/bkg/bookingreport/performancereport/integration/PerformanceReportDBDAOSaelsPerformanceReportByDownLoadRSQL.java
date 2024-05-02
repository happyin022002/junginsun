/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSaelsPerformanceReportByDownLoadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSaelsPerformanceReportByDownLoadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SaelsPerformanceReport(ESM_BKG_0632)
	  * Data Download
	  * </pre>
	  */
	public PerformanceReportDBDAOSaelsPerformanceReportByDownLoadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ib_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_inlnd_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuntract_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSaelsPerformanceReportByDownLoadRSQL").append("\n"); 
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
		query.append("WITH  MAIN_TEMP  AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT /* ORDERED */" ).append("\n"); 
		query.append("          BKG.BKG_NO BKG_NO" ).append("\n"); 
		query.append("         ,BKG.Bl_No BL_NO" ).append("\n"); 
		query.append("         ,BKG.SLAN_CD" ).append("\n"); 
		query.append("         ,MON.SLS_YRMON SLS_YRMON" ).append("\n"); 
		query.append("         ,MON.COST_WK SLS_WK" ).append("\n"); 
		query.append("         ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("         ,BKG.POR_CD" ).append("\n"); 
		query.append("         ,BKG.POL_CD" ).append("\n"); 
		query.append("         ,BKG.POD_CD" ).append("\n"); 
		query.append("         ,BKG.DEL_CD" ).append("\n"); 
		query.append("         ,REV.IOC_CD IO" ).append("\n"); 
		query.append("         ,SUBSTR(REPLACE(TRANSLATE(NVL(CUSTOMER.CUST_LGL_ENG_NM, ' '),CHR(10), ' '), CHR(34), ' '), 1, 30) CUST_NM" ).append("\n"); 
		query.append("         ,NVL(S.CUST_CNT_CD||TO_CHAR(S.CUST_SEQ), 0) CUST_CNT_CD" ).append("\n"); 
		query.append("         ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("         ,BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("         ,BKG.BKG_CGO_TP_cd" ).append("\n"); 
		query.append("         ,BKG.DOC_USR_ID" ).append("\n"); 
		query.append("         ,BKG_RATE.FRT_TERM_CD" ).append("\n"); 
		query.append("         ,BKG_VVD.VSL_CD||BKG_VVD.SKD_VOY_NO||BKG_VVD.SKD_DIR_CD first_VVD" ).append("\n"); 
		query.append("         ,TO_CHAR(BKG_BL_DOC.BL_OBRD_DT, 'YYYYMMDD') BL_OBRD_DT" ).append("\n"); 
		query.append("         ,TO_CHAR(BKG_BL_DOC.BL_OBRD_DT, 'IW') BL_OBRD_WK" ).append("\n"); 
		query.append("         ,BKG.REP_CMDT_CD" ).append("\n"); 
		query.append("         ,SUBSTR(REP.REP_CMDT_NM, 1, 20) REP_CMDT_NM" ).append("\n"); 
		query.append("         ,SUBSTR(BKG.DEL_CD,1,2) IBS_OFC_NT" ).append("\n"); 
		query.append("         ,BKG.IB_SLS_OFC_CD" ).append("\n"); 
		query.append("         ,ORG_TRNS_SVC_MOD_CD ORG_SVC" ).append("\n"); 
		query.append("         ,DEST_TRNS_SVC_MOD_CD DST_SVC" ).append("\n"); 
		query.append("         ,DECODE(BKG.CUST_TO_ORD_FLG, 'Y', N1.CUST_SEQ, C1.CUST_SEQ) CNNF_CD" ).append("\n"); 
		query.append("         ,SUBSTR(REPLACE(TRANSLATE(NVL(DECODE(BKG.CUST_TO_ORD_FLG, 'Y', N1.CUST_NM, C1.CUST_NM), ' '),CHR(10), ' '), CHR(34), ' '), 1, 30) CNNF_NM" ).append("\n"); 
		query.append("         ,BKG.AGMT_ACT_CNT_CD||BKG.AGMT_ACT_CUST_SEQ REP_CUST_CD" ).append("\n"); 
		query.append("         ,PTS.CUST_LGL_ENG_NM REP_ACCT_NM" ).append("\n"); 
		query.append("         ,BKG.CTRT_OFC_CD" ).append("\n"); 
		query.append("         ,BKG.CTRT_SREP_CD" ).append("\n"); 
		query.append("         ,OFC_N3RD_LVL_CD RHQ" ).append("\n"); 
		query.append("         ,OFC_N4TH_LVL_CD GSO" ).append("\n"); 
		query.append("         ,BKG.REV_DIR_CD" ).append("\n"); 
		query.append("         ,BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("         ,NVL(BKG.PST_RLY_PORT_CD,BKG.POD_CD) IB_WK_POD_CD" ).append("\n"); 
		query.append("         ,BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("         ,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("         ,BKG.SC_NO" ).append("\n"); 
		query.append("         ,BKG.RFA_NO" ).append("\n"); 
		query.append("         ,(  SELECT TO_CHAR(MIN(SKD.VPS_ETA_DT),'YYYYMMIW')" ).append("\n"); 
		query.append("             FROM   VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("             WHERE  SKD.VSL_CD = BKG.VSL_CD" ).append("\n"); 
		query.append("             AND    SKD.SKD_VOY_NO = BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND    SKD.SKD_DIR_CD = BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("          ) IB_WK" ).append("\n"); 
		query.append("   FROM   BKG_BOOKING BKG" ).append("\n"); 
		query.append("         ,BKG_BL_DOC BKG_BL_DOC" ).append("\n"); 
		query.append("         ,BKG_RATE BKG_RATE" ).append("\n"); 
		query.append("         ,BKG_CUSTOMER S" ).append("\n"); 
		query.append("         ,BKG_CUSTOMER C1" ).append("\n"); 
		query.append("         ,BKG_CUSTOMER N1" ).append("\n"); 
		query.append("         ,BKG_VVD" ).append("\n"); 
		query.append("         ,MDM_CUSTOMER CUSTOMER" ).append("\n"); 
		query.append("         ,MDM_CUSTOMER PTS" ).append("\n"); 
		query.append("         ,COA_MON_VVD mon" ).append("\n"); 
		query.append("         ,COA_RGST_BKG REV" ).append("\n"); 
		query.append("         ,MDM_REP_CMDT rep" ).append("\n"); 
		query.append("         ,BKG_OFC_LVL_V OFCV" ).append("\n"); 
		query.append("   WHERE  1 = 1" ).append("\n"); 
		query.append("   AND    MON.TRD_CD = REV.TRD_CD" ).append("\n"); 
		query.append("   AND    MON.RLANE_CD =REV.RLANE_CD" ).append("\n"); 
		query.append("   AND    MON.IOC_CD =REV.IOC_CD" ).append("\n"); 
		query.append("   AND    MON.VSL_CD =REV.VSL_CD" ).append("\n"); 
		query.append("   AND    MON.SKD_VOY_NO =REV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND    MON.DIR_CD =REV.DIR_CD" ).append("\n"); 
		query.append("   --AND    MON.WKY_TGT_FLG ='Y'" ).append("\n"); 
		query.append("   AND    BKG.BKG_NO = REV.BKG_NO" ).append("\n"); 
		query.append("   AND    BKG.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("   AND    S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND    S.CUST_CNT_CD = CUSTOMER.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND    S.CUST_SEQ = CUSTOMER.CUST_SEQ" ).append("\n"); 
		query.append("   AND    BKG.BKG_NO = BKG_RATE.BKG_NO" ).append("\n"); 
		query.append("   AND    BKG.BKG_NO = BKG_BL_DOC.BKG_NO" ).append("\n"); 
		query.append("   AND    BKG.BKG_NO = BKG_VVD.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    BKG.BKG_NO = C1.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    C1.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND    BKG.BKG_NO = N1.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    N1.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND    BKG_VVD.VSL_PRE_PST_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND    BKG_VVD.VSL_SEQ(+) = '1' " ).append("\n"); 
		query.append("   AND    BKG.AGMT_ACT_CNT_CD = PTS.cust_cnt_cd(+)" ).append("\n"); 
		query.append("   AND    BKG.AGMT_ACT_CUST_SEQ = PTS.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND    NVL(PTS.NMD_CUST_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("   AND    NVL(BKG.BL_NO_TP, 'M') IN ('0', 'M')" ).append("\n"); 
		query.append("   AND    BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND    BKG.REP_CMDT_CD = rep.REP_CMDT_CD" ).append("\n"); 
		query.append("   AND    BKG.BKG_CGO_TP_CD IN ('F','B','R')" ).append("\n"); 
		query.append("   AND    OFCV.OFC_CD =BKG.OB_SLS_OFC_CD " ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("           ${vvd}" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '' && ${bkg_cgo_tp_cd} != 'A')" ).append("\n"); 
		query.append("   AND    BKG.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} == 'C') " ).append("\n"); 
		query.append("   AND    C1.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')  " ).append("\n"); 
		query.append("   AND    C1.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')  " ).append("\n"); 
		query.append("   AND    C1.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '')" ).append("\n"); 
		query.append("   AND    C1.CUST_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'S') " ).append("\n"); 
		query.append("   AND    S.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')  " ).append("\n"); 
		query.append("   AND    S.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')  " ).append("\n"); 
		query.append("   AND    S.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '')" ).append("\n"); 
		query.append("   AND    S.CUST_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'N') " ).append("\n"); 
		query.append("   AND    N.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')  " ).append("\n"); 
		query.append("   AND    N.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')  " ).append("\n"); 
		query.append("   AND    N.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_nm} != '')" ).append("\n"); 
		query.append("   AND    N.CUST_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cuntract_tp} == 'A' && ${cuntract_no} != '')" ).append("\n"); 
		query.append("   AND    BKG.SC_NO = @[cuntract_no]" ).append("\n"); 
		query.append("#elseif (${cuntract_tp} == 'B' && ${cuntract_no} != '')" ).append("\n"); 
		query.append("   AND    BKG.RFA_NO = @[cuntract_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.REP_CMDT_CD = @[rep_cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dcgo_flg} != '')" ).append("\n"); 
		query.append("   AND    BKG.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rc_flg} != '')" ).append("\n"); 
		query.append("   AND    BKG.RC_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} != '')" ).append("\n"); 
		query.append("   AND    BKG.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bb_cgo_flg} != '')" ).append("\n"); 
		query.append("   AND    BKG.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("   AND    BKG.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${load_view} == '0')" ).append("\n"); 
		query.append("   AND    NVL(BKG.BL_NO_TP, 'M') IN ('0','M')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '' && ${bkg_ofc_sub} == '')" ).append("\n"); 
		query.append("   AND    BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${bkg_ofc_cd} != '' && ${bkg_ofc_sub} != '')" ).append("\n"); 
		query.append("   AND    BKG.BKG_OFC_CD IN (  SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                               FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                               WHERE  @[bkg_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                           OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '' && ${ob_sls_ofc_sub} == '')" ).append("\n"); 
		query.append("   AND    BKG.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ob_sls_ofc_cd} != '' && ${ob_sls_ofc_sub} != '')" ).append("\n"); 
		query.append("   AND    BKG.OB_SLS_OFC_CD IN (  SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                                  FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                  WHERE  @[ob_sls_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                                 OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_srep_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.CTRT_SREP_CD = @[ctrt_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ib_sls_ofc_cd} != '' && ${ib_sls_ofc_sub} == '')" ).append("\n"); 
		query.append("   AND    BKG.IB_SLS_OFC_CD = @[ib_sls_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${ib_sls_ofc_cd} != '' && ${ib_sls_ofc_sub} != '')" ).append("\n"); 
		query.append("   AND    BKG.IB_SLS_OFC_CD IN (  SELECT OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("                                  FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                  WHERE  @[ib_sls_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                                 OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_rout_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.ORG_SCONTI_CD = @[org_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_rout_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.DEST_SCONTI_CD = @[dest_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_svc_mod_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.ORG_TRNS_SVC_MOD_CD = @[org_svc_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_inlnd_svc_mod_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG.DEST_TRNS_SVC_MOD_CD = @[dest_inlnd_svc_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_cnt} != '')" ).append("\n"); 
		query.append("   AND    SUBSTR(BKG.POL_CD,0,2) = @[org_cnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_cnt} != '')" ).append("\n"); 
		query.append("   AND    SUBSTR(BKG.DEL_CD,0,2) = @[dest_cnt]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${frt_term_cd} != '')" ).append("\n"); 
		query.append("   AND    BKG_RATE.FRT_TERM_CD = @[frt_term_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${ioc_cd} != '' && ${ioc_cd} == 'O')" ).append("\n"); 
		query.append("   AND    SUBSTR(BKG.ORG_SCONTI_CD,0,1) <> SUBSTR(BKG.DEST_SCONTI_CD,0,1)" ).append("\n"); 
		query.append("#elseif (${ioc_cd} != '' && ${ioc_cd} == 'I')" ).append("\n"); 
		query.append("   AND    SUBSTR(BKG.ORG_SCONTI_CD,0,1) = SUBSTR(BKG.DEST_SCONTI_CD,0,1)" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("   SELECT A.BKG_NO" ).append("\n"); 
		query.append("         ,A.BL_NO" ).append("\n"); 
		query.append("         ,A.SLAN_CD" ).append("\n"); 
		query.append("         ,A.SLS_YRMON" ).append("\n"); 
		query.append("         ,A.SLS_WK" ).append("\n"); 
		query.append("         ,A.VVD" ).append("\n"); 
		query.append("         ,A.POR_CD" ).append("\n"); 
		query.append("         ,A.POL_CD" ).append("\n"); 
		query.append("         ,A.POD_CD" ).append("\n"); 
		query.append("         ,A.DEL_CD" ).append("\n"); 
		query.append("         ,A.IO" ).append("\n"); 
		query.append("         ,(SELECT SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', QTY.OP_CNTR_QTY, '3', QTY.OP_CNTR_QTY, QTY.OP_CNTR_QTY * 2)) FROM BKG_QUANTITY QTY WHERE A.BKG_NO = QTY.BKG_NO) AS TEU_TTL" ).append("\n"); 
		query.append("         ,(B.CNTR_TP_SUM+Q2+(Q4*2)) CNTR_TTL" ).append("\n"); 
		query.append("         ,C.TOT_SUM" ).append("\n"); 
		query.append("         ,CASE WHEN NVL(C.TOT_SUM,0) !=0 AND (B.CNTR_TP_SUM+Q2+(Q4*2)) !=0 THEN NVL(C.TOT_SUM,0)/(B.CNTR_TP_SUM+Q2+(Q4*2)) ELSE 0 END RPB" ).append("\n"); 
		query.append("         ,A.CUST_NM" ).append("\n"); 
		query.append("         ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("         ,A.OB_SREP_CD" ).append("\n"); 
		query.append("         ,A.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("         ,A.BKG_CGO_TP_cd" ).append("\n"); 
		query.append("         ,B.D2" ).append("\n"); 
		query.append("         ,B.D4" ).append("\n"); 
		query.append("         ,B.D5" ).append("\n"); 
		query.append("         ,B.D7" ).append("\n"); 
		query.append("         ,B.R2" ).append("\n"); 
		query.append("         ,B.R4" ).append("\n"); 
		query.append("         ,B.R5" ).append("\n"); 
		query.append("         ,B.RD2" ).append("\n"); 
		query.append("         ,B.RD4" ).append("\n"); 
		query.append("         ,B.F2" ).append("\n"); 
		query.append("         ,B.F4" ).append("\n"); 
		query.append("         ,B.O2" ).append("\n"); 
		query.append("         ,B.O4" ).append("\n"); 
		query.append("         ,B.P2" ).append("\n"); 
		query.append("         ,B.P4" ).append("\n"); 
		query.append("         ,B.T2" ).append("\n"); 
		query.append("         ,B.T4" ).append("\n"); 
		query.append("         ,B.Q2" ).append("\n"); 
		query.append("         ,B.Q4" ).append("\n"); 
		query.append("         ,C.REV_D2 + (C.BOX * (B.D2 / B.CNTR_TP_SUM)) REV_D2" ).append("\n"); 
		query.append("         ,C.REV_D4 + (C.BOX * (B.D4 * 2 / B.CNTR_TP_SUM)) REV_D4" ).append("\n"); 
		query.append("         ,C.REV_D5 + (C.BOX * (B.D5 * 2 / B.CNTR_TP_SUM)) REV_D5" ).append("\n"); 
		query.append("         ,C.REV_D7 + (C.BOX * (B.D7 * 2 / B.CNTR_TP_SUM)) REV_D7" ).append("\n"); 
		query.append("         ,DECODE(B.R2,0,0,C.REV_R2 + (C.BOX * (B.R2 / B.CNTR_TP_SUM))) REV_R2" ).append("\n"); 
		query.append("         ,DECODE(B.R4,0,0,C.REV_R4 + (C.BOX * (B.R4 * 2 / B.CNTR_TP_SUM))) REV_R4" ).append("\n"); 
		query.append("         ,DECODE(B.R5,0,0,C.REV_R5 + (C.BOX * (B.R5 * 2 / B.CNTR_TP_SUM))) REV_R5" ).append("\n"); 
		query.append("         ,DECODE(B.RD2,0,0,C.REV_R2) + (DECODE(B.RD2,0,0,C.BOX) * (B.RD2 / B.CNTR_TP_SUM)) REV_RD2" ).append("\n"); 
		query.append("         ,DECODE(b.RD4,0,0,C.REV_R4) + (DECODE(B.RD4,0,0,C.BOX) * (B.RD4 * 2 / B.CNTR_TP_SUM)) REV_RD4" ).append("\n"); 
		query.append("         ,C.REV_F2 + (C.BOX * (B.F2 / B.CNTR_TP_SUM)) REV_F2" ).append("\n"); 
		query.append("         ,C.REV_F4 + (C.BOX * (B.F4 * 2 / B.CNTR_TP_SUM)) REV_F4" ).append("\n"); 
		query.append("         ,C.REV_O2 + (C.BOX * (B.O2 / B.CNTR_TP_SUM)) REV_O2" ).append("\n"); 
		query.append("         ,C.REV_O4 + (C.BOX * (B.O4 * 2 / B.CNTR_TP_SUM)) REV_O4" ).append("\n"); 
		query.append("         ,C.REV_P2 + (C.BOX * (B.P2 / B.CNTR_TP_SUM)) REV_P2" ).append("\n"); 
		query.append("         ,C.REV_P4 + (C.BOX * (B.P4 * 2 / B.CNTR_TP_SUM)) REV_P4" ).append("\n"); 
		query.append("         ,C.REV_T2 + (C.BOX * (B.T2 / B.CNTR_TP_SUM))  REV_T2" ).append("\n"); 
		query.append("         ,C.REV_T4 + (C.BOX * (B.T4 * 2 / B.CNTR_TP_SUM)) REV_T4" ).append("\n"); 
		query.append("         ,C.REV_Q2" ).append("\n"); 
		query.append("         ,C.REV_Q4" ).append("\n"); 
		query.append("         ,C.BOX" ).append("\n"); 
		query.append("         ,C.OFT" ).append("\n"); 
		query.append("         ,C.BAF" ).append("\n"); 
		query.append("         ,C.CAF" ).append("\n"); 
		query.append("         ,C.OTH" ).append("\n"); 
		query.append("         ,C.DTH" ).append("\n"); 
		query.append("         ,C.DOC" ).append("\n"); 
		query.append("         ,C.TAC" ).append("\n"); 
		query.append("         ,C.TOT_SUM - (C.OFT + C.BAF + C.CAF + C.OTH + C.DTH + C.DOC + C.TAC) R_OTHER" ).append("\n"); 
		query.append("         ,A.FRT_TERM_CD" ).append("\n"); 
		query.append("         ,A.FIRST_VVD" ).append("\n"); 
		query.append("         ,A.BL_OBRD_DT" ).append("\n"); 
		query.append("         ,A.BL_OBRD_WK" ).append("\n"); 
		query.append("         ,A.REP_CMDT_CD" ).append("\n"); 
		query.append("         ,A.REP_CMDT_NM" ).append("\n"); 
		query.append("         ,A.IBS_OFC_NT" ).append("\n"); 
		query.append("         ,A.IB_SLS_OFC_CD" ).append("\n"); 
		query.append("         ,A.ORG_SVC" ).append("\n"); 
		query.append("         ,A.DST_SVC" ).append("\n"); 
		query.append("         ,A.CNNF_CD" ).append("\n"); 
		query.append("         ,A.CNNF_NM" ).append("\n"); 
		query.append("         ,A.REP_CUST_CD" ).append("\n"); 
		query.append("         ,A.REP_ACCT_NM" ).append("\n"); 
		query.append("         ,A.RHQ" ).append("\n"); 
		query.append("         ,A.GSO" ).append("\n"); 
		query.append("         ,A.REV_DIR_CD" ).append("\n"); 
		query.append("         ,A.RFA_NO" ).append("\n"); 
		query.append("         ,A.SC_NO" ).append("\n"); 
		query.append("         ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("         ,A.CTRT_SREP_CD" ).append("\n"); 
		query.append("         ,A.BKG_OFC_CD" ).append("\n"); 
		query.append("         ,A.IB_WK_POD_CD" ).append("\n"); 
		query.append("         ,A.IB_WK     " ).append("\n"); 
		query.append("   FROM   MAIN_TEMP A     " ).append("\n"); 
		query.append("         ,(" ).append("\n"); 
		query.append("             SELECT /*+ USE_NL(M C) */" ).append("\n"); 
		query.append("                    M.BKG_NO," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('D2','D3')                                          THEN CNTR_VOL_QTY END),0)  D2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('D4','D6','D8','D9','DX','DY','DW','DZ')            THEN CNTR_VOL_QTY END),0)  D4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'D5'                                                 THEN CNTR_VOL_QTY END),0)  D5," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'D7'                                                 THEN CNTR_VOL_QTY END),0)  D7," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R2','R3') AND RD_CGO_FLG = 'N'                     THEN CNTR_VOL_QTY END),0)  R2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R4','R6','R7','R8','R9') AND RD_CGO_FLG = 'N'      THEN CNTR_VOL_QTY END),0)  R4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD = 'R5' AND RD_CGO_FLG = 'N'                             THEN CNTR_VOL_QTY END),0)  R5," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R2','R3') AND RD_CGO_FLG = 'Y'                     THEN CNTR_VOL_QTY END),0)  RD2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R4','R5','R6','R7','R8','R9') AND RD_CGO_FLG = 'Y' THEN CNTR_VOL_QTY END),0)  RD4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('F2','A2')  AND RD_CGO_FLG = 'N'                    THEN CNTR_VOL_QTY END),0)  F2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('F4','A4','A5','F5')  AND RD_CGO_FLG = 'N'          THEN CNTR_VOL_QTY END),0)  F4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('O2','S2')  AND RD_CGO_FLG = 'N'                    THEN CNTR_VOL_QTY END),0)  O2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('O4','O5','S4','S5')  AND RD_CGO_FLG = 'N'          THEN CNTR_VOL_QTY END),0)  O4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'P2' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0)  P2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'P4' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0)  P4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'T2' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0)  T2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'T4' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0)  T4," ).append("\n"); 
		query.append("                    ----------------------------------------------" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('D2','D3')                                          THEN CNTR_VOL_QTY END),0)  +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('D4','D5','D6','D7','D8','D9','DX','DY','DW','DZ')  THEN CNTR_VOL_QTY END),0) * 2 +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R2','R3') AND RD_CGO_FLG = 'N'                     THEN CNTR_VOL_QTY END),0)  +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R4','R5','R6','R7','R8','R9') AND RD_CGO_FLG = 'N' THEN CNTR_VOL_QTY END),0) * 2 +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R2','R3') AND RD_CGO_FLG = 'Y'                     THEN CNTR_VOL_QTY END),0)  +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('R4','R5','R6','R7','R8','R9') AND RD_CGO_FLG = 'Y' THEN CNTR_VOL_QTY END),0) * 2 +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('F2','A2')  AND RD_CGO_FLG = 'N'                    THEN CNTR_VOL_QTY END),0)  +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('F4','A4','A5','F5')  AND RD_CGO_FLG = 'N'          THEN CNTR_VOL_QTY END),0) * 2 +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('O2','S2')  AND RD_CGO_FLG = 'N'                    THEN CNTR_VOL_QTY END),0)  +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD IN ('O4','O5','S4','S5')  AND RD_CGO_FLG = 'N'          THEN CNTR_VOL_QTY END),0) * 2 +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'P2' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0)  +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'P4' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0) * 2 +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'T2' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0)  +" ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CNTR_TPSZ_CD  = 'T4' AND  RD_CGO_FLG = 'N'                           THEN CNTR_VOL_QTY END),0) * 2  AS CNTR_TP_SUM," ).append("\n"); 
		query.append("                    ----------------------------------------------" ).append("\n"); 
		query.append("                    NVL((SELECT  SUM(OP_CNTR_QTY) FROM BKG_QUANTITY  WHERE CNTR_TPSZ_CD ='Q2' AND BKG_NO = M.BKG_NO ),0)     Q2," ).append("\n"); 
		query.append("                    NVL((SELECT  SUM(OP_CNTR_QTY) FROM BKG_QUANTITY  WHERE CNTR_TPSZ_CD IN ('Q4','Q5') AND BKG_NO = M.BKG_NO),0)  Q4" ).append("\n"); 
		query.append("                    -- SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',CNTR_VOL_QTY,CNTR_VOL_QTY*2)) AS  TEU_TTL" ).append("\n"); 
		query.append("             FROM   MAIN_TEMP M," ).append("\n"); 
		query.append("                    BKG_CONTAINER  C" ).append("\n"); 
		query.append("             WHERE  M.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("             GROUP BY M.BKG_NO" ).append("\n"); 
		query.append("          ) B," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("             SELECT /*+ USE_NL(M C AE CH) */" ).append("\n"); 
		query.append("                    M.BKG_NO," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('D2','D3')                                              THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_D2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('D4','D6','D8','D9','DX','DY','DW','DZ')                THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_D4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD  = 'D5'                                                     THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_D5," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD  = 'D7'                                                     THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_D7," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('R2','R3')                                              THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_R2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('R4','R6','R7','R8','R9','RX','RY','RW','RZ')           THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_R4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD  = 'R5'                                                     THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_R5," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('F2','F3','A2')                                         THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_F2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('F4','F5','F6','F7','F8','F9','FX','FY','FW','FZ','A4','A5')      THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_F4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('O2','S2')                                              THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_O2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('O4','S4','S5','S6','S7','S8','S9','SX','SY','SW','SZ') THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_O4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('P2','P3')                                              THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_P2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('P4','P5','P6','P7','P8','P9')                          THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_P4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('T2','T3')                                              THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_T2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD  = 'T4'                                                     THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_T4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD  = 'Q2'                                                     THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_Q2," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('Q4','Q5')                                              THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  REV_Q4," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN C.RAT_UT_CD IN ('20','40','45','4H','53','BD','BE','BG','BL','BM'," ).append("\n"); 
		query.append("                                                      'BX','CF','CM','CN','CT','FT', 'LB','MT','PC','PK'," ).append("\n"); 
		query.append("                                                      'PG','RO','RT','SD','ST','TN','TR','UN','Z2','Z4')" ).append("\n"); 
		query.append("                                                                                                              THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  BOX," ).append("\n"); 
		query.append("                    NVL(SUM(C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1)) ,0)                                                                                            TOT_SUM," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN REP_CHG_CD = 'OFT'                                                      THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  OFT," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN REP_CHG_CD = 'BAF'                                                      THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  BAF," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN REP_CHG_CD = 'CAF'                                                      THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  CAF," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CHG_APLY_AREA_CD||REP_CHG_CD = 'PCHC'                                   THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  OTH," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN CHG_APLY_AREA_CD||REP_CHG_CD = 'CCHC'                                   THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  DTH," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN REP_CHG_CD ='DOC'                                                       THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  DOC," ).append("\n"); 
		query.append("                    NVL(SUM(CASE WHEN REP_CHG_CD ='TAC'                                                       THEN C.CHG_AMT/NVL(A3.USD_LOCL_XCH_RT,1) END),0)  TAC" ).append("\n"); 
		query.append("             FROM   MAIN_TEMP      M," ).append("\n"); 
		query.append("                    BKG_CHG_RT     C," ).append("\n"); 
		query.append("                    GL_MON_XCH_RT  A3," ).append("\n"); 
		query.append("                    MDM_CHARGE     CH" ).append("\n"); 
		query.append("             WHERE  M.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("             AND    C.CHG_CD = CH.CHG_CD" ).append("\n"); 
		query.append("             AND    TO_CHAR(C.CRE_DT, 'YYYYMM') = A3.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("             AND    A3.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("             AND    C.CURR_CD = A3.CURR_CD" ).append("\n"); 
		query.append("             AND    C.DP_SEQ  = DECODE(C.CHG_CD, 'DIH', 430, C.DP_SEQ)   -- DIH의 경우 DP_SEQ = 430" ).append("\n"); 
		query.append("             AND    ( C.CHG_CD NOT IN('DOD', 'TVA')  OR C.DE_TERM_CD  <> 'H' OR C.PRN_HDN_FLG <> '1' OR NOT ( M.POD_CD = M.DEL_CD  AND  M.DE_TERM_CD IN ('Y', 'H') ) )" ).append("\n"); 
		query.append("             AND    C.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("             GROUP BY M.BKG_NO" ).append("\n"); 
		query.append("          )  C" ).append("\n"); 
		query.append("   WHERE  A.BKG_NO = B.BKG_NO (+)" ).append("\n"); 
		query.append("   AND    A.BKG_NO = C.BKG_NO (+)" ).append("\n"); 

	}
}