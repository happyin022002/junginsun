/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USDomesticDBDAODomesticStatusMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.05.08 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAODomesticStatusMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Domestic Saving Credit 월 단가 복사
	  * </pre>
	  */
	public USDomesticDBDAODomesticStatusMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAODomesticStatusMonthCopyCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_UT_COST_CRE_STS A1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT @[f_tar_mon] COST_YRMON" ).append("\n"); 
		query.append("      , ( SELECT MIN(COST_WK) FROM MAS_WK_PRD WHERE SLS_FM_DT LIKE @[f_tar_mon]||'%' ) COST_WK" ).append("\n"); 
		query.append("      , CM_UC_CD" ).append("\n"); 
		query.append("      , COST_CRE_STS_CD" ).append("\n"); 
		query.append("      , COST_IF_STS_CD" ).append("\n"); 
		query.append("      , COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("      , COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("      , @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE CRE_DT" ).append("\n"); 
		query.append("      , @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE UPD_DT" ).append("\n"); 
		query.append("   FROM MAS_UT_COST_CRE_STS" ).append("\n"); 
		query.append("  WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 
		query.append("    AND CM_UC_CD   = 'USDM'" ).append("\n"); 
		query.append(") A2 " ).append("\n"); 
		query.append("  ON ( A1.COST_YRMON = A2.COST_YRMON AND A1.CM_UC_CD = A2.CM_UC_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("            SET A1.COST_WK           = A2.COST_WK" ).append("\n"); 
		query.append("              , A1.COST_CRE_STS_CD   = A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("              , A1.COST_IF_STS_CD    = A2.COST_IF_STS_CD" ).append("\n"); 
		query.append("              , A1.COST_SRC_FM_YRMON = A2.COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("              , A1.COST_SRC_TO_YRMON = A2.COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("              , A1.UPD_USR_ID        = A2.UPD_USR_ID" ).append("\n"); 
		query.append("              , A1.UPD_DT            = A2.UPD_DT " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("         INSERT (" ).append("\n"); 
		query.append("                A1.COST_YRMON" ).append("\n"); 
		query.append("              , A1.COST_WK" ).append("\n"); 
		query.append("              , A1.CM_UC_CD" ).append("\n"); 
		query.append("              , A1.COST_CRE_STS_CD" ).append("\n"); 
		query.append("              , A1.COST_IF_STS_CD" ).append("\n"); 
		query.append("              , A1.COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("              , A1.COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("              , A1.CRE_USR_ID" ).append("\n"); 
		query.append("              , A1.CRE_DT" ).append("\n"); 
		query.append("              , A1.UPD_USR_ID" ).append("\n"); 
		query.append("              , A1.UPD_DT ) " ).append("\n"); 
		query.append("         VALUES (" ).append("\n"); 
		query.append("                A2.COST_YRMON" ).append("\n"); 
		query.append("              , A2.COST_WK" ).append("\n"); 
		query.append("              , A2.CM_UC_CD" ).append("\n"); 
		query.append("              , A2.COST_CRE_STS_CD" ).append("\n"); 
		query.append("              , A2.COST_IF_STS_CD" ).append("\n"); 
		query.append("              , A2.COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("              , A2.COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("              , A2.CRE_USR_ID" ).append("\n"); 
		query.append("              , A2.CRE_DT" ).append("\n"); 
		query.append("              , A2.UPD_USR_ID" ).append("\n"); 
		query.append("              , A2.UPD_DT )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}