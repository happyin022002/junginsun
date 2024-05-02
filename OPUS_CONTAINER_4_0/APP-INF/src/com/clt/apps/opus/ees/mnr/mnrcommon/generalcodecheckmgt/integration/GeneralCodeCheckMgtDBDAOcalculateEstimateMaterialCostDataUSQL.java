/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcalculateEstimateMaterialCostDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
	  * calculateEstimateMaterialCostData
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
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET (A.INP_MSG17, A.INP_MSG37)        " ).append("\n"); 
		query.append("       =  ( SELECT --VOL_TP_CD, RPR_QTY, RPR_SIZE, EQ_CMPO_CD, EQ_RPR_CD, TRF_DIV_CD, RANGE_TYPE, F_LABOR, F_MATERIAL, F_SIZE, A_LABOR, A_MATERIAL, A_SIZE," ).append("\n"); 
		query.append("                   DECODE(VOL_TP_CD, 'Q', DECODE(RANGE_TYPE, 'F', F_MATERIAL, 'A', DECODE(DFLT_RANGE, 'F', ROUND((RPR_QTY/F_SIZE) + 0.49)*F_MATERIAL, F_MATERIAL + ((RPR_QTY - F_SIZE)*(A_MATERIAL/F_SIZE)))), " ).append("\n"); 
		query.append("                                          DECODE(RANGE_TYPE, 'F', F_MATERIAL, 'A', DECODE(DFLT_RANGE, 'F', ROUND((RPR_SIZE/F_SIZE) + 0.49)*F_MATERIAL, F_MATERIAL + ROUND((RPR_SIZE - F_SIZE)/A_SIZE + 0.49)*A_MATERIAL))" ).append("\n"); 
		query.append("                   ) RPR_MTRL," ).append("\n"); 
		query.append("            SUBSTR(A.INP_MSG37, 1, 2)||'Y'" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT MRTD.COST_GRP_CD COST_GRP_CD, A.INP_MSG1 LOC_CD, MRTD.VOL_TP_CD VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10) RPR_QTY, A.INP_MSG10 RPR_SIZE, MRTD.EQ_CMPO_CD EQ_CMPO_CD, MRTD.EQ_RPR_CD EQ_RPR_CD, MRTD.TRF_DIV_CD TRF_DIV_CD," ).append("\n"); 
		query.append("                           MAX(DECODE(" ).append("\n"); 
		query.append("                                   DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', SIGN(MRTD.RPR_QTY - A.INP_MSG9), SIGN(MRTD.RPR_SZ_NO - A.INP_MSG10)), -1)," ).append("\n"); 
		query.append("                                   -1, 'A', 'F'      " ).append("\n"); 
		query.append("                           )) RANGE_TYPE," ).append("\n"); 
		query.append("                           MIN(MRTD.MNR_RNG_TP_CD) DFLT_RANGE," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.RPR_LBR_HRS,0)) F_LABOR," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.MTRL_COST_AMT,0)) F_MATERIAL," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO),0))     F_SIZE," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.RPR_LBR_HRS), 2)) A_LABOR," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.MTRL_COST_AMT), 2)) A_MATERIAL," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO)), 2)) A_SIZE        " ).append("\n"); 
		query.append("                    FROM MNR_AGMT_HDR MAH, MNR_RPR_TRF_DTL MRTD, MNR_DAT_VRFY A" ).append("\n"); 
		query.append("                    WHERE A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND   MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("                    AND   MAH.TRF_NO               = MRTD.TRF_NO" ).append("\n"); 
		query.append("                    AND   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)         " ).append("\n"); 
		query.append("                    AND   A.INP_MSG2               = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG5               = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                    AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("                    AND   A.INP_MSG8               = MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                    AND   TO_NUMBER(DECODE(A.INP_MSG8, 'Q', A.INP_MSG9, A.INP_MSG10))         BETWEEN TO_NUMBER(MRTD.FM_RNG_SZ_NO) AND TO_NUMBER(DECODE(MRTD.TO_RNG_SZ_NO, 0, 9999999999, MRTD.TO_RNG_SZ_NO))  " ).append("\n"); 
		query.append("                    AND   A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                    AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("                    GROUP BY MRTD.COST_GRP_CD, A.INP_MSG1, MRTD.VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10), A.INP_MSG10, MRTD.EQ_CMPO_CD, MRTD.EQ_RPR_CD, MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            WHERE SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("            AND   A.INP_MSG1               = LOC_CD   " ).append("\n"); 
		query.append("            AND   A.INP_MSG2               = EQ_CMPO_CD" ).append("\n"); 
		query.append("            AND   A.INP_MSG5               = EQ_RPR_CD" ).append("\n"); 
		query.append("            AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("            AND   A.INP_MSG8               = VOL_TP_CD" ).append("\n"); 
		query.append("			AND   NVL(A.INP_MSG9, A.INP_MSG10)  = RPR_QTY" ).append("\n"); 
		query.append("            AND   ROWNUM = 1" ).append("\n"); 
		query.append("          )     " ).append("\n"); 
		query.append("WHERE   A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND     A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND     EXISTS ( " ).append("\n"); 
		query.append("      		SELECT 'X'" ).append("\n"); 
		query.append("      		FROM (" ).append("\n"); 
		query.append("                    SELECT MRTD.COST_GRP_CD COST_GRP_CD, A.INP_MSG1 LOC_CD, MRTD.VOL_TP_CD VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10) RPR_QTY, A.INP_MSG10 RPR_SIZE, MRTD.EQ_CMPO_CD EQ_CMPO_CD, MRTD.EQ_RPR_CD EQ_RPR_CD, MRTD.TRF_DIV_CD TRF_DIV_CD," ).append("\n"); 
		query.append("                           MAX(DECODE(" ).append("\n"); 
		query.append("                                   DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', SIGN(MRTD.RPR_QTY - A.INP_MSG9), SIGN(MRTD.RPR_SZ_NO - A.INP_MSG10)), -1)," ).append("\n"); 
		query.append("                                   -1, 'A', 'F'      " ).append("\n"); 
		query.append("                           )) RANGE_TYPE," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.RPR_LBR_HRS,0)) F_LABOR," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', MRTD.MTRL_COST_AMT,0)) F_MATERIAL," ).append("\n"); 
		query.append("                           MAX(DECODE(MRTD.MNR_RNG_TP_CD, 'F', DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO),0))     F_SIZE," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.RPR_LBR_HRS), 2)) A_LABOR," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||MRTD.MTRL_COST_AMT), 2)) A_MATERIAL," ).append("\n"); 
		query.append("                           TO_NUMBER(SUBSTR(MIN(MRTD.MNR_RNG_TP_CD||DECODE(MRTD.VOL_TP_CD, 'Q', MRTD.RPR_QTY, MRTD.RPR_SZ_NO)), 2)) A_SIZE     " ).append("\n"); 
		query.append("                    FROM MNR_AGMT_HDR MAH, MNR_RPR_TRF_DTL MRTD, MNR_DAT_VRFY A" ).append("\n"); 
		query.append("                    WHERE A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND   MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("                    AND   MAH.TRF_NO               = MRTD.TRF_NO" ).append("\n"); 
		query.append("                    AND   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)        " ).append("\n"); 
		query.append("                    AND   A.INP_MSG2               = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                    AND   A.INP_MSG5               = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                    AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("                    AND   A.INP_MSG8               = MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("                    AND   TO_NUMBER(DECODE(A.INP_MSG8, 'Q', A.INP_MSG9, A.INP_MSG10))          BETWEEN TO_NUMBER(MRTD.FM_RNG_SZ_NO) AND TO_NUMBER(DECODE(MRTD.TO_RNG_SZ_NO, 0, 9999999999, MRTD.TO_RNG_SZ_NO))  " ).append("\n"); 
		query.append("                    AND   A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                    AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("                    GROUP BY MRTD.COST_GRP_CD, A.INP_MSG1, MRTD.VOL_TP_CD, NVL(A.INP_MSG9, A.INP_MSG10), A.INP_MSG10, MRTD.EQ_CMPO_CD, MRTD.EQ_RPR_CD, MRTD.TRF_DIV_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            WHERE   SUBSTRB(A.INP_MSG19,1,3) = SUBSTR(COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("            AND   A.INP_MSG1               = LOC_CD        " ).append("\n"); 
		query.append("            AND   A.INP_MSG2               = EQ_CMPO_CD" ).append("\n"); 
		query.append("            AND   A.INP_MSG5               = EQ_RPR_CD" ).append("\n"); 
		query.append("            AND   NVL(RTRIM(A.INP_MSG7), 'XXXX')  = NVL(RTRIM(TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("            AND   A.INP_MSG8               = VOL_TP_CD" ).append("\n"); 
		query.append("			AND   NVL(A.INP_MSG9, A.INP_MSG10)  = RPR_QTY" ).append("\n"); 
		query.append("			AND   1 <> (CASE WHEN (SELECT MNR_CD_DESC FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                    WHERE PRNT_CD_ID ='CD00096'" ).append("\n"); 
		query.append("                    AND   MNR_CD_ID='TC' ) = 'N' " ).append("\n"); 
		query.append("              	THEN 1" ).append("\n"); 
		query.append("              	ELSE 0" ).append("\n"); 
		query.append("        		END)" ).append("\n"); 
		query.append("            AND   ROWNUM = 1" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}