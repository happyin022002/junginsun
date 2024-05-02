/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SurplusAreaDBDAOSearchOfcLvlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOSearchOfcLvlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USER OFC LEVEL 구하기
	  * - CHM-201428796, SELCTY --> SELCOE 로 변경, 신용찬
	  * - CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환
	  * </pre>
	  */
	public SurplusAreaDBDAOSearchOfcLvlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.integration").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOSearchOfcLvlRSQL").append("\n"); 
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
		query.append("--/**" ).append("\n"); 
		query.append("--## 설명 -  MTY Inventory Simulation by Port & Yard의 User별 office level결정" ).append("\n"); 
		query.append("--  SELCOE        - 1, CTY-EQ는 Super-user" ).append("\n"); 
		query.append("--  HQ 혹은 지역본부 - 2, 지역본부: 자기 지역 산하의 데이터만 조회&입력&수정 가능" ).append("\n"); 
		query.append("--  서남아                - 3, 입력/수정 불가(또는 SHAAS와 마찬가지로 접근 불가)한 서남아" ).append("\n"); 
		query.append("--                        ofc: 'BAHBA','KWIBA','DOHBA','BDOBA','BLWBA,BTMBA','JKTBA','SRGBA','SUBBA','PENBS','PGUBS','PKGBB','CEBBA','MNLBA','MNLBB','SINBB','BKKBB','SGZBA','DADBA','HANBS','HPOBO','SGNBB'" ).append("\n"); 
		query.append("--  서남아 예외처리  - 4, SHAAS는 원천적으로 해당 메뉴 접근 불가" ).append("\n"); 
		query.append("--  미주 예외처리    - 5, ATLSC와 PHXSC는 미주는 센터에서 본부를 대신하여 업무를 수행함에 RHQ와 동일한 권한을 부여함" ).append("\n"); 
		query.append("--  그외 일반 지점   - 6, Office 단위: 자기 LCC 지역 단위의 데이터까지만 조회&입력&수정 가능" ).append("\n"); 
		query.append("--**/" ).append("\n"); 
		query.append("SELECT CASE WHEN @[ofc_cd] IN ('SELCTY') -- SELCOE --> SELOPE" ).append("\n"); 
		query.append("                THEN 1" ).append("\n"); 
		query.append("            WHEN (" ).append("\n"); 
		query.append("                    SELECT DISTINCT AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND     OFC_TP_CD IN ('HQ','QT') -- HQ : HEAD QUATER, QT : 지역본부" ).append("\n"); 
		query.append("                    AND     OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                    AND     AR_HD_QTR_OFC_CD NOT IN ('SHARC') --(SHAAS --> SHARC)는 제외" ).append("\n"); 
		query.append("					AND     ROWNUM = 1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                  = TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(@[ofc_cd])" ).append("\n"); 
		query.append("                THEN 2 -- 지역본부" ).append("\n"); 
		query.append("            --WHEN ofc_cd IN ('BAHBA','KWIBA','DOHBA','BDOBA','BLWBA','BTMBA','JKTBB','SRGBA','SUBBA','PENBS','PGUBS','PKGBB','CEBBA','MNLBA','MNLBB','SINBB','BKKBB','SGZBA','DADBA','HANBS','HPOBO','SGNBB') " ).append("\n"); 
		query.append("            WHEN @[ofc_cd] IN ('BAHBA','KWIBA','DOHBA','BDOBA','BLWBA','BTMBA','JKTSC','SRGBA','SUBBA','PENSO','PGUSO','PKGSC','CEBBA','MNLBA','MNLSC','SINSC','BKKSC','SGZBA','DADBA','HANBS','HPOKS','SGNSC') " ).append("\n"); 
		query.append("                THEN 3 -- 조회못하는 office" ).append("\n"); 
		query.append("            WHEN (" ).append("\n"); 
		query.append("                    SELECT DISTINCT AR_HD_QTR_OFC_CD " ).append("\n"); 
		query.append("                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                    WHERE   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND     OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("					AND     ROWNUM = 1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                  = 'SHARC'  -- SHAAS-->SHARC" ).append("\n"); 
		query.append("                THEN 4 -- 조회못하는 office (SHAAS 하부의 모든 OFFICE)                " ).append("\n"); 
		query.append("            WHEN @[ofc_cd] IN ('ATLSA','PHXSA')  -- 'ATLSC'--> ATLSA,'PHXSC'-->PHXSA" ).append("\n"); 
		query.append("                THEN 5" ).append("\n"); 
		query.append("            ELSE 6 " ).append("\n"); 
		query.append("       END LEVEL_CD   " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}