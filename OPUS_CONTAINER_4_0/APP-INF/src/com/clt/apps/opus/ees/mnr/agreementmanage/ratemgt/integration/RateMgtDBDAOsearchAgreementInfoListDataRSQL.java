/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RateMgtDBDAOsearchAgreementInfoListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAgreementInfoListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAgreementInfoListData
	  * </pre>
	  */
	public RateMgtDBDAOsearchAgreementInfoListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAgreementInfoListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MAX(A.AGMT_OFC_CD)) RHQ_OFC," ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) AGMT_NO," ).append("\n"); 
		query.append("	   MAX(A.DELT_FLG) DELT_FLG," ).append("\n"); 
		query.append("       MAX(A.AGMT_OFC_CD) AGMT_OFC_CD," ).append("\n"); 
		query.append("       MAX(D.MNR_CD_DP_DESC) MNR_CD_DP_DESC," ).append("\n"); 
		query.append("       MAX(A.AGMT_VER_NO) AGMT_VER_NO," ).append("\n"); 
		query.append("       MAX(A.AGMT_REF_NO) REF_NO," ).append("\n"); 
		query.append("	   MAX(MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ)) VNDR_SEQ," ).append("\n"); 
		query.append("       MAX(A.TRF_NO) TRF_NO," ).append("\n"); 
		query.append("	   MAX(E.VNDR_LGL_ENG_NM) VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       TO_CHAR(MAX(A.EFF_DT), 'yyyy-mm-dd')||'~'||TO_CHAR(MAX(A.EXP_DT), 'yyyy-mm-dd') EFF_DT," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 1, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK1," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 2, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK2," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 3, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK3," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 4, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK4," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 5, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK5," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 6, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK6," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 7, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK7," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 8, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK8," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 9, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK9," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 10, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK10," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 11, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK11," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 12, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK12," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 13, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK13," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 14, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK14," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 15, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK15," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 16, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK16," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 17, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK17," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 18, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK18," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 19, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK19," ).append("\n"); 
		query.append("       MAX(DECODE(F.DP_SEQ, 20, DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CHK20," ).append("\n"); 
		query.append("       MAX(A.CRE_USR_ID) CRE_USR_ID," ).append("\n"); 
		query.append("       MAX(TO_CHAR(A.CRE_DT, 'YYYY-MM-DD HH24:MI:SS')) CRE_DT," ).append("\n"); 
		query.append("       MAX(A.UPD_USR_ID) UPD_USR_ID," ).append("\n"); 
		query.append("       MAX(TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI:SS')) UPD_DT" ).append("\n"); 
		query.append("FROM  MNR_AGMT_HDR A, MNR_AGMT_APLY_OFC B, MNR_AGMT_RT C, MNR_GEN_CD D, MDM_VENDOR E, " ).append("\n"); 
		query.append("	(SELECT DECODE(EQ_TP, 1, DECODE(COST_CD, 'RC', 'URC', COST_CD), 2, DECODE(COST_CD, 'RC', 'ZRC', COST_CD), 3, DECODE(COST_CD, 'RC', 'GRC', COST_CD)) COST_CD," ).append("\n"); 
		query.append("       TT AS COST_CD_NM," ).append("\n"); 
		query.append("       ROW_NUMBER() OVER (ORDER BY EQ_TP, TP) DP_SEQ" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT DECODE(SUBSTR(A.COST_CD, 5, 2), 'RC', 'RC', A.COST_CD) COST_CD," ).append("\n"); 
		query.append("                       CASE WHEN A.COST_CD LIKE '%RC' THEN 'Repair' ELSE (SELECT DISTINCT MNR_CD_DESC" ).append("\n"); 
		query.append("                                                                            FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                                                                           WHERE MNR_CD_ID = A.COST_CD" ).append("\n"); 
		query.append("                                                                             AND PRNT_CD_ID LIKE '_G') END TT ," ).append("\n"); 
		query.append("               DECODE((SELECT MNR_ORD_TP_CD" ).append("\n"); 
		query.append("                         FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                        WHERE MNR_CD_ID = A.COST_CD" ).append("\n"); 
		query.append("                          AND PRNT_CD_ID LIKE '_G'), 'LB', 1, 'TS', 2, 'QT', 3, 1) TP," ).append("\n"); 
		query.append("               DECODE((SELECT PRNT_CD_ID" ).append("\n"); 
		query.append("                         FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                        WHERE MNR_CD_ID = A.COST_CD" ).append("\n"); 
		query.append("                          AND PRNT_CD_ID LIKE '_G'), 'UG', 1, 'ZG', 2, 'GG', 3, 1) EQ_TP" ).append("\n"); 
		query.append("          FROM MNR_AGMT_RT A, MNR_AGMT_HDR B" ).append("\n"); 
		query.append("         WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("           AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("#if(${agmt_eq_type} != 'A' && ${agmt_eq_type} != '')           " ).append("\n"); 
		query.append("           AND B.EQ_KND_CD = @[agmt_eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          )) F" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND   A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("AND   B.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   B.AGMT_SEQ        = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND   B.AGMT_VER_NO     = C.AGMT_VER_NO" ).append("\n"); 
		query.append("AND   A.EQ_KND_CD       = DECODE(@[agmt_eq_type], 'A', A.EQ_KND_CD, @[agmt_eq_type])" ).append("\n"); 
		query.append("AND   ((A.EFF_DT BETWEEN TO_DATE(@[agmt_fm_dt], 'yyyy-mm-dd') AND TO_DATE(@[agmt_to_dt], 'yyyy-mm-dd')) OR (A.EXP_DT BETWEEN TO_DATE(@[agmt_fm_dt], 'yyyy-mm-dd') AND TO_DATE(@[agmt_to_dt], 'yyyy-mm-dd')))" ).append("\n"); 
		query.append("AND   A.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   D.PRNT_CD_ID = 'CD00002'" ).append("\n"); 
		query.append("AND   D.MNR_CD_ID = A.EQ_KND_CD " ).append("\n"); 
		query.append("AND   DECODE(SUBSTR(C.COST_CD, 5, 2), 'RC', A.EQ_KND_CD||'RC', C.COST_CD) = F.COST_CD" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ        = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   B.AGMT_OFC_TP_CD = 'COST'" ).append("\n"); 
		query.append("AND   B.APLY_OFC_CD LIKE @[cost_ofc_cd]||'%%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_cd} != '')" ).append("\n"); 
		query.append("AND   A.AGMT_OFC_CD IN ( select OFC_CD" ).append("\n"); 
		query.append("                         from mdm_organization" ).append("\n"); 
		query.append("                         where AR_HD_QTR_OFC_CD = @[ar_hd_qtr_cd]" ).append("\n"); 
		query.append("                         and ofc_cd LIKE @[agmt_ofc_cd]||'%%'" ).append("\n"); 
		query.append("                         and delt_flg = 'N'" ).append("\n"); 
		query.append("                       )   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   A.AGMT_OFC_CD IN ( SELECT D.OFC_CD" ).append("\n"); 
		query.append("                         FROM   MNR_OFC_GEN_INFO D" ).append("\n"); 
		query.append("                         WHERE  D.UPPR_OFC_CD  =  @[agmt_ofc_cd]" ).append("\n"); 
		query.append("                         AND    D.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("                         AND    D.COST_CD       = 'MR'" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                         SELECT @[agmt_ofc_cd]" ).append("\n"); 
		query.append("                         FROM DUAL" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${old_agmt_no} != '')" ).append("\n"); 
		query.append("AND   A.OLD_AGMT_NO = @[old_agmt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ)" ).append("\n"); 

	}
}