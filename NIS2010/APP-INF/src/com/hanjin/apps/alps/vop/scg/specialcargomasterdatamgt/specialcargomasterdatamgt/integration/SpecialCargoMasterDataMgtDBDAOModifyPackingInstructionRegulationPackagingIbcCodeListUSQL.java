/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPackagingIbcCodeListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPackagingIbcCodeListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proper IBC Code 를 변경한다.
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPackagingIbcCodeListUSQL(){
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
		params.put("sub_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("perm_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("and_or_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("regu_dp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPackagingIbcCodeListUSQL").append("\n"); 
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
		query.append("##UPDATE SCG_PCK_REGU_PKG_IBC_CD" ).append("\n"); 
		query.append("##   SET PERM_CHK   = @[perm_chk]  " ).append("\n"); 
		query.append("##     , PCK_TP_CD  = @[pck_tp_cd] " ).append("\n"); 
		query.append("##     , IMDG_PCK_CD     = @[imdg_pck_cd]    " ).append("\n"); 
		query.append("##     , AND_OR_CD  = @[and_or_cd] " ).append("\n"); 
		query.append("##     , DELT_FLG   = @[delt_flg]  " ).append("\n"); 
		query.append("##     , UPD_USR_ID = @[upd_usr_id]  " ).append("\n"); 
		query.append("##     , UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("##WHERE IMDG_PCK_INSTR_CD     = @[imdg_pck_instr_cd]    " ).append("\n"); 
		query.append("##  AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]     " ).append("\n"); 
		query.append("##  AND REGU_DP_NO    = @[regu_dp_no]   " ).append("\n"); 
		query.append("##  AND SUB_SEQ        = @[sub_seq] " ).append("\n"); 

	}
}