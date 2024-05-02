/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchBsaCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchBsaCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Common 공동 메소드 쿼리 모음
	  * </pre>
	  */
	public CommonDBDAOSearchBsaCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmmonth",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frmweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loccd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchBsaCommonRSQL").append("\n"); 
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
		query.append("#if (${methodname} == 'searchDatePeriod')" ).append("\n"); 
		query.append("	/*검색 조건에 맞는 DatePriod을 가져온다. - 입력파라메터의 경우의 수 1. Year, Month 2. Year, Week 3. Year, Month, Week : Week가 우선권을 가진다. " ).append("\n"); 
		query.append("    														 4. Year, FromMonth, ToMonth 5. Year, FromWeek, ToWeek 6. Year, FromMonth, ToMonth, FromWeek, ToWeek*/" ).append("\n"); 
		query.append("    #if(${gubun}=='1')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /*searchDatePeriod : YEAR, MONTH, WEEK인경우*/" ).append("\n"); 
		query.append("    	SELECT TO_CHAR(TO_DATE(DECODE(FM_CHK,'Y',SLS_FM_DT, @[year]||@[month]||'01'),'YYYYMMDD'),'YYYY-MM-DD') || ' ~ '|| " ).append("\n"); 
		query.append("      	   					   DECODE(TO_CHK,'Y',TO_CHAR(TO_DATE(SLS_TO_DT,'YYYYMMDD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append("    		  ,TO_CHAR(LAST_DAY(TO_DATE(SLS_FM_DT,'YYYYMMDD')),'YYYY-MM-DD')) RTN_DATE" ).append("\n"); 
		query.append("    	  FROM ( " ).append("\n"); 
		query.append("    			SELECT SLS_FM_DT,SLS_TO_DT " ).append("\n"); 
		query.append("      	   			  ,DECODE(SUBSTR(SLS_FM_DT,1,6), @[year]||@[month],'Y','N') FM_CHK " ).append("\n"); 
		query.append("         	   			  ,DECODE(SUBSTR(SLS_TO_DT,1,6), @[year]||@[month],'Y','N') TO_CHK " ).append("\n"); 
		query.append("      			  FROM  COA_WK_PRD " ).append("\n"); 
		query.append("    		     WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("    				   AND COST_WK = @[week] " ).append("\n"); 
		query.append("        	) " ).append("\n"); 
		query.append("    #elseif(${gubun}=='2')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /*log.info('searchDatePeriod : YEAR, MONTH인경우')*/" ).append("\n"); 
		query.append("    	SELECT TO_CHAR(TO_DATE(@[year]||@[month],'YYYYMM'),'YYYY-MM-DD') || ' ~ ' || " ).append("\n"); 
		query.append("         	   	   TO_CHAR(LAST_DAY(TO_DATE(@[year]||@[month],'YYYYMM')),'YYYY-MM-DD') RTN_DATE" ).append("\n"); 
		query.append("     	  FROM DUAL " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #elseif(${gubun}=='3')			" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /*log.info('searchDatePeriod : YEAR, WEEK인경우')*/" ).append("\n"); 
		query.append("    	SELECT TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'),'YYYY-MM-DD') || ' ~ '|| " ).append("\n"); 
		query.append("         	       TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'),'YYYY-MM-DD') RTN_DATE " ).append("\n"); 
		query.append("     	  FROM  COA_WK_PRD " ).append("\n"); 
		query.append("         WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("    	       AND COST_WK = @[week]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #elseif(${gubun}=='4')	" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /*log.info('searchDatePeriod : year,from month,to_month,from_week,to_week인경우')*/" ).append("\n"); 
		query.append("    	SELECT TO_CHAR(TO_DATE(DECODE(SIGN(TO_NUMBER(MN_FM_DT) - TO_NUMBER(WK_TO_DT)),  1, '' " ).append("\n"); 
		query.append("                                ,DECODE(SIGN(TO_NUMBER(MN_TO_DT) - TO_NUMBER(WK_FM_DT)),  -1, '' " ).append("\n"); 
		query.append("                                ,DECODE(SIGN(TO_NUMBER(MN_FM_DT)-TO_NUMBER(WK_FM_DT)), 1, MN_FM_DT, WK_FM_DT) )), 'YYYYMMDD'),'YYYY-MM-DD')  || '~' || " ).append("\n"); 
		query.append("        		   TO_CHAR(TO_DATE(DECODE(SIGN(TO_NUMBER(MN_TO_DT) - TO_NUMBER(WK_FM_DT)), -1, '', " ).append("\n"); 
		query.append("                                 DECODE(SIGN(TO_NUMBER(MN_FM_DT) - TO_NUMBER(WK_TO_DT)),  1, '', " ).append("\n"); 
		query.append("                                 DECODE(SIGN(TO_NUMBER(MN_TO_DT)-TO_NUMBER(WK_TO_DT)), -1, MN_TO_DT, WK_TO_DT) )), 'YYYYMMDD'),'YYYY-MM-DD') RTN_DATE  " ).append("\n"); 
		query.append("    	 FROM ( " ).append("\n"); 
		query.append("       		   SELECT MAX(WK_FM_DT) WK_FM_DT" ).append("\n"); 
		query.append("    				 ,MAX(WK_TO_DT) WK_TO_DT" ).append("\n"); 
		query.append("    				 ,MAX(MN_FM_DT) MN_FM_DT" ).append("\n"); 
		query.append("    				 ,MAX(MN_TO_DT) MN_TO_DT " ).append("\n"); 
		query.append("       			 FROM ( " ).append("\n"); 
		query.append("            			   SELECT MIN(SLS_FM_DT) WK_FM_DT" ).append("\n"); 
		query.append("    						 ,MAX(SLS_TO_DT) WK_TO_DT" ).append("\n"); 
		query.append("    						 ,'' MN_FM_DT" ).append("\n"); 
		query.append("    						 ,'' MN_TO_DT " ).append("\n"); 
		query.append("            FROM  COA_WK_PRD " ).append("\n"); 
		query.append("            WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("              AND COST_WK BETWEEN @[frmweek] AND @[toweek] " ).append("\n"); 
		query.append("            UNION ALL " ).append("\n"); 
		query.append("            SELECT '','',TO_CHAR(TO_DATE(@[year]||@[frmmonth],'YYYYMM'),'YYYYMMDD'), " ).append("\n"); 
		query.append("                    TO_CHAR(LAST_DAY(TO_DATE(@[year]||@[tomonth],'YYYYMM')),'YYYYMMDD') " ).append("\n"); 
		query.append("             FROM DUAL " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #elseif(${gubun}=='5')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /*log.debug('searchDatePeriod : year,from month,to month인경우')*/" ).append("\n"); 
		query.append("    SELECT TO_CHAR(TO_DATE(@[year]||@[frmmonth],'YYYYMM'),'YYYY-MM-DD') || ' ~ ' ||        " ).append("\n"); 
		query.append("         	   TO_CHAR(LAST_DAY(TO_DATE(@[year]||@[tomonth],'YYYYMM')),'YYYY-MM-DD') RTN_DATE " ).append("\n"); 
		query.append("      FROM DUAL                                                           " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #elseif(${gubun}=='6')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /*log.debug('searchDatePeriod : year,from week,to week인경우')*/" ).append("\n"); 
		query.append("    SELECT MIN(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'),'YYYY-MM-DD')) ||' ~ ' || " ).append("\n"); 
		query.append("         	   MAX(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'),'YYYY-MM-DD')) RTN_DATE " ).append("\n"); 
		query.append("      FROM COA_WK_PRD " ).append("\n"); 
		query.append("     WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("    	   AND COST_WK BETWEEN @[frmweek] AND @[toweek] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPreWeek')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*현재주보다 작은 주를 반환한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT MAX(COST_YR || COST_WK)" ).append("\n"); 
		query.append("  	  FROM COA_WK_PRD " ).append("\n"); 
		query.append(" 	 WHERE COST_YR || COST_WK < @[year]||@[week]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchFirstEtd')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*VVD에 해당하는 etd date를 리턴한다*/" ).append("\n"); 
		query.append("/*20160127.MOD : VPS_ETD_DT -> PF_ETD_DT */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT TO_CHAR(MIN(PF_ETD_DT),'YYYYMMDD') ETD_DT" ).append("\n"); 
		query.append("	  FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("	 WHERE VSL_CD      = @[vsl_cd] " ).append("\n"); 
		query.append("  	   AND SKD_VOY_NO  = @[skd_voy_no] " ).append("\n"); 
		query.append("  	   AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND PF_ETD_DT   IS NOT NULL				--20160127.ADD" ).append("\n"); 
		query.append("  	   /*AND NVL(CNG_STS_CD,'*') <> 'S'*/ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPrevWkPrd')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*전주를 구한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT  COST_YR, COST_WK " ).append("\n"); 
		query.append("  	  FROM  COA_WK_PRD " ).append("\n"); 
		query.append(" 	 WHERE  1=1 " ).append("\n"); 
		query.append("   	   AND  (TO_CHAR(SYSDATE-7, 'YYYYMMDD') " ).append("\n"); 
		query.append("   BETWEEN  SLS_FM_DT AND SLS_TO_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkLocationCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Location Code 유무를 확인*/" ).append("\n"); 
		query.append("	SELECT 'Y' " ).append("\n"); 
		query.append("	  FROM DUAL " ).append("\n"); 
		query.append("	 WHERE EXISTS ( " ).append("\n"); 
		query.append("      			   SELECT '1' " ).append("\n"); 
		query.append("      			     FROM MDM_LOCATION " ).append("\n"); 
		query.append("      			    WHERE LOC_CD = @[loccd]  " ).append("\n"); 
		query.append("				   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}