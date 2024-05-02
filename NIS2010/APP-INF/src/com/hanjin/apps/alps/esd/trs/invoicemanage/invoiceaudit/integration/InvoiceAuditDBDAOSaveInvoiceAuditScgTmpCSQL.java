/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAuditDBDAOSaveInvoiceAuditScgTmpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.22 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSaveInvoiceAuditScgTmpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Temp 정보 입력
	  * </pre>
	  */
	public InvoiceAuditDBDAOSaveInvoiceAuditScgTmpCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toll_fee_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fuel_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nego_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSaveInvoiceAuditScgTmpCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SCG_DTL_TMP							" ).append("\n"); 
		query.append(" (	INV_FNE_CUZ_DESC	" ).append("\n"); 
		query.append(" ,	LGS_COST_CD			" ).append("\n"); 
		query.append(" ,	WO_PRV_GRP_SEQ		" ).append("\n"); 
		query.append(" ,	TRSP_SO_OFC_CTY_CD	" ).append("\n"); 
		query.append(" ,	TRSP_SO_SEQ			" ).append("\n"); 
		query.append(" ,	N3PTY_DESC	" ).append("\n"); 
		query.append(" ,	CRE_USR_ID" ).append("\n"); 
		query.append(" ,	CRE_DT" ).append("\n"); 
		query.append(" ,	UPD_USR_ID" ).append("\n"); 
		query.append(" ,	UPD_DT" ).append("\n"); 
		query.append(" ,	LOCL_CRE_DT" ).append("\n"); 
		query.append(" ,	LOCL_UPD_DT		" ).append("\n"); 
		query.append(" ) VALUES					" ).append("\n"); 
		query.append(" (	'TRS_SPP_INV_SAV_PRG'" ).append("\n"); 
		query.append(" ,	'SPP'				" ).append("\n"); 
		query.append(" ,	TRS_TRSP_SCG_DTL_TMP_SEQ1.NEXTVAL					" ).append("\n"); 
		query.append(" ,	@[trsp_so_ofc_cty_cd]					" ).append("\n"); 
		query.append(" ,	@[trsp_so_seq]					" ).append("\n"); 
		query.append(" ,	@[n3pty_desc]					" ).append("\n"); 
		query.append(" 		||(SELECT '/BZC_AMT:'	|| @[bzc_amt]						" ).append("\n"); 
		query.append(" 			|| '/FUEL_SCG_AMT:'	|| @[fuel_scg_amt]	" ).append("\n"); 
		query.append("			|| '/SCG_VAT_AMT:'	|| @[scg_vat_amt]						" ).append("\n"); 
		query.append(" 			|| '/ETC_ADD_AMT:'	|| @[etc_add_amt]						" ).append("\n"); 
		query.append(" 			|| '/NEGO_AMT:'	    || @[nego_amt]" ).append("\n"); 
		query.append("            || '/TOLL_FEE_AMT:'	|| @[toll_fee_amt]						" ).append("\n"); 
		query.append(" 			FROM			" ).append("\n"); 
		query.append(" 				TRS_TRSP_SVC_ORD							" ).append("\n"); 
		query.append(" 			WHERE			" ).append("\n"); 
		query.append(" 				TRSP_SO_OFC_CTY_CD 	= @[trsp_so_ofc_cty_cd]						" ).append("\n"); 
		query.append(" 			AND TRSP_SO_SEQ			= @[trsp_so_seq]						" ).append("\n"); 
		query.append(" 			)	" ).append("\n"); 
		query.append(" , @[FORM_CRE_USR_ID]" ).append("\n"); 
		query.append(" , SYSDATE	" ).append("\n"); 
		query.append(" , @[FORM_CRE_USR_ID]	" ).append("\n"); 
		query.append(" , SYSDATE	" ).append("\n"); 
		query.append(" , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])" ).append("\n"); 
		query.append(" , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])	" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}