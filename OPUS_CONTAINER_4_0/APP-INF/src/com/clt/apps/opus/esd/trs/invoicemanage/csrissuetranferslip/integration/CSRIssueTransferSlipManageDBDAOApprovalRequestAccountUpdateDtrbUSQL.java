/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOApprovalRequestAccountUpdateDtrbUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011.12.01 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOApprovalRequestAccountUpdateDtrbUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApprovalRequestAccountUpdateDtrb
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOApprovalRequestAccountUpdateDtrbUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOApprovalRequestAccountUpdateDtrbUSQL").append("\n"); 
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
		query.append("UPDATE	AP_INV_DTRB D" ).append("\n"); 
		query.append("SET		D.DTRB_COA_VVD_CD	= 'CNTC'||SUBSTR((SELECT H.GL_DT FROM AP_INV_HDR H WHERE H.CSR_NO = D.CSR_NO),3,4)||'MM'," ).append("\n"); 
		query.append("D.ACT_VVD_CD		= 'CNTC'||SUBSTR((SELECT H.GL_DT FROM AP_INV_HDR H WHERE H.CSR_NO = D.CSR_NO),3,4)||'MM'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	D.CSR_NO = @[CSR_NO]" ).append("\n"); 
		query.append("AND D.BKG_NO IS NULL" ).append("\n"); 
		query.append("AND EXISTS	(" ).append("\n"); 
		query.append("SELECT	''" ).append("\n"); 
		query.append("FROM	TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("WHERE	S.TRSP_SO_OFC_CTY_CD = D.SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND S.TRSP_SO_SEQ = D.SO_SEQ" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("S.LGS_COST_CD LIKE 'TRM%' OR (S.LGS_COST_CD LIKE 'TRO%' AND S.REF_BKG_NO IS NOT NULL)" ).append("\n"); 
		query.append("OR S.LGS_COST_CD LIKE 'TRC%' OR S.LGS_COST_CD LIKE 'TRG%'" ).append("\n"); 
		query.append("--OR ( SUBSTR(S.FINC_VVD_CD,1,4) = 'CNTC' AND S.ORG_BKG_NO IS NULL AND S.CGO_TP_CD = 'M')" ).append("\n"); 
		query.append("OR SUBSTR(S.FINC_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--AND S.TRSP_SO_TP_CD != 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	''" ).append("\n"); 
		query.append("FROM	TRS_TRSP_RFND_INV   R" ).append("\n"); 
		query.append("WHERE	R.INV_NO = D.ATTR_CTNT1" ).append("\n"); 
		query.append("AND R.TRSP_COST_DTL_MOD_CD IN ('ER', 'CN','CF')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ''" ).append("\n"); 
		query.append("FROM   TRS_TRSP_RAIL_INV_DTL A, AP_INV_HDR AP" ).append("\n"); 
		query.append("WHERE  D.CSR_NO = AP.CSR_NO" ).append("\n"); 
		query.append("AND A.INV_NO = D.ATTR_CTNT1" ).append("\n"); 
		query.append("AND  A.INV_VNDR_SEQ = AP.VNDR_NO" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("A.LGS_COST_CD LIKE 'TRM%'" ).append("\n"); 
		query.append("OR ( SUBSTR(A.FINC_VVD_CD,1,4) = 'CNTC'  AND A.CGO_TP_CD = 'M' )" ).append("\n"); 
		query.append("OR ( A.LGS_COST_CD LIKE 'TRDMRD' AND A.TRSP_INV_CO_IND_CD = 'DOM' )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND D.DTRB_COA_VVD_CD LIKE 'CNTC%'" ).append("\n"); 
		query.append("AND SUBSTR(D.DTRB_COA_VVD_CD,5,4) <> (SELECT SUBSTR(H.GL_DT,3,4) FROM AP_INV_HDR H WHERE H.CSR_NO = D.CSR_NO)" ).append("\n"); 

	}
}