/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtherSOManageDBDAOSearchCostMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.09.15 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOSearchCostMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CostMonth search
	  * </pre>
	  */
	public OtherSOManageDBDAOSearchCostMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DATE",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration ").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOSearchCostMonthRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TO_DATE(@[DATE], 'YYYYMMDD') COST_MONTH" ).append("\n"); 
		query.append("FROM 	DUAL" ).append("\n"); 

	}
}