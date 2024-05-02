/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionCodeRSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPackingInstructionCode
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionCodeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionCodeRSQL").append("\n"); 
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
		query.append("SELECT PCK_INSTR_TP_CTNT " ).append("\n"); 
		query.append("      ,PCK_DIV_CD " ).append("\n"); 
		query.append("      ,PCK_DESC " ).append("\n"); 
		query.append("      ,PCK_DESC_USE_FLG " ).append("\n"); 
		query.append("      ,PCK_REGU_USE_FLG " ).append("\n"); 
		query.append("      ,INR_PCK_USE_FLG " ).append("\n"); 
		query.append("      ,INTMD_PCK_USE_FLG " ).append("\n"); 
		query.append("      ,OUTR_PCK_USE_FLG " ).append("\n"); 
		query.append("      ,OUTR_PCK_MAX_CAPA_FLG " ).append("\n"); 
		query.append("      ,SGL_PCK_USE_FLG " ).append("\n"); 
		query.append("      ,SGL_PCK_MAX_CAPA_FLG " ).append("\n"); 
		query.append("      ,PRSS_DESC " ).append("\n"); 
		query.append("      ,PRSS_DESC_USE_FLG " ).append("\n"); 
		query.append("      ,ADD_REGU_DESC " ).append("\n"); 
		query.append("      ,ADD_REGU_DESC_USE_FLG " ).append("\n"); 
		query.append("      ,SPCL_PCK_REGU_USE_FLG " ).append("\n"); 
		query.append("      ,GAS_USE_FLG " ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,PCK_EXPT_FLG" ).append("\n"); 
		query.append("  FROM SCG_PCK_INSTR" ).append("\n"); 
		query.append(" WHERE IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("   AND IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}