/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCManageDBDAOMultiSupplySwapVvdVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
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

public class SPCManageDBDAOMultiSupplySwapVvdVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0030 SAVE시 사용되는 VO용 QUERY
	  * 
	  * 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * 2016.02.16 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
	  * 2016.05.17 김용습 화폐코드, 환율 하드코딩 제거, Slot Price Insert시 BSA로 들어가는 버그 수정
	  * </pre>
	  */
	public SPCManageDBDAOMultiSupplySwapVvdVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOMultiSupplySwapVvdVOUSQL").append("\n"); 
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
		query.append("MERGE INTO BSA_VVD_CRR_PERF A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[trd_cd] TRD_CD " ).append("\n"); 
		query.append("      , @[lane_cd] RLANE_CD" ).append("\n"); 
		query.append("      , @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("      , @[voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append("      , @[dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("      , @[crr_cd] CRR_CD" ).append("\n"); 
		query.append("      , @[bsa_op_jb_cd] BSA_OP_JB_CD" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("    A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.CRR_CD = B.CRR_CD" ).append("\n"); 
		query.append("  AND A.BSA_OP_JB_CD = B.BSA_OP_JB_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("      SET " ).append("\n"); 
		query.append("	#if (${tab_index} == '0')" ).append("\n"); 
		query.append("		CRR_PERF_AMT = DECODE( CRR_BSA_CAPA , 0 , 0 , ((CRR_PERF_AMT / CRR_BSA_CAPA) * @[crr_bsa_capa]) )" ).append("\n"); 
		query.append("		, CRR_BSA_CAPA = @[crr_bsa_capa]" ).append("\n"); 
		query.append("	#elseif (${tab_index} == '1')" ).append("\n"); 
		query.append("		CRR_PERF_AMT = @[crr_bsa_capa] * CRR_BSA_CAPA" ).append("\n"); 
		query.append("		, SLT_PRC_CAPA = @[crr_bsa_capa]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		, UPD_DT = SYSDATE" ).append("\n"); 
		query.append("		, UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND TRD_CD = A.TRD_CD" ).append("\n"); 
		query.append("      AND RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("      AND VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND CRR_CD = A.CRR_CD" ).append("\n"); 
		query.append("      AND BSA_OP_JB_CD = A.BSA_OP_JB_CD" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (TRD_CD" ).append("\n"); 
		query.append("           , RLANE_CD" ).append("\n"); 
		query.append("           , VSL_CD" ).append("\n"); 
		query.append("           , SKD_VOY_NO" ).append("\n"); 
		query.append("           , SKD_DIR_CD" ).append("\n"); 
		query.append("           , BSA_OP_JB_CD" ).append("\n"); 
		query.append("           , CRR_CD" ).append("\n"); 
		query.append("           , CRR_BSA_CAPA" ).append("\n"); 
		query.append("           , CRR_PERF_AMT" ).append("\n"); 
		query.append("           , JO_EVNT_DT" ).append("\n"); 
		query.append("           , SLT_PRC_CAPA" ).append("\n"); 
		query.append("           , CRE_USR_ID" ).append("\n"); 
		query.append("           , CRE_DT" ).append("\n"); 
		query.append("           , UPD_USR_ID" ).append("\n"); 
		query.append("           , UPD_DT" ).append("\n"); 
		query.append("           , CRR_PERF_LOCL_AMT" ).append("\n"); 
		query.append("           , CURR_CD" ).append("\n"); 
		query.append("           , USD_XCH_RT" ).append("\n"); 
		query.append("	) VALUES ( @[trd_cd]" ).append("\n"); 
		query.append("            , @[lane_cd]" ).append("\n"); 
		query.append("            , @[vsl_cd]" ).append("\n"); 
		query.append("            , @[voy_no]" ).append("\n"); 
		query.append("            , @[dir_cd]" ).append("\n"); 
		query.append("            , @[bsa_op_jb_cd]" ).append("\n"); 
		query.append("            , @[crr_cd]" ).append("\n"); 
		query.append("#if (${tab_index} == '0')" ).append("\n"); 
		query.append("            , @[crr_bsa_capa]" ).append("\n"); 
		query.append("            , 0" ).append("\n"); 
		query.append("            , null" ).append("\n"); 
		query.append("            , 0" ).append("\n"); 
		query.append("#elseif (${tab_index} == '1')" ).append("\n"); 
		query.append("            , 0" ).append("\n"); 
		query.append("            , 0" ).append("\n"); 
		query.append("            , null" ).append("\n"); 
		query.append("            , @[crr_bsa_capa]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , @[upd_usr_id]" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , 0" ).append("\n"); 
		query.append("--            , 'USD'" ).append("\n"); 
		query.append("            ,NVL((SELECT DISTINCT NVL(A.CURR_CD,'USD') AS CURR_CD         " ).append("\n"); 
		query.append("              FROM BSA_SLT_PRC A, GL_MON_XCH_RT B " ).append("\n"); 
		query.append("             WHERE A.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("               AND A.RLANE_CD = @[lane_cd] " ).append("\n"); 
		query.append("               AND A.DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("               AND (SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y') >=TO_DATE(BSA_SLT_PRC_FM_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("               AND (SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y') <=TO_DATE(BSA_SLT_PRC_TO_DT,'YYYYMMDD')+0.99999 " ).append("\n"); 
		query.append("               AND A.BSA_SLT_COST_TP_CD = '017' " ).append("\n"); 
		query.append("               AND B.ACCT_XCH_RT_YRMON = (SELECT DISTINCT CASE WHEN TO_CHAR((SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y'), 'YYYYMM') > MAX(ACCT_XCH_RT_YRMON) OVER (PARTITION BY CURR_CD) " ).append("\n"); 
		query.append("                                                               THEN MAX(ACCT_XCH_RT_YRMON) OVER (PARTITION BY CURR_CD) " ).append("\n"); 
		query.append("                                                               ELSE TO_CHAR((SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y'), 'YYYYMM') " ).append("\n"); 
		query.append("                                                          END XCH_RT_YRMON " ).append("\n"); 
		query.append("                                            FROM GL_MON_XCH_RT C " ).append("\n"); 
		query.append("                                           WHERE ACCT_XCH_RT_YRMON > ' ' " ).append("\n"); 
		query.append("                                             AND C.ACCT_XCH_RT_LVL = '1' " ).append("\n"); 
		query.append("                                             AND C.CURR_CD = B.CURR_CD " ).append("\n"); 
		query.append("                                             AND C.DELT_FLG = 'N') " ).append("\n"); 
		query.append("               AND B.ACCT_XCH_RT_YRMON > ' ' " ).append("\n"); 
		query.append("               AND B.ACCT_XCH_RT_LVL = '1' " ).append("\n"); 
		query.append("               AND A.CURR_CD  = B.CURR_CD " ).append("\n"); 
		query.append("               AND B.DELT_FLG = 'N'), 'USD')" ).append("\n"); 
		query.append("--            , 1" ).append("\n"); 
		query.append("            ,NVL((SELECT DISTINCT USD_LOCL_XCH_RT           " ).append("\n"); 
		query.append("              FROM BSA_SLT_PRC A, GL_MON_XCH_RT B " ).append("\n"); 
		query.append("             WHERE A.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("               AND A.RLANE_CD = @[lane_cd] " ).append("\n"); 
		query.append("               AND A.DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("               AND (SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y') >=TO_DATE(BSA_SLT_PRC_FM_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("               AND (SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y') <=TO_DATE(BSA_SLT_PRC_TO_DT,'YYYYMMDD')+0.99999 " ).append("\n"); 
		query.append("               AND A.BSA_SLT_COST_TP_CD = '017' " ).append("\n"); 
		query.append("               AND B.ACCT_XCH_RT_YRMON = (SELECT DISTINCT CASE WHEN TO_CHAR((SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y'), 'YYYYMM') > MAX(ACCT_XCH_RT_YRMON) OVER (PARTITION BY CURR_CD) " ).append("\n"); 
		query.append("                                                               THEN MAX(ACCT_XCH_RT_YRMON) OVER (PARTITION BY CURR_CD) " ).append("\n"); 
		query.append("                                                               ELSE TO_CHAR((SELECT MAS.N1ST_LODG_PORT_ETD_DT FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = @[trd_cd] AND MAS.RLANE_CD = @[lane_cd] AND MAS.DIR_CD = @[dir_cd] AND MAS.VSL_CD = @[vsl_cd] AND MAS.SKD_VOY_NO = @[voy_no] AND MAS.DELT_FLG != 'Y'), 'YYYYMM') " ).append("\n"); 
		query.append("                                                          END XCH_RT_YRMON " ).append("\n"); 
		query.append("                                            FROM GL_MON_XCH_RT C " ).append("\n"); 
		query.append("                                           WHERE ACCT_XCH_RT_YRMON > ' ' " ).append("\n"); 
		query.append("                                             AND C.ACCT_XCH_RT_LVL = '1' " ).append("\n"); 
		query.append("                                             AND C.CURR_CD = B.CURR_CD " ).append("\n"); 
		query.append("                                             AND C.DELT_FLG = 'N') " ).append("\n"); 
		query.append("               AND B.ACCT_XCH_RT_YRMON > ' ' " ).append("\n"); 
		query.append("               AND B.ACCT_XCH_RT_LVL = '1' " ).append("\n"); 
		query.append("               AND A.CURR_CD  = B.CURR_CD " ).append("\n"); 
		query.append("               AND B.DELT_FLG = 'N'), 1)" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}