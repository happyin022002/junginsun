/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRInvAgmtLnkDBDAOUpdApInvHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.27 
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

public class CSRInvAgmtLnkDBDAOUpdApInvHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_INV_HDR UPDATE
	  * </pre>
	  */
	public CSRInvAgmtLnkDBDAOUpdApInvHdrUSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration").append("\n"); 
		query.append("FileName : CSRInvAgmtLnkDBDAOUpdApInvHdrUSQL").append("\n"); 
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
		query.append(" UPDATE AP_INV_HDR A" ).append("\n"); 
		query.append("   SET A.AGMT_FILE_CFM_CD = (SELECT" ).append("\n"); 
		query.append("                       CASE" ).append("\n"); 
		query.append("                         WHEN NVL((SELECT COUNT(F.ATCH_FILE_ID)" ).append("\n"); 
		query.append("                          FROM COM_AP_FILE_UPLD F" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND F.AP_FILE_DIV_CD = 'C'" ).append("\n"); 
		query.append("                           AND F.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("                           AND F.DELT_FLG != 'Y'" ).append("\n"); 
		query.append("                           AND (" ).append("\n"); 
		query.append("                                F.CSR_FILE_UPLD_TP_CD = 'FA' " ).append("\n"); 
		query.append("                                OR " ).append("\n"); 
		query.append("                                (A.SRC_CTNT =  'SO_PORT' AND F.CSR_FILE_UPLD_TP_CD = 'PF')" ).append("\n"); 
		query.append("                                )), 0) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                         ELSE 'N'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("          FROM DUAL )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("   AND NVL(A.RQST_APRO_STEP_FLG, 'N') = 'Y'" ).append("\n"); 

	}
}