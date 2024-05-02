/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceCostByPoolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2015.10.22 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceCostByPoolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VerifyStorageInvoiceCostByPool
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceCostByPoolRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceCostByPoolRSQL").append("\n"); 
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
		query.append("SELECT 	  'I' AS IBFLAG" ).append("\n"); 
		query.append("		, 'A' AS CALC_TP_CD" ).append("\n"); 
		query.append("		, 'SP' AS CALC_COST_GRP_CD" ).append("\n"); 
		query.append("#if (${mode} == 'M') " ).append("\n"); 
		query.append("		, 'M' FP_CALC_PRD_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		, 'D' FP_CALC_PRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		, NVL(CALC.LGS_COST_CD, 'SRNDMT') AS LGS_COST_CD" ).append("\n"); 
		query.append("		, NVL(CALC.LGS_COST_CD, 'SRNDMT') AS LGS_COST_CD2" ).append("\n"); 
		query.append("		, ORG.WRK_DT" ).append("\n"); 
		query.append("		, ORG.INV_VOL_QTY" ).append("\n"); 
		query.append("		, C.ACCT_CD" ).append("\n"); 
		query.append("		, CALC.M_DATE" ).append("\n"); 
		query.append("		, NVL(CALC.TML_AGMT_OFC_CTY_CD, AGMT.TML_AGMT_OFC_CTY_CD) AS TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, NVL(CALC.TML_AGMT_SEQ, AGMT.TML_AGMT_SEQ) AS TML_AGMT_SEQ" ).append("\n"); 
		query.append("		, NVL(CALC.TML_AGMT_VER_NO, AGMT.TML_AGMT_VER_NO) AS TML_AGMT_VER_NO" ).append("\n"); 
		query.append("		, NVL(CALC.FP_TEU_QTY, AGMT.FP_TEU_QTY) AS FP_TEU_QTY" ).append("\n"); 
		query.append("		, NVL(CALC.UOM, AGMT.UOM) AS VOL_TR_UT_CD" ).append("\n"); 
		query.append("		, NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT) AS CTRT_RT" ).append("\n"); 
		query.append("		-- CHM-201433247 MR Storage Cost Cal.(SR by FP)에서 Auto Cal하면 이중계산 되는 오류 수정 (양양선B 요청)" ).append("\n"); 
		query.append("		-- AGMT Tier Over Days 계산위한 로직 수정 (2015-03-10)" ).append("\n"); 
		query.append("--		, NVL(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), 0) AS INV_AMT" ).append("\n"); 
		query.append("--		, NVL(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), 0) AS CALC_AMT" ).append("\n"); 
		query.append("--		, NVL(DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, (NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1)  * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), (NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT))), 0) AS INV_AMT" ).append("\n"); 
		query.append("--		, NVL(DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, (NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1)  * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), (NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT))), 0) AS CALC_AMT" ).append("\n"); 
		query.append("		-- [CHM-201535623]TES: Over Days를 구하는 부분에서 Tier Over Days 값이 없는 경우를 고려한 로직 수정 (MR Storage) " ).append("\n"); 
		query.append("		, CASE WHEN NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) = 0 THEN NVL(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), 0)" ).append("\n"); 
		query.append("               ELSE NVL(DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, (NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1)  * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), (NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT))), 0)" ).append("\n"); 
		query.append("          END AS INV_AMT " ).append("\n"); 
		query.append("        , CASE WHEN NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) = 0 THEN NVL(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), 0)" ).append("\n"); 
		query.append("               ELSE NVL(DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, (NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1)  * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), (NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT))), 0) " ).append("\n"); 
		query.append("          END AS CALC_AMT" ).append("\n"); 
		query.append("		, NVL(CALC.STACKING_VOL, 0) AS STK_VOL_QTY" ).append("\n"); 
		query.append("		, NVL(CALC.STACKING_VOL, 0) - NVL(ORG.INV_VOL_QTY, 0) AS DIFF_VOL_QTY" ).append("\n"); 
		query.append("		-- CHM-201433247 MR Storage Cost Cal.(SR by FP)에서 Auto Cal하면 이중계산 되는 오류 수정 (양양선B 요청)" ).append("\n"); 
		query.append("		-- AGMT Tier Over Days 계산위한 로직 수정 (2015-03-10)" ).append("\n"); 
		query.append("--		, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY)), -1, 0, 0, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY)) AS OVR_VOL_QTY" ).append("\n"); 
		query.append("--		, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1, NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1 )) AS OVR_VOL_QTY" ).append("\n"); 
		query.append("		-- [CHM-201535623]TES: Over Days를 구하는 부분에서 Tier Over Days 값이 없는 경우를 고려한 로직 수정 (MR Storage) " ).append("\n"); 
		query.append("		, CASE WHEN NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) = 0 THEN DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY)), -1, 0, 0, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY))" ).append("\n"); 
		query.append("               ELSE DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1, NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1 ))" ).append("\n"); 
		query.append("		  END AS OVR_VOL_QTY" ).append("\n"); 
		query.append("		, NVL(CALC.CURR_CHK, AGMT.CURR_CHK) AS CURR_CHK" ).append("\n"); 
		query.append("		, NVL(CALC.CURR_CD, AGMT.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("		, 1 AS INV_XCH_RT" ).append("\n"); 
		query.append("		, NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) AS FM_TR_DYS" ).append("\n"); 
		query.append("		, NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) AS TO_TR_DYS" ).append("\n"); 
		query.append("FROM	( SELECT 'SRNDMT' AS LGS_COST_CD," ).append("\n"); 
		query.append("#if (${mode} == 'M') " ).append("\n"); 
		query.append("				SUBSTR(TGT_MVMT_DT, 0, 6) AS M_DATE," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("				SUBSTR(TGT_MVMT_DT, 0, 8) AS M_DATE," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				SUM(DECODE(M.CNTR_TPSZ_CD,'D7', M.CNTR_KNT,0))*2.25+" ).append("\n"); 
		query.append("				SUM(DECODE(M.CNTR_TPSZ_CD,'D8', M.CNTR_KNT,0))*2.4+" ).append("\n"); 
		query.append("				SUM(DECODE(M.CNTR_TPSZ_CD,'D9', M.CNTR_KNT,0))*2.4+" ).append("\n"); 
		query.append("				SUM(DECODE(M.CNTR_TPSZ_CD,'DW', M.CNTR_KNT,0))*2.65+" ).append("\n"); 
		query.append("				SUM(DECODE(M.CNTR_TPSZ_CD,'DX', M.CNTR_KNT,0))*2.25+" ).append("\n"); 
		query.append("				SUM(DECODE(M.CNTR_TPSZ_CD,'D7',0,'D8',0,'D9',0,'DW',0,'DX',0,DECODE(SUBSTR(M.CNTR_TPSZ_CD,2,1),2, M.CNTR_KNT,0)))+" ).append("\n"); 
		query.append("				SUM(DECODE(M.CNTR_TPSZ_CD,'D7',0,'D8',0,'D9',0,'DW',0,'DX',0,DECODE(SUBSTR(M.CNTR_TPSZ_CD,2,1),2,0, M.CNTR_KNT*2))) AS STACKING_VOL," ).append("\n"); 
		query.append("				P.INV_VOL_QTY," ).append("\n"); 
		query.append("				D.FP_TEU_QTY," ).append("\n"); 
		query.append("				DECODE(SIGN(P.INV_VOL_QTY - D.FP_TEU_QTY), -1, 0, 0, 0, (P.INV_VOL_QTY - D.FP_TEU_QTY)) OVR_VOL_QTY, --P.INV_VOL_QTY - D.FP_TEU_QTY OVR_VOL_QTY," ).append("\n"); 
		query.append("				D.TML_AGMT_VOL_UT_CD AS UOM," ).append("\n"); 
		query.append("				D.AGMT_UT_RT" ).append("\n"); 
		query.append("				, H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("				( P.INV_VOL_QTY - D.FP_TEU_QTY ) * D.AGMT_UT_RT AS AMOUNT," ).append("\n"); 
		query.append("				DECODE(@[curr_cd], D.CURR_CD, 'Y', 'N') AS CURR_CHK" ).append("\n"); 
		query.append("				, D.CURR_CD" ).append("\n"); 
		query.append("				--2015.04.20 [CHM-201535341]Storage Rate List에서 Tier Over Days 없어도 CNTR Verification되도록 설정변경" ).append("\n"); 
		query.append("				, NVL(FM_TR_DYS, 0) FM_TR_DYS" ).append("\n"); 
		query.append("				, NVL(TO_TR_DYS, 0) TO_TR_DYS" ).append("\n"); 
		query.append("		-- CHM-201538470 TES: MT Storage(FP)의 verify data 변경 (ATLAS->CIM) TES_EQ_LAND_STAY > CIM_DLY_INV_SMRY 변경 - (2015-10-22 양양선B) TEST만 반영 테스트후 라이브 반영 여부 결정" ).append("\n"); 
		query.append("        FROM   CIM_DLY_INV_SMRY M, TES_TML_AGMT_HDR H, TES_TML_AGMT_DTL D, TES_FILE_IMP_TMP P" ).append("\n"); 
		query.append("  	    WHERE  M.TGT_MVMT_DT  >= DECODE(@[mode], 'D', P.WRK_DT, P.WRK_DT||'01')" ).append("\n"); 
		query.append("  	    AND    M.TGT_MVMT_DT  <= DECODE(@[mode], 'D', P.WRK_DT, TO_CHAR(LAST_DAY(TO_DATE(P.WRK_DT, 'YYYYMM')), 'YYYYMMDD'))" ).append("\n"); 
		query.append("--        AND    M.CNTR_FULL_FLG <> 'Y'	-- TES_EQ_LAND_STAY > CIM_DLY_INV_SMRY 변경 - (2015-10-22 양양선B)" ).append("\n"); 
		query.append("  	    AND    P.TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("  	    AND    P.TML_SO_SEQ    		= @[tml_so_seq]" ).append("\n"); 
		query.append("        AND    M.YD_CD         		= P.YD_CD" ).append("\n"); 
		query.append("        AND    M.YD_CD         		= H.YD_CD" ).append("\n"); 
		query.append("        AND    H.VNDR_SEQ      		= P.VNDR_SEQ" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_STS_CD 	= 'C'" ).append("\n"); 
		query.append("		AND    M.MVMT_STS_CD     	= 'MT' -- 2013.11.20 양양선 부장님 요청으로 추가함.(MT, OP가 같이 나오고 있어서 OP때문에 중복되고 있었음)" ).append("\n"); 
		query.append("        AND    H.DELT_FLG        	= 'N'" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                                     FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                                     WHERE  M.YD_CD               = P.YD_CD" ).append("\n"); 
		query.append("                                     AND    M.VNDR_SEQ            = P.VNDR_SEQ" ).append("\n"); 
		query.append("                                     AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                                     AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                                     AND    TO_CHAR(M.EFF_FM_DT, 'YYYYMMDD') <= P.FM_PRD_DT" ).append("\n"); 
		query.append("                                     AND    TO_CHAR(M.EFF_TO_DT, 'YYYYMMDD') >= P.TO_PRD_DT )" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_SEQ        = D.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("        AND    D.TML_AGMT_TP_CD      = 'S'" ).append("\n"); 
		query.append("        AND    D.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append("        AND    D.LGS_COST_CD         = 'SRNDMT'" ).append("\n"); 
		query.append("        AND    D.TML_STO_AGMT_TP_CD  = 'FP'" ).append("\n"); 
		query.append("#if (${mode} == 'M') " ).append("\n"); 
		query.append("		AND    D.FP_CALC_PRD_CD      = 'M'" ).append("\n"); 
		query.append("		GROUP BY SUBSTR(TGT_MVMT_DT, 0, 6)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		AND    D.FP_CALC_PRD_CD      = 'D'" ).append("\n"); 
		query.append("		GROUP BY TGT_MVMT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				, P.INV_VOL_QTY" ).append("\n"); 
		query.append("				, H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("				, D.FP_TEU_QTY, D.TML_AGMT_VOL_UT_CD, D.AGMT_UT_RT, D.CURR_CD" ).append("\n"); 
		query.append("				, FM_TR_DYS" ).append("\n"); 
		query.append("				, TO_TR_DYS" ).append("\n"); 
		query.append("		) CALC" ).append("\n"); 
		query.append("		, (SELECT	WRK_DT, INV_VOL_QTY" ).append("\n"); 
		query.append("		FROM	TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("		WHERE	TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		AND		TML_SO_SEQ			= @[tml_so_seq]" ).append("\n"); 
		query.append("		 ) ORG" ).append("\n"); 
		query.append("		, TES_LGS_COST C" ).append("\n"); 
		query.append("		, (SELECT	T.WRK_DT, T.INV_VOL_QTY, D.FP_TEU_QTY, D.TML_AGMT_VOL_UT_CD UOM, D.AGMT_UT_RT," ).append("\n"); 
		query.append("                DECODE(@[curr_cd], D.CURR_CD, 'Y', 'N') CURR_CHK, D.CURR_CD," ).append("\n"); 
		query.append("                H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("                DECODE(SIGN(T.INV_VOL_QTY - D.FP_TEU_QTY),-1,0,0,0,(T.INV_VOL_QTY - D.FP_TEU_QTY)) OVR_VOL_QTY" ).append("\n"); 
		query.append("				--2015.04.20 [CHM-201535341]Storage Rate List에서 Tier Over Days 없어도 CNTR Verification되도록 설정변경" ).append("\n"); 
		query.append("				, NVL(FM_TR_DYS, 0) FM_TR_DYS" ).append("\n"); 
		query.append("				, NVL(TO_TR_DYS, 0) TO_TR_DYS" ).append("\n"); 
		query.append("		FROM   TES_FILE_IMP_TMP T, TES_TML_AGMT_HDR H, TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append("		WHERE  T.TML_SO_OFC_CTY_CD	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		AND    T.TML_SO_SEQ			= @[tml_so_seq]" ).append("\n"); 
		query.append("		AND    H.VNDR_SEQ			= T.VNDR_SEQ" ).append("\n"); 
		query.append("		AND    H.TML_AGMT_STS_CD	= 'C'" ).append("\n"); 
		query.append("		AND    H.DELT_FLG        	= 'N'" ).append("\n"); 
		query.append("		AND    H.TML_AGMT_VER_NO 	= (SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                                      FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                                      WHERE  M.YD_CD               = T.YD_CD" ).append("\n"); 
		query.append("                                      AND    M.VNDR_SEQ            = T.VNDR_SEQ" ).append("\n"); 
		query.append("                                      AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                                      AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                                      AND    TO_CHAR(M.EFF_FM_DT, 'YYYYMMDD') <= T.FM_PRD_DT" ).append("\n"); 
		query.append("                                      AND    TO_CHAR(M.EFF_TO_DT, 'YYYYMMDD') >= T.TO_PRD_DT )" ).append("\n"); 
		query.append("		AND    H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		AND    H.TML_AGMT_SEQ        = D.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("		AND    H.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("		AND    D.TML_AGMT_TP_CD      = 'S'" ).append("\n"); 
		query.append("		AND    D.AUTO_CALC_FLG       = 'Y'" ).append("\n"); 
		query.append("		AND    D.LGS_COST_CD         = 'SRNDMT'" ).append("\n"); 
		query.append("		AND    D.TML_STO_AGMT_TP_CD  = 'FP'" ).append("\n"); 
		query.append("-- 20091228 FILE IMPORT 시  월,일별로 나누어서 처리해야함 " ).append("\n"); 
		query.append("#if (${mode} == 'M') " ).append("\n"); 
		query.append("		AND    D.FP_CALC_PRD_CD      = 'M'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND    D.FP_CALC_PRD_CD      = 'D'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		) AGMT		" ).append("\n"); 
		query.append("WHERE	ORG.WRK_DT      	= CALC.M_DATE(+)" ).append("\n"); 
		query.append("AND		ORG.INV_VOL_QTY 	= CALC.INV_VOL_QTY(+)" ).append("\n"); 
		query.append("AND		ORG.WRK_DT      	= AGMT.WRK_DT(+)" ).append("\n"); 
		query.append("AND		ORG.INV_VOL_QTY 	= AGMT.INV_VOL_QTY(+)" ).append("\n"); 
		query.append("--2015.04.20 [CHM-201535341]Storage Rate List에서 Tier Over Days 없어도 CNTR Verification되도록 설정변경" ).append("\n"); 
		query.append("AND		((NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) = 1 OR NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) = 0)" ).append("\n"); 
		query.append("OR		(ORG.INV_VOL_QTY	>= CALC.FP_TEU_QTY" ).append("\n"); 
		query.append("AND		ORG.INV_VOL_QTY - CALC.FP_TEU_QTY >= CALC.FM_TR_DYS))" ).append("\n"); 
		query.append("AND		CALC.LGS_COST_CD	= C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("GROUP BY  NVL(CALC.LGS_COST_CD, 'SRNDMT')" ).append("\n"); 
		query.append("		, NVL(CALC.LGS_COST_CD, 'SRNDMT')" ).append("\n"); 
		query.append("		, ORG.WRK_DT" ).append("\n"); 
		query.append("		, ORG.INV_VOL_QTY" ).append("\n"); 
		query.append("		, C.ACCT_CD" ).append("\n"); 
		query.append("		, CALC.M_DATE" ).append("\n"); 
		query.append("		, NVL(CALC.TML_AGMT_OFC_CTY_CD, AGMT.TML_AGMT_OFC_CTY_CD)" ).append("\n"); 
		query.append("		, NVL(CALC.TML_AGMT_SEQ, AGMT.TML_AGMT_SEQ)" ).append("\n"); 
		query.append("		, NVL(CALC.TML_AGMT_VER_NO, AGMT.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("		, NVL(CALC.FP_TEU_QTY, AGMT.FP_TEU_QTY)" ).append("\n"); 
		query.append("		, NVL(CALC.UOM, AGMT.UOM)" ).append("\n"); 
		query.append("		, NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT)" ).append("\n"); 
		query.append("        , NVL(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), 0)" ).append("\n"); 
		query.append("		, NVL(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), 0)" ).append("\n"); 
		query.append("		, NVL(DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, (NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1)  * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), (NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT))), 0)" ).append("\n"); 
		query.append("		, NVL(DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, (NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1)  * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT), (NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1) * NVL(CALC.AGMT_UT_RT, AGMT.AGMT_UT_RT))), 0)" ).append("\n"); 
		query.append("		, NVL(CALC.STACKING_VOL, 0)" ).append("\n"); 
		query.append("		, NVL(CALC.STACKING_VOL, 0) - NVL(ORG.INV_VOL_QTY, 0)" ).append("\n"); 
		query.append("	    , DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY)), -1, 0, 0, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY))" ).append("\n"); 
		query.append("    	, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)), -1, DECODE(SIGN(NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), -1, 0, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - (NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) - 1)), DECODE(NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS), 999, NVL(CALC.OVR_VOL_QTY, AGMT.OVR_VOL_QTY) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1, NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS) - NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS) + 1 ))" ).append("\n"); 
		query.append("		, NVL(CALC.CURR_CHK, AGMT.CURR_CHK)" ).append("\n"); 
		query.append("		, NVL(CALC.CURR_CD, AGMT.CURR_CD)" ).append("\n"); 
		query.append("		, NVL(CALC.FM_TR_DYS, AGMT.FM_TR_DYS)" ).append("\n"); 
		query.append("		, NVL(CALC.TO_TR_DYS, AGMT.TO_TR_DYS)" ).append("\n"); 
		query.append("ORDER BY  ORG.WRK_DT" ).append("\n"); 

	}
}