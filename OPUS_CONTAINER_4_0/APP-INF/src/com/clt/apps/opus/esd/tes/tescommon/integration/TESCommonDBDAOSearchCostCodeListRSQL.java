/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Code를 조회한다.
	  * </pre>
	  */
	public TESCommonDBDAOSearchCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchCostCodeListRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|') AS COST_CODE " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT ROWNUM ROW_ID " ).append("\n"); 
		query.append("            , LGS_COST_CD " ).append("\n"); 
		query.append("         FROM TES_TML_SO_COST " ).append("\n"); 
		query.append("         ORDER BY LGS_COST_CD" ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1 START " ).append("\n"); 
		query.append("WITH ROW_ID = 1" ).append("\n"); 

	}
}