/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndInquiryRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndInquiryRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland Rates Location을 조회한다.
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndInquiryRtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndInquiryRtVORSQL").append("\n"); 
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
		query.append("SELECT  TRF_PFX_CD" ).append("\n"); 
		query.append("       ,TRF_NO" ).append("\n"); 
		query.append("       ,TRF_INLND_SEQ" ).append("\n"); 
		query.append("       ,AMDT_SEQ" ).append("\n"); 
		query.append("       ,TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("       ,INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  LOC_NM" ).append("\n"); 
		query.append("          FROM  MDM_LOCATION" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  LOC_CD   = INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("           AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("        ) AS INLND_RT_BSE_LOC_NM" ).append("\n"); 
		query.append("       ,INLND_RT_BSE_LOC_ZIP_CD" ).append("\n"); 
		query.append("--       ,INLND_RT_TERM_CD" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  INTG_CD_ID = 'CD01725'" ).append("\n"); 
		query.append("           AND  INTG_CD_VAL_CTNT = INLND_RT_TERM_CD" ).append("\n"); 
		query.append("        ) AS INLND_RT_TERM_CD" ).append("\n"); 
		query.append("       ,INLND_RT_VIA_LOC_CD" ).append("\n"); 
		query.append("--       ,PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  INTG_CD_ID = 'CD02772'" ).append("\n"); 
		query.append("           AND  INTG_CD_VAL_CTNT = PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("        ) AS PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("	   ,INLND_RT_MIN_LMT_WGT" ).append("\n"); 
		query.append("       ,INLND_RT_LMT_WGT" ).append("\n"); 
		query.append("       ,INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("--       ,(" ).append("\n"); 
		query.append("--        SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("--          FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("--         WHERE  1 = 1" ).append("\n"); 
		query.append("--           AND  INTG_CD_ID = 'CD02764'" ).append("\n"); 
		query.append("--           AND  INTG_CD_VAL_CTNT = INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("--        ) AS INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("       ,PRC_CGO_TP_CD" ).append("\n"); 
		query.append("--       ,(" ).append("\n"); 
		query.append("--        SELECT  INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("--          FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("--         WHERE  1 = 1" ).append("\n"); 
		query.append("--           AND  INTG_CD_ID = 'CD01701'" ).append("\n"); 
		query.append("--           AND  INTG_CD_VAL_CTNT = PRC_CGO_TP_CD" ).append("\n"); 
		query.append("--        ) AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("       ,CURR_CD" ).append("\n"); 
		query.append("       ,INLND_ONE_WY_BX_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_ONE_WY_20FT_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_ONE_WY_40FT_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_ONE_WY_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_ONE_WY_45FT_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_BX_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_20FT_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_40FT_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_45FT_RT_AMT" ).append("\n"); 
		query.append("       ,INLND_RT_RMK" ).append("\n"); 
		query.append("  FROM  PRI_TRF_INLND_RT RT" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  TRF_PFX_CD    = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  TRF_NO        = @[trf_no]" ).append("\n"); 
		query.append("   AND  TRF_INLND_SEQ = @[trf_inlnd_seq]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ      = @[amdt_seq]" ).append("\n"); 
		query.append("   AND  SRC_INFO_CD   <> 'AD'" ).append("\n"); 
		query.append("ORDER BY FIRST_VALUE(INLND_RT_BSE_LOC_NM) OVER ( PARTITION BY RT.TRF_INLND_RT_SEQ ORDER BY RT.AMDT_SEQ ), RT.TRF_INLND_RT_SEQ, RT.AMDT_SEQ" ).append("\n"); 

	}
}