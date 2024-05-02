/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgCalcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAODmtChgCalcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODmtChgCalcVORSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgCalcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgCalcRSQL").append("\n"); 
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
		query.append("SELECT ( SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("            FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("           WHERE INTG_CD_ID = 'CD03382' " ).append("\n"); 
		query.append("             AND INTG_CD_VAL_CTNT = AA.DMDT_DELT_RQST_STS_CD ) AS INACT_STS_NM" ).append("\n"); 
		query.append("     , AA.*" ).append("\n"); 
		query.append("#if (${est_mk} != 'P')  " ).append("\n"); 
		query.append("	 , DECODE(TRIM(DMDT_EXPT_RQST_STS_CD), NULL, NULL, '', NULL, DECODE(DMDT_EXPT_RQST_STS_CD, 'R', 'BLUE', 'J', 'RED', 'O', 'RED', 'A', 'BLACK', 'PINK')) DMDT_EXPT_RQST_STS_COLOR" ).append("\n"); 
		query.append("	   , CASE WHEN DMDT_EXPT_RQST_STS_CD = 'O' THEN " ).append("\n"); 
		query.append("				   (SELECT DECODE(MAX(AFT_BKG_PATH_LVL), 1, 'SCO PIC ', 2, 'SSZ/BAG ', 3, 'RHQ PIC ', 4, 'RHQ MGR ', 5, 'HO PIC ', 6, 'HO MGR ', '') || 'Counter-Offer'" ).append("\n"); 
		query.append("					  FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append(" 			         WHERE AFT_EXPT_DAR_NO = AA.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					   AND DMDT_EXPT_RQST_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("	 		           AND AFT_BKG_PATH_CPLS_FLG = 'Y')" ).append("\n"); 
		query.append("			 ELSE  (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("			          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		             WHERE INTG_CD_ID = 'CD01971'" ).append("\n"); 
		query.append("	    	           AND INTG_CD_VAL_CTNT = DMDT_EXPT_RQST_STS_CD)" ).append("\n"); 
		query.append("			 END DMDT_EXPT_RQST_STS_CD_DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("          T1.BKG_NO" ).append("\n"); 
		query.append("        , T1.BL_NO" ).append("\n"); 
		query.append("        , T2.SYS_AREA_GRP_ID                                                               		 AS SVR_ID" ).append("\n"); 
		query.append("        , T2.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT  CASE " ).append("\n"); 
		query.append("						WHEN NVL(MAX(DD.DMDT_DELT_RQST_STS_CD), 'N') IN ('C','N') THEN 'N'" ).append("\n"); 
		query.append("						WHEN 0 < MAX((" ).append("\n"); 
		query.append("									SELECT  COUNT(1)" ).append("\n"); 
		query.append("									  FROM  DMT_CHG_DELT_PATH " ).append("\n"); 
		query.append("									 WHERE  SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   AND  CNTR_NO             = DD.CNTR_NO" ).append("\n"); 
		query.append("									   AND  CNTR_CYC_NO         = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   AND  DMDT_TRF_CD         = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   AND  DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("									   AND  CHG_SEQ             = DD.CHG_SEQ" ).append("\n"); 
		query.append("									   AND  CHG_OFC_CD          = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("									   AND  DELT_SEQ            = DD.DELT_SEQ" ).append("\n"); 
		query.append("									   AND  CHG_DELT_PATH_LVL  >=" ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												SELECT  max(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("												  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("												 WHERE  SYS_AREA_GRP_ID        = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("												   AND  CNTR_NO                = DD.CNTR_NO" ).append("\n"); 
		query.append("												   AND  CNTR_CYC_NO            = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("												   AND  DMDT_TRF_CD            = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("												   AND  DMDT_CHG_LOC_DIV_CD    = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("												   AND  CHG_SEQ                = DD.CHG_SEQ" ).append("\n"); 
		query.append("												   AND  CHG_OFC_CD             = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("												   AND  DELT_SEQ               = DD.DELT_SEQ" ).append("\n"); 
		query.append("												   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("									   and  CHG_DELT_STS_CD = 'A'" ).append("\n"); 
		query.append("								 )) THEN 'X'		--// Charge Deletion 요청 불가, Charge Deletion Cancel 불가" ).append("\n"); 
		query.append("						ELSE MAX(DD.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("			 WHERE  DD.SYS_AREA_GRP_ID     = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND	DD.CNTR_NO		       = T2.CNTR_NO" ).append("\n"); 
		query.append("			   AND	DD.CNTR_CYC_NO		   = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND	DD.DMDT_TRF_CD		   = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   AND	DD.DMDT_CHG_LOC_DIV_CD = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   AND	DD.CHG_SEQ			   = T2.CHG_SEQ" ).append("\n"); 
		query.append("			   AND  DD.DELT_SEQ            = " ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("						SELECT  NVL(MAX(DS.DELT_SEQ), 0) " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_RQST_APRO DS" ).append("\n"); 
		query.append("						 WHERE  DS.SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  DS.CNTR_NO	           = DD.CNTR_NO" ).append("\n"); 
		query.append("						   AND  DS.CNTR_CYC_NO	       = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DS.DMDT_TRF_CD	       = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DS.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  DS.CHG_SEQ		       = DD.CHG_SEQ" ).append("\n"); 
		query.append("						   AND  DS.CHG_OFC_CD          = DD.CHG_OFC_CD   " ).append("\n"); 
		query.append("						   AND  DS.DMDT_DELT_RQST_STS_CD != 'C'" ).append("\n"); 
		query.append("					)  " ).append("\n"); 
		query.append("		 ) 																						 AS DMDT_DELT_RQST_STS_CD	  " ).append("\n"); 
		query.append("        , T2.CNTR_NO" ).append("\n"); 
		query.append("        , T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("        , T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        , T2.OFC_CD" ).append("\n"); 
		query.append("        , T2.OFC_RHQ_CD" ).append("\n"); 
		query.append("        , T2.CHG_SEQ" ).append("\n"); 
		query.append("        , T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , T2.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        , T2.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("        , T2.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("        , T2.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("        , T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("        , T2.FT_DYS" ).append("\n"); 
		query.append("        , T2.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("		-- 조건추가(S) 2013.12.13" ).append("\n"); 
		query.append("		, TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(NVL(T2.TO_MVMT_DT, T2.FT_END_DT), 'YYYYMMDD'), 'YYYYMMDD') AS OVR_DUE" ).append("\n"); 
		query.append("		-- 조건추가(E)" ).append("\n"); 
		query.append("        , TO_CHAR(T2.FM_MVMT_DT, 'YYYYMMDD')                                                     AS FM_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T2.FM_MVMT_DT, 'HH24MI')                                                       AS FM_MVMT_DT_TIME" ).append("\n"); 
		query.append("        , TO_CHAR(T2.TO_MVMT_DT, 'YYYYMMDD')                                                     AS TO_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T2.TO_MVMT_DT, 'HH24MI')                                                       AS TO_MVMT_DT_TIME" ).append("\n"); 
		query.append("        , TO_CHAR(T2.FT_CMNC_DT, 'YYYYMMDD')                                                     AS FT_CMNC_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T2.FT_END_DT , 'YYYYMMDD')                                                     AS FT_END_DT" ).append("\n"); 
		query.append("        , T2.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("        , T2.ORG_CHG_AMT" ).append("\n"); 
		query.append("        , T2.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("        , T2.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("        , T2.BIL_AMT" ).append("\n"); 
		query.append("        , DECODE(T2.CHG_SEQ, 1, 'G', 'B')                                                        AS CHG_TYPE" ).append("\n"); 
		query.append("        , NVL(T2.UCLM_FLG, 'N')                                                                  AS UCLM_FLG" ).append("\n"); 
		query.append("        , NVL(T1.SOC_FLG, 'N')                                                                   AS SOC_FLG" ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("          WHEN T2.DMDT_TRF_CD='DMIF' AND T2.TO_MVMT_STS_CD      ='ID'               THEN 'L'" ).append("\n"); 
		query.append("          WHEN T2.DMDT_TRF_CD='DMIF' AND T2.TO_MVMT_STS_CD NOT IN ('ID','CS','DR')  THEN 'I'" ).append("\n"); 
		query.append("          WHEN T2.DMDT_TRF_CD='DMOF' AND T2.DMDT_CHG_LOC_DIV_CD<>'POL'              THEN 'L'" ).append("\n"); 
		query.append("          WHEN T2.DMDT_TRF_CD='DMOF' AND T2.DMDT_CHG_LOC_DIV_CD ='POL'              THEN 'I'" ).append("\n"); 
		query.append("          END                                                                                 AS LI" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT NVL(HLG_TP_CD, 'N')      /* 'C'ARRIER, 'M'ERCHANT, 'N'ULL */" ).append("\n"); 
		query.append("          FROM   BKG_EUR_TRO" ).append("\n"); 
		query.append("          WHERE  BKG_NO              = T1.BKG_NO" ).append("\n"); 
		query.append("          AND    IO_BND_CD           = SUBSTR(T2.DMDT_TRF_CD, 3, 1)    /* IN/OUT BOUND */" ).append("\n"); 
		query.append("          AND    NVL(CXL_FLG, 'N')   = 'N'" ).append("\n"); 
		query.append("          AND    CNTR_NO             = T2.CNTR_NO" ).append("\n"); 
		query.append("          AND    ROWNUM              = 1" ).append("\n"); 
		query.append("          )                                                                                     AS CH" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT 'Y'" ).append("\n"); 
		query.append("          FROM   DUAL" ).append("\n"); 
		query.append("          WHERE  EXISTS (" ).append("\n"); 
		query.append("                        SELECT  S2.RLSE_STS_CD" ).append("\n"); 
		query.append("                        FROM    BKG_DO     S1," ).append("\n"); 
		query.append("                                BKG_DO_DTL S2" ).append("\n"); 
		query.append("                        WHERE   S1.BKG_NO        = S2.BKG_NO" ).append("\n"); 
		query.append("                        AND     S1.BKG_NO        = T1.BKG_NO" ).append("\n"); 
		query.append("                        AND     S2.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("          )                                                                                   AS D_O" ).append("\n"); 
		query.append("        , (	" ).append("\n"); 
		query.append("          SELECT  S2.EVNT_OFC_CD" ).append("\n"); 
		query.append("          FROM    BKG_DO         S1," ).append("\n"); 
		query.append("                  BKG_DO_DTL     S2" ).append("\n"); 
		query.append("          WHERE   S1.BKG_NO        = S2.BKG_NO" ).append("\n"); 
		query.append("          AND     S1.BKG_NO        = T1.BKG_NO" ).append("\n"); 
		query.append("          AND     S2.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("          AND     ROWNUM           = 1 " ).append("\n"); 
		query.append("          )                                                                                   AS RLSE_OFC" ).append("\n"); 
		query.append("        , T4.CLT_OFC_CD" ).append("\n"); 
		query.append("        , NVL(T2.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("          SELECT 'C'" ).append("\n"); 
		query.append("          FROM   DUAL" ).append("\n"); 
		query.append("          WHERE  EXISTS (" ).append("\n"); 
		query.append("                        SELECT 1" ).append("\n"); 
		query.append("                        FROM   BKG_ROLL_OVR R" ).append("\n"); 
		query.append("                        WHERE  R.BKG_NO          = T1.BKG_NO" ).append("\n"); 
		query.append("                        AND    R.ROLL_OVR_RSN_CD IN ( 'C','H' )" ).append("\n"); 
		query.append("          	        )" ).append("\n"); 
		query.append("        )                                                                                   AS ROLL_OVR" ).append("\n"); 
		query.append("        , T2.DMDT_INV_NO" ).append("\n"); 
		query.append("        , TO_CHAR(T5.CRE_DT, 'YYYYMMDD')                                                    AS ISS_DT" ).append("\n"); 
		query.append("        , T5.INV_CURR_CD" ).append("\n"); 
		query.append("        , T6.CNTR_INV_AMT" ).append("\n"); 
		query.append("        , T5.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("        , T2.WEB_IND_FLG " ).append("\n"); 
		query.append("        , DECODE(T2.WEB_IND_FLG, 'Y', TO_CHAR(NVL(T2.WEB_MTY_DT, T2.TO_MVMT_DT), 'YYYY-MM-DD'), TO_CHAR(T2.WEB_MTY_DT, 'YYYY-MM-DD'))         AS WEB_CRE_DT" ).append("\n"); 
		query.append("        , DECODE(T2.WEB_IND_FLG, 'Y', TO_CHAR(NVL(T2.FT_END_DT, T2.TO_MVMT_DT) + 7, 'YYYY-MM-DD'), TO_CHAR(T2.FT_END_DT + 7, 'YYYY-MM-DD')) AS WEB_MTY_DT" ).append("\n"); 
		query.append("        , T2.WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append("        , T2.DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("        , T2.CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append("        , NVL(T6.CRE_OFC_CD, T2.OFC_CD)                                                     AS CRE_OFC_CD" ).append("\n"); 
		query.append("        , T2.NOT_CRE_BAL_FLG" ).append("\n"); 
		query.append("#if (${est_mk} != 'P')  " ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT  COUNT (CNTR_NO) " ).append("\n"); 
		query.append("          FROM    BKG_CONTAINER" ).append("\n"); 
		query.append("          WHERE   BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("          )                                                                                 AS BKG_QTY" ).append("\n"); 
		query.append("        , T3.INCUR_QTY" ).append("\n"); 
		query.append("        , T3.INCUR_CNTR_TEU_KNT" ).append("\n"); 
		query.append("        , T3.EXPT_QTY" ).append("\n"); 
		query.append("        , T3.EXPT_CNTR_TEU_KNT" ).append("\n"); 
		query.append("        , T3.INCUR_AMT" ).append("\n"); 
		query.append("        , T3.EXPT_DYS" ).append("\n"); 
		query.append("        , T3.EXPT_COST_AMT" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT  SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2))" ).append("\n"); 
		query.append("          FROM    BKG_CONTAINER" ).append("\n"); 
		query.append("          WHERE   BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("          AND     SUBSTR(CNTR_TPSZ_CD,1,1) <> 'Q'" ).append("\n"); 
		query.append("          )                                                                               AS BKG_CNTR_TEU" ).append("\n"); 
		query.append("        , T1.BKG_DE_TERM_CD " ).append("\n"); 
		query.append("        , T1.BKG_RCV_TERM_CD " ).append("\n"); 
		query.append("		, (SELECT AA.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("              FROM DMT_AFT_BKG_ADJ_RQST_DTL CC" ).append("\n"); 
		query.append("                 , DMT_AFT_BKG_CNTR BB" ).append("\n"); 
		query.append("                 , DMT_AFT_BKG_ADJ_RQST AA" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND CC.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("               AND CC.AFT_EXPT_DAR_NO = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("               AND CC.AFT_EXPT_ADJ_SEQ = BB.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("               AND CC.DMDT_TRF_CD = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("               AND BB.SYS_AREA_GRP_ID = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND BB.CNTR_NO = T2.CNTR_NO" ).append("\n"); 
		query.append("               AND BB.CNTR_CYC_NO = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("               AND BB.DMDT_TRF_CD = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("               AND BB.DMDT_CHG_LOC_DIV_CD = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("               AND BB.CHG_SEQ = T2.CHG_SEQ" ).append("\n"); 
		query.append("               AND AA.AFT_EXPT_DAR_NO = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("               AND AA.RQST_DT = (SELECT MAX(RQST_DT)" ).append("\n"); 
		query.append("                      FROM DMT_AFT_BKG_ADJ_RQST A1" ).append("\n"); 
		query.append("                         , DMT_AFT_BKG_ADJ_RQST_DTL B1" ).append("\n"); 
		query.append("                     WHERE A1.AFT_EXPT_DAR_NO=B1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                       AND B1.BKG_NO=CC.BKG_NO )" ).append("\n"); 
		query.append("               AND DMDT_EXPT_RQST_STS_CD != 'T' ) AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("         , (SELECT DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("              FROM DMT_AFT_BKG_ADJ_RQST_DTL CC" ).append("\n"); 
		query.append("                 , DMT_AFT_BKG_CNTR BB" ).append("\n"); 
		query.append("                 , DMT_AFT_BKG_ADJ_RQST AA" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND CC.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("               AND CC.AFT_EXPT_DAR_NO = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("               AND CC.AFT_EXPT_ADJ_SEQ = BB.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("               AND CC.DMDT_TRF_CD = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("               AND BB.SYS_AREA_GRP_ID = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND BB.CNTR_NO = T2.CNTR_NO" ).append("\n"); 
		query.append("               AND BB.CNTR_CYC_NO = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("               AND BB.DMDT_TRF_CD = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("               AND BB.DMDT_CHG_LOC_DIV_CD = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("               AND BB.CHG_SEQ = T2.CHG_SEQ" ).append("\n"); 
		query.append("               AND AA.AFT_EXPT_DAR_NO = BB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("               AND AA.RQST_DT = (SELECT MAX(RQST_DT)" ).append("\n"); 
		query.append("                      FROM DMT_AFT_BKG_ADJ_RQST A1" ).append("\n"); 
		query.append("                         , DMT_AFT_BKG_ADJ_RQST_DTL B1" ).append("\n"); 
		query.append("                     WHERE A1.AFT_EXPT_DAR_NO=B1.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                       AND B1.BKG_NO=CC.BKG_NO )" ).append("\n"); 
		query.append("               AND DMDT_EXPT_RQST_STS_CD != 'T' ) DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${est_mk} == 'P') " ).append("\n"); 
		query.append("FROM	  DMT_CHG_PRE_CALC_BKG_CNTR T1" ).append("\n"); 
		query.append("        , DMT_CHG_PRE_CALC          T2" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM	  DMT_CHG_BKG_CNTR          T1" ).append("\n"); 
		query.append("        , DMT_CHG_CALC              T2" ).append("\n"); 
		query.append("        , DMT_EXPT_CHG_CALC         T3" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , BKG_RATE                  T4" ).append("\n"); 
		query.append("        , DMT_INV_MN                T5" ).append("\n"); 
		query.append("        , DMT_INV_DTL               T6" ).append("\n"); 
		query.append("WHERE   T1.SYS_AREA_GRP_ID      = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     T1.CNTR_NO              = T2.CNTR_NO" ).append("\n"); 
		query.append("AND     T1.CNTR_CYC_NO          = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     T1.BKG_NO               = T4.BKG_NO(+)" ).append("\n"); 
		query.append("AND     T1.BKG_NO               = @[bkg_no]" ).append("\n"); 
		query.append("AND     T2.DMDT_TRF_CD          = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("#if (${est_mk} != 'P')" ).append("\n"); 
		query.append("AND     T2.DMDT_CHG_STS_CD   IN (" ).append("\n"); 
		query.append("	#foreach( $chg_sts_cd in ${chg_sts_cd_list} )" ).append("\n"); 
		query.append("		#if($velocityCount < $chg_sts_cd_list.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("AND     T2.CNTR_NO               = T3.CNTR_NO             (+)" ).append("\n"); 
		query.append("AND     T2.CNTR_CYC_NO           = T3.CNTR_CYC_NO         (+)" ).append("\n"); 
		query.append("AND     T2.DMDT_TRF_CD           = T3.DMDT_TRF_CD         (+)" ).append("\n"); 
		query.append("AND     T2.DMDT_CHG_LOC_DIV_CD   = T3.DMDT_CHG_LOC_DIV_CD (+)" ).append("\n"); 
		query.append("AND     T2.CHG_SEQ               = T3.CHG_SEQ             (+)" ).append("\n"); 
		query.append("AND     T3.BKG_NO            (+) = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     NOT (T2.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(T2.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND     T2.DMDT_CHG_LOC_DIV_CD	<> 'SZP'" ).append("\n"); 
		query.append("AND     T2.DMDT_INV_NO           = T6.DMDT_INV_NO       (+)" ).append("\n"); 
		query.append("AND     T2.SYS_AREA_GRP_ID       = T6.SYS_AREA_GRP_ID   (+)" ).append("\n"); 
		query.append("AND     T2.CNTR_NO               = T6.CNTR_NO           (+)" ).append("\n"); 
		query.append("AND     T2.CNTR_CYC_NO           = T6.CNTR_CYC_NO       (+)" ).append("\n"); 
		query.append("AND     T2.DMDT_TRF_CD           = T6.DMDT_TRF_CD       (+)" ).append("\n"); 
		query.append("AND     T2.DMDT_CHG_LOC_DIV_CD	 = T6.DMDT_CHG_LOC_DIV_CD(+)" ).append("\n"); 
		query.append("AND     T2.CHG_SEQ               = T6.CHG_SEQ           (+)" ).append("\n"); 
		query.append("AND     T5.DMDT_INV_NO        (+)= T6.DMDT_INV_NO" ).append("\n"); 
		query.append("AND     T5.CRE_OFC_CD         (+)= T6.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     T5.DMDT_INV_STS_CD    (+)= 'I'" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("#if (${rhq_ofc_cd} != 'All')" ).append("\n"); 
		query.append("AND     T2.OFC_RHQ_CD            = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 조건추가(S) 2013.09.11" ).append("\n"); 
		query.append("#if(${uclm_flg} != 'ALL')          " ).append("\n"); 
		query.append("AND     NVL(T2.UCLM_FLG, 'N')    =  @[uclm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- 조건추가(E)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY T2.DMDT_TRF_CD, T2.CNTR_NO, T2.CNTR_CYC_NO, TO_CHAR(T2.FM_MVMT_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append(") AA" ).append("\n"); 

	}
}