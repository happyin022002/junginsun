/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOsearchBkg0061List3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("f_epp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rout_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
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
		query.append("         ,SGRP_COST_CD_DESC " ).append("\n"); 
		query.append("         ,SUBSTR(STND_COST_NM1,3) STND_COST_NM " ).append("\n"); 
		query.append("         ,AMT " ).append("\n"); 
		query.append("         ,WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("         ,WTR_DE_TERM_CD " ).append("\n"); 
		query.append("         ,DECODE(LVL,1,1,2) LVL " ).append("\n"); 
		query.append("FROM     (SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("                A1.NOD_LNK_ROUT_NM                                   NOD_CD " ).append("\n"); 
		query.append("                ,A1.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                ,A1.COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("                ,COA_GET_COM_NM_FNC('cost_act_grp_cd',A1.COST_ACT_GRP_CD) GRP " ).append("\n"); 
		query.append("                ,A3.SGRP_COST_CD_DESC " ).append("\n"); 
		query.append("                ,A3.ACCT_DP_SEQ||A3.STND_COST_NM                   STND_COST_NM1 " ).append("\n"); 
		query.append("                ,SUM(A1.ESTM_USD_TTL_AMT) AMT " ).append("\n"); 
		query.append("                ,A3.STND_COST_TP_CD ||A3.COA_COST_SRC_PRT_CD        PR_CM " ).append("\n"); 
		query.append("                ,A1.WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("                ,A1.WTR_DE_TERM_CD " ).append("\n"); 
		query.append("                ,GROUPING(A3.ACCT_DP_SEQ||A3.STND_COST_NM) LVL  " ).append("\n"); 
		query.append("          FROM     COA_BKG_COST_ACT_GRP_SMRY A1 " ).append("\n"); 
		query.append("                   ,COA_SPCL_REPO_CNTR_RGST A2 " ).append("\n"); 
		query.append("                   ,COA_STND_ACCT_V A3 " ).append("\n"); 
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
		query.append("                   AND A3.COA_COST_SRC_PRT_CD IN ('CO','PA') /*COA_COST_SRC_PRT_CD:R,P*/" ).append("\n"); 
		query.append("                   AND A3.STND_COST_TP_CD IN ('C',DECODE(@[f_pro_lvl],'C','C','O')) /*STND_COST_TP_CD:C,O*/ " ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD = A3.STND_COST_CD 				" ).append("\n"); 
		query.append("                   AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD NOT IN ('51102001')" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("          GROUP BY A1.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                   ,A1.NOD_LNK_ROUT_NM " ).append("\n"); 
		query.append("                   /*,CUBE(A1.COST_ACT_GRP_SEQ,A3.SGRP_COST_CD_DESC,A3.ACCT_DP_SEQ||A3.STND_COST_NM)*/ " ).append("\n"); 
		query.append("                   ,A1.COST_ACT_GRP_SEQ,A3.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                   ,ROLLUP(A3.ACCT_DP_SEQ||A3.STND_COST_NM)" ).append("\n"); 
		query.append("                   ,A3.STND_COST_TP_CD||A3.COA_COST_SRC_PRT_CD " ).append("\n"); 
		query.append("                   ,A1.WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("                   ,A1.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   UNION ALL" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("         SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("                A1.NOD_LNK_ROUT_NM                                   NOD_CD " ).append("\n"); 
		query.append("                ,A1.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                ,A1.COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("                ,COA_GET_COM_NM_FNC('cost_act_grp_cd',A1.COST_ACT_GRP_CD) GRP " ).append("\n"); 
		query.append("                ,A3.SGRP_COST_CD_DESC " ).append("\n"); 
		query.append("                ,A3.ACCT_DP_SEQ||A3.STND_COST_NM                   STND_COST_NM1 " ).append("\n"); 
		query.append("                ,DECODE(@[f_epp_tp_cd], 'B', SUM(A1.ESTM_USD_TTL_AMT2), SUM(A1.ESTM_USD_TTL_AMT)) AMT " ).append("\n"); 
		query.append("                ,A3.STND_COST_TP_CD ||A3.COA_COST_SRC_PRT_CD        PR_CM " ).append("\n"); 
		query.append("                ,A1.WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("                ,A1.WTR_DE_TERM_CD " ).append("\n"); 
		query.append("                ,GROUPING(A3.ACCT_DP_SEQ||A3.STND_COST_NM) LVL " ).append("\n"); 
		query.append("          FROM     COA_BKG_COST_ACT_GRP_SMRY A1 " ).append("\n"); 
		query.append("                   ,COA_SPCL_REPO_CNTR_RGST A2 " ).append("\n"); 
		query.append("                   ,COA_STND_ACCT_V A3 " ).append("\n"); 
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
		query.append("                   AND A3.COA_COST_SRC_PRT_CD IN ('CO','PA') /*COA_COST_SRC_PRT_CD:R,P*/" ).append("\n"); 
		query.append("                   AND A3.STND_COST_TP_CD IN ('C',DECODE(@[f_pro_lvl],'C','C','O')) /*STND_COST_TP_CD:C,O*/ " ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD = A3.STND_COST_CD 				" ).append("\n"); 
		query.append("                   AND A3.PA_VW = 'BKG'" ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD IN ('51102001')" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("          GROUP BY A1.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                   ,A1.NOD_LNK_ROUT_NM " ).append("\n"); 
		query.append("                   /*,CUBE(A1.COST_ACT_GRP_SEQ,A3.SGRP_COST_CD_DESC,A3.ACCT_DP_SEQ||A3.STND_COST_NM)*/ " ).append("\n"); 
		query.append("                   ,A1.COST_ACT_GRP_SEQ,A3.SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("                   ,ROLLUP(A3.ACCT_DP_SEQ||A3.STND_COST_NM)" ).append("\n"); 
		query.append("                   ,A3.STND_COST_TP_CD||A3.COA_COST_SRC_PRT_CD " ).append("\n"); 
		query.append("                   ,A1.WTR_RCV_TERM_CD " ).append("\n"); 
		query.append("                   ,A1.WTR_DE_TERM_CD) " ).append("\n"); 
		query.append("ORDER BY COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("         ,SGRP_COST_CD_DESC " ).append("\n"); 
		query.append("         ,LVL " ).append("\n"); 
		query.append("         ,STND_COST_NM1" ).append("\n"); 

	}
}