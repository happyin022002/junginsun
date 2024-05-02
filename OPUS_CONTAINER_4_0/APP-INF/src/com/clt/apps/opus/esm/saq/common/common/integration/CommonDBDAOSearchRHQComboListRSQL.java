/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchRHQComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.02.28 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchRHQComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ Combo List 조회
	  * </pre>
	  */
	public CommonDBDAOSearchRHQComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchRHQComboListRSQL").append("\n"); 
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
		query.append("  SELECT T.OFC_CD," ).append("\n"); 
		query.append("         T.OFC_ENG_NM" ).append("\n"); 
		query.append("    FROM SAQ_ORGANIZATION_V T" ).append("\n"); 
		query.append("   WHERE T.LVL = 2" ).append("\n"); 
		query.append("     AND T.DELT_FLG IN ('N', @[del])" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}