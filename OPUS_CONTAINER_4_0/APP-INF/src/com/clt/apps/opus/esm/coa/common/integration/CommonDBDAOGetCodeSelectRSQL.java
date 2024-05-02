/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CommonDBDAOGetCodeSelectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOGetCodeSelectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA에서 사용하는 목록성 코드조회
	  * @SJH.20140818.ADD : sokeupStatus 추가
	  * @SJH.20141224.ADD : searchSubTradeList2 추가
	  * </pre>
	  */
	public CommonDBDAOGetCodeSelectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdvoyno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slancd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skddircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofccd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnum",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmnlcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofclvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofclvl0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("keyacctgrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frmweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loccd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlttrdgrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dept_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOGetCodeSelectRSQL").append("\n"); 
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
		query.append("#if (${methodname} == '')" ).append("\n"); 
		query.append("	SELECT	'' AS CODE" ).append("\n"); 
		query.append("	,		'' AS NAME" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,		'' AS KEY" ).append("\n"); 
		query.append("	,		'' AS RTN_DATE" ).append("\n"); 
		query.append("	,		'' AS ETD_DT " ).append("\n"); 
		query.append("	,		'' AS OFC_CD" ).append("\n"); 
		query.append("	,		'' AS PRNT_OFC_CD" ).append("\n"); 
		query.append("	,		'' AS SIM_NO" ).append("\n"); 
		query.append("	,		'' AS OFC_LEVEL" ).append("\n"); 
		query.append("	,		'' AS COST_YR" ).append("\n"); 
		query.append("	,		'' AS COST_WK " ).append("\n"); 
		query.append("	,		'' AS TEAM_CODE" ).append("\n"); 
		query.append("	,		'' AS RT" ).append("\n"); 
		query.append("	,		'' AS SORT_KEY" ).append("\n"); 
		query.append("	FROM	DUAL" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRevLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*revenue lane의 정보를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT DISTINCT RLANE_CD NAME" ).append("\n"); 
		query.append("          ,RLANE_CD CODE " ).append("\n"); 
		query.append("	  FROM COA_LANE_RGST " ).append("\n"); 
		query.append("	 WHERE TRD_CD = NVL(@[str_trd_cd],TRD_CD) " ).append("\n"); 
		query.append("       AND SUB_TRD_CD = NVL(@[str_sub_trd_cd],SUB_TRD_CD) " ).append("\n"); 
		query.append("       AND NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("	 ORDER BY RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRevLaneList2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*revenue lane의 정보를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT DISTINCT RLANE_CD NAME" ).append("\n"); 
		query.append("          ,RLANE_CD CODE " ).append("\n"); 
		query.append("	  FROM COA_LANE_RGST " ).append("\n"); 
		query.append("     WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("	 ORDER BY RLANE_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*revenue lane의 정보를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT DISTINCT TRD_CD KEY" ).append("\n"); 
		query.append("          ,RLANE_CD NAME" ).append("\n"); 
		query.append("		  ,RLANE_CD CODE " ).append("\n"); 
		query.append("	  FROM COA_LANE_RGST " ).append("\n"); 
		query.append("	 WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append(" 	   AND TRD_CD = NVL(@[trd_cd], TRD_CD) " ).append("\n"); 
		query.append("	 ORDER BY KEY" ).append("\n"); 
		query.append("     		,NAME " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSMUSubTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*SMU Sub Trade 정보를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT DISTINCT  SUB_TRD_CD CODE" ).append("\n"); 
		query.append("          ,SUB_TRD_CD NAME " ).append("\n"); 
		query.append("	  FROM MDM_DTL_REV_LANE                           " ).append("\n"); 
		query.append("	 WHERE SUB_TRD_CD IS NOT NULL                     " ).append("\n"); 
		query.append("	   AND TRD_CD = NVL(@[trd_cd], TRD_CD)                " ).append("\n"); 
		query.append("	   AND SUB_TRD_CD <> 'IP'                         " ).append("\n"); 
		query.append("	 ORDER BY SUB_TRD_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*service lane의 정보를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT DISTINCT TRD_CD KEY" ).append("\n"); 
		query.append("          ,SLAN_CD NAME" ).append("\n"); 
		query.append("          ,SLAN_CD CODE " ).append("\n"); 
		query.append("	  FROM COA_LANE_RGST " ).append("\n"); 
		query.append("	 WHERE TRD_CD = NVL(@[trd_cd], TRD_CD) " ).append("\n"); 
		query.append("  	   AND NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("	 ORDER BY TRD_CD" ).append("\n"); 
		query.append("        	 ,SLAN_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLccList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*LCC의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${code} == '') " ).append("\n"); 
		query.append("   		SELECT DISTINCT LCC_CD NAME" ).append("\n"); 
		query.append("	          ,LCC_CD CODE " ).append("\n"); 
		query.append("    	  FROM COA_LOCATION_V " ).append("\n"); 
		query.append("    	 ORDER BY LCC_CD 			" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    	SELECT DISTINCT RCC_CD KEY" ).append("\n"); 
		query.append("			  ,LCC_CD NAME" ).append("\n"); 
		query.append("			  ,LCC_CD CODE " ).append("\n"); 
		query.append("    	  FROM COA_LOCATION_V " ).append("\n"); 
		query.append("    	 WHERE RCC_CD = @[code] " ).append("\n"); 
		query.append("   	     ORDER BY RCC_CD, LCC_CD  " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchEccList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*ECC의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${code} == '') " ).append("\n"); 
		query.append("		SELECT DISTINCT ECC_CD NAME" ).append("\n"); 
		query.append("			  ,ECC_CD CODE " ).append("\n"); 
		query.append("		FROM COA_LOCATION_V " ).append("\n"); 
		query.append("		ORDER BY ECC_CD " ).append("\n"); 
		query.append("  #else " ).append("\n"); 
		query.append("		SELECT DISTINCT RCC_CD || LCC_CD KEY" ).append("\n"); 
		query.append("			  ,ECC_CD NAME" ).append("\n"); 
		query.append("			  ,ECC_CD CODE " ).append("\n"); 
		query.append("		  FROM COA_LOCATION_V " ).append("\n"); 
		query.append("         WHERE RCC_CD = @[rcc_cd] " ).append("\n"); 
		query.append("		   AND LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("		 ORDER BY RCC_CD" ).append("\n"); 
		query.append("				 ,LCC_CD  " ).append("\n"); 
		query.append("   #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubOFCList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*선택한 office Level에 해당하는 office code목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT DISTINCT DECODE(@[sel_ofc_lvl]" ).append("\n"); 
		query.append("                      	,'1', OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                      	,'2', OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                      	,'3', OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                      	,'4', OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("                      	,'5', OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                      	,'6', OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("                      	,'7', OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("                      	) CODE" ).append("\n"); 
		query.append("               	,DECODE(@[sel_ofc_lvl]" ).append("\n"); 
		query.append("                      	,'1', OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("                      	,'2', OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                      	,'3', OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                      	,'4', OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("                      	,'5', OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                      	,'6', OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("                      	,'7', OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("                      	) NAME" ).append("\n"); 
		query.append("    FROM COA_OFC_LVL" ).append("\n"); 
		query.append("   WHERE 1 = 1" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("			/*COST_MON이 들어온 경우, 2009년 이상 데이터는 월별관리*/" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		  		AND @[cost_yr]||@[cost_mon] BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON /*월별관리*/" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("     			AND DECODE(@[usr_ofc_lvl]" ).append("\n"); 
		query.append("               		,'1', OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("               		,'2', OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("                    ,'3', OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                    ,'4', OFC_N4TH_LVL_CD" ).append("\n"); 
		query.append("                    ,'5', OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                    ,'6', OFC_N6TH_LVL_CD" ).append("\n"); 
		query.append("                    ,'7', OFC_N7TH_LVL_CD" ).append("\n"); 
		query.append("                    ) IN (@[usr_ofc_cd], '', '', '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND DECODE(@[sel_ofc_lvl]" ).append("\n"); 
		query.append("               ,'1', OFC_N1ST_LVL_CD" ).append("\n"); 
		query.append("               ,'2', OFC_N2ND_LVL_TP_CD" ).append("\n"); 
		query.append("               ,'3', OFC_N3RD_LVL_TP_CD" ).append("\n"); 
		query.append("               ,'4', OFC_N4TH_LVL_TP_CD                        " ).append("\n"); 
		query.append("               ,'5', OFC_N5TH_LVL_TP_CD" ).append("\n"); 
		query.append("               ,'6', OFC_N6TH_LVL_TP_CD" ).append("\n"); 
		query.append("               ,'7', OFC_N7TH_LVL_TP_CD" ).append("\n"); 
		query.append("               ,' '" ).append("\n"); 
		query.append("               ) IS NOT NULL" ).append("\n"); 
		query.append("  ORDER BY CODE	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchReportItem')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Report Item Infomation 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT SLCT_ITM_FOM_SEQ CODE" ).append("\n"); 
		query.append("	      ,SLCT_ITM_FOM_DESC NAME" ).append("\n"); 
		query.append("  	  FROM COA_RPT_ITM_INFO_MST" ).append("\n"); 
		query.append(" 	 WHERE CRE_USR_ID = @[code]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkBKGNo')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Booking Number 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append("	  FROM DUAL " ).append("\n"); 
		query.append("	 WHERE EXISTS ( " ).append("\n"); 
		query.append("     	 		  SELECT '1' " ).append("\n"); 
		query.append("     	 			FROM COA_RGST_BKG " ).append("\n"); 
		query.append("      			   WHERE BKG_NO = @[bkgno] " ).append("\n"); 
		query.append("				  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkLocationCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Location Code 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append("	  FROM DUAL " ).append("\n"); 
		query.append("	 WHERE EXISTS ( " ).append("\n"); 
		query.append("      			   SELECT '1' " ).append("\n"); 
		query.append("      			     FROM MDM_LOCATION " ).append("\n"); 
		query.append("      			    WHERE LOC_CD = @[loccd]  " ).append("\n"); 
		query.append("				   ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkVesselCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Vessel Code 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append(" 	  FROM DUAL " ).append("\n"); 
		query.append(" 	 WHERE EXISTS ( " ).append("\n"); 
		query.append("               	   SELECT '1' " ).append("\n"); 
		query.append("                     FROM MDM_VSL_CNTR " ).append("\n"); 
		query.append("                    WHERE VSL_CD = @[vslcd]  " ).append("\n"); 
		query.append("                  )   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkVVDCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*VVD Code 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append("      FROM DUAL " ).append("\n"); 
		query.append("     WHERE EXISTS ( " ).append("\n"); 
		query.append("      			   SELECT '1' " ).append("\n"); 
		query.append("      			     FROM VSK_VSL_SKD " ).append("\n"); 
		query.append("     			    WHERE VSL_CD = @[vslcd] " ).append("\n"); 
		query.append("        		      AND SKD_VOY_NO = @[skdvoyno]" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD = @[skddircd] " ).append("\n"); 
		query.append("    			   ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkOfficeCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Office Code 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append("	  FROM DUAL " ).append("\n"); 
		query.append("	 WHERE EXISTS ( " ).append("\n"); 
		query.append("      			   SELECT '1' " ).append("\n"); 
		query.append("      				 FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("      				WHERE OFC_CD = @[ofccd] " ).append("\n"); 
		query.append("     			   ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkRevLaneCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Revenue Lane Code 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append("	  FROM DUAL " ).append("\n"); 
		query.append("	 WHERE EXISTS ( " ).append("\n"); 
		query.append("      			   SELECT '1' " ).append("\n"); 
		query.append("      				 FROM MDM_REV_LANE " ).append("\n"); 
		query.append("      			    WHERE RLANE_CD = @[rlanecd] " ).append("\n"); 
		query.append("      				  AND NVL(DELT_FLG,'*') = 'N' " ).append("\n"); 
		query.append("     			   ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkNodeCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Port or Node Code 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append("      FROM DUAL " ).append("\n"); 
		query.append("     WHERE EXISTS ( " ).append("\n"); 
		query.append("                   SELECT '1' " ).append("\n"); 
		query.append("                     FROM MDM_YARD " ).append("\n"); 
		query.append("                    WHERE YD_CD = @[tmnlcd] " ).append("\n"); 
		query.append("	               ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'checkSLaneCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Service Lane Code 유무를 확인*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'X' " ).append("\n"); 
		query.append("  	  FROM DUAL " ).append("\n"); 
		query.append(" 	 WHERE EXISTS ( " ).append("\n"); 
		query.append("               	   SELECT '1' " ).append("\n"); 
		query.append("                 	 FROM MDM_VSL_SVC_LANE " ).append("\n"); 
		query.append("                	WHERE DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                  	  AND VSL_SLAN_CD   = @[slancd] " ).append("\n"); 
		query.append("              	   ) " ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOFCLevelList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*office Level List 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT DISTINCT OFC_LVL CODE" ).append("\n"); 
		query.append("		  ,OFC_LVL_DESC NAME " ).append("\n"); 
		query.append("  	  FROM   COA_RPT_AUTH_MGMT " ).append("\n"); 
		query.append(" 	 WHERE OFC_LVL >= @[code] " ).append("\n"); 
		query.append(" 	 ORDER BY OFC_LVL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchDatePeriod')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*검색 조건에 맞는 DatePriod을 가져온다. - 입력파라메터의 경우의 수 1. Year, Month 2. Year, Week 3. Year, Month, Week : Week가 우선권을 가진다. " ).append("\n"); 
		query.append("															 4. Year, FromMonth, ToMonth 5. Year, FromWeek, ToWeek 6. Year, FromMonth, ToMonth, FromWeek, ToWeek*/" ).append("\n"); 
		query.append("	#if(${gubun}=='1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/*searchDatePeriod : YEAR, MONTH, WEEK인경우*/" ).append("\n"); 
		query.append("		SELECT TO_CHAR(TO_DATE(DECODE(FM_CHK,'Y',SLS_FM_DT, @[year]||@[month]||'01'),'YYYYMMDD'),'YYYY-MM-DD') || ' ~ '|| " ).append("\n"); 
		query.append("    	   					   DECODE(TO_CHK,'Y',TO_CHAR(TO_DATE(SLS_TO_DT,'YYYYMMDD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append("			  ,TO_CHAR(LAST_DAY(TO_DATE(SLS_FM_DT,'YYYYMMDD')),'YYYY-MM-DD')) RTN_DATE" ).append("\n"); 
		query.append("		  FROM ( " ).append("\n"); 
		query.append("				SELECT SLS_FM_DT,SLS_TO_DT " ).append("\n"); 
		query.append("    	   			  ,DECODE(SUBSTR(SLS_FM_DT,1,6), @[year]||@[month],'Y','N') FM_CHK " ).append("\n"); 
		query.append("       	   			  ,DECODE(SUBSTR(SLS_TO_DT,1,6), @[year]||@[month],'Y','N') TO_CHK " ).append("\n"); 
		query.append("	  			  FROM  COA_WK_PRD " ).append("\n"); 
		query.append("			     WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("  				   AND COST_WK = @[week] " ).append("\n"); 
		query.append("      	) " ).append("\n"); 
		query.append("	#elseif(${gubun}=='2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/*log.info('searchDatePeriod : YEAR, MONTH인경우')*/" ).append("\n"); 
		query.append("		SELECT TO_CHAR(TO_DATE(@[year]||@[month],'YYYYMM'),'YYYY-MM-DD') || ' ~ ' || " ).append("\n"); 
		query.append("       	   	   TO_CHAR(LAST_DAY(TO_DATE(@[year]||@[month],'YYYYMM')),'YYYY-MM-DD') RTN_DATE" ).append("\n"); 
		query.append("	 	  FROM DUAL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#elseif(${gubun}=='3')			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/*log.info('searchDatePeriod : YEAR, WEEK인경우')*/" ).append("\n"); 
		query.append("		SELECT TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'),'YYYY-MM-DD') || ' ~ '|| " ).append("\n"); 
		query.append("       	       TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'),'YYYY-MM-DD') RTN_DATE " ).append("\n"); 
		query.append("	 	  FROM  COA_WK_PRD " ).append("\n"); 
		query.append("	     WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("  	       AND COST_WK = @[week]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif(${gubun}=='4')	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*log.info('searchDatePeriod : year,from month,to_month,from_week,to_week인경우')*/" ).append("\n"); 
		query.append("		SELECT TO_CHAR(TO_DATE(DECODE(SIGN(TO_NUMBER(MN_FM_DT) - TO_NUMBER(WK_TO_DT)),  1, '' " ).append("\n"); 
		query.append("                              ,DECODE(SIGN(TO_NUMBER(MN_TO_DT) - TO_NUMBER(WK_FM_DT)),  -1, '' " ).append("\n"); 
		query.append("                              ,DECODE(SIGN(TO_NUMBER(MN_FM_DT)-TO_NUMBER(WK_FM_DT)), 1, MN_FM_DT, WK_FM_DT) )), 'YYYYMMDD'),'YYYY-MM-DD')  || '~' || " ).append("\n"); 
		query.append("      		   TO_CHAR(TO_DATE(DECODE(SIGN(TO_NUMBER(MN_TO_DT) - TO_NUMBER(WK_FM_DT)), -1, '', " ).append("\n"); 
		query.append("                               DECODE(SIGN(TO_NUMBER(MN_FM_DT) - TO_NUMBER(WK_TO_DT)),  1, '', " ).append("\n"); 
		query.append("                               DECODE(SIGN(TO_NUMBER(MN_TO_DT)-TO_NUMBER(WK_TO_DT)), -1, MN_TO_DT, WK_TO_DT) )), 'YYYYMMDD'),'YYYY-MM-DD') RTN_DATE  " ).append("\n"); 
		query.append("		 FROM ( " ).append("\n"); 
		query.append("     		   SELECT MAX(WK_FM_DT) WK_FM_DT" ).append("\n"); 
		query.append("					 ,MAX(WK_TO_DT) WK_TO_DT" ).append("\n"); 
		query.append("					 ,MAX(MN_FM_DT) MN_FM_DT" ).append("\n"); 
		query.append("					 ,MAX(MN_TO_DT) MN_TO_DT " ).append("\n"); 
		query.append("     			 FROM ( " ).append("\n"); 
		query.append("          			   SELECT MIN(SLS_FM_DT) WK_FM_DT" ).append("\n"); 
		query.append("							 ,MAX(SLS_TO_DT) WK_TO_DT" ).append("\n"); 
		query.append("							 ,'' MN_FM_DT" ).append("\n"); 
		query.append("							 ,'' MN_TO_DT " ).append("\n"); 
		query.append("          FROM  COA_WK_PRD " ).append("\n"); 
		query.append("          WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("            AND COST_WK BETWEEN @[frmweek] AND @[toweek] " ).append("\n"); 
		query.append("          UNION ALL " ).append("\n"); 
		query.append("          SELECT '','',TO_CHAR(TO_DATE(@[year]||@[frmmonth],'YYYYMM'),'YYYYMMDD'), " ).append("\n"); 
		query.append("                  TO_CHAR(LAST_DAY(TO_DATE(@[year]||@[tomonth],'YYYYMM')),'YYYYMMDD') " ).append("\n"); 
		query.append("           FROM DUAL " ).append("\n"); 
		query.append("      ) " ).append("\n"); 
		query.append(" ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${gubun}=='5')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*log.debug('searchDatePeriod : year,from month,to month인경우')*/" ).append("\n"); 
		query.append("	SELECT TO_CHAR(TO_DATE(@[year]||@[frmmonth],'YYYYMM'),'YYYY-MM-DD') || ' ~ ' ||        " ).append("\n"); 
		query.append("       	   TO_CHAR(LAST_DAY(TO_DATE(@[year]||@[tomonth],'YYYYMM')),'YYYY-MM-DD') RTN_DATE " ).append("\n"); 
		query.append("	  FROM DUAL                                                           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${gubun}=='6')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*log.debug('searchDatePeriod : year,from week,to week인경우')*/" ).append("\n"); 
		query.append("	SELECT MIN(TO_CHAR(TO_DATE(SLS_FM_DT, 'YYYYMMDD'),'YYYY-MM-DD')) ||' ~ ' || " ).append("\n"); 
		query.append("       	   MAX(TO_CHAR(TO_DATE(SLS_TO_DT, 'YYYYMMDD'),'YYYY-MM-DD')) RTN_DATE " ).append("\n"); 
		query.append("	  FROM COA_WK_PRD " ).append("\n"); 
		query.append("	 WHERE COST_YR = @[year] " ).append("\n"); 
		query.append("  	   AND COST_WK BETWEEN @[frmweek] AND @[toweek] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchFirstEtd')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*VVD에 해당하는 etd date를 리턴한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT TO_CHAR(MIN(VPS_ETD_DT),'YYYYMMDD') ETD_DT " ).append("\n"); 
		query.append("	  FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("	 WHERE VSL_CD      = @[vsl_cd] " ).append("\n"); 
		query.append("  	   AND SKD_VOY_NO  = @[skd_voy_no] " ).append("\n"); 
		query.append("  	   AND SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("  	   /*AND NVL(CNG_STS_CD,'*') <> 'S'*/ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchKeyAcctInDvlList')	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Group ID = code인 Key Account List*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT CUST_CNT_CD||CUST_SEQ CODE " ).append("\n"); 
		query.append("       	  ,CUST_LGL_ENG_NM NAME " ).append("\n"); 
		query.append("  	  FROM MDM_CUSTOMER " ).append("\n"); 
		query.append(" 	 WHERE DELT_FLG     = 'N'  " ).append("\n"); 
		query.append("   	   AND KEY_ACCT_FLG = 'Y' " ).append("\n"); 
		query.append("   	   AND (NMD_CUST_FLG IS NULL OR NMD_CUST_FLG = 'N') " ).append("\n"); 
		query.append("   	   	#if(${keyacctgrp} != '' && ${keyacctgrp} != 'All')" ).append("\n"); 
		query.append("   	    	AND CUST_GRP_ID = @[keyacctgrp]" ).append("\n"); 
		query.append("   	    #end " ).append("\n"); 
		query.append(" 	 ORDER BY CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMltTrdInDvlList')	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Group ID = code인 M/A List*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT CUST_CNT_CD||CUST_SEQ CODE " ).append("\n"); 
		query.append("       	  ,CUST_LGL_ENG_NM NAME " ).append("\n"); 
		query.append("  	  FROM MDM_CUSTOMER " ).append("\n"); 
		query.append(" 	 WHERE DELT_FLG     = 'N'  " ).append("\n"); 
		query.append("   	   AND mlt_trd_acct_flg = 'Y' " ).append("\n"); 
		query.append("   	   AND (NMD_CUST_FLG IS NULL OR NMD_CUST_FLG = 'N') " ).append("\n"); 
		query.append("   	   	#if(${mlttrdgrp} != '' && ${mlttrdgrp} != 'All')" ).append("\n"); 
		query.append("   	    	AND CUST_GRP_ID = @[mlttrdgrp]" ).append("\n"); 
		query.append("   	    #end " ).append("\n"); 
		query.append(" 	 ORDER BY CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchChgOffice')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT OFC_CD" ).append("\n"); 
		query.append("		  ,PRNT_OFC_CD                               " ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION     " ).append("\n"); 
		query.append("     WHERE 1=1 " ).append("\n"); 
		query.append("   	   AND OFC_KND_CD = '2'    " ).append("\n"); 
		query.append("   	   AND OFC_TP_CD  <> 'AQ'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOFCLevel')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*office code에 해당하는 Level를 리턴한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT COA_GET_OFC_LEVEL_FNC(@[ofc_cd]) OFC_LEVEL" ).append("\n"); 
		query.append("  	  FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPrevWkPrd')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*전주를 구한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT  COST_YR" ).append("\n"); 
		query.append("		   ,COST_WK " ).append("\n"); 
		query.append("  	  FROM  COA_WK_PRD " ).append("\n"); 
		query.append(" 	 WHERE  1=1 " ).append("\n"); 
		query.append("   	   AND  (TO_CHAR(SYSDATE-7, 'YYYYMMDD') " ).append("\n"); 
		query.append("   BETWEEN  SLS_FM_DT AND SLS_TO_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPreWeek')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*현재주보다 작은 주를 반환한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT MAX(COST_YR || COST_WK)" ).append("\n"); 
		query.append("  	  FROM COA_WK_PRD " ).append("\n"); 
		query.append(" 	 WHERE COST_YR || COST_WK < @[year]||@[week]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'getUSDAmt')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*환율 변환*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT ROUND(@[lcl_amt]/USD_LOCL_XCH_RT, 3) RT     " ).append("\n"); 
		query.append("      FROM GL_MON_XCH_RT 			" ).append("\n"); 
		query.append("     WHERE ACCT_XCH_RT_YRMON = @[cost_yrmon] 		" ).append("\n"); 
		query.append("       AND ACCT_XCH_RT_LVL   = '1' 		" ).append("\n"); 
		query.append("       AND CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Trade콤보의 목록을 가져온다*/" ).append("\n"); 
		query.append("/*2009.09.07 TRADE 코드중 COM 이 나오지 않도록 쿼리 수정*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT TRD_CD CODE" ).append("\n"); 
		query.append("		  ,TRD_CD NAME " ).append("\n"); 
		query.append("	  FROM MDM_TRADE " ).append("\n"); 
		query.append("	 WHERE VSL_TP_CD = 'C' " ).append("\n"); 
		query.append("	   AND DELT_FLG  = 'N' " ).append("\n"); 
		query.append("	   AND TRD_CD    <> 'COM' " ).append("\n"); 
		query.append("	 ORDER BY TRD_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Sub Trade 정보를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT  TRD_CD KEY" ).append("\n"); 
		query.append("			  ,SUB_TRD_CD CODE" ).append("\n"); 
		query.append("			  ,SUB_TRD_CD NAME " ).append("\n"); 
		query.append("		  FROM MDM_DTL_REV_LANE " ).append("\n"); 
		query.append("		 WHERE SUB_TRD_CD IS NOT NULL " ).append("\n"); 
		query.append("		   AND TRD_CD     = NVL(@[trd_cd], TRD_CD) " ).append("\n"); 
		query.append("		 ORDER BY TRD_CD" ).append("\n"); 
		query.append("				 ,SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSccList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*SCC의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT ECC_CD KEY, SCC_CD NAME, SCC_CD CODE " ).append("\n"); 
		query.append("		  FROM COA_LOCATION_V " ).append("\n"); 
		query.append("		 WHERE ECC_CD = @[code] " ).append("\n"); 
		query.append("		 ORDER BY ECC_CD, SCC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVslCapaList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*VESSEL CAPA 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT vsl_clss_capa code" ).append("\n"); 
		query.append("			  ,vsl_clss_capa name" ).append("\n"); 
		query.append("		  FROM COA_VSL_RGST " ).append("\n"); 
		query.append("		 WHERE vsl_tp_cd     = 'C' " ).append("\n"); 
		query.append("		   AND vsl_clss_capa > 0 " ).append("\n"); 
		query.append("		 ORDER BY vsl_clss_capa " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCurrencyList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Currency 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT curr_cd code" ).append("\n"); 
		query.append("			  ,curr_cd name " ).append("\n"); 
		query.append("		  FROM MDM_CURRENCY " ).append("\n"); 
		query.append("		 WHERE NVL(delt_flg,'N') = 'N' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRepCMDTList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Commodity List 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT REP_CMDT_CD CODE" ).append("\n"); 
		query.append("			  ,REP_CMDT_NM NAME" ).append("\n"); 
		query.append("		  FROM MDM_REP_CMDT                       " ).append("\n"); 
		query.append("		 WHERE NVL(DELT_FLG,'N') = 'N'      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRHQList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Regional Headquarter: RHQ 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT ofc_cd code" ).append("\n"); 
		query.append("			  ,ofc_cd name " ).append("\n"); 
		query.append("		  FROM mdm_organization " ).append("\n"); 
		query.append("		 WHERE ofc_knd_cd = '2' " ).append("\n"); 
		query.append("		 ORDER BY name   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLocList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Location Code 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${param0} == 'ECC')	" ).append("\n"); 
		query.append("			 SELECT DISTINCT ECC_CD KEY" ).append("\n"); 
		query.append("			       ,LOC_CD NAME" ).append("\n"); 
		query.append("				   ,LOC_CD CODE " ).append("\n"); 
		query.append("			      FROM COA_LOCATION_V " ).append("\n"); 
		query.append("			      WHERE ECC_CD = @[param1]" ).append("\n"); 
		query.append("			      ORDER BY ECC_CD" ).append("\n"); 
		query.append("						  ,LOC_CD " ).append("\n"); 
		query.append("		#else    /*SCC*/" ).append("\n"); 
		query.append("			  SELECT DISTINCT SCC_CD KEY" ).append("\n"); 
		query.append("					,LOC_CD NAME" ).append("\n"); 
		query.append("					,LOC_CD CODE " ).append("\n"); 
		query.append("			      FROM COA_LOCATION_V " ).append("\n"); 
		query.append("			      WHERE SCC_CD = @[param1]" ).append("\n"); 
		query.append("			      ORDER BY SCC_CD, LOC_CD " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchEQRepoTpSzList')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*컨테이너 Reposition Flag가 Y인 Type Size 목록을 조회한다*/ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT CNTR_TPSZ_CD NAME" ).append("\n"); 
		query.append("			  ,CNTR_TPSZ_CD CODE " ).append("\n"); 
		query.append("		  FROM COA_SPCL_REPO_CNTR_RGST " ).append("\n"); 
		query.append("		 WHERE NVL(REPO_FLG,'N') = 'Y' " ).append("\n"); 
		query.append("		   AND NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("         ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRAMainGroupList') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*RA Main Group 항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT INTG_CD_VAL_CTNT CODE " ).append("\n"); 
		query.append("			  ,INTG_CD_VAL_DP_DESC NAME  " ).append("\n"); 
		query.append("		  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("		 WHERE INTG_CD_ID = 'CD00895'  " ).append("\n"); 
		query.append("		 ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRASubGroupList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*RA Sub Group 항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT SUBSTR(INTG_CD_VAL_CTNT, 1,2) KEY" ).append("\n"); 
		query.append("			  ,INTG_CD_VAL_CTNT CODE " ).append("\n"); 
		query.append("			  ,INTG_CD_VAL_DP_DESC NAME " ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD00894'" ).append("\n"); 
		query.append("			#if (${code} != '')" ).append("\n"); 
		query.append("		   		AND SUBSTR(INTG_CD_VAL_CTNT, 1,2) = @[code]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	    ORDER BY KEY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRccList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Rcc 의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT RCC_CD NAME" ).append("\n"); 
		query.append("			  ,RCC_CD CODE " ).append("\n"); 
		query.append("		FROM COA_LOCATION_V " ).append("\n"); 
		query.append("		ORDER BY RCC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchStndCostList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*COA_STND_ACCT에서 비용항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT STND_COST_CD AS CODE " ).append("\n"); 
		query.append("		      ,STND_COST_NM AS NAME " ).append("\n"); 
		query.append("		FROM   COA_STND_ACCT " ).append("\n"); 
		query.append("		WHERE MGRP_COST_CD IN ('OV','OF','GE') " ).append("\n"); 
		query.append("		AND   NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("		ORDER BY  ACCT_DP_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOwnVesselList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Vessel콤보의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT VSL_CD CODE" ).append("\n"); 
		query.append("			  ,VSL_CD NAME " ).append("\n"); 
		query.append("		FROM COA_VSL_RGST " ).append("\n"); 
		query.append("		WHERE VSL_TP_CD   = 'C' " ).append("\n"); 
		query.append("		  AND DELT_FLG    = 'N' " ).append("\n"); 
		query.append("		  AND VSL_OSHP_CD = 'OWN' " ).append("\n"); 
		query.append("		ORDER BY VSL_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchChtVesselList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Vessel콤보의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT VSL_CD CODE" ).append("\n"); 
		query.append("			  ,VSL_CD NAME " ).append("\n"); 
		query.append("		FROM COA_VSL_RGST " ).append("\n"); 
		query.append("		WHERE VSL_TP_CD   = 'C' " ).append("\n"); 
		query.append("		  AND DELT_FLG    = 'N' " ).append("\n"); 
		query.append("		  AND VSL_OSHP_CD = 'CHT' " ).append("\n"); 
		query.append("		  AND LST_FLG     = 'Y' " ).append("\n"); 
		query.append("		ORDER BY VSL_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchActGrpList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*PRD_COST_ACT_GRP에서 활동그룹항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT COST_ACT_GRP_CD   CODE" ).append("\n"); 
		query.append("		      ,COST_ACT_GRP_NM   NAME" ).append("\n"); 
		query.append("		FROM PRD_COST_ACT_GRP    " ).append("\n"); 
		query.append("		ORDER BY COST_ACT_GRP_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCntList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*mdm_county에서 국가코드항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT CNT_CD  CODE" ).append("\n"); 
		query.append("		      ,CNT_NM  NAME" ).append("\n"); 
		query.append("		FROM MDM_COUNTRY " ).append("\n"); 
		query.append("		ORDER BY CNT_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCostSourceCodeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Cost Srouce Code를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${code} == '')" ).append("\n"); 
		query.append("			 SELECT COA_COST_SRC_CD KEY" ).append("\n"); 
		query.append("			       ,COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("				   ,COA_COST_SRC_CD_NM NAME  " ).append("\n"); 
		query.append("			   FROM COA_COST_SRC_ACCT " ).append("\n"); 
		query.append("			  WHERE NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("			  ORDER BY STND_COST_CD" ).append("\n"); 
		query.append("				      ,COA_COST_SRC_CD " ).append("\n"); 
		query.append("	  	#elseif (${code} == 'COA_NOD_AVG_STND_COST')" ).append("\n"); 
		query.append("	  		 SELECT A.COA_COST_SRC_CD KEY" ).append("\n"); 
		query.append("			       ,A.COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("				   ,A.COA_COST_SRC_CD_NM NAME  " ).append("\n"); 
		query.append("			   FROM COA_COST_SRC_ACCT A,COA_STND_ACCT B" ).append("\n"); 
		query.append("			  WHERE NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("			    AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("			    AND B.SGRP_COST_CD = 'CVFS'" ).append("\n"); 
		query.append("			  ORDER BY A.STND_COST_CD" ).append("\n"); 
		query.append("				      ,A.COA_COST_SRC_CD" ).append("\n"); 
		query.append("	  	#elseif (${code} == 'COA_LNK_AVG_STND_COST')" ).append("\n"); 
		query.append("			 SELECT A.COA_COST_SRC_CD KEY" ).append("\n"); 
		query.append("			       ,A.COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("				   ,A.COA_COST_SRC_CD_NM NAME  " ).append("\n"); 
		query.append("			   FROM COA_COST_SRC_ACCT A,COA_STND_ACCT B" ).append("\n"); 
		query.append("			  WHERE NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("			    AND A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("			    AND B.SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("			  ORDER BY A.STND_COST_CD" ).append("\n"); 
		query.append("				      ,A.COA_COST_SRC_CD	  	" ).append("\n"); 
		query.append("	  	#else" ).append("\n"); 
		query.append("			 SELECT COA_COST_SRC_CD KEY " ).append("\n"); 
		query.append("				   ,COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("				   ,COA_COST_SRC_CD_NM NAME " ).append("\n"); 
		query.append("			  FROM COA_COST_SRC_ACCT" ).append("\n"); 
		query.append("			 WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("			   AND STND_COST_CD = @[code] " ).append("\n"); 
		query.append("			 ORDER BY STND_COST_CD" ).append("\n"); 
		query.append("			         ,COA_COST_SRC_CD " ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCoaCodeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Stndard Cost code를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${code0} == '')" ).append("\n"); 
		query.append("			SELECT SGRP_COST_CD KEY" ).append("\n"); 
		query.append("			      ,STND_COST_CD CODE " ).append("\n"); 
		query.append("			      ,STND_COST_NM NAME " ).append("\n"); 
		query.append("			  FROM COA_STND_ACCT " ).append("\n"); 
		query.append("			 WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("		     ORDER BY MGRP_COST_CD, SGRP_COST_CD, STND_COST_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			SELECT SGRP_COST_CD KEY " ).append("\n"); 
		query.append("			  	  ,STND_COST_CD CODE  " ).append("\n"); 
		query.append("			      ,STND_COST_NM NAME " ).append("\n"); 
		query.append("	     	  FROM COA_STND_ACCT  " ).append("\n"); 
		query.append("			 WHERE NVL(DELT_FLG,'N') = 'N' AND SGRP_COST_CD IN (@[code0],@[code1])	--SJH.20141222.MOD : = -> IN" ).append("\n"); 
		query.append("			 ORDER BY SGRP_COST_CD, STND_COST_CD 									--SJH.20141222.MOD : SGRP_COST_CD 추가" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLogisticsKpiList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*공통코드에서 Lobistics KPI 항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${code} == 'TM')" ).append("\n"); 
		query.append("			SELECT INTG_CD_VAL_CTNT CODE ,INTG_CD_VAL_DP_DESC NAME  " ).append("\n"); 
		query.append("			  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("			 WHERE INTG_CD_ID = 'CD00950' " ).append("\n"); 
		query.append("			   AND INTG_CD_VAL_CTNT IN (SELECT DISTINCT LGS_KPI_CD FROM PRD_COST_ACT_GRP WHERE LGS_KPI_COST_GRP_CD = @[code])" ).append("\n"); 
		query.append("			 ORDER BY INTG_CD_VAL_DP_SEQ					" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#elseif(${code} == 'TR')" ).append("\n"); 
		query.append("			SELECT INTG_CD_VAL_CTNT CODE ,INTG_CD_VAL_DP_DESC NAME  " ).append("\n"); 
		query.append("			  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("			 WHERE INTG_CD_ID = 'CD00950'  " ).append("\n"); 
		query.append("			   AND INTG_CD_VAL_CTNT IN (SELECT DISTINCT NVL(LGS_KPI_CD, 'SHTL')FROM PRD_COST_ACT_GRP WHERE LGS_KPI_COST_GRP_CD = @[code])" ).append("\n"); 
		query.append("			 ORDER BY INTG_CD_VAL_DP_SEQ			  		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			SELECT INTG_CD_VAL_CTNT CODE ,INTG_CD_VAL_DP_DESC NAME " ).append("\n"); 
		query.append("			  FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("			 WHERE INTG_CD_ID = 'CD00950'  " ).append("\n"); 
		query.append("			ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCostTableCntrTpszList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*컨테이너 Reposition Flag가 Y인 Type Size 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DECODE(CODE, 'RD2', 'R2', 'RD4', 'R4', CODE) AS CODE  " ).append("\n"); 
		query.append("		      ,NAME  " ).append("\n"); 
		query.append("		  FROM (  " ).append("\n"); 
		query.append("		        SELECT DISTINCT SPCL_CNTR_TPSZ_CD AS NAME  " ).append("\n"); 
		query.append("		              ,SPCL_CNTR_TPSZ_CD AS CODE   " ).append("\n"); 
		query.append("		          FROM COA_SPCL_REPO_CNTR_RGST   " ).append("\n"); 
		query.append("		         WHERE NVL(DELT_FLG,'N') = 'N'  " ).append("\n"); 
		query.append("		           AND CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("		       )  " ).append("\n"); 
		query.append("		 ORDER BY NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchKeyAccountList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*key account 항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT CUST_CNT_CD||CUST_SEQ CODE" ).append("\n"); 
		query.append("			  ,CUST_LGL_ENG_NM NAME " ).append("\n"); 
		query.append("		 FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("		WHERE DELT_FLG     = 'N' " ).append("\n"); 
		query.append("		  AND KEY_ACCT_FLG = 'Y' " ).append("\n"); 
		query.append("		  AND KEY_ACCT_FLG = 'Y' " ).append("\n"); 
		query.append("		  AND (NMD_CUST_FLG IS NULL OR NMD_CUST_FLG = 'N') " ).append("\n"); 
		query.append("	    ORDER BY CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLogisticsRhqCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*logistics 에서 사용하는 RHQ 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT OFC_N2ND_LVL_CD CODE" ).append("\n"); 
		query.append("		               ,OFC_N2ND_LVL_CD NAME" ).append("\n"); 
		query.append("		  FROM  COA_OFC_LVL" ).append("\n"); 
		query.append("		 WHERE OFC_N2ND_LVL_TP_CD IS NOT NULL		    " ).append("\n"); 
		query.append("		   AND OFC_LVL <> '9'" ).append("\n"); 
		query.append("		   AND OFC_N1ST_LVL_CD = COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()		 " ).append("\n"); 
		query.append("		 ORDER BY OFC_N2ND_LVL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOriginalCntrTpszList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*컨테이너 Type Size 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT CODE" ).append("\n"); 
		query.append("			  ,NAME " ).append("\n"); 
		query.append("		  FROM(" ).append("\n"); 
		query.append("		       SELECT DISTINCT CNTR_TPSZ_CD NAME" ).append("\n"); 
		query.append("		                      ,CNTR_TPSZ_CD CODE" ).append("\n"); 
		query.append("		         FROM COA_SPCL_REPO_CNTR_RGST " ).append("\n"); 
		query.append("		        WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("		     )" ).append("\n"); 
		query.append("		ORDER BY CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOtrCommLocList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Agency Other Commission이 사용하는 Location Code List를 반환*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT COMM_LOC_CD AS CODE " ).append("\n"); 
		query.append("		      ,COMM_LOC_CD AS NAME " ).append("\n"); 
		query.append("		  FROM COA_OTR_COMM " ).append("\n"); 
		query.append("		 ORDER BY COMM_LOC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPodEccList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*EMU Simulated Cost 계산시 사용 되는 POD ECC의 목록을 가져온다. (Port ECC만)*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT A2.ECC_CD NAME" ).append("\n"); 
		query.append("			  ,A2.ECC_CD CODE  " ).append("\n"); 
		query.append("		  FROM MDM_LOCATION A1 " ).append("\n"); 
		query.append("		      ,MDM_EQ_ORZ_CHT A2 " ).append("\n"); 
		query.append("		 WHERE A1.SCC_CD = A2.SCC_CD" ).append("\n"); 
		query.append("		   AND A2.DELT_FLG ='N'" ).append("\n"); 
		query.append("		   AND A1.PORT_INLND_FLG = 'Y'" ).append("\n"); 
		query.append("		ORDER BY A2.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMNGRPCostList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*COA Main Group 항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT STND_COST_TP_CD KEY" ).append("\n"); 
		query.append("			  ,MGRP_COST_CD CODE" ).append("\n"); 
		query.append("			  ,MGRP_COST_CD_DESC NAME " ).append("\n"); 
		query.append("		  FROM COA_MN_GRP_COST " ).append("\n"); 
		query.append("			#if(${code} != '')" ).append("\n"); 
		query.append("			WHERE STND_COST_TP_CD = @[code] " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		ORDER BY KEY " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVesselClassList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Port Class 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT VSL_CLSS_CAPA CODE" ).append("\n"); 
		query.append("			  ,VSL_CLSS_CAPA NAME " ).append("\n"); 
		query.append("		  FROM COA_VSL_RGST " ).append("\n"); 
		query.append("		 WHERE VSL_TP_CD     = 'C' " ).append("\n"); 
		query.append("		   AND VSL_CLSS_CAPA > 0 " ).append("\n"); 
		query.append("		 ORDER BY VSL_CLSS_CAPA " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLoc2EccList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*LOC코드의 ECC를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${code} == '')" ).append("\n"); 
		query.append("			SELECT DISTINCT ecc_cd name" ).append("\n"); 
		query.append("				  ,ecc_cd code " ).append("\n"); 
		query.append("			FROM coa_location_v " ).append("\n"); 
		query.append("			ORDER BY ecc_cd " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			SELECT DISTINCT ecc_cd name" ).append("\n"); 
		query.append("				  ,ecc_cd code " ).append("\n"); 
		query.append("			FROM coa_location_v " ).append("\n"); 
		query.append("			WHERE loc_cd = @[code] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLogisticsOfficeCode')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*logistics 에서 사용하는 Office 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${code} == '')" ).append("\n"); 
		query.append("			 SELECT DISTINCT OFC_CD AS CODE" ).append("\n"); 
		query.append("				   ,OFC_CD AS NAME" ).append("\n"); 
		query.append("			 FROM (SELECT DISTINCT OFC_N5TH_LVL_CD AS OFC_CD" ).append("\n"); 
		query.append("			         FROM COA_OFC_LVL" ).append("\n"); 
		query.append("			        WHERE OFC_N2ND_LVL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("			          AND OFC_N2ND_LVL_CD <> COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC() " ).append("\n"); 
		query.append("			          AND OFC_N1ST_LVL_CD = COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC()" ).append("\n"); 
		query.append("			          AND OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("			       ) " ).append("\n"); 
		query.append("			ORDER BY OFC_CD" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("			SELECT DISTINCT OFC_CD CODE" ).append("\n"); 
		query.append("				  ,OFC_CD NAME" ).append("\n"); 
		query.append("			 FROM (SELECT DISTINCT OFC_N5TH_LVL_CD AS OFC_CD" ).append("\n"); 
		query.append("			         FROM COA_OFC_LVL" ).append("\n"); 
		query.append("			        WHERE OFC_N2ND_LVL_CD = @[code] " ).append("\n"); 
		query.append("                      AND OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("			       )" ).append("\n"); 
		query.append("			ORDER BY OFC_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVSLSubTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*COA_VSL_SUB_TRADE 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT SUB_TRD_CD CODE " ).append("\n"); 
		query.append("		      ,SUB_TRD_NM NAME" ).append("\n"); 
		query.append("		  FROM MDM_SUB_TRD " ).append("\n"); 
		query.append("		 WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("		ORDER BY SUB_TRD_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSVCLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*S.Lane의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT SLAN_CD CODE " ).append("\n"); 
		query.append("		               ,SLAN_CD NAME " ).append("\n"); 
		query.append("		  FROM COA_LANE_RGST " ).append("\n"); 
		query.append("		 WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("		 ORDER BY SLAN_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchTpSzList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*컨테이너 Type Size 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT SPCL_CNTR_TPSZ_CD AS NAME " ).append("\n"); 
		query.append("		      ,SPCL_CNTR_TPSZ_CD AS CODE " ).append("\n"); 
		query.append("		  FROM COA_SPCL_REPO_CNTR_RGST " ).append("\n"); 
		query.append("		 WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("		   AND CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("		 ORDER BY SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRPTAuthList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Report Authority 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT B.CODE " ).append("\n"); 
		query.append("	      ,B.NAME " ).append("\n"); 
		query.append("	      ,DECODE(@[ofclvl0], 'CD00939',DECODE(A.PFIT_VW_DFLT_CD, 'Y', 'SELECTED') " ).append("\n"); 
		query.append("	                      ,'CD00940',DECODE(A.OFC_VW_DFLT_CD,  'Y', 'SELECTED') " ).append("\n"); 
		query.append("	                      ,'CD00941',DECODE(A.PFIT_LVL_DFLT_CD,'Y', 'SELECTED')) SELOPT " ).append("\n"); 
		query.append("	FROM   COA_RPT_AUTH_MGMT A, " ).append("\n"); 
		query.append("	       ( " ).append("\n"); 
		query.append("	        SELECT INTG_CD_VAL_CTNT CODE" ).append("\n"); 
		query.append("				  ,INTG_CD_VAL_DP_DESC NAME " ).append("\n"); 
		query.append("	        FROM   COM_INTG_CD_DTL " ).append("\n"); 
		query.append("	        WHERE  INTG_CD_ID = @[ofclvl0] " ).append("\n"); 
		query.append("	       ) B " ).append("\n"); 
		query.append("	WHERE  B.CODE = DECODE(@[ofclvl0], 'CD00939',A.PFIT_VW_CD, " ).append("\n"); 
		query.append("	                                'CD00940',A.OFC_VW_CD, " ).append("\n"); 
		query.append("	                                'CD00941',A.PFIT_LVL_CD) " ).append("\n"); 
		query.append("	  AND  'Y'    = DECODE(@[ofclvl0], 'CD00939',A.PFIT_VW_SLCT_FLG, " ).append("\n"); 
		query.append("	                                'CD00940',A.OFC_VW_SLCT_FLG, " ).append("\n"); 
		query.append("	                                'CD00941',A.PFIT_LVL_SLCT_FLG) " ).append("\n"); 
		query.append("	  AND  A.OFC_LVL          = @[ofclvl1] " ).append("\n"); 
		query.append("    ORDER BY SELOPT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubGRPCostList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*COA Sub Group 항목을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT MGRP_COST_CD KEY" ).append("\n"); 
		query.append("			  ,SGRP_COST_CD CODE" ).append("\n"); 
		query.append("			  ,SGRP_COST_CD_DESC NAME" ).append("\n"); 
		query.append("		  FROM COA_SUB_GRP_COST " ).append("\n"); 
		query.append("		 WHERE MGRP_COST_CD IS NOT NULL " ).append("\n"); 
		query.append("		 #if(${code} != '')" ).append("\n"); 
		query.append("	       AND MGRP_COST_CD = @[code] " ).append("\n"); 
		query.append("	     #end" ).append("\n"); 
		query.append("	     ORDER BY KEY " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCommonCodeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*공통코드에서 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT INTG_CD_VAL_CTNT    CODE " ).append("\n"); 
		query.append("		      ,INTG_CD_VAL_DP_DESC NAME " ).append("\n"); 
		query.append("		FROM   COM_INTG_CD_DTL " ).append("\n"); 
		query.append("		WHERE  INTG_CD_ID = @[code] " ).append("\n"); 
		query.append("		  AND  (TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN APLY_ST_DT AND APLY_END_DT) " ).append("\n"); 
		query.append("		ORDER BY INTG_CD_VAL_DP_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCostSourceCodeStndCodeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Cost Srouce Code/Stnd Code를 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	#if(${code} == '')" ).append("\n"); 
		query.append("		  SELECT COA_COST_SRC_CD KEY" ).append("\n"); 
		query.append("		        ,COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("		        ,STND_COST_CD NAME " ).append("\n"); 
		query.append("		    FROM COA_COST_SRC_ACCT " ).append("\n"); 
		query.append("		   WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("		   ORDER BY COA_COST_SRC_CD, STND_COST_CD " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		  SELECT COA_COST_SRC_CD KEY" ).append("\n"); 
		query.append("			    ,COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("			    ,STND_COST_CD NAME " ).append("\n"); 
		query.append("			FROM COA_COST_SRC_ACCT " ).append("\n"); 
		query.append("		   WHERE NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("			 AND COA_COST_SRC_CD = @[code] " ).append("\n"); 
		query.append("		   ORDER BY COA_COST_SRC_CD, STND_COST_CD " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCustGrpIdcList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Agency Other Commission이 사용하는 Location Code List를 반환*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT A1.CUST_GRP_ID CODE" ).append("\n"); 
		query.append("			      ,A1.CUST_GRP_NM NAME" ).append("\n"); 
		query.append("			  FROM MDM_CUST_PERF_GRP A1" ).append("\n"); 
		query.append("				  ,MDM_CUSTOMER A2" ).append("\n"); 
		query.append("			 WHERE 1 = 1" ).append("\n"); 
		query.append("			   AND A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   AND A2.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("			   AND A2.KEY_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("			   AND (A2.NMD_CUST_FLG IS NULL OR A2.NMD_CUST_FLG = 'N')" ).append("\n"); 
		query.append("			   AND A1.CUST_GRP_ID = A2.CUST_GRP_ID" ).append("\n"); 
		query.append("			 GROUP BY A1.CUST_GRP_ID, A1.CUST_GRP_NM" ).append("\n"); 
		query.append("			 ORDER BY A1.CUST_GRP_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMltTrdGrpIdcList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Agency Other Commission이 사용하는 Location Code M/A List를 반환*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT A1.CUST_GRP_ID CODE" ).append("\n"); 
		query.append("			      ,A1.CUST_GRP_NM NAME" ).append("\n"); 
		query.append("			  FROM MDM_CUST_PERF_GRP A1" ).append("\n"); 
		query.append("				  ,MDM_CUSTOMER A2" ).append("\n"); 
		query.append("			 WHERE 1 = 1" ).append("\n"); 
		query.append("			   AND A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			   AND A2.CNTR_DIV_FLG = 'Y'" ).append("\n"); 
		query.append("			   AND A2.mlt_trd_acct_flg = 'Y'" ).append("\n"); 
		query.append("			   AND (A2.NMD_CUST_FLG IS NULL OR A2.NMD_CUST_FLG = 'N')" ).append("\n"); 
		query.append("			   AND A1.CUST_GRP_ID = A2.CUST_GRP_ID" ).append("\n"); 
		query.append("			 GROUP BY A1.CUST_GRP_ID, A1.CUST_GRP_NM" ).append("\n"); 
		query.append("			 ORDER BY A1.CUST_GRP_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLocationToOffice')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Location Code를 이용해서 Office Code를 반환한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			SELECT COA_LOC_OFF_CD_FNC(@[loc_cd]) OFC_CD " ).append("\n"); 
		query.append("			  FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOFCHQList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*지역본부 단위의 Office Code 목록을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT OFC_CD NAME, OFC_CD CODE  " ).append("\n"); 
		query.append("		  FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("		 WHERE PRNT_OFC_CD = COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC() " ).append("\n"); 
		query.append("		   AND OFC_KND_CD  = '2'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSIMCostItem') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*화물변동비 항목을 가져온다*/" ).append("\n"); 
		query.append("		SELECT DECODE(SGRP_COST_CD,'MIRE','DEMT',SGRP_COST_CD) AS CODE " ).append("\n"); 
		query.append("		     ,DECODE(SGRP_COST_CD,'MIRE',STND_COST_NM,SGRP_COST_CD_DESC) AS NAME " ).append("\n"); 
		query.append("		     ,MIN(ACCT_DP_SEQ) AS ACCT_DP_SEQ " ).append("\n"); 
		query.append("		 FROM COA_STND_ACCT_V " ).append("\n"); 
		query.append("		WHERE 1=1 " ).append("\n"); 
		query.append("		  AND COA_COST_SRC_PRT_CD IN ('CO','PA') " ).append("\n"); 
		query.append("		  AND (STND_COST_TP_CD IN ('C') " ).append("\n"); 
		query.append("		    OR STND_COST_TP_CD IN ('O') AND MGRP_COST_CD IN ('EQ','BU')) " ).append("\n"); 
		query.append("		    OR STND_COST_TP_CD IN ('S') AND STND_COST_CD IN ('43201011') " ).append("\n"); 
		query.append("		  AND COA_COST_SRC_PRT_CD IN ('CO','PA') " ).append("\n"); 
		query.append("		GROUP BY SGRP_COST_CD,DECODE(SGRP_COST_CD,'MIRE',STND_COST_NM,SGRP_COST_CD_DESC) " ).append("\n"); 
		query.append("		ORDER BY ACCT_DP_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchAvgSubGrpList')" ).append("\n"); 
		query.append(" 	 	 SELECT MGRP_COST_CD code, MGRP_COST_CD_DESC name " ).append("\n"); 
		query.append("		 FROM COA_MN_GRP_COST " ).append("\n"); 
		query.append("		 WHERE MGRP_COST_CD in ('OV','OF')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchAvgCoaCodeList')" ).append("\n"); 
		query.append("		 SELECT STND_COST_CD CODE, STND_COST_NM NAME " ).append("\n"); 
		query.append("		 FROM COA_STND_ACCT " ).append("\n"); 
		query.append("		 WHERE ( MGRP_COST_CD = @[code] AND STND_COST_CD != '54600000') " ).append("\n"); 
		query.append("		#if (${svcGrpCd} != '')" ).append("\n"); 
		query.append("			  OR (STND_COST_CD = '43102011')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	     ORDER BY STND_COST_CD   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchDemDetStandardCdList')" ).append("\n"); 
		query.append("SELECT STND_COST_CD CODE" ).append("\n"); 
		query.append("	 , STND_COST_NM NAME " ).append("\n"); 
		query.append("  FROM COA_STND_ACCT" ).append("\n"); 
		query.append(" WHERE STND_COST_CD IN ('43201011', '51601011')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCostSourceGroupCodeList')" ).append("\n"); 
		query.append("SELECT COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("     , COA_COST_SRC_CD_NM NAME " ).append("\n"); 
		query.append("  FROM COA_COST_SRC_ACCT " ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG, 'N')= 'N'" ).append("\n"); 
		query.append("   AND SGRP_COST_CD 	= @[code]" ).append("\n"); 
		query.append(" ORDER BY STND_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVslOwnerList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Vessel 소유구분 항목을 가져온다*/" ).append("\n"); 
		query.append("  SELECT INTG_CD_VAL_CTNT    AS CODE" ).append("\n"); 
		query.append("        ,INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   WHERE INTG_CD_ID = 'CD00230'" ).append("\n"); 
		query.append("#if(${code} == 'OTH')" ).append("\n"); 
		query.append("     AND INTG_CD_VAL_DP_SEQ IN (3)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     AND INTG_CD_VAL_DP_SEQ IN (1,4) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMdmRegionList')" ).append("\n"); 
		query.append("	SELECT RGN_CD CODE," ).append("\n"); 
		query.append("	       RGN_NM NAME" ).append("\n"); 
		query.append("	  FROM MDM_REGION" ).append("\n"); 
		query.append("	 WHERE CNT_CD IN ('CA', 'US')" ).append("\n"); 
		query.append("	   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'getUSDAmt2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*환율 변환2 : 현재월 환율이 없을경우 이전월 데이터 사용 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT MAX(ROUND(@[lcl_amt]/USD_LOCL_XCH_RT,3)) KEEP(DENSE_RANK FIRST ORDER BY ACCT_XCH_RT_YRMON DESC) RT" ).append("\n"); 
		query.append("      FROM GL_MON_XCH_RT 			" ).append("\n"); 
		query.append("     WHERE ACCT_XCH_RT_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[cost_yrmon],'YYYYMM'),-1),'YYYYMM') AND @[cost_yrmon]	" ).append("\n"); 
		query.append("       AND ACCT_XCH_RT_LVL   = '1' 		" ).append("\n"); 
		query.append("       AND CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMaxSimNo')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*날짜의 Max Simulation No를 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT LPAD(NVL(MAX(SIM_NO)+1,1), 3,'0') SIM_NO  " ).append("\n"); 
		query.append("      FROM COA_SIM_INFO " ).append("\n"); 
		query.append("     WHERE 1=1 " ).append("\n"); 
		query.append("       AND SIM_DT  = TO_CHAR(SYSDATE, 'yyyymmdd')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Simulation number의 설명을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT TO_CHAR(TO_DATE(SIM_DT,'yyyymmdd'),'yyyy-mm-dd')  || chr(14849154)|| SIM_NO  || chr(14849154) ||  CRE_USR_ID  NAME   " ).append("\n"); 
		query.append("      	  ,SIM_DEPT_CD || '|' || SIM_DT  || '|' || SIM_NO  CODE  " ).append("\n"); 
		query.append("	  FROM COA_SIM_INFO " ).append("\n"); 
		query.append("     WHERE SLAN_CD = @[slan_cd] " ).append("\n"); 
		query.append("  	   AND SIM_DEPT_CD = NVL(@[sim_dept_cd],SIM_DEPT_CD) " ).append("\n"); 
		query.append("     ORDER BY  SIM_DT DESC" ).append("\n"); 
		query.append("              ,SIM_NO DESC " ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimDeptList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Simulation dept code를 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT SIM_DEPT_CD NAME" ).append("\n"); 
		query.append("			  ,SIM_DEPT_CD CODE   " ).append("\n"); 
		query.append("		FROM COA_SIM_INFO " ).append("\n"); 
		query.append("		WHERE SIM_DEPT_CD = NVL(@[code], SIM_DEPT_CD) " ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Simulation number의 설명을 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT TO_CHAR(TO_DATE(SIM_DT,'yyyymmdd'),'yyyy-mm-dd')  || chr(14849154)|| SIM_NO  || chr(14849154) ||  CRE_USR_ID  NAME   " ).append("\n"); 
		query.append("      	  ,SIM_DEPT_CD || '|' || SIM_DT  || '|' || SIM_NO  CODE  " ).append("\n"); 
		query.append("	  FROM COA_SIM_INFO " ).append("\n"); 
		query.append("     WHERE SLAN_CD = @[slan_cd] " ).append("\n"); 
		query.append("  	   AND SIM_DEPT_CD = NVL(@[sim_dept_cd],SIM_DEPT_CD) " ).append("\n"); 
		query.append("     ORDER BY  SIM_DT DESC" ).append("\n"); 
		query.append("              ,SIM_NO DESC " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimVesselList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Vessel콤보의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT '1' SEQ" ).append("\n"); 
		query.append("		  ,VSL_CD CODE" ).append("\n"); 
		query.append("		  ,VSL_CD NAME " ).append("\n"); 
		query.append("	  FROM COA_VSL_RGST " ).append("\n"); 
		query.append("	 WHERE VSL_TP_CD = 'C' " ).append("\n"); 
		query.append("  	   AND DELT_FLG  = 'N' " ).append("\n"); 
		query.append("  	   AND LST_FLG   = 'Y'" ).append("\n"); 
		query.append("    UNION ALL " ).append("\n"); 
		query.append("    SELECT '0' SEQ" ).append("\n"); 
		query.append("		  ,VSL_CD CODE" ).append("\n"); 
		query.append("		  ,VSL_CD NAME " ).append("\n"); 
		query.append("      FROM COA_SIM_VSL_RGST " ).append("\n"); 
		query.append("     ORDER BY SEQ" ).append("\n"); 
		query.append("			,CODE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimVessel')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Simulation에서 사용한 vessel 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT VSL_CD CODE" ).append("\n"); 
		query.append("			  ,VSL_CD NAME " ).append("\n"); 
		query.append("		  FROM COA_SIM_VSL_SET_INFO " ).append("\n"); 
		query.append("		 WHERE SIM_DT  = @[sim_dt] " ).append("\n"); 
		query.append("		   AND SIM_NO  = @[sim_no] " ).append("\n"); 
		query.append("		   AND SIM_DIV_CD = '1' " ).append("\n"); 
		query.append("		 ORDER BY VSL_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimOpAcct')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*OP 계정코드를 조회한다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT STND_COST_NM NAME" ).append("\n"); 
		query.append("			  ,SGRP_COST_CD CODE  " ).append("\n"); 
		query.append("		  FROM COA_STND_ACCT " ).append("\n"); 
		query.append("		 WHERE MGRP_COST_CD = 'OF' " ).append("\n"); 
		query.append("		   AND STND_COST_CD NOT IN ('54400000','92200000','92100000') " ).append("\n"); 
		query.append("		 ORDER BY ACCT_DP_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimVslClssList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Vessel Class 콤보의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT VSL_CLSS_CAPA CODE" ).append("\n"); 
		query.append("			  ,VSL_CLSS_CAPA NAME " ).append("\n"); 
		query.append("		  FROM ( " ).append("\n"); 
		query.append("		SELECT DISTINCT VSL_CLSS_CAPA  " ).append("\n"); 
		query.append("		  FROM COA_VSL_RGST " ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		   AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT DISTINCT VSL_CLSS_CAPA  " ).append("\n"); 
		query.append("		  FROM COA_SIM_VSL_RGST " ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		   ) " ).append("\n"); 
		query.append("		ORDER BY  VSL_CLSS_CAPA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSimSLaneList') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*S.Lane의 목록을 가져온다*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT DISTINCT NAME" ).append("\n"); 
		query.append("			  ,CODE " ).append("\n"); 
		query.append("		  FROM ( " ).append("\n"); 
		query.append("		        SELECT SLAN_CD NAME" ).append("\n"); 
		query.append("					  ,SLAN_CD CODE " ).append("\n"); 
		query.append("		          FROM COA_LANE_RGST " ).append("\n"); 
		query.append("		         WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("		         UNION ALL " ).append("\n"); 
		query.append("		        SELECT SLAN_CD NAME" ).append("\n"); 
		query.append("					  ,SLAN_CD CODE " ).append("\n"); 
		query.append("		          FROM COA_SIM_INFO " ).append("\n"); 
		query.append("		       ) " ).append("\n"); 
		query.append("		ORDER BY CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVOPCd') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*searchVOPCd*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSokeupCodeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*sokeupStatus : SJH.20140818.ADD */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		INTG_CD_VAL_CTNT CODE" ).append("\n"); 
		query.append("		,INTG_CD_VAL_DP_DESC  NAME" ).append("\n"); 
		query.append("	FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("	WHERE INTG_CD_ID = 'CD00220'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSvcScpCodeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*searchSvcScpCodeList : PCM.20141218.ADD */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD AS CODE" ).append("\n"); 
		query.append("	  ,SVC_SCP_NM AS NAME" ).append("\n"); 
		query.append("	  ,'' AS ETC1" ).append("\n"); 
		query.append("      ,'' AS ETC2" ).append("\n"); 
		query.append("      ,'' AS ETC3" ).append("\n"); 
		query.append("      ,'' AS ETC4" ).append("\n"); 
		query.append("      ,(SVC_SCP_CD || '|' || SVC_SCP_NM) AS ETC5" ).append("\n"); 
		query.append("FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubTradeList2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*Sub Trade 정보를 가져온다(중복없이) */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT  " ).append("\n"); 
		query.append("	   SUB_TRD_CD CODE" ).append("\n"); 
		query.append("	  ,SUB_TRD_CD NAME " ).append("\n"); 
		query.append("  FROM MDM_DTL_REV_LANE " ).append("\n"); 
		query.append(" WHERE SUB_TRD_CD IS NOT NULL " ).append("\n"); 
		query.append("   AND TRD_CD     = NVL(@[trd_cd], TRD_CD) " ).append("\n"); 
		query.append(" ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLocListAll')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Location Code별 목록을 가져온다 (SJH.20150105.ADD) */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       DECODE(@[param0],'S',SCC_CD,'E',ECC_CD,'L',LCC_CD,'R',RCC_CD,LOC_CD) NAME" ).append("\n"); 
		query.append("	  ,DECODE(@[param0],'S',SCC_CD,'E',ECC_CD,'L',LCC_CD,'R',RCC_CD,LOC_CD) CODE " ).append("\n"); 
		query.append("  FROM COA_LOCATION_V " ).append("\n"); 
		query.append(" ORDER BY CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCostSourceGroupCodeList2')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* so cost Code별 목록을 가져온다 (SJH.20150205.ADD) */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT COA_COST_SRC_CD CODE " ).append("\n"); 
		query.append("     , COA_COST_SRC_CD_NM NAME " ).append("\n"); 
		query.append("  FROM COA_COST_SRC_ACCT " ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG, 'N')= 'N'" ).append("\n"); 
		query.append("   AND SGRP_COST_CD 	 = @[code]" ).append("\n"); 
		query.append("   AND COA_COST_SRC_CD LIKE @[cnum]||'%'" ).append("\n"); 
		query.append(" ORDER BY STND_COST_CD, COA_COST_SRC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCntrTpszCdList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* so cost Code별 목록을 가져온다 (SJH.20150205.ADD) */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD CODE " ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD NAME " ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG, 'N')= 'N'" ).append("\n"); 
		query.append("   AND CNTR_TP_CD 	 = @[param0]" ).append("\n"); 
		query.append(" ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchAcmAccountTypeList')" ).append("\n"); 
		query.append("/* avg agent commition account 구분 코드 - ac_tp_cd 2017.01.11 Add */" ).append("\n"); 
		query.append("SELECT DISTINCT A.AC_TP_CD AS CODE" ).append("\n"); 
		query.append("     , A.AC_CD_RMK AS NAME" ).append("\n"); 
		query.append("  FROM ACM_COMM_TP_CD_MAPG A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND COMM_TP_CD   = 'C'" ).append("\n"); 
		query.append("   AND AC_TP_CD     <> 'T'  " ).append("\n"); 
		query.append(" ORDER BY A.AC_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchAcmBoundList')" ).append("\n"); 
		query.append("/* avg agent commition : bound 구분 코드 - io_bnd_cd 2017.01.11 Add */" ).append("\n"); 
		query.append("SELECT DISTINCT A.IO_BND_CD AS CODE" ).append("\n"); 
		query.append("     , A.IO_BND_CD AS NAME" ).append("\n"); 
		query.append("  FROM ACM_COMM_TP_CD_MAPG A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND COMM_TP_CD   = 'C'" ).append("\n"); 
		query.append("   AND AC_TP_CD     <> 'T'    " ).append("\n"); 
		query.append(" ORDER BY A.IO_BND_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchAcmCostList')" ).append("\n"); 
		query.append("/* avg agent commition : Cost Code 구분 코드 - coa_cost_src_cd 2017.01.11 Add */" ).append("\n"); 
		query.append("SELECT A.COA_COST_SRC_CD AS CODE" ).append("\n"); 
		query.append("     , A.COA_COST_SRC_CD_NM AS NAME" ).append("\n"); 
		query.append("  FROM COA_COST_SRC_ACCT A" ).append("\n"); 
		query.append(" WHERE A.SGRP_COST_CD   = 'CVAC'" ).append("\n"); 
		query.append("   AND A.STND_COST_CD   <> '51401014'" ).append("\n"); 
		query.append(" ORDER BY A.COA_COST_SRC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}