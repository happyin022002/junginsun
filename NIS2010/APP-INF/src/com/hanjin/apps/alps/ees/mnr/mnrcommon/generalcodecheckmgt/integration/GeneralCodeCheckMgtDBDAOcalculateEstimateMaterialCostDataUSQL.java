/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcalculateEstimateMaterialCostDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.03 
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

public class GeneralCodeCheckMgtDBDAOcalculateEstimateMaterialCostDataUSQL implements ISQLTemplate{

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
	  * - verifying 기능 개선을 위한 SQL 튜닝
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcalculateEstimateMaterialCostDataUSQL(){
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
		query.append("FileName : GeneralCodeCheckMgtDBDAOcalculateEstimateMaterialCostDataUSQL").append("\n"); 
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
		query.append("UPDATE   MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET      ( A.INP_MSG17, A.INP_MSG37 ) =" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   DECODE(VOL_TP_CD, 'Q', DECODE(RANGE_TYPE, 'F', F_MATERIAL, 'A', DECODE(DFLT_RANGE, 'F', ROUND((RPR_QTY/F_SIZE) + 0.49)*F_MATERIAL, F_MATERIAL + ((RPR_QTY - F_SIZE)*(A_MATERIAL/F_SIZE)))), " ).append("\n"); 
		query.append("                                           DECODE(RANGE_TYPE, 'F', F_MATERIAL, 'A', DECODE(DFLT_RANGE, 'F', ROUND((RPR_SIZE/F_SIZE) + 0.49)*F_MATERIAL, F_MATERIAL + ROUND((RPR_SIZE - F_SIZE)/A_SIZE + 0.49)*A_MATERIAL))" ).append("\n"); 
		query.append("                    ) AS RPR_MTRL" ).append("\n"); 
		query.append("                  , SUBSTR(A.INP_MSG37, 1, 2)||'Y'" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   /*+ INDEX(MRTD XPKMNR_RPR_TRF_DTL) */" ).append("\n"); 
		query.append("                               MRTD.COST_GRP_CD" ).append("\n"); 
		query.append("                             , A.INP_MSG1 LOC_CD" ).append("\n"); 
		query.append("                             , MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                             , NVL(A.INP_MSG9, A.INP_MSG10) AS RPR_QTY" ).append("\n"); 
		query.append("                             , A.INP_MSG10 AS RPR_SIZE" ).append("\n"); 
		query.append("                             , MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                             , MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                             , MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                             , MAX(DECODE(" ).append("\n"); 
		query.append("                                   DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', SIGN(MRTD.RPR_QTY - A.INP_MSG9), SIGN(MRTD.RPR_SZ_NO - A.INP_MSG10)), -1)," ).append("\n"); 
		query.append("                                   -1, 'A', 'F'      " ).append("\n"); 
		query.append("                               )) RANGE_TYPE" ).append("\n"); 
		query.append("                             , MIN(MRTD.MNR_RNG_TP_CD) DFLT_RANGE" ).append("\n"); 
		query.append("                             , MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.RPR_LBR_HRS,0)) F_LABOR" ).append("\n"); 
		query.append("                             , MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.MTRL_COST_AMT,0)) F_MATERIAL" ).append("\n"); 
		query.append("                             , MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO),0)) AS F_SIZE" ).append("\n"); 
		query.append("                             , TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.RPR_LBR_HRS), 2)) AS A_LABOR" ).append("\n"); 
		query.append("                             , TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.MTRL_COST_AMT), 2)) AS A_MATERIAL" ).append("\n"); 
		query.append("                             , TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO)), 2)) AS A_SIZE" ).append("\n"); 
		query.append("                      FROM     MNR_DAT_VRFY A" ).append("\n"); 
		query.append("                             , MNR_AGMT_HDR MAH" ).append("\n"); 
		query.append("                             , MNR_RPR_TRF_DTL MRTD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("                      AND      MAH.TRF_NO               = MRTD.TRF_NO" ).append("\n"); 
		query.append("                      AND      SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)         " ).append("\n"); 
		query.append("                      AND      A.INP_MSG2               = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                      AND      A.INP_MSG5               = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                      AND      NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("                      AND      A.INP_MSG8               = MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                      AND      TO_NUMBER(DECODE(A.INP_MSG8, 'Q', A.INP_MSG9, A.INP_MSG10))         BETWEEN TO_NUMBER(MRTD.FM_RNG_SZ_NO) AND TO_NUMBER(DECODE(MRTD.TO_RNG_SZ_NO, 0, 9999999999, MRTD.TO_RNG_SZ_NO))  " ).append("\n"); 
		query.append("                      AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                      AND      A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("                      GROUP BY MRTD.COST_GRP_CD, A.INP_MSG1, MRTD.VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10), A.INP_MSG10, MRTD.EQ_CMPO_CD, MRTD.EQ_RPR_CD, MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("           WHERE    SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("           AND      A.INP_MSG1               = LOC_CD" ).append("\n"); 
		query.append("           AND      A.INP_MSG2               = EQ_CMPO_CD" ).append("\n"); 
		query.append("           AND      A.INP_MSG5               = EQ_RPR_CD" ).append("\n"); 
		query.append("           AND      NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("           AND      A.INP_MSG8               = VOL_TP_CD" ).append("\n"); 
		query.append("		   AND      NVL(A.INP_MSG9, A.INP_MSG10)  = RPR_QTY" ).append("\n"); 
		query.append("           AND      ROWNUM = 1" ).append("\n"); 
		query.append("         )     " ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND      A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("      	   SELECT   'X'" ).append("\n"); 
		query.append("      	   FROM     (" ).append("\n"); 
		query.append("                      SELECT   /*+ INDEX(MRTD XPKMNR_RPR_TRF_DTL) */" ).append("\n"); 
		query.append("                               MRTD.COST_GRP_CD" ).append("\n"); 
		query.append("                             , A.INP_MSG1 AS LOC_CD" ).append("\n"); 
		query.append("                             , MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                             , NVL(A.INP_MSG9, A.INP_MSG10) AS RPR_QTY" ).append("\n"); 
		query.append("                             , A.INP_MSG10 AS RPR_SIZE" ).append("\n"); 
		query.append("                             , MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                             , MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                             , MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                             , MAX(DECODE(" ).append("\n"); 
		query.append("                                   DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', SIGN(MRTD.RPR_QTY - A.INP_MSG9), SIGN(MRTD.RPR_SZ_NO - A.INP_MSG10)), -1)," ).append("\n"); 
		query.append("                                   -1, 'A', 'F'      " ).append("\n"); 
		query.append("                               )) RANGE_TYPE" ).append("\n"); 
		query.append("                             , MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.RPR_LBR_HRS,0)) AS F_LABOR" ).append("\n"); 
		query.append("                             , MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.MTRL_COST_AMT,0)) AS F_MATERIAL" ).append("\n"); 
		query.append("                             , MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO),0)) AS F_SIZE" ).append("\n"); 
		query.append("                             , TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.RPR_LBR_HRS), 2)) AS A_LABOR" ).append("\n"); 
		query.append("                             , TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.MTRL_COST_AMT), 2)) AS A_MATERIAL" ).append("\n"); 
		query.append("                             , TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO)), 2)) AS A_SIZE" ).append("\n"); 
		query.append("                      FROM     MNR_DAT_VRFY A" ).append("\n"); 
		query.append("                             , MNR_AGMT_HDR MAH" ).append("\n"); 
		query.append("                             , MNR_RPR_TRF_DTL MRTD" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("                      AND      MAH.TRF_NO               = MRTD.TRF_NO" ).append("\n"); 
		query.append("                      AND      SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)        " ).append("\n"); 
		query.append("                      AND      A.INP_MSG2               = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                      AND      A.INP_MSG5               = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                      AND      NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("                      AND      A.INP_MSG8               = MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                      AND      TO_NUMBER(DECODE(A.INP_MSG8, 'Q', A.INP_MSG9, A.INP_MSG10))          BETWEEN TO_NUMBER(MRTD.FM_RNG_SZ_NO) AND TO_NUMBER(DECODE(MRTD.TO_RNG_SZ_NO, 0, 9999999999, MRTD.TO_RNG_SZ_NO))  " ).append("\n"); 
		query.append("                      AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                      AND      A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("                      GROUP BY MRTD.COST_GRP_CD" ).append("\n"); 
		query.append("                             , A.INP_MSG1" ).append("\n"); 
		query.append("                             , MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                             , NVL(A.INP_MSG9, A.INP_MSG10)" ).append("\n"); 
		query.append("                             , A.INP_MSG10" ).append("\n"); 
		query.append("                             , MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                             , MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                             , MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("      	   WHERE   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("           AND     A.INP_MSG1               = LOC_CD        " ).append("\n"); 
		query.append("           AND     A.INP_MSG2               = EQ_CMPO_CD" ).append("\n"); 
		query.append("           AND     A.INP_MSG5               = EQ_RPR_CD" ).append("\n"); 
		query.append("           AND     NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("           AND     A.INP_MSG8               = VOL_TP_CD" ).append("\n"); 
		query.append("           AND     NVL(A.INP_MSG9, A.INP_MSG10)  = RPR_QTY" ).append("\n"); 
		query.append("           AND     ROWNUM = 1" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}