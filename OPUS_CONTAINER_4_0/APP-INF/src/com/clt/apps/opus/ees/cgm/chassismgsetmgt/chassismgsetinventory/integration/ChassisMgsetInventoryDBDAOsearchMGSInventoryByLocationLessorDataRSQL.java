/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.25 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Shung, Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090915 2080 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("--D.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${location} == 'RCC')" ).append("\n"); 
		query.append(", C.RCC_CD AS LOC_CD" ).append("\n"); 
		query.append("#elseif (${location} == 'LCC')" ).append("\n"); 
		query.append(", C.LCC_CD AS LOC_CD" ).append("\n"); 
		query.append("#elseif (${location} == 'SCC')" ).append("\n"); 
		query.append(", C.SCC_CD AS LOC_CD" ).append("\n"); 
		query.append("#elseif (${location} == 'ALL')" ).append("\n"); 
		query.append(", A.CRNT_LOC_CD AS LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", COUNT(*) AS EQ_TPSZ_CD_TOTAL" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'UMG' THEN 1 END),0) AS EQ_TPSZ_CD_UMG" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'CLG' THEN 1 END),0) AS EQ_TPSZ_CD_CLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_EQUIPMENT A" ).append("\n"); 
		query.append(", MDM_LOCATION B" ).append("\n"); 
		query.append(", MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append(", MDM_VENDOR D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CRNT_LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("#if (${location} == 'RCC')" ).append("\n"); 
		query.append("AND C.RCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'LCC')" ).append("\n"); 
		query.append("AND C.LCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'SCC')" ).append("\n"); 
		query.append("AND C.SCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'ALL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--GROUP BY D.VNDR_LGL_ENG_NM ,  A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("--ORDER BY D.VNDR_LGL_ENG_NM ASC ,  A.AGMT_LSTM_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${location} == 'RCC')" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ,  C.RCC_CD" ).append("\n"); 
		query.append("ORDER BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ASC ,  C.RCC_CD ASC" ).append("\n"); 
		query.append("#elseif (${location} == 'LCC')" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ,  C.LCC_CD" ).append("\n"); 
		query.append("ORDER BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ASC ,  C.LCC_CD ASC" ).append("\n"); 
		query.append("#elseif (${location} == 'SCC')" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ,  C.SCC_CD" ).append("\n"); 
		query.append("ORDER BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ASC ,  C.SCC_CD ASC" ).append("\n"); 
		query.append("#elseif (${location} == 'ALL')" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ,  A.CRNT_LOC_CD" ).append("\n"); 
		query.append("ORDER BY A.VNDR_SEQ || '.' || D.VNDR_ABBR_NM ASC ,  A.CRNT_LOC_CD ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}