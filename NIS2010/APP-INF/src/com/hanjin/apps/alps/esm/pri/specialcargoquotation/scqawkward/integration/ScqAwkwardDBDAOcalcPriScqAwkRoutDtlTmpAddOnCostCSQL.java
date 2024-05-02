/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpAddOnCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.15
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.04.15 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpAddOnCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_ROUT_DTL_TMP 의 POL - T/S1, T/S Last - POD 구간 - Cargo 별 
	  * Add - On Cost 계산 및 결과 생성
	  * </pre>
	  */
	public ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpAddOnCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no_tmp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpAddOnCostCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCQ_AWK_ROUT_DTL_TMP" ).append("\n"); 
		query.append("(       SCQ_RQST_NO" ).append("\n"); 
		query.append("    ,   SCQ_VER_NO" ).append("\n"); 
		query.append("    ,   ROUT_SEQ" ).append("\n"); 
		query.append("    ,   ROUT_COST_SEQ" ).append("\n"); 
		query.append("    ,   ROUT_COST_DTL_SEQ" ).append("\n"); 
		query.append("    ,   COST_TP_CD" ).append("\n"); 
		query.append("    ,   FM_YD_CD" ).append("\n"); 
		query.append("    ,   TO_YD_CD" ).append("\n"); 
		query.append("    ,   CGO_SEQ" ).append("\n"); 
		query.append("    ,   CNTR_QTY" ).append("\n"); 
		query.append("    ,   USD_AMT" ).append("\n"); 
		query.append("    ,   SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("    ,   CRE_USR_ID" ).append("\n"); 
		query.append("    ,   CRE_DT" ).append("\n"); 
		query.append("    ,   UPD_USR_ID" ).append("\n"); 
		query.append("    ,   UPD_DT" ).append("\n"); 
		query.append(")    " ).append("\n"); 
		query.append("WITH" ).append("\n"); 
		query.append("ROUT_CS AS (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                DECODE ( ROUT_TP_CD, 'L', N_ROUT_SEQ, 'P', B_ROUT_SEQ ) AS ROUT_SEQ" ).append("\n"); 
		query.append("            ,   'N' AS ROUT_TP_CD" ).append("\n"); 
		query.append("            ,   ROUT_TP_CD AS ORG_ROUT_TP_CD" ).append("\n"); 
		query.append("            ,   DECODE ( ROUT_TP_CD, 'L', N_ROUT_TP_SEQ, 'P', B_ROUT_TP_SEQ ) AS ROUT_TP_SEQ" ).append("\n"); 
		query.append("            ,   DECODE ( ROUT_TP_CD, 'L', OB_YD_CD, 'P', B_OB_YD_CD ) AS IB_YD_CD" ).append("\n"); 
		query.append("            ,   DECODE ( ROUT_TP_CD, 'L', N_IB_YD_CD, 'P', IB_YD_CD ) AS OB_YD_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (   SELECT  ROUT_SEQ," ).append("\n"); 
		query.append("                        ROUT_TP_CD," ).append("\n"); 
		query.append("                        IB_YD_CD," ).append("\n"); 
		query.append("                        OB_YD_CD," ).append("\n"); 
		query.append("                        LEAD ( ROUT_SEQ ) OVER ( ORDER BY ROUT_SEQ ) N_ROUT_SEQ," ).append("\n"); 
		query.append("                        LAG ( ROUT_SEQ ) OVER ( ORDER BY ROUT_SEQ ) B_ROUT_SEQ," ).append("\n"); 
		query.append("                        LEAD ( ROUT_TP_CD ) OVER ( ORDER BY ROUT_SEQ ) N_ROUT_TP_CD," ).append("\n"); 
		query.append("                        LAG ( ROUT_TP_CD ) OVER ( ORDER BY ROUT_SEQ ) B_ROUT_TP_CD," ).append("\n"); 
		query.append("                        LEAD ( ROUT_TP_SEQ ) OVER ( ORDER BY ROUT_SEQ ) N_ROUT_TP_SEQ," ).append("\n"); 
		query.append("                        LAG ( ROUT_TP_SEQ ) OVER ( ORDER BY ROUT_SEQ ) B_ROUT_TP_SEQ," ).append("\n"); 
		query.append("                        LEAD ( IB_YD_CD ) OVER ( ORDER BY ROUT_SEQ ) N_IB_YD_CD," ).append("\n"); 
		query.append("                        LEAD ( OB_YD_CD ) OVER ( ORDER BY ROUT_SEQ ) N_OB_YD_CD," ).append("\n"); 
		query.append("                        LAG ( IB_YD_CD ) OVER ( ORDER BY ROUT_SEQ ) B_IB_YD_CD," ).append("\n"); 
		query.append("                        LAG ( OB_YD_CD ) OVER ( ORDER BY ROUT_SEQ ) B_OB_YD_CD" ).append("\n"); 
		query.append("                FROM    PRI_SCQ_AWK_ROUT_TMP A" ).append("\n"); 
		query.append("                WHERE   A.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("                AND     A.SCQ_VER_NO = @[scq_ver_no_tmp] )" ).append("\n"); 
		query.append("        WHERE (  ROUT_TP_CD = 'L' AND N_ROUT_TP_CD = 'N' )" ).append("\n"); 
		query.append("        OR    (  ROUT_TP_CD = 'P' AND B_ROUT_TP_CD = 'N' )" ).append("\n"); 
		query.append(")           " ).append("\n"); 
		query.append(", ROUT_PRIORITY_LIST AS (" ).append("\n"); 
		query.append("    SELECT  B.ROUT_SEQ, B.ROUT_TP_CD, B.ORG_ROUT_TP_CD" ).append("\n"); 
		query.append("        ,   B.IB_YD_CD, B.OB_YD_CD" ).append("\n"); 
		query.append("        ,   A.FM_LOC_CD, A.FM_NOD_YD_NO" ).append("\n"); 
		query.append("        ,   A.TO_LOC_CD, A.TO_NOD_YD_NO" ).append("\n"); 
		query.append("        ,   A.COND_NO" ).append("\n"); 
		query.append("        ,   MAX ( A.TML_AWK_ADON_VER_NO ) AS MAX_VER_NO" ).append("\n"); 
		query.append("        ,   CASE WHEN LENGTH ( B.IB_YD_CD ) = 7 AND LENGTH ( B.OB_YD_CD ) = 7 THEN" ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO <> ' ' AND A.TO_NOD_YD_NO <> ' ' THEN 4" ).append("\n"); 
		query.append("                     WHEN A.FM_NOD_YD_NO <> ' ' AND A.TO_NOD_YD_NO = ' ' THEN 3" ).append("\n"); 
		query.append("                     WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO <> ' ' THEN 2" ).append("\n"); 
		query.append("                     WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO = ' ' THEN 1 ELSE 0 END " ).append("\n"); 
		query.append("            WHEN LENGTH ( B.IB_YD_CD ) = 5 AND LENGTH ( B.OB_YD_CD ) = 7 THEN " ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO <> ' ' THEN 1 ELSE 0 END          " ).append("\n"); 
		query.append("            WHEN LENGTH ( B.IB_YD_CD ) = 7 AND LENGTH ( B.OB_YD_CD ) = 5 THEN " ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO <> ' ' AND A.TO_NOD_YD_NO = ' ' THEN 1 ELSE 0 END          " ).append("\n"); 
		query.append("            WHEN LENGTH ( B.IB_YD_CD ) = 5 AND LENGTH ( B.OB_YD_CD ) = 5 THEN " ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO = ' ' THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("            ELSE 0 END AS PRIORITY  " ).append("\n"); 
		query.append("        ,   MAX ( CASE WHEN LENGTH ( B.IB_YD_CD ) = 7 AND LENGTH ( B.OB_YD_CD ) = 7 THEN" ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO <> ' ' AND A.TO_NOD_YD_NO <> ' ' THEN 4" ).append("\n"); 
		query.append("                     WHEN A.FM_NOD_YD_NO <> ' ' AND A.TO_NOD_YD_NO = ' ' THEN 3" ).append("\n"); 
		query.append("                     WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO <> ' ' THEN 2" ).append("\n"); 
		query.append("                     WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO = ' ' THEN 1 ELSE 0 END " ).append("\n"); 
		query.append("            WHEN LENGTH ( B.IB_YD_CD ) = 5 AND LENGTH ( B.OB_YD_CD ) = 7 THEN " ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO <> ' ' THEN 1 ELSE 0 END          " ).append("\n"); 
		query.append("            WHEN LENGTH ( B.IB_YD_CD ) = 7 AND LENGTH ( B.OB_YD_CD ) = 5 THEN " ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO <> ' ' AND A.TO_NOD_YD_NO = ' ' THEN 1 ELSE 0 END          " ).append("\n"); 
		query.append("            WHEN LENGTH ( B.IB_YD_CD ) = 5 AND LENGTH ( B.OB_YD_CD ) = 5 THEN " ).append("\n"); 
		query.append("                CASE WHEN A.FM_NOD_YD_NO = ' ' AND A.TO_NOD_YD_NO = ' ' THEN 1 ELSE 0 END  " ).append("\n"); 
		query.append("            ELSE 0 END ) OVER ( PARTITION BY B.ROUT_SEQ, B.ORG_ROUT_TP_CD ) AS MAX_PRIORITY" ).append("\n"); 
		query.append("    FROM    TES_AWK_CGO_ADON_HDR A, ROUT_CS B" ).append("\n"); 
		query.append("    WHERE   A.FM_LOC_CD = SUBSTR ( B.IB_YD_CD, 1, 5 ) AND ( A.FM_NOD_YD_NO = ' ' OR  A.FM_NOD_YD_NO = SUBSTR ( B.IB_YD_CD, 6, 2 ) )" ).append("\n"); 
		query.append("    AND     A.TO_LOC_CD = SUBSTR ( B.OB_YD_CD, 1, 5 ) AND ( A.TO_NOD_YD_NO = ' ' OR  A.TO_NOD_YD_NO = SUBSTR ( B.OB_YD_CD, 6, 2 ) )" ).append("\n"); 
		query.append("--  AND     A.COND_NO <> '0'" ).append("\n"); 
		query.append("    GROUP   BY B.ROUT_SEQ, B.ROUT_TP_CD, B.ORG_ROUT_TP_CD, B.IB_YD_CD, B.OB_YD_CD, A.FM_LOC_CD, A.FM_NOD_YD_NO, A.TO_LOC_CD, A.TO_NOD_YD_NO, A.COND_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MAX_COND_LIST AS (" ).append("\n"); 
		query.append("    SELECT  A.ROUT_SEQ, A.ROUT_TP_CD, A.ORG_ROUT_TP_CD, A.IB_YD_CD, A.OB_YD_CD" ).append("\n"); 
		query.append("        ,   A.FM_LOC_CD, A.FM_NOD_YD_NO, A.TO_LOC_CD, A.TO_NOD_YD_NO, A.COND_NO, A.MAX_VER_NO" ).append("\n"); 
		query.append("    FROM    ROUT_PRIORITY_LIST A" ).append("\n"); 
		query.append("    WHERE   A.PRIORITY = A.MAX_PRIORITY" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",  DIST_COND_LIST AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT  COND_NO FROM MAX_COND_LIST     " ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append(", CGO_COND_CHK_LIST AS ( " ).append("\n"); 
		query.append("    SELECT  A.CGO_SEQ, A.CNTR_TPSZ_CD, A.CNTR_QTY, B.COND_NO" ).append("\n"); 
		query.append("        ,   PRI_SCQ_CGO_COND_CHK_FNC ( B.COND_NO, @[scq_rqst_no], @[scq_ver_no_tmp], A.CGO_SEQ ) COND_CHK_RSLT" ).append("\n"); 
		query.append("    FROM    PRI_SCQ_AWK_CGO_TMP A, DIST_COND_LIST B" ).append("\n"); 
		query.append("    WHERE   A.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("    AND     A.SCQ_VER_NO  = @[scq_ver_no_tmp] " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MAX_AMT_LIST AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("            A.ROUT_SEQ, A.ROUT_TP_CD, A.ORG_ROUT_TP_CD, A.IB_YD_CD, A.OB_YD_CD" ).append("\n"); 
		query.append("        ,   A.FM_LOC_CD, A.FM_NOD_YD_NO, A.TO_LOC_CD, A.TO_NOD_YD_NO" ).append("\n"); 
		query.append("        ,   B.CGO_SEQ, B.CNTR_QTY" ).append("\n"); 
		query.append("        ,   C.USD_AMT, C.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("        ,   MAX ( C.USD_AMT ) OVER ( PARTITION BY A.ROUT_SEQ, A.ROUT_TP_CD, A.ORG_ROUT_TP_CD, A.IB_YD_CD, A.OB_YD_CD, B.CGO_SEQ ) AS MAX_USD_AMT" ).append("\n"); 
		query.append("        ,   A.COND_NO, A.MAX_VER_NO" ).append("\n"); 
		query.append("    FROM    MAX_COND_LIST A" ).append("\n"); 
		query.append("        ,   CGO_COND_CHK_LIST B" ).append("\n"); 
		query.append("        ,   TES_AWK_CGO_ADON_TP_SZ C" ).append("\n"); 
		query.append("    WHERE   A.COND_NO = B.COND_NO " ).append("\n"); 
		query.append("    AND     B.COND_CHK_RSLT = 1   " ).append("\n"); 
		query.append("    AND     A.FM_LOC_CD = C.FM_LOC_CD" ).append("\n"); 
		query.append("    AND     A.FM_NOD_YD_NO = C.FM_NOD_YD_NO" ).append("\n"); 
		query.append("    AND     A.TO_LOC_CD = C.TO_LOC_CD" ).append("\n"); 
		query.append("    AND     A.TO_NOD_YD_NO = C.TO_NOD_YD_NO" ).append("\n"); 
		query.append("    AND     A.FM_LOC_CD = C.FM_LOC_CD" ).append("\n"); 
		query.append("    AND     A.FM_LOC_CD = C.FM_LOC_CD" ).append("\n"); 
		query.append("    AND     A.COND_NO = C.COND_NO" ).append("\n"); 
		query.append("    AND     A.MAX_VER_NO = C.TML_AWK_ADON_VER_NO    " ).append("\n"); 
		query.append("    AND     C.CNTR_SZ_CD = DECODE ( SIGN ( INSTR ( B.CNTR_TPSZ_CD, '2' ) ), 1, '2', '4' )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[scq_rqst_no], @[scq_ver_no_tmp], A.ROUT_SEQ" ).append("\n"); 
		query.append("    ,   PRI_SCQ_AWK_COST_SEQ_FNC ( A.ROUT_TP_CD, 'A', '' ) AS ROUT_COST_SEQ" ).append("\n"); 
		query.append("    ,   ROW_NUMBER ( ) OVER ( PARTITION BY A.ROUT_SEQ  ORDER BY A.ORG_ROUT_TP_CD, A.CGO_SEQ ) AS ROUT_COST_DTL_SEQ" ).append("\n"); 
		query.append("    ,   'A' AS COST_TP_CD, A.FM_LOC_CD||A.FM_NOD_YD_NO AS FM_YD_CD, A.TO_LOC_CD||A.TO_NOD_YD_NO AS TO_YD_CD, A.CGO_SEQ, A.CNTR_QTY, A.USD_AMT" ).append("\n"); 
		query.append("    ,   MAX ( A.SPCL_CGO_REF_SEQ )  AS MAX_SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("    ,   @[cre_usr_id], SYSDATE, @[cre_usr_id], SYSDATE" ).append("\n"); 
		query.append("FROM     MAX_AMT_LIST A" ).append("\n"); 
		query.append("WHERE    A.USD_AMT = A.MAX_USD_AMT" ).append("\n"); 
		query.append("GROUP   BY A.ROUT_SEQ, A.ROUT_TP_CD, A.ORG_ROUT_TP_CD,  A.FM_LOC_CD, A.FM_NOD_YD_NO, A.TO_LOC_CD, A.TO_NOD_YD_NO, A.CGO_SEQ, A.CNTR_QTY, A.USD_AMT" ).append("\n"); 
		query.append("ORDER   BY A.ROUT_SEQ, A.ROUT_TP_CD, A.ORG_ROUT_TP_CD,  A.FM_LOC_CD, A.FM_NOD_YD_NO, A.TO_LOC_CD, A.TO_NOD_YD_NO, A.CGO_SEQ" ).append("\n"); 

	}
}