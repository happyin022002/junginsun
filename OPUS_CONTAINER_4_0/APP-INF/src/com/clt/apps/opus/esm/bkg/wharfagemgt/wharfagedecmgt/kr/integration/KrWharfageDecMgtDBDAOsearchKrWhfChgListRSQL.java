/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfChgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfChgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfChgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfChgListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO," ).append("\n"); 
		query.append("      (A.BL_NO || A.BL_TP_CD) AS BL_NO," ).append("\n"); 
		query.append("       REPLACE(A.CUST_NM, CHR(13)||CHR(10), ' ') AS CUST_NM," ).append("\n"); 
		query.append("       A.XPT_REF_NO," ).append("\n"); 
		query.append("       B.RAT_UT_CD," ).append("\n"); 
		query.append("       B.RAT_AS_QTY_SUM," ).append("\n"); 
		query.append("       DECODE(B.CURR_CD, ' ', B.CHG_AMT_SUM, B.CHG_AMT_SUM * C.LOCL_CNY_XCH_RT) AS AMOUNT," ).append("\n"); 
		query.append("       D.TEU_QTY, " ).append("\n"); 
		query.append("       D.FEU_QTY, " ).append("\n"); 
		query.append("       D.HCB_QTY," ).append("\n"); 
		query.append("       A.BL_CVRD_TP_CD," ).append("\n"); 
		query.append("       -- A.BKG_RT_WHF_EXPT_CD," ).append("\n"); 
		query.append("       F.ATTR_CTNT4 AS BKG_RT_WHF_EXPT_CD,  -- VO 수정을 피하기 위해  알리아싱을 수정대상 원 이름으로 정했다." ).append("\n"); 
		query.append("       A.WHF_SHPR_RGST_NO," ).append("\n"); 
		query.append("       A.BL_TP_CD," ).append("\n"); 
		query.append("       B.CNTR_SZ_CD," ).append("\n"); 
		query.append("       DECODE(D.TEU_QTY, 0, 0, E.TEU_QTY) AS F_TEU_QTY," ).append("\n"); 
		query.append("       DECODE(D.FEU_QTY, 0, 0, E.FEU_QTY) AS F_FEU_QTY," ).append("\n"); 
		query.append("       DECODE(D.HCB_QTY, 0, 0, E.HCB_QTY) AS F_HCB_QTY" ).append("\n"); 
		query.append("  FROM ( SELECT B.BKG_NO, B.BL_NO, B.BL_TP_CD, NVL(E.CUST_NM, BKG_GET_BKG_CTMS_CD_FNC('KR','WHF_CHG_CUST_NM',1,1) ) AS CUST_NM, F.CUST_NM AS XPT_REF_NO, D.BKG_RT_WHF_EXPT_CD, D.WHF_SHPR_RGST_NO, C.BL_CVRD_TP_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_DOC C, BKG_RATE D, BKG_CUSTOMER E, BKG_CUSTOMER F" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND A.POL_CD LIKE @[pol_cd] || '%' -- POL 조건" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND A.POD_CD LIKE @[pod_cd] || '%' -- POD 조건" ).append("\n"); 
		query.append("	AND B.POD_CD = A.POD_CD -- POD 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.POL_CD = A.POL_CD" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'A')" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND D.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_CUST_TP_CD(+) = @[bkg_cust_tp_cd]  -- 'S':OUTBOUND 'C':INBOUND" ).append("\n"); 
		query.append("   AND F.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND F.BKG_CUST_TP_CD(+) = 'E' ) A, ( SELECT A.BKG_NO, B.RAT_UT_CD, B.CURR_CD, TO_CHAR(B.CRE_DT, 'YYYYMM') AS CRE_DT," ).append("\n"); 
		query.append("       DECODE(C.RAT_UT_GRP_CD, 'E', C.CNTR_SZ_CD, C.RAT_UT_GRP_CD) AS CNTR_SZ_CD," ).append("\n"); 
		query.append("       SUM(B.CHG_AMT) AS CHG_AMT_SUM, SUM(B.RAT_AS_QTY) AS RAT_AS_QTY_SUM" ).append("\n"); 
		query.append("  FROM ( SELECT B.BKG_NO, B.BL_NO, B.BL_TP_CD, NVL(E.CUST_NM, BKG_GET_BKG_CTMS_CD_FNC('KR','WHF_CHG_CUST_NM',1,1)) AS CUST_NM, F.CUST_NM AS XPT_REF_NO, D.BKG_RT_WHF_EXPT_CD, D.WHF_SHPR_RGST_NO, C.BL_CVRD_TP_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_DOC C, BKG_RATE D, BKG_CUSTOMER E, BKG_CUSTOMER F" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND A.POL_CD LIKE @[pol_cd] || '%' -- POL 조건" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND A.POD_CD LIKE @[pod_cd] || '%' -- POD 조건" ).append("\n"); 
		query.append("	AND B.POD_CD = A.POD_CD -- POD 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.POL_CD = A.POL_CD" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'A')" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND D.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_CUST_TP_CD(+) = @[bkg_cust_tp_cd]  -- 'S':OUTBOUND 'C':INBOUND" ).append("\n"); 
		query.append("   AND F.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND F.BKG_CUST_TP_CD(+) = 'E' ) A, BKG_CHG_RT B, PRI_RAT_UT C" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.CHG_CD = 'WHF'" ).append("\n"); 
		query.append("   AND C.RAT_UT_CD(+) = B.RAT_UT_CD" ).append("\n"); 
		query.append(" GROUP BY A.BKG_NO, B.RAT_UT_CD, B.CURR_CD, TO_CHAR(B.CRE_DT, 'YYYYMM')," ).append("\n"); 
		query.append("       DECODE(C.RAT_UT_GRP_CD, 'E', C.CNTR_SZ_CD, C.RAT_UT_GRP_CD) ) B, GL_MON_XCH_RT C, ( SELECT A.BKG_NO," ).append("\n"); 
		query.append("       NVL(SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) =  '2' THEN OP_CNTR_QTY ELSE 0 END), 0) AS TEU_QTY," ).append("\n"); 
		query.append("       NVL(SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) IN ('3', '4', '5') THEN OP_CNTR_QTY ELSE 0 END), 0) AS FEU_QTY," ).append("\n"); 
		query.append("       NVL(SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) IN ('2', '3', '4', '5') THEN 0 ELSE OP_CNTR_QTY END), 0) AS HCB_QTY" ).append("\n"); 
		query.append("  FROM ( SELECT B.BKG_NO, B.BL_NO, B.BL_TP_CD, NVL(E.CUST_NM, BKG_GET_BKG_CTMS_CD_FNC('KR','WHF_CHG_CUST_NM',1,1) ) AS CUST_NM, F.CUST_NM AS XPT_REF_NO, D.BKG_RT_WHF_EXPT_CD, D.WHF_SHPR_RGST_NO, C.BL_CVRD_TP_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_DOC C, BKG_RATE D, BKG_CUSTOMER E, BKG_CUSTOMER F" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND A.POL_CD LIKE @[pol_cd] || '%' -- POL 조건" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND A.POD_CD LIKE @[pod_cd] || '%' -- POD 조건" ).append("\n"); 
		query.append("	AND B.POD_CD = A.POD_CD -- POD 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.POL_CD = A.POL_CD" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'A')" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND D.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_CUST_TP_CD(+) = @[bkg_cust_tp_cd]  -- 'S':OUTBOUND 'C':INBOUND" ).append("\n"); 
		query.append("   AND F.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND F.BKG_CUST_TP_CD(+) = 'E' ) A, BKG_QUANTITY B" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append(" GROUP BY A.BKG_NO ) D, ( SELECT A.BKG_NO," ).append("\n"); 
		query.append("       NVL(SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) =  '2' THEN CNTR_VOL_QTY ELSE 0 END), 0) AS TEU_QTY," ).append("\n"); 
		query.append("       NVL(SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) IN ('3', '4', '5') THEN CNTR_VOL_QTY ELSE 0 END), 0) AS FEU_QTY," ).append("\n"); 
		query.append("       NVL(SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) IN ('2', '3', '4', '5') THEN 0 ELSE CNTR_VOL_QTY END), 0) AS HCB_QTY" ).append("\n"); 
		query.append("  FROM ( SELECT B.BKG_NO, B.BL_NO, B.BL_TP_CD, NVL(E.CUST_NM, BKG_GET_BKG_CTMS_CD_FNC('KR','WHF_CHG_CUST_NM',1,1)  ) AS CUST_NM, F.CUST_NM AS XPT_REF_NO, D.BKG_RT_WHF_EXPT_CD, D.WHF_SHPR_RGST_NO, C.BL_CVRD_TP_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_DOC C, BKG_RATE D, BKG_CUSTOMER E, BKG_CUSTOMER F" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND A.POL_CD LIKE @[pol_cd] || '%' -- POL 조건" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND A.POD_CD LIKE @[pod_cd] || '%' -- POD 조건" ).append("\n"); 
		query.append("	AND B.POD_CD = A.POD_CD -- POD 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.POL_CD = A.POL_CD" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'A')" ).append("\n"); 
		query.append("   AND C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND D.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_CUST_TP_CD(+) = @[bkg_cust_tp_cd]  -- 'S':OUTBOUND 'C':INBOUND" ).append("\n"); 
		query.append("   AND F.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND F.BKG_CUST_TP_CD(+) = 'E' ) A, BKG_CONTAINER B" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND (NVL(A.BKG_RT_WHF_EXPT_CD, 'N') <> 'B' OR" ).append("\n"); 
		query.append("        (A.BKG_RT_WHF_EXPT_CD = 'B' AND B.RCV_TERM_CD IN ('I', 'T')))" ).append("\n"); 
		query.append(" GROUP BY A.BKG_NO ) E," ).append("\n"); 
		query.append("       BKG_HRD_CDG_CTNT F" ).append("\n"); 
		query.append(" WHERE B.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND C.ACCT_XCH_RT_YRMON(+) = B.CRE_DT" ).append("\n"); 
		query.append("   AND C.ACCT_XCH_RT_LVL(+) = '1'" ).append("\n"); 
		query.append("   AND C.CURR_CD(+) = B.CURR_CD" ).append("\n"); 
		query.append("   AND D.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND F.HRD_CDG_ID(+) = 'KR_WHF_EXEMPT_CD'" ).append("\n"); 
		query.append("   AND F.ATTR_CTNT1(+) = A.BKG_RT_WHF_EXPT_CD" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} == 'N')" ).append("\n"); 
		query.append("   AND A.BKG_RT_WHF_EXPT_CD = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} == 'Y')" ).append("\n"); 
		query.append("   AND A.BKG_RT_WHF_EXPT_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} == 'X')" ).append("\n"); 
		query.append("   AND A.BKG_RT_WHF_EXPT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}