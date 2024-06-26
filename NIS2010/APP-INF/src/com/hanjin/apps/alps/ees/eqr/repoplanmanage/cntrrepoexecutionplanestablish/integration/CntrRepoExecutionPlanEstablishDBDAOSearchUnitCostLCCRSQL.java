/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostLCCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostLCCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UNIT COST 정보를 취득합니다.
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostLCCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostLCCRSQL").append("\n"); 
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
		query.append("-- ---------------------- LCC LEVEL SEARCH(EQR_LCC_ADD_PLN_COST -------------------------" ).append("\n"); 
		query.append("-- CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL = 0 인 경우 " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    NVL(MAX(DECODE(SUB_MOD, 'F', PLN_UC_AMT)),0) FM_COST											" ).append("\n"); 
		query.append("    ,NVL(MAX(DECODE(SUB_MOD, 'T', PLN_UC_AMT)),0) TO_COST												" ).append("\n"); 
		query.append("    ,NVL(SUM(PLN_UC_AMT),0) UC_COST   																" ).append("\n"); 
		query.append("FROM 												  													" ).append("\n"); 
		query.append("    (  																									" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if(${trsp_mod_cd} == 'V') " ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PLN_UC_AMT" ).append("\n"); 
		query.append("			, TRSP_SUB_MOD_CD SUB_MOD																" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("			EQR_LCC_ADD_PLN_COST																			" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	#if(${division} == 'P')  -- plan" ).append("\n"); 
		query.append("			WHERE " ).append("\n"); 
		query.append("				FM_LCC_CD = (" ).append("\n"); 
		query.append("								SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("								FROM   MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("								WHERE  ECC_CD = @[fm_ecc]" ).append("\n"); 
		query.append("								AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                AND    ROWNUM=1" ).append("\n"); 
		query.append("				)              	" ).append("\n"); 
		query.append("    	#else   -- execute 혹은 internal (E, I)" ).append("\n"); 
		query.append("			WHERE " ).append("\n"); 
		query.append("				FM_LCC_CD = (" ).append("\n"); 
		query.append("								SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("								FROM   MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("								WHERE  SCC_CD = SUBSTR(@[fm_ecc], 0, 5)" ).append("\n"); 
		query.append("								AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                AND    ROWNUM=1" ).append("\n"); 
		query.append("				)  " ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	    AND   TRSP_MOD_CD = @[trsp_mod_cd]																				" ).append("\n"); 
		query.append("    	    AND   CNTR_TPSZ_CD= @[cntr_tpsz_cd]																				" ).append("\n"); 
		query.append("    	    AND   TRSP_SUB_MOD_CD = 'F'																		" ).append("\n"); 
		query.append("    	" ).append("\n"); 
		query.append("	UNION ALL																								" ).append("\n"); 
		query.append("    	    " ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			PLN_UC_AMT" ).append("\n"); 
		query.append("			, TRSP_SUB_MOD_CD SUB_MOD																" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("			EQR_LCC_ADD_PLN_COST																			" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	#if(${division} == 'P')  -- plan" ).append("\n"); 
		query.append("			WHERE " ).append("\n"); 
		query.append("				TO_LCC_CD = (" ).append("\n"); 
		query.append("							SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("							FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("							WHERE ECC_CD = @[to_ecc]" ).append("\n"); 
		query.append("							AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   ROWNUM=1" ).append("\n"); 
		query.append("				)  				" ).append("\n"); 
		query.append("    	#else   -- execute 혹은 internal (E, I)" ).append("\n"); 
		query.append("			WHERE " ).append("\n"); 
		query.append("				TO_LCC_CD = (" ).append("\n"); 
		query.append("							SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("							FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("							WHERE SCC_CD = SUBSTR( @[to_ecc] , 0, 5)" ).append("\n"); 
		query.append("							AND	  DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   ROWNUM=1" ).append("\n"); 
		query.append("				) 	" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	    AND   TRSP_MOD_CD = @[trsp_mod_cd]																				" ).append("\n"); 
		query.append("    	    AND   CNTR_TPSZ_CD= @[cntr_tpsz_cd]																						" ).append("\n"); 
		query.append("    	    AND   TRSP_SUB_MOD_CD = 'T'																		" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("    	    SELECT " ).append("\n"); 
		query.append("				PLN_UC_AMT" ).append("\n"); 
		query.append("				, TRSP_SUB_MOD_CD SUB_MOD																" ).append("\n"); 
		query.append("    	    FROM " ).append("\n"); 
		query.append("				EQR_LCC_ADD_PLN_COST																			" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    	#if(${division} == 'P')  -- plan" ).append("\n"); 
		query.append("			WHERE " ).append("\n"); 
		query.append("				FM_LCC_CD = (" ).append("\n"); 
		query.append("							SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("							FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("							WHERE ECC_CD = @[fm_ecc]" ).append("\n"); 
		query.append("							AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   ROWNUM=1" ).append("\n"); 
		query.append("				)              	" ).append("\n"); 
		query.append("    		    AND TO_LCC_CD = (" ).append("\n"); 
		query.append("								SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("								FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("								WHERE ECC_CD = @[to_ecc]" ).append("\n"); 
		query.append("								AND	  DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                AND   ROWNUM=1" ).append("\n"); 
		query.append("				)  				" ).append("\n"); 
		query.append("    	#else   -- execute 혹은 internal (E, I)" ).append("\n"); 
		query.append("			WHERE " ).append("\n"); 
		query.append("				FM_LCC_CD = (" ).append("\n"); 
		query.append("							SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("							FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("							WHERE SCC_CD = SUBSTR( @[fm_ecc] , 0, 5)" ).append("\n"); 
		query.append("							AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   ROWNUM=1" ).append("\n"); 
		query.append("				)  " ).append("\n"); 
		query.append("    		    AND TO_LCC_CD = (" ).append("\n"); 
		query.append("								SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("								FROM MDM_EQ_ORZ_CHT " ).append("\n"); 
		query.append("								WHERE SCC_CD = SUBSTR( @[to_ecc] , 0, 5)" ).append("\n"); 
		query.append("								AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                AND   ROWNUM=1" ).append("\n"); 
		query.append("				) 	" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	    AND   TRSP_MOD_CD = @[trsp_mod_cd]																				" ).append("\n"); 
		query.append("    	    AND   CNTR_TPSZ_CD= @[cntr_tpsz_cd]																				" ).append("\n"); 
		query.append("    	-- ECC INTERNAL" ).append("\n"); 
		query.append("    	#if(${division} == 'I')" ).append("\n"); 
		query.append("			AND   TRSP_SUB_MOD_CD = 'I'" ).append("\n"); 
		query.append("		#end												" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}