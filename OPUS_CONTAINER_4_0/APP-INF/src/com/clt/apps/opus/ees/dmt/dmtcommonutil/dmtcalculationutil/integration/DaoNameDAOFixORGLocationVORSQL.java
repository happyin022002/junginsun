/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOFixORGLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOFixORGLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FixORGLocationVO
	  * </pre>
	  */
	public DaoNameDAOFixORGLocationVORSQL(){
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
		query.append("select" ).append("\n"); 
		query.append("'' org_conti_cd" ).append("\n"); 
		query.append(",'' org_cnt_cd" ).append("\n"); 
		query.append(",'' org_rgn_cd" ).append("\n"); 
		query.append(",'' org_ste_cd" ).append("\n"); 
		query.append(",'' org_cd" ).append("\n"); 
		query.append(",'' msg_cd" ).append("\n"); 
		query.append(",'' msg_desc" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOFixORGLocationVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}