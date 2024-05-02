/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOUpdateHPCUSQL.java
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

public class CARIssueTransferSlipManageDBDAOUpdateHPCUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateHPC
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOUpdateHPCUSQL(){
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
		query.append("FileName : CARIssueTransferSlipManageDBDAOUpdateHPCUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_HDR H" ).append("\n"); 
		query.append("#if (${mode} != '' and ${mode}=='1')--// 1) CSR I/F SUCCESS시(IF_FLG에 'Y' 들어 올때) " ).append("\n"); 
		query.append("	 SET AP_IF_DT = SYSDATE, HPC_CRE_FLG = 'N', LEA_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${mode} != '' and ${mode}=='2')--// 2) CSR CANCEL(RCV_ERR_FLG에 'E' 들어 올때) " ).append("\n"); 
		query.append("	 SET AP_CXL_DT = SYSDATE, HPC_CXL_FLG = 'N', LEA_CXL_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${mode} != '' and ${mode}=='3')--// 3) FNS010-0002 - CSR PAY_AMT 정보 받을 시 " ).append("\n"); 
		query.append("	 SET AP_PAY_DT = SYSDATE, HPC_DELT_FLG = 'N'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE H.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}