/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchCostBySimulationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.11.22 진마리아
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

public class GeneralInvoiceAuditDBDAOsearchCostBySimulationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 port, yard, account code 에 해당하는 cost  정보를 조회한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchCostBySimulationRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchCostBySimulationRSQL").append("\n"); 
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
		query.append("/**** Tariff에 등록되어 있는 Cost 조회 ****/" ).append("\n"); 
		query.append("SELECT T2.LGS_COST_CD      COST_CD" ).append("\n"); 
		query.append("      ,T2.LGS_COST_FULL_NM COST_NM" ).append("\n"); 
		query.append("FROM   TES_LGS_COST     T2" ).append("\n"); 
		query.append("      ,(SELECT DISTINCT A.LGS_COST_CD" ).append("\n"); 
		query.append("        FROM   PSO_YD_CHG A" ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    A.YD_CD LIKE @[port_cd] || NVL(@[yard_cd], '%')" ).append("\n"); 
		query.append("--        AND    A.CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("        AND    A.LST_FLG = 'Y'" ).append("\n"); 
		query.append("       #if(${issue_date} != '')" ).append("\n"); 
		query.append("        AND    TO_DATE(REPLACE(@[issue_date], '-', ''), 'YYYYMMDD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ) T4" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T2.LGS_COST_CD = T4.LGS_COST_CD" ).append("\n"); 
		query.append("AND    T2.ACCT_CD <> '999999'" ).append("\n"); 
		query.append("AND    T2.LGS_COST_CD LIKE '____' || '%'" ).append("\n"); 
		query.append("AND    T2.ACCT_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${acct_cd}) " ).append("\n"); 
		query.append("         #if($velocityCount < $acct_cd.size()) " ).append("\n"); 
		query.append("          '$key', " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("          '$key' " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

	}
}