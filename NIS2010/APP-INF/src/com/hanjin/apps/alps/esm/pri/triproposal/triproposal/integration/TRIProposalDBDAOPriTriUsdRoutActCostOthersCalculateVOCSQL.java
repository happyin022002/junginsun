/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriUsdRoutActCostOthersCalculateVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriUsdRoutActCostOthersCalculateVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Calculate logic.
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriUsdRoutActCostOthersCalculateVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_src_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_clss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriUsdRoutActCostOthersCalculateVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_PRS_USD_ROUT_ACT_COST" ).append("\n"); 
		query.append("	(  ROUT_CS_NO			,       ROUT_CS_SRC_DT		," ).append("\n"); 
		query.append("       COST_ACT_GRP_SEQ     ,       CNTR_TPSZ_CD         ," ).append("\n"); 
		query.append("       COA_COST_SRC_CD      ,       STND_COST_CD         ," ).append("\n"); 
		query.append("       RA_ACCT_CD           ,       COST_UT_AMT_CD       ," ).append("\n"); 
		query.append("       COST_SRC_SYS_CD      ,       COST_ASS_BSE_CD      ," ).append("\n"); 
		query.append("       RAIL_SVC_TP_CD       ,       ACT_GRP_CD           ," ).append("\n"); 
		query.append("       COST_ACT_GRP_TP_CD   ,       VSL_SLAN_CD          ," ).append("\n"); 
		query.append("       CTRL_OFC_CD          ,       COST_OFC_CD          ," ).append("\n"); 
		query.append("       COST_IO_BND_CD       ,       N1ST_NOD_CD          ," ).append("\n"); 
		query.append("       N1ST_NOD_TP_CD       ,       N1ST_ESTM_DT         ," ).append("\n"); 
		query.append("       N2ND_NOD_CD          ,       N3RD_NOD_CD          ," ).append("\n"); 
		query.append("       N4TH_NOD_CD          ,       ROUT_TZ_MOD_CD       ," ).append("\n"); 
		query.append("       N1ST_POL_POD_DIST    ,       N1ST_DIST_UT_CD      ," ).append("\n"); 
		query.append("       N2ND_POL_POD_DIST    ,       N2ND_DIST_UT_CD      ," ).append("\n"); 
		query.append("       N3RD_POL_POD_DIST    ,       N3RD_DIST_UT_CD      ," ).append("\n"); 
		query.append("       N1ST_VNDR_SEQ        ,       N2ND_VNDR_SEQ        ," ).append("\n"); 
		query.append("       N3RD_VNDR_SEQ        ,       N4TH_VNDR_SEQ        ," ).append("\n"); 
		query.append("       CUST_NOMI_TRKR_FLG   ,       PRE_NOD_CD           ," ).append("\n"); 
		query.append("       PST_NOD_CD           ,       PRE_LNK_VNDR_SEQ     ," ).append("\n"); 
		query.append("       PST_LNK_VNDR_SEQ     ,       FCGO_TZ_DYS          ," ).append("\n"); 
		query.append("       FCGO_TZ_HRS          ,       MCGO_TZ_DYS          ," ).append("\n"); 
		query.append("       MCGO_TZ_HRS          ,       CNTR_QTY             ," ).append("\n"); 
		query.append("       COST_CATE_CD         ,       ESTM_UC_AMT          ," ).append("\n"); 
		query.append("       RESPB_UC_AMT         ,       LOCL_CURR_CD         ," ).append("\n"); 
		query.append("       TRSP_SVC_OFC_CD      ,       COST_ASGN_CALC_FLG   ," ).append("\n"); 
		query.append("       LGS_COST_CD_CHK_FLG  ,       THRP_RT_FLG          ," ).append("\n"); 
		query.append("       ACT_GRP_TML_FLG      ,       LGS_COST_AUTO_CD_FLG ," ).append("\n"); 
		query.append("       IOC_CD               ,       BFR_TRSP_MOD_CD       ," ).append("\n"); 
		query.append("       AFT_TRSP_MOD_CD      ,       CTRT_RTN_FLG         ," ).append("\n"); 
		query.append("       APLY_VNDR_SEQ        ,       SCC_CD               ," ).append("\n"); 
		query.append("       ECC_CD               ,       PARA_FM_SCC_CD       ," ).append("\n"); 
		query.append("       PARA_TO_SCC_CD       ,       PARA_FM_ECC_CD       ," ).append("\n"); 
		query.append("       PARA_TO_ECC_CD       ,       N1ST_RAIL_CRR_TP_CD  ," ).append("\n"); 
		query.append("       N2ND_RAIL_CRR_TP_CD  ,       N3RD_RAIL_CRR_TP_CD  ," ).append("\n"); 
		query.append("       ESTM_USD_UC_AMT      ,       RESPB_USD_UC_AMT     ," ).append("\n"); 
		query.append("       ESTM_USD_TTL_AMT     ,       RESPB_USD_TTL_AMT    ," ).append("\n"); 
		query.append("       WTR_DE_TERM_CD       ,       WTR_RCV_TERM_CD      ," ).append("\n"); 
		query.append("       INLND_ROUT_INCL_STTL_FLG,    N1ST_TRSP_AGMT_SEQ   ," ).append("\n"); 
		query.append("       N2ND_TRSP_AGMT_SEQ   ,       N3RD_TRSP_AGMT_SEQ   ," ).append("\n"); 
		query.append("       N1ST_TRSP_AGMT_OFC_CTY_CD,   N1ST_AGMT_REF_NO     ," ).append("\n"); 
		query.append("       N2ND_TRSP_AGMT_OFC_CTY_CD,   N2ND_AGMT_REF_NO     ," ).append("\n"); 
		query.append("       N3RD_TRSP_AGMT_OFC_CTY_CD,   N3RD_AGMT_REF_NO     ," ).append("\n"); 
		query.append("       COST_CALC_RMK		,       CRE_USR_ID           ," ).append("\n"); 
		query.append("       CRE_DT               ,       UPD_USR_ID           ," ).append("\n"); 
		query.append("       UPD_DT       		" ).append("\n"); 
		query.append(")	" ).append("\n"); 
		query.append("WITH VW_ROUT_CS_NO AS (" ).append("\n"); 
		query.append("   SELECT ROUT_CS_NO" ).append("\n"); 
		query.append("    FROM ( " ).append("\n"); 
		query.append("		 SELECT  /*+ ORDERED */DISTINCT ROUT.ROUT_CS_NO, DENSE_RANK() OVER( ORDER BY ROUT_CS_NO) NUM" ).append("\n"); 
		query.append("		  FROM (" ).append("\n"); 
		query.append("		       SELECT DISTINCT A.TRI_PROP_NO," ).append("\n"); 
		query.append("		       		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("		         FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("		        WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("		          AND A.ORG_DEST_TP_CD = 'O'      " ).append("\n"); 
		query.append("		       ) ORG, " ).append("\n"); 
		query.append("		       (" ).append("\n"); 
		query.append("		       SELECT DISTINCT A.TRI_PROP_NO, " ).append("\n"); 
		query.append("		       		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("		         FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("		        WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("		          AND A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		       ) DST" ).append("\n"); 
		query.append("			   , PRI_TRI_RT RT" ).append("\n"); 
		query.append("		       , PRI_PRS_ROUT_CS ROUT" ).append("\n"); 
		query.append("		 WHERE ORG.TRI_PROP_NO  = DST.TRI_PROP_NO    " ).append("\n"); 
		query.append("		   AND ORG.TRI_PROP_NO      = RT.TRI_PROP_NO   " ).append("\n"); 
		query.append("		   AND RT.PROP_STS_CD IN ( 'I', 'R') " ).append("\n"); 
		query.append("		   AND ROUT.ROUT_CS_CLSS_NO = @[rout_cs_clss_no]" ).append("\n"); 
		query.append("		   AND ROUT.POR_CD      = ORG.LOC_CD" ).append("\n"); 
		query.append("		   AND ROUT.DEL_CD      = DST.LOC_CD" ).append("\n"); 
		query.append("		   AND ROUT.BKG_RCV_TERM_CD = ORG.TERM_CD  " ).append("\n"); 
		query.append("		   AND ROUT.BKG_DE_TERM_CD  = DST.TERM_CD  " ).append("\n"); 
		query.append("		   AND ROUT.RAT_UT_CD   = RT.RAT_UT_CD" ).append("\n"); 
		query.append("		   AND ROUT.PRC_CGO_TP_CD = RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		   AND ROUT.COST_ROUT_CS_FLG = 'Y'" ).append("\n"); 
		query.append("           AND NOT EXISTS (" ).append("\n"); 
		query.append("                   SELECT 1" ).append("\n"); 
		query.append("                     FROM PRI_PRS_USD_ROUT_ACT_COST USED_ROUT_COST" ).append("\n"); 
		query.append("                    WHERE ROUT_CS_SRC_DT = @[rout_cs_src_dt]" ).append("\n"); 
		query.append("                      AND ROUT.ROUT_CS_NO  = USED_ROUT_COST.ROUT_CS_NO " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(" )   	" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT ROUT_CS_NO			,	    ${rout_cs_src_dt} as ROUT_CS_SRC_DT	," ).append("\n"); 
		query.append("       COST_ACT_GRP_SEQ     ,       CNTR_TPSZ_CD         ," ).append("\n"); 
		query.append("       COA_COST_SRC_CD      ,       STND_COST_CD         ," ).append("\n"); 
		query.append("       RA_ACCT_CD           ,       COST_UT_AMT_CD       ," ).append("\n"); 
		query.append("       COST_SRC_SYS_CD      ,       COST_ASS_BSE_CD      ," ).append("\n"); 
		query.append("       RAIL_SVC_TP_CD       ,       ACT_GRP_CD           ," ).append("\n"); 
		query.append("       COST_ACT_GRP_TP_CD   ,       VSL_SLAN_CD          ," ).append("\n"); 
		query.append("       CTRL_OFC_CD          ,       COST_OFC_CD          ," ).append("\n"); 
		query.append("       COST_IO_BND_CD       ,       N1ST_NOD_CD          ," ).append("\n"); 
		query.append("       N1ST_NOD_TP_CD       ,       N1ST_ESTM_DT			," ).append("\n"); 
		query.append("       N2ND_NOD_CD          ,       N3RD_NOD_CD          ," ).append("\n"); 
		query.append("       N4TH_NOD_CD          ,       ROUT_TZ_MOD_CD       ," ).append("\n"); 
		query.append("       N1ST_POL_POD_DIST    ,       N1ST_DIST_UT_CD      ," ).append("\n"); 
		query.append("       N2ND_POL_POD_DIST    ,       N2ND_DIST_UT_CD      ," ).append("\n"); 
		query.append("       N3RD_POL_POD_DIST    ,       N3RD_DIST_UT_CD      ," ).append("\n"); 
		query.append("       N1ST_VNDR_SEQ        ,       N2ND_VNDR_SEQ        ," ).append("\n"); 
		query.append("       N3RD_VNDR_SEQ        ,       N4TH_VNDR_SEQ        ," ).append("\n"); 
		query.append("       CUST_NOMI_TRKR_FLG   ,       PRE_NOD_CD           ," ).append("\n"); 
		query.append("       PST_NOD_CD           ,       PRE_LNK_VNDR_SEQ     ," ).append("\n"); 
		query.append("       PST_LNK_VNDR_SEQ     ,       FCGO_TZ_DYS          ," ).append("\n"); 
		query.append("       FCGO_TZ_HRS          ,       MCGO_TZ_DYS          ," ).append("\n"); 
		query.append("       MCGO_TZ_HRS          ,       CNTR_QTY             ," ).append("\n"); 
		query.append("       COST_CATE_CD         ,       ESTM_UC_AMT          ," ).append("\n"); 
		query.append("       RESPB_UC_AMT         ,       LOCL_CURR_CD         ," ).append("\n"); 
		query.append("       TRSP_SVC_OFC_CD      ,       COST_ASGN_CALC_FLG   ," ).append("\n"); 
		query.append("       LGS_COST_CD_CHK_FLG  ,       THRP_RT_FLG          ," ).append("\n"); 
		query.append("       ACT_GRP_TML_FLG      ,       LGS_COST_AUTO_CD_FLG ," ).append("\n"); 
		query.append("       IOC_CD               ,       BFR_TRSP_MOD_CD       ," ).append("\n"); 
		query.append("       AFT_TRSP_MOD_CD      ,       CTRT_RTN_FLG         ," ).append("\n"); 
		query.append("       APLY_VNDR_SEQ        ,       SCC_CD               ," ).append("\n"); 
		query.append("       ECC_CD               ,       PARA_FM_SCC_CD       ," ).append("\n"); 
		query.append("       PARA_TO_SCC_CD       ,       PARA_FM_ECC_CD       ," ).append("\n"); 
		query.append("       PARA_TO_ECC_CD       ,       N1ST_RAIL_CRR_TP_CD  ," ).append("\n"); 
		query.append("       N2ND_RAIL_CRR_TP_CD  ,       N3RD_RAIL_CRR_TP_CD  ," ).append("\n"); 
		query.append("       ESTM_USD_UC_AMT      ,       RESPB_USD_UC_AMT     ," ).append("\n"); 
		query.append("       ESTM_USD_TTL_AMT     ,       RESPB_USD_TTL_AMT    ," ).append("\n"); 
		query.append("       WTR_DE_TERM_CD       ,       WTR_RCV_TERM_CD      ," ).append("\n"); 
		query.append("       INLND_ROUT_INCL_STTL_FLG,    N1ST_TRSP_AGMT_SEQ   ," ).append("\n"); 
		query.append("       N2ND_TRSP_AGMT_SEQ   ,       N3RD_TRSP_AGMT_SEQ   ," ).append("\n"); 
		query.append("       N1ST_TRSP_AGMT_OFC_CTY_CD,   N1ST_AGMT_REF_NO     ," ).append("\n"); 
		query.append("       N2ND_TRSP_AGMT_OFC_CTY_CD,   N2ND_AGMT_REF_NO     ," ).append("\n"); 
		query.append("       N3RD_TRSP_AGMT_OFC_CTY_CD,   N3RD_AGMT_REF_NO     ," ).append("\n"); 
		query.append("	   '' 					,       'CALC'				," ).append("\n"); 
		query.append("       SYSDATE              ,       'CALC'				," ).append("\n"); 
		query.append("       SYSDATE              " ).append("\n"); 
		query.append("  FROM PRI_PRS_ROUT_ACT_COST" ).append("\n"); 
		query.append(" WHERE ROUT_CS_NO IN ( SELECT ROUT_CS_NO FROM VW_ROUT_CS_NO ) " ).append("\n"); 
		query.append("   AND ROUT_CS_CLSS_NO = @[rout_cs_clss_no]" ).append("\n"); 

	}
}