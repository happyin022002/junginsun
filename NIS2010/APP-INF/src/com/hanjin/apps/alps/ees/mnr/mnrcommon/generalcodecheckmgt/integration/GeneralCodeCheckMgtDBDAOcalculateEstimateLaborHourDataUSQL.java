/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcalculateEstimateLaborHourDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOcalculateEstimateLaborHourDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Incident Ticket : ICM-201200829 
	  * Ticket ID: CHM-201221355
	  * Developer: 조경완
	  * Title : [MNR] Estimate Creation - Calculation시 Timeout Error 발생 문제 해결을 위한 변경 관리
	  * Description: Calculation시 SQL 수행속도 저하로 인한 Timeout Error 발생 문제 해결(SQL 튜닝)
	  * 
	  * 2012.11.23 조경완 [CHM-201220893-01] Estimate Group Auditing 모듈에서 Repair code 및 division code 수정 기능 추가
	  * - verify기능 개선을 위한 SQL 튜닝
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcalculateEstimateLaborHourDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOcalculateEstimateLaborHourDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET (A.INP_MSG16, A.INP_MSG37 ,A.INP_MSG30)       " ).append("\n"); 
		query.append("       =  ( SELECT                    " ).append("\n"); 
		query.append("                            DECODE(VOL_TP_CD, 'Q', DECODE(RANGE_TYPE, 'F', F_LABOR, 'A', DECODE(DFLT_RANGE, 'F', ROUND((RPR_QTY/F_SIZE) + 0.49)*F_LABOR, F_LABOR + ((RPR_QTY - F_SIZE)*(A_LABOR/F_SIZE)))), " ).append("\n"); 
		query.append("                                                   DECODE(RANGE_TYPE, 'F', F_LABOR, 'A', DECODE(DFLT_RANGE, 'F', ROUND((RPR_SIZE/F_SIZE) + 0.49)*F_LABOR, F_LABOR + ROUND((RPR_SIZE - F_SIZE)/A_SIZE + 0.49)*A_LABOR))" ).append("\n"); 
		query.append("                   ) RPR_LABOR," ).append("\n"); 
		query.append("                  SUBSTR(A.INP_MSG37, 1, 1)||'YN',DTL_DESC" ).append("\n"); 
		query.append("            FROM ( " ).append("\n"); 
		query.append("                    SELECT /*+ PUSH_SUBQ INDEX(MRTD XPKMNR_RPR_TRF_DTL) */" ).append("\n"); 
		query.append("                           MRTD.COST_GRP_CD COST_GRP_CD, A.INP_MSG1 LOC_CD, MRTD.VOL_TP_CD VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10) RPR_QTY, MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD) RPR_SIZE, MRTD.EQ_CMPO_CD EQ_CMPO_CD, MRTD.EQ_RPR_CD EQ_RPR_CD, MRTD.TRF_DIV_CD TRF_DIV_CD," ).append("\n"); 
		query.append("                           MAX(DECODE(" ).append("\n"); 
		query.append("                                   DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', SIGN(MRTD.RPR_QTY - A.INP_MSG9), SIGN(MRTD.RPR_SZ_NO - MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD))), -1)," ).append("\n"); 
		query.append("                                   -1, 'A', 'F'      " ).append("\n"); 
		query.append("                           )) RANGE_TYPE," ).append("\n"); 
		query.append("                           MIN(MRTD.MNR_RNG_TP_CD) DFLT_RANGE," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.RPR_LBR_HRS,0)) F_LABOR," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.MTRL_COST_AMT,0)) F_MATERIAL," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO),0))     F_SIZE," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.RPR_LBR_HRS), 2)) A_LABOR," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.MTRL_COST_AMT), 2)) A_MATERIAL," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO)), 2)) A_SIZE,  " ).append("\n"); 
		query.append("						   MAX(MRTD.DTL_DESC) AS DTL_DESC     " ).append("\n"); 
		query.append("                    FROM  MNR_RPR_TRF_HDR MRTH, MNR_RPR_TRF_DTL MRTD, MNR_DAT_VRFY A, MNR_AGMT_HDR MAH, MNR_RPR_TRF_HDR LTR" ).append("\n"); 
		query.append("                    WHERE A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND   MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("                    AND   MAH.TRF_NO               = LTR.TRF_NO(+)  " ).append("\n"); 
		query.append("                    AND   MRTH.TRF_NO              = MRTD.TRF_NO" ).append("\n"); 
		query.append("                    AND   MRTH.TRF_NO IN (SELECT MAX(MRTH.TRF_NO)" ).append("\n"); 
		query.append("                                          FROM MNR_RPR_TRF_HDR MRTH" ).append("\n"); 
		query.append("                                          WHERE MRTH.MNR_TRF_KND_CD = 'STD'" ).append("\n"); 
		query.append("                                          AND   MRTH.MNR_TRF_STS_CD = 'HA'" ).append("\n"); 
		query.append("                                          AND   TO_CHAR(MRTH.EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("                                          GROUP BY MRTH.EQ_KND_CD" ).append("\n"); 
		query.append("                                       )                    " ).append("\n"); 
		query.append("                    AND   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)        " ).append("\n"); 
		query.append("                    AND   A.INP_MSG2               = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG5               = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                    AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("                    AND   A.INP_MSG8               = MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                    AND   TO_NUMBER(DECODE(A.INP_MSG8, 'Q', A.INP_MSG9, MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD))) BETWEEN TO_NUMBER(MRTD.FM_RNG_SZ_NO) AND TO_NUMBER(DECODE(MRTD.TO_RNG_SZ_NO, 0, 9999999999, MRTD.TO_RNG_SZ_NO))  " ).append("\n"); 
		query.append("                    AND   A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                    AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("                    GROUP BY MRTD.COST_GRP_CD, A.INP_MSG1, MRTD.VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10) ,MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD), MRTD.EQ_CMPO_CD, MRTD.EQ_RPR_CD, MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            WHERE   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("            AND   A.INP_MSG1               = LOC_CD        " ).append("\n"); 
		query.append("            AND   A.INP_MSG2               = EQ_CMPO_CD" ).append("\n"); 
		query.append("            AND   A.INP_MSG5               = EQ_RPR_CD" ).append("\n"); 
		query.append("            AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("            AND   A.INP_MSG8               = VOL_TP_CD" ).append("\n"); 
		query.append("            AND   NVL(A.INP_MSG9, A.INP_MSG10) = RPR_QTY" ).append("\n"); 
		query.append("            AND   ROWNUM = 1" ).append("\n"); 
		query.append("          )     " ).append("\n"); 
		query.append("WHERE   A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND     A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND 	EXISTS ( " ).append("\n"); 
		query.append("			SELECT 'X'" ).append("\n"); 
		query.append("            FROM ( " ).append("\n"); 
		query.append("                    SELECT /*+ PUSH_SUBQ INDEX(MRTD XPKMNR_RPR_TRF_DTL) */" ).append("\n"); 
		query.append("                           MRTD.COST_GRP_CD COST_GRP_CD, A.INP_MSG1 LOC_CD, MRTD.VOL_TP_CD VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10) RPR_QTY, MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD) RPR_SIZE, MRTD.EQ_CMPO_CD EQ_CMPO_CD, MRTD.EQ_RPR_CD EQ_RPR_CD, MRTD.TRF_DIV_CD TRF_DIV_CD," ).append("\n"); 
		query.append("                           MAX(DECODE(" ).append("\n"); 
		query.append("                                   DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', SIGN(MRTD.RPR_QTY - A.INP_MSG9), SIGN(MRTD.RPR_SZ_NO - MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD))), -1)," ).append("\n"); 
		query.append("                                   -1, 'A', 'F'      " ).append("\n"); 
		query.append("                           )) RANGE_TYPE," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.RPR_LBR_HRS,0)) F_LABOR," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.MTRL_COST_AMT,0)) F_MATERIAL," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO),0))     F_SIZE," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.RPR_LBR_HRS), 2)) A_LABOR," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.MTRL_COST_AMT), 2)) A_MATERIAL," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO)), 2)) A_SIZE       " ).append("\n"); 
		query.append("                    FROM  MNR_RPR_TRF_HDR MRTH, MNR_RPR_TRF_DTL MRTD, MNR_DAT_VRFY A, MNR_AGMT_HDR MAH, MNR_RPR_TRF_HDR LTR" ).append("\n"); 
		query.append("                    WHERE A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND   MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("                    AND   MAH.TRF_NO               = LTR.TRF_NO(+)  " ).append("\n"); 
		query.append("                    AND   MRTH.TRF_NO              = MRTD.TRF_NO" ).append("\n"); 
		query.append("                    AND   MRTH.TRF_NO IN (SELECT MAX(MRTH.TRF_NO)" ).append("\n"); 
		query.append("                                          FROM MNR_RPR_TRF_HDR MRTH" ).append("\n"); 
		query.append("                                          WHERE MRTH.MNR_TRF_KND_CD = 'STD'" ).append("\n"); 
		query.append("                                          AND   MRTH.MNR_TRF_STS_CD = 'HA'" ).append("\n"); 
		query.append("                                          AND   TO_CHAR(MRTH.EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("                                          GROUP BY MRTH.EQ_KND_CD" ).append("\n"); 
		query.append("                                       )                    " ).append("\n"); 
		query.append("                    AND   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)         " ).append("\n"); 
		query.append("                    AND   A.INP_MSG2               = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG5               = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                    AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("                    AND   A.INP_MSG8               = MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                    AND   TO_NUMBER(DECODE(A.INP_MSG8, 'Q', A.INP_MSG9, MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD)))   BETWEEN TO_NUMBER(MRTD.FM_RNG_SZ_NO) AND TO_NUMBER(DECODE(MRTD.TO_RNG_SZ_NO, 0, 9999999999, MRTD.TO_RNG_SZ_NO))  " ).append("\n"); 
		query.append("                    AND   A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                    AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("                    GROUP BY MRTD.COST_GRP_CD, A.INP_MSG1, MRTD.VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10), MNR_COMMON_PKG.MNR_CONV_MEASURE_FNC(A.INP_MSG8, LTR.MNR_MEAS_UT_CD, A.INP_MSG10, MRTH.MNR_MEAS_UT_CD), MRTD.EQ_CMPO_CD, MRTD.EQ_RPR_CD, MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            WHERE   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("            AND   A.INP_MSG1               = LOC_CD       " ).append("\n"); 
		query.append("            AND   A.INP_MSG2               = EQ_CMPO_CD" ).append("\n"); 
		query.append("            AND   A.INP_MSG5               = EQ_RPR_CD" ).append("\n"); 
		query.append("            AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("            AND   A.INP_MSG8               = VOL_TP_CD" ).append("\n"); 
		query.append("            AND   NVL(A.INP_MSG9, A.INP_MSG10) = RPR_QTY" ).append("\n"); 
		query.append("            AND   ROWNUM = 1" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}