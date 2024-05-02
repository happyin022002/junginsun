/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOffHireResultbyLocationAgreementDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.02
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.11.02 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOffHireResultbyLocationAgreementDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차 장비 반납 실적을 보는 화면-Off Hire Result by Location / AGMT No(Contract No.)-Option  Detail 조회
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOffHireResultbyLocationAgreementDetailRSQL(){
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
		params.put("detail_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_cntr_tp_sz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_change",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_rcc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOffHireResultbyLocationAgreementDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   ROW_SEQ" ).append("\n"); 
		query.append(" , CNTRNO" ).append("\n"); 
		query.append(" , TYSZ" ).append("\n"); 
		query.append(" , AGMT_NO" ).append("\n"); 
		query.append(" , LSE_CTRT_NO" ).append("\n"); 
		query.append(" , TERM" ).append("\n"); 
		query.append(" , REF_NO " ).append("\n"); 
		query.append(" , CNMV_STS_CD" ).append("\n"); 
		query.append(" , OHDATE" ).append("\n"); 
		query.append(" , OHLOC" ).append("\n"); 
		query.append(" , FDAYS" ).append("\n"); 
		query.append(" , OFHDATE" ).append("\n"); 
		query.append(" , OFHLOC" ).append("\n"); 
		query.append("-- , USEDDAYS" ).append("\n"); 
		query.append(" , DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',USEDDAYS" ).append("\n"); 
		query.append(" 				,'N','') AS USEDDAYS " ).append("\n"); 
		query.append(" , MINOHDAYS" ).append("\n"); 
		query.append(" , TERM_CHANGE" ).append("\n"); 
		query.append(" , DII " ).append("\n"); 
		query.append(" , IMMEDIATELY" ).append("\n"); 
		query.append("-- , NVL(RENTAL_CHARGE, 0 ) RENTAL_CHARGE" ).append("\n"); 
		query.append(" , DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',NVL(RENTAL_CHARGE, 0 ) " ).append("\n"); 
		query.append(" 				,'N','') AS RENTAL_CHARGE " ).append("\n"); 
		query.append(" , NVL(LON, 0 ) LON" ).append("\n"); 
		query.append(" , NVL(PUC, 0 ) PUC" ).append("\n"); 
		query.append(" , NVL(PCR, 0 ) PCR" ).append("\n"); 
		query.append(" , NVL(LOF, 0 ) LOF" ).append("\n"); 
		query.append(" , NVL(DOC, 0 ) DOC" ).append("\n"); 
		query.append(" , NVL(DCR, 0 ) DCR" ).append("\n"); 
		query.append(" , NVL(ON_HIRE_DRAYAGE, 0 ) ON_HIRE_DRAYAGE" ).append("\n"); 
		query.append(" , NVL(OFF_HIRE_DRAYAGE, 0 ) OFF_HIRE_DRAYAGE" ).append("\n"); 
		query.append(" , NVL(M_R_COST, 0 ) M_R_COST" ).append("\n"); 
		query.append(" , NVL(DPP, 0 ) DPP" ).append("\n"); 
		query.append("-- , NVL(RENTAL_CHARGE, 0 ) + NVL(LON, 0 ) + NVL(PUC, 0 ) - NVL(PCR, 0 ) + NVL(LOF, 0 ) + NVL(DOC, 0 ) - NVL(DCR, 0 ) + NVL(DPP, 0 ) + NVL(M_R_COST, 0 ) + NVL(ON_HIRE_DRAYAGE, 0 ) + NVL(OFF_HIRE_DRAYAGE, 0 ) AS G_TTL" ).append("\n"); 
		query.append(" , DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',NVL(RENTAL_CHARGE, 0 ) + NVL(LON, 0 ) + NVL(PUC, 0 ) - NVL(PCR, 0 ) + NVL(LOF, 0 ) + NVL(DOC, 0 ) - NVL(DCR, 0 ) + NVL(DPP, 0 ) + NVL(M_R_COST, 0 ) + NVL(ON_HIRE_DRAYAGE, 0 ) + NVL(OFF_HIRE_DRAYAGE, 0 ) " ).append("\n"); 
		query.append(" 				,'N','') AS G_TTL" ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("		 ROW_NUMBER() OVER(ORDER BY B.CNTR_NO , B.CNTR_TPSZ_CD) AS ROW_SEQ" ).append("\n"); 
		query.append("	   , B.CNTR_NO CNTRNO" ).append("\n"); 
		query.append("       , B.CNTR_TPSZ_CD TYSZ" ).append("\n"); 
		query.append("       , B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("	   , D.LSE_CTRT_NO" ).append("\n"); 
		query.append("       , B.LSTM_CD TERM" ).append("\n"); 
		query.append("       , D.REF_NO" ).append("\n"); 
		query.append("       , B.CNMV_STS_CD " ).append("\n"); 
		query.append("       , CASE WHEN ( D.LSTM_CD = 'OW' OR D.LSTM_CD = 'LP' OR D.LSTM_CD = 'OL' ) THEN TO_CHAR(E.CNTR_STS_EVNT_DT, 'YYYYMMDD') ELSE TO_CHAR(E.CNTR_STS_EVNT_DT, 'YYYYMMDD') END OHDATE " ).append("\n"); 
		query.append("       , CASE WHEN ( D.LSTM_CD = 'OW' OR D.LSTM_CD = 'LP' OR D.LSTM_CD = 'OL' ) THEN E.YD_CD ELSE E.YD_CD END OHLOC " ).append("\n"); 
		query.append("       , NVL(A.RNTL_CHG_FREE_DYS , 0) FDAYS" ).append("\n"); 
		query.append("       , TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYYMMDD') OFHDATE" ).append("\n"); 
		query.append("       , A.YD_CD OFHLOC" ).append("\n"); 
		query.append("       , CASE WHEN ( D.LSTM_CD = 'OW' OR D.LSTM_CD = 'LP' OR D.LSTM_CD = 'OL' ) THEN " ).append("\n"); 
		query.append("           TRUNC(NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - E.CNTR_STS_EVNT_DT) + 1    " ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("           TRUNC(NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - E.CNTR_STS_EVNT_DT) + 1 " ).append("\n"); 
		query.append("         END USEDDAYS" ).append("\n"); 
		query.append("       , NVL(A.CNTR_MIN_ONH_DYS , 0) MINOHDAYS" ).append("\n"); 
		query.append("       , A.CNTR_LSTM_CNG_FLG TERM_CHANGE" ).append("\n"); 
		query.append("       , DECODE(A.CNTR_STS_CD,'DIO','Y','N') DII" ).append("\n"); 
		query.append("       , IMDT_EXT_FLG IMMEDIATELY" ).append("\n"); 
		query.append("	   , GREATEST(" ).append("\n"); 
		query.append("         CASE WHEN D.LSTM_CD IN('OW','LP','OL') " ).append("\n"); 
		query.append("              THEN " ).append("\n"); 
		query.append("                  (TRUNC(NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - E.CNTR_STS_EVNT_DT - NVL(E.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                  * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'PDM', B.CNTR_TPSZ_CD, A.YD_CD)" ).append("\n"); 
		query.append("              ELSE  " ).append("\n"); 
		query.append("                  (TRUNC(NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - E.CNTR_STS_EVNT_DT - NVL(E.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                  * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'PDM', B.CNTR_TPSZ_CD, A.YD_CD)" ).append("\n"); 
		query.append("         END,0) AS RENTAL_CHARGE" ).append("\n"); 
		query.append("       , NVL(E.CNTR_LFT_CHG_AMT,0) AS LON" ).append("\n"); 
		query.append("       , DECODE(SIGN(E.CNTR_PKUP_CHG_AMT), 1, E.CNTR_PKUP_CHG_AMT, 0) AS PUC" ).append("\n"); 
		query.append("       , DECODE(SIGN(E.CNTR_PKUP_CHG_AMT), -1, -E.CNTR_PKUP_CHG_AMT, 0) AS PCR" ).append("\n"); 
		query.append("       , NVL(A.CNTR_LFT_CHG_AMT,0) AS LOF" ).append("\n"); 
		query.append("       , DECODE(SIGN(A.CNTR_DRFF_CR_AMT), 1, A.CNTR_DRFF_CR_AMT, 0) AS DOC" ).append("\n"); 
		query.append("       , DECODE(SIGN(A.CNTR_DRFF_CR_AMT), -1, -A.CNTR_DRFF_CR_AMT, 0) AS DCR" ).append("\n"); 
		query.append("       , ( SELECT /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                  SO.NEGO_AMT" ).append("\n"); 
		query.append("           FROM   TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("           WHERE  SO.EQ_NO                = B.CNTR_NO" ).append("\n"); 
		query.append("           AND    SO.TRSP_COST_DTL_MOD_CD = 'CN' --CNTR S/T ON-HIRE" ).append("\n"); 
		query.append("           AND    ROWNUM                  = 1) AS ON_HIRE_DRAYAGE" ).append("\n"); 
		query.append("       , ( SELECT /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                  SO.NEGO_AMT" ).append("\n"); 
		query.append("           FROM   TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("           WHERE  SO.EQ_NO                = B.CNTR_NO" ).append("\n"); 
		query.append("           AND    SO.TRSP_COST_DTL_MOD_CD = 'CF' --CNTR S/T OFF-HIRE" ).append("\n"); 
		query.append("           AND    ROWNUM                  = 1) AS OFF_HIRE_DRAYAGE" ).append("\n"); 
		query.append("       , ( SELECT  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',  MC.CNTR_NO)" ).append("\n"); 
		query.append("           FROM    MST_CONTAINER MC," ).append("\n"); 
		query.append("                   MNR_ORD_DTL OD," ).append("\n"); 
		query.append("                   MNR_ORD_HDR OH " ).append("\n"); 
		query.append("           WHERE   MC.CNTR_NO            = OD.EQ_NO" ).append("\n"); 
		query.append("           AND     MC.CNTR_NO            = B.CNTR_NO" ).append("\n"); 
		query.append("           AND     OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND     OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           GROUP BY MC.CNTR_NO ) AS M_R_COST" ).append("\n"); 
		query.append("       , (SELECT  NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(AM.AGMT_CTY_CD, AM.AGMT_SEQ, 'DPP', B.CNTR_TPSZ_CD, A.YD_CD, A.CNTR_STS_EVNT_DT), 0)                                 " ).append("\n"); 
		query.append("          FROM    LSE_AGMT_RT RT,        " ).append("\n"); 
		query.append("                  LSE_AGREEMENT AM" ).append("\n"); 
		query.append("          WHERE   RT.AGMT_CTY_CD         = AM.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND     RT.AGMT_SEQ            = AM.AGMT_SEQ                              " ).append("\n"); 
		query.append("          AND     RT.CNTR_RNTL_CHG_TP_CD = 'DPPV'     " ).append("\n"); 
		query.append("          AND     AM.DPP_TP_CD           = 'Y'" ).append("\n"); 
		query.append("          AND     RT.AGMT_CTY_CD         = E.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND     RT.AGMT_SEQ            = E.AGMT_SEQ" ).append("\n"); 
		query.append("          AND     RT.CNTR_TPSZ_CD        = B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("          AND     TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYYMMDD') BETWEEN @[period_stdt] AND @[period_eddt] " ).append("\n"); 
		query.append("		  AND    ROWNUM                  = 1) AS DPP" ).append("\n"); 
		query.append("      FROM  MST_CNTR_STS_HIS A , MST_CONTAINER B , LSE_AGREEMENT D, MST_CNTR_STS_HIS E ," ).append("\n"); 
		query.append("           (SELECT A.YD_CD, A.LOC_CD, C.RCC_CD,C.LCC_CD, C.SCC_CD" ).append("\n"); 
		query.append("            FROM   MDM_YARD       A," ).append("\n"); 
		query.append("                   MDM_LOCATION   B," ).append("\n"); 
		query.append("                   MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("            WHERE  A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("            AND    B.SCC_CD = C.SCC_CD) F" ).append("\n"); 
		query.append("      WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("	  AND   B.CO_CRE_FLG = 'N'" ).append("\n"); 
		query.append("      AND   A.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND   A.AGMT_SEQ    = D.AGMT_SEQ" ).append("\n"); 
		query.append("      AND   B.ONH_YD_CD   = F.YD_CD" ).append("\n"); 
		query.append("      #if (${term_change} != '' )             " ).append("\n"); 
		query.append("      AND   A.CNTR_LSTM_CNG_FLG = @[term_change]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${dii} != '' )" ).append("\n"); 
		query.append("        #if (${dii} == 'N' )" ).append("\n"); 
		query.append("				AND A.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("        #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("                AND A.CNTR_STS_CD = 'DIO'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("                AND A.CNTR_STS_CD IN ('LSO', 'DIO')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      AND   A.AGMT_SEQ     <> 999990" ).append("\n"); 
		query.append("      AND   A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[period_stdt],'yyyymmdd') AND TO_DATE(@[period_eddt],'yyyymmdd')" ).append("\n"); 
		query.append("      AND   A.CNTR_NO      = E.CNTR_NO      (+)" ).append("\n"); 
		query.append("      AND   A.PRNR_STS_SEQ = E.CNTR_STS_SEQ (+)" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("	  #if (${detail_rcc} != '') " ).append("\n"); 
		query.append("        #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("      AND   A.LCC_CD = @[detail_rcc]" ).append("\n"); 
		query.append("        #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("      AND   A.SCC_CD = @[detail_rcc]" ).append("\n"); 
		query.append("        #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("      AND   A.YD_CD = @[detail_rcc]" ).append("\n"); 
		query.append("        #elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("      AND   A.RCC_CD = @[detail_rcc]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${detail_agmt_seq} != '0' ) " ).append("\n"); 
		query.append("      AND   A.AGMT_CTY_CD  = @[detail_agmt_cty_cd]" ).append("\n"); 
		query.append("      AND   A.AGMT_SEQ     = @[detail_agmt_seq]" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("      AND  A.AGMT_CTY_CD  = @[agmt_cty_cd]       " ).append("\n"); 
		query.append("      AND  A.AGMT_SEQ     = @[agmt_seq]  " ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${detail_cntr_tp_sz} != '' ) " ).append("\n"); 
		query.append("		 #if (${detail_cntr_tp_sz} != 'Total' ) " ).append("\n"); 
		query.append("      		AND   B.CNTR_TPSZ_CD = @[detail_cntr_tp_sz]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${company} != '' )" ).append("\n"); 
		query.append("      AND   B.CNTR_USE_CO_CD = @[company] " ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("      AND   DECODE(@[loc_tp], 'R', A.RCC_CD, 'L', A.LCC_CD, 'S', A.SCC_CD , 'Y' , A.YD_CD , 'C' , SUBSTR(A.YD_CD , 0 ,2)) = @[loc_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("      AND   D.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${cntr_tpsz_cd_str} != '' ) " ).append("\n"); 
		query.append("      AND B.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                 #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                     '$key'," ).append("\n"); 
		query.append("                                 #else" ).append("\n"); 
		query.append("                                     '$key'" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                             #end )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("      AND D.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                             #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                 '$key'," ).append("\n"); 
		query.append("                             #else" ).append("\n"); 
		query.append("                                 '$key'" ).append("\n"); 
		query.append("                             #end" ).append("\n"); 
		query.append("                         #end )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      ORDER BY B.CNTR_NO , B.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("WHERE 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}