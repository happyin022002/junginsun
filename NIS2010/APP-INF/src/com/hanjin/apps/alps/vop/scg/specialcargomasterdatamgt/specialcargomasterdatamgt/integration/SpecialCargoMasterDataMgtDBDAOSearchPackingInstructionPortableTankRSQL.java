/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPortableTankRSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPortableTankRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPackingInstructionPortableTank
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPortableTankRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ptbl_tnk_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPortableTankRSQL").append("\n"); 
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
		query.append("SELECT T.PTBL_TNK_INSTR_CD" ).append("\n"); 
		query.append("      ,T.SUB_SEQ" ).append("\n"); 
		query.append("      ,T.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,T.MIN_TST_PRSS" ).append("\n"); 
		query.append("      ,T.MIN_SHL_THCK_CTNT" ).append("\n"); 
		query.append("      ,T.BTM_OPN_PROVI_CTNT" ).append("\n"); 
		query.append("      ,T.PRS_RLF_PROVI_CTNT" ).append("\n"); 
		query.append("      ,T.SBST_DESC" ).append("\n"); 
		query.append("	  ,T.SBST_DESC_REF_NO" ).append("\n"); 
		query.append("      ,T.FILL_DGR_CTNT" ).append("\n"); 
		query.append("      ,T.IMDG_CTRL_TEMP" ).append("\n"); 
		query.append("      ,T.CTRL_TEMP_REF_NO" ).append("\n"); 
		query.append("      ,T.IMDG_EMER_TEMP" ).append("\n"); 
		query.append("      ,T.EMER_TEMP_REF_NO" ).append("\n"); 
		query.append("      ,T.MAX_ALW_WRK_SML_PRSS" ).append("\n"); 
		query.append("      ,T.MAX_ALW_WRK_BARE_PRSS" ).append("\n"); 
		query.append("      ,T.MAX_ALW_WRK_SUN_SHLD_PRSS" ).append("\n"); 
		query.append("      ,T.MAX_ALW_WRK_INSLT_PRSS" ).append("\n"); 
		query.append("      ,T.OPN_BLW_LQD_LVL_CD" ).append("\n"); 
		query.append("      ,T.MAX_FILL_DNST_CTNT" ).append("\n"); 
		query.append("      ,T.PCK_REF_CD" ).append("\n"); 
		query.append("      ,T.REF_DIV_NO" ).append("\n"); 
		query.append("#if(${ptbl_tnk_instr_cd} != '')" ).append("\n"); 
		query.append("      ,U.PRP_SHP_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,T.DELT_FLG" ).append("\n"); 
		query.append("  FROM SCG_PCK_PTB_TNK T" ).append("\n"); 
		query.append("#if(${ptbl_tnk_instr_cd} != '')" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("       SELECT IMDG_UN_NO" ).append("\n"); 
		query.append("             ,RANK() OVER (PARTITION BY IMDG_UN_NO" ).append("\n"); 
		query.append("                           ORDER BY IMDG_UN_NO_SEQ DESC) R" ).append("\n"); 
		query.append("             ,PRP_SHP_NM" ).append("\n"); 
		query.append("         FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("       ) U" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${ptbl_tnk_instr_cd} != '')" ).append("\n"); 
		query.append("   AND T.IMDG_UN_NO = U.IMDG_UN_NO" ).append("\n"); 
		query.append("   AND U.R = 1" ).append("\n"); 
		query.append("   AND T.PTBL_TNK_INSTR_CD = @[ptbl_tnk_instr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND T.PTBL_TNK_INSTR_CD NOT IN ('T23', 'T50')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND T.DELT_FLG = 'N'" ).append("\n"); 

	}
}