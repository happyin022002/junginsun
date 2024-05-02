/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSDExchangeRateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSDExchangeRateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USD Exchange
	  * * History
	  * 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSDExchangeRateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSDExchangeRateUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_IHC_RT RTMN" ).append("\n"); 
		query.append("   SET ( GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_DG_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("             , GLINE_OVR_WGT_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_OVR_WGT_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , GLINE_OVR_WGT_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("          ) = " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT ROUND(ROUND(RT.GLINE_LOCL_CURR_20FT_AMT      / R.USD_LOCL_XCH_RT,2) ) AS COST_20FT" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_40FT_AMT      / R.USD_LOCL_XCH_RT,2) ) AS COST_40FT" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_45FT_AMT      / R.USD_LOCL_XCH_RT,2) ) AS COST_45FT -- 45' Cost 추가" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_DG_20FT_AMT   / R.USD_LOCL_XCH_RT,2) ) AS DG_20FT" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_DG_40FT_AMT   / R.USD_LOCL_XCH_RT,2) ) AS DG_40FT" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_DG_45FT_AMT   / R.USD_LOCL_XCH_RT,2) ) AS DG_45FT -- 45' Cost 추가" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_OVR_20FT_AMT  / R.USD_LOCL_XCH_RT,2) ) AS OV_20FT" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_OVR_40FT_AMT  / R.USD_LOCL_XCH_RT,2) ) AS OV_40FT" ).append("\n"); 
		query.append("                 , ROUND(ROUND(RT.GLINE_LOCL_CURR_OVR_45FT_AMT  / R.USD_LOCL_XCH_RT,2) ) AS OV_45FT -- 45' Cost 추가" ).append("\n"); 
		query.append("              FROM PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append("                 , GL_MON_XCH_RT R" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND RT.SVC_SCP_CD        = RTMN.SVC_SCP_CD" ).append("\n"); 
		query.append("               AND RT.ORG_DEST_TP_CD    = RTMN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               AND RT.IHC_TRF_NO        = RTMN.IHC_TRF_NO" ).append("\n"); 
		query.append("               AND RT.AMDT_SEQ          = RTMN.AMDT_SEQ" ).append("\n"); 
		query.append("               AND RT.IHC_CGO_TP_CD     = RTMN.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("               AND RT.RT_SEQ            = RTMN.RT_SEQ" ).append("\n"); 
		query.append("               AND RT.AMDT_SEQ          = RT.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("               AND R.CURR_CD            = RT.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND R.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("               AND R.ACCT_XCH_RT_YRMON = (  SELECT MAX(R.ACCT_XCH_RT_YRMON)" ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT R" ).append("\n"); 
		query.append("                                             WHERE R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                               AND DELT_FLG = 'N' ) " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND RTMN.SVC_SCP_CD      = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND RTMN.IHC_TRF_NO      = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND RTMN.AMDT_SEQ        = @[amdt_seq]" ).append("\n"); 
		query.append("   AND RTMN.ORG_DEST_TP_CD  = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND RTMN.AMDT_SEQ        = RTMN.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 

	}
}