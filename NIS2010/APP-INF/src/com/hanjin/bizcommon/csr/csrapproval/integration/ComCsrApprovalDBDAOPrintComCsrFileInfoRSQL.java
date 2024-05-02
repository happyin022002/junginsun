/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComCsrApprovalDBDAOPrintComCsrFileInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ComCsrApprovalDBDAOPrintComCsrFileInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 첨부파일 정보 조회
	  * </pre>
	  */
	public ComCsrApprovalDBDAOPrintComCsrFileInfoRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.csrapproval.integration").append("\n"); 
		query.append("FileName : ComCsrApprovalDBDAOPrintComCsrFileInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	R.SUB_SYS_ID L_FILE_MODULE_ID, " ).append("\n"); 
		query.append("	C.FILE_SAV_ID L_FILE_SAV_ID, " ).append("\n"); 
		query.append("	C.FILE_UPLD_NM L_FILE_NM" ).append("\n"); 
		query.append("FROM COM_AP_FILE_UPLD F, AP_INV_HDR A, COM_UPLD_FILE C, COM_APRO_SND_MN_RULE R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND F.AP_FILE_DIV_CD = 'C' --CSR유형만" ).append("\n"); 
		query.append("AND F.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND F.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND F.CSR_FILE_UPLD_TP_CD = 'FU'  --> FA : Agmt File / FU : 일반 FILE (화면의 TAB구분자)" ).append("\n"); 
		query.append("AND NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND A.SRC_CTNT = R.SRC_CTNT(+) " ).append("\n"); 

	}
}