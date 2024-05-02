/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOMultiCSRNoCSRNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
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
		query.append("		||DECODE(@[convRevVVD_YN],'Y','SELCOL',(SELECT AP_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]))				" ).append("\n"); 
		query.append("		||(SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),'YYMM') FROM DUAL)					" ).append("\n"); 
		query.append("		||(SELECT LPAD(NVL(MAX(SUBSTR(csr_no,13,16)),0)+1,4, '0') 					" ).append("\n"); 
		query.append("			FROM ap_csr_no WHERE SUBSTR(csr_no,1,LENGTH(csr_no)-4) =				" ).append("\n"); 
		query.append("			DECODE(@[convRevVVD_YN],'Y','14','12')||@[csr_no_sub]																	" ).append("\n"); 
		query.append("			||DECODE(@[convRevVVD_YN],'Y','SELCOL',(SELECT AP_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]))							  " ).append("\n"); 
		query.append("			||(SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),'YYMM') FROM DUAL)) csr_no		" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}