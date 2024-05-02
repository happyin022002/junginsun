/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselInformationMgtDBDAOVSLPartIVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOVSLPartIVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Particular I, Particular II 정보를 조회 합니다.
	  * 
	  * =====================================================
	  * History
	  * 2011.04.26 진마리아 [CHM-201110282-01] 로직 변경 요청(Engine Power 단위 BHP/KW 항목구분)
	  * 2012.04.02 진마리아 CHM-201217105-01 Local Vessel name 칼럼 추가 요청건
	  * </pre>
	  */
	public VesselInformationMgtDBDAOVSLPartIVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOVSLPartIVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	MVC.CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append(",	MVC.RF_RCPT_KNT" ).append("\n"); 
		query.append(",	MVC.RF_RCPT_MAX_KNT" ).append("\n"); 
		query.append(",	MVC.FBD_CAPA" ).append("\n"); 
		query.append(",	MVC.DPL_CAPA" ).append("\n"); 
		query.append(",	MVC.BLST_TNK_CAPA" ).append("\n"); 
		query.append(",	MVC.FOIL_CSM" ).append("\n"); 
		query.append(",	MVC.DOIL_CSM" ).append("\n"); 
		query.append(",	MVC.FRSH_WTR_CSM" ).append("\n"); 
		query.append(",	MVC.MN_ENG_RPM_PWR" ).append("\n"); 
		query.append(",	MVC.GNR_RPM_PWR" ).append("\n"); 
		query.append(",	MVC.VSL_HGT" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.RGST_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') RGST_DT" ).append("\n"); 
		query.append(",	MVC.VSL_EDI_NM" ).append("\n"); 
		query.append(",	MVC.CO_CD " ).append("\n"); 
		query.append(",	MVC.VSL_CLZ_DT" ).append("\n"); 
		query.append(",	MVC.VSL_CRE_OFC_CD" ).append("\n"); 
		query.append(",	MVC.VSL_DELT_OFC_CD" ).append("\n"); 
		query.append(",	MVC.VSL_BLD_AREA_NM " ).append("\n"); 
		query.append(",	MVC.GNR_MKR_NM" ).append("\n"); 
		query.append(",	MVC.GNR_TP_DESC" ).append("\n"); 
		query.append(",	MVC.GNR_BHP_PWR" ).append("\n"); 
		query.append(",	MVC.BWTHST_MKR_NM" ).append("\n"); 
		query.append(",	MVC.BWTHST_TP_DESC" ).append("\n"); 
		query.append(",	MVC.BWTHST_BHP_PWR" ).append("\n"); 
		query.append(",	MVC.BWTHST_RPM_PWR" ).append("\n"); 
		query.append(",	MVC.LLOYD_NO" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.VSL_LNCH_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') VSL_LNCH_DT" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.VSL_DE_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') VSL_DE_DT" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.VSL_KEL_LY_DT,'ddMonyy', 'NLS_DATE_LANGUAGE=American') VSL_KEL_LY_DT" ).append("\n"); 
		query.append(",	MVC.VSL_HL_NO" ).append("\n"); 
		query.append(",	MVC.TTL_TEU_KNT" ).append("\n"); 
		query.append(",	MVC.VSL_HTCH_KNT" ).append("\n"); 
		query.append(",	MVC.VSL_HLD_KNT" ).append("\n"); 
		query.append(",	MVC.VSL_RMK" ).append("\n"); 
		query.append(",	MVC.INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append(",	MVC.VSL_SFT_CSTRU_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_SFT_RDO_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_SFT_EQ_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_LOD_LINE_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.VSL_DERAT_CERTI_EXP_DT" ).append("\n"); 
		query.append(",	MVC.CRE_USR_ID" ).append("\n"); 
		query.append(",	MVC.CRE_DT" ).append("\n"); 
		query.append(",	MVC.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(MVC.UPD_DT,'yyyy-mm-dd hh24:mi') UPD_DT" ).append("\n"); 
		query.append(",	MVC.DELT_FLG" ).append("\n"); 
		query.append(",	MVC.EAI_EVNT_DT" ).append("\n"); 
		query.append(",	MVC.VSL_CD" ).append("\n"); 
		query.append(",	'' VSL_CLSS_CD" ).append("\n"); 
		query.append(",	MVC.VSL_ENG_NM" ).append("\n"); 
		query.append(",	MVC.VSL_KRN_NM" ).append("\n"); 
		query.append(",	MVC.FOIL_CAPA" ).append("\n"); 
		query.append(",	MVC.DOIL_CAPA" ).append("\n"); 
		query.append(",	MVC.FRSH_WTR_CAPA" ).append("\n"); 
		query.append(",	MVC.CALL_SGN_NO" ).append("\n"); 
		query.append(",	MVC.RGST_NO" ).append("\n"); 
		query.append(",	MVC.PHN_NO" ).append("\n"); 
		query.append(",	MVC.FAX_NO" ).append("\n"); 
		query.append(",	MVC.TLX_NO" ).append("\n"); 
		query.append(",	MVC.VSL_EML" ).append("\n"); 
		query.append(",	MVC.PICLB_DESC" ).append("\n"); 
		query.append(",	ML.LOC_NM||', '||MC2.CNT_NM RGST_PORT_CD" ).append("\n"); 
		query.append(",	MVC.CLSS_NO_RGST_AREA_NM" ).append("\n"); 
		query.append(",	MVC.VSL_CLSS_NO" ).append("\n"); 
		query.append(",	MVC.VSL_BLDR_NM" ).append("\n"); 
		query.append(",	MVC.LOA_LEN" ).append("\n"); 
		query.append(",	MVC.LBP_LEN" ).append("\n"); 
		query.append(",	MVC.VSL_WDT" ).append("\n"); 
		query.append(",	MVC.VSL_DPTH" ).append("\n"); 
		query.append(",	MVC.SMR_DRFT_HGT" ).append("\n"); 
		query.append(",	MVC.DWT_WGT" ).append("\n"); 
		query.append(",	MVC.LGT_SHP_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.PNM_GT_WGT" ).append("\n"); 
		query.append(",	MVC.PNM_NET_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.SUZ_GT_WGT" ).append("\n"); 
		query.append(",	MVC.SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append(",   MVC.MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append(",	MVC.MN_ENG_MKR_NM" ).append("\n"); 
		query.append(",	MVC.MN_ENG_TP_DESC" ).append("\n"); 
		query.append(",	DECODE(MVC.MN_ENG_HOR_PWR_UT_CD, 'KW', MVC.MN_ENG_BHP_PWR, 0) MN_ENG_KW_PWR" ).append("\n"); 
		query.append(",	DECODE(MVC.MN_ENG_HOR_PWR_UT_CD, 'KW', 0, MVC.MN_ENG_BHP_PWR) MN_ENG_BHP_PWR" ).append("\n"); 
		query.append(",	DECODE(MVC.VSL_OWN_IND_CD,'O','OWNER','C','CHARTER') AS VSL_OWN_IND_CD" ).append("\n"); 
		query.append(",	MVC.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",	DECODE(MVC.VSL_BLD_CD,'N','NEW','U','USED') AS VSL_BLD_CD" ).append("\n"); 
		query.append(",	MVC.CRR_CD" ).append("\n"); 
		query.append(",	MVC.FDR_DIV_CD" ).append("\n"); 
		query.append(",	MVC.VSL_SVC_SPD" ).append("\n"); 
		query.append(",	MVC.MAX_SPD" ).append("\n"); 
		query.append(",	MVC.ECN_SPD" ).append("\n"); 
		query.append(",	MVC.CRW_KNT" ).append("\n"); 
		query.append(",	MVC.CNTR_DZN_CAPA" ).append("\n"); 
		query.append(",	MVC.CNTR_OP_CAPA" ).append("\n"); 
		query.append(",	MVC.CNTR_PNM_CAPA" ).append("\n"); 
		query.append(",	VC.CRR_NM AS CRR_FULL_NM" ).append("\n"); 
		query.append(",	MC1.CNT_CD" ).append("\n"); 
		query.append(",	MC1.CNT_NM " ).append("\n"); 
		query.append(",   'CNTR' AS VSL_TYPE" ).append("\n"); 
		query.append(",   MVC.VSL_LOCL_NM" ).append("\n"); 
		query.append(",   TO_CHAR(DAILY_HIRE.N1ST_EFF_DT,'yyyy-mm-dd') N1ST_EFF_DT" ).append("\n"); 
		query.append(",   TO_CHAR(DAILY_HIRE.N1ST_EXP_DT,'yyyy-mm-dd') N1ST_EXP_DT" ).append("\n"); 
		query.append(",   TO_CHAR(DAILY_HIRE.N2ND_EFF_DT,'yyyy-mm-dd') N2ND_EFF_DT " ).append("\n"); 
		query.append(",   TO_CHAR(DAILY_HIRE.N2ND_EXP_DT,'yyyy-mm-dd') N2ND_EXP_DT" ).append("\n"); 
		query.append(", 	DECODE(DAILY_HIRE.N1ST_EXP_DT, NULL, '', (TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N1ST_EXP_DT, SYSDATE)/12)||'-'||" ).append("\n"); 
		query.append("    TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N1ST_EXP_DT , SYSDATE)-TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N1ST_EXP_DT, SYSDATE)/12)*12)||'-'||" ).append("\n"); 
		query.append("    CEIL((MONTHS_BETWEEN(DAILY_HIRE.N1ST_EXP_DT, SYSDATE)-TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N1ST_EXP_DT, SYSDATE)))*30.5)))" ).append("\n"); 
		query.append("    N1ST_RMN_DT" ).append("\n"); 
		query.append(", 	DECODE(DAILY_HIRE.N2ND_EXP_DT, NULL, '', (TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N2ND_EXP_DT, SYSDATE)/12)||'-'||" ).append("\n"); 
		query.append("    TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N2ND_EXP_DT , SYSDATE)-TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N2ND_EXP_DT, SYSDATE)/12)*12)||'-'||" ).append("\n"); 
		query.append("    CEIL((MONTHS_BETWEEN(DAILY_HIRE.N2ND_EXP_DT, SYSDATE)-TRUNC(MONTHS_BETWEEN(DAILY_HIRE.N2ND_EXP_DT, SYSDATE)))*30.5)))" ).append("\n"); 
		query.append("    N2ND_RMN_DT" ).append("\n"); 
		query.append(",   DAILY_HIRE.N1ST_VNDR_SEQ" ).append("\n"); 
		query.append(",   DAILY_HIRE.N1ST_VNDR_NM" ).append("\n"); 
		query.append(",   DAILY_HIRE.N2ND_VNDR_SEQ" ).append("\n"); 
		query.append(",   DAILY_HIRE.N2ND_VNDR_NM" ).append("\n"); 
		query.append(",   DAILY_HIRE.N1ST_HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append(",   DAILY_HIRE.N1ST_HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append(",   DAILY_HIRE.N1ST_HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append(",   DAILY_HIRE.N1ST_HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append(",   DAILY_HIRE.N2ND_HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append(",   DAILY_HIRE.N2ND_HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append(",   DAILY_HIRE.N2ND_HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append(",   DAILY_HIRE.N2ND_HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append(",   MVC.MN_ENG_TR_KNT" ).append("\n"); 
		query.append(",   '' GNR_TR_KNT" ).append("\n"); 
		query.append(",   '' BWTHST_TR_KNT" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append(",      MDM_CARRIER  VC" ).append("\n"); 
		query.append(",      MDM_COUNTRY  MC1" ).append("\n"); 
		query.append(",      MDM_COUNTRY  MC2" ).append("\n"); 
		query.append(",      MDM_LOCATION ML" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("    SELECT      MAX(X.VSL_CD)                          AS VSL_CD                                                            " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.EFF_DT)           ) AS N1ST_EFF_DT                               /* PERIOD FROM    */       " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.EXP_DT)           ) AS N1ST_EXP_DT                               /* PERIOD TO      */       " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.EFF_DT)           ) AS N2ND_EFF_DT                               /* PERIOD FROM    */       " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.EXP_DT)           ) AS N2ND_EXP_DT                               /* PERIOD TO      */       " ).append("\n"); 
		query.append("             -- , MAX(DECODE(SEQ,1,X.VNDR_SEQ,2,X.VNDR_SEQ)) AS VNDR_SEQ   " ).append("\n"); 
		query.append("             -- , MAX(DECODE(SEQ,1,X.VNDR_NM ,2,X.VNDR_NM )) AS VNDR_NM                               /* OWNER          */   " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.VNDR_SEQ)) AS N1ST_VNDR_SEQ   " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.VNDR_NM )) AS N1ST_VNDR_NM                               /* OWNER          */      " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.VNDR_SEQ)) AS N2ND_VNDR_SEQ   " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.VNDR_NM )) AS N2ND_VNDR_NM                               /* OWNER          */                      " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.HIR_CURR_N1ST_CD) ) AS N1ST_HIR_CURR_N1ST_CD                     /* FIRST CURRENCY */     " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.HIR_RT_N1ST_AMT)  ) AS N1ST_HIR_RT_N1ST_AMT                      /* FIRST AMOUNT   */      " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.HIR_CURR_N2ND_CD) ) AS N1ST_HIR_CURR_N2ND_CD                     /* SECOND AMOUNT  */     " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,1,X.HIR_RT_N2ND_AMT)  ) AS N1ST_HIR_RT_N2ND_AMT                      /* SECOND AMOUNT  */      " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.HIR_CURR_N1ST_CD) ) AS N2ND_HIR_CURR_N1ST_CD                     /* FIRST CURRENCY */     " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.HIR_RT_N1ST_AMT)  ) AS N2ND_HIR_RT_N1ST_AMT                      /* FIRST AMOUNT   */      " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.HIR_CURR_N2ND_CD) ) AS N2ND_HIR_CURR_N2ND_CD                     /* SECOND AMOUNT  */     " ).append("\n"); 
		query.append("              , MAX(DECODE(SEQ,2,X.HIR_RT_N2ND_AMT)  ) AS N2ND_HIR_RT_N2ND_AMT                      /* SECOND AMOUNT  */     " ).append("\n"); 
		query.append("    FROM     " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                -------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                SELECT      ROW_NUMBER() OVER (ORDER BY Y.SEQ ASC) AS SEQ" ).append("\n"); 
		query.append("                          , Y.VSL_CD" ).append("\n"); 
		query.append("                          , Y.FLET_CTRT_NO" ).append("\n"); 
		query.append("                          , Y.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                          , Y.EFF_DT                              " ).append("\n"); 
		query.append("                          , Y.EXP_DT                              " ).append("\n"); 
		query.append("                          , Y.VNDR_SEQ " ).append("\n"); 
		query.append("                          , Y.VNDR_NM                                         " ).append("\n"); 
		query.append("                          , Y.HIR_CURR_N1ST_CD                    " ).append("\n"); 
		query.append("                          , Y.HIR_RT_N1ST_AMT                     " ).append("\n"); 
		query.append("                          , Y.HIR_CURR_N2ND_CD                    " ).append("\n"); 
		query.append("                          , Y.HIR_RT_N2ND_AMT                                 " ).append("\n"); 
		query.append("                FROM        (" ).append("\n"); 
		query.append("                            SELECT  1 SEQ" ).append("\n"); 
		query.append("                                  , X.VSL_CD" ).append("\n"); 
		query.append("                                  , X.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                  , X.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                                  , X.EFF_DT                                /* PERIOD FROM */" ).append("\n"); 
		query.append("                                  , X.EXP_DT                                /* PERIOD TO   */" ).append("\n"); 
		query.append("                                  , X.VNDR_SEQ " ).append("\n"); 
		query.append("                                  , (SELECT   V.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("                                     FROM     MDM_VENDOR    V " ).append("\n"); 
		query.append("                                     WHERE    1 = 1" ).append("\n"); 
		query.append("                                     AND      V.VNDR_SEQ    = X.VNDR_SEQ" ).append("\n"); 
		query.append("                                     ) VNDR_NM                             /* OWNER */                            " ).append("\n"); 
		query.append("                                  , Y.HIR_CURR_N1ST_CD                     /* FIRST CURRENCY */" ).append("\n"); 
		query.append("                                  , Y.HIR_RT_N1ST_AMT                      /* FIRST AMOUNT   */" ).append("\n"); 
		query.append("                                  , Y.HIR_CURR_N2ND_CD                     /* SECOND AMOUNT  */" ).append("\n"); 
		query.append("                                  , Y.HIR_RT_N2ND_AMT                      /* SECOND AMOUNT  */" ).append("\n"); 
		query.append("                            FROM    FMS_CONTRACT        X" ).append("\n"); 
		query.append("                                  , FMS_HIRE            Y" ).append("\n"); 
		query.append("                            WHERE   1 = 1" ).append("\n"); 
		query.append("                            AND     X.FLET_CTRT_NO      = Y.FLET_CTRT_NO   " ).append("\n"); 
		query.append("                            AND     X.FLET_CTRT_TP_CD   IN ('OW','TI')  " ).append("\n"); 
		query.append("                            AND     X.FLET_CTRT_FACT_CD = 'ACT' " ).append("\n"); 
		query.append("                            AND     X.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("                            AND     SYSDATE             BETWEEN TO_DATE(TO_CHAR(X.EFF_DT,'YYYYMMDD'),'YYYYMMDD') AND TO_DATE(TO_CHAR(X.EXP_DT,'YYYYMMDD'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                            AND     SYSDATE             BETWEEN TO_DATE(TO_CHAR(Y.EFF_DT,'YYYYMMDD'),'YYYYMMDD') AND TO_DATE(TO_CHAR(Y.EXP_DT,'YYYYMMDD'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                            AND     X.VSL_CD            =  @[vsl_cd]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                            UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                            SELECT  2 SEQ" ).append("\n"); 
		query.append("                                  , X.VSL_CD" ).append("\n"); 
		query.append("                                  , X.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                  , X.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                                  , X.EFF_DT                                /* PERIOD FROM */" ).append("\n"); 
		query.append("                                  , X.EXP_DT                                /* PERIOD TO   */" ).append("\n"); 
		query.append("                                  , X.VNDR_SEQ   " ).append("\n"); 
		query.append("                                  , (SELECT   V.VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("                                     FROM     MDM_VENDOR    V " ).append("\n"); 
		query.append("                                     WHERE    1 = 1" ).append("\n"); 
		query.append("                                     AND      V.VNDR_SEQ    = X.VNDR_SEQ" ).append("\n"); 
		query.append("                                     ) VNDR_NM                             /* OWNER */                           " ).append("\n"); 
		query.append("                                  , Y.HIR_CURR_N1ST_CD                     /* FIRST CURRENCY */" ).append("\n"); 
		query.append("                                  , Y.HIR_RT_N1ST_AMT                      /* FIRST AMOUNT   */" ).append("\n"); 
		query.append("                                  , Y.HIR_CURR_N2ND_CD                     /* SECOND AMOUNT  */" ).append("\n"); 
		query.append("                                  , Y.HIR_RT_N2ND_AMT                      /* SECOND AMOUNT  */" ).append("\n"); 
		query.append("                            FROM    FMS_CONTRACT        X" ).append("\n"); 
		query.append("                                  , FMS_HIRE            Y" ).append("\n"); 
		query.append("                            WHERE   1 = 1" ).append("\n"); 
		query.append("                            AND     X.FLET_CTRT_NO      = Y.FLET_CTRT_NO   " ).append("\n"); 
		query.append("                            AND     X.FLET_CTRT_TP_CD   = 'TO'  " ).append("\n"); 
		query.append("                            AND     X.FLET_CTRT_FACT_CD = 'ACT' " ).append("\n"); 
		query.append("                            AND     X.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("                            AND     SYSDATE             BETWEEN TO_DATE(TO_CHAR(X.EFF_DT,'YYYYMMDD'),'YYYYMMDD') AND TO_DATE(TO_CHAR(X.EXP_DT,'YYYYMMDD'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                            AND     SYSDATE             BETWEEN TO_DATE(TO_CHAR(Y.EFF_DT,'YYYYMMDD'),'YYYYMMDD') AND TO_DATE(TO_CHAR(Y.EXP_DT,'YYYYMMDD'),'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                            AND     X.VSL_CD            =   @[vsl_cd]" ).append("\n"); 
		query.append("                            ) Y" ).append("\n"); 
		query.append("                -------------------------------------------------------------------------------------                        " ).append("\n"); 
		query.append("                ) X" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ) DAILY_HIRE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE MVC.CRR_CD = VC.CRR_CD(+)" ).append("\n"); 
		query.append("AND   MVC.VSL_RGST_CNT_CD = MC1.CNT_CD(+)" ).append("\n"); 
		query.append("AND   SUBSTR(MVC.RGST_PORT_CD,1,2) = MC2.CNT_CD(+)" ).append("\n"); 
		query.append("AND   MVC.RGST_PORT_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("AND   MVC.VSL_CD =   @[vsl_cd]" ).append("\n"); 

	}
}