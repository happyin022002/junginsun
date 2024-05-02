/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnersAccountDBDAOCustomTaxDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOCustomTaxDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CustomTaxDtl
	  * </pre>
	  */
	public OwnersAccountDBDAOCustomTaxDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOCustomTaxDtlRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     ITM_NM" ).append("\n"); 
		query.append("    ,TO_CHAR(SPL_AMT,'FM999,999,999,999,999,990') SPL_AMT" ).append("\n"); 
		query.append("    ,TO_CHAR(TAX_AMT,'FM999,999,999,999,999,990') TAX_AMT" ).append("\n"); 
		query.append("    ,TO_CHAR(SPL_AMT + TAX_AMT,'FM999,999,999,999,999,990') TOTAL_AMT    " ).append("\n"); 
		query.append("FROM FMS_TAX_DTL F" ).append("\n"); 
		query.append("WHERE (F.TAX_INV_YRMON, F.OFC_CD, F.TAX_SER_NO) IN (" ).append("\n"); 
		query.append("                                                    SELECT F.TAX_INV_YRMON, F.OFC_CD, F.TAX_SER_NO FROM FMS_TAX F" ).append("\n"); 
		query.append("                                                    WHERE F.SLP_TP_CD||F.SLP_FUNC_CD||F.SLP_OFC_CD||F.SLP_ISS_DT||F.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     ITM_NM" ).append("\n"); 
		query.append("    ,TO_CHAR(SPL_AMT,'FM999,999,999,999,999,990') SPL_AMT" ).append("\n"); 
		query.append("    ,'0' TAX_AMT" ).append("\n"); 
		query.append("    ,TO_CHAR(SPL_AMT,'FM999,999,999,999,999,990') TOTAL_AMT    " ).append("\n"); 
		query.append("FROM FMS_BIL_DTL F" ).append("\n"); 
		query.append("WHERE (F.BIL_INV_YRMON, F.OFC_CD, F.BIL_SER_NO) IN (" ).append("\n"); 
		query.append("                                                    SELECT F.BIL_INV_YRMON, F.OFC_CD, F.BIL_SER_NO FROM FMS_BILL F" ).append("\n"); 
		query.append("                                                    WHERE F.SLP_TP_CD||F.SLP_FUNC_CD||F.SLP_OFC_CD||F.SLP_ISS_DT||F.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 

	}
}