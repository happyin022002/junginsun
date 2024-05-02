/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAOCheckUpdateDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.20 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOCheckUpdateDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회시 Update Date 를 미리 조회 해 놓고
	  * 저장시 해당 table이 조회 시간 이후로 변경된 것이 있는지 check 한다.
	  * </pre>
	  */
	public PRICommonDBDAOCheckUpdateDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOCheckUpdateDateRSQL").append("\n"); 
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
		query.append("SELECT UPD_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, (SELECT USR_NM FROM COM_USER WHERE USR_ID = MN.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append("	,'' AS TABLE_NAME" ).append("\n"); 
		query.append("	,'' AS KEY1" ).append("\n"); 
		query.append("	,'' AS KEY2" ).append("\n"); 
		query.append("	,'' AS KEY3" ).append("\n"); 
		query.append("	,'' AS KEY4" ).append("\n"); 
		query.append("	,'' AS KEY5" ).append("\n"); 
		query.append("	,'' AS KEY6" ).append("\n"); 
		query.append("	,'' AS KEY7" ).append("\n"); 
		query.append("	,'' AS KEY8" ).append("\n"); 
		query.append("	,'' AS KEY9" ).append("\n"); 
		query.append("	,'' AS KEY10" ).append("\n"); 
		query.append("	,'' AS PAGE_NAME" ).append("\n"); 
		query.append("FROM ${table_name} MN" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	UPD_DT > TO_DATE(@[upd_dt],'YYYYMMDD-HH24MISS')" ).append("\n"); 
		query.append("#if (${table_name} == 'PRI_SP_MN')" ).append("\n"); 
		query.append("   	AND PROP_NO = @[key1]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[key2]" ).append("\n"); 
		query.append("#elseif( ${table_name} == 'PRI_RP_MN')" ).append("\n"); 
		query.append("   	AND PROP_NO = @[key1]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[key2]" ).append("\n"); 
		query.append("#elseif( ${table_name} == 'PRI_TRF_BZC' || ${table_name} == 'PRI_TRF_BZC_ROUT_PNT')" ).append("\n"); 
		query.append("   	AND TRF_PFX_CD = @[key1]" ).append("\n"); 
		query.append("	AND TRF_NO = @[key2]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[key3]" ).append("\n"); 
		query.append("#elseif( ${table_name} == 'PRI_TRF_RULE')" ).append("\n"); 
		query.append("   	AND TRF_PFX_CD = @[key1]" ).append("\n"); 
		query.append("	AND TRF_NO = @[key2]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[key3]" ).append("\n"); 
		query.append("	AND TRF_RULE_NO = @[key4]" ).append("\n"); 
		query.append("#elseif( ${table_name} == 'PRI_TRF_INLND' || ${table_name} == 'PRI_TRF_INLND_RT')" ).append("\n"); 
		query.append("   	AND TRF_PFX_CD = @[key1]" ).append("\n"); 
		query.append("	AND TRF_NO = @[key2]" ).append("\n"); 
		query.append("	AND AMDT_SEQ = @[key3]" ).append("\n"); 
		query.append("	AND TRF_INLND_SEQ = @[key4]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}