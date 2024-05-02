/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOTesManualCancellationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOTesManualCancellationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select TesManualCancellation
	  * </pre>
	  */
	public StatementCommonDBDAOTesManualCancellationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cancel_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOTesManualCancellationRSQL").append("\n"); 
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
		query.append("SELECT  VVD         VVD" ).append("\n"); 
		query.append("      , YARD        YARD_CODE" ).append("\n"); 
		query.append("      , TO_CHAR(ACT_DT, 'YYYY-MM') 	ACT_DT" ).append("\n"); 
		query.append("      , VNDR        VENDOR_CODE" ).append("\n"); 
		query.append("      , CST         COST_CODE" ).append("\n"); 
		query.append("      , SUM(ESTM_QTY) ESTM_QTY" ).append("\n"); 
		query.append("      , SUM(ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("      , SUM(ACT_QTY)  ACT_QTY" ).append("\n"); 
		query.append("      , SUM(ACT_AMT)  ACT_AMT" ).append("\n"); 
		query.append("      , SUM(ACCL_QTY) ACCL_QTY" ).append("\n"); 
		query.append("      , SUM(ACCL_AMT) ACCL_AMT" ).append("\n"); 
		query.append("      , MAX(CXL_FLG)  CANCEL_FLAG" ).append("\n"); 
		query.append("      , MIN(REV_YRMON) AS REV_YRMON" ).append("\n"); 
		query.append("      , MIN(ACCT_CD) AS  ACCT_CD" ).append("\n"); 
		query.append("      , MIN(ACCL_SEQ) AS ACCL_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD AS VVD " ).append("\n"); 
		query.append("              , NOD_CD                  AS  YARD" ).append("\n"); 
		query.append("              , VNDR_NO                 AS  VNDR" ).append("\n"); 
		query.append("              , COA_COST_SRC_CD         AS  CST" ).append("\n"); 
		query.append("              , ESTM_QTY                AS  ESTM_QTY" ).append("\n"); 
		query.append("              , ESTM_COST_AMT           AS  ESTM_AMT" ).append("\n"); 
		query.append("              , ACT_QTY                 AS  ACT_QTY" ).append("\n"); 
		query.append("              , ACT_COST_AMT            AS  ACT_AMT" ).append("\n"); 
		query.append("              , ACCL_QTY                AS  ACCL_QTY" ).append("\n"); 
		query.append("              , ACCL_COST_AMT           AS  ACCL_AMT" ).append("\n"); 
		query.append("              , CXL_FLG                 AS  CXL_FLG" ).append("\n"); 
		query.append("              , ACT_DT                  AS  ACT_DT" ).append("\n"); 
		query.append("              , UPD_DT                  AS  UPD_DT" ).append("\n"); 
		query.append("              --, ROW_NUMBER() OVER (PARTITION BY VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD,NOD_CD ORDER BY UPD_DT DESC) ROW_SEQ" ).append("\n"); 
		query.append("              , REV_YRMON               AS  REV_YRMON" ).append("\n"); 
		query.append("              , ACCT_CD                 AS  ACCT_CD" ).append("\n"); 
		query.append("              , ACCL_SEQ                AS  ACCL_SEQ" ).append("\n"); 
		query.append("        FROM    SAC_TML_ACCL_COST_IF    ACCL" ).append("\n"); 
		query.append("        WHERE   ACCL.EXE_YRMON = @[exe_month]" ).append("\n"); 
		query.append("        AND     ACCL.SYS_SRC_ID = 'TES'" ).append("\n"); 
		query.append("        AND     NVL(CXL_FLG, 'N') = @[cancel_flg]" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("        AND     VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD LIKE @[vvd]|| '%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} != '')" ).append("\n"); 
		query.append("        AND     NOD_CD LIKE @[yd_cd] || '%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) TML_ACCL" ).append("\n"); 
		query.append("GROUP   BY VVD, YARD, VNDR, CST, TO_CHAR(ACT_DT, 'YYYY-MM')" ).append("\n"); 
		query.append("ORDER   BY VVD, YARD, ACT_DT, VNDR, CST" ).append("\n"); 

	}
}