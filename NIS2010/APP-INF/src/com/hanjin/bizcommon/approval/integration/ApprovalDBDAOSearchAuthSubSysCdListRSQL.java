/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOSearchAuthSubSysCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
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

public class ApprovalDBDAOSearchAuthSubSysCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Authorization 모듈 리스트 조회
	  * </pre>
	  */
	public ApprovalDBDAOSearchAuthSubSysCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration").append("\n"); 
		query.append("FileName : ApprovalDBDAOSearchAuthSubSysCdListRSQL").append("\n"); 
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
		query.append("DISTINCT P.SUB_SYS_CD AS SUB_SYS_CD_AUTH, P.SUB_SYS_CD AS SUB_SYS_CD" ).append("\n"); 
		query.append("FROM COM_AUTH_PGM P, COM_AUTH_PGM_BTN B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.AUTH_PGM_SEQ = B.AUTH_PGM_SEQ" ).append("\n"); 
		query.append("AND NVL(P.USE_FLG,'N') = 'Y' " ).append("\n"); 
		query.append("AND NVL(B.USE_FLG,'N') = 'Y' " ).append("\n"); 
		query.append("AND DECODE(@[auth_apro_tp_cd],NULL,'ALL','','ALL','ALL','ALL',@[auth_apro_tp_cd]) = DECODE(@[auth_apro_tp_cd],NULL,'ALL','','ALL','ALL','ALL',B.AUTH_APRO_TP_CD)" ).append("\n"); 
		query.append("ORDER BY P.SUB_SYS_CD ASC" ).append("\n"); 

	}
}