/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchVVDForMaxINVInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.10.22 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchVVDForMaxINVInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchVVDForMaxINVInterfaceRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchVVDForMaxINVInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchVVDForMaxINVInterfaceRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("	 , SKD_DIR_CD" ).append("\n"); 
		query.append("	 , IO_BND_CD" ).append("\n"); 
		query.append("	 , SAIL_DT" ).append("\n"); 
		query.append("	 , SAIL_ARR_DT" ).append("\n"); 
		query.append("	 , SLAN_CD" ).append("\n"); 
		query.append("	 , TRNK_VSL_CD" ).append("\n"); 
		query.append("	 , TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("	 , TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("	 , POR_CD" ).append("\n"); 
		query.append("	 , POL_CD" ).append("\n"); 
		query.append("	 , POD_CD" ).append("\n"); 
		query.append("	 , DEL_CD" ).append("\n"); 
		query.append("	 , SVC_SCP_CD" ).append("\n"); 
		query.append("	 , REV_VSL_CD" ).append("\n"); 
		query.append("	 , REV_SKD_VOY_NO" ).append("\n"); 
		query.append("	 , REV_SKD_DIR_CD " ).append("\n"); 
		query.append("	 , REV_DIR_CD " ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("	 , ZN_IOC_CD" ).append("\n"); 
		query.append("  FROM INV_AR_MN" ).append("\n"); 
		query.append(" WHERE AR_IF_NO IN (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                      FROM INV_AR_MN" ).append("\n"); 
		query.append("                     WHERE BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                       AND AR_OFC_CD   = @[ofc_cd]" ).append("\n"); 
		query.append("                       AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                       AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                       AND INV_DELT_DIV_CD <> 'Y')" ).append("\n"); 

	}
}