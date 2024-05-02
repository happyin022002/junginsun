/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOCurrencyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOCurrencyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCurrencyList
	  * </pre>
	  */
	public DMTCommonDBDAOCurrencyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOCurrencyVORSQL").append("\n"); 
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
		query.append("SELECT  CURR_CD" ).append("\n"); 
		query.append(",	CURR_NM" ).append("\n"); 
		query.append("#if(${use_rt_curr} == 'Y')" ).append("\n"); 
		query.append(",	DECODE(CURR_CD, @[rt_curr_cd], 1, 2) AS IDX" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	DECODE(CNT_CD, @[cnt_cd], 1, 2) AS IDX" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM    MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE   DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${rt_curr_cd} != '')" ).append("\n"); 
		query.append("AND (CURR_CD = @[rt_curr_cd] OR CNT_CD IN (@[cnt_cd], 'US', 'EU'))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND CNT_CD IN (@[cnt_cd], 'US', 'EU')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY IDX, CURR_CD ASC" ).append("\n"); 

	}
}