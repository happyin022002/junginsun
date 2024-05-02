/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingBkgDgCgo
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("spcl_stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("out_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DG_CGO_HIS (" ).append("\n"); 
		query.append(" 	BKG_NO" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	PRP_SHP_NM" ).append("\n"); 
		query.append(",	HZD_DESC" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	DCGO_STS_CD" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	EMS_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",   HZD_CTNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append(",   IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	PSA_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" 	@[bkg_no]" ).append("\n"); 
		query.append(",	@[dcgo_seq]" ).append("\n"); 
		query.append(",	@[dg_cntr_seq]" ).append("\n"); 
		query.append(",	@[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	@[imdg_clss_cd]" ).append("\n"); 
		query.append(",	@[prp_shp_nm]" ).append("\n"); 
		query.append(",	@[hzd_desc]" ).append("\n"); 
		query.append(",	@[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	@[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	@[mrn_polut_flg]" ).append("\n"); 
		query.append(",	@[emer_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	@[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	(SELECT MAX(IMDG_EMER_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	(SELECT MAX(EMER_RSPN_GID_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	(SELECT MAX(EMER_RSPN_GID_CHR_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("            SELECT SUBSTR(XMLAGG(XMLELEMENT(NM, '|' || M.IMDG_SEGR_GRP_NM) ORDER BY M.IMDG_SEGR_GRP_NO).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("            FROM   SCG_IMDG_SEGR_GRP_DTL D" ).append("\n"); 
		query.append("                  ,SCG_IMDG_SEGR_GRP M" ).append("\n"); 
		query.append("            WHERE  1 = 1" ).append("\n"); 
		query.append("            AND    D.IMDG_SEGR_GRP_NO = M.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("            AND    D.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	'TMP0000001'" ).append("\n"); 
		query.append(",   @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",   @[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(", @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append(", @[out_imdg_pck_qty1]" ).append("\n"); 
		query.append(", @[psa_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO BKG_DG_CGO (" ).append("\n"); 
		query.append(" 	BKG_NO" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	PRP_SHP_NM" ).append("\n"); 
		query.append(",	HZD_DESC" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	MRN_POLUT_FLG" ).append("\n"); 
		query.append(",	EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	DCGO_STS_CD" ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	EMS_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",   HZD_CTNT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	PSA_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" 	@[bkg_no]" ).append("\n"); 
		query.append(",	@[dcgo_seq]" ).append("\n"); 
		query.append(",	@[dg_cntr_seq]" ).append("\n"); 
		query.append(",	@[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	@[imdg_clss_cd]" ).append("\n"); 
		query.append(",	@[prp_shp_nm]" ).append("\n"); 
		query.append(",	@[hzd_desc]" ).append("\n"); 
		query.append(",	@[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append(",	@[imdg_pck_grp_cd]" ).append("\n"); 
		query.append(",	@[mrn_polut_flg]" ).append("\n"); 
		query.append(",	@[emer_cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[dcgo_sts_cd]" ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append(",	@[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	(SELECT MAX(IMDG_EMER_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	(SELECT MAX(EMER_RSPN_GID_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	(SELECT MAX(EMER_RSPN_GID_CHR_NO) FROM SCG_IMDG_UN_NO WHERE IMDG_UN_NO = @[imdg_un_no] AND IMDG_CLSS_CD = @[imdg_clss_cd])" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("            SELECT SUBSTR(XMLAGG(XMLELEMENT(NM, '|' || M.IMDG_SEGR_GRP_NM) ORDER BY M.IMDG_SEGR_GRP_NO).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("            FROM   SCG_IMDG_SEGR_GRP_DTL D" ).append("\n"); 
		query.append("                  ,SCG_IMDG_SEGR_GRP M" ).append("\n"); 
		query.append("            WHERE  1 = 1" ).append("\n"); 
		query.append("            AND    D.IMDG_SEGR_GRP_NO = M.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("            AND    D.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",   @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append(",   @[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append(", @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append(", @[out_imdg_pck_qty1]" ).append("\n"); 
		query.append(", 	@[psa_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}