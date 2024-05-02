/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchCLMHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
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
		query.append("      C.CLM_CRR_NM       ," ).append("\n"); 
		query.append("      S.CLM_SGHT_ABBR_NM ," ).append("\n"); 
		query.append("      TO_CHAR(C.ARR_DT   , 'YYYY-MM-DD HH24:MI:SS') ARR_DT ," ).append("\n"); 
		query.append("      C.ARR_LOC_NM       ," ).append("\n"); 
		query.append("      C.ARR_STE_CD       ," ).append("\n"); 
		query.append("      C.DEP_LOC_NM       ," ).append("\n"); 
		query.append("      C.DEP_STE_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("      SCE_CLM_IF   C ," ).append("\n"); 
		query.append("      SCE_CLM_SGHT S ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      trs_trsp_rail_bil_ord   str," ).append("\n"); 
		query.append("      sce_rail_splc rss" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE C.CNTR_NO     = @[eq_no]" ).append("\n"); 
		query.append("AND   C.CLM_SGHT_CD = S.CLM_SGHT_CD" ).append("\n"); 
		query.append("AND   C.ARR_DT BETWEEN TO_DATE( @[wbl_dt]||'000001', 'YYYYMMDDHH24MISS') AND TO_DATE( @[wbl_dt]||'235959', 'YYYYMMDDHH24MISS')+30" ).append("\n"); 
		query.append("  AND    c.cntr_no                 = str.eq_no" ).append("\n"); 
		query.append("  AND    SUBSTR(str.to_nod_cd, 1, 5) = rss.loc_cd" ).append("\n"); 
		query.append("  AND    c.dep_ste_cd              = rss.ste_cd" ).append("\n"); 
		query.append("  AND    c.arr_dt between str.cre_dt and ADD_MONTHS(str.cre_dt,1)" ).append("\n"); 
		query.append("  AND    str.delt_flg  = 'N'" ).append("\n"); 
		query.append("  AND    rss.splc_cd                 > 500" ).append("\n"); 
		query.append("  AND    DEST_GATE_OUT_DT IS NULL" ).append("\n"); 
		query.append("ORDER BY ARR_DT DESC" ).append("\n"); 

	}
}