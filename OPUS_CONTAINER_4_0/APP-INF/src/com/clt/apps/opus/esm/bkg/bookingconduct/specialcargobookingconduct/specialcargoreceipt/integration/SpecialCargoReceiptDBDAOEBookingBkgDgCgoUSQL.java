/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.23
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.23 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingBkgDgCgo
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_phn_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_pnt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_segr_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_DG_CGO_HIS SET " ).append("\n"); 
		query.append("	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ = @[dg_cntr_seq]" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ = @[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	PRP_SHP_NM = @[prp_shp_nm]" ).append("\n"); 
		query.append(",	HZD_DESC = @[hzd_desc]" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP = @[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG = @[mrn_polut_flg]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM = @[emer_cntc_pnt_ctnt]" ).append("\n"); 
		query.append(",	EMER_CNTC_PHN_NO_CTNT = @[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(",	DCGO_STS_CD = @[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG = @[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC = @[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	EMS_NO = (SELECT MAX(IMDG_EMER_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO = (SELECT MAX(EMER_RSPN_GID_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO = (SELECT MAX(EMER_RSPN_GID_CHR_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",	IMDG_AMDT_NO = @[imdg_amdt_no]" ).append("\n"); 
		query.append(",	IMDG_SEGR_GRP_NO = @[imdg_segr_grp_no]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append("AND NVL(SPCL_CGO_APRO_CD,' ') NOT IN ('R', 'Y', 'N')" ).append("\n"); 
		query.append("AND	CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_DG_CGO SET " ).append("\n"); 
		query.append("	CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ = @[dg_cntr_seq]" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ = @[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	PRP_SHP_NM = @[prp_shp_nm]" ).append("\n"); 
		query.append(",	HZD_DESC = @[hzd_desc]" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP = @[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG = @[mrn_polut_flg]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM = @[emer_cntc_pnt_ctnt]" ).append("\n"); 
		query.append(",	EMER_CNTC_PHN_NO_CTNT = @[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(",	DCGO_STS_CD = @[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG = @[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC = @[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	EMS_NO = (SELECT MAX(IMDG_EMER_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO = (SELECT MAX(EMER_RSPN_GID_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO = (SELECT MAX(EMER_RSPN_GID_CHR_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",	IMDG_AMDT_NO = @[imdg_amdt_no]" ).append("\n"); 
		query.append(",	IMDG_SEGR_GRP_NO = @[imdg_segr_grp_no]" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND NVL(SPCL_CGO_APRO_CD,' ') NOT IN ('R', 'Y', 'N')" ).append("\n"); 
		query.append("AND	DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}