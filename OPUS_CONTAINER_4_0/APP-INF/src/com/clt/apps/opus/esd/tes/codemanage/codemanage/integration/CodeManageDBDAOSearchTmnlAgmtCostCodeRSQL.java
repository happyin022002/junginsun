/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CodeManageDBDAOSearchTmnlAgmtCostCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOSearchTmnlAgmtCostCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Agreement Cost code 조회
	  * </pre>
	  */
	public CodeManageDBDAOSearchTmnlAgmtCostCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.codemanage.codemanage.integration").append("\n"); 
		query.append("FileName : CodeManageDBDAOSearchTmnlAgmtCostCodeRSQL").append("\n"); 
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
		query.append("SELECT LGS_COST_CD," ).append("\n"); 
		query.append("TML_AGMT_MGMT_CD," ).append("\n"); 
		query.append("MRN_TML_FLG," ).append("\n"); 
		query.append("FDCK_CY_FLG," ).append("\n"); 
		query.append("CFS_FLG," ).append("\n"); 
		query.append("RAIL_RMP_FLG" ).append("\n"); 
		query.append("FROM TES_TML_AGMT_COST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lgs_cost_cd} != '')" ).append("\n"); 
		query.append("WHERE LGS_COST_CD LIKE @[lgs_cost_cd]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE LGS_COST_CD LIKE ''||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD" ).append("\n"); 

	}
}