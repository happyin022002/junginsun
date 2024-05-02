/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.23
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.05.23 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingBkgAwkCgo
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_rt_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_void_slt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_bkwd_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ga_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_lf_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_fwrd_len",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_AWK_CGO_HIS SET " ).append("\n"); 
		query.append(" 	CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD          = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	CMDT_CD               = @[cmdt_cd]" ).append("\n"); 
		query.append(",	TTL_DIM_LEN           = @[ttl_dim_len]" ).append("\n"); 
		query.append(",	TTL_DIM_WDT           = @[ttl_dim_wdt]" ).append("\n"); 
		query.append(",	TTL_DIM_HGT           = @[ttl_dim_hgt]" ).append("\n"); 
		query.append(",	GRS_WGT               = @[grs_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD             = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	PCK_QTY               = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD             = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	NET_WGT               = @[net_wgt]" ).append("\n"); 
		query.append(",	STWG_RQST_DESC        = REPLACE(REPLACE(REPLACE(@[stwg_rqst_desc], CHR(13)||CHR(10), ' '), CHR(13), ' '), CHR(10), ' ')" ).append("\n"); 
		query.append(",	UPD_USR_ID 			  = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT 				  = SYSDATE" ).append("\n"); 
		query.append(",	OVR_FWRD_LEN		  = @[ovr_fwrd_len]" ).append("\n"); 
		query.append(",	OVR_BKWD_LEN		  = @[ovr_bkwd_len]" ).append("\n"); 
		query.append(",	OVR_HGT				  = @[ovr_hgt]" ).append("\n"); 
		query.append(",	OVR_LF_LEN			  = @[ovr_lf_len]" ).append("\n"); 
		query.append(",	OVR_RT_LEN			  = @[ovr_rt_len]" ).append("\n"); 
		query.append(",	OVR_VOID_SLT_QTY	  = @[ovr_void_slt_qty]	" ).append("\n"); 
		query.append(",	IN_GA_FLG			  = @[in_ga_flg]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	AWK_CGO_SEQ = @[awk_cgo_seq]" ).append("\n"); 
		query.append("AND NVL(SPCL_CGO_APRO_CD,' ') NOT IN ('R', 'Y', 'N')" ).append("\n"); 
		query.append("AND	CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_AWK_CGO SET " ).append("\n"); 
		query.append(" 	CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD          = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	CMDT_CD               = @[cmdt_cd]" ).append("\n"); 
		query.append(",	TTL_DIM_LEN           = @[ttl_dim_len]" ).append("\n"); 
		query.append(",	TTL_DIM_WDT           = @[ttl_dim_wdt]" ).append("\n"); 
		query.append(",	TTL_DIM_HGT           = @[ttl_dim_hgt]" ).append("\n"); 
		query.append(",	GRS_WGT               = @[grs_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD             = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	PCK_QTY               = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD             = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	NET_WGT               = @[net_wgt]" ).append("\n"); 
		query.append(",	STWG_RQST_DESC        = REPLACE(REPLACE(REPLACE(@[stwg_rqst_desc], CHR(13)||CHR(10), ' '), CHR(13), ' '), CHR(10), ' ')" ).append("\n"); 
		query.append(",	UPD_USR_ID 			  = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT 				  = SYSDATE" ).append("\n"); 
		query.append(",	OVR_FWRD_LEN		  = @[ovr_fwrd_len]" ).append("\n"); 
		query.append(",	OVR_BKWD_LEN		  = @[ovr_bkwd_len]" ).append("\n"); 
		query.append(",	OVR_HGT				  = @[ovr_hgt]" ).append("\n"); 
		query.append(",	OVR_LF_LEN			  = @[ovr_lf_len]" ).append("\n"); 
		query.append(",	OVR_RT_LEN			  = @[ovr_rt_len]" ).append("\n"); 
		query.append(",	OVR_VOID_SLT_QTY	  = @[ovr_void_slt_qty]	" ).append("\n"); 
		query.append(",	IN_GA_FLG			  = @[in_ga_flg]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND NVL(SPCL_CGO_APRO_CD,' ') NOT IN ('R', 'Y', 'N')" ).append("\n"); 
		query.append("AND	AWK_CGO_SEQ = @[awk_cgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}