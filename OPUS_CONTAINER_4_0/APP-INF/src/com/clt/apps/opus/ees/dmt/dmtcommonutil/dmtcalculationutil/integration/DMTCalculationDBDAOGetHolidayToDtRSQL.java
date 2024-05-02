/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOGetHolidayToDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.25 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetHolidayToDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getHolidayToDt
	  * </pre>
	  */
	public DMTCalculationDBDAOGetHolidayToDtRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("state_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftime_cmnc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("SELECT	/*+ NO_EXPAND INDEX_DESC ( DMT_HOLIDAY XPKDMT_HOLIDAY ) */" ).append("\n"); 
		query.append("RTRIM(TO_CHAR( HOL_DT, 'YYYYMMDD' )) DDH_DATE" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE	HOL_YR	=	SUBSTR(@[ftime_cmnc], 1, 4)" ).append("\n"); 
		query.append("AND		( CNT_CD, RGN_CD, STE_CD, LOC_CD )" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+ NO_EXPAND INDEX_DESC ( DMT_HOLIDAY XPKDMT_HOLIDAY ) */" ).append("\n"); 
		query.append("CNT_CD, RGN_CD, STE_CD, LOC_CD" ).append("\n"); 
		query.append("FROM	DMT_HOLIDAY" ).append("\n"); 
		query.append("WHERE	HOL_YR		=	SUBSTR(@[ftime_cmnc], 1, 4)" ).append("\n"); 
		query.append("AND		( CNT_CD	=	@[cnt_cd]		OR	CNT_CD		=	' ')" ).append("\n"); 
		query.append("AND		( RGN_CD	=	@[rgn_cd]		OR	RGN_CD		=	' ')" ).append("\n"); 
		query.append("AND		( STE_CD	=	@[state_cd]		OR	STE_CD		=	' ')" ).append("\n"); 
		query.append("AND		( LOC_CD	=	@[loc_cd]		OR	LOC_CD		=	' ')" ).append("\n"); 
		query.append("AND		ROWNUM		=	1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		HOL_DT	=	TO_DATE(SUBSTR(@[ftime_cmnc], 1, 8), 'YYYYMMDD')" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetHolidayToDtRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}