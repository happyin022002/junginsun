/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JooFileUploadDBDAOFileUploadInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JooFileUploadDBDAOFileUploadInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 첨부파일 Add, Delete 기능 수행
	  * </pre>
	  */
	public JooFileUploadDBDAOFileUploadInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_save_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_val1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_val7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_val6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_val3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_val2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_val5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("col_val4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.integration").append("\n"); 
		query.append("FileName : JooFileUploadDBDAOFileUploadInfoUSQL").append("\n"); 
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
		query.append("UPDATE	${tbl_nm}" ).append("\n"); 
		query.append("SET		atch_file_id = @[file_save_id]" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("		#if (${col_nm1}!='')" ).append("\n"); 
		query.append("		AND	${col_nm1}   = @[col_val1]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${col_nm2}!='')" ).append("\n"); 
		query.append("		AND	${col_nm2}   = @[col_val2]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${col_nm3}!='')" ).append("\n"); 
		query.append("		AND	${col_nm3}   = @[col_val3]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${col_nm4}!='')" ).append("\n"); 
		query.append("		AND	${col_nm4}   = @[col_val4]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${col_nm5}!='')" ).append("\n"); 
		query.append("		AND	${col_nm5}   = @[col_val5]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${col_nm6}!='')" ).append("\n"); 
		query.append("		AND ${col_nm6}   = @[col_val6]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${col_nm7}!='')" ).append("\n"); 
		query.append("		AND ${col_nm7}   = @[col_val7]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 

	}
}