/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOIsStateCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOIsStateCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 코드가 State 코드인지를 조회하는 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOIsStateCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOIsStateCodeRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*)" ).append("\n"); 
		query.append("FROM    MDM_STATE" ).append("\n"); 
		query.append("WHERE   CNT_CD IN ('CA', 'US') AND STE_CD = @[ste_cd]" ).append("\n"); 

	}
}