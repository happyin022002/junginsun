/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315CurrInfoIsCurrVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.23 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee YounJung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315CurrInfoIsCurrVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for is_curr_vvd vo
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315CurrInfoIsCurrVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315CurrInfoIsCurrVvdRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("''curr_bound," ).append("\n"); 
		query.append("''curr_vvd," ).append("\n"); 
		query.append("''vsl_nm," ).append("\n"); 
		query.append("''vsl_cnt_cd," ).append("\n"); 
		query.append("''lloyd_cd," ).append("\n"); 
		query.append("''rly_name," ).append("\n"); 
		query.append("''rly_port," ).append("\n"); 
		query.append("''rly_amsqual," ).append("\n"); 
		query.append("''rly_amsport" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}