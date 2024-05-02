/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CanadaCCTManageDBDAOSearchCCTManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanadaCCTManageDBDAOSearchCCTManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CanadaCCTManageDBDAOSearchCCTManage
	  * </pre>
	  */
	public CanadaCCTManageDBDAOSearchCCTManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.integration").append("\n"); 
		query.append("FileName : CanadaCCTManageDBDAOSearchCCTManageRSQL").append("\n"); 
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
		query.append("SELECT POR_CD,POL_NOD_CD" ).append("\n"); 
		query.append("	  ,POR_NOD_CD" ).append("\n"); 
		query.append("      ,ARR_SUN_DYS" ).append("\n"); 
		query.append("      ,ARR_MON_DYS" ).append("\n"); 
		query.append("      ,ARR_TUE_DYS" ).append("\n"); 
		query.append("      ,ARR_WED_DYS" ).append("\n"); 
		query.append("      ,ARR_THU_DYS" ).append("\n"); 
		query.append("      ,ARR_FRI_DYS" ).append("\n"); 
		query.append("      ,ARR_SAT_DYS" ).append("\n"); 
		query.append("      ,CCT_HRMNT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("  FROM PRD_CND_TML_CCT_MGMT" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("  AND POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_nod_cd} != '') " ).append("\n"); 
		query.append("  AND POL_NOD_CD = @[pol_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_nod_cd} != '') " ).append("\n"); 
		query.append("  AND POR_NOD_CD = @[por_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY POL_NOD_CD,POR_CD" ).append("\n"); 

	}
}