/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationReportDBDAODeleteSpecificReasonListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAODeleteSpecificReasonListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationReportDBDAODeleteSpecificReasonListVORSQL
	  * </pre>
	  */
	public ChargeCalculationReportDBDAODeleteSpecificReasonListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration ").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAODeleteSpecificReasonListVORSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT3 AS INTG_CD_VAL_CTNT, ATTR_CTNT4 AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'CHG_DELT_RSN_CD'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = @[del_cd]" ).append("\n"); 
		query.append("ORDER BY HRD_CDG_ID_SEQ" ).append("\n"); 

	}
}