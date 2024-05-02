/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOsearchMonthListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOsearchMonthListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRID 타이틀 월정보 조회
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOsearchMonthListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_bse_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_bse_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration ").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOsearchMonthListRSQL").append("\n"); 
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
		query.append("SELECT BSE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT BSE_DT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT B.SEQ SEQ" ).append("\n"); 
		query.append("              ,TO_CHAR(ADD_MONTHS(A.BSE_DT,SEQ-1),'YYYYMM') BSE_DT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                 SELECT TO_DATE(@[from_bse_dt],'YYYYMM') BSE_DT   " ).append("\n"); 
		query.append("                 FROM DUAL" ).append("\n"); 
		query.append("             ) A" ).append("\n"); 
		query.append("            ,(" ).append("\n"); 
		query.append("                 SELECT LEVEL SEQ   " ).append("\n"); 
		query.append("                 FROM DUAL " ).append("\n"); 
		query.append("                 CONNECT BY LEVEL <=12 -- 최대 12개 하드코딩" ).append("\n"); 
		query.append("             ) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.BSE_DT BETWEEN @[from_bse_dt] AND @[to_bse_dt]" ).append("\n"); 

	}
}