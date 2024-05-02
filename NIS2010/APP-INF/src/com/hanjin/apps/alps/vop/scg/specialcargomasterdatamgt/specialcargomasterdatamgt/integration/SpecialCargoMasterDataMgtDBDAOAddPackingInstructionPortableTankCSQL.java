/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionPortableTankCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규
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

public class SpecialCargoMasterDataMgtDBDAOAddPackingInstructionPortableTankCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddPackingInstructionPortableTank
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOAddPackingInstructionPortableTankCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_alw_wrk_sun_shld_prss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("btm_opn_provi_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sbst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_alw_wrk_inslt_prss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prs_rlf_provi_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_tst_prss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_shl_thck_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opn_blw_lqd_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_fill_dnst_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_alw_wrk_bare_prss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_ctrl_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_temp_REF_DIV_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ptbl_tnk_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mat_sub_desc_REF_DIV_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_temp_REF_DIV_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_alw_wrk_sml_prss",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_emer_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fill_dgr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_div_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionPortableTankCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PCK_PTB_TNK(" ).append("\n"); 
		query.append("       PTBL_TNK_INSTR_CD" ).append("\n"); 
		query.append("      ,SUB_SEQ" ).append("\n"); 
		query.append("      ,IMDG_UN_NO" ).append("\n"); 
		query.append("      ,MIN_TST_PRSS" ).append("\n"); 
		query.append("      ,MIN_SHL_THCK_CTNT" ).append("\n"); 
		query.append("      ,BTM_OPN_PROVI_CTNT" ).append("\n"); 
		query.append("      ,PRS_RLF_PROVI_CTNT" ).append("\n"); 
		query.append("      ,SBST_DESC" ).append("\n"); 
		query.append("      ,MAT_SUB_DESC_REF_DIV_NO" ).append("\n"); 
		query.append("      ,FILL_DGR_CTNT" ).append("\n"); 
		query.append("      ,IMDG_CTRL_TEMP" ).append("\n"); 
		query.append("      ,CTRL_TEMP_REF_DIV_NO" ).append("\n"); 
		query.append("      ,IMDG_EMER_TEMP" ).append("\n"); 
		query.append("      ,EMER_TEMP_REF_DIV_NO" ).append("\n"); 
		query.append("      ,MAX_ALW_WRK_SML_PRSS" ).append("\n"); 
		query.append("	  ,MAX_ALW_WRK_BARE_PRSS" ).append("\n"); 
		query.append("	  ,MAX_ALW_WRK_SUN_SHLD_PRSS" ).append("\n"); 
		query.append("	  ,MAX_ALW_WRK_INSLT_PRSS" ).append("\n"); 
		query.append("      ,OPN_BLW_LQD_LVL_CD" ).append("\n"); 
		query.append("      ,MAX_FILL_DNST_CTNT" ).append("\n"); 
		query.append("      ,PCK_REF_CD" ).append("\n"); 
		query.append("      ,REF_DIV_NO " ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID " ).append("\n"); 
		query.append("      ,CRE_DT " ).append("\n"); 
		query.append("      ,UPD_USR_ID " ).append("\n"); 
		query.append("      ,UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[ptbl_tnk_instr_cd]" ).append("\n"); 
		query.append("      ,NVL(MAX(SUB_SEQ), 0) + 1" ).append("\n"); 
		query.append("      ,@[imdg_un_no]" ).append("\n"); 
		query.append("      ,@[min_tst_prss]" ).append("\n"); 
		query.append("      ,@[min_shl_thck_ctnt]" ).append("\n"); 
		query.append("      ,@[btm_opn_provi_ctnt]" ).append("\n"); 
		query.append("      ,@[prs_rlf_provi_ctnt]" ).append("\n"); 
		query.append("      ,@[sbst_desc]" ).append("\n"); 
		query.append("      ,@[mat_sub_desc_REF_DIV_NO]" ).append("\n"); 
		query.append("      ,@[fill_dgr_ctnt]" ).append("\n"); 
		query.append("      ,@[imdg_ctrl_temp]" ).append("\n"); 
		query.append("      ,@[cntr_temp_REF_DIV_NO]" ).append("\n"); 
		query.append("      ,@[imdg_emer_temp]" ).append("\n"); 
		query.append("      ,@[emer_temp_REF_DIV_NO]" ).append("\n"); 
		query.append("      ,@[max_alw_wrk_sml_prss]" ).append("\n"); 
		query.append("  	  ,@[max_alw_wrk_bare_prss]" ).append("\n"); 
		query.append("	  ,@[max_alw_wrk_sun_shld_prss]" ).append("\n"); 
		query.append("	  ,@[max_alw_wrk_inslt_prss]" ).append("\n"); 
		query.append("      ,@[opn_blw_lqd_lvl_cd]" ).append("\n"); 
		query.append("      ,@[max_fill_dnst_ctnt]" ).append("\n"); 
		query.append("      ,@[pck_ref_cd]" ).append("\n"); 
		query.append("      ,@[ref_div_no]" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append(" FROM SCG_PCK_PTB_TNK" ).append("\n"); 
		query.append("WHERE PTBL_TNK_INSTR_CD     = @[ptbl_tnk_instr_cd]" ).append("\n"); 

	}
}