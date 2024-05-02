/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SPCManageDBDAOSearchSlotPrcSwapVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * History---------------------------
	  * 2010.12.14 이행지 [CHM-201007368] - [BSA Creation] Slot Price 탭과 Slottage 탭의 Data 불일치
	  *                                                   Slottage탭에서 보여주던 Price Data(Slot Creation/Update)를 BSA&Slottage의 Creation후의 Price 값에서 가져오도록 변경
	  * 2014.04.28 김시몬 [CHM-201429944] MONTH 조회시 SLS_YRMON으로 조회되도록
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
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
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
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
		query.append("  NVL(B1.MNL_FLG,'N') MNL_FLG ," ).append("\n"); 
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
		query.append("  B1.FNL_HJS_BSA_CAPA ," ).append("\n"); 
		query.append("  B1.CO_BSA_CAPA ," ).append("\n"); 
		query.append("  B1.HJS_BSA_RTO ," ).append("\n"); 
		query.append("  B1.CHTR_BSA_RTO ," ).append("\n"); 
		query.append("  B1.HJS_BSA_BFR_SUB_CAPA, " ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("  NVL(SUM(CASE WHEN B1.BSA_OP_JB_CD = SUBSTR('${keys}', 4, 6)    " ).append("\n"); 
		query.append("                AND B1.CRR_CD = SUBSTR('${keys}', 1, 3)" ).append("\n"); 
		query.append("                AND B1.CRR_BSA_CAPA <> 0 " ).append("\n"); 
		query.append("               THEN B1.CRR_PERF_AMT/B1.CRR_BSA_CAPA ELSE 0 END), 0) AS PRC_${keys} ," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   B1.REV_PORT_CD, " ).append("\n"); 
		query.append("   B1.REV_PORT_ETD_DT ," ).append("\n"); 
		query.append("   B1.N1ST_PORT_ETD_DT ," ).append("\n"); 
		query.append("   B1.IOC_RULE_DESC, " ).append("\n"); 
		query.append("   B1.IOC_CD, " ).append("\n"); 
		query.append("   B1.BSA_OP_CD, " ).append("\n"); 
		query.append("   B1.FNL_HJS_BSA_CAPA     " ).append("\n"); 
		query.append("FROM (       " ).append("\n"); 
		query.append("     SELECT DECODE(A4.CRR_CD, '', 'I', 'R') AS FLAG " ).append("\n"); 
		query.append("           ,NVL(A1.BSA_ZR_FLG,'N') AS BSA_ZR_FLG " ).append("\n"); 
		query.append("           ,DECODE(A1.BSA_ZR_FLG,'Y','1','0') AS BSA_FLG            " ).append("\n"); 
		query.append("		#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("		   ,SUBSTR(A1.SLS_YRMON,0,4) ||'-'|| A1.COST_WK AS COST_YRWK   			" ).append("\n"); 
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
		query.append("           ,DECODE(A3.VOP_CD, 'SML', '0', '1') AS VOP_FLG " ).append("\n"); 
		query.append("           ,A3.VSL_CAPA--, A3.VSL_CAPA " ).append("\n"); 
		query.append("           ,A3.BSA_CAPA " ).append("\n"); 
		query.append("           ,NVL(A3.FNL_HJS_BSA_CAPA,0) AS FNL_HJS_BSA_CAPA " ).append("\n"); 
		query.append("           ,NVL(A3.CO_BSA_CAPA,0) AS CO_BSA_CAPA " ).append("\n"); 
		query.append("           ,NVL(A3.HJS_BSA_RTO,0)*100 AS HJS_BSA_RTO " ).append("\n"); 
		query.append("           ,NVL(A3.CHTR_BSA_RTO,0)*100 AS CHTR_BSA_RTO " ).append("\n"); 
		query.append("           ,NVL(A3.HJS_BSA_BFR_SUB_CAPA,0) AS HJS_BSA_BFR_SUB_CAPA " ).append("\n"); 
		query.append("           ,A3.REV_PORT_CD " ).append("\n"); 
		query.append("           ,TO_CHAR(A3.REV_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') AS REV_PORT_ETD_DT " ).append("\n"); 
		query.append("           ,TO_CHAR(A3.N1ST_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') AS N1ST_PORT_ETD_DT " ).append("\n"); 
		query.append("           ,TO_CHAR(A3.N1ST_PORT_ETD_DT, 'YYYYMMDD') AS N1ST_PORT_ETD_DT2 " ).append("\n"); 
		query.append("           ,A3.IOC_RULE_DESC" ).append("\n"); 
		query.append("           ,A3.IOC_CD" ).append("\n"); 
		query.append("           ,A3.BSA_OP_CD--, A3.FNL_HJS_BSA_CAPA     " ).append("\n"); 
		query.append("           ,A4.BSA_OP_JB_CD " ).append("\n"); 
		query.append("           ,A4.CRR_BSA_CAPA " ).append("\n"); 
		query.append("           ,A4.CRR_PERF_AMT  -- Add @2010-12-13" ).append("\n"); 
		query.append("           ,A3.MNL_FLG" ).append("\n"); 
		query.append("       FROM MAS_MON_VVD A1," ).append("\n"); 
		query.append("            MAS_LANE_RGST A2," ).append("\n"); 
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
		query.append("        AND A1.VSL_CD     = A5.VSL_CD(+)  " ).append("\n"); 
		query.append("--        AND 'Y'           = A5.CRR_RGST_FLG(+)  COA_VSL_INFO TABLE 삭제에따른 제외      " ).append("\n"); 
		query.append("        AND A4.CRR_CD(+)  != 'SML'  " ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  AND A1.SLS_YRMON BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
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
		query.append("    ) B1      " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("GROUP BY B1.BSA_ZR_FLG " ).append("\n"); 
		query.append("   ,B1.MNL_FLG" ).append("\n"); 
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
		query.append("   ,B1.FNL_HJS_BSA_CAPA " ).append("\n"); 
		query.append("   ,B1.CO_BSA_CAPA " ).append("\n"); 
		query.append("   ,B1.HJS_BSA_RTO " ).append("\n"); 
		query.append("   ,B1.CHTR_BSA_RTO " ).append("\n"); 
		query.append("   ,B1.HJS_BSA_BFR_SUB_CAPA " ).append("\n"); 
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