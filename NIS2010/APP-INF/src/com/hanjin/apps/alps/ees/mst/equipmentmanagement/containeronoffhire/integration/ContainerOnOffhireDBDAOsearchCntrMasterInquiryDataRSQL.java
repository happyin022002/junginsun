/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Master Inquiry
	  * 2010.10.21 남궁진호 [CHM-201006508-01] LT,ST Term일경우 Reefer Unit Info를 MST_CONTAINER에서 조회한다.기존엔 MST_CNTR_LOT에서 모두조회함
	  * 2010.12.27 진마리아 [CHM-201007809-01] RF_TP_CD을 COM_INTG_CD_DTL에서 조회한다.
	  * 2011.04.26 남궁진호 [CHM-201110291-01] CNMV_YR,CNMV_ID_NO 컬럼 추가
	  * 2013.05.22 채창호    [CHM-201324310] CNTR_RSK_FLG 컬럼 추가
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_dgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrMasterInquiryDataRSQL").append("\n"); 
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
		query.append("WITH PPARAM AS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                    CNTR_NO " ).append("\n"); 
		query.append("           FROM     MST_CONTAINER A" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${noExit} == 'A')" ).append("\n"); 
		query.append("    #if (${chk_dgt} == '')" ).append("\n"); 
		query.append("           AND      A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${chk_dgt} != '') " ).append("\n"); 
		query.append("           AND      A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${noExit} == 'E')" ).append("\n"); 
		query.append("    #if (${chk_dgt} == '')" ).append("\n"); 
		query.append("           AND      A.CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${chk_dgt} != '') " ).append("\n"); 
		query.append("           AND      A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND      CNMV_DT =" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   MAX(CNMV_DT) " ).append("\n"); 
		query.append("                      FROM     MST_CONTAINER " ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${noExit} == 'A')" ).append("\n"); 
		query.append("    #if (${chk_dgt} == '')" ).append("\n"); 
		query.append("                      AND  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${chk_dgt} != '') " ).append("\n"); 
		query.append("                      AND   CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${noExit} == 'E')" ).append("\n"); 
		query.append("    #if (${chk_dgt} == '')" ).append("\n"); 
		query.append("                      AND  CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${chk_dgt} != '') " ).append("\n"); 
		query.append("                      AND   CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("           AND      ROWNUM = 1" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("SELECT   A.*" ).append("\n"); 
		query.append("       , B.*" ).append("\n"); 
		query.append("	   , CASE WHEN A.LSTM_CD IN ('LT','ST','OF','SB','MU') THEN (DECODE(CNTR_STS_EVNT_DT_OLD, NULL, TRUNC(SYSDATE)+1, TRUNC(CNTR_STS_EVNT_DT_OLD)+1) - TRUNC(ONH_DT_OLD)) * B.RNTL_CHG_AMT1" ).append("\n"); 
		query.append("	          ELSE 0 END " ).append("\n"); 
		query.append("	     AS RNTL_CHG_AMT" ).append("\n"); 
		query.append("	   , C.BKG_NO1" ).append("\n"); 
		query.append("       , C.BKG_NO2" ).append("\n"); 
		query.append("       , C.BKG_NO3" ).append("\n"); 
		query.append("       , DECODE(CNTR_STS_EVNT_DT_OLD, NULL, TRUNC(SYSDATE)+1, TRUNC(CNTR_STS_EVNT_DT_OLD)+1) - TRUNC(ONH_DT_OLD) USING_DAYS" ).append("\n"); 
		query.append("       , ROUND(MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',P.CNTR_NO),2) COST_AMT" ).append("\n"); 
		query.append("       , L.CERTI_NO" ).append("\n"); 
		query.append("       , L.APRO_CSC_NO" ).append("\n"); 
		query.append("       , L.APRO_TIR_NO" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   NVL(VNDR_ABBR_NM, VNDR_LGL_ENG_NM) " ).append("\n"); 
		query.append("           FROM     MDM_VENDOR " ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      VNDR_SEQ = NVL(A.RF_MKR_SEQ,L.RF_MKR_SEQ)" ).append("\n"); 
		query.append("         ) AS RF_MKR_SEQ" ).append("\n"); 
		query.append("       , NVL(A.RF_MDL_NM, L.RF_MDL_NM) AS RF_MDL_NM" ).append("\n"); 
		query.append("       , NVL(A.RF_RFR_NO, L.RF_RFR_NO) AS RF_RFR_NO" ).append("\n"); 
		query.append("       , NVL(A.MIN_TEMP, L.MIN_TEMP) AS MIN_TEMP" ).append("\n"); 
		query.append("       , NVL(A.MAX_TEMP, L.MAX_TEMP) AS MAX_TEMP" ).append("\n"); 
		query.append("FROM     ( " ).append("\n"); 
		query.append("		   SELECT   A.CNTR_NO" ).append("\n"); 
		query.append("                  , A.PLST_FLR_FLG" ).append("\n"); 
		query.append("                  , SUBSTR(A.CNTR_NO,11) CHK_DGT" ).append("\n"); 
		query.append("                  , DECODE(A.ACIAC_DIV_CD, 'I', 'Inactive','A','Active') ACIAC_DIV_CD" ).append("\n"); 
		query.append("                  , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , B.CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("                  , A.CNTR_MTRL_CD" ).append("\n"); 
		query.append("                  , E.TARE_WGT" ).append("\n"); 
		query.append("                  , E.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                  , ROUND(TO_NUMBER(E.TARE_WGT) * 2.2046,0) TARE_WGT_LBS" ).append("\n"); 
		query.append("                  , A.LSTM_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("                      FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      INTG_CD_ID = 'CD01020'" ).append("\n"); 
		query.append("                      AND      INTG_CD_VAL_CTNT = A.CNTR_USE_CO_CD" ).append("\n"); 
		query.append("                    ) CNTR_USE_CO_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("                      FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      INTG_CD_ID = 'CD01047'" ).append("\n"); 
		query.append("                      AND      INTG_CD_VAL_CTNT = A.OWNR_CO_CD" ).append("\n"); 
		query.append("                    ) OWNR_CO_CD" ).append("\n"); 
		query.append("                  , C.VNDR_ABBR_NM" ).append("\n"); 
		query.append("                  , C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  , TO_CHAR(A.MFT_DT, 'YYYY-MM-DD') MFT_DT" ).append("\n"); 
		query.append("                  , A.D2_PAYLD_FLG" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   S.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                      FROM     COM_INTG_CD_DTL S" ).append("\n"); 
		query.append("                      WHERE	   1 = 1" ).append("\n"); 
		query.append("                      AND      S.INTG_CD_VAL_CTNT = A.RF_TP_CD" ).append("\n"); 
		query.append("                      AND      S.INTG_CD_ID = 'CD01085'" ).append("\n"); 
		query.append("                    ) RF_TP_CD" ).append("\n"); 
		query.append("                  , A.CNMV_STS_CD" ).append("\n"); 
		query.append("                  , A.CNMV_YR" ).append("\n"); 
		query.append("                  , A.CNMV_ID_NO" ).append("\n"); 
		query.append("                  , A.CRNT_YD_CD" ).append("\n"); 
		query.append("                  , A.VSL_CD" ).append("\n"); 
		query.append("                  , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  , TO_CHAR(A.CNMV_DT, 'YYYY-MM-DD HH24:MI') CNMV_DT" ).append("\n"); 
		query.append("                  , A.FULL_FLG" ).append("\n"); 
		query.append("                  , A.DMG_FLG" ).append("\n"); 
		query.append("                  , A.IMDT_EXT_FLG" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                      FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      INTG_CD_ID = 'CD02012'" ).append("\n"); 
		query.append("                      AND      INTG_CD_VAL_CTNT = A.CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("                    ) CNTR_HNGR_RCK_CD" ).append("\n"); 
		query.append("                  , A.MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("                  , A.CNTR_HNGR_BAR_ATCH_KNT" ).append("\n"); 
		query.append("                  , A.DISP_FLG" ).append("\n"); 
		query.append("                  , A.UCLM_LS_DIV_CD UCLM_LS" ).append("\n"); 
		query.append("                  , TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("                  , A.ONH_DT ONH_DT_OLD" ).append("\n"); 
		query.append("                  , A.ONH_CNTR_STS_CD" ).append("\n"); 
		query.append("                  , MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ) ONH_AGMT_NO" ).append("\n"); 
		query.append("                  , D.VNDR_SEQ" ).append("\n"); 
		query.append("                  , D.VNDR_LGL_ENG_NM LESSOR_NM" ).append("\n"); 
		query.append("                  , MNR_COMMON_PKG.MNR_CAL_DV_FNC('U',A.CNTR_NO,TO_CHAR(SYSDATE,'YYYYMMDD')) DPC_VAL" ).append("\n"); 
		query.append("                  , A.RF_MKR_SEQ" ).append("\n"); 
		query.append("                  , A.RF_MDL_NM" ).append("\n"); 
		query.append("                  , A.RF_RFR_NO" ).append("\n"); 
		query.append("                  , A.MIN_TEMP" ).append("\n"); 
		query.append("                  , A.MAX_TEMP" ).append("\n"); 
		query.append("                  , TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("                  , A.CRE_USR_ID" ).append("\n"); 
		query.append("                  , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                  , A.UPD_USR_ID" ).append("\n"); 
		query.append("                  , NVL(A.CNTR_RSK_FLG,'N') CNTR_RSK_FLG" ).append("\n"); 
		query.append("		   FROM     MST_CONTAINER A" ).append("\n"); 
		query.append("			      , MDM_CNTR_TP_SZ B" ).append("\n"); 
		query.append("			      , (" ).append("\n"); 
		query.append("	    	          SELECT   BB.VNDR_ABBR_NM" ).append("\n"); 
		query.append("	       		             , BB.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	       		             , BB.VNDR_SEQ" ).append("\n"); 
		query.append("		              FROM     MST_CONTAINER AA" ).append("\n"); 
		query.append("	       		             , MDM_VENDOR BB" ).append("\n"); 
		query.append("	       		             , PPARAM P" ).append("\n"); 
		query.append("	    	          WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      AA.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("	    	          AND      AA.MFTR_VNDR_SEQ = BB.VNDR_SEQ" ).append("\n"); 
		query.append("			        ) C" ).append("\n"); 
		query.append("			      , (" ).append("\n"); 
		query.append("			          SELECT   AA.VNDR_SEQ" ).append("\n"); 
		query.append("				             , BB.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			          FROM     MST_CONTAINER AA" ).append("\n"); 
		query.append("				             , MDM_VENDOR BB" ).append("\n"); 
		query.append("				             , PPARAM P" ).append("\n"); 
		query.append("			          WHERE AA.CNTR_NO    = P.CNTR_NO" ).append("\n"); 
		query.append("			          AND   AA.VNDR_SEQ   = BB.VNDR_SEQ" ).append("\n"); 
		query.append("			        ) D" ).append("\n"); 
		query.append("			      , (" ).append("\n"); 
		query.append("			          SELECT   NVL(B.TARE_WGT, A.CNTR_TPSZ_TARE_WGT) TARE_WGT" ).append("\n"); 
		query.append("				             , C.CNTR_SPEC_NO" ).append("\n"); 
		query.append("			          FROM     MST_CNTR_SPEC B" ).append("\n"); 
		query.append("                             , MST_CONTAINER C" ).append("\n"); 
		query.append("                             , PPARAM P" ).append("\n"); 
		query.append("                             , MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("			          WHERE    1 = 1" ).append("\n"); 
		query.append("			          AND      C.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("			          AND      C.CNTR_SPEC_NO = B.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("			          AND      C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("			        ) E" ).append("\n"); 
		query.append("			      , PPARAM P   " ).append("\n"); 
		query.append("		   WHERE    1 = 1" ).append("\n"); 
		query.append("		   AND      A.CNTR_NO		= P.CNTR_NO" ).append("\n"); 
		query.append("		   AND      B.CNTR_TPSZ_CD	= A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		   AND      A.MFTR_VNDR_SEQ	= C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("		   AND      A.VNDR_SEQ		= D.VNDR_SEQ(+)" ).append("\n"); 
		query.append("		 ) A" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("		   SELECT   CASE WHEN C.ACIAC_DIV_CD = 'I' THEN CASE WHEN B.CNTR_STS_CD IN ('SBO', 'MUO', 'SBI', 'MUI') THEN D.LSTM_CD ELSE C.LSTM_CD END" ).append("\n"); 
		query.append("                         ELSE C.LSTM_CD" ).append("\n"); 
		query.append("                    END SUB_LSTM_CD" ).append("\n"); 
		query.append("                  , CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN TO_CHAR(B.CNTR_STS_EVNT_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                         ELSE ''" ).append("\n"); 
		query.append("                    END CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                  , CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN B.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                         ELSE NULL" ).append("\n"); 
		query.append("                    END CNTR_STS_EVNT_DT_OLD" ).append("\n"); 
		query.append("                  , CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN B.CNTR_STS_CD" ).append("\n"); 
		query.append("                         ELSE ''" ).append("\n"); 
		query.append("                    END CNTR_STS_CD" ).append("\n"); 
		query.append("                  , CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(B.AGMT_CTY_CD, B.AGMT_SEQ)" ).append("\n"); 
		query.append("                         ELSE ''" ).append("\n"); 
		query.append("                    END EXIT_AGMT_NO" ).append("\n"); 
		query.append("                  , CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SCR', 'DON', 'TLL') THEN TO_CHAR(E.VNDR_SEQ)" ).append("\n"); 
		query.append("                         WHEN B.CNTR_STS_CD IN ('SLD') THEN DECODE(NVL(B.CUST_CNT_CD,'0'), '0', '', B.CUST_CNT_CD||B.CUST_SEQ)" ).append("\n"); 
		query.append("                         ELSE ''" ).append("\n"); 
		query.append("                    END EXIT_VNDR_SEQ" ).append("\n"); 
		query.append("                  , CASE WHEN B.CNTR_STS_CD IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SCR', 'DON', 'TLL') THEN E.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                         WHEN B.CNTR_STS_CD IN ('SLD') THEN DECODE(NVL(B.CUST_CNT_CD,'0'), '0', B.CUST_NM, (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = B.CUST_CNT_CD AND CUST_SEQ = B.CUST_SEQ))" ).append("\n"); 
		query.append("                         ELSE ''" ).append("\n"); 
		query.append("                    END EXIT_VNDR_ENG_NM" ).append("\n"); 
		query.append("                  , DECODE(D.DPP_TP_CD,'G','General','L','Lump Sum','') DPP_TP_CD" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   NVL(N1ST_CHG_AMT, 0) N1ST_CHG_AMT" ).append("\n"); 
		query.append("                      FROM     LSE_AGMT_RT" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND      AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      LOC_CD   = 'KRSEL'" ).append("\n"); 
		query.append("                      AND      CNTR_TPSZ_CD  = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      AND      CNTR_RNTL_CHG_TP_CD IN ('LDPV','DPPV')" ).append("\n"); 
		query.append("                      AND      ROWNUM = 1" ).append("\n"); 
		query.append("                    ) DPP_AMT" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   NVL(N1ST_CHG_AMT, 0) N1ST_CHG_AMT" ).append("\n"); 
		query.append("                      FROM     LSE_AGMT_RT" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND      AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      LOC_CD   = DECODE(C.LSTM_CD, 'LT', ( SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(C.ONH_YD_CD, 1, 5) ), 'KRSEL')" ).append("\n"); 
		query.append("                      AND      CNTR_TPSZ_CD  = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      AND      CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("                      AND      AGMT_CHG_VAL = 1" ).append("\n"); 
		query.append("                    ) RNTL_CHG_AMT1" ).append("\n"); 
		query.append("                  , CASE WHEN C.ACIAC_DIV_CD = 'A' AND C.LSTM_CD = 'LT' THEN CASE WHEN nvl(c.min_onh_dys,0) > 0 THEN CASE WHEN TRUNC(SYSDATE) > TRUNC(C.ONH_DT) + (NVL(C.MIN_ONH_DYS,0) - 1) THEN 'Offhire Available !!!'" ).append("\n"); 
		query.append("                                                                                                                          ELSE '' " ).append("\n"); 
		query.append("                                                                                                                     END" ).append("\n"); 
		query.append("                                                                                  ELSE CASE WHEN TRUNC(SYSDATE) - ( SELECT /*+ INDEX_DESC (A XPKLSE_AGMT_VER) */ TRUNC(EXP_DT) FROM LSE_AGMT_VER A WHERE  A.AGMT_CTY_CD = C.AGMT_CTY_CD AND A.AGMT_SEQ = C.AGMT_SEQ AND ROWNUM = 1 ) > 0 THEN 'Offhire Available !!!!'" ).append("\n"); 
		query.append("                                                                                            ELSE '' " ).append("\n"); 
		query.append("                                                                                       END" ).append("\n"); 
		query.append("                                                                             END" ).append("\n"); 
		query.append("                         WHEN C.ACIAC_DIV_CD = 'A' AND C.LSTM_CD IN ('ST', 'SI', 'OF', 'MI') THEN CASE WHEN TRUNC(SYSDATE) > TRUNC(C.ONH_DT) + (NVL(C.MIN_ONH_DYS,0) - 1) THEN 'Offhire Available !!!'" ).append("\n"); 
		query.append("                                                                                                       ELSE ''" ).append("\n"); 
		query.append("                                                                                                  END" ).append("\n"); 
		query.append("                         ELSE ''" ).append("\n"); 
		query.append("                    END OFF_HIRE_AVAIL" ).append("\n"); 
		query.append("                  , C.CNTR_NO" ).append("\n"); 
		query.append("                  , D.LSE_VNDR_URL" ).append("\n"); 
		query.append("		   FROM     (" ).append("\n"); 
		query.append("			          SELECT   A.LST_STS_SEQ MAX_STS_SEQ" ).append("\n"); 
		query.append("				             , A.CNTR_NO" ).append("\n"); 
		query.append("			          FROM     MST_CONTAINER A" ).append("\n"); 
		query.append("				             , PPARAM P" ).append("\n"); 
		query.append("			          WHERE    1 = 1" ).append("\n"); 
		query.append("			          AND      A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("                  , MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                  , MST_CONTAINER C" ).append("\n"); 
		query.append("                  , LSE_AGREEMENT D" ).append("\n"); 
		query.append("                  , MDM_VENDOR E" ).append("\n"); 
		query.append("		   WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.CNTR_NO     = B.CNTR_NO" ).append("\n"); 
		query.append("		   AND      A.MAX_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("		   AND      C.CNTR_NO     = A.CNTR_NO" ).append("\n"); 
		query.append("		   AND      D.AGMT_CTY_CD(+) = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("		   AND      D.AGMT_SEQ(+)    = B.AGMT_SEQ" ).append("\n"); 
		query.append("		   AND      D.VNDR_SEQ    = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   MAX(DECODE(RN, 1, BKG_NO)) BKG_NO1" ).append("\n"); 
		query.append("                  , MAX(DECODE(RN, 2, BKG_NO)) BKG_NO2" ).append("\n"); 
		query.append("                  , MAX(DECODE(RN, 3, BKG_NO)) BKG_NO3" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("    	              SELECT   ROWNUM RN" ).append("\n"); 
		query.append("                             , BKG_NO" ).append("\n"); 
		query.append("    	              FROM     (" ).append("\n"); 
		query.append("        	                     SELECT   /*+ INDEX_DESC(A XAK11CTM_MOVEMENT) */  " ).append("\n"); 
		query.append("				                          A.BKG_NO" ).append("\n"); 
		query.append("				                        , CNMV_EVNT_DT EVNT_DT" ).append("\n"); 
		query.append("        	                     FROM     CTM_MOVEMENT A" ).append("\n"); 
		query.append("        	                            , PPARAM P" ).append("\n"); 
		query.append("        	                            , MST_CONTAINER B" ).append("\n"); 
		query.append("        	                     WHERE    1 = 1" ).append("\n"); 
		query.append("        	                     AND      B.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        	                     AND      A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        	                     AND      B.CNMV_CYC_NO =A.CNMV_CYC_NO" ).append("\n"); 
		query.append("        	                     AND      A.BKG_CGO_TP_CD IN ('F','R')" ).append("\n"); 
		query.append("        	                     AND      ROWNUM = 1" ).append("\n"); 
		query.append("        	                     UNION ALL" ).append("\n"); 
		query.append("        	                     SELECT   /*+ INDEX_DESC(A XAK11CTM_MOVEMENT) */  " ).append("\n"); 
		query.append("                                          A.BKG_NO" ).append("\n"); 
		query.append("                                        , MAX(CNMV_EVNT_DT) EVNT_DT" ).append("\n"); 
		query.append("        	                     FROM " ).append("\n"); 
		query.append("                                          CTM_MOVEMENT A" ).append("\n"); 
		query.append("                                        , PPARAM P" ).append("\n"); 
		query.append("                                        , MST_CONTAINER B" ).append("\n"); 
		query.append("        	                     WHERE    1 = 1" ).append("\n"); 
		query.append("        	                     AND      B.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        	                     AND      A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        	                     AND      B.CNMV_CYC_NO > A.CNMV_CYC_NO" ).append("\n"); 
		query.append("        	                     AND      A.MVMT_STS_CD IN ('VD')" ).append("\n"); 
		query.append("        	                     AND      A.BKG_CGO_TP_CD IN ('F','R')" ).append("\n"); 
		query.append("        	                     AND      ROWNUM <= 10" ).append("\n"); 
		query.append("        	                     GROUP BY A.BKG_NO" ).append("\n"); 
		query.append("        	                     ORDER BY EVNT_DT DESC" ).append("\n"); 
		query.append("        	                   )" ).append("\n"); 
		query.append("    	            )" ).append("\n"); 
		query.append("         ) C" ).append("\n"); 
		query.append("	   , PPARAM P" ).append("\n"); 
		query.append("	   , MST_CNTR_LOT L" ).append("\n"); 
		query.append("WHERE    A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND      SUBSTR(A.CNTR_NO,0,10) BETWEEN L.LOT_CNTR_PFX_CD(+)||L.FM_SER_NO(+) AND L.LOT_CNTR_PFX_CD(+)||L.TO_SER_NO(+)" ).append("\n"); 
		query.append("AND      ROWNUM = 1" ).append("\n"); 

	}
}