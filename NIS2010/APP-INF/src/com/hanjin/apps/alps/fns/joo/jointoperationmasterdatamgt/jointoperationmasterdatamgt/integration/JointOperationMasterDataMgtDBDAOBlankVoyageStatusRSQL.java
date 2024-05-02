/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOBlankVoyageStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOBlankVoyageStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Blank Voyage Status 데이타 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOBlankVoyageStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cmpn_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOBlankVoyageStatusRSQL").append("\n"); 
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
		query.append("		jo_crr_cd,      " ).append("\n"); 
		query.append("		trd_cd,         " ).append("\n"); 
		query.append("		rlane_cd,       " ).append("\n"); 
		query.append("		re_divr_cd,     " ).append("\n"); 
		query.append("		cmpn_agmt_seq,  " ).append("\n"); 
		query.append("		ofc_cd,         " ).append("\n"); 
		query.append("		agmt_ofc_cd,    " ).append("\n"); 
		query.append("		jo_cmpn_knd_cd, " ).append("\n"); 
		query.append("		cmpn_agmt_yrmon," ).append("\n"); 
		query.append("		cmpn_agmt_yrwk, " ).append("\n"); 
		query.append("		vsl_cd,         " ).append("\n"); 
		query.append("		skd_voy_no,     " ).append("\n"); 
		query.append("		skd_dir_cd,     " ).append("\n"); 
		query.append("		vsl_cd||skd_voy_no||skd_dir_cd vvd_cd," ).append("\n"); 
		query.append("		bsa_qty,        " ).append("\n"); 
		query.append("		bsa_slt_prc,    " ).append("\n"); 
		query.append("		agmt_ttl_amt,   " ).append("\n"); 
		query.append("		DECODE(atch_file_id, null,'N','Y') atch_file_flag, " ).append("\n"); 
		query.append("		atch_file_id,   " ).append("\n"); 
		query.append("		cmpn_agmt_rmk,  " ).append("\n"); 
		query.append("		stl_flg,        " ).append("\n"); 
		query.append("		stl_vsl_cd,     " ).append("\n"); 
		query.append("		stl_voy_no,     " ).append("\n"); 
		query.append("		stl_dir_cd," ).append("\n"); 
		query.append("		stl_vsl_cd||stl_voy_no||stl_dir_cd stl_vvd_cd,   " ).append("\n"); 
		query.append("		stl_dt,         " ).append("\n"); 
		query.append("		delt_flg,       " ).append("\n"); 
		query.append("		cre_dt,         " ).append("\n"); 
		query.append("		cre_usr_id,     " ).append("\n"); 
		query.append("		upd_dt,         " ).append("\n"); 
		query.append("		upd_usr_id" ).append("\n"); 
		query.append("FROM	joo_cmpn_agmt   " ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("		#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("		AND jo_crr_cd = @[jo_crr_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${trd_cd} != '') " ).append("\n"); 
		query.append("		AND	trd_cd = @[trd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("		AND rlane_cd = @[rlane_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("		AND vsl_cd||skd_voy_no||skd_dir_cd = @[vvd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${re_divr_cd} != '') " ).append("\n"); 
		query.append("		AND re_divr_cd = @[re_divr_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${to_prd2} != '')" ).append("\n"); 
		query.append("		AND ( NVL(CMPN_AGMT_YRMON,REPLACE(@[to_prd2],'-','')) >= REPLACE(@[fm_prd1],'-','') AND NVL(CMPN_AGMT_YRMON,REPLACE(@[to_prd2],'-','')) <= REPLACE(@[to_prd2],'-','') )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${sttl_cd} != '' &&  ${sttl_cd} == 'Y') " ).append("\n"); 
		query.append("		AND stl_vsl_cd||stl_voy_no||stl_dir_cd IS NOT NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${sttl_cd} != '' &&  ${sttl_cd} == 'N') " ).append("\n"); 
		query.append("		AND stl_vsl_cd||stl_voy_no||stl_dir_cd IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${jo_cmpn_knd_cd} != '') " ).append("\n"); 
		query.append("		AND jo_cmpn_knd_cd = @[jo_cmpn_knd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${delt_flg} != '')" ).append("\n"); 
		query.append("		AND DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3" ).append("\n"); 

	}
}