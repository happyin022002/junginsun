/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCommChgRefCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCommChgRefCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmAgnCommChgRef
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCommChgRefCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCommChgRefCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM_CHG_REF" ).append("\n"); 
		query.append("(BKG_NO, CHG_CD, BKG_AGMT_UT_CD, SPCL_CGO_CTNT, CURR_CD, ROUT_TRF_FX_AMT, ROUT_TRF_RT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      BKG_NO" ).append("\n"); 
		query.append("    , CHG_CD" ).append("\n"); 
		query.append("    , BKG_AGMT_UT_CD" ).append("\n"); 
		query.append("    , SPCL_CGO_CTNT" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , ROUT_TRF_FX_AMT" ).append("\n"); 
		query.append("    , ROUT_TRF_RT" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("          ARR.BKG_NO, " ).append("\n"); 
		query.append("          SRT.CHG_CD,  " ).append("\n"); 
		query.append("          NVL(SRT.RAT_UT_CD     , '  ')                                         AS BKG_AGMT_UT_CD, " ).append("\n"); 
		query.append("          NVL(SRT.PRC_CGO_TP_CD , '  ')                                         AS SPCL_CGO_CTNT,  " ).append("\n"); 
		query.append("          SRT.CURR_CD                                                           AS CURR_CD,  " ).append("\n"); 
		query.append("          DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'F', SRT.SCG_AMT, '0')          AS ROUT_TRF_FX_AMT,                                                                        " ).append("\n"); 
		query.append("          DECODE (NVL (PRF.FLT_PCT_TP_CD, '0'), 'P', SRT.SCG_AMT, '0')          AS ROUT_TRF_RT,                                                                       " ).append("\n"); 
		query.append("                                                                                                       " ).append("\n"); 
		query.append("          ROW_NUMBER () OVER                                                                                                                                           " ).append("\n"); 
		query.append("          (                                                                                                                                                            " ).append("\n"); 
		query.append("              PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POL_DEF_CD,POD_DEF_CD,DEL_DEF_CD                                          " ).append("\n"); 
		query.append("              ORDER BY LENGTH(NVL(POR_DEF_CD,'*')) DESC                                                                                                                " ).append("\n"); 
		query.append("          ) D_POR,                                                                                                                                                     " ).append("\n"); 
		query.append("          ROW_NUMBER () OVER                                                                                                                                           " ).append("\n"); 
		query.append("          (                                                                                                                                                            " ).append("\n"); 
		query.append("              PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POR_DEF_CD,POD_DEF_CD,DEL_DEF_CD                                          " ).append("\n"); 
		query.append("              ORDER BY LENGTH(NVL(POL_DEF_CD,'*')) DESC                                                                                                                " ).append("\n"); 
		query.append("          ) D_POL,                                                                                                                                                     " ).append("\n"); 
		query.append("          ROW_NUMBER () OVER                                                                                                                                           " ).append("\n"); 
		query.append("          (                                                                                                                                                            " ).append("\n"); 
		query.append("              PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POR_DEF_CD,POL_DEF_CD,DEL_DEF_CD                                          " ).append("\n"); 
		query.append("              ORDER BY LENGTH(NVL(POD_DEF_CD,'*')) DESC                                                                                                                " ).append("\n"); 
		query.append("          ) D_POD,                                                                                                                                                     " ).append("\n"); 
		query.append("          ROW_NUMBER () OVER                                                                                                                                           " ).append("\n"); 
		query.append("          (                                                                                                                                                            " ).append("\n"); 
		query.append("              PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD,POR_DEF_CD,POL_DEF_CD,POD_DEF_CD                                          " ).append("\n"); 
		query.append("              ORDER BY LENGTH(NVL(DEL_DEF_CD,'*')) DESC                                                                                                                " ).append("\n"); 
		query.append("          ) D_DEL,                                                                                                                                                     " ).append("\n"); 
		query.append("          ROW_NUMBER () OVER                                                                                                                                           " ).append("\n"); 
		query.append("          (                                                                                                                                                            " ).append("\n"); 
		query.append("              PARTITION BY ARR.BKG_NO,SRT.CHG_CD,SRT.RAT_UT_CD,SRT.CURR_CD,SRT.PRC_CGO_TP_CD                                          									" ).append("\n"); 
		query.append("              ORDER BY NVL(length(POR_TP_CD||POL_TP_CD||POD_TP_CD||DEL_TP_CD),0) DESC                                                     " ).append("\n"); 
		query.append("          ) MAT_LOC_CNT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     FROM PRI_SCG_RT  SRT,  " ).append("\n"); 
		query.append("          PRI_SCG_PRF PRF,  " ).append("\n"); 
		query.append("          MDM_LOCATION POR,  " ).append("\n"); 
		query.append("          MDM_LOCATION POL,  " ).append("\n"); 
		query.append("          MDM_LOCATION POD,  " ).append("\n"); 
		query.append("          MDM_LOCATION DEL,  " ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("       --------------------------------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("           SELECT  " ).append("\n"); 
		query.append("                  BKG.BKG_NO, " ).append("\n"); 
		query.append("                  BKG.SVC_SCP_CD,  " ).append("\n"); 
		query.append("                  BKG.RCV_TERM_CD,  " ).append("\n"); 
		query.append("                  BKG.DE_TERM_CD,  " ).append("\n"); 
		query.append("                  BKG.CMDT_CD,  " ).append("\n"); 
		query.append("                  BKG.SOC_FLG,  " ).append("\n"); 
		query.append("                  BKG.POL_NOD_CD,  " ).append("\n"); 
		query.append("                  BKG.POD_NOD_CD,  " ).append("\n"); 
		query.append("                  BKG.ORG_TRNS_MOD_CD,  " ).append("\n"); 
		query.append("                  BKG.DEST_TRNS_MOD_CD,  " ).append("\n"); 
		query.append("                  BKG.POR_CD,  " ).append("\n"); 
		query.append("                  BKG.POL_CD,  " ).append("\n"); 
		query.append("                  BKG.POD_CD,  " ).append("\n"); 
		query.append("                  BKG.DEL_CD,  " ).append("\n"); 
		query.append("                  @[rt_aply_dt] AS RT_APLY_DT, " ).append("\n"); 
		query.append("             CASE " ).append("\n"); 
		query.append("             WHEN DEL.CML_ZN_FLG = 'Y' " ).append("\n"); 
		query.append("              AND POD.RGN_CD " ).append("\n"); 
		query.append("               IN " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                  'UAG', " ).append("\n"); 
		query.append("                  'UAN', " ).append("\n"); 
		query.append("                  'UAS' " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("             THEN 'CZ' " ).append("\n"); 
		query.append("             ELSE 'NN' " ).append("\n"); 
		query.append("              END                                AS CML_ZN_CD, " ).append("\n"); 
		query.append("       --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("       --;) <USA SERVICE MODE CODE, 미국내륙운송 형태> " ).append("\n"); 
		query.append("       --;) 지정한 USA SERVICE MODE CODE에 해당하는 BOOKING인 경우 부과되는 SURCHARGE임을 의미함. " ).append("\n"); 
		query.append("       --;) - PORT: 근처 " ).append("\n"); 
		query.append("       --;) - LOCAL: 근처 " ).append("\n"); 
		query.append("       --;) - MLB(Mini Land Bridge): 내륙 깊숙이까지 " ).append("\n"); 
		query.append("       --;) - IPI(Interior Point Intermodal): 복합내륙운송 " ).append("\n"); 
		query.append("       --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("             CASE " ).append("\n"); 
		query.append("             WHEN POD.CNT_CD          IN ('US', 'CA') " ).append("\n"); 
		query.append("              AND BKG.DE_TERM_CD  NOT IN ('D', 'H') " ).append("\n"); 
		query.append("              AND BKG.POD_CD           = BKG.DEL_CD " ).append("\n"); 
		query.append("             THEN 'PO' " ).append("\n"); 
		query.append("             WHEN POD.CNT_CD          IN ('US', 'CA') " ).append("\n"); 
		query.append("             THEN " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                      SELECT " ).append("\n"); 
		query.append("                             SUBSTR (SVC_MOD_CD, 1, 2) " ).append("\n"); 
		query.append("                        FROM COA_USA_SVC_MOD A " ).append("\n"); 
		query.append("                       WHERE A.ORG_RGN_CD  = POD.RGN_CD " ).append("\n"); 
		query.append("                         AND A.DEST_RGN_CD = DEL.RGN_CD " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("             WHEN POL.CNT_CD          IN ('US', 'CA') " ).append("\n"); 
		query.append("              AND BKG.RCV_TERM_CD NOT IN ('D', 'H') " ).append("\n"); 
		query.append("              AND BKG.POL_CD           = BKG.POR_CD " ).append("\n"); 
		query.append("             THEN 'PO' " ).append("\n"); 
		query.append("             WHEN POL.CNT_CD          IN ('US', 'CA') " ).append("\n"); 
		query.append("             THEN " ).append("\n"); 
		query.append("                (  " ).append("\n"); 
		query.append("                      SELECT " ).append("\n"); 
		query.append("                             SUBSTR (SVC_MOD_CD, 1, 2) " ).append("\n"); 
		query.append("                        FROM COA_USA_SVC_MOD A " ).append("\n"); 
		query.append("                       WHERE A.ORG_RGN_CD  = POL.RGN_CD " ).append("\n"); 
		query.append("                         AND A.DEST_RGN_CD = POR.RGN_CD " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("              END                                                                              AS USA_SVC_MOD_CD, " ).append("\n"); 
		query.append("       --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("       --;) <DIRECT CALLING FLAG> " ).append("\n"); 
		query.append("       --;) TRANSHIPMENT 없는 경우에만 적용되는 SURCHARGE임을 의미함. " ).append("\n"); 
		query.append("       --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("                  DECODE (BKG.PRE_RLY_PORT_CD||BKG.PST_RLY_PORT_CD, NULL, 'Y', 'N')            AS DIR_CALL_FLG " ).append("\n"); 
		query.append("             FROM BKG_BOOKING    BKG, " ).append("\n"); 
		query.append("                  BKG_RATE       RAT, " ).append("\n"); 
		query.append("                  MDM_LOCATION   POR, " ).append("\n"); 
		query.append("                  MDM_LOCATION   POL, " ).append("\n"); 
		query.append("                  MDM_LOCATION   POD, " ).append("\n"); 
		query.append("                  MDM_LOCATION   DEL " ).append("\n"); 
		query.append("            WHERE BKG.BKG_NO     = RAT.BKG_NO " ).append("\n"); 
		query.append("              AND POR.LOC_CD     = BKG.POR_CD " ).append("\n"); 
		query.append("              AND POL.LOC_CD     = BKG.POL_CD " ).append("\n"); 
		query.append("              AND POD.LOC_CD     = BKG.POD_CD " ).append("\n"); 
		query.append("              AND DEL.LOC_CD     = BKG.DEL_CD " ).append("\n"); 
		query.append("              AND POR.DELT_FLG   = 'N' " ).append("\n"); 
		query.append("              AND POL.DELT_FLG   = 'N' " ).append("\n"); 
		query.append("              AND POD.DELT_FLG   = 'N' " ).append("\n"); 
		query.append("              AND DEL.DELT_FLG   = 'N' " ).append("\n"); 
		query.append("              AND BKG.BKG_CRE_DT > TO_DATE ('20100405', 'YYYYMMDD') " ).append("\n"); 
		query.append("              AND BKG.BKG_NO     =  @[bkg_no] --'CMB100645100' " ).append("\n"); 
		query.append("       --------------------------------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("                ) ARR " ).append("\n"); 
		query.append("    --------------------------------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("    WHERE SRT.SVC_SCP_CD           = ARR.SVC_SCP_CD " ).append("\n"); 
		query.append("      AND PRF.SVC_SCP_CD           = ARR.SVC_SCP_CD " ).append("\n"); 
		query.append("      AND PRF.SVC_SCP_CD           = SRT.SVC_SCP_CD " ).append("\n"); 
		query.append("      AND PRF.CHG_CD               = SRT.CHG_CD " ).append("\n"); 
		query.append("      AND SRT.DELT_FLG             = 'N' " ).append("\n"); 
		query.append("      AND SRT.WDR_FLG              = 'N' " ).append("\n"); 
		query.append("      AND ARR.POR_CD = POR.LOC_CD " ).append("\n"); 
		query.append("      AND ARR.POL_CD = POL.LOC_CD " ).append("\n"); 
		query.append("      AND ARR.POD_CD = POD.LOC_CD " ).append("\n"); 
		query.append("      AND ARR.DEL_CD = DEL.LOC_CD " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.POR_USE_FLG, 'Y', SRT.POR_DEF_CD, '*'), '*') IN (POR.LOC_CD, POR.RGN_CD, POR.CNT_CD, '*' ) " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.POL_USE_FLG, 'Y', SRT.POL_DEF_CD, '*'), '*') IN (POL.LOC_CD, POL.RGN_CD, POL.CNT_CD, '*' ) " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.POD_USE_FLG, 'Y', SRT.POD_DEF_CD, '*'), '*') IN (POD.LOC_CD, POD.RGN_CD, POD.CNT_CD, '*' ) " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.DEL_USE_FLG, 'Y', SRT.DEL_DEF_CD, '*'), '*') IN (DEL.LOC_CD, DEL.RGN_CD, DEL.CNT_CD, '*' ) " ).append("\n"); 
		query.append("      AND PRF.CHG_CD " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("         CASE " ).append("\n"); 
		query.append("             WHEN ARR.RT_APLY_DT > '20101231' AND PRF.CHG_CD = 'FRC' THEN '*' " ).append("\n"); 
		query.append("    --> CFM Charge(CFM) " ).append("\n"); 
		query.append("    --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("    --;) <CFM Charge> " ).append("\n"); 
		query.append("    --;) RCV_TERM_CD 혹은 DE_TERM_CD가 'S'(CFS)일 때 부과되는 CHARGE " ).append("\n"); 
		query.append("    --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("             WHEN PRF.CHG_CD      = 'CFL' AND ARR.RCV_TERM_CD = 'S' THEN 'CFL' " ).append("\n"); 
		query.append("             WHEN PRF.CHG_CD      = 'CFD' AND ARR.DE_TERM_CD  = 'S' THEN 'CFD' " ).append("\n"); 
		query.append("             WHEN PRF.CHG_CD      = 'CFL' THEN '*' " ).append("\n"); 
		query.append("             WHEN PRF.CHG_CD      = 'CFD' THEN '*' " ).append("\n"); 
		query.append("             /* [THC 공제로직 변경사항]   CHM-201111599               */ " ).append("\n"); 
		query.append("             /*   - BKG의 term 중에 I/O/T가 있는 경우 해당 지역의 THC 불공제 */ " ).append("\n"); 
		query.append("             /*   - BKG R term에 I 혹은 T가 있는 경우 - THL 불공제                */ " ).append("\n"); 
		query.append("             /*   - BKG D term에 O 혹은 T가 있는 경우 - THD 불공제                */ " ).append("\n"); 
		query.append("             WHEN PRF.CHG_CD      = 'THC'  AND(ARR.RCV_TERM_CD IN ('T','I','O') or ARR.DE_TERM_CD IN ('T','I','O')) THEN '*' " ).append("\n"); 
		query.append("             WHEN PRF.CHG_CD      = 'THL'  AND ARR.RCV_TERM_CD IN ('T','I') THEN '*' " ).append("\n"); 
		query.append("             WHEN PRF.CHG_CD      = 'THD'  AND ARR.DE_TERM_CD  IN ('T','O') THEN '*' " ).append("\n"); 
		query.append("             /* R/D Term 에 따라 THC 공제 여부 체크 로직 추가 - 임종한 과장 요청[CHM-201111599]*/ " ).append("\n"); 
		query.append("             ELSE PRF.CHG_CD " ).append("\n"); 
		query.append("         END " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> RECEIVE TERM  " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.RCV_DE_TERM_USE_FLG, 'Y', SRT.PRC_RCV_TERM_CD, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          ARR.RCV_TERM_CD, " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> DELIVERY TERM " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.RCV_DE_TERM_USE_FLG, 'Y', SRT.PRC_DE_TERM_CD, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          ARR.DE_TERM_CD, " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> USA SVC MODE  " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.USA_SVC_MOD_USE_FLG, 'Y', SRT.USA_SVC_MOD_CD, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          DECODE (ARR.USA_SVC_MOD_CD, 'CZ', ARR.CML_ZN_CD, ARR.USA_SVC_MOD_CD), " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> DIRECT CALLING " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.DIR_CALL_USE_FLG, 'Y', SRT.DIR_CALL_FLG, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          ARR.DIR_CALL_FLG, " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> ORIGIN TRANSPORTATION MODE " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.TRNS_MOD_USE_FLG, 'Y', SRT.ORG_TRSP_MOD_CD, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          ARR.ORG_TRNS_MOD_CD, " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> DESTINATION TRANSPORTATION MODE " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.TRNS_MOD_USE_FLG, 'Y', SRT.DEST_TRSP_MOD_CD, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          ARR.DEST_TRNS_MOD_CD, " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> TERMINAL " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          PRF.TML_USE_FLG = 'N' " ).append("\n"); 
		query.append("       OR SRT.TML_CD     IS NULL " ).append("\n"); 
		query.append("       OR SRT.TML_CD      = ARR.POL_NOD_CD " ).append("\n"); 
		query.append("       OR SRT.TML_CD      = ARR.POD_NOD_CD " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> TRANSSHIPMENT PORT " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          PRF.TS_PORT_USE_FLG = 'N'  " ).append("\n"); 
		query.append("       OR SRT.TS_PORT_CD     IS NULL " ).append("\n"); 
		query.append("       OR EXISTS " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM BKG_VVD    BVD " ).append("\n"); 
		query.append("               WHERE BVD.BKG_NO   = ARR.BKG_NO " ).append("\n"); 
		query.append("                 AND " ).append("\n"); 
		query.append("                   ( " ).append("\n"); 
		query.append("                     BVD.POL_CD   = SRT.TS_PORT_CD " ).append("\n"); 
		query.append("                  OR BVD.POL_CD   = SRT.TS_PORT_CD " ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> IN/OUT GAGE " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          SRT.IO_GA_CD  IS NULL " ).append("\n"); 
		query.append("       OR EXISTS " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM BKG_AWK_CGO AWK " ).append("\n"); 
		query.append("               WHERE AWK.IN_GA_FLG    = 'Y' " ).append("\n"); 
		query.append("                 AND AWK.BKG_NO       = ARR.BKG_NO " ).append("\n"); 
		query.append("                 AND AWK.CNTR_TPSZ_CD = SRT.RAT_UT_CD " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> VESSEL SERVICE LANE CODE " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          PRF.SLAN_USE_FLG = 'N' " ).append("\n"); 
		query.append("       OR SRT.VSL_SLAN_CD IS NULL " ).append("\n"); 
		query.append("       OR EXISTS " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM BKG_VVD BVD " ).append("\n"); 
		query.append("               WHERE BVD.BKG_NO  = ARR.BKG_NO " ).append("\n"); 
		query.append("                 AND BVD.SLAN_CD = SRT.VSL_SLAN_CD " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> COMMODITY " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.CMDT_USE_FLG, 'Y', SRT.CMDT_CD, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          ARR.CMDT_CD, " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> SHIPPER'S OWN CONTAINER(S.O.C) " ).append("\n"); 
		query.append("      AND NVL (DECODE (PRF.SOC_USE_FLG, 'Y', SRT.SOC_FLG, '*'), '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          ARR.SOC_FLG, " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> IMDG CLASS " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          PRF.IMDG_CLSS_USE_FLG = 'N' " ).append("\n"); 
		query.append("       OR SRT.SCG_IMDG_CLSS_CD  IS NULL " ).append("\n"); 
		query.append("       OR EXISTS " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM BKG_DG_CGO BDG " ).append("\n"); 
		query.append("               WHERE BDG.BKG_NO            = ARR.BKG_NO " ).append("\n"); 
		query.append("                 AND BDG.CNTR_TPSZ_CD      = SRT.RAT_UT_CD " ).append("\n"); 
		query.append("                 AND BDG.IMDG_CLSS_CD    LIKE SRT.SCG_IMDG_CLSS_CD||'%' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> SUB TRADE " ).append("\n"); 
		query.append("    --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("    --;) <SUB TRADE CODE> " ).append("\n"); 
		query.append("    --;) 운송 서비스 Trade 내의 상세 Area 세분화 하여 Code 화 함 " ).append("\n"); 
		query.append("    --;) 지정한 SUB TRADE에 해당하는 BOOKING인 경우 부과되는 SURCHARGE임을 의미함. " ).append("\n"); 
		query.append("    --;)----------------------------------------------------------------------------------------------- " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          PRF.SUB_TRD_USE_FLG  = 'N' " ).append("\n"); 
		query.append("       OR SRT.SUB_TRD_CD      IS NULL " ).append("\n"); 
		query.append("       OR SRT.SUB_TRD_CD " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     MDL.SUB_TRD_CD " ).append("\n"); 
		query.append("                FROM BKG_VVD             BVD, " ).append("\n"); 
		query.append("                     MDM_REV_LANE        MRL, " ).append("\n"); 
		query.append("                     MDM_DTL_REV_LANE    MDL " ).append("\n"); 
		query.append("               WHERE MDL.FM_CONTI_CD     = ( SELECT X.CONTI_CD FROM MDM_LOCATION X WHERE X.LOC_CD = BVD.POL_CD ) " ).append("\n"); 
		query.append("                 AND MDL.TO_CONTI_CD     = ( SELECT x.CONTI_CD FROM MDM_LOCATION X WHERE X.LOC_CD = BVD.POL_CD ) " ).append("\n"); 
		query.append("                 AND MRL.VSL_SLAN_CD     = BVD.SLAN_CD " ).append("\n"); 
		query.append("                 AND MDL.RLANE_CD        = MRL.RLANE_CD " ).append("\n"); 
		query.append("                 AND MDL.VSL_SLAN_DIR_CD = BVD.SKD_DIR_CD " ).append("\n"); 
		query.append("                 AND MRL.DELT_FLG        = 'N' " ).append("\n"); 
		query.append("                 AND MDL.DELT_FLG        = 'N' " ).append("\n"); 
		query.append("                 AND BVD.BKG_NO          = ARR.BKG_NO " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> DATE FROM " ).append("\n"); 
		query.append("      AND TO_DATE(ARR.RT_APLY_DT ,'YYYYMMDD')" ).append("\n"); 
		query.append("    BETWEEN SRT.EFF_DT " ).append("\n"); 
		query.append("      AND SRT.EXP_DT " ).append("\n"); 
		query.append("    --> DATE TO " ).append("\n"); 
		query.append("      AND TO_DATE(ARR.RT_APLY_DT ,'YYYYMMDD')" ).append("\n"); 
		query.append("    BETWEEN SRT.EFF_DT " ).append("\n"); 
		query.append("      AND SRT.EXP_DT " ).append("\n"); 
		query.append("    --> CARGO TYPE " ).append("\n"); 
		query.append("      AND NVL(SRT.PRC_CGO_TP_CD, '*') " ).append("\n"); 
		query.append("       IN " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          'DR',  " ).append("\n"); 
		query.append("          'RF', " ).append("\n"); 
		query.append("          'DG', " ).append("\n"); 
		query.append("          'AK', " ).append("\n"); 
		query.append("          'BB', " ).append("\n"); 
		query.append("          '*' " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> SURCARGE GROUP COMMODITY ( GRI ) " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          PRF.GRI_CMDT_USE_FLG = 'N' " ).append("\n"); 
		query.append("       OR SRT.SCG_GRP_CMDT_CD IS NULL " ).append("\n"); 
		query.append("       OR EXISTS " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM PRI_SCG_GRP_CMDT     GC, " ).append("\n"); 
		query.append("                     PRI_SCG_GRP_CMDT_DTL GD " ).append("\n"); 
		query.append("               WHERE GD.SVC_SCP_CD         = GC.SVC_SCP_CD " ).append("\n"); 
		query.append("                 AND GD.CHG_CD             = GC.CHG_CD " ).append("\n"); 
		query.append("                 AND GD.SCG_GRP_CMDT_SEQ   = GC.SCG_GRP_CMDT_SEQ " ).append("\n"); 
		query.append("                 AND GC.SVC_SCP_CD         = ARR.SVC_SCP_CD " ).append("\n"); 
		query.append("                 AND GC.CHG_CD             = SRT.CHG_CD " ).append("\n"); 
		query.append("                 AND GC.SCG_GRP_CMDT_CD    = SRT.SCG_GRP_CMDT_CD " ).append("\n"); 
		query.append("                 AND GD.CMDT_CD            = ARR.CMDT_CD " ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("    --> CANAL TRANSIT CODE " ).append("\n"); 
		query.append("     AND " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("          PRF.CNL_TZ_FLG  = 'N' " ).append("\n"); 
		query.append("       OR SRT.CNL_TZ_CD  IS NULL " ).append("\n"); 
		query.append("       OR EXISTS " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM BKG_VVD          BV, " ).append("\n"); 
		query.append("                     VSK_VSL_PORT_SKD S1, " ).append("\n"); 
		query.append("                     VSK_VSL_PORT_SKD S2, " ).append("\n"); 
		query.append("                     VSK_VSL_PORT_SKD S3 " ).append("\n"); 
		query.append("               WHERE BV.BKG_NO        = ARR.BKG_NO " ).append("\n"); 
		query.append("                 AND S1.VSL_CD        = BV.VSL_CD " ).append("\n"); 
		query.append("                 AND S1.SKD_VOY_NO    = BV.SKD_VOY_NO " ).append("\n"); 
		query.append("                 AND S1.SKD_DIR_CD    = BV.SKD_DIR_CD " ).append("\n"); 
		query.append("                 AND S1.VPS_PORT_CD   = BV.POL_CD " ).append("\n"); 
		query.append("                 AND S1.CLPT_IND_SEQ  = BV.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                 AND S2.VSL_CD        = BV.VSL_CD " ).append("\n"); 
		query.append("                 AND S2.SKD_VOY_NO    = BV.SKD_VOY_NO " ).append("\n"); 
		query.append("                 AND S2.SKD_DIR_CD    = BV.SKD_DIR_CD " ).append("\n"); 
		query.append("                 AND S2.VPS_PORT_CD   = BV.POD_CD " ).append("\n"); 
		query.append("                 AND S2.CLPT_IND_SEQ  = BV.POD_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                 AND S3.VSL_CD        = BV.VSL_CD " ).append("\n"); 
		query.append("                 AND S3.SKD_VOY_NO    = BV.SKD_VOY_NO " ).append("\n"); 
		query.append("                 AND S3.SKD_DIR_CD    = BV.SKD_DIR_CD " ).append("\n"); 
		query.append("                 AND S3.VPS_PORT_CD   = DECODE (SRT.CNL_TZ_CD, 'P', 'PAPCA', 'S', 'EGSCA') " ).append("\n"); 
		query.append("                 AND S3.CLPT_SEQ " ).append("\n"); 
		query.append("             BETWEEN S1.CLPT_SEQ " ).append("\n"); 
		query.append("                 AND S2.CLPT_SEQ " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    --> CARGO WEIGHT  " ).append("\n"); 
		query.append("      AND " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("          PRF.CGO_WGT_USE_FLG = 'N' " ).append("\n"); 
		query.append("       OR EXISTS " ).append("\n"); 
		query.append("        ( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM BKG_CONTAINER BCT " ).append("\n"); 
		query.append("               WHERE BCT.BKG_NO      = ARR.BKG_NO " ).append("\n"); 
		query.append("                 AND CNTR_TPSZ_CD    = SRT.RAT_UT_CD " ).append("\n"); 
		query.append("              HAVING 'Y' = " ).append("\n"); 
		query.append("                CASE " ).append("\n"); 
		query.append("                WHEN TO_NUMBER (SRT.MIN_CGO_WGT) >= NVL (MIN (DECODE (BCT.WGT_UT_CD, 'LBS', BCT.CNTR_WGT * 0.45359, BCT.CNTR_WGT)), 0) " ).append("\n"); 
		query.append("                 AND TO_NUMBER (SRT.MAX_CGO_WGT) <  NVL (MIN (DECODE (BCT.WGT_UT_CD, 'LBS', BCT.CNTR_WGT * 0.45359, BCT.CNTR_WGT)), 0) " ).append("\n"); 
		query.append("                THEN 'Y' " ).append("\n"); 
		query.append("                ELSE 'N' " ).append("\n"); 
		query.append("                 END " ).append("\n"); 
		query.append("           UNION ALL " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     'X' " ).append("\n"); 
		query.append("                FROM BKG_BL_DOC  BBC, " ).append("\n"); 
		query.append("                     BKG_QTY_DTL BQD " ).append("\n"); 
		query.append("               WHERE BBC.BKG_NO    = ARR.BKG_NO " ).append("\n"); 
		query.append("                 AND BBC.BKG_NO    = BQD.BKG_NO " ).append("\n"); 
		query.append("              HAVING 'Y' = " ).append("\n"); 
		query.append("                CASE " ).append("\n"); 
		query.append("                WHEN 1 = SUM (BQD.OP_CNTR_QTY) " ).append("\n"); 
		query.append("                 AND TO_NUMBER (SRT.MIN_CGO_WGT) >= NVL (MIN (DECODE (BBC.WGT_UT_CD, 'LBS', BBC.ACT_WGT * 0.45359, BBC.ACT_WGT)), 0) " ).append("\n"); 
		query.append("                 AND TO_NUMBER (SRT.MAX_CGO_WGT) <  NVL (MIN (DECODE (BBC.WGT_UT_CD, 'LBS', BBC.ACT_WGT * 0.45359, BBC.ACT_WGT)), 0) " ).append("\n"); 
		query.append("                THEN 'Y' " ).append("\n"); 
		query.append("                ELSE 'N'  " ).append("\n"); 
		query.append("                 END " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("     ) TMP                                                                                                                                                                 " ).append("\n"); 
		query.append("WHERE D_POR = 1 AND D_POL = 1 AND D_POD = 1 AND D_DEL = 1 AND MAT_LOC_CNT = 1" ).append("\n"); 

	}
}