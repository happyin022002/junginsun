/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB03RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.17 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 비교03
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB03RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LEVEL",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DTRB_COA_ACCT_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB03RSQL").append("\n"); 
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
		query.append("NVL(DECODE(@[LEVEL] , '1', VVD_LVL_FLG1" ).append("\n"); 
		query.append(", '2', VVD_LVL_FLG2" ).append("\n"); 
		query.append(", '3', VVD_LVL_FLG3" ).append("\n"); 
		query.append(", '4', VVD_LVL_FLG4" ).append("\n"); 
		query.append(", '5', VVD_LVL_FLG5" ).append("\n"); 
		query.append(",      VVD_LVL_FLG6)" ).append("\n"); 
		query.append(", 'N') VVDFLAG" ).append("\n"); 
		query.append("FROM	MDM_ACCOUNT" ).append("\n"); 
		query.append("WHERE	ACCT_CD	= @[DTRB_COA_ACCT_CD]" ).append("\n"); 

	}
}