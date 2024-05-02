/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOGetManualRevVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOGetManualRevVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetManualRevVVDList
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOGetManualRevVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOGetManualRevVVDListRSQL").append("\n"); 
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
		query.append("SELECT FINC_VSL_CD," ).append("\n"); 
		query.append("		FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("		FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("		LGS_COST_CD," ).append("\n"); 
		query.append("		TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("		TML_SO_SEQ," ).append("\n"); 
		query.append("		TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		, CASE WHEN FINC_VSL_CD IS NULL OR FINC_VSL_CD = 'CNTC' THEN 0 ELSE 1 END RNK" ).append("\n"); 
		query.append(" FROM   ( SELECT DISTINCT" ).append("\n"); 
		query.append("				 'CNTC' FINC_VSL_CD," ).append("\n"); 
		query.append("				 CASE" ).append("\n"); 
		query.append("				 -- // CHM-201433246 [TES] 신규 Cost Code 생성(SVDRTM) (MTY TS에 따른 Volume Incentive처리를 위한 비용코드 추가) - 4347-12-15" ).append("\n"); 
		query.append("				 WHEN D.LGS_COST_CD IN ('SVDRMT', 'SVDRTM')  --// 아직 SVDRTM은 운영 안하고 있어서 넣지 않으나 차후에 넣게 되면 여기에 추가해야함" ).append("\n"); 
		query.append("				 THEN DECODE(D.VSL_CD,'CNTC',D.SKD_VOY_NO,TO_CHAR(D.ATB_DT,'YYMM'))" ).append("\n"); 
		query.append("				 ELSE " ).append("\n"); 
		query.append("				 DECODE(NVL((SELECT CASE WHEN SUM(DECODE(A.CLZ_STS_CD,'O',1,0)) > 0 THEN 'O' ELSE 'C' END STS" ).append("\n"); 
		query.append("							 FROM AP_PERIOD A" ).append("\n"); 
		query.append("							 WHERE A.SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("							 AND A.EFF_YRMON = CASE               														  --2009-01-19 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("											   WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("											   THEN DECODE(D.REV_YRMON,NULL,TO_CHAR(H.ISS_DT,'YYYYMM'),'',TO_CHAR(H.ISS_DT,'YYYYMM'),D.REV_YRMON)" ).append("\n"); 
		query.append("											   WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'A'               					  --2009-02-12 OF-FD-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("											   THEN" ).append("\n"); 
		query.append("													CASE" ).append("\n"); 
		query.append("													WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("														  FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("														  WHERE CL.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = D.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("													THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("														 FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("														 WHERE CL.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = D.TML_SO_SEQ),'YYYYMM')" ).append("\n"); 
		query.append("													WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("													THEN SUBSTR(H.FM_PRD_DT,1,6)" ).append("\n"); 
		query.append("													ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("													END" ).append("\n"); 
		query.append("											   ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("											   END" ).append("\n"); 
		query.append("							 AND A.OFC_CD IN (@[ap_ofc_cd],(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[ap_ofc_cd]))" ).append("\n"); 
		query.append("							 AND A.AR_AP_DIV_CD = 'P'),'C')," ).append("\n"); 
		query.append("							 'O',CASE                              --2009-01-19 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("								 WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'M'                              --2009-01-19 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("								 THEN DECODE(D.REV_YRMON,NULL,TO_CHAR(H.ISS_DT,'YYMM'),'',TO_CHAR(H.ISS_DT,'YYMM'),SUBSTR(D.REV_YRMON,3,4))" ).append("\n"); 
		query.append("								 WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'A'									  --2009-02-12 OF-FD-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("								 THEN" ).append("\n"); 
		query.append("									  CASE" ).append("\n"); 
		query.append("									  WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("											FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("											WHERE CL.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = D.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("									  THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("										   FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("										   WHERE CL.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = D.TML_SO_SEQ),'YYMM')                          --2009-02-20 : 재무항차 자리수 년월(YYMM)만으로 변경" ).append("\n"); 
		query.append("									  WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("									  THEN SUBSTR(H.FM_PRD_DT,3,4)" ).append("\n"); 
		query.append("									  ELSE TO_CHAR(H.ISS_DT,'YYMM')" ).append("\n"); 
		query.append("									  END" ).append("\n"); 
		query.append("								 ELSE MAX(TO_CHAR(H.ISS_DT,'YYMM'))" ).append("\n"); 
		query.append("								 END ," ).append("\n"); 
		query.append("							 'C',(SELECT SUBSTR(MIN(N.EFF_YRMON),3,4)" ).append("\n"); 
		query.append("								  FROM AP_PERIOD N" ).append("\n"); 
		query.append("								  WHERE N.SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("								  AND N.EFF_YRMON >= CASE                     --2009-02-12 OF-FD-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("													 WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("													 THEN DECODE(D.REV_YRMON,NULL,TO_CHAR(H.ISS_DT,'YYYYMM'),'',TO_CHAR(H.ISS_DT,'YYYYMM'),D.REV_YRMON)" ).append("\n"); 
		query.append("													 WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'A'						 --2009-02-12 OF-TMNL-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("													 THEN" ).append("\n"); 
		query.append("														  CASE" ).append("\n"); 
		query.append("														  WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("																FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("																WHERE CL.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = D.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("														  THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("															   FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("															   WHERE CL.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = D.TML_SO_SEQ),'YYYYMM')" ).append("\n"); 
		query.append("														  WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("														  THEN SUBSTR(H.FM_PRD_DT,1,6)" ).append("\n"); 
		query.append("														  ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("														  END" ).append("\n"); 
		query.append("													 ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("													 END" ).append("\n"); 
		query.append("								  AND N.OFC_CD IN (@[ap_ofc_cd],(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[ap_ofc_cd]))" ).append("\n"); 
		query.append("								  AND N.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("								  AND N.CLZ_STS_CD = 'O'))" ).append("\n"); 
		query.append("                 END FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 'MM' FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 D.LGS_COST_CD," ).append("\n"); 
		query.append("				 D.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 D.TML_SO_SEQ," ).append("\n"); 
		query.append("				 D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		  FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		  WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("		  AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD  = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ         = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("		  AND    NVL(H.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("		  AND    ( D.CALC_COST_GRP_CD IN ('SD','SP') --수정(20080111)" ).append("\n"); 
		query.append("		  OR       D.CALC_TP_CD       = 'M' )" ).append("\n"); 
		query.append("		  AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("		  AND    C.CNTR_STY_CD        = 'M'" ).append("\n"); 
		query.append("		  GROUP BY D.LGS_COST_CD, D.TML_SO_OFC_CTY_CD, D.TML_SO_SEQ, D.TML_SO_DTL_SEQ, H.ISS_DT, H.TML_INV_TP_CD, D.CALC_TP_CD, D.REV_YRMON, H.FM_PRD_DT, DECODE(D.VSL_CD,'CNTC',D.SKD_VOY_NO,TO_CHAR(D.ATB_DT,'YYMM'))" ).append("\n"); 
		query.append("		  UNION ALL" ).append("\n"); 
		query.append("		  SELECT DISTINCT" ).append("\n"); 
		query.append("					DECODE(NVL(A.TML_CRR_CD,'SML'),'SML'," ).append("\n"); 
		query.append("                               DECODE(R.SLAN_DIR_CD||R.RLANE_DIR_CD,NULL," ).append("\n"); 
		query.append("                               DECODE(V.VSL_CD,NULL,'CNTC',V.VSL_CD),A.VSL_CD),'CNTC') FINC_VSL_CD," ).append("\n"); 
		query.append("                    DECODE(NVL(A.TML_CRR_CD,'SML'),'SML'," ).append("\n"); 
		query.append("                               DECODE(R.SLAN_DIR_CD||R.RLANE_DIR_CD,NULL," ).append("\n"); 
		query.append("                               DECODE(V.SKD_VOY_NO,NULL,TO_CHAR(A.ATB_DT,'YYMM'),V.SKD_VOY_NO),A.SKD_VOY_NO)," ).append("\n"); 
		query.append("                               TO_CHAR(A.ATB_DT,'YYMM')) FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("						CASE                                                                                                         -- 2009-02-17: 재무항차 삭제건 DIR CD 조회 LOGIC 변경" ).append("\n"); 
		query.append("				 		WHEN NVL(A.TML_CRR_CD,'SML') = 'SML'" ).append("\n"); 
		query.append("				 		THEN" ).append("\n"); 
		query.append("							CASE" ).append("\n"); 
		query.append("							WHEN R.SLAN_DIR_CD||R.RLANE_DIR_CD IS NULL" ).append("\n"); 
		query.append("							THEN DECODE(V.SKD_DIR_CD||V.RLANE_DIR_CD,NULL,'MM',V.SKD_DIR_CD||V.RLANE_DIR_CD)" ).append("\n"); 
		query.append("							ELSE (" ).append("\n"); 
		query.append("								NVL(" ).append("\n"); 
		query.append("								(SELECT DISTINCT MAX(M.SKD_DIR_CD||M.RLANE_DIR_CD)" ).append("\n"); 
		query.append("								FROM AR_MST_REV_VVD M" ).append("\n"); 
		query.append("								WHERE M.VSL_CD = DECODE(NVL(A.TML_CRR_CD,'SML'),'SML',A.VSL_CD,'CNTC')" ).append("\n"); 
		query.append("								AND M.SKD_VOY_NO = DECODE(NVL(A.TML_CRR_CD,'SML'),'SML',A.SKD_VOY_NO,TO_CHAR(A.ATB_DT,'YYMM'))" ).append("\n"); 
		query.append("								AND M.SKD_DIR_CD = R.SLAN_DIR_CD" ).append("\n"); 
		query.append("								AND NVL(M.DELT_FLG,'N') <> 'Y'), R.SLAN_DIR_CD||R.RLANE_DIR_CD)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("				 		ELSE 'MM'" ).append("\n"); 
		query.append("					END FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 A.LGS_COST_CD," ).append("\n"); 
		query.append("				 A.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 A.TML_SO_SEQ," ).append("\n"); 
		query.append("				 A.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		  FROM   ( SELECT D.VSL_CD," ).append("\n"); 
		query.append("						  H.ISS_DT," ).append("\n"); 
		query.append("						  D.ATB_DT," ).append("\n"); 
		query.append("						  D.SKD_VOY_NO," ).append("\n"); 
		query.append("						  SUBSTR(D.SKD_DIR_CD,1,1) SKD_DIR_CD," ).append("\n"); 
		query.append("						  V.SLAN_CD," ).append("\n"); 
		query.append("						  S.SCONTI_CD," ).append("\n"); 
		query.append("						  D.LGS_COST_CD," ).append("\n"); 
		query.append("						  D.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("						  D.TML_SO_SEQ," ).append("\n"); 
		query.append("						  D.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("						  D.TML_CRR_CD," ).append("\n"); 
		query.append("						  DECODE(D.REV_YRMON,NULL,TO_CHAR(H.ISS_DT,'YYMM')) CNTC_YRMON" ).append("\n"); 
		query.append("					FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_COST C, BKG_VVD V, MDM_LOCATION S" ).append("\n"); 
		query.append("					WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("					AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("					AND    H.TML_SO_OFC_CTY_CD  = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("					AND    H.TML_SO_SEQ         = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("					AND    ( D.CALC_COST_GRP_CD IN ('SD','SP')  --수정(20080111)" ).append("\n"); 
		query.append("					OR       D.CALC_TP_CD       = 'M' )" ).append("\n"); 
		query.append("					AND    H.TML_INV_TP_CD      = 'TM'" ).append("\n"); 
		query.append("					AND    NVL(H.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("					AND    NVL(D.VSL_CD,'CNTC') <> 'CNTC'" ).append("\n"); 
		query.append("					AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("					AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("					AND    D.VSL_CD            = V.VSL_CD(+)" ).append("\n"); 
		query.append("					AND    D.SKD_VOY_NO        = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("					AND    D.SKD_DIR_CD        = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("					AND    SUBSTR(H.YD_CD,1,5) = S.LOC_CD(+) ) A, --AR_FINC_DIR_CONV R, AR_MST_REV_VVD V" ).append("\n"); 
		query.append("					(SELECT R.* FROM AR_FINC_DIR_CONV R WHERE NVL(R.DELT_FLG,'N') <> 'Y') R," ).append("\n"); 
		query.append("					(SELECT V.* FROM AR_MST_REV_VVD V WHERE NVL(V.DELT_FLG,'N') <> 'Y') V" ).append("\n"); 
		query.append("		  WHERE  A.SLAN_CD   = R.SLAN_CD(+)                                                                                   --2007-09-20 (+)제거" ).append("\n"); 
		query.append("		  AND    A.SCONTI_CD = R.SCONTI_CD(+)                                                                                 --2007-09-20 (+)제거" ).append("\n"); 
		query.append("		  AND    A.SKD_DIR_CD = R.SLAN_DIR_CD(+)                                                                              --2007-09-20 (+)제거" ).append("\n"); 
		query.append("		  AND    A.VSL_CD     = V.VSL_CD(+)" ).append("\n"); 
		query.append("		  AND    A.SKD_VOY_NO = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("		  AND    A.SKD_DIR_CD = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("		  AND    A.SKD_DIR_CD = V.RLANE_DIR_CD(+)" ).append("\n"); 
		query.append("		  UNION ALL" ).append("\n"); 
		query.append("		  SELECT DISTINCT" ).append("\n"); 
		query.append("				 VSL_CD FINC_VSL_CD," ).append("\n"); 
		query.append("				 SKD_VOY_NO FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 'MM' FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 D.LGS_COST_CD," ).append("\n"); 
		query.append("				 D.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 D.TML_SO_SEQ," ).append("\n"); 
		query.append("				 D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		  FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		  WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("		  AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD  = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ         = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("		  AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		  AND    ( D.CALC_COST_GRP_CD IN ('SD','SP')  --수정(20080111)" ).append("\n"); 
		query.append("		  OR       D.CALC_TP_CD       = 'M' )" ).append("\n"); 
		query.append("		  AND    D.VSL_CD             = 'CNTC'" ).append("\n"); 
		query.append("		  AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("		  AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("		  UNION ALL" ).append("\n"); 
		query.append("		  SELECT DISTINCT" ).append("\n"); 
		query.append("				 'CNTC' FINC_VSL_CD," ).append("\n"); 
		query.append("				 CASE                                                                                                        	 --2009-01-19 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("				 WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("				 THEN DECODE(D.REV_YRMON,NULL,TO_CHAR(H.ISS_DT,'YYMM'),'',TO_CHAR(H.ISS_DT,'YYMM'),SUBSTR(D.REV_YRMON,3,4))" ).append("\n"); 
		query.append("				 WHEN H.TML_INV_TP_CD IN ('OF','ST') AND D.CALC_TP_CD = 'A'						      	 --2009-02-12 OF-FD-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("				 THEN" ).append("\n"); 
		query.append("					  CASE" ).append("\n"); 
		query.append("					  WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("							FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("							WHERE CL.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = H.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("					  THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("						   FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("						   WHERE CL.TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = H.TML_SO_SEQ),'YYMM')" ).append("\n"); 
		query.append("					  WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("					  THEN SUBSTR(H.FM_PRD_DT,3,4)" ).append("\n"); 
		query.append("					  ELSE TO_CHAR(H.ISS_DT,'YYMM')" ).append("\n"); 
		query.append("					  END" ).append("\n"); 
		query.append("				 ELSE TO_CHAR(H.ISS_DT,'YYMM')" ).append("\n"); 
		query.append("				 END FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 'MM' FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 D.LGS_COST_CD," ).append("\n"); 
		query.append("				 D.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 D.TML_SO_SEQ," ).append("\n"); 
		query.append("				 D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		  FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		  WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("		  AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD  = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ         = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("		  AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		  AND    ( D.CALC_COST_GRP_CD IN ('SD','SP')  --수정(20080111)" ).append("\n"); 
		query.append("		  OR       D.CALC_TP_CD       = 'M' )" ).append("\n"); 
		query.append("		  AND    D.VSL_CD             IS NULL" ).append("\n"); 
		query.append("		  AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("		  AND    C.CNTR_STY_CD        = 'F' )" ).append("\n"); 
		query.append(" ORDER BY TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_DTL_SEQ, RNK, FINC_VSL_CD, FINC_SKD_VOY_NO" ).append("\n"); 

	}
}