/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgRfCgoVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.04.27 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOBkgRfCgoVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRfCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgRfCgoVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pwr_spl_cbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbm_per_hr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vent_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sns_cgo_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_atms_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vltg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oxgn_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("humid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("humid_ctrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_atms_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crbn_dxd_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vent_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOBkgRfCgoVOUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_RF_CGO_HIS SET " ).append("\n"); 
		query.append("	CNTR_VOL_QTY = @[cntr_vol_qty]" ).append("\n"); 
		query.append(",	CBM_PER_HR_QTY = @[cbm_per_hr_qty]" ).append("\n"); 
		query.append(",	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(",	RC_SEQ = @[rc_seq]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(",	PCK_TP_CD = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	PCK_QTY = @[pck_qty]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append(",	CMDT_DESC = @[cmdt_desc]" ).append("\n"); 
		query.append(",	FDO_TEMP = @[fdo_temp]" ).append("\n"); 
		query.append(",	CDO_TEMP = @[cdo_temp]" ).append("\n"); 
		query.append(",	CNTR_VENT_TP_CD = @[cntr_vent_tp_cd]" ).append("\n"); 
		query.append(",	VENT_RTO = @[vent_rto]" ).append("\n"); 
		query.append(",	HUMID_NO = @[humid_no]" ).append("\n"); 
		query.append(",	DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append(",	RF_DCGO_SEQ = @[rf_dcgo_seq]" ).append("\n"); 
		query.append(",	PWR_SPL_CBL_FLG = @[pwr_spl_cbl_flg]" ).append("\n"); 
		query.append(",	VLTG_NO = @[vltg_no]" ).append("\n"); 
		query.append(",	CTRL_ATMS_FLG = @[ctrl_atms_flg]" ).append("\n"); 
		query.append(",	MODI_ATMS_FLG = @[modi_atms_flg]" ).append("\n"); 
		query.append(",	HUMID_CTRL_FLG = @[humid_ctrl_flg]" ).append("\n"); 
		query.append(",	CNTR_DRN_CD = @[cntr_drn_cd]" ).append("\n"); 
		query.append(",	CLNG_TP_CD = @[clng_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append(",	SNS_CGO_KND_CD = @[sns_cgo_knd_cd]" ).append("\n"); 
		query.append(",	OXGN_RTO = @[oxgn_rto]" ).append("\n"); 
		query.append(",	CRBN_DXD_RTO = @[crbn_dxd_rto]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	RC_SEQ = @[rc_seq]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_RF_CGO SET " ).append("\n"); 
		query.append("	CNTR_VOL_QTY = @[cntr_vol_qty]" ).append("\n"); 
		query.append(",	CBM_PER_HR_QTY = @[cbm_per_hr_qty]" ).append("\n"); 
		query.append(",	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(",	RC_SEQ = @[rc_seq]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(",	PCK_TP_CD = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	PCK_QTY = @[pck_qty]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append(",	CMDT_DESC = @[cmdt_desc]" ).append("\n"); 
		query.append(",	FDO_TEMP = @[fdo_temp]" ).append("\n"); 
		query.append(",	CDO_TEMP = @[cdo_temp]" ).append("\n"); 
		query.append(",	CNTR_VENT_TP_CD = @[cntr_vent_tp_cd]" ).append("\n"); 
		query.append(",	VENT_RTO = @[vent_rto]" ).append("\n"); 
		query.append(",	HUMID_NO = @[humid_no]" ).append("\n"); 
		query.append(",	DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append(",	RF_DCGO_SEQ = @[rf_dcgo_seq]" ).append("\n"); 
		query.append(",	PWR_SPL_CBL_FLG = @[pwr_spl_cbl_flg]" ).append("\n"); 
		query.append(",	VLTG_NO = @[vltg_no]" ).append("\n"); 
		query.append(",	CTRL_ATMS_FLG = @[ctrl_atms_flg]" ).append("\n"); 
		query.append(",	MODI_ATMS_FLG = @[modi_atms_flg]" ).append("\n"); 
		query.append(",	HUMID_CTRL_FLG = @[humid_ctrl_flg]" ).append("\n"); 
		query.append(",	CNTR_DRN_CD = @[cntr_drn_cd]" ).append("\n"); 
		query.append(",	CLNG_TP_CD = @[clng_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append(",	SNS_CGO_KND_CD = @[sns_cgo_knd_cd]" ).append("\n"); 
		query.append(",	OXGN_RTO = @[oxgn_rto]" ).append("\n"); 
		query.append(",	CRBN_DXD_RTO = @[crbn_dxd_rto]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	RC_SEQ = @[rc_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}