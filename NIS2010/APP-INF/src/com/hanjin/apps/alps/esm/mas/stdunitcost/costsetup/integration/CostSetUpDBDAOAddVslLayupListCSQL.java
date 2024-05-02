/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostSetUpDBDAOAddVslLayupListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOAddVslLayupListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAS_MNL_DTL_COST 테이블에 데이터 저장
	  * </pre>
	  */
	public CostSetUpDBDAOAddVslLayupListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fri_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sat_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thu_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sun_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wed_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tue_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mon_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOAddVslLayupListCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_MNL_DTL_COST" ).append("\n"); 
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
		query.append("      , DECODE(B.SUN, NULL, 0, SUN_COST_AMT)" ).append("\n"); 
		query.append("      + DECODE(B.MON, NULL, 0, MON_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.TUE, NULL, 0, TUE_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.WED, NULL, 0, WED_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.THU, NULL, 0, THU_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.FRI, NULL, 0, FRI_COST_AMT) " ).append("\n"); 
		query.append("      + DECODE(B.SAT, NULL, 0, SAT_COST_AMT) TTL_AMT" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[dp_seq]" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT SUBSTR(REPLACE(@[cost_yrmon],'-',''),1,4) COST_YR" ).append("\n"); 
		query.append("              , SUBSTR(REPLACE(@[cost_yrmon],'-',''),5,2) COST_WK" ).append("\n"); 
		query.append("              , @[rlane_cd] RLANE_CD" ).append("\n"); 
		query.append("              , @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("              , @[stnd_cost_cd] STND_COST_CD" ).append("\n"); 
		query.append("              , @[sun_cost_amt] SUN_COST_AMT" ).append("\n"); 
		query.append("              , @[mon_cost_amt] MON_COST_AMT" ).append("\n"); 
		query.append("              , @[tue_cost_amt] TUE_COST_AMT" ).append("\n"); 
		query.append("              , @[wed_cost_amt] WED_COST_AMT" ).append("\n"); 
		query.append("              , @[thu_cost_amt] THU_COST_AMT" ).append("\n"); 
		query.append("              , @[fri_cost_amt] FRI_COST_AMT" ).append("\n"); 
		query.append("              , @[sat_cost_amt] SAT_COST_AMT" ).append("\n"); 
		query.append("              , @[ttl_amt] TTL_AMT" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
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
		query.append("                   FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND COST_YR = SUBSTR(REPLACE(@[cost_yrmon],'-',''),1,4)" ).append("\n"); 
		query.append("                    AND COST_WK = SUBSTR(REPLACE(@[cost_yrmon],'-',''),5,2)" ).append("\n"); 
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
		query.append("                   FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND COST_YR = SUBSTR(REPLACE(@[cost_yrmon],'-',''),1,4)" ).append("\n"); 
		query.append("                    AND COST_WK = SUBSTR(REPLACE(@[cost_yrmon],'-',''),5,2)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       GROUP BY COST_YR" ).append("\n"); 
		query.append("              , YYYY_MM" ).append("\n"); 
		query.append("              , COST_WK" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("  WHERE A. COST_YR = B.COST_YR" ).append("\n"); 
		query.append("    AND A.COST_WK  = B.COST_WK" ).append("\n"); 

	}
}