/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOAddQueueDetailReturn1CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
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

public class PerformanceReportDBDAOAddQueueDetailReturn1CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOAddQueueDetailReturn1CSQL
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
		params.put("message",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rsn_awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rsn_split_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_bkg_mn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsn_bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
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
		query.append("    " ).append("\n"); 
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
		query.append("    " ).append("\n"); 
		query.append("    CRE_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID,/*로그인 ID*/" ).append("\n"); 
		query.append("    UPD_DT    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT SUBSTR(@[src_cd],1,1) SR_KND_CD" ).append("\n"); 
		query.append("     , @[sr_no] SR_NO" ).append("\n"); 
		query.append("     , @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("     , NVL(SR_HIS_SEQ+1,0) SR_HIS_SEQ" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , DECODE(@[grp_cd], 'I', 'ID', 'R', 'RD', 'A', 'AD', '  ') /* WRK_GRP_CD */" ).append("\n"); 
		query.append("     , 'R' /* 상수 */" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC( (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                                FROM   COM_USER" ).append("\n"); 
		query.append("                                                                                WHERE  USR_ID = @[usr_id]) )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("     , DECODE(@[ui_grp_cd], 'I', 'I', 'R', 'R', 'S', 'S', ' ') /* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("     ,@[message]" ).append("\n"); 
		query.append("     , DECODE(@[ui_grp_cd], 'I', 'I', 'R', 'R', 'S', 'S', ' ') /* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , BKG_GET_TOKEN_FNC(CRNT_RQST,6) AS RTN_TO_RTN_STS_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC( (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                                FROM   COM_USER" ).append("\n"); 
		query.append("                                                                                WHERE  USR_ID = @[usr_id]) )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("		, NVL(@[rsn_bkg_mn_flg]    , 'N')  /*BKG Main*/            " ).append("\n"); 
		query.append("		, NVL(@[rsn_cust_info_flg] , 'N')  /*Customer INFO*/       " ).append("\n"); 
		query.append("		, NVL(@[rsn_frt_chg_flg]   , 'N')  /*FRT & Charge*/        " ).append("\n"); 
		query.append("		, NVL(@[rsn_cntr_flg]      , 'N')  /*Container*/           " ).append("\n"); 
		query.append("		, NVL(@[rsn_cntr_mf_flg]   , 'N')  /*Container Manifest*/  " ).append("\n"); 
		query.append("																														 " ).append("\n"); 
		query.append("		, NVL(@[rsn_dcgo_flg]      , 'N')  /*Danger*/              " ).append("\n"); 
		query.append("		, NVL(@[rsn_awk_cgo_flg]   , 'N')  /*Awkward*/             " ).append("\n"); 
		query.append("		, NVL(@[rsn_rc_flg]        , 'N')  /*Reefer*/              " ).append("\n"); 
		query.append("		, NVL(@[rsn_bb_cgo_flg]    , 'N')  /*B/Bulk*/              " ).append("\n"); 
		query.append("		, NVL(@[rsn_rly_port_flg]  , 'N')  /*RLY VVD & Port*/      " ).append("\n"); 
		query.append("																														 " ).append("\n"); 
		query.append("		, NVL(@[rsn_new_bkg_flg]   , 'N')  /*New BKG*/             " ).append("\n"); 
		query.append("		, NVL(@[rsn_split_flg]     , 'N')  /*BKG Split*/           " ).append("\n"); 
		query.append("		, NVL(@[rsn_bl_info_flg]   , 'N')  /*BL Inform*/           " ).append("\n"); 
		query.append("		, NVL(@[rsn_hbl_flg]       , 'N')  /*NVO House BL*/        " ).append("\n"); 
		query.append("		, NVL(@[cust_verif_flg]    , 'N')  /*Customer Verification*/" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("    -- , BKG_GET_TOKEN_FNC(CRNT_RQST,1) AS SR_CRNT_STS_CD" ).append("\n"); 
		query.append("     --, BKG_GET_TOKEN_FNC(CRNT_RQST,2) AS SR_CRNT_INFO_CD     " ).append("\n"); 
		query.append("     --, BKG_GET_TOKEN_FNC(CRNT_RQST,5) AS RTN_FM_USR_ID   " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("FROM (  SELECT " ).append("\n"); 
		query.append("                (SELECT " ).append("\n"); 
		query.append("                     SR_CRNT_STS_CD    ||','||" ).append("\n"); 
		query.append("                     SR_CRNT_INFO_CD   ||','||" ).append("\n"); 
		query.append("                     RTN_TO_USR_ID     ||','||" ).append("\n"); 
		query.append("                     RTN_TO_RTN_USR_ID ||','||" ).append("\n"); 
		query.append("                     RTN_FM_USR_ID     ||','||" ).append("\n"); 
		query.append("                     RTN_TO_RTN_STS_CD" ).append("\n"); 
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
		query.append("               ) SR_HIS_SEQ" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}