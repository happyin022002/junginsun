/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingIbcCodeListRSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingIbcCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgPckReguPkgIbcCdVO 생성
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingIbcCodeListRSQL(){
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
		params.put("regu_dp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingIbcCodeListRSQL").append("\n"); 
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
		query.append("##SELECT IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("##     , IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("##     , REGU_DP_NO" ).append("\n"); 
		query.append("##     , SUB_SEQ" ).append("\n"); 
		query.append("##     , PERM_CHK " ).append("\n"); 
		query.append("##     , PCK_TP_CD" ).append("\n"); 
		query.append("##     , IMDG_PCK_CD" ).append("\n"); 
		query.append("##     , AND_OR_CD" ).append("\n"); 
		query.append("##     , DELT_FLG" ).append("\n"); 
		query.append("##FROM SCG_PCK_REGU_PKG_IBC_CD " ).append("\n"); 
		query.append("##WHERE 1=1" ).append("\n"); 
		query.append("##AND IMDG_PCK_INSTR_CD     = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("##AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("##AND REGU_DP_NO    = @[regu_dp_no]" ).append("\n"); 
		query.append("##AND DELT_FLG = 'N'" ).append("\n"); 

	}
}