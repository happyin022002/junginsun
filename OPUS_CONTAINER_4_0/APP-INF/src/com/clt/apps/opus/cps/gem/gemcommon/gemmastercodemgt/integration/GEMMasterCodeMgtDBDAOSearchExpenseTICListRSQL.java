/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchExpenseTICListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.09
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.09 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtDBDAOSearchExpenseTICListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용주관팀으로 정의된 조직코드(Office Code) 정보
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchExpenseTICListRSQL(){
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
		query.append("select OFC_CD" ).append("\n"); 
		query.append("from GEM_OFFICE" ).append("\n"); 
		query.append("where TIC_AUTH_FLG = 'Y'" ).append("\n"); 
		query.append("and DELT_FLG = 'N'" ).append("\n"); 
		query.append("order by OFC_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchExpenseTICListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}