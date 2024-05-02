/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchMonthlyQuotaInfoList0077RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOSearchMonthlyQuotaInfoList0077RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * month에 대한 subTrade 별 데이터 조회
	  * History : 2011.02.14 김종준 [T-선사] YEARLY QTA 부분 삭제
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchMonthlyQuotaInfoList0077RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchMonthlyQuotaInfoList0077RSQL").append("\n"); 
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
		query.append("SELECT															" ).append("\n"); 
		query.append("    MIN(QTA.TRD_CD||QTA.DIR_CD) KEY,                                         " ).append("\n"); 
		query.append("    DECODE(QTA.TRD_CD||QTA.DIR_CD, '', '1',                                  " ).append("\n"); 
		query.append("    DECODE(QTA.SUB_TRD_CD, '', '2', '3')) SLEVEL,                        " ).append("\n"); 
		query.append("    DECODE(QTA.TRD_CD||QTA.DIR_CD, '', 'TOTAL', MIN(QTA.TRD_CD)) TRD_CD,     " ).append("\n"); 
		query.append("    DECODE(QTA.TRD_CD||QTA.DIR_CD, '', '', MIN(QTA.DIR_CD)) DIR_CD,          " ).append("\n"); 
		query.append("    QTA.SUB_TRD_CD,                                                          " ).append("\n"); 
		query.append("    SUM(MDL_LOAD) AS MDL_LOAD,                                               " ).append("\n"); 
		query.append("    SUM(MDL_GROSS_REVENUE/1000) AS MDL_GROSS_REVENUE,                        " ).append("\n"); 
		query.append("    SUM(MDL_CM/1000) AS MDL_CM,                                              " ).append("\n"); 
		query.append("    SUM(MDL_OP/1000) AS MDL_OP,                                              " ).append("\n"); 
		query.append("    SUM(ACC_MDL_LOAD) AS ACC_MDL_LOAD,                                       " ).append("\n"); 
		query.append("    SUM(ACC_MDL_REV/1000) AS ACC_MDL_REV,                                    " ).append("\n"); 
		query.append("    SUM(CAP.CAPA) AS MDL_CAPA                                               " ).append("\n"); 
		query.append("FROM (                                                                       " ).append("\n"); 
		query.append("    SELECT -- MODEL RESLUT                                 " ).append("\n"); 
		query.append("        'MODEL' AS GUBUN,                                  " ).append("\n"); 
		query.append("        TRNS.TRD_CD,                                       " ).append("\n"); 
		query.append("        TRNS.DIR_CD,                                       " ).append("\n"); 
		query.append("        TRNS.SUB_TRD_CD,                                   " ).append("\n"); 
		query.append("        SUM(TRNS.LOD_QTY) AS MDL_LOAD,                     " ).append("\n"); 
		query.append("        SUM(GRS_RPB_REV*LOD_QTY) AS MDL_GROSS_REVENUE,     " ).append("\n"); 
		query.append("        SUM((GRS_RPB_REV-CM_UC_AMT)*LOD_QTY)  AS MDL_CM,   " ).append("\n"); 
		query.append("        SUM((GRS_RPB_REV-OPFIT_UC_AMT)*LOD_QTY) AS MDL_OP, " ).append("\n"); 
		query.append("        0 AS YQT_LOAD,                                     " ).append("\n"); 
		query.append("        0 AS YQT_CAPA,                                     " ).append("\n"); 
		query.append("        0 AS YQT_GROSS_REVENUE,                            " ).append("\n"); 
		query.append("        0 AS YQT_CM,                                       " ).append("\n"); 
		query.append("        0 AS YQT_OP,                                       " ).append("\n"); 
		query.append("        0 AS ACC_YQT_LOAD,                                 " ).append("\n"); 
		query.append("        0 AS ACC_YQT_REV,                                  " ).append("\n"); 
		query.append("        0 AS ACC_MDL_LOAD,                                 " ).append("\n"); 
		query.append("        0 AS ACC_MDL_REV                                   " ).append("\n"); 
		query.append("    FROM SAQ_MON_MDL_CTRT_SMRY TRNS                    " ).append("\n"); 
		query.append("    WHERE TRNS.MQTA_MDL_VER_NO = @[version]                         " ).append("\n"); 
		query.append("    AND   TRNS.BSE_YR = @[year]" ).append("\n"); 
		query.append("-- MONTH" ).append("\n"); 
		query.append("#if (${month} < 10) " ).append("\n"); 
		query.append("	AND TRNS.BSE_MON = '0'||@[month]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND TRNS.BSE_MON = @[month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY TRNS.TRD_CD, TRNS.DIR_CD, TRNS.SUB_TRD_CD     " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("    UNION ALL                                              " ).append("\n"); 
		query.append("    SELECT -- ACCUMULATED MONTHLY QUOTA                    " ).append("\n"); 
		query.append("        '' AS GUBUN,                                       " ).append("\n"); 
		query.append("        VVD.TRD_CD,                                            " ).append("\n"); 
		query.append("        VVD.DIR_CD,                                            " ).append("\n"); 
		query.append("        VVD.SUB_TRD_CD,                                        " ).append("\n"); 
		query.append("        0 AS MDL_LOAD,                                     " ).append("\n"); 
		query.append("        0 AS MDL_GROSS_REVENUE,                            " ).append("\n"); 
		query.append("        0 AS MDL_CM,                                       " ).append("\n"); 
		query.append("        0 AS MDL_OP,                                       " ).append("\n"); 
		query.append("        0 AS YQT_LOAD,                                     " ).append("\n"); 
		query.append("        0 AS YQT_CAPA,                                     " ).append("\n"); 
		query.append("        0 AS YQT_GROSS_REVENUE,                            " ).append("\n"); 
		query.append("        0 AS YQT_CM,                                       " ).append("\n"); 
		query.append("        0 AS YQT_OP,                                       " ).append("\n"); 
		query.append("        0 AS ACC_YQT_LOAD,                                 " ).append("\n"); 
		query.append("        0 AS ACC_YQT_REV,                                  " ).append("\n"); 
		query.append("        SUM(LOD_QTY) AS ACC_MDL_LOAD,                      " ).append("\n"); 
		query.append("        SUM(GRS_RPB_REV*LOD_QTY) AS ACC_MDL_REV            " ).append("\n"); 
		query.append("    FROM   SAQ_MON_QTA_RLSE RLS,                           " ).append("\n"); 
		query.append("           SAQ_MON_CFM_QTA QTA,                                 " ).append("\n"); 
		query.append("           SAQ_MON_CFM_TGT_VVD VVD                                 		" ).append("\n"); 
		query.append("    WHERE  RLS.BSE_YR = @[year]                                  " ).append("\n"); 
		query.append("    AND    TO_NUMBER(SUBSTR(RLS.BSE_QTR_CD,1,1)) < TO_NUMBER(SUBSTR(@[bse_qtr_cd],1,1)) -- REP MONTH                    " ).append("\n"); 
		query.append("    AND    RLS.QTA_RLSE_STS_CD = 'R'                       " ).append("\n"); 
		query.append("    AND    QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO     " ).append("\n"); 
		query.append("    AND    QTA.BSE_YR = RLS.BSE_YR                         " ).append("\n"); 
		query.append("    AND    QTA.BSE_QTR_CD = RLS.BSE_QTR_CD                       " ).append("\n"); 
		query.append("    AND QTA.MQTA_RLSE_VER_NO = VVD.MQTA_RLSE_VER_NO                          " ).append("\n"); 
		query.append("    AND QTA.BSE_YR = VVD.BSE_YR                      " ).append("\n"); 
		query.append("    AND QTA.BSE_QTR_CD = VVD.BSE_QTR_CD                      " ).append("\n"); 
		query.append("    AND QTA.BSE_MON = VVD.BSE_MON                      " ).append("\n"); 
		query.append("    AND QTA.TRD_CD = VVD.TRD_CD                      " ).append("\n"); 
		query.append("    AND QTA.RLANE_CD = VVD.RLANE_CD                      " ).append("\n"); 
		query.append("    AND QTA.DIR_CD = VVD.DIR_CD                      " ).append("\n"); 
		query.append("    AND QTA.VSL_CD = VVD.VSL_CD                      " ).append("\n"); 
		query.append("    AND QTA.SKD_VOY_NO = VVD.SKD_VOY_NO                      " ).append("\n"); 
		query.append("    AND QTA.SKD_DIR_CD = VVD.SKD_DIR_CD                      " ).append("\n"); 
		query.append("    GROUP BY VVD.TRD_CD, VVD.DIR_CD, VVD.SUB_TRD_CD                    " ).append("\n"); 
		query.append("    ) QTA, (                                               " ).append("\n"); 
		query.append("    SELECT 'MODEL' AS GUBUN,           		              " ).append("\n"); 
		query.append("           VVD.TRD_CD, NVL(DIR.CONV_DIR_CD, VVD.DIR_CD) DIR_CD, VVD.SUB_TRD_CD, 		              " ).append("\n"); 
		query.append("           SUM(VVD.FNL_BSA_CAPA) AS CAPA                       " ).append("\n"); 
		query.append("    FROM   SAQ_MON_TGT_VVD VVD" ).append("\n"); 
		query.append("          ,SAQ_MON_DIR_CONV DIR" ).append("\n"); 
		query.append("    WHERE  VVD.BSE_YR        = @[year]                                      " ).append("\n"); 
		query.append("    AND    VVD.BSE_QTR_CD    = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND    DIR.BSE_YR(+)     = @[year]" ).append("\n"); 
		query.append("    AND    DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND    DIR.TRD_CD(+)     = VVD.TRD_CD" ).append("\n"); 
		query.append("    AND    DIR.RLANE_CD(+)   = VVD.RLANE_CD" ).append("\n"); 
		query.append("    AND    DIR.DIR_CD(+)     = VVD.DIR_CD" ).append("\n"); 
		query.append("#if (${month} < 10) " ).append("\n"); 
		query.append("	AND VVD.BSE_MON = '0'||@[month]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	AND VVD.BSE_MON = @[month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND    VVD.DELT_FLG = 'N'                                  " ).append("\n"); 
		query.append("    GROUP BY VVD.TRD_CD, NVL(DIR.CONV_DIR_CD, VVD.DIR_CD), VVD.SUB_TRD_CD                    " ).append("\n"); 
		query.append("    ) CAP                                                  " ).append("\n"); 
		query.append("WHERE QTA.GUBUN = CAP.GUBUN(+)                             " ).append("\n"); 
		query.append("AND   QTA.TRD_CD = CAP.TRD_CD(+)                           " ).append("\n"); 
		query.append("AND   QTA.DIR_CD = CAP.DIR_CD(+)                           " ).append("\n"); 
		query.append("AND   QTA.SUB_TRD_CD = CAP.SUB_TRD_CD(+)                   " ).append("\n"); 
		query.append("GROUP BY ROLLUP(QTA.TRD_CD||QTA.DIR_CD, QTA.SUB_TRD_CD)    " ).append("\n"); 
		query.append("ORDER BY KEY, SLEVEL" ).append("\n"); 

	}
}