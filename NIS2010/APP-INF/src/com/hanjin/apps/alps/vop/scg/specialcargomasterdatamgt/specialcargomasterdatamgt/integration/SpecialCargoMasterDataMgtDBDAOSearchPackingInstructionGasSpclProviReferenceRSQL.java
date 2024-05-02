/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasSpclProviReferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.18
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.18 원종규
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

public class SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasSpclProviReferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPackingInstructionGasSpclProviReference
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasSpclProviReferenceRSQL(){
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
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasSpclProviReferenceRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       R.PCK_REF_CD" ).append("\n"); 
		query.append("      ,R.REF_DIV_NO" ).append("\n"); 
		query.append("      ,R.REF_DESC" ).append("\n"); 
		query.append("      ,R.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,R.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,R.DELT_FLG" ).append("\n"); 
		query.append("  FROM SCG_PCK_REF R" ).append("\n"); 
		query.append("      ,SCG_PCK_GAS_REGU P" ).append("\n"); 
		query.append(" WHERE R.PCK_REF_CD = P.PCK_REF_CD" ).append("\n"); 
		query.append("   AND P.IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("   AND P.IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("   AND P.IMDG_PCK_INSTR_CD = R.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("   AND P.IMDG_PCK_INSTR_SEQ = R.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("       P.GAS_SPCL_PCK_PROVI_N1ST_CTNT = R.REF_DIV_NO" ).append("\n"); 
		query.append("       OR P.GAS_SPCL_PCK_PROVI_N2ND_CTNT = R.REF_DIV_NO" ).append("\n"); 
		query.append("       OR P.GAS_SPCL_PCK_PROVI_N3RD_CTNT = R.REF_DIV_NO" ).append("\n"); 
		query.append("       OR P.GAS_SPCL_PCK_PROVI_N4TH_CTNT = R.REF_DIV_NO" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND R.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY R.PCK_REF_CD, R.REF_DIV_NO" ).append("\n"); 

	}
}