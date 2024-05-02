/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchBsaOpJbCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchBsaOpJbCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_OP_JB 테이블 조회
	  * </pre>
	  */
	public CommonDBDAOSearchBsaOpJbCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchBsaOpJbCodeRSQL").append("\n"); 
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
		query.append("SELECT	BSA_OP_JB_CD CODE" ).append("\n"); 
		query.append("	,	BSA_OP_JB_DESC NAME" ).append("\n"); 
		query.append("  FROM	BSA_OP_JB" ).append("\n"); 
		query.append(" WHERE	BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append(" ORDER	BY CASE WHEN BSA_OP_CD = '3' AND BSA_OP_JB_CD = '017' THEN '001' 	--20150513.ADD : BSA_OP_CD=3 만(현재 0028만)" ).append("\n"); 
		query.append("                WHEN BSA_OP_CD = '3' AND BSA_OP_JB_CD = '023' THEN '002' " ).append("\n"); 
		query.append("                ELSE BSA_OP_JB_CD END" ).append("\n"); 

	}
}