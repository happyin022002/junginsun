/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SPCManageDBDAOSearchSpcSlotInfoByVvdListRSQL.java
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

public class SPCManageDBDAOSearchSpcSlotInfoByVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_BSA_VVD_MST, COA_BSA_VVD_CRR_PERF, COA_BSA_VVD_PERF 테이블의 내용을 조회
	  * 2014.04.28 김시몬 [CHM-201429944] MONTH 조회시 SLS_YRMON으로 조회되도록
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * </pre>
	  */
	public SPCManageDBDAOSearchSpcSlotInfoByVvdListRSQL(){
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
		params.put("txttomonth",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("txttoweek",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rdoopjob",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("txtdir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("txtyear",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("txtvsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOSearchSpcSlotInfoByVvdListRSQL").append("\n"); 
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
		query.append("SELECT MIN(DECODE(D.CRR_CD, '', 'I', 'R')) FLAG, " ).append("\n"); 
		query.append("      NVL(C.MNL_FLG , 'N' ) ," ).append("\n"); 
		query.append("      NVL(A.BSA_ZR_FLG,'N') BSA_ZR_FLG,       " ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("	SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK COST_YRWK,   	" ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  	SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK COST_YRWK,   	" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("      C.TRD_CD, " ).append("\n"); 
		query.append("      A.SUB_TRD_CD, " ).append("\n"); 
		query.append("      A.SLAN_CD, " ).append("\n"); 
		query.append("      C.RLANE_CD, " ).append("\n"); 
		query.append("      DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC') VSL_LANE_TP_CD, " ).append("\n"); 
		query.append("      C.VSL_CD, " ).append("\n"); 
		query.append("      C.SKD_VOY_NO, " ).append("\n"); 
		query.append("      C.SKD_DIR_CD, " ).append("\n"); 
		query.append("      C.VOP_CD, " ).append("\n"); 
		query.append("      C.CRR_CD, " ).append("\n"); 
		query.append("      C.BSA_CAPA, " ).append("\n"); 
		query.append("      NVL(SUM(DECODE(D.CRR_CD, 'SML', D.CRR_BSA_CAPA)), 0) FNL_HJS_BSA_CAPA, " ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("      NVL(SUM(DECODE(D.crr_cd, '${keys}', D.CRR_BSA_CAPA)), 0) C${keys}, " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${rdoopjob} != '008' && ${rdoopjob} != '009') " ).append("\n"); 
		query.append("      MAX(F.FREE_ADD_TEU_CAPA) FREE_ADD_TEU_CAPA , " ).append("\n"); 
		query.append("      MAX(F.FREE_ADD_WGT) FREE_ADD_WGT, " ).append("\n"); 
		query.append("      C.N2ND_FNL_HJS_BSA_CAPA, " ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList})        " ).append("\n"); 
		query.append("	    NVL(SUM(DECODE(D.CRR_CD, '${keys}', D.SPC_CTRL_SLT_CAPA)), 0) S${keys}, " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("      MAX(DECODE(C.SPC_OTR_SWAP_FLG, 'Y', DECODE(F.BSA_OP_JB_CD, @[rdoopjob], DECODE(F.CRR_CD, 'SML', '', 'Yes')))) SPC_OTR_SWAP_FLG," ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList})  " ).append("\n"); 
		query.append("      NVL(MIN(DECODE(F.CRR_CD, '${keys}', F.SLS_TEU_CAPA)), 0) SLS${keys}, " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList})  " ).append("\n"); 
		query.append("      NVL(MIN(DECODE(F.CRR_CD, '${keys}', F.PUR_TEU_CAPA)), 0) PUR${keys}, " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList})  " ).append("\n"); 
		query.append("      NVL(MIN(DECODE(F.CRR_CD, '${keys}', F.SLT_SWAP_TEU_CAPA)), 0) SLT${keys}, " ).append("\n"); 
		query.append("#end 			        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      C.IOC_CD, " ).append("\n"); 
		query.append("      C.BSA_OP_CD, " ).append("\n"); 
		query.append("      TO_CHAR(C.N1ST_PORT_ETD_DT,'YYYYMMDD') N1ST_PORT_ETD_DT  " ).append("\n"); 
		query.append("      , C.MNL_FLG MNL_FLG" ).append("\n"); 
		query.append("FROM MAS_MON_VVD A, " ).append("\n"); 
		query.append("     MAS_LANE_RGST B," ).append("\n"); 
		query.append("     BSA_VVD_MST C, " ).append("\n"); 
		query.append("     BSA_VVD_OTR_CRR D" ).append("\n"); 
		query.append("#if (${rdoopjob} != '008' && ${rdoopjob} != '009') " ).append("\n"); 
		query.append("    ,BSA_VVD_SWAP_INFO F " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE A.TRD_CD     = C.TRD_CD " ).append("\n"); 
		query.append("  AND A.RLANE_CD   = C.RLANE_CD " ).append("\n"); 
		query.append("  AND A.IOC_CD     = C.IOC_CD " ).append("\n"); 
		query.append("  AND A.VSL_CD     = C.VSL_CD " ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = C.SKD_VOY_NO " ).append("\n"); 
		query.append("  AND A.DIR_CD     = C.SKD_DIR_CD " ).append("\n"); 
		query.append("  AND A.TRD_CD     = B.TRD_CD " ).append("\n"); 
		query.append("  AND A.RLANE_CD   = B.RLANE_CD " ).append("\n"); 
		query.append("  AND A.DIR_CD     = B.DIR_CD " ).append("\n"); 
		query.append("  AND A.IOC_CD     = B.IOC_CD " ).append("\n"); 
		query.append("  AND C.TRD_CD     = D.TRD_CD(+) " ).append("\n"); 
		query.append("  AND C.RLANE_CD   = D.RLANE_CD(+) " ).append("\n"); 
		query.append("  AND C.VSL_CD     = D.VSL_CD(+) " ).append("\n"); 
		query.append("  AND C.SKD_VOY_NO = D.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD = D.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("#if (${rdoopjob} != '008' && ${rdoopjob} != '009')  " ).append("\n"); 
		query.append("  AND D.TRD_CD     = F.TRD_CD(+) " ).append("\n"); 
		query.append("  AND D.RLANE_CD   = F.RLANE_CD(+) " ).append("\n"); 
		query.append("  AND D.VSL_CD     = F.VSL_CD(+) " ).append("\n"); 
		query.append("  AND D.SKD_VOY_NO = F.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("  AND D.SKD_DIR_CD = F.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("  AND D.BSA_OP_JB_CD= F.BSA_OP_JB_CD(+) " ).append("\n"); 
		query.append("  AND D.CRR_CD      = F.CRR_CD(+) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND NVL(A.DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("  AND D.BSA_OP_JB_CD(+) = @[rdoopjob]" ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  AND A.SLS_YRMON  BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  AND A.SLS_YRMON  LIKE @[txtyear] || '%'" ).append("\n"); 
		query.append("  AND A.COST_WK BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("  AND C.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("  AND c.rlane_cd = @[coblane] " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("GROUP BY C.MNL_FLG, NVL(A.BSA_ZR_FLG,'N'), " ).append("\n"); 
		query.append("	#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("		A.SLS_YRMON,  	" ).append("\n"); 
		query.append("	#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  		A.SLS_YRMON, 	" ).append("\n"); 
		query.append("	#end 		" ).append("\n"); 
		query.append("		A.COST_WK, " ).append("\n"); 
		query.append("		C.TRD_CD, " ).append("\n"); 
		query.append("		A.SUB_TRD_CD, " ).append("\n"); 
		query.append("		A.SLAN_CD, " ).append("\n"); 
		query.append("        C.RLANE_CD, " ).append("\n"); 
		query.append("		DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC'), " ).append("\n"); 
		query.append("		C.VSL_CD, " ).append("\n"); 
		query.append("		C.SKD_VOY_NO, " ).append("\n"); 
		query.append("		C.SKD_DIR_CD, " ).append("\n"); 
		query.append("        C.VOP_CD, " ).append("\n"); 
		query.append("		C.CRR_CD,  " ).append("\n"); 
		query.append("		C.BSA_CAPA, " ).append("\n"); 
		query.append("		C.N2ND_FNL_HJS_BSA_CAPA, " ).append("\n"); 
		query.append("		C.SPC_OTR_SWAP_FLG, " ).append("\n"); 
		query.append("		C.IOC_CD, " ).append("\n"); 
		query.append("        C.BSA_OP_CD," ).append("\n"); 
		query.append("		C.N1ST_PORT_ETD_DT" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("	#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("		SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK, 	" ).append("\n"); 
		query.append("	#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  		SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK,	" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("		C.TRD_CD, " ).append("\n"); 
		query.append("		A.SUB_TRD_CD, " ).append("\n"); 
		query.append("		A.SLAN_CD, " ).append("\n"); 
		query.append("		C.RLANE_CD, " ).append("\n"); 
		query.append("		C.BSA_OP_CD" ).append("\n"); 

	}
}