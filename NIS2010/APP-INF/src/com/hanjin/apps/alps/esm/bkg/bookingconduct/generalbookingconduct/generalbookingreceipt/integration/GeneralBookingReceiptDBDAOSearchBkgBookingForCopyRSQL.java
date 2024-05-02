/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgBookingForCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.28 
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

public class GeneralBookingReceiptDBDAOSearchBkgBookingForCopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ui에서 check한 Stowage,Stop Off Cargo,Rail Bulk,Hide,Food Grade,Precaution,Remark에 따라 조회하는 항목을 공백으로 바꾼다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgBookingForCopyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stop_off_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trunk_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stowage_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bulk_rail_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fd_grd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgBookingForCopyRSQL").append("\n"); 
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
		query.append("	 '' BKG_NO" ).append("\n"); 
		query.append("	,'' BL_NO" ).append("\n"); 
		query.append("	,'0' BL_NO_TP" ).append("\n"); 
		query.append("	,'' BL_TP_CD" ).append("\n"); 
		query.append("	,DECODE(NVL(@[dcgo_flg]||@[rc_flg]||@[awk_cgo_flg]||@[bb_cgo_flg], 'N'), 'N', 'F', 'W') BKG_STS_CD" ).append("\n"); 
		query.append("	,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("		SELECT 	VSL_SLAN_CD " ).append("\n"); 
		query.append("		FROM 	VSK_VSL_SKD" ).append("\n"); 
		query.append("	 	WHERE 	VSL_CD = SUBSTR(@[bkg_trunk_vvd], 1, 4) " ).append("\n"); 
		query.append("		AND 	SKD_VOY_NO = SUBSTR(@[bkg_trunk_vvd], 5, 4) " ).append("\n"); 
		query.append("        AND 	SKD_DIR_CD = SUBSTR(@[bkg_trunk_vvd], 9, 1) " ).append("\n"); 
		query.append("		AND 	ROWNUM = 1" ).append("\n"); 
		query.append("	) SLAN_CD" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("	,SUBSTR(@[bkg_trunk_vvd], 1, 4) VSL_CD" ).append("\n"); 
		query.append("	,SUBSTR(@[bkg_trunk_vvd], 5, 4) SKD_VOY_NO" ).append("\n"); 
		query.append("	,SUBSTR(@[bkg_trunk_vvd], 9, 1) SKD_DIR_CD" ).append("\n"); 
		query.append("	,REV_DIR_CD" ).append("\n"); 
		query.append("	,RCV_TERM_CD" ).append("\n"); 
		query.append("	,DE_TERM_CD" ).append("\n"); 
		query.append("	,POR_CD" ).append("\n"); 
		query.append("	,POR_NOD_CD" ).append("\n"); 
		query.append("	,POL_CD" ).append("\n"); 
		query.append("	,POL_NOD_CD" ).append("\n"); 
		query.append("	,POD_CD" ).append("\n"); 
		query.append("	,POD_NOD_CD" ).append("\n"); 
		query.append("	,OCP_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,DEL_NOD_CD" ).append("\n"); 
		query.append("	,FNL_DEST_CD" ).append("\n"); 
		query.append("	,'' POL_ETD_DT" ).append("\n"); 
		query.append("	,'' POD_ETA_DT" ).append("\n"); 
		query.append("	,MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("	,TO_CHAR(MTY_PKUP_DT,'YYYY-MM-DD HH24:MI:SS') MTY_PKUP_DT" ).append("\n"); 
		query.append("	,FULL_RTN_YD_CD" ).append("\n"); 
		query.append("	,FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("	,MTY_RTN_YD_CD" ).append("\n"); 
		query.append("	,TO_CHAR(MTY_DOR_ARR_DT,'YYYY-MM-DD HH24:MI:SS') MTY_DOR_ARR_DT" ).append("\n"); 
		query.append("	,TO_CHAR(LODG_DUE_DT,'YYYY-MM-DD HH24:MI:SS') LODG_DUE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(DE_DUE_DT,'YYYY-MM-DD HH24:MI:SS') DE_DUE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(IB_DEL_DE_DT,'YYYY-MM-DD HH24:MI:SS') IB_DEL_DE_DT" ).append("\n"); 
		query.append("	,ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("	,ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("	,ORG_SCONTI_CD" ).append("\n"); 
		query.append("	,DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("	,DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("	,DEST_SCONTI_CD" ).append("\n"); 
		query.append("	,DECODE(@[stop_off_flg],'Y',STOP_OFF_LOC_CD,'') STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("	,DECODE(@[stop_off_flg],'Y',STOP_OFF_CNTC_PSON_NM,'') STOP_OFF_CNTC_PSON_NM" ).append("\n"); 
		query.append("	,DECODE(@[stop_off_flg],'Y',STOP_OFF_CNTC_PHN_NO,'') STOP_OFF_CNTC_PHN_NO" ).append("\n"); 
		query.append("	,DECODE(@[stop_off_flg],'Y',STOP_OFF_DIFF_RMK,'') STOP_OFF_DIFF_RMK" ).append("\n"); 
		query.append("	,SLS_RHQ_CD" ).append("\n"); 
		query.append("	,SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("	,@[ofc_cd] BKG_OFC_CD" ).append("\n"); 
		query.append("	,@[usr_id] DOC_USR_ID" ).append("\n"); 
		query.append("	,CTRT_OFC_CD" ).append("\n"); 
		query.append("	,CTRT_SREP_CD" ).append("\n"); 
		query.append("	,CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("	,CTRT_CUST_SEQ" ).append("\n"); 
		query.append("	,OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	,OB_SREP_CD" ).append("\n"); 
		query.append("	,IB_SLS_OFC_CD" ).append("\n"); 
		query.append("	,EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("	,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC((SELECT OFC_CD FROM COM_USER USR WHERE USR.USR_ID = @[usr_id]))),'YYYY-MM-DD HH24:MI:SS') BKG_CRE_DT" ).append("\n"); 
		query.append("	,'' PORT_CLZ_DT" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,REP_CMDT_CD" ).append("\n"); 
		query.append("	,DECODE(@[dcgo_flg],'Y',DCGO_FLG,'N') DCGO_FLG" ).append("\n"); 
		query.append("	,DECODE(@[rc_flg],'Y',RC_FLG,'N') RC_FLG " ).append("\n"); 
		query.append("	,DECODE(@[awk_cgo_flg],'Y',AWK_CGO_FLG,'N') AWK_CGO_FLG" ).append("\n"); 
		query.append("	,DECODE(@[bb_cgo_flg],'Y',BB_CGO_FLG,'N') BB_CGO_FLG" ).append("\n"); 
		query.append("	,RD_CGO_FLG" ).append("\n"); 
		query.append("	,DECODE(@[hngr_flg],'Y',HNGR_FLG,'N') HNGR_FLG" ).append("\n"); 
		query.append("	,DECODE(@[bulk_rail_flg],'Y',RAIL_BLK_CD,'') RAIL_BLK_CD" ).append("\n"); 
		query.append("	,DECODE(@[prct_flg],'Y',PRCT_FLG,'N') PRCT_FLG" ).append("\n"); 
		query.append("	,DECODE(@[spcl_hide_flg],'Y',SPCL_HIDE_FLG,'N') SPCL_HIDE_FLG" ).append("\n"); 
		query.append("	,SOC_FLG" ).append("\n"); 
		query.append("	,EQ_SUBST_FLG" ).append("\n"); 
		query.append("	,DECODE(@[fd_grd_flg],'Y',FD_GRD_FLG,'N') FD_GRD_FLG" ).append("\n"); 
		query.append("	,FLEX_HGT_FLG" ).append("\n"); 
		query.append("	,DECODE(@[stowage_flg],'Y',STWG_CD,'') STWG_CD" ).append("\n"); 
		query.append("	,DECODE(@[stowage_flg],'Y',STWG_RMK,'') STWG_RMK" ).append("\n"); 
		query.append("	,BLCK_STWG_CD" ).append("\n"); 
		query.append("	,ALL_MTR_FLG" ).append("\n"); 
		query.append("	,DBL_BKG_FLG" ).append("\n"); 
		query.append("	,AP_BROG_FLG" ).append("\n"); 
		query.append("	,CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("	,KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("	,SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append("	,ALT_CUST_CFM_FLG" ).append("\n"); 
		query.append("	,decode(instr(nvl(@[dcgo_flg]||@[rc_flg]||@[awk_cgo_flg]||@[bb_cgo_flg], 'N'), 'Y'), 0, 'N', 'Y') WT_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append("	,'N' WT_RSN_HLD_FLG" ).append("\n"); 
		query.append("	,SHP_BAK_FLG" ).append("\n"); 
		query.append("	,MNL_BKG_NO_FLG" ).append("\n"); 
		query.append("	,BL_ISS_BLCK_FLG" ).append("\n"); 
		query.append("	,'' CA_INSP_DUE_DT" ).append("\n"); 
		query.append("	,SCAC_CD" ).append("\n"); 
		query.append("	,CHN_AGN_CD" ).append("\n"); 
		query.append("	,USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("	,CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("	,TWN_SO_NO" ).append("\n"); 
		query.append("	,'' INTER_RMK" ).append("\n"); 
		query.append("	,@[xter_rmk] XTER_RMK" ).append("\n"); 
		query.append("	,'' INTER_RMK_AUD_FLG" ).append("\n"); 
		query.append("	,'N' SPLIT_FLG" ).append("\n"); 
		query.append("	,'N' HCMT_CMB_FLG" ).append("\n"); 
		query.append("	,'C' BKG_CRE_TP_CD" ).append("\n"); 
		query.append("	,'' TO_BKG_NO" ).append("\n"); 
		query.append("	,@[bkg_no] FM_BKG_NO" ).append("\n"); 
		query.append("	,'' ADV_SHTG_CD" ).append("\n"); 
		query.append("	,'' SPLIT_RSN_CD" ).append("\n"); 
		query.append("	,1 SPLIT_RTO" ).append("\n"); 
		query.append("	,@[sc_no] SC_NO" ).append("\n"); 
		query.append("	,@[rfa_no] RFA_NO" ).append("\n"); 
		query.append("	,TAA_NO" ).append("\n"); 
		query.append("	,AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("	,AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("	,MTY_CRE_SVR_CD" ).append("\n"); 
		query.append("	,MTY_BKG_STS_CD" ).append("\n"); 
		query.append("	,MTY_POD_FLG" ).append("\n"); 
		query.append("	,MTY_PRE_VVD_FLG" ).append("\n"); 
		query.append("	,MTY_PORT_FLG" ).append("\n"); 
		query.append("	,MTY_SPLIT_AVAL_CD" ).append("\n"); 
		query.append("	,'NIS' XTER_BKG_RQST_CD" ).append("\n"); 
		query.append("	,'' XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append("	,'N' SI_FLG" ).append("\n"); 
		query.append("	,'' XTER_SI_CD" ).append("\n"); 
		query.append("	,'' XTER_SI_REF_NO" ).append("\n"); 
		query.append("	,XTER_RQST_AUTO_NTC_FLG" ).append("\n"); 
		query.append("	,EDI_HLD_FLG" ).append("\n"); 
		query.append("	,'' XTER_BKG_KNT" ).append("\n"); 
		query.append("	,'' XTER_SI_KNT" ).append("\n"); 
		query.append("	,'' XTER_RQST_CUST_RMK" ).append("\n"); 
		query.append("	,DECODE(@[bb_cgo_flg],'Y', OVR_VOID_SLT_QTY, 0) OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("	,'' MY_FWRD_CD" ).append("\n"); 
		query.append("	,'' MY_FWRD_VSL_DESC" ).append("\n"); 
		query.append("	,PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("	,PST_RLY_PORT_CD" ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE CRE_DT" ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE UPD_DT	" ).append("\n"); 
		query.append("	,DECODE(@[spcl_hide_lnr_flg],'Y',SPCL_HIDE_LNR_FLG,'N') SPCL_HIDE_LNR_FLG" ).append("\n"); 
		query.append("	,DECODE(@[fumg_flg],'Y',FUMG_LOC_CD,'') FUMG_LOC_CD" ).append("\n"); 
		query.append("	,DECODE(@[fumg_flg],'Y',FUMG_CNTC_PSON_NM,'') FUMG_CNTC_PSON_NM" ).append("\n"); 
		query.append("	,DECODE(@[fumg_flg],'Y',FUMG_CNTC_PHN_NO,'') FUMG_CNTC_PHN_NO" ).append("\n"); 
		query.append("	,DECODE(@[fumg_flg],'Y',FUMG_DIFF_RMK,'') FUMG_DIFF_RMK" ).append("\n"); 
		query.append("    ,CRR_SOC_FLG" ).append("\n"); 
		query.append("    ,DECODE(@[veh_cmdt_flg],'Y',VEH_CMDT_FLG,'N') VEH_CMDT_FLG" ).append("\n"); 
		query.append("    ,IDA_HLG_TP_CD" ).append("\n"); 
		query.append("    ,NON_DG_CHEM_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	BKG_BOOKING" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}