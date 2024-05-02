/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeDBDAOSearchOfficeLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2014.03.07 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOSearchOfficeLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeLevel
	  * </pre>
	  */
	public AgreementNoticeDBDAOSearchOfficeLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOSearchOfficeLevelRSQL").append("\n"); 
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
		query.append("#if(${code_gubun} == '' || ${code_gubun} == 'null')" ).append("\n"); 
		query.append("SELECT 'BB' AS CD, 'BB' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'HQ' AS CD, 'RHQ' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'HO' AS CD, 'HO' AS NM FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${code_gubun} == 'BB')" ).append("\n"); 
		query.append("SELECT 'BBG' AS CD, 'General Manager' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BBS' AS CD, 'Sales Manager' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BBO' AS CD, 'Operation Manager' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BBA' AS CD, 'Administrator' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PIC' AS CD, 'Person In Charge' AS NM FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${code_gubun} == 'HO')" ).append("\n"); 
		query.append("SELECT 'VP' AS CD, 'Vice President' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MGR' AS CD, 'Manager' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PIC' AS CD, 'Person In Charge' AS NM FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${code_gubun} == 'HQ')" ).append("\n"); 
		query.append("SELECT 'VP' AS CD, 'Vice President' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MGR' AS CD, 'Manager' AS NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PIC' AS CD, 'Person In Charge' AS NM FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}