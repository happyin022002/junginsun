/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchOfficeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchOfficeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_hohq_gbn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_office_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_office_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_com_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_sumup_office",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchOfficeInfoRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_ENG_NM OFC_ENG_NM" ).append("\n"); 
		query.append("      ,A.CTR_CD CTR_CD" ).append("\n"); 
		query.append("      ,A.AP_CTRL_OFC_CD AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_OFC_LVL GEN_EXPN_OFC_LVL" ).append("\n"); 
		query.append("      ,A.PRNT_OFC_CD PRNT_OFC_CD" ).append("\n"); 
		query.append("      ,A.RGN_OFC_FLG RGN_OFC_FLG" ).append("\n"); 
		query.append("      ,A.SLS_OFC_FLG SLS_OFC_FLG" ).append("\n"); 
		query.append("      ,A.OFC_CO_DIV_CD OFC_CO_DIV_CD" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.RQST_UT_VAL RQST_UT_VAL" ).append("\n"); 
		query.append("      ,DECODE(A.RQST_AUTH_FLG,'Y','1','0') RQST_AUTH_FLG" ).append("\n"); 
		query.append("      ,DECODE(A.RHQ_AUTH_FLG,'Y','1','0') RHQ_AUTH_FLG" ).append("\n"); 
		query.append("      ,DECODE(A.TIC_AUTH_FLG,'Y','1','0') TIC_AUTH_FLG" ).append("\n"); 
		query.append("      ,DECODE(A.CMIT_AUTH_FLG,'Y','1','0') CMIT_AUTH_FLG" ).append("\n"); 
		query.append("      ,A.EXPN_SMRY_OFC_CD EXPN_SMRY_OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(A.EXPN_SMRY_YRMON,'yyyy-MM'),'yyyy-MM') EXPN_SMRY_YRMON" ).append("\n"); 
		query.append("      ,A.DELT_FLG DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_DT CRE_DT" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT UPD_DT" ).append("\n"); 
		query.append("	  ,(SELECT MAX (DECODE (EXP_DT, NULL, 1, 0)) CNT FROM GEM_OFC_HIS WHERE OFC_CD = A.OFC_CD) OFC_HIS_CNT" ).append("\n"); 
		query.append("  FROM GEM_OFFICE A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${sch_lvl1} != '' || ${sch_lvl2} != '' || ${sch_lvl3} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD IN (   " ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("          FROM GEM_OFFICE		   		" ).append("\n"); 
		query.append("		   #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} != '') START WITH OFC_CD = @[sch_lvl3] #end" ).append("\n"); 
		query.append("		   #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} == '') START WITH OFC_CD = @[sch_lvl2] #end" ).append("\n"); 
		query.append("		   #if(${sch_lvl1} != '' && ${sch_lvl2} == '' && ${sch_lvl3} == '') START WITH OFC_CD = @[sch_lvl1] #end" ).append("\n"); 
		query.append("		 CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_hohq_gbn} != '')" ).append("\n"); 
		query.append("   AND A.RGN_OFC_FLG = @[sch_hohq_gbn]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'Y')" ).append("\n"); 
		query.append("   #if(${sch_office_code} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'N')" ).append("\n"); 
		query.append("   #if(${sch_office_code} != '')" ).append("\n"); 
		query.append("   AND A.PRNT_OFC_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'C')" ).append("\n"); 
		query.append("   #if(${sch_office_code} != '')" ).append("\n"); 
		query.append("   AND A.CTR_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_lvl} != '')" ).append("\n"); 
		query.append("   AND A.GEN_EXPN_OFC_LVL = @[sch_office_lvl]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_com_div} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CO_DIV_CD = @[sch_com_div]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${str_app_div_sql} != '')" ).append("\n"); 
		query.append("   ${str_app_div_sql}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_sumup_gbn} == 'Y')" ).append("\n"); 
		query.append("   #if(${sch_sumup_office} != '')" ).append("\n"); 
		query.append("   AND A.EXPN_SMRY_OFC_CD = @[sch_sumup_office]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_delt_flg} == 'Y')" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.OFC_CD, A.CTR_CD" ).append("\n"); 

	}
}