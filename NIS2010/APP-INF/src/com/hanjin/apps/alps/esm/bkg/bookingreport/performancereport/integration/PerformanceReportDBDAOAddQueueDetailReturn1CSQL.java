/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOAddQueueDetailReturn1CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOAddQueueDetailReturn1CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03 김기종 [CHM-201109394-01] DPCS고도화일환으로  말레이지아 LOCAL TIME 변경
	  * </pre>
	  */
	public PerformanceReportDBDAOAddQueueDetailReturn1CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_bl_info_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_frt_chg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_rly_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_cust_info_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_to_usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_split_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_hbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_new_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_verif_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_cpy_to_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("message",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_cntr_mf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_subj_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_st_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_bkg_mn_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddQueueDetailReturn1CSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SR_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SR_KND_CD," ).append("\n"); 
		query.append("    SR_NO," ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    SR_HIS_SEQ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SR_STS_CD," ).append("\n"); 
		query.append("    SR_PROC_STS_CD," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ATND_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("    ST_DT," ).append("\n"); 
		query.append("    SR_PROC_UPD_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FNT_OFC_RTN_CD," ).append("\n"); 
		query.append("    DIFF_RMK," ).append("\n"); 
		query.append("    SR_RTN_TO_STS_CD," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    RTN_TO_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("    RTN_TO_RTN_STS_CD," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    RTN_TO_RTN_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("    RTN_DT," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    RSN_BKG_MN_FLG,    /*BKG Main*/" ).append("\n"); 
		query.append("    RSN_CUST_INFO_FLG, /*Customer INFO*/" ).append("\n"); 
		query.append("    RSN_FRT_CHG_FLG,   /*FRT & Charge*/" ).append("\n"); 
		query.append("    RSN_CNTR_FLG,      /*Container*/" ).append("\n"); 
		query.append("    RSN_CNTR_MF_FLG,   /*Container Manifest*/" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    RSN_DCGO_FLG,      /*Danger*/" ).append("\n"); 
		query.append("    RSN_AWK_CGO_FLG,   /*Awkward*/" ).append("\n"); 
		query.append("    RSN_RC_FLG,        /*Reefer*/" ).append("\n"); 
		query.append("    RSN_BB_CGO_FLG,    /*B/Bulk*/" ).append("\n"); 
		query.append("    RSN_RLY_PORT_FLG,  /*RLY VVD & Port*/" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    RSN_NEW_BKG_FLG,   /*New BKG*/" ).append("\n"); 
		query.append("    RSN_SPLIT_FLG,     /*BKG Split*/" ).append("\n"); 
		query.append("    RSN_BL_INFO_FLG,   /*BL Inform*/" ).append("\n"); 
		query.append("    RSN_HBL_FLG,       /*NVO House BL*/" ).append("\n"); 
		query.append("    RSN_MK_DESC_FLG,   /*Customer Verification*/" ).append("\n"); 
		query.append("    RTN_TO_USR_EML," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    CRE_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    EML_SUBJ_CTNT," ).append("\n"); 
		query.append("    EML_CPY_TO_CUST_FLG," ).append("\n"); 
		query.append("    SR_PROC_HRS," ).append("\n"); 
		query.append("    BL_DOC_WRK_HRS," ).append("\n"); 
		query.append("    BL_DOC_OVT_HRS," ).append("\n"); 
		query.append("    HOL_FLG" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT SUBSTR(@[src_cd],1,1) SR_KND_CD" ).append("\n"); 
		query.append("     , @[sr_no] SR_NO" ).append("\n"); 
		query.append("     , @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("     , NVL(SR_HIS_SEQ+1,0) SR_HIS_SEQ" ).append("\n"); 
		query.append("     , 'RR'" ).append("\n"); 
		query.append("     , 'R' /* 상수 */" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append("     , AST_DT" ).append("\n"); 
		query.append("     , DECODE(@[ui_grp_cd], 'I', 'I', 'R', 'R', 'S', 'S','C','C', @[ui_grp_cd]) /* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("     ,@[message]" ).append("\n"); 
		query.append("     , DECODE(@[ui_grp_cd], 'I', 'I', 'R', 'R', 'S', 'S','C','C', @[ui_grp_cd]) /* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     #if (${ui_grp_cd} == 'I') " ).append("\n"); 
		query.append("	 , BL_DOC_INP_USR_ID" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'R') " ).append("\n"); 
		query.append("	 , BL_RT_USR_ID" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'S') " ).append("\n"); 
		query.append("     , FNT_OFC_CD " ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'P') " ).append("\n"); 
		query.append("     , (SELECT M.OFC_CD FROM MDM_SLS_REP M,BKG_BOOKING BK WHERE BK.OB_SREP_CD = M.SREP_CD AND BK.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'C') 	 " ).append("\n"); 
		query.append("     , 'Customer'" ).append("\n"); 
		query.append("	 #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(CRNT_RQST,6) AS RTN_TO_RTN_STS_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("     , NVL(@[rsn_bkg_mn_flg]    , 'N')  /*BKG Main*/            " ).append("\n"); 
		query.append("     , NVL(@[rsn_cust_info_flg] , 'N')  /*Customer INFO*/       " ).append("\n"); 
		query.append("     , NVL(@[rsn_frt_chg_flg]   , 'N')  /*FRT & Charge*/        " ).append("\n"); 
		query.append("     , NVL(@[rsn_cntr_flg]      , 'N')  /*Container*/           " ).append("\n"); 
		query.append("     , NVL(@[rsn_cntr_mf_flg]   , 'N')  /*Container Manifest*/  " ).append("\n"); 
		query.append("																														 " ).append("\n"); 
		query.append("     , NVL(@[rsn_dcgo_flg]      , 'N')  /*Danger*/              " ).append("\n"); 
		query.append("     , NVL(@[rsn_awk_cgo_flg]   , 'N')  /*Awkward*/             " ).append("\n"); 
		query.append("     , NVL(@[rsn_rc_flg]        , 'N')  /*Reefer*/              " ).append("\n"); 
		query.append("     , NVL(@[rsn_bb_cgo_flg]    , 'N')  /*B/Bulk*/              " ).append("\n"); 
		query.append("     , NVL(@[rsn_rly_port_flg]  , 'N')  /*RLY VVD & Port*/      " ).append("\n"); 
		query.append("																														 " ).append("\n"); 
		query.append("     , NVL(@[rsn_new_bkg_flg]   , 'N')  /*New BKG*/             " ).append("\n"); 
		query.append("     , NVL(@[rsn_split_flg]     , 'N')  /*BKG Split*/           " ).append("\n"); 
		query.append("     , NVL(@[rsn_bl_info_flg]   , 'N')  /*BL Inform*/           " ).append("\n"); 
		query.append("     , NVL(@[rsn_hbl_flg]       , 'N')  /*NVO House BL*/        " ).append("\n"); 
		query.append("     , NVL(@[cust_verif_flg]    , 'N')  /*Customer Verification*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , @[rtn_to_usr_eml]" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[eml_subj_ctnt]" ).append("\n"); 
		query.append("     , @[eml_cpy_to_cust_flg]" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') - TO_DATE(BKG_GET_TOKEN_FNC(CRNT_RQST,7),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("    -- , BKG_GET_TOKEN_FNC(CRNT_RQST,1) AS SR_CRNT_STS_CD" ).append("\n"); 
		query.append("     --, BKG_GET_TOKEN_FNC(CRNT_RQST,2) AS SR_CRNT_INFO_CD     " ).append("\n"); 
		query.append("     --, BKG_GET_TOKEN_FNC(CRNT_RQST,5) AS RTN_FM_USR_ID   " ).append("\n"); 
		query.append("     , BIZ_ELT" ).append("\n"); 
		query.append("     , OVT" ).append("\n"); 
		query.append("     , HOL_FLG  " ).append("\n"); 
		query.append("FROM (  SELECT " ).append("\n"); 
		query.append("                (SELECT " ).append("\n"); 
		query.append("                     SR_CRNT_STS_CD    ||','||" ).append("\n"); 
		query.append("                     SR_CRNT_INFO_CD   ||','||" ).append("\n"); 
		query.append("                     RTN_TO_USR_ID     ||','||" ).append("\n"); 
		query.append("                     RTN_TO_RTN_USR_ID ||','||" ).append("\n"); 
		query.append("                     RTN_FM_USR_ID     ||','||" ).append("\n"); 
		query.append("                     RTN_TO_RTN_STS_CD ||','||" ).append("\n"); 
		query.append("					 TO_CHAR(DPCS_DOC_FM_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                 FROM BKG_SR_CRNT_RQST X" ).append("\n"); 
		query.append("               WHERE SR_KND_CD = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("  				 AND  SR_NO    = @[sr_no]" ).append("\n"); 
		query.append("				 AND  BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("				 AND SR_AMD_TP_CD = @[sr_knd_cd]/* 0421의 SR_KND_CD*/" ).append("\n"); 
		query.append("                 AND SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ) " ).append("\n"); 
		query.append("                                      FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                                     WHERE SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("                                       AND SR_NO = X.SR_NO" ).append("\n"); 
		query.append("                                       AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                                       AND SR_AMD_TP_CD = X.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                 ) CRNT_RQST" ).append("\n"); 
		query.append("            , (SELECT	MAX(SR_HIS_SEQ)" ).append("\n"); 
		query.append("                FROM BKG_SR_HIS" ).append("\n"); 
		query.append("                WHERE SR_KND_CD = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("  				  AND  SR_NO    = @[sr_no]" ).append("\n"); 
		query.append("				  AND  BKG_NO   = @[bkg_no]                " ).append("\n"); 
		query.append("               ) SR_HIS_SEQ	" ).append("\n"); 
		query.append("            , AST_DT" ).append("\n"); 
		query.append("            , BIZ_ELT" ).append("\n"); 
		query.append("            , OVT" ).append("\n"); 
		query.append("            , HOL_FLG	" ).append("\n"); 
		query.append("            , BL_DOC_INP_USR_ID" ).append("\n"); 
		query.append("            , BL_RT_USR_ID" ).append("\n"); 
		query.append("            , FNT_OFC_CD	" ).append("\n"); 
		query.append("        FROM BKG_SR_CRNT_RQST X, " ).append("\n"); 
		query.append("            (SELECT  AST_DT, AEND_DT, " ).append("\n"); 
		query.append("                     SUM(CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                              WHEN T.AEND_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AEND_DT" ).append("\n"); 
		query.append("                              WHEN T.ST_TO_DT < T.AEND_DT THEN T.ST_TO_DT" ).append("\n"); 
		query.append("                              WHEN T.AEND_DT < T.ST_FM_DT THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                              ELSE T.ST_TO_DT + 1" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                     -" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                              WHEN T.AST_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AST_DT " ).append("\n"); 
		query.append("                              WHEN T.ST_FM_DT > T.AST_DT THEN T.ST_FM_DT " ).append("\n"); 
		query.append("                              WHEN T.AST_DT > T.ST_TO_DT THEN T.ST_TO_DT " ).append("\n"); 
		query.append("                              ELSE T.ST_FM_DT -1" ).append("\n"); 
		query.append("                              END) BIZ_ELT,     " ).append("\n"); 
		query.append("                     T.AEND_DT - T.AST_DT -" ).append("\n"); 
		query.append("                     SUM(CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                              WHEN T.AEND_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AEND_DT" ).append("\n"); 
		query.append("                              WHEN T.ST_TO_DT < T.AEND_DT THEN T.ST_TO_DT" ).append("\n"); 
		query.append("                              WHEN T.AEND_DT < T.ST_FM_DT THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                              ELSE T.ST_TO_DT + 1" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                     -" ).append("\n"); 
		query.append("                         CASE WHEN TO_CHAR(T.ST_FM_DT,'D') IN (1,7) OR T.HOL_FLG = 'Y' THEN T.ST_FM_DT" ).append("\n"); 
		query.append("                              WHEN T.AST_DT BETWEEN T.ST_FM_DT AND T.ST_TO_DT THEN T.AST_DT " ).append("\n"); 
		query.append("                              WHEN T.ST_FM_DT > T.AST_DT THEN T.ST_FM_DT " ).append("\n"); 
		query.append("                              WHEN T.AST_DT > T.ST_TO_DT THEN T.ST_TO_DT " ).append("\n"); 
		query.append("                              ELSE T.ST_FM_DT -1" ).append("\n"); 
		query.append("                         END) OVT," ).append("\n"); 
		query.append("                     MAX(T.HOL_FLG) HOL_FLG" ).append("\n"); 
		query.append("               FROM (SELECT AST_DT, AEND_DT, " ).append("\n"); 
		query.append("                            ST_FM_DT, ST_TO_DT," ).append("\n"); 
		query.append("							(SELECT DECODE(COUNT(DISTINCT HOL_DT),0,'N','Y')" ).append("\n"); 
		query.append("			                   FROM DMT_HOLIDAY H, MDM_ORGANIZATION O,MDM_LOCATION L" ).append("\n"); 
		query.append("				              WHERE O.OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                                AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("								AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("				                AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("                				AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("			                    AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append("                                AND HOL_DT BETWEEN TRUNC(ST_FM_DT) AND TRUNC(ST_TO_DT)) HOL_FLG" ).append("\n"); 
		query.append("                     FROM (SELECT T.AST_DT, T.AEND_DT," ).append("\n"); 
		query.append("                                  --SIGN(X.DPCS_DOC_FM_DT-TRUNC(X.DPCS_DOC_FM_DT)-0.5) 오전 : -1, 오후 : 1이 리턴" ).append("\n"); 
		query.append("                                  --Overnigt인 경우만 Working time이 오전인 경우 하루 전으로 계산함" ).append("\n"); 
		query.append("                                  TO_DATE(TO_CHAR(T.AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                    - DECODE(T.AST_DT,'Y',DECODE(SIGN(T.AST_DT- TO_DATE(TO_CHAR(T.AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                    + CNT -1 ST_FM_DT," ).append("\n"); 
		query.append("                                  TO_DATE(TO_CHAR(T.AST_DT+DECODE(W.DOC_WRK_OVN_FLG,'Y',1,0),'YYYYMMDD')||W.DOC_WRK_END_HRMNT,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                    - DECODE(W.DOC_WRK_OVN_FLG,'Y',DECODE(SIGN(T.AST_DT- TO_DATE(TO_CHAR(T.AST_DT,'YYYYMMDD')||W.DOC_WRK_ST_HRMNT,'YYYYMMDDHH24MI')),-1,1,0),0) " ).append("\n"); 
		query.append("                                    + CNT -1 ST_TO_DT" ).append("\n"); 
		query.append("                      FROM BKG_DPCS_OFC_WRK_TM W, " ).append("\n"); 
		query.append("                            (SELECT TO_DATE(@[wrk_st_tm],'YYYYMMDD HH24:MI:SS') AST_DT, " ).append("\n"); 
		query.append("                                    GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') AEND_DT " ).append("\n"); 
		query.append("                             FROM DUAL) T," ).append("\n"); 
		query.append("                            (SELECT ROWNUM CNT FROM DICT) C" ).append("\n"); 
		query.append("                      WHERE W.BKG_OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                      AND C.CNT < T.AEND_DT - T.AST_DT + 3)) T" ).append("\n"); 
		query.append("               WHERE TRUNC(T.AEND_DT) >= TRUNC(T.ST_FM_DT) -- 필요할까?" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("               GROUP BY T.AST_DT, T.AEND_DT" ).append("\n"); 
		query.append("               ) T	" ).append("\n"); 
		query.append("               WHERE SR_KND_CD   = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("               AND SR_NO        = @[sr_no]    " ).append("\n"); 
		query.append("               AND BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("               AND SR_AMD_TP_CD = @[sr_knd_cd]/* 0421의 SR_KND_CD*/ " ).append("\n"); 
		query.append("               AND SR_AMD_SEQ = (SELECT NVL(MAX(SR_AMD_SEQ),0)" ).append("\n"); 
		query.append("                                  FROM  BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                                  WHERE SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("                                  AND SR_AMD_TP_CD = X.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                                  AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                                  AND SR_NO = X.SR_NO)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}