/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchGwApprFileAttachRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchGwApprFileAttachRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.04.05 FMS Owner's Account Attach FILE 조회하여 GW로 전송하기위한 FILE정보
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchGwApprFileAttachRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchGwApprFileAttachRSQL").append("\n"); 
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
		query.append("WITH FILES AS (SELECT 'FMS' AS L_FILE_MODULE_ID," ).append("\n"); 
		query.append("               F.FILE_SAV_ID AS L_FILE_SAV_ID" ).append("\n"); 
		query.append("          FROM FMS_CSUL_SLP S," ).append("\n"); 
		query.append("               FMS_OWNR_ACCT_ATCH_FILE F," ).append("\n"); 
		query.append("               COM_UPLD_FILE C" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND S.SLP_TP_CD||S.SLP_FUNC_CD||S.SLP_OFC_CD||S.SLP_ISS_DT||S.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("           AND S.ATCH_FILE_OA_LNK_ID = F.ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("           AND F.FILE_SAV_ID = C.FILE_SAV_ID )" ).append("\n"); 
		query.append("SELECT A.L_FILE_MODULE_ID," ).append("\n"); 
		query.append("       A.L_FILE_SAV_ID ," ).append("\n"); 
		query.append("       B.FILE_UPLD_NM AS L_FILE_NM" ).append("\n"); 
		query.append("  FROM FILES A," ).append("\n"); 
		query.append("       COM_UPLD_FILE B" ).append("\n"); 
		query.append(" WHERE A.L_FILE_SAV_ID = B.FILE_SAV_ID" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" GROUP BY A.L_FILE_MODULE_ID," ).append("\n"); 
		query.append("       A.L_FILE_SAV_ID , " ).append("\n"); 
		query.append("       B.FILE_UPLD_NM" ).append("\n"); 

	}
}