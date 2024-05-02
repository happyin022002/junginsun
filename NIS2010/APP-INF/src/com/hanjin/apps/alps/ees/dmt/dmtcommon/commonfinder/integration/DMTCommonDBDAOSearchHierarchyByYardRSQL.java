/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOSearchHierarchyByYardRSQL.java
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

public class DMTCommonDBDAOSearchHierarchyByYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHierarchyByYard
	  * </pre>
	  */
	public DMTCommonDBDAOSearchHierarchyByYardRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT F.CONTI_CD CONTI_CD" ).append("\n"); 
		query.append(",F.CONTI_NM CONTI_NM" ).append("\n"); 
		query.append(",E.CNT_CD CNT_CD" ).append("\n"); 
		query.append(",E.CNT_NM CNT_NM" ).append("\n"); 
		query.append(",D.STE_CD STE_CD" ).append("\n"); 
		query.append(",D.STE_NM STE_NM" ).append("\n"); 
		query.append(",C.RGN_CD RGN_CD" ).append("\n"); 
		query.append(",C.RGN_NM RGN_NM" ).append("\n"); 
		query.append(",B.LOC_CD LOC_CD" ).append("\n"); 
		query.append(",B.LOC_NM LOC_NM" ).append("\n"); 
		query.append(",A.YD_CD YD_CD" ).append("\n"); 
		query.append(",A.YD_NM YD_NM" ).append("\n"); 
		query.append("FROM MDM_YARD A" ).append("\n"); 
		query.append(",MDM_LOCATION B" ).append("\n"); 
		query.append(",MDM_REGION C" ).append("\n"); 
		query.append(",MDM_STATE D" ).append("\n"); 
		query.append(",MDM_COUNTRY E" ).append("\n"); 
		query.append(",MDM_CONTINENT F" ).append("\n"); 
		query.append("WHERE A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND B.RGN_CD = C.RGN_CD(+)" ).append("\n"); 
		query.append("AND B.CNT_CD = D.CNT_CD(+)" ).append("\n"); 
		query.append("AND B.STE_CD = D.STE_CD(+)" ).append("\n"); 
		query.append("AND B.CNT_CD = E.CNT_CD" ).append("\n"); 
		query.append("AND B.CONTI_CD = F.CONTI_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommon.dmtcommonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchHierarchyByYardRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}