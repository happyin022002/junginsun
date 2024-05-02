/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceAuditListByInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.06
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.06 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceAuditListByInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * invoice 리스트 가져오기
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceAuditListByInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceAuditListByInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	A.EQ_NO" ).append("\n"); 
		query.append(" ,	A.EQ_NO AS ORG_EQ_NO" ).append("\n"); 
		query.append(" ,	A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(" ,	A.ORG_EQ_TPSZ_CD" ).append("\n"); 
		query.append(" ,	A.EQ_KND_CD" ).append("\n"); 
		query.append(" ,	SUBSTR(A.FM_NOD_CD,1,5) FM_LOC_VALUE" ).append("\n"); 
		query.append(" ,	SUBSTR(A.FM_NOD_CD,6,2) FM_YARD_VALUE" ).append("\n"); 
		query.append(" ,	SUBSTR(A.VIA_NOD_CD,1,5) VIA_LOC_VALUE" ).append("\n"); 
		query.append(" ,	SUBSTR(A.VIA_NOD_CD,6,2) VIA_YARD_VALUE" ).append("\n"); 
		query.append(" ,	SUBSTR(A.TO_NOD_CD,1,5) TO_LOC_VALUE" ).append("\n"); 
		query.append(" ,	SUBSTR(A.TO_NOD_CD,6,2) TO_YARD_VALUE" ).append("\n"); 
		query.append(" ,	SUBSTR(A.DOR_NOD_CD,1,5) DOR_LOC_VALUE" ).append("\n"); 
		query.append(" ,	SUBSTR(A.DOR_NOD_CD,6,2) DOR_YARD_VALUE" ).append("\n"); 
		query.append(" ,	A.CUST_CNT_CD" ).append("\n"); 
		query.append(" ,	A.CUST_SEQ" ).append("\n"); 
		query.append(" ,	A.DOR_DE_ADDR" ).append("\n"); 
		query.append(" ,	A.CURR_CD" ).append("\n"); 
		query.append(" ,	A.BZC_AMT" ).append("\n"); 
		query.append(" ,	A.NEGO_AMT" ).append("\n"); 
		query.append(" ,	A.FUEL_SCG_AMT" ).append("\n"); 
		query.append(" ,	A.ETC_ADD_AMT" ).append("\n"); 
		query.append(" ,  (SELECT CASE WHEN MAX(A.CURR_CD) <> MAX(NVL(D.CURR_CD, A.CURR_CD)) OR MAX(A.CURR_CD) <> MIN(NVL(D.CURR_CD, A.CURR_CD)) THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       FROM TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("      WHERE A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    ) AS MULTI_CURR_YN" ).append("\n"); 
		query.append(" ,	( NVL(A.BZC_AMT,0)+ NVL(A.NEGO_AMT,0)+ NVL(A.FUEL_SCG_AMT,0) + NVL(A.ETC_ADD_AMT,0)) AS WO_TOT_AMT" ).append("\n"); 
		query.append(" ,	NVL(A.TRSP_INV_CALC_LGC_TP_CD, 'TM') TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(" ,	NVL(A.INV_XCH_RT, 1) INV_XCH_RT" ).append("\n"); 
		query.append(" ,	A.INV_CURR_CD" ).append("\n"); 
		query.append(" ,	CASE WHEN ( A.INV_BZC_AMT IS NULL OR A.INV_BZC_AMT = 0)	 THEN ( NVL(A.BZC_AMT,0)+ NVL(A.NEGO_AMT,0)	+ NVL(A.FUEL_SCG_AMT,0)	+ NVL(A.ETC_ADD_AMT,0))" ).append("\n"); 
		query.append(" 	     ELSE A.INV_BZC_AMT" ).append("\n"); 
		query.append("    END AS INV_BZC_AMT" ).append("\n"); 
		query.append(" ,	A.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_SEQ" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD')	CRE_DT" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'HH24:MI:SS')	CRE_TM" ).append("\n"); 
		query.append(",	TO_CHAR(A.WO_EXE_DT, 'YYYY-MM-DD HH24:MI:SS')	COP_EXE_DT" ).append("\n"); 
		query.append(" ,	A.BKG_NO" ).append("\n"); 
		query.append(" ,	A.BL_NO BL_NO" ).append("\n"); 
		query.append(" ,	A.CGO_TP_CD" ).append("\n"); 
		query.append(" ,	A.SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append(" ,	A.TRSP_BND_CD" ).append("\n"); 
		query.append(" ,	A.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(" ,	A.DOR_SVC_TP_CD" ).append("\n"); 
		query.append(" ,	A.N3PTY_BIL_FLG" ).append("\n"); 
		query.append(" ,	A.INV_RMK" ).append("\n"); 
		query.append(" ,	DECODE(A.TRSP_SO_TP_CD, 'M', A.INTER_RMK, 'H', A.INTER_RMK, 'O', A.INTER_RMK, " ).append("\n"); 
		query.append("	DECODE((SELECT MAX(RMK.BKG_NO)" ).append("\n"); 
		query.append("              FROM TRS_INTER_RMK RMK" ).append("\n"); 
		query.append("             WHERE RMK.BKG_NO IN(A.BKG_NO, 'DUM000000000')" ).append("\n"); 
		query.append("               AND NVL(RMK.EQ_NO, 'X') = NVL2(RMK.EQ_NO, A.EQ_NO, 'X')" ).append("\n"); 
		query.append("               AND NVL(RMK.TRSP_SO_OFC_CTY_CD, 'XX') = NVL2(RMK.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_OFC_CTY_CD, 'XX')" ).append("\n"); 
		query.append("               AND NVL(RMK.TRSP_SO_SEQ, '99999') = NVL2(RMK.TRSP_SO_SEQ, A.TRSP_SO_SEQ, '99999')" ).append("\n"); 
		query.append("               AND NVL(RMK.DELT_FLG, 'X') = 'N'), '', '', 'Y')) INTER_RMK" ).append("\n"); 
		query.append(" ,  DECODE(A.TRSP_SO_TP_CD, 'M', '', 'H', '', 'O', '', '1') INTER_RMK_IMG" ).append("\n"); 
		query.append(" ,	A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append(" ,	A.CNTR_NO" ).append("\n"); 
		query.append(" ,	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.ORG_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(" 	AS ORG_GATE_OUT_DT" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.DEST_GATE_IN_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(" 	AS DEST_GATE_IN_DT" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ TRSP_SO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ SURCHARGE_KEY" ).append("\n"); 
		query.append(" ,	A.TRSP_MTY_COST_MOD_CD" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append(" ,	A.CRE_OFC_CD" ).append("\n"); 
		query.append(" ,	A.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(" ,	NVL(A.TRSP_FRST_FLG,'N') TRSP_FRST_FLG" ).append("\n"); 
		query.append(" ,  A.REF_INV_NO" ).append("\n"); 
		query.append(" ,  'Y'	EMPTY_EQ_NO_VERIFY_CHECK" ).append("\n"); 
		query.append(" ,  A.INV_ADJ_BZC_AMT" ).append("\n"); 
		query.append(" ,  A.INV_BZC_AMT AS ORG_INV_BZC_AMT" ).append("\n"); 
		query.append(" FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(" WHERE A.INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 
		query.append(" AND A.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("#if ( !(${trsp_inv_act_sts_cd_param} == '' ) )" ).append("\n"); 
		query.append(" AND A.TRSP_INV_ACT_STS_CD	= 	'${trsp_inv_act_sts_cd_param}'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" AND A.INV_NO = @[inv_no]" ).append("\n"); 

	}
}