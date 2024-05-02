/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchEDIContainerInfoByInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchEDIContainerInfoByInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR-IF 후 EDI 전송 데이터를 조회
	  * 
	  * AR-IF 한 CHARGE 중 MAX SEQ인 것만 전송한다.
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchEDIContainerInfoByInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchEDIContainerInfoByInvoiceRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",B.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",B.CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_CYC_NO" ).append("\n"); 
		query.append(",D.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("FROM DMT_INV_MN A, DMT_INV_DTL B, DMT_CHG_BKG_CNTR C, DMT_CHG_CALC D" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD    = B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO         = D.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO     = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD     = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND B.DMDT_CHG_LOC_DIV_CD = D.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND B.CHG_SEQ             = D.CHG_SEQ" ).append("\n"); 
		query.append("AND C.SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND C.CNTR_NO         = D.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO     = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND A.DMDT_INV_NO 	  = @[invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD	  = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND D.CHG_SEQ         = (SELECT MAX(CHG_SEQ) FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND CNTR_CYC_NO = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND DMDT_TRF_CD = D.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND dmdt_chg_loc_div_cd = D.DMDT_CHG_LOC_DIV_CD)" ).append("\n"); 

	}
}