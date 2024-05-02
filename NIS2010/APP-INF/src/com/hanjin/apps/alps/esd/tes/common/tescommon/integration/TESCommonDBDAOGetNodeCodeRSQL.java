/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESCommonDBDAOGetNodeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.04 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOGetNodeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Node(Yard) Info Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOGetNodeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOGetNodeCodeRSQL").append("\n"); 
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
		query.append("SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(NOD_CD,'|')),'|')" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	DISTINCT SUBSTR(YD_CD, 6, 7) NOD_CD" ).append("\n"); 
		query.append(", ROWNUM ROW_ID" ).append("\n"); 
		query.append("FROM	MDM_YARD" ).append("\n"); 
		query.append("WHERE	SUBSTR(YD_CD, 1, 5) = @[loc_cd]" ).append("\n"); 
		query.append("AND	 DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SUBSTR(YD_CD, 6, 7) DESC" ).append("\n"); 
		query.append(") CONNECT BY PRIOR ROW_ID = ROW_ID -1" ).append("\n"); 
		query.append("START	WITH ROW_ID = 1" ).append("\n"); 

	}
}