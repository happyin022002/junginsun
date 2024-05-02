/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOXchRtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.05.11 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration ;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtDBDAOXchRtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율조회
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOXchRtInfoRSQL(){
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
		query.append("select '' curr_cd" ).append("\n"); 
		query.append(", '' curr_nm" ).append("\n"); 
		query.append(", '' jan" ).append("\n"); 
		query.append(", '' feb" ).append("\n"); 
		query.append(", '' mar" ).append("\n"); 
		query.append(", '' apr" ).append("\n"); 
		query.append(", '' may" ).append("\n"); 
		query.append(", '' jun" ).append("\n"); 
		query.append(", '' jul" ).append("\n"); 
		query.append(", '' aug" ).append("\n"); 
		query.append(", '' sep" ).append("\n"); 
		query.append(", '' oct" ).append("\n"); 
		query.append(", '' nov" ).append("\n"); 
		query.append(", '' dec" ).append("\n"); 
		query.append("from GEM_XCH_RT" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration ").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOXchRtInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}