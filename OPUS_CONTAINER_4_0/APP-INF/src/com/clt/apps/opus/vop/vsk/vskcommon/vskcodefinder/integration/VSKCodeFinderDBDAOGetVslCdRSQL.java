/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VSKCodeFinderDBDAOGetVslCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOGetVslCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL_CD 값 구하기
	  * 1. CALL_SGN_NO값이 있으면 해당 VSL_CD선택
	  * 2. CALL_sGN_NO값에 해당하는 VSL_CD값이 없고 LLOYD_NO값에 
	  *    해당하는 값이 있으면 LLOYD_NO에 해당하는 VSL_CD선택
	  * </pre>
	  */
	public VSKCodeFinderDBDAOGetVslCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOGetVslCdRSQL").append("\n"); 
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
		query.append("SELECT 		VSL_CD" ).append("\n"); 
		query.append("     	,	CALL_SGN_NO" ).append("\n"); 
		query.append("     	, 	LLOYD_NO" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("			SELECT 		VSL_CD" ).append("\n"); 
		query.append("     				,	CALL_SGN_NO" ).append("\n"); 
		query.append("     				, 	LLOYD_NO" ).append("\n"); 
		query.append("			FROM   		MDM_VSL_CNTR" ).append("\n"); 
		query.append("			WHERE  		( 	CALL_SGN_NO 	= @[call_sgn_no]" ).append("\n"); 
		query.append("         				OR 	LLOYD_NO 		= @[lloyd_no]" ).append("\n"); 
		query.append("       					)" ).append("\n"); 
		query.append("			ORDER BY 	DECODE(DELT_FLG,'N','1','9')				ASC" ).append("\n"); 
		query.append("					,	DECODE(CALL_SGN_NO , @[call_sgn_no], 1, 2) 	ASC" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("WHERE		ROWNUM		= 1" ).append("\n"); 

	}
}