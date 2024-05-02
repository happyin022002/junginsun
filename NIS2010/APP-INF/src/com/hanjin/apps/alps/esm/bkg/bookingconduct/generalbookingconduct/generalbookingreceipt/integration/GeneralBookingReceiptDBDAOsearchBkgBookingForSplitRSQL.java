/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchBkgBookingForSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchBkgBookingForSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgBookingForSplit
	  * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchBkgBookingForSplitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_hide_lnr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("veh_cmdt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_hide_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_off_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tvvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fd_grd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splitcount",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_blk_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fumg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchBkgBookingForSplitRSQL").append("\n"); 
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
		query.append("select bkg_no" ).append("\n"); 
		query.append("    , BL_TP_CD" ).append("\n"); 
		query.append("    , BKG_STS_CD" ).append("\n"); 
		query.append("    , BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    , SLAN_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , substr(@[tvvd], 1, 4) VSL_CD" ).append("\n"); 
		query.append("    , substr(@[tvvd], 5, 4) SKD_VOY_NO" ).append("\n"); 
		query.append("    , substr(@[tvvd], 9, 1) SKD_DIR_CD" ).append("\n"); 
		query.append("    , REV_DIR_CD" ).append("\n"); 
		query.append("    , RCV_TERM_CD" ).append("\n"); 
		query.append("    , DE_TERM_CD" ).append("\n"); 
		query.append("    , POR_CD" ).append("\n"); 
		query.append("    , POR_NOD_CD" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , POL_NOD_CD" ).append("\n"); 
		query.append("    , POD_CD" ).append("\n"); 
		query.append("    , POD_NOD_CD" ).append("\n"); 
		query.append("    , OCP_CD" ).append("\n"); 
		query.append("    , DEL_CD" ).append("\n"); 
		query.append("    , DEL_NOD_CD" ).append("\n"); 
		query.append("    , FNL_DEST_CD" ).append("\n"); 
		query.append("    , TO_CHAR(POL_ETD_DT, 'YYYY-MM-DD hh24:mi:ss') POL_ETD_DT" ).append("\n"); 
		query.append("    , TO_CHAR(POD_ETA_DT, 'YYYY-MM-DD hh24:mi:ss') POD_ETA_DT" ).append("\n"); 
		query.append("    , MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("    , TO_CHAR(MTY_PKUP_DT, 'YYYY-MM-DD hh24:mi:ss') MTY_PKUP_DT" ).append("\n"); 
		query.append("    , FULL_RTN_YD_CD" ).append("\n"); 
		query.append("    , FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("    , MTY_RTN_YD_CD" ).append("\n"); 
		query.append("    , TO_CHAR(MTY_DOR_ARR_DT, 'YYYY-MM-DD hh24:mi:ss') MTY_DOR_ARR_DT" ).append("\n"); 
		query.append("    , TO_CHAR(LODG_DUE_DT, 'YYYY-MM-DD hh24:mi:ss') LODG_DUE_DT" ).append("\n"); 
		query.append("    , TO_CHAR(DE_DUE_DT, 'YYYY-MM-DD hh24:mi:ss') DE_DUE_DT" ).append("\n"); 
		query.append("    , TO_CHAR(IB_DEL_DE_DT, 'YYYY-MM-DD hh24:mi:ss') IB_DEL_DE_DT" ).append("\n"); 
		query.append("    , ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("    , ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("    , ORG_SCONTI_CD" ).append("\n"); 
		query.append("    , DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("    , DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("    , DEST_SCONTI_CD" ).append("\n"); 
		query.append("    , decode(@[stop_off_loc_cd], 'on', STOP_OFF_LOC_CD,   null) STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("    , decode(@[stop_off_loc_cd], 'on', STOP_OFF_CNTC_PSON_NM,  null) STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("    , decode(@[stop_off_loc_cd], 'on', STOP_OFF_CNTC_PHN_NO,   null) STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("    , decode(@[stop_off_loc_cd], 'on', STOP_OFF_DIFF_RMK,      null) STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("    , SLS_RHQ_CD" ).append("\n"); 
		query.append("    , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    , BKG_OFC_CD" ).append("\n"); 
		query.append("    , DOC_USR_ID" ).append("\n"); 
		query.append("    , CTRT_OFC_CD" ).append("\n"); 
		query.append("    , CTRT_SREP_CD" ).append("\n"); 
		query.append("    , CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("    , OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    , OB_SREP_CD" ).append("\n"); 
		query.append("    , IB_SLS_OFC_CD" ).append("\n"); 
		query.append("    , EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("    , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,(SELECT POR_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])),'YYYY-MM-DD hh24:mi:ss') BKG_CRE_DT" ).append("\n"); 
		query.append("    , TO_CHAR(PORT_CLZ_DT, 'YYYY-MM-DD hh24:mi:ss') PORT_CLZ_DT" ).append("\n"); 
		query.append("    , CMDT_CD" ).append("\n"); 
		query.append("    , REP_CMDT_CD" ).append("\n"); 
		query.append("    , DCGO_FLG" ).append("\n"); 
		query.append("    , RC_FLG" ).append("\n"); 
		query.append("    , AWK_CGO_FLG" ).append("\n"); 
		query.append("    , BB_CGO_FLG" ).append("\n"); 
		query.append("    , RD_CGO_FLG" ).append("\n"); 
		query.append("    , decode(@[hngr_flg], 'on', HNGR_FLG, 'N') HNGR_FLG" ).append("\n"); 
		query.append("    , decode(@[rail_blk_cd], 'on', RAIL_BLK_CD, null) RAIL_BLK_CD" ).append("\n"); 
		query.append("    , decode(@[prct_flg], 'on', PRCT_FLG, 'N') PRCT_FLG" ).append("\n"); 
		query.append("    , decode(@[spcl_hide_flg], 'on', SPCL_HIDE_FLG, 'N')  SPCL_HIDE_FLG" ).append("\n"); 
		query.append("    , SOC_FLG" ).append("\n"); 
		query.append("    , EQ_SUBST_FLG" ).append("\n"); 
		query.append("    , decode(@[fd_grd_flg], 'on', FD_GRD_FLG, 'N') FD_GRD_FLG" ).append("\n"); 
		query.append("    , FLEX_HGT_FLG" ).append("\n"); 
		query.append("    , decode(@[stwg_cd], 'on', STWG_CD, null) STWG_CD" ).append("\n"); 
		query.append("    , decode(@[stwg_cd], 'on', STWG_RMK, null) STWG_RMK" ).append("\n"); 
		query.append("    , BLCK_STWG_CD" ).append("\n"); 
		query.append("    , ALL_MTR_FLG" ).append("\n"); 
		query.append("    , DBL_BKG_FLG" ).append("\n"); 
		query.append("    , AP_BROG_FLG" ).append("\n"); 
		query.append("    , CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("    , KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("    , SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("    , ALT_CUST_CFM_FLG" ).append("\n"); 
		query.append("    , WT_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append("    , WT_RSN_HLD_FLG" ).append("\n"); 
		query.append("    , 'N' SHP_BAK_FLG" ).append("\n"); 
		query.append("    , MNL_BKG_NO_FLG" ).append("\n"); 
		query.append("    , BL_ISS_BLCK_FLG" ).append("\n"); 
		query.append("    , TO_CHAR(CA_INSP_DUE_DT, 'YYYY-MM-DD hh24:mi:ss') CA_INSP_DUE_DT" ).append("\n"); 
		query.append("    , SCAC_CD" ).append("\n"); 
		query.append("    , CHN_AGN_CD" ).append("\n"); 
		query.append("    , USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("    , CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("    , TWN_SO_NO" ).append("\n"); 
		query.append("    , decode(@[remark], 'on', INTER_RMK, null) INTER_RMK" ).append("\n"); 
		query.append("    , decode(@[remark], 'on', XTER_RMK, null) XTER_RMK" ).append("\n"); 
		query.append("    , decode(@[remark], 'on', INTER_RMK_AUD_FLG, 'N') INTER_RMK_AUD_FLG" ).append("\n"); 
		query.append("    , 'Y' SPLIT_FLG" ).append("\n"); 
		query.append("    , HCMT_CMB_FLG HCMT_CMB_FLG" ).append("\n"); 
		query.append("    , 'S' BKG_CRE_TP_CD" ).append("\n"); 
		query.append("    , null TO_BKG_NO" ).append("\n"); 
		query.append("    , @[bkg_no] FM_BKG_NO" ).append("\n"); 
		query.append("    , ADV_SHTG_CD ADV_SHTG_CD" ).append("\n"); 
		query.append("    , null SPLIT_RSN_CD" ).append("\n"); 
		query.append("    , (SPLIT_RTO/TO_NUMBER(@[splitcount])) SPLIT_RTO" ).append("\n"); 
		query.append("    , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC((SELECT OFC_CD FROM COM_USER USR WHERE USR.USR_ID = @[usr_id]))),'YYYY-MM-DD hh24:mi:ss') SPLIT_DT" ).append("\n"); 
		query.append("    , SC_NO " ).append("\n"); 
		query.append("    , RFA_NO" ).append("\n"); 
		query.append("    , TAA_NO" ).append("\n"); 
		query.append("    , AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("    , AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("    , MTY_CRE_SVR_CD" ).append("\n"); 
		query.append("    , MTY_BKG_STS_CD" ).append("\n"); 
		query.append("    , MTY_POD_FLG" ).append("\n"); 
		query.append("    , MTY_PRE_VVD_FLG" ).append("\n"); 
		query.append("    , MTY_PORT_FLG" ).append("\n"); 
		query.append("    , MTY_SPLIT_AVAL_CD" ).append("\n"); 
		query.append("    , XTER_BKG_RQST_CD" ).append("\n"); 
		query.append("    , NULL XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append("    , SI_FLG" ).append("\n"); 
		query.append("    , XTER_SI_CD" ).append("\n"); 
		query.append("    , NULL XTER_SI_REF_NO" ).append("\n"); 
		query.append("    , XTER_RQST_AUTO_NTC_FLG" ).append("\n"); 
		query.append("	, @[edi_hld_flg] EDI_HLD_FLG" ).append("\n"); 
		query.append("    , XTER_BKG_KNT" ).append("\n"); 
		query.append("    , XTER_SI_KNT" ).append("\n"); 
		query.append("    , XTER_RQST_CUST_RMK" ).append("\n"); 
		query.append("    , 0 OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("    , MY_FWRD_CD" ).append("\n"); 
		query.append("    , MY_FWRD_VSL_DESC" ).append("\n"); 
		query.append("    , PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("    , PST_RLY_PORT_CD" ).append("\n"); 
		query.append("	, PCTL_NO" ).append("\n"); 
		query.append("    , @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("    , sysdate CRE_DT " ).append("\n"); 
		query.append("    , @[usr_id] UPD_USR_ID " ).append("\n"); 
		query.append("    , sysdate UPD_DT " ).append("\n"); 
		query.append("    , ALOC_STS_CD" ).append("\n"); 
		query.append("    , ALOC_SVC_CD" ).append("\n"); 
		query.append("    , BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("    , decode(@[spcl_hide_lnr_flg], 'on', SPCL_HIDE_LNR_FLG, 'N')  SPCL_HIDE_LNR_FLG" ).append("\n"); 
		query.append("    , decode(@[fumg_loc_cd], 'on', FUMG_LOC_CD,   null) FUMG_LOC_CD" ).append("\n"); 
		query.append("    , decode(@[fumg_loc_cd], 'on', FUMG_CNTC_PSON_NM,  null) FUMG_CNTC_PSON_NM" ).append("\n"); 
		query.append("    , decode(@[fumg_loc_cd], 'on', FUMG_CNTC_PHN_NO,   null) FUMG_CNTC_PHN_NO" ).append("\n"); 
		query.append("    , decode(@[fumg_loc_cd], 'on', FUMG_DIFF_RMK,      null) FUMG_DIFF_RMK" ).append("\n"); 
		query.append("    , CRR_SOC_FLG" ).append("\n"); 
		query.append("    , NON_RT_STS_CD" ).append("\n"); 
		query.append("    , decode(@[veh_cmdt_flg], 'on', VEH_CMDT_FLG, 'N') VEH_CMDT_FLG" ).append("\n"); 
		query.append("    , IDA_HLG_TP_CD" ).append("\n"); 
		query.append("    , NON_DG_CHEM_FLG" ).append("\n"); 
		query.append("  from bkg_booking" ).append("\n"); 
		query.append(" where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}