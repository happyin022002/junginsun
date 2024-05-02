/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.04 원종규
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

public class SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddPackingInstructionRegulation
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationCSQL(){
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
		params.put("regu_mn_desc",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PCK_REGU(" ).append("\n"); 
		query.append("       IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,REGU_DP_NO" ).append("\n"); 
		query.append("      ,REGU_MN_DESC" ).append("\n"); 
		query.append("      ,REGU_PCK_CD_FLG" ).append("\n"); 
		query.append("      ,REGU_IBC_FLG" ).append("\n"); 
		query.append("      ,REGU_PCK_ORG_PRX_FLG" ).append("\n"); 
		query.append("      ,REGU_PCK_MZD_FLG" ).append("\n"); 
		query.append("      ,REGU_IMG_FLG" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("       @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("      ,@[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("      ,@[regu_dp_no]" ).append("\n"); 
		query.append("      ,@[regu_mn_desc]" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,'N'" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}