/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOGetAutoRevVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOGetAutoRevVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAutoRevVVDList
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOGetAutoRevVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOGetAutoRevVVDListRSQL").append("\n"); 
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
		query.append("		CNTR_NO," ).append("\n"); 
		query.append("		TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("		TML_SO_SEQ," ).append("\n"); 
		query.append("		TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		, CASE WHEN FINC_VSL_CD IS NULL OR FINC_VSL_CD = 'CNTC' THEN 0 ELSE 1 END RNK" ).append("\n"); 
		query.append(" FROM   ( SELECT DISTINCT" ).append("\n"); 
		query.append("				 'CNTC' FINC_VSL_CD," ).append("\n"); 
		query.append("				 DECODE(NVL((SELECT CASE WHEN SUM(DECODE(A.CLZ_STS_CD,'O',1,0)) > 0 THEN 'O' ELSE 'C' END STS" ).append("\n"); 
		query.append("							 FROM AP_PERIOD A" ).append("\n"); 
		query.append("							 WHERE A.SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("--		                             AND A.EFF_YRMON = TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("							 AND A.EFF_YRMON = CASE WHEN H.TML_INV_TP_CD IN ('OF')									   --2009-02-12 OF-TMNL-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("											   THEN" ).append("\n"); 
		query.append("													CASE" ).append("\n"); 
		query.append("													WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("														  FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("														  WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("													THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("														  FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("														  WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ),'YYYYMM')" ).append("\n"); 
		query.append("													WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("													THEN SUBSTR(H.FM_PRD_DT,1,6)" ).append("\n"); 
		query.append("													ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("													END" ).append("\n"); 
		query.append("											   ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("											   END" ).append("\n"); 
		query.append("							 AND A.OFC_CD IN (@[ap_ofc_cd],(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[ap_ofc_cd]))" ).append("\n"); 
		query.append("							 AND A.AR_AP_DIV_CD = 'P'),'C')," ).append("\n"); 
		query.append("--		                             'O',MAX(TO_CHAR(H.ISS_DT,'YYMM'))," ).append("\n"); 
		query.append("							 'O',CASE 															   --2009-02-12 OF-TMNL-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("								 WHEN H.TML_INV_TP_CD IN ('OF')" ).append("\n"); 
		query.append("								 THEN CASE" ).append("\n"); 
		query.append("									  WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("											FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("											WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("									  THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("										   FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("										   WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ),'YYMM')" ).append("\n"); 
		query.append("									  WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("									  THEN SUBSTR(H.FM_PRD_DT,3,4)" ).append("\n"); 
		query.append("									  ELSE MAX(TO_CHAR(H.ISS_DT,'YYMM'))" ).append("\n"); 
		query.append("									  END" ).append("\n"); 
		query.append("								 ELSE MAX(TO_CHAR(H.ISS_DT,'YYMM'))" ).append("\n"); 
		query.append("								 END," ).append("\n"); 
		query.append("							 'C',(SELECT SUBSTR(MIN(N.EFF_YRMON),3,4)" ).append("\n"); 
		query.append("								  FROM AP_PERIOD N" ).append("\n"); 
		query.append("								  WHERE N.SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("--		                                  AND N.EFF_YRMON >= TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("								  AND N.EFF_YRMON >= CASE WHEN H.TML_INV_TP_CD IN ('OF')					 --2009-02-12 OF-TMNL-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("													 THEN" ).append("\n"); 
		query.append("														  CASE" ).append("\n"); 
		query.append("														  WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("																FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("																WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("														  THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("																FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("																WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ),'YYYYMM')" ).append("\n"); 
		query.append("														  WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("														  THEN SUBSTR(H.FM_PRD_DT,1,6)" ).append("\n"); 
		query.append("														  ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("														  END" ).append("\n"); 
		query.append("													 ELSE TO_CHAR(H.ISS_DT,'YYYYMM')" ).append("\n"); 
		query.append("													 END" ).append("\n"); 
		query.append("								  AND N.OFC_CD IN (@[ap_ofc_cd],(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = @[ap_ofc_cd]))" ).append("\n"); 
		query.append("								  AND N.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("								  AND N.CLZ_STS_CD = 'O')) FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 'MM' FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 L.CNTR_NO," ).append("\n"); 
		query.append("				 L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 L.TML_SO_SEQ," ).append("\n"); 
		query.append("				 L.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		  FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		  WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("		  AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("		  AND    NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("		  AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP','EQ') --수정(20080111)" ).append("\n"); 
		query.append("		  AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("		  AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("		  AND    NVL(L.CNTR_TPSZ_CD,'N') 	= NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("--수정(20070920) -- B" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("				 'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("				 'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S','O','O',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("        	   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("--수정(20070920) -- E" ).append("\n"); 
		query.append("		  AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("		  AND    C.CNTR_STY_CD        = 'M'" ).append("\n"); 
		query.append("		  GROUP BY L.CNTR_NO, L.TML_SO_OFC_CTY_CD, L.TML_SO_SEQ, L.TML_SO_CNTR_LIST_SEQ, H.ISS_DT, H.TML_INV_TP_CD, H.FM_PRD_DT                           --2009-02-12 OF-TMNL-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("		  UNION ALL" ).append("\n"); 
		query.append("		  SELECT DISTINCT                                                " ).append("\n"); 
		query.append("			   DECODE(V.VSL_CD,NULL,'CNTC',V.VSL_CD) FINC_VSL_CD," ).append("\n"); 
		query.append("			   DECODE(V.SKD_VOY_NO,NULL,DECODE(H.TML_INV_TP_CD,'TM',TO_CHAR(D.ATB_DT,'YYMM'),TO_CHAR(H.ISS_DT,'YYMM')),V.SKD_VOY_NO) FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("			   DECODE(V.SKD_DIR_CD||V.RLANE_DIR_CD,NULL,'MM',V.SKD_DIR_CD||V.RLANE_DIR_CD) FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("			   L.CNTR_NO," ).append("\n"); 
		query.append("			   L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("			   L.TML_SO_SEQ," ).append("\n"); 
		query.append("			   L.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C, AR_MST_REV_VVD V" ).append("\n"); 
		query.append("		WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("		AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("		AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("        AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("		AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP','EQ') --수정(20080111)" ).append("\n"); 
		query.append("		AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("		AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("		AND    NVL(L.CNTR_TPSZ_CD,'N') 	= NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("--수정(20070920) -- B" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("				 'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("				 'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S','O','O',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("		AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("/* 2008-07-07 : 이경한 대리 요청 사항으로 Terminal Invoice의 경우 CNTC항차에도 BKG이 있는 경우가 있어 전체 비교 한다.  */" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM','Y',L.VSL_CD) <> DECODE(H.TML_INV_TP_CD,'TM','N','CNTC')" ).append("\n"); 
		query.append("		AND    L.BKG_NO             IS NOT NULL" ).append("\n"); 
		query.append("		AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("		AND    L.VSL_CD            = V.VSL_CD(+)" ).append("\n"); 
		query.append("		AND    L.SKD_VOY_NO        = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("		AND    L.SKD_DIR_CD        = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND    L.LANE_CD           = V.SLAN_CD(+)" ).append("\n"); 
		query.append("		  UNION ALL" ).append("\n"); 
		query.append("		  SELECT DISTINCT" ).append("\n"); 
		query.append("				 DECODE(NVL(A.TML_CRR_CD,'NYK'),'NYK'," ).append("\n"); 
		query.append("				   DECODE(R.SLAN_DIR_CD||R.RLANE_DIR_CD,NULL," ).append("\n"); 
		query.append("				   DECODE(V.VSL_CD,NULL,'CNTC',V.VSL_CD),A.VSL_CD),'CNTC') FINC_VSL_CD," ).append("\n"); 
		query.append("				 DECODE(NVL(A.TML_CRR_CD,'NYK'),'NYK'," ).append("\n"); 
		query.append("				   DECODE(R.SLAN_DIR_CD||R.RLANE_DIR_CD,NULL," ).append("\n"); 
		query.append("				   DECODE(V.SKD_VOY_NO,NULL,TO_CHAR(A.ATB_DT,'YYMM'),V.SKD_VOY_NO),A.SKD_VOY_NO)," ).append("\n"); 
		query.append("				   TO_CHAR(A.ISS_DT,'YYMM'))    FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 DECODE(NVL(A.TML_CRR_CD,'NYK'),'NYK'," ).append("\n"); 
		query.append("				   DECODE(R.SLAN_DIR_CD||R.RLANE_DIR_CD,NULL," ).append("\n"); 
		query.append("				   DECODE(V.SKD_DIR_CD||V.RLANE_DIR_CD,NULL,'MM',V.SKD_DIR_CD||V.RLANE_DIR_CD),R.SLAN_DIR_CD||R.RLANE_DIR_CD)," ).append("\n"); 
		query.append("				   'MM') FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 A.CNTR_NO," ).append("\n"); 
		query.append("				 A.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 A.TML_SO_SEQ," ).append("\n"); 
		query.append("				 A.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		  FROM   ( SELECT L.VSL_CD," ).append("\n"); 
		query.append("						  L.ATB_DT," ).append("\n"); 
		query.append("						  L.SKD_VOY_NO," ).append("\n"); 
		query.append("						  SUBSTR(L.SKD_DIR_CD,1,1) SKD_DIR_CD,																					" ).append("\n"); 
		query.append("						  V.SLAN_CD," ).append("\n"); 
		query.append("						  S.SCONTI_CD," ).append("\n"); 
		query.append("						  L.CNTR_NO," ).append("\n"); 
		query.append("						  L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("						  L.TML_SO_SEQ," ).append("\n"); 
		query.append("						  L.TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("						  D.TML_CRR_CD," ).append("\n"); 
		query.append("						  H.ISS_DT" ).append("\n"); 
		query.append("				   FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C, BKG_VVD V, MDM_LOCATION S" ).append("\n"); 
		query.append("				   WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("				   AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("				   AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				   AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("				   AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				   AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("				   AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("				   AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP','EQ') --수정(20080111)" ).append("\n"); 
		query.append("				   AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("				   AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("				   AND    NVL(L.CNTR_TPSZ_CD,'N') 	= NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("--수정(20070920) -- B" ).append("\n"); 
		query.append("					AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("							= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("							DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("							'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("							'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("					AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S','O','O',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("					AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("--수정(20070920) -- E" ).append("\n"); 
		query.append("				   AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("				   AND    NVL(L.VSL_CD,'CNTC') <> 'CNTC'" ).append("\n"); 
		query.append("				   AND    L.BKG_NO             IS NULL" ).append("\n"); 
		query.append("				   AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("				   AND    L.VSL_CD            = V.VSL_CD(+)" ).append("\n"); 
		query.append("				   AND    L.SKD_VOY_NO        = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("				   AND    L.SKD_DIR_CD        = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("				   AND    SUBSTR(H.YD_CD,1,5) = S.LOC_CD(+) ) A, --AR_FINC_DIR_CONV R, AR_MST_REV_VVD V" ).append("\n"); 
		query.append("					(SELECT R.* FROM AR_FINC_DIR_CONV R WHERE NVL(R.DELT_FLG,'N') <> 'Y') R," ).append("\n"); 
		query.append("					(SELECT V.* FROM AR_MST_REV_VVD V WHERE NVL(V.DELT_FLG,'N') <> 'Y') V" ).append("\n"); 
		query.append("		  WHERE  A.SLAN_CD           = R.SLAN_CD(+)                                                                                                       --2007-09-20 (+)제거" ).append("\n"); 
		query.append("		  AND    A.SCONTI_CD         = R.SCONTI_CD(+)                                                                                                     --2007-09-20 (+)제거" ).append("\n"); 
		query.append("		  AND    A.SKD_DIR_CD        = R.SLAN_DIR_CD(+)                                                                                                   --2007-09-20 (+)제거" ).append("\n"); 
		query.append("		  AND    A.VSL_CD            = V.VSL_CD(+)" ).append("\n"); 
		query.append("		  AND    A.SKD_VOY_NO        = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("		  AND    A.SKD_DIR_CD        = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("		  AND    A.SKD_DIR_CD        = V.RLANE_DIR_CD(+)" ).append("\n"); 
		query.append("		  UNION ALL" ).append("\n"); 
		query.append("		  SELECT DISTINCT" ).append("\n"); 
		query.append("				 L.VSL_CD        FINC_VSL_CD," ).append("\n"); 
		query.append("				 L.SKD_VOY_NO    FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 L.SKD_DIR_CD||'M'    FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 L.CNTR_NO," ).append("\n"); 
		query.append("				 L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 L.TML_SO_SEQ," ).append("\n"); 
		query.append("				 L.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		  FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		  WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("		  AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("		  AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("		  AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP','EQ') --수정(20080111)" ).append("\n"); 
		query.append("		  AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("		  AND    L.VRFY_RSLT_IND_CD  	 = 'CO'" ).append("\n"); 
		query.append("		  AND    NVL(L.CNTR_TPSZ_CD,'N') 	= NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("--수정(20070920) -- B" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				   DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("				   'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("				   'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S','O','O',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("--수정(20070920) -- E" ).append("\n"); 
		query.append("		  AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("		  AND    L.VSL_CD             = 'CNTC'" ).append("\n"); 
		query.append("		  AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("		  UNION ALL" ).append("\n"); 
		query.append("		  SELECT DISTINCT" ).append("\n"); 
		query.append("				 'CNTC'          FINC_VSL_CD," ).append("\n"); 
		query.append("--		                 TO_CHAR(H.ISS_DT,'YYMM') FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 CASE WHEN H.TML_INV_TP_CD IN ('OF')													   --2009-02-12 OF-TMNL-AUTO 재무항차 년월 산출 LOGIC 변경" ).append("\n"); 
		query.append("				 THEN" ).append("\n"); 
		query.append("					  CASE" ).append("\n"); 
		query.append("					  WHEN (SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("							FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("							WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ) IS NOT NULL" ).append("\n"); 
		query.append("					  THEN TO_CHAR((SELECT MIN(CL.INV_GATE_IN_DT)" ).append("\n"); 
		query.append("						   FROM TES_TML_SO_CNTR_LIST CL" ).append("\n"); 
		query.append("						   WHERE CL.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD AND CL.TML_SO_SEQ = L.TML_SO_SEQ),'YYMM')" ).append("\n"); 
		query.append("					  WHEN H.FM_PRD_DT IS NOT NULL" ).append("\n"); 
		query.append("					  THEN SUBSTR(H.FM_PRD_DT,3,4)" ).append("\n"); 
		query.append("					  ELSE TO_CHAR(H.ISS_DT,'YYMM')" ).append("\n"); 
		query.append("					  END" ).append("\n"); 
		query.append("				 ELSE TO_CHAR(H.ISS_DT,'YYMM')" ).append("\n"); 
		query.append("				 END FINC_SKD_VOY_NO," ).append("\n"); 
		query.append("				 'MM'    FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				 L.CNTR_NO," ).append("\n"); 
		query.append("				 L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("				 L.TML_SO_SEQ," ).append("\n"); 
		query.append("				 L.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("		  FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		  WHERE  H.INV_NO             = @[inv_no]" ).append("\n"); 
		query.append("		  AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("		  AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("		  AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("		  AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP','EQ') --수정(20080111)" ).append("\n"); 
		query.append("		  AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("		  AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("		  AND    NVL(L.CNTR_TPSZ_CD,'N') 	= NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("--수정(20070920) -- B" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				   DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("				   'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("				   'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S','O','O',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("		  AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("				 = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("--수정(20070920) -- E" ).append("\n"); 
		query.append("		  AND    D.LGS_COST_CD        = C.LGS_COST_CD" ).append("\n"); 
		query.append("		  AND    C.CNTR_STY_CD        = 'F'" ).append("\n"); 
		query.append("		  AND    L.VSL_CD             IS NULL" ).append("\n"); 
		query.append("		  AND    L.BKG_NO             IS NULL )" ).append("\n"); 
		query.append(" ORDER BY TML_SO_OFC_CTY_CD, TML_SO_SEQ, TML_SO_CNTR_LIST_SEQ, RNK, FINC_VSL_CD, FINC_SKD_VOY_NO" ).append("\n"); 

	}
}