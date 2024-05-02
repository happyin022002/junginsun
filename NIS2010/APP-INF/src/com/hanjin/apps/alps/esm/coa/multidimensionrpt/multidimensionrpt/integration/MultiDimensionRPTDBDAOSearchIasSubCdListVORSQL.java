/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchIasSubCdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.08.23 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchIasSubCdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    IAS 협의체별 Scop 관리(ESM_COA_0178)
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchIasSubCdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ias_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchIasSubCdListVORSQL").append("\n"); 
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
		query.append("SELECT IAS_SUB_CD" ).append("\n"); 
		query.append("      ,POL_CNT_CD" ).append("\n"); 
		query.append("      ,POD_CNT_CD" ).append("\n"); 
		query.append("      ,CD_RMK" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM   COA_IAS_SUB" ).append("\n"); 
		query.append("#if (${ias_sub_cd} != '') " ).append("\n"); 
		query.append("WHERE  IAS_SUB_CD = @[ias_sub_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY IAS_SUB_CD" ).append("\n"); 

	}
}