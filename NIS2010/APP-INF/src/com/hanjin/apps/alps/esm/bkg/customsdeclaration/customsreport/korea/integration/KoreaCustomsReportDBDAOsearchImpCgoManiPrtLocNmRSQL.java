/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchImpCgoManiPrtLocNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.05 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchImpCgoManiPrtLocNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Print Header 정보의 적재항, 양륙항을 조회한다. 화물구분(Local T/S 항목)이 'I' 이면 화면상의 POL, POD를 인자값으로 하고, 화물구분이 'T' 이면 POL, FINAL POD를 인자값으로 한다.
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchImpCgoManiPrtLocNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration ").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchImpCgoManiPrtLocNmRSQL").append("\n"); 
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
		query.append("SELECT LOC1.CNT_CD||'-'||LOC1.LOC_NM LOC1_INFO" ).append("\n"); 
		query.append(", LOC2.CNT_CD||'-'||LOC2.LOC_NM LOC2_INFO" ).append("\n"); 
		query.append("FROM MDM_LOCATION LOC1, MDM_LOCATION LOC2" ).append("\n"); 
		query.append("WHERE LOC1.LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND LOC2.LOC_CD = @[pod_cd]" ).append("\n"); 

	}
}