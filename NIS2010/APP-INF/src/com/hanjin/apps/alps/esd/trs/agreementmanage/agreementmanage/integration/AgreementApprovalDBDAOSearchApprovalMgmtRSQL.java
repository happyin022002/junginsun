/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementApprovalDBDAOSearchApprovalMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.07.22 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementApprovalDBDAOSearchApprovalMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement 결재자 조회
	  * </pre>
	  */
	public AgreementApprovalDBDAOSearchApprovalMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementApprovalDBDAOSearchApprovalMgmtRSQL").append("\n"); 
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
		query.append("SELECT CFM_USR_ID" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.CFM_USR_ID) CFM_USR_NM" ).append("\n"); 
		query.append("      ,CFM_OFC_CD" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.CRE_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,'' SEL" ).append("\n"); 
		query.append("  FROM TRS_AGMT_APRO_MGMT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${fm_cfm_usr_id} != '' )" ).append("\n"); 
		query.append("   AND CFM_USR_ID = @[fm_cfm_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CFM_USR_ID, CFM_OFC_CD" ).append("\n"); 

	}
}