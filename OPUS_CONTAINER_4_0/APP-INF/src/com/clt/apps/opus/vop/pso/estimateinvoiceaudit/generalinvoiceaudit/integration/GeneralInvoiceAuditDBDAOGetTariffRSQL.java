/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOGetTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28 
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

public class GeneralInvoiceAuditDBDAOGetTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건내, 최종 Version의 Tariff 가져오기
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOGetTariffRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOGetTariffRSQL").append("\n"); 
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
		query.append("WITH V_YD_CHG AS (" ).append("\n"); 
		query.append("        SELECT DISTINCT A.*" ).append("\n"); 
		query.append("          FROM (SELECT C.YD_CHG_NO" ).append("\n"); 
		query.append("                     , C.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                     , TO_CHAR(C.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("                     , TO_CHAR(C.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("                     , C.CURR_CD" ).append("\n"); 
		query.append("                     , C.CPLS_FLG" ).append("\n"); 
		query.append("                     , C.LST_FLG" ).append("\n"); 
		query.append("                     , C.LGS_COST_CD" ).append("\n"); 
		query.append("                     , C.VNDR_SEQ" ).append("\n"); 
		query.append("                     , COUNT( * ) OVER (PARTITION BY C.YD_CD, C.LGS_COST_CD ORDER BY C.YD_CD, C.LGS_COST_CD) AS CNT" ).append("\n"); 
		query.append("                  FROM PSO_YD_CHG C" ).append("\n"); 
		query.append("                 WHERE C.YD_CD LIKE @[port_cd] || @[yard_cd]" ).append("\n"); 
		query.append("                   AND TO_DATE(REPLACE(@[issue_date], '-', ''), 'YYYYMMDD') BETWEEN C.EFF_DT AND C.EXP_DT" ).append("\n"); 
		query.append("                   AND C.LST_FLG = 'Y'" ).append("\n"); 
		query.append("                 GROUP BY C.YD_CHG_NO" ).append("\n"); 
		query.append("                     , C.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                     , C.YD_CD" ).append("\n"); 
		query.append("                     , TO_CHAR(C.EFF_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                     , TO_CHAR(C.EXP_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                     , C.CURR_CD" ).append("\n"); 
		query.append("                     , C.CPLS_FLG" ).append("\n"); 
		query.append("                     , C.LST_FLG" ).append("\n"); 
		query.append("                     , C.LGS_COST_CD" ).append("\n"); 
		query.append("                     , C.VNDR_SEQ ) A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("#if( ${cpls_flg} != '' && ${cpls_flg} == 'Y' )" ).append("\n"); 
		query.append("           --Compulsory flag Y 일대 아래 조건 활성." ).append("\n"); 
		query.append("           AND (CASE WHEN A.CNT >= 2 THEN 'Y' ELSE A.CPLS_FLG END) = A.CPLS_FLG " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT *  FROM V_YD_CHG" ).append("\n"); 
		query.append("SELECT A.YD_CHG_NO" ).append("\n"); 
		query.append("     , A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("     , A.EFF_DT" ).append("\n"); 
		query.append("     , A.EXP_DT" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.CPLS_FLG" ).append("\n"); 
		query.append("     , A.LST_FLG" ).append("\n"); 
		query.append("     , A.LGS_COST_CD AS COST_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , B.ACCT_CD" ).append("\n"); 
		query.append("     , C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("  FROM V_YD_CHG A" ).append("\n"); 
		query.append("     , TES_LGS_COST B" ).append("\n"); 
		query.append("     , MDM_VENDOR C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${vndr_seq_all_flg} != '' && ${vndr_seq_all_flg} != 'Y') " ).append("\n"); 
		query.append("		 AND A.VNDR_SEQ IN (" ).append("\n"); 
		query.append("             #foreach($key IN ${vndr_seq})" ).append("\n"); 
		query.append("             	#if($velocityCount < $vndr_seq.size()) '$key', #else '$key' #end" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_cd_all_flg} != '' && ${cost_cd_all_flg} != 'Y') " ).append("\n"); 
		query.append("		 AND A.LGS_COST_CD IN (" ).append("\n"); 
		query.append("             #foreach(${key2} IN ${cost_cd})" ).append("\n"); 
		query.append("             	#if($velocityCount < $cost_cd.size()) '$key2', #else '$key2' #end" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.LGS_COST_CD    = B.LGS_COST_CD" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ       = C.VNDR_SEQ " ).append("\n"); 

	}
}