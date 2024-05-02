/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.29 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndRtVORSQL(){
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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndRtVORSQL").append("\n"); 
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
		query.append("SELECT TRF_PFX_CD" ).append("\n"); 
		query.append("	   , TRF_NO" ).append("\n"); 
		query.append("	   , TRF_INLND_SEQ" ).append("\n"); 
		query.append("	   , AMDT_SEQ" ).append("\n"); 
		query.append("	   , TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("	   , INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_BSE_LOC_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_BSE_LOC_NM" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_BSE_LOC_NM_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_BSE_LOC_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_BSE_LOC_ZIP_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_BSE_LOC_ZIP_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_TERM_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_TERM_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_VIA_LOC_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_VIA_LOC_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS PRC_INLND_RT_TRSP_MOD_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_LMT_WGT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_LMT_WGT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_MIN_LMT_WGT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_MIN_LMT_WGT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_LMT_WGT_UT_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS PRC_CGO_TP_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , CURR_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS CURR_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_BX_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_BX_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_20FT_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_20FT_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_40FT_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_40FT_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_40FT_HC_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_45FT_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_45FT_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_ONE_WY_BX_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_ONE_WY_BX_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_ONE_WY_20FT_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_ONE_WY_20FT_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_ONE_WY_40FT_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_ONE_WY_40FT_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_ONE_WY_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_ONE_WY_40FT_HC_RT_AMT_PP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_ONE_WY_45FT_RT_AMT" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_ONE_WY_45FT_RT_AMT_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , INLND_RT_RMK" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS INLND_RT_RMK_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	   , SRC_INFO_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN 'edit:false;'" ).append("\n"); 
		query.append("			  ELSE '' END AS SRC_INFO_CD_PROP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , CRE_USR_ID" ).append("\n"); 
		query.append("	   , CRE_DT" ).append("\n"); 
		query.append("	   , UPD_USR_ID" ).append("\n"); 
		query.append("	   , UPD_DT" ).append("\n"); 
		query.append("	   , INPUT_FLG" ).append("\n"); 
		query.append("	   , COLOR_FLG" ).append("\n"); 
		query.append("	   , TRF_INLND_STS_CD" ).append("\n"); 
		query.append("	   , RQST_OFC_CD" ).append("\n"); 
		query.append("	   , CASE WHEN INPUT_FLG = 'D1' THEN 'edit:false;FontStrikethru=''TRUE'';'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'E0' AND COLOR_FLG = 'R' THEN 'color:red;'" ).append("\n"); 
		query.append("			  WHEN (TRF_INLND_STS_CD != 'I' OR RQST_OFC_CD != @[etc2]) AND INPUT_FLG = 'E0' AND COLOR_FLG = 'R' THEN 'edit:false;color:red;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'E0' AND COLOR_FLG = 'B' THEN ''" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'color:red;'" ).append("\n"); 
		query.append("			  WHEN (TRF_INLND_STS_CD != 'I' OR RQST_OFC_CD != @[etc2]) AND INPUT_FLG = 'D0' AND COLOR_FLG = 'R' THEN 'color:red;edit:false;'" ).append("\n"); 
		query.append("			  WHEN TRF_INLND_STS_CD = 'I' AND RQST_OFC_CD = @[etc2] AND INPUT_FLG = 'D0' AND COLOR_FLG = 'B' THEN ''" ).append("\n"); 
		query.append("			  ELSE 'edit:false;' END AS ROW_PROPERTIES" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append("		 , A.TRF_NO" ).append("\n"); 
		query.append("		 , A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("		 , A.AMDT_SEQ" ).append("\n"); 
		query.append("		 , A.TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("		 , A.INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("		 , (SELECT LOC_NM FROM MDM_LOCATION" ).append("\n"); 
		query.append("			 WHERE LOC_CD = A.INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("			   AND DELT_FLG = 'N') INLND_RT_BSE_LOC_NM" ).append("\n"); 
		query.append("		 , A.INLND_RT_BSE_LOC_ZIP_CD" ).append("\n"); 
		query.append("		 , A.INLND_RT_TERM_CD" ).append("\n"); 
		query.append("		 , A.INLND_RT_VIA_LOC_CD" ).append("\n"); 
		query.append("		 , A.PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("		 , A.INLND_RT_LMT_WGT" ).append("\n"); 
		query.append("		 , A.INLND_RT_MIN_LMT_WGT" ).append("\n"); 
		query.append("		 , A.INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("		 , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		 , A.CURR_CD" ).append("\n"); 
		query.append("		 , A.INLND_BX_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_20FT_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_40FT_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_45FT_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_ONE_WY_BX_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_ONE_WY_20FT_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_ONE_WY_40FT_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_ONE_WY_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_ONE_WY_45FT_RT_AMT" ).append("\n"); 
		query.append("		 , A.INLND_RT_RMK" ).append("\n"); 
		query.append("		 , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("		 , A.SRC_INFO_CD" ).append("\n"); 
		query.append("		 , A.CRE_USR_ID" ).append("\n"); 
		query.append("		 , A.CRE_DT" ).append("\n"); 
		query.append("		 , A.UPD_USR_ID" ).append("\n"); 
		query.append("		 , A.UPD_DT" ).append("\n"); 
		query.append("		 , M.TRF_INLND_STS_CD" ).append("\n"); 
		query.append("		 , M.RQST_OFC_CD" ).append("\n"); 
		query.append("		 , CASE WHEN A.AMDT_SEQ = @[amdt_seq] AND A.AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ AND M.TRF_INLND_STS_CD = 'I' AND A.SRC_INFO_CD IN ('NW', 'AM') THEN 'E0'" ).append("\n"); 
		query.append("				WHEN A.AMDT_SEQ = @[amdt_seq] - 1 THEN 'D1'" ).append("\n"); 
		query.append("				ELSE 'D0' END AS INPUT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 , CASE WHEN A.AMDT_SEQ > 0 AND A.AMDT_SEQ = @[amdt_seq] AND A.AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ THEN 'R'" ).append("\n"); 
		query.append("				ELSE 'B' END AS COLOR_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  FROM PRI_TRF_INLND_RT A" ).append("\n"); 
		query.append("		 , PRI_TRF_INLND M" ).append("\n"); 
		query.append("	 WHERE A.TRF_PFX_CD 		= M.TRF_PFX_CD" ).append("\n"); 
		query.append("	   AND A.TRF_NO 			= M.TRF_NO" ).append("\n"); 
		query.append("	   AND A.TRF_INLND_SEQ 		= M.TRF_INLND_SEQ" ).append("\n"); 
		query.append("	   AND A.TRF_PFX_CD			= @[trf_pfx_cd]" ).append("\n"); 
		query.append("	   AND A.TRF_NO       		= @[trf_no]" ).append("\n"); 
		query.append("	   AND A.TRF_INLND_SEQ   	= @[trf_inlnd_seq]" ).append("\n"); 
		query.append("	   AND M.AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 
		query.append("	   AND A.AMDT_SEQ IN ( @[amdt_seq], @[amdt_seq] - 1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_view_yn} == 'Y') " ).append("\n"); 
		query.append("	   AND ( A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD = 'AD'" ).append("\n"); 
		query.append("		   OR ( A.AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 
		query.append("				AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("				AND EXISTS (      SELECT 'X'  FROM PRI_TRF_INLND_RT B" ).append("\n"); 
		query.append("                                     WHERE B.TRF_PFX_CD			= A.TRF_PFX_CD" ).append("\n"); 
		query.append("                                       AND B.TRF_NO       		= A.TRF_NO" ).append("\n"); 
		query.append("                                       AND B.TRF_INLND_SEQ   	= A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("                                       AND B.AMDT_SEQ			= @[amdt_seq] - 1" ).append("\n"); 
		query.append("                                       AND B.TRF_INLND_RT_SEQ IN (" ).append("\n"); 
		query.append("                                        SELECT TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("                                          FROM PRI_TRF_INLND_RT" ).append("\n"); 
		query.append("                                         WHERE TRF_PFX_CD         	= A.TRF_PFX_CD" ).append("\n"); 
		query.append("                                           AND TRF_NO      			= A.TRF_NO" ).append("\n"); 
		query.append("                                           AND TRF_INLND_SEQ     	= A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("                                           AND TRF_INLND_RT_SEQ 	= A.TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("                                           AND AMDT_SEQ        		= @[amdt_seq]" ).append("\n"); 
		query.append("                                           AND N1ST_CMNC_AMDT_SEQ	= @[amdt_seq]" ).append("\n"); 
		query.append("                                           AND SRC_INFO_CD          = 'AD' )" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	   AND ( A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("		   OR ( A.AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 
		query.append("				AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("				AND  EXISTS ( " ).append("\n"); 
		query.append("                                     SELECT 'X'  FROM PRI_TRF_INLND_RT B" ).append("\n"); 
		query.append("                                     WHERE B.TRF_PFX_CD			= A.TRF_PFX_CD" ).append("\n"); 
		query.append("                                       AND B.TRF_NO       		= A.TRF_NO" ).append("\n"); 
		query.append("                                       AND B.TRF_INLND_SEQ   	= A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("                                       AND B.AMDT_SEQ			= @[amdt_seq] - 1" ).append("\n"); 
		query.append("                                       AND B.TRF_INLND_RT_SEQ IN (" ).append("\n"); 
		query.append("                                        SELECT TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("                                          FROM PRI_TRF_INLND_RT" ).append("\n"); 
		query.append("                                         WHERE TRF_PFX_CD         	= A.TRF_PFX_CD" ).append("\n"); 
		query.append("                                           AND TRF_NO      			= A.TRF_NO" ).append("\n"); 
		query.append("                                           AND TRF_INLND_SEQ     	= A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("                                           AND TRF_INLND_RT_SEQ 	= A.TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("                                           AND AMDT_SEQ        		= @[amdt_seq]" ).append("\n"); 
		query.append("                                           AND N1ST_CMNC_AMDT_SEQ	= @[amdt_seq]" ).append("\n"); 
		query.append("                                           AND SRC_INFO_CD          <> 'AD' )" ).append("\n"); 
		query.append("								 )" ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("		   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 ORDER BY FIRST_VALUE(INLND_RT_BSE_LOC_NM) OVER ( PARTITION BY A.TRF_INLND_RT_SEQ ORDER BY A.AMDT_SEQ ), A.TRF_INLND_RT_SEQ, A.AMDT_SEQ" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}