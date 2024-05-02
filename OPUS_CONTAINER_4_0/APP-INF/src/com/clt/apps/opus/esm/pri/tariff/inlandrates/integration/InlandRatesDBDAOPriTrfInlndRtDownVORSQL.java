/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndRtDownVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.14 최성민
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

public class InlandRatesDBDAOPriTrfInlndRtDownVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Excel download 를 위한 조회
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndRtDownVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndRtDownVORSQL").append("\n"); 
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
		query.append("SELECT A.TRF_PFX_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , A.TRF_INLND_SEQ" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.TRF_INLND_RT_SEQ" ).append("\n"); 
		query.append("     , A.INLND_RT_BSE_LOC_CD" ).append("\n"); 
		query.append("     , (SELECT LOC_NM FROM MDM_LOCATION " ).append("\n"); 
		query.append("	 	 WHERE LOC_CD = A.INLND_RT_BSE_LOC_CD " ).append("\n"); 
		query.append("	   	   AND DELT_FLG = 'N') INLND_RT_BSE_LOC_NM" ).append("\n"); 
		query.append("     , A.INLND_RT_BSE_LOC_ZIP_CD" ).append("\n"); 
		query.append("     , A.INLND_RT_TERM_CD" ).append("\n"); 
		query.append("     , A.INLND_RT_VIA_LOC_CD" ).append("\n"); 
		query.append("     , A.PRC_INLND_RT_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , A.INLND_RT_LMT_WGT" ).append("\n"); 
		query.append("     , A.INLND_RT_MIN_LMT_WGT" ).append("\n"); 
		query.append("     , A.INLND_RT_LMT_WGT_UT_CD" ).append("\n"); 
		query.append("     , A.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.INLND_BX_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_20FT_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_40FT_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_45FT_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_ONE_WY_BX_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_ONE_WY_20FT_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_ONE_WY_40FT_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_ONE_WY_40FT_HC_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_ONE_WY_45FT_RT_AMT" ).append("\n"); 
		query.append("     , A.INLND_RT_RMK" ).append("\n"); 
		query.append("     , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SRC_INFO_CD" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_TRF_INLND_RT A" ).append("\n"); 
		query.append(" WHERE A.TRF_PFX_CD			= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND A.TRF_NO       		= @[trf_no]" ).append("\n"); 
		query.append("   AND A.TRF_INLND_SEQ   	= @[trf_inlnd_seq]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append(" ORDER BY INLND_RT_BSE_LOC_NM, A.TRF_INLND_RT_SEQ" ).append("\n"); 

	}
}