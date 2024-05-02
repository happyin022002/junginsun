/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnmatchBLDBDAOUnmatchStatusReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.17 
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

public class UnmatchBLDBDAOUnmatchStatusReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * unmatch status report
	  * </pre>
	  */
	public UnmatchBLDBDAOUnmatchStatusReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rt_aply_dt_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : UnmatchBLDBDAOUnmatchStatusReportRSQL").append("\n"); 
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
		query.append("SELECT  RCT_RHQ_CD              ," ).append("\n"); 
		query.append("        BKG_OFC_CD              ," ).append("\n"); 
		query.append("        NVL(ROUND(SUM(SETTLE_TERM) / DECODE(SUM(DECODE(SETTLE_TERM,NULL,0,1)),0,1,SUM(DECODE(SETTLE_TERM,NULL,0,1)))),0)  SETTLE_TERM ," ).append("\n"); 
		query.append("        NVL(SUM(BL_U_CNT),0) BL_U_CNT  ," ).append("\n"); 
		query.append("        NVL(SUM(BL_S_CNT),0) BL_S_CNT  ," ).append("\n"); 
		query.append("        NVL(SUM(U_A_CNT),0)  U_A_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_Al_CNT),0)  U_Al_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_All_CNT),0)  U_All_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_B_CNT),0)  U_B_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_C_CNT),0)  U_C_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_D_CNT),0)  U_D_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_E_CNT),0)  U_E_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_F_CNT),0)  U_F_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(U_G_CNT),0)  U_G_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_Al_CNT),0)  S_Al_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_All_CNT),0)  S_All_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_B_CNT),0)  S_B_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_C_CNT),0)  S_C_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_D_CNT),0)  S_D_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_E_CNT),0)  S_E_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_F_CNT),0)  S_F_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(S_G_CNT),0)  S_G_CNT   ," ).append("\n"); 
		query.append("        NVL(SUM(STL_MNL_DIFF_AMT),0)   STL_MNL_DIFF_AMT  ," ).append("\n"); 
		query.append("        COUNT(BKG_NO) AS TTL_BKG_CNT," ).append("\n"); 
		query.append("        NVL(SUM(BL_U_CNT) + SUM(BL_S_CNT),0) ERR_BL_TTL," ).append("\n"); 
		query.append("        ROUND(NVL((SUM(BL_U_CNT) + SUM(BL_S_CNT)),0) / COUNT(BKG_NO),2) ERR_RTO," ).append("\n"); 
		query.append("        '' AS RT_APLY_DT_FROM   ," ).append("\n"); 
		query.append("        '' AS RT_APLY_DT_TO     ," ).append("\n"); 
		query.append("        '' AS BKG_CTRT_TP_CD    ," ).append("\n"); 
		query.append("        '' AS AUTO_RAT_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  BK.BKG_NO           ," ).append("\n"); 
		query.append("                LVL.REGION RCT_RHQ_CD        ,                                       --RHQ" ).append("\n"); 
		query.append("                BK.BKG_OFC_CD       ," ).append("\n"); 
		query.append("                UI.STL_MNL_DIFF_AMT ," ).append("\n"); 
		query.append("                BR.BKG_CTRT_TP_CD   ," ).append("\n"); 
		query.append("                UI.SETTLE_TERM ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  MAX(DECODE(AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("                FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("                WHERE   A.BKG_NO    = BK.BKG_NO" ).append("\n"); 
		query.append("                ) AUTO_RAT_FLG      ," ).append("\n"); 
		query.append("                UI.BL_U_CNT         ," ).append("\n"); 
		query.append("                UI.BL_S_CNT         ," ).append("\n"); 
		query.append("                UI.U_A_CNT          ," ).append("\n"); 
		query.append("				UI.U_Al_CNT          ," ).append("\n"); 
		query.append("				UI.U_All_CNT          ," ).append("\n"); 
		query.append("                UI.U_B_CNT          ," ).append("\n"); 
		query.append("                UI.U_C_CNT          ," ).append("\n"); 
		query.append("                UI.U_D_CNT          ," ).append("\n"); 
		query.append("                UI.U_E_CNT          ," ).append("\n"); 
		query.append("                UI.U_F_CNT          ," ).append("\n"); 
		query.append("                UI.U_G_CNT          ," ).append("\n"); 
		query.append("                UI.S_Al_CNT          ," ).append("\n"); 
		query.append("                UI.S_All_CNT          ," ).append("\n"); 
		query.append("                UI.S_B_CNT          ," ).append("\n"); 
		query.append("                UI.S_C_CNT          ," ).append("\n"); 
		query.append("                UI.S_D_CNT          ," ).append("\n"); 
		query.append("                UI.S_E_CNT          ," ).append("\n"); 
		query.append("                UI.S_F_CNT          ," ).append("\n"); 
		query.append("                UI.S_G_CNT          " ).append("\n"); 
		query.append("        FROM    BKG_BOOKING       BK  ," ).append("\n"); 
		query.append("                BKG_RATE          BR  ," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD  VSKD," ).append("\n"); 
		query.append("                BKG_VVD           BVVD," ).append("\n"); 
		query.append("                BKG_OFC_LVL_V     LVL," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  A1.BKG_NO       ," ).append("\n"); 
		query.append("                        A1.STL_MNL_DIFF_AMT," ).append("\n"); 
		query.append("                        DECODE(A1.REV_AUD_STS_CD, 'S', TO_DATE(A1.STL_DT) - TO_DATE(A1.N1ST_UMCH_FND_DT), 0) SETTLE_TERM," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(A1.BKG_NO,NULL,0,1),0))     BL_U_CNT  ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(A1.BKG_NO,NULL,0,1),0))     BL_S_CNT  ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'A',1,0),0))  U_A_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'A1',1,0),0))  U_Al_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'A2',1,0),0))  U_All_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'B',1,0),0))  U_B_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'C',1,0),0))  U_C_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'D',1,0),0))  U_D_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'E',1,0),0))  U_E_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'F',1,0),0))  U_F_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'G',1,0),0))  U_G_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'A1',1,0),0))  S_Al_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'A2',1,0),0))  S_All_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'B',1,0),0))  S_B_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'C',1,0),0))  S_C_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'D',1,0),0))  S_D_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'E',1,0),0))  S_E_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'F',1,0),0))  S_F_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'G',1,0),0))  S_G_CNT   " ).append("\n"); 
		query.append("                FROM    BKG_REV_UMCH_BKG A1 ," ).append("\n"); 
		query.append("                        BKG_REV_UMCH_ITM B1" ).append("\n"); 
		query.append("                WHERE   B1.BKG_NO       = A1.BKG_NO" ).append("\n"); 
		query.append("                AND     B1.UMCH_BKG_SEQ = A1.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                AND     A1.UMCH_BKG_SEQ = (SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_BKG WHERE BKG_NO = A1.BKG_NO )" ).append("\n"); 
		query.append("                GROUP BY A1.BKG_NO, A1.STL_MNL_DIFF_AMT, DECODE(A1.REV_AUD_STS_CD, 'S', TO_DATE(A1.STL_DT) - TO_DATE(A1.N1ST_UMCH_FND_DT), 0)" ).append("\n"); 
		query.append("                ) UI" ).append("\n"); 
		query.append("        WHERE   BR.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     UI.BKG_NO(+)       = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     BK.BKG_CGO_TP_CD    <> 'P'" ).append("\n"); 
		query.append("        AND     BK.BKG_STS_CD       <> 'X'" ).append("\n"); 
		query.append("        AND     3 = (SELECT COUNT(*) FROM BKG_CUSTOMER WHERE BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD IN ('S', 'C', 'N'))" ).append("\n"); 
		query.append("        AND     BVVD.VSL_CD           = VSKD.VSL_CD   -- Join의 방향성 때문에 Duration인 경우와 아닌 경우를 분리함" ).append("\n"); 
		query.append("        AND     BVVD.SKD_VOY_NO       = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     BVVD.SKD_DIR_CD       = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     BVVD.POL_CD           = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        AND     BVVD.POL_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND     BK.BKG_NO             = BVVD.BKG_NO" ).append("\n"); 
		query.append("		AND     BK.POL_CD             = BVVD.POL_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_OFC_CD         = LVL.OFC_CD" ).append("\n"); 
		query.append("#if (${date_type} == 'L')" ).append("\n"); 
		query.append("        AND     VSKD.VPS_ETD_DT BETWEEN TO_DATE(@[rt_aply_dt_from], 'YYYY-MM-DD') AND TO_DATE(@[rt_aply_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_type} == 'I')" ).append("\n"); 
		query.append("        AND     EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                          FROM BKG_REV_UMCH_BKG " ).append("\n"); 
		query.append("                         WHERE N1ST_UMCH_FND_DT BETWEEN TO_DATE(@[rt_aply_dt_from], 'YYYY-MM-DD') AND TO_DATE(@[rt_aply_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                           AND BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_type} == 'A')" ).append("\n"); 
		query.append("        AND     BR.RT_APLY_DT BETWEEN TO_DATE(@[rt_aply_dt_from], 'YYYY-MM-DD') AND TO_DATE(@[rt_aply_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_type} == 'P')" ).append("\n"); 
		query.append("        AND     BK.PORT_CLZ_DT BETWEEN TO_DATE(@[rt_aply_dt_from], 'YYYY-MM-DD') AND TO_DATE(@[rt_aply_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     BR.BKG_CTRT_TP_CD = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   RCT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rct_rhq_cd} != '')" ).append("\n"); 
		query.append("AND     RCT_RHQ_CD    = @[rct_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auto_rat_flg} != '')" ).append("\n"); 
		query.append("AND     AUTO_RAT_FLG  = @[auto_rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        RCT_RHQ_CD  ," ).append("\n"); 
		query.append("        BKG_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        RCT_RHQ_CD  ," ).append("\n"); 
		query.append("        BKG_OFC_CD" ).append("\n"); 

	}
}