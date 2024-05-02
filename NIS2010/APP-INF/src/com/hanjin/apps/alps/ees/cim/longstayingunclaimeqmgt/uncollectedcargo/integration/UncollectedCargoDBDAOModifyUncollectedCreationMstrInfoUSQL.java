/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOModifyUncollectedCreationMstrInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOModifyUncollectedCreationMstrInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyUncollectedCreation Master 데이타 Update 
	  * </pre>
	  */
	public UncollectedCargoDBDAOModifyUncollectedCreationMstrInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kntr_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kntr_brnc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_brnc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_upd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_uc_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kntr_upd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_ropn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kntr_hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kntr_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_ofc_trns_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOModifyUncollectedCreationMstrInfoUSQL").append("\n"); 
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
		query.append("UPDATE	CIM_UC_CGO" ).append("\n"); 
		query.append("SET		" ).append("\n"); 
		query.append("		hndl_rhq_cd 		=	@[hndl_rhq_cd]" ).append("\n"); 
		query.append("		, hndl_brnc_cd 		=	@[hndl_brnc_cd]" ).append("\n"); 
		query.append("		, hndl_hdlr_usr_id 	=	@[hndl_hdlr_usr_id]" ).append("\n"); 
		query.append("		, kntr_rhq_cd 		=	@[kntr_rhq_cd]" ).append("\n"); 
		query.append("		, kntr_brnc_cd 		=	@[kntr_brnc_cd]" ).append("\n"); 
		query.append("		, kntr_hdlr_usr_id 	=	@[kntr_hdlr_usr_id]" ).append("\n"); 
		query.append("		, uc_sts_cd 		=	@[uc_sts_cd]" ).append("\n"); 
		query.append("		, uc_ropn_flg 		=	@[uc_ropn_flg]" ).append("\n"); 
		query.append("		, uc_ofc_trns_flg 	=	@[uc_ofc_trns_flg]" ).append("\n"); 
		query.append("		, cnee_uc_dt 		=	@[cnee_uc_dt]" ).append("\n"); 
		query.append("		, uc_clz_dt 		=	@[uc_clz_dt]" ).append("\n"); 
		query.append("		, uc_dys 			=	NULL" ).append("\n"); 
		query.append("		, uc_dchg_dys 		=	NULL" ).append("\n"); 
		query.append("		, upd_usr_id 		=	@[upd_usr_id]" ).append("\n"); 
		query.append("		, upd_dt     		=	SYSDATE" ).append("\n"); 
		query.append("		#if (${uc_ofc_trns_flg} == 'N')" ).append("\n"); 
		query.append("			, hndl_upd_id 		=	@[hndl_upd_id]" ).append("\n"); 
		query.append("			, hndl_upd_dt 		=	TO_DATE(DECODE(@[hndl_upd_dt],'SYSDATE',TO_CHAR(SYSDATE,'YYYYMMDD'),@[hndl_upd_dt]),'YYYYMMDD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${uc_ofc_trns_flg} == 'Y')" ).append("\n"); 
		query.append("			, kntr_upd_id 		=	@[kntr_upd_id]" ).append("\n"); 
		query.append("			, kntr_upd_dt 		=	TO_DATE(DECODE(@[kntr_upd_dt],'SYSDATE',TO_CHAR(SYSDATE,'YYYYMMDD'),@[kntr_upd_dt]),'YYYYMMDD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("WHERE	uc_cs_no 			=	@[uc_cs_no]" ).append("\n"); 

	}
}