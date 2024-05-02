/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceImportEmptyWoRSQL.java
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

public class InvoiceAuditDBDAOSearchInvoiceImportEmptyWoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * W/O번호로 EQ_NO 가 null인 S/O, W/O 정보를 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceImportEmptyWoRSQL(){
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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceImportEmptyWoRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append(" 	A.TRSP_SO_OFC_CTY_CD	" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ			" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD	" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_SEQ			" ).append("\n"); 
		query.append(" ,	A.EQ_NO	" ).append("\n"); 
		query.append(" ,	A.EQ_TPSZ_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_TP_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_STS_CD		" ).append("\n"); 
		query.append(" ,	A.TRSP_INV_ACT_STS_CD	" ).append("\n"); 
		query.append(" ,	A.CURR_CD" ).append("\n"); 
		query.append(" ,	(	NVL(A.BZC_AMT, 0)	" ).append("\n"); 
		query.append(" 	+	NVL(A.NEGO_AMT, 0)	" ).append("\n"); 
		query.append(" 	+	NVL(A.FUEL_SCG_AMT, 0)" ).append("\n"); 
		query.append("	+	NVL(A.SCG_VAT_AMT, 0)" ).append("\n"); 
		query.append(" 	+	NVL(A.ETC_ADD_AMT, 0)" ).append("\n"); 
		query.append("    +	NVL(A.TOLL_FEE_AMT, 0)" ).append("\n"); 
		query.append(" 	)	AS INV_BZC_AMT			" ).append("\n"); 
		query.append(" , A.INV_NO" ).append("\n"); 
		query.append(" , A.INV_VNDR_SEQ			" ).append("\n"); 
		query.append(" , A.VNDR_SEQ" ).append("\n"); 
		query.append(" , NVL(A.BZC_AMT, 0) BZC_AMT" ).append("\n"); 
		query.append(" , NVL(A.NEGO_AMT, 0) NEGO_AMT" ).append("\n"); 
		query.append(" , NVL(A.FUEL_SCG_AMT, 0) FUEL_SCG_AMT" ).append("\n"); 
		query.append(" , NVL(A.SCG_VAT_AMT, 0) SCG_VAT_AMT			" ).append("\n"); 
		query.append(" , NVL(A.ETC_ADD_AMT, 0) ETC_ADD_AMT" ).append("\n"); 
		query.append(" , NVL(A.TOLL_FEE_AMT, 0) TOLL_FEE_AMT" ).append("\n"); 
		query.append(" , A.BKG_NO		" ).append("\n"); 
		query.append(" , A.ORG_BKG_NO				" ).append("\n"); 
		query.append(" , A.TRSP_BND_CD			" ).append("\n"); 
		query.append(" , A.TRSP_COST_DTL_MOD_CD	" ).append("\n"); 
		query.append(" , B.INV_OFC_CD	CRE_OFC_CD		" ).append("\n"); 
		query.append(" , TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT	" ).append("\n"); 
		query.append(" , A.FM_NOD_CD" ).append("\n"); 
		query.append(" FROM		" ).append("\n"); 
		query.append(" 	TRS_TRSP_SVC_ORD A		" ).append("\n"); 
		query.append(" ,	TRS_TRSP_INV_OFC B		" ).append("\n"); 
		query.append(" WHERE		" ).append("\n"); 
		query.append(" 	TRSP_WO_OFC_CTY_CD	= @[trsp_wo_ofc_cty_cd]		" ).append("\n"); 
		query.append(" AND TRSP_WO_SEQ		= @[trsp_wo_seq]		" ).append("\n"); 
		query.append(" AND EQ_NO			IS NULL	" ).append("\n"); 
		query.append(" AND A.DELT_FLG		= 'N'	" ).append("\n"); 
		query.append(" AND A.CRE_OFC_CD	= B.OFC_CD" ).append("\n"); 
		query.append(" AND B.INV_OFC_CD	= @[FORM_USR_OFC_CD]		" ).append("\n"); 
		query.append(" AND NVL(A.TRSP_FRST_FLG,'N')	= 'N'	" ).append("\n"); 
		query.append("		/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append(" AND A.HJL_NO IS NULL" ).append("\n"); 

	}
}