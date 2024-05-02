/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionGasRegulationCSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOAddPackingInstructionGasRegulationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddPackingInstructionGasRegulation
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOAddPackingInstructionGasRegulationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clnd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gas_spcl_pck_provi_n1st_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prss_drm_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gas_spcl_pck_provi_n4th_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("megc_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_wrk_prss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gas_fill_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tst_prss",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tst_prd_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gas_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clnd_bdl_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lc50_val",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gas_spcl_pck_provi_n3rd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tub_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gas_spcl_pck_provi_n2nd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_div_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionGasRegulationCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PCK_GAS_REGU(" ).append("\n"); 
		query.append("       IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,GAS_TP_CD" ).append("\n"); 
		query.append("      ,IMDG_UN_NO" ).append("\n"); 
		query.append("      ,LC50_VAL" ).append("\n"); 
		query.append("      ,CLND_CHK_FLG" ).append("\n"); 
		query.append("      ,TUB_CHK_FLG" ).append("\n"); 
		query.append("      ,PRSS_DRM_CHK_FLG" ).append("\n"); 
		query.append("      ,CLND_BDL_CHK_FLG" ).append("\n"); 
		query.append("      ,MEGC_CHK_FLG" ).append("\n"); 
		query.append("      ,TST_PRD_YR" ).append("\n"); 
		query.append("      ,TST_PRSS" ).append("\n"); 
		query.append("      ,MAX_WRK_PRSS" ).append("\n"); 
		query.append("      ,GAS_FILL_RTO" ).append("\n"); 
		query.append("      ,GAS_SPCL_PCK_PROVI_N1ST_CTNT" ).append("\n"); 
		query.append("      ,GAS_SPCL_PCK_PROVI_N2ND_CTNT" ).append("\n"); 
		query.append("      ,GAS_SPCL_PCK_PROVI_N3RD_CTNT" ).append("\n"); 
		query.append("      ,GAS_SPCL_PCK_PROVI_N4TH_CTNT" ).append("\n"); 
		query.append("      ,PCK_REF_CD" ).append("\n"); 
		query.append("      ,REF_DIV_NO " ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID " ).append("\n"); 
		query.append("      ,CRE_DT " ).append("\n"); 
		query.append("      ,UPD_USR_ID " ).append("\n"); 
		query.append("      ,UPD_DT " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("       @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("      ,@[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("      ,@[gas_tp_cd]" ).append("\n"); 
		query.append("      ,@[imdg_un_no]" ).append("\n"); 
		query.append("      ,@[lc50_val]" ).append("\n"); 
		query.append("      ,@[clnd_chk_flg]" ).append("\n"); 
		query.append("      ,@[tub_chk_flg]" ).append("\n"); 
		query.append("      ,@[prss_drm_chk_flg]" ).append("\n"); 
		query.append("      ,@[clnd_bdl_chk_flg]" ).append("\n"); 
		query.append("      ,@[megc_chk_flg]" ).append("\n"); 
		query.append("      ,@[tst_prd_yr]" ).append("\n"); 
		query.append("      ,@[tst_prss]" ).append("\n"); 
		query.append("      ,@[max_wrk_prss]" ).append("\n"); 
		query.append("      ,@[gas_fill_rto]" ).append("\n"); 
		query.append("      ,@[gas_spcl_pck_provi_n1st_ctnt]" ).append("\n"); 
		query.append("      ,@[gas_spcl_pck_provi_n2nd_ctnt]" ).append("\n"); 
		query.append("      ,@[gas_spcl_pck_provi_n3rd_ctnt]" ).append("\n"); 
		query.append("      ,@[gas_spcl_pck_provi_n4th_ctnt]" ).append("\n"); 
		query.append("      ,@[pck_ref_cd]" ).append("\n"); 
		query.append("      ,@[ref_div_no]" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}