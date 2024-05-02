/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOXchRtInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.08 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOXchRtInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율조회정보 VO
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOXchRtInqVORSQL(){
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
		query.append("SELECT '' SORT1" ).append("\n"); 
		query.append(",'' SORT_NM" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' COL_JAN" ).append("\n"); 
		query.append(",'' COL_FEB" ).append("\n"); 
		query.append(",'' COL_MAR" ).append("\n"); 
		query.append(",'' COL_APR" ).append("\n"); 
		query.append(",'' COL_MAY" ).append("\n"); 
		query.append(",'' COL_JUN" ).append("\n"); 
		query.append(",'' COL_JUL" ).append("\n"); 
		query.append(",'' COL_AUG" ).append("\n"); 
		query.append(",'' COL_SEP" ).append("\n"); 
		query.append(",'' COL_OCT" ).append("\n"); 
		query.append(",'' COL_NOV" ).append("\n"); 
		query.append(",'' COL_DEC" ).append("\n"); 
		query.append(",'' ROW_CNT" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration ").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOXchRtInqVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}