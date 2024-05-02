/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOSearchSingleTransportationSOCandidatesListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOSearchSingleTransportationSOCandidatesListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 발행 대상 조회
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOSearchSingleTransportationSOCandidatesListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.integration").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOSearchSingleTransportationSOCandidatesListRSQL").append("\n"); 
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
		query.append("#if (${cydoor_div} == 'CY')" ).append("\n"); 
		query.append("    #if (${ui_conti_cd} == 'E')" ).append("\n"); 
		query.append("        select * from table(TRS_CYDOOR_PKG.F_GET_CY_CANDIDATE('HAMSC', 'P', '20080520', '20080605', '', " ).append("\n"); 
		query.append("        '', '', '','', '', " ).append("\n"); 
		query.append("        '', '','', '', ''," ).append("\n"); 
		query.append("        '','','','','',''," ).append("\n"); 
		query.append("        '',''));" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}