/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionSpclProviCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.07
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.07 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOAddPackingInstructionSpclProviCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddPackingInstructionSpclProvi
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOAddPackingInstructionSpclProviCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_mtrl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n1st_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n1st_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_pck_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prmt_chk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("capa_mass_max_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n2nd_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rule_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_pck_provi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_pck_provi_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n1st_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_pck_mtrl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("capa_mass_min_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n3rd_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n2nd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("capa_mass_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("capa_mass_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n3rd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_pck_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n2nd_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_n3rd_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_pck_provi_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionSpclProviCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_SPCL_PCK_PROVI(" ).append("\n"); 
		query.append("       IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,SPCL_PCK_PROVI_CD" ).append("\n"); 
		query.append("      ,SUB_SEQ" ).append("\n"); 
		query.append("      ,SPCL_PCK_PROVI_DIV_CD" ).append("\n"); 
		query.append("      ,PRMT_CHK_CD" ).append("\n"); 
		query.append("      ,PCK_STY_CD" ).append("\n"); 
		query.append("      ,GRP_N1ST_USE_FLG" ).append("\n"); 
		query.append("      ,GRP_N1ST_QTY" ).append("\n"); 
		query.append("      ,GRP_N1ST_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,GRP_N2ND_USE_FLG" ).append("\n"); 
		query.append("      ,GRP_N2ND_QTY" ).append("\n"); 
		query.append("      ,GRP_N2ND_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,GRP_N3RD_USE_FLG" ).append("\n"); 
		query.append("      ,GRP_N3RD_QTY" ).append("\n"); 
		query.append("      ,GRP_N3RD_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,CAPA_MASS_USE_FLG" ).append("\n"); 
		query.append("      ,CAPA_MASS_MIN_QTY" ).append("\n"); 
		query.append("      ,CAPA_MASS_MAX_QTY" ).append("\n"); 
		query.append("      ,CAPA_MASS_MEAS_UT_CD" ).append("\n"); 
		query.append("      ,RULE_APLY_TP_CD" ).append("\n"); 
		query.append("      ,PCK_TP_CD" ).append("\n"); 
		query.append("      ,PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_CD" ).append("\n"); 
		query.append("      ,SPCL_PCK_DESC" ).append("\n"); 
		query.append("      ,COND_PCK_STY_CD" ).append("\n"); 
		query.append("      ,COND_PCK_TP_CD" ).append("\n"); 
		query.append("      ,COND_PCK_MTRL_TP_CD" ).append("\n"); 
		query.append("      ,COND_PCK_CD" ).append("\n"); 
		query.append("      ,COND_PCK_CD_DESC" ).append("\n"); 
		query.append("      ,SPCL_PCK_PROVI_DESC" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID " ).append("\n"); 
		query.append("      ,CRE_DT " ).append("\n"); 
		query.append("      ,UPD_USR_ID " ).append("\n"); 
		query.append("      ,UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("      ,@[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("      ,@[spcl_pck_provi_cd]" ).append("\n"); 
		query.append("      ,NVL(MAX(SUB_SEQ), 0) + 1" ).append("\n"); 
		query.append("      ,@[spcl_pck_provi_div_cd]" ).append("\n"); 
		query.append("      ,@[prmt_chk_cd]" ).append("\n"); 
		query.append("      ,@[pck_sty_cd]" ).append("\n"); 
		query.append("      ,@[grp_n1st_use_flg]" ).append("\n"); 
		query.append("      ,@[grp_n1st_qty]" ).append("\n"); 
		query.append("      ,@[grp_n1st_meas_ut_cd]" ).append("\n"); 
		query.append("      ,@[grp_n2nd_use_flg]" ).append("\n"); 
		query.append("      ,@[grp_n2nd_qty]" ).append("\n"); 
		query.append("      ,@[grp_n2nd_meas_ut_cd]" ).append("\n"); 
		query.append("      ,@[grp_n3rd_use_flg]" ).append("\n"); 
		query.append("      ,@[grp_n3rd_qty]" ).append("\n"); 
		query.append("      ,@[grp_n3rd_meas_ut_cd]" ).append("\n"); 
		query.append("      ,@[capa_mass_use_flg]" ).append("\n"); 
		query.append("      ,@[capa_mass_min_qty]" ).append("\n"); 
		query.append("      ,@[capa_mass_max_qty]" ).append("\n"); 
		query.append("      ,@[capa_mass_meas_ut_cd]" ).append("\n"); 
		query.append("      ,@[rule_aply_tp_cd]" ).append("\n"); 
		query.append("      ,@[pck_tp_cd]" ).append("\n"); 
		query.append("      ,@[pck_mtrl_tp_cd]" ).append("\n"); 
		query.append("      ,@[imdg_pck_cd]" ).append("\n"); 
		query.append("      ,@[spcl_pck_desc]" ).append("\n"); 
		query.append("      ,@[cond_pck_sty_cd]" ).append("\n"); 
		query.append("      ,@[cond_pck_tp_cd]" ).append("\n"); 
		query.append("      ,@[cond_pck_mtrl_tp_cd]" ).append("\n"); 
		query.append("      ,@[cond_pck_cd]" ).append("\n"); 
		query.append("      ,@[cond_pck_cd_desc]" ).append("\n"); 
		query.append("	  ,@[spcl_pck_provi_desc]" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM SCG_SPCL_PCK_PROVI" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("   AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]  " ).append("\n"); 
		query.append("   AND SPCL_PCK_PROVI_CD = @[spcl_pck_provi_cd]" ).append("\n"); 

	}
}