/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOSearchModelshipAcctListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchModelshipAcctListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Season/Version에 등록되어 있는 Modelship Account를 조회합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.09.04 [Trouble Shooting] 현재 유효한 PRI의 정보와 차이 나는 경우 빨간 글씨로 표시
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2014.06.09 RFA에 'AES' Trade일 경우만 적용되도록 보완
	  * 2015.01.29 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
	  * 2015.02.09 박은주 [CHM-201534243] SMP RFA amend 건
	  *                            PRI와 비교하는 기준이 상이하여 유효한 계약임에도 불구하고 유효하지 않은것으로 처리하고 있음
	  * 2015.12.29 선반영 이혜민 SMP 저장로직 변경 및 입력 날짜 기준 +30일(한달) 내 effective date를 보유한 RFA/SC시 import 가능토록 변경
	  * </pre>
	  */
	public ModelManageDBDAOSearchModelshipAcctListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchModelshipAcctListRSQL").append("\n"); 
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
		query.append("WITH CRNT_SC AS (" ).append("\n"); 
		query.append("    SELECT D.CUST_CNT_CD" ).append("\n"); 
		query.append("         , D.CUST_SEQ" ).append("\n"); 
		query.append("         , H.SC_NO" ).append("\n"); 
		query.append("      FROM PRI_SP_MN       M" ).append("\n"); 
		query.append("         , PRI_SP_CTRT_PTY D" ).append("\n"); 
		query.append("         , PRI_SP_HDR      H" ).append("\n"); 
		query.append("         , MDM_CUSTOMER    I" ).append("\n"); 
		query.append("     WHERE M.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("       AND M.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("       AND M.AMDT_SEQ           = D.AMDT_SEQ" ).append("\n"); 
		query.append("       AND H.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("       AND I.CUST_CNT_CD        = D.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND I.CUST_SEQ           = D.CUST_SEQ" ).append("\n"); 
		query.append("       AND I.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("       AND D.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND M.AMDT_SEQ           = ( SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                      FROM PRI_SP_MN K" ).append("\n"); 
		query.append("                                     WHERE K.PROP_NO     = M.PROP_NO" ).append("\n"); 
		query.append("                                       AND K.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                       AND ( TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT) )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CRNT_RFA AS (" ).append("\n"); 
		query.append("    SELECT I.CUST_CNT_CD" ).append("\n"); 
		query.append("         , I.CUST_SEQ" ).append("\n"); 
		query.append("         , HDR.RFA_NO" ).append("\n"); 
		query.append("      FROM PRI_RP_HDR              HDR" ).append("\n"); 
		query.append("         , PRI_RP_MN               MN" ).append("\n"); 
		query.append("         , MDM_CUSTOMER            I" ).append("\n"); 
		query.append("     WHERE HDR.PROP_NO       = MN.PROP_NO" ).append("\n"); 
		query.append("       AND MN.PROP_STS_CD    = 'A'" ).append("\n"); 
		query.append("#if (${trade} == 'AES')" ).append("\n"); 
		query.append("       AND MN.RFA_CTRT_TP_CD = 'C' -- AES 에서는 Contract 화주만 IAS는 상관없이 모든 화주에 대해서" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND I.CUST_CNT_CD     = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("       AND I.CUST_SEQ        = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("       AND I.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("       AND MN.AMDT_SEQ       = ( SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                   FROM PRI_RP_MN K" ).append("\n"); 
		query.append("                                  WHERE K.PROP_NO     = MN.PROP_NO" ).append("\n"); 
		query.append("                                    AND K.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                    AND ( TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT) )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pop_yn} == 'N')" ).append("\n"); 
		query.append("  SELECT COST_YRWK" ).append("\n"); 
		query.append("       , VER_SEQ" ).append("\n"); 
		query.append("       , CUST_CNT_CD" ).append("\n"); 
		query.append("       , CUST_SEQ" ).append("\n"); 
		query.append("       , CUST_CD" ).append("\n"); 
		query.append("       , CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       , DTL_SEQ" ).append("\n"); 
		query.append("       , CUST_GRP_ID" ).append("\n"); 
		query.append("       , CUST_GRP_NM" ).append("\n"); 
		query.append("       , SC_NO" ).append("\n"); 
		query.append("       , RFA_NO" ).append("\n"); 
		query.append("       , CUST_CTRL_CD" ).append("\n"); 
		query.append("       , CTRT_OFC_CD" ).append("\n"); 
		query.append("       , CRNT_SC_YN" ).append("\n"); 
		query.append("       , CRNT_RFA_YN" ).append("\n"); 
		query.append("       , SC_RFA_FLG" ).append("\n"); 
		query.append("       , SUB_TRD_CD" ).append("\n"); 
		query.append("       , DECODE(SUB_TRD_CD, '*', '', SUBSTR(SUB_TRD_CD,  1, 2)) AS SUB_TRD_1" ).append("\n"); 
		query.append("       , SUBSTR(SUB_TRD_CD,  4, 2) AS SUB_TRD_2" ).append("\n"); 
		query.append("       , SUBSTR(SUB_TRD_CD,  7, 2) AS SUB_TRD_3" ).append("\n"); 
		query.append("       , SUBSTR(SUB_TRD_CD, 10, 2) AS SUB_TRD_4" ).append("\n"); 
		query.append("       , SUBSTR(SUB_TRD_CD, 13, 2) AS SUB_TRD_5" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT COST_YRWK" ).append("\n"); 
		query.append("                 , VER_SEQ" ).append("\n"); 
		query.append("                 , CUST_CNT_CD" ).append("\n"); 
		query.append("                 , CUST_SEQ" ).append("\n"); 
		query.append("                 , CUST_CD" ).append("\n"); 
		query.append("                 , CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                 , DTL_SEQ" ).append("\n"); 
		query.append("                 , CUST_GRP_ID" ).append("\n"); 
		query.append("                 , CUST_GRP_NM" ).append("\n"); 
		query.append("                 , SC_NO" ).append("\n"); 
		query.append("                 , RFA_NO" ).append("\n"); 
		query.append("                 , CUST_CTRL_CD" ).append("\n"); 
		query.append("                 , CTRT_OFC_CD" ).append("\n"); 
		query.append("                 , CRNT_SC_YN" ).append("\n"); 
		query.append("                 , CRNT_RFA_YN" ).append("\n"); 
		query.append("                 , SC_RFA_FLG" ).append("\n"); 
		query.append("                 , SUBSTR(MAX(SYS_CONNECT_BY_PATH(SUB_TRD_CD, ',')), 2) AS SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      SELECT COST_YRWK" ).append("\n"); 
		query.append("                           , VER_SEQ" ).append("\n"); 
		query.append("                           , CUST_CNT_CD" ).append("\n"); 
		query.append("                           , CUST_SEQ" ).append("\n"); 
		query.append("                           , CUST_CNT_CD||TO_CHAR(CUST_SEQ, 'FM000000') AS CUST_CD" ).append("\n"); 
		query.append("                           , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE T.CUST_CNT_CD=CUST_CNT_CD AND T.CUST_SEQ=CUST_SEQ) CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                           , DTL_SEQ" ).append("\n"); 
		query.append("                           , CUST_GRP_ID" ).append("\n"); 
		query.append("                           , (SELECT CUST_GRP_NM FROM MDM_CUST_PERF_GRP WHERE T.CUST_GRP_ID=CUST_GRP_ID) CUST_GRP_NM" ).append("\n"); 
		query.append("                           , SC_NO" ).append("\n"); 
		query.append("                           , DECODE(TRD_CD,'AES',NVL(RFA_NO, SC_NO),'IAS',NVL(RFA_NO, SC_NO),'') AS RFA_NO" ).append("\n"); 
		query.append("                           , CUST_CTRL_CD" ).append("\n"); 
		query.append("                           , WK_MQC_QTY" ).append("\n"); 
		query.append("                           , (SELECT MAX(OFC_CD)" ).append("\n"); 
		query.append("                                FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                               WHERE T.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                                 AND T.CUST_SEQ    = M.CUST_SEQ" ).append("\n"); 
		query.append("                             ) AS CTRT_OFC_CD" ).append("\n"); 
		query.append("                           , ACCT_PIC_NM" ).append("\n"); 
		query.append("                           , SUB_TRD_CD" ).append("\n"); 
		query.append("                           , NVL((SELECT 'Y' FROM CRNT_SC  C WHERE C.CUST_CNT_CD = T.CUST_CNT_CD AND C.CUST_SEQ = T.CUST_SEQ AND C.SC_NO  = T.SC_NO ), 'N') AS CRNT_SC_YN" ).append("\n"); 
		query.append("                           , NVL((SELECT 'Y' FROM CRNT_RFA C WHERE C.CUST_CNT_CD = T.CUST_CNT_CD AND C.CUST_SEQ = T.CUST_SEQ AND C.RFA_NO = T.RFA_NO), 'N') AS CRNT_RFA_YN" ).append("\n"); 
		query.append("                           , NVL2(SC_NO, 'SC', 'RFA') AS SC_RFA_FLG" ).append("\n"); 
		query.append("#if (${pop_yn} == 'N')" ).append("\n"); 
		query.append("                           , DENSE_RANK() OVER (PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY SUB_TRD_CD) AS RNUM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        FROM SPC_MDL_CUST_CTRL T" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND TRD_CD    = @[trade]" ).append("\n"); 
		query.append("#if (${pop_yn} == 'N')" ).append("\n"); 
		query.append("                         AND COST_YRWK = '200001' --비수기" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                         AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                         AND VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         AND DELT_FLG  = 'N'" ).append("\n"); 
		query.append("#if (${pop_yn} == 'N')" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("        START WITH RNUM = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CNT_CD = CUST_CNT_CD AND PRIOR CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("          GROUP BY COST_YRWK" ).append("\n"); 
		query.append("                 , VER_SEQ" ).append("\n"); 
		query.append("                 , CUST_CNT_CD" ).append("\n"); 
		query.append("                 , CUST_SEQ" ).append("\n"); 
		query.append("                 , CUST_CD" ).append("\n"); 
		query.append("                 , CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                 , DTL_SEQ" ).append("\n"); 
		query.append("                 , CUST_GRP_ID" ).append("\n"); 
		query.append("                 , CUST_GRP_NM" ).append("\n"); 
		query.append("                 , SC_NO" ).append("\n"); 
		query.append("                 , RFA_NO" ).append("\n"); 
		query.append("                 , CUST_CTRL_CD" ).append("\n"); 
		query.append("                 , CTRT_OFC_CD" ).append("\n"); 
		query.append("                 , CRNT_SC_YN" ).append("\n"); 
		query.append("                 , CRNT_RFA_YN" ).append("\n"); 
		query.append("                 , SC_RFA_FLG" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CUST_GRP_NM" ).append("\n"); 
		query.append("       , CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       , SC_NO" ).append("\n"); 
		query.append("       , RFA_NO" ).append("\n"); 

	}
}