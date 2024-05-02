/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TESCommonDBDAOTemplateFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOExcelTemplateFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES Agreement Template file
	  * </pre>
	  */
	public TESCommonDBDAOExcelTemplateFileRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration ").append("\n"); 
		query.append("FileName : TESCommonDBDAOTemplateFileRSQL").append("\n"); 
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
		query.append(", FILE_UPLD_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT FILE_SAV_ID" ).append("\n"); 
		query.append(", FILE_UPLD_NM" ).append("\n"); 
		query.append(", DENSE_RANK() OVER(PARTITION BY FILE_UPLD_NM" ).append("\n"); 
		query.append("ORDER BY FILE_UPLD_NM, CRE_DT DESC) AS SEQ" ).append("\n"); 
		query.append("FROM COM_UPLD_FILE" ).append("\n"); 
		query.append("WHERE PGM_SUB_SYS_CD = 'TES'" ).append("\n"); 
		query.append("AND   FILE_UPLD_NM = @[file_upld_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SEQ = 1" ).append("\n"); 

	}
}