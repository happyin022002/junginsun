/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAOExcelTemplateFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.02.10 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOExcelTemplateFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Upload 되어있는 Excel Template File Key를 조회한다.
	  * </pre>
	  */
	public PRICommonDBDAOExcelTemplateFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_upld_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ").append("\n"); 
		query.append("FileName : PRICommonDBDAOExcelTemplateFileRSQL").append("\n"); 
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
		query.append("     , FILE_UPLD_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT FILE_SAV_ID" ).append("\n"); 
		query.append("         , FILE_UPLD_NM" ).append("\n"); 
		query.append("         , DENSE_RANK() OVER(PARTITION BY FILE_UPLD_NM" ).append("\n"); 
		query.append("                             ORDER BY FILE_UPLD_NM, CRE_DT DESC) AS SEQ" ).append("\n"); 
		query.append("    FROM COM_UPLD_FILE" ).append("\n"); 
		query.append("    WHERE PGM_SUB_SYS_CD = 'PRI'" ).append("\n"); 
		query.append("    AND   FILE_UPLD_NM = @[file_upld_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 

	}
}