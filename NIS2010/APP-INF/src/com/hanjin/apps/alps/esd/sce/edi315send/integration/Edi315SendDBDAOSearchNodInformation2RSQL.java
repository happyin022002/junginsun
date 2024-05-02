/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Edi315SendDBDAOSearchNodInformation2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchNodInformation2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * YARD NAME 조회
	  * </pre>
	  */
	public Edi315SendDBDAOSearchNodInformation2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchNodInformation2RSQL").append("\n"); 
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
		query.append("SELECT YD_NM AS EVENT_YD_NAME" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT YD_NM" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("         WHERE YD_CD = @[e_event_yard]" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT LSE_CO_YD_NM" ).append("\n"); 
		query.append("          FROM MDM_LSE_CO_YD" ).append("\n"); 
		query.append("         WHERE LSE_CO_YD_CD = @[e_event_yard]" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}