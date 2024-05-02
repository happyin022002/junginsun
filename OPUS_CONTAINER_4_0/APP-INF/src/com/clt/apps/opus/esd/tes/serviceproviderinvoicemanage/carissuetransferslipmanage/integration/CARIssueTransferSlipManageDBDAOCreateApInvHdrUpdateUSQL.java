/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvHdrUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvHdrUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvHdrUpdate
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvHdrUpdateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvHdrUpdateUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR" ).append("\n"); 
		query.append(" SET INV_DESC = (" ).append("\n"); 
		query.append("	 SELECT (SELECT M.ACCT_ENG_NM FROM MDM_ACCOUNT M WHERE M.ACCT_CD = A.DTRB_COA_ACCT_CD) MAX_ACCT_NM FROM (" ).append("\n"); 
		query.append("	 SELECT SUM(INV_AMT) SUM_AMT, DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("	 FROM AP_INV_DTRB D" ).append("\n"); 
		query.append("	 WHERE D.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("	 GROUP BY D.DTRB_COA_CO_CD, D.DTRB_COA_RGN_CD, D.DTRB_COA_CTR_CD, D.DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("			  D.DTRB_COA_INTER_CO_CD, D.DTRB_COA_VVD_CD, D.INV_DESC, D.ATTR_CTNT3, D.ATTR_CTNT1, D.LINE_NO" ).append("\n"); 
		query.append("	 ORDER BY SUM_AMT DESC" ).append("\n"); 
		query.append("	 ) A WHERE ROWNUM = 1" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}