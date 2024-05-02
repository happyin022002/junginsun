/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOAddCustPerfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.07.16 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddCustPerfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance를 생성합니다.
	  * 2013.05.06 [CHM-201324211-01] 프로젝트 안정화 및 HELP DESK - SMP Season Creation 배치->backend로 변경
	  * 2013.09.04 [Trouble Shooting] TPS 외의 trade는 SC가 반드시 들어오지 않도록
	  * 2013.12.03 잘못된 데이터를 걸러내기 위한 조건추가. 3레벨 OFC BKG 들어오면서 에러남
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - 재생성 로칙 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2014.06.10 DTL_SEQ 구하는 DECODE(TRD_CD, 'AES', RFA_NO, SC_NO) ORDER BY 수정
	  * 2015.01.27 김성욱 [CHM-201533820] SMP creation 오류 데이터 수정 요청 
	  * 2015.01.     박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가 
	  * 2015.02.27 박은주 [CHM-201534433] SMP Regeneration 오류 수정 요청 - 삭제기준과 생성 기준이 달라져서 일치시킴
	  * 2015.07.16 Arie [CHM-201537094] MAS CMB 산출 로직 변경 적용 - dem/det 추가 CM = REV+DEM/DET-COST TTL
	  * </pre>
	  */
	public ModelManageDBDAOAddCustPerfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddCustPerfCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_PERF (" ).append("\n"); 
		query.append("     COST_YRWK" ).append("\n"); 
		query.append("    ,TRD_CD" ).append("\n"); 
		query.append("    ,RLANE_CD" ).append("\n"); 
		query.append("    ,SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    ,CUST_CNT_CD" ).append("\n"); 
		query.append("    ,CUST_SEQ" ).append("\n"); 
		query.append("    ,BKG_POR_CD" ).append("\n"); 
		query.append("    ,BKG_POL_CD" ).append("\n"); 
		query.append("    ,BKG_POD_CD" ).append("\n"); 
		query.append("    ,BKG_DEL_CD" ).append("\n"); 
		query.append("    ,DTL_SEQ" ).append("\n"); 
		query.append("    ,CTRT_OFC_CD" ).append("\n"); 
		query.append("    ,SC_NO" ).append("\n"); 
		query.append("    ,RFA_NO" ).append("\n"); 
		query.append("    ,SUB_TRD_CD" ).append("\n"); 
		query.append("    ,SLS_RHQ_CD" ).append("\n"); 
		query.append("    ,SLS_AQ_CD" ).append("\n"); 
		query.append("    ,USA_BKG_MOD_CD" ).append("\n"); 
		query.append("    ,RLANE_BKG_QTY" ).append("\n"); 
		query.append("    ,RLANE_CMPB_AMT" ).append("\n"); 
		query.append("    ,GRS_TTL_REV" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,DMDT_COM_AMT --2015.07.16 Arie [CHM-201537094] MAS CMB 산출 로직 변경 적용 - dem/det 추가 CM = REV+DEM/DET-COST TTL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH MAS_MON_VVD_LV AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           M.COST_YRMON" ).append("\n"); 
		query.append("          ,SUBSTR(M.SLS_YRMON, 1, 4) || M.COST_WK AS COST_YRWK" ).append("\n"); 
		query.append("          ,M.COST_WK" ).append("\n"); 
		query.append("          ,M.TRD_CD" ).append("\n"); 
		query.append("          ,M.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,M.RLANE_CD" ).append("\n"); 
		query.append("          ,H.DIR_CD" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD     M" ).append("\n"); 
		query.append("          ,SPC_MDL_VER_MST V" ).append("\n"); 
		query.append("          ,SPC_HD_HUL_MST  H" ).append("\n"); 
		query.append("     WHERE SUBSTR(M.SLS_YRMON, 1, 4) || M.COST_WK BETWEEN V.PERF_ST_YRWK AND V.PERF_END_YRWK" ).append("\n"); 
		query.append("       AND (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("       AND V.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("       AND V.COST_YRWK  = @[cost_yrwk]" ).append("\n"); 
		query.append("       AND V.VER_SEQ    = @[ver_seq]" ).append("\n"); 
		query.append("       AND M.TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("       AND M.TRD_CD     = H.TRD_CD" ).append("\n"); 
		query.append("       AND M.RLANE_CD   = H.RLANE_CD" ).append("\n"); 
		query.append("       AND M.SUB_TRD_CD = H.SUB_TRD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT COST_YRWK" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,SLS_OFC_CD" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("      ,BKG_POR_CD" ).append("\n"); 
		query.append("      ,BKG_POL_CD" ).append("\n"); 
		query.append("      ,BKG_POD_CD" ).append("\n"); 
		query.append("      ,BKG_DEL_CD" ).append("\n"); 
		query.append("      ,DENSE_RANK() OVER (PARTITION BY COST_YRWK, CUST_CD, CUST_SEQ, BKG_POR_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD ORDER BY COST_YRWK, CUST_CD, CUST_SEQ, RFA_NO, SC_NO, CTRT_OFC_CD, USA_BKG_MOD_CD) AS DTL_SEQ" ).append("\n"); 
		query.append("      ,CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,SC_NO" ).append("\n"); 
		query.append("      ,RFA_NO" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,SLS_RHQ_CD" ).append("\n"); 
		query.append("      ,SLS_AQ_CD" ).append("\n"); 
		query.append("      ,USA_BKG_MOD_CD" ).append("\n"); 
		query.append("      ,TEU_QTY_SUM" ).append("\n"); 
		query.append("      ,RA_CM_SUM" ).append("\n"); 
		query.append("      ,GRS_REV_SUM" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("      ,DMDT_SUM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT COST_YRWK" ).append("\n"); 
		query.append("                ,CUST_CD" ).append("\n"); 
		query.append("                ,CUST_SEQ" ).append("\n"); 
		query.append("                ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                ,SC_NO" ).append("\n"); 
		query.append("                ,RFA_NO" ).append("\n"); 
		query.append("                ,O.N4TH_PRNT_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("                ,O.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD" ).append("\n"); 
		query.append("                ,NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD) AS SLS_AQ_CD" ).append("\n"); 
		query.append("                ,TRD_CD" ).append("\n"); 
		query.append("                ,SUB_TRD_CD" ).append("\n"); 
		query.append("                ,RLANE_CD" ).append("\n"); 
		query.append("                ,BKG_POR_CD" ).append("\n"); 
		query.append("                ,BKG_POL_CD" ).append("\n"); 
		query.append("                ,BKG_POD_CD" ).append("\n"); 
		query.append("                ,BKG_DEL_CD" ).append("\n"); 
		query.append("                ,USA_BKG_MOD_CD" ).append("\n"); 
		query.append("                ,SUM(RA_CM_SUM)    AS RA_CM_SUM" ).append("\n"); 
		query.append("                ,SUM(GREV)         AS GRS_REV_SUM" ).append("\n"); 
		query.append("                ,SUM(TEU_QTY_SUM)  AS TEU_QTY_SUM" ).append("\n"); 
		query.append("                ,SUM(DMDT_SUM )    AS DMDT_SUM" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT LV.COST_YRWK" ).append("\n"); 
		query.append("                          ,DTL.TRD_CD" ).append("\n"); 
		query.append("                          ,DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("                          ,DTL.RLANE_CD" ).append("\n"); 
		query.append("                          ,DECODE(MO.OFC_KND_CD, '5', MO.PRNT_OFC_CD, DTL.SLS_OFC_CD) AS SLS_OFC_CD" ).append("\n"); 
		query.append("                          ,DTL.AGMT_CNT_CD   AS CUST_CD" ).append("\n"); 
		query.append("                          ,DTL.AGMT_CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("                          ,DTL.CTRT_OFC_CD" ).append("\n"); 
		query.append("                          ,DECODE(UPPER(SUBSTR(DTL.SC_NO, 1, 3)), 'DUM', NULL, DTL.SC_NO) AS SC_NO" ).append("\n"); 
		query.append("                           -- RFA_NO에 AES뿐만 아니라 IAS 추가" ).append("\n"); 
		query.append("                          ,CASE WHEN DTL.TRD_CD IN ('AES','IAS') THEN DECODE(UPPER(SUBSTR(DTL.RFA_NO, 1, 3)), 'DUM', NULL, DTL.RFA_NO)" ).append("\n"); 
		query.append("                                ELSE NULL" ).append("\n"); 
		query.append("                           END AS RFA_NO" ).append("\n"); 
		query.append("--                          ,DECODE(DTL.TRD_CD, 'AES', DECODE(UPPER(SUBSTR(DTL.RFA_NO, 1, 3)), 'DUM', NULL, DTL.RFA_NO), NULL) AS RFA_NO" ).append("\n"); 
		query.append("                          ,DTL.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_POR_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_POL_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_POD_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_DEL_CD" ).append("\n"); 
		query.append("                          ,NVL(SUM(DTL.BKG_REV), 0) + NVL(SUM(DTL.BKG_OFT_REV), 0) + NVL(SUM(DTL.BKG_MISC_REV), 0) + NVL(SUM(DTL.SCR_CHG_REV), 0) + NVL(SUM(DTL.DMDT_COM_AMT),0) - NVL(SUM(DTL.RA_CM_COST_TTL_AMT), 0)  AS RA_CM_SUM" ).append("\n"); 
		query.append("                          ,NVL(SUM(DTL.BKG_REV), 0) + NVL(SUM(DTL.BKG_OFT_REV), 0) + NVL(SUM(DTL.BKG_MISC_REV), 0) + NVL(SUM(DTL.SCR_CHG_REV), 0) AS GREV" ).append("\n"); 
		query.append("                          ,SUM(DECODE(SUBSTR(DTL.SPCL_CNTR_TPSZ_CD, -1), 2, DTL.BKG_QTY, 3, DTL.BKG_QTY, DTL.BKG_QTY * 2)) AS TEU_QTY_SUM" ).append("\n"); 
		query.append("                          ,NVL(SUM(DTL.DMDT_COM_AMT),0) AS DMDT_SUM" ).append("\n"); 
		query.append("                      FROM MAS_BKG_EXPN_DTL DTL" ).append("\n"); 
		query.append("                          ,MAS_MON_VVD_LV   LV" ).append("\n"); 
		query.append("                          ,MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                     WHERE DTL.COST_YRMON            = LV.COST_YRMON" ).append("\n"); 
		query.append("                       AND DTL.COST_WK               = LV.COST_WK" ).append("\n"); 
		query.append("                       AND DTL.TRD_CD                = LV.TRD_CD" ).append("\n"); 
		query.append("                       AND DTL.SUB_TRD_CD            = LV.SUB_TRD_CD" ).append("\n"); 
		query.append("                       AND DTL.RLANE_CD              = LV.RLANE_CD" ).append("\n"); 
		query.append("                       AND DTL.DIR_CD                = LV.DIR_CD" ).append("\n"); 
		query.append("                       AND DTL.BKG_STS_CD           IN ('F', 'S')" ).append("\n"); 
		query.append("                       AND DTL.BKG_CGO_TP_CD        IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                       AND DTL.SLS_OFC_CD            = MO.OFC_CD" ).append("\n"); 
		query.append("                  GROUP BY LV.COST_YRWK" ).append("\n"); 
		query.append("                          ,DTL.TRD_CD" ).append("\n"); 
		query.append("                          ,DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("                          ,DTL.RLANE_CD" ).append("\n"); 
		query.append("                          ,DECODE(MO.OFC_KND_CD, '5', MO.PRNT_OFC_CD, DTL.SLS_OFC_CD)" ).append("\n"); 
		query.append("                          ,DTL.AGMT_CNT_CD" ).append("\n"); 
		query.append("                          ,DTL.AGMT_CUST_SEQ" ).append("\n"); 
		query.append("                          ,DTL.CTRT_OFC_CD" ).append("\n"); 
		query.append("                          ,DECODE(UPPER(SUBSTR(DTL.SC_NO, 1, 3)), 'DUM', NULL, DTL.SC_NO)" ).append("\n"); 
		query.append("                          ,CASE WHEN DTL.TRD_CD IN ('AES','IAS') THEN DECODE(UPPER(SUBSTR(DTL.RFA_NO, 1, 3)), 'DUM', NULL, DTL.RFA_NO)" ).append("\n"); 
		query.append("                                ELSE NULL" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("--                          ,DECODE(DTL.TRD_CD, 'AES', DECODE(UPPER(SUBSTR(DTL.RFA_NO, 1, 3)), 'DUM', NULL, DTL.RFA_NO), NULL)" ).append("\n"); 
		query.append("                          ,DTL.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_POR_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_POL_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_POD_CD" ).append("\n"); 
		query.append("                          ,DTL.BKG_DEL_CD" ).append("\n"); 
		query.append("                 ) DTL" ).append("\n"); 
		query.append("                ,SPC_OFC_LVL O" ).append("\n"); 
		query.append("           WHERE O.OFC_CD   = SPC_SCR_OFC_CONV_FNC(DTL.SLS_OFC_CD)" ).append("\n"); 
		query.append("             AND DTL.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("             AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        GROUP BY COST_YRWK" ).append("\n"); 
		query.append("                ,CUST_CD" ).append("\n"); 
		query.append("                ,CUST_SEQ" ).append("\n"); 
		query.append("                ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                ,SC_NO" ).append("\n"); 
		query.append("                ,RFA_NO" ).append("\n"); 
		query.append("                ,TRD_CD" ).append("\n"); 
		query.append("                ,SUB_TRD_CD" ).append("\n"); 
		query.append("                ,RLANE_CD" ).append("\n"); 
		query.append("                ,O.N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                ,O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                ,NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD)" ).append("\n"); 
		query.append("                ,USA_BKG_MOD_CD" ).append("\n"); 
		query.append("                ,BKG_POR_CD" ).append("\n"); 
		query.append("                ,BKG_POL_CD" ).append("\n"); 
		query.append("                ,BKG_POD_CD" ).append("\n"); 
		query.append("                ,BKG_DEL_CD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE SLS_OFC_CD IS NOT NULL -- 잘못된 데이터를 걸러내기 위한 조건추가. 2013-12-03" ).append("\n"); 

	}
}