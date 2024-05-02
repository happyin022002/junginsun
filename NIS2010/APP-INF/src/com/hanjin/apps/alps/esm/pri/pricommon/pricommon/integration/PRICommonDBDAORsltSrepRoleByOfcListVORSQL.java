/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAORsltSrepRoleByOfcListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSrepRoleByOfcListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRICommonDBDAORsltSrepRoleByOfcListVORSQL
	  * </pre>
	  */
	public PRICommonDBDAORsltSrepRoleByOfcListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSrepRoleByOfcListVORSQL").append("\n"); 
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
		query.append("SELECT A.USR_ID CD" ).append("\n"); 
		query.append("     , A.USR_NM NM" ).append("\n"); 
		query.append("     , A.OFC_CD ETC2" ).append("\n"); 
		query.append("  FROM COM_USER A" ).append("\n"); 
		query.append("     , COM_USR_ROLE_MTCH B" ).append("\n"); 
		query.append(" WHERE A.USR_ID = B.USR_ID " ).append("\n"); 
		query.append("   AND A.USE_FLG = 'Y'" ).append("\n"); 
		query.append("   AND B.USR_ROLE_CD IN ('PRI02' , 'PRI17')" ).append("\n"); 
		query.append("   AND OFC_CD = @[etc1] -- SELCMA" ).append("\n"); 
		query.append(" GROUP BY A.USR_ID, A.USR_NM, A.OFC_CD" ).append("\n"); 
		query.append(" ORDER BY A.USR_NM" ).append("\n"); 

	}
}