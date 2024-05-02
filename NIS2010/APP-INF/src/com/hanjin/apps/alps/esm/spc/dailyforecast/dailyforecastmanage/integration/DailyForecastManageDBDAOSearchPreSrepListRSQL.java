/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchPreSrepListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.26
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2013.04.26 김시몬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author simonkim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchPreSrepListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화주별 전임 S.REP을 조회한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchPreSrepListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("salesrep",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchPreSrepListRSQL").append("\n"); 
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
		query.append("SELECT CUST_CD," ).append("\n"); 
		query.append("       CUST_NM," ).append("\n"); 
		query.append("       CUST_TP_CD," ).append("\n"); 
		query.append("       SUBSTR(MAX(SYS_CONNECT_BY_PATH(SREP_CD, '|')), 2) AS SREP_USR_ID," ).append("\n"); 
		query.append("       SUBSTR(MAX(SYS_CONNECT_BY_PATH(SREP_NM, '|')), 2) AS SREP_NM," ).append("\n"); 
		query.append("       TO_CHAR(SYSDATE, 'YYYY-WW') AS COST_WK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT CUST_CD,  -- 20130424 추가" ).append("\n"); 
		query.append("               CUST_NM," ).append("\n"); 
		query.append("               CUST_TP_CD," ).append("\n"); 
		query.append("               SREP_CD," ).append("\n"); 
		query.append("               SREP_NM," ).append("\n"); 
		query.append("               ROW_NUMBER() OVER (PARTITION BY CUST_CD ORDER BY SREP_NM) AS RNUM" ).append("\n"); 
		query.append("          FROM (  " ).append("\n"); 
		query.append("                SELECT DISTINCT  -- 20130424 추가" ).append("\n"); 
		query.append("                       BR.CUST_CNT_CD||TO_CHAR(BR.CUST_SEQ, 'FM000000') AS CUST_CD," ).append("\n"); 
		query.append("                       C.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("                       C.RVIS_CNTR_CUST_TP_CD AS CUST_TP_CD," ).append("\n"); 
		query.append("                       SR.SREP_CD," ).append("\n"); 
		query.append("                       S.SREP_NM" ).append("\n"); 
		query.append("                       --,ROW_NUMBER() OVER (PARTITION BY BR.CUST_CNT_CD, BR.CUST_SEQ ORDER BY S.SREP_NM) AS RNUM -- 20130424 수정" ).append("\n"); 
		query.append("                  FROM BKG_CUST_SLS_REP BR," ).append("\n"); 
		query.append("                       SPC_SLS_REP_CUST SR," ).append("\n"); 
		query.append("                       MDM_CUSTOMER     C ," ).append("\n"); 
		query.append("                       MDM_SLS_REP      S" ).append("\n"); 
		query.append("                 WHERE BR.CUST_CNT_CD = SR.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND BR.CUST_SEQ    = SR.CUST_SEQ" ).append("\n"); 
		query.append("                   AND BR.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                   AND SR.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                   --AND BR.CRE_DT      > SYSDATE - 30" ).append("\n"); 
		query.append("                   AND BR.SREP_CD    <> SR.SREP_CD" ).append("\n"); 
		query.append("                   AND BR.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND BR.CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("                   AND SR.SREP_CD     = S.SREP_CD" ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                                     FROM SPC_SLS_REP_CUST" ).append("\n"); 
		query.append("                                    WHERE SREP_CD     = BR.SREP_CD" ).append("\n"); 
		query.append("                                      AND CUST_CNT_CD = BR.CUST_CNT_CD" ).append("\n"); 
		query.append("                                      AND CUST_SEQ    = BR.CUST_SEQ" ).append("\n"); 
		query.append("                                      AND DELT_FLG    = 'N')" ).append("\n"); 
		query.append("                   AND BR.SREP_CD     = @[salesrep]" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        )  " ).append("\n"); 
		query.append(" START WITH RNUM = 1" ).append("\n"); 
		query.append(" CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CD = CUST_CD          " ).append("\n"); 
		query.append(" GROUP BY CUST_CD, CUST_NM, CUST_TP_CD" ).append("\n"); 
		query.append(" ORDER BY CUST_NM" ).append("\n"); 

	}
}