/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOModifyApprovalStepUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOModifyApprovalStepUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyApprovalStep
	  * </pre>
	  */
	public OwnersAccountDBDAOModifyApprovalStepUpdateUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOModifyApprovalStepUpdateUSQL").append("\n"); 
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
		query.append("UPDATE ap_inv_hdr SET" ).append("\n"); 
		query.append("	   gl_dt	= (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                            NVL(" ).append("\n"); 
		query.append("                            CASE" ).append("\n"); 
		query.append("                            WHEN" ).append("\n"); 
		query.append("                                (SELECT NVL((SELECT CASE WHEN SUM(DECODE(CLZ_STS_CD,'O',1,0)) > 0 THEN 'O' ELSE 'C' END STS" ).append("\n"); 
		query.append("                            		         FROM   AP_PERIOD" ).append("\n"); 
		query.append("                            		         WHERE  SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("                            		         AND    EFF_YRMON  = SUBSTR(A.GL_DT,1,6)" ).append("\n"); 
		query.append("                            		         AND    OFC_CD IN (A.TJ_OFC_CD,(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = A.TJ_OFC_CD))" ).append("\n"); 
		query.append("                            		         AND    AR_AP_DIV_CD = 'P'),'C') STS " ).append("\n"); 
		query.append("                                 FROM DUAL) = 'O'" ).append("\n"); 
		query.append("                            THEN A.GL_DT" ).append("\n"); 
		query.append("                            WHEN" ).append("\n"); 
		query.append("                                (SELECT NVL((SELECT CASE WHEN SUM(DECODE(CLZ_STS_CD,'O',1,0)) > 0 THEN 'O' ELSE 'C' END STS" ).append("\n"); 
		query.append("                            		         FROM   AP_PERIOD" ).append("\n"); 
		query.append("                            		         WHERE  SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("                            		         AND    EFF_YRMON  = SUBSTR(A.GL_DT,1,6)" ).append("\n"); 
		query.append("                            		         AND    OFC_CD IN (A.TJ_OFC_CD,(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = A.TJ_OFC_CD))" ).append("\n"); 
		query.append("                            		         AND    AR_AP_DIV_CD = 'P'),'C') STS " ).append("\n"); 
		query.append("                                 FROM DUAL) = 'C'" ).append("\n"); 
		query.append("                            THEN " ).append("\n"); 
		query.append("                                (SELECT MIN(EFF_YRMON)||'01' DT" ).append("\n"); 
		query.append("                		         FROM   AP_PERIOD" ).append("\n"); 
		query.append("                		         WHERE  SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("                		         AND    AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("                		         AND    OFC_CD IN (A.TJ_OFC_CD,(SELECT M.AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION M WHERE M.OFC_CD = A.TJ_OFC_CD))" ).append("\n"); 
		query.append("                		         AND    CLZ_STS_CD = 'O')" ).append("\n"); 
		query.append("                            ELSE ''" ).append("\n"); 
		query.append("                            END,'') GL_DT                 		         " ).append("\n"); 
		query.append("					FROM AP_INV_HDR A" ).append("\n"); 
		query.append("					WHERE A.CSR_NO = @[csr_no]     " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	csr_no = @[csr_no]" ).append("\n"); 

	}
}