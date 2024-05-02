/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORsltAllPerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.06.18 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltAllPerListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_RAT_UT 전체 조회
	  * </pre>
	  */
	public PRICommonDBDAORsltAllPerListVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("RAT_UT_CD AS CD" ).append("\n"); 
		query.append(",RAT_UT_CD||'\t'||RAT_UT_DESC AS NM" ).append("\n"); 
		query.append("FROM PRI_RAT_UT" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY RAT_UT_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration ").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltAllPerListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}