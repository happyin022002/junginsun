/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchLaneBoundSwitchRlaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchLaneBoundSwitchRlaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rlane List 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchLaneBoundSwitchRlaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLaneBoundSwitchRlaneListRSQL").append("\n"); 
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
		query.append("  SELECT DISTINCT RLANE_CD AS TEXT,                       " ).append("\n"); 
		query.append("                  RLANE_CD AS CODE                        " ).append("\n"); 
		query.append("    FROM MDM_DTL_REV_LANE                                 " ).append("\n"); 
		query.append("   WHERE DELT_FLG   = 'N'                                 " ).append("\n"); 
		query.append("     AND TRD_CD     = @[trd_cd]                                   " ).append("\n"); 
		query.append("     AND SUB_TRD_CD LIKE @[sub_trd_cd] || '%'                         " ).append("\n"); 
		query.append("ORDER BY DECODE(TEXT,'RBCCO','ZZ',SUBSTR(TEXT,-2)), TEXT  " ).append("\n"); 

	}
}