/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SupplementSOManageDBDAOSearchSupplementSOCorrectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SupplementSOManageDBDAOSearchSupplementSOCorrectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Supplement Correction 대상 목록 조회
	  * </pre>
	  */
	public SupplementSOManageDBDAOSearchSupplementSOCorrectionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loginUsrOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_costmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_eq_radio",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_dor_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_provider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_boundmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_via_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_transmode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_tp_sz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_from_node",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration").append("\n"); 
		query.append("FileName : SupplementSOManageDBDAOSearchSupplementSOCorrectionListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    X.BASIS_NO ," ).append("\n"); 
		query.append("    Z.BASIS_NO2 ," ).append("\n"); 
		query.append("    '' IBCHECK ," ).append("\n"); 
		query.append("    NVL(X.TRSP_SPL_SO_TP_CD, 'AS') TRSP_SPL_SO_TP_CD ," ).append("\n"); 
		query.append("    DECODE(Z.BASIS_NO2, 1, 'WorkOrder', 2, 'Invoiced', 3, 'Adjusted') AMOUNT_KIND ," ).append("\n"); 
		query.append("    NVL(X.TRSP_SO_CMB_TP_CD , '　') TRSP_SO_CMB_TP_CD ," ).append("\n"); 
		query.append("    NVL(X.TRSP_SO_CMB_SEQ , '　') TRSP_SO_CMB_SEQ ," ).append("\n"); 
		query.append("    NVL(X.TRSP_SO_CMB_SRT_NO , '　') TRSP_SO_CMB_SRT_NO ," ).append("\n"); 
		query.append("    X.EQ_NO ," ).append("\n"); 
		query.append("    DECODE(X.EQ_TPSZ_CD , NULL, '　', EQ_TPSZ_CD ) EQ_TPSZ_CD ," ).append("\n"); 
		query.append("    DECODE(X.TRSP_COST_DTL_MOD_CD , NULL, '　', TRSP_COST_DTL_MOD_CD ) TRSP_COST_DTL_MOD_CD ," ).append("\n"); 
		query.append("    DECODE(X.TRSP_CRR_MOD_CD , NULL, '　', TRSP_CRR_MOD_CD ) TRSP_CRR_MOD_CD ," ).append("\n"); 
		query.append("    NVL(X.FM_NOD_CD , '　') FM_NOD_CD ," ).append("\n"); 
		query.append("    NVL(X.VIA_NOD_CD, '　') VIA_NOD_CD ," ).append("\n"); 
		query.append("    NVL(X.TO_NOD_CD , '　') TO_NOD_CD ," ).append("\n"); 
		query.append("    NVL(X.DOR_NOD_CD, '　') DOR_NOD_CD ," ).append("\n"); 
		query.append("    DECODE(X.FM_LOC , NULL, '　', FM_LOC ) FM_LOC ," ).append("\n"); 
		query.append("    DECODE(X.FM_YARD , NULL, '　', FM_YARD ) FM_YARD ," ).append("\n"); 
		query.append("    DECODE(X.VIA_LOC , NULL, '　', VIA_LOC ) VIA_LOC ," ).append("\n"); 
		query.append("    DECODE(X.VIA_YARD , NULL, '　', VIA_YARD ) VIA_YARD ," ).append("\n"); 
		query.append("    DECODE(X.TO_LOC , NULL, '　', TO_LOC ) TO_LOC ," ).append("\n"); 
		query.append("    DECODE(X.TO_YARD , NULL, '　', TO_YARD ) TO_YARD ," ).append("\n"); 
		query.append("    DECODE(X.DOR_LOC , NULL, '　', DOR_LOC ) DOR_LOC ," ).append("\n"); 
		query.append("    DECODE(X.DOR_ZONE , NULL, '　', DOR_ZONE ) DOR_ZONE ," ).append("\n"); 
		query.append("    DECODE(X.CUST_VAL , NULL, '　', CUST_VAL ) CUST_VAL ," ).append("\n"); 
		query.append("    DECODE(X.DOR_DE_ADDR , NULL, '　', DOR_DE_ADDR ) DOR_DE_ADDR ," ).append("\n"); 
		query.append("    DECODE(X.VNDR_SEQ , NULL, '　', VNDR_SEQ ) VNDR_SEQ ," ).append("\n"); 
		query.append("	DECODE(X.VNDR_SEQ             , NULL, '　', TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(VNDR_SEQ)) VNDR_NM, " ).append("\n"); 
		query.append("    DECODE(X.BKG_SQ , NULL, '　', BKG_SQ ) BKG_SQ ," ).append("\n"); 
		query.append("    DECODE(X.BL_NO , NULL, '　', BL_NO ) BL_NO ," ).append("\n"); 
		query.append("    DECODE(X.TRUCK_VVD , NULL, '　', TRUCK_VVD ) TRUCK_VVD ," ).append("\n"); 
		query.append("    DECODE(X.SO_NUMBER , NULL, '　', SO_NUMBER ) SO_NUMBER ," ).append("\n"); 
		query.append("    DECODE(X.WO_NUMBER , NULL, '　', WO_NUMBER ) WO_NUMBER ," ).append("\n"); 
		query.append("    DECODE(X.LOCL_CRE_DT , NULL, '　', TO_CHAR(X.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI') ) CRE_DT ," ).append("\n"); 
		query.append("    DECODE(X.LOCL_CRE_DT , NULL, '　', TO_CHAR(X.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') ) CREATE_DATE ," ).append("\n"); 
		query.append("    DECODE(X.INV_NO , NULL, '　', INV_NO ) INV_NO ," ).append("\n"); 
		query.append("    DECODE(X.INV_CFM_DT , NULL, '　', TO_CHAR(INV_CFM_DT, 'YYYY-MM-DD HH24:MI') ) INV_CFM_DT ," ).append("\n"); 
		query.append("    DECODE(X.REF_NO , NULL, '　', REF_NO ) REF_NO ," ).append("\n"); 
		query.append("    DECODE(X.SPL_ISS_RSN , NULL, '　', SPL_ISS_RSN ) SPL_ISS_RSN ," ).append("\n"); 
		query.append("    X.TRSP_SO_OFC_CTY_CD ," ).append("\n"); 
		query.append("    X.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("    DECODE(BASIS_NO2, 1, X.TRSP_AGMT_RT_TP_CD , 2, X.TRSP_AGMT_RT_TP_CD , 3, X.TRSP_AGMT_RT_TP_CD ) AGMT_RT_TP_CD ," ).append("\n"); 
		query.append("    DECODE(BASIS_NO2, 1, X.TRSP_AGMT_WY_TP_CD , 2, X.TRSP_AGMT_WY_TP_CD , 3, X.TRSP_AGMT_WY_TP_CD ) AGMT_WY_TP_CD ," ).append("\n"); 
		query.append("    DECODE(BASIS_NO2, 1, X.WO_CURR_CD , 2, X.INV_CURR_CD, 3, X.SO_CURR_CD ) CURR_CD ," ).append("\n"); 
		query.append("    DECODE(BASIS_NO2, 1, X.WO_BZC_AMT , 2, X.INV_BZC_AMT , 3, X.SO_BZC_AMT ) BZC_AMT ," ).append("\n"); 
		query.append("	DECODE(BASIS_NO2, 1, X.WO_NEGO_AMT , 2, 0 , 3, X.SO_NEGO_AMT ) NEGO_AMT ,	" ).append("\n"); 
		query.append("	DECODE(BASIS_NO2, 1, X.WO_FUEL_SCG_AMT , 2, 0 , 3, X.SO_FUEL_SCG_AMT ) FUEL_SCG_AMT ,					  " ).append("\n"); 
		query.append("	DECODE(BASIS_NO2, 1, X.WO_OVR_WGT_SCG_AMT , 2, 0 , 3, X.SO_OVR_WGT_SCG_AMT ) OVR_WGT_SCG_AMT ,					" ).append("\n"); 
		query.append("    DECODE(BASIS_NO2, 1, X.WO_ETC_ADD_AMT , 2, X.INV_ETC_ADD_AMT , 3, X.SO_ETC_ADD_AMT ) ETC_ADD_AMT ,					" ).append("\n"); 
		query.append("    DECODE(BASIS_NO2, 1, X.WO_TOT_AMT , 2, X.TOT_INV_AMT , 3, X.SO_TOT_AMT ) TOT_AMT ," ).append("\n"); 
		query.append("    NVL(X.TRSP_SO_TP_CD , '　') TRSP_SO_TP_CD ," ).append("\n"); 
		query.append("    NVL(X.TRSP_BND_CD , '　') TRSP_BND_CD ," ).append("\n"); 
		query.append("    NVL(X.EQ_KND_CD , '　') EQ_KND_CD ," ).append("\n"); 
		query.append("    NVL(X.BKG_NO , '　') BKG_NO ," ).append("\n"); 
		query.append("    X.BDL_KNT ," ).append("\n"); 
		query.append("    X.WGT_MEAS_UT_CD ," ).append("\n"); 
		query.append("    X.CNTR_WGT ," ).append("\n"); 
		query.append("    X.CRE_OFC_CD ," ).append("\n"); 
		query.append("    X.CGO_TP_CD ," ).append("\n"); 
		query.append("    NVL(X.CUST_NOMI_TRKR_FLG, 'N') CUST_NOMI_TRKR_FLG ," ).append("\n"); 
		query.append("    X.CUST_CNT_CD ," ).append("\n"); 
		query.append("    X.CUST_SEQ ," ).append("\n"); 
		query.append("    X.CMDT_CD ," ).append("\n"); 
		query.append("    X.TRSP_DFLT_VNDR_FLG ," ).append("\n"); 
		query.append("    DECODE(X.INTER_RMK_CHK, '', '', 'Y') INTER_RMK," ).append("\n"); 
		query.append("	X.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        ROWNUM BASIS_NO ," ).append("\n"); 
		query.append("        A.TRSP_SPL_SO_TP_CD ," ).append("\n"); 
		query.append("        A.TRSP_SO_CMB_TP_CD ," ).append("\n"); 
		query.append("        TO_CHAR(A.TRSP_SO_CMB_SEQ) TRSP_SO_CMB_SEQ ," ).append("\n"); 
		query.append("        A.TRSP_SO_CMB_SRT_NO ," ).append("\n"); 
		query.append("        A.EQ_NO ," ).append("\n"); 
		query.append("        A.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("        A.TRSP_COST_DTL_MOD_CD ," ).append("\n"); 
		query.append("        A.TRSP_CRR_MOD_CD ," ).append("\n"); 
		query.append("        A.FM_NOD_CD ," ).append("\n"); 
		query.append("        A.VIA_NOD_CD ," ).append("\n"); 
		query.append("        A.TO_NOD_CD ," ).append("\n"); 
		query.append("        A.DOR_NOD_CD ," ).append("\n"); 
		query.append("        SUBSTR(A.FM_NOD_CD , 1, 5) FM_LOC ," ).append("\n"); 
		query.append("        SUBSTR(A.FM_NOD_CD , 6, 2) FM_YARD ," ).append("\n"); 
		query.append("        SUBSTR(A.VIA_NOD_CD, 1, 5) VIA_LOC ," ).append("\n"); 
		query.append("        SUBSTR(A.VIA_NOD_CD, 6, 2) VIA_YARD ," ).append("\n"); 
		query.append("        SUBSTR(A.TO_NOD_CD , 1, 5) TO_LOC ," ).append("\n"); 
		query.append("        SUBSTR(A.TO_NOD_CD , 6, 2) TO_YARD ," ).append("\n"); 
		query.append("        SUBSTR(A.DOR_NOD_CD, 1, 5) DOR_LOC ," ).append("\n"); 
		query.append("        SUBSTR(A.DOR_NOD_CD, 6, 2) DOR_ZONE ," ).append("\n"); 
		query.append("        A.CUST_CNT_CD||A.CUST_SEQ CUST_VAL ," ).append("\n"); 
		query.append("        A.CUST_NOMI_TRKR_FLG ," ).append("\n"); 
		query.append("        A.CUST_CNT_CD ," ).append("\n"); 
		query.append("        A.CUST_SEQ ," ).append("\n"); 
		query.append("        A.DOR_DE_ADDR ," ).append("\n"); 
		query.append("        A.VNDR_SEQ ," ).append("\n"); 
		query.append("        A.TRSP_AGMT_RT_TP_CD ," ).append("\n"); 
		query.append("        A.TRSP_AGMT_WY_TP_CD ," ).append("\n"); 
		query.append("        AA.CURR_CD WO_CURR_CD ," ).append("\n"); 
		query.append("        AA.BZC_AMT WO_BZC_AMT ," ).append("\n"); 
		query.append("        AA.NEGO_AMT WO_NEGO_AMT ," ).append("\n"); 
		query.append("        AA.FUEL_SCG_AMT WO_FUEL_SCG_AMT ," ).append("\n"); 
		query.append("        AA.OVR_WGT_SCG_AMT WO_OVR_WGT_SCG_AMT ," ).append("\n"); 
		query.append("        AA.ETC_ADD_AMT WO_ETC_ADD_AMT ," ).append("\n"); 
		query.append("        NVL(AA.BZC_AMT, 0)+NVL(AA.FUEL_SCG_AMT, 0)+NVL(AA.OVR_WGT_SCG_AMT, 0)+NVL(AA.ETC_ADD_AMT, 0) WO_TOT_AMT ," ).append("\n"); 
		query.append("        AA.INV_CURR_CD ," ).append("\n"); 
		query.append("        AA.INV_BZC_AMT ," ).append("\n"); 
		query.append("        AA.INV_ETC_ADD_AMT ," ).append("\n"); 
		query.append("		NVL(AA.INV_BZC_AMT, 0)+NVL(AA.INV_ETC_ADD_AMT, 0) TOT_INV_AMT ," ).append("\n"); 
		query.append("        A.CURR_CD SO_CURR_CD ," ).append("\n"); 
		query.append("        A.BZC_AMT SO_BZC_AMT ," ).append("\n"); 
		query.append("        A.NEGO_AMT SO_NEGO_AMT ," ).append("\n"); 
		query.append("        A.FUEL_SCG_AMT SO_FUEL_SCG_AMT ," ).append("\n"); 
		query.append("        A.OVR_WGT_SCG_AMT SO_OVR_WGT_SCG_AMT ," ).append("\n"); 
		query.append("        A.ETC_ADD_AMT SO_ETC_ADD_AMT ," ).append("\n"); 
		query.append("        NVL(A.BZC_AMT, 0)+NVL(A.FUEL_SCG_AMT, 0)+NVL(A.OVR_WGT_SCG_AMT, 0)+NVL(A.ETC_ADD_AMT, 0) SO_TOT_AMT ,	" ).append("\n"); 
		query.append("		A.BKG_NO BKG_SQ ,									  " ).append("\n"); 
		query.append("		A.BL_NO AS BL_NO , 									" ).append("\n"); 
		query.append("        A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD TRUCK_VVD ," ).append("\n"); 
		query.append("        A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ SO_NUMBER ," ).append("\n"); 
		query.append("        AA.TRSP_WO_OFC_CTY_CD||AA.TRSP_WO_SEQ WO_NUMBER ," ).append("\n"); 
		query.append("        B.LOCL_CRE_DT ," ).append("\n"); 
		query.append("        AA.INV_NO ," ).append("\n"); 
		query.append("        C.INV_CFM_DT ," ).append("\n"); 
		query.append("        AA.REF_ID||AA.REF_SEQ REF_NO ," ).append("\n"); 
		query.append("        A.SPL_ISS_RSN ," ).append("\n"); 
		query.append("        A.TRSP_SO_OFC_CTY_CD ," ).append("\n"); 
		query.append("        A.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("        A.TRSP_SO_TP_CD ," ).append("\n"); 
		query.append("        A.TRSP_BND_CD ," ).append("\n"); 
		query.append("        A.EQ_KND_CD ," ).append("\n"); 
		query.append("        A.BKG_NO ," ).append("\n"); 
		query.append("        CASE    " ).append("\n"); 
		query.append("            WHEN A.EQ_KND_CD = 'Z' AND A.TRSP_SO_CMB_TP_CD = 'BD' " ).append("\n"); 
		query.append("                THEN COUNT(*) OVER (PARTITION BY A.TRSP_SO_CMB_TP_CD, A.TRSP_SO_CMB_SEQ) " ).append("\n"); 
		query.append("            WHEN A.EQ_KND_CD = 'Z' THEN 1 " ).append("\n"); 
		query.append("            WHEN A.EQ_KND_CD = 'U' AND SUBSTR(A.EQ_TPSZ_CD, 1, 1) = 'F' AND A.TRSP_SO_CMB_TP_CD = 'BD' " ).append("\n"); 
		query.append("                THEN COUNT(*) OVER (PARTITION BY A.TRSP_SO_CMB_TP_CD, A.TRSP_SO_CMB_SEQ) " ).append("\n"); 
		query.append("            WHEN A.EQ_KND_CD = 'U' AND SUBSTR(A.EQ_TPSZ_CD, 1, 1) = 'F' THEN 1 " ).append("\n"); 
		query.append("        ELSE 0 " ).append("\n"); 
		query.append("        END BDL_KNT ," ).append("\n"); 
		query.append("        A.WGT_MEAS_UT_CD ," ).append("\n"); 
		query.append("        A.CNTR_WGT ," ).append("\n"); 
		query.append("        A.CRE_OFC_CD ," ).append("\n"); 
		query.append("        A.CGO_TP_CD ," ).append("\n"); 
		query.append("        A.CMDT_CD ," ).append("\n"); 
		query.append("        NVL(A.TRSP_DFLT_VNDR_FLG, 'N') TRSP_DFLT_VNDR_FLG ," ).append("\n"); 
		query.append("        (SELECT MAX(RMK.BKG_NO)" ).append("\n"); 
		query.append("		   FROM TRS_INTER_RMK RMK" ).append("\n"); 
		query.append("		  WHERE AA.BKG_NO = RMK.BKG_NO(+)" ).append("\n"); 
		query.append("			AND NVL(RMK.EQ_NO, 'X') = NVL2(RMK.EQ_NO, AA.EQ_NO, 'X')" ).append("\n"); 
		query.append("			AND NVL(RMK.DELT_FLG, 'X') = 'N') AS INTER_RMK_CHK," ).append("\n"); 
		query.append("		A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD AA ," ).append("\n"); 
		query.append("        TRS_TRSP_SVC_ORD A ," ).append("\n"); 
		query.append("        TRS_TRSP_WRK_ORD B ," ).append("\n"); 
		query.append("        TRS_TRSP_INV_WRK C" ).append("\n"); 
		query.append("    WHERE AA.TRSP_SO_OFC_CTY_CD = A.PRNT_TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND AA.TRSP_SO_SEQ = A.PRNT_TRSP_SO_SEQ" ).append("\n"); 
		query.append("        AND AA.TRSP_WO_OFC_CTY_CD = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND AA.TRSP_WO_SEQ = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("        AND AA.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("        AND AA.INV_VNDR_SEQ = C.INV_VNDR_SEQ" ).append("\n"); 
		query.append("        AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("        AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("        AND A.TRSP_SO_TP_CD = 'S'" ).append("\n"); 
		query.append("        AND A.TRSP_SO_OFC_CTY_CD = @[loginUsrOfcCtyCd]" ).append("\n"); 
		query.append("        AND A.TRSP_SPL_SO_TP_CD = @[hid_kind]" ).append("\n"); 
		query.append("        AND A.EQ_KND_CD = @[hid_eq_radio]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(!($sonumberArr.size() > 0 || $wonumberArr.size() > 0 || $bkgnumberArr.size() > 0 " ).append("\n"); 
		query.append("            || $blnumberArr.size() > 0 || $vvdnumberArr.size() > 0 || $refnumberArr.size() > 0 || $invnumberArr.size() > 0 || $eqnumberArr.size() > 0 ))" ).append("\n"); 
		query.append("       		AND A.LOCL_CRE_DT >= TO_DATE(NVL(@[from_date], '20070101'), 'YYYYMMDD')" ).append("\n"); 
		query.append("        	AND A.LOCL_CRE_DT < TO_DATE(NVL(@[to_date], '99991231'), 'YYYYMMDD')+1" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND NVL(A.TRSP_BND_CD , 'N/A') 			= NVL(@[hid_boundmode], NVL(A.TRSP_BND_CD , 'N/A'))" ).append("\n"); 
		query.append("        AND NVL(A.TRSP_COST_DTL_MOD_CD , 'N/A') = NVL(@[hid_costmode], NVL(A.TRSP_COST_DTL_MOD_CD , 'N/A'))" ).append("\n"); 
		query.append("        AND NVL(A.TRSP_CRR_MOD_CD , 'N/A') 		= NVL(@[hid_transmode], NVL(A.TRSP_CRR_MOD_CD , 'N/A'))" ).append("\n"); 
		query.append("        AND NVL(A.VNDR_SEQ , 0 ) 				= NVL(@[hid_provider], NVL(A.VNDR_SEQ , 0 )) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	#if(${hid_from_node} != '')" ).append("\n"); 
		query.append("        	AND A.FM_NOD_CD LIKE @[hid_from_node]||'%'" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("      	#if(${hid_via_node} != '')" ).append("\n"); 
		query.append("        	AND A.VIA_NOD_CD LIKE @[hid_via_node]||'%' " ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("      	#if(${hid_to_node} != '')" ).append("\n"); 
		query.append("       		AND A.TO_NOD_CD LIKE @[hid_to_node]||'%'" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      	#if(${hid_dor_node} != '')" ).append("\n"); 
		query.append("        	AND A.DOR_NOD_CD LIKE @[hid_dor_node]||'%'" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	-- //2009-03-12 CSR 요건 추가" ).append("\n"); 
		query.append("      	#if(${hid_tp_sz} != '' && ${hid_tp_sz}!='ALL')" ).append("\n"); 
		query.append("        	AND A.EQ_TPSZ_CD = @[hid_tp_sz]" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	#if($vvdnumberArr.size() > 0) " ).append("\n"); 
		query.append("       		AND (( A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ) IN (" ).append("\n"); 
		query.append("	       		#foreach( ${key} in ${vvdnumberArr}) " ).append("\n"); 
		query.append("		      		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			    		( '${key.vslCd}', '${key.skdVoyNo}', '${key.skdDirCd}' )" ).append("\n"); 
		query.append("		      		#else " ).append("\n"); 
		query.append(" 			    		, ( '${key.vslCd}', '${key.skdVoyNo}', '${key.skdDirCd}' )" ).append("\n"); 
		query.append("		      		#end " ).append("\n"); 
		query.append("	       		#end " ).append("\n"); 
		query.append("        	))" ).append("\n"); 
		query.append("      	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	#if($refnumberArr.size() > 0) " ).append("\n"); 
		query.append("        	AND (" ).append("\n"); 
		query.append("	       		#foreach( ${key} in ${refnumberArr}) " ).append("\n"); 
		query.append("		      		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			  			( " ).append("\n"); 
		query.append("							A.REF_ID = '${key.refId}' " ).append("\n"); 
		query.append("							#if(${key.refSeq} != '') " ).append("\n"); 
		query.append("								AND A.REF_SEQ = ${key.refSeq} " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("		      		#else " ).append("\n"); 
		query.append(" 			    		OR ( " ).append("\n"); 
		query.append("							A.REF_ID = '${key.refId}' " ).append("\n"); 
		query.append("							#if(${key.refSeq} != '') " ).append("\n"); 
		query.append("								AND A.REF_SEQ = ${key.refSeq} " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("		      		#end " ).append("\n"); 
		query.append("	       		#end " ).append("\n"); 
		query.append("       		)" ).append("\n"); 
		query.append("      	#end " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     	#if($sonumberArr.size() > 0) " ).append("\n"); 
		query.append("      		AND ( " ).append("\n"); 
		query.append("	       			#foreach( ${key} in ${sonumberArr}) 			" ).append("\n"); 
		query.append("		      			#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			     			( A.TRSP_SO_OFC_CTY_CD =  '${key.trspSoOfcCtyCd}'" ).append("\n"); 
		query.append("							#if(${key.trspSoSeq}!= '')" ).append("\n"); 
		query.append("								AND A.TRSP_SO_SEQ = ${key.trspSoSeq}" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("		      			#else " ).append("\n"); 
		query.append(" 			     			OR ( A.TRSP_SO_OFC_CTY_CD =  '${key.trspSoOfcCtyCd}'" ).append("\n"); 
		query.append("							#if(${key.trspSoSeq} != '')" ).append("\n"); 
		query.append("								AND A.TRSP_SO_SEQ = ${key.trspSoSeq}" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("	       			#end " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("       	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	#if($wonumberArr.size() > 0) " ).append("\n"); 
		query.append("      		AND ( " ).append("\n"); 
		query.append("	       			#foreach( ${key} in ${wonumberArr}) 			" ).append("\n"); 
		query.append("		      			#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			     			( AA.TRSP_WO_OFC_CTY_CD =  '${key.trspWoOfcCtyCd}'" ).append("\n"); 
		query.append("							#if(${key.trspWoSeq}!= '')" ).append("\n"); 
		query.append("								AND AA.TRSP_WO_SEQ = ${key.trspWoSeq}" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("		      			#else " ).append("\n"); 
		query.append(" 			     			OR ( AA.TRSP_WO_OFC_CTY_CD =  '${key.trspWoOfcCtyCd}'" ).append("\n"); 
		query.append("							#if(${key.trspWoSeq} != '')" ).append("\n"); 
		query.append("								AND AA.TRSP_WO_SEQ = ${key.trspWoSeq}" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("	       			#end " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("       	#end " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("      	#if($blnumberArr.size() > 0) " ).append("\n"); 
		query.append("        	AND A.BL_NO IN (" ).append("\n"); 
		query.append("	       		#foreach( ${key} in ${blnumberArr}) " ).append("\n"); 
		query.append("		      		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			    		'${key}'" ).append("\n"); 
		query.append("		      		#else " ).append("\n"); 
		query.append(" 			    		, '${key}'" ).append("\n"); 
		query.append("		      		#end " ).append("\n"); 
		query.append("	       		#end " ).append("\n"); 
		query.append("        	)" ).append("\n"); 
		query.append("      	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	#if($bkgnumberArr.size() > 0)" ).append("\n"); 
		query.append("  	     	AND A.BKG_NO IN (" ).append("\n"); 
		query.append("	       		#foreach( ${key} in ${bkgnumberArr}) " ).append("\n"); 
		query.append("		      		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			    		'${key}'	" ).append("\n"); 
		query.append("		      		#else " ).append("\n"); 
		query.append(" 			    		, '${key}'	" ).append("\n"); 
		query.append("		      		#end " ).append("\n"); 
		query.append("	       		#end " ).append("\n"); 
		query.append("	    	)" ).append("\n"); 
		query.append("      	#end      " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("      	#if($eqnumberArr.size() > 0)" ).append("\n"); 
		query.append("  	     	AND A.EQ_NO IN (" ).append("\n"); 
		query.append("	       		#foreach( ${key} in ${eqnumberArr}) " ).append("\n"); 
		query.append("		      		#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 			    		'${key}'	" ).append("\n"); 
		query.append("		      		#else " ).append("\n"); 
		query.append(" 			    		, '${key}'	" ).append("\n"); 
		query.append("		      		#end " ).append("\n"); 
		query.append("	       		#end " ).append("\n"); 
		query.append("	     	)" ).append("\n"); 
		query.append("      	#end    " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("	    ORDER BY   EQ_NO ASC                                                                   " ).append("\n"); 
		query.append("	    	, TRSP_SPL_SO_TP_CD     ASC                                                                   " ).append("\n"); 
		query.append("	        , EQ_TPSZ_CD            ASC                                                                   " ).append("\n"); 
		query.append("	        , TRSP_COST_DTL_MOD_CD  ASC                                                                   " ).append("\n"); 
		query.append("	        , TRSP_CRR_MOD_CD       ASC                                                                   " ).append("\n"); 
		query.append("	        , WO_NUMBER             ASC         		                                                   " ).append("\n"); 
		query.append(") X,                                                                                                      " ).append("\n"); 
		query.append("(                                                                                                      " ).append("\n"); 
		query.append("	SELECT 1 BASIS_NO2 	FROM DUAL	" ).append("\n"); 
		query.append("	UNION ALL         " ).append("\n"); 
		query.append("    SELECT 2 			FROM DUAL	" ).append("\n"); 
		query.append("	UNION ALL         " ).append("\n"); 
		query.append("    SELECT 3			FROM DUAL	                   " ).append("\n"); 
		query.append(") Z                                                                                                    " ).append("\n"); 
		query.append("ORDER BY   X.BASIS_NO  ASC, Z.BASIS_NO2 ASC" ).append("\n"); 

	}
}