/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOInsertEDIMessageForGateNewCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOInsertEDIMessageForGateNewCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOInsertEDIMessageForGateNewCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_io",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("muid_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_vrfy_ord_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hanger_tag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("result_indicator",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("muid_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vessel",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("way_bill_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_number0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voyage",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sight_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_sts_tp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("result_message",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_pty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stowage",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_sig_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flat_car_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("muid_area",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sign_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cont_stat",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_vrfy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pickup_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_count",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ffile_rref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOInsertEDIMessageForGateNewCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MVMT_EDI_MSG (" ).append("\n"); 
		query.append("  MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("  TML_NM," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  EVNT_YD_CD," ).append("\n"); 
		query.append("  EVNT_DT," ).append("\n"); 
		query.append("  EDI_GATE_IO_CD," ).append("\n"); 
		query.append("  CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("  CHSS_NO," ).append("\n"); 
		query.append("  CRNT_VSL_CD," ).append("\n"); 
		query.append("  CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("  CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("  EDI_BL_NO," ).append("\n"); 
		query.append("  BKG_KNT," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  BKG_POL_CD," ).append("\n"); 
		query.append("  BKG_POD_CD," ).append("\n"); 
		query.append("  DEST_YD_CD," ).append("\n"); 
		query.append("  CNTR_SEAL_NO," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("  FCAR_NO," ).append("\n"); 
		query.append("  EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("  CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("  WBL_NO," ).append("\n"); 
		query.append("  PKUP_NO," ).append("\n"); 
		query.append("  MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("  MVMT_EDI_RMK," ).append("\n"); 
		query.append("  RTY_KNT," ).append("\n"); 
		query.append("  MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("  CNTR_DMG_FLG," ).append("\n"); 
		query.append("  CALL_SGN_NO," ).append("\n"); 
		query.append("  LLOYD_NO," ).append("\n"); 
		query.append("  MVMT_EDI_STS_TP_FLG," ).append("\n"); 
		query.append("  OFC_CD," ).append("\n"); 
		query.append("  CNMV_CO_CD," ).append("\n"); 
		query.append("  FLT_FILE_REF_NO," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  CRE_LOCL_DT," ).append("\n"); 
		query.append("  UPD_DT," ).append("\n"); 
		query.append("  UPD_LOCL_DT," ).append("\n"); 
		query.append("  IDX_CRE_LOCL_DT," ).append("\n"); 
		query.append("  IDX_EVNT_DT," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  EDI_BKG_NO," ).append("\n"); 
		query.append("  CNTR_STWG_NO," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  VGM_WGT_UT_CD," ).append("\n"); 
		query.append("  VGM_WGT_QTY," ).append("\n"); 
		query.append("  VGM_VRFY_DT," ).append("\n"); 
		query.append("  VGM_SIG_CTNT," ).append("\n"); 
		query.append("  VGM_REF_NO," ).append("\n"); 
		query.append("  VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("  VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("  @[edi_id]," ).append("\n"); 
		query.append("  @[msg_id]," ).append("\n"); 
		query.append("  @[muid_area]," ).append("\n"); 
		query.append("  @[muid_dt]," ).append("\n"); 
		query.append("  @[muid_seq]," ).append("\n"); 
		query.append("  @[term_id]," ).append("\n"); 
		query.append("  @[cntr_number]," ).append("\n"); 
		query.append("  @[event_yard]," ).append("\n"); 
		query.append("  TO_DATE (@[event_date], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("  @[gate_io]," ).append("\n"); 
		query.append("  @[cont_stat]," ).append("\n"); 
		query.append("  @[chss_code]," ).append("\n"); 
		query.append("  @[vessel]," ).append("\n"); 
		query.append("  @[voyage]," ).append("\n"); 
		query.append("  @[dir]," ).append("\n"); 
		query.append("  @[bl_no]," ).append("\n"); 
		query.append("  @[bkg_count]," ).append("\n"); 
		query.append("  @[bkg_number0]," ).append("\n"); 
		query.append("  @[pol]," ).append("\n"); 
		query.append("  @[pod]," ).append("\n"); 
		query.append("  @[dest_loc]," ).append("\n"); 
		query.append("  @[seal_no]," ).append("\n"); 
		query.append("  @[vndr_seq]," ).append("\n"); 
		query.append("  @[trans_mode]," ).append("\n"); 
		query.append("  @[flat_car_nbr]," ).append("\n"); 
		query.append("  @[mvmt_status]," ).append("\n"); 
		query.append("  @[hanger_tag]," ).append("\n"); 
		query.append("  @[way_bill_no]," ).append("\n"); 
		query.append("  @[pickup_no]," ).append("\n"); 
		query.append("  @[result_indicator]," ).append("\n"); 
		query.append("  REPLACE (@[result_message], '^#^', CHR(39)), /* 2010 @F_DB_CHECK Return Value */" ).append("\n"); 
		query.append("  0," ).append("\n"); 
		query.append("  @[sight_cd]," ).append("\n"); 
		query.append("  @[dmg_flag]," ).append("\n"); 
		query.append("  @[call_sign_no]," ).append("\n"); 
		query.append("  @[lloyd_no]," ).append("\n"); 
		query.append("  @[mvmt_edi_sts_tp_flg]," ).append("\n"); 
		query.append("  SUBSTR (@[event_yard], 1, 5)," ).append("\n"); 
		query.append("  'SML'," ).append("\n"); 
		query.append("  @[ffile_rref_no]," ).append("\n"); 
		query.append("  @[user_id]," ).append("\n"); 
		query.append("  @[user_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, DECODE (@[event_yard], '', DECODE (@[muid_area], 'USA', 'USNYC', 'KOR', 'KRSEL', 'CHN', 'CHSHA', 'SWA', 'SGSIN', 'EUR', 'DEHAM', ''), SUBSTR(@[event_yard], 1, 5)))," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, DECODE (@[event_yard], '', DECODE (@[muid_area], 'USA', 'USNYC', 'KOR', 'KRSEL', 'CHN', 'CHSHA', 'SWA', 'SGSIN', 'EUR', 'DEHAM', ''), SUBSTR(@[event_yard], 1, 5)))," ).append("\n"); 
		query.append("  SUBSTR (TO_CHAR (GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, DECODE (@[event_yard], '', DECODE (@[muid_area], 'USA', 'USNYC', 'KOR', 'KRSEL', 'CHN', 'CHSHA', 'SWA', 'SGSIN', 'EUR', 'DEHAM', ''), SUBSTR(@[event_yard], 1, 5))), 'YYYYMMDDHH24MISS'), 1, 8)," ).append("\n"); 
		query.append("  SUBSTR (@[event_date], 1, 8)," ).append("\n"); 
		query.append("  @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("  @[edi_bkg_no]," ).append("\n"); 
		query.append("  @[stowage]," ).append("\n"); 
		query.append("  @[vgm_mzd_tp_cd]," ).append("\n"); 
		query.append("  @[vgm_wgt_ut_cd]," ).append("\n"); 
		query.append("  TO_NUMBER(@[vgm_wgt_qty])," ).append("\n"); 
		query.append("  TO_DATE(@[vgm_vrfy_dt], 'YYYYMMDDHH24MI')," ).append("\n"); 
		query.append("  @[vgm_sig_ctnt]," ).append("\n"); 
		query.append("  @[vgm_ref_no]," ).append("\n"); 
		query.append("  @[vgm_wgt_pty_ctnt]," ).append("\n"); 
		query.append("  @[vgm_vrfy_ord_ctnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}