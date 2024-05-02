/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.04 손은주(TRS)
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

public class InvoiceAuditDBDAOSearchVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor 정보를 조회한다
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration ").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchVendorRSQL").append("\n"); 
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
		query.append("VNDR_SEQ 		VNDR_NO" ).append("\n"); 
		query.append(",	VNDR_LGL_ENG_NM VNDR_NM_ENG" ).append("\n"); 
		query.append(",	B.CURR_CD		VNDR_CNT_CURR_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR		A" ).append("\n"); 
		query.append(",	MDM_CURRENCY 	B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VNDR_SEQ 		= @[combo_svc_provider]" ).append("\n"); 
		query.append("AND	A.VNDR_CNT_CD	= B.CNT_CD(+)" ).append("\n"); 
		query.append("AND	B.DELT_FLG(+)	= 'N'" ).append("\n"); 

	}
}