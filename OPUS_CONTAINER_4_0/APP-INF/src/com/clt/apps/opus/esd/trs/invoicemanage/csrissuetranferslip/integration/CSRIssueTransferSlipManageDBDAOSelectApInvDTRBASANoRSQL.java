/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.14 
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

public class CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApInvDTRBASANo 내역을 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL(){
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
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL").append("\n"); 
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
		query.append("SELECT A.LINE_SEQ, B.LINE_NO, C.INV_NO, C.ISS_DT, C.LOC_CD, C.ATTR_CTNT12, D.TOTAL_AMT" ).append("\n"); 
		query.append("  FROM (SELECT NVL(MAX(LINE_SEQ), 0) + 1 LINE_SEQ FROM AP_INV_DTRB WHERE CSR_NO = @[CSR_NO]) A" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(LINE_NO), 0) + 1 LINE_NO FROM AP_INV_DTRB WHERE CSR_NO = @[CSR_NO]) B" ).append("\n"); 
		query.append("      ,(SELECT T1.ATTR_CTNT1 AS INV_NO, LOC_CD, T1.ISS_DT, T1.ATTR_CTNT12" ).append("\n"); 
		query.append("          FROM (SELECT B.ATTR_CTNT1" ).append("\n"); 
		query.append("                      ,NVL(SUBSTR(B.YD_CD, 1, 5), B.ATTR_CTNT3) LOC_CD" ).append("\n"); 
		query.append("                      ,B.ATTR_CTNT2 AS ISS_DT" ).append("\n"); 
		query.append("                      ,B.ATTR_CTNT12" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY B.ATTR_CTNT1, NVL(SUBSTR(B.YD_CD, 1, 5), B.ATTR_CTNT3) ORDER BY B.ATTR_CTNT2 DESC) RK" ).append("\n"); 
		query.append("                  FROM AP_INV_DTRB B" ).append("\n"); 
		query.append("                 WHERE CSR_NO = @[CSR_NO]) T1" ).append("\n"); 
		query.append("              ,(SELECT MAX(ATTR_CTNT1) ATTR_CTNT1 FROM AP_INV_DTRB WHERE CSR_NO = @[CSR_NO]) T2" ).append("\n"); 
		query.append("         WHERE RK = 1" ).append("\n"); 
		query.append("           AND T1.ATTR_CTNT1 = T2.ATTR_CTNT1" ).append("\n"); 
		query.append("           AND ROWNUM = 1) C" ).append("\n"); 
		query.append("      ,(SELECT -SUM(INV_AMT) TOTAL_AMT FROM AP_INV_DTRB WHERE CSR_NO = @[CSR_NO]) D	  " ).append("\n"); 

	}
}