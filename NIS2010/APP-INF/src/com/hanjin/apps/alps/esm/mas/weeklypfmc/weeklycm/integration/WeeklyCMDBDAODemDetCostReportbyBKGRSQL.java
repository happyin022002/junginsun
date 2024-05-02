/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WeeklyCMDBDAODemDetCostReportbyBKGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2016.03.22 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAODemDetCostReportbyBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Cost Report by BKG 를 조회한다.
	  * </pre>
	  */
	public WeeklyCMDBDAODemDetCostReportbyBKGRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sls_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAODemDetCostReportbyBKGRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      ,COST_WK" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,SC_NO" ).append("\n"); 
		query.append("      ,RFA_NO" ).append("\n"); 
		query.append("      ,CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("      ,IO_BND_CD" ).append("\n"); 
		query.append("      ,CNTR_FM_DT" ).append("\n"); 
		query.append("      ,CNTR_TO_DT" ).append("\n"); 
		query.append("      ,CNTR_STAY_DYS" ).append("\n"); 
		query.append("      ,FT_END_DT" ).append("\n"); 
		query.append("      ,OVER_DYS" ).append("\n"); 
		query.append("      ,INC_AMT" ).append("\n"); 
		query.append("      ,BIL_AMT" ).append("\n"); 
		query.append("      ,INV_CHG_AMT" ).append("\n"); 
		query.append("      ,MRN_STO_WTHN" ).append("\n"); 
		query.append("      ,RAIL_STO_WTHN" ).append("\n"); 
		query.append("      ,CNTR_EQ_WTHN" ).append("\n"); 
		query.append("      ,CHSS_ST_WTHN" ).append("\n"); 
		query.append("      ,CHSS_COM_WTHN" ).append("\n"); 
		query.append("      ,RF_HNDL_WTHN" ).append("\n"); 
		query.append("      ,COST_TTL_WTHN" ).append("\n"); 
		query.append("      ,MRN_STO_AFT" ).append("\n"); 
		query.append("      ,RAIL_STO_AFT" ).append("\n"); 
		query.append("      ,CNTR_EQ_AFT" ).append("\n"); 
		query.append("      ,CHSS_ST_AFT" ).append("\n"); 
		query.append("      ,CHSS_COM_AFT" ).append("\n"); 
		query.append("      ,RF_HNDL_AFT" ).append("\n"); 
		query.append("      ,COST_TTL_AFT" ).append("\n"); 
		query.append("      ,STO_STATUS" ).append("\n"); 
		query.append("      ,CNTR_STATUS" ).append("\n"); 
		query.append("      ,CHSS_STATUS" ).append("\n"); 
		query.append("      ,TTL_STATUS" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT COST_YRMON" ).append("\n"); 
		query.append("              ,COST_WK" ).append("\n"); 
		query.append("              ,BKG_NO" ).append("\n"); 
		query.append("              ,CNTR_NO" ).append("\n"); 
		query.append("              ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,SC_NO" ).append("\n"); 
		query.append("              ,RFA_NO" ).append("\n"); 
		query.append("              ,CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("              ,IO_BND_CD" ).append("\n"); 
		query.append("              ,CNTR_FM_DT" ).append("\n"); 
		query.append("              ,CNTR_TO_DT" ).append("\n"); 
		query.append("              ,CNTR_STAY_DYS" ).append("\n"); 
		query.append("              ,FT_END_DT" ).append("\n"); 
		query.append("              ,OVER_DYS" ).append("\n"); 
		query.append("              ,INC_AMT" ).append("\n"); 
		query.append("              ,BIL_AMT" ).append("\n"); 
		query.append("              ,INV_CHG_AMT" ).append("\n"); 
		query.append("              ,MRN_STO_WTHN" ).append("\n"); 
		query.append("              ,RAIL_STO_WTHN" ).append("\n"); 
		query.append("              ,CNTR_EQ_WTHN" ).append("\n"); 
		query.append("              ,CHSS_ST_WTHN" ).append("\n"); 
		query.append("              ,CHSS_COM_WTHN" ).append("\n"); 
		query.append("              ,RF_HNDL_WTHN" ).append("\n"); 
		query.append("              ,COST_TTL_WTHN" ).append("\n"); 
		query.append("              ,MRN_STO_AFT" ).append("\n"); 
		query.append("              ,RAIL_STO_AFT" ).append("\n"); 
		query.append("              ,CNTR_EQ_AFT" ).append("\n"); 
		query.append("              ,CHSS_ST_AFT" ).append("\n"); 
		query.append("              ,CHSS_COM_AFT" ).append("\n"); 
		query.append("              ,RF_HNDL_AFT" ).append("\n"); 
		query.append("              ,COST_TTL_AFT" ).append("\n"); 
		query.append("              ,CASE WHEN STO_STATUS > 0 THEN 'Finished'" ).append("\n"); 
		query.append("                    ELSE 'Unfinished' END STO_STATUS" ).append("\n"); 
		query.append("              ,CASE WHEN CNTR_STATUS > 0 THEN 'Finished'" ).append("\n"); 
		query.append("                    ELSE 'Unfinished' END CNTR_STATUS" ).append("\n"); 
		query.append("              ,CASE WHEN CHSS_STATUS > 0 THEN 'Finished'" ).append("\n"); 
		query.append("                    ELSE 'Unfinished' END CHSS_STATUS" ).append("\n"); 
		query.append("              ,CASE WHEN (SELECT COUNT(1) from MAS_DMDT_COST_RPT_BKG_DTL D" ).append("\n"); 
		query.append("                          WHERE D.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                            AND D.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                            AND D.ITM_NM LIKE '%CNTR%'" ).append("\n"); 
		query.append("                            AND D.CNTR_FM_MVMT_STS_CD = 'ID') = 0 THEN" ).append("\n"); 
		query.append("                          'Unfinished'" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                        CASE WHEN (SELECT COUNT(1) from MAS_DMDT_COST_RPT_BKG_DTL D" ).append("\n"); 
		query.append("                                      WHERE D.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                                        AND D.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                                        AND D.ITM_NM LIKE '%CNTR%'" ).append("\n"); 
		query.append("                                        AND D.CNTR_FM_MVMT_STS_CD = 'ID'" ).append("\n"); 
		query.append("                                        AND D.CNTR_TO_MVMT_STS_CD IS NULL) = 0 THEN 'Finished'" ).append("\n"); 
		query.append("                             ELSE 'Unfinished'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("               END TTL_STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT B.COST_YRMON" ).append("\n"); 
		query.append("                      ,B.COST_WK" ).append("\n"); 
		query.append("                      ,A.BKG_NO" ).append("\n"); 
		query.append("                      ,A.CNTR_NO" ).append("\n"); 
		query.append("                      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      ,A.SC_NO" ).append("\n"); 
		query.append("                      ,A.RFA_NO" ).append("\n"); 
		query.append("                      ,A.CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("                      ,A.IO_BND_CD" ).append("\n"); 
		query.append("                      ,TO_CHAR(MIN(A.CNTR_FM_DT), 'YYYY-MM-DD') AS CNTR_FM_DT" ).append("\n"); 
		query.append("                      ,TO_CHAR(MAX(A.CNTR_TO_DT), 'YYYY-MM-DD') AS CNTR_TO_DT" ).append("\n"); 
		query.append("                      ,SUM(A.CNTR_STAY_DYS) AS CNTR_STAY_DYS" ).append("\n"); 
		query.append("                      ,TO_CHAR(MAX(A.FT_END_DT), 'YYYY-MM-DD') AS FT_END_DT" ).append("\n"); 
		query.append("                      ,CASE WHEN MAX(A.CNTR_TO_DT) - MAX(A.FT_END_DT) < 0" ).append("\n"); 
		query.append("                            THEN -FLOOR(ABS(MAX(A.CNTR_TO_DT) - MAX(A.FT_END_DT)))" ).append("\n"); 
		query.append("                            ELSE FLOOR(MAX(A.CNTR_TO_DT) - MAX(A.FT_END_DT)) END OVER_DYS" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.ORG_CHG_AMT), 0), 2) AS INC_AMT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.BIL_AMT), 0), 2) AS BIL_AMT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.INV_CHG_AMT), 0), 2) AS INV_CHG_AMT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.MRN_STO_WTHN), 0), 2) AS MRN_STO_WTHN" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.RAIL_STO_WTHN), 0), 2) AS RAIL_STO_WTHN" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.CNTR_EQ_WTHN), 0), 2) AS CNTR_EQ_WTHN" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.CHSS_ST_WTHN), 0), 2) AS CHSS_ST_WTHN" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.CHSS_COM_WTHN), 0), 2) AS CHSS_COM_WTHN" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.RF_HNDL_WTHN), 0), 2) AS RF_HNDL_WTHN" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.MRN_STO_WTHN) + SUM(A.RAIL_STO_WTHN) + SUM(A.CNTR_EQ_WTHN) + SUM(A.CHSS_ST_WTHN) + SUM(A.CHSS_COM_WTHN) + SUM(A.RF_HNDL_WTHN), 0), 2) AS COST_TTL_WTHN" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.MRN_STO_AFT), 0), 2) AS MRN_STO_AFT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.RAIL_STO_AFT), 0), 2) AS RAIL_STO_AFT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.CNTR_EQ_AFT), 0), 2) AS CNTR_EQ_AFT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.CHSS_ST_AFT), 0), 2) AS CHSS_ST_AFT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.CHSS_COM_AFT), 0), 2) AS CHSS_COM_AFT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.RF_HNDL_AFT), 0), 2) AS RF_HNDL_AFT" ).append("\n"); 
		query.append("                      ,ROUND(NVL(SUM(A.MRN_STO_AFT) + SUM(A.RAIL_STO_AFT) + SUM(A.CNTR_EQ_AFT) + SUM(A.CHSS_ST_AFT) + SUM(A.CHSS_COM_AFT) + SUM(A.RF_HNDL_AFT), 0), 2) AS COST_TTL_AFT" ).append("\n"); 
		query.append("                      ,SUM(A.STO_STATUS) AS STO_STATUS" ).append("\n"); 
		query.append("                      ,SUM(A.CNTR_STATUS) AS CNTR_STATUS" ).append("\n"); 
		query.append("                      ,SUM(A.CHSS_STATUS) AS CHSS_STATUS" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT BKG_NO" ).append("\n"); 
		query.append("                              ,CNTR_NO" ).append("\n"); 
		query.append("                              ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              ,SC_NO" ).append("\n"); 
		query.append("                              ,RFA_NO" ).append("\n"); 
		query.append("                              ,CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("                              ,CASE WHEN TRF_CD = ''" ).append("\n"); 
		query.append("                                    THEN ''" ).append("\n"); 
		query.append("                                    WHEN TRF_CD IN ('DTIC/CTIC', 'DMIF/CTIC', 'DMIF', 'DTIC', 'CTIC')" ).append("\n"); 
		query.append("                                    THEN 'I/B'" ).append("\n"); 
		query.append("                                    ELSE 'O/B' END IO_BND_CD" ).append("\n"); 
		query.append("                              ,CNTR_FM_DT" ).append("\n"); 
		query.append("                              ,CNTR_TO_DT" ).append("\n"); 
		query.append("                              ,CNTR_STAY_DYS" ).append("\n"); 
		query.append("                              ,FT_END_DT" ).append("\n"); 
		query.append("                              ,ORG_CHG_AMT" ).append("\n"); 
		query.append("                              ,BIL_AMT" ).append("\n"); 
		query.append("                              ,INV_CHG_AMT" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'MRN_STO', COST_WTHN_FT_AMT, 0) AS MRN_STO_WTHN" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'RAIL_STO', COST_WTHN_FT_AMT, 0) AS RAIL_STO_WTHN" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'CNTR_EQ', COST_WTHN_FT_AMT, 0) AS CNTR_EQ_WTHN" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'CHSS_ST', COST_WTHN_FT_AMT, 0) AS CHSS_ST_WTHN" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'CHSS_COM', COST_WTHN_FT_AMT, 0) AS CHSS_COM_WTHN" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'RF_HNDL', COST_WTHN_FT_AMT, 0) AS RF_HNDL_WTHN" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'MRN_STO', COST_AFT_FT_AMT, 0) AS MRN_STO_AFT" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'RAIL_STO', COST_AFT_FT_AMT, 0) AS RAIL_STO_AFT" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'CNTR_EQ', COST_AFT_FT_AMT, 0) AS CNTR_EQ_AFT" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'CHSS_ST', COST_AFT_FT_AMT, 0) AS CHSS_ST_AFT" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'CHSS_COM', COST_AFT_FT_AMT, 0) AS CHSS_COM_AFT" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(ITM_NM, 5), 'RF_HNDL', COST_AFT_FT_AMT, 0) AS RF_HNDL_AFT" ).append("\n"); 
		query.append("                              ,CASE WHEN (SELECT COUNT(1) FROM MAS_DMDT_COST_RPT_BKG_DTL D" ).append("\n"); 
		query.append("                                          WHERE D.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("                                            AND D.CNTR_NO = DTL.CNTR_NO" ).append("\n"); 
		query.append("                                            AND D.ITM_NM LIKE '%STO%'" ).append("\n"); 
		query.append("                                            AND D.CNTR_FM_MVMT_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("                                            AND D.CNTR_TO_MVMT_STS_CD IS NULL) = 0 THEN 1" ).append("\n"); 
		query.append("                                     ELSE 0" ).append("\n"); 
		query.append("                               END STO_STATUS" ).append("\n"); 
		query.append("                              ,CASE WHEN (SELECT COUNT(1) FROM MAS_DMDT_COST_RPT_BKG_DTL D" ).append("\n"); 
		query.append("                                          WHERE D.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("                                            AND D.CNTR_NO = DTL.CNTR_NO" ).append("\n"); 
		query.append("                                            AND D.ITM_NM LIKE '%CNTR%'" ).append("\n"); 
		query.append("                                            AND D.CNTR_FM_MVMT_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("                                            AND D.CNTR_TO_MVMT_STS_CD IS NULL) = 0 THEN 1" ).append("\n"); 
		query.append("                                     ELSE 0" ).append("\n"); 
		query.append("                               END CNTR_STATUS" ).append("\n"); 
		query.append("                              ,CASE WHEN (SELECT COUNT(1) FROM MAS_DMDT_COST_RPT_BKG_DTL D" ).append("\n"); 
		query.append("                                          WHERE D.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("                                            AND D.CNTR_NO = DTL.CNTR_NO" ).append("\n"); 
		query.append("                                            AND D.ITM_NM LIKE '%CHSS%'" ).append("\n"); 
		query.append("                                            AND D.CNTR_FM_MVMT_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("                                            AND D.CNTR_TO_MVMT_STS_CD IS NULL) = 0 THEN 1" ).append("\n"); 
		query.append("                                     ELSE 0" ).append("\n"); 
		query.append("                               END CHSS_STATUS" ).append("\n"); 
		query.append("                          FROM MAS_DMDT_COST_RPT_BKG_DTL DTL" ).append("\n"); 
		query.append("                          WHERE 1 = 1" ).append("\n"); 
		query.append("							AND NVL(DMDT_CHG_STS_CD, 'F') IN ('F', 'L', 'N', 'U', 'C', 'I')" ).append("\n"); 
		query.append("                            #if(${f_bkg_no} != '')" ).append("\n"); 
		query.append("                               AND BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_cntr_no} != '')" ).append("\n"); 
		query.append("                               AND CNTR_NO = @[f_cntr_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_cntr_ofc_cd} != '')" ).append("\n"); 
		query.append("                               AND CNTR_OFC_CD = @[f_cntr_ofc_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_por_cd} != '')" ).append("\n"); 
		query.append("                               AND POR_CD = @[f_por_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_del_cd} != '')" ).append("\n"); 
		query.append("                               AND DEL_CD = @[f_del_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                               AND CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_sc_no} != '')" ).append("\n"); 
		query.append("                               AND SC_NO = @[f_sc_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_rfa_no} != '')" ).append("\n"); 
		query.append("                               AND SC_NO = @[f_rfa_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if(${f_loc_cd} != '')" ).append("\n"); 
		query.append("                               AND CNTR_FM_NOD_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        ) A, MAS_BKG_EXPN_DTL B" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                         AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                         AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      #if(${f_year} != '')" ).append("\n"); 
		query.append("                         #if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("                         AND B.COST_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("                         #elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("                         AND B.SLS_YRMON     LIKE @[f_year]||@[f_sls_mon]||'%'" ).append("\n"); 
		query.append("                         AND B.COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                GROUP BY B.COST_YRMON" ).append("\n"); 
		query.append("                        ,B.COST_WK" ).append("\n"); 
		query.append("                        ,A.BKG_NO" ).append("\n"); 
		query.append("                        ,A.CNTR_NO" ).append("\n"); 
		query.append("                        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        ,A.SC_NO" ).append("\n"); 
		query.append("                        ,A.RFA_NO" ).append("\n"); 
		query.append("                        ,A.CNTR_FM_NOD_CD" ).append("\n"); 
		query.append("                        ,A.IO_BND_CD" ).append("\n"); 
		query.append("                ORDER BY B.COST_YRMON, B.COST_WK, A.BKG_NO, A.CNTR_NO, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ) M" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${f_status} != '')" ).append("\n"); 
		query.append("    #if(${f_status} == 'F')" ).append("\n"); 
		query.append("      AND (TTL_STATUS = 'Finished')" ).append("\n"); 
		query.append("    #elseif(${f_status} == 'U')" ).append("\n"); 
		query.append("      AND TTL_STATUS = 'Unfinished'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}