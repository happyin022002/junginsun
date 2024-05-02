/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOApprovalRequestAccountVVDSOUSQL.java
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

public class CSRIssueTransferSlipManageDBDAOApprovalRequestAccountVVDSOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRUCK SO FINC_VVD_CD 업데이트 
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOApprovalRequestAccountVVDSOUSQL(){
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
		query.append("FileName : CSRIssueTransferSlipManageDBDAOApprovalRequestAccountVVDSOUSQL").append("\n"); 
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
		query.append("UPDATE	TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("SET			X.FINC_VVD_CD = 'CNTC'||SUBSTR((SELECT H.GL_DT FROM AP_INV_HDR H WHERE H.CSR_NO = @[CSR_NO]),3,4)||'MM'" ).append("\n"); 
		query.append("WHERE		(X.INV_NO, X.INV_VNDR_SEQ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	W.INV_NO, W.INV_VNDR_SEQ" ).append("\n"); 
		query.append("FROM	TRS_TRSP_INV_WRK W" ).append("\n"); 
		query.append("WHERE	W.CSR_NO = @[CSR_NO]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (X.LGS_COST_CD LIKE 'TRM%' OR (X.LGS_COST_CD LIKE 'TRO%' AND X.REF_BKG_NO IS NOT NULL) OR X.LGS_COST_CD LIKE 'TRC%' OR X.LGS_COST_CD LIKE 'TRG%'           /* 2008.06.06 CNTC Modification based on GL Date, Empty Container Only	*/" ).append("\n"); 
		query.append("--OR ( SUBSTR(X.FINC_VVD_CD,1,4) = 'CNTC' AND X.ORG_BKG_NO IS NULL AND X.CGO_TP_CD = 'M' )" ).append("\n"); 
		query.append("OR SUBSTR(X.FINC_VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append(")	           		/* 2009.08.19 CNTC Modification based on GL Date, Empty Container Only	*/" ).append("\n"); 
		query.append("--AND X.TRSP_SO_TP_CD != 'O'" ).append("\n"); 
		query.append("AND SUBSTR(X.FINC_VVD_CD,5,4) <> (SELECT SUBSTR(H.GL_DT,3,4) FROM AP_INV_HDR H WHERE H.CSR_NO = @[CSR_NO])" ).append("\n"); 

	}
}