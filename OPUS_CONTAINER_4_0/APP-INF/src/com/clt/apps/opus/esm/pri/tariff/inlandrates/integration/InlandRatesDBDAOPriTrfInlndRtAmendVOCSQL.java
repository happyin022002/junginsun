/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndRtAmendVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.21 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndRtAmendVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * amend 시 복사
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndRtAmendVOCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndRtAmendVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_INLND_RT (" ).append("\n"); 
		query.append("       TRF_PFX_CD" ).append("\n"); 
		query.append("     , TRF_NO" ).append("\n"); 
		query.append("     , TRF_INLND_SEQ" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("     , INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("     , INLND_RT_BSE_LOC_ZIP_CD" ).append("\n"); 
		query.append("     , INLND_RT_TERM_CD" ).append("\n"); 
		query.append("     , INLND_RT_VIA_LOC_CD" ).append("\n"); 
		query.append("     , PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , INLND_RT_LMT_WGT" ).append("\n"); 
		query.append("     , INLND_RT_MIN_LMT_WGT" ).append("\n"); 
		query.append("     , INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , INLND_BX_RT_AMT" ).append("\n"); 
		query.append("     , INLND_20FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_40FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("     , INLND_45FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_BX_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_20FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_40FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_45FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_RT_RMK" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TRF_PFX_CD" ).append("\n"); 
		query.append("     , TRF_NO" ).append("\n"); 
		query.append("     , TRF_INLND_SEQ" ).append("\n"); 
		query.append("     , AMDT_SEQ + 1" ).append("\n"); 
		query.append("     , TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("     , INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("     , INLND_RT_BSE_LOC_ZIP_CD" ).append("\n"); 
		query.append("     , INLND_RT_TERM_CD" ).append("\n"); 
		query.append("     , INLND_RT_VIA_LOC_CD" ).append("\n"); 
		query.append("     , PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , INLND_RT_LMT_WGT" ).append("\n"); 
		query.append("     , INLND_RT_MIN_LMT_WGT" ).append("\n"); 
		query.append("     , INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , INLND_BX_RT_AMT" ).append("\n"); 
		query.append("     , INLND_20FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_40FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("     , INLND_45FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_BX_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_20FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_40FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("     , INLND_ONE_WY_45FT_RT_AMT" ).append("\n"); 
		query.append("     , INLND_RT_RMK" ).append("\n"); 
		query.append("     , N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[cre_usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("  FROM PRI_TRF_INLND_RT" ).append("\n"); 
		query.append(" WHERE TRF_PFX_CD		= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND TRF_NO			= @[trf_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ			= @[amdt_seq] - 1" ).append("\n"); 
		query.append("   AND TRF_INLND_SEQ	= @[trf_inlnd_seq]" ).append("\n"); 
		query.append("   AND SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}