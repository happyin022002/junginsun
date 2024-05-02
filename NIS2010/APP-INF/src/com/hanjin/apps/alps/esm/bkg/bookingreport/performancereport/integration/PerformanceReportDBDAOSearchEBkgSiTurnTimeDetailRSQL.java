/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchEBkgSiTurnTimeDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchEBkgSiTurnTimeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eBKG&SI Turn Time Detail 조회
	  * * e-BKG은 BKG Office 기준, e-SI는 Doc. Perf Office GSO 기준에 의해 실적 귀속
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchEBkgSiTurnTimeDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchEBkgSiTurnTimeDetailRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT BKG_NO,XTER_RQST_NO,XTER_RQST_SEQ, " ).append("\n"); 
		query.append("        VVD, BKG_OFC_CD, POL_CD, POD_CD, XTER_RQST_VIA_CD, PORT_CLZ_DT," ).append("\n"); 
		query.append("        --BKG_GET_CONV_INTVAL_TIME_FNC(NTC_DT-RQST_DT,'TM') TURN_TM, " ).append("\n"); 
		query.append("        ROUND(BKG_E_BKG_TURNTIME_FNC('D',substr(u.POR_CD,1,2),RQST_DT,NTC_DT),2) TURN_TM, " ).append("\n"); 
		query.append("		TO_CHAR(RQST_DT,'YYYY-MM-DD HH24:MI:SS') RQST_DT, " ).append("\n"); 
		query.append("		TO_CHAR(NTC_DT,'YYYY-MM-DD HH24:MI:SS') NTC_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT T.BKG_NO," ).append("\n"); 
		query.append("              T.VVD," ).append("\n"); 
		query.append("              T.BKG_OFC_CD," ).append("\n"); 
		query.append("			  T.PORT_CLZ_DT," ).append("\n"); 
		query.append("              T.SND_USR_ID," ).append("\n"); 
		query.append("			  T.POR_CD," ).append("\n"); 
		query.append("              T.POL_CD," ).append("\n"); 
		query.append("              T.POD_CD," ).append("\n"); 
		query.append("              X.XTER_RQST_VIA_CD," ).append("\n"); 
		query.append("              X.XTER_RQST_NO," ).append("\n"); 
		query.append("              X.XTER_RQST_SEQ," ).append("\n"); 
		query.append("              GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', X.CRE_DT, T.POR_CD ) RQST_DT," ).append("\n"); 
		query.append("              GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', t.NTC_DT, T.POR_CD ) NTC_DT," ).append("\n"); 
		query.append("              RANK() OVER(PARTITION BY X.BKG_NO, X.RQST_DT ORDER BY T.NTC_DT) NTC_RANK," ).append("\n"); 
		query.append("              RANK() OVER(PARTITION BY X.BKG_NO, T.NTC_DT ORDER BY X.RQST_DT) RQST_RANK" ).append("\n"); 
		query.append("        FROM ( SELECT N.BKG_NO, " ).append("\n"); 
		query.append("                  B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("                  B.BKG_OFC_CD," ).append("\n"); 
		query.append("				  B.PORT_CLZ_DT," ).append("\n"); 
		query.append("                  B.POR_CD," ).append("\n"); 
		query.append("                  B.POL_CD," ).append("\n"); 
		query.append("                  B.POD_CD," ).append("\n"); 
		query.append("                  N.NTC_KND_CD," ).append("\n"); 
		query.append("                  N.SND_USR_ID," ).append("\n"); 
		query.append("				  LAG(N.CRE_DT) OVER (PARTITION BY N.BKG_NO, NTC_KND_CD ORDER BY N.CRE_DT) BEF_NTC_DT," ).append("\n"); 
		query.append("                  N.CRE_DT NTC_DT" ).append("\n"); 
		query.append("                FROM BKG_BOOKING B, BKG_NTC_HIS N" ).append("\n"); 
		query.append("                WHERE N.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                  AND N.NTC_KND_CD = DECODE(@[doc_tp_cd],'B','BK','S','BL')" ).append("\n"); 
		query.append("                  AND N.SND_OFC_CD NOT IN ('SELCOS','SELCMQ')   " ).append("\n"); 
		query.append("                  AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#if (${doc_tp_cd} == 'B')" ).append("\n"); 
		query.append("				  AND N.SND_OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("#end                                 " ).append("\n"); 
		query.append("#if (${opt_tp} == 'D' && ${period} == 'B')" ).append("\n"); 
		query.append("                  AND B.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                                FROM BKG_XTER_RQST_MST X " ).append("\n"); 
		query.append("                               WHERE B.BKG_NO = X.BKG_NO " ).append("\n"); 
		query.append("                                 AND X.DOC_TP_CD = @[doc_tp_cd]" ).append("\n"); 
		query.append("#if (${opt_tp} == 'D' && ${period} == 'R')" ).append("\n"); 
		query.append("                                 AND X.RQST_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                  )                     " ).append("\n"); 
		query.append("#if (${opt_tp} == 'D' && ${period} == 'E')" ).append("\n"); 
		query.append("                  AND B.BKG_NO IN (SELECT D.BKG_NO" ).append("\n"); 
		query.append("                                     FROM BKG_VVD D" ).append("\n"); 
		query.append("                                         ,VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                    WHERE V.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("                                      AND V.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND V.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      AND V.VPS_PORT_CD = D.POL_CD" ).append("\n"); 
		query.append("                                      AND V.CLPT_IND_SEQ = D.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                      AND V.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("                  AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                  AND B.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("				  AND B.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				  AND B.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                  AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                  AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_tp_cd} == 'S/C' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("                  AND B.SC_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_tp_cd} == 'RFA' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("                  AND B.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_tp_cd} == 'TAA' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("                  AND B.TAA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')          " ).append("\n"); 
		query.append("                   AND B.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opt_tp} == 'D' && ${period} == 'B' && (${cust_cnt_cd} != '' || ${cust_grp_id} != ''))" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                 FROM BKG_CUSTOMER BC, MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                                WHERE BC.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                  AND BC.BKG_CUST_TP_CD = NVL(@[cust_tp_cd], BC.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("                                  AND BC.CUST_CNT_CD = NVL(@[cust_cnt_cd], BC.CUST_CNT_CD)" ).append("\n"); 
		query.append("                                  AND BC.CUST_SEQ = NVL(@[cust_seq], BC.CUST_SEQ)" ).append("\n"); 
		query.append("                                  AND BC.BKG_CUST_TP_CD IN (${cust_grp_tp})" ).append("\n"); 
		query.append("                                  AND BC.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                                  AND BC.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                                  AND MC.CUST_GRP_ID = NVL(@[cust_grp_id], MC.CUST_GRP_ID)" ).append("\n"); 
		query.append("                                  AND MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opt_tp} == 'D')" ).append("\n"); 
		query.append("                   AND (" ).append("\n"); 
		query.append("#foreach( ${key} in ${d_bkg_ofc_cd})" ).append("\n"); 
		query.append("	#if($velocityCount < $d_bkg_ofc_cd.size()) " ).append("\n"); 
		query.append("                          (B.BKG_OFC_CD = SUBSTR('${key}',1,5))  OR " ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("                          (B.BKG_OFC_CD = SUBSTR('${key}',1,5))  " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						)  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) T, BKG_XTER_RQST_MST X, BKG_DOC_PERF_OFC O " ).append("\n"); 
		query.append("        WHERE X.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("#if (${opt_tp} == 'D' && ${period} == 'R')" ).append("\n"); 
		query.append("          AND X.RQST_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("						FROM BKG_BL_DOC BBD " ).append("\n"); 
		query.append("						WHERE BBD.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("#if (${doc_tp_cd} == 'S')" ).append("\n"); 
		query.append("						AND   X.CRE_DT > BL_OBRD_DT - 7)" ).append("\n"); 
		query.append("#else                   " ).append("\n"); 
		query.append("                                  AND   X.CRE_DT > BL_OBRD_DT - 22)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND X.DOC_TP_CD = @[doc_tp_cd]" ).append("\n"); 
		query.append("          AND NVL(X.XTER_BL_TP_CD,'X') <> 'H'" ).append("\n"); 
		query.append("          AND NVL(X.SNACCS_MSG_TP_CD,'X') NOT IN ('SAT050', 'SAT054')" ).append("\n"); 
		query.append("          AND X.CRE_DT < NTC_DT" ).append("\n"); 
		query.append("          AND X.CRE_DT >= NVL(BEF_NTC_DT, X.CRE_DT) " ).append("\n"); 
		query.append("          AND T.BKG_OFC_CD = DECODE(SUBSTR(O.POR_CD,1,2),'JP',T.BKG_OFC_CD,O.BKG_OFC_CD)" ).append("\n"); 
		query.append("          AND T.POR_CD = DECODE(O.POR_CD,'*',T.POR_CD,O.POR_CD)" ).append("\n"); 
		query.append("#if (${opt_tp} == 'D' && ${doc_tp_cd} != 'B')" ).append("\n"); 
		query.append("          AND (" ).append("\n"); 
		query.append("#foreach( ${key} in ${d_bkg_ofc_cd})" ).append("\n"); 
		query.append("	#if($velocityCount < $d_bkg_ofc_cd.size()) " ).append("\n"); 
		query.append("               (T.BKG_OFC_CD = SUBSTR('${key}',1,5) AND  O.GSO_OFC_CD = DECODE(@[doc_tp_cd],'B',O.GSO_OFC_CD,SUBSTR('${key}',6,10))) OR " ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("               (T.BKG_OFC_CD = SUBSTR('${key}',1,5) AND  O.GSO_OFC_CD = DECODE(@[doc_tp_cd],'B',O.GSO_OFC_CD,SUBSTR('${key}',6,10)))" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) U" ).append("\n"); 
		query.append("WHERE NTC_RANK = 1" ).append("\n"); 
		query.append("#if (${doc_tp_cd} == 'S')" ).append("\n"); 
		query.append("	AND NOT EXISTS (SELECT 'X' FROM DUAL WHERE PORT_CLZ_DT < NTC_DT AND SND_USR_ID = 'SYSTEM' )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  AND RQST_RANK = 1)" ).append("\n"); 
		query.append("WHERE TURN_TM > 0" ).append("\n"); 

	}
}