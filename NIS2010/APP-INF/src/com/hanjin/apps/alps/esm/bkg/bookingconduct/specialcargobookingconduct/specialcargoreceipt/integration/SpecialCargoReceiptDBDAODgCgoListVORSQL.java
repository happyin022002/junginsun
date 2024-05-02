/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODgCgoListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.17 
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",	A.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",	A.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append(",	A.DCGO_SEQ" ).append("\n"); 
		query.append(",	DENSE_RANK() OVER (PARTITION BY A.BKG_NO ORDER BY A.DG_CNTR_SEQ) AS DG_CNTR_SEQ" ).append("\n"); 
		query.append(",   A.DG_CNTR_SEQ AS DG_CNTR_SEQ2" ).append("\n"); 
		query.append(",	ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, A.DG_CNTR_SEQ ORDER BY A.DG_CNTR_SEQ, A.CNTR_CGO_SEQ) AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	A.CNTR_NO" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",   (  SELECT   SUBSTR(XMLAGG(XMLELEMENT(X, '/' || IMDG_SPCL_PROVI_NO) ORDER BY DP_SEQ).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("       FROM     SCG_IMDG_UN_NO_SPCL_PROVI" ).append("\n"); 
		query.append("       WHERE 	IMDG_UN_NO  = A.IMDG_UN_NO " ).append("\n"); 
		query.append("       AND 	    IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("       GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("    ) SPCL_PROVI_NO" ).append("\n"); 
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
		query.append(",	A.HZD_CTNT" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("       SELECT   SUBSTR(XMLAGG(XMLELEMENT(NM, '|' || M.IMDG_SEGR_GRP_NM) ORDER BY M.IMDG_SEGR_GRP_NO).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("       FROM     SCG_IMDG_SEGR_GRP_DTL D" ).append("\n"); 
		query.append("               ,SCG_IMDG_SEGR_GRP M" ).append("\n"); 
		query.append("       WHERE    1 = 1" ).append("\n"); 
		query.append("       AND      D.IMDG_SEGR_GRP_NO = M.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("       AND      D.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("    ) DFLT_SEGR_GRP_NM" ).append("\n"); 
		query.append(",	A.STWG_TEMP_CTNT" ).append("\n"); 
		query.append(",	A.MEAS_QTY" ).append("\n"); 
		query.append(",	A.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A.CLOD_FLG" ).append("\n"); 
		query.append(",	A.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	A.DCGO_STS_CD" ).append("\n"); 
		query.append(",	A.CGO_LCL_FLG" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	A.DCGO_RQST_GRP_EML1" ).append("\n"); 
		query.append(",	A.DCGO_RQST_GRP_EML2" ).append("\n"); 
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
		query.append(",   (SELECT IMDG_SPCL_PROVI_NO FROM SCG_IMDG_UN_NO_SPCL_PROVI WHERE IMDG_UN_NO = A.IMDG_UN_NO AND IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ AND IMDG_SPCL_PROVI_NO = '274') IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append(",   (SELECT A3.IMDG_CRR_RSTR_EXPT_CD FROM BKG_VVD A1, MDM_VSL_CNTR A2, SCG_IMDG_CRR_RSTR A3 WHERE A1.VSL_CD = A2.VSL_CD AND A1.BKG_NO = @[bkg_no] AND A2.CRR_CD = A3.VSL_OPR_TP_CD AND A3.IMDG_CRR_RSTR_EXPT_CD = 'R' AND C.IMDG_UN_NO = NVL(A3.IMDG_UN_NO, C.IMDG_UN_NO) AND C.IMDG_UN_NO_SEQ  = NVL(A3.IMDG_UN_NO_SEQ , C.IMDG_UN_NO_SEQ) AND C.IMDG_CLSS_CD = NVL(A3.IMDG_CLSS_CD,C.IMDG_CLSS_CD) AND ROWNUM =1) IMDG_CRR_RSTR_EXPT_CD " ).append("\n"); 
		query.append(",	C.HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append(",	C.IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append(",   CONCAT(C.IMDG_LMT_QTY, C.IMDG_LMT_QTY_MEAS_UT_CD) LTD_QTY" ).append("\n"); 
		query.append(",	A.GRS_CAPA_QTY" ).append("\n"); 
		query.append(",   (SELECT '1'" ).append("\n"); 
		query.append("		FROM BKG_BKG_HIS B" ).append("\n"); 
		query.append("			,MDM_LOCATION L1" ).append("\n"); 
		query.append("			,MDM_LOCATION L2" ).append("\n"); 
		query.append("			,MDM_LOCATION L3" ).append("\n"); 
		query.append("			,MDM_LOCATION L4" ).append("\n"); 
		query.append("		WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		AND B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("		AND B.POR_CD = L1.LOC_CD" ).append("\n"); 
		query.append("		AND B.POL_CD = L2.LOC_CD" ).append("\n"); 
		query.append("		AND B.POD_CD = L3.LOC_CD" ).append("\n"); 
		query.append("		AND B.DEL_CD = L4.LOC_CD" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					(L1.CONTI_CD = 'E' OR L2.CONTI_CD = 'E')" ).append("\n"); 
		query.append("				AND (   B.RCV_TERM_CD IN ('D','H')" ).append("\n"); 
		query.append("					OR (    B.POR_CD <> B.POL_CD" ).append("\n"); 
		query.append("						AND NVL(L1.CALL_PORT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				OR (" ).append("\n"); 
		query.append("					(L3.CONTI_CD = 'E' OR L4.CONTI_CD = 'E')" ).append("\n"); 
		query.append("					AND (  B.DE_TERM_CD IN ('D','H')" ).append("\n"); 
		query.append("						OR (    B.POD_CD <> B.DEL_CD" ).append("\n"); 
		query.append("							AND NVL(L4.CALL_PORT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("							)							" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			) HCDG_QTY" ).append("\n"); 
		query.append("FROM 	BKG_DG_CGO_HIS A, BKG_BKG_HIS B, SCG_IMDG_UN_NO C" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND	A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.CORR_NO = B.CORR_NO" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO = C.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO_SEQ =  C.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
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
		query.append(",	A.DG_CNTR_SEQ AS DG_CNTR_SEQ2" ).append("\n"); 
		query.append(",	ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, A.DG_CNTR_SEQ ORDER BY A.DG_CNTR_SEQ, A.CNTR_CGO_SEQ) AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",	A.CNTR_NO" ).append("\n"); 
		query.append(",	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO" ).append("\n"); 
		query.append(",	A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",   (SELECT 	 SUBSTR(XMLAGG(XMLELEMENT(X, '/' || IMDG_SPCL_PROVI_NO) ORDER BY DP_SEQ).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("                FROM     SCG_IMDG_UN_NO_SPCL_PROVI" ).append("\n"); 
		query.append("                WHERE 	 IMDG_UN_NO  = A.IMDG_UN_NO" ).append("\n"); 
		query.append("                AND 	 IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("    ) SPCL_PROVI_NO" ).append("\n"); 
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
		query.append(",	A.HZD_CTNT" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("       SELECT   SUBSTR(XMLAGG(XMLELEMENT(NM, '|' || M.IMDG_SEGR_GRP_NM) ORDER BY M.IMDG_SEGR_GRP_NO).EXTRACT('//text()'), 2)" ).append("\n"); 
		query.append("       FROM     SCG_IMDG_SEGR_GRP_DTL D" ).append("\n"); 
		query.append("               ,SCG_IMDG_SEGR_GRP M" ).append("\n"); 
		query.append("       WHERE    1 = 1" ).append("\n"); 
		query.append("       AND      D.IMDG_SEGR_GRP_NO = M.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("       AND      D.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("    ) DFLT_SEGR_GRP_NM" ).append("\n"); 
		query.append(",	A.STWG_TEMP_CTNT" ).append("\n"); 
		query.append(",	A.MEAS_QTY" ).append("\n"); 
		query.append(",	A.MEAS_UT_CD" ).append("\n"); 
		query.append(",	A.CLOD_FLG" ).append("\n"); 
		query.append(",	A.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	A.DCGO_STS_CD" ).append("\n"); 
		query.append(",	A.CGO_LCL_FLG" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append(",	A.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	A.DCGO_RQST_GRP_EML1" ).append("\n"); 
		query.append(",	A.DCGO_RQST_GRP_EML2" ).append("\n"); 
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
		query.append("             WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
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
		query.append(",   (SELECT IMDG_SPCL_PROVI_NO FROM SCG_IMDG_UN_NO_SPCL_PROVI WHERE IMDG_UN_NO = A.IMDG_UN_NO AND IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ AND IMDG_SPCL_PROVI_NO = '274') IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append(",   (SELECT A2.CRR_CD FROM BKG_VVD A1, MDM_VSL_CNTR A2, SCG_IMDG_CRR_RSTR A3 WHERE A1.VSL_CD = A2.VSL_CD AND A1.BKG_NO = @[bkg_no] AND A2.CRR_CD = A3.VSL_OPR_TP_CD AND A3.IMDG_CRR_RSTR_EXPT_CD = 'R' AND C.IMDG_UN_NO = NVL(A3.IMDG_UN_NO, C.IMDG_UN_NO) AND C.IMDG_UN_NO_SEQ  = NVL(A3.IMDG_UN_NO_SEQ , C.IMDG_UN_NO_SEQ) AND C.IMDG_CLSS_CD = NVL(A3.IMDG_CLSS_CD,C.IMDG_CLSS_CD) AND ROWNUM =1) CRR_CD" ).append("\n"); 
		query.append(",   C.HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append(",   C.HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append(",   C.IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append(",	C.IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append(",	A.GRS_CAPA_QTY" ).append("\n"); 
		query.append(",   CONCAT(C.IMDG_LMT_QTY, C.IMDG_LMT_QTY_MEAS_UT_CD) LTD_QTY" ).append("\n"); 
		query.append(",   (SELECT '1'" ).append("\n"); 
		query.append("		FROM BKG_BOOKING B" ).append("\n"); 
		query.append("			,MDM_LOCATION L1" ).append("\n"); 
		query.append("			,MDM_LOCATION L2" ).append("\n"); 
		query.append("			,MDM_LOCATION L3" ).append("\n"); 
		query.append("			,MDM_LOCATION L4" ).append("\n"); 
		query.append("		WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("		AND B.POR_CD = L1.LOC_CD" ).append("\n"); 
		query.append("		AND B.POL_CD = L2.LOC_CD" ).append("\n"); 
		query.append("		AND B.POD_CD = L3.LOC_CD" ).append("\n"); 
		query.append("		AND B.DEL_CD = L4.LOC_CD" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					(L1.CONTI_CD = 'E' OR L2.CONTI_CD = 'E')" ).append("\n"); 
		query.append("				AND (   B.RCV_TERM_CD IN ('D','H')" ).append("\n"); 
		query.append("					OR (    B.POR_CD <> B.POL_CD" ).append("\n"); 
		query.append("						AND NVL(L1.CALL_PORT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			OR (" ).append("\n"); 
		query.append("				(L3.CONTI_CD = 'E' OR L4.CONTI_CD = 'E')" ).append("\n"); 
		query.append("					AND (  B.DE_TERM_CD IN ('D','H')" ).append("\n"); 
		query.append("						OR (    B.POD_CD <> B.DEL_CD" ).append("\n"); 
		query.append("							AND NVL(L4.CALL_PORT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append(") HCDG_QTY" ).append("\n"); 
		query.append("FROM 	BKG_DG_CGO A, BKG_BOOKING B, SCG_IMDG_UN_NO C" ).append("\n"); 
		query.append("WHERE	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO = C.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND A.IMDG_UN_NO_SEQ =  C.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}