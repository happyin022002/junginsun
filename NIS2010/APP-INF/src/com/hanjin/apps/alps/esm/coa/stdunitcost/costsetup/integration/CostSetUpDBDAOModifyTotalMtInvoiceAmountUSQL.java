/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOModifyTotalMtInvoiceAmountUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.12.24 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOModifyTotalMtInvoiceAmountUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 데이터 수정
	  * </pre>
	  */
	public CostSetUpDBDAOModifyTotalMtInvoiceAmountUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOModifyTotalMtInvoiceAmountUSQL").append("\n"); 
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
		query.append("--================================" ).append("\n"); 
		query.append("-- SAVE - 데이터 변경시 TOTAL 비용 업데이트" ).append("\n"); 
		query.append("--================================" ).append("\n"); 
		query.append("MERGE INTO COA_MNL_COST_STUP A USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT @[cost_yrmon] AS COST_YRMON" ).append("\n"); 
		query.append("             , 'XX' AS COST_WK" ).append("\n"); 
		query.append("             , 'COM' AS TRD_CD" ).append("\n"); 
		query.append("             , 'MTYTT' AS RLANE_CD" ).append("\n"); 
		query.append("             , 'O' AS IOC_CD" ).append("\n"); 
		query.append("             , 'M' AS DIR_CD" ).append("\n"); 
		query.append("             , 'OT' AS SUB_TRD_CD" ).append("\n"); 
		query.append("             , SUM(MTY_TML_MNL_AMT) + SUM(MTY_TRSP_MNL_AMT) AS OTR_EXPN_AMT" ).append("\n"); 
		query.append("          FROM COA_MTY_REPO_COST_DTL" ).append("\n"); 
		query.append("         WHERE COST_YRMON 	= @[cost_yrmon]" ).append("\n"); 
		query.append("           AND APLY_ADJ_PL_FLG = 'Y'" ).append("\n"); 
		query.append(") B ON ( A.COST_YRMON = B.COST_YRMON " ).append("\n"); 
		query.append("        AND A.COST_WK = B.COST_WK " ).append("\n"); 
		query.append("        AND A.TRD_CD = B.TRD_CD " ).append("\n"); 
		query.append("        AND A.RLANE_CD = B.RLANE_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET A.OTR_EXPN_AMT     = B.OTR_EXPN_AMT" ).append("\n"); 
		query.append("           , A.UPD_USR_ID       = @[user_id]" ).append("\n"); 
		query.append("           , A.UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("          A.COST_YRMON" ).append("\n"); 
		query.append("        , A.COST_WK" ).append("\n"); 
		query.append("        , A.TRD_CD" ).append("\n"); 
		query.append("        , A.RLANE_CD" ).append("\n"); 
		query.append("        , A.IOC_CD" ).append("\n"); 
		query.append("        , A.DIR_CD" ).append("\n"); 
		query.append("        , A.SUB_TRD_CD" ).append("\n"); 
		query.append("        , A.OTR_EXPN_AMT" ).append("\n"); 
		query.append("        , A.CRE_USR_ID" ).append("\n"); 
		query.append("        , A.CRE_DT" ).append("\n"); 
		query.append("        , A.UPD_USR_ID" ).append("\n"); 
		query.append("        , A.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("          B.COST_YRMON" ).append("\n"); 
		query.append("        , B.COST_WK" ).append("\n"); 
		query.append("        , B.TRD_CD" ).append("\n"); 
		query.append("        , B.RLANE_CD" ).append("\n"); 
		query.append("        , B.IOC_CD" ).append("\n"); 
		query.append("        , B.DIR_CD" ).append("\n"); 
		query.append("        , B.SUB_TRD_CD" ).append("\n"); 
		query.append("        , B.OTR_EXPN_AMT" ).append("\n"); 
		query.append("        , @[user_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[user_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}