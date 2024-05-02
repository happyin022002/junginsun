/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckSumLineAmountTotalAmountRSQL.java
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

public class CSRIssueTransferSlipManageDBDAOCheckSumLineAmountTotalAmountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Amt와 Line Amt 비교한다
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckSumLineAmountTotalAmountRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckSumLineAmountTotalAmountRSQL").append("\n"); 
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
		query.append("DECODE(		NVL(	(SELECT (H.CSR_AMT)     FROM AP_INV_HDR  H WHERE H.CSR_NO = @[CSR_NO]), 0)" ).append("\n"); 
		query.append(", 	NVL(	(SELECT  SUM(D.INV_AMT) FROM AP_INV_DTRB D WHERE D.CSR_NO = @[CSR_NO]), 1)" ).append("\n"); 
		query.append(", 	'Y'" ).append("\n"); 
		query.append(", 	'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("FROM    	DUAL" ).append("\n"); 

	}
}