/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonDBDAOSearchYardCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.12.23 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchYardCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchYardCodeData
	  * </pre>
	  */
	public MSTCommonDBDAOSearchYardCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchYardCodeDataRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(YD_NM),2) CODE_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '2'||NVL(A.YD_NM,A.YD_CD||'*') YD_NM" ).append("\n"); 
		query.append("FROM  MDM_YARD A" ).append("\n"); 
		query.append("WHERE A.YD_CD = @[code]" ).append("\n"); 
		query.append("AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '1'||NVL(A.LSE_CO_YD_NM,A.LSE_CO_YD_CD||'*') YD_NM" ).append("\n"); 
		query.append("FROM  MDM_LSE_CO_YD A" ).append("\n"); 
		query.append("WHERE A.LSE_CO_YD_CD = @[code]" ).append("\n"); 
		query.append("AND   @[yd_chk_flg] = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}