/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchSubTrdCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchSubTrdCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub Trdae Code 조회
	  * </pre>
	  */
	public TESCommonDBDAOSearchSubTrdCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.tescommon.integration ").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchSubTrdCdListRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(SUB_TRD_CD,'|')),'|') AS SUB_TRD_CD " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT ROWNUM ROW_ID " ).append("\n"); 
		query.append("            , Z.SUB_TRD_CD " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT SUB_TRD_CD " ).append("\n"); 
		query.append("                FROM MDM_SUB_TRD " ).append("\n"); 
		query.append("               WHERE DELT_FLG='N' " ).append("\n"); 
		query.append("               ORDER BY SUB_TRD_CD " ).append("\n"); 
		query.append("              ) Z " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1 START WITH ROW_ID = 1" ).append("\n"); 

	}
}