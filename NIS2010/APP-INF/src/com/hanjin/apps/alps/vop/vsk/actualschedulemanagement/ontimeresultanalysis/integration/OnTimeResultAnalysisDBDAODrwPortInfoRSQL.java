/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAODrwPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAODrwPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drewry Port의 상세한 정보를 가지고 온다.
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAODrwPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAODrwPortInfoRSQL").append("\n"); 
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
		query.append("     T1.CONTI_CD " ).append("\n"); 
		query.append("    ,T3.CONTI_NM " ).append("\n"); 
		query.append("    ,T1.SCONTI_CD " ).append("\n"); 
		query.append("    ,T4.SCONTI_NM " ).append("\n"); 
		query.append("    ,T2.PORT_CD " ).append("\n"); 
		query.append("FROM    MDM_LOCATION  T1, " ).append("\n"); 
		query.append("        VSK_DRW_TGT_PORT T2, " ).append("\n"); 
		query.append("        MDM_CONTINENT T3, " ).append("\n"); 
		query.append("        MDM_SUBCONTINENT T4" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.LOC_CD = T2.PORT_CD " ).append("\n"); 
		query.append("AND T1.CONTI_CD = T3.CONTI_CD " ).append("\n"); 
		query.append("AND T1.SCONTI_CD = T4.SCONTI_CD" ).append("\n"); 
		query.append("AND	T2.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("ORDER BY T1.CONTI_CD , T1.SCONTI_CD , T2.PORT_CD" ).append("\n"); 

	}
}