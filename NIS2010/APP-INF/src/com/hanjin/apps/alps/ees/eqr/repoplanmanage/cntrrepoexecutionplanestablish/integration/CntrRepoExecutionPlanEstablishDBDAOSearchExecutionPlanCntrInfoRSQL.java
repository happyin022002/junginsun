/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
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

public class CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_EXE_PLN_CNTR &  BKG_BKG_CNTR 테이블에서  
	  * 컨테이너-MOVEMENT정보 조회(특정 컨테이터 검색에서 사용)
	  * 
	  * - 20100510 SQL QUERY 수정, 신용찬 수석(신범철 확인)
	  * 1. CNMV_YR, CNMV_ID_NO --> CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO 으로 변경
	  * 2. XPKCTM_MOVEMENT --> XUK1CTM_MOVEMENT 으로 변경
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanCntrInfoRSQL(){
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
		params.put("to_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchExecutionPlanCntrInfoRSQL").append("\n"); 
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
		query.append("    MC.CNTR_NO,                                                               " ).append("\n"); 
		query.append("    MC.CNTR_TPSZ_CD,                                                          " ).append("\n"); 
		query.append("    MC.LSTM_CD,                                                                 " ).append("\n"); 
		query.append("    CM.MVMT_STS_CD , --CNMV_STS_CD,                                                        " ).append("\n"); 
		query.append("    MC.VNDR_ABBR_NM ,                                                           " ).append("\n"); 
		query.append("    MC.CNTR_USE_CO_CD ,                                                         " ).append("\n"); 
		query.append("    MC.DMG_FLG,                                                                 " ).append("\n"); 
		query.append("    MC.CNTR_HNGR_RCK_CD , -- CNTR_HNGR_RCK_FLG,                                                       " ).append("\n"); 
		query.append("    MC.CNTR_HNGR_BAR_ATCH_KNT , -- CNTR_HNGR_BAR_FLG,                                                       " ).append("\n"); 
		query.append("    MC.RFUB_FLG,                                                                " ).append("\n"); 
		query.append("    MC.DISP_FLG,                                                                " ).append("\n"); 
		query.append("    MC.PLST_FLR_FLG ,                                                           " ).append("\n"); 
		query.append("    MC.IMDT_EXT_FLG,                                                            " ).append("\n"); 
		query.append("    MC.RF_TP_CD_C ,                                                             " ).append("\n"); 
		query.append("    MC.RF_TP_CD_H                                                               " ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("    CTM_MOVEMENT CM --CTM_CNTR_MVMT  CM" ).append("\n"); 
		query.append("    ,( " ).append("\n"); 
		query.append("        with cntr_info as " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                MC.CNTR_NO,                                                       " ).append("\n"); 
		query.append("                MC.CNTR_TPSZ_CD,                                                         " ).append("\n"); 
		query.append("                MC.LSTM_CD,                                                              " ).append("\n"); 
		query.append("                MC.CNMV_STS_CD,      	                                                   " ).append("\n"); 
		query.append("                MV.VNDR_ABBR_NM ,                                                        " ).append("\n"); 
		query.append("                DECODE(MC.CNTR_USE_CO_CD,'H','SML','SEN') CNTR_USE_CO_CD ,               " ).append("\n"); 
		query.append("                MC.DMG_FLG,                                                              " ).append("\n"); 
		query.append("                MC.CNTR_HNGR_RCK_CD,                                                    " ).append("\n"); 
		query.append("                MC.CNTR_HNGR_BAR_ATCH_KNT,                                                    " ).append("\n"); 
		query.append("                MC.RFUB_FLG,                                                             " ).append("\n"); 
		query.append("                MC.DISP_FLG,                                                             " ).append("\n"); 
		query.append("                MC.PLST_FLR_FLG ,                                                        " ).append("\n"); 
		query.append("                MC.IMDT_EXT_FLG,                                                         " ).append("\n"); 
		query.append("                DECODE(MC.RF_TP_CD, 'C', 'Y') RF_TP_CD_C ,                               " ).append("\n"); 
		query.append("                DECODE(MC.RF_TP_CD, 'H', 'Y') RF_TP_CD_H                                 " ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("                MST_CONTAINER MC" ).append("\n"); 
		query.append("                , MDM_VENDOR MV                                       " ).append("\n"); 
		query.append("--    		    	WHERE MC.VNDR_CNT_CD = MV.VNDR_CNT_CD                                      " ).append("\n"); 
		query.append("--    	 VENDOR CODE Join 시 CNT_CD 제외하고 SEQ만 하게 함. - by.JH Kwon" ).append("\n"); 
		query.append("	    	WHERE " ).append("\n"); 
		query.append("	    	    MC.VNDR_SEQ = MV.VNDR_SEQ                                            " ).append("\n"); 
		query.append("                #if(${trans_mode} != 'F')  --Off-Hire의 경우 INACTIVE 한 것도 가능하게 함." ).append("\n"); 
		query.append("                    AND MC.ACIAC_DIV_CD <> 'I' --Active한 것만 가져온다" ).append("\n"); 
		query.append("                #end	" ).append("\n"); 
		query.append("                AND MC.CNTR_NO NOT IN (   -- 동일한 PLN_WEEK 에 중복되는 cntr_no가 없게 함." ).append("\n"); 
		query.append("	                                    SELECT DISTINCT CNTR_NO " ).append("\n"); 
		query.append("	                                    FROM EQR_EXE_PLN_CNTR  " ).append("\n"); 
		query.append("                                        WHERE PLN_YRWK = @[pln_yrwk] " ).append("\n"); 
		query.append("                                        AND NVL(FM_ECC_CD,'XXXXX') = @[fm_ecc]  " ).append("\n"); 
		query.append("                                        AND NVL(TO_ECC_CD,'XXXXX') = @[to_ecc] " ).append("\n"); 
		query.append("                                        AND TRSP_MOD_CD = DECODE(@[trans_mode] ,'S','X',@[trans_mode]) " ).append("\n"); 
		query.append("                ) 	--trans_mode = 'S'는 ecc_internal임. ECC Internal은 cntr 제한 없이 가능하게 함. 	 " ).append("\n"); 
		query.append("                #if(${cntr_no} != '')" ).append("\n"); 
		query.append("                    AND MC.CNTR_NO IN( ${arrStrCntrNo} )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("        )                                                                           " ).append("\n"); 
		query.append("        select " ).append("\n"); 
		query.append("            CNTR_NO,                                                             " ).append("\n"); 
		query.append("            CNTR_TPSZ_CD,                                                            " ).append("\n"); 
		query.append("            LSTM_CD,                                                                 " ).append("\n"); 
		query.append("            CNMV_STS_CD,      	                                                     " ).append("\n"); 
		query.append("            VNDR_ABBR_NM ,                                                           " ).append("\n"); 
		query.append("            CNTR_USE_CO_CD ,                                                         " ).append("\n"); 
		query.append("            DMG_FLG,                                                                 " ).append("\n"); 
		query.append("            CNTR_HNGR_RCK_CD,                                                       " ).append("\n"); 
		query.append("            CNTR_HNGR_BAR_ATCH_KNT,                                                       " ).append("\n"); 
		query.append("            RFUB_FLG,                                                                " ).append("\n"); 
		query.append("            DISP_FLG,                                                                " ).append("\n"); 
		query.append("            PLST_FLR_FLG ,                                                           " ).append("\n"); 
		query.append("            IMDT_EXT_FLG,                                                            " ).append("\n"); 
		query.append("            RF_TP_CD_C ,                                                             " ).append("\n"); 
		query.append("            RF_TP_CD_H                                                               " ).append("\n"); 
		query.append("	     FROM " ).append("\n"); 
		query.append("	        cntr_info" ).append("\n"); 
		query.append("	) MC                                                          " ).append("\n"); 
		query.append("WHERE CM.CNTR_NO = MC.CNTR_NO     " ).append("\n"); 
		query.append("-- CNMV_YR, CNMV_ID_NO --> CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO 으로 변경,  20100510 신용찬 수정(신범철 확인)                                                " ).append("\n"); 
		query.append("--AND (CM.CNMV_YR, CM.CNMV_ID_NO) = (       " ).append("\n"); 
		query.append("AND (CM.CNMV_YR, CM.CNMV_SEQ, CM.CNMV_SPLIT_NO) = " ).append("\n"); 
		query.append("                                 (                                             " ).append("\n"); 
		query.append("                					--SELECT /*+index_desc(a XPKCTM_MOVEMENT) */ CNMV_YR, CNMV_ID_NO " ).append("\n"); 
		query.append("                                    -- 20100510 신용찬 수정(신범철 확인)" ).append("\n"); 
		query.append("                                    -- XPKCTM_MOVEMENT --> XUK1CTM_MOVEMENT 으로 변경   " ).append("\n"); 
		query.append("                                    -- CNMV_YR, CNMV_ID_NO --> CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO 으로 변경                                        " ).append("\n"); 
		query.append("               						SELECT /*+index_desc(a XUK1CTM_MOVEMENT) */ CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO                                      " ).append("\n"); 
		query.append("                    				FROM CTM_MOVEMENT A                                            " ).append("\n"); 
		query.append("                    				WHERE A.CNTR_NO = MC.CNTR_NO                                     " ).append("\n"); 
		query.append("                    				AND ROWNUM = 1" ).append("\n"); 
		query.append("                    			  )" ).append("\n"); 

	}
}