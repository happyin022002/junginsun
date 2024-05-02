/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVoDAOMcsStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.20 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOMcsStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVoDAOMcsStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOMcsStatusRSQL").append("\n"); 
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
		query.append("''TRD_CD," ).append("\n"); 
		query.append("''RLANE_CD," ).append("\n"); 
		query.append("''ACCT_YRMON," ).append("\n"); 
		query.append("''STL_CMB_SEQ," ).append("\n"); 
		query.append("''JO_CRR_CD," ).append("\n"); 
		query.append("''JO_REV," ).append("\n"); 
		query.append("''JO_EXP," ).append("\n"); 
		query.append("''JO_BALANCE," ).append("\n"); 
		query.append("''BENEFIT_LINE," ).append("\n"); 
		query.append("'' FROM_DT," ).append("\n"); 
		query.append("'' TO_DT," ).append("\n"); 
		query.append("'' vvd_chk," ).append("\n"); 
		query.append("'' combined_chk," ).append("\n"); 
		query.append("''VVD," ).append("\n"); 
		query.append("''JO_STL_ITM_CD," ).append("\n"); 
		query.append("''RLANE_CD," ).append("\n"); 
		query.append("''OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}