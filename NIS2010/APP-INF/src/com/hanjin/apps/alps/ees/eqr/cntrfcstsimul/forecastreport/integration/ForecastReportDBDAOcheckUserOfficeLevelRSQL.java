/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ForecastReportDBDAOcheckUserOfficeLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOcheckUserOfficeLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유저의 오피스 레벨을 체크
	  * - CHM-201428796, SELCTY --> SELCOE 로 변경, 신용찬
	  * - CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환
	  *   SELCOE --> SELOPE
	  * </pre>
	  */
	public ForecastReportDBDAOcheckUserOfficeLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOcheckUserOfficeLevelRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("--1. 설명" ).append("\n"); 
		query.append("--  유저별 office level결정" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--  SELOPE           - 1, 전지역 조회,       수정" ).append("\n"); 
		query.append("--  HQ 혹은 지역본부        - 2, 전지역 조회,       수정불가" ).append("\n"); 
		query.append("--  지점                            - 3, 지점의 LCC만 조회,  수정불가" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("--2. 변수" ).append("\n"); 
		query.append("--   :ofc_cd  - SELCDO, SHAAS, NBOBB" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT CASE WHEN @[ofc_cd] = 'SELCTY' THEN 1      -- SELCOE --> SELOPE 는 SUPER 권한" ).append("\n"); 
		query.append("            WHEN @[ofc_cd] = 'PUSSC'  THEN 2      -- PUSSC 는 KRINC, KRKAN 을 모두 커버하므로 HQ 권한을 드립니다." ).append("\n"); 
		query.append("            WHEN (" ).append("\n"); 
		query.append("                    SELECT AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND     OFC_TP_CD IN ('HQ','QT') -- HQ : HEAD QUATER, QT : 지역본부" ).append("\n"); 
		query.append("                    AND     OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                 ) " ).append("\n"); 
		query.append("                  = TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(@[ofc_cd]) THEN 2 -- 지역본부" ).append("\n"); 
		query.append("            ELSE 3                                                      -- 지점 OFFICE " ).append("\n"); 
		query.append("       END LEVEL_CD   " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}