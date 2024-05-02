/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEccLinkInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.23 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchEccLinkInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 ecc 의 EQR_ECC_LNK  테이블의 정보 조회
	  * 2010.12.23 이준범 [CHM-201007870-01]
	  * 1. Default >Inquiry>Link Info 화면
	  * > 조회시 Detail data에 대한 생성일자를 화면에 표시
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEccLinkInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("transitTime",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEccLinkInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    FM_ECC_CD" ).append("\n"); 
		query.append("    ,TO_ECC_CD" ).append("\n"); 
		query.append("    ,TRSP_MOD_CD" ).append("\n"); 
		query.append("    ,TZ_DYS" ).append("\n"); 
		query.append("    ,TZ_20FT_COST_AMT" ).append("\n"); 
		query.append("    ,TZ_40FT_COST_AMT" ).append("\n"); 
		query.append("    ,TZ_45FT_COST_AMT" ).append("\n"); 
		query.append("    ,CNTR_MAX_CAPA_QTY" ).append("\n"); 
		query.append("    ,CNTR_VOL_UT_CD     -- BOX1" ).append("\n"); 
		query.append("    ,TRSP_FREQ_KNT" ).append("\n"); 
		query.append("    ,EXPT_FM_YRWK" ).append("\n"); 
		query.append("    ,EXPT_TO_YRWK" ).append("\n"); 
		query.append("    ,EXPT_MAX_CAPA_QTY" ).append("\n"); 
		query.append("    ,EXPT_VOL_UT_CD     -- BOX2" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    EQR_ECC_LNK" ).append("\n"); 
		query.append("	## WHERE 조건 변경 : DELT_FLG = 'N' ,즉, DELETE 되지 않은 항목만 조회 가능." ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    NVL(DELT_FLG,'N') = 'N'		        " ).append("\n"); 
		query.append("	AND 1=1                                   " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	## where condition " ).append("\n"); 
		query.append("	#if (${fromStatus} != '') " ).append("\n"); 
		query.append("		AND FM_ECC_CD IN (" ).append("\n"); 
		query.append("		#foreach($key IN ${fromEccArr}) " ).append("\n"); 
		query.append("			#if($velocityCount < $fromEccArr.size()) " ).append("\n"); 
		query.append("			'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("			'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${toStatus} != '') " ).append("\n"); 
		query.append("		AND TO_ECC_CD IN (" ).append("\n"); 
		query.append("		#foreach( $key in ${toEccArr}) " ).append("\n"); 
		query.append("			#if($velocityCount < $toEccArr.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${mode} != '') " ).append("\n"); 
		query.append("		AND TRSP_MOD_CD = @[mode]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${transitTime} != '') " ).append("\n"); 
		query.append("		AND TZ_DYS >= @[transitTime]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("    1" ).append("\n"); 
		query.append("    ,2" ).append("\n"); 
		query.append("    ,3" ).append("\n"); 

	}
}