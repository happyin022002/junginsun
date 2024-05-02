/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOcopyDgCgoBySplitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.31
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.05.31 류대영
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

public class SpecialCargoReceiptDBDAOcopyDgCgoBySplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOcopyDgCgoBySplitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOcopyDgCgoBySplitCSQL").append("\n"); 
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
		query.append("insert into bkg_dg_cgo(BKG_NO " ).append("\n"); 
		query.append(",DCGO_SEQ " ).append("\n"); 
		query.append(",DG_CNTR_SEQ " ).append("\n"); 
		query.append(",CNTR_CGO_SEQ " ).append("\n"); 
		query.append(",CNTR_NO " ).append("\n"); 
		query.append(",CNTR_TPSZ_CD " ).append("\n"); 
		query.append(",IMDG_UN_NO " ).append("\n"); 
		query.append(",IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append(",IMDG_CLSS_CD " ).append("\n"); 
		query.append(",IMDG_SUBS_RSK_LBL_CD1 " ).append("\n"); 
		query.append(",IMDG_SUBS_RSK_LBL_CD2 " ).append("\n"); 
		query.append(",IMDG_SUBS_RSK_LBL_CD3  " ).append("\n"); 
		query.append(",IMDG_LMT_QTY_FLG " ).append("\n"); 
		query.append(",IMDG_EXPT_QTY_FLG " ).append("\n"); 
		query.append(",NET_WGT " ).append("\n"); 
		query.append(",GRS_WGT " ).append("\n"); 
		query.append(",WGT_UT_CD " ).append("\n"); 
		query.append(",FLSH_PNT_CDO_TEMP " ).append("\n"); 
		query.append(",PRP_SHP_NM " ).append("\n"); 
		query.append(",HZD_DESC " ).append("\n"); 
		query.append(",MEAS_QTY " ).append("\n"); 
		query.append(",MEAS_UT_CD " ).append("\n"); 
		query.append(",CLOD_FLG " ).append("\n"); 
		query.append(",SPCL_STWG_RQST_DESC " ).append("\n"); 
		query.append(",DCGO_STS_CD " ).append("\n"); 
		query.append(",CGO_LCL_FLG " ).append("\n"); 
		query.append(",EMER_RSPN_GID_NO " ).append("\n"); 
		query.append(",EMER_RSPN_GID_CHR_NO " ).append("\n"); 
		query.append(",EMER_CNTC_PHN_NO_CTNT " ).append("\n"); 
		query.append(",EMER_CNTC_PSON_NM " ).append("\n"); 
		query.append(",EMER_TEMP_CTNT " ).append("\n"); 
		query.append(",CTRL_TEMP_CTNT " ).append("\n"); 
		query.append(",EMS_NO " ).append("\n"); 
		query.append(",IMDG_PCK_GRP_CD " ).append("\n"); 
		query.append(",MRN_POLUT_FLG " ).append("\n"); 
		query.append(",PSA_NO " ).append("\n"); 
		query.append(",CERTI_NO " ).append("\n"); 
		query.append(",IN_IMDG_PCK_QTY1 " ).append("\n"); 
		query.append(",IN_IMDG_PCK_CD1 " ).append("\n"); 
		query.append(",IN_IMDG_PCK_QTY2 " ).append("\n"); 
		query.append(",IN_IMDG_PCK_CD2 " ).append("\n"); 
		query.append(",OUT_IMDG_PCK_QTY1 " ).append("\n"); 
		query.append(",OUT_IMDG_PCK_CD1 " ).append("\n"); 
		query.append(",OUT_IMDG_PCK_QTY2 " ).append("\n"); 
		query.append(",OUT_IMDG_PCK_CD2 " ).append("\n"); 
		query.append(",MAX_IN_PCK_QTY " ).append("\n"); 
		query.append(",MAX_IN_PCK_TP_CD " ).append("\n"); 
		query.append(",CNEE_DTL_DESC " ).append("\n"); 
		query.append(",NET_EXPLO_WGT " ).append("\n"); 
		query.append(",RADA_SKD_NO " ).append("\n"); 
		query.append(",RADA_AMT " ).append("\n"); 
		query.append(",RADA_UT_CD " ).append("\n"); 
		query.append(",RADA_TRSP_NO " ).append("\n"); 
		query.append(",RC_FLG " ).append("\n"); 
		query.append(",AWK_CGO_FLG " ).append("\n"); 
		query.append(",BB_CGO_FLG " ).append("\n"); 
		query.append(",RC_SEQ " ).append("\n"); 
		query.append(",AWK_CGO_SEQ " ).append("\n"); 
		query.append(",BB_CGO_SEQ " ).append("\n"); 
		query.append(",HCDG_FLG " ).append("\n"); 
		query.append(",HCDG_DPND_QTY_FLG " ).append("\n"); 
		query.append(",RQST_DT " ).append("\n"); 
		query.append(",RQST_USR_ID " ).append("\n"); 
		query.append(",APLY_NO " ).append("\n"); 
		query.append(",SPCL_CGO_APRO_CD " ).append("\n"); 
		query.append(",DIFF_RMK " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",cntr_vol_qty" ).append("\n"); 
		query.append(",GRS_CAPA_QTY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO, " ).append("\n"); 
		query.append("DCGO_SEQ, " ).append("\n"); 
		query.append("DG_CNTR_SEQ, " ).append("\n"); 
		query.append("CNTR_CGO_SEQ, " ).append("\n"); 
		query.append("CNTR_NO, " ).append("\n"); 
		query.append("CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("IMDG_UN_NO, " ).append("\n"); 
		query.append("IMDG_UN_NO_SEQ, " ).append("\n"); 
		query.append("IMDG_CLSS_CD, " ).append("\n"); 
		query.append("IMDG_SUBS_RSK_LBL_CD1, " ).append("\n"); 
		query.append("IMDG_SUBS_RSK_LBL_CD2, " ).append("\n"); 
		query.append("IMDG_SUBS_RSK_LBL_CD3,  " ).append("\n"); 
		query.append("IMDG_LMT_QTY_FLG, " ).append("\n"); 
		query.append("IMDG_EXPT_QTY_FLG, " ).append("\n"); 
		query.append("NET_WGT, " ).append("\n"); 
		query.append("GRS_WGT, " ).append("\n"); 
		query.append("WGT_UT_CD, " ).append("\n"); 
		query.append("FLSH_PNT_CDO_TEMP, " ).append("\n"); 
		query.append("PRP_SHP_NM, " ).append("\n"); 
		query.append("HZD_DESC, " ).append("\n"); 
		query.append("MEAS_QTY, " ).append("\n"); 
		query.append("MEAS_UT_CD, " ).append("\n"); 
		query.append("CLOD_FLG, " ).append("\n"); 
		query.append("SPCL_STWG_RQST_DESC, " ).append("\n"); 
		query.append("DCGO_STS_CD, " ).append("\n"); 
		query.append("CGO_LCL_FLG, " ).append("\n"); 
		query.append("EMER_RSPN_GID_NO, " ).append("\n"); 
		query.append("EMER_RSPN_GID_CHR_NO, " ).append("\n"); 
		query.append("EMER_CNTC_PHN_NO_CTNT, " ).append("\n"); 
		query.append("EMER_CNTC_PSON_NM, " ).append("\n"); 
		query.append("EMER_TEMP_CTNT, " ).append("\n"); 
		query.append("CTRL_TEMP_CTNT, " ).append("\n"); 
		query.append("EMS_NO, " ).append("\n"); 
		query.append("IMDG_PCK_GRP_CD, " ).append("\n"); 
		query.append("MRN_POLUT_FLG, " ).append("\n"); 
		query.append("PSA_NO, " ).append("\n"); 
		query.append("CERTI_NO, " ).append("\n"); 
		query.append("IN_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("IN_IMDG_PCK_CD1, " ).append("\n"); 
		query.append("IN_IMDG_PCK_QTY2, " ).append("\n"); 
		query.append("IN_IMDG_PCK_CD2, " ).append("\n"); 
		query.append("OUT_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("OUT_IMDG_PCK_CD1, " ).append("\n"); 
		query.append("OUT_IMDG_PCK_QTY2, " ).append("\n"); 
		query.append("OUT_IMDG_PCK_CD2, " ).append("\n"); 
		query.append("MAX_IN_PCK_QTY, " ).append("\n"); 
		query.append("MAX_IN_PCK_TP_CD, " ).append("\n"); 
		query.append("CNEE_DTL_DESC, " ).append("\n"); 
		query.append("NET_EXPLO_WGT, " ).append("\n"); 
		query.append("RADA_SKD_NO, " ).append("\n"); 
		query.append("RADA_AMT, " ).append("\n"); 
		query.append("RADA_UT_CD, " ).append("\n"); 
		query.append("RADA_TRSP_NO, " ).append("\n"); 
		query.append("RC_FLG, " ).append("\n"); 
		query.append("AWK_CGO_FLG, " ).append("\n"); 
		query.append("BB_CGO_FLG, " ).append("\n"); 
		query.append("RC_SEQ, " ).append("\n"); 
		query.append("AWK_CGO_SEQ, " ).append("\n"); 
		query.append("BB_CGO_SEQ, " ).append("\n"); 
		query.append("HCDG_FLG, " ).append("\n"); 
		query.append("HCDG_DPND_QTY_FLG, " ).append("\n"); 
		query.append("RQST_DT, " ).append("\n"); 
		query.append("RQST_USR_ID, " ).append("\n"); 
		query.append("APLY_NO, " ).append("\n"); 
		query.append("SPCL_CGO_APRO_CD, " ).append("\n"); 
		query.append("DIFF_RMK, " ).append("\n"); 
		query.append("@[usr_id] CRE_USR_ID, " ).append("\n"); 
		query.append("sysdate CRE_DT, " ).append("\n"); 
		query.append("@[usr_id] UPD_USR_ID, " ).append("\n"); 
		query.append("sysdate UPD_DT" ).append("\n"); 
		query.append(",nvl((select cntr.CNTR_VOL_QTY " ).append("\n"); 
		query.append("        from bkg_container cntr " ).append("\n"); 
		query.append("       where cntr.bkg_no  = @[targetBkg]" ).append("\n"); 
		query.append("         and cntr.cntr_no = spcl.cntr_no), 1)" ).append("\n"); 
		query.append(",GRS_CAPA_QTY" ).append("\n"); 
		query.append("from bkg_dg_cgo spcl" ).append("\n"); 
		query.append("where bkg_no =  @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${dcgo_seq} != 'all')" ).append("\n"); 
		query.append("	and dcgo_seq = @[dcgo_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	and cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}