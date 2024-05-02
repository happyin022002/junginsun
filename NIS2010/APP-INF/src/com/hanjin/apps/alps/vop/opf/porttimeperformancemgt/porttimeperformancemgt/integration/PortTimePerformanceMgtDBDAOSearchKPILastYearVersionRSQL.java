/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOSearchKPILastYearVersionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.07.13 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOSearchKPILastYearVersionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 KPI에 속해 있는 최종 년도와 Version 정보를 표시한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * 2012.07.09 문동선 [CHM-201218855-01] Base line 입력화면 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOSearchKPILastYearVersionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOSearchKPILastYearVersionRSQL").append("\n"); 
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
		query.append("#if(${tab_chk}=='KPI'||${tab_chk}=='')" ).append("\n"); 
		query.append("SELECT  DISTINCT KPI_TGT_YR AS KPI_TGT_YR" ).append("\n"); 
		query.append("FROM    OPF_PORT_TM_KPI" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  TO_CHAR( SYSDATE, 'YYYY' ) AS KPI_TGT_YR" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("ORDER BY KPI_TGT_YR DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tab_chk}=='BSEL')" ).append("\n"); 
		query.append("SELECT  DISTINCT BSEL_YR AS KPI_TGT_YR" ).append("\n"); 
		query.append("FROM    OPF_PORT_TM_BSEL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  TO_CHAR( SYSDATE -365, 'YYYY' ) AS KPI_TGT_YR" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("ORDER BY KPI_TGT_YR DESC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}