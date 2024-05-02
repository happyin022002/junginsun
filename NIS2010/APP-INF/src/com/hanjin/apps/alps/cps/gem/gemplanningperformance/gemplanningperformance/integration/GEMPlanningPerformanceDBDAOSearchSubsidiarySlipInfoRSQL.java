/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchSubsidiarySlipInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchSubsidiarySlipInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.04.09 [CHM-201217079-01] 이준범
	  * 1.subsidiary Slip Upload  신규 기능 추가
	  *   : 현지법인 전표 정보 조회
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchSubsidiarySlipInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchSubsidiarySlipInfoRSQL").append("\n"); 
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
		query.append("SELECT A.SLP_TJ_NO" ).append("\n"); 
		query.append("      ,A.SLP_SEQ_NO" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,A.SLP_CURR_CD" ).append("\n"); 
		query.append("      ,A.SLP_CTR_CD" ).append("\n"); 
		query.append("      ,A.GL_EFF_DT" ).append("\n"); 
		query.append("      ,A.SUBS_ACCT_CD" ).append("\n"); 
		query.append("      ,A.SLP_AMT" ).append("\n"); 
		query.append("      ,A.SLP_DESC" ).append("\n"); 
		query.append("      ,A.SLP_IF_FLG" ).append("\n"); 
		query.append("      ,B.TIC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SLP_TJ_NO" ).append("\n"); 
		query.append("              ,SLP_SEQ_NO" ).append("\n"); 
		query.append("              ,OFC_CD" ).append("\n"); 
		query.append("              ,SLP_CURR_CD" ).append("\n"); 
		query.append("              ,SLP_CTR_CD" ).append("\n"); 
		query.append("              ,GL_EFF_DT" ).append("\n"); 
		query.append("              ,SUBS_ACCT_CD" ).append("\n"); 
		query.append("              ,SLP_AMT" ).append("\n"); 
		query.append("              ,SLP_DESC" ).append("\n"); 
		query.append("              ,SLP_IF_FLG" ).append("\n"); 
		query.append("          FROM GEM_SLP_IF A" ).append("\n"); 
		query.append("         WHERE GL_EFF_DT LIKE @[pln_yr]||@[pln_mon]||'%'" ).append("\n"); 
		query.append("           AND SYS_CATE_NM = 'Subsidiary'" ).append("\n"); 
		query.append("		   #if(${slp_if_flg} == 'Y')" ).append("\n"); 
		query.append("           AND SLP_IF_FLG = 'N'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,(           " ).append("\n"); 
		query.append("        SELECT A.OFC_CD" ).append("\n"); 
		query.append("              ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,A.SUBS_ACCT_CD" ).append("\n"); 
		query.append("              ,B.TIC_CD" ).append("\n"); 
		query.append("          FROM GEM_SUBS_ACCT_MTX A" ).append("\n"); 
		query.append("              ,GEM_EXPENSE B" ).append("\n"); 
		query.append("         WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append(" WHERE A.OFC_CD = B.OFC_CD(+)" ).append("\n"); 
		query.append("   AND A.SUBS_ACCT_CD = B.SUBS_ACCT_CD(+)" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("-- (YNYN) 일때 -- 비용주관팀           " ).append("\n"); 
		query.append("     AND ( A.OFC_CD IN (SELECT OFC_CD      " ).append("\n"); 
		query.append("                          FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                    START WITH OFC_CD IN (@[login_ofc_cd])" ).append("\n"); 
		query.append("              CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) " ).append("\n"); 
		query.append("          OR B.TIC_CD = @[login_ofc_cd] )" ).append("\n"); 
		query.append("#elseif(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("-- (YYYN) 일때 -- BU CTRL||비용주관" ).append("\n"); 
		query.append("     AND ( A.OFC_CD IN ( SELECT OFC_CD      " ).append("\n"); 
		query.append("                           FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                     START WITH OFC_CD IN ( SELECT L_4 " ).append("\n"); 
		query.append("                                              FROM GEM_OFC_LEVEL_V " ).append("\n"); 
		query.append("                                             WHERE L_3 = @[login_ofc_cd] )" ).append("\n"); 
		query.append("               CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) OR B.TIC_CD = @[login_ofc_cd] )    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD IN (   " ).append("\n"); 
		query.append("        				  SELECT OFC_CD      " ).append("\n"); 
		query.append("  							FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("						   START WITH OFC_CD IN (    " ).append("\n"); 
		query.append("        						                 SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("          						                   FROM GEM_OFC_LEVEL_V A" ).append("\n"); 
		query.append("                                                       ,GEM_OFFICE B" ).append("\n"); 
		query.append("         						                  WHERE 1=1" ).append("\n"); 
		query.append("								                    AND A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("                                                    AND B.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("		   						                    #if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("           						                    AND A.RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("		   						                    #end		" ).append("\n"); 
		query.append("		   						                    #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '') " ).append("\n"); 
		query.append("		   						                    AND A.L_4 LIKE @[ofc_lvl3]||'%' " ).append("\n"); 
		query.append("		   						                    #end" ).append("\n"); 
		query.append("		   						                    #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						                    AND A.L_3 LIKE @[ofc_lvl2]||'%' " ).append("\n"); 
		query.append("		   						                    #end" ).append("\n"); 
		query.append("		   						                    #if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '') " ).append("\n"); 
		query.append("		   						                    AND A.L_2 LIKE @[ofc_lvl1]||'%' " ).append("\n"); 
		query.append("		   						                    #end" ).append("\n"); 
		query.append("							                    )" ).append("\n"); 
		query.append(" 	 				 CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.SLP_TJ_NO" ).append("\n"); 
		query.append("        ,A.SLP_SEQ_NO" ).append("\n"); 

	}
}