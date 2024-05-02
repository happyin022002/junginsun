/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TrsCommonDBDAOsearchFileAllRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOsearchFileAllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsCommonDBDAOsearchFileAllRSQL
	  * </pre>
	  */
	public TrsCommonDBDAOsearchFileAllRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration ").append("\n"); 
		query.append("FileName : TrsCommonDBDAOsearchFileAllRSQL").append("\n"); 
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
		query.append("SELECT FILE_SAV_ID" ).append("\n"); 
		query.append("      ,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append("  FROM TRS_ATCH_FILE" ).append("\n"); 
		query.append(" WHERE ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 

	}
}