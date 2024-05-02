/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrProvTpszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.09.17 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrProvTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 변경가능 컨테이너 타입사이즈를 조회한다.
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrProvTpszRSQL(){
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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration ").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceImportBkgBkgCntrProvTpszRSQL").append("\n"); 
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
		query.append("CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",   PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ACT_FLG		= 'Y'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD	= @[eq_tpsz_cd]" ).append("\n"); 
		query.append("AND PROV_CNTR_TPSZ_CD	= @[cntr_tpsz_cd]" ).append("\n"); 

	}
}