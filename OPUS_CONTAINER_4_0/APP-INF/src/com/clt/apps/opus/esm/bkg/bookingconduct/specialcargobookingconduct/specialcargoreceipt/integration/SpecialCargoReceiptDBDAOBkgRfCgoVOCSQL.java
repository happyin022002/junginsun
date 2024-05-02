/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgRfCgoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOBkgRfCgoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRfCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgRfCgoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pwr_spl_cbl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("modi_atms_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_atms_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("humid_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_drn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_apro_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oxgn_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sns_cgo_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crbn_dxd_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOBkgRfCgoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_RF_CGO_HIS (" ).append("\n"); 
		query.append("	CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	FDO_TEMP" ).append("\n"); 
		query.append(",	CDO_TEMP" ).append("\n"); 
		query.append(",	CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(",	VENT_RTO" ).append("\n"); 
		query.append(",	HUMID_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	RF_DCGO_SEQ" ).append("\n"); 
		query.append(",	PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(",	VLTG_NO" ).append("\n"); 
		query.append(",	CTRL_ATMS_FLG" ).append("\n"); 
		query.append(",	MODI_ATMS_FLG" ).append("\n"); 
		query.append(",	HUMID_CTRL_FLG" ).append("\n"); 
		query.append(",	CNTR_DRN_CD" ).append("\n"); 
		query.append(",	CLNG_TP_CD" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CORR_NO" ).append("\n"); 
		query.append(",	SNS_CGO_KND_CD" ).append("\n"); 
		query.append(",	OXGN_RTO" ).append("\n"); 
		query.append(",	CRBN_DXD_RTO" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cntr_vol_qty]" ).append("\n"); 
		query.append(",	@[cbm_per_hr_qty]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[cmdt_desc]" ).append("\n"); 
		query.append(",	@[fdo_temp]" ).append("\n"); 
		query.append(",	@[cdo_temp]" ).append("\n"); 
		query.append(",	@[cntr_vent_tp_cd]" ).append("\n"); 
		query.append(",	@[vent_rto]" ).append("\n"); 
		query.append(",	@[humid_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[rf_dcgo_seq]" ).append("\n"); 
		query.append(",	@[pwr_spl_cbl_flg]" ).append("\n"); 
		query.append(",	@[vltg_no]" ).append("\n"); 
		query.append(",	@[ctrl_atms_flg]" ).append("\n"); 
		query.append(",	@[modi_atms_flg]" ).append("\n"); 
		query.append(",	@[humid_ctrl_flg]" ).append("\n"); 
		query.append(",	@[cntr_drn_cd]" ).append("\n"); 
		query.append(",	@[clng_tp_cd]" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	'TMP0000001'" ).append("\n"); 
		query.append(",	@[sns_cgo_knd_cd]" ).append("\n"); 
		query.append(",	@[oxgn_rto]" ).append("\n"); 
		query.append(",	@[crbn_dxd_rto]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO BKG_RF_CGO (" ).append("\n"); 
		query.append("	CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	CBM_PER_HR_QTY" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	FDO_TEMP" ).append("\n"); 
		query.append(",	CDO_TEMP" ).append("\n"); 
		query.append(",	CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(",	VENT_RTO" ).append("\n"); 
		query.append(",	HUMID_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	RF_DCGO_SEQ" ).append("\n"); 
		query.append(",	PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(",	VLTG_NO" ).append("\n"); 
		query.append(",	CTRL_ATMS_FLG" ).append("\n"); 
		query.append(",	MODI_ATMS_FLG" ).append("\n"); 
		query.append(",	HUMID_CTRL_FLG" ).append("\n"); 
		query.append(",	CNTR_DRN_CD" ).append("\n"); 
		query.append(",	CLNG_TP_CD" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	SNS_CGO_KND_CD" ).append("\n"); 
		query.append(",	OXGN_RTO" ).append("\n"); 
		query.append(",	CRBN_DXD_RTO" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cntr_vol_qty]" ).append("\n"); 
		query.append(",	@[cbm_per_hr_qty]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[cmdt_desc]" ).append("\n"); 
		query.append(",	@[fdo_temp]" ).append("\n"); 
		query.append(",	@[cdo_temp]" ).append("\n"); 
		query.append(",	@[cntr_vent_tp_cd]" ).append("\n"); 
		query.append(",	@[vent_rto]" ).append("\n"); 
		query.append(",	@[humid_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[rf_dcgo_seq]" ).append("\n"); 
		query.append(",	@[pwr_spl_cbl_flg]" ).append("\n"); 
		query.append(",	@[vltg_no]" ).append("\n"); 
		query.append(",	@[ctrl_atms_flg]" ).append("\n"); 
		query.append(",	@[modi_atms_flg]" ).append("\n"); 
		query.append(",	@[humid_ctrl_flg]" ).append("\n"); 
		query.append(",	@[cntr_drn_cd]" ).append("\n"); 
		query.append(",	@[clng_tp_cd]" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[sns_cgo_knd_cd]" ).append("\n"); 
		query.append(",	@[oxgn_rto]" ).append("\n"); 
		query.append(",	@[crbn_dxd_rto]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}