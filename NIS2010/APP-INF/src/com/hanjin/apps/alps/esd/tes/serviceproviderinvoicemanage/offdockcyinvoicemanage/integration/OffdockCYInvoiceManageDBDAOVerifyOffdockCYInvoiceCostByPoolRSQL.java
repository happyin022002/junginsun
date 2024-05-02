/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOVerifyOffdockCYInvoiceCostByPoolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.26
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2015.10.26 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOVerifyOffdockCYInvoiceCostByPoolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VerifyOffdockCYInvoiceCostByPool
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOVerifyOffdockCYInvoiceCostByPoolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOVerifyOffdockCYInvoiceCostByPoolRSQL").append("\n"); 
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
		query.append("SELECT 'I' IBFLAG, 'A' CALC_TP_CD, 'SP' CALC_COST_GRP_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mode} != '' and ${mode}=='M') " ).append("\n"); 
		query.append("			'M' FP_CALC_PRD_CD," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("			'D' FP_CALC_PRD_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      NVL(CALC.LGS_COST_CD,'SRFDMT') LGS_COST_CD, NVL(CALC.LGS_COST_CD,'SRFDMT') LGS_COST_CD2," ).append("\n"); 
		query.append(" 	   ORG.WRK_DT, ORG.INV_VOL_QTY, C.ACCT_CD, CALC.M_DATE," ).append("\n"); 
		query.append(" 	   NVL(CALC.TML_AGMT_OFC_CTY_CD,AGMT.TML_AGMT_OFC_CTY_CD) TML_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append(" 	   NVL(CALC.TML_AGMT_SEQ,AGMT.TML_AGMT_SEQ) TML_AGMT_SEQ," ).append("\n"); 
		query.append(" 	   NVL(CALC.TML_AGMT_VER_NO,AGMT.TML_AGMT_VER_NO) TML_AGMT_VER_NO," ).append("\n"); 
		query.append(" 	   NVL(CALC.FP_TEU_QTY,AGMT.FP_TEU_QTY) FP_TEU_QTY," ).append("\n"); 
		query.append(" 	   NVL(CALC.UOM,AGMT.UOM) VOL_TR_UT_CD, NVL(CALC.AGMT_UT_RT,AGMT.AGMT_UT_RT) CTRT_RT," ).append("\n"); 
		query.append(" 	   NVL(NVL(CALC.OVR_VOL_QTY,AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT,AGMT.AGMT_UT_RT),0) INV_AMT," ).append("\n"); 
		query.append(" 	   NVL(NVL(CALC.OVR_VOL_QTY,AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT,AGMT.AGMT_UT_RT),0) CALC_AMT," ).append("\n"); 
		query.append(" 	   NVL(CALC.STACKING_VOL,0) STK_VOL_QTY, NVL(CALC.STACKING_VOL,0) - ORG.INV_VOL_QTY DIFF_VOL_QTY," ).append("\n"); 
		query.append(" 	   DECODE(SIGN(NVL(CALC.OVR_VOL_QTY,AGMT.OVR_VOL_QTY)),-1,0,0,0,NVL(CALC.OVR_VOL_QTY,AGMT.OVR_VOL_QTY)) OVR_VOL_QTY," ).append("\n"); 
		query.append(" 	   NVL(CALC.CURR_CHK,AGMT.CURR_CHK) CURR_CHK, NVL(CALC.CURR_CD,AGMT.CURR_CD) CURR_CD, 1 INV_XCH_RT" ).append("\n"); 
		query.append("FROM   ( SELECT 'SRFDMT' LGS_COST_CD," ).append("\n"); 
		query.append("#if (${mode} != '' and ${mode}=='M') " ).append("\n"); 
		query.append("					SUBSTR(TGT_MVMT_DT,0,6) M_Date," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("					SUBSTR(TGT_MVMT_DT,0,8) M_Date," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                SUM(DECODE(M.CNTR_TPSZ_CD,'D7', M.CNTR_KNT,0))*2.25+" ).append("\n"); 
		query.append("                SUM(DECODE(M.CNTR_TPSZ_CD,'D8', M.CNTR_KNT,0))*2.4+" ).append("\n"); 
		query.append("                SUM(DECODE(M.CNTR_TPSZ_CD,'D9', M.CNTR_KNT,0))*2.4+" ).append("\n"); 
		query.append("                SUM(DECODE(M.CNTR_TPSZ_CD,'DW', M.CNTR_KNT,0))*2.65+" ).append("\n"); 
		query.append("                SUM(DECODE(M.CNTR_TPSZ_CD,'DX', M.CNTR_KNT,0))*2.25+" ).append("\n"); 
		query.append("                SUM(DECODE(M.CNTR_TPSZ_CD,'D7',0,'D8',0,'D9',0,'DW',0,'DX',0,DECODE(SUBSTR(M.CNTR_TPSZ_CD,2,1),2, M.CNTR_KNT,0)))+" ).append("\n"); 
		query.append("                SUM(DECODE(M.CNTR_TPSZ_CD,'D7',0,'D8',0,'D9',0,'DW',0,'DX',0,DECODE(SUBSTR(M.CNTR_TPSZ_CD,2,1),2,0, M.CNTR_KNT*2))) Stacking_Vol," ).append("\n"); 
		query.append(" 	            P.INV_VOL_QTY," ).append("\n"); 
		query.append(" 	            D.FP_TEU_QTY," ).append("\n"); 
		query.append(" 	            DECODE(SIGN(P.INV_VOL_QTY - D.FP_TEU_QTY),-1,0,0,0,(P.INV_VOL_QTY - D.FP_TEU_QTY)) OVR_VOL_QTY," ).append("\n"); 
		query.append(" 	            D.TML_AGMT_VOL_UT_CD UOM," ).append("\n"); 
		query.append(" 	            D.AGMT_UT_RT, H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append(" 	            (P.INV_VOL_QTY - D.FP_TEU_QTY) * D.AGMT_UT_RT Amount," ).append("\n"); 
		query.append(" 	            DECODE(@[curr_cd],D.CURR_CD,'Y','N') CURR_CHK, D.CURR_CD" ).append("\n"); 
		query.append("		 -- CHM-201538470 TES: MT Storage(FP)의 verify data 변경 (ATLAS->CIM) TES_EQ_LAND_STAY > CIM_DLY_INV_SMRY 변경 - (2015-10-22 양양선B) TEST만 반영 테스트후 라이브 반영 여부 결정" ).append("\n"); 
		query.append(" 	     FROM   CIM_DLY_INV_SMRY M, TES_TML_AGMT_HDR H, TES_TML_AGMT_DTL D, TES_FILE_IMP_TMP P" ).append("\n"); 
		query.append(" 	     WHERE  M.TGT_MVMT_DT  >= DECODE(@[mode],'D',P.WRK_DT,P.WRK_DT||'01')" ).append("\n"); 
		query.append(" 	     AND    M.TGT_MVMT_DT  <= DECODE(@[mode],'D',P.WRK_DT,TO_CHAR(LAST_DAY(TO_DATE(P.WRK_DT,'YYYYMM')),'YYYYMMDD'))" ).append("\n"); 
		query.append("-- 	     AND    M.CNTR_FULL_FLG <> 'Y'" ).append("\n"); 
		query.append(" 	     AND    P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" 	     AND    P.TML_SO_SEQ    = @[tml_so_seq]" ).append("\n"); 
		query.append(" 	     AND    M.YD_CD         = P.YD_CD" ).append("\n"); 
		query.append(" 	     AND    M.YD_CD         = H.YD_CD" ).append("\n"); 
		query.append(" 	     AND    H.VNDR_SEQ      = P.VNDR_SEQ" ).append("\n"); 
		query.append(" 	     AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("		 AND    M.MVMT_STS_CD     = 'MT' -- [CHM-201327805] 2013.11.21 양양선 부장님 요청으로 추가함. (Storage선 반영후 추가 요청임)" ).append("\n"); 
		query.append(" 	     AND    H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append(" 	     AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append(" 	                                  FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append(" 	                                  WHERE  M.YD_CD               = P.YD_CD" ).append("\n"); 
		query.append(" 	                                  AND    M.VNDR_SEQ            = P.VNDR_SEQ" ).append("\n"); 
		query.append(" 	                                  AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append(" 	                                  AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append(" 	                                  AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= P.FM_PRD_DT" ).append("\n"); 
		query.append(" 	                                  AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= P.TO_PRD_DT )" ).append("\n"); 
		query.append(" 	     AND    H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" 	     AND    H.TML_AGMT_SEQ        = D.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append(" 	     AND    H.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append(" 	     AND    D.TML_AGMT_TP_CD      = 'S'" ).append("\n"); 
		query.append(" 	     AND    D.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append(" 	     AND    D.LGS_COST_CD         = 'SRFDMT'" ).append("\n"); 
		query.append(" 	     AND    D.TML_STO_AGMT_TP_CD  = 'FP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mode} != '' and ${mode}=='M') " ).append("\n"); 
		query.append("	 	     AND    D.FP_CALC_PRD_CD      = 'M'" ).append("\n"); 
		query.append("	 	     GROUP BY SUBSTR(TGT_MVMT_DT,0,6), P.INV_VOL_QTY," ).append("\n"); 
		query.append("	 		  	      H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("	 			      D.FP_TEU_QTY, D.TML_AGMT_VOL_UT_CD, D.AGMT_UT_RT, D.CURR_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	 	     AND    D.FP_CALC_PRD_CD      = 'D'" ).append("\n"); 
		query.append("	 	     GROUP BY TGT_MVMT_DT, P.INV_VOL_QTY," ).append("\n"); 
		query.append("	 		  	      H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("	 			      D.FP_TEU_QTY, D.TML_AGMT_VOL_UT_CD, D.AGMT_UT_RT, D.CURR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 		) CALC, TES_LGS_COST C," ).append("\n"); 
		query.append("      (  SELECT WRK_DT, INV_VOL_QTY" ).append("\n"); 
		query.append(" 	      FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append(" 	      WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" 	      AND    TML_SO_SEQ = @[tml_so_seq] ) ORG," ).append("\n"); 
		query.append("      ( SELECT T.WRK_DT, T.INV_VOL_QTY, D.FP_TEU_QTY, D.TML_AGMT_VOL_UT_CD UOM, D.AGMT_UT_RT," ).append("\n"); 
		query.append(" 	            DECODE('USD',D.CURR_CD,'Y','N') CURR_CHK, D.CURR_CD," ).append("\n"); 
		query.append(" 	            H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append(" 	            DECODE(SIGN(T.INV_VOL_QTY - D.FP_TEU_QTY),-1,0,0,0,(T.INV_VOL_QTY - D.FP_TEU_QTY)) OVR_VOL_QTY" ).append("\n"); 
		query.append(" 	      FROM   TES_FILE_IMP_TMP T, TES_TML_AGMT_HDR H, TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append(" 	      WHERE  T.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" 	      AND    T.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append(" 	      AND    H.VNDR_SEQ      = T.VNDR_SEQ" ).append("\n"); 
		query.append("		  AND    H.YD_CD = T.YD_CD" ).append("\n"); 
		query.append(" 	      AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append(" 	      AND    H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("         AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                                        FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                                        WHERE  M.YD_CD               = T.YD_CD" ).append("\n"); 
		query.append("                                        AND    M.VNDR_SEQ            = T.VNDR_SEQ" ).append("\n"); 
		query.append("                                        AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                                        AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                                        AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= T.FM_PRD_DT" ).append("\n"); 
		query.append("                                        AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= T.TO_PRD_DT )" ).append("\n"); 
		query.append("           AND    H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND    H.TML_AGMT_SEQ        = D.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("           AND    H.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("           AND    D.TML_AGMT_TP_CD      = 'S'" ).append("\n"); 
		query.append("           AND    D.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append("           AND    D.LGS_COST_CD         = 'SRFDMT'" ).append("\n"); 
		query.append("           AND    D.TML_STO_AGMT_TP_CD  = 'FP'" ).append("\n"); 
		query.append("-- // 2009-12-23 [CHM-200901951] : Offdock Freepool calculation 월별/ 일별로 받는 부분에 처리되는 로직 수정" ).append("\n"); 
		query.append("-- 20091228 FILE IMPORT 시  월,일별로 나누어서 처리해야함 " ).append("\n"); 
		query.append("#if (${mode} != '' and ${mode}=='M') " ).append("\n"); 
		query.append("           AND    D.FP_CALC_PRD_CD      = 'M' ) AGMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND    D.FP_CALC_PRD_CD      = 'D' ) AGMT	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE ORG.WRK_DT       = CALC.M_DATE(+)" ).append("\n"); 
		query.append("AND   ORG.INV_VOL_QTY  = CALC.INV_VOL_QTY(+)" ).append("\n"); 
		query.append("AND   CALC.LGS_COST_CD = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND   ORG.WRK_DT       = AGMT.WRK_DT(+)" ).append("\n"); 
		query.append("AND   ORG.INV_VOL_QTY  = AGMT.INV_VOL_QTY(+)" ).append("\n"); 
		query.append("ORDER BY ORG.WRK_DT ASC" ).append("\n"); 

	}
}