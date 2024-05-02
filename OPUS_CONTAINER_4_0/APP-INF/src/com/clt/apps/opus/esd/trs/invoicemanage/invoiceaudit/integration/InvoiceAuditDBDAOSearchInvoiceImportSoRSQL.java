/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceImportSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceImportSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O번호로 S/O, W/O, Container정보를 조회
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceImportSoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("form_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceImportSoRSQL").append("\n"); 
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
		query.append(" 	A.TRSP_SO_OFC_CTY_CD		" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ				" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD		" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_SEQ				" ).append("\n"); 
		query.append(" ,	A.EQ_NO	" ).append("\n"); 
		query.append(" ,	A.EQ_TPSZ_CD				" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_TP_CD				" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_STS_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_INV_ACT_STS_CD		" ).append("\n"); 
		query.append(" ,	A.CURR_CD" ).append("\n"); 
		query.append(" ,	(	NVL(A.BZC_AMT, 0)		" ).append("\n"); 
		query.append(" 	+	NVL(A.NEGO_AMT, 0)		" ).append("\n"); 
		query.append(" 	+	NVL(A.FUEL_SCG_AMT, 0)	" ).append("\n"); 
		query.append(" 	+	NVL(A.ETC_ADD_AMT, 0)	" ).append("\n"); 
		query.append(" 	)	AS WO_TOT_AMT			" ).append("\n"); 
		query.append(" , A.INV_NO" ).append("\n"); 
		query.append(" , A.INV_VNDR_SEQ				" ).append("\n"); 
		query.append(" , A.VNDR_SEQ" ).append("\n"); 
		query.append(" , A.BZC_AMT" ).append("\n"); 
		query.append(" , A.NEGO_AMT" ).append("\n"); 
		query.append(" , A.FUEL_SCG_AMT				" ).append("\n"); 
		query.append(" , A.ETC_ADD_AMT				" ).append("\n"); 
		query.append(" , A.BKG_NO			" ).append("\n"); 
		query.append(" , A.ORG_BKG_NO						" ).append("\n"); 
		query.append(" , A.TRSP_BND_CD				" ).append("\n"); 
		query.append(" , A.TRSP_COST_DTL_MOD_CD		" ).append("\n"); 
		query.append(" , B.INV_OFC_CD				" ).append("\n"); 
		query.append(" , TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT			" ).append("\n"); 
		query.append(" , A.FM_NOD_CD" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append(" 	TRS_TRSP_SVC_ORD A			" ).append("\n"); 
		query.append(" ,	TRS_TRSP_INV_OFC B			" ).append("\n"); 
		query.append(" WHERE" ).append("\n"); 
		query.append("   A.TRSP_SO_OFC_CTY_CD	= @[trsp_so_ofc_cty_cd]	" ).append("\n"); 
		query.append(" AND A.TRSP_SO_SEQ	= @[trsp_so_seq]	" ).append("\n"); 
		query.append(" AND A.DELT_FLG		= 'N'" ).append("\n"); 
		query.append(" AND A.CRE_OFC_CD	= B.OFC_CD				" ).append("\n"); 
		query.append(" AND B.INV_OFC_CD	= @[form_usr_ofc_cd]" ).append("\n"); 

	}
}