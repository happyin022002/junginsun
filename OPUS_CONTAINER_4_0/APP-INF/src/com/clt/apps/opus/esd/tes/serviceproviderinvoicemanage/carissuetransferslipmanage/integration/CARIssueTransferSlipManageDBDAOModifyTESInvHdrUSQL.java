/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOModifyTESInvHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOModifyTESInvHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyTESInvHdr
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOModifyTESInvHdrUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOModifyTESInvHdrUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_HDR " ).append("\n"); 
		query.append("SET 		" ).append("\n"); 
		query.append("#if ('RJ' == ${sTrspInvAudStsCd})" ).append("\n"); 
		query.append("	AP_CXL_DT = SYSDATE" ).append("\n"); 
		query.append("#elseif ('IF' == ${sTrspInvAudStsCd})" ).append("\n"); 
		query.append("	AP_IF_DT = SYSDATE," ).append("\n"); 
		query.append("	TML_INV_STS_CD = 'P'," ).append("\n"); 
		query.append("	PAY_FLG = ''," ).append("\n"); 
		query.append("	PAY_DT = ''," ).append("\n"); 
		query.append("	AP_PAY_DT = ''" ).append("\n"); 
		query.append("#elseif ('PD' == ${sTrspInvAudStsCd})" ).append("\n"); 
		query.append("	PAY_FLG = 'Y', " ).append("\n"); 
		query.append("	PAY_DT = SYSDATE, " ).append("\n"); 
		query.append("	AP_PAY_DT = SYSDATE," ).append("\n"); 
		query.append("	TML_INV_STS_CD = 'D' " ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	CSR_NO = @[csr_no]" ).append("\n"); 

	}
}