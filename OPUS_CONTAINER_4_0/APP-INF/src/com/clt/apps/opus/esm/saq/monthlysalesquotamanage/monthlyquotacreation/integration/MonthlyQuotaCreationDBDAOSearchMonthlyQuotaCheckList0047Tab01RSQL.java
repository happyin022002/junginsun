/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaCreationDBDAOSearchMonthlyQuotaCheckList0047Tab01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCreationDBDAOSearchMonthlyQuotaCheckList0047Tab01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Engine Status 조회를 위한 data 조회
	  * </pre>
	  */
	public MonthlyQuotaCreationDBDAOSearchMonthlyQuotaCheckList0047Tab01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCreationDBDAOSearchMonthlyQuotaCheckList0047Tab01RSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(SAQ_PPT_CD, -2) CODE, SAQ_PPT_DESC ITEM, SAQ_PPT_CTNT STATUS " ).append("\n"); 
		query.append("FROM   SAQ_COM_PPT " ).append("\n"); 
		query.append("WHERE  1=1 " ).append("\n"); 
		query.append("AND    SAQ_PPT_CD LIKE 'MON%' " ).append("\n"); 
		query.append("ORDER BY SAQ_PPT_CD" ).append("\n"); 

	}
}