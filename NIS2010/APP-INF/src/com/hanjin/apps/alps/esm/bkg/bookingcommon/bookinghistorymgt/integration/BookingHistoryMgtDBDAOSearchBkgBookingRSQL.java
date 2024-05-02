/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchBkgBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgBookingRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgBookingRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO,                " ).append("\n"); 
		query.append("       BL_NO,                 " ).append("\n"); 
		query.append("       BL_NO_TP,              " ).append("\n"); 
		query.append("       BL_TP_CD,              " ).append("\n"); 
		query.append("       BKG_STS_CD,            " ).append("\n"); 
		query.append("       BKG_CGO_TP_CD,         " ).append("\n"); 
		query.append("       SLAN_CD,               " ).append("\n"); 
		query.append("       SVC_SCP_CD,            " ).append("\n"); 
		query.append("       VSL_CD,                " ).append("\n"); 
		query.append("       SKD_VOY_NO,            " ).append("\n"); 
		query.append("       SKD_DIR_CD,            " ).append("\n"); 
		query.append("       REV_DIR_CD,             " ).append("\n"); 
		query.append("       RCV_TERM_CD,           " ).append("\n"); 
		query.append("       DE_TERM_CD,            " ).append("\n"); 
		query.append("       POR_CD,                " ).append("\n"); 
		query.append("       POR_NOD_CD,            " ).append("\n"); 
		query.append("       POL_CD,                " ).append("\n"); 
		query.append("       POL_NOD_CD,            " ).append("\n"); 
		query.append("       POD_CD,                " ).append("\n"); 
		query.append("       POD_NOD_CD,            " ).append("\n"); 
		query.append("       OCP_CD,                " ).append("\n"); 
		query.append("       DEL_CD,                " ).append("\n"); 
		query.append("       DEL_NOD_CD,            " ).append("\n"); 
		query.append("       FNL_DEST_CD,           " ).append("\n"); 
		query.append("       TO_CHAR(POL_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') POL_ETD_DT,            " ).append("\n"); 
		query.append("       TO_CHAR(POD_ETA_DT, 'YYYY-MM-DD HH24:MI:SS') POD_ETA_DT,            " ).append("\n"); 
		query.append("       MTY_PKUP_YD_CD,        " ).append("\n"); 
		query.append("       TO_CHAR(MTY_PKUP_DT, 'YYYY-MM-DD HH24:MI:SS') MTY_PKUP_DT,           " ).append("\n"); 
		query.append("       FULL_RTN_YD_CD,        " ).append("\n"); 
		query.append("       FULL_PKUP_YD_CD,       " ).append("\n"); 
		query.append("       MTY_RTN_YD_CD,         " ).append("\n"); 
		query.append("       TO_CHAR(MTY_DOR_ARR_DT, 'YYYY-MM-DD HH24:MI:SS') MTY_DOR_ARR_DT,        " ).append("\n"); 
		query.append("       TO_CHAR(LODG_DUE_DT, 'YYYY-MM-DD HH24:MI:SS') LODG_DUE_DT,           " ).append("\n"); 
		query.append("       TO_CHAR(DE_DUE_DT, 'YYYY-MM-DD HH24:MI:SS') DE_DUE_DT,             " ).append("\n"); 
		query.append("       TO_CHAR(IB_DEL_DE_DT, 'YYYY-MM-DD HH24:MI:SS') IB_DEL_DE_DT,          " ).append("\n"); 
		query.append("       ORG_TRNS_SVC_MOD_CD,   " ).append("\n"); 
		query.append("       ORG_TRNS_MOD_CD,       " ).append("\n"); 
		query.append("       ORG_SCONTI_CD,         " ).append("\n"); 
		query.append("       DEST_TRNS_SVC_MOD_CD,  " ).append("\n"); 
		query.append("       DEST_TRNS_MOD_CD,      " ).append("\n"); 
		query.append("       DEST_SCONTI_CD,        " ).append("\n"); 
		query.append("       STOP_OFF_LOC_CD,       " ).append("\n"); 
		query.append("       STOP_OFF_CNTC_PSON_NM, " ).append("\n"); 
		query.append("       STOP_OFF_CNTC_PHN_NO,  " ).append("\n"); 
		query.append("       STOP_OFF_DIFF_RMK,     " ).append("\n"); 
		query.append("       SLS_RHQ_CD,            " ).append("\n"); 
		query.append("       SLS_RGN_OFC_CD,        " ).append("\n"); 
		query.append("       BKG_OFC_CD,            " ).append("\n"); 
		query.append("       DOC_USR_ID,            " ).append("\n"); 
		query.append("       CTRT_OFC_CD,           " ).append("\n"); 
		query.append("       CTRT_SREP_CD,          " ).append("\n"); 
		query.append("       CTRT_CUST_CNT_CD,      " ).append("\n"); 
		query.append("       CTRT_CUST_SEQ,         " ).append("\n"); 
		query.append("       OB_SLS_OFC_CD,         " ).append("\n"); 
		query.append("       OB_SREP_CD,            " ).append("\n"); 
		query.append("       IB_SLS_OFC_CD,         " ).append("\n"); 
		query.append("       EQ_CTRL_OFC_CD,        " ).append("\n"); 
		query.append("       TO_CHAR(BKG_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') BKG_CRE_DT,            " ).append("\n"); 
		query.append("       TO_CHAR(BKG_CXL_DT, 'YYYY-MM-DD HH24:MI:SS') BKG_CXL_DT,            " ).append("\n"); 
		query.append("       TO_CHAR(PORT_CLZ_DT, 'YYYY-MM-DD HH24:MI:SS') PORT_CLZ_DT,           " ).append("\n"); 
		query.append("       CMDT_CD,               " ).append("\n"); 
		query.append("       REP_CMDT_CD,           " ).append("\n"); 
		query.append("       DCGO_FLG,              " ).append("\n"); 
		query.append("       RC_FLG,                " ).append("\n"); 
		query.append("       AWK_CGO_FLG,           " ).append("\n"); 
		query.append("       BB_CGO_FLG,            " ).append("\n"); 
		query.append("       RD_CGO_FLG,            " ).append("\n"); 
		query.append("       HNGR_FLG,              " ).append("\n"); 
		query.append("       RAIL_BLK_CD,           " ).append("\n"); 
		query.append("       PRCT_FLG,              " ).append("\n"); 
		query.append("       SPCL_HIDE_FLG,         " ).append("\n"); 
		query.append("       SOC_FLG,               " ).append("\n"); 
		query.append("       EQ_SUBST_FLG,          " ).append("\n"); 
		query.append("       FD_GRD_FLG,            " ).append("\n"); 
		query.append("       FLEX_HGT_FLG,          " ).append("\n"); 
		query.append("       STWG_CD,               " ).append("\n"); 
		query.append("       STWG_RMK,              " ).append("\n"); 
		query.append("       BLCK_STWG_CD,          " ).append("\n"); 
		query.append("       ALL_MTR_FLG,           " ).append("\n"); 
		query.append("       DBL_BKG_FLG,           " ).append("\n"); 
		query.append("       AP_BROG_FLG,           " ).append("\n"); 
		query.append("       CUST_TO_ORD_FLG,       " ).append("\n"); 
		query.append("       KR_CSTMS_CUST_TP_CD,   " ).append("\n"); 
		query.append("       SAM_CNEE_NTFY_FLG,     " ).append("\n"); 
		query.append("       ALT_CUST_CFM_FLG,      " ).append("\n"); 
		query.append("       WT_RSN_SPCL_CGO_FLG,   " ).append("\n"); 
		query.append("       WT_RSN_HLD_FLG,        " ).append("\n"); 
		query.append("       SHP_BAK_FLG,           " ).append("\n"); 
		query.append("       MNL_BKG_NO_FLG,        " ).append("\n"); 
		query.append("       BL_ISS_BLCK_FLG,       " ).append("\n"); 
		query.append("       TO_CHAR(CA_INSP_DUE_DT, 'YYYY-MM-DD HH24:MI:SS') CA_INSP_DUE_DT,        " ).append("\n"); 
		query.append("       SCAC_CD,               " ).append("\n"); 
		query.append("       CHN_AGN_CD,            " ).append("\n"); 
		query.append("       USA_CSTMS_FILE_CD,     " ).append("\n"); 
		query.append("       CND_CSTMS_FILE_CD,     " ).append("\n"); 
		query.append("       TWN_SO_NO,             " ).append("\n"); 
		query.append("       INTER_RMK,             " ).append("\n"); 
		query.append("       XTER_RMK,              " ).append("\n"); 
		query.append("       INTER_RMK_AUD_FLG,     " ).append("\n"); 
		query.append("       SPLIT_FLG,             " ).append("\n"); 
		query.append("       HCMT_CMB_FLG,          " ).append("\n"); 
		query.append("       BKG_CRE_TP_CD,         " ).append("\n"); 
		query.append("       TO_BKG_NO,             " ).append("\n"); 
		query.append("       FM_BKG_NO,             " ).append("\n"); 
		query.append("       ADV_SHTG_CD,           " ).append("\n"); 
		query.append("       SPLIT_RSN_CD,          " ).append("\n"); 
		query.append("       SPLIT_RTO,             " ).append("\n"); 
		query.append("       TO_CHAR(SPLIT_DT, 'YYYY-MM-DD HH24:MI:SS') SPLIT_DT,              " ).append("\n"); 
		query.append("       SC_NO,                 " ).append("\n"); 
		query.append("       RFA_NO,                " ).append("\n"); 
		query.append("       --TRF_LNR_ITM_NO,        " ).append("\n"); 
		query.append("       TAA_NO, " ).append("\n"); 
		query.append("       AGMT_ACT_CNT_CD,       " ).append("\n"); 
		query.append("       AGMT_ACT_CUST_SEQ,     " ).append("\n"); 
		query.append("       MTY_CRE_SVR_CD,        " ).append("\n"); 
		query.append("       MTY_BKG_STS_CD,        " ).append("\n"); 
		query.append("       MTY_SPLIT_AVAL_CD,     " ).append("\n"); 
		query.append("       XTER_BKG_RQST_CD,      " ).append("\n"); 
		query.append("       XTER_BKG_RQST_REF_NO,  " ).append("\n"); 
		query.append("       SI_FLG,                " ).append("\n"); 
		query.append("       XTER_SI_CD,            " ).append("\n"); 
		query.append("       XTER_SI_REF_NO,        " ).append("\n"); 
		query.append("       XTER_RQST_AUTO_NTC_FLG," ).append("\n"); 
		query.append("       XTER_BKG_KNT,          " ).append("\n"); 
		query.append("       XTER_SI_KNT,           " ).append("\n"); 
		query.append("       XTER_RQST_CUST_RMK,           " ).append("\n"); 
		query.append("       OVR_VOID_SLT_QTY,      " ).append("\n"); 
		query.append("       MY_FWRD_CD,            " ).append("\n"); 
		query.append("       MY_FWRD_VSL_DESC,      " ).append("\n"); 
		query.append("       PRE_RLY_PORT_CD,       " ).append("\n"); 
		query.append("       PST_RLY_PORT_CD,       " ).append("\n"); 
		query.append("	   PCTL_NO," ).append("\n"); 
		query.append("       TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("       EDI_HLD_FLG," ).append("\n"); 
		query.append("	   INDIV_PSON_FLG," ).append("\n"); 
		query.append("	   FUMG_LOC_CD," ).append("\n"); 
		query.append("	   FUMG_CNTC_PSON_NM," ).append("\n"); 
		query.append("	   FUMG_CNTC_PHN_NO," ).append("\n"); 
		query.append("	   FUMG_DIFF_RMK," ).append("\n"); 
		query.append("	   SPCL_HIDE_LNR_FLG," ).append("\n"); 
		query.append("	   CRR_SOC_FLG," ).append("\n"); 
		query.append("       ALOC_STS_CD," ).append("\n"); 
		query.append("	   NON_RT_STS_CD," ).append("\n"); 
		query.append("	   VEH_CMDT_FLG," ).append("\n"); 
		query.append("	   NEW_CUST_APRO_FLG," ).append("\n"); 
		query.append("	   NEW_CUST_APRO_CMDT_NM," ).append("\n"); 
		query.append("	   NEW_CUST_APRO_RMK," ).append("\n"); 
		query.append("	   IDA_HLG_TP_CD," ).append("\n"); 
		query.append("	   NON_DG_CHEM_FLG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}