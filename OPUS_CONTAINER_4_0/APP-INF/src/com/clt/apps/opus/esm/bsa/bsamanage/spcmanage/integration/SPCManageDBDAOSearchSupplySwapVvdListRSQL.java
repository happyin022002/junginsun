/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SPCManageDBDAOSearchSupplySwapVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.23 
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

public class SPCManageDBDAOSearchSupplySwapVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCManageDBDAO SearchSupplySwapVvdList
	  * </pre>
	  */
	public SPCManageDBDAOSearchSupplySwapVvdListRSQL(){
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
		query.append("FileName : SPCManageDBDAOSearchSupplySwapVvdListRSQL").append("\n"); 
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
		query.append("SELECT MIN(DECODE(D.CRR_CD, '', 'I', 'R')) FLAG," ).append("\n"); 
		query.append("  NVL(A.BSA_ZR_FLG, 'N') AS BSA_ZR_FLG," ).append("\n"); 
		query.append("  DECODE(A.BSA_ZR_FLG, 'Y', '1', '0') AS BSA_FLG," ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("	SUBSTR(A.COST_YRMON,0,4) ||'-'|| A.COST_WK AS COST_YRWK,   	" ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  	SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK AS COST_YRWK,   	" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  C.TRD_CD," ).append("\n"); 
		query.append("  A.SUB_TRD_CD," ).append("\n"); 
		query.append("  A.SLAN_CD," ).append("\n"); 
		query.append("  C.RLANE_CD," ).append("\n"); 
		query.append("  DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC') AS VSL_LANE_TP_CD," ).append("\n"); 
		query.append("  DECODE(C.BSA_OP_CD, 'J', '0', '1') AS TYPE_FLG," ).append("\n"); 
		query.append("  C.VSL_CD," ).append("\n"); 
		query.append("  C.SKD_VOY_NO," ).append("\n"); 
		query.append("  C.SKD_DIR_CD," ).append("\n"); 
		query.append("  C.VOP_CD," ).append("\n"); 
		query.append("  --F.CRR_CD," ).append("\n"); 
		query.append("  C.CRR_CD," ).append("\n"); 
		query.append("  DECODE(C.VOP_CD, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC, '0', '1') AS VOP_FLG," ).append("\n"); 
		query.append("  C.VSL_CAPA," ).append("\n"); 
		query.append("  C.VSL_CAPA," ).append("\n"); 
		query.append("  C.BSA_CAPA," ).append("\n"); 
		query.append("  NVL(C.FNL_CO_BSA_CAPA, 0) AS FNL_CO_BSA_CAPA," ).append("\n"); 
		query.append("  NVL(C.CO_BSA_CAPA, 0) CO_BSA_CAPA," ).append("\n"); 
		query.append("  NVL(C.CO_BSA_RTO, 0)*100 AS CO_BSA_RTO," ).append("\n"); 
		query.append("  NVL(C.CHTR_BSA_RTO, 0)*100 AS CHTR_BSA_RTO," ).append("\n"); 
		query.append("  NVL(C.CO_BSA_BFR_SUB_CAPA, 0) AS CO_BSA_BFR_SUB_CAPA," ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("  NVL(SUM(DECODE(D.BSA_OP_JB_CD, SUBSTR('${keys}', 4, 6), DECODE(D.CRR_CD, SUBSTR('${keys}', 1, 3), D.CRR_BSA_CAPA))), 0) ${keys}," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  C.REV_PORT_CD," ).append("\n"); 
		query.append("  TO_CHAR(C.REV_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') REV_PORT_ETD_DT," ).append("\n"); 
		query.append("  TO_CHAR(C.N1ST_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') N1ST_PORT_ETD_DT," ).append("\n"); 
		query.append("  C.IOC_RULE_DESC," ).append("\n"); 
		query.append("  C.IOC_CD," ).append("\n"); 
		query.append("  C.BSA_OP_CD," ).append("\n"); 
		query.append("  C.FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    COA_MON_VVD A,  " ).append("\n"); 
		query.append("    COA_LANE_RGST B,  " ).append("\n"); 
		query.append("    BSA_VVD_MST C,  " ).append("\n"); 
		query.append("    BSA_VVD_CRR_PERF D " ).append("\n"); 
		query.append("    --,MDM_VSL_CNTR F" ).append("\n"); 
		query.append("WHERE A.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("  AND A.IOC_CD      = C.IOC_CD" ).append("\n"); 
		query.append("  AND A.VSL_CD      = C.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO  = C.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.DIR_CD      = C.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.TRD_CD      = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD      = B.DIR_CD" ).append("\n"); 
		query.append("  AND A.IOC_CD      = B.IOC_CD" ).append("\n"); 
		query.append("  AND C.TRD_CD      = D.TRD_CD(+)" ).append("\n"); 
		query.append("  AND C.RLANE_CD    = D.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND C.VSL_CD      = D.VSL_CD(+)" ).append("\n"); 
		query.append("  AND C.SKD_VOY_NO  = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD  = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("--AND A.VSL_CD      = F.VSL_CD(+)" ).append("\n"); 
		query.append("--AND 'Y' = F.CRR_RGST_FLG(+)  COA_VSL_INFO TABLE 삭제에따른 제외" ).append("\n"); 
		query.append("  AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND D.CRR_CD(+) != COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  AND A.COST_YRMON BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  AND A.SLS_YRMON LIKE @[txtyear] || '%'" ).append("\n"); 
		query.append("  AND A.COST_WK BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("  AND C.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("  AND C.RLANE_CD = @[coblane] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD = @[cobdir] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobioc} != '')" ).append("\n"); 
		query.append("  AND C.IOC_CD = @[cobioc] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtvsl_cd} != '')" ).append("\n"); 
		query.append("  AND C.VSL_CD = @[txtvsl_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtskd_voy_no} != '')" ).append("\n"); 
		query.append("  AND C.SKD_VOY_NO = @[txtskd_voy_no] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtdir_cd} != '')" ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD = @[txtdir_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY NVL(A.BSA_ZR_FLG, 'N'), " ).append("\n"); 
		query.append("    DECODE(A.BSA_ZR_FLG, 'Y', '1', '0'), " ).append("\n"); 
		query.append("    #if (${chkprd} == 'M')" ).append("\n"); 
		query.append("		A.COST_YRMON, 	" ).append("\n"); 
		query.append("	#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  		A.SLS_YRMON," ).append("\n"); 
		query.append("	#end	" ).append("\n"); 
		query.append("		A.COST_WK, " ).append("\n"); 
		query.append("		C.TRD_CD, " ).append("\n"); 
		query.append("		A.SUB_TRD_CD, " ).append("\n"); 
		query.append("		A.SLAN_CD, " ).append("\n"); 
		query.append("		C.RLANE_CD, " ).append("\n"); 
		query.append("		C.BSA_OP_CD, " ).append("\n"); 
		query.append("		C.VSL_CD, " ).append("\n"); 
		query.append("		C.SKD_VOY_NO, " ).append("\n"); 
		query.append("		C.SKD_DIR_CD, " ).append("\n"); 
		query.append("		C.VOP_CD, " ).append("\n"); 
		query.append("		--F.CRR_CD, " ).append("\n"); 
		query.append("		C.CRR_CD," ).append("\n"); 
		query.append("		C.VSL_CAPA, " ).append("\n"); 
		query.append("		C.BSA_CAPA, " ).append("\n"); 
		query.append("		C.FNL_CO_BSA_CAPA, " ).append("\n"); 
		query.append("		C.CO_BSA_CAPA, " ).append("\n"); 
		query.append("		C.CO_BSA_RTO, " ).append("\n"); 
		query.append("		C.CHTR_BSA_RTO, " ).append("\n"); 
		query.append("		C.CO_BSA_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("		C.REV_PORT_CD, " ).append("\n"); 
		query.append("		C.REV_PORT_ETD_DT, " ).append("\n"); 
		query.append("		C.N1ST_PORT_ETD_DT, " ).append("\n"); 
		query.append("		C.IOC_RULE_DESC, " ).append("\n"); 
		query.append("		C.IOC_CD, " ).append("\n"); 
		query.append("		C.BSA_OP_CD" ).append("\n"); 
		query.append("ORDER BY COST_YRWK, " ).append("\n"); 
		query.append("    C.TRD_CD, " ).append("\n"); 
		query.append("    A.SUB_TRD_CD, " ).append("\n"); 
		query.append("    A.SLAN_CD, " ).append("\n"); 
		query.append("    C.RLANE_CD, " ).append("\n"); 
		query.append("    C.BSA_OP_CD, " ).append("\n"); 
		query.append("    C.N1ST_PORT_ETD_DT" ).append("\n"); 

	}
}