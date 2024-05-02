/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TESInterfaceManageDBDAOGetTabColumnsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.11.06 이정혜
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInterfaceManageDBDAOGetTabColumnsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetTabColumns
	  * </pre>
	  */
	public TESInterfaceManageDBDAOGetTabColumnsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("table_name",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ").append("\n"); 
		query.append("FileName : TESInterfaceManageDBDAOGetTabColumnsRSQL").append("\n"); 
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
		query.append("SELECT COLUMN_NAME" ).append("\n"); 
		query.append("FROM ALL_TAB_COLUMNS" ).append("\n"); 
		query.append("WHERE TABLE_NAME =  @[table_name]" ).append("\n"); 
		query.append("ORDER BY COLUMN_ID" ).append("\n"); 

	}
}