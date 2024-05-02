/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HolidayMgtDBDAOHolidayMgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HolidayMgtDBDAOHolidayMgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 Country, Region, State, Location 별로 등록된 Holiday 정보 조회용 쿼리
	  * </pre>
	  */
	public HolidayMgtDBDAOHolidayMgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hol_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOHolidayMgtRSQL").append("\n"); 
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
		query.append("SELECT	A.HOL_YR" ).append("\n"); 
		query.append(",	A.CNT_CD" ).append("\n"); 
		query.append(",	'' AS CNT_NM" ).append("\n"); 
		query.append(",	'' AS CVRG_CNT_CD" ).append("\n"); 
		query.append(",	A.RGN_CD" ).append("\n"); 
		query.append(",	'' AS RGN_NM" ).append("\n"); 
		query.append(",	'' AS CVRG_RGN_CD" ).append("\n"); 
		query.append(",	A.STE_CD" ).append("\n"); 
		query.append(",	'' AS STE_NM" ).append("\n"); 
		query.append(",	A.LOC_CD" ).append("\n"); 
		query.append(",	'' AS CVRG_LOC_CD" ).append("\n"); 
		query.append(",	TO_CHAR(A.HOL_DT, 'DDMON', 'NLS_DATE_LANGUAGE = American') HOL_DT_IN" ).append("\n"); 
		query.append(",	TO_CHAR(A.HOL_DT, 'YYYY-MM-DD') HOL_DT" ).append("\n"); 
		query.append(",	A.HOL_DESC" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",	A.CRE_OFC_CD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT 	UPD_USR_NM" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT 	B.USR_NM UPD_USR_NM" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY A, COM_USER B" ).append("\n"); 
		query.append("WHERE 	A.HOL_YR = @[hol_yr]" ).append("\n"); 
		query.append("AND A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND A.RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND A.STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND A.LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("ORDER BY A.UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") UPD_USR_NM" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT 	UPD_DT" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT 	TO_CHAR(UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE 	HOL_YR = @[hol_yr]" ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") UPD_DT" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT 	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT 	UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE 	HOL_YR = @[hol_yr]" ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' AS CHG_CD" ).append("\n"); 
		query.append(",	B.WKND_TP_CD" ).append("\n"); 
		query.append(",	'' AS RETRY" ).append("\n"); 
		query.append(",	'' AS SVR_ID" ).append("\n"); 
		query.append(",	'' AS HOL_WKND_TP" ).append("\n"); 
		query.append(",	'' AS HOL_DAYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY A, DMT_WEEKEND B" ).append("\n"); 
		query.append("WHERE	A.HOL_YR = @[hol_yr]" ).append("\n"); 
		query.append("AND A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND A.RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("AND A.STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("AND A.LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("ORDER BY HOL_DT ASC" ).append("\n"); 

	}
}