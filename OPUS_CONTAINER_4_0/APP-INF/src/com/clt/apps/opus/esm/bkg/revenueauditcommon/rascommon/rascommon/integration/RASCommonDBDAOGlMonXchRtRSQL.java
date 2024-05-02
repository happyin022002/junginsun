/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RASCommonDBDAOGlMonXchRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.23 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAOGlMonXchRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GlMonXchRt
	  * </pre>
	  */
	public RASCommonDBDAOGlMonXchRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration ").append("\n"); 
		query.append("FileName : RASCommonDBDAOGlMonXchRtRSQL").append("\n"); 
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
		query.append("SELECT  TO_CHAR(ROUND(TO_NUMBER(@[etc2]) / USD_LOCL_XCH_RT,2)) AS NM" ).append("\n"); 
		query.append("FROM    GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE   ACCT_XCH_RT_YRMON = SUBSTR(DECODE(NVL(@[etc3],''),'',TO_CHAR(SYSDATE,'YYYYMMDD'),@[etc3]),0,6)" ).append("\n"); 
		query.append("AND     CURR_CD = @[etc1]" ).append("\n"); 
		query.append("AND     ACCT_XCH_RT_LVL = '1'" ).append("\n"); 

	}
}