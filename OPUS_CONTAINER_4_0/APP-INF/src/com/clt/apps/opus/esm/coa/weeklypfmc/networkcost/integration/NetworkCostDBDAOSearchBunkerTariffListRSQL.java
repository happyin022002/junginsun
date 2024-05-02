/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOSearchBunkerTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.03.14 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchBunkerTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBunkerTariffList SELECT
	  * 2010.09.08 이상용   [CHM-201005893] MIN 값이 아니라 SLS_YRMON 과 조인하도록 변경
	  * </pre>
	  */
	public NetworkCostDBDAOSearchBunkerTariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchBunkerTariffListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C1.COST_YRMON, C2.COST_YRMON, 'R', 'I') FLAG" ).append("\n"); 
		query.append("      ,C2.COST_YRMON                                  COST_YRMON" ).append("\n"); 
		query.append("      ,C2.COST_WK                                COST_WK" ).append("\n"); 
		query.append("      ,C2.SLAN_CD                                     SLAN_CD" ).append("\n"); 
		query.append("      ,C2.RLANE_CD                                    RLANE_CD" ).append("\n"); 
		query.append("      ,C2.VSL_CLSS_CAPA                               VSL_CLSS_CAPA" ).append("\n"); 
		query.append("      ,C2.DIR_CD                                      DIR_CD" ).append("\n"); 
		query.append("      ,C1.FOIL_CSM                                    FOIL_CSM" ).append("\n"); 
		query.append("      ,C1.FOIL_UC_AMT                                 FOIL_UC_AMT" ).append("\n"); 
		query.append("      ,C1.DOIL_CSM                                    DOIL_CSM" ).append("\n"); 
		query.append("      ,C1.DOIL_UC_AMT                                 DOIL_UC_AMT" ).append("\n"); 
		query.append("FROM COA_BNK_TRF C1" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("     SELECT Distinct" ).append("\n"); 
		query.append("#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("            B1.SLS_YRMON COST_YRMON" ).append("\n"); 
		query.append("           ,B1.COST_WK COST_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           B1.COST_YRMON AS COST_YRMON" ).append("\n"); 
		query.append("           ,'' COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ,B1.SLAN_CD" ).append("\n"); 
		query.append("           ,B1.RLANE_CD" ).append("\n"); 
		query.append("           ,B1.DIR_CD" ).append("\n"); 
		query.append("           ,B2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("       FROM COA_MON_VVD B1" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("           SELECT A1.VSL_SEQ         VSL_SEQ" ).append("\n"); 
		query.append("                 ,A1.VSL_CD          VSL_CD" ).append("\n"); 
		query.append("                 ,A1.VSL_TP_CD       VSL_TP_CD" ).append("\n"); 
		query.append("                 ,A1.VSL_OSHP_CD     VSL_OSHP_CD" ).append("\n"); 
		query.append("                 ,A1.VOP_CD          VOP_CD                 " ).append("\n"); 
		query.append("                 ,A1.VSL_CLSS_CAPA   VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                 ,A1.VSL_APLY_FM_DT  FM_DT" ).append("\n"); 
		query.append("                 ,A1.VSL_APLY_TO_DT  TO_DT" ).append("\n"); 
		query.append("             FROM COA_VSL_RGST A1" ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("              AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("          ) B2" ).append("\n"); 
		query.append("          ,COA_LANE_RGST B3" ).append("\n"); 
		query.append("     WHERE B1.VSL_CD          = B2.VSL_CD" ).append("\n"); 
		query.append("      AND B1.TRD_CD           = B3.TRD_CD" ).append("\n"); 
		query.append("      AND B1.RLANE_CD         = B3.RLANE_CD" ).append("\n"); 
		query.append("      AND B1.IOC_CD           = B3.IOC_CD" ).append("\n"); 
		query.append("      AND B1.DIR_CD           = B3.DIR_CD" ).append("\n"); 
		query.append("#if (${yrType} == 'yrwk')" ).append("\n"); 
		query.append("      AND B1.SLS_YRMON        LIKE @[sls_yrmon]||'%'" ).append("\n"); 
		query.append("      AND B1.COST_WK          LIKE @[cost_wk]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND B1.COST_YRMON        LIKE @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND B1.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("	  AND NVL(B3.DELT_FLG,'N')= 'N'" ).append("\n"); 
		query.append("      AND B2.VOP_CD           = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("      AND B3.TRD_CD           <> 'COM'" ).append("\n"); 
		query.append("      AND B3.VSL_LANE_TP_CD   IN ('JO','SC')" ).append("\n"); 
		query.append("      AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("          AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("    ) C2" ).append("\n"); 
		query.append("WHERE C2.SLAN_CD       = C1.SLAN_CD         (+)" ).append("\n"); 
		query.append("  AND C2.RLANE_CD      = C1.RLANE_CD        (+)" ).append("\n"); 
		query.append("  AND C2.DIR_CD        = C1.SLAN_DIR_CD     (+)" ).append("\n"); 
		query.append("  AND C2.VSL_CLSS_CAPA = C1.VSL_CLSS_CAPA   (+)" ).append("\n"); 
		query.append("  AND C2.COST_YRMON    = C1.COST_YRMON (+)" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("  AND C2.SLAN_CD       = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("  AND C2.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_clss_capa} != '')" ).append("\n"); 
		query.append("  AND C2.VSL_CLSS_CAPA = @[vsl_clss_capa]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY C2.COST_YRMON" ).append("\n"); 
		query.append("        ,C2.COST_WK" ).append("\n"); 
		query.append("        ,C2.SLAN_CD" ).append("\n"); 
		query.append("        ,C2.RLANE_CD" ).append("\n"); 
		query.append("        ,C2.VSL_CLSS_CAPA" ).append("\n"); 

	}
}