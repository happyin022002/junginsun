/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchFmsVvdByFletCtrtNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchFmsVvdByFletCtrtNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TI/TO 에 따른 VVD 조회.
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchFmsVvdByFletCtrtNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration ").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchFmsVvdByFletCtrtNoRSQL").append("\n"); 
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
		query.append("SELECT LISTAGG (A.VVD_CD, '|') WITHIN GROUP ( ORDER BY A.VVD_CD) AS VVD_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT A.VVD_CD" ).append("\n"); 
		query.append("             , A.VST_DT" ).append("\n"); 
		query.append("             , A.VED_DT" ).append("\n"); 
		query.append("             , A.FLET_CTRT_NO" ).append("\n"); 
		query.append("             , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , A.COM_VVD_FLG" ).append("\n"); 
		query.append("             , CASE WHEN A.COM_VVD_FLG = 'Y' AND A.FLET_CTRT_TP_CD = 'TO' THEN A.FLET_CTRT_NO" ).append("\n"); 
		query.append("                    WHEN A.COM_VVD_FLG = 'N' AND A.FLET_CTRT_TP_CD = 'TI' THEN A.FLET_CTRT_NO" ).append("\n"); 
		query.append("                    ELSE NULL" ).append("\n"); 
		query.append("               END AS EXIST_FLET_CTRT_NO /*TO-Y : 공통 선박, TI-N : 공통 선박이 아닌 선박.*/" ).append("\n"); 
		query.append("          FROM (SELECT FV.VSL_CD || FV.SKD_VOY_NO || FV.SKD_DIR_CD || FV.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("                     , FV.VST_DT" ).append("\n"); 
		query.append("                     , FV.VED_DT" ).append("\n"); 
		query.append("                     , FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , FC.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                     , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                  FROM MDM_REV_LANE M" ).append("\n"); 
		query.append("                                 WHERE M.REP_TRD_CD = 'COM'" ).append("\n"); 
		query.append("                                   AND M.RLANE_CD = FV.RLANE_CD),'N') AS COM_VVD_FLG" ).append("\n"); 
		query.append("                  FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("                     , FMS_VVD FV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                   AND FC.VSL_CD = FV.VSL_CD" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT FV.VSL_CD || FV.SKD_VOY_NO || FV.SKD_DIR_CD || FV.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("                     , FV.VST_DT" ).append("\n"); 
		query.append("                     , FV.VED_DT" ).append("\n"); 
		query.append("                     , FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , SUBSTR(FI.FLET_CTRT_NO, 5,2) AS FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                     , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE M" ).append("\n"); 
		query.append("                             WHERE M.REP_TRD_CD = 'COM'" ).append("\n"); 
		query.append("                               AND M.RLANE_CD = FV.RLANE_CD),'N') AS COM_VVD_FLG" ).append("\n"); 
		query.append("                  FROM FMS_ID_VSL FI" ).append("\n"); 
		query.append("                     , FMS_VVD FV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND FI.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("                   AND FI.USE_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND FI.VSL_CD = FV.VSL_CD " ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND (CASE WHEN A.COM_VVD_FLG = 'Y' AND A.FLET_CTRT_TP_CD = 'TO' THEN A.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     WHEN A.COM_VVD_FLG = 'N' AND A.FLET_CTRT_TP_CD = 'TI' THEN A.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     ELSE NULL" ).append("\n"); 
		query.append("                END) IS NOT NULL" ).append("\n"); 
		query.append("           AND REPLACE(@[eff_dt],'-','') BETWEEN A.VST_DT AND A.VED_DT " ).append("\n"); 
		query.append("    ) A" ).append("\n"); 

	}
}