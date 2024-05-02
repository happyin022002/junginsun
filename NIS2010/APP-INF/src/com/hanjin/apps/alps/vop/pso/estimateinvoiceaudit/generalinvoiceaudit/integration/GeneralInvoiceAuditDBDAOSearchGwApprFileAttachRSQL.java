/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchGwApprFileAttachRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

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
	  * 2014.11.03 PSO FILE 조회하여 GW로 전송하기위한 FILE정보
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
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
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
		query.append("WITH FILES AS (" ).append("\n"); 
		query.append("                                  SELECT 'PSO' AS L_FILE_MODULE_ID" ).append("\n"); 
		query.append("                                            ,A.FILE_SAVE_ID AS L_FILE_SAV_ID" ).append("\n"); 
		query.append("                                   FROM PSO_TRF_ATCH_FILE A," ).append("\n"); 
		query.append("                                            AP_PAY_INV C, " ).append("\n"); 
		query.append("                                             PSO_CHARGE D," ).append("\n"); 
		query.append("                                             PSO_CHG_DTL E" ).append("\n"); 
		query.append("                                 WHERE C.INV_RGST_NO = D.INV_RGST_NO " ).append("\n"); 
		query.append("                                      AND D.ISS_CTY_CD   = E.ISS_CTY_CD" ).append("\n"); 
		query.append("                                      AND D.SO_SEQ         = E.SO_SEQ" ).append("\n"); 
		query.append("                                      AND E.YD_CHG_NO   = A.YD_CHG_NO" ).append("\n"); 
		query.append("                                      AND C.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                                      AND C.INV_SUB_SYS_CD = 'PSO'" ).append("\n"); 
		query.append("                                      AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                      AND C.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("                                      AND E.YD_CHG_NO IS NOT NULL" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                SELECT A.L_FILE_MODULE_ID,  A.L_FILE_SAV_ID  ,B.FILE_UPLD_NM AS L_FILE_NM " ).append("\n"); 
		query.append("                   FROM  FILES A, COM_UPLD_FILE B" ).append("\n"); 
		query.append("                  WHERE A.L_FILE_SAV_ID = B.FILE_SAV_ID" ).append("\n"); 
		query.append("                    AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" GROUP BY A.L_FILE_MODULE_ID,  A.L_FILE_SAV_ID  ,B.FILE_UPLD_NM" ).append("\n"); 

	}
}