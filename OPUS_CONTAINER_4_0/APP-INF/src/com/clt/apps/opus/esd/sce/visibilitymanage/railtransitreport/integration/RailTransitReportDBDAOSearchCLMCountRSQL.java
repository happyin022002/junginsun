/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchCLMCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.21
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.09.21 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchCLMCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From RailTransiteReportDBDAO
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchCLMCountRSQL(){
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
		params.put("arr_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchCLMCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) tot_cnt" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT CNTR_NO" ).append("\n"); 
		query.append("                     , CNMV_YR" ).append("\n"); 
		query.append("                     , CNMV_ID_NO" ).append("\n"); 
		query.append("                     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , FULL_MTY_CD" ).append("\n"); 
		query.append("                     , CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                     , LOC_CD" ).append("\n"); 
		query.append("                     , ARR_STE_CD" ).append("\n"); 
		query.append("                     , ARR_DATE" ).append("\n"); 
		query.append("                     , ARR_TIME" ).append("\n"); 
		query.append("                     , CLM_CRR_NM" ).append("\n"); 
		query.append("                     , TRSP_MOD_TP_CD" ).append("\n"); 
		query.append("                     , FM_NOD_CD" ).append("\n"); 
		query.append("                     , FM_STE_CD" ).append("\n"); 
		query.append("                     , TO_NOD_CD" ).append("\n"); 
		query.append("                     , TO_STE_CD" ).append("\n"); 
		query.append("                     , DEP_LOC_NM" ).append("\n"); 
		query.append("                     , TRN_NO" ).append("\n"); 
		query.append("                     , FCAR_NO" ).append("\n"); 
		query.append("                  FROM (SELECT SC.CNTR_NO" ).append("\n"); 
		query.append("                             , SC.CNMV_YR" ).append("\n"); 
		query.append("                             , SC.CNMV_ID_NO" ).append("\n"); 
		query.append("                             , SC.CLM_SEQ" ).append("\n"); 
		query.append("                             , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , SC.FULL_MTY_CD FULL_MTY_CD" ).append("\n"); 
		query.append("                             , CLM_SGHT_ABBR_NM CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                             , CASE WHEN SRST.LOC_CD IS NULL THEN SC.ARR_LOC_NM" ).append("\n"); 
		query.append("                                    ELSE SC.ARR_LOC_NM||' ('||SRST.LOC_CD||')'" ).append("\n"); 
		query.append("                               END LOC_CD" ).append("\n"); 
		query.append("                             , SC.ARR_STE_CD ARR_STE_CD" ).append("\n"); 
		query.append("                             , TO_CHAR(SC.ARR_DT, 'YYYY-MM-DD') ARR_DATE" ).append("\n"); 
		query.append("                             , TO_CHAR(SC.ARR_DT, 'HH24:MI') ARR_TIME" ).append("\n"); 
		query.append("                             , SC.CLM_CRR_NM CLM_CRR_NM" ).append("\n"); 
		query.append("                             , SC.TRSP_MOD_TP_CD TRSP_MOD_TP_CD" ).append("\n"); 
		query.append("                             , SRSF.YD_CD FM_NOD_CD" ).append("\n"); 
		query.append("                             , SC.ARR_STE_CD FM_STE_CD" ).append("\n"); 
		query.append("                             , SRST.YD_CD TO_NOD_CD" ).append("\n"); 
		query.append("                             , SC.DEP_STE_CD TO_STE_CD" ).append("\n"); 
		query.append("                             , SC.DEP_LOC_NM DEP_LOC_NM" ).append("\n"); 
		query.append("                             , SC.TRN_NO TRN_NO" ).append("\n"); 
		query.append("                             , SC.FCAR_NO FCAR_NO" ).append("\n"); 
		query.append("                          FROM (SELECT " ).append("\n"); 
		query.append("                                      CNTR_NO" ).append("\n"); 
		query.append("                                     , CNMV_YR" ).append("\n"); 
		query.append("                                     , CNMV_ID_NO" ).append("\n"); 
		query.append("                                     , CLM_SEQ" ).append("\n"); 
		query.append("                                     , CMC.FULL_MTY_CD FULL_MTY_CD" ).append("\n"); 
		query.append("                                     , SCS.CLM_SGHT_ABBR_NM CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                                     , CMC.ARR_DT ARR_DT" ).append("\n"); 
		query.append("                                     , CMC.ARR_LOC_NM ARR_LOC_NM" ).append("\n"); 
		query.append("                                     , CMC.ARR_STE_CD ARR_STE_CD" ).append("\n"); 
		query.append("                                     , CMC.CLM_CRR_NM CLM_CRR_NM" ).append("\n"); 
		query.append("                                     , CMC.TRSP_MOD_TP_CD TRSP_MOD_TP_CD" ).append("\n"); 
		query.append("                                     , CMC.DEP_STE_CD DEP_STE_CD" ).append("\n"); 
		query.append("                                     , CMC.TRN_NO TRN_NO" ).append("\n"); 
		query.append("                                     , CMC.FCAR_NO FCAR_NO" ).append("\n"); 
		query.append("                                     , CMC.CLM_SGHT_CD CLM_SGHT_CD" ).append("\n"); 
		query.append("                                     , CMC.ARR_SPLC_CD ARR_SPLC_CD" ).append("\n"); 
		query.append("                                     , CMC.DEP_LOC_NM DEP_LOC_NM" ).append("\n"); 
		query.append("                                     , CMC.DEP_SPLC_CD DEP_SPLC_CD" ).append("\n"); 
		query.append("                                     , '' EVNT_YD_CD" ).append("\n"); 
		query.append("                                  FROM SCE_CLM_IF CMC" ).append("\n"); 
		query.append("                                     , SCE_CLM_SGHT SCS" ).append("\n"); 
		query.append("                                 WHERE 1 =1" ).append("\n"); 
		query.append("                                   AND CMC.CNTR_NO = @[cntr_no] -- Param" ).append("\n"); 
		query.append("                                   AND CMC.SO_MAPG_STS_CD != '52'" ).append("\n"); 
		query.append("#if (${arr_dt1} != '')" ).append("\n"); 
		query.append("                                   AND CMC.ARR_DT >= TO_DATE(@[arr_dt1], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                   AND CMC.ARR_DT < TO_DATE(@[arr_dt2], 'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND CMC.CLM_SGHT_CD = SCS.CLM_SGHT_CD(+)" ).append("\n"); 
		query.append("                                   " ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT EDI.EQ_NO CNTR_NO" ).append("\n"); 
		query.append("                                     , '' CNMV_YR" ).append("\n"); 
		query.append("                                     , 1 CNMV_ID_NO" ).append("\n"); 
		query.append("                                     , 1 CLM_SEQ" ).append("\n"); 
		query.append("                                     , '' FULL_MTY_CD" ).append("\n"); 
		query.append("                                     , NVL(COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD30032',EDI_322_STS_CD), EDI_322_STS_CD) CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                                     , EDI.EVNT_DT ARR_DT" ).append("\n"); 
		query.append("                                     , EDI.EVNT_CTY_NM ARR_LOC_NM" ).append("\n"); 
		query.append("                                     , EDI.EVNT_STE_CD ARR_STE_CD" ).append("\n"); 
		query.append("                                     , EDI.SNDR_ID CLM_CRR_NM" ).append("\n"); 
		query.append("                                     , 'R' TRSP_MOD_TP_CD" ).append("\n"); 
		query.append("                                     , '' DEP_STE_CD" ).append("\n"); 
		query.append("                                     , '' TRN_NO" ).append("\n"); 
		query.append("                                     , '' FCAR_NO" ).append("\n"); 
		query.append("                                     , EDI.EDI_322_STS_CD CLM_SGHT_CD" ).append("\n"); 
		query.append("                                     , RSS.SPLC_CD ARR_SPLC_CD" ).append("\n"); 
		query.append("                                     , '' DEP_LOC_NM" ).append("\n"); 
		query.append("                                     , ''" ).append("\n"); 
		query.append("                                     , EDI.EVNT_YD_CD EVNT_YD_CD" ).append("\n"); 
		query.append("                                  FROM SCE_RAIL_SPLC RSS" ).append("\n"); 
		query.append("                                     , EDI_322_MSG EDI" ).append("\n"); 
		query.append("                                 WHERE 1 = 1" ).append("\n"); 
		query.append("                                   AND EDI.EQ_NO = @[cntr_no] -- Param" ).append("\n"); 
		query.append("#if (${arr_dt1} != '')" ).append("\n"); 
		query.append("                                   AND EDI.EVNT_DT >= TO_DATE(@[arr_dt1], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                   AND EDI.EVNT_DT < TO_DATE(@[arr_dt2], 'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND EDI.EVNT_YD_CD = RSS.YD_CD(+)" ).append("\n"); 
		query.append("                                   AND EDI.SNDR_ID = RSS.SPLC_VNDR_NM(+)  " ).append("\n"); 
		query.append("                                ) SC" ).append("\n"); 
		query.append("                              , SCE_RAIL_SPLC SRSF" ).append("\n"); 
		query.append("                              , SCE_RAIL_SPLC SRST" ).append("\n"); 
		query.append("                              , MST_CONTAINER MC" ).append("\n"); 
		query.append("                         WHERE SC.ARR_SPLC_CD = SRST.SPLC_CD(+)" ).append("\n"); 
		query.append("                           AND SC.CNTR_NO = MC.CNTR_NO(+)" ).append("\n"); 
		query.append("                           AND SC.DEP_SPLC_CD = SRSF.SPLC_CD(+) " ).append("\n"); 
		query.append("                           AND SC.CLM_CRR_NM = SRST.SPLC_VNDR_NM(+)" ).append("\n"); 
		query.append("                           AND SC.CLM_CRR_NM = SRSF.SPLC_VNDR_NM(+)" ).append("\n"); 
		query.append("                           AND SC.EVNT_YD_CD = SRST.YD_CD(+)" ).append("\n"); 
		query.append("                       ORDER BY TO_CHAR(SC.ARR_DT, 'YYYY-MM-DD'), TO_CHAR(SC.ARR_DT, 'HH24:MI')" ).append("\n"); 
		query.append("        			)" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}