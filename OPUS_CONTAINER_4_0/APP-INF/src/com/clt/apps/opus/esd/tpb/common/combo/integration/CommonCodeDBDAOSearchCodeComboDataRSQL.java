/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCodeComboDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCodeComboDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCodeComboData
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCodeComboDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_default_select_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("main_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCodeComboDataRSQL").append("\n"); 
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
		query.append("SELECT (100000 +(SEQ * 10) ) AS SEQ," ).append("\n"); 
		query.append("       INTG_CD_ID, CODE, NAME," ).append("\n"); 
		query.append("       DECODE(CODE,@[s_default_select_code],'Y','N') AS SELECTEDYN" ).append("\n"); 
		query.append("  FROM ( SELECT INTG_CD_VAL_DP_SEQ AS SEQ," ).append("\n"); 
		query.append("                B.INTG_CD_ID," ).append("\n"); 
		query.append("                B.INTG_CD_VAL_CTNT AS CODE," ).append("\n"); 
		query.append("                B.INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("          WHERE INTG_CD_ID = @[main_code]" ).append("\n"); 
		query.append("			  #if(${code_condition_positive_arr} != '')" ).append("\n"); 
		query.append("				AND B.INTG_CD_VAL_CTNT IN (" ).append("\n"); 
		query.append("	 			#foreach($code_condition_positive_arr_num IN ${code_condition_positive_arr}) " ).append("\n"); 
		query.append("	 				#if($velocityCount < $code_condition_positive_arr.size()) " ).append("\n"); 
		query.append("	 					'$code_condition_positive_arr_num'," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("	 					'$code_condition_positive_arr_num'" ).append("\n"); 
		query.append("	 				#end " ).append("\n"); 
		query.append("	 			#end " ).append("\n"); 
		query.append("	 			)" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${code_condition_negative_arr} != '')" ).append("\n"); 
		query.append("				AND B.INTG_CD_VAL_CTNT NOT IN (" ).append("\n"); 
		query.append("	 			#foreach($code_condition_negative_arr_num IN ${code_condition_negative_arr}) " ).append("\n"); 
		query.append("	 				#if($velocityCount < $code_condition_negative_arr.size()) " ).append("\n"); 
		query.append("	 					'$code_condition_negative_arr_num'," ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("	 					'$code_condition_negative_arr_num'" ).append("\n"); 
		query.append("	 				#end " ).append("\n"); 
		query.append("	 			#end " ).append("\n"); 
		query.append("	 			)" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($addOptArr.size() > 0)" ).append("\n"); 
		query.append("	#foreach( ${key} in ${addOptArr}) " ).append("\n"); 
		query.append("----------                                      " ).append("\n"); 
		query.append("UNION ALL                                       " ).append("\n"); 
		query.append("SELECT TO_NUMBER('${key.name0}') SEQ, NULL INTG_CD_ID, '${key.name1}' CODE, '${key.name2}' NAME, DECODE('${key.name1}', @[s_default_select_code],'Y','N') SELECTEDYN" ).append("\n"); 
		query.append("FROM DUAL     " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY ${sortKey} ASC" ).append("\n"); 

	}
}