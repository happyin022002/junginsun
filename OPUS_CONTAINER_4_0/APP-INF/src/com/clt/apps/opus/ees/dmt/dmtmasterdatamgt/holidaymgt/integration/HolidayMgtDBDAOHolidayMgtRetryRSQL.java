/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtDBDAOHolidayMgtRetryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.21 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class HolidayMgtDBDAOHolidayMgtRetryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 Country, Region, State, Location 별로 등록된 Holiday 조회시 지정한 년도에 데이터가 없을 경우,
	  * 데이터가 있는 최대년도의 값으로 재조회를 실행하는 쿼리
	  * </pre>
	  */
	public HolidayMgtDBDAOHolidayMgtRetryRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hol_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT	A.HOL_YR," ).append("\n"); 
		query.append("A.CNT_CD," ).append("\n"); 
		query.append("'' CNT_NM," ).append("\n"); 
		query.append("A.RGN_CD," ).append("\n"); 
		query.append("'' RGN_NM," ).append("\n"); 
		query.append("A.STE_CD," ).append("\n"); 
		query.append("'' STE_NM," ).append("\n"); 
		query.append("A.LOC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.HOL_DT, 'DDMON', 'NLS_DATE_LANGUAGE = American') HOL_DT_IN," ).append("\n"); 
		query.append("TO_CHAR(A.HOL_DT, 'YYYY-MM-DD') HOL_DT," ).append("\n"); 
		query.append("A.HOL_DESC," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("A.CRE_OFC_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT UPD_USR_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	B.USR_NM UPD_USR_NM" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY A, COM_USER B" ).append("\n"); 
		query.append("WHERE 	A.HOL_YR = (" ).append("\n"); 
		query.append("SELECT	MAX(HOL_YR)" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND HOL_YR < @[hol_yr]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND A.RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND A.STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND A.LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("ORDER BY A.UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") UPD_USR_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE 	HOL_YR = (" ).append("\n"); 
		query.append("SELECT	MAX(HOL_YR)" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND HOL_YR < @[hol_yr]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") UPD_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT UPD_OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE 	HOL_YR = (" ).append("\n"); 
		query.append("SELECT	MAX(HOL_YR)" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND HOL_YR < @[hol_yr]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") UPD_OFC_CD," ).append("\n"); 
		query.append("'' CHG_CD," ).append("\n"); 
		query.append("B.WKND_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY A, DMT_WEEKEND B" ).append("\n"); 
		query.append("WHERE	A.HOL_YR = (" ).append("\n"); 
		query.append("SELECT	MAX(HOL_YR)" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND HOL_YR < @[hol_yr]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND A.RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND A.STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND A.LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY HOL_DT ASC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOHolidayMgtRetryRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}