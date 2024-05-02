/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreventionDBDAOSearchPreventionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.20 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.prevention.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreventionDBDAOSearchPreventionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Prevention Key로 검색
	  * </pre>
	  */
	public PreventionDBDAOSearchPreventionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_prve_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.prevention.integration").append("\n"); 
		query.append("FileName : PreventionDBDAOSearchPreventionInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    CLM_PRVE_NO" ).append("\n"); 
		query.append("  , CLM_PRVE_DIV_CD" ).append("\n"); 
		query.append("  , CNI_GET_CLM_MISC_NM_FNC ('37', CLM_PRVE_DIV_CD, '2') CLM_PRVE_DIV_NM" ).append("\n"); 
		query.append("  , EFF_DT" ).append("\n"); 
		query.append("  , EXP_DT" ).append("\n"); 
		query.append("  , CRE_OFC_CD" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            CLM_AREA_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            CNI_AREA_OFC" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            OFC_CD = CRE_OFC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    CLM_AREA_CD" ).append("\n"); 
		query.append("  , CLM_PRVE_SUBJ_NM" ).append("\n"); 
		query.append("  , CLM_PRVE_DESC" ).append("\n"); 
		query.append("  , CLM_PRVE_READ_KNT" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_PRVE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    1               = 1" ).append("\n"); 
		query.append("    AND CLM_PRVE_NO = @[clm_prve_no]" ).append("\n"); 

	}
}