/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOMultiCSRNoCSRNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOMultiCSRNoCSRNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiCSRNoCSRNo
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOMultiCSRNoCSRNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no_sub",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("convRevVVD_YN",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOMultiCSRNoCSRNoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[convRevVVD_YN],'Y','14','12')||@[csr_no_sub]																		" ).append("\n"); 
		query.append("		||DECODE(@[convRevVVD_YN],'Y','SELOPA',(SELECT AP_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])) -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)				" ).append("\n"); 
		query.append("		||(SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),'YYMMDD') FROM DUAL)					" ).append("\n"); 
		query.append("		||(SELECT LPAD(NVL(MAX(SUBSTR(csr_no,16,20)),0)+1,5, '0') 					" ).append("\n"); 
		query.append("			FROM ap_csr_no WHERE SUBSTR(csr_no,1,LENGTH(csr_no)-5) =				" ).append("\n"); 
		query.append("			DECODE(@[convRevVVD_YN],'Y','14','12')||@[csr_no_sub]																	" ).append("\n"); 
		query.append("			||DECODE(@[convRevVVD_YN],'Y','SELOPA',(SELECT AP_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])) -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)							  " ).append("\n"); 
		query.append("			||(SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),'YYMMDD') FROM DUAL)) csr_no		" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}