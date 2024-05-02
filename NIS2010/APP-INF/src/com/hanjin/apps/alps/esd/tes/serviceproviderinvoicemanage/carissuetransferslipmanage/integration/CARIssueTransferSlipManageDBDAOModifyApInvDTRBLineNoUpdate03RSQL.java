/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOModifyApInvDTRBLineNoUpdate03RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOModifyApInvDTRBLineNoUpdate03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyApInvDTRBLineNoUpdate03
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOModifyApInvDTRBLineNoUpdate03RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOModifyApInvDTRBLineNoUpdate03RSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1, DTRB_COA_ACCT_CD, DTRB_COA_VVD_CD, FTU_USE_CTNT1, ROWNUM LINE_NO" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("	--[CHM-201536111]CSR I/F할 때 Line No 반복되지 않도록 로직 변경" ).append("\n"); 
		query.append("	SELECT DISTINCT ATTR_CTNT1, DTRB_COA_ACCT_CD, DTRB_COA_VVD_CD, NVL(FTU_USE_CTNT1,'N') FTU_USE_CTNT1" ).append("\n"); 
		query.append("	FROM   AP_INV_DTRB" ).append("\n"); 
		query.append("	WHERE  CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("	ORDER BY ATTR_CTNT1, DTRB_COA_VVD_CD DESC" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}