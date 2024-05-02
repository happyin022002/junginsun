/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchOfficeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.27 
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchOfficeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OFFICE CODE 생성
	  * 1. Change History
	  *    1) 2012-12-27, 신용찬 수석
	  *        SQL 로직 수정
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchOfficeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_plan_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchOfficeCodeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    DISTINCT NVL(X.EQ_CTRL_OFC_CD, C.OFC_CD) OFFICE_CODE" ).append("\n"); 
		query.append("   ,TRS_PRIOR     			     " ).append("\n"); 
		query.append("FROM                                                                    	" ).append("\n"); 
		query.append("    (                                                                       	" ).append("\n"); 
		query.append("    SELECT EQ_CTRL_OFC_CD                                               	" ).append("\n"); 
		query.append("          ,REF_ID" ).append("\n"); 
		query.append("          ,TRS_PRIOR                                                       	" ).append("\n"); 
		query.append("    FROM                                                                	" ).append("\n"); 
		query.append("        (                                                                   	                " ).append("\n"); 
		query.append("        SELECT B.CTRL_OFC_CD  EQ_CTRL_OFC_CD                                " ).append("\n"); 
		query.append("              ,A.REF_ID                                                     " ).append("\n"); 
		query.append("              ,A.TRS_PRIOR" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            ( " ).append("\n"); 
		query.append("			SELECT 'T' as TRS_PRIOR " ).append("\n"); 
		query.append("				  ,A0.* " ).append("\n"); 
		query.append("				  ,B0.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			FROM ${target_table} A0" ).append("\n"); 
		query.append("				,${target_qty_table} B0" ).append("\n"); 
		query.append("			WHERE 1 = 1				" ).append("\n"); 
		query.append("		#foreach( ${key} in ${target_key_list}) " ).append("\n"); 
		query.append("			AND A0.${key.field1} = B0.${key.field2}" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			) A                                               " ).append("\n"); 
		query.append("            ,TRS_TRSP_OFC_EXPT_RULE B                                       " ).append("\n"); 
		query.append("        WHERE " ).append("\n"); 
		query.append("            B.FM_NOD_CD = CASE NVL(LENGTH(TRIM(B.FM_NOD_CD)),0)                    " ).append("\n"); 
		query.append("                            WHEN 7 THEN A.FM_YD_CD                      " ).append("\n"); 
		query.append("                            WHEN 5 THEN SUBSTR(A.FM_YD_CD,1,5)          " ).append("\n"); 
		query.append("                            WHEN 2 THEN SUBSTR(A.FM_YD_CD,1,2)          " ).append("\n"); 
		query.append("                            WHEN 0 THEN B.FM_NOD_CD                                              " ).append("\n"); 
		query.append("            END                                             " ).append("\n"); 
		query.append("            AND   B.TO_NOD_CD = CASE NVL(LENGTH(TRIM(B.TO_NOD_CD)),0)                    " ).append("\n"); 
		query.append("                                WHEN 7 THEN A.TO_YD_CD                      " ).append("\n"); 
		query.append("                                WHEN 5 THEN SUBSTR(A.TO_YD_CD,1,5)          " ).append("\n"); 
		query.append("                                WHEN 2 THEN SUBSTR(A.TO_YD_CD,1,2)          " ).append("\n"); 
		query.append("                                WHEN 0 THEN B.TO_NOD_CD                                              " ).append("\n"); 
		query.append("            END                                             " ).append("\n"); 
		query.append("            /* EMPTY REPO HAS NO VIA, DOR NODE */								" ).append("\n"); 
		query.append("            --AND   B.VIA_NOD_CD = '  '              								" ).append("\n"); 
		query.append("            --AND   B.DOR_NOD_CD = '  '	    			" ).append("\n"); 
		query.append("            /* 2007/07/27 ADDED */                                          	" ).append("\n"); 
		query.append("            #if(${target_table} == 'EQR_ONF_HIR_EXE_PLN') " ).append("\n"); 
		query.append("                AND   DECODE(B.TRSP_COST_DTL_MOD_CD,'  ',A.ONF_HIR_DIV_CD,'CN','O','CF','F')  = A.ONF_HIR_DIV_CD        " ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND   DECODE(B.TRSP_CRR_MOD_CD,'RD','R','TD','T','WD','W','  ',A.TRSP_MOD_CD) = A.TRSP_MOD_CD           " ).append("\n"); 
		query.append("            #end                " ).append("\n"); 
		query.append("            AND   DECODE(B.CNTR_TP_CD,'  ',SUBSTR(A.CNTR_TPSZ_CD,1,1),B.CNTR_TP_CD)       = SUBSTR(A.CNTR_TPSZ_CD,1,1)  " ).append("\n"); 
		query.append("            AND   DECODE(B.CNTR_SZ_CD,'  ',SUBSTR(A.CNTR_TPSZ_CD,2,1),B.CNTR_SZ_CD)       = SUBSTR(A.CNTR_TPSZ_CD,2,1)  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* KEY VALUE SET */                                                            " ).append("\n"); 
		query.append("            AND      A.REPO_PLN_ID = @[repo_plan_id]                    		 		        " ).append("\n"); 
		query.append("            AND      A.PLN_YRWK    = @[pln_yrwk]                             		        " ).append("\n"); 
		query.append("            AND      A.REF_ID      = @[ref_id]       " ).append("\n"); 
		query.append("			#if(${target_table} != 'EQR_ECC_INTER_EXE_PLN')                      		        " ).append("\n"); 
		query.append("            	AND      A.PLN_SEQ     = @[pln_seq]   " ).append("\n"); 
		query.append("			#end                                       " ).append("\n"); 
		query.append("            AND      A.CNTR_TPSZ_CD= @[cntr_tpsz_cd]                                          " ).append("\n"); 
		query.append("            /* HJS ONLY */                                                      " ).append("\n"); 
		query.append("            AND      A.CO_CD       = 'H'                                        " ).append("\n"); 
		query.append("            /* EMPTY EQ , EMPTY REPO ONLY */                                    " ).append("\n"); 
		query.append("            AND      B.CGO_TP_CD   = 'M'                                        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if(${target_table} == 'EQR_ONF_HIR_EXE_PLN')" ).append("\n"); 
		query.append("                AND	     B.TRSP_COST_DTL_MOD_CD IN ('CN','CF')		        	" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND      B.TRSP_COST_DTL_MOD_CD = 'ER'                  		" ).append("\n"); 
		query.append("            #end          " ).append("\n"); 
		query.append("            AND      B.DELT_FLG    = 'N'                                        " ).append("\n"); 
		query.append("        ORDER BY " ).append("\n"); 
		query.append("            NVL(LENGTH(TRIM(B.TRSP_COST_DTL_MOD_CD)),0)    DESC                               " ).append("\n"); 
		query.append("            ,NVL(LENGTH(TRIM(B.TRSP_CRR_MOD_CD)),0)         DESC                                           " ).append("\n"); 
		query.append("            ,NVL(LENGTH(TRIM(B.CNTR_TP_CD)),0)              DESC                                                                   " ).append("\n"); 
		query.append("            ,NVL(LENGTH(TRIM(B.CNTR_SZ_CD)),0)              DESC           " ).append("\n"); 
		query.append("            ,NVL(LENGTH(TRIM(B.FM_NOD_CD)),0)               DESC                               " ).append("\n"); 
		query.append("            ,NVL(LENGTH(TRIM(B.TO_NOD_CD)),0)               DESC                               " ).append("\n"); 
		query.append("        )  " ).append("\n"); 
		query.append("    WHERE   " ).append("\n"); 
		query.append("        ROWNUM = 1         " ).append("\n"); 
		query.append("    ) X                                                                     	" ).append("\n"); 
		query.append("    ,( " ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			A0.* ," ).append("\n"); 
		query.append("			B0.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("			${target_table} A0" ).append("\n"); 
		query.append("			, ${target_qty_table} B0" ).append("\n"); 
		query.append("		WHERE" ).append("\n"); 
		query.append("			1 = 1				" ).append("\n"); 
		query.append("			#foreach( ${key} in ${target_key_list}) " ).append("\n"); 
		query.append("				AND A0.${key.field1} = B0.${key.field2}" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	) A                                                  	" ).append("\n"); 
		query.append("    ,MDM_YARD C                                                             	" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    A.FM_YD_CD = C.YD_CD                                  				" ).append("\n"); 
		query.append("    AND      A.REF_ID       = X.REF_ID (+)                           						" ).append("\n"); 
		query.append("    /* KEY VALUE SET */                                                     	" ).append("\n"); 
		query.append("    AND      A.REPO_PLN_ID = @[repo_plan_id]                       				        	" ).append("\n"); 
		query.append("    AND      A.PLN_YRWK    = @[pln_yrwk]                             		            	" ).append("\n"); 
		query.append("    AND      A.REF_ID      = @[ref_id]      " ).append("\n"); 
		query.append("	#if(${target_table} != 'EQR_ECC_INTER_EXE_PLN')                      		        " ).append("\n"); 
		query.append("		AND      A.PLN_SEQ     = @[pln_seq]                                             	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    AND      A.CNTR_TPSZ_CD= @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("ORDER BY TRS_PRIOR" ).append("\n"); 

	}
}