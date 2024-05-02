/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAOSearchAmendPortionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanGuidelineManageDBDAOSearchAmendPortionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Amend의 Portion조회
	  * - CHM-201534846, 신용찬, 2015-03-19, TRADE=IAS 인 경우는 POL_CD 는 조건에서 제외. 
	  * </pre>
	  */
	public CntrPlanGuidelineManageDBDAOSearchAmendPortionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eff_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration").append("\n"); 
		query.append("FileName : CntrPlanGuidelineManageDBDAOSearchAmendPortionRSQL").append("\n"); 
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
		query.append("SELECT	@[trade] TRD_CD" ).append("\n"); 
		query.append("        ,SUBSTR(@[subtrade],4,2) SUB_TRD_CD" ).append("\n"); 
		query.append("        --,SUBSTR([lane],6) VSL_LANE_CD" ).append("\n"); 
		query.append("        ,@[lane] VSL_LANE_CD" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("        ,@[s_vvd_cd] VVD" ).append("\n"); 
		query.append("        ,@[s_pol_cd] POL_CD" ).append("\n"); 
		query.append("        ,@[s_eta_dt] ETA_DT" ).append("\n"); 
		query.append("		,'%' POD_CD " ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D2 / TOT_VOL) * 100),0,'',ROUND((D2 / TOT_VOL) * 100)) QTY_D2" ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D2 / TOT_VOL) * 100),0,'','P') UT_D2" ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D4 / TOT_VOL) * 100),0,'',ROUND((D4 / TOT_VOL) * 100)) QTY_D4" ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D4 / TOT_VOL) * 100),0,'','P') UT_D4" ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D5 / TOT_VOL) * 100),0,'',ROUND((D5 / TOT_VOL) * 100)) QTY_D5" ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D5 / TOT_VOL) * 100),0,'','P') UT_D5" ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D7 / TOT_VOL) * 100),0,'',ROUND((D7 / TOT_VOL) * 100)) QTY_D7" ).append("\n"); 
		query.append("	  	,DECODE(ROUND((D7 / TOT_VOL) * 100),0,'','P') UT_D7" ).append("\n"); 
		query.append("	  	,'' QTY_R2" ).append("\n"); 
		query.append("	  	,'' UT_R2" ).append("\n"); 
		query.append("	  	,'' QTY_R5" ).append("\n"); 
		query.append("	  	,'' UT_R5" ).append("\n"); 
		query.append("	  	,'' QTY_R9" ).append("\n"); 
		query.append("	  	,'' UT_R9" ).append("\n"); 
		query.append("	  	,'' QTY_O2" ).append("\n"); 
		query.append("	  	,'' UT_O2" ).append("\n"); 
		query.append("	  	,'' QTY_O4" ).append("\n"); 
		query.append("	  	,'' UT_O4" ).append("\n"); 
		query.append("	  	,'' QTY_O5" ).append("\n"); 
		query.append("	  	,'' UT_O5" ).append("\n"); 
		query.append("	  	,'' QTY_S2" ).append("\n"); 
		query.append("	  	,'' UT_S2" ).append("\n"); 
		query.append("	  	,'' QTY_S4" ).append("\n"); 
		query.append("	  	,'' UT_S4" ).append("\n"); 
		query.append("	  	,'' QTY_F2" ).append("\n"); 
		query.append("	  	,'' UT_F2" ).append("\n"); 
		query.append("	  	,'' QTY_F4" ).append("\n"); 
		query.append("	  	,'' UT_F4" ).append("\n"); 
		query.append("	  	,'' QTY_F5" ).append("\n"); 
		query.append("	  	,'' UT_F5" ).append("\n"); 
		query.append("	  	,'' QTY_A2" ).append("\n"); 
		query.append("	  	,'' UT_A2" ).append("\n"); 
		query.append("	  	,'' QTY_A4" ).append("\n"); 
		query.append("	  	,'' UT_A4" ).append("\n"); 
		query.append("        ,'' QTY_A5" ).append("\n"); 
		query.append("	  	,'' UT_A5" ).append("\n"); 
		query.append("		,' ' REPO_GLINE_RMK" ).append("\n"); 
		query.append("		,SYSDATE UPD_DT" ).append("\n"); 
		query.append("		,'' UPD_USR_NM" ).append("\n"); 
		query.append("		,'' UPD_USR_ID" ).append("\n"); 
		query.append("		,'N' CFM_FLG" ).append("\n"); 
		query.append("        ,@[s_eff_st_dt] EFF_ST_DT" ).append("\n"); 
		query.append("		,'' COL_DIV" ).append("\n"); 
		query.append("		,SUBSTR(@[s_vvd_cd],1,4) VSL_CD" ).append("\n"); 
		query.append("		,SUBSTR(@[s_vvd_cd],5,4)SKD_VOY_NO" ).append("\n"); 
		query.append("		,SUBSTR(@[s_vvd_cd],9)SKD_DIR_CD" ).append("\n"); 
		query.append("		,'2' SORT_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(      " ).append("\n"); 
		query.append("    SELECT A.SLAN_CD" ).append("\n"); 
		query.append("          ,COUNT(1) TOT_VOL" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD, 'D2', 1, 0)) D2" ).append("\n"); 
		query.append("		  ,SUM(DECODE(A.CNTR_TPSZ_CD, 'D4', 1, 0)) D4" ).append("\n"); 
		query.append("		  ,SUM(DECODE(A.CNTR_TPSZ_CD, 'D5', 1, 0)) D5" ).append("\n"); 
		query.append("		  ,SUM(DECODE(A.CNTR_TPSZ_CD, 'D7', 1, 0)) D7" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT A.BKG_NO" ).append("\n"); 
		query.append("              ,A.POL_CD" ).append("\n"); 
		query.append("              ,A.POD_CD" ).append("\n"); 
		query.append("              ,A.BKG_STS_CD" ).append("\n"); 
		query.append("              ,A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,A.SLAN_CD" ).append("\n"); 
		query.append("              ,A.VSL_CD" ).append("\n"); 
		query.append("              ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,C.CNTR_NO" ).append("\n"); 
		query.append("              ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        FROM BKG_BOOKING A" ).append("\n"); 
		query.append("		    ,BKG_CONTAINER C" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("		AND   A.BKG_CRE_DT BETWEEN SYSDATE - 86 AND SYSDATE -- 8주+30일" ).append("\n"); 
		query.append("        AND   A.BKG_CRE_DT BETWEEN TO_DATE(@[h_eta_dt], 'YYYYMMDD')-30 AND SYSDATE -- 쿼리 속도향상 위한 조건" ).append("\n"); 
		query.append("        AND   NVL(A.BKG_STS_CD, ' ')  = 'F'      -- 하드코딩, ACTIVE" ).append("\n"); 
		query.append("        --AND   A.SLAN_CD               = SUBSTR([lane],6,3)  -- 입력값, LANE" ).append("\n"); 
		query.append("        AND   A.SLAN_CD               = @[lane]" ).append("\n"); 
		query.append("        AND   A.BKG_CGO_TP_CD         = 'P'      -- 하드코딩, EMPTY BKG" ).append("\n"); 
		query.append("		AND   C.CNTR_TPSZ_CD         IN ('D2','D4','D5','D7')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -- TRADE=IAS 인 경우는 POL_CD 는 조건에서 제외. CHM-201534846, 신용찬, 2015-03-19" ).append("\n"); 
		query.append("#if (${trade} != 'IAS')         " ).append("\n"); 
		query.append("        AND   A.POL_CD IN (" ).append("\n"); 
		query.append("                                SELECT LOC_CD " ).append("\n"); 
		query.append("                                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                WHERE CONTI_CD      <> 'A'  -- 하드코딩, ASIA 제외" ).append("\n"); 
		query.append("                                AND   CALL_PORT_FLG = 'Y'   -- 하드코딩, PORT 만 검색" ).append("\n"); 
		query.append("                                AND   DELT_FLG      = 'N'   -- 하드코딩, DELT 제거" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND   A.POD_CD IN (" ).append("\n"); 
		query.append("                                SELECT LOC_CD " ).append("\n"); 
		query.append("                                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                WHERE CONTI_CD      = 'A'  -- 하드코딩, ASIA 제외" ).append("\n"); 
		query.append("                                AND   CALL_PORT_FLG = 'Y'   -- 하드코딩, PORT 만 검색" ).append("\n"); 
		query.append("                                AND   DELT_FLG      = 'N'   -- 하드코딩, DELT 제거" ).append("\n"); 
		query.append("                         ) " ).append("\n"); 
		query.append("    ) A                 " ).append("\n"); 
		query.append("    GROUP BY A.SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}