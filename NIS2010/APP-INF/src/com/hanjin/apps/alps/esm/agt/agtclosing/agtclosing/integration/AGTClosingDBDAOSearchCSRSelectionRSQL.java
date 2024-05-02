/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTClosingDBDAOSearchCSRSelectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.13
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.01.13 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTClosingDBDAOSearchCSRSelectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGTClosingDBDAOSearchCSRSelectionRSQL
	  * </pre>
	  */
	public AGTClosingDBDAOSearchCSRSelectionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration").append("\n"); 
		query.append("FileName : AGTClosingDBDAOSearchCSRSelectionRSQL").append("\n"); 
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
		query.append("select '02SSAOBB10010710001 ' CSR_NO, 'MUNCIIPAL TAX -ISS DEC.09' des, '20101206' gl_dt, 'SAOBB ' off_cd, 'BRSAO ' slip_loc from dual union all" ).append("\n"); 
		query.append("select '02SSAOBB10010710002 ' CSR_NO, 'INV NO 0D2156 AGENT COMMISSION' des, '20101206' gl_dt, 'SAOBB ' off_cd, 'BRSAO ' slip_loc from dual union all" ).append("\n"); 
		query.append("select '02SSAOBB10010710003 ' CSR_NO, 'BOX FEE - DIFF. AMOUNT NOT CALCULATED IN AGT COMM.' des, '20101206' gl_dt, 'SAOBB ' off_cd, 'BRSAO ' slip_loc from dual union all" ).append("\n"); 
		query.append("select '02SSAOBB10010710004 ' CSR_NO, 'AGENCY COMMISSION MONTHLY AS PER AGENCY AGREEMENT' des, '20101206' gl_dt, 'SAOBB ' off_cd, 'BRSAO ' slip_loc from dual union all" ).append("\n"); 
		query.append("select '02SSAOBB10010710005 ' CSR_NO, 'DEMURRAGE COMMISSIONS' des, '20101206' gl_dt, 'SAOBB ' off_cd, 'BRSAO ' slip_loc from dual union all" ).append("\n"); 
		query.append("select '02SSAOBB10010710006 ' CSR_NO, 'THC Refund related to GSA side letter Nov2007 to June2008' des, '20101206' gl_dt, 'SAOBB ' off_cd, 'BRSAO ' slip_loc from dual union all" ).append("\n"); 
		query.append("select '02SSAOBB10010710007 ' CSR_NO, 'AGENT COMM FOR YOKBA(STAMP)' des, '20101206' gl_dt, 'SAOBB ' off_cd, 'BRSAO ' slip_loc from dual" ).append("\n"); 

	}
}