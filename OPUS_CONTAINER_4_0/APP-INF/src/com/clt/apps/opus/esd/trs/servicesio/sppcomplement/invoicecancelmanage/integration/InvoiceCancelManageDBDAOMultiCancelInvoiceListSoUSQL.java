/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceCancelManageDBDAOMultiCancelInvoiceListSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.invoicecancelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCancelManageDBDAOMultiCancelInvoiceListSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * So 테이블에 Surcharge 정보 Update
	  * </pre>
	  */
	public InvoiceCancelManageDBDAOMultiCancelInvoiceListSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.invoicecancelmanage.integration").append("\n"); 
		query.append("FileName : InvoiceCancelManageDBDAOMultiCancelInvoiceListSoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SET				" ).append("\n"); 
		query.append(" TRSP_INV_ACT_STS_CD	= ''		,		" ).append("\n"); 
		query.append(" INV_NO			= ''		,		" ).append("\n"); 
		query.append(" INV_VNDR_SEQ		= ''		,		" ).append("\n"); 
		query.append(" INV_BZC_AMT		= ''		,		" ).append("\n"); 
		query.append(" INV_ETC_ADD_AMT	= ''		,		" ).append("\n"); 
		query.append(" INV_CURR_CD		= ''		,		" ).append("\n"); 
		query.append(" INV_RMK		= ''		,		" ).append("\n"); 
		query.append(" SP_INV_RMK		= ''		," ).append("\n"); 
		query.append(" INV_XCH_RT		= ''		,		" ).append("\n"); 
		query.append(" UPD_USR_ID		= 'SPP_IF'	,		" ).append("\n"); 
		query.append(" UPD_DT			= SYSDATE ," ).append("\n"); 
		query.append(" LOCL_UPD_DT	= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append(" WHERE" ).append("\n"); 
		query.append(" INV_NO			= @[inv_no]" ).append("\n"); 
		query.append(" AND INV_VNDR_SEQ	= @[inv_vndr_seq]" ).append("\n"); 

	}
}