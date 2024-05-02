/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOCreateVslLayupWeekCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCreateVslLayupWeekCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Detail Cost 테이블에서 source주를 복사해서 target데이터를 생성한다
	  * </pre>
	  */
	public CommonDBDAOCreateVslLayupWeekCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCreateVslLayupWeekCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_MNL_DTL_COST" ).append("\n"); 
		query.append(" SELECT B.YYYY_MM" ).append("\n"); 
		query.append("      , B.COST_WK" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , A.STND_COST_CD" ).append("\n"); 
		query.append("      , DECODE(B.SUN, NULL, 0, SUN_COST_AMT) SUN_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(B.MON, NULL, 0, MON_COST_AMT) MON_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(B.TUE, NULL, 0, TUE_COST_AMT) TUE_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(B.WED, NULL, 0, WED_COST_AMT) WED_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(B.THU, NULL, 0, THU_COST_AMT) THU_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(B.FRI, NULL, 0, FRI_COST_AMT) FRI_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(B.SAT, NULL, 0, SAT_COST_AMT) SAT_COST_AMT" ).append("\n"); 
		query.append("      , DECODE(B.SUN, NULL, 0, SUN_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.MON, NULL, 0, MON_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.TUE, NULL, 0, TUE_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.WED, NULL, 0, WED_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.THU, NULL, 0, THU_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.FRI, NULL, 0, FRI_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.SAT, NULL, 0, SAT_COST_AMT) TTL_AMT" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[user_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,A.DP_SEQ" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT SUBSTR(REPLACE(@[f_tar_week],'-',''),1,4) AS COST_YR" ).append("\n"); 
		query.append("              , SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2) COST_WK" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,VSL_CD" ).append("\n"); 
		query.append("            ,STND_COST_CD" ).append("\n"); 
		query.append("            ,SUM(SUN_COST_AMT) AS SUN_COST_AMT" ).append("\n"); 
		query.append("            ,SUM(MON_COST_AMT) AS MON_COST_AMT" ).append("\n"); 
		query.append("            ,SUM(TUE_COST_AMT) AS TUE_COST_AMT" ).append("\n"); 
		query.append("            ,SUM(WED_COST_AMT) AS WED_COST_AMT" ).append("\n"); 
		query.append("            ,SUM(THU_COST_AMT) AS THU_COST_AMT" ).append("\n"); 
		query.append("            ,SUM(FRI_COST_AMT) AS FRI_COST_AMT" ).append("\n"); 
		query.append("            ,SUM(SAT_COST_AMT) AS SAT_COST_AMT" ).append("\n"); 
		query.append("            ,SUM(TTL_AMT) AS TTL_AMT" ).append("\n"); 
		query.append("            ,DP_SEQ" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT (SUBSTR(COST_YRMON,1,4)||COST_WK) AS COST_YRMON" ).append("\n"); 
		query.append("                ,COST_WK" ).append("\n"); 
		query.append("                ,RLANE_CD" ).append("\n"); 
		query.append("                ,'' AS VSL_CD_TTL" ).append("\n"); 
		query.append("                ,VSL_CD" ).append("\n"); 
		query.append("                ,STND_COST_CD" ).append("\n"); 
		query.append("                ,(CASE WHEN STND_COST_CD='43101011' THEN 'Vessel Charter Revenue'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='53101000' THEN 'Port EXP'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='53102000' THEN 'Canal Transit Fee'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='53200000' THEN 'Bunker'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54100000' THEN 'Crew EXP'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54250000' THEN 'Insurance'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54300000' THEN 'Lubricant EXP'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54200000' THEN 'Store Supply EXP'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54150000' THEN 'Vessel M&R'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54450000' THEN 'Depreciations'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54180000' THEN 'Telecom ExP'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54550000' THEN 'Other Operation Fixed Exp'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54350000' THEN 'Time Charterage'" ).append("\n"); 
		query.append("                    WHEN STND_COST_CD='54400000' THEN 'Space Charterage'" ).append("\n"); 
		query.append("                 END ) AS STND_COST_NM" ).append("\n"); 
		query.append("                ,SUN_COST_AMT" ).append("\n"); 
		query.append("                ,MON_COST_AMT" ).append("\n"); 
		query.append("                ,TUE_COST_AMT" ).append("\n"); 
		query.append("                ,WED_COST_AMT" ).append("\n"); 
		query.append("                ,THU_COST_AMT" ).append("\n"); 
		query.append("                ,FRI_COST_AMT" ).append("\n"); 
		query.append("                ,SAT_COST_AMT" ).append("\n"); 
		query.append("                ,TTL_AMT" ).append("\n"); 
		query.append("                ,DP_SEQ" ).append("\n"); 
		query.append("            	,VSL_CD AS MERGE_CD" ).append("\n"); 
		query.append("            	,'1' AS ROW_SEQ" ).append("\n"); 
		query.append("            FROM COA_MNL_DTL_COST" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            	AND COST_YRMON LIKE SUBSTR(REPLACE(@[f_src_week],'-',''),1,4)||'%'" ).append("\n"); 
		query.append("                AND COST_WK = SUBSTR(REPLACE(@[f_src_week],'-',''),5,2)" ).append("\n"); 
		query.append("                AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        GROUP BY COST_YRMON, COST_WK, RLANE_CD, VSL_CD, STND_COST_CD,  DP_SEQ" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      , (SELECT COST_YR" ).append("\n"); 
		query.append("              , YYYY_MM" ).append("\n"); 
		query.append("              , COST_WK" ).append("\n"); 
		query.append("              , MAX(SUN) SUN" ).append("\n"); 
		query.append("              , MAX(MON) MON" ).append("\n"); 
		query.append("              , MAX(TUE) TUE" ).append("\n"); 
		query.append("              , MAX(WED) WED" ).append("\n"); 
		query.append("              , MAX(THU) THU" ).append("\n"); 
		query.append("              , MAX(FRI) FRI" ).append("\n"); 
		query.append("              , MAX(SAT) SAT" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT COST_YR" ).append("\n"); 
		query.append("                      , SUBSTR(SLS_FM_DT, 1, 6) YYYY_MM" ).append("\n"); 
		query.append("                      , TO_DATE(SLS_FM_DT, 'YYYYMMDD') YEAR_MONTH" ).append("\n"); 
		query.append("                      , COST_WK" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 0, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 0)) SUN" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 1, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 1)) MON" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 2, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 2)) TUE" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 3, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 3)) WED" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 4, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 4)) THU" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 5, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 5)) FRI" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 6, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 6)) SAT" ).append("\n"); 
		query.append("                   FROM COA_WK_PRD" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND COST_YR = SUBSTR(REPLACE(@[f_tar_week],'-',''),1,4)" ).append("\n"); 
		query.append("                    AND COST_WK = SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2)" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("                 SELECT COST_YR" ).append("\n"); 
		query.append("                      , SUBSTR(SLS_TO_DT, 1, 6) YYYY_MM" ).append("\n"); 
		query.append("                      , TO_DATE(SLS_TO_DT, 'YYYYMMDD') YEAR_MONTH" ).append("\n"); 
		query.append("                      , COST_WK" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 0, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 0)) SUN" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 1, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 1)) MON" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 2, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 2)) TUE" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 3, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 3)) WED" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 4, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 4)) THU" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 5, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 5)) FRI" ).append("\n"); 
		query.append("                      , DECODE(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'), 'YYYYMM'), TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 6, 'YYYYMM'), (TO_DATE(SLS_FM_DT, 'YYYYMMDD') + 6)) SAT" ).append("\n"); 
		query.append("                   FROM COA_WK_PRD" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND COST_YR = SUBSTR(REPLACE(@[f_tar_week],'-',''),1,4)" ).append("\n"); 
		query.append("                    AND COST_WK = SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       GROUP BY COST_YR" ).append("\n"); 
		query.append("              , YYYY_MM" ).append("\n"); 
		query.append("              , COST_WK" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("  WHERE A. COST_YR = B.COST_YR" ).append("\n"); 
		query.append("    AND A.COST_WK  = B.COST_WK" ).append("\n"); 

	}
}