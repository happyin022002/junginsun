/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchChangedDGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.01.26 Maeda Atsushi
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

public class SpecialCargoReceiptDBDAOSearchChangedDGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check DG is changed or not
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchChangedDGRSQL(){
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
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("certi_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ems_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("net_explo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchChangedDGRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND CNTR_VOL_QTY = @[cntr_vol_qty]" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_clss_cd}== '')" ).append("\n"); 
		query.append("AND IMDG_CLSS_CD IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no}== '')" ).append("\n"); 
		query.append("AND IMDG_UN_NO IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no_seq}== '')" ).append("\n"); 
		query.append("AND IMDG_UN_NO_SEQ IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prp_shp_nm}== '')" ).append("\n"); 
		query.append("AND PRP_SHP_NM IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND PRP_SHP_NM = @[prp_shp_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hzd_desc}== '')" ).append("\n"); 
		query.append("AND HZD_DESC IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND HZD_DESC = @[hzd_desc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${grs_wgt}== '')" ).append("\n"); 
		query.append("AND GRS_WGT IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${net_wgt}== '')" ).append("\n"); 
		query.append("AND NET_WGT IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_pck_grp_cd}== '')" ).append("\n"); 
		query.append("AND IMDG_PCK_GRP_CD IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IMDG_PCK_GRP_CD = @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${psa_no}== '')" ).append("\n"); 
		query.append("AND PSA_NO IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND PSA_NO = @[psa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${flsh_pnt_cdo_temp}== '')" ).append("\n"); 
		query.append("AND FLSH_PNT_CDO_TEMP IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND FLSH_PNT_CDO_TEMP = @[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ems_no}== '')" ).append("\n"); 
		query.append("AND EMS_NO IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EMS_NO = @[ems_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mrn_polut_flg}== '')" ).append("\n"); 
		query.append("AND MRN_POLUT_FLG IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MRN_POLUT_FLG = @[mrn_polut_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${emer_cntc_phn_no_ctnt}== '')" ).append("\n"); 
		query.append("AND EMER_CNTC_PHN_NO_CTNT IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EMER_CNTC_PHN_NO_CTNT = @[emer_cntc_phn_no_ctnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${emer_cntc_pson_nm}== '')" ).append("\n"); 
		query.append("AND EMER_CNTC_PSON_NM IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EMER_CNTC_PSON_NM = @[emer_cntc_pson_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${certi_no}== '')" ).append("\n"); 
		query.append("AND CERTI_NO IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND CERTI_NO = @[certi_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${net_explo_wgt}== '')" ).append("\n"); 
		query.append("AND NET_EXPLO_WGT IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NET_EXPLO_WGT = @[net_explo_wgt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${out_imdg_pck_qty1}== '')" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_QTY1 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_QTY1 = @[out_imdg_pck_qty1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${out_imdg_pck_cd1}== '')" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_CD1 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_CD1 = @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${out_imdg_pck_qty2}== '')" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_QTY2 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_QTY2 = @[out_imdg_pck_qty2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${out_imdg_pck_cd2}== '')" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_CD2 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND OUT_IMDG_PCK_CD2 = @[out_imdg_pck_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_imdg_pck_qty1}== '')" ).append("\n"); 
		query.append("AND IN_IMDG_PCK_QTY1 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IN_IMDG_PCK_QTY1 = @[in_imdg_pck_qty1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_imdg_pck_cd1}== '')" ).append("\n"); 
		query.append("AND IN_IMDG_PCK_CD1 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IN_IMDG_PCK_CD1 = @[in_imdg_pck_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_imdg_pck_qty2}== '')" ).append("\n"); 
		query.append("AND IN_IMDG_PCK_QTY2 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IN_IMDG_PCK_QTY2 = @[in_imdg_pck_qty2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_imdg_pck_cd2}== '')" ).append("\n"); 
		query.append("	AND IN_IMDG_PCK_CD2 IS NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND IN_IMDG_PCK_CD2 = @[in_imdg_pck_cd2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}