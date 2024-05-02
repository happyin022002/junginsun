/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchEDIMappingCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.13
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.12.13 이석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOsearchEDIMappingCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV(CHM-201006884) ui 2개 신규 개발
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOsearchEDIMappingCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchEDIMappingCodeListRSQL").append("\n"); 
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
		query.append("select a.INTG_CD_ID,b.HJS_CD_VAL_CTNT,b.HJS_CD_VAL_DESC,b.CUST_CD_VAL_CTNT,b.CUST_CD_VAL_DESC" ).append("\n"); 
		query.append("  from INV_EDI_INTG_CD a,INV_EDI_INTG_CD_DTL b " ).append("\n"); 
		query.append(" where a.INTG_CD_ID = b.INTG_CD_ID" ).append("\n"); 
		query.append("   and a.INTG_CD_ID = @[intg_cd_id]" ).append("\n"); 
		query.append("order by b.HJS_CD_VAL_CTNT" ).append("\n"); 

	}
}