/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOSearchCntrOnHireApprovalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOSearchCntrOnHireApprovalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0053 컨테이너 수급 예측실적 및 정확도 조회>
	  * On-Hire Approve 정보를 조회
	  * 
	  * <Change History>
	  * 1	2009.09.04	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOSearchCntrOnHireApprovalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOSearchCntrOnHireApprovalRSQL").append("\n"); 
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
		query.append("SELECT  NVL(T1.AA, 'NotApproval') AUTH_NO," ).append("\n"); 
		query.append("T1.BB CTRT_OFC_CITY," ).append("\n"); 
		query.append("T1.CC CTRT_SEQ," ).append("\n"); 
		query.append("T1.DD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("SUM(NVL(T1.EE, 0)) APP_QTY," ).append("\n"); 
		query.append("SUM(NVL(T2.EE, 0)) PIC_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CO.CNTR_ONH_AUTH_NO AA," ).append("\n"); 
		query.append("CO.AGMT_CTY_CD BB," ).append("\n"); 
		query.append("CO.AGMT_SEQ CC," ).append("\n"); 
		query.append("DECODE(COQ.CNTR_TPSZ_CD, 'S2', 'O2', 'S4', 'O4', 'A2', 'F2', 'A4', 'F4', COQ.CNTR_TPSZ_CD) DD,  -- 하드코딩" ).append("\n"); 
		query.append("COQ.ONH_QTY EE," ).append("\n"); 
		query.append("COQ.NEW_VAN_TP_CD FF" ).append("\n"); 
		query.append("FROM LSE_ONH_APRO CO," ).append("\n"); 
		query.append("LSE_ONH_APRO_QTY COQ" ).append("\n"); 
		query.append("WHERE CO.CNTR_ONH_AUTH_NO   = COQ.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("AND CO.AGMT_CTY_CD          = COQ.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND CO.AGMT_SEQ             = COQ.AGMT_SEQ" ).append("\n"); 
		query.append("AND COQ.ONH_QTY <> 0" ).append("\n"); 
		query.append("AND NVL(CO.DELT_FLG, 'N') <>'Y' -- 하드코딩" ).append("\n"); 
		query.append("AND CO.ONH_LOC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("#if (${typeby_3} == 'R' || ${typeby_3} == 'L' || ${typeby_3} == 'E')" ).append("\n"); 
		query.append("AND DECODE('$typeby_3', 'R', B.RCC_CD, 'L', B.LCC_CD, 'E', B.ECC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CNT_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if ($arrCntrTpszCd.size() > 0)" ).append("\n"); 
		query.append("AND COQ.CNTR_TPSZ_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrCntrTpszCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- 검색조건(20081215, 20090321)" ).append("\n"); 
		query.append("-- FROM DATE : 검색조건 REPOPLANDID 주차 -12 주차의 월요일" ).append("\n"); 
		query.append("-- TO DATE   : 검색조건 REPOPLANDID 주차의 토요일" ).append("\n"); 
		query.append("AND CO.CRE_DT" ).append("\n"); 
		query.append("BETWEEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_DATE(WK_ST_DT, 'YYYYMMDD') - (12*7) + 1" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK = @[week]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_DATE(WK_END_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK = @[week]" ).append("\n"); 
		query.append(") + 0.999999" ).append("\n"); 
		query.append(") T1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  AA," ).append("\n"); 
		query.append("BB," ).append("\n"); 
		query.append("CC," ).append("\n"); 
		query.append("DD," ).append("\n"); 
		query.append("SUM(EE) EE," ).append("\n"); 
		query.append("FF" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  HS.CNTR_AUTH_NO AA," ).append("\n"); 
		query.append("HS.AGMT_CTY_CD BB," ).append("\n"); 
		query.append("HS.AGMT_SEQ CC," ).append("\n"); 
		query.append("CN.CNTR_TPSZ_CD DD," ).append("\n"); 
		query.append("COUNT(HS.CNTR_NO) EE," ).append("\n"); 
		query.append("DECODE(HS.CNTR_OLD_VAN_FLG, 'N', 'N', 'Y', 'N') FF -- 하드코딩" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MST_CNTR_STS_HIS HS," ).append("\n"); 
		query.append("LSE_AGREEMENT CT," ).append("\n"); 
		query.append("MST_CONTAINER CN" ).append("\n"); 
		query.append("WHERE HS.CNTR_NO = CN.CNTR_NO" ).append("\n"); 
		query.append("AND HS.AGMT_CTY_CD = CT.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND HS.AGMT_SEQ = CT.AGMT_SEQ" ).append("\n"); 
		query.append("AND SUBSTR(NVL(HS.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE' -- 하드코딩" ).append("\n"); 
		query.append("AND HS.CNTR_LSTM_CNG_FLG IS NULL" ).append("\n"); 
		query.append("AND (HS.CNTR_STS_CD = 'LSI' OR HS.CNTR_STS_CD = 'OWN')  -- 하드코딩" ).append("\n"); 
		query.append("AND HS.AGMT_SEQ <> 999990   -- 하드코딩" ).append("\n"); 
		query.append("AND HS.CNTR_AUTH_NO IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CO.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("FROM LSE_ONH_APRO CO," ).append("\n"); 
		query.append("LSE_ONH_APRO_QTY COQ" ).append("\n"); 
		query.append("WHERE CO.CNTR_ONH_AUTH_NO = CO.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("AND CO.CNTR_ONH_AUTH_NO = COQ.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("AND CO.AGMT_CTY_CD = COQ.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND CO.AGMT_SEQ = COQ.AGMT_SEQ" ).append("\n"); 
		query.append("AND COQ.ONH_QTY <> 0" ).append("\n"); 
		query.append("AND NVL(CO.DELT_FLG, 'N') <> 'Y'  -- 하드코딩" ).append("\n"); 
		query.append("-- 검색조건(20081215, 20090321)" ).append("\n"); 
		query.append("-- FROM DATE : 검색조건 REPOPLANDID 주차 -12 주차의 월요일" ).append("\n"); 
		query.append("-- TO DATE   : 검색조건 REPOPLANDID 주차의 토요일" ).append("\n"); 
		query.append("AND CO.CRE_DT" ).append("\n"); 
		query.append("BETWEEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_DATE(WK_ST_DT, 'YYYYMMDD') - (12*7) + 1" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK = @[week]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_DATE(WK_END_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR||PLN_WK = @[week]" ).append("\n"); 
		query.append(") + 0.999999" ).append("\n"); 
		query.append("AND CO.ONH_LOC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("#if (${typeby_3} == 'R' || ${typeby_3} == 'L' || ${typeby_3} == 'E')" ).append("\n"); 
		query.append("AND DECODE('$typeby_3', 'R', B.RCC_CD, 'L', B.LCC_CD, 'E', B.ECC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CNT_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND HS.LOC_CD IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("#if (${typeby_3} == 'R' || ${typeby_3} == 'L' || ${typeby_3} == 'E')" ).append("\n"); 
		query.append("AND DECODE('$typeby_3', 'R', B.RCC_CD, 'L', B.LCC_CD, 'E', B.ECC_CD) = @[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CNT_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY HS.CNTR_AUTH_NO, HS.AGMT_CTY_CD, HS.AGMT_SEQ, CN.CNTR_TPSZ_CD, HS.LOC_CD, DECODE(HS.CNTR_OLD_VAN_FLG, 'N', 'N', 'Y', 'N')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY AA, BB, CC, DD, FF ) T2" ).append("\n"); 
		query.append("WHERE T1.AA = T2.AA(+)" ).append("\n"); 
		query.append("AND T1.BB = T2.BB(+)" ).append("\n"); 
		query.append("AND T1.CC = T2.CC(+)" ).append("\n"); 
		query.append("AND T1.DD = T2.DD(+)" ).append("\n"); 
		query.append("AND T1.FF = T2.FF(+)" ).append("\n"); 
		query.append("GROUP BY NVL(T1.AA, 'NotApproval'), T1.BB, T1.CC, T1.DD, T1.FF" ).append("\n"); 
		query.append("ORDER BY NVL(T1.AA, 'NotApproval')" ).append("\n"); 

	}
}