/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodepublishDAOComIntgCdDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.edm.codepublish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodepublishDAOComIntgCdDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * com_intg_cd delete
	  * </pre>
	  */
	public CodepublishDAOComIntgCdDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM COM_INTG_CD" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = @[intg_cd_id]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.edm.codepublish.integration").append("\n"); 
		query.append("FileName : CodepublishDAOComIntgCdDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}