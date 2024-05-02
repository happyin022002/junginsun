/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchTruckInvoiceFileImportRSQL.java
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

public class InvoiceAuditDBDAOSearchTruckInvoiceFileImportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceFileImport를 통해 입력해주는 데이터를 조회한다.
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchTruckInvoiceFileImportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sub_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchTruckInvoiceFileImportRSQL").append("\n"); 
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
		query.append("SELECT							" ).append("\n"); 
		query.append("	@[eq_no]		AS EQ_NO			 	" ).append("\n"); 
		query.append(" ,	@[eq_no]		AS ORG_EQ_NO		 	" ).append("\n"); 
		query.append(" ,	@[eq_tpsz_cd]       AS EQ_TPSZ_CD			" ).append("\n"); 
		query.append(" ,	A.ORG_EQ_TPSZ_CD				" ).append("\n"); 
		query.append(" ,	A.EQ_KND_CD					 	" ).append("\n"); 
		query.append(" ,	SUBSTR(A.FM_NOD_CD,1,5) FM_LOC_VALUE							" ).append("\n"); 
		query.append(" ,	SUBSTR(A.FM_NOD_CD,6,2) FM_YARD_VALUE							" ).append("\n"); 
		query.append(" ,	SUBSTR(A.VIA_NOD_CD,1,5) VIA_LOC_VALUE						 	" ).append("\n"); 
		query.append(" ,	SUBSTR(A.VIA_NOD_CD,6,2) VIA_YARD_VALUE						 	" ).append("\n"); 
		query.append(" ,	SUBSTR(A.TO_NOD_CD,1,5) TO_LOC_VALUE							" ).append("\n"); 
		query.append(" ,	SUBSTR(A.TO_NOD_CD,6,2) TO_YARD_VALUE							" ).append("\n"); 
		query.append(" ,	SUBSTR(A.DOR_NOD_CD,1,5) DOR_LOC_VALUE						 	" ).append("\n"); 
		query.append(" ,	SUBSTR(A.DOR_NOD_CD,6,2) DOR_YARD_VALUE						 	" ).append("\n"); 
		query.append(" ,	A.CUST_CNT_CD					" ).append("\n"); 
		query.append(" ,	A.CUST_SEQ					 	" ).append("\n"); 
		query.append(" ,	A.DOR_DE_ADDR					" ).append("\n"); 
		query.append(" ,	A.CURR_CD						" ).append("\n"); 
		query.append(" ,	NVL(A.BZC_AMT,0) 	  BZC_AMT						" ).append("\n"); 
		query.append(" ,	NVL(A.NEGO_AMT,0) 	  NEGO_AMT			 	" ).append("\n"); 
		query.append(" ,	NVL(A.FUEL_SCG_AMT,0) FUEL_SCG_AMT	" ).append("\n"); 
		query.append(" ,	NVL(A.SCG_VAT_AMT,0)  SCG_VAT_AMT			 	" ).append("\n"); 
		query.append(" ,	NVL(A.ETC_ADD_AMT,0)  ETC_ADD_AMT" ).append("\n"); 
		query.append(" ,	NVL(A.TOLL_FEE_AMT,0) TOLL_FEE_AMT" ).append("\n"); 
		query.append(" ,	(	 						 	" ).append("\n"); 
		query.append("		NVL(A.BZC_AMT,0)		+ 	" ).append("\n"); 
		query.append("		NVL(A.NEGO_AMT,0)		+ 	" ).append("\n"); 
		query.append("		NVL(A.FUEL_SCG_AMT,0)	+ 	" ).append("\n"); 
		query.append("		NVL(A.SCG_VAT_AMT,0)	+ " ).append("\n"); 
		query.append("		NVL(A.ETC_ADD_AMT,0)	+" ).append("\n"); 
		query.append("        NVL(A.TOLL_FEE_AMT,0) 	" ).append("\n"); 
		query.append("	) AS WO_TOT_AMT	 		 		" ).append("\n"); 
		query.append(" ,	'TM' AS TRSP_INV_CALC_LGC_TP_CD	" ).append("\n"); 
		query.append(" ,	1 AS INV_XCH_RT					" ).append("\n"); 
		query.append(" ,	@[inv_curr_cd] AS INV_CURR_CD				" ).append("\n"); 
		query.append(" ,	(	 						 	" ).append("\n"); 
		query.append("		NVL(A.BZC_AMT,0)		+ 	" ).append("\n"); 
		query.append("		NVL(A.NEGO_AMT,0)		+ 	" ).append("\n"); 
		query.append("		NVL(A.FUEL_SCG_AMT,0)	+" ).append("\n"); 
		query.append("		NVL(A.SCG_VAT_AMT,0)	+ " ).append("\n"); 
		query.append("	    NVL(A.TOLL_FEE_AMT,0) 	+	" ).append("\n"); 
		query.append("		NVL(A.ETC_ADD_AMT,0)	 	" ).append("\n"); 
		query.append("	) AS INV_BZC_AMT 		 		" ).append("\n"); 
		query.append(" ,	A.INV_ETC_ADD_AMT				" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_SEQ					" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD_SEQ  	" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD')	CRE_DT							" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'HH24:MI:SS')	CRE_TM								" ).append("\n"); 
		query.append(" ,	A.BKG_NO									 	" ).append("\n"); 
		query.append(" ,	A.BL_NO BL_NO						 					 	" ).append("\n"); 
		query.append(" ,	A.CGO_TP_CD					 	" ).append("\n"); 
		query.append(" ,	A.SPCL_CGO_CNTR_TP_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_BND_CD					" ).append("\n"); 
		query.append(" ,	A.TRSP_COST_DTL_MOD_CD		 	" ).append("\n"); 
		query.append(" ,	A.DOR_SVC_TP_CD				 	" ).append("\n"); 
		query.append(" ,	A.N3PTY_BIL_FLG				 	" ).append("\n"); 
		query.append(" ,	@[inv_rmk] VERIFY_RESULT					" ).append("\n"); 
		query.append(" ,	A.INTER_RMK						" ).append("\n"); 
		query.append(" ,	A.SPCL_INSTR_RMK				" ).append("\n"); 
		query.append(" ,	A.CNTR_NO						" ).append("\n"); 
		query.append(" ,	A.CNTR_TPSZ_CD					" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.ORG_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI:SS')				" ).append("\n"); 
		query.append(" 	AS ORG_GATE_OUT_DT				" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.DEST_GATE_IN_DT, 'YYYY-MM-DD HH24:MI:SS')				" ).append("\n"); 
		query.append(" 	AS DEST_GATE_IN_DT				" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS TRSP_SO_OFC_CTY_CD_SEQ	" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_OFC_CTY_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ					" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ AS SURCHARGE_KEY	" ).append("\n"); 
		query.append(" ,	A.TRSP_MTY_COST_MOD_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_TP_CD					" ).append("\n"); 
		query.append(" ,	A.CRE_OFC_CD					" ).append("\n"); 
		query.append(" ,	A.COST_ACT_GRP_CD					" ).append("\n"); 
		query.append(" , @[cntr_sub_flg] CNTR_SUB_FLG					" ).append("\n"); 
		query.append(" FROM " ).append("\n"); 
		query.append("   TRS_TRSP_SVC_ORD A						" ).append("\n"); 
		query.append(" WHERE 							" ).append("\n"); 
		query.append(" 	  A.TRSP_SO_OFC_CTY_CD 	= @[trsp_so_ofc_cty_cd]		" ).append("\n"); 
		query.append(" AND A.TRSP_SO_SEQ		= @[trsp_so_seq]				" ).append("\n"); 
		query.append("		/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append(" AND A.HJL_NO IS NULL" ).append("\n"); 

	}
}