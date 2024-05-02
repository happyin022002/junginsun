/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CsScreenDBDAOsearchCntrClmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchCntrClmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US I/B CS Screen에서 B/L No 기준으로 Estimate + Actual Container Movement Detail 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchCntrClmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchCntrClmInfoRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO              AS CNTR_NO" ).append("\n"); 
		query.append("      ,CS.CLM_SGHT_ABBR_NM  AS MVMT_STS_NM" ).append("\n"); 
		query.append("      ,MVMT_EVNT_DT         AS MVMT_EVNT_DT" ).append("\n"); 
		query.append("      ,ORG_YD_CD            AS ORG_YD_CD" ).append("\n"); 
		query.append("      ,DEST_YD_CD           AS DEST_YD_CD" ).append("\n"); 
		query.append("      ,CLM_CRR_NM           AS CLM_CRR_NM" ).append("\n"); 
		query.append("      ,TRN_NO               AS TRN_NO" ).append("\n"); 
		query.append("      ,FCAR_NO              AS FCAR_NO " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT CL.CNTR_NO                                       AS CNTR_NO" ).append("\n"); 
		query.append("          ,TO_CHAR(CL.ARR_DT, 'YYYY/MM/DD HH24:MI')         AS MVMT_EVNT_DT" ).append("\n"); 
		query.append("          ,CL.ARR_LOC_NM|| '  ' ||CL.ARR_STE_CD             AS ORG_YD_CD" ).append("\n"); 
		query.append("          ,CL.DEP_LOC_NM|| '  ' ||CL.DEP_STE_CD             AS DEST_YD_CD" ).append("\n"); 
		query.append("          ,CL.CLM_CRR_NM                                    AS CLM_CRR_NM" ).append("\n"); 
		query.append("          ,CL.TRN_NO                                        AS TRN_NO" ).append("\n"); 
		query.append("          ,CL.FCAR_NO                                       AS FCAR_NO " ).append("\n"); 
		query.append("           ,CL.CLM_SGHT_CD " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT  BCNTR.BKG_NO" ).append("\n"); 
		query.append("                  ,BCNTR.CNTR_NO " ).append("\n"); 
		query.append("                  , ( SELECT /*+ INDEX_DESC ( MVMT XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                          TO_CHAR(CNMV_EVNT_DT,'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("                     FROM CTM_MOVEMENT MVMT" ).append("\n"); 
		query.append("                     WHERE MVMT.BKG_NO = BCNTR.BKG_NO    " ).append("\n"); 
		query.append("                       AND MVMT.CNTR_NO = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("                       AND MVMT.CNMV_CYC_NO = BCNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                       AND MVMT.MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) FROM_DT" ).append("\n"); 
		query.append("                 , ( SELECT /*+ INDEX_DESC ( MVMT XPKCTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                            DECODE( COUNT(CNMV_EVNT_DT),0, TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI'),MAX( TO_CHAR(CNMV_EVNT_DT,'YYYY/MM/DD HH24:MI') ) ) " ).append("\n"); 
		query.append("                     FROM CTM_MOVEMENT MVMT" ).append("\n"); 
		query.append("                     WHERE MVMT.BKG_NO = BCNTR.BKG_NO    " ).append("\n"); 
		query.append("                       AND MVMT.CNTR_NO = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("                       AND MVMT.CNMV_CYC_NO = BCNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                       AND MVMT.MVMT_STS_CD = 'MT' " ).append("\n"); 
		query.append("                       AND ROWNUM = 1      " ).append("\n"); 
		query.append("                   ) TO_DT" ).append("\n"); 
		query.append("           FROM BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("           WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND   CNTR_NO = @[cntr_no]   " ).append("\n"); 
		query.append("         ) SUB_MAIN" ).append("\n"); 
		query.append("         , SCE_CLM CL" ).append("\n"); 
		query.append("    WHERE  CL.CNTR_NO = SUB_MAIN.CNTR_NO" ).append("\n"); 
		query.append("       AND CL.ARR_DT >=  TO_DATE(SUB_MAIN.FROM_DT, 'YYYY/MM/DD HH24:MI') " ).append("\n"); 
		query.append("       AND CL.ARR_DT <=  TO_DATE(SUB_MAIN.TO_DT, 'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT CI.CNTR_NO                                       AS CNTR_NO" ).append("\n"); 
		query.append("          ,TO_CHAR(CI.ARR_DT, 'YYYY/MM/DD HH24:MI')         AS MVMT_EVNT_DT" ).append("\n"); 
		query.append("          ,CI.ARR_LOC_NM|| '  ' ||CI.ARR_STE_CD             AS ORG_YD_CD" ).append("\n"); 
		query.append("          ,CI.DEP_LOC_NM|| '  ' ||CI.DEP_STE_CD             AS DEST_YD_CD" ).append("\n"); 
		query.append("          ,CI.CLM_CRR_NM                                    AS CLM_CRR_NM" ).append("\n"); 
		query.append("          ,CI.TRN_NO                                        AS TRN_NO" ).append("\n"); 
		query.append("          ,CI.FCAR_NO                                       AS FCAR_NO  " ).append("\n"); 
		query.append("          ,CI.CLM_SGHT_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT  BCNTR.BKG_NO" ).append("\n"); 
		query.append("                  ,BCNTR.CNTR_NO " ).append("\n"); 
		query.append("                  , ( SELECT /*+ INDEX_DESC ( MVMT XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                          TO_CHAR(CNMV_EVNT_DT,'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("                     FROM CTM_MOVEMENT MVMT" ).append("\n"); 
		query.append("                     WHERE MVMT.BKG_NO = BCNTR.BKG_NO    " ).append("\n"); 
		query.append("                       AND MVMT.CNTR_NO = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("                       AND MVMT.CNMV_CYC_NO = BCNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                       AND MVMT.MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) FROM_DT" ).append("\n"); 
		query.append("                 , ( SELECT /*+ INDEX_DESC ( MVMT XPKCTM_MOVEMENT) */ " ).append("\n"); 
		query.append("                            DECODE( COUNT(CNMV_EVNT_DT),0, TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI'),MAX( TO_CHAR(CNMV_EVNT_DT,'YYYY/MM/DD HH24:MI') ) ) " ).append("\n"); 
		query.append("                     FROM CTM_MOVEMENT MVMT" ).append("\n"); 
		query.append("                     WHERE MVMT.BKG_NO = BCNTR.BKG_NO    " ).append("\n"); 
		query.append("                       AND MVMT.CNTR_NO = BCNTR.CNTR_NO " ).append("\n"); 
		query.append("                       AND MVMT.CNMV_CYC_NO = BCNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("                       AND MVMT.MVMT_STS_CD = 'MT' " ).append("\n"); 
		query.append("                       AND ROWNUM = 1      " ).append("\n"); 
		query.append("                   ) TO_DT" ).append("\n"); 
		query.append("           FROM BKG_CONTAINER BCNTR" ).append("\n"); 
		query.append("           WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND   CNTR_NO = @[cntr_no]     " ).append("\n"); 
		query.append("         ) SUB_MAIN" ).append("\n"); 
		query.append("         , SCE_CLM_IF CI" ).append("\n"); 
		query.append("    WHERE  CI.CNTR_NO = SUB_MAIN.CNTR_NO" ).append("\n"); 
		query.append("       AND CI.ARR_DT >=  TO_DATE(SUB_MAIN.FROM_DT, 'YYYY/MM/DD HH24:MI') " ).append("\n"); 
		query.append("       AND CI.ARR_DT <=  TO_DATE(SUB_MAIN.TO_DT, 'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("       	AND   CI.SO_MAPG_STS_CD != '52'" ).append("\n"); 
		query.append(")SUB_MAIN, SCE_CLM_SGHT CS  " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CS.CLM_SGHT_CD(+) = SUB_MAIN.CLM_SGHT_CD" ).append("\n"); 
		query.append("ORDER BY 3 DESC" ).append("\n"); 

	}
}