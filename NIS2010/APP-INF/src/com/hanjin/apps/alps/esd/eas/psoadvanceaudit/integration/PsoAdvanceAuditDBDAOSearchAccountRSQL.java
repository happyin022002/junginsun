/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOSearchAccountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.01 
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

public class PsoAdvanceAuditDBDAOSearchAccountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PsoAdvanceAuditDBDAOSearchAccount 
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOSearchAccountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOSearchAccountRSQL").append("\n"); 
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
		query.append("SELECT distinct T2.ACCT_CD          ACCT_CD   " ).append("\n"); 
		query.append("      ,T3.ACCT_ENG_NM      ACCT_NM" ).append("\n"); 
		query.append("FROM   TES_LGS_COST     T2" ).append("\n"); 
		query.append("      ,MDM_ACCOUNT      T3" ).append("\n"); 
		query.append("      ,EAS_PORT_SO_CHG_ACCT A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T2.ACCT_CD = T3.ACCT_CD" ).append("\n"); 
		query.append("AND    T2.ACCT_CD <> '999999'" ).append("\n"); 
		query.append("AND    T2.LGS_COST_CD = A.LGS_COST_CD" ).append("\n"); 
		query.append("#if ( ${divChargeType} == '1' ) " ).append("\n"); 
		query.append("AND   A.LGS_COST_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${divChargeType} == '2' ) " ).append("\n"); 
		query.append("AND   A.LGS_COST_AUD_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${rhq} != '' ) " ).append("\n"); 
		query.append("AND    A.AUD_OFC_CD =@[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    T2.ACCT_CD <> '999999'" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '01' ) " ).append("\n"); 
		query.append("	----PORT CHARGE 선택시" ).append("\n"); 
		query.append("    AND T2.ACCT_CD <> '511795'" ).append("\n"); 
		query.append("	AND SUBSTR(to_char(t2.acct_cd),1,4) = '5117'" ).append("\n"); 
		query.append("	AND length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("	AND T3.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '02' ) " ).append("\n"); 
		query.append("	----PORT SERVICE CHARGE 선택시" ).append("\n"); 
		query.append("    AND T2.ACCT_CD <> '511795'" ).append("\n"); 
		query.append("	AND SUBSTR(to_char(t2.acct_cd),1,4) = '5118'" ).append("\n"); 
		query.append("	AND length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("	AND T3.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '03' ) " ).append("\n"); 
		query.append("	----Canal Transit Fee 선택시" ).append("\n"); 
		query.append("    AND T2.ACCT_CD <> '511795'" ).append("\n"); 
		query.append("	AND SUBSTR(to_char(t2.acct_cd),1,4) = '5119'" ).append("\n"); 
		query.append("	AND length(t2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("	AND T3.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chargeType} != '' && ${chargeType} == '04' ) " ).append("\n"); 
		query.append("	----Other 선택시" ).append("\n"); 
		query.append("	AND (T2.ACCT_CD = '564611' OR T2.ACCT_CD = '511795' OR T3.ACCT_ENG_NM LIKE 'OTHER PORT%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}