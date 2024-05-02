/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DOFChgColPermanageDBDAOSearchDofChgColPerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgColPermanageDBDAOSearchDofChgColPerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDofChgColPerList SELECT
	  * </pre>
	  */
	public DOFChgColPermanageDBDAOSearchDofChgColPerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromtrodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("haul_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("totrodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgColPermanageDBDAOSearchDofChgColPerListRSQL").append("\n"); 
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
		query.append("SELECT '' SEQ," ).append("\n"); 
		query.append("TMP.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("TMP.D2_QTY," ).append("\n"); 
		query.append("TMP.D4_QTY," ).append("\n"); 
		query.append("TMP.D5_QTY," ).append("\n"); 
		query.append("(TMP.D2_QTY+TMP.D4_QTY+TMP.D5_QTY) CNTR_QTY," ).append("\n"); 
		query.append("TRF.TRF_D2_QTY," ).append("\n"); 
		query.append("TRF.TRF_D4_QTY," ).append("\n"); 
		query.append("TRF.TRF_D5_QTY," ).append("\n"); 
		query.append("(TMP.D2_QTY*TRF.TRF_D2_QTY) + (TMP.D4_QTY*TRF.TRF_D4_QTY) + (TMP.D5_QTY*TRF.TRF_D5_QTY) TRF_AMT," ).append("\n"); 
		query.append("TRO_AMT," ).append("\n"); 
		query.append("DOD_AMT," ).append("\n"); 
		query.append("TMP.HLG_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SUBSTR(CNTR_RTN_YD_CD, 1, 5) CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("SUM(D2_QTY) D2_QTY," ).append("\n"); 
		query.append("SUM(D4_QTY) D4_QTY," ).append("\n"); 
		query.append("SUM(D5_QTY) D5_QTY," ).append("\n"); 
		query.append("SUM(TRO_AMT) TRO_AMT," ).append("\n"); 
		query.append("SUM(DOD_AMT) DOD_AMT," ).append("\n"); 
		query.append("HLG_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SUBSTR(CNTR_RTN_YD_CD, 1, 5) CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("DECODE(CNTR_TPSZ_CD, 'D2', 1, 0) D2_QTY," ).append("\n"); 
		query.append("DECODE(CNTR_TPSZ_CD, 'D4', 1, 0) D4_QTY," ).append("\n"); 
		query.append("DECODE(CNTR_TPSZ_CD, 'D5', 1, 0) D5_QTY," ).append("\n"); 
		query.append("TRNS_REV_AMT TRO_AMT," ).append("\n"); 
		query.append("DIF_AMT DOD_AMT," ).append("\n"); 
		query.append("HLG_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.CRE_OFC_CD," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("B.BL_NO BL_NO," ).append("\n"); 
		query.append("E.CUST_CNT_CD," ).append("\n"); 
		query.append("E.CUST_SEQ," ).append("\n"); 
		query.append("C.CNTR_NO," ).append("\n"); 
		query.append("C.CNMV_ID_NO," ).append("\n"); 
		query.append("C.CNMV_YR," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("B.POR_CD," ).append("\n"); 
		query.append("B.POL_CD," ).append("\n"); 
		query.append("B.POD_CD," ).append("\n"); 
		query.append("B.DEL_CD," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("D.MVMT_STS_CD," ).append("\n"); 
		query.append("D.ORG_YD_CD," ).append("\n"); 
		query.append("A.CURR_CD," ).append("\n"); 
		query.append("(NVL(A.TRNS_REV_AMT, 0)+NVL(A.NMF_TRNS_REV_AMT, 0)) TRNS_REV_AMT," ).append("\n"); 
		query.append("AR_IF.AR_INV_CHG_TP_CD," ).append("\n"); 
		query.append("SUM(AR_IF.AR_CHG_AMT) DIF_AMT," ).append("\n"); 
		query.append("A.HLG_TP_CD" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO A," ).append("\n"); 
		query.append("BKG_BOOKING B," ).append("\n"); 
		query.append("BKG_CUSTOMER E," ).append("\n"); 
		query.append("BKG_CONTAINER C," ).append("\n"); 
		query.append("CTM_MOVEMENT D," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LOCL_CURR_CD AR_CURR_CD," ).append("\n"); 
		query.append("IO_BND_CD bkg_io_bnd_cd," ).append("\n"); 
		query.append("BL_SRC_NO bl_no," ).append("\n"); 
		query.append("BKG_NO bkg_no," ).append("\n"); 
		query.append("CHG_CD ar_inv_chg_tp_cd," ).append("\n"); 
		query.append("CHG_AMT ar_chg_amt," ).append("\n"); 
		query.append("CURR_CD chg_curr_cd," ).append("\n"); 
		query.append("BL_SRC_NO ar_bl_all_no," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD trnk_vvd_cd," ).append("\n"); 
		query.append("AR_OFC_CD ar_ofc_cd," ).append("\n"); 
		query.append("ACT_CUST_CNT_CD||ACT_CUST_SEQ act_cust_cd" ).append("\n"); 
		query.append("FROM INV_AR_MN MN," ).append("\n"); 
		query.append("INV_AR_CHG CHG" ).append("\n"); 
		query.append("WHERE MN.AR_IF_NO = CHG.AR_IF_NO) AR_IF" ).append("\n"); 
		query.append("WHERE A.CRE_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("AND TO_CHAR(A.CRE_DT, 'YYYYMMDD') >= @[fromtrodate]" ).append("\n"); 
		query.append("AND TO_CHAR(A.CRE_DT, 'YYYYMMDD') <= @[totrodate] + 0.999" ).append("\n"); 
		query.append("AND A.HLG_TP_CD = @[haul_cd]" ).append("\n"); 
		query.append("AND A.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD = (" ).append("\n"); 
		query.append("SELECT MIN(BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER X" ).append("\n"); 
		query.append("WHERE BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD IN ('C'," ).append("\n"); 
		query.append("'N') )" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNMV_ID_NO = D.CNMV_ID_NO" ).append("\n"); 
		query.append("AND C.CNMV_YR = D.CNMV_YR" ).append("\n"); 
		query.append("AND B.BL_NO = AR_IF.AR_BL_ALL_NO(+)" ).append("\n"); 
		query.append("AND AR_IF.AR_INV_CHG_TP_CD = 'DOD'" ).append("\n"); 
		query.append("GROUP BY A.CRE_OFC_CD, A.BKG_NO, B.BL_NO, E.CUST_CNT_CD, E.CUST_SEQ, C.CNTR_NO, C.CNMV_ID_NO, C.CNMV_YR, C.CNTR_TPSZ_CD, A.CNTR_RTN_YD_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD, A.CRE_DT, D.MVMT_STS_CD, D.ORG_YD_CD, A.CURR_CD, A.TRNS_REV_AMT, A.NMF_TRNS_REV_AMT, AR_IF.AR_INV_CHG_TP_CD, AR_IF.AR_CURR_CD, A.HLG_TP_CD) )" ).append("\n"); 
		query.append("GROUP BY SUBSTR(CNTR_RTN_YD_CD, 1, 5), HLG_TP_CD ) TMP," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT FM_LOC_CD," ).append("\n"); 
		query.append("SUM(TRF_D2_QTY) TRF_D2_QTY," ).append("\n"); 
		query.append("SUM(TRF_D4_QTY) TRF_D4_QTY," ).append("\n"); 
		query.append("SUM(TRF_D5_QTY) TRF_D5_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT X.FM_LOC_CD," ).append("\n"); 
		query.append("DECODE(X.CNTR_TP_CD, 'D2', X.CHRR_FRT_TAX_VAL, 0) TRF_D2_QTY," ).append("\n"); 
		query.append("DECODE(X.CNTR_TP_CD, 'D4', X.CHRR_FRT_TAX_VAL, 0) TRF_D4_QTY," ).append("\n"); 
		query.append("DECODE(X.CNTR_TP_CD, 'D5', X.CHRR_FRT_TAX_VAL, 0) TRF_D5_QTY" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT FM_LOC_CD," ).append("\n"); 
		query.append("CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("MAX(EFF_DT) EFF_DT" ).append("\n"); 
		query.append("FROM TRS_DRFF_CHG_TRF" ).append("\n"); 
		query.append("GROUP BY FM_LOC_CD, CNT_CD, CUST_SEQ ) Y" ).append("\n"); 
		query.append("WHERE X.EFF_DT = Y.EFF_DT" ).append("\n"); 
		query.append("AND X.FM_LOC_CD = Y.FM_LOC_CD" ).append("\n"); 
		query.append("AND X.CNT_CD = Y.CNT_CD" ).append("\n"); 
		query.append("AND X.CUST_SEQ = Y.CUST_SEQ )" ).append("\n"); 
		query.append("GROUP BY FM_LOC_CD ) TRF" ).append("\n"); 
		query.append("WHERE TMP.CNTR_RTN_YD_CD = TRF.FM_LOC_CD (+)" ).append("\n"); 
		query.append("#if ( ${location} != '' )" ).append("\n"); 
		query.append("AND TMP.CNTR_RTN_YD_CD = @[location]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}