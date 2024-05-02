/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAORsltMotTrfSvcScpCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.19
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.05.19 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltMotTrfSvcScpCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MOT Tariff 화면에서 사용되는 Service Scope List 가져오기
	  * PRI_MOT_FILE_LOC_PPT 에 등록되어있는 Service Scope 만을 가져온다.
	  * </pre>
	  */
	public SCReportDBDAORsltMotTrfSvcScpCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltMotTrfSvcScpCdListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       A.SVC_SCP_CD AS CD" ).append("\n"); 
		query.append("	  ,A.SVC_SCP_NM AS NM" ).append("\n"); 
		query.append("FROM   MDM_SVC_SCP A" ).append("\n"); 
		query.append("	,  PRI_MOT_FILE_LOC_PPT B" ).append("\n"); 
		query.append("WHERE  A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    B.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("AND	   A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("ORDER BY A.SVC_SCP_CD" ).append("\n"); 

	}
}