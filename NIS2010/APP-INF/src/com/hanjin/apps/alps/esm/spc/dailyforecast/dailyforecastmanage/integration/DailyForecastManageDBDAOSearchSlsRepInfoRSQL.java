/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchSlsRepInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchSlsRepInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep 의 기본정보를 조회한다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchSlsRepInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchSlsRepInfoRSQL").append("\n"); 
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
		query.append("SELECT   M.OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("       , M.SREP_CD" ).append("\n"); 
		query.append("       , M.SREP_NM" ).append("\n"); 
		query.append("  FROM MDM_SLS_REP M" ).append("\n"); 
		query.append(" WHERE M.SREP_STS_CD = 'N'" ).append("\n"); 
		query.append("#if(${sls_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND M.OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${srep_cd} != '')" ).append("\n"); 
		query.append("   AND M.SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${srep_nm} != '')" ).append("\n"); 
		query.append("   AND UPPER(M.SREP_NM) LIKE '%'||UPPER(@[srep_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                       SELECT R.SREP_CD" ).append("\n"); 
		query.append("                         FROM BKG_CUST_SLS_REP R" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("                              , MDM_CUSTOMER C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        WHERE R.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                          AND R.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("                          AND R.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("                          AND R.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                          AND R.CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("                          AND UPPER(C.CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                       SELECT R.SREP_CD" ).append("\n"); 
		query.append("                         FROM SPC_SLS_REP_CUST R" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("                              , MDM_CUSTOMER C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        WHERE R.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                          AND R.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("                          AND R.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_nm} != '')" ).append("\n"); 
		query.append("                          AND R.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                          AND R.CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("                          AND UPPER(C.CUST_LGL_ENG_NM) LIKE '%'||UPPER(@[cust_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                 WHERE A.SREP_CD = M.SREP_CD" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}