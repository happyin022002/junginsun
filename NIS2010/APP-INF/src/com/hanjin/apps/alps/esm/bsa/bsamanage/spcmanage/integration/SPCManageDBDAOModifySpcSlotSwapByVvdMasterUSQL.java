/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCManageDBDAOModifySpcSlotSwapByVvdMasterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.04
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2016.02.04 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOModifySpcSlotSwapByVvdMasterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA_VVD_MST UPDate 쿼리
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * </pre>
	  */
	public SPCManageDBDAOModifySpcSlotSwapByVvdMasterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_bsa_bfr_sub_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_hjs_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cht_out",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_hjs_bsa_capa_sc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOModifySpcSlotSwapByVvdMasterUSQL").append("\n"); 
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
		query.append("UPDATE BSA_VVD_MST SET " ).append("\n"); 
		query.append("		MNL_FLG = @[mnl_flg]," ).append("\n"); 
		query.append("#if (${tab_index} == '0')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnl_flg} == 'Y')" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	#if (${type} == 'SC')" ).append("\n"); 
		query.append("		FNL_HJS_BSA_CAPA = @[fnl_hjs_bsa_capa_sc], -- SC" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		FNL_HJS_BSA_CAPA = @[fnl_hjs_bsa_capa], -- JO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		CO_BSA_CAPA = @[cht_out]," ).append("\n"); 
		query.append("	#if (${type} == 'SC')" ).append("\n"); 
		query.append("		HJS_BSA_RTO = @[fnl_hjs_bsa_capa_sc]/DECODE((@[fnl_hjs_bsa_capa_sc]+@[cht_out]),0,1,(@[fnl_hjs_bsa_capa_sc]+@[cht_out]))," ).append("\n"); 
		query.append("		CHTR_BSA_RTO = 1 - @[fnl_hjs_bsa_capa_sc]/DECODE((@[fnl_hjs_bsa_capa_sc]+@[cht_out]),0,1,(@[fnl_hjs_bsa_capa_sc]+@[cht_out]))," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		HJS_BSA_RTO = @[fnl_hjs_bsa_capa]/DECODE((@[fnl_hjs_bsa_capa]+@[cht_out]),0,1,(@[fnl_hjs_bsa_capa]+@[cht_out]))," ).append("\n"); 
		query.append("		CHTR_BSA_RTO = 1-@[fnl_hjs_bsa_capa]/DECODE((@[fnl_hjs_bsa_capa]+@[cht_out]),0,1,(@[fnl_hjs_bsa_capa]+@[cht_out]))," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		HJS_BSA_BFR_SUB_CAPA = @[hjs_bsa_bfr_sub_capa]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UPD_USR_ID 		 = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT 			 = SYSDATE" ).append("\n"); 
		query.append("WHERE	TRD_CD 	= @[trd_cd]" ).append("\n"); 
		query.append("AND	RLANE_CD 	= @[rlane_cd]" ).append("\n"); 
		query.append("AND	VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO 	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD 	= @[skd_dir_cd]" ).append("\n"); 

	}
}