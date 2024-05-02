/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODgCgoListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.28 
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

public class SpecialCargoReceiptDBDAODgCgoListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgCgoListVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAODgCgoListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAODgCgoListVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("A.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	A.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append(",	A.DCGO_SEQ" ).append("\n"); 
		query.append(",	DENSE_RANK() OVER (PARTITION BY A.BKG_NO ORDER BY A.DG_CNTR_SEQ) AS DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, A.DG_CNTR_SEQ ORDER BY A.DG_CNTR_SEQ, A.DCGO_SEQ) AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	A.CNTR_NO" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	A.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append(",	A.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	A.IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(",	A.NET_WGT" ).append("\n"); 
		query.append(",	A.GRS_WGT" ).append("\n"); 
		query.append(",	A.WGT_UT_CD" ).append("\n"); 
		query.append(",	A.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	A.PRP_SHP_NM" ).append("\n"); 
		query.append(",	A.HZD_DESC" ).append("\n"); 
		query.append(",	A.MEAS_QTY" ).append("\n"); 
		query.append(",	A.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A.CLOD_FLG" ).append("\n"); 
		query.append(",	A.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	A.DCGO_STS_CD" ).append("\n"); 
		query.append(",	A.CGO_LCL_FLG" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	A.EMER_TEMP_CTNT" ).append("\n"); 
		query.append(",	A.CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(",	A.EMS_NO" ).append("\n"); 
		query.append(",	A.EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	A.EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",	A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	A.MRN_POLUT_FLG" ).append("\n"); 
		query.append(",	A.PSA_NO" ).append("\n"); 
		query.append(",	A.CERTI_NO" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	'0' MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(",	A.MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(",	A.CNEE_DTL_DESC" ).append("\n"); 
		query.append(",	A.NET_EXPLO_WGT" ).append("\n"); 
		query.append(",	A.RADA_SKD_NO" ).append("\n"); 
		query.append(",	A.RADA_AMT" ).append("\n"); 
		query.append(",	A.RADA_UT_CD" ).append("\n"); 
		query.append(",	A.RADA_TRSP_NO" ).append("\n"); 
		query.append(",	A.RC_FLG" ).append("\n"); 
		query.append(",	A.AWK_CGO_FLG" ).append("\n"); 
		query.append(",	A.BB_CGO_FLG" ).append("\n"); 
		query.append(",	A.RC_SEQ" ).append("\n"); 
		query.append(",	A.AWK_CGO_SEQ" ).append("\n"); 
		query.append(",	A.BB_CGO_SEQ" ).append("\n"); 
		query.append(",	A.HCDG_FLG" ).append("\n"); 
		query.append(",	A.HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append(",	A.RQST_DT" ).append("\n"); 
		query.append(",	A.RQST_USR_ID" ).append("\n"); 
		query.append(",   (SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("       FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("           ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                  , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                  , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                  , DCGO_SEQ" ).append("\n"); 
		query.append("              FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("             GROUP BY DCGO_SEQ) N " ).append("\n"); 
		query.append("      WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("        AND M.VSL_PRE_PST_CD||M.VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("        AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("        AND M.DCGO_SEQ = N.DCGO_SEQ" ).append("\n"); 
		query.append("        AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND M.DCGO_SEQ = A.DCGO_SEQ) APLY_NO" ).append("\n"); 
		query.append(",	A.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	A.DIFF_RMK" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	A.SPCL_RQST_FLG" ).append("\n"); 
		query.append(",	A.SPCL_RQST_DESC" ).append("\n"); 
		query.append(",   B.POR_CD" ).append("\n"); 
		query.append(",   B.DEL_CD" ).append("\n"); 
		query.append(",   B.RCV_TERM_CD" ).append("\n"); 
		query.append(",   B.DE_TERM_CD" ).append("\n"); 
		query.append(",   (SELECT substr(CNTR_TPSZ_DESC, 1, 4) from mdm_cntr_tp_sz where cntr_tpsz_cd = A.CNTR_TPSZ_CD) EQ_TPSZ" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1) IN_IMDG_PCK_DESC1" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD2) IN_IMDG_PCK_DESC2" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = INTMD_IMDG_PCK_CD1) INTMD_IMDG_PCK_DESC1" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = INTMD_IMDG_PCK_CD2) INTMD_IMDG_PCK_DESC2" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1) OUT_IMDG_PCK_DESC1" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD2) OUT_IMDG_PCK_DESC2" ).append("\n"); 
		query.append(",   (SELECT IMDG_SPCL_PROVI_NO FROM SCG_IMDG_UN_NO_SPCL_PROVI WHERE IMDG_UN_NO = A.IMDG_UN_NO AND IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ AND IMDG_SPCL_PROVI_NO IN (274,318)) IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append(",   (SELECT A3.IMDG_CRR_RSTR_EXPT_CD FROM BKG_VVD A1, MDM_VSL_CNTR A2, SCG_IMDG_CRR_RSTR A3 WHERE A1.VSL_CD = A2.VSL_CD AND A1.BKG_NO = @[bkg_no] AND A2.CRR_CD = A3.VSL_OPR_TP_CD AND A3.IMDG_CRR_RSTR_EXPT_CD = 'R' AND C.IMDG_UN_NO = NVL(A3.IMDG_UN_NO, C.IMDG_UN_NO) AND C.IMDG_UN_NO_SEQ  = NVL(A3.IMDG_UN_NO_SEQ , C.IMDG_UN_NO_SEQ) AND C.IMDG_CLSS_CD = NVL(A3.IMDG_CLSS_CD,C.IMDG_CLSS_CD) AND ROWNUM =1) IMDG_CRR_RSTR_EXPT_CD " ).append("\n"); 
		query.append(",	C.HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append(",	C.IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append(",	C.IMDG_EXPT_QTY_DESC" ).append("\n"); 
		query.append(",CONCAT(C.IMDG_LMT_QTY, C.IMDG_LMT_QTY_MEAS_UT_CD) LTD_QTY" ).append("\n"); 
		query.append(",C.IMDG_LMT_QTY_DESC" ).append("\n"); 
		query.append(",   (SELECT '1'" ).append("\n"); 
		query.append("FROM bkg_bkg_his B" ).append("\n"); 
		query.append(",mdm_location L1" ).append("\n"); 
		query.append(",mdm_location L2" ).append("\n"); 
		query.append(",mdm_location L3" ).append("\n"); 
		query.append(",mdm_location L4" ).append("\n"); 
		query.append("WHERE B.bkg_no = A.BKG_NO" ).append("\n"); 
		query.append("AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND B.por_cd = L1.loc_cd" ).append("\n"); 
		query.append("AND B.pol_cd = L2.loc_cd" ).append("\n"); 
		query.append("AND B.pod_cd = L3.loc_cd" ).append("\n"); 
		query.append("AND B.del_cd = L4.loc_cd" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(L1.conti_cd = 'E' OR L2.conti_cd = 'E')" ).append("\n"); 
		query.append("AND (   B.rcv_term_cd IN ('D','H')" ).append("\n"); 
		query.append("OR (    B.por_cd <> B.pol_cd" ).append("\n"); 
		query.append("AND NVL(L1.call_port_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("(L3.conti_cd = 'E' OR L4.conti_cd = 'E')" ).append("\n"); 
		query.append("AND (  B.de_term_cd IN ('D','H')" ).append("\n"); 
		query.append("OR (    B.pod_cd <> B.del_cd" ).append("\n"); 
		query.append("AND NVL(L4.call_port_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") HCDG_QTY" ).append("\n"); 
		query.append(",	A.CFR_FLG" ).append("\n"); 
		query.append(",	IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append(",	RSD_FLG" ).append("\n"); 
		query.append(",	A.DCGO_REF_NO" ).append("\n"); 
		query.append(",	'' AS OFC_CD" ).append("\n"); 
		query.append(",	SEGR.IMDG_SEGR_GRP_NOS" ).append("\n"); 
		query.append(",	A.DG_CNTR_SEQ AS DG_CNTR_SEQ_ORIGINAL" ).append("\n"); 
		query.append(",	A.IMDG_AMDT_NO" ).append("\n"); 
		query.append(",	A.ERAP_NO" ).append("\n"); 
		query.append(",	A.ERAP_CNTC_NO" ).append("\n"); 
		query.append(",	A.ERAP_APRO_REF_NO" ).append("\n"); 
		query.append(",	A.DOT_EXP_NO" ).append("\n"); 
		query.append(",	A.DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append(",	A.DOT_AUTH_NO" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO_SPCL_PROVI_CTNT" ).append("\n"); 
		query.append("FROM 	BKG_DG_CGO_HIS A, BKG_BKG_HIS B, SCG_IMDG_UN_NO C" ).append("\n"); 
		query.append("		,(	SELECT IMDG_UN_NO, LISTAGG(IMDG_SEGR_GRP_NO, ',') WITHIN GROUP (ORDER BY IMDG_SEGR_GRP_NO) AS IMDG_SEGR_GRP_NOS" ).append("\n"); 
		query.append("			FROM SCG_IMDG_SEGR_GRP_DTL" ).append("\n"); 
		query.append("			GROUP BY IMDG_UN_NO) SEGR" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND	A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.CORR_NO = B.CORR_NO" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO = C.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO_SEQ =  C.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO = SEGR.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	A.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append(",	A.DCGO_SEQ" ).append("\n"); 
		query.append(",	DENSE_RANK() OVER (PARTITION BY A.BKG_NO ORDER BY A.DG_CNTR_SEQ) AS DG_CNTR_SEQ" ).append("\n"); 
		query.append(",	ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, A.DG_CNTR_SEQ ORDER BY A.DG_CNTR_SEQ, A.DCGO_SEQ) AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	A.CNTR_NO" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	A.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append(",	A.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	A.IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(",	A.NET_WGT" ).append("\n"); 
		query.append(",	A.GRS_WGT" ).append("\n"); 
		query.append(",	A.WGT_UT_CD" ).append("\n"); 
		query.append(",	A.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	A.PRP_SHP_NM" ).append("\n"); 
		query.append(",	A.HZD_DESC" ).append("\n"); 
		query.append(",	A.MEAS_QTY" ).append("\n"); 
		query.append(",	A.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A.CLOD_FLG" ).append("\n"); 
		query.append(",	A.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	A.DCGO_STS_CD" ).append("\n"); 
		query.append(",	A.CGO_LCL_FLG" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	A.EMER_TEMP_CTNT" ).append("\n"); 
		query.append(",	A.CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(",	A.EMS_NO" ).append("\n"); 
		query.append(",	A.EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	A.EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",	A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	A.MRN_POLUT_FLG" ).append("\n"); 
		query.append(",	A.PSA_NO" ).append("\n"); 
		query.append(",	A.CERTI_NO" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	A.IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	A.INTMD_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append(",	A.OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append(",	'0' MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(",	A.MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(",	A.CNEE_DTL_DESC" ).append("\n"); 
		query.append(",	A.NET_EXPLO_WGT" ).append("\n"); 
		query.append(",	A.RADA_SKD_NO" ).append("\n"); 
		query.append(",	A.RADA_AMT" ).append("\n"); 
		query.append(",	A.RADA_UT_CD" ).append("\n"); 
		query.append(",	A.RADA_TRSP_NO" ).append("\n"); 
		query.append(",	A.RC_FLG" ).append("\n"); 
		query.append(",	A.AWK_CGO_FLG" ).append("\n"); 
		query.append(",	A.BB_CGO_FLG" ).append("\n"); 
		query.append(",	A.RC_SEQ" ).append("\n"); 
		query.append(",	A.AWK_CGO_SEQ" ).append("\n"); 
		query.append(",	A.BB_CGO_SEQ" ).append("\n"); 
		query.append(",	A.HCDG_FLG" ).append("\n"); 
		query.append(",	A.HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append(",	A.RQST_DT" ).append("\n"); 
		query.append(",	A.RQST_USR_ID" ).append("\n"); 
		query.append(",   (SELECT M.APRO_REF_NO " ).append("\n"); 
		query.append("       FROM SCG_AUTHORIZATION M " ).append("\n"); 
		query.append("           ,(SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                  , MIN(VSL_PRE_PST_CD||VSL_SEQ) VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                  , MAX(SPCL_CGO_AUTH_SEQ) AS SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                  , DCGO_SEQ" ).append("\n"); 
		query.append("              FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               AND SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("             GROUP BY DCGO_SEQ) N " ).append("\n"); 
		query.append("      WHERE M.SPCL_CGO_APRO_RQST_SEQ = N.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("        AND M.VSL_PRE_PST_CD||M.VSL_SEQ = N.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("        AND M.SPCL_CGO_AUTH_SEQ = N.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("        AND M.DCGO_SEQ = N.DCGO_SEQ" ).append("\n"); 
		query.append("        AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND M.DCGO_SEQ = A.DCGO_SEQ) APLY_NO" ).append("\n"); 
		query.append(",	A.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	A.DIFF_RMK" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",	A.SPCL_RQST_FLG" ).append("\n"); 
		query.append(",	A.SPCL_RQST_DESC" ).append("\n"); 
		query.append(",   B.POR_CD" ).append("\n"); 
		query.append(",   B.DEL_CD" ).append("\n"); 
		query.append(",   B.RCV_TERM_CD" ).append("\n"); 
		query.append(",   B.DE_TERM_CD" ).append("\n"); 
		query.append(",   (SELECT substr(CNTR_TPSZ_DESC, 1, 4) from mdm_cntr_tp_sz where cntr_tpsz_cd = A.CNTR_TPSZ_CD) EQ_TPSZ" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD1) IN_IMDG_PCK_DESC1" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = IN_IMDG_PCK_CD2) IN_IMDG_PCK_DESC2" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = INTMD_IMDG_PCK_CD1) INTMD_IMDG_PCK_DESC1" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = INTMD_IMDG_PCK_CD2) INTMD_IMDG_PCK_DESC2" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD1) OUT_IMDG_PCK_DESC1" ).append("\n"); 
		query.append(",   (SELECT IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD WHERE IMDG_PCK_CD = OUT_IMDG_PCK_CD2) OUT_IMDG_PCK_DESC2" ).append("\n"); 
		query.append(",   (SELECT IMDG_SPCL_PROVI_NO FROM SCG_IMDG_UN_NO_SPCL_PROVI WHERE IMDG_UN_NO = A.IMDG_UN_NO AND IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ AND IMDG_SPCL_PROVI_NO IN(274,318)) IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append(",   (SELECT A2.CRR_CD FROM BKG_VVD A1, MDM_VSL_CNTR A2, SCG_IMDG_CRR_RSTR A3 WHERE A1.VSL_CD = A2.VSL_CD AND A1.BKG_NO = @[bkg_no] AND A2.CRR_CD = A3.VSL_OPR_TP_CD AND A3.IMDG_CRR_RSTR_EXPT_CD = 'R' AND C.IMDG_UN_NO = NVL(A3.IMDG_UN_NO, C.IMDG_UN_NO) AND C.IMDG_UN_NO_SEQ  = NVL(A3.IMDG_UN_NO_SEQ , C.IMDG_UN_NO_SEQ) AND C.IMDG_CLSS_CD = NVL(A3.IMDG_CLSS_CD,C.IMDG_CLSS_CD) AND ROWNUM =1) CRR_CD" ).append("\n"); 
		query.append(",   C.HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append(",	C.IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append(",	C.IMDG_EXPT_QTY_DESC" ).append("\n"); 
		query.append(",	CONCAT(C.IMDG_LMT_QTY, C.IMDG_LMT_QTY_MEAS_UT_CD) LTD_QTY" ).append("\n"); 
		query.append(",	C.IMDG_LMT_QTY_DESC" ).append("\n"); 
		query.append(",   (SELECT '1'" ).append("\n"); 
		query.append("FROM bkg_booking B" ).append("\n"); 
		query.append(",mdm_location L1" ).append("\n"); 
		query.append(",mdm_location L2" ).append("\n"); 
		query.append(",mdm_location L3" ).append("\n"); 
		query.append(",mdm_location L4" ).append("\n"); 
		query.append("WHERE B.bkg_no = A.BKG_NO" ).append("\n"); 
		query.append("AND B.por_cd = L1.loc_cd" ).append("\n"); 
		query.append("AND B.pol_cd = L2.loc_cd" ).append("\n"); 
		query.append("AND B.pod_cd = L3.loc_cd" ).append("\n"); 
		query.append("AND B.del_cd = L4.loc_cd" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(L1.conti_cd = 'E' OR L2.conti_cd = 'E')" ).append("\n"); 
		query.append("AND (   B.rcv_term_cd IN ('D','H')" ).append("\n"); 
		query.append("OR (    B.por_cd <> B.pol_cd" ).append("\n"); 
		query.append("AND NVL(L1.call_port_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("(L3.conti_cd = 'E' OR L4.conti_cd = 'E')" ).append("\n"); 
		query.append("AND (  B.de_term_cd IN ('D','H')" ).append("\n"); 
		query.append("OR (    B.pod_cd <> B.del_cd" ).append("\n"); 
		query.append("AND NVL(L4.call_port_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") HCDG_QTY" ).append("\n"); 
		query.append(",	A.CFR_FLG" ).append("\n"); 
		query.append(",	IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append(",	RSD_FLG" ).append("\n"); 
		query.append(",	A.DCGO_REF_NO" ).append("\n"); 
		query.append(",	'' AS OFC_CD" ).append("\n"); 
		query.append(",	SEGR.IMDG_SEGR_GRP_NOS" ).append("\n"); 
		query.append(",	A.DG_CNTR_SEQ AS DG_CNTR_SEQ_ORIGINAL" ).append("\n"); 
		query.append(",	A.IMDG_AMDT_NO" ).append("\n"); 
		query.append(",	A.ERAP_NO" ).append("\n"); 
		query.append(",	A.ERAP_CNTC_NO" ).append("\n"); 
		query.append(",	A.ERAP_APRO_REF_NO" ).append("\n"); 
		query.append(",	A.DOT_EXP_NO" ).append("\n"); 
		query.append(",	A.DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append(",	A.DOT_AUTH_NO" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO_SPCL_PROVI_CTNT" ).append("\n"); 
		query.append("FROM 	BKG_DG_CGO A, BKG_BOOKING B, SCG_IMDG_UN_NO C" ).append("\n"); 
		query.append("		,(	SELECT IMDG_UN_NO, LISTAGG(IMDG_SEGR_GRP_NO, ',') WITHIN GROUP (ORDER BY IMDG_SEGR_GRP_NO) AS IMDG_SEGR_GRP_NOS" ).append("\n"); 
		query.append("			FROM SCG_IMDG_SEGR_GRP_DTL" ).append("\n"); 
		query.append("			GROUP BY IMDG_UN_NO) SEGR" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO = C.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO_SEQ =  C.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO = SEGR.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}