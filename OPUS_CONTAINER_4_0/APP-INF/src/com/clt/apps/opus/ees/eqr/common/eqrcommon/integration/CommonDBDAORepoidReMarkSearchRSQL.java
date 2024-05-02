/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAORepoidReMarkSearchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAORepoidReMarkSearchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * repoidReMark 조회
	  * </pre>
	  */
	public CommonDBDAORepoidReMarkSearchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAORepoidReMarkSearchRSQL").append("\n"); 
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
		query.append("SELECT              						" ).append("\n"); 
		query.append("    CASE WHEN REPO_PLN_DTRB_FLG ='Y' OR REPO_PLN_AUTO_GEN_FLG ='Y' THEN " ).append("\n"); 
		query.append("        'FALSE'                					          " ).append("\n"); 
		query.append("    ELSE 										" ).append("\n"); 
		query.append("        'TRUE'										                 " ).append("\n"); 
		query.append("    END  STATUS,        						" ).append("\n"); 
		query.append("    SCNR_ID,	" ).append("\n"); 
		query.append("    REPO_PLN_RMK   , " ).append("\n"); 
		query.append("    REPO_PLN_ID,   " ).append("\n"); 
		query.append("    REPO_PLN_DTRB_FLG	," ).append("\n"); 
		query.append("	NVL((SELECT 'Y' FROM (" ).append("\n"); 
		query.append("		SELECT 'Y' FROM EQR_PLAN_V WHERE REPO_PLN_ID=@[repo_id] AND ROWNUM=1" ).append("\n"); 
		query.append("		 UNION ALL" ).append("\n"); 
		query.append("         SELECT 'Y' FROM EQR_VSL_LDIS_PLN_COD_TMP WHERE REPO_PLN_ID=@[repo_id] AND ROWNUM=1" ).append("\n"); 
		query.append("		) WHERE ROWNUM=1" ).append("\n"); 
		query.append("		),'N') AS REPO_PLN_LST" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    EQR_EQ_REPO_PLN  						" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = @[repo_id]" ).append("\n"); 

	}
}