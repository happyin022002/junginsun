/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPKGMethodListCSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPKGMethodListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PackingInstruction Creation
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPKGMethodListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("max_mass",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("regu_dp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_div_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPKGMethodListCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PCK_REGU_MZD" ).append("\n"); 
		query.append("( IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append(", IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append(", REGU_DP_NO" ).append("\n"); 
		query.append(", SUB_SEQ" ).append("\n"); 
		query.append(", IMDG_PCK_MZD_CD" ).append("\n"); 
		query.append(", CMB_PCK_MAX_WGT " ).append("\n"); 
		query.append(", LQD_MAX_WGT" ).append("\n"); 
		query.append(", PCK_REF_CD" ).append("\n"); 
		query.append(", REF_DIV_NO" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("    , @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("    , @[regu_dp_no]" ).append("\n"); 
		query.append("    , NVL(MAX(SUB_SEQ), 0) + 1" ).append("\n"); 
		query.append("    , @[imdg_pck_mzd_cd]" ).append("\n"); 
		query.append("    , @[max_mass]" ).append("\n"); 
		query.append("    , @[max_ctnt]" ).append("\n"); 
		query.append("    , @[pck_ref_cd] " ).append("\n"); 
		query.append("    , @[ref_div_no] " ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("FROM SCG_PCK_REGU_MZD     " ).append("\n"); 
		query.append("WHERE 1=1      " ).append("\n"); 
		query.append(" AND IMDG_PCK_INSTR_CD     = @[imdg_pck_instr_cd]    " ).append("\n"); 
		query.append(" AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]     " ).append("\n"); 
		query.append(" AND REGU_DP_NO    = @[regu_dp_no]" ).append("\n"); 

	}
}