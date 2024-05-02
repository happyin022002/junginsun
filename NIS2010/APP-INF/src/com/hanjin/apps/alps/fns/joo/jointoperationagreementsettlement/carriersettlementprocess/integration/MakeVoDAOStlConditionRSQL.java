/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVoDAOStlConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.11.17 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOStlConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVoDAOStlConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOStlConditionRSQL").append("\n"); 
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
		query.append("SELECT  ''ACCT_YRMON," ).append("\n"); 
		query.append("        ''ACCT_YRMON_FR," ).append("\n"); 
		query.append("        ''ACCT_YRMON_TO," ).append("\n"); 
		query.append("        ''JO_CRR_CD," ).append("\n"); 
		query.append("        ''TRD_CD," ).append("\n"); 
		query.append("        ''REV_DIR_CD," ).append("\n"); 
		query.append("        ''RLANE_CD," ).append("\n"); 
		query.append("	    ''RE_DIVR_CD," ).append("\n"); 
		query.append("        ''JO_STL_ITM_CD," ).append("\n"); 
		query.append("        ''REOPT," ).append("\n"); 
		query.append("        ''STL_CMB_SEQ," ).append("\n"); 
		query.append("        ''OFC_CD," ).append("\n"); 
		query.append("        ''DIFF_ONLY_YN," ).append("\n"); 
		query.append("        ''RMK_YN" ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 

	}
}