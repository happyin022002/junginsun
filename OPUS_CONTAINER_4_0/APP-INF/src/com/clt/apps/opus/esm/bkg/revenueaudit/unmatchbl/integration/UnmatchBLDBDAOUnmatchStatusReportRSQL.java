/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOUnmatchStatusReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.25
*@LastModifier : 이용태
*@LastVersion : 1.0
* 2010.06.25 이용태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YONG-TAE
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
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
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
		query.append("        ROUND(SUM(SETTLE_TERM) / DECODE(SUM(DECODE(SETTLE_TERM,NULL,0,1)),0,1,SUM(DECODE(SETTLE_TERM,NULL,0,1))))  SETTLE_TERM ," ).append("\n"); 
		query.append("        SUM(BL_U_CNT) BL_U_CNT  ," ).append("\n"); 
		query.append("        SUM(BL_S_CNT) BL_S_CNT  ," ).append("\n"); 
		query.append("        SUM(U_A_CNT)  U_A_CNT   ," ).append("\n"); 
		query.append("        SUM(U_Al_CNT)  U_Al_CNT   ," ).append("\n"); 
		query.append("        SUM(U_All_CNT)  U_All_CNT   ," ).append("\n"); 
		query.append("        SUM(U_B_CNT)  U_B_CNT   ," ).append("\n"); 
		query.append("        SUM(U_C_CNT)  U_C_CNT   ," ).append("\n"); 
		query.append("        SUM(U_D_CNT)  U_D_CNT   ," ).append("\n"); 
		query.append("        SUM(U_E_CNT)  U_E_CNT   ," ).append("\n"); 
		query.append("        SUM(U_F_CNT)  U_F_CNT   ," ).append("\n"); 
		query.append("        SUM(S_Al_CNT)  S_Al_CNT   ," ).append("\n"); 
		query.append("        SUM(S_All_CNT)  S_All_CNT   ," ).append("\n"); 
		query.append("        SUM(S_B_CNT)  S_B_CNT   ," ).append("\n"); 
		query.append("        SUM(S_C_CNT)  S_C_CNT   ," ).append("\n"); 
		query.append("        SUM(S_D_CNT)  S_D_CNT   ," ).append("\n"); 
		query.append("        SUM(S_E_CNT)  S_E_CNT   ," ).append("\n"); 
		query.append("        SUM(S_F_CNT)  S_F_CNT   ," ).append("\n"); 
		query.append("        SUM(STL_MNL_DIFF_AMT)   STL_MNL_DIFF_AMT  ," ).append("\n"); 
		query.append("        '' AS RT_APLY_DT_FROM   ," ).append("\n"); 
		query.append("        '' AS RT_APLY_DT_TO     ," ).append("\n"); 
		query.append("        '' AS BKG_CTRT_TP_CD    ," ).append("\n"); 
		query.append("        '' AS AUTO_RAT_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  UB.BKG_NO           ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT A.OFC_CD" ).append("\n"); 
		query.append("                FROM   MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                WHERE  A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("                START  WITH A.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("                CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("                ) RCT_RHQ_CD        ,                                       --RHQ" ).append("\n"); 
		query.append("                BK.BKG_OFC_CD       ," ).append("\n"); 
		query.append("                UB.STL_MNL_DIFF_AMT ," ).append("\n"); 
		query.append("                BR.BKG_CTRT_TP_CD   ," ).append("\n"); 
		query.append("                DECODE( UB.REV_AUD_STS_CD, 'S', TO_DATE(UB.STL_DT) - TO_DATE(UB.N1ST_UMCH_FND_DT)) SETTLE_TERM ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  MAX(DECODE(AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("                FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("                WHERE   A.BKG_NO    = UB.BKG_NO" ).append("\n"); 
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
		query.append("                UI.S_Al_CNT          ," ).append("\n"); 
		query.append("                UI.S_All_CNT          ," ).append("\n"); 
		query.append("                UI.S_B_CNT          ," ).append("\n"); 
		query.append("                UI.S_C_CNT          ," ).append("\n"); 
		query.append("                UI.S_D_CNT          ," ).append("\n"); 
		query.append("                UI.S_E_CNT          ," ).append("\n"); 
		query.append("                UI.S_F_CNT" ).append("\n"); 
		query.append("        FROM    BKG_REV_UMCH_BKG  UB  ," ).append("\n"); 
		query.append("                BKG_BOOKING       BK  ," ).append("\n"); 
		query.append("                BKG_RATE          BR  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  A1.BKG_NO       ," ).append("\n"); 
		query.append("                        A1.UMCH_BKG_SEQ ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(A1.BKG_NO,NULL,0,1),0))     BL_U_CNT  ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(A1.BKG_NO,NULL,0,1),0))     BL_S_CNT  ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'A',1,0),0))  U_A_CNT   ," ).append("\n"); 
		query.append("						MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'A1',1,0),0))  U_Al_CNT   ," ).append("\n"); 
		query.append("						MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'A2',1,0),0))  U_All_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'B',1,0),0))  U_B_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'C',1,0),0))  U_C_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'D',1,0),0))  U_D_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'E',1,0),0))  U_E_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'U',DECODE(B1.UMCH_TP_CD,'F',1,0),0))  U_F_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'A1',1,0),0))  S_Al_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'A2',1,0),0))  S_All_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'B',1,0),0))  S_B_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'C',1,0),0))  S_C_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'D',1,0),0))  S_D_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'E',1,0),0))  S_E_CNT   ," ).append("\n"); 
		query.append("                        MAX(DECODE(A1.REV_AUD_STS_CD,'S',DECODE(B1.UMCH_TP_CD,'F',1,0),0))  S_F_CNT" ).append("\n"); 
		query.append("                FROM    BKG_REV_UMCH_BKG A1 ," ).append("\n"); 
		query.append("                        BKG_REV_UMCH_ITM B1" ).append("\n"); 
		query.append("                WHERE   B1.BKG_NO       = A1.BKG_NO" ).append("\n"); 
		query.append("                AND     B1.UMCH_BKG_SEQ = A1.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                        A1.BKG_NO       ," ).append("\n"); 
		query.append("                        A1.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                ) UI" ).append("\n"); 
		query.append("        WHERE   BK.BKG_NO       = UB.BKG_NO" ).append("\n"); 
		query.append("        AND     BR.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     UI.BKG_NO       = UB.BKG_NO" ).append("\n"); 
		query.append("        AND     UI.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("        AND     ( UB.BKG_NO, UB.UMCH_BKG_SEQ )  IN" ).append("\n"); 
		query.append("                ( SELECT BKG_NO, MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM GROUP BY BKG_NO )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rt_aply_dt_from} != '' && ${rt_aply_dt_to} != '')" ).append("\n"); 
		query.append("        AND     UB.N1ST_UMCH_FND_DT BETWEEN TO_DATE(@[rt_aply_dt_from], 'YYYY/MM/DD') AND TO_DATE(@[rt_aply_dt_to], 'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     BR.BKG_CTRT_TP_CD = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
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