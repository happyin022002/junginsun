/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationManageDBDAOsetYearMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.19
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.19 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationManageDBDAOsetYearMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * setYearMonth
	  * </pre>
	  */
	public SpecialCargoQuotationManageDBDAOsetYearMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.integration").append("\n"); 
		query.append("FileName : SpecialCargoQuotationManageDBDAOsetYearMonthRSQL").append("\n"); 
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
		query.append("SELECT NVL(TO_CHAR(AH.EXE_FM_DT,'YYYY-MM'),'') AS YEAR_MONTH" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR AH" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EXE_STS_CD = 'C'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND AH.TRSP_ACT_COST_SEQ = (" ).append("\n"); 
		query.append("SELECT MAX(H.TRSP_ACT_COST_SEQ)" ).append("\n"); 
		query.append("FROM TRS_ACT_COST_HDR H" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}