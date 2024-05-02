/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchProviderBySimulationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.03.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchProviderBySimulationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff에 해당하는 Vendors 조회
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchProviderBySimulationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchProviderBySimulationRSQL").append("\n"); 
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
		query.append("/**** Tariff에 해당하는 Vendors 조회 ****/" ).append("\n"); 
		query.append("SELECT Y.VNDR_SEQ" ).append("\n"); 
		query.append("      ,Y.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT DISTINCT A.VNDR_SEQ " ).append("\n"); 
		query.append("        FROM   PSO_YD_CHG A" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    A.YD_CD LIKE @[port_cd] || @[yard_cd]" ).append("\n"); 
		query.append("        AND    A.LGS_COST_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${cost_cd}) " ).append("\n"); 
		query.append("         #if($velocityCount < $cost_cd.size()) " ).append("\n"); 
		query.append("          '$key', " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("          '$key' " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if( ${issue_date} != '' )" ).append("\n"); 
		query.append("	    AND    TO_DATE(REPLACE(@[issue_date], '-', ''), 'YYYYMMDD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND    A.LST_FLG = 'Y'" ).append("\n"); 
		query.append("--        AND    A.CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("      ,MDM_VENDOR Y" ).append("\n"); 
		query.append("WHERE  X.VNDR_SEQ = Y.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY Y.VNDR_SEQ" ).append("\n"); 

	}
}