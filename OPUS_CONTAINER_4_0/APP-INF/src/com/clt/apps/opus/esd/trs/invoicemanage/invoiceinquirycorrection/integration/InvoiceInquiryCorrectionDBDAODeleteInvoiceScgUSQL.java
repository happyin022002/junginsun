/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceScgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceInquiryCorrectionDBDAODeleteInvoiceScgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge 정보를 수정
	  * </pre>
	  */
	public InvoiceInquiryCorrectionDBDAODeleteInvoiceScgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : InvoiceInquiryCorrectionDBDAODeleteInvoiceScgUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SCG_DTL SET" ).append("\n"); 
		query.append(" 	INV_SCG_AMT			= ''" ).append("\n"); 
		query.append(" ,	INV_DRY_RUN_RLBL_PTY_TP_CD	= ''" ).append("\n"); 
		query.append(" ,	INV_FNE_CUZ_DESC		= ''" ).append("\n"); 
		query.append(" ,	INV_FUMG_COST_TP_CD		= ''" ).append("\n"); 
		query.append(" ,	INV_MGST_TPSZ_CD		= ''" ).append("\n"); 
		query.append(" ,	INV_INSP_RF_PTI_CSTMS_TP_CD	= ''" ).append("\n"); 
		query.append(" ,	INV_LFTG_KNT			= ''" ).append("\n"); 
		query.append(" ,	INV_LFTG_CUZ_DESC		= ''" ).append("\n"); 
		query.append(" ,	INV_STOP_LOC_NOD_CD		= ''" ).append("\n"); 
		query.append(" ,	INV_GRS_WGT			= ''" ).append("\n"); 
		query.append(" ,	INV_INCRT_DT			= ''" ).append("\n"); 
		query.append(" ,	INV_SCL_STOP_PLC_NOD_CD		= ''" ).append("\n"); 
		query.append(" ,	INV_STO_DYS			= ''" ).append("\n"); 
		query.append(" ,	INV_OB_BKG_NO			= ''" ).append("\n"); 
		query.append(" ,	INV_WT_HRS			= ''" ).append("\n"); 
		query.append(" ,	INV_OTR_RMK			= ''" ).append("\n"); 
		query.append(" ,	UPD_USR_ID			= @[FORM_CRE_USR_ID]	" ).append("\n"); 
		query.append(" ,	UPD_DT				= SYSDATE		" ).append("\n"); 
		query.append(" ,	LOCL_UPD_DT			= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])" ).append("\n"); 
		query.append(" ,  INV_CHSS_NO 			= ''	" ).append("\n"); 
		query.append(" ,	INV_INCUR_DT		= ''" ).append("\n"); 
		query.append(" WHERE	" ).append("\n"); 
		query.append(" TRSP_SO_SEQ	IN 	" ).append("\n"); 
		query.append(" (		" ).append("\n"); 
		query.append(" 	SELECT TRSP_SO_SEQ FROM TRS_TRSP_SVC_ORD 	" ).append("\n"); 
		query.append(" 	WHERE " ).append("\n"); 
		query.append(" 	INV_NO			= @[inv_no]			" ).append("\n"); 
		query.append(" 	AND INV_VNDR_SEQ	= @[inv_vndr_seq]	" ).append("\n"); 
		query.append(" )		" ).append("\n"); 
		query.append(" AND NVL(SCG_AMT, 0)	<> 0" ).append("\n"); 

	}
}