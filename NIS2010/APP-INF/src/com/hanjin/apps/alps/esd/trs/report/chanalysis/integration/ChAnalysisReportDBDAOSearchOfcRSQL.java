/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChAnalysisReportDBDAOSearchOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.10.29 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChAnalysisReportDBDAOSearchOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * office 검색결과값을 리턴함
	  * </pre>
	  */
	public ChAnalysisReportDBDAOSearchOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("HID_BOUNDMODE",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.chanalysis.integration ").append("\n"); 
		query.append("FileName : ChAnalysisReportDBDAOSearchOfcRSQL").append("\n"); 
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
		query.append("OFC_CD" ).append("\n"); 
		query.append("FROM  	MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 	OFC_KND_CD > 1" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("START 	WITH OFC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	OFC_CD" ).append("\n"); 
		query.append("FROM	MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE	OFC_KND_CD = 3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${SEL_RHQMODE} != 'ALL')" ).append("\n"); 
		query.append("AND PRNT_OFC_CD = @[HID_BOUNDMODE]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 

	}
}