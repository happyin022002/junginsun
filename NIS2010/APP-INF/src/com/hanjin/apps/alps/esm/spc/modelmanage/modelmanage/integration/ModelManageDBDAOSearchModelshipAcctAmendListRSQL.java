/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : ModelManageDBDAOSearchModelshipAcctAmendListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.04.03 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchModelshipAcctAmendListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Season/Version에 등록되어 있는 Modelship Account 중 유효하지 않은 S/C, RFA 를 조회합니다.
	  * 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - Amend 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2015.02.06 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
	  * 2015.02.09 박은주 [CHM-201534243] SMP RFA amend 건
	  *                            PRI와 비교하는 기준이 상이하여 유효한 계약임에도 불구하고 유효하지 않은것으로 처리하고 있음
	  * 2015.12.29 이혜민 선반영 SMP 저장로직 변경 및 입력 날짜 기준 +30일(한달) 내 effective date를 보유한 RFA/SC시 import 가능토록 변경
	  * 2016.01.13 이혜민 [CHM-201639750] Amend 조회 로직 보완
	  * </pre>
	  */
	public ModelManageDBDAOSearchModelshipAcctAmendListRSQL(){
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
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchModelshipAcctAmendListRSQL").append("\n"); 
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
		query.append("#if (${check_amend_flg} == 'Y')" ).append("\n"); 
		query.append("       COUNT(1) AS CNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , VER_SEQ" ).append("\n"); 
		query.append("     , CUST_GRP_ID" ).append("\n"); 
		query.append("     , (SELECT CUST_GRP_NM FROM MDM_CUST_PERF_GRP WHERE T.CUST_GRP_ID=CUST_GRP_ID) AS CUST_GRP_NM" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CUST_CNT_CD||TO_CHAR(CUST_SEQ, 'FM000000') AS CUST_CD" ).append("\n"); 
		query.append("     , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE T.CUST_CNT_CD=CUST_CNT_CD AND T.CUST_SEQ=CUST_SEQ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , DTL_SEQ" ).append("\n"); 
		query.append("     , SC_NO                    AS PRE_SC_NO" ).append("\n"); 
		query.append("     , NVL(RFA_NO, SC_NO)       AS PRE_RFA_NO" ).append("\n"); 
		query.append("     , NVL2(SC_NO, 'SC', 'RFA') AS SC_RFA_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM SPC_MDL_CUST_CTRL T" ).append("\n"); 
		query.append(" WHERE T.TRD_CD    = @[trade]" ).append("\n"); 
		query.append("   AND T.COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("   AND T.VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("   AND (T.SC_NO IS NOT NULL OR T.RFA_NO IS NOT NULL)" ).append("\n"); 
		query.append("   AND T.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("   AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM PRI_RP_HDR   HDR" ).append("\n"); 
		query.append("                         , PRI_RP_MN    MN" ).append("\n"); 
		query.append("                         , MDM_CUSTOMER I" ).append("\n"); 
		query.append("                     WHERE HDR.PROP_NO       = MN.PROP_NO" ).append("\n"); 
		query.append("                       AND HDR.RFA_NO        = NVL(T.RFA_NO, T.SC_NO)" ).append("\n"); 
		query.append("                       AND MN.PROP_STS_CD    = 'A'" ).append("\n"); 
		query.append("#if (${trade} == 'AES')" ).append("\n"); 
		query.append("                       AND MN.RFA_CTRT_TP_CD = 'C' -- AES 에서는 Contract 화주만 IAS는 상관없이 모든 화주에 대해서" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       AND I.CUST_CNT_CD     = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND I.CUST_SEQ        = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                       AND I.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                       AND MN.AMDT_SEQ       = ( SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                                   FROM PRI_RP_MN K" ).append("\n"); 
		query.append("                                                  WHERE K.PROP_NO     = MN.PROP_NO" ).append("\n"); 
		query.append("                                                    AND K.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                                    AND (TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT) ) )" ).append("\n"); 
		query.append("   AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM PRI_SP_MN       M" ).append("\n"); 
		query.append("                         , PRI_SP_CTRT_PTY D" ).append("\n"); 
		query.append("                         , PRI_SP_HDR      H" ).append("\n"); 
		query.append("                         , MDM_CUSTOMER    I" ).append("\n"); 
		query.append("                     WHERE M.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("                       AND M.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("                       AND M.AMDT_SEQ           = D.AMDT_SEQ" ).append("\n"); 
		query.append("                       AND H.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("                       AND H.SC_NO              = NVL(T.SC_NO, T.RFA_NO)" ).append("\n"); 
		query.append("                       AND I.CUST_CNT_CD        = D.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND I.CUST_SEQ           = D.CUST_SEQ" ).append("\n"); 
		query.append("                       AND I.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("                       AND D.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                       AND M.AMDT_SEQ           = trim(( SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                                      FROM PRI_SP_MN K" ).append("\n"); 
		query.append("                                                     WHERE K.PROP_NO     = M.PROP_NO" ).append("\n"); 
		query.append("                                                       AND K.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                                       AND (TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT) ) ))" ).append("\n"); 

	}
}