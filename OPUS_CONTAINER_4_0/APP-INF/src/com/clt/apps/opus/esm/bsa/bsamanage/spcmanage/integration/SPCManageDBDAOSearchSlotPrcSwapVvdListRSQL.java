/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPCManageDBDAOSearchSlotPrcSwapVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOSearchSlotPrcSwapVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public SPCManageDBDAOSearchSlotPrcSwapVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtdir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtskd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtyear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttoweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtvsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOSearchSlotPrcSwapVvdListRSQL").append("\n"); 
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
		query.append("SELECT MIN(B1.FLAG) AS FLAG ," ).append("\n"); 
		query.append("  B1.BSA_ZR_FLG ," ).append("\n"); 
		query.append("  B1.BSA_FLG ," ).append("\n"); 
		query.append("  B1.COST_YRWK ," ).append("\n"); 
		query.append("  B1.TRD_CD," ).append("\n"); 
		query.append("  B1.SUB_TRD_CD," ).append("\n"); 
		query.append("  B1.SLAN_CD," ).append("\n"); 
		query.append("  B1.RLANE_CD ," ).append("\n"); 
		query.append("  B1.VSL_LANE_TP_CD ," ).append("\n"); 
		query.append("  B1.TYPE_FLG ," ).append("\n"); 
		query.append("  B1.VSL_CD," ).append("\n"); 
		query.append("  B1.SKD_VOY_NO," ).append("\n"); 
		query.append("  B1.SKD_DIR_CD," ).append("\n"); 
		query.append("  B1.VOP_CD," ).append("\n"); 
		query.append("  B1.CRR_CD2 ," ).append("\n"); 
		query.append("  B1.VOP_FLG ," ).append("\n"); 
		query.append("  B1.VSL_CAPA," ).append("\n"); 
		query.append("  B1.VSL_CAPA," ).append("\n"); 
		query.append("  B1.BSA_CAPA ," ).append("\n"); 
		query.append("  B1.FNL_CO_BSA_CAPA ," ).append("\n"); 
		query.append("  B1.CO_BSA_CAPA ," ).append("\n"); 
		query.append("  B1.CO_BSA_RTO ," ).append("\n"); 
		query.append("  B1.CHTR_BSA_RTO ," ).append("\n"); 
		query.append("  B1.CO_BSA_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("  NVL(SUM(CASE WHEN B1.BSA_OP_JB_CD = SUBSTR('${keys}', 4, 6)    " ).append("\n"); 
		query.append("                AND B1.CRR_CD = SUBSTR('${keys}', 1, 3)" ).append("\n"); 
		query.append("                AND B1.CRR_BSA_CAPA <> 0 " ).append("\n"); 
		query.append("               THEN B1.CRR_PERF_AMT/B1.CRR_BSA_CAPA ELSE 0 END), 0) AS PRC_${keys} ," ).append("\n"); 
		query.append("  --20150513.ADD" ).append("\n"); 
		query.append("  NVL(SUM(CASE WHEN B1.BSA_OP_JB_CD = SUBSTR('${keys}', 4, 6)    " ).append("\n"); 
		query.append("                AND B1.CRR_CD = SUBSTR('${keys}', 1, 3)" ).append("\n"); 
		query.append("                AND B1.CRR_BSA_CAPA <> 0 " ).append("\n"); 
		query.append("               THEN B1.OP_CRR_PERF_AMT/B1.CRR_BSA_CAPA ELSE 0 END), 0) AS PCO_${keys} ," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   B1.REV_PORT_CD, " ).append("\n"); 
		query.append("   B1.REV_PORT_ETD_DT ," ).append("\n"); 
		query.append("   B1.N1ST_PORT_ETD_DT ," ).append("\n"); 
		query.append("   B1.IOC_RULE_DESC, " ).append("\n"); 
		query.append("   B1.IOC_CD, " ).append("\n"); 
		query.append("   B1.BSA_OP_CD, " ).append("\n"); 
		query.append("   B1.FNL_CO_BSA_CAPA     " ).append("\n"); 
		query.append("FROM (       " ).append("\n"); 
		query.append("     SELECT DECODE(A4.CRR_CD, '', 'I', 'R') AS FLAG " ).append("\n"); 
		query.append("           ,NVL(A1.BSA_ZR_FLG,'N') AS BSA_ZR_FLG " ).append("\n"); 
		query.append("           ,DECODE(A1.BSA_ZR_FLG,'Y','1','0') AS BSA_FLG            " ).append("\n"); 
		query.append("		#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("		   ,SUBSTR(A1.COST_YRMON,0,4) ||'-'|| A1.COST_WK AS COST_YRWK   			" ).append("\n"); 
		query.append("		#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  		   ,SUBSTR(A1.SLS_YRMON, 0, 4) ||'-'|| A1.COST_WK AS COST_YRWK" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("           ,A3.TRD_CD, A1.SUB_TRD_CD, A1.SLAN_CD, A3.RLANE_CD " ).append("\n"); 
		query.append("           ,DECODE(A3.BSA_OP_CD, 'J', 'JO', 'SC') AS VSL_LANE_TP_CD " ).append("\n"); 
		query.append("           ,DECODE(A3.BSA_OP_CD, 'J', '0', '1') AS TYPE_FLG " ).append("\n"); 
		query.append("           ,A3.VSL_CD" ).append("\n"); 
		query.append("           ,A3.SKD_VOY_NO" ).append("\n"); 
		query.append("           ,A3.SKD_DIR_CD" ).append("\n"); 
		query.append("           ,A3.VOP_CD" ).append("\n"); 
		query.append("           ,A4.CRR_CD" ).append("\n"); 
		query.append("           ,A3.CRR_CD AS CRR_CD2 " ).append("\n"); 
		query.append("           ,DECODE(A3.VOP_CD, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC, '0', '1') AS VOP_FLG " ).append("\n"); 
		query.append("           ,A3.VSL_CAPA--, A3.VSL_CAPA " ).append("\n"); 
		query.append("           ,A3.BSA_CAPA " ).append("\n"); 
		query.append("           ,NVL(A3.FNL_CO_BSA_CAPA,0) AS FNL_CO_BSA_CAPA " ).append("\n"); 
		query.append("           ,NVL(A3.CO_BSA_CAPA,0) AS CO_BSA_CAPA " ).append("\n"); 
		query.append("           ,NVL(A3.CO_BSA_RTO,0)*100 AS CO_BSA_RTO " ).append("\n"); 
		query.append("           ,NVL(A3.CHTR_BSA_RTO,0)*100 AS CHTR_BSA_RTO " ).append("\n"); 
		query.append("           ,NVL(A3.CO_BSA_BFR_SUB_CAPA,0) AS CO_BSA_BFR_SUB_CAPA " ).append("\n"); 
		query.append("           ,A3.REV_PORT_CD " ).append("\n"); 
		query.append("           ,TO_CHAR(A3.REV_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') AS REV_PORT_ETD_DT " ).append("\n"); 
		query.append("           ,TO_CHAR(A3.N1ST_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') AS N1ST_PORT_ETD_DT " ).append("\n"); 
		query.append("           ,TO_CHAR(A3.N1ST_PORT_ETD_DT, 'YYYYMMDD') AS N1ST_PORT_ETD_DT2 " ).append("\n"); 
		query.append("           ,A3.IOC_RULE_DESC" ).append("\n"); 
		query.append("           ,A3.IOC_CD" ).append("\n"); 
		query.append("           ,A3.BSA_OP_CD " ).append("\n"); 
		query.append("           ,A4.BSA_OP_JB_CD " ).append("\n"); 
		query.append("           ,A4.CRR_BSA_CAPA " ).append("\n"); 
		query.append("           ,A4.CRR_PERF_AMT" ).append("\n"); 
		query.append("           ,A4.OP_CRR_PERF_AMT			--20150513.ADD" ).append("\n"); 
		query.append("       FROM COA_MON_VVD A1," ).append("\n"); 
		query.append("            COA_LANE_RGST A2," ).append("\n"); 
		query.append("            BSA_VVD_MST A3," ).append("\n"); 
		query.append("            BSA_VVD_CRR_PERF A4," ).append("\n"); 
		query.append("            MDM_VSL_CNTR A5 " ).append("\n"); 
		query.append("      WHERE A1.TRD_CD     = A3.TRD_CD  " ).append("\n"); 
		query.append("        AND A1.RLANE_CD   = A3.RLANE_CD  " ).append("\n"); 
		query.append("        AND A1.IOC_CD     = A3.IOC_CD  " ).append("\n"); 
		query.append("        AND A1.VSL_CD     = A3.VSL_CD  " ).append("\n"); 
		query.append("        AND A1.SKD_VOY_NO = A3.SKD_VOY_NO  " ).append("\n"); 
		query.append("        AND A1.DIR_CD     = A3.SKD_DIR_CD  " ).append("\n"); 
		query.append("        AND A1.TRD_CD     = A2.TRD_CD  " ).append("\n"); 
		query.append("        AND A1.RLANE_CD   = A2.RLANE_CD  " ).append("\n"); 
		query.append("        AND A1.DIR_CD     = A2.DIR_CD  " ).append("\n"); 
		query.append("        AND A1.IOC_CD     = A2.IOC_CD  " ).append("\n"); 
		query.append("        AND A1.DELT_FLG   = 'N'            " ).append("\n"); 
		query.append("        AND NVL(A2.DELT_FLG, 'N')   = 'N'            " ).append("\n"); 
		query.append("        AND A3.TRD_CD     = A4.TRD_CD(+) " ).append("\n"); 
		query.append("        AND A3.RLANE_CD   = A4.RLANE_CD(+)  " ).append("\n"); 
		query.append("        AND A3.VSL_CD     = A4.VSL_CD(+)  " ).append("\n"); 
		query.append("        AND A3.SKD_VOY_NO = A4.SKD_VOY_NO(+)  " ).append("\n"); 
		query.append("        AND A3.SKD_DIR_CD = A4.SKD_DIR_CD(+)             " ).append("\n"); 
		query.append("        AND A1.VSL_CD     = A5.VSL_CD(+)   " ).append("\n"); 
		query.append("        AND A4.CRR_CD(+)  != COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  AND A1.COST_YRMON BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  AND A1.SLS_YRMON LIKE @[txtyear] || '%'" ).append("\n"); 
		query.append("  AND A1.COST_WK BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("  AND A3.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("  AND A3.RLANE_CD = @[coblane] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("  AND A3.SKD_DIR_CD = @[cobdir] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobioc} != '')" ).append("\n"); 
		query.append("  AND A3.IOC_CD = @[cobioc] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtvsl_cd} != '')" ).append("\n"); 
		query.append("  AND A3.VSL_CD = @[txtvsl_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtskd_voy_no} != '')" ).append("\n"); 
		query.append("  AND A3.SKD_VOY_NO = @[txtskd_voy_no] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtdir_cd} != '')" ).append("\n"); 
		query.append("  AND A3.SKD_DIR_CD = @[txtdir_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) B1" ).append("\n"); 
		query.append("GROUP BY B1.BSA_ZR_FLG " ).append("\n"); 
		query.append("   ,B1.BSA_FLG " ).append("\n"); 
		query.append("   ,B1.COST_YRWK " ).append("\n"); 
		query.append("   ,B1.TRD_CD" ).append("\n"); 
		query.append("   ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("   ,B1.SLAN_CD" ).append("\n"); 
		query.append("   ,B1.RLANE_CD " ).append("\n"); 
		query.append("   ,B1.VSL_LANE_TP_CD " ).append("\n"); 
		query.append("   ,B1.TYPE_FLG " ).append("\n"); 
		query.append("   ,B1.VSL_CD" ).append("\n"); 
		query.append("   ,B1.SKD_VOY_NO" ).append("\n"); 
		query.append("   ,B1.SKD_DIR_CD" ).append("\n"); 
		query.append("   ,B1.VOP_CD" ).append("\n"); 
		query.append("   ,B1.CRR_CD2 " ).append("\n"); 
		query.append("   ,B1.VOP_FLG " ).append("\n"); 
		query.append("   ,B1.VSL_CAPA" ).append("\n"); 
		query.append("   ,B1.VSL_CAPA" ).append("\n"); 
		query.append("   ,B1.BSA_CAPA " ).append("\n"); 
		query.append("   ,B1.FNL_CO_BSA_CAPA " ).append("\n"); 
		query.append("   ,B1.CO_BSA_CAPA " ).append("\n"); 
		query.append("   ,B1.CO_BSA_RTO " ).append("\n"); 
		query.append("   ,B1.CHTR_BSA_RTO " ).append("\n"); 
		query.append("   ,B1.CO_BSA_BFR_SUB_CAPA " ).append("\n"); 
		query.append("   ,B1.REV_PORT_CD " ).append("\n"); 
		query.append("   ,B1.REV_PORT_ETD_DT " ).append("\n"); 
		query.append("   ,B1.N1ST_PORT_ETD_DT " ).append("\n"); 
		query.append("   ,B1.IOC_RULE_DESC" ).append("\n"); 
		query.append("   ,B1.IOC_CD" ).append("\n"); 
		query.append("   ,B1.BSA_OP_CD " ).append("\n"); 
		query.append("ORDER BY B1.COST_YRWK " ).append("\n"); 
		query.append("   ,B1.TRD_CD " ).append("\n"); 
		query.append("   ,B1.SUB_TRD_CD " ).append("\n"); 
		query.append("   ,B1.SLAN_CD " ).append("\n"); 
		query.append("   ,B1.RLANE_CD     " ).append("\n"); 
		query.append("   ,B1.BSA_OP_CD " ).append("\n"); 
		query.append("   ,B1.N1ST_PORT_ETD_DT" ).append("\n"); 

	}
}