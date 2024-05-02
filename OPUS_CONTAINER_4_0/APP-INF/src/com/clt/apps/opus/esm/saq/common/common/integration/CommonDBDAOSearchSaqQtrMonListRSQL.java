/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqQtrMonListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqQtrMonListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기 S.Rep : 분기에 해당하는 월 가져오기
	  * </pre>
	  */
	public CommonDBDAOSearchSaqQtrMonListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bseQtrCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqQtrMonListRSQL").append("\n"); 
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
		query.append("SELECT CHR_CPY_NO AS CODE,                                                           " ).append("\n"); 
		query.append("       CHR_CPY_NO AS TEXT                                                            " ).append("\n"); 
		query.append("FROM   COM_CPY_NO                                                                    " ).append("\n"); 
		query.append("WHERE  1=1                                                                           " ).append("\n"); 
		query.append("AND    CPY_NO BETWEEN DECODE(@[bseQtrCd], '1Q', '01', '2Q', '04', '3Q', '07', '4Q', '10')      " ).append("\n"); 
		query.append("              AND     DECODE(@[bseQtrCd], '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12')      " ).append("\n"); 
		query.append("ORDER BY CPY_NO    " ).append("\n"); 

	}
}