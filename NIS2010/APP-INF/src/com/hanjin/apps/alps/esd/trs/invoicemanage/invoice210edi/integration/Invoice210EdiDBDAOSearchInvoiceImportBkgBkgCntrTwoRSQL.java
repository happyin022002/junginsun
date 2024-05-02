/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrTwoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.10.13 최진오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrTwoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceImportBkgBkgCntr-Two SELECT
	  * </pre>
	  */
	public Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrTwoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration ").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrTwoRSQL").append("\n"); 
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
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM  SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE ACT_FLG           = 'Y'" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD      = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND   PROV_CNTR_TPSZ_CD = @[prov_cntr_tpsz_cd]" ).append("\n"); 

	}
}