/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchInvoiceSheetSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchInvoiceSheetSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB -> JO TPB -> JO TPB Insert Setting
	  * Search 기능
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchInvoiceSheetSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchInvoiceSheetSetRSQL").append("\n"); 
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
		query.append("SELECT INV_ISS_OFC_CD" ).append("\n"); 
		query.append(",CO_NM" ).append("\n"); 
		query.append(",OFC_ADDR" ).append("\n"); 
		query.append(",OFC_PHN_NO" ).append("\n"); 
		query.append(",OFC_FAX_NO" ).append("\n"); 
		query.append(",BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",INV_RMK1" ).append("\n"); 
		query.append(",INV_RMK2" ).append("\n"); 
		query.append(",VAT_XCH_RT" ).append("\n"); 
		query.append(",VAT_XCH_RT / 100 VAT_XCH_RT_DIV" ).append("\n"); 
		query.append("FROM TPB_INV_SH_SET" ).append("\n"); 
		query.append("WHERE INV_ISS_OFC_CD = @[s_inv_iss_ofc_cd]" ).append("\n"); 

	}
}