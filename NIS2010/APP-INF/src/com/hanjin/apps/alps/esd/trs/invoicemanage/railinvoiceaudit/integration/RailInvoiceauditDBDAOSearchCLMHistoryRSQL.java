/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchCLMHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.08.31 최진오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchCLMHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCLMHistory SELECT
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchCLMHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceaudit.integration ").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchCLMHistoryRSQL").append("\n"); 
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
		query.append("C.CLM_CRR_NM       ," ).append("\n"); 
		query.append("S.CLM_SGHT_ABBR_NM ," ).append("\n"); 
		query.append("TO_CHAR(C.ARR_DT   , 'YYYY-MM-DD HH24:MI:SS') ARR_DT ," ).append("\n"); 
		query.append("C.ARR_LOC_NM       ," ).append("\n"); 
		query.append("C.ARR_STE_CD       ," ).append("\n"); 
		query.append("C.DEP_LOC_NM       ," ).append("\n"); 
		query.append("C.DEP_STE_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_CLM      C ," ).append("\n"); 
		query.append("SCE_CLM_SGHT S" ).append("\n"); 
		query.append("WHERE C.CNTR_NO     = @[eq_no]" ).append("\n"); 
		query.append("AND   C.CLM_SGHT_CD = S.CLM_SGHT_CD" ).append("\n"); 
		query.append("AND   ARR_DT BETWEEN TO_DATE( @[wbl_dt]||'000001', 'YYYYMMDDHH24MISS') AND TO_DATE( @[wbl_dt]||'235959', 'YYYYMMDDHH24MISS')+30" ).append("\n"); 
		query.append("ORDER BY ARR_DT DESC" ).append("\n"); 

	}
}