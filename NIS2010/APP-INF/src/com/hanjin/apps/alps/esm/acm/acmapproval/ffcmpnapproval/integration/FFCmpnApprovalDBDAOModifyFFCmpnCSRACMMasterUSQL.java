/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRACMMasterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOModifyFFCmpnCSRACMMasterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFFCmpnCSRACMMaster
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOModifyFFCmpnCSRACMMasterUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOModifyFFCmpnCSRACMMasterUSQL").append("\n"); 
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
		query.append("/* ACM_FF_CMPN UPDATE */" ).append("\n"); 
		query.append("UPDATE ACM_FF_CMPN A " ).append("\n"); 
		query.append("   SET A.FF_CMPN_STS_CD = 'IF', " ).append("\n"); 
		query.append("       A.GL_DT            = (SELECT DISTINCT B.GL_DT FROM AP_INV_HDR B WHERE B.CSR_NO = A.CSR_NO), " ).append("\n"); 
		query.append("       A.FF_CMPN_RMK = 'APPROVAL REQUEST!', " ).append("\n"); 
		query.append("		/* REQUEST의 경우 날짜 검색 조건을 충족하기 위해 LOCAL TIME으로 UPDATE */" ).append("\n"); 
		query.append("       A.IF_DT = (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD) " ).append("\n"); 
		query.append("                       FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD), " ).append("\n"); 
		query.append("	   A.APRO_DT = (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD) " ).append("\n"); 
		query.append("                       FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD)" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 

	}
}