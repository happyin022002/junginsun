/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchCLMListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.05.12 김성욱
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

public class RailTransitReportDBDAOSearchCLMListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From RailTransitDBDAO
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchCLMListRSQL(){
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
		params.put("row_size",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_page",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchCLMListRSQL").append("\n"); 
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
		query.append("SELECT * FROM " ).append("\n"); 
		query.append("(SELECT  T2.*" ).append("\n"); 
		query.append("       , CEIL(ROWNUM/@[row_size]) PAGE" ).append("\n"); 
		query.append("  FROM (SELECT T1.*" ).append("\n"); 
		query.append("             , COUNT(1) OVER() TOT_CNT" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT CNTR_NO" ).append("\n"); 
		query.append("                     , CNMV_YR" ).append("\n"); 
		query.append("                     , CNMV_ID_NO" ).append("\n"); 
		query.append("                     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , FULL_MTY_CD" ).append("\n"); 
		query.append("                     , CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                     , LOC_CD" ).append("\n"); 
		query.append("                     , ARR_LOC_NM" ).append("\n"); 
		query.append("                     , ARR_STE_CD" ).append("\n"); 
		query.append("                     , ARR_DATE" ).append("\n"); 
		query.append("                     , ARR_TIME" ).append("\n"); 
		query.append("                     , ARR_DT" ).append("\n"); 
		query.append("                     , CLM_CRR_NM" ).append("\n"); 
		query.append("                     , TRSP_MOD_TP_CD" ).append("\n"); 
		query.append("                     , FM_NOD_CD" ).append("\n"); 
		query.append("                     , FM_STE_CD" ).append("\n"); 
		query.append("                     , TO_NOD_CD" ).append("\n"); 
		query.append("                     , TO_STE_CD" ).append("\n"); 
		query.append("                     , DEP_LOC_NM" ).append("\n"); 
		query.append("                     , TRN_NO" ).append("\n"); 
		query.append("                     , FCAR_NO" ).append("\n"); 
		query.append("                     , BKG_NO" ).append("\n"); 
		query.append("                     , WBL_NO" ).append("\n"); 
		query.append("                     , PKUP_NO" ).append("\n"); 
		query.append("                     , RCV_DT" ).append("\n"); 
		query.append("				FROM" ).append("\n"); 
		query.append("						(SELECT                      " ).append("\n"); 
		query.append("                               SC.CNTR_NO" ).append("\n"); 
		query.append("                             , SC.CNMV_YR" ).append("\n"); 
		query.append("                             , SC.CNMV_ID_NO" ).append("\n"); 
		query.append("                             , SC.CLM_SEQ" ).append("\n"); 
		query.append("                             , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , SC.FULL_MTY_CD FULL_MTY_CD" ).append("\n"); 
		query.append("                             , CLM_SGHT_ABBR_NM CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                             , SC.ARR_LOC LOC_CD" ).append("\n"); 
		query.append("                             , SC.ARR_LOC_NM ARR_LOC_NM" ).append("\n"); 
		query.append("                             , SC.ARR_STE_CD ARR_STE_CD" ).append("\n"); 
		query.append("                             , TO_CHAR(SC.ARR_DT, 'YYYY-MM-DD') ARR_DATE" ).append("\n"); 
		query.append("                             , TO_CHAR(SC.ARR_DT, 'HH24:MI') ARR_TIME" ).append("\n"); 
		query.append("                             , SC.ARR_DT" ).append("\n"); 
		query.append("                             , SC.CLM_CRR_NM CLM_CRR_NM" ).append("\n"); 
		query.append("                             , SC.TRSP_MOD_TP_CD TRSP_MOD_TP_CD" ).append("\n"); 
		query.append("                             , SRSF.YD_CD FM_NOD_CD" ).append("\n"); 
		query.append("                             , SC.ARR_STE_CD TO_STE_CD" ).append("\n"); 
		query.append("                             , SRST.YD_CD TO_NOD_CD" ).append("\n"); 
		query.append("                             , SC.DEP_STE_CD FM_STE_CD" ).append("\n"); 
		query.append("                             , SC.DEP_LOC_NM DEP_LOC_NM" ).append("\n"); 
		query.append("                             , '' DEP_CTY_NM" ).append("\n"); 
		query.append("                             , SC.TRN_NO TRN_NO" ).append("\n"); 
		query.append("                             , SC.FCAR_NO FCAR_NO" ).append("\n"); 
		query.append("                             , SC.BKG_NO BKG_NO" ).append("\n"); 
		query.append("                             , SC.WBL_NO WBL_NO" ).append("\n"); 
		query.append("                             , SC.PKUP_NO" ).append("\n"); 
		query.append("                             , SC.RCV_DT" ).append("\n"); 
		query.append("                          FROM (SELECT " ).append("\n"); 
		query.append("                                      CNTR_NO" ).append("\n"); 
		query.append("                                     , CNMV_YR" ).append("\n"); 
		query.append("                                     , CNMV_ID_NO" ).append("\n"); 
		query.append("                                     , CLM_SEQ" ).append("\n"); 
		query.append("                                     , CMC.FULL_MTY_CD FULL_MTY_CD" ).append("\n"); 
		query.append("                                     , SCS.CLM_SGHT_ABBR_NM CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("                                     , CMC.ARR_DT ARR_DT" ).append("\n"); 
		query.append("                                     , CMC.ARR_LOC_NM ARR_LOC" ).append("\n"); 
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
		query.append("                                     , '' EVNT_CTY_NM" ).append("\n"); 
		query.append("                                     , '' DEST_LOC" ).append("\n"); 
		query.append("                                     , '' BKG_NO" ).append("\n"); 
		query.append("                                     , '' WBL_NO" ).append("\n"); 
		query.append("                                     , '' PKUP_NO" ).append("\n"); 
		query.append("                                     , CMC.UPD_DT RCV_DT" ).append("\n"); 
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
		query.append("						UNION ALL" ).append("\n"); 
		query.append("                        SELECT " ).append("\n"); 
		query.append("							 EDI.EQ_NO CNTR_NO" ).append("\n"); 
		query.append("							 , '' CNMV_YR" ).append("\n"); 
		query.append("							 , 1 CNMV_ID_NO" ).append("\n"); 
		query.append("							 , 1 CLM_SEQ" ).append("\n"); 
		query.append("							 , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("							 , '' FULL_MTY_CD" ).append("\n"); 
		query.append("							 , NVL(COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD30032',EDI_322_STS_CD), EDI_322_STS_CD) CLM_SGHT_ABBR_NM" ).append("\n"); 
		query.append("							 , EDI.EVNT_YD_CD ARR_LOC" ).append("\n"); 
		query.append("							 , EDI.EVNT_CTY_NM ARR_LOC_NM -- current city name description" ).append("\n"); 
		query.append("							 , EDI.EVNT_STE_CD ARR_STE_CD  -- current state " ).append("\n"); 
		query.append("							 , TO_CHAR(EVNT_DT, 'YYYY-MM-DD') ARR_DATE" ).append("\n"); 
		query.append("							 , TO_CHAR(EVNT_DT, 'HH24:MI') ARR_TIME" ).append("\n"); 
		query.append("                             , EVNT_DT ARR_DT" ).append("\n"); 
		query.append("							 , EDI.SNDR_ID CLM_CRR_NM" ).append("\n"); 
		query.append("							 , 'R' TRSP_MOD_TP_CD" ).append("\n"); 
		query.append("							 , '' FM_MOD_CD" ).append("\n"); 
		query.append("							 , DEST_STE_NM TO_STE_CD -- destination state name" ).append("\n"); 
		query.append("							 , DEST_LOC_NM TO_NOD_CD -- Destination name" ).append("\n"); 
		query.append("							 , '' FM_STE_CD" ).append("\n"); 
		query.append("							 , DEST_CTY_NM DEP_LOC_NM -- Destination name" ).append("\n"); 
		query.append("							 , DEST_CTY_NM DEP_CTY_NM" ).append("\n"); 
		query.append("							 , '' TRN_NO" ).append("\n"); 
		query.append("							 , FCAR_NO FCAR_NO" ).append("\n"); 
		query.append("							 , NVL(BKG_EDI_322_NO, BL_EDI_322_NO) BKG_NO" ).append("\n"); 
		query.append("							 , WBL_NO WBL_NO" ).append("\n"); 
		query.append("                             , PKUP_EDI_322_NO  PKUP_NO" ).append("\n"); 
		query.append("                             , EDI.UPD_DT RCV_DT" ).append("\n"); 
		query.append("						  FROM " ).append("\n"); 
		query.append("							   SCE_RAIL_SPLC RSS" ).append("\n"); 
		query.append("							 , EDI_322_MSG EDI" ).append("\n"); 
		query.append("							 , MST_CONTAINER MC" ).append("\n"); 
		query.append("						 WHERE 1 = 1" ).append("\n"); 
		query.append("						   AND EDI.EQ_NO = @[cntr_no] -- Param" ).append("\n"); 
		query.append("						   AND EDI.EQ_NO = MC.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${arr_dt1} != '')" ).append("\n"); 
		query.append("						   AND EDI.EVNT_DT >= TO_DATE(@[arr_dt1], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("						   AND EDI.EVNT_DT < TO_DATE(@[arr_dt2], 'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						   AND EDI.EVNT_YD_CD = RSS.YD_CD(+)" ).append("\n"); 
		query.append("						   AND EDI.SNDR_ID = RSS.SPLC_VNDR_NM(+)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("                ) T1 " ).append("\n"); 
		query.append(" ORDER BY ARR_DT DESC, RCV_DT DESC" ).append("\n"); 
		query.append("        ) T2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" WHERE PAGE = @[i_page]" ).append("\n"); 

	}
}