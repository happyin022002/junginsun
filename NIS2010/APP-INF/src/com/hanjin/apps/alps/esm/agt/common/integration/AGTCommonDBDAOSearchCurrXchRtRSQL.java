/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOSearchCurrXchRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.04.16 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchCurrXchRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCurrXchRt
	  * </pre>
	  */
	public AGTCommonDBDAOSearchCurrXchRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("currCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aplyDt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchCurrXchRtRSQL").append("\n"); 
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
		query.append("SELECT b.usd_locl_xch_rt as xchRt" ).append("\n"); 
		query.append("FROM gl_mon_xch_rt b" ).append("\n"); 
		query.append("WHERE b.acct_xch_rt_yrmon = SUBSTR(@[aplyDt],1,6)" ).append("\n"); 
		query.append("AND b.acct_xch_rt_lvl = '1'" ).append("\n"); 
		query.append("AND b.curr_cd = @[currCd]" ).append("\n"); 

	}
}