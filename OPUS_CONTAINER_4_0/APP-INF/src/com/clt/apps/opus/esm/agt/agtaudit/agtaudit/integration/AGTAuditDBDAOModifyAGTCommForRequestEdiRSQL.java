/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommForRequestEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.02 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyAGTCommForRequestEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommForRequestEdi
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommForRequestEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommForRequestEdiRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		   'I'                                   AS EAI_STS," ).append("\n"); 
		query.append("           TO_CHAR (SYSDATE, 'YYYYMMDDHH24MISS') AS EAI_DT," ).append("\n"); 
		query.append("	   	   'EDI'                                 AS COMPANY," ).append("\n"); 
		query.append("	   	   BKG_NO," ).append("\n"); 
		query.append("           AGN_CD," ).append("\n"); 
		query.append("           IO_BND_CD," ).append("\n"); 
		query.append("           AC_TP_CD," ).append("\n"); 
		query.append("           AC_SEQ," ).append("\n"); 
		query.append("           COMM_PROC_STS_CD," ).append("\n"); 
		query.append("           COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("           VNDR_CNT_CD," ).append("\n"); 
		query.append("           VNDR_SEQ," ).append("\n"); 
		query.append("           ACT_COMM_AMT," ).append("\n"); 
		query.append("           ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("           ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("           CURR_CD," ).append("\n"); 
		query.append("      CASE XCH_RT_APLY_LVL" ).append("\n"); 
		query.append("      WHEN '1'" ).append("\n"); 
		query.append("      THEN TO_CHAR(VVD_XCH_RT)" ).append("\n"); 
		query.append("      WHEN '2'" ).append("\n"); 
		query.append("      THEN TO_CHAR(MON_XCH_RT)" ).append("\n"); 
		query.append("      WHEN  '3'" ).append("\n"); 
		query.append("      THEN TO_CHAR(DLY_XCH_RT)" ).append("\n"); 
		query.append("      ELSE ''" ).append("\n"); 
		query.append("       END                                       AS XCH_RT," ).append("\n"); 
		query.append("	   	   CRE_USR_ID " ).append("\n"); 
		query.append("      FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("     WHERE COMM_PROC_STS_CD" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         ( 'RS', 'AS', 'IF'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("       AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("       AND CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("       AND BKG_NO" ).append("\n"); 
		query.append("        IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("           ${bkg_no}" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  ORDER BY" ).append("\n"); 
		query.append("           BKG_NO," ).append("\n"); 
		query.append("           AGN_CD," ).append("\n"); 
		query.append("           IO_BND_CD," ).append("\n"); 
		query.append("           AC_TP_CD," ).append("\n"); 
		query.append("           AC_SEQ" ).append("\n"); 

	}
}