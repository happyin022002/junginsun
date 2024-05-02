/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNotesPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2010.11.25 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNotesPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDN Performance
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNotesPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_iss_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_iss_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNotesPerformanceRSQL").append("\n"); 
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
		query.append("SELECT  A3.RCT_RHQ_CD" ).append("\n"); 
		query.append(",       A3.RCT_OFC_CD" ).append("\n"); 
		query.append(",       A3.RESPB_RHQ_CD                --상위오피스" ).append("\n"); 
		query.append(",       A3.RESPB_OFC_CD                --하위오피스" ).append("\n"); 
		query.append(",       SUM(A3.CNT1)  AS CNT1  " ).append("\n"); 
		query.append(",       SUM(A3.AMT1)  AS AMT1 " ).append("\n"); 
		query.append(",       SUM(A3.CNT2)  AS CNT2 " ).append("\n"); 
		query.append(",       SUM(A3.AMT2)  AS AMT2 " ).append("\n"); 
		query.append(",       SUM(A3.CNT3)  AS CNT3 " ).append("\n"); 
		query.append(",       SUM(A3.AMT3)  AS AMT3 " ).append("\n"); 
		query.append(",       SUM(A3.CNT4)  AS CNT4 " ).append("\n"); 
		query.append(",       SUM(A3.AMT4)  AS AMT4 " ).append("\n"); 
		query.append(",       SUM(A3.CNT5)  AS CNT5 " ).append("\n"); 
		query.append(",       SUM(A3.AMT5)  AS AMT5 " ).append("\n"); 
		query.append(",       SUM(A3.CNT6)  AS CNT6 " ).append("\n"); 
		query.append(",       SUM(A3.AMT6)  AS AMT6 " ).append("\n"); 
		query.append(",       SUM(A3.CNT7)  AS CNT7 " ).append("\n"); 
		query.append(",       SUM(A3.AMT7)  AS AMT7 " ).append("\n"); 
		query.append(",       SUM(A3.CNT8)  AS CNT8 " ).append("\n"); 
		query.append(",       SUM(A3.AMT8)  AS AMT8 " ).append("\n"); 
		query.append(",       SUM(A3.CNT9)  AS CNT9 " ).append("\n"); 
		query.append(",       SUM(A3.AMT9)  AS AMT9 " ).append("\n"); 
		query.append(",       SUM(A3.CNT10) AS CNT10 " ).append("\n"); 
		query.append(",       SUM(A3.AMT10) AS AMT10 " ).append("\n"); 
		query.append(",       SUM(A3.CNT11) AS CNT11 " ).append("\n"); 
		query.append(",       SUM(A3.AMT11) AS AMT11 " ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  A2.RDN_NO" ).append("\n"); 
		query.append("        ,       A2.RVIS_SEQ" ).append("\n"); 
		query.append("		,       A2.RCT_RHQ_CD" ).append("\n"); 
		query.append("        ,       A2.RCT_OFC_CD" ).append("\n"); 
		query.append("		,       A2.RESPB_RHQ_CD                --상위오피스" ).append("\n"); 
		query.append("        ,       A2.RESPB_OFC_CD                --하위오피스" ).append("\n"); 
		query.append("        ,       SUM(B2.CNT1)  AS CNT1  " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT1)  AS AMT1 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT2)  AS CNT2 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT2)  AS AMT2 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT3)  AS CNT3 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT3)  AS AMT3 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT4)  AS CNT4 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT4)  AS AMT4 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT5)  AS CNT5 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT5)  AS AMT5 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT6)  AS CNT6 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT6)  AS AMT6 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT7)  AS CNT7 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT7)  AS AMT7 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT8)  AS CNT8 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT8)  AS AMT8 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT9)  AS CNT9 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT9)  AS AMT9 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT10) AS CNT10 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT10) AS AMT10 " ).append("\n"); 
		query.append("        ,       SUM(B2.CNT11) AS CNT11 " ).append("\n"); 
		query.append("        ,       SUM(B2.AMT11) AS AMT11 " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("                (   " ).append("\n"); 
		query.append("                SELECT A1.RDN_NO" ).append("\n"); 
		query.append("                ,      A1.RVIS_SEQ" ).append("\n"); 
		query.append("                ,      A1.RCT_RHQ_CD                --상위오피스" ).append("\n"); 
		query.append("                ,      A1.RCT_OFC_CD                --하위오피스" ).append("\n"); 
		query.append("				,      DECODE(NVL(A1.RESPB_RHQ_CD,''),'',A1.RCT_RHQ_CD,A1.RESPB_RHQ_CD) AS RESPB_RHQ_CD              --상위오피스" ).append("\n"); 
		query.append("                ,      DECODE(NVL(A1.RESPB_OFC_CD,''),'',A1.RCT_OFC_CD,A1.RESPB_OFC_CD) AS RESPB_OFC_CD                --하위오피스" ).append("\n"); 
		query.append("                FROM   BKG_REV_DR_NOTE A1" ).append("\n"); 
		query.append("				WHERE  1=1" ).append("\n"); 
		query.append("				#if (${rdn_sts_cd} != '') " ).append("\n"); 
		query.append("				--상태구분" ).append("\n"); 
		query.append("				AND    A1.RDN_STS_CD IN (${rdn_sts_cd})" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				AND	   A1.RDN_STS_CD <> 'IN'" ).append("\n"); 
		query.append("				#if (${rdn_iss_dt_from} != '' && ${rdn_iss_dt_to} != '')" ).append("\n"); 
		query.append("				--RDN_ISS_DT FROM TO" ).append("\n"); 
		query.append("				AND    A1.RDN_ISS_DT BETWEEN TO_DATE(@[rdn_iss_dt_from],'YYYY/MM/DD') AND TO_DATE(@[rdn_iss_dt_to],'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${rct_rhq_cd} != '') " ).append("\n"); 
		query.append("				--오피스 대분류" ).append("\n"); 
		query.append("				AND    A1.RCT_RHQ_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${rct_ofc_cd} != '') " ).append("\n"); 
		query.append("				--오피스 소분류" ).append("\n"); 
		query.append("				AND 	A1.RCT_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${respb_rhq_cd} != '') " ).append("\n"); 
		query.append("				--책임 오피스" ).append("\n"); 
		query.append("				AND 	A1.RESPB_RHQ_CD = @[respb_rhq_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${respb_ofc_cd} != '') " ).append("\n"); 
		query.append("				--책임 오피스" ).append("\n"); 
		query.append("				AND 	A1.RESPB_OFC_CD = @[respb_ofc_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) A2," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                --UNMATCH CODE 별 CNT, AMT" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT A1.RDN_NO" ).append("\n"); 
		query.append("                ,      A1.RVIS_SEQ" ).append("\n"); 
		query.append("				,      DECODE(A1.UMCH_TP_CD,'D', 1,0) AS CNT1                                                        --NON-CHARGED CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'D', SUM(B1.USD_AMT),0) AS AMT1                                          --NON-CHARGED AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'10', 1,0),0) AS CNT2                      --CNTR QTY CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'10', SUM(B1.USD_AMT),0),0) AS AMT2        --CNTR QTY AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'20', 1,0),0) AS CNT3                      --GRI CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'20', SUM(B1.USD_AMT),0),0) AS AMT3        --GRI AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'30', 1,0),0) AS CNT4                      --CARGO TYPE CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'30', SUM(B1.USD_AMT),0),0) AS AMT4        --CARGO TYPE AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'40', 1,0),0) AS CNT5                      --ROUTE CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'40', SUM(B1.USD_AMT),0),0) AS AMT5        --ROUTE AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'50', 1,0),0) AS CNT6                      --OTHERS CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'E', DECODE(A1.UMCH_SUB_TP_CD,'50', SUM(B1.USD_AMT),0),0) AS AMT6        --OTHERS AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'10', 1,0),0) AS CNT7                      --IHC CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'10', SUM(B1.USD_AMT),0),0) AS AMT7        --IHC AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'20', 1,0),0) AS CNT8                      --BUNKER CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'20', SUM(B1.USD_AMT),0),0) AS AMT8        --BUNKER AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'30', 1,0),0) AS CNT9                      --DG CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'30', SUM(B1.USD_AMT),0),0) AS AMT9        --DG AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'40', 1,0),0) AS CNT10                     --WSC CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'40', SUM(B1.USD_AMT),0),0) AS AMT10       --WSC AMT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'50', 1,0),0) AS CNT11                     --OTHERS CNT" ).append("\n"); 
		query.append("                ,      DECODE(A1.UMCH_TP_CD,'F', DECODE(A1.UMCH_SUB_TP_CD,'50', SUM(B1.USD_AMT),0),0) AS AMT11       --OTHERS AMT" ).append("\n"); 
		query.append("                FROM   BKG_REV_DR_NOTE A1" ).append("\n"); 
		query.append("                ,      (" ).append("\n"); 
		query.append("                        SELECT D1.RDN_NO" ).append("\n"); 
		query.append("                        ,      D1.RVIS_SEQ" ).append("\n"); 
		query.append("                        ,      SUM(NVL(ROUND(D1.DR_AMT / B1.USD_LOCL_XCH_RT, 2), 0)) AS USD_AMT" ).append("\n"); 
		query.append("                        FROM  BKG_REV_DR_AMT D1," ).append("\n"); 
		query.append("                        GL_MON_XCH_RT B1," ).append("\n"); 
		query.append("                        BKG_REV_DR_NOTE A1" ).append("\n"); 
		query.append("                        WHERE D1.CURR_CD = B1.CURR_CD" ).append("\n"); 
		query.append("                        AND   B1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                        AND   D1.RDN_NO = A1.RDN_NO" ).append("\n"); 
		query.append("                        AND   D1.RVIS_SEQ = A1.RVIS_SEQ" ).append("\n"); 
		query.append("                        AND   B1.ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(NVL(A1.RDN_ISS_DT,SYSDATE),'YYYYMMDD'),0,6)" ).append("\n"); 
		query.append("                        GROUP BY D1.RDN_NO, D1.RVIS_SEQ" ).append("\n"); 
		query.append("                       ) B1" ).append("\n"); 
		query.append("                ,      BKG_BOOKING C1" ).append("\n"); 
		query.append("                WHERE  A1.RDN_NO = B1.RDN_NO(+)" ).append("\n"); 
		query.append("                AND    A1.RVIS_SEQ = B1.RVIS_SEQ(+)" ).append("\n"); 
		query.append("                AND    A1.BKG_NO = C1.BKG_NO" ).append("\n"); 
		query.append("                AND    (A1.RDN_NO, A1.RVIS_SEQ) IN (SELECT RDN_NO" ).append("\n"); 
		query.append("                                                    ,      MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("                                                    FROM   BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                                                    GROUP  BY RDN_NO) " ).append("\n"); 
		query.append("				#if (${rdn_sts_cd} != '') " ).append("\n"); 
		query.append("				--상태구분" ).append("\n"); 
		query.append("				AND    A1.RDN_STS_CD IN (${rdn_sts_cd})" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				AND	   A1.RDN_STS_CD <> 'IN'" ).append("\n"); 
		query.append("				#if (${rdn_iss_dt_from} != '' && ${rdn_iss_dt_to} != '')" ).append("\n"); 
		query.append("				--RDN_ISS_DT FROM TO" ).append("\n"); 
		query.append("				AND    A1.RDN_ISS_DT BETWEEN TO_DATE(@[rdn_iss_dt_from],'YYYY/MM/DD') AND TO_DATE(@[rdn_iss_dt_to],'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${rct_rhq_cd} != '') " ).append("\n"); 
		query.append("				--오피스 대분류" ).append("\n"); 
		query.append("				AND    A1.RCT_RHQ_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${rct_ofc_cd} != '') " ).append("\n"); 
		query.append("				--오피스 소분류" ).append("\n"); 
		query.append("				AND 	A1.RCT_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${respb_rhq_cd} != '') " ).append("\n"); 
		query.append("				--책임 오피스" ).append("\n"); 
		query.append("				AND 	A1.RESPB_RHQ_CD = @[respb_rhq_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${respb_ofc_cd} != '') " ).append("\n"); 
		query.append("				--책임 오피스" ).append("\n"); 
		query.append("				AND 	A1.RESPB_OFC_CD = @[respb_ofc_cd] " ).append("\n"); 
		query.append("				#end                                   " ).append("\n"); 
		query.append("               GROUP   BY A1.RDN_NO" ).append("\n"); 
		query.append("                          , A1.RVIS_SEQ" ).append("\n"); 
		query.append("                          , A1.UMCH_TP_CD" ).append("\n"); 
		query.append("                          , A1.UMCH_SUB_TP_CD" ).append("\n"); 
		query.append("               ) B2" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        WHERE  A2.RDN_NO = B2.RDN_NO" ).append("\n"); 
		query.append("        AND    A2.RVIS_SEQ = B2.RVIS_SEQ" ).append("\n"); 
		query.append("        GROUP  BY A2.RDN_NO" ).append("\n"); 
		query.append("                  , A2.RVIS_SEQ" ).append("\n"); 
		query.append("                  , A2.RCT_RHQ_CD" ).append("\n"); 
		query.append("                  , A2.RCT_OFC_CD" ).append("\n"); 
		query.append("				  , A2.RESPB_RHQ_CD" ).append("\n"); 
		query.append("                  , A2.RESPB_OFC_CD	" ).append("\n"); 
		query.append("       ) A3" ).append("\n"); 
		query.append("GROUP  BY A3.RCT_RHQ_CD" ).append("\n"); 
		query.append("          , A3.RCT_OFC_CD " ).append("\n"); 
		query.append("		  , A3.RESPB_RHQ_CD" ).append("\n"); 
		query.append("          , A3.RESPB_OFC_CD   " ).append("\n"); 
		query.append("ORDER  BY A3.RCT_RHQ_CD, A3.RCT_OFC_CD, A3.RESPB_RHQ_CD, A3.RESPB_OFC_CD" ).append("\n"); 

	}
}