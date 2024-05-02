/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSlipArApprovalOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.16 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchSlipArApprovalOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR전표에서 
	  * Slip Approval 승인 시에 Office 및 User 테이블에서 필요 항목 조회한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSlipArApprovalOfficeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchSlipArApprovalOfficeRSQL").append("\n"); 
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
		query.append("SELECT O.FINC_RGN_CD, O.AP_CTR_CD, O.AR_HD_QTR_OFC_CD, U.USR_NM, U.OFC_CD, U.USR_EML" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION O, COM_USER U" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    U.USR_ID = (" ).append("\n"); 
		query.append("					SELECT J.CSR_USR_ID" ).append("\n"); 
		query.append(" 					FROM FMS_CONSULTATION J" ).append("\n"); 
		query.append(" 					WHERE J.SLP_TP_CD||J.SLP_FUNC_CD||J.SLP_OFC_CD||J.SLP_ISS_DT||J.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("AND    U.OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}