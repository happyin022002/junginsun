/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAODeleteUploadFilesCOMUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAODeleteUploadFilesCOMUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DeleteUploadFilesCOM 
	  * </pre>
	  */
	public UncollectedCargoDBDAODeleteUploadFilesCOMUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAODeleteUploadFilesCOMUSQL").append("\n"); 
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
		query.append("UPDATE COM_UPLD_FILE" ).append("\n"); 
		query.append("SET DELT_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE PGM_SUB_SYS_CD = 'CIM'" ).append("\n"); 
		query.append("-- 다중처리" ).append("\n"); 
		query.append("#if ($s_file_sav_id.size() > 0)" ).append("\n"); 
		query.append("    AND FILE_SAV_ID IN (" ).append("\n"); 
		query.append("    #foreach($key in ${s_file_sav_id}) " ).append("\n"); 
		query.append("        #if($velocityCount < $s_file_sav_id.size()) " ).append("\n"); 
		query.append("            '$key', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}