/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqSlsRepOfcListRSQL.java
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

public class CommonDBDAOSearchSaqSlsRepOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기 S.Rep : User의 RGN OFC CD 하위의 OFC CD조회
	  * </pre>
	  */
	public CommonDBDAOSearchSaqSlsRepOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgnOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqSlsRepOfcListRSQL").append("\n"); 
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
		query.append("SELECT  OFC_CD  TEXT," ).append("\n"); 
		query.append("        OFC_CD  CODE" ).append("\n"); 
		query.append("FROM    SAQ_ORGANIZATION_V" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     N4TH_PRNT_OFC_CD    = @[rgnOfcCd]" ).append("\n"); 
		query.append("AND     DELT_FLG            = 'N'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        LVL" ).append("\n"); 

	}
}