/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchUnmatchBLSettlementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchUnmatchBLSettlementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unmatch BL Settelement Report 조회
	  * 
	  * [CHM-201539496] Error B/L Settlement Report 보완요청
	  * KPI2항목 추가 : Error건중에 RDN이 발행된 건은 건수에서 제외 
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchUnmatchBLSettlementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchUnmatchBLSettlementListRSQL").append("\n"); 
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
		query.append("SELECT RCT_RHQ_CD, BKG_OFC_CD," ).append("\n"); 
		query.append("       S_B_CNT, S_B_STL_PRD," ).append("\n"); 
		query.append("       S_A_CNT, S_A_STL_PRD," ).append("\n"); 
		query.append("       S_M_CNT, S_M_STL_PRD," ).append("\n"); 
		query.append("       S_O_CNT, S_O_STL_PRD," ).append("\n"); 
		query.append("       S_C_CNT, S_C_STL_PRD," ).append("\n"); 
		query.append("       BL_S_CNT, BL_S_STL_PRD, BL_S_AVG_STL_PRD," ).append("\n"); 
		query.append("       BL_U_CNT, BL_U_STL_PRD, BL_U_AVG_STL_PRD," ).append("\n"); 
		query.append("       TTL_BL_CNT, TTL_STL_PRD, TTL_AVG_STL_PRD," ).append("\n"); 
		query.append("       KPI_MORE_THAN6, KPI_LESS_THAN6," ).append("\n"); 
		query.append("       KPI2_MORE_THAN6, KPI2_LESS_THAN6" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("        SELECT RCT_RHQ_CD," ).append("\n"); 
		query.append("               BKG_OFC_CD," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'B',1,0),0))  S_B_CNT   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'B',STL_PRD,0),0))  S_B_STL_PRD   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'A',1,0),0))  S_A_CNT   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'A',STL_PRD,0),0))  S_A_STL_PRD   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'M',1,0),0))  S_M_CNT   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'M',STL_PRD,0),0))  S_M_STL_PRD   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'O',1,0),0))  S_O_CNT   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'O',STL_PRD,0),0))  S_O_STL_PRD   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'C',1,0),0))  S_C_CNT   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(REV_AUD_STL_KND_CD,'C',STL_PRD,0),0))  S_C_STL_PRD   ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(BKG_NO,NULL,0,1),0))     BL_S_CNT  ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(BKG_NO,NULL,0,STL_PRD),0))     BL_S_STL_PRD  ," ).append("\n"); 
		query.append("               CASE WHEN SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(BKG_NO,NULL,0,1),0)) = 0 THEN 0" ).append("\n"); 
		query.append("                    ELSE ROUND(SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(BKG_NO,NULL,0,STL_PRD),0)) / SUM(DECODE(REV_AUD_STS_CD,'S',DECODE(BKG_NO,NULL,0,1),0)),2)" ).append("\n"); 
		query.append("               END BL_S_AVG_STL_PRD," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'U',DECODE(BKG_NO,NULL,0,1),0))     BL_U_CNT  ," ).append("\n"); 
		query.append("               SUM(DECODE(REV_AUD_STS_CD,'U',DECODE(BKG_NO,NULL,0,STL_PRD),0))     BL_U_STL_PRD  ," ).append("\n"); 
		query.append("               CASE WHEN SUM(DECODE(REV_AUD_STS_CD,'U',DECODE(BKG_NO,NULL,0,1),0)) = 0 THEN 0" ).append("\n"); 
		query.append("                    ELSE ROUND(SUM(DECODE(REV_AUD_STS_CD,'U',DECODE(BKG_NO,NULL,0,STL_PRD),0)) / SUM(DECODE(REV_AUD_STS_CD,'U',DECODE(BKG_NO,NULL,0,1),0)) ,2)" ).append("\n"); 
		query.append("               END BL_U_AVG_STL_PRD," ).append("\n"); 
		query.append("               COUNT(BKG_NO) TTL_BL_CNT," ).append("\n"); 
		query.append("               SUM(STL_PRD) TTL_STL_PRD," ).append("\n"); 
		query.append("               ROUND(SUM(STL_PRD) / COUNT(BKG_NO),2) TTL_AVG_STL_PRD," ).append("\n"); 
		query.append("               SUM(DECODE(SIGN(STL_PRD-6), 1,1,0)) KPI_MORE_THAN6," ).append("\n"); 
		query.append("               SUM(DECODE(SIGN(STL_PRD-6),-1,1,0,1,0)) KPI_LESS_THAN6," ).append("\n"); 
		query.append("               SUM(DECODE(RDN_FLG,'N',DECODE(SIGN(STL_PRD-6), 1,1,0),0)) KPI2_MORE_THAN6," ).append("\n"); 
		query.append("               SUM(DECODE(RDN_FLG,'N',DECODE(SIGN(STL_PRD-6),-1,1,0,1,0),0))KPI2_LESS_THAN6" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                  SELECT  UB.BKG_NO," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                            SELECT  A.OFC_CD" ).append("\n"); 
		query.append("                            FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                            WHERE   A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("                            START   WITH A.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("                            CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("                          ) RCT_RHQ_CD," ).append("\n"); 
		query.append("                          BK.BKG_OFC_CD," ).append("\n"); 
		query.append("                          UB.REV_AUD_STS_CD," ).append("\n"); 
		query.append("                          UB.REV_AUD_STL_KND_CD," ).append("\n"); 
		query.append("                          CASE WHEN NVL(BB.BDR_FLG, 'N') = 'N' " ).append("\n"); 
		query.append("                                    THEN 0" ).append("\n"); 
		query.append("                               WHEN UB.REV_AUD_STS_CD = 'S' AND UB.STL_DT < BB.BDR_DT" ).append("\n"); 
		query.append("                                    THEN 0" ).append("\n"); 
		query.append("                               WHEN UB.REV_AUD_STS_CD = 'S' AND UB.N1ST_UMCH_FND_DT < BB.BDR_DT " ).append("\n"); 
		query.append("                                    THEN TRUNC(UB.STL_DT) - TRUNC(BB.BDR_DT)" ).append("\n"); 
		query.append("                               WHEN UB.REV_AUD_STS_CD = 'S' AND UB.N1ST_UMCH_FND_DT > BB.BDR_DT" ).append("\n"); 
		query.append("                                    THEN TRUNC(UB.STL_DT) - TRUNC(UB.N1ST_UMCH_FND_DT)" ).append("\n"); 
		query.append("                               WHEN UB.REV_AUD_STS_CD = 'U' AND UB.N1ST_UMCH_FND_DT < BB.BDR_DT" ).append("\n"); 
		query.append("                                    THEN TRUNC(SYSDATE) - TRUNC(BB.BDR_DT)" ).append("\n"); 
		query.append("                               WHEN UB.REV_AUD_STS_CD = 'U' AND UB.N1ST_UMCH_FND_DT > BB.BDR_DT" ).append("\n"); 
		query.append("                                    THEN TRUNC(SYSDATE) - TRUNC(UB.N1ST_UMCH_FND_DT)" ).append("\n"); 
		query.append("                          END STL_PRD," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                          SELECT  MAX(DECODE(AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("                          FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("                          WHERE   A.BKG_NO    = UB.BKG_NO" ).append("\n"); 
		query.append("                          ) AUTO_RAT_FLG ," ).append("\n"); 
		query.append("                          NVL((SELECT  'Y'" ).append("\n"); 
		query.append("                               FROM    BKG_REV_DR_NOTE  A" ).append("\n"); 
		query.append("                               WHERE   A.BKG_NO    = UB.BKG_NO" ).append("\n"); 
		query.append("                               AND     ROWNUM = 1" ).append("\n"); 
		query.append("                               ),'N') RDN_FLG" ).append("\n"); 
		query.append("                  FROM    BKG_REV_UMCH_BKG  UB" ).append("\n"); 
		query.append("                        , BKG_BOOKING       BK" ).append("\n"); 
		query.append("                        , BKG_RATE          BR" ).append("\n"); 
		query.append("#if (${date_type} == 'L')" ).append("\n"); 
		query.append("                        , VSK_VSL_PORT_SKD  VSKD" ).append("\n"); 
		query.append("                        , BKG_VVD           BVVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        , BKG_BL_DOC        BB" ).append("\n"); 
		query.append("                  WHERE   BK.BKG_NO       = UB.BKG_NO" ).append("\n"); 
		query.append("                  AND     BR.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND     BB.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("        		  AND     BK.BKG_CGO_TP_CD = 'F' " ).append("\n"); 
		query.append("                  AND EXISTS ( SELECT  'Y'" ).append("\n"); 
		query.append("                           FROM    BKG_REV_UMCH_ITM ITM" ).append("\n"); 
		query.append("                           WHERE   ITM.BKG_NO = UB.BKG_NO" ).append("\n"); 
		query.append("                           AND     ITM.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                           AND     ITM.UMCH_BKG_SEQ = ( SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM WHERE BKG_NO = ITM.BKG_NO ) " ).append("\n"); 
		query.append("                           AND     ROWNUM = 1" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#if (${date_type} == 'L')" ).append("\n"); 
		query.append("        		  AND     VSKD.VPS_ETD_DT BETWEEN TO_DATE(@[rt_aply_dt_from], 'YYYY-MM-DD') AND TO_DATE(@[rt_aply_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        		  AND     BVVD.VSL_CD           = VSKD.VSL_CD   -- Join의 방향성 때문에 Duration인 경우와 아닌 경우를 분리함" ).append("\n"); 
		query.append("        		  AND     BVVD.SKD_VOY_NO       = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        		  AND     BVVD.SKD_DIR_CD       = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        		  AND     BVVD.POL_CD           = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        		  AND     BVVD.POL_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        		  AND     BK.BKG_NO = BVVD.BKG_NO" ).append("\n"); 
		query.append("        		  AND     BK.POL_CD = BVVD.POL_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" #if (${rt_aply_dt_from} != '' && ${rt_aply_dt_to} != '')" ).append("\n"); 
		query.append("        		  AND     UB.N1ST_UMCH_FND_DT >= TO_DATE(@[rt_aply_dt_from],'YYYY/MM/DD')" ).append("\n"); 
		query.append("                  AND     UB.N1ST_UMCH_FND_DT <= TO_DATE(@[rt_aply_dt_to],'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("        		  AND     BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        		  AND     BR.BKG_CTRT_TP_CD = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("        WHERE RCT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '')" ).append("\n"); 
		query.append("        AND     RCT_RHQ_CD    = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auto_rat_flg} != '')" ).append("\n"); 
		query.append("        AND     AUTO_RAT_FLG  = @[auto_rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY (RCT_RHQ_CD," ).append("\n"); 
		query.append("               BKG_OFC_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE BKG_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY RCT_RHQ_CD, BKG_OFC_CD" ).append("\n"); 

	}
}