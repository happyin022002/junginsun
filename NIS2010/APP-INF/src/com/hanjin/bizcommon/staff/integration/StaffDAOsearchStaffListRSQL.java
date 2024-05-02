/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StaffDAOsearchStaffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 노형춘
*@LastVersion : 1.0
* 2011.07.12 노형춘
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.staff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ROHHYUNGCHOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StaffDAOsearchStaffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select Staff list
	  * </pre>
	  */
	public StaffDAOsearchStaffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.staff.integration").append("\n"); 
		query.append("FileName : StaffDAOsearchStaffListRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD," ).append("\n"); 
		query.append("	    USR_ID," ).append("\n"); 
		query.append("	    USR_NM," ).append("\n"); 
		query.append("	    USR_EML" ).append("\n"); 
		query.append("FROM (SELECT ROW_NUMBER() OVER (ORDER BY usr_id ASC) NO,  	" ).append("\n"); 
		query.append("		 OFC_CD," ).append("\n"); 
		query.append("		 USR_ID," ).append("\n"); 
		query.append("	    	 USR_NM," ).append("\n"); 
		query.append("	    	 USR_EML" ).append("\n"); 
		query.append("	  FROM COM_USER" ).append("\n"); 
		query.append("	  WHERE 1 = 1 " ).append("\n"); 
		query.append("		AND NVL(USE_FLG, 'Y') <> 'N'		" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("		AND OFC_CD like @[ofc_cd] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${usr_id} != '')        " ).append("\n"); 
		query.append("		AND USR_ID like @[usr_id] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${usr_nm} != '')   " ).append("\n"); 
		query.append("		AND (upper(USR_NM) like '%' || upper(@[usr_nm]) || '%' or USR_LOCL_NM like '%' || @[usr_nm] || '%')     " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) A	                     " ).append("\n"); 
		query.append("WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}