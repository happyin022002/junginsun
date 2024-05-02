/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOSearchCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOSearchCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PsoAdvanceAuditDBDAOSearchCost 
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOSearchCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOSearchCostRSQL").append("\n"); 
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
		query.append("SELECT distinct A.LGS_COST_CD      AS COST_CD" ).append("\n"); 
		query.append("     , B.LGS_COST_FULL_NM AS COST_NM" ).append("\n"); 
		query.append("  FROM EAS_PORT_SO_CHG_ACCT  A" ).append("\n"); 
		query.append("     , TES_LGS_COST B" ).append("\n"); 
		query.append("     , MDM_ACCOUNT C" ).append("\n"); 
		query.append(" WHERE A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("   AND B.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("   AND B.ACCT_CD <> '999999' " ).append("\n"); 
		query.append("#if ( ${rhq} != '' ) " ).append("\n"); 
		query.append("   AND AUD_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${divChargeType} == '1' ) " ).append("\n"); 
		query.append("AND   A.LGS_COST_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${divChargeType} == '2')" ).append("\n"); 
		query.append("    #if (${chargeType} != '04' ) " ).append("\n"); 
		query.append("      AND   A.LGS_COST_AUD_FLG = 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '01' ) " ).append("\n"); 
		query.append("	----PORT CHARGE 선택시" ).append("\n"); 
		query.append("	and SUBSTR(to_char(B.acct_cd),1,4) = '5117'" ).append("\n"); 
		query.append("	and length(B.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("    and B.ACCT_CD <> '511795'" ).append("\n"); 
		query.append("	AND C.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '02' ) " ).append("\n"); 
		query.append("	----PORT SERVICE CHARGE 선택시" ).append("\n"); 
		query.append("	and SUBSTR(to_char(B.acct_cd),1,4) = '5118'" ).append("\n"); 
		query.append("	and length(B.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("    and B.ACCT_CD <> '511795'" ).append("\n"); 
		query.append("	AND C.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '03' ) " ).append("\n"); 
		query.append("	----Canal Transit Fee 선택시" ).append("\n"); 
		query.append("	and SUBSTR(to_char(B.acct_cd),1,4) = '5119'" ).append("\n"); 
		query.append("	and length(B.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("    and B.ACCT_CD <> '511795'" ).append("\n"); 
		query.append("	AND C.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '04' ) " ).append("\n"); 
		query.append("	----Other 선택시" ).append("\n"); 
		query.append("	AND (B.ACCT_CD = '564611' OR B.ACCT_CD = '511795' OR C.ACCT_ENG_NM LIKE 'OTHER PORT%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${acct_cd} != '') " ).append("\n"); 
		query.append("	----Other 선택시" ).append("\n"); 
		query.append("	AND B.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}