/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriUsdRoutCsInfoOthersCalculateVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 김효정
*@LastVersion : 1.0
* 2010.05.06 김효정
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

public class TRIProposalDBDAOPriTriUsdRoutCsInfoOthersCalculateVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Calculate logic.
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriUsdRoutCsInfoOthersCalculateVOCSQL(){
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
		query.append("FileName : TRIProposalDBDAOPriTriUsdRoutCsInfoOthersCalculateVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_PRS_USD_ROUT_CS_INFO" ).append("\n"); 
		query.append(" (  ROUT_CS_NO              ,       ROUT_CS_SRC_DT       ," ).append("\n"); 
		query.append("       PCTL_NO              ,       BKG_NO               ," ).append("\n"); 
		query.append("       MTY_PKUP_YD_CD       ,       POR_CD               ," ).append("\n"); 
		query.append("       POR_NOD_CD           ,       POL_CD               ," ).append("\n"); 
		query.append("       N1ST_TS_PORT_CD      ,       N2ND_TS_PORT_CD      ," ).append("\n"); 
		query.append("       N3RD_TS_PORT_CD      ,       POD_CD               ," ).append("\n"); 
		query.append("       DEL_CD               ,       DEL_NOD_CD           ," ).append("\n"); 
		query.append("       MTY_RTN_YD_CD        ,       TTL_TZTM_HRS         ," ).append("\n"); 
		query.append("       PROD_REV             ,       TTL_EXPN_AMT         ," ).append("\n"); 
		query.append("       CM_AMT               ,       TRNK_AVAL_SPC        ," ).append("\n"); 
		query.append("       BKG_SEL_FLG          ,       COP_CRE_FLG          ," ).append("\n"); 
		query.append("       OB_ITCHG_CTNT        ,       IB_ITCHG_CTNT        ," ).append("\n"); 
		query.append("       TRNK_VSL_CD          ,       TRNK_SKD_VOY_NO      ," ).append("\n"); 
		query.append("       TRNK_SKD_DIR_CD      ,       CNST_FLG             ," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD        ,       BKG_RCV_TERM_CD      ," ).append("\n"); 
		query.append("       CMDT_CD              ,       BKG_DE_TERM_CD       ," ).append("\n"); 
		query.append("       REP_CMDT_CD          ,       SHPR_CNT_CD          ," ).append("\n"); 
		query.append("       SHPR_SEQ             ,       CNEE_CNT_CD          ," ).append("\n"); 
		query.append("       CNEE_SEQ             ,       SC_NO                ," ).append("\n"); 
		query.append("       RFA_NO               ,       DG_CLSS_CD           ," ).append("\n"); 
		query.append("       DG_SPCL_FLG          ,       RF_SPCL_FLG          ," ).append("\n"); 
		query.append("       SPCL_AWK_CGO_FLG     ,       BB_SPCL_FLG          ," ).append("\n"); 
		query.append("       RD_SPCL_FLG          ,       HNGR_SPCL_FLG        ," ).append("\n"); 
		query.append("       SOC_FLG              ,       EQ_SUBST_FLG         ," ).append("\n"); 
		query.append("       BKG_WGT              ,       BKG_WGT_UT_CD        ," ).append("\n"); 
		query.append("       SLS_OFC_CD           ,       SLS_RHQ_CD           ," ).append("\n"); 
		query.append("       SLS_HO_CD            ,       BKG_OFC_CD           ," ).append("\n"); 
		query.append("       CRE_OFC_CD           ,       N1ST_FINC_VVD_CD     ," ).append("\n"); 
		query.append("       N2ND_FINC_VVD_CD     ,       N3RD_FINC_VVD_CD     ," ).append("\n"); 
		query.append("       N4TH_FINC_VVD_CD     ,       N1ST_RLANE_CD        ," ).append("\n"); 
		query.append("       N2ND_RLANE_CD        ,       N3RD_RLANE_CD        ," ).append("\n"); 
		query.append("       N4TH_RLANE_CD        ,       N1ST_TRD_CD          ," ).append("\n"); 
		query.append("       N2ND_TRD_CD          ,       N3RD_TRD_CD          ," ).append("\n"); 
		query.append("       N4TH_TRD_CD          ,       SC_OFC_CD            ," ).append("\n"); 
		query.append("       RFA_OFC_CD           ,       COST_ROUT_NO         ," ).append("\n"); 
		query.append("       PARA_ROUT_NO         ,       PPD_OFC_CD           ," ).append("\n"); 
		query.append("       CLT_OFC_CD           ,       CRE_USR_ID           ," ).append("\n"); 
		query.append("       CRE_DT               ,       UPD_USR_ID           ," ).append("\n"); 
		query.append("       UPD_DT                  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH VW_ROUT_CS_NO AS (" ).append("\n"); 
		query.append("  SELECT * " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   SELECT ROUT_CS_NO   " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("		SELECT  /*+ ORDERED */DISTINCT ROUT.ROUT_CS_NO" ).append("\n"); 
		query.append("		  FROM (" ).append("\n"); 
		query.append("		       SELECT DISTINCT A.TRI_PROP_NO, " ).append("\n"); 
		query.append("		       		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("		         FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("		        WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("		          AND A.ORG_DEST_TP_CD = 'O'     -- ORIGIN" ).append("\n"); 
		query.append("		       ) ORG, " ).append("\n"); 
		query.append("		       (" ).append("\n"); 
		query.append("		       SELECT DISTINCT A.TRI_PROP_NO, " ).append("\n"); 
		query.append("		       		  A.ROUT_PNT_LOC_CD AS LOC_CD, NVL(A.RCV_DE_TERM_CD, 'Y') TERM_CD" ).append("\n"); 
		query.append("		         FROM PRI_TRI_RT_ROUT_PNT A" ).append("\n"); 
		query.append("		        WHERE A.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("		          AND A.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("		       ) DST" ).append("\n"); 
		query.append("		       , PRI_TRI_RT RT" ).append("\n"); 
		query.append("		       , PRI_PRS_ROUT_CS ROUT" ).append("\n"); 
		query.append("		 WHERE ORG.TRI_PROP_NO  = DST.TRI_PROP_NO    " ).append("\n"); 
		query.append("		   AND ORG.TRI_PROP_NO  = RT.TRI_PROP_NO   " ).append("\n"); 
		query.append("		   AND RT.PROP_STS_CD IN ( 'I', 'R')" ).append("\n"); 
		query.append("		   AND ROUT.ROUT_CS_CLSS_NO = @[rout_cs_clss_no]" ).append("\n"); 
		query.append("		   AND ROUT.POR_CD      = ORG.LOC_CD" ).append("\n"); 
		query.append("		   AND ROUT.DEL_CD      = DST.LOC_CD" ).append("\n"); 
		query.append("		   AND ROUT.BKG_RCV_TERM_CD = ORG.TERM_CD -- TERM MAPPING 필요" ).append("\n"); 
		query.append("		   AND ROUT.BKG_DE_TERM_CD  = DST.TERM_CD -- TERM MAPPING 필요" ).append("\n"); 
		query.append("		   AND ROUT.RAT_UT_CD   = RT.RAT_UT_CD" ).append("\n"); 
		query.append("		   AND ROUT.PRC_CGO_TP_CD = RT.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("		MINUS " ).append("\n"); 
		query.append("		SELECT ROUT_CS_NO" ).append("\n"); 
		query.append("		  FROM PRI_PRS_USD_ROUT_CS_INFO" ).append("\n"); 
		query.append("		 WHERE ROUT_CS_SRC_DT = @[rout_cs_src_dt]   " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(" )       " ).append("\n"); 
		query.append("SELECT ROUT_CS_NO           ,       @[rout_cs_src_dt],    " ).append("\n"); 
		query.append("       PCTL_NO              ,       BKG_NO               ," ).append("\n"); 
		query.append("       MTY_PKUP_YD_CD       ,       POR_CD               ," ).append("\n"); 
		query.append("       POR_NOD_CD           ,       POL_CD               ," ).append("\n"); 
		query.append("       N1ST_TS_PORT_CD      ,       N2ND_TS_PORT_CD      ," ).append("\n"); 
		query.append("       N3RD_TS_PORT_CD      ,       POD_CD               ," ).append("\n"); 
		query.append("       DEL_CD               ,       DEL_NOD_CD           ," ).append("\n"); 
		query.append("       MTY_RTN_YD_CD        ,       TTL_TZTM_HRS         ," ).append("\n"); 
		query.append("       PROD_REV             ,       TTL_EXPN_AMT         ," ).append("\n"); 
		query.append("       CM_AMT               ,       TRNK_AVAL_SPC        ," ).append("\n"); 
		query.append("       BKG_SEL_FLG          ,       COP_CRE_FLG          ," ).append("\n"); 
		query.append("       OB_ITCHG_CTNT        ,       IB_ITCHG_CTNT        ," ).append("\n"); 
		query.append("       TRNK_VSL_CD          ,       TRNK_SKD_VOY_NO      ," ).append("\n"); 
		query.append("       TRNK_SKD_DIR_CD      ,       CNST_FLG             ," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD        ,       BKG_RCV_TERM_CD      ," ).append("\n"); 
		query.append("       CMDT_CD              ,       BKG_DE_TERM_CD       ," ).append("\n"); 
		query.append("       REP_CMDT_CD          ,       SHPR_CNT_CD          ," ).append("\n"); 
		query.append("       SHPR_SEQ             ,       CNEE_CNT_CD          ," ).append("\n"); 
		query.append("       CNEE_SEQ             ,       SC_NO                ," ).append("\n"); 
		query.append("       RFA_NO               ,       DG_CLSS_CD           ," ).append("\n"); 
		query.append("       DG_SPCL_FLG          ,       RF_SPCL_FLG          ," ).append("\n"); 
		query.append("       SPCL_AWK_CGO_FLG     ,       BB_SPCL_FLG          ," ).append("\n"); 
		query.append("       RD_SPCL_FLG          ,       HNGR_SPCL_FLG        ," ).append("\n"); 
		query.append("       SOC_FLG              ,       EQ_SUBST_FLG         ," ).append("\n"); 
		query.append("       BKG_WGT              ,       BKG_WGT_UT_CD        ," ).append("\n"); 
		query.append("       SLS_OFC_CD           ,       SLS_RHQ_CD           ," ).append("\n"); 
		query.append("       SLS_HO_CD            ,       BKG_OFC_CD           ," ).append("\n"); 
		query.append("       CRE_OFC_CD           ,       N1ST_FINC_VVD_CD     ," ).append("\n"); 
		query.append("       N2ND_FINC_VVD_CD     ,       N3RD_FINC_VVD_CD     ," ).append("\n"); 
		query.append("       N4TH_FINC_VVD_CD     ,       N1ST_RLANE_CD        ," ).append("\n"); 
		query.append("       N2ND_RLANE_CD        ,       N3RD_RLANE_CD        ," ).append("\n"); 
		query.append("       N4TH_RLANE_CD        ,       N1ST_TRD_CD          ," ).append("\n"); 
		query.append("       N2ND_TRD_CD          ,       N3RD_TRD_CD          ," ).append("\n"); 
		query.append("       N4TH_TRD_CD          ,       SC_OFC_CD            ," ).append("\n"); 
		query.append("       RFA_OFC_CD           ,       COST_ROUT_NO         ," ).append("\n"); 
		query.append("       PARA_ROUT_NO         ,       PPD_OFC_CD           ," ).append("\n"); 
		query.append("       CLT_OFC_CD           ,       'CALC' AS CRE_USR_ID ," ).append("\n"); 
		query.append("       SYSDATE AS CRE_DT    ,       'CALC' AS UPD_USR_ID ,       " ).append("\n"); 
		query.append("       SYSDATE AS UPD_DT       " ).append("\n"); 
		query.append("  FROM PRI_PRS_ROUT_CS_INFO " ).append("\n"); 
		query.append(" WHERE ROUT_CS_NO IN ( SELECT ROUT_CS_NO FROM VW_ROUT_CS_NO ) " ).append("\n"); 
		query.append("   AND ROUT_CS_CLSS_NO = @[rout_cs_clss_no]" ).append("\n"); 

	}
}