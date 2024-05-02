/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVODAOEstdVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.20 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOEstdVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EstdVvdVO
	  * </pre>
	  */
	public MakeVODAOEstdVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : MakeVODAOEstdVvdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' exe_yrmon," ).append("\n"); 
		query.append("'' acct_yrmon," ).append("\n"); 
		query.append("'' RLANE_CD," ).append("\n"); 
		query.append("'' VVDCODE," ).append("\n"); 
		query.append("'' yrmon_type," ).append("\n"); 
		query.append("''JO_CRR_CD," ).append("\n"); 
		query.append("''BSA_OP_JB_CD" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}