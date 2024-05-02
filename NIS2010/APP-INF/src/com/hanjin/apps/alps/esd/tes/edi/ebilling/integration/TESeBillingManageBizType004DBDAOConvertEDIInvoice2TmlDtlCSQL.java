/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI data의 DTL을 정규 Invoice의 DTL로 옮기기
	  * </pre>
	  */
	public TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageBizType004DBDAOConvertEDIInvoice2TmlDtlCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("INSERT INTO TES_TML_SO_DTL(" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TML_SO_SEQ," ).append("\n"); 
		query.append("TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("CALC_COST_GRP_CD," ).append("\n"); 
		query.append("CALC_TP_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("VOL_TR_UT_CD," ).append("\n"); 
		query.append("CTRT_RT," ).append("\n"); 
		query.append("INV_AMT," ).append("\n"); 
		query.append("INV_XCH_RT," ).append("\n"); 
		query.append("STAY_DYS," ).append("\n"); 
		query.append("OVR_DYS," ).append("\n"); 
		query.append("OVR_VOL_QTY," ).append("\n"); 
		query.append("WRK_DT," ).append("\n"); 
		query.append("INV_VOL_QTY," ).append("\n"); 
		query.append("STK_VOL_QTY," ).append("\n"); 
		query.append("FP_TEU_QTY," ).append("\n"); 
		query.append("DCGO_IND_CD," ).append("\n"); 
		query.append("RC_FLG," ).append("\n"); 
		query.append("TML_WRK_DY_CD," ).append("\n"); 
		query.append("IOC_CD," ).append("\n"); 
		query.append("TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("LANE_CD," ).append("\n"); 
		query.append("TML_CRR_CD," ).append("\n"); 
		query.append("CALC_VOL_QTY," ).append("\n"); 
		query.append("RVIS_VOL_QTY," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("ATB_DT," ).append("\n"); 
		query.append("EDI_SO_DTL_ID," ).append("\n"); 
		query.append("RF_MNTR_DYS," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  X.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("X.TML_SO_SEQ," ).append("\n"); 
		query.append("ROWNUM TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("X.LGS_COST_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN DECODE(SUBSTR(X.TML_INV_TP_CD,1,1),'S','SD','M','TM')" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('180020') --//HJNC는 Storage비용은 (FULL대상)FreePool만 하기로 함(FreeDay와 FreePool을 같이 쓸 S/P는 별도로 구별할 방법을 찾아야함 ~ EX.별도구분자)" ).append("\n"); 
		query.append("THEN DECODE(X.TML_INV_TP_CD,'ST','SP','TM','TM')" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('186666') --//HJGT는 Terminal 비용만 수동으로 받기로 함(Storage비용은 자동대상만 받기로 함)" ).append("\n"); 
		query.append("THEN DECODE(X.TML_INV_TP_CD,'TM','TM')" ).append("\n"); 
		query.append("ELSE X.TML_INV_TP_CD" ).append("\n"); 
		query.append("END CALC_COST_GRP_CD," ).append("\n"); 
		query.append("X.CALC_TP_CD," ).append("\n"); 
		query.append("TES_GET_EDI_CNTR_TPSZ_CD_FNC(X.VNDR_SEQ,X.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("X.VOL_TR_UT_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN NVL(CASE WHEN X.CTRT_RT IS NOT NULL AND X.CTRT_RT <> 0 THEN X.CTRT_RT/100 ELSE X.CTRT_RT END,0)" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('180020')" ).append("\n"); 
		query.append("THEN X.CTRT_RT" ).append("\n"); 
		query.append("ELSE X.CTRT_RT" ).append("\n"); 
		query.append("END CTRT_RT," ).append("\n"); 
		query.append("(NVL(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN  X.LGS_COST_CD IS NOT NULL AND X.LGS_COST_CD IN ('TMRFMO') AND X.RF_MNTR_DYS IS NOT NULL AND ABS(X.RF_MNTR_DYS) > 0" ).append("\n"); 
		query.append("THEN X.RF_MNTR_DYS" ).append("\n"); 
		query.append("ELSE 1" ).append("\n"); 
		query.append("END,1) *" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN NVL(CASE WHEN X.CTRT_RT IS NOT NULL AND X.CTRT_RT <> 0 THEN X.CTRT_RT/100 ELSE X.CTRT_RT END,0) *" ).append("\n"); 
		query.append("NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY/1000 ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('180020')" ).append("\n"); 
		query.append("THEN NVL(CASE WHEN X.CTRT_RT IS NOT NULL AND X.CTRT_RT <> 0 THEN X.CTRT_RT ELSE X.CTRT_RT END,0) *" ).append("\n"); 
		query.append("NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("ELSE NVL(CASE WHEN X.CTRT_RT IS NOT NULL AND X.CTRT_RT <> 0 THEN X.CTRT_RT ELSE X.CTRT_RT END,0) *" ).append("\n"); 
		query.append("NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("END) INV_AMT," ).append("\n"); 
		query.append("NVL(X.INV_XCH_RT,1) INV_XCH_RT," ).append("\n"); 
		query.append("X.STAY_DYS," ).append("\n"); 
		query.append("X.OVR_DYS," ).append("\n"); 
		query.append("X.OVR_VOL_QTY," ).append("\n"); 
		query.append("X.WRK_DT," ).append("\n"); 
		query.append("X.INV_VOL_QTY," ).append("\n"); 
		query.append("X.STK_VOL_QTY," ).append("\n"); 
		query.append("X.FP_TEU_QTY," ).append("\n"); 
		query.append("X.DCGO_IND_CD," ).append("\n"); 
		query.append("X.RC_FLG," ).append("\n"); 
		query.append("X.TML_WRK_DY_CD," ).append("\n"); 
		query.append("X.IOC_CD," ).append("\n"); 
		query.append("X.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("X.LANE_CD," ).append("\n"); 
		query.append("X.TML_CRR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY/1000 ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('180020')" ).append("\n"); 
		query.append("THEN NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("ELSE NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("END CALC_VOL_QTY," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("THEN NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY/1000 ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("WHEN X.VNDR_SEQ IN ('180020')" ).append("\n"); 
		query.append("THEN NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("ELSE NVL(CASE WHEN X.CALC_VOL_QTY IS NOT NULL AND X.CALC_VOL_QTY <> 0 THEN X.CALC_VOL_QTY ELSE X.CALC_VOL_QTY END,0)" ).append("\n"); 
		query.append("END RVIS_VOL_QTY," ).append("\n"); 
		query.append("X.IO_BND_CD," ).append("\n"); 
		query.append("X.VSL_CD," ).append("\n"); 
		query.append("X.SKD_VOY_NO," ).append("\n"); 
		query.append("X.SKD_DIR_CD," ).append("\n"); 
		query.append("X.ATB_DT," ).append("\n"); 
		query.append("X.EDI_SO_DTL_ID," ).append("\n"); 
		query.append("X.RF_MNTR_DYS," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT   H.VNDR_SEQ," ).append("\n"); 
		query.append("H.TML_INV_TP_CD," ).append("\n"); 
		query.append("D.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("@[tml_so_seq] TML_SO_SEQ," ).append("\n"); 
		query.append("D.TML_EDI_SO_DTL_SEQ," ).append("\n"); 
		query.append("D.LGS_COST_CD," ).append("\n"); 
		query.append("'M' CALC_TP_CD," ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("D.VOL_TR_UT_CD," ).append("\n"); 
		query.append("D.CTRT_RT," ).append("\n"); 
		query.append("D.INV_AMT," ).append("\n"); 
		query.append("D.INV_XCH_RT," ).append("\n"); 
		query.append("D.STAY_DYS," ).append("\n"); 
		query.append("D.OVR_DYS," ).append("\n"); 
		query.append("D.OVR_VOL_QTY," ).append("\n"); 
		query.append("D.WRK_DT," ).append("\n"); 
		query.append("D.INV_VOL_QTY," ).append("\n"); 
		query.append("D.STK_VOL_QTY," ).append("\n"); 
		query.append("D.FP_TEU_QTY," ).append("\n"); 
		query.append("D.DCGO_IND_CD," ).append("\n"); 
		query.append("D.RC_FLG," ).append("\n"); 
		query.append("D.TML_WRK_DY_CD," ).append("\n"); 
		query.append("D.IOC_CD," ).append("\n"); 
		query.append("D.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("D.LANE_CD," ).append("\n"); 
		query.append("D.TML_CRR_CD," ).append("\n"); 
		query.append("D.CALC_VOL_QTY," ).append("\n"); 
		query.append("D.RVIS_VOL_QTY," ).append("\n"); 
		query.append("DECODE(D.IO_BND_CD,'B','I',D.IO_BND_CD) IO_BND_CD," ).append("\n"); 
		query.append("SUBSTR(D.IB_VVD_CD,1,4) VSL_CD," ).append("\n"); 
		query.append("SUBSTR(D.IB_VVD_CD,5,4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(D.IB_VVD_CD,9) SKD_DIR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(D.IB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.IB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(", TES_EDI_SO_HDR E" ).append("\n"); 
		query.append("WHERE E.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND E.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(D.IB_VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(D.IB_VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD =SUBSTR(D.IB_VVD_CD,9)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(D.IB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--    // 2009-10-26 [ITM-200900174] : EDI invoice 전환시 DTL data넣는 부분에서  VVD유효성 확인 LOGIC에 복수개의 VVD 처리 추가" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(E.YD_CD,1,5) AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN SUBSTR(D.IB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.IB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT  LAST_DAY(TO_DATE(SUBSTR(D.IB_VVD_CD,5,4),'YYMM')) ATB_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("END ATB_DT," ).append("\n"); 
		query.append("D.EDI_SO_DTL_ID," ).append("\n"); 
		query.append("D.RF_MNTR_DYS" ).append("\n"); 
		query.append("FROM  TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = 	D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND D.IB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(D.IB_VVD_CD)=9" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT      H.VNDR_SEQ," ).append("\n"); 
		query.append("H.TML_INV_TP_CD," ).append("\n"); 
		query.append("D.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("@[tml_so_seq] TML_SO_SEQ," ).append("\n"); 
		query.append("D.TML_EDI_SO_DTL_SEQ," ).append("\n"); 
		query.append("D.LGS_COST_CD," ).append("\n"); 
		query.append("'M' CALC_TP_CD," ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("D.VOL_TR_UT_CD," ).append("\n"); 
		query.append("D.CTRT_RT," ).append("\n"); 
		query.append("D.INV_AMT," ).append("\n"); 
		query.append("D.INV_XCH_RT," ).append("\n"); 
		query.append("D.STAY_DYS," ).append("\n"); 
		query.append("D.OVR_DYS," ).append("\n"); 
		query.append("D.OVR_VOL_QTY," ).append("\n"); 
		query.append("D.WRK_DT," ).append("\n"); 
		query.append("D.INV_VOL_QTY," ).append("\n"); 
		query.append("D.STK_VOL_QTY," ).append("\n"); 
		query.append("D.FP_TEU_QTY," ).append("\n"); 
		query.append("D.DCGO_IND_CD," ).append("\n"); 
		query.append("D.RC_FLG," ).append("\n"); 
		query.append("D.TML_WRK_DY_CD," ).append("\n"); 
		query.append("D.IOC_CD," ).append("\n"); 
		query.append("D.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("D.LANE_CD," ).append("\n"); 
		query.append("D.TML_CRR_CD," ).append("\n"); 
		query.append("D.CALC_VOL_QTY," ).append("\n"); 
		query.append("D.RVIS_VOL_QTY," ).append("\n"); 
		query.append("DECODE(D.IO_BND_CD,'B','I',D.IO_BND_CD) IO_BND_CD," ).append("\n"); 
		query.append("SUBSTR(D.OB_VVD_CD,1,4) VSL_CD," ).append("\n"); 
		query.append("SUBSTR(D.OB_VVD_CD,5,4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(D.OB_VVD_CD,9) SKD_DIR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(D.OB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.OB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(", TES_EDI_SO_HDR E" ).append("\n"); 
		query.append("WHERE E.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND E.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(D.OB_VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(D.OB_VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD =SUBSTR(D.OB_VVD_CD,9)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(D.OB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--    // 2009-10-26 [ITM-200900174] : EDI invoice 전환시 DTL data넣는 부분에서  VVD유효성 확인 LOGIC에 복수개의 VVD 처리 추가" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(E.YD_CD,1,5) AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN SUBSTR(D.OB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.OB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT  LAST_DAY(TO_DATE(SUBSTR(D.OB_VVD_CD,5,4),'YYMM')) ATB_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("END ATB_DT," ).append("\n"); 
		query.append("D.EDI_SO_DTL_ID," ).append("\n"); 
		query.append("D.RF_MNTR_DYS" ).append("\n"); 
		query.append("FROM  TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = 	D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND SUBSTR(H.TML_INV_TP_CD,1,1) = 'M'" ).append("\n"); 
		query.append("AND D.OB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(D.OB_VVD_CD)=9" ).append("\n"); 
		query.append("AND D.IB_VVD_CD <> D.OB_VVD_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT      H.VNDR_SEQ," ).append("\n"); 
		query.append("H.TML_INV_TP_CD," ).append("\n"); 
		query.append("D.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("@[tml_so_seq] TML_SO_SEQ," ).append("\n"); 
		query.append("D.TML_EDI_SO_DTL_SEQ," ).append("\n"); 
		query.append("D.LGS_COST_CD," ).append("\n"); 
		query.append("'M' CALC_TP_CD," ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("D.VOL_TR_UT_CD," ).append("\n"); 
		query.append("D.CTRT_RT," ).append("\n"); 
		query.append("D.INV_AMT," ).append("\n"); 
		query.append("D.INV_XCH_RT," ).append("\n"); 
		query.append("D.STAY_DYS," ).append("\n"); 
		query.append("D.OVR_DYS," ).append("\n"); 
		query.append("D.OVR_VOL_QTY," ).append("\n"); 
		query.append("D.WRK_DT," ).append("\n"); 
		query.append("D.INV_VOL_QTY," ).append("\n"); 
		query.append("D.STK_VOL_QTY," ).append("\n"); 
		query.append("D.FP_TEU_QTY," ).append("\n"); 
		query.append("D.DCGO_IND_CD," ).append("\n"); 
		query.append("D.RC_FLG," ).append("\n"); 
		query.append("D.TML_WRK_DY_CD," ).append("\n"); 
		query.append("D.IOC_CD," ).append("\n"); 
		query.append("D.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("D.LANE_CD," ).append("\n"); 
		query.append("D.TML_CRR_CD," ).append("\n"); 
		query.append("D.CALC_VOL_QTY," ).append("\n"); 
		query.append("D.RVIS_VOL_QTY," ).append("\n"); 
		query.append("DECODE(D.IO_BND_CD,'B','O',D.IO_BND_CD) IO_BND_CD," ).append("\n"); 
		query.append("SUBSTR(D.IB_VVD_CD,1,4) VSL_CD," ).append("\n"); 
		query.append("SUBSTR(D.IB_VVD_CD,5,4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(D.IB_VVD_CD,9) SKD_DIR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(D.IB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.IB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(", TES_EDI_SO_HDR E" ).append("\n"); 
		query.append("WHERE E.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND E.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(D.IB_VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(D.IB_VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD =SUBSTR(D.IB_VVD_CD,9)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(D.IB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--    // 2009-10-26 [ITM-200900174] : EDI invoice 전환시 DTL data넣는 부분에서  VVD유효성 확인 LOGIC에 복수개의 VVD 처리 추가" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(E.YD_CD,1,5) AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN SUBSTR(D.IB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.IB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT  LAST_DAY(TO_DATE(SUBSTR(D.IB_VVD_CD,5,4),'YYMM')) ATB_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("END ATB_DT," ).append("\n"); 
		query.append("D.EDI_SO_DTL_ID," ).append("\n"); 
		query.append("D.RF_MNTR_DYS" ).append("\n"); 
		query.append("FROM  TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = 	D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND D.IB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(D.IB_VVD_CD)=9" ).append("\n"); 
		query.append("AND D.IO_BND_CD IS NOT NULL AND D.IO_BND_CD = 'B'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT      H.VNDR_SEQ," ).append("\n"); 
		query.append("H.TML_INV_TP_CD," ).append("\n"); 
		query.append("D.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("@[tml_so_seq] TML_SO_SEQ," ).append("\n"); 
		query.append("D.TML_EDI_SO_DTL_SEQ," ).append("\n"); 
		query.append("D.LGS_COST_CD," ).append("\n"); 
		query.append("'M' CALC_TP_CD," ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("D.VOL_TR_UT_CD," ).append("\n"); 
		query.append("D.CTRT_RT," ).append("\n"); 
		query.append("D.INV_AMT," ).append("\n"); 
		query.append("D.INV_XCH_RT," ).append("\n"); 
		query.append("D.STAY_DYS," ).append("\n"); 
		query.append("D.OVR_DYS," ).append("\n"); 
		query.append("D.OVR_VOL_QTY," ).append("\n"); 
		query.append("D.WRK_DT," ).append("\n"); 
		query.append("D.INV_VOL_QTY," ).append("\n"); 
		query.append("D.STK_VOL_QTY," ).append("\n"); 
		query.append("D.FP_TEU_QTY," ).append("\n"); 
		query.append("D.DCGO_IND_CD," ).append("\n"); 
		query.append("D.RC_FLG," ).append("\n"); 
		query.append("D.TML_WRK_DY_CD," ).append("\n"); 
		query.append("D.IOC_CD," ).append("\n"); 
		query.append("D.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("D.LANE_CD," ).append("\n"); 
		query.append("D.TML_CRR_CD," ).append("\n"); 
		query.append("D.CALC_VOL_QTY," ).append("\n"); 
		query.append("D.RVIS_VOL_QTY," ).append("\n"); 
		query.append("DECODE(D.IO_BND_CD,'B','O',D.IO_BND_CD) IO_BND_CD," ).append("\n"); 
		query.append("SUBSTR(D.OB_VVD_CD,1,4) VSL_CD," ).append("\n"); 
		query.append("SUBSTR(D.OB_VVD_CD,5,4) SKD_VOY_NO," ).append("\n"); 
		query.append("SUBSTR(D.OB_VVD_CD,9) SKD_DIR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(D.OB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.OB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(", TES_EDI_SO_HDR E" ).append("\n"); 
		query.append("WHERE E.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND E.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(D.OB_VVD_CD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(D.OB_VVD_CD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD =SUBSTR(D.OB_VVD_CD,9)" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND SUBSTR(D.OB_VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--    // 2009-10-26 [ITM-200900174] : EDI invoice 전환시 DTL data넣는 부분에서  VVD유효성 확인 LOGIC에 복수개의 VVD 처리 추가" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(E.YD_CD,1,5) AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN SUBSTR(D.OB_VVD_CD,1,4) IS NOT NULL AND SUBSTR(D.OB_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT  LAST_DAY(TO_DATE(SUBSTR(D.OB_VVD_CD,5,4),'YYMM')) ATB_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("END ATB_DT," ).append("\n"); 
		query.append("D.EDI_SO_DTL_ID," ).append("\n"); 
		query.append("D.RF_MNTR_DYS" ).append("\n"); 
		query.append("FROM  TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = 	D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.VNDR_SEQ IN ('158002','114776')" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("AND SUBSTR(H.TML_INV_TP_CD,1,1) = 'M'" ).append("\n"); 
		query.append("AND D.OB_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(D.OB_VVD_CD)=9" ).append("\n"); 
		query.append("AND D.IB_VVD_CD <> D.OB_VVD_CD" ).append("\n"); 
		query.append("AND D.IO_BND_CD IS NOT NULL AND D.IO_BND_CD = 'B'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT      H.VNDR_SEQ," ).append("\n"); 
		query.append("H.TML_INV_TP_CD," ).append("\n"); 
		query.append("D.TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("@[tml_so_seq] TML_SO_SEQ," ).append("\n"); 
		query.append("D.TML_EDI_SO_DTL_SEQ," ).append("\n"); 
		query.append("D.LGS_COST_CD," ).append("\n"); 
		query.append("'M' CALC_TP_CD," ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("D.VOL_TR_UT_CD," ).append("\n"); 
		query.append("D.CTRT_RT," ).append("\n"); 
		query.append("D.INV_AMT," ).append("\n"); 
		query.append("D.INV_XCH_RT," ).append("\n"); 
		query.append("D.STAY_DYS," ).append("\n"); 
		query.append("D.OVR_DYS," ).append("\n"); 
		query.append("D.OVR_VOL_QTY," ).append("\n"); 
		query.append("D.WRK_DT," ).append("\n"); 
		query.append("D.INV_VOL_QTY," ).append("\n"); 
		query.append("D.STK_VOL_QTY," ).append("\n"); 
		query.append("D.FP_TEU_QTY," ).append("\n"); 
		query.append("D.DCGO_IND_CD," ).append("\n"); 
		query.append("D.RC_FLG," ).append("\n"); 
		query.append("D.TML_WRK_DY_CD," ).append("\n"); 
		query.append("D.IOC_CD," ).append("\n"); 
		query.append("D.TML_TRNS_MOD_CD," ).append("\n"); 
		query.append("D.LANE_CD," ).append("\n"); 
		query.append("D.TML_CRR_CD," ).append("\n"); 
		query.append("D.CALC_VOL_QTY," ).append("\n"); 
		query.append("D.RVIS_VOL_QTY," ).append("\n"); 
		query.append("D.IO_BND_CD IO_BND_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("THEN D.VSL_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END VSL_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("THEN D.SKD_VOY_NO" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END SKD_VOY_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("THEN D.SKD_DIR_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END SKD_DIR_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN H.TML_INV_TP_CD IS NOT NULL AND H.TML_INV_TP_CD IN ('TM')" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN D.VSL_CD IS NOT NULL AND D.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT V.VPS_ETB_DT ATB_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(", TES_EDI_SO_HDR E" ).append("\n"); 
		query.append("WHERE E.TML_EDI_SO_OFC_CTY_CD = H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND E.TML_EDI_SO_SEQ = H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND V.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("AND V.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND D.VSL_CD <> 'CNTC'" ).append("\n"); 
		query.append("AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("--    // 2009-10-26 [ITM-200900174] : EDI invoice 전환시 DTL data넣는 부분에서  VVD유효성 확인 LOGIC에 복수개의 VVD 처리 추가" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(E.YD_CD,1,5) AND ROWNUM = 1)" ).append("\n"); 
		query.append("WHEN D.VSL_CD IS NOT NULL AND D.VSL_CD = 'CNTC'" ).append("\n"); 
		query.append("THEN (SELECT  LAST_DAY(TO_DATE(D.SKD_VOY_NO,'YYMM')) ATB_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END ATB_DT," ).append("\n"); 
		query.append("D.EDI_SO_DTL_ID," ).append("\n"); 
		query.append("D.RF_MNTR_DYS" ).append("\n"); 
		query.append("FROM  TES_EDI_SO_HDR H" ).append("\n"); 
		query.append(", TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("WHERE H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = 	D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(H.VNDR_SEQ IN ('180020') AND H.TML_INV_TP_CD IN ('TM','ST')) --//HJNC는 Storage비용은 (FULL대상)FreePool만 하기로 함(현재는 ST비용 미발생으로 아직 미사용중이며, 사용하려면 동작확인요함)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(H.VNDR_SEQ IN ('186666','176307') AND H.TML_INV_TP_CD IN ('TM'))	--//HJGT는 Terminal 비용만 수동으로 받기로 함(Storage비용은 자동대상만 받기로 함)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}