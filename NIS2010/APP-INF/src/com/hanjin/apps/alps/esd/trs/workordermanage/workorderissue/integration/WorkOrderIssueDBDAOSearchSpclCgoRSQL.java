/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderIssueDBDAOSearchSpclCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.04.27 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOSearchSpclCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contaner별 Special Cargo Flag조회
	  * </pre>
	  */
	public WorkOrderIssueDBDAOSearchSpclCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOSearchSpclCgoRSQL").append("\n"); 
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
		query.append("SELECT  A.HZD_MTRL_FLG" ).append("\n"); 
		query.append("        ,A.OVWT_TRI_AXL_FLG" ).append("\n"); 
		query.append("   FROM TRS_SPCL_CGO_AVAL_SVC_PROV A" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ = @[VNDR_CD]" ).append("\n"); 
		query.append("    AND A.SO_CRE_OFC_CD = @[CRE_OFC_CD]" ).append("\n"); 
		query.append("    AND ROWNUM =1" ).append("\n"); 

	}
}