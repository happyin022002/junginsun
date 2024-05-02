/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES Invoice Common Code List Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL").append("\n"); 
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
		query.append("SELECT 													" ).append("\n"); 
		query.append("	(                                                                                                   " ).append("\n"); 
		query.append("	SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(CNTR_TPSZ_CD,'|')),'|')                                        " ).append("\n"); 
		query.append("	FROM	(                                                                                              " ).append("\n"); 
		query.append("		SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append("			, Z.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		FROM	(SELECT	CNTR_TPSZ_CD " ).append("\n"); 
		query.append("			FROM	MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("			GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			ORDER BY  CNTR_TPSZ_CD     " ).append("\n"); 
		query.append("			) Z                                                                                             " ).append("\n"); 
		query.append("		)                                                                                                   " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1                                                          " ).append("\n"); 
		query.append("	START WITH ROW_ID = 1) CNTR_TPSZ_CD,                                                          " ).append("\n"); 
		query.append("	(                                                                                             " ).append("\n"); 
		query.append("	SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')                                   " ).append("\n"); 
		query.append("	FROM	(SELECT LGS_COST_CD, ROWNUM ROW_ID" ).append("\n"); 
		query.append("		          FROM (                                                                                        " ).append("\n"); 
		query.append("						SELECT	Z.LGS_COST_CD" ).append("\n"); 
		query.append("					FROM	(SELECT LGS_COST_CD, ROWNUM ROW_ID                                                     " ).append("\n"); 
		query.append("							 FROM   TES_TML_SO_COST                                                                " ).append("\n"); 
		query.append("							 WHERE  DECODE('MT','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG,      " ).append("\n"); 
		query.append("			                   					'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'                      " ).append("\n"); 
		query.append("							 AND    COST_CALC_MZD_CD = 'A'" ).append("\n"); 
		query.append("            				 ORDER BY LGS_COST_CD ASC		                                                  " ).append("\n"); 
		query.append("			) Z                                                                                       " ).append("\n"); 
		query.append("		))                                                                                             " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1                                                          " ).append("\n"); 
		query.append("	START WITH ROW_ID = 1) MT_A_LGS_COST_CD,                                                      " ).append("\n"); 
		query.append("	(                                                                                             " ).append("\n"); 
		query.append("	SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')                                   " ).append("\n"); 
		query.append("	FROM	(                                                                                        " ).append("\n"); 
		query.append("		SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append("			, Z.LGS_COST_CD" ).append("\n"); 
		query.append("		FROM	(SELECT	LGS_COST_CD" ).append("\n"); 
		query.append("				, ROWNUM ROW_ID                                                     " ).append("\n"); 
		query.append("			FROM	TES_TML_SO_COST                                                                " ).append("\n"); 
		query.append("			WHERE	DECODE('ON','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG,      " ).append("\n"); 
		query.append("			                   'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'                      " ).append("\n"); 
		query.append("			AND	COST_CALC_MZD_CD = 'A'		                                                  " ).append("\n"); 
		query.append("			) Z                                                                                       " ).append("\n"); 
		query.append("		)                                                                                             " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1                                                          " ).append("\n"); 
		query.append("	START WITH ROW_ID = 1) ON_A_LGS_COST_CD,                                                      " ).append("\n"); 
		query.append("	(                                                                                             " ).append("\n"); 
		query.append("	SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')                                   " ).append("\n"); 
		query.append("	FROM	(                                                                                        " ).append("\n"); 
		query.append("		SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append("			, Z.LGS_COST_CD" ).append("\n"); 
		query.append("		FROM	(                                                " ).append("\n"); 
		query.append("			SELECT	LGS_COST_CD" ).append("\n"); 
		query.append("				, ROWNUM ROW_ID                                                     " ).append("\n"); 
		query.append("			FROM	TES_TML_SO_COST                                                                " ).append("\n"); 
		query.append("			WHERE	DECODE('OT','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG,      " ).append("\n"); 
		query.append("			                   'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'                      " ).append("\n"); 
		query.append("			AND	COST_CALC_MZD_CD = 'A'		                                                  " ).append("\n"); 
		query.append("			) Z                                                                                       " ).append("\n"); 
		query.append("		)                                                                                             " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1                                                          " ).append("\n"); 
		query.append("	START WITH ROW_ID = 1) OT_A_LGS_COST_CD,	                                                  " ).append("\n"); 
		query.append("	(                                                                                             " ).append("\n"); 
		query.append("	SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')                                   " ).append("\n"); 
		query.append("	FROM	(                                                                                        " ).append("\n"); 
		query.append("		SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append("			, Z.LGS_COST_CD" ).append("\n"); 
		query.append("		FROM	(                                                " ).append("\n"); 
		query.append("			SELECT	LGS_COST_CD" ).append("\n"); 
		query.append("				, ROWNUM ROW_ID                                                     " ).append("\n"); 
		query.append("			FROM	TES_TML_SO_COST                                                                " ).append("\n"); 
		query.append("			WHERE	DECODE('OS','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG,      " ).append("\n"); 
		query.append("			                   'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'                      " ).append("\n"); 
		query.append("			AND	COST_CALC_MZD_CD = 'A'		                                                  " ).append("\n"); 
		query.append("			) Z                                                                                       " ).append("\n"); 
		query.append("		)                                                                                             " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1                                                          " ).append("\n"); 
		query.append("	START WITH ROW_ID = 1) OS_A_LGS_COST_CD,	                                                  " ).append("\n"); 
		query.append("	(                                                                                             " ).append("\n"); 
		query.append("	SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')                                   " ).append("\n"); 
		query.append("	FROM	(                                                                                        " ).append("\n"); 
		query.append("		SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append("			, Z.LGS_COST_CD" ).append("\n"); 
		query.append("		FROM	(                                                " ).append("\n"); 
		query.append("			SELECT	LGS_COST_CD" ).append("\n"); 
		query.append("				, ROWNUM ROW_ID                                                     " ).append("\n"); 
		query.append("			FROM	TES_TML_SO_COST                                                                " ).append("\n"); 
		query.append("			WHERE	DECODE('ST','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG,      " ).append("\n"); 
		query.append("			                   'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'                      " ).append("\n"); 
		query.append("			AND	COST_CALC_MZD_CD = 'A'		                                                  " ).append("\n"); 
		query.append("			) Z                                                                                       " ).append("\n"); 
		query.append("		)                                                                                             " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1                                                          " ).append("\n"); 
		query.append("	START WITH ROW_ID = 1) ST_A_LGS_COST_CD,                                                      " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(CRR_CD,'|')),'|')" ).append("\n"); 
		query.append("	FROM	(" ).append("\n"); 
		query.append("		SELECT	CRR_CD" ).append("\n"); 
		query.append("			, ROWNUM ROW_ID" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("			SELECT	CRR_CD" ).append("\n"); 
		query.append("			FROM	MDM_CARRIER" ).append("\n"); 
		query.append("			WHERE	DELT_FLG = 'N'" ).append("\n"); 
		query.append("			ORDER BY CRR_CD" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("	) CARR_CD," ).append("\n"); 
		query.append("    (                                                                                                   " ).append("\n"); 
		query.append("	SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(EQ_TPSZ_CD,'|')),'|')                                        " ).append("\n"); 
		query.append("	FROM	(                                                                                              " ).append("\n"); 
		query.append("		SELECT	ROWNUM ROW_ID" ).append("\n"); 
		query.append("			, Z.EQ_TPSZ_CD" ).append("\n"); 
		query.append("		FROM	(SELECT	EQ_TPSZ_CD " ).append("\n"); 
		query.append("			FROM	CGM_EQ_TP_SZ" ).append("\n"); 
		query.append("			GROUP BY EQ_KND_CD,EQ_TPSZ_CD" ).append("\n"); 
		query.append("			ORDER BY  EQ_KND_CD desc, EQ_TPSZ_CD" ).append("\n"); 
		query.append("			) Z                                                                                             " ).append("\n"); 
		query.append("		)                                                                                                   " ).append("\n"); 
		query.append("	CONNECT BY PRIOR ROW_ID = ROW_ID - 1                                                          " ).append("\n"); 
		query.append("	START WITH ROW_ID = 1) EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}