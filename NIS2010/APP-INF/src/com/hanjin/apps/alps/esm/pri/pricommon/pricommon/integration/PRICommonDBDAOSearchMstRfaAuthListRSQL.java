/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRICommonDBDAOSearchMstRfaAuthListRSQL.java
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

public class PRICommonDBDAOSearchMstRfaAuthListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA의 권한 PRI17과 승인권자 권한을 조회한다.
	  * </pre>
	  */
	public PRICommonDBDAOSearchMstRfaAuthListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchMstRfaAuthListRSQL").append("\n"); 
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
		query.append(" SELECT --[usr_id] AS CD" ).append("\n"); 
		query.append("       MAX(ETC1) AS CD -- 생성/Amend/Copy (PRI02 + PRI17)" ).append("\n"); 
		query.append("     , '' AS NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT A.USR_ID" ).append("\n"); 
		query.append("         , DECODE(COUNT(A.USR_ID), 0, 'N', 'Y') ETC1" ).append("\n"); 
		query.append("         , '' ETC2" ).append("\n"); 
		query.append("      FROM COM_USER A" ).append("\n"); 
		query.append("         , COM_USR_ROLE_MTCH C" ).append("\n"); 
		query.append("         , COM_USR_ROLE_MTCH D" ).append("\n"); 
		query.append("     WHERE A.USR_ID = C.USR_ID" ).append("\n"); 
		query.append("       AND A.USR_ID = D.USR_ID" ).append("\n"); 
		query.append("       AND A.USE_FLG = 'Y'" ).append("\n"); 
		query.append("       AND C.USR_ROLE_CD = 'PRI02'" ).append("\n"); 
		query.append("       AND D.USR_ROLE_CD = 'PRI17'" ).append("\n"); 
		query.append("	   AND A.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     GROUP BY A.USR_ID" ).append("\n"); 
		query.append("  ) A" ).append("\n"); 

	}
}