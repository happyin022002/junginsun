/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AsiaOceanFeederCostManageDBDAOSearchOceanFeederCostAccountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaOceanFeederCostManageDBDAOSearchOceanFeederCostAccountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.29 변종건 [CHM-201217633] Ocean Feeder Cost Management - Cost Detail
	  * </pre>
	  */
	public AsiaOceanFeederCostManageDBDAOSearchOceanFeederCostAccountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : AsiaOceanFeederCostManageDBDAOSearchOceanFeederCostAccountRSQL").append("\n"); 
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
		query.append("SELECT  A.COST_TRF_NO                                                           AS TRF_NO" ).append("\n"); 
		query.append("      , A.COST_TRF_ROUT_SEQ                                                     AS TRF_ROUT_SEQ" ).append("\n"); 
		query.append("      , A.COST_TRF_ROUT_DESC                                                    AS TRF_ROUT_DESC" ).append("\n"); 
		query.append("      , MAS_GET_COM_NM_FNC('cost_act_grp_cd', A.COST_ACT_GRP_CD)                AS ACT_GRP" ).append("\n"); 
		query.append("      , A.STND_COST_CD                                                          AS STND_COST_CD" ).append("\n"); 
		query.append("      , V.STND_COST_NM                                                          AS STND_COST_NM" ).append("\n"); 
		query.append("      , A.COA_COST_SRC_CD                                                       AS SRC_CD" ).append("\n"); 
		query.append("      , MAS_GET_COM_NM_FNC('mas_cost_src_cd', A.COA_COST_SRC_CD)                AS SRC_NM  " ).append("\n"); 
		query.append("      , A.COST_ACT_GRP_CD                                                       AS ACT_GRP_CD" ).append("\n"); 
		query.append("      , A.FDR_20FT_COST_TRF_AMT                                               AS TRF_AMT_20FT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', FDR_20FT_COST_SYS_SRC_CD) AS SYS_SRC_CD_20FT" ).append("\n"); 
		query.append("      , A.FDR_20FT_COST_CALC_RMK                                              AS CALC_RMK_20FT" ).append("\n"); 
		query.append("      , A.FDR_40FT_COST_TRF_AMT                                               AS TRF_AMT_40FT" ).append("\n"); 
		query.append("      , COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03050', FDR_40FT_COST_SYS_SRC_CD) AS SYS_SRC_CD_40FT" ).append("\n"); 
		query.append("      , A.FDR_40FT_COST_CALC_RMK                                              AS CALC_RMK_40FT" ).append("\n"); 
		query.append("FROM    ${acct_tbl_div}     A" ).append("\n"); 
		query.append("      , MAS_STND_ACCT_V     V" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     A.STND_COST_CD      = V.STND_COST_CD" ).append("\n"); 
		query.append("AND     V.PA_VW             = 'BKG'" ).append("\n"); 
		query.append("AND     A.COST_TRF_NO       = @[trf_no]" ).append("\n"); 
		query.append("AND     A.COST_TRF_ROUT_SEQ = @[trf_rout_seq]" ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ, COA_COST_SRC_CD" ).append("\n"); 

	}
}