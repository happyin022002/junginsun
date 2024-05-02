/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchPSOFile.java
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

public class GeneralInvoiceAuditDBDAOSearchPSOFile implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.10.29 PSO FILE 조회하여 GW로 카피한다
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchPSOFile(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchPSOFile").append("\n"); 
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
		query.append("WITH PSO_FILE AS (" ).append("\n"); 
		query.append("        SELECT FILE_SAVE_ID --YD_CHG_NO : FILE_SAVE_ID = 1 : 1" ).append("\n"); 
		query.append("          FROM PSO_TRF_ATCH_FILE" ).append("\n"); 
		query.append("        WHERE YD_CHG_NO IN (" ).append("\n"); 
		query.append("							#if (${yd_chg_no}!='')" ).append("\n"); 
		query.append("                            ${yd_chg_no}" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("							'X'" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						   )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.FILE_SAV_ID," ).append("\n"); 
		query.append("            A.FILE_PATH_URL" ).append("\n"); 
		query.append("  FROM COM_UPLD_FILE A" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("                          SELECT 1" ).append("\n"); 
		query.append("                            FROM PSO_FILE B" ).append("\n"); 
		query.append("                          WHERE A.FILE_SAV_ID = B.FILE_SAVE_ID" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}