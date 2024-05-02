/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveInvoiceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.16
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.08.16 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSaveInvoiceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Save
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveInvoiceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveInvoiceCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_INV_WRK (" ).append("\n"); 
		query.append("	   INV_NO" ).append("\n"); 
		query.append("      ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	  ,TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("	  ,WO_VNDR_SEQ" ).append("\n"); 
		query.append("	  ,INV_CURR_CD" ).append("\n"); 
		query.append("	  ,INV_BZC_AMT" ).append("\n"); 
		query.append("	  ,INV_VAT_AMT" ).append("\n"); 
		query.append("      ,INV_WHLD_TAX_AMT" ).append("\n"); 
		query.append("	  ,INV_TTL_AMT" ).append("\n"); 
		query.append("	  ,INV_RCV_DT" ).append("\n"); 
		query.append("	  ,INV_ISS_DT" ).append("\n"); 
		query.append("	  ,IF_SYS_KND_CD" ).append("\n"); 
		query.append("      ,INV_HLD_FLG" ).append("\n"); 
		query.append("	  ,DELT_FLG" ).append("\n"); 
		query.append("	  ,CRE_OFC_CD" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("	  ,LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    SELECT A.INV_NO" ).append("\n"); 
		query.append("          ,A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("  	      ,'SV' TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("	      ,A.INV_VNDR_SEQ WO_VNDR_SEQ" ).append("\n"); 
		query.append("          ,A.INV_CURR_CD" ).append("\n"); 
		query.append("          ,A.INV_BZC_AMT" ).append("\n"); 
		query.append("      	  ,A.INV_VAT_AMT" ).append("\n"); 
		query.append("          ,A.INV_WHLD_TAX_AMT" ).append("\n"); 
		query.append("     	  ,A.INV_TTL_AMT" ).append("\n"); 
		query.append("   	      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = A.INV_VNDR_SEQ)) INV_RCV_DT" ).append("\n"); 
		query.append("  	      ,A.INV_ISS_DT" ).append("\n"); 
		query.append(" 	      ,'I' IF_SYS_KND_CD" ).append("\n"); 
		query.append("          ,'N' INV_HLD_FLG" ).append("\n"); 
		query.append(" 	      ,'N' DELT_FLG " ).append("\n"); 
		query.append("	      ,(SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = A.INV_VNDR_SEQ) CRE_OFC_CD" ).append("\n"); 
		query.append("	      ,'HIT_INV_EDI'" ).append("\n"); 
		query.append("	      ,SYSDATE" ).append("\n"); 
		query.append("	      ,'HIT_INV_EDI'" ).append("\n"); 
		query.append("	      ,SYSDATE" ).append("\n"); 
		query.append("	      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = A.INV_VNDR_SEQ)) LOCL_CRE_DT" ).append("\n"); 
		query.append("	      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = A.INV_VNDR_SEQ)) LOCL_UPD_DT " ).append("\n"); 
		query.append("     FROM TRS_INV_EDI_RCV  A" ).append("\n"); 
		query.append("    WHERE A.INV_EDI_RCV_SEQ = @[inv_edi_rcv_seq]" ).append("\n"); 
		query.append("      AND A.VAL_CHK_FLG = 'Y'" ).append("\n"); 

	}
}