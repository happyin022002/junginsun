/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LeaseReportDBDAOOffHireResultAvgUsingDayDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
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

public class LeaseReportDBDAOOffHireResultAvgUsingDayDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차장비별 사용실적에 대한 상세내역을 조회합니다.
	  * 2010.09.10 남궁진호 [CHM-201005773-01] USED DAYS계산시 +1,RENTAL CHARGE계산로직 수정
	  * 2010.12.13 류인원 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
	  * </pre>
	  */
	public LeaseReportDBDAOOffHireResultAvgUsingDayDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("end_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_use_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOOffHireResultAvgUsingDayDetailRSQL").append("\n"); 
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
		query.append("SELECT  ROW_SEQ" ).append("\n"); 
		query.append("      , CNTR_NO" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , AGMT_NO" ).append("\n"); 
		query.append("      , LSTM_CD" ).append("\n"); 
		query.append("      , REF_NO" ).append("\n"); 
		query.append("      , ON_HR_DT" ).append("\n"); 
		query.append("      , ON_HR_YD_CD" ).append("\n"); 
		query.append("      , RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("      , OFF_HR_DT" ).append("\n"); 
		query.append("      , OFF_HR_YD_CD" ).append("\n"); 
		query.append("      , USED_DYS" ).append("\n"); 
		query.append("      , CRNT_YD_CD" ).append("\n"); 
		query.append("      , CNMV_STS_CD" ).append("\n"); 
		query.append("      , MT_DRAYAGE_COST" ).append("\n"); 
		query.append("      , TERM_CHG_FLG" ).append("\n"); 
		query.append("      , DII_FLG" ).append("\n"); 
		query.append("      , IMDT_EXT_FLG" ).append("\n"); 
		query.append("      , PDM_AMT" ).append("\n"); 
		query.append("      , LON_AMT" ).append("\n"); 
		query.append("      , PUC_AMT" ).append("\n"); 
		query.append("      , PCR_AMT" ).append("\n"); 
		query.append("      , LOF_AMT" ).append("\n"); 
		query.append("      , MIN_OH_DAYS" ).append("\n"); 
		query.append("      , DOC_AMT" ).append("\n"); 
		query.append("      , DCR_AMT" ).append("\n"); 
		query.append("      , ONH_DRAYAGE_COST" ).append("\n"); 
		query.append("      , OFFH_DRAYAGE_COST" ).append("\n"); 
		query.append("      , MNR_COST, DPP_AMT" ).append("\n"); 
		query.append("      ,(NVL(PDM_AMT,0) + NVL(LON_AMT,0) + NVL(PUC_AMT,0) - NVL(PCR_AMT,0) " ).append("\n"); 
		query.append("	    + NVL(LOF_AMT,0) + NVL(DOC_AMT,0) - NVL(DCR_AMT,0) + NVL(DPP_AMT,0) + NVL(MNR_COST,0) " ).append("\n"); 
		query.append("	    + NVL(ONH_DRAYAGE_COST,0) + NVL(OFFH_DRAYAGE_COST,0)" ).append("\n"); 
		query.append("	   ) AS TTL_AMT " ).append("\n"); 
		query.append("      , BKG_NO" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POR_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("      , DEL_CD" ).append("\n"); 
		query.append("      , ETD_DT" ).append("\n"); 
		query.append("      , ETA_DT" ).append("\n"); 
		query.append("      , VVD      " ).append("\n"); 
		query.append("FROM   (SELECT  ROW_NUMBER() OVER(ORDER BY A.CNTR_NO) AS ROW_SEQ" ).append("\n"); 
		query.append("              , A.CNTR_NO" ).append("\n"); 
		query.append("              , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , A.LSTM_CD" ).append("\n"); 
		query.append("              , C.REF_NO" ).append("\n"); 
		query.append("              , A.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS AGMT_NO               " ).append("\n"); 
		query.append("              , CASE WHEN A.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("                THEN TO_CHAR(A.ONH_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("                ELSE TO_CHAR(B.CNTR_STS_EVNT_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("                END AS ON_HR_DT" ).append("\n"); 
		query.append("              , B.YD_CD AS ON_HR_YD_CD" ).append("\n"); 
		query.append("              , B.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("              , TO_CHAR(C.OFF_HR_DT,'YYYYMMDD') AS OFF_HR_DT" ).append("\n"); 
		query.append("              , C.YD_CD AS OFF_HR_YD_CD" ).append("\n"); 
		query.append("              , CASE WHEN A.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("                THEN ROUND(C.OFF_HR_DT - A.MFT_DT) + 1" ).append("\n"); 
		query.append("                ELSE ROUND(C.OFF_HR_DT - B.CNTR_STS_EVNT_DT) + 1" ).append("\n"); 
		query.append("                END AS USED_DYS" ).append("\n"); 
		query.append("              , A.CRNT_YD_CD" ).append("\n"); 
		query.append("              , A.CNMV_STS_CD" ).append("\n"); 
		query.append("              , 0 MT_DRAYAGE_COST" ).append("\n"); 
		query.append("              , C.CNTR_LSTM_CNG_FLG AS TERM_CHG_FLG" ).append("\n"); 
		query.append("              , C.DII_FLG" ).append("\n"); 
		query.append("              , A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("              , B.CNTR_MIN_ONH_DYS AS MIN_OH_DAYS" ).append("\n"); 
		query.append("              , GREATEST(NVL(" ).append("\n"); 
		query.append("                (SELECT (TRUNC(NVL(C.OFF_HR_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - B.CNTR_STS_EVNT_DT - NVL(B.RNTL_CHG_FREE_DYS , 0))) + 1 * RT.N1ST_CHG_AMT" ).append("\n"); 
		query.append("                FROM    LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                WHERE   RT.AGMT_CTY_CD         = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     RT.AGMT_SEQ            = B.AGMT_SEQ" ).append("\n"); 
		query.append("                AND     RT.LOC_CD              = DECODE(A.LSTM_CD, 'LT', B.LCC_CD, 'KRSEL')" ).append("\n"); 
		query.append("                AND     RT.CNTR_TPSZ_CD        = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                AND     RT.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("                AND     RT.AGMT_CHG_VAL        = 1)," ).append("\n"); 
		query.append("                (SELECT (TRUNC(NVL(C.OFF_HR_DT,TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - B.CNTR_STS_EVNT_DT - NVL(B.RNTL_CHG_FREE_DYS , 0))) + 1 * AVG(RT.N1ST_CHG_AMT)" ).append("\n"); 
		query.append("                FROM    LSE_AGMT_RT RT" ).append("\n"); 
		query.append("                WHERE   RT.AGMT_CTY_CD         = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     RT.AGMT_SEQ            = B.AGMT_SEQ" ).append("\n"); 
		query.append("                AND     RT.CNTR_TPSZ_CD        = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                AND     RT.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("                AND     RT.AGMT_CHG_VAL        = 1)" ).append("\n"); 
		query.append("               ),0) AS PDM_AMT" ).append("\n"); 
		query.append("              , NVL(B.CNTR_LFT_CHG_AMT,0) AS LON_AMT" ).append("\n"); 
		query.append("              , DECODE(SIGN(B.CNTR_PKUP_CHG_AMT),  1,  B.CNTR_PKUP_CHG_AMT, 0) AS PUC_AMT" ).append("\n"); 
		query.append("              , DECODE(SIGN(B.CNTR_PKUP_CHG_AMT), -1, -B.CNTR_PKUP_CHG_AMT, 0) AS PCR_AMT" ).append("\n"); 
		query.append("              , NVL(C.CNTR_LFT_CHG_AMT,0) AS LOF_AMT" ).append("\n"); 
		query.append("              , DECODE(SIGN(C.CNTR_DRFF_CR_AMT),  1,  C.CNTR_DRFF_CR_AMT, 0) AS DOC_AMT" ).append("\n"); 
		query.append("              , DECODE(SIGN(C.CNTR_DRFF_CR_AMT), -1, -C.CNTR_DRFF_CR_AMT, 0) AS DCR_AMT" ).append("\n"); 
		query.append("              , (SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */ " ).append("\n"); 
		query.append("                         SO.NEGO_AMT" ).append("\n"); 
		query.append("                 FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                 WHERE   SO.EQ_NO                = A.CNTR_NO" ).append("\n"); 
		query.append("                 AND     SO.TRSP_COST_DTL_MOD_CD = 'CN' " ).append("\n"); 
		query.append("                 AND     ROWNUM = 1" ).append("\n"); 
		query.append("              ) AS ONH_DRAYAGE_COST" ).append("\n"); 
		query.append("              ,(SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */ " ).append("\n"); 
		query.append("                        SO.NEGO_AMT" ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                WHERE   SO.EQ_NO                = A.CNTR_NO" ).append("\n"); 
		query.append("                AND     SO.TRSP_COST_DTL_MOD_CD = 'CF' " ).append("\n"); 
		query.append("                AND     ROWNUM = 1" ).append("\n"); 
		query.append("              ) AS OFFH_DRAYAGE_COST" ).append("\n"); 
		query.append("              ,(SELECT  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',  MC.CNTR_NO)" ).append("\n"); 
		query.append("                FROM    MST_CONTAINER MC," ).append("\n"); 
		query.append("                        MNR_ORD_DTL   OD," ).append("\n"); 
		query.append("                        MNR_ORD_HDR   OH" ).append("\n"); 
		query.append("                WHERE   MC.CNTR_NO            = OD.EQ_NO" ).append("\n"); 
		query.append("                AND     MC.CNTR_NO            = A.CNTR_NO" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                GROUP BY MC.CNTR_NO" ).append("\n"); 
		query.append("              ) AS MNR_COST" ).append("\n"); 
		query.append("              ,(SELECT  RT.AGMT_CHG_VAL                                 " ).append("\n"); 
		query.append("                FROM    LSE_AGMT_RT RT,        " ).append("\n"); 
		query.append("                LSE_AGREEMENT AG" ).append("\n"); 
		query.append("                WHERE   RT.AGMT_CTY_CD  = AG.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     RT.AGMT_SEQ     = AG.AGMT_SEQ                              " ).append("\n"); 
		query.append("                AND     RT.CNTR_RNTL_CHG_TP_CD = 'DPPV'     " ).append("\n"); 
		query.append("                AND     AG.DPP_TP_CD    = 'Y'" ).append("\n"); 
		query.append("                AND     RT.AGMT_CTY_CD  = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     RT.AGMT_SEQ     = C.AGMT_SEQ" ).append("\n"); 
		query.append("                AND     RT.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                AND     C.OFF_HR_DT BETWEEN C.STR_EVNT_DT AND C.END_EVNT_DT" ).append("\n"); 
		query.append("                ) AS DPP_AMT" ).append("\n"); 
		query.append("             ,BKG.BKG_NO" ).append("\n"); 
		query.append("             ,BKG.POL_CD" ).append("\n"); 
		query.append("             ,BKG.POR_CD" ).append("\n"); 
		query.append("             ,BKG.POD_CD" ).append("\n"); 
		query.append("             ,BKG.DEL_CD" ).append("\n"); 
		query.append("             ,TO_CHAR(BKG.POL_ETD_DT, 'YYYY-MM-DD') ETD_DT" ).append("\n"); 
		query.append("             ,TO_CHAR(BKG.POD_ETA_DT, 'YYYY-MM-DD') ETA_DT" ).append("\n"); 
		query.append("             ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD VVD                   " ).append("\n"); 
		query.append("		FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS B, " ).append("\n"); 
		query.append("               (SELECT  /*+ INDEX(A XAK4MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("						B.AGMT_CTY_CD, B.AGMT_SEQ, B.REF_NO, A.CNTR_NO," ).append("\n"); 
		query.append("                        A.YD_CD, A.CNTR_STS_EVNT_DT AS OFF_HR_DT," ).append("\n"); 
		query.append("                        A.PRNR_STS_SEQ, A.CNTR_LSTM_CNG_FLG," ).append("\n"); 
		query.append("                        DECODE(A.CNTR_STS_CD,'DIO','Y','N') AS DII_FLG," ).append("\n"); 
		query.append("                        A.CNTR_LFT_CHG_AMT, A.CNTR_DRFF_CR_AMT," ).append("\n"); 
		query.append("						P.STR_EVNT_DT, P.END_EVNT_DT, P.LSTM_CD, P.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                        P.CNTR_USE_CO_CD, P.VNDR_SEQ, P.HJS_CRE_FLG" ).append("\n"); 
		query.append("                FROM   (SELECT  TO_DATE(@[str_evnt_dt],'YYYYMMDD') AS STR_EVNT_DT," ).append("\n"); 
		query.append("					            TO_DATE(@[end_evnt_dt],'YYYYMMDD') AS END_EVNT_DT," ).append("\n"); 
		query.append("					            @[lstm_cd]        AS LSTM_CD," ).append("\n"); 
		query.append("					            @[agmt_cty_cd]    AS AGMT_CTY_CD," ).append("\n"); 
		query.append("					            @[agmt_seq]       AS AGMT_SEQ," ).append("\n"); 
		query.append("					            @[cntr_tpsz_cd]   AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("					            @[cntr_use_co_cd] AS CNTR_USE_CO_CD," ).append("\n"); 
		query.append("					            @[vndr_seq]       AS VNDR_SEQ," ).append("\n"); 
		query.append("								@[hjs_cre_flg]    AS HJS_CRE_FLG" ).append("\n"); 
		query.append("					    FROM    DUAL) P," ).append("\n"); 
		query.append("						MST_CONTAINER C," ).append("\n"); 
		query.append("                        MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("                        LSE_AGREEMENT B" ).append("\n"); 
		query.append("                WHERE   A.CNTR_NO      = C.CNTR_NO" ).append("\n"); 
		query.append("				AND		A.AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     A.AGMT_SEQ     = B.AGMT_SEQ        " ).append("\n"); 
		query.append("                AND     A.CNTR_STS_CD IN ('LSO','DIO','TLL')" ).append("\n"); 
		query.append("                AND     A.CNTR_STS_EVNT_DT BETWEEN P.STR_EVNT_DT AND P.END_EVNT_DT" ).append("\n"); 
		query.append("#if (${hjs_cre_flg} != '' )" ).append("\n"); 
		query.append("				AND     A.CNTR_LSTM_CNG_FLG = P.HJS_CRE_FLG" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    			AND     B.LSTM_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("    			AND 	B.AGMT_CTY_CD = P.AGMT_CTY_CD       " ).append("\n"); 
		query.append("    			AND 	B.AGMT_SEQ = P.AGMT_SEQ  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("				) C, " ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("                , BKG_BOOKING BKG                " ).append("\n"); 
		query.append("        WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("        AND     C.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("        AND     C.PRNR_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("        AND     A.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND     B.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("        AND     BKG.BKG_NO(+)  = A.BKG_NO        " ).append("\n"); 
		query.append("--		AND     A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("		AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cntr_use_co_cd} != '' )" ).append("\n"); 
		query.append("		AND 	A.CNTR_USE_CO_CD = C.CNTR_USE_CO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND 	A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '1' ) " ).append("\n"); 
		query.append("		AND     B.CNTR_STS_CD IN ('DII','LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '2')" ).append("\n"); 
		query.append("		AND     B.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '3')" ).append("\n"); 
		query.append("		AND     B.CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("		AND    	A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("WHERE 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CNTR_NO" ).append("\n"); 

	}
}