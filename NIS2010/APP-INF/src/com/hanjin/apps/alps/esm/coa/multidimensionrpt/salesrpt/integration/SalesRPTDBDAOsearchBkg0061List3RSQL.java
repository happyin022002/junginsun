/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesRPTDBDAOsearchBkg0061List3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.01.18 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchBkg0061List3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _BKG_COST_DTL, _SPCL_REPO_CNTR_RGST 테이블의 데이터 조회
	  * 
	  * 2010.07.28 장영석  Ticket ID : CHM-201004777-01 COA 
	  * 			     코드매핑 불일치건 조치 요청 
	  *                            ACT_GRP_CD  -> COST_ACT_GRP_CD 칼럼명으로 변경 
	  * 2011.12.30 최윤성 [CHM-201115391-01] [COA] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - LOC, NOD Chekc 로직 추가
	  * </pre>
	  */
	public SalesRPTDBDAOsearchBkg0061List3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rout_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchBkg0061List3RSQL").append("\n"); 
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
		query.append("SELECT   NOD_CD " ).append("\n"); 
		query.append("         ,COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("         ,GRP " ).append("\n"); 
		query.append("      	 ,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("      	 ,SUBSTR(STND_COST_NM1, 3) STND_COST_NM" ).append("\n"); 
		query.append("         ,AMT " ).append("\n"); 
		query.append("         ,WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("         ,WTR_DE_TERM_CD " ).append("\n"); 
		query.append("         ,DECODE(LVL,1,1,2) LVL " ).append("\n"); 
		query.append("         ,AVG_LVL_CHK" ).append("\n"); 
		query.append("FROM     (SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("                A1.NOD_LNK_ROUT_NM                                   NOD_CD " ).append("\n"); 
		query.append("                ,A1.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                ,A1.COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("                ,COA_GET_COM_NM_FNC('cost_act_grp_cd',A1.COST_ACT_GRP_CD) GRP " ).append("\n"); 
		query.append("                ,DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.SGRP_COST_CD_DESC) SGRP_COST_CD_DESC " ).append("\n"); 
		query.append("                ,A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM) STND_COST_NM1 " ).append("\n"); 
		query.append("                ,DECODE(@[f_pro_vw],'P',SUM(A1.ESTM_USD_TTL_AMT),SUM(A1.RESPB_USD_TTL_AMT)) AMT " ).append("\n"); 
		query.append("                ,A3.STND_COST_TP_CD ||A3.COA_COST_SRC_PRT_CD        PR_CM " ).append("\n"); 
		query.append("                ,A1.WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("                ,A1.WTR_DE_TERM_CD " ).append("\n"); 
		query.append("                ,GROUPING(A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM)) LVL " ).append("\n"); 
		query.append("                ,DECODE(A3.SGRP_COST_CD_DESC, 'Full Transport Expense', NVL(A4.AVG_LVL_CHK,'N'), 'N') AVG_LVL_CHK" ).append("\n"); 
		query.append("          FROM     COA_BKG_COST_ACT_GRP_SMRY A1 " ).append("\n"); 
		query.append("                   ,COA_SPCL_REPO_CNTR_RGST A2 " ).append("\n"); 
		query.append("                   ,COA_STND_ACCT_V A3" ).append("\n"); 
		query.append("                   ,(" ).append("\n"); 
		query.append("                       SELECT A.BKG_NO" ).append("\n"); 
		query.append("                             ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             ,A.COST_ROUT_NO" ).append("\n"); 
		query.append("                             ,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                             ,A.NOD_LNK_ROUT_NM" ).append("\n"); 
		query.append("                             ,A.STND_COST_CD" ).append("\n"); 
		query.append("                             ,'Y' AVG_LVL_CHK" ).append("\n"); 
		query.append("                         FROM COA_BKG_COST_ACT_GRP_SMRY A" ).append("\n"); 
		query.append("                             ,COA_BKG_COST_SRC_DTL B" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND A.BKG_NO           = @[f_bkg_no]" ).append("\n"); 
		query.append("                          AND A.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("                          AND A.CNTR_TPSZ_CD     = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                          AND A.COST_ROUT_NO     = B.COST_ROUT_NO" ).append("\n"); 
		query.append("                          AND A.COST_ACT_GRP_SEQ = B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                          AND A.STND_COST_CD     = B.STND_COST_CD" ).append("\n"); 
		query.append("                          AND (A.ESTM_USD_TTL_AMT <> 0 OR A.RESPB_USD_TTL_AMT <> 0)" ).append("\n"); 
		query.append("                          AND REGEXP_LIKE(B.COST_CALC_RMK, 'AVG-SCC|AVG-ECC|AVG-LCC|AVG-RCC')" ).append("\n"); 
		query.append("                   ) A4" ).append("\n"); 
		query.append("          WHERE    A1.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("                #if ( ${f_rout_no} != 'All' )" ).append("\n"); 
		query.append("                   AND A1.COST_ROUT_NO = @[f_rout_no]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if ( ${f_cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("                   AND A2.SPCL_CNTR_TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                   AND A2.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                   AND (A1.ESTM_USD_TTL_AMT <> 0 OR A1.RESPB_USD_TTL_AMT <> 0) " ).append("\n"); 
		query.append("                   AND A3.COA_COST_SRC_PRT_CD IN (DECODE(@[f_pro_lvl],'C','CO','CO'),DECODE(@[f_pro_vw],'P','PA','RA')) /*COA_COST_SRC_PRT_CD:R,P*/" ).append("\n"); 
		query.append("                   AND A3.STND_COST_TP_CD IN ('C',DECODE(@[f_pro_lvl],'C','C','M','C','O')) /*STND_COST_TP_CD:C,O*/ " ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD = A3.STND_COST_CD " ).append("\n"); 
		query.append("				#if ( ${f_pro_vw} == 'P' ) " ).append("\n"); 
		query.append("                   AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				   AND A3.RA_VW = 'BKG'" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if ( ${f_pro_lvl} != 'M' ) " ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD <> '51701011'" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("                   AND A1.BKG_NO           = A4.BKG_NO           (+)" ).append("\n"); 
		query.append("                   AND A1.CNTR_TPSZ_CD     = A4.CNTR_TPSZ_CD     (+)" ).append("\n"); 
		query.append("                   AND A1.COST_ROUT_NO     = A4.COST_ROUT_NO     (+)" ).append("\n"); 
		query.append("                   AND A1.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ (+)" ).append("\n"); 
		query.append("                   AND A1.NOD_LNK_ROUT_NM  = A4.NOD_LNK_ROUT_NM  (+)" ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD     = A4.STND_COST_CD     (+)" ).append("\n"); 
		query.append("          GROUP BY A1.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                   ,A1.NOD_LNK_ROUT_NM " ).append("\n"); 
		query.append("                   ,A1.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                   ,DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.SGRP_COST_CD_DESC)" ).append("\n"); 
		query.append("                   ,ROLLUP(A3.ACCT_DP_SEQ||DECODE(A3.STND_COST_CD, '51701011', 'CM2 Cost', A3.STND_COST_NM))" ).append("\n"); 
		query.append("                   ,A3.STND_COST_TP_CD||A3.COA_COST_SRC_PRT_CD " ).append("\n"); 
		query.append("                   ,A1.WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("                   ,A1.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                   ,DECODE(A3.SGRP_COST_CD_DESC, 'Full Transport Expense', NVL(A4.AVG_LVL_CHK,'N'), 'N')) " ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("         ,SGRP_COST_CD_DESC " ).append("\n"); 
		query.append("         ,LVL " ).append("\n"); 
		query.append("         ,STND_COST_NM1" ).append("\n"); 

	}
}