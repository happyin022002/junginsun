/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchEMUPfmcListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchEMUPfmcListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EMU 단가 조회   
	  * 2012.03.01 [CHM-201216305] 이석준  EMU 조회할때 POR,DEL이 각각 suplus,defit일때 0처리
	  * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -EMU(RA) Origin Credit Ratio 추가
	  * 2012.10.18 전윤주 기존 쿼리 보완 (불필요하게 join 된 테이블 삭제)
	  * 2012.12.24 최윤성 [CHM-201222072] RF화물의 EMU Credit 적용로직 변경 - RD를 R로 replace 하도록 로직 추가
	  * 2013.05.15 박찬민 [CHM-201324727] 2013년 2Q EMU 보완
	  * 2013.06.20 김수정 [CHM-201325173] EMU 시스템 보완 RCC DEHAM 이외 지역 OP Credit Ratio 조정 가능토록 수정
	  * 2013.07.18 김수정 [CHM-201325174-01] OP/DEL Rule이 Y인 경우에만 Credit Amount 계산하도록 수정
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchEMUPfmcListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_from_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchEMUPfmcListVORSQL").append("\n"); 
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
		query.append("SELECT      E1.COST_YRMON" ).append("\n"); 
		query.append("          , E1.ORG_LOC_CD" ).append("\n"); 
		query.append("          , E1.POD_ECC_CD" ).append("\n"); 
		query.append("          , E1.DEST_LOC_CD" ).append("\n"); 
		query.append("          , E1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          , E1.REPO_UT_AMT_POR" ).append("\n"); 
		query.append("          , E1.REPO_UT_AMT_DEL" ).append("\n"); 
		query.append("          , E1.BSE_UT_AMT" ).append("\n"); 
		query.append("          , E1.SIM_MTY_COST_AMT_POR" ).append("\n"); 
		query.append("          , E1.SIM_MTY_COST_AMT_POD" ).append("\n"); 
		query.append("          , E1.SIM_MTY_COST_AMT_TTL" ).append("\n"); 
		query.append("		  , CASE " ).append("\n"); 
		query.append("                 WHEN NVL(E3.POR_REPO_FLG, 'N')||NVL(E4.DEL_REPO_FLG, 'N') = 'YY' THEN" ).append("\n"); 
		query.append("                      CASE " ).append("\n"); 
		query.append("                           WHEN E1.COST_YRMON >= 201304 AND NVL(E2.EQ_REPO_CR_RTO,0)<>0 THEN ROUND((((E1.SIM_MTY_COST_AMT_POR*NVL(E1.OP_EQ_REPO_CR_RTO,0))+E1.SIM_MTY_COST_AMT_POD) * E2.EQ_REPO_CR_RTO),2)" ).append("\n"); 
		query.append("                           WHEN E1.COST_YRMON >= 201304 AND NVL(E2.EQ_REPO_CR_RTO,0)=0 AND E1.DEL_EQ_REPO_CR_RTO IS NOT NULL THEN  ROUND((((E1.SIM_MTY_COST_AMT_POR*NVL(E1.OP_EQ_REPO_CR_RTO,0))+E1.SIM_MTY_COST_AMT_POD) * E1.DEL_EQ_REPO_CR_RTO),2)" ).append("\n"); 
		query.append("                           WHEN E1.COST_YRMON < 201304 AND NVL(E1.DEL_EQ_REPO_CR_RTO,0)<>0 THEN ROUND((((E1.SIM_MTY_COST_AMT_POR*NVL(E1.OP_EQ_REPO_CR_RTO,0))+E1.SIM_MTY_COST_AMT_POD) * E1.DEL_EQ_REPO_CR_RTO),2)" ).append("\n"); 
		query.append("                           WHEN E1.COST_YRMON < 201304 AND NVL(E1.DEL_EQ_REPO_CR_RTO,0)=0 AND E2.EQ_REPO_CR_RTO IS NOT NULL THEN ROUND((((E1.SIM_MTY_COST_AMT_POR*NVL(E1.OP_EQ_REPO_CR_RTO,0))+E1.SIM_MTY_COST_AMT_POD) * E2.EQ_REPO_CR_RTO),2)" ).append("\n"); 
		query.append("                           ELSE ROUND((E1.SIM_MTY_COST_AMT_POR*NVL(E1.OP_EQ_REPO_CR_RTO,0))*0,2)" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                 ELSE 0                 " ).append("\n"); 
		query.append("        	END  EMU_ADJ_MTY_COST_AMT_TTL" ).append("\n"); 
		query.append("          , E1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("          , DECODE(NVL(E3.POR_REPO_FLG, 'N'), 'N', 'No', 'Yes') AS OP_STG" ).append("\n"); 
		query.append("          , DECODE(NVL(E4.DEL_REPO_FLG, 'N'), 'N', 'No', 'Yes') AS DEL_STG" ).append("\n"); 
		query.append("          , CASE WHEN E1.OP_EQ_REPO_CR_RTO IS NOT NULL THEN E1.OP_EQ_REPO_CR_RTO * 100 || '%' " ).append("\n"); 
		query.append("                 ELSE '' END AS OP_EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("          , CASE WHEN E1.COST_YRMON >= 201304 AND NVL(E2.EQ_REPO_CR_RTO,0)<>0 THEN E2.EQ_REPO_CR_RTO * 100 || '%'" ).append("\n"); 
		query.append("                 WHEN E1.COST_YRMON >= 201304 AND NVL(E2.EQ_REPO_CR_RTO,0)=0 AND E1.DEL_EQ_REPO_CR_RTO IS NOT NULL THEN  E1.DEL_EQ_REPO_CR_RTO *100 || '%'" ).append("\n"); 
		query.append("                 WHEN E1.COST_YRMON < 201304 AND NVL(E1.DEL_EQ_REPO_CR_RTO,0)<>0 THEN E1.DEL_EQ_REPO_CR_RTO *100  || '%'" ).append("\n"); 
		query.append("                 WHEN E1.COST_YRMON < 201304 AND NVL(E1.DEL_EQ_REPO_CR_RTO,0)=0 AND E2.EQ_REPO_CR_RTO IS NOT NULL THEN E2.EQ_REPO_CR_RTO *100 || '%'" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("             END DEL_EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("          , E1.POR_STS" ).append("\n"); 
		query.append("          , E1.POR_RTO" ).append("\n"); 
		query.append("          , E1.DEL_STS" ).append("\n"); 
		query.append("          , E1.DEL_RTO" ).append("\n"); 
		query.append("          , E1.MNL_RQST_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT D2.COST_YRMON" ).append("\n"); 
		query.append("          , D1.FROM_ECC ORG_LOC_CD" ).append("\n"); 
		query.append("          , D1.POD_ECC POD_ECC_CD" ).append("\n"); 
		query.append("          , D1.TO_ECC DEST_LOC_CD" ).append("\n"); 
		query.append("          , D2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          , DECODE(D2.POR_STS, 'S', 0, D2.REPO_UT_AMT_POR) REPO_UT_AMT_POR" ).append("\n"); 
		query.append("          , DECODE(D2.DEL_STS, 'D', 0, D2.REPO_UT_AMT_DEL) REPO_UT_AMT_DEL" ).append("\n"); 
		query.append("          , NVL(DECODE(D2.POR_STS, 'S', 0, D2.REPO_UT_AMT_POR), 0) + NVL(DECODE(D2.DEL_STS, 'D', 0, D2.REPO_UT_AMT_DEL), 0) BSE_UT_AMT" ).append("\n"); 
		query.append("          , NVL(D3.SIM_MTY_COST_AMT_POR, 0) SIM_MTY_COST_AMT_POR" ).append("\n"); 
		query.append("          , NVL(COALESCE(D4.SIM_POD_STEV_ECC, D4.SIM_POD_STEV_LCC, D4.SIM_POD_STEV_RCC, 0), 0) SIM_MTY_COST_AMT_POD" ).append("\n"); 
		query.append("            /* 다른 SIMULATED COST가 NULL 일 때는 보여주지 않음 */" ).append("\n"); 
		query.append("          , NVL(D3.SIM_MTY_COST_AMT_POR, 0) + NVL(COALESCE(D4.SIM_POD_STEV_ECC, D4.SIM_POD_STEV_LCC, D4.SIM_POD_STEV_RCC, 0 ), 0) SIM_MTY_COST_AMT_TTL" ).append("\n"); 
		query.append("          , D2.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("--          , DECODE(D5.OP_EQ_REPO_CR_RTO, NULL, 'No', 'Yes') OP_STG" ).append("\n"); 
		query.append("--          , DECODE(D6.DEL_EQ_REPO_CR_RTO, NULL, 'No', 'Yes') DEL_STG" ).append("\n"); 
		query.append("          , D5.OP_EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("--          , CASE WHEN D6.DEL_EQ_REPO_CR_RTO IS NOT NULL THEN D6.DEL_EQ_REPO_CR_RTO * 100 || '%' " ).append("\n"); 
		query.append("--                 ELSE '' END AS DEL_EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("          , D6.DEL_EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("          , DECODE(D2.POR_STS, 'S', 'Surplus', 'D', 'Deficit') POR_STS" ).append("\n"); 
		query.append("          , D2.POR_RTO*100 POR_RTO" ).append("\n"); 
		query.append("          , DECODE(D2.DEL_STS, 'S', 'Surplus', 'D', 'Deficit') DEL_STS" ).append("\n"); 
		query.append("          , D2.DEL_RTO*100 DEL_RTO" ).append("\n"); 
		query.append("          , D2.MNL_RQST_FLG" ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("                    /* FROM, TO */" ).append("\n"); 
		query.append("                     SELECT FROM_ECC" ).append("\n"); 
		query.append("                          , POD_ECC" ).append("\n"); 
		query.append("                          , TO_ECC" ).append("\n"); 
		query.append("                       FROM (" ).append("\n"); 
		query.append("                                    SELECT DISTINCT @[f_from_ecc_cd] FROM_ECC" ).append("\n"); 
		query.append("                                          , B2.ECC_CD POD_ECC" ).append("\n"); 
		query.append("                                          , B2.RCC_CD POD_RCC" ).append("\n"); 
		query.append("                                       FROM MDM_LOCATION B1" ).append("\n"); 
		query.append("                                          , MDM_EQ_ORZ_CHT B2" ).append("\n"); 
		query.append("                                      WHERE B1.SCC_CD             = B2.SCC_CD" ).append("\n"); 
		query.append("                                        AND NVL(B2.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                        AND B1.SCC_CD            <>'XXXXX'" ).append("\n"); 
		query.append("    #if (${f_pod_ecc_cd} != '')" ).append("\n"); 
		query.append("                                        AND B2.ECC_CD = @[f_pod_ecc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                        AND B1.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                            ) C1" ).append("\n"); 
		query.append("                            /* POD ECC는 PORT 에 해당하는 ECC만 가져옴 */" ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                                    SELECT DISTINCT ECC_CD TO_ECC" ).append("\n"); 
		query.append("                                          , RCC_CD TO_RCC" ).append("\n"); 
		query.append("                                       FROM COA_LOCATION_V" ).append("\n"); 
		query.append("                            ) C2" ).append("\n"); 
		query.append("                      WHERE C1.POD_RCC = C2.TO_RCC" ).append("\n"); 
		query.append("            ) D1" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("                    /* 회송비 ECC>LCC>RCC */" ).append("\n"); 
		query.append("                     SELECT B1.COST_YRMON" ).append("\n"); 
		query.append("                          , B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                          , B1.ORG_LOC_CD" ).append("\n"); 
		query.append("                          , B2.DEST_LOC_CD" ).append("\n"); 
		query.append("                          , COALESCE(B1.PLCY_PRC_AMT_ECC, B1.PLCY_PRC_AMT_LCC, B1.PLCY_PRC_AMT_RCC, 0) REPO_UT_AMT_POR" ).append("\n"); 
		query.append("                          , COALESCE(B2.PLCY_PRC_AMT_ECC, B2.PLCY_PRC_AMT_LCC, B2.PLCY_PRC_AMT_RCC, 0) REPO_UT_AMT_DEL" ).append("\n"); 
		query.append("                          , NULL SIM_UT_AMT" ).append("\n"); 
		query.append("                          , B1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("                          , B1.CNTR_IO_VOL_STS_CD POR_STS" ).append("\n"); 
		query.append("                          , B1.IMBAL_RTO POR_RTO" ).append("\n"); 
		query.append("                          , B2.CNTR_IO_VOL_STS_CD DEL_STS" ).append("\n"); 
		query.append("                          , B2.IMBAL_RTO DEL_RTO" ).append("\n"); 
		query.append("                          , GREATEST(B1.MNL_RQST_FLG, B2.MNL_RQST_FLG) AS MNL_RQST_FLG" ).append("\n"); 
		query.append("                       FROM ( /* POR REPO 단가 가져오는 부분 */" ).append("\n"); 
		query.append("                                     SELECT A1.COST_YR" ).append("\n"); 
		query.append("                                          , A1.COST_MON" ).append("\n"); 
		query.append("                                          , A1.COST_YR || A1.COST_MON COST_YRMON" ).append("\n"); 
		query.append("                                          , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                          , A1.LOC_CD ORG_LOC_CD" ).append("\n"); 
		query.append("                                          , A1.PLCY_PRC_AMT PLCY_PRC_AMT_ECC" ).append("\n"); 
		query.append("                                          , (" ).append("\n"); 
		query.append("                                                     SELECT PLCY_PRC_AMT" ).append("\n"); 
		query.append("                                                       FROM COA_REPO_IF_MGMT" ).append("\n"); 
		query.append("                                                      WHERE COST_YR          = A1.COST_YR" ).append("\n"); 
		query.append("                                                        AND COST_MON         = A1.COST_MON" ).append("\n"); 
		query.append("                                                        AND VER_TP_CD        = A1.VER_TP_CD" ).append("\n"); 
		query.append("                                                        AND COST_LOC_GRP_CD  = 'L'" ).append("\n"); 
		query.append("                                                        AND IF_VER_CD        = A1.IF_VER_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_TPSZ_CD     = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                        AND LOC_CD           = COA_LOC_FNC(A1.LOC_CD, 'LCC')" ).append("\n"); 
		query.append("                                            ) PLCY_PRC_AMT_LCC" ).append("\n"); 
		query.append("                                          , (" ).append("\n"); 
		query.append("                                                     SELECT PLCY_PRC_AMT" ).append("\n"); 
		query.append("                                                       FROM COA_REPO_IF_MGMT" ).append("\n"); 
		query.append("                                                      WHERE COST_YR          = A1.COST_YR" ).append("\n"); 
		query.append("                                                        AND COST_MON         = A1.COST_MON" ).append("\n"); 
		query.append("                                                        AND VER_TP_CD        = A1.VER_TP_CD" ).append("\n"); 
		query.append("                                                        AND COST_LOC_GRP_CD  = 'R'" ).append("\n"); 
		query.append("                                                        AND IF_VER_CD        = A1.IF_VER_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_TPSZ_CD     = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                        AND LOC_CD           = COA_LOC_FNC(A1.LOC_CD, 'RCC')" ).append("\n"); 
		query.append("                                            ) PLCY_PRC_AMT_RCC" ).append("\n"); 
		query.append("                                          , A1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("                                          , A2.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("                                          , ROUND(DECODE(SIGN(A2.CNTR_IB_QTY-A2.CNTR_OB_QTY), 1 , A2.CNTR_OB_QTY / A2.CNTR_IB_QTY, -1, -1 * A2.CNTR_IB_QTY / A2.CNTR_OB_QTY , 0 , 1),2) IMBAL_RTO -- A2.CNTR_IMBAL_RTO IMBAL_RTO 2013.05.15 박찬민 [CHM-201324727] 2013년 2Q EMU 보완" ).append("\n"); 
		query.append("                                          , NVL(A1.MNL_RQST_FLG, 'N') AS MNL_RQST_FLG" ).append("\n"); 
		query.append("                                       FROM COA_REPO_IF_MGMT A1" ).append("\n"); 
		query.append("                                          , COA_FULL_ECC_IMBAL A2 /* IMBAL_RTO 가져오기 위해 JOIN */                                        " ).append("\n"); 
		query.append("                                      WHERE 1                       = 1" ).append("\n"); 
		query.append("                                        AND A1.COST_YR              = SUBSTR(@[f_cost_yrmon], 1, 4)" ).append("\n"); 
		query.append("                                        AND A1.COST_MON             = SUBSTR(@[f_cost_yrmon], 5, 6)" ).append("\n"); 
		query.append("                                        AND A1.VER_TP_CD            = 'M'" ).append("\n"); 
		query.append("                                        AND A1.COST_LOC_GRP_CD      = 'E'" ).append("\n"); 
		query.append("                                        AND A1.IF_VER_CD            = '0'" ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD         = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("                                        AND A1.CNTR_ORG_DEST_CD     = 'P'" ).append("\n"); 
		query.append("                                        AND A1.LOC_CD               = @[f_from_ecc_cd]" ).append("\n"); 
		query.append("                                        AND A1.COST_YR||A1.COST_MON = A2.COST_YRMON      (+)" ).append("\n"); 
		query.append("                                        AND A1.COST_LOC_GRP_CD      = A2.COST_LOC_GRP_CD (+)" ).append("\n"); 
		query.append("                                        AND A1.LOC_CD               = A2.FCNTR_ECC_CD    (+)" ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD         = A2.CNTR_TPSZ_CD    (+)" ).append("\n"); 
		query.append("                             ) B1" ).append("\n"); 
		query.append("                          , ( /* DEL REPO 단가 가져오는 부분*/" ).append("\n"); 
		query.append("                                     SELECT A1.COST_YR || A1.COST_MON COST_YRMON" ).append("\n"); 
		query.append("                                          , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                          , A1.LOC_CD DEST_LOC_CD" ).append("\n"); 
		query.append("                                          , A1.PLCY_PRC_AMT PLCY_PRC_AMT_ECC" ).append("\n"); 
		query.append("                                          , (" ).append("\n"); 
		query.append("                                                     SELECT PLCY_PRC_AMT" ).append("\n"); 
		query.append("                                                       FROM COA_REPO_IF_MGMT" ).append("\n"); 
		query.append("                                                      WHERE COST_YR          = A1.COST_YR" ).append("\n"); 
		query.append("                                                        AND COST_MON         = A1.COST_MON" ).append("\n"); 
		query.append("                                                        AND VER_TP_CD        = A1.VER_TP_CD" ).append("\n"); 
		query.append("                                                        AND COST_LOC_GRP_CD  = 'L'" ).append("\n"); 
		query.append("                                                        AND IF_VER_CD        = A1.IF_VER_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_TPSZ_CD     = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                        AND LOC_CD           = COA_LOC_FNC(A1.LOC_CD, 'LCC')" ).append("\n"); 
		query.append("                                            ) PLCY_PRC_AMT_LCC" ).append("\n"); 
		query.append("                                          , (" ).append("\n"); 
		query.append("                                                     SELECT PLCY_PRC_AMT" ).append("\n"); 
		query.append("                                                       FROM COA_REPO_IF_MGMT" ).append("\n"); 
		query.append("                                                      WHERE COST_YR          = A1.COST_YR" ).append("\n"); 
		query.append("                                                        AND COST_MON         = A1.COST_MON" ).append("\n"); 
		query.append("                                                        AND VER_TP_CD        = A1.VER_TP_CD" ).append("\n"); 
		query.append("                                                        AND COST_LOC_GRP_CD  = 'R'" ).append("\n"); 
		query.append("                                                        AND IF_VER_CD        = A1.IF_VER_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_TPSZ_CD     = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                        AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                        AND LOC_CD           = COA_LOC_FNC(A1.LOC_CD, 'RCC')" ).append("\n"); 
		query.append("                                            ) PLCY_PRC_AMT_RCC" ).append("\n"); 
		query.append("                                          , A1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("                                          , A2.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("                                          , ROUND(DECODE(SIGN(A2.CNTR_IB_QTY-A2.CNTR_OB_QTY), 1 , A2.CNTR_OB_QTY / A2.CNTR_IB_QTY, -1, -1 * A2.CNTR_IB_QTY / A2.CNTR_OB_QTY , 0 , 1),2) IMBAL_RTO -- A2.CNTR_IMBAL_RTO IMBAL_RTO 2013.05.15 박찬민 [CHM-201324727] 2013년 2Q EMU 보완" ).append("\n"); 
		query.append("                                          , NVL(A1.MNL_RQST_FLG, 'N') AS MNL_RQST_FLG" ).append("\n"); 
		query.append("                                       FROM COA_REPO_IF_MGMT A1" ).append("\n"); 
		query.append("                                          , COA_FULL_ECC_IMBAL A2 /* IMBAL_RTO 가져오기 위해 JOIN */                                        " ).append("\n"); 
		query.append("                                      WHERE 1                  = 1" ).append("\n"); 
		query.append("                                        AND A1.COST_YR         = SUBSTR(@[f_cost_yrmon], 1, 4)" ).append("\n"); 
		query.append("                                        AND A1.COST_MON        = SUBSTR(@[f_cost_yrmon], 5, 6)" ).append("\n"); 
		query.append("                                        AND A1.VER_TP_CD       = 'M'" ).append("\n"); 
		query.append("                                        AND A1.COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("                                        AND A1.IF_VER_CD       = '0'" ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD    = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("    #if (${f_to_ecc_cd} != '')" ).append("\n"); 
		query.append("                                        AND A1.LOC_CD               = @[f_to_ecc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                        AND A1.CNTR_ORG_DEST_CD     = 'D'" ).append("\n"); 
		query.append("                                        AND A1.COST_YR||A1.COST_MON = A2.COST_YRMON      (+)" ).append("\n"); 
		query.append("                                        AND A1.COST_LOC_GRP_CD      = A2.COST_LOC_GRP_CD (+)" ).append("\n"); 
		query.append("                                        AND A1.LOC_CD               = A2.FCNTR_ECC_CD    (+) " ).append("\n"); 
		query.append("                                        AND A1.CNTR_TPSZ_CD         = A2.CNTR_TPSZ_CD    (+)                               " ).append("\n"); 
		query.append("                            ) B2" ).append("\n"); 
		query.append("                      WHERE B1.CNTR_TPSZ_CD    = B2.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                        AND B1.COST_LOC_GRP_CD = B2.COST_LOC_GRP_CD(+)" ).append("\n"); 
		query.append("            ) D2" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("            /* SIM POR 금액 */" ).append("\n"); 
		query.append("             SELECT B1.COST_YRMON" ).append("\n"); 
		query.append("                  , B1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , B1.ORG_LOC_CD" ).append("\n"); 
		query.append("                  , COALESCE(B1.SIM_STVG_UC_AMT_ECC, B1.SIM_STVG_UC_AMT_LCC, B1.SIM_STVG_UC_AMT_RCC, 0) " ).append("\n"); 
		query.append("                     + COALESCE(B1.SIM_TRSP_UC_AMT_ECC, B1.SIM_TRSP_UC_AMT_LCC, B1.SIM_TRSP_UC_AMT_RCC, 0) SIM_MTY_COST_AMT_POR" ).append("\n"); 
		query.append("                  , B1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("               FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                             SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("                                  , A1.ECC_CD ORG_LOC_CD" ).append("\n"); 
		query.append("                                  , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                  /* SIMULATED POR STEVE 비용(ECC, LCC, RCC) */" ).append("\n"); 
		query.append("                                  , A1.SIM_STVG_UC_AMT SIM_STVG_UC_AMT_ECC" ).append("\n"); 
		query.append("                                  , (" ).append("\n"); 
		query.append("                                             SELECT SIM_STVG_UC_AMT" ).append("\n"); 
		query.append("                                               FROM COA_MTY_ECC_UT_COST" ).append("\n"); 
		query.append("                                              WHERE COST_YRMON = A1.COST_YRMON" ).append("\n"); 
		query.append("                                                AND ECC_CD = COA_LOC_FNC(A1.ECC_CD, 'LCC')" ).append("\n"); 
		query.append("                                                AND CNTR_TPSZ_CD = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                AND CNTR_IO_VOL_STS_CD = A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("                                                AND COST_LOC_GRP_CD = 'L'" ).append("\n"); 
		query.append("                                    ) SIM_STVG_UC_AMT_LCC" ).append("\n"); 
		query.append("                                  , (" ).append("\n"); 
		query.append("                                             SELECT SIM_STVG_UC_AMT" ).append("\n"); 
		query.append("                                               FROM COA_MTY_ECC_UT_COST" ).append("\n"); 
		query.append("                                              WHERE COST_YRMON = A1.COST_YRMON" ).append("\n"); 
		query.append("                                                AND ECC_CD = COA_LOC_FNC(A1.ECC_CD, 'RCC')" ).append("\n"); 
		query.append("                                                AND CNTR_TPSZ_CD = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                AND CNTR_IO_VOL_STS_CD = A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("                                                AND COST_LOC_GRP_CD = 'R'" ).append("\n"); 
		query.append("                                    ) SIM_STVG_UC_AMT_RCC" ).append("\n"); 
		query.append("                                    /*SIMULATED POR TRANS 비용(ECC, LCC, RCC)   */" ).append("\n"); 
		query.append("                                  , A1.SIM_TRSP_UC_AMT SIM_TRSP_UC_AMT_ECC" ).append("\n"); 
		query.append("                                  , (" ).append("\n"); 
		query.append("                                             SELECT SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("                                               FROM COA_MTY_ECC_UT_COST" ).append("\n"); 
		query.append("                                              WHERE COST_YRMON = A1.COST_YRMON" ).append("\n"); 
		query.append("                                                AND ECC_CD = COA_LOC_FNC(A1.ECC_CD, 'LCC')" ).append("\n"); 
		query.append("                                                AND CNTR_TPSZ_CD = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                AND CNTR_IO_VOL_STS_CD = A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("                                                AND COST_LOC_GRP_CD = 'L'" ).append("\n"); 
		query.append("                                    ) SIM_TRSP_UC_AMT_LCC" ).append("\n"); 
		query.append("                                  , (" ).append("\n"); 
		query.append("                                             SELECT SIM_TRSP_UC_AMT" ).append("\n"); 
		query.append("                                               FROM COA_MTY_ECC_UT_COST" ).append("\n"); 
		query.append("                                              WHERE COST_YRMON = A1.COST_YRMON" ).append("\n"); 
		query.append("                                                AND ECC_CD = COA_LOC_FNC(A1.ECC_CD, 'RCC')" ).append("\n"); 
		query.append("                                                AND CNTR_TPSZ_CD = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                AND CNTR_ORG_DEST_CD = A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                                AND CNTR_IO_VOL_STS_CD = A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("                                                AND COST_LOC_GRP_CD = 'R'" ).append("\n"); 
		query.append("                                    ) SIM_TRSP_UC_AMT_RCC" ).append("\n"); 
		query.append("                                  , A1.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("                               FROM COA_MTY_ECC_UT_COST A1" ).append("\n"); 
		query.append("                                  , (" ).append("\n"); 
		query.append("                                             SELECT CNTR_TPSZ_CD TPSZ_CD" ).append("\n"); 
		query.append("                                               FROM COA_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("                                              WHERE NVL(REPO_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                                    ) A2" ).append("\n"); 
		query.append("                              WHERE A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("                                AND A1.CNTR_ORG_DEST_CD = 'O' /* POR SIMULATED 비용 */" ).append("\n"); 
		query.append("                                AND A1.CNTR_TPSZ_CD = TPSZ_CD" ).append("\n"); 
		query.append("                                AND A1.ECC_CD = @[f_from_ecc_cd]" ).append("\n"); 
		query.append("                                AND A1.COST_LOC_GRP_CD = 'E'" ).append("\n"); 
		query.append("                                AND A1.CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("                    ) B1" ).append("\n"); 
		query.append("            ) D3" ).append("\n"); 
		query.append("          , ( /* SIM POD STEVE 금액 */" ).append("\n"); 
		query.append("                     SELECT C1.COST_YRMON" ).append("\n"); 
		query.append("                          , C1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                          , C1.ECC_CD POD_LOC_CD" ).append("\n"); 
		query.append("                          , C1.SIM_STVG_UC_AMT SIM_POD_STEV_ECC" ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                                     SELECT SIM_STVG_UC_AMT" ).append("\n"); 
		query.append("                                       FROM COA_MTY_DEST_COST" ).append("\n"); 
		query.append("                                      WHERE COST_YRMON       = C1.COST_YRMON" ).append("\n"); 
		query.append("                                        AND CNTR_ORG_DEST_CD = C1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                        AND COST_LOC_GRP_CD  = 'L'" ).append("\n"); 
		query.append("                                        AND ECC_CD           = COA_LOC_FNC(C1.ECC_CD, 'LCC')" ).append("\n"); 
		query.append("                                        AND CNTR_TPSZ_CD     = C1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            ) SIM_POD_STEV_LCC" ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                                     SELECT SIM_STVG_UC_AMT" ).append("\n"); 
		query.append("                                       FROM COA_MTY_DEST_COST" ).append("\n"); 
		query.append("                                      WHERE COST_YRMON       = C1.COST_YRMON" ).append("\n"); 
		query.append("                                        AND CNTR_ORG_DEST_CD = C1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                                        AND COST_LOC_GRP_CD  = 'R'" ).append("\n"); 
		query.append("                                        AND ECC_CD           = COA_LOC_FNC(C1.ECC_CD, 'RCC')" ).append("\n"); 
		query.append("                                        AND CNTR_TPSZ_CD     = C1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                            ) SIM_POD_STEV_RCC" ).append("\n"); 
		query.append("                       FROM COA_MTY_DEST_COST C1" ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                                     SELECT CNTR_TPSZ_CD TPSZ_CD" ).append("\n"); 
		query.append("                                       FROM COA_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("                                      WHERE NVL(REPO_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                      WHERE C1.COST_YRMON       = @[f_cost_yrmon]" ).append("\n"); 
		query.append("                        AND C1.CNTR_ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("                        AND C1.COST_LOC_GRP_CD  = 'E'" ).append("\n"); 
		query.append("                        AND C1.CNTR_TPSZ_CD     = TPSZ_CD" ).append("\n"); 
		query.append("                        AND C1.CNTR_TPSZ_CD     = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("            ) D4       " ).append("\n"); 
		query.append("    	, ( /* OP Credit ratio */" ).append("\n"); 
		query.append("            SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("                  ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  ,A1.ECC_CD" ).append("\n"); 
		query.append("                  ,A1.RCC_CD" ).append("\n"); 
		query.append("                  ,CASE WHEN A1.COST_YRMON >= '201305' THEN" ).append("\n"); 
		query.append("                             NVL(A1.EQ_REPO_CR_RTO, 0)" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                             CASE WHEN A1.RCC_CD = 'DEHAM' AND A1.CNTR_TPSZ_CD IN ('D2', 'D4', 'D5')" ).append("\n"); 
		query.append("                                  THEN NVL(A1.EQ_REPO_CR_RTO, 0)" ).append("\n"); 
		query.append("                                  ELSE 1" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                   END AS OP_EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("                  ,A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("              FROM COA_CNTR_REPO_SHTG_INFO A1, COA_CNTR_REPO_ROUT_ECC A2" ).append("\n"); 
		query.append("             WHERE A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("               AND A1.CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("               AND A1.ECC_CD = @[f_from_ecc_cd]" ).append("\n"); 
		query.append("               AND A1.CNTR_ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("               AND A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("               AND A1.RCC_CD = A2.RCC_CD" ).append("\n"); 
		query.append("               AND A1.ECC_CD = A2.ECC_CD" ).append("\n"); 
		query.append("               AND A2.CNTR_TPSZ_CD = DECODE(SUBSTR(A1.CNTR_TPSZ_CD, 1, 1), 'D', 'D', A1.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("               AND A2.POR_REPO_FLG = 'Y'" ).append("\n"); 
		query.append("            ) D5" ).append("\n"); 
		query.append("          , ( /* DEL Credit ratio */" ).append("\n"); 
		query.append("              SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("                    ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    ,A1.ECC_CD" ).append("\n"); 
		query.append("                    ,A1.RCC_CD" ).append("\n"); 
		query.append("                    ,A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("                    ,A1.EQ_REPO_CR_RTO DEL_EQ_REPO_CR_RTO" ).append("\n"); 
		query.append("                FROM COA_CNTR_REPO_SHTG_INFO A1, COA_CNTR_REPO_ROUT_ECC A2" ).append("\n"); 
		query.append("               WHERE A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("                 AND A1.CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R')" ).append("\n"); 
		query.append("    #if (${f_to_ecc_cd} != '')" ).append("\n"); 
		query.append("                 AND A1.ECC_CD = @[f_to_ecc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                 AND A1.CNTR_ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("                 AND A1.COST_YRMON = A2.COST_YRMON" ).append("\n"); 
		query.append("                 AND A1.RCC_CD = A2.RCC_CD" ).append("\n"); 
		query.append("                 AND A1.ECC_CD = A2.ECC_CD" ).append("\n"); 
		query.append("                 AND A2.CNTR_TPSZ_CD = DECODE(SUBSTR(A1.CNTR_TPSZ_CD, 1, 1), 'D', 'D', A1.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                 AND A2.DEL_REPO_FLG = 'Y' " ).append("\n"); 
		query.append("            ) D6" ).append("\n"); 
		query.append("      WHERE D1.FROM_ECC = D2.ORG_LOC_CD" ).append("\n"); 
		query.append("        AND D1.TO_ECC   = D2.DEST_LOC_CD" ).append("\n"); 
		query.append("        AND D1.FROM_ECC = D3.ORG_LOC_CD(+)" ).append("\n"); 
		query.append("        AND D1.POD_ECC  = D4.POD_LOC_CD(+)" ).append("\n"); 
		query.append("        AND D2.ORG_LOC_CD = D5.ECC_CD(+)" ).append("\n"); 
		query.append("        AND D2.DEST_LOC_CD = D6.ECC_CD(+)" ).append("\n"); 
		query.append("    )E1," ).append("\n"); 
		query.append("    (SELECT POR_ECC_CD, DEL_ECC_CD, EQ_REPO_CR_RTO " ).append("\n"); 
		query.append("      FROM coa_cntr_repo_spls_del_rto A1, COA_CNTR_REPO_ROUT_ECC A2" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND   A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("      AND   A1.CNTR_TPSZ_CD = REPLACE(@[f_cntr_tpsz_cd] ,'RD','R')" ).append("\n"); 
		query.append("      AND   A1.POR_ECC_CD = @[f_from_ecc_cd]" ).append("\n"); 
		query.append("    #if (${f_to_ecc_cd} != '')" ).append("\n"); 
		query.append("      AND   A1.DEL_ECC_CD = @[f_to_ecc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND   A2.COST_YRMON = A1.COST_YRMON" ).append("\n"); 
		query.append("      AND   A2.RCC_CD = COA_LOC_FNC(A1.DEL_ECC_CD,'RCC')" ).append("\n"); 
		query.append("      AND   A2.ECC_CD = A1.DEL_ECC_CD" ).append("\n"); 
		query.append("      AND   A2.CNTR_TPSZ_CD = DECODE(SUBSTR(A1.CNTR_TPSZ_CD, 1, 1), 'D', 'D', A1.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("      AND   A2.DEL_REPO_FLG = 'Y' " ).append("\n"); 
		query.append("  ) E2," ).append("\n"); 
		query.append("  COA_CNTR_REPO_ROUT_ECC E3, " ).append("\n"); 
		query.append("  COA_CNTR_REPO_ROUT_ECC E4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND E1.ORG_LOC_CD = E2.POR_ECC_CD(+)" ).append("\n"); 
		query.append("AND E1.DEST_LOC_CD = E2.DEL_ECC_CD(+)" ).append("\n"); 
		query.append("AND E1.COST_YRMON  = E3.COST_YRMON (+)" ).append("\n"); 
		query.append("AND E1.ORG_LOC_CD  = E3.ECC_CD(+)" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(E1.CNTR_TPSZ_CD, 1, 1), 'D', 'D', E1.CNTR_TPSZ_CD) = E3.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND E1.COST_YRMON  = E4.COST_YRMON (+)" ).append("\n"); 
		query.append("AND E1.DEST_LOC_CD = E4.ECC_CD(+)" ).append("\n"); 
		query.append("AND DECODE(SUBSTR(E1.CNTR_TPSZ_CD, 1, 1), 'D', 'D', E1.CNTR_TPSZ_CD) = E4.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY E1.ORG_LOC_CD" ).append("\n"); 
		query.append("       , E1.POD_ECC_CD" ).append("\n"); 
		query.append("       , E1.DEST_LOC_CD" ).append("\n"); 

	}
}