/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchApInvVVDChackeRSQL.java
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

public class CARIssueTransferSlipManageDBDAOSearchApInvVVDChackeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchApInvVVDChacke
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchApInvVVDChackeRSQL(){
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
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchApInvVVDChackeRSQL").append("\n"); 
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
		query.append("SELECT A.DTRB_COA_VVD_CD RVVD, A.DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("       NVL(DECODE(V.VVD_COM_LVL,'1',M.VVD_LVL_FLG1,'2',M.VVD_LVL_FLG2,'3'," ).append("\n"); 
		query.append("                  M.VVD_LVL_FLG3,'4',M.VVD_LVL_FLG4,'5',M.VVD_LVL_FLG4," ).append("\n"); 
		query.append("                  M.VVD_LVL_FLG6),'N') LVL_CHK" ).append("\n"); 
		query.append("FROM   AP_INV_DTRB A, MDM_ACCOUNT M, AR_MST_REV_VVD V" ).append("\n"); 
		query.append("WHERE  A.CSR_NO                       = @[csr_no]" ).append("\n"); 
		query.append("AND    ( SUBSTR(A.DTRB_COA_ACCT_CD,1,1)  IN ('4','6','7' )" ).append("\n"); 
		query.append("         OR SUBSTR(A.DTRB_COA_ACCT_CD,1,2)  IN ('51') )" ).append("\n"); 
		query.append("AND    A.DTRB_COA_ACCT_CD             = M.ACCT_CD(+)" ).append("\n"); 
		query.append("AND    SUBSTR(A.DTRB_COA_VVD_CD,1,4)  = V.VSL_CD(+)" ).append("\n"); 
		query.append("AND    SUBSTR(A.DTRB_COA_VVD_CD,5,4)  = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    SUBSTR(A.DTRB_COA_VVD_CD,9,1)  = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    SUBSTR(A.DTRB_COA_VVD_CD,10,1) = V.RLANE_DIR_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.DTRB_COA_VVD_CD RVVD, A.DTRB_COA_ACCT_CD, DECODE(A.DTRB_COA_VVD_CD,'0000000000','Y','N')" ).append("\n"); 
		query.append("FROM   AP_INV_DTRB A" ).append("\n"); 
		query.append("WHERE  A.CSR_NO             = @[csr_no]" ).append("\n"); 
		query.append("AND    A.DTRB_COA_ACCT_CD  IN ('111811','111821','954113')" ).append("\n"); 

	}
}