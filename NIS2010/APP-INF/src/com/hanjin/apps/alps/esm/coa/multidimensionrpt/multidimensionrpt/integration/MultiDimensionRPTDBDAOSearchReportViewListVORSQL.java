/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchReportViewListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.14 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchReportViewListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    COA_RPT_AUTH_MGMT 테이블의 레포트 별 권한 조회
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchReportViewListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchReportViewListVORSQL").append("\n"); 
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
		query.append("SELECT MIN(TO_NUMBER(RPT_SEQ)) AS RPT_SEQ" ).append("\n"); 
		query.append(",OFC_LVL" ).append("\n"); 
		query.append(",OFC_LVL_DESC" ).append("\n"); 
		query.append(",MAX(DECODE(PFIT_VW_CD, 'P', PFIT_VW_SLCT_FLG)) AS PFIT_CD1" ).append("\n"); 
		query.append(",MAX(DECODE(PFIT_VW_CD, 'R', PFIT_VW_SLCT_FLG)) AS PFIT_CD2" ).append("\n"); 
		query.append(",MAX(DECODE(PFIT_VW_DFLT_CD,'Y', PFIT_VW_CD)) AS PFIT_DFLT" ).append("\n"); 
		query.append(",MAX(DECODE(OFC_VW_CD, 'C', OFC_VW_SLCT_FLG)) AS OFC_CD1" ).append("\n"); 
		query.append(",MAX(DECODE(OFC_VW_CD, 'L', OFC_VW_SLCT_FLG)) AS OFC_CD2" ).append("\n"); 
		query.append(",MAX(DECODE(OFC_VW_DFLT_CD, 'Y', OFC_VW_CD)) AS OFC_DFLT" ).append("\n"); 
		query.append(",MAX(DECODE(PFIT_LVL_CD, 'C', PFIT_LVL_SLCT_FLG)) AS LVL_CD1" ).append("\n"); 
		query.append(",MAX(DECODE(PFIT_LVL_CD, 'O', PFIT_LVL_SLCT_FLG)) AS LVL_CD2" ).append("\n"); 
		query.append(",MAX(DECODE(PFIT_LVL_DFLT_CD, 'Y', PFIT_LVL_CD)) AS LVL_DFLT" ).append("\n"); 
		query.append("FROM COA_RPT_AUTH_MGMT" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("GROUP BY OFC_LVL, OFC_LVL_DESC" ).append("\n"); 
		query.append("ORDER BY OFC_LVL" ).append("\n"); 

	}
}