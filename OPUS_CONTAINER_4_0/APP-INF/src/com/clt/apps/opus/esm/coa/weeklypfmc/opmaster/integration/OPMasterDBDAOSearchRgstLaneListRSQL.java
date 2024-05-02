/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OPMasterDBDAOSearchRgstLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOSearchRgstLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRgstLaneList SELECT
	  * </pre>
	  */
	public OPMasterDBDAOSearchRgstLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchRgstLaneListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      TRD_CD                                TRD_CD" ).append("\n"); 
		query.append("    , SUB_TRD_CD                            SUB_TRD_CD" ).append("\n"); 
		query.append("    , SLAN_CD                               SLAN_CD" ).append("\n"); 
		query.append("    , RLANE_CD                              RLANE_CD" ).append("\n"); 
		query.append("    , DIR_CD                                DIR_CD" ).append("\n"); 
		query.append("    , IOC_CD                                IOC_CD" ).append("\n"); 
		query.append("    , VSL_LANE_TP_CD                        VSL_LANE_TP_CD" ).append("\n"); 
		query.append("    , DECODE(STUP_FLG,'Y','1','0')          STUP_FLG" ).append("\n"); 
		query.append("    , DECODE(SCTR_PRC_FLG, 'Y','1','0')     SCTR_PRC_FLG" ).append("\n"); 
		query.append("    , TRNS_PCF_FLG                          TRNS_PCF_FLG" ).append("\n"); 
		query.append("    , EUR_FLG                               EUR_FLG" ).append("\n"); 
		query.append("    , TRNS_ATLAN_FLG                        TRNS_ATLAN_FLG" ).append("\n"); 
		query.append("    , INTR_ASIA_FLG                         INTR_ASIA_FLG" ).append("\n"); 
		query.append("    , TRNK_IPT_FLG                          TRNK_IPT_FLG" ).append("\n"); 
		query.append("	, PNDLM_LANE_FLG						PNDLM_LANE_FLG" ).append("\n"); 
		query.append("    , SUB_TRD_DESC                          SUB_TRD_DESC" ).append("\n"); 
		query.append("    , DELT_FLG                              DELT_FLG" ).append("\n"); 
		query.append("    , DECODE(LOD_SPL_CNG_FLG,'Y','1','0')   LOD_SPL_CNG_FLG" ).append("\n"); 
		query.append("    , NVL(LANE_TP_HIS_FLG,'N')              LANE_TP_HIS_FLG" ).append("\n"); 
		query.append("   FROM COA_LANE_RGST" ).append("\n"); 
		query.append("  WHERE NVL(DELT_FLG,'N') = @[delt_flg]" ).append("\n"); 
		query.append("    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("      AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${slan_cd} != '')" ).append("\n"); 
		query.append("      AND SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" ORDER BY TRD_CD" ).append("\n"); 
		query.append("        , SUB_TRD_CD" ).append("\n"); 

	}
}