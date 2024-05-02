/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EASCommonDBDAOYardLocCdNodCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.01 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EASCommonDBDAOYardLocCdNodCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * YardLocCdNodCd
	  * </pre>
	  */
	public EASCommonDBDAOYardLocCdNodCdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.eas.eascommon.integration").append("\n"); 
		query.append("FileName : EASCommonDBDAOYardLocCdNodCdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SUBSTR(YD_CD, 6, 7) NOD_CD" ).append("\n"); 
		query.append("      , YD_NM" ).append("\n"); 
		query.append("   FROM MDM_YARD" ).append("\n"); 
		query.append("  WHERE SUBSTR(YD_CD, 1, 5) = @[loc_cd]" ).append("\n"); 
		query.append("    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SUBSTR(YD_CD, 6, 7) DESC " ).append("\n"); 

	}
}