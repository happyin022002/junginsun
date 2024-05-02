/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRInvAgmtLnkDBDAOgetComApFileUpldCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRInvAgmtLnkDBDAOgetComApFileUpldCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM_AP_FILE_UPLD CNT
	  * </pre>
	  */
	public CSRInvAgmtLnkDBDAOgetComApFileUpldCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_file_upld_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration").append("\n"); 
		query.append("FileName : CSRInvAgmtLnkDBDAOgetComApFileUpldCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) AS ATCH_FILE_CNT" ).append("\n"); 
		query.append("  FROM COM_AP_FILE_UPLD F," ).append("\n"); 
		query.append("       AP_INV_HDR A," ).append("\n"); 
		query.append("       COM_UPLD_FILE C," ).append("\n"); 
		query.append("       COM_USER U" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND F.AP_FILE_DIV_CD = 'C'" ).append("\n"); 
		query.append("   AND F.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND F.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("   AND F.CSR_FILE_UPLD_TP_CD = @[csr_file_upld_tp_cd]" ).append("\n"); 
		query.append("   AND NVL(F.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND F.FILE_SAV_ID = C.FILE_SAV_ID" ).append("\n"); 
		query.append("   AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND F.CRE_USR_ID = U.USR_ID" ).append("\n"); 
		query.append("   AND NVL(U.USE_FLG, 'N') = 'Y'" ).append("\n"); 

	}
}