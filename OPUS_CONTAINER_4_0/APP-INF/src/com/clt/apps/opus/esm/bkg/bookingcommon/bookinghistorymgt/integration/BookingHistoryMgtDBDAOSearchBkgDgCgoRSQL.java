/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgDgCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.14 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchBkgDgCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgDgCgoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgDgCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgDgCgoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", DCGO_SEQ" ).append("\n"); 
		query.append(", DG_CNTR_SEQ" ).append("\n"); 
		query.append(", CNTR_CGO_SEQ" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", IMDG_UN_NO" ).append("\n"); 
		query.append(", IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(", IMDG_CLSS_CD" ).append("\n"); 
		query.append(", IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(", IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append(", IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append(", IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(", IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(", IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(", NET_WGT" ).append("\n"); 
		query.append(", GRS_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(", PRP_SHP_NM" ).append("\n"); 
		query.append(", HZD_DESC" ).append("\n"); 
		query.append(", MEAS_QTY" ).append("\n"); 
		query.append(", MEAS_UT_CD" ).append("\n"); 
		query.append(", CLOD_FLG" ).append("\n"); 
		query.append(", SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(", DCGO_STS_CD" ).append("\n"); 
		query.append(", CGO_LCL_FLG" ).append("\n"); 
		query.append(", EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(", EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(", EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(", EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(", EMER_TEMP_CTNT" ).append("\n"); 
		query.append(", CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(", EMS_NO" ).append("\n"); 
		query.append(", IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(", MRN_POLUT_FLG" ).append("\n"); 
		query.append(", PSA_NO" ).append("\n"); 
		query.append(", CERTI_NO" ).append("\n"); 
		query.append(", IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(", IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append(", IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(", IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(", OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append(", MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(", MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(", CNEE_DTL_DESC" ).append("\n"); 
		query.append(", NET_EXPLO_WGT" ).append("\n"); 
		query.append(", RADA_SKD_NO" ).append("\n"); 
		query.append(", RADA_AMT" ).append("\n"); 
		query.append(", RADA_UT_CD" ).append("\n"); 
		query.append(", RADA_TRSP_NO" ).append("\n"); 
		query.append(", RC_FLG" ).append("\n"); 
		query.append(", AWK_CGO_FLG" ).append("\n"); 
		query.append(", BB_CGO_FLG" ).append("\n"); 
		query.append(", RC_SEQ" ).append("\n"); 
		query.append(", AWK_CGO_SEQ" ).append("\n"); 
		query.append(", BB_CGO_SEQ" ).append("\n"); 
		query.append(", HCDG_FLG" ).append("\n"); 
		query.append(", HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append(", TO_CHAR(RQST_DT, 'YYYY-MM-DD HH24:MI:SS') RQST_DT" ).append("\n"); 
		query.append(", RQST_USR_ID" ).append("\n"); 
		query.append(", APLY_NO" ).append("\n"); 
		query.append(", SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append(", IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(", IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append(", CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}