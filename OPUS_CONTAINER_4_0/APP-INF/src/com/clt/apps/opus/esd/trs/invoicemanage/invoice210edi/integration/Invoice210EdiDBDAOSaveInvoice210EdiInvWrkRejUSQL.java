/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * saveInvoice210Edi  TRS_TRSP_INV_WRK TABLE UPDATE
	  * </pre>
	  */
	public Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoice210edi.integration").append("\n"); 
		query.append("FileName : Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_INV_WRK" ).append("\n"); 
		query.append("   SET TRSP_INV_AUD_STS_CD = 'RJ'" ).append("\n"); 
		query.append("      ,INV_RJCT_FLG        = 'Y'" ).append("\n"); 
		query.append("      ,INV_RJCT_DT         = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT         = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,UPD_DT              = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append(" WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND INV_VNDR_SEQ = @[inv_vndr_seq]" ).append("\n"); 

	}
}