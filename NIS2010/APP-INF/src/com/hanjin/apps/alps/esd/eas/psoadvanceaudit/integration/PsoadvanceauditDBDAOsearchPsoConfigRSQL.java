/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoadvanceauditDBDAOsearchPsoConfigRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.02 
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

public class PsoadvanceauditDBDAOsearchPsoConfigRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre-Audit Criterion setting 내역을 조회한다. 
	  * </pre>
	  */
	public PsoadvanceauditDBDAOsearchPsoConfigRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_aud_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoadvanceauditDBDAOsearchPsoConfigRSQL").append("\n"); 
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
		query.append("SELECT CHG_TP_NM" ).append("\n"); 
		query.append("     , ACCT_CD" ).append("\n"); 
		query.append("     , ACCT_NM" ).append("\n"); 
		query.append("     , COST_CD" ).append("\n"); 
		query.append("     , COST_NM" ).append("\n"); 
		query.append("     , LGS_COST_AUD_FLG" ).append("\n"); 
		query.append("     , EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("     , EXPN_PRMT_RTO_RSN" ).append("\n"); 
		query.append("     , OFC_CD AS AUD_OFC_CD" ).append("\n"); 
		query.append("	 , UPT_DT" ).append("\n"); 
		query.append("FROM (SELECT CASE WHEN AA.CHG_TP_CD = '01' THEN 'PORT CHARGE'" ).append("\n"); 
		query.append("                  WHEN AA.CHG_TP_CD = '02' THEN 'PORT SERVICE CHARGE'" ).append("\n"); 
		query.append("                  WHEN AA.CHG_TP_CD = '03' THEN 'CANAL TRANSIT FEE'" ).append("\n"); 
		query.append("                  WHEN AA.CHG_TP_CD = '04' THEN 'OTHER'" ).append("\n"); 
		query.append("             END CHG_TP_NM" ).append("\n"); 
		query.append("           , AA.CHG_TP_CD" ).append("\n"); 
		query.append("           , AA.ACCT_CD" ).append("\n"); 
		query.append("           , AA.ACCT_NM" ).append("\n"); 
		query.append("           , AA.COST_CD" ).append("\n"); 
		query.append("           , AA.COST_NM" ).append("\n"); 
		query.append("           , BB.LGS_COST_AUD_FLG" ).append("\n"); 
		query.append("           , BB.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("           , BB.EXPN_PRMT_RTO_RSN" ).append("\n"); 
		query.append("           , AA.OFC_CD" ).append("\n"); 
		query.append("		   , TO_CHAR(BB.CRE_DT, 'YYYY-MM-DD') UPT_DT" ).append("\n"); 
		query.append("        FROM (SELECT CHG_TP_CD" ).append("\n"); 
		query.append("                   , ACCT_CD" ).append("\n"); 
		query.append("                   , ACCT_NM" ).append("\n"); 
		query.append("                   , COST_CD" ).append("\n"); 
		query.append("                   , COST_NM" ).append("\n"); 
		query.append("                   , OFC_CD       " ).append("\n"); 
		query.append("                FROM (SELECT CASE WHEN LENGTH(T2.LGS_COST_CD) > 4 AND T3.ACCT_ENG_NM NOT LIKE 'OTHER PORT%' AND SUBSTR(TO_CHAR(T2.ACCT_CD),1,4) = '5117' AND T2.ACCT_CD != '511795' THEN '01'" ).append("\n"); 
		query.append("                                  WHEN LENGTH(T2.LGS_COST_CD) > 4 AND T3.ACCT_ENG_NM NOT LIKE 'OTHER PORT%' AND SUBSTR(TO_CHAR(T2.ACCT_CD),1,4) = '5118' THEN '02'" ).append("\n"); 
		query.append("                                  WHEN LENGTH(T2.LGS_COST_CD) > 4 AND T3.ACCT_ENG_NM NOT LIKE 'OTHER PORT%' AND SUBSTR(TO_CHAR(T2.ACCT_CD),1,4) = '5119' THEN '03'" ).append("\n"); 
		query.append("                                  --WHEN T2.ACCT_CD = '564611' OR T3.ACCT_ENG_NM LIKE 'OTHER PORT%' THEN '04'" ).append("\n"); 
		query.append("        				       WHEN T2.ACCT_CD IN ('564611', '511795') OR T3.ACCT_ENG_NM LIKE 'OTHER PORT%' THEN '04'" ).append("\n"); 
		query.append("                             END CHG_TP_CD" ).append("\n"); 
		query.append("                            ,T2.ACCT_CD" ).append("\n"); 
		query.append("                            ,T3.ACCT_ENG_NM AS ACCT_NM" ).append("\n"); 
		query.append("                            ,T2.LGS_COST_CD AS COST_CD" ).append("\n"); 
		query.append("                            ,T2.LGS_COST_FULL_NM AS COST_NM      " ).append("\n"); 
		query.append("                        FROM TES_LGS_COST T2" ).append("\n"); 
		query.append("                            ,MDM_ACCOUNT  T3" ).append("\n"); 
		query.append("                       WHERE T2.ACCT_CD = T3.ACCT_CD" ).append("\n"); 
		query.append("                       #if(${s_chg_tp_cd} != '')" ).append("\n"); 
		query.append("                           #if(${s_chg_tp_cd} == '04')" ).append("\n"); 
		query.append("                               AND T2.ACCT_CD <> '999999'" ).append("\n"); 
		query.append("                           #elseif (${s_chg_tp_cd} != '04') " ).append("\n"); 
		query.append("                               AND (T2.ACCT_CD <> '999999' AND T2.ACCT_CD <> '511795')" ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                       #end        		              " ).append("\n"); 
		query.append("                               AND ((    LENGTH(T2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("                                    AND T3.ACCT_ENG_NM NOT LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("                                    AND SUBSTR(TO_CHAR(T2.ACCT_CD),1,4) IN ('5117', '5118', '5119')" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                    OR " ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                    T2.ACCT_CD = '564611' OR T3.ACCT_ENG_NM LIKE 'OTHER PORT%'" ).append("\n"); 
		query.append("                                    )) " ).append("\n"); 
		query.append("                      ) A" ).append("\n"); 
		query.append("                      ,(SELECT OFC_CD" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE  OFC_TP_CD =  'HQ'" ).append("\n"); 
		query.append("                      ) B" ).append("\n"); 
		query.append("            ) AA" ).append("\n"); 
		query.append("            , EAS_PORT_SO_CHG_ACCT BB" ).append("\n"); 
		query.append("       WHERE AA.COST_CD = BB.LGS_COST_CD(+)" ).append("\n"); 
		query.append("       AND   AA.OFC_CD =  BB.AUD_OFC_CD(+)" ).append("\n"); 
		query.append("#if(${s_chg_tp_cd} != '')" ).append("\n"); 
		query.append("   #if(${s_chg_tp_cd} == '04')" ).append("\n"); 
		query.append("       AND (AA.CHG_TP_CD = @[s_chg_tp_cd] OR AA.ACCT_CD = '511795') -- Charge Type (옵션)" ).append("\n"); 
		query.append("   #elseif (${s_chg_tp_cd} != '04') " ).append("\n"); 
		query.append("       AND AA.CHG_TP_CD = @[s_chg_tp_cd] -- Charge Type (옵션)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${s_auto_acd} == 'Y')" ).append("\n"); 
		query.append("    AND LGS_COST_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_auto_acd} == 'N')" ).append("\n"); 
		query.append("    AND LGS_COST_AUD_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_aud_ofc_cd} != '')" ).append("\n"); 
		query.append("    AND OFC_CD = @[s_aud_ofc_cd]" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("ORDER BY CHG_TP_CD, ACCT_CD, COST_CD ASC" ).append("\n"); 

	}
}