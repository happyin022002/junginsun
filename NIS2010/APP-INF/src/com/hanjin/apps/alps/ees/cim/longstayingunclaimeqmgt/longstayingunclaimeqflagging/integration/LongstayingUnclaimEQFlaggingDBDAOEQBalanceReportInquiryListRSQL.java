/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOEQBalanceReportInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOEQBalanceReportInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [EES_CIM_0061] EQ Balance Report Inquiry => Main Search
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOEQBalanceReportInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOEQBalanceReportInquiryListRSQL").append("\n"); 
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
		query.append("SELECT * FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  SELECT " ).append("\n"); 
		query.append("        MAX((SELECT T.RCC_CD" ).append("\n"); 
		query.append("            FROM  MDM_EQ_ORZ_CHT T" ).append("\n"); 
		query.append("            WHERE T.ECC_CD = X.ECC_CD" ).append("\n"); 
		query.append("            AND  ROWNUM = 1" ).append("\n"); 
		query.append("        )) RCC_CD," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        X.SCONTI_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        MAX((SELECT T.LCC_CD" ).append("\n"); 
		query.append("            FROM  MDM_EQ_ORZ_CHT T" ).append("\n"); 
		query.append("            WHERE T.ECC_CD = X.ECC_CD" ).append("\n"); 
		query.append("            AND  ROWNUM = 1" ).append("\n"); 
		query.append("        )) LCC_CD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        X.ECC_CD," ).append("\n"); 
		query.append("        X.TGT_YRWK," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        MAX((SELECT N.SCONTI_NM" ).append("\n"); 
		query.append("            FROM MDM_SUBCONTINENT N" ).append("\n"); 
		query.append("            WHERE N.SCONTI_CD = X.SCONTI_CD" ).append("\n"); 
		query.append("        )) || ' (' || X.SCONTI_CD || ')' SCONTI_NM," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'D2', X.SPLS_DFCT_STS_CTNT, '')) D2_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'D4', X.SPLS_DFCT_STS_CTNT, '')) D4_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'D5', X.SPLS_DFCT_STS_CTNT, '')) D5_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'D7', X.SPLS_DFCT_STS_CTNT, '')) D7_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'R2', X.SPLS_DFCT_STS_CTNT, '')) R2_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'R5', X.SPLS_DFCT_STS_CTNT, '')) R5_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'O2', X.SPLS_DFCT_STS_CTNT, '')) O2_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'O4', X.SPLS_DFCT_STS_CTNT, '')) O4_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'F2', X.SPLS_DFCT_STS_CTNT, '')) F2_STS," ).append("\n"); 
		query.append("        MAX(DECODE(X.CNTR_TPSZ_CD, 'F4', X.SPLS_DFCT_STS_CTNT, '')) F4_STS," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        MAX(X.CFM_FLG) CFM_FLG," ).append("\n"); 
		query.append("        MAX(X.STS_RMK) STS_RMK" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("     SELECT " ).append("\n"); 
		query.append("            S.TGT_YRWK," ).append("\n"); 
		query.append("            S.ECC_CD," ).append("\n"); 
		query.append("            S.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            S.SPLS_DFCT_STS_CTNT," ).append("\n"); 
		query.append("            S.CFM_FLG," ).append("\n"); 
		query.append("            S.STS_RMK," ).append("\n"); 
		query.append("            Y.SCONTI_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("     FROM CIM_EQ_SPLS_DFCT_STS S," ).append("\n"); 
		query.append("          MDM_COUNTRY Y" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     #if (${fm_week} != '' && ${to_week} != '')     " ).append("\n"); 
		query.append("     WHERE S.TGT_YRWK between REPLACE(@[fm_week],'-','') and REPLACE(@[to_week],'-','')" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND S.FULL_MTY_CD = 'F'" ).append("\n"); 
		query.append("       AND S.MVMT_CO_CD  = 'H'" ).append("\n"); 
		query.append("       AND S.SOC_FLG     = 'N'" ).append("\n"); 
		query.append("       AND S.ENR_FLG     = 'N'" ).append("\n"); 
		query.append("       AND S.TN_ROUT_FLG = 'N'" ).append("\n"); 
		query.append("       AND S.CNTR_TPSZ_CD IN ('D2', 'D4', 'D5', 'D7', 'R2', 'R5', 'O2', 'O4', 'F2', 'F4')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND SUBSTR(S.ECC_CD, 1, 2) = Y.CNT_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("  ) X" ).append("\n"); 
		query.append("  GROUP BY" ).append("\n"); 
		query.append("      X.SCONTI_CD," ).append("\n"); 
		query.append("      X.ECC_CD," ).append("\n"); 
		query.append("      X.TGT_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${rhq_cd} != 'ALL' && ${rhq_cd} != '')" ).append("\n"); 
		query.append("AND RCC_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		select RCC_CD" ).append("\n"); 
		query.append("		from CIM_EQ_SPLS_DFCT_RHQ" ).append("\n"); 
		query.append("		where 1= 1" ).append("\n"); 
		query.append("		and RHQ_CD = @[rhq_cd]   -- RHQ CODE" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fm_week} != '' && ${to_week} != '')" ).append("\n"); 
		query.append("AND TGT_YRWK between REPLACE(@[fm_week],'-','') and REPLACE(@[to_week],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sconti_cd} != 'ALL' && ${sconti_cd} != '')" ).append("\n"); 
		query.append("AND SCONTI_CD = @[sconti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lcc_cd} != 'ALL' && ${lcc_cd} != '')" ).append("\n"); 
		query.append("AND LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ecc_cd} != 'ALL' && ${ecc_cd} != '')" ).append("\n"); 
		query.append("AND ECC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 5, 1, 2, 3, 4" ).append("\n"); 

	}
}