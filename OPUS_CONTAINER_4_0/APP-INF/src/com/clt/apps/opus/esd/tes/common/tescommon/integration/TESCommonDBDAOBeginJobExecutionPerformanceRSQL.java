/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESCommonDBDAOBeginJobExecutionPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2010.02.01 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOBeginJobExecutionPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance Seq
	  * </pre>
	  */
	public TESCommonDBDAOBeginJobExecutionPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tescommon.integration ").append("\n"); 
		query.append("FileName : TESCommonDBDAOBeginJobExecutionPerformanceRSQL").append("\n"); 
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
		query.append("SELECT TES_JB_EXE_PERF_LOG_SEQ.NEXTVAL SEQ FROM DUAL" ).append("\n"); 

	}
}