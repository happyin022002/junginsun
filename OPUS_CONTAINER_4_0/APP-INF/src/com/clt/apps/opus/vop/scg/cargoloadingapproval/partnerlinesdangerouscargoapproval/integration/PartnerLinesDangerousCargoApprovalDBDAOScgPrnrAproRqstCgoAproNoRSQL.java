/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoAproNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoAproNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인번호조회
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoAproNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoAproNoRSQL").append("\n"); 
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
		query.append("SELECT  COM_CONSTANTMGR_PKG.COM_GETCOMPANYCODE_FNC()" ).append("\n"); 
		query.append("||SUBSTR('${pol_cd}',3,5)||TO_CHAR(SYSDATE, 'YYMMDD')" ).append("\n"); 
		query.append("||DECODE(NVL(LENGTH(MAX(SUBSTR(APRO_REF_NO,13,15))+1),0)," ).append("\n"); 
		query.append("          0, '001'," ).append("\n"); 
		query.append("          1, '00'||TO_CHAR(MAX(SUBSTR(APRO_REF_NO,13,15))+1)," ).append("\n"); 
		query.append("          2, '0'||TO_CHAR(MAX(SUBSTR(APRO_REF_NO,13,15))+1)," ).append("\n"); 
		query.append("          3, TO_CHAR(MAX(SUBSTR(APRO_REF_NO,13,15))+1) " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST_CGO" ).append("\n"); 
		query.append("WHERE SUBSTR(APRO_REF_NO,1,12) = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()||SUBSTR('${pol_cd}',3,5)||TO_CHAR(SYSDATE, 'yymmdd')" ).append("\n"); 

	}
}