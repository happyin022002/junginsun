/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOApprovalRequestAccountRailVVDSOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOApprovalRequestAccountRailVVDSOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RAIL SO FINC_VVD_CD 업데이트
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOApprovalRequestAccountRailVVDSOUSQL(){
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
		query.append("FileName : CSRIssueTransferSlipManageDBDAOApprovalRequestAccountRailVVDSOUSQL").append("\n"); 
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
		query.append("UPDATE  TRS_TRSP_RAIL_INV_DTL D                                                                                         " ).append("\n"); 
		query.append("      SET     D.FINC_VVD_CD = 'CNTC'||SUBSTR((SELECT H.GL_DT FROM AP_INV_HDR H WHERE H.CSR_NO = @[CSR_NO]),3,4)||'MM'" ).append("\n"); 
		query.append("      WHERE   (D.INV_NO, D.INV_VNDR_SEQ) IN" ).append("\n"); 
		query.append("              (SELECT  W.INV_NO, W.INV_VNDR_SEQ FROM  TRS_TRSP_RAIL_INV_WRK   W WHERE W.CSR_NO = @[CSR_NO] )" ).append("\n"); 
		query.append("              AND D.FINC_VVD_CD LIKE 'CNTC%'" ).append("\n"); 
		query.append("              AND (" ).append("\n"); 
		query.append("                   D.LGS_COST_CD LIKE 'TRM%' OR D.LGS_COST_CD LIKE 'SM%' OR D.LGS_COST_CD LIKE 'TRC%' OR D.LGS_COST_CD LIKE 'TRG%'" ).append("\n"); 
		query.append("                  OR ( SUBSTR(D.FINC_VVD_CD,1,4) = 'CNTC' AND D.CGO_TP_CD = 'M' )" ).append("\n"); 
		query.append("                  OR ( D.LGS_COST_CD LIKE 'TRDMRD' AND D.TRSP_INV_CO_IND_CD = 'DOM' )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("              AND SUBSTR(D.FINC_VVD_CD,5,4) <> (SELECT SUBSTR(H.GL_DT,3,4) FROM AP_INV_HDR H WHERE H.CSR_NO = @[CSR_NO])" ).append("\n"); 

	}
}