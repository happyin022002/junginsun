/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyQueueDetailReturnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.27 
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

public class PerformanceReportDBDAOModifyQueueDetailReturnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOModifyQueueDetailReturnUSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyQueueDetailReturnUSQL(){
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
		params.put("rsn_rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rsn_bkg_mn_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyQueueDetailReturnUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_CRNT_RQST X" ).append("\n"); 
		query.append(" SET   SR_CRNT_STS_CD   = DECODE(@[grp_cd], 'I', 'ID', 'R', 'RD', 'A', 'AD', '  ')" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("       #if (${ui_grp_cd} == 'I') " ).append("\n"); 
		query.append("     , BL_DOC_INP_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #elseif (${ui_grp_cd} == 'R') " ).append("\n"); 
		query.append("     , BL_RT_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #elseif (${ui_grp_cd} == 'S') " ).append("\n"); 
		query.append("     , BL_DOC_INP_FLG    = 'N'" ).append("\n"); 
		query.append("     , BL_RT_FLG    = 'N'" ).append("\n"); 
		query.append("     , BL_AUD_FLG    = 'N'              " ).append("\n"); 
		query.append("     , BL_DRFT_FAX_OUT_FLG    = 'N'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , SR_CRNT_INFO_CD   ='R' /*상수*/" ).append("\n"); 
		query.append("     , MAX_HIS_SEQ = ( SELECT MAX(SR_HIS_SEQ)" ).append("\n"); 
		query.append("						FROM  BKG_SR_HIS" ).append("\n"); 
		query.append("						WHERE BKG_NO   = X.BKG_NO" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("     , CRNT_DT          = GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append("     , CRNT_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , RTN_FM_STS_CD    = @[grp_cd]" ).append("\n"); 
		query.append("     , RTN_FM_USR_ID    = @[usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , SR_RTN_TO_STS_CD = DECODE(@[ui_grp_cd], 'I', 'I', 'R', 'R', 'S', 'S', @[ui_grp_cd])/* UI WRK_GRP_CD 상에서 FO 'S', INPUTER 'I', RATER 'R' */" ).append("\n"); 
		query.append("     , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("     #if (${ui_grp_cd} == 'I') " ).append("\n"); 
		query.append("	 , RTN_TO_USR_ID    = BL_DOC_INP_USR_ID" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'R') " ).append("\n"); 
		query.append("	 , RTN_TO_USR_ID    = BL_RT_USR_ID" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'S') " ).append("\n"); 
		query.append("     , RTN_TO_USR_ID    = FNT_OFC_CD " ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'P') " ).append("\n"); 
		query.append("     , RTN_TO_USR_ID    = (SELECT M.OFC_CD FROM MDM_SLS_REP M,BKG_BOOKING BK WHERE BK.OB_SREP_CD = M.SREP_CD AND BK.BKG_NO = X.BKG_NO)" ).append("\n"); 
		query.append("     #elseif (${ui_grp_cd} == 'C') 	 " ).append("\n"); 
		query.append("     , RTN_TO_USR_ID    = 'Customer'" ).append("\n"); 
		query.append("	 #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , RTN_DT           = DPCS_DOC_FM_DT" ).append("\n"); 
		query.append("	 , DPCS_DOC_FM_DT	= GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,CRE_FLG      =      NVL(@[rsn_bkg_mn_flg]    , 'N')  /*BKG Main*/                                                                          " ).append("\n"); 
		query.append("    ,CUST_INP_FLG   =   	NVL(@[rsn_cust_info_flg] , 'N')  /*Customer INFO*/                                                             " ).append("\n"); 
		query.append("    ,CHG_INP_FLG     =   	NVL(@[rsn_frt_chg_flg]   , 'N')  /*FRT & Charge*/                                                              " ).append("\n"); 
		query.append("    ,CNTR_INP_FLG        =   	NVL(@[rsn_cntr_flg]      , 'N')  /*Container*/                                                                 " ).append("\n"); 
		query.append("    ,CNTR_MF_INP_FLG     =   	NVL(@[rsn_cntr_mf_flg]   , 'N')  /*Container Manifest*/                                                        " ).append("\n"); 
		query.append("                            																											 " ).append("\n"); 
		query.append("    ,DCGO_INP_FLG        =   	NVL(@[rsn_dcgo_flg]      , 'N')  /*Danger*/                                                                    " ).append("\n"); 
		query.append("    ,AWK_CGO_INP_FLG     =   	NVL(@[rsn_awk_cgo_flg]   , 'N')  /*Awkward*/                                                                   " ).append("\n"); 
		query.append("    ,RC_INP_FLG         =   	NVL(@[rsn_rc_flg]        , 'N')  /*Reefer*/                                                                    " ).append("\n"); 
		query.append("    ,BB_CGO_INP_FLG      =   	NVL(@[rsn_bb_cgo_flg]    , 'N')  /*B/Bulk*/                                                                    " ).append("\n"); 
		query.append("    ,RLY_PORT_INP_FLG    =   	NVL(@[rsn_rly_port_flg]  , 'N')  /*RLY VVD & Port*/                                                            " ).append("\n"); 
		query.append("                            																											 " ).append("\n"); 
		query.append("    ,NEW_BKG_CRE_FLG     =   	NVL(@[rsn_new_bkg_flg]   , 'N')  /*New BKG*/                                                                   " ).append("\n"); 
		query.append("    ,SPLIT_FLG       	=   	NVL(@[rsn_split_flg]     , 'N')  /*BKG Split*/                                                                 " ).append("\n"); 
		query.append("    ,BL_INFO_INP_FLG     =   	NVL(@[rsn_bl_info_flg]   , 'N')  /*BL Inform*/                                                                 " ).append("\n"); 
		query.append("    ,HBL_INFO_INP_FLG    =   	NVL(@[rsn_hbl_flg]       , 'N')  /*NVO House BL*/                                                              " ).append("\n"); 
		query.append("    ,MK_DESC_INP_FLG     =   	NVL(@[cust_verif_flg]    , 'N')  /*Customer Verification*/ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,RTN_HRS =  (SELECT SUM(SR_PROC_HRS) FROM BKG_SR_HIS H WHERE H.SR_KND_CD=X.SR_KND_CD AND H.SR_NO = X.SR_NO AND H.BKG_NO = X.BKG_NO AND H.SR_STS_CD = 'RR')                                                    " ).append("\n"); 
		query.append("WHERE SR_KND_CD = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("  AND  SR_NO    = @[sr_no]" ).append("\n"); 
		query.append("  AND  BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("  AND SR_AMD_TP_CD = @[sr_knd_cd]/* 0421의 SR_KND_CD*/" ).append("\n"); 
		query.append("  AND SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ) " ).append("\n"); 
		query.append("                      FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                     WHERE SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("                       AND SR_NO = X.SR_NO" ).append("\n"); 
		query.append("                       AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                       AND SR_AMD_TP_CD = X.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 

	}
}