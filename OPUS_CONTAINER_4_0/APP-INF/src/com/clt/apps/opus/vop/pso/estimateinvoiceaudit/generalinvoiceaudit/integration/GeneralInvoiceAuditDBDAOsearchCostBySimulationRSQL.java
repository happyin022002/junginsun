/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchCostBySimulationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
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
		query.append("SELECT T2.LGS_COST_CD       AS COST_CD" ).append("\n"); 
		query.append("     , T2.LGS_COST_FULL_NM  AS COST_NM" ).append("\n"); 
		query.append("  FROM TES_LGS_COST T2" ).append("\n"); 
		query.append("     ,( SELECT DISTINCT LGS_COST_CD" ).append("\n"); 
		query.append("          FROM (SELECT C.YD_CD" ).append("\n"); 
		query.append("                     , C.LGS_COST_CD" ).append("\n"); 
		query.append("                     , C.VNDR_SEQ" ).append("\n"); 
		query.append("                     , C.CPLS_FLG" ).append("\n"); 
		query.append("                     , COUNT( * ) OVER (PARTITION BY C.YD_CD, C.LGS_COST_CD" ).append("\n"); 
		query.append("                         ORDER BY C.YD_CD, C.LGS_COST_CD) AS CNT" ).append("\n"); 
		query.append("                  FROM PSO_YD_CHG C" ).append("\n"); 
		query.append("                 WHERE C.YD_CD LIKE @[port_cd] || NVL(@[yard_cd], '%') /*'BRNVTM1'*/" ).append("\n"); 
		query.append("       			#if(${issue_date} != '')" ).append("\n"); 
		query.append("                   AND TO_DATE(REPLACE(@[issue_date], '-', ''), 'YYYYMMDD') BETWEEN C.EFF_DT AND C.EXP_DT" ).append("\n"); 
		query.append("       			#end" ).append("\n"); 
		query.append("                   AND C.LST_FLG = 'Y'" ).append("\n"); 
		query.append("                 GROUP BY C.YD_CD" ).append("\n"); 
		query.append("                     , C.LGS_COST_CD" ).append("\n"); 
		query.append("                     , C.VNDR_SEQ" ).append("\n"); 
		query.append("                     , C.CPLS_FLG )" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("#if( ${cpls_flg} != '' && ${cpls_flg} == 'Y' )" ).append("\n"); 
		query.append("           --Compulsory flag Y 일대 아래 조건 활성." ).append("\n"); 
		query.append("           AND (CASE WHEN CNT >= 2 THEN 'Y' ELSE CPLS_FLG END) = CPLS_FLG " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) T4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND T2.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("   AND T2.LGS_COST_CD   = T4.LGS_COST_CD" ).append("\n"); 
		query.append("   AND T2.LGS_COST_SUBJ_CD = DECODE(@[port_cd],'EGSCA','CN','PAPCA','CN','PT')" ).append("\n"); 
		query.append("#if(${acct_cd} != '')" ).append("\n"); 
		query.append("   AND T2.ACCT_CD IN ( " ).append("\n"); 
		query.append("       #foreach($key IN ${acct_cd}) " ).append("\n"); 
		query.append("         #if($velocityCount < $acct_cd.size()) " ).append("\n"); 
		query.append("          '$key', " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("          '$key' " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY T2.LGS_COST_OPT_NO" ).append("\n"); 

	}
}