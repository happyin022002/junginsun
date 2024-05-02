/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationFlgUSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyPackingInstructionRegulationFlg
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationFlgUSQL(){
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
		params.put("imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("regu_dp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationFlgUSQL").append("\n"); 
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
		query.append("UPDATE SCG_PCK_REGU" ).append("\n"); 
		query.append("   SET " ).append("\n"); 
		query.append("       REGU_PCK_CD_FLG = 'N'   -- FROM SCG_PCK_REGU_PKG_CD" ).append("\n"); 
		query.append("      ,REGU_IBC_FLG = 'N'   --   FROM SCG_PCK_REGU_PKG_IBC_CD" ).append("\n"); 
		query.append("      ,REGU_PCK_ORG_PRX_FLG = DECODE((SELECT COUNT(1) " ).append("\n"); 
		query.append("                                   FROM SCG_PCK_REGU_ORG_PRX" ).append("\n"); 
		query.append("                                  WHERE IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("                                    AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq] " ).append("\n"); 
		query.append("                                    AND REGU_DP_NO = @[regu_dp_no]" ).append("\n"); 
		query.append("								    AND DELT_FLG = 'N'), 0, 'N', 'Y')" ).append("\n"); 
		query.append("      ,REGU_PCK_MZD_FLG = DECODE((SELECT COUNT(1) " ).append("\n"); 
		query.append("                                   FROM SCG_PCK_REGU_MZD" ).append("\n"); 
		query.append("                                  WHERE IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("                                    AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq] " ).append("\n"); 
		query.append("                                    AND REGU_DP_NO = @[regu_dp_no]" ).append("\n"); 
		query.append("								    AND DELT_FLG = 'N'), 0, 'N', 'Y')" ).append("\n"); 
		query.append("      ,REGU_IMG_FLG = DECODE((SELECT COUNT(1) " ).append("\n"); 
		query.append("                                   FROM SCG_PCK_REGU_IMG" ).append("\n"); 
		query.append("                                  WHERE IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("                                    AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq] " ).append("\n"); 
		query.append("                                    AND REGU_DP_NO = @[regu_dp_no]" ).append("\n"); 
		query.append("								    AND DELT_FLG = 'N'), 0, 'N', 'Y')" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("   AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]  " ).append("\n"); 
		query.append("   AND REGU_DP_NO = @[regu_dp_no]" ).append("\n"); 

	}
}