/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasRegulationRSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasRegulationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPackingInstructionGasRegulation
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasRegulationRSQL(){
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
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasRegulationRSQL").append("\n"); 
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
		query.append("SELECT G.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("      ,G.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("      ,G.GAS_TP_CD" ).append("\n"); 
		query.append("      ,G.IMDG_UN_NO" ).append("\n"); 
		query.append("      ,G.LC50_VAL" ).append("\n"); 
		query.append("      ,G.CLND_CHK_FLG" ).append("\n"); 
		query.append("      ,G.TUB_CHK_FLG" ).append("\n"); 
		query.append("      ,G.PRSS_DRM_CHK_FLG" ).append("\n"); 
		query.append("      ,G.CLND_BDL_CHK_FLG" ).append("\n"); 
		query.append("      ,G.MEGC_CHK_FLG" ).append("\n"); 
		query.append("      ,G.TST_PRD_YR" ).append("\n"); 
		query.append("      ,G.TST_PRSS" ).append("\n"); 
		query.append("      ,G.MAX_WRK_PRSS" ).append("\n"); 
		query.append("      ,G.GAS_FILL_RTO" ).append("\n"); 
		query.append("      ,G.GAS_SPCL_PCK_PROVI_N1ST_CTNT" ).append("\n"); 
		query.append("      ,G.GAS_SPCL_PCK_PROVI_N2ND_CTNT" ).append("\n"); 
		query.append("      ,G.GAS_SPCL_PCK_PROVI_N3RD_CTNT" ).append("\n"); 
		query.append("      ,G.GAS_SPCL_PCK_PROVI_N4TH_CTNT" ).append("\n"); 
		query.append("      ,G.PCK_REF_CD" ).append("\n"); 
		query.append("      ,G.REF_DIV_NO " ).append("\n"); 
		query.append("      ,U.PRP_SHP_NM" ).append("\n"); 
		query.append("      ,G.DELT_FLG" ).append("\n"); 
		query.append("  FROM SCG_PCK_GAS_REGU G" ).append("\n"); 
		query.append("      ,(SELECT IMDG_UN_NO" ).append("\n"); 
		query.append("             ,RANK() OVER (PARTITION BY IMDG_UN_NO" ).append("\n"); 
		query.append("                           ORDER BY IMDG_UN_NO_SEQ DESC) R" ).append("\n"); 
		query.append("             ,PRP_SHP_NM" ).append("\n"); 
		query.append("         FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("       ) U" ).append("\n"); 
		query.append(" WHERE G.IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("   AND G.IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("   AND G.IMDG_UN_NO = U.IMDG_UN_NO" ).append("\n"); 
		query.append("   AND U.R = 1" ).append("\n"); 
		query.append("   AND G.DELT_FLG = 'N'" ).append("\n"); 

	}
}