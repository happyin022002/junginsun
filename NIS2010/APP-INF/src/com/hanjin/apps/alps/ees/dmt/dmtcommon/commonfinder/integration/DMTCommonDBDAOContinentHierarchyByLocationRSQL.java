/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOContinentHierarchyByLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.01 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOContinentHierarchyByLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location 를 포함하는 상위 Continent, Country, Region or State 정보를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOContinentHierarchyByLocationRSQL(){
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
		query.append("SELECT  A.LOC_CD, A.LOC_NM, A.RGN_CD, B.RGN_NM, A.STE_CD, C.STE_NM, A.CNT_CD, D.CNT_NM, E.CONTI_CD, E.CONTI_NM" ).append("\n"); 
		query.append("FROM    MDM_LOCATION A, MDM_REGION B, MDM_STATE C, MDM_COUNTRY D, MDM_CONTINENT E" ).append("\n"); 
		query.append("WHERE   A.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.RGN_CD = B.RGN_CD(+)" ).append("\n"); 
		query.append("AND B.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND A.CNT_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("AND A.STE_CD = C.STE_CD(+)" ).append("\n"); 
		query.append("AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND A.CNT_CD = D.CNT_CD" ).append("\n"); 
		query.append("AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.CONTI_CD = E.CONTI_CD" ).append("\n"); 
		query.append("AND E.DELT_FLG = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommon.dmtcommonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOContinentHierarchyByLocationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}