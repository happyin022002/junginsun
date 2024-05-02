/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchTariffByYardsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
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

public class GeneralInvoiceAuditDBDAOSearchTariffByYardsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 vvd, yard의 tariff를 조회합니다.
	  * 
	  * =========================
	  * History
	  * 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchTariffByYardsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchTariffByYardsRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CHG_NO" ).append("\n"); 
		query.append("     , A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("     , A.YD_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.LGS_COST_CD COST_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , B.ACCT_CD" ).append("\n"); 
		query.append("     , C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("  FROM (SELECT C.YD_CD" ).append("\n"); 
		query.append("             , C.LGS_COST_CD" ).append("\n"); 
		query.append("             , C.VNDR_SEQ" ).append("\n"); 
		query.append("             , C.CPLS_FLG" ).append("\n"); 
		query.append("             , MAX (C.YD_CHG_NO) YD_CHG_NO" ).append("\n"); 
		query.append("             , MAX (C.YD_CHG_VER_SEQ) YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("             , SUBSTR (MAX (C.YD_CHG_VER_SEQ || CURR_CD), -3) AS CURR_CD" ).append("\n"); 
		query.append("             , COUNT( * ) OVER (PARTITION BY C.YD_CD, C.LGS_COST_CD ORDER BY C.YD_CD, C.LGS_COST_CD) AS CNT" ).append("\n"); 
		query.append("          FROM PSO_YD_CHG C" ).append("\n"); 
		query.append("             , MDM_VENDOR V" ).append("\n"); 
		query.append("         WHERE C.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("           AND TO_DATE (@[vps_etb_dt], 'YYYYMMDD') BETWEEN C.EFF_DT AND C.EXP_DT" ).append("\n"); 
		query.append("           AND C.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("         GROUP BY C.YD_CD, C.LGS_COST_CD, C.VNDR_SEQ, C.CPLS_FLG ) A" ).append("\n"); 
		query.append("     , TES_LGS_COST B" ).append("\n"); 
		query.append("     , MDM_VENDOR C" ).append("\n"); 
		query.append(" WHERE (CASE WHEN CNT >= 2 THEN 'Y' ELSE CPLS_FLG END) = CPLS_FLG" ).append("\n"); 
		query.append("   AND A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 

	}
}