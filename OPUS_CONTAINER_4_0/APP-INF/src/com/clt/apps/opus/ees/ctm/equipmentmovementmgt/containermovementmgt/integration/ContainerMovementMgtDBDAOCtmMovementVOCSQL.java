/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCtmMovementVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOCtmMovementVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCtmMovementVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_lvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_unflg_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_cntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_disp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_edi_msg_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usa_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_xch_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCtmMovementVOCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MOVEMENT" ).append("\n"); 
		query.append("            (FCNTR_FLG," ).append("\n"); 
		query.append("             OB_CNTR_FLG," ).append("\n"); 
		query.append("             VNDR_SEQ," ).append("\n"); 
		query.append("             SPCL_CGO_FLG," ).append("\n"); 
		query.append("             BKG_NO," ).append("\n"); 
		query.append("             BKG_KNT," ).append("\n"); 
		query.append("             BL_NO," ).append("\n"); 
		query.append("             CNTR_DISP_FLG," ).append("\n"); 
		query.append("             IMDT_EXT_FLG," ).append("\n"); 
		query.append("             CNTR_XCH_CD," ).append("\n"); 
		query.append("             CNMV_CO_CD," ).append("\n"); 
		query.append("             GMT_DT," ).append("\n"); 
		query.append("             CRE_USR_ID," ).append("\n"); 
		query.append("             UPD_USR_ID," ).append("\n"); 
		query.append("             USR_NM," ).append("\n"); 
		query.append("             CRE_DT," ).append("\n"); 
		query.append("             CRE_LOCL_DT," ).append("\n"); 
		query.append("             UPD_DT," ).append("\n"); 
		query.append("             UPD_LOCL_DT," ).append("\n"); 
		query.append("             CNTR_NO," ).append("\n"); 
		query.append("             CNMV_YR," ).append("\n"); 
		query.append("             CNMV_ID_NO," ).append("\n"); 
		query.append("             CNMV_SEQ," ).append("\n"); 
		query.append("             CNMV_SPLIT_NO," ).append("\n"); 
		query.append("             MVMT_STS_CD," ).append("\n"); 
		query.append("             BKG_CGO_TP_CD," ).append("\n"); 
		query.append("             CNMV_CYC_NO," ).append("\n"); 
		query.append("             CNMV_EVNT_DT," ).append("\n"); 
		query.append("             DEST_YD_CD," ).append("\n"); 
		query.append("             INP_YD_CD," ).append("\n"); 
		query.append("             ORG_YD_CD," ).append("\n"); 
		query.append("             CHSS_NO," ).append("\n"); 
		query.append("             MGST_NO," ).append("\n"); 
		query.append("             CNTR_DMG_FLG," ).append("\n"); 
		query.append("             CRNT_VSL_CD," ).append("\n"); 
		query.append("             CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("             CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("             TRNK_VSL_CD," ).append("\n"); 
		query.append("             TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("             TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("             SYS_AREA_GRP_ID," ).append("\n"); 
		query.append("             OFC_CD," ).append("\n"); 
		query.append("             CNTR_ACT_CD," ).append("\n"); 
		query.append("             CNMV_RMK," ).append("\n"); 
		query.append("             CNTR_SEAL_NO," ).append("\n"); 
		query.append("             CNMV_LVL_NO," ).append("\n"); 
		query.append("             BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("             MVMT_INP_TP_CD," ).append("\n"); 
		query.append("             CTRT_OFC_CTY_CD," ).append("\n"); 
		query.append("             CTRT_SEQ," ).append("\n"); 
		query.append("             MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("             MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("             MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("             MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("             MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("             MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("             PRE_STS_FLG," ).append("\n"); 
		query.append("			 RSTR_USG_LBL_NM_DESC," ).append("\n"); 
		query.append("			 RSTR_USG_LBL_VAL_DESC," ).append("\n"); 
		query.append("			 MTY_PLN_NO," ).append("\n"); 
		query.append("			 DMG_FLG_DT," ).append("\n"); 
		query.append("			 DMG_UNFLG_DT," ).append("\n"); 
		query.append("             CNMV_GDT" ).append("\n"); 
		query.append("             , USA_EDI_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     VALUES (NVL (DECODE (@[fcntr_flg], 'F', 'Y', 'M', 'N', 'E', 'N', @[fcntr_flg]), 'N')," ).append("\n"); 
		query.append("             DECODE (@[ob_cntr_flg], 'O', 'Y', 'I', 'N', @[ob_cntr_flg])," ).append("\n"); 
		query.append("             DECODE (@[vndr_seq], 'null', '', @[vndr_seq])," ).append("\n"); 
		query.append("             NVL (@[spcl_cgo_flg], 'N')," ).append("\n"); 
		query.append("             @[bkg_no]," ).append("\n"); 
		query.append("             @[bkg_knt]," ).append("\n"); 
		query.append("             @[bl_no]," ).append("\n"); 
		query.append("             NVL (@[cntr_disp_flg], 'N')," ).append("\n"); 
		query.append("             NVL (@[imdt_ext_flg], 'N')," ).append("\n"); 
		query.append("             @[cntr_xch_cd]," ).append("\n"); 
		query.append("             COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5 ), SYSDATE, 'GMT')," ).append("\n"); 
		query.append("             @[cre_usr_id]," ).append("\n"); 
		query.append("             @[cre_usr_id]," ).append("\n"); 
		query.append("             @[usr_nm]," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("             SYSDATE," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[org_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("             @[cntr_no]," ).append("\n"); 
		query.append("             @[cnmv_yr]," ).append("\n"); 
		query.append("             @[cnmv_id_no]," ).append("\n"); 
		query.append("             @[cnmv_seq]," ).append("\n"); 
		query.append("             NVL (@[cnmv_split_no], ' ')," ).append("\n"); 
		query.append("             @[mvmt_sts_cd]," ).append("\n"); 
		query.append("             @[bkg_cgo_tp_cd]," ).append("\n"); 
		query.append("             @[cnmv_cyc_no]," ).append("\n"); 
		query.append("             TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("             @[dest_yd_cd]," ).append("\n"); 
		query.append("             NVL (@[org_yd_cd], '')," ).append("\n"); 
		query.append("             @[org_yd_cd]," ).append("\n"); 
		query.append("             @[chss_no]," ).append("\n"); 
		query.append("             @[mgst_no]," ).append("\n"); 
		query.append("             NVL (@[cntr_dmg_flg], 'N')," ).append("\n"); 
		query.append("             @[crnt_vsl_cd]," ).append("\n"); 
		query.append("             DECODE (@[crnt_skd_voy_no], 'null', '', @[crnt_skd_voy_no])," ).append("\n"); 
		query.append("             DECODE (@[crnt_skd_dir_cd], 'null', '', @[crnt_skd_dir_cd])," ).append("\n"); 
		query.append("             DECODE (@[trnk_vsl_cd], 'null', '', @[trnk_vsl_cd])," ).append("\n"); 
		query.append("             DECODE (@[trnk_skd_voy_no], 'null', '', @[trnk_skd_voy_no])," ).append("\n"); 
		query.append("             DECODE (@[trnk_skd_dir_cd], 'null', '', @[trnk_skd_dir_cd])," ).append("\n"); 
		query.append("             @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("             @[mvmt_cre_tp_cd]," ).append("\n"); 
		query.append("             @[cntr_svr_id]," ).append("\n"); 
		query.append("             @[ofc_cd]," ).append("\n"); 
		query.append("             DECODE (@[mvmt_sts_cd], 'XX', 'I', 'A')," ).append("\n"); 
		query.append("             @[cnmv_rmk]," ).append("\n"); 
		query.append("             @[cntr_seal_no]," ).append("\n"); 
		query.append("             @[cnmv_lvl_no]," ).append("\n"); 
		query.append("             @[bkg_rcv_term_cd]," ).append("\n"); 
		query.append("             @[mvmt_inp_tp_cd]," ).append("\n"); 
		query.append("             @[ctrt_ofc_cty_cd]," ).append("\n"); 
		query.append("             @[ctrt_seq]," ).append("\n"); 
		query.append("             @[mvmt_trsp_mod_cd]," ).append("\n"); 
		query.append("             @[mvmt_edi_tp_cd]," ).append("\n"); 
		query.append("             @[mvmt_edi_msg_tp_id]," ).append("\n"); 
		query.append("             @[mvmt_edi_msg_area_cd]," ).append("\n"); 
		query.append("             @[mvmt_edi_msg_yrmondy]," ).append("\n"); 
		query.append("             @[mvmt_edi_msg_seq]," ).append("\n"); 
		query.append("             DECODE (@[pre_sts_flg], NULL, 'N', @[pre_sts_flg])," ).append("\n"); 
		query.append("			 MST_COMMON_PKG.MST_RU_TP_GET_FNC(@[cntr_no])," ).append("\n"); 
		query.append("			 MST_COMMON_PKG.MST_RU_VAL_GET_FNC(@[cntr_no])," ).append("\n"); 
		query.append("			 @[mty_pln_no]," ).append("\n"); 
		query.append("			 NVL(TO_DATE (@[dmg_flg_dt], 'YYYY-MM-DD HH24:MI'),'')," ).append("\n"); 
		query.append("			 NVL(TO_DATE (@[dmg_unflg_dt], 'YYYY-MM-DD HH24:MI'),'')," ).append("\n"); 
		query.append("             GLOBALDATE_PKG.TIME_CONV_FNC (SUBSTR (@[org_yd_cd], 0, 5 ), TO_DATE (@[cnmv_evnt_dt], 'YYYY-MM-DD HH24:MI'), 'GMT' )" ).append("\n"); 
		query.append("             , @[usa_edi_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}