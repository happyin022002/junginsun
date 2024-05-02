/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HolidayMgtDBDAOHolidayCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HolidayMgtDBDAOHolidayCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각 Country, Region, State, Location 별로 등록된 Holiday 총 일 수를 조회하는 쿼리
	  * </pre>
	  */
	public HolidayMgtDBDAOHolidayCountRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.integration").append("\n"); 
		query.append("FileName : HolidayMgtDBDAOHolidayCountRSQL").append("\n"); 
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
		query.append(",	A.CNT_CD AS CVRG_CNT_CD" ).append("\n"); 
		query.append(",	CASE WHEN A.CNT_CD IN ('CA', 'US') THEN A.STE_CD ELSE A.RGN_CD END CVRG_RGN_CD" ).append("\n"); 
		query.append(",	A.LOC_CD AS CVRG_LOC_CD" ).append("\n"); 
		query.append(",	A.RGN_CD" ).append("\n"); 
		query.append(",	A.STE_CD" ).append("\n"); 
		query.append(",	A.LOC_CD" ).append("\n"); 
		query.append(",	A.HOL_DAYS" ).append("\n"); 
		query.append(",	B.WKND_TP_CD" ).append("\n"); 
		query.append(",	DECODE(NVL(B.WKND_TP_CD,''), '', 'SAT/SUN', 'FS', 'FRI/SAT', 'TF', 'THU/FRI', B.WKND_TP_CD) HOL_WKND_TP" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	C.USR_NM UPD_USR_NM" ).append("\n"); 
		query.append(",	A.UPD_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT 	HOL_DAYS, HOL_YR, CNT_CD, RGN_CD, STE_CD, LOC_CD, UPD_DT, UPD_USR_ID, UPD_OFC_CD" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  COUNT(HOL_DT) OVER (PARTITION BY HOL_YR, CNT_CD, RGN_CD, STE_CD, LOC_CD) HOL_DAYS," ).append("\n"); 
		query.append("ROW_NUMBER () OVER (PARTITION BY HOL_YR, CNT_CD, RGN_CD, STE_CD, LOC_CD ORDER BY UPD_DT DESC) SEQ," ).append("\n"); 
		query.append("HOL_YR, CNT_CD, RGN_CD, STE_CD, LOC_CD, UPD_DT, UPD_USR_ID, UPD_OFC_CD" ).append("\n"); 
		query.append("FROM    DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE	CNT_CD = NVL(@[cnt_cd], ' ')" ).append("\n"); 
		query.append("#if(${rgn_cd} != '')" ).append("\n"); 
		query.append("AND RGN_CD = NVL(@[rgn_cd], ' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ste_cd} != '')" ).append("\n"); 
		query.append("AND STE_CD = NVL(@[ste_cd], ' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("AND LOC_CD = NVL(@[loc_cd], ' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hol_yr} != '')" ).append("\n"); 
		query.append("AND HOL_YR = @[hol_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	SEQ < 2" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",	DMT_WEEKEND B" ).append("\n"); 
		query.append(",	COM_USER C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 	A.CNT_CD 		= B.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.UPD_USR_ID 	= C.USR_ID(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CVRG_CNT_CD, CVRG_RGN_CD, CVRG_LOC_CD, A.HOL_YR" ).append("\n"); 

	}
}