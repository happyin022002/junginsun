/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOffHireResultvsDOLDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOffHireResultvsDOLDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차장비 임차 (Off 장비) 실적을 상세조회(Off-Hire Vs DOL)
	  * 2010.09.10 남궁진호 [CHM-201005773-01] USED DAYS계산시 FREE DYAS 제외,RENTAL CHARGE계산로직 수정
	  * 2010.12.09 이준범 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOffHireResultvsDOLDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("detail_sccc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOffHireResultvsDOLDetailRSQL").append("\n"); 
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
		query.append("   CNTRNO" ).append("\n"); 
		query.append(" , CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" , AGMT_NO" ).append("\n"); 
		query.append(" , LSTM_CD" ).append("\n"); 
		query.append(" , REF_NO" ).append("\n"); 
		query.append(" , CNMV_STS_CD" ).append("\n"); 
		query.append(" , OHDATE" ).append("\n"); 
		query.append(" , OHLOC" ).append("\n"); 
		query.append(" , FDAYS" ).append("\n"); 
		query.append(" , OFHDATE" ).append("\n"); 
		query.append(" , OFHLOC" ).append("\n"); 
		query.append(" , USEDDAYS" ).append("\n"); 
		query.append(" , MINOHDAYS" ).append("\n"); 
		query.append(" , TERM_CHANGE" ).append("\n"); 
		query.append(" , DII " ).append("\n"); 
		query.append(" , IMMEDIATELY" ).append("\n"); 
		query.append(" , NVL(RENTAL_CHARGE, 0 ) RENTAL_CHARGE" ).append("\n"); 
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
		query.append(" , NVL(RENTAL_CHARGE, 0 ) + NVL(LON, 0 ) + NVL(PUC, 0 ) - NVL(PCR, 0 ) + NVL(LOF, 0 ) + NVL(DOC, 0 ) - NVL(DCR, 0 ) + NVL(DPP, 0 ) + NVL(M_R_COST, 0 ) + NVL(ON_HIRE_DRAYAGE, 0 ) + NVL(OFF_HIRE_DRAYAGE, 0 ) AS G_TTL" ).append("\n"); 
		query.append(" , BKG_NO" ).append("\n"); 
		query.append(" , POL_CD" ).append("\n"); 
		query.append(" , POR_CD" ).append("\n"); 
		query.append(" , POD_CD" ).append("\n"); 
		query.append(" , DEL_CD" ).append("\n"); 
		query.append(" , ETD_DT" ).append("\n"); 
		query.append(" , ETA_DT" ).append("\n"); 
		query.append(" , VVD      " ).append("\n"); 
		query.append("FROM( SELECT" ).append("\n"); 
		query.append("         A.CNTR_NO CNTRNO" ).append("\n"); 
		query.append("       , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("       , B.LSTM_CD" ).append("\n"); 
		query.append("       , C.REF_NO" ).append("\n"); 
		query.append("       , B.CNMV_STS_CD" ).append("\n"); 
		query.append("       , CASE WHEN ( B.LSTM_CD = 'OW' OR B.LSTM_CD = 'LP' OR B.LSTM_CD = 'OL' ) THEN TO_CHAR(B.ONH_DT, 'YYYYMMDD') ELSE TO_CHAR(D.CNTR_STS_EVNT_DT, 'YYYYMMDD') END OHDATE " ).append("\n"); 
		query.append("       , CASE WHEN ( B.LSTM_CD = 'OW' OR B.LSTM_CD = 'LP' OR B.LSTM_CD = 'OL' ) THEN E.YD_CD ELSE D.YD_CD END OHLOC " ).append("\n"); 
		query.append("       , NVL(A.RNTL_CHG_FREE_DYS , 0) FDAYS" ).append("\n"); 
		query.append("       , A.YD_CD OFHLOC" ).append("\n"); 
		query.append("       , TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYY-MM-DD') OFHDATE" ).append("\n"); 
		query.append("       , CASE WHEN ( B.LSTM_CD = 'OW' OR B.LSTM_CD = 'LP' OR B.LSTM_CD = 'OL' ) THEN " ).append("\n"); 
		query.append("            NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - B.MFT_DT  + 1 " ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("            NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - D.CNTR_STS_EVNT_DT  + 1 " ).append("\n"); 
		query.append("         END USEDDAYS" ).append("\n"); 
		query.append("       , NVL(A.CNTR_MIN_ONH_DYS , 0 ) MINOHDAYS" ).append("\n"); 
		query.append("       , A.CNTR_LSTM_CNG_FLG TERM_CHANGE" ).append("\n"); 
		query.append("       , DECODE(A.CNTR_STS_CD,'DII','Y','N') DII" ).append("\n"); 
		query.append("       , IMDT_EXT_FLG IMMEDIATELY" ).append("\n"); 
		query.append("       , CASE WHEN B.LSTM_CD IN('OW','LP','OL') " ).append("\n"); 
		query.append("              THEN NVL(" ).append("\n"); 
		query.append("                   (SELECT ( NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - B.MFT_DT - NVL(D.RNTL_CHG_FREE_DYS , 0 ) + 1 ) * N1ST_CHG_AMT" ).append("\n"); 
		query.append("                    FROM    LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                    WHERE   RT.AGMT_CTY_CD(+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     RT.AGMT_SEQ(+) = A.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     RT.LOC_CD(+)   = DECODE(C.LSTM_CD, 'LT', A.LCC_CD, 'KRSEL')" ).append("\n"); 
		query.append("                    AND     RT.AGMT_CHG_VAL = 1" ).append("\n"); 
		query.append("                    AND     RT.CNTR_TPSZ_CD(+) = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    AND     RT.CNTR_RNTL_CHG_TP_CD(+) = 'PDGV')," ).append("\n"); 
		query.append("                   (SELECT ( NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - B.MFT_DT - NVL(D.RNTL_CHG_FREE_DYS , 0 ) + 1 ) * AVG(N1ST_CHG_AMT)" ).append("\n"); 
		query.append("                    FROM    LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                    WHERE   RT.AGMT_CTY_CD(+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     RT.AGMT_SEQ(+) = A.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     RT.AGMT_CHG_VAL = 1" ).append("\n"); 
		query.append("                    AND     RT.CNTR_TPSZ_CD(+) = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    AND     RT.CNTR_RNTL_CHG_TP_CD(+) = 'PDGV'))    " ).append("\n"); 
		query.append("              ELSE  NVL( " ).append("\n"); 
		query.append("                   (SELECT ( NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - D.CNTR_STS_EVNT_DT - NVL(D.RNTL_CHG_FREE_DYS , 0 ) + 1 ) * N1ST_CHG_AMT" ).append("\n"); 
		query.append("                    FROM    LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                    WHERE   RT.AGMT_CTY_CD(+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     RT.AGMT_SEQ(+) = A.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     RT.LOC_CD(+)   = DECODE(C.LSTM_CD, 'LT', A.LCC_CD, 'KRSEL')" ).append("\n"); 
		query.append("                    AND     RT.AGMT_CHG_VAL = 1" ).append("\n"); 
		query.append("                    AND     RT.CNTR_TPSZ_CD(+) = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    AND     RT.CNTR_RNTL_CHG_TP_CD(+) = 'PDGV')," ).append("\n"); 
		query.append("                   (SELECT ( NVL(A.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - D.CNTR_STS_EVNT_DT - NVL(D.RNTL_CHG_FREE_DYS , 0 ) + 1 ) * AVG(N1ST_CHG_AMT)" ).append("\n"); 
		query.append("                    FROM    LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                    WHERE   RT.AGMT_CTY_CD(+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     RT.AGMT_SEQ(+) = A.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     RT.AGMT_CHG_VAL = 1" ).append("\n"); 
		query.append("                    AND     RT.CNTR_TPSZ_CD(+) = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    AND     RT.CNTR_RNTL_CHG_TP_CD(+) = 'PDGV'))                                             " ).append("\n"); 
		query.append("         END RENTAL_CHARGE " ).append("\n"); 
		query.append("       , NVL(D.CNTR_LFT_CHG_AMT,0) AS LON" ).append("\n"); 
		query.append("       , DECODE(SIGN(D.CNTR_PKUP_CHG_AMT), 1, D.CNTR_PKUP_CHG_AMT, 0) AS PUC" ).append("\n"); 
		query.append("       , DECODE(SIGN(D.CNTR_PKUP_CHG_AMT), -1, -D.CNTR_PKUP_CHG_AMT, 0) AS PCR" ).append("\n"); 
		query.append("       , NVL(A.CNTR_LFT_CHG_AMT,0) AS LOF" ).append("\n"); 
		query.append("       , DECODE(SIGN(A.CNTR_DRFF_CR_AMT), 1, A.CNTR_DRFF_CR_AMT, 0) AS DOC" ).append("\n"); 
		query.append("       , DECODE(SIGN(A.CNTR_DRFF_CR_AMT), -1, -A.CNTR_DRFF_CR_AMT, 0) AS DCR" ).append("\n"); 
		query.append("       , ( SELECT /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("              SO.NEGO_AMT" ).append("\n"); 
		query.append("           FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("           WHERE SO.EQ_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND SO.TRSP_COST_DTL_MOD_CD = 'CN' --CNTR S/T ON-HIRE" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS ON_HIRE_DRAYAGE" ).append("\n"); 
		query.append("       , ( SELECT /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("              SO.NEGO_AMT" ).append("\n"); 
		query.append("           FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("           WHERE SO.EQ_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND SO.TRSP_COST_DTL_MOD_CD = 'CF' --CNTR S/T OFF-HIRE" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS OFF_HIRE_DRAYAGE" ).append("\n"); 
		query.append("       , ( SELECT  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',  MC.CNTR_NO)" ).append("\n"); 
		query.append("           FROM    MST_CONTAINER MC," ).append("\n"); 
		query.append("                  MNR_ORD_DTL OD," ).append("\n"); 
		query.append("                  MNR_ORD_HDR OH" ).append("\n"); 
		query.append("           WHERE   MC.CNTR_NO = OD.EQ_NO" ).append("\n"); 
		query.append("           AND     MC.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND     OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND     OD.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           GROUP BY MC.CNTR_NO ) AS M_R_COST " ).append("\n"); 
		query.append("       , (SELECT  RT.AGMT_CHG_VAL                                 " ).append("\n"); 
		query.append("          FROM    LSE_AGMT_RT RT,        " ).append("\n"); 
		query.append("                  LSE_AGREEMENT AM" ).append("\n"); 
		query.append("          WHERE   RT.AGMT_CTY_CD = AM.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND     RT.AGMT_SEQ = AM.AGMT_SEQ                              " ).append("\n"); 
		query.append("          AND     RT.CNTR_RNTL_CHG_TP_CD = 'DPPV'     " ).append("\n"); 
		query.append("          AND     AM.DPP_TP_CD = 'Y'" ).append("\n"); 
		query.append("          AND     RT.AGMT_CTY_CD  = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND     RT.AGMT_SEQ     = D.AGMT_SEQ" ).append("\n"); 
		query.append("          AND     RT.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("          AND     TO_CHAR(D.CNTR_STS_EVNT_DT, 'YYYYMMDD') BETWEEN @[period_stdt] AND @[period_eddt] ) AS DPP" ).append("\n"); 
		query.append("       ,BKG.BKG_NO" ).append("\n"); 
		query.append("       ,BKG.POL_CD" ).append("\n"); 
		query.append("       ,BKG.POR_CD" ).append("\n"); 
		query.append("       ,BKG.POD_CD" ).append("\n"); 
		query.append("       ,BKG.DEL_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(BKG.POL_ETD_DT, 'YYYY-MM-DD') ETD_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(BKG.POD_ETA_DT, 'YYYY-MM-DD') ETA_DT" ).append("\n"); 
		query.append("       ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD VVD                   " ).append("\n"); 
		query.append("      FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("           MST_CONTAINER B," ).append("\n"); 
		query.append("           LSE_AGREEMENT C , " ).append("\n"); 
		query.append("           MST_CNTR_STS_HIS D ," ).append("\n"); 
		query.append("           (SELECT A.YD_CD, A.LOC_CD, C.RCC_CD,C.LCC_CD, C.SCC_CD" ).append("\n"); 
		query.append("            FROM MDM_YARD A," ).append("\n"); 
		query.append("                 MDM_LOCATION B," ).append("\n"); 
		query.append("                 MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("            WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("              AND B.SCC_CD = C.SCC_CD) E" ).append("\n"); 
		query.append("           ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("      WHERE A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("        AND A.CNTR_STS_EVNT_DT BETWEEN TO_DATE( @[period_stdt],'YYYYMMDD') AND TO_DATE(@[period_eddt],'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("--        AND B.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("		AND B.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("        AND A.CNTR_NO = B.CNTR_NO      " ).append("\n"); 
		query.append("        AND B.ONH_YD_CD   = E.YD_CD" ).append("\n"); 
		query.append("        AND BKG.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("      #if (${term_change} != '' )             " ).append("\n"); 
		query.append("                AND A.CNTR_LSTM_CNG_FLG = @[term_change]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${dii} != '' )" ).append("\n"); 
		query.append("        #if (${dii} == 'N' )" ).append("\n"); 
		query.append("				AND A.CNTR_STS_CD IN ('LSO', 'TLL')" ).append("\n"); 
		query.append("        #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("                AND A.CNTR_STS_CD = 'DIO'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("                AND A.CNTR_STS_CD IN ('LSO', 'DIO', 'TLL')" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      AND A.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("      AND A.PRNR_STS_SEQ = D.CNTR_STS_SEQ" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${report_type} == 'L' ) " ).append("\n"); 
		query.append("        AND A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("		#if (${detail_sccc_cd} != '' )" ).append("\n"); 
		query.append("        AND A.SCC_CD      = @[detail_sccc_cd]  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      #else        " ).append("\n"); 
		query.append("        AND A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("		#if (${detail_agmt_seq} != '' )" ).append("\n"); 
		query.append("        AND A.AGMT_SEQ    = @[detail_agmt_seq]	" ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("		#if (${detail_sccc_cd} != '' )" ).append("\n"); 
		query.append("		AND A.SCC_CD      = @[detail_sccc_cd]  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("	  " ).append("\n"); 
		query.append("	  #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("    	#if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("        AND A.SCC_CD  IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = @[loc_cd]  )" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("        AND A.SCC_CD  IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = @[loc_cd]  )" ).append("\n"); 
		query.append("    	#end " ).append("\n"); 
		query.append("	  #end 	" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("        AND B.VNDR_SEQ    = @[vndr_seq] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if (${detail_cntr_tpsz_cd} != '' ) " ).append("\n"); 
		query.append("        AND B.CNTR_TPSZ_CD = @[detail_cntr_tpsz_cd]" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${cntr_tpsz_cd_str} != '' ) " ).append("\n"); 
		query.append("        AND B.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                   #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                       '$key'," ).append("\n"); 
		query.append("                                   #else" ).append("\n"); 
		query.append("                                       '$key'" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                               #end )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("        AND C.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                               #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                   '$key'," ).append("\n"); 
		query.append("                               #else" ).append("\n"); 
		query.append("                                   '$key'" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                           #end )" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}