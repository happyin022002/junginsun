/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PrdCommonManageDBDAOIsPrdNodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2011.03.02 김진주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimJinJoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOIsPrdNodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRD Node에 등록된 Data인지 확인한다.
	  * </pre>
	  */
	public PrdCommonManageDBDAOIsPrdNodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOIsPrdNodeRSQL").append("\n"); 
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
		query.append("SELECT nod_cd FROM prd_node	" ).append("\n"); 
		query.append(" WHERE nod_cd = @[pk]" ).append("\n"); 

	}
}