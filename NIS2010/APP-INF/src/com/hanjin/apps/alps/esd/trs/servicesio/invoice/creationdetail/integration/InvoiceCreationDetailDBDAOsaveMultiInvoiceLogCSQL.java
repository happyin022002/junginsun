/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOsaveMultiInvoiceLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.03.19 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOsaveMultiInvoiceLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * saveMultiInvoiceLog
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOsaveMultiInvoiceLogCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOsaveMultiInvoiceLogCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SCG_DTL_TMP " ).append("\n"); 
		query.append("(	CRE_DT " ).append("\n"); 
		query.append(",	INV_FNE_CUZ_DESC " ).append("\n"); 
		query.append(",	LGS_COST_CD " ).append("\n"); 
		query.append(",	WO_PRV_GRP_SEQ " ).append("\n"); 
		query.append(",	TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append(",	TRSP_SO_SEQ " ).append("\n"); 
		query.append(",	N3PTY_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append("	SYSTIMESTAMP " ).append("\n"); 
		query.append("	,'TRS_SPP_INV_SAV_PRG' " ).append("\n"); 
		query.append("	,'SPP' " ).append("\n"); 
		query.append("	,TRS_TRSP_SCG_DTL_TMP_SEQ1.NEXTVAL " ).append("\n"); 
		query.append("	,a.trsp_so_ofc_cty_cd " ).append("\n"); 
		query.append("	,a.trsp_so_seq " ).append("\n"); 
		query.append("	,'SPP_INV_BZC_AMT:' || a.inv_bzc_amt " ).append("\n"); 
		query.append("	|| '/BZC_AMT:' || a.bzc_amt " ).append("\n"); 
		query.append("	|| '/FUEL_SCG_AMT:' || a.fuel_scg_amt" ).append("\n"); 
		query.append("	|| '/SCG_VAT_AMT:' || a.scg_vat_amt" ).append("\n"); 
		query.append("	|| '/ETC_ADD_AMT:' || a.etc_add_amt " ).append("\n"); 
		query.append("	|| '/NEGO_AMT:' || a.nego_amt" ).append("\n"); 
		query.append("	|| '/TOLL_FEE_AMT:' || a.toll_fee_amt" ).append("\n"); 
		query.append("	|| '/INV_NO:' || a.inv_no" ).append("\n"); 
		query.append("	,'SPP' " ).append("\n"); 
		query.append("	,'SPP'" ).append("\n"); 
		query.append("    ,SYSTIMESTAMP" ).append("\n"); 
		query.append(" from trs_trsp_svc_ord a " ).append("\n"); 
		query.append("where a.inv_no = @[inv_no] " ).append("\n"); 
		query.append(" and a.inv_vndr_seq = @[inv_vndr_seq]" ).append("\n"); 

	}
}