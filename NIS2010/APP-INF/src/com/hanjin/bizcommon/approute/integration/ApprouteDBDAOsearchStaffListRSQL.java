/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ApprouteDBDAOsearchStaffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.10.11 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprouteDBDAOsearchStaffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApprouteDBDAOsearchStaffList
	  * </pre>
	  */
	public ApprouteDBDAOsearchStaffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd_deptsrch",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approute.integration").append("\n"); 
		query.append("FileName : ApprouteDBDAOsearchStaffListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("USR_NM," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("PSN_ENG_NM," ).append("\n"); 
		query.append("USR_ID" ).append("\n"); 
		query.append("FROM COM_USER" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(USE_FLG, 'Y') <> 'N'" ).append("\n"); 
		query.append("AND OFC_CD LIKE @[ofc_cd_deptsrch] || '%'" ).append("\n"); 
		query.append("ORDER BY PSN_ENG_NM, USR_NM" ).append("\n"); 

	}
}