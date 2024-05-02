/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailLocalDiffUSQL.java
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

public class IHCGuideLineDBDAOModifyIHCGuidelineDetailLocalDiffUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Local Diff
	  * * History
	  * 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public IHCGuideLineDBDAOModifyIHCGuidelineDetailLocalDiffUSQL(){
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
		query.append("FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailLocalDiffUSQL").append("\n"); 
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
		query.append("UPDATE /*+ bypass_ujvc */" ).append("\n"); 
		query.append("(           " ).append("\n"); 
		query.append("       SELECT DECODE(IHC.OPTM_TRSP_MOD_FLG,'N',DECODE(SUBSTR(CALC_20FT_FRT_RT_AMT,1,1),'Y',TO_NUMBER(REPLACE(CALC_20FT_FRT_RT_AMT,'Y','')))+IHC.LOCL_CURR_COST_20FT_FRT_RT_AMT,IHC.GLINE_LOCL_CURR_20FT_AMT) CALC_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             ,DECODE(IHC.OPTM_TRSP_MOD_FLG,'N',DECODE(SUBSTR(CALC_40FT_FRT_RT_AMT,1,1),'Y',TO_NUMBER(REPLACE(CALC_40FT_FRT_RT_AMT,'Y','')))+IHC.LOCL_CURR_COST_40FT_FRT_RT_AMT,IHC.GLINE_LOCL_CURR_40FT_AMT) CALC_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             -- 45' Cost 추가" ).append("\n"); 
		query.append("             ,DECODE(IHC.OPTM_TRSP_MOD_FLG,'N',DECODE(SUBSTR(CALC_45FT_FRT_RT_AMT,1,1),'Y',TO_NUMBER(REPLACE(CALC_45FT_FRT_RT_AMT,'Y','')))+IHC.LOCL_CURR_COST_45FT_FRT_RT_AMT,IHC.GLINE_LOCL_CURR_45FT_AMT) CALC_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("             , UPD_IHC.*" ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("         SELECT MAX( OPTM_TRSP_MOD_FLG||(GLINE_LOCL_CURR_20FT_AMT-LOCL_CURR_COST_20FT_FRT_RT_AMT) ) OVER(PARTITION BY PNT_LOC_CD, BSE_PORT_LOC_CD  )  AS CALC_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("               ,MAX( OPTM_TRSP_MOD_FLG||(GLINE_LOCL_CURR_40FT_AMT-LOCL_CURR_COST_40FT_FRT_RT_AMT) ) OVER(PARTITION BY PNT_LOC_CD, BSE_PORT_LOC_CD  )  AS CALC_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("               ,MAX( OPTM_TRSP_MOD_FLG||(GLINE_LOCL_CURR_45FT_AMT-LOCL_CURR_COST_45FT_FRT_RT_AMT) ) OVER(PARTITION BY PNT_LOC_CD, BSE_PORT_LOC_CD  )  AS CALC_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("           ,IHC.*" ).append("\n"); 
		query.append("         FROM PRI_TRF_IHC_RT IHC" ).append("\n"); 
		query.append("         WHERE SVC_SCP_CD = @[svc_scp_cd] AND IHC_TRF_NO = @[ihc_trf_no]  AND AMDT_SEQ = @[amdt_seq] AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("         ORDER BY PNT_LOC_CD,BSE_PORT_LOC_CD,OPTM_TRSP_MOD_FLG DESC" ).append("\n"); 
		query.append("       )  IHC" ).append("\n"); 
		query.append("       , PRI_TRF_IHC_RT UPD_IHC" ).append("\n"); 
		query.append("       WHERE UPD_IHC.SVC_SCP_CD = @[svc_scp_cd] AND UPD_IHC.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("         AND UPD_IHC.AMDT_SEQ = @[amdt_seq]     AND UPD_IHC.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("         AND IHC.SVC_SCP_CD = UPD_IHC.SVC_SCP_CD" ).append("\n"); 
		query.append("         AND IHC.IHC_TRF_NO = UPD_IHC.IHC_TRF_NO" ).append("\n"); 
		query.append("         AND IHC.AMDT_SEQ = UPD_IHC.AMDT_SEQ" ).append("\n"); 
		query.append("         AND IHC.RT_SEQ = UPD_IHC.RT_SEQ" ).append("\n"); 
		query.append("         AND IHC.ORG_DEST_TP_CD = UPD_IHC.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("         AND IHC.IHC_CGO_TP_CD = UPD_IHC.IHC_CGO_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET GLINE_LOCL_CURR_20FT_AMT = DECODE(OPTM_TRSP_MOD_FLG,'Y',GLINE_LOCL_CURR_20FT_AMT, CALC_20FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("  , GLINE_LOCL_CURR_40FT_AMT = DECODE(OPTM_TRSP_MOD_FLG,'Y',GLINE_LOCL_CURR_40FT_AMT, CALC_40FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("  , GLINE_LOCL_CURR_45FT_AMT = DECODE(OPTM_TRSP_MOD_FLG,'Y',GLINE_LOCL_CURR_45FT_AMT, CALC_45FT_FRT_RT_AMT) -- 45' Cost 추가" ).append("\n"); 

	}
}