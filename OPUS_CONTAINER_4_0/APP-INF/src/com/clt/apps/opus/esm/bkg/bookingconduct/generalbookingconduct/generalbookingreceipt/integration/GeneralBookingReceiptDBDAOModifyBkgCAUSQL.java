/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgCAUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyBkgCAUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOModifyBkgCAUSQL
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgCAUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgCAUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING " ).append("\n"); 
		query.append("   SET (" ).append("\n"); 
		query.append("      BL_NO " ).append("\n"); 
		query.append("    , BL_NO_TP " ).append("\n"); 
		query.append("    , BL_TP_CD " ).append("\n"); 
		query.append("    , BKG_STS_CD " ).append("\n"); 
		query.append("    , BKG_CGO_TP_CD " ).append("\n"); 
		query.append("    , SLAN_CD " ).append("\n"); 
		query.append("    , VSL_CD " ).append("\n"); 
		query.append("    , SKD_VOY_NO " ).append("\n"); 
		query.append("    , SKD_DIR_CD " ).append("\n"); 
		query.append("    , REV_DIR_CD " ).append("\n"); 
		query.append("    , RCV_TERM_CD " ).append("\n"); 
		query.append("    , DE_TERM_CD " ).append("\n"); 
		query.append("    , POR_CD " ).append("\n"); 
		query.append("    , POR_NOD_CD " ).append("\n"); 
		query.append("    , POL_CD " ).append("\n"); 
		query.append("    , POL_NOD_CD " ).append("\n"); 
		query.append("    , POD_CD " ).append("\n"); 
		query.append("    , POD_NOD_CD " ).append("\n"); 
		query.append("    , OCP_CD " ).append("\n"); 
		query.append("    , DEL_CD " ).append("\n"); 
		query.append("    , DEL_NOD_CD " ).append("\n"); 
		query.append("    , FNL_DEST_CD " ).append("\n"); 
		query.append("    , POL_ETD_DT " ).append("\n"); 
		query.append("    , MTY_PKUP_YD_CD " ).append("\n"); 
		query.append("    , POD_ETA_DT " ).append("\n"); 
		query.append("    , FULL_RTN_YD_CD " ).append("\n"); 
		query.append("    , MTY_PKUP_DT " ).append("\n"); 
		query.append("    , FULL_PKUP_YD_CD " ).append("\n"); 
		query.append("    , MTY_RTN_YD_CD " ).append("\n"); 
		query.append("    , MTY_DOR_ARR_DT " ).append("\n"); 
		query.append("    , LODG_DUE_DT " ).append("\n"); 
		query.append("    , DE_DUE_DT " ).append("\n"); 
		query.append("    , IB_DEL_DE_DT " ).append("\n"); 
		query.append("    , ORG_TRNS_SVC_MOD_CD " ).append("\n"); 
		query.append("    , ORG_TRNS_MOD_CD " ).append("\n"); 
		query.append("    , ORG_SCONTI_CD " ).append("\n"); 
		query.append("    , DEST_TRNS_SVC_MOD_CD " ).append("\n"); 
		query.append("    , DEST_TRNS_MOD_CD " ).append("\n"); 
		query.append("    , DEST_SCONTI_CD " ).append("\n"); 
		query.append("    , STOP_OFF_LOC_CD " ).append("\n"); 
		query.append("    , STOP_OFF_CNTC_PSON_NM " ).append("\n"); 
		query.append("    , STOP_OFF_CNTC_PHN_NO " ).append("\n"); 
		query.append("    , STOP_OFF_DIFF_RMK " ).append("\n"); 
		query.append("    , SLS_RHQ_CD " ).append("\n"); 
		query.append("    , SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("    , BKG_OFC_CD " ).append("\n"); 
		query.append("    , DOC_USR_ID " ).append("\n"); 
		query.append("    , CTRT_OFC_CD " ).append("\n"); 
		query.append("    , CTRT_SREP_CD " ).append("\n"); 
		query.append("    , CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("    , CTRT_CUST_SEQ " ).append("\n"); 
		query.append("    , OB_SLS_OFC_CD " ).append("\n"); 
		query.append("    , OB_SREP_CD " ).append("\n"); 
		query.append("    , IB_SLS_OFC_CD " ).append("\n"); 
		query.append("    , EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("    , BKG_CRE_DT " ).append("\n"); 
		query.append("    , BKG_CXL_DT " ).append("\n"); 
		query.append("    , PORT_CLZ_DT " ).append("\n"); 
		query.append("    , CMDT_CD " ).append("\n"); 
		query.append("    , REP_CMDT_CD " ).append("\n"); 
		query.append("    , DCGO_FLG " ).append("\n"); 
		query.append("    , RC_FLG " ).append("\n"); 
		query.append("    , AWK_CGO_FLG " ).append("\n"); 
		query.append("    , BB_CGO_FLG " ).append("\n"); 
		query.append("    , RD_CGO_FLG " ).append("\n"); 
		query.append("    , HNGR_FLG " ).append("\n"); 
		query.append("    , RAIL_BLK_CD " ).append("\n"); 
		query.append("    , PRCT_FLG " ).append("\n"); 
		query.append("    , SPCL_HIDE_FLG " ).append("\n"); 
		query.append("    , SOC_FLG " ).append("\n"); 
		query.append("    , EQ_SUBST_FLG " ).append("\n"); 
		query.append("    , FD_GRD_FLG " ).append("\n"); 
		query.append("    , FLEX_HGT_FLG " ).append("\n"); 
		query.append("    , STWG_CD " ).append("\n"); 
		query.append("    , STWG_RMK " ).append("\n"); 
		query.append("    , BLCK_STWG_CD " ).append("\n"); 
		query.append("    , ALL_MTR_FLG " ).append("\n"); 
		query.append("    , HOT_DE_FLG " ).append("\n"); 
		query.append("    , DBL_BKG_FLG " ).append("\n"); 
		query.append("    , AP_BROG_FLG " ).append("\n"); 
		query.append("    , CUST_TO_ORD_FLG " ).append("\n"); 
		query.append("    , KR_CSTMS_CUST_TP_CD " ).append("\n"); 
		query.append("    , SAM_CNEE_NTFY_FLG " ).append("\n"); 
		query.append("    , WT_RSN_SPCL_CGO_FLG " ).append("\n"); 
		query.append("    , ALT_CUST_CFM_FLG " ).append("\n"); 
		query.append("    , WT_RSN_HLD_FLG " ).append("\n"); 
		query.append("    , SHP_BAK_FLG " ).append("\n"); 
		query.append("    , MNL_BKG_NO_FLG " ).append("\n"); 
		query.append("    , BL_ISS_BLCK_FLG " ).append("\n"); 
		query.append("    , CA_INSP_DUE_DT " ).append("\n"); 
		query.append("    , SCAC_CD " ).append("\n"); 
		query.append("    , CHN_AGN_CD " ).append("\n"); 
		query.append("    , USA_CSTMS_FILE_CD " ).append("\n"); 
		query.append("    , CND_CSTMS_FILE_CD " ).append("\n"); 
		query.append("    , TWN_SO_NO " ).append("\n"); 
		query.append("    , INTER_RMK " ).append("\n"); 
		query.append("    , XTER_RMK " ).append("\n"); 
		query.append("    , INTER_RMK_AUD_FLG " ).append("\n"); 
		query.append("    , SPLIT_FLG " ).append("\n"); 
		query.append("    , HCMT_CMB_FLG " ).append("\n"); 
		query.append("    , BKG_CRE_TP_CD " ).append("\n"); 
		query.append("    , ADV_SHTG_CD " ).append("\n"); 
		query.append("    , SPLIT_RSN_CD " ).append("\n"); 
		query.append("    , SPLIT_RTO " ).append("\n"); 
		query.append("    , SPLIT_DT " ).append("\n"); 
		query.append("    , SC_NO " ).append("\n"); 
		query.append("    , RFA_NO " ).append("\n"); 
		query.append("    , TAA_NO " ).append("\n"); 
		query.append("    , AGMT_ACT_CNT_CD " ).append("\n"); 
		query.append("    , AGMT_ACT_CUST_SEQ " ).append("\n"); 
		query.append("    , MTY_CRE_SVR_CD " ).append("\n"); 
		query.append("    , MTY_BKG_STS_CD " ).append("\n"); 
		query.append("    , MTY_POD_FLG " ).append("\n"); 
		query.append("    , MTY_PRE_VVD_FLG " ).append("\n"); 
		query.append("    , MTY_PORT_FLG " ).append("\n"); 
		query.append("    , MTY_SPLIT_AVAL_CD " ).append("\n"); 
		query.append("    , XTER_BKG_RQST_CD " ).append("\n"); 
		query.append("    , XTER_BKG_RQST_REF_NO " ).append("\n"); 
		query.append("    , SI_FLG " ).append("\n"); 
		query.append("    , XTER_SI_CD " ).append("\n"); 
		query.append("    , XTER_SI_REF_NO " ).append("\n"); 
		query.append("    , XTER_RQST_AUTO_NTC_FLG " ).append("\n"); 
		query.append("    , XTER_BKG_KNT " ).append("\n"); 
		query.append("    , XTER_SI_KNT " ).append("\n"); 
		query.append("    , XTER_RQST_CUST_RMK " ).append("\n"); 
		query.append("    , OVR_VOID_SLT_QTY " ).append("\n"); 
		query.append("    , MY_FWRD_CD " ).append("\n"); 
		query.append("    , MY_FWRD_VSL_DESC " ).append("\n"); 
		query.append("    , PRE_RLY_PORT_CD " ).append("\n"); 
		query.append("    , PST_RLY_PORT_CD " ).append("\n"); 
		query.append("    , CRE_USR_ID " ).append("\n"); 
		query.append("    , CRE_DT " ).append("\n"); 
		query.append("    , UPD_USR_ID " ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("    , SVC_SCP_CD " ).append("\n"); 
		query.append("    , FM_BKG_NO " ).append("\n"); 
		query.append("    , TO_BKG_NO" ).append("\n"); 
		query.append("	, PCTL_NO" ).append("\n"); 
		query.append("	, BKG_CTRL_PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	, BKG_CTRL_PTY_CUST_SEQ" ).append("\n"); 
		query.append("	, IRR_BL_NO_FLG" ).append("\n"); 
		query.append("	, EDI_HLD_FLG" ).append("\n"); 
		query.append("	, VNDR_RMK" ).append("\n"); 
		query.append("	, BKG_PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("	, BKG_PTY_CUST_SEQ" ).append("\n"); 
		query.append(" ) = (SELECT  BL_NO " ).append("\n"); 
		query.append("                            , BL_NO_TP " ).append("\n"); 
		query.append("                            , BL_TP_CD " ).append("\n"); 
		query.append("                            , BKG_STS_CD " ).append("\n"); 
		query.append("                            , BKG_CGO_TP_CD " ).append("\n"); 
		query.append("                            , SLAN_CD " ).append("\n"); 
		query.append("                            , VSL_CD " ).append("\n"); 
		query.append("                            , SKD_VOY_NO " ).append("\n"); 
		query.append("                            , SKD_DIR_CD " ).append("\n"); 
		query.append("                            , REV_DIR_CD " ).append("\n"); 
		query.append("                            , RCV_TERM_CD " ).append("\n"); 
		query.append("                            , DE_TERM_CD " ).append("\n"); 
		query.append("                            , POR_CD " ).append("\n"); 
		query.append("                            , POR_NOD_CD " ).append("\n"); 
		query.append("                            , POL_CD " ).append("\n"); 
		query.append("                            , POL_NOD_CD " ).append("\n"); 
		query.append("                            , POD_CD " ).append("\n"); 
		query.append("                            , POD_NOD_CD " ).append("\n"); 
		query.append("                            , OCP_CD " ).append("\n"); 
		query.append("                            , DEL_CD " ).append("\n"); 
		query.append("                            , DEL_NOD_CD " ).append("\n"); 
		query.append("                            , FNL_DEST_CD " ).append("\n"); 
		query.append("                            , POL_ETD_DT " ).append("\n"); 
		query.append("                            , MTY_PKUP_YD_CD " ).append("\n"); 
		query.append("                            , POD_ETA_DT " ).append("\n"); 
		query.append("                            , FULL_RTN_YD_CD " ).append("\n"); 
		query.append("                            , MTY_PKUP_DT " ).append("\n"); 
		query.append("                            , FULL_PKUP_YD_CD " ).append("\n"); 
		query.append("                            , MTY_RTN_YD_CD " ).append("\n"); 
		query.append("                            , MTY_DOR_ARR_DT " ).append("\n"); 
		query.append("                            , LODG_DUE_DT " ).append("\n"); 
		query.append("                            , DE_DUE_DT " ).append("\n"); 
		query.append("                            , IB_DEL_DE_DT " ).append("\n"); 
		query.append("                            , ORG_TRNS_SVC_MOD_CD " ).append("\n"); 
		query.append("                            , ORG_TRNS_MOD_CD " ).append("\n"); 
		query.append("                            , ORG_SCONTI_CD " ).append("\n"); 
		query.append("                            , DEST_TRNS_SVC_MOD_CD " ).append("\n"); 
		query.append("                            , DEST_TRNS_MOD_CD " ).append("\n"); 
		query.append("                            , DEST_SCONTI_CD " ).append("\n"); 
		query.append("                            , STOP_OFF_LOC_CD " ).append("\n"); 
		query.append("                            , STOP_OFF_CNTC_PSON_NM " ).append("\n"); 
		query.append("                            , STOP_OFF_CNTC_PHN_NO " ).append("\n"); 
		query.append("                            , STOP_OFF_DIFF_RMK " ).append("\n"); 
		query.append("                            , SLS_RHQ_CD " ).append("\n"); 
		query.append("                            , SLS_RGN_OFC_CD " ).append("\n"); 
		query.append("                            , BKG_OFC_CD " ).append("\n"); 
		query.append("                            , DOC_USR_ID " ).append("\n"); 
		query.append("                            , CTRT_OFC_CD " ).append("\n"); 
		query.append("                            , CTRT_SREP_CD " ).append("\n"); 
		query.append("                            , CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("                            , CTRT_CUST_SEQ " ).append("\n"); 
		query.append("                            , OB_SLS_OFC_CD " ).append("\n"); 
		query.append("                            , OB_SREP_CD " ).append("\n"); 
		query.append("                            , IB_SLS_OFC_CD " ).append("\n"); 
		query.append("                            , EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("                            , BKG_CRE_DT " ).append("\n"); 
		query.append("                            , BKG_CXL_DT " ).append("\n"); 
		query.append("                            , PORT_CLZ_DT " ).append("\n"); 
		query.append("                            , CMDT_CD " ).append("\n"); 
		query.append("                            , REP_CMDT_CD " ).append("\n"); 
		query.append("                            , nvl(DCGO_FLG, 'N')" ).append("\n"); 
		query.append("                            , nvl(RC_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(AWK_CGO_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(BB_CGO_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(RD_CGO_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(HNGR_FLG , 'N')" ).append("\n"); 
		query.append("                            , RAIL_BLK_CD " ).append("\n"); 
		query.append("                            , nvl(PRCT_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(SPCL_HIDE_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(SOC_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(EQ_SUBST_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(FD_GRD_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(FLEX_HGT_FLG , 'N')" ).append("\n"); 
		query.append("                            , STWG_CD " ).append("\n"); 
		query.append("                            , STWG_RMK " ).append("\n"); 
		query.append("                            , BLCK_STWG_CD " ).append("\n"); 
		query.append("                            , nvl(ALL_MTR_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(HOT_DE_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(DBL_BKG_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(AP_BROG_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(CUST_TO_ORD_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(KR_CSTMS_CUST_TP_CD , 'N')" ).append("\n"); 
		query.append("                            , nvl(SAM_CNEE_NTFY_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(WT_RSN_SPCL_CGO_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(ALT_CUST_CFM_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(WT_RSN_HLD_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(SHP_BAK_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(MNL_BKG_NO_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(BL_ISS_BLCK_FLG , 'N')" ).append("\n"); 
		query.append("                            , CA_INSP_DUE_DT " ).append("\n"); 
		query.append("                            , SCAC_CD " ).append("\n"); 
		query.append("                            , CHN_AGN_CD " ).append("\n"); 
		query.append("                            , USA_CSTMS_FILE_CD " ).append("\n"); 
		query.append("                            , CND_CSTMS_FILE_CD " ).append("\n"); 
		query.append("                            , TWN_SO_NO " ).append("\n"); 
		query.append("                            , INTER_RMK " ).append("\n"); 
		query.append("                            , XTER_RMK " ).append("\n"); 
		query.append("                            , nvl(INTER_RMK_AUD_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(SPLIT_FLG , 'N')" ).append("\n"); 
		query.append("                            , nvl(HCMT_CMB_FLG , 'N')" ).append("\n"); 
		query.append("                            , BKG_CRE_TP_CD " ).append("\n"); 
		query.append("                            , ADV_SHTG_CD " ).append("\n"); 
		query.append("                            , SPLIT_RSN_CD " ).append("\n"); 
		query.append("                            , SPLIT_RTO " ).append("\n"); 
		query.append("                            , SPLIT_DT " ).append("\n"); 
		query.append("                            , SC_NO " ).append("\n"); 
		query.append("                            , RFA_NO " ).append("\n"); 
		query.append("                            , TAA_NO " ).append("\n"); 
		query.append("                            , AGMT_ACT_CNT_CD " ).append("\n"); 
		query.append("                            , AGMT_ACT_CUST_SEQ " ).append("\n"); 
		query.append("                            , MTY_CRE_SVR_CD " ).append("\n"); 
		query.append("                            , MTY_BKG_STS_CD " ).append("\n"); 
		query.append("                            , nvl(MTY_POD_FLG  , 'N') " ).append("\n"); 
		query.append("                            , nvl(MTY_PRE_VVD_FLG  , 'N')" ).append("\n"); 
		query.append("                            , nvl(MTY_PORT_FLG  , 'N')" ).append("\n"); 
		query.append("                            , nvl(MTY_SPLIT_AVAL_CD  , 'N')" ).append("\n"); 
		query.append("                            , XTER_BKG_RQST_CD " ).append("\n"); 
		query.append("                            , XTER_BKG_RQST_REF_NO " ).append("\n"); 
		query.append("                            , nvl(SI_FLG  , 'N')" ).append("\n"); 
		query.append("                            , XTER_SI_CD " ).append("\n"); 
		query.append("                            , XTER_SI_REF_NO " ).append("\n"); 
		query.append("                            , nvl(XTER_RQST_AUTO_NTC_FLG  , 'N')" ).append("\n"); 
		query.append("                            , XTER_BKG_KNT " ).append("\n"); 
		query.append("                            , XTER_SI_KNT " ).append("\n"); 
		query.append("                            , XTER_RQST_CUST_RMK " ).append("\n"); 
		query.append("                            , nvl(OVR_VOID_SLT_QTY, 0)" ).append("\n"); 
		query.append("                            , MY_FWRD_CD " ).append("\n"); 
		query.append("                            , MY_FWRD_VSL_DESC " ).append("\n"); 
		query.append("                            , PRE_RLY_PORT_CD " ).append("\n"); 
		query.append("                            , PST_RLY_PORT_CD " ).append("\n"); 
		query.append("                            , CRE_USR_ID " ).append("\n"); 
		query.append("                            , CRE_DT " ).append("\n"); 
		query.append("                            , UPD_USR_ID " ).append("\n"); 
		query.append("                            , sysdate" ).append("\n"); 
		query.append("                            , SVC_SCP_CD " ).append("\n"); 
		query.append("                            , FM_BKG_NO " ).append("\n"); 
		query.append("                            , TO_BKG_NO" ).append("\n"); 
		query.append("							, PCTL_NO " ).append("\n"); 
		query.append("							, BKG_CTRL_PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("							, BKG_CTRL_PTY_CUST_SEQ" ).append("\n"); 
		query.append("							, IRR_BL_NO_FLG" ).append("\n"); 
		query.append("							, EDI_HLD_FLG" ).append("\n"); 
		query.append("							, VNDR_RMK" ).append("\n"); 
		query.append("							, BKG_PTY_CUST_CNT_CD" ).append("\n"); 
		query.append("							, BKG_PTY_CUST_SEQ" ).append("\n"); 
		query.append("                      FROM BKG_BKG_HIS " ).append("\n"); 
		query.append("                     WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                       AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}