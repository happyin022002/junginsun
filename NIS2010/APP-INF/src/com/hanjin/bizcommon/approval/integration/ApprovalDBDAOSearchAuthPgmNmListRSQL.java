/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOSearchAuthPgmNmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOSearchAuthPgmNmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization 0U2 Program List 조회
	  * </pre>
	  */
	public ApprovalDBDAOSearchAuthPgmNmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAuthPgmNmListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("DISTINCT P.PGM_NO, C.PGM_NM" ).append("\n"); 
		query.append("FROM COM_AUTH_PGM P, COM_PROGRAM C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.PGM_NO = C.PGM_NO" ).append("\n"); 
		query.append("AND DECODE(@[sub_sys_cd],NULL,'ALL','','ALL','ALL','ALL',P.SUB_SYS_CD) = DECODE(@[sub_sys_cd],NULL,'ALL','','ALL','ALL','ALL',@[sub_sys_cd])" ).append("\n"); 
		query.append("AND NVL(P.USE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("AND NVL(C.USE_FLG,'N') = 'Y' " ).append("\n"); 

	}
}