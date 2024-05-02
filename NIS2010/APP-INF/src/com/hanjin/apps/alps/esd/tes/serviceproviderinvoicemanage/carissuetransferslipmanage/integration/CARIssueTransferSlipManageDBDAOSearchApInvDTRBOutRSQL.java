/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchApInvDTRBOutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchApInvDTRBOutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchApInvDTRBOut
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchApInvDTRBOutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("line_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchApInvDTRBOutRSQL").append("\n"); 
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
		query.append("SELECT LINE_SEQ, ROWNUM LINE_NO, LINE_TP_LU_CD, CSR_AMT," ).append("\n"); 
		query.append("		INV_DESC, INV_TAX_CD, DTRB_COA_CO_CD, DTRB_COA_RGN_CD, DTRB_COA_CTR_CD, DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("		DTRB_COA_VVD_CD, DTRB_COA_INTER_CO_CD, DTRB_COA_FTU_N1ST_CD, DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("		ATTR_CATE_NM, ATTR_CTNT1, ATTR_CTNT2, ATTR_CTNT3, ATTR_CTNT4, ATTR_CTNT5," ).append("\n"); 
		query.append("		ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9, ATTR_CTNT10, ATTR_CTNT11," ).append("\n"); 
		query.append("		ATTR_CTNT12, ATTR_CTNT13, ATTR_CTNT14, ATTR_CTNT15, BKG_NO, " ).append("\n"); 
		query.append("		CNTR_TPSZ_CD, ACT_VVD_CD, PLN_SCTR_DIV_CD, SO_CRR_CD, YD_CD, FTU_USE_CTNT1," ).append("\n"); 
		query.append("		FTU_USE_CTNT2, FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CNTR5, CRE_DT, CRE_USR_ID, EAI_EVNT_DT" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append(" SELECT LINE_SEQ, LINE_NO, LINE_TP_LU_CD, DECODE(CURR,'JPY',ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2),'TWD',ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2)," ).append("\n"); 
		query.append("	   ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2,2)) CSR_AMT," ).append("\n"); 
		query.append("	   INV_DESC, INV_TAX_CD, DTRB_COA_CO_CD, DTRB_COA_RGN_CD, DTRB_COA_CTR_CD, DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("	   DTRB_COA_VVD_CD, DTRB_COA_INTER_CO_CD, DTRB_COA_FTU_N1ST_CD, DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("	   ATTR_CATE_NM, ATTR_CTNT1, ATTR_CTNT2, ATTR_CTNT3, ATTR_CTNT4, ATTR_CTNT5," ).append("\n"); 
		query.append("	   ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9, ATTR_CTNT10, ATTR_CTNT11," ).append("\n"); 
		query.append("	   ATTR_CTNT12, ATTR_CTNT13, ATTR_CTNT14, ATTR_CTNT15, BKG_NO," ).append("\n"); 
		query.append("	   CNTR_TPSZ_CD, ACT_VVD_CD, PLN_SCTR_DIV_CD, SO_CRR_CD, YD_CD, FTU_USE_CTNT1," ).append("\n"); 
		query.append("	   FTU_USE_CTNT2, FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CNTR5, CRE_DT, CRE_USR_ID, EAI_EVNT_DT" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("	   SELECT @[line_seq]                                                     LINE_SEQ," ).append("\n"); 
		query.append("			  ''                                                      LINE_NO," ).append("\n"); 
		query.append("			  'ITEM'                                                  LINE_TP_LU_CD," ).append("\n"); 
		query.append("			  CSR_AMT," ).append("\n"); 
		query.append("			  INV_DESC," ).append("\n"); 
		query.append("			  @[inv_tax_cd]                                                       INV_TAX_CD," ).append("\n"); 
		query.append("			  '01'                                                    DTRB_COA_CO_CD," ).append("\n"); 
		query.append("			  DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("			  DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("			  DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("			  DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("			  DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("			  '000000'                                                DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("			  '000000'                                                DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("			  ATTR_CATE_NM," ).append("\n"); 
		query.append("			  ATTR_CTNT1," ).append("\n"); 
		query.append("			  ATTR_CTNT2," ).append("\n"); 
		query.append("			  ATTR_CTNT3," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT4," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT5," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT6," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT7," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT8," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT9," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT10," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT11," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT12," ).append("\n"); 
		query.append("			  NULL                                                    ATTR_CTNT13," ).append("\n"); 
		query.append("			  AP_RVS_CNG_FLG                                          ATTR_CTNT14," ).append("\n"); 
		query.append("			  'A'                                                     ATTR_CTNT15," ).append("\n"); 
		query.append("			  BKG_NO," ).append("\n"); 
		query.append("			  M.CNTR_TPSZ_CD,                                        --수정(20070723)" ).append("\n"); 
		query.append("			  ACT_VVD_CD," ).append("\n"); 
		query.append("			  PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("			  SO_CRR_CD," ).append("\n"); 
		query.append("			  YD_CD," ).append("\n"); 
		query.append("			  FTU_USE_CTNT1," ).append("\n"); 
		query.append("			  NVL(FTU_USE_CTNT2,1)                                    FTU_USE_CTNT2," ).append("\n"); 
		query.append("			  FTU_USE_CTNT3," ).append("\n"); 
		query.append("			  NULL                                                    FTU_USE_CTNT4," ).append("\n"); 
		query.append("			  NULL                                                    FTU_USE_CNTR5," ).append("\n"); 
		query.append("			  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])                    CRE_DT," ).append("\n"); 
		query.append("			  @[cre_usr_id]                                                       CRE_USR_ID," ).append("\n"); 
		query.append("			  NVL(RATE,1)                                             RATE," ).append("\n"); 
		query.append("			  CURR," ).append("\n"); 
		query.append("			  '' EAI_EVNT_DT" ).append("\n"); 
		query.append("	   FROM" ).append("\n"); 
		query.append("	   ( SELECT DISTINCT" ).append("\n"); 
		query.append("			  ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("				FROM   MDM_ACCOUNT" ).append("\n"); 
		query.append("				WHERE  ACCT_CD = D.ACCT_CD )                          INV_DESC," ).append("\n"); 
		query.append("			  ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("				FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("				WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("			  ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("				FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("				WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("			  D.ACCT_CD                                               DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("			  NVL(L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("				  '0000000000')                                       DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("			  ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("				FROM   MDM_VENDOR" ).append("\n"); 
		query.append("				WHERE  VNDR_SEQ = H.VNDR_SEQ )                        DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("			  D.ACCT_CD                                               ATTR_CATE_NM," ).append("\n"); 
		query.append("			  H.INV_NO                                                ATTR_CTNT1," ).append("\n"); 
		query.append("			  TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS')               ATTR_CTNT2," ).append("\n"); 
		query.append("			  SUBSTR(H.YD_CD,1,5)                                     ATTR_CTNT3," ).append("\n"); 
		query.append("			  L.BKG_NO                                                BKG_NO," ).append("\n"); 
		query.append("			  L.CNTR_TPSZ_CD                                          CNTR_TPSZ_CD," ).append("\n"); 
		query.append("			  DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				NVL(L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD,L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("				L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD) ACT_VVD_CD," ).append("\n"); 
		query.append("			  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'ET','T'," ).append("\n"); 
		query.append("				DECODE((SELECT YD_OSHP_CD FROM MDM_YARD WHERE YD_CD = H.YD_CD),'O'," ).append("\n"); 
		query.append("				DECODE(NVL(TRIM(D.TML_CRR_CD),'SML'),'SML','C','T'),'C')) PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("			  TRIM(D.TML_CRR_CD)        	                           SO_CRR_CD," ).append("\n"); 
		query.append("			  H.YD_CD                                                 YD_CD," ).append("\n"); 
		query.append("			  D.LGS_COST_CD                                           FTU_USE_CTNT1," ).append("\n"); 
		query.append("			  COUNT(L.CNTR_NO)                                        FTU_USE_CTNT2," ).append("\n"); 
		query.append("			  D.VOL_TR_UT_CD                                          FTU_USE_CTNT3," ).append("\n"); 
		query.append("			  H.CURR_CD                                               CURR," ).append("\n"); 
		query.append("			  H.AP_RVS_CNG_FLG	" ).append("\n"); 
		query.append("	   FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("	   WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("	   AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("	   AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("	   AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("	   AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	   AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("--		       AND    D.CALC_COST_GRP_CD    <> 'SP'" ).append("\n"); 
		query.append("	   AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')  --수정(20080111)" ).append("\n"); 
		query.append("	   AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("	   AND    NVL(D.INV_AMT,0)      <> 0" ).append("\n"); 
		query.append("	   AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	   AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("	   AND    L.VRFY_RSLT_IND_CD       = 'CO'" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("						'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("						'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("						'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("						'ST','N') <> 'Y'" ).append("\n"); 
		query.append("	   AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("--		       AND    DECODE('TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		              = DECODE('TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		       AND    DECODE('TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		              = DECODE('TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		       AND    DECODE('TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		              = DECODE('TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		       AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("----		                DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("--		                DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("--		                'ON',DECODE(CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("--		              = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR('TMNDRF',6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("--		                'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("--수정(20070920) -- B" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("				'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("				'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF',NVL(L.DCGO_CLSS_CD,'N'),'ST',NVL(L.DCGO_CLSS_CD,'N'))" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF',NVL(D.DCGO_IND_CD,'N'),'ST',NVL(D.DCGO_IND_CD,'N'))" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("	   AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("--수정(20070920) -- E" ).append("\n"); 
		query.append("	   GROUP BY D.ACCT_CD,H.COST_OFC_CD,NVL(L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD,'0000000000')," ).append("\n"); 
		query.append("				H.VNDR_SEQ,H.INV_NO,TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS'),H.YD_CD," ).append("\n"); 
		query.append("				L.BKG_NO,L.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("				DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				NVL(L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD,L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("				L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD), D.LGS_COST_CD," ).append("\n"); 
		query.append("				D.TML_CRR_CD,D.VOL_TR_UT_CD,H.CURR_CD,H.AP_RVS_CNG_FLG	) M," ).append("\n"); 
		query.append("	  ( SELECT D.LGS_COST_CD, D.CNTR_TPSZ_CD, D.TML_CRR_CD, SUM(NVL(D.INV_AMT,0)) CSR_AMT                   --수정(20070723)" ).append("\n"); 
		query.append("		FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("		WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("		AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("		AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("		AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("		AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("--		        AND    D.CALC_COST_GRP_CD    <> 'SP'" ).append("\n"); 
		query.append("		AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')  --수정(20080111)" ).append("\n"); 
		query.append("		AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("		AND    NVL(D.INV_AMT,0)      <> 0" ).append("\n"); 
		query.append("		GROUP BY D.LGS_COST_CD, D.CNTR_TPSZ_CD, D.TML_CRR_CD ) A,                                           --수정(20070723)" ).append("\n"); 
		query.append("	  ( SELECT D.LGS_COST_CD, D.CNTR_TPSZ_CD, D.TML_CRR_CD, COUNT(L.CNTR_NO) RATE                           --수정(20070723)" ).append("\n"); 
		query.append("		FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("		WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("		AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("		AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("		AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("		AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("--		        AND    D.CALC_COST_GRP_CD    <> 'SP'" ).append("\n"); 
		query.append("		AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')  --수정(20080111)" ).append("\n"); 
		query.append("		AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("		AND    NVL(D.INV_AMT,0)      <> 0" ).append("\n"); 
		query.append("		AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND    L.VRFY_RSLT_IND_CD       = 'CO'" ).append("\n"); 
		query.append("		 AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("						'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("						'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("						'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("						'ST','N') <> 'Y'" ).append("\n"); 
		query.append("		AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("--		        AND    DECODE('TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		               = DECODE('TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		        AND    DECODE('TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		               = DECODE('TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		        AND    DECODE('TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		               = DECODE('TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("--		        AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("----		                 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("--		                 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("--		                 'ON',DECODE(CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("--		               = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR('TMNDRF',6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("--		                 'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("--수정(20070920) -- B" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("				 'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("				 'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF',NVL(L.DCGO_CLSS_CD,'N'),'ST',NVL(L.DCGO_CLSS_CD,'N'))" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF',NVL(D.DCGO_IND_CD,'N'),'ST',NVL(D.DCGO_IND_CD,'N'))" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("		AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("			   = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("--수정(20070920) -- E" ).append("\n"); 
		query.append("		GROUP BY D.LGS_COST_CD, D.CNTR_TPSZ_CD, D.TML_CRR_CD ) R                   --수정(20070723)" ).append("\n"); 
		query.append("		WHERE M.FTU_USE_CTNT1 = A.LGS_COST_CD" ).append("\n"); 
		query.append("		AND   M.CNTR_TPSZ_CD  = A.CNTR_TPSZ_CD                       --수정(20070723)" ).append("\n"); 
		query.append("		AND   M.FTU_USE_CTNT1 = R.LGS_COST_CD" ).append("\n"); 
		query.append("		AND   M.CNTR_TPSZ_CD  = R.CNTR_TPSZ_CD                       --수정(20070723)" ).append("\n"); 
		query.append("        AND   NVL(M.SO_CRR_CD,'N') = NVL(A.TML_CRR_CD,'N')  " ).append("\n"); 
		query.append("        AND   NVL(A.TML_CRR_CD,'N') = NVL(R.TML_CRR_CD,'N')) " ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT --DISTINCT" ).append("\n"); 
		query.append("		   @[line_seq]                                 LINE_SEQ," ).append("\n"); 
		query.append("		   ''                                                      LINE_NO," ).append("\n"); 
		query.append("		   'ITEM'                                                  LINE_TP_LU_CD," ).append("\n"); 
		query.append("		   DECODE(H.CURR_CD,'JPY',ROUND(SUM(NVL(D.INV_AMT,0))),'TWD',ROUND(SUM(NVL(D.INV_AMT,0))),ROUND(SUM(NVL(D.INV_AMT,0)),2)) CSR_AMT,  --수정(20070523)" ).append("\n"); 
		query.append("		   ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("			 FROM   MDM_ACCOUNT" ).append("\n"); 
		query.append("			 WHERE  ACCT_CD = D.ACCT_CD )                          INV_DESC," ).append("\n"); 
		query.append("		   @[inv_tax_cd]                                                       INV_TAX_CD," ).append("\n"); 
		query.append("		   '01'                                                    DTRB_COA_CO_CD," ).append("\n"); 
		query.append("		   ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("			 FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			 WHERE  OFC_CD = H.COST_OFC_CD  )                       DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("		   ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("			 FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			 WHERE  OFC_CD = H.COST_OFC_CD  )                       DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("		   D.ACCT_CD                                               DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("		   DECODE(D.ACCT_CD,'954111','0000000000', NVL(D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD, '0000000000')) DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("		   ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("			 FROM   MDM_VENDOR" ).append("\n"); 
		query.append("			 WHERE  VNDR_SEQ = H.VNDR_SEQ )                        DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("		   '000000'                                                DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("		   '000000'                                                DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("		   D.ACCT_CD                                               ATTR_CATE_NM," ).append("\n"); 
		query.append("		   H.INV_NO                                                ATTR_CTNT1," ).append("\n"); 
		query.append("		   TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS')               ATTR_CTNT2," ).append("\n"); 
		query.append("		   SUBSTR(H.YD_CD,1,5)                                     ATTR_CTNT3," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT4," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT5," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT6," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT7," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT8," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT9," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT10," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT11," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT12," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT13," ).append("\n"); 
		query.append("		   H.AP_RVS_CNG_FLG                                        ATTR_CTNT14," ).append("\n"); 
		query.append("--		           'M'                                                     ATTR_CTNT15," ).append("\n"); 
		query.append("		   D.CALC_TP_CD                                            ATTR_CTNT15,       --수정(20080111)" ).append("\n"); 
		query.append("		   NULL                                                    BKG_NO," ).append("\n"); 
		query.append("		   NULL                                                    CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		   DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("				  NVL(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD,D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("				  D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD)  ACT_VVD_CD," ).append("\n"); 
		query.append("		   DECODE(SUBSTR(D.LGS_COST_CD,1,2),'ET','T'," ).append("\n"); 
		query.append("			   DECODE((SELECT YD_OSHP_CD FROM MDM_YARD WHERE YD_CD = H.YD_CD),'O'," ).append("\n"); 
		query.append("			DECODE(NVL(TRIM(D.TML_CRR_CD),'SML'),'SML','C','T'),'C')) PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("		   TRIM(D.TML_CRR_CD) 			                            SO_CRR_CD," ).append("\n"); 
		query.append("		   H.YD_CD                                                 YD_CD," ).append("\n"); 
		query.append("		   D.LGS_COST_CD                                           FTU_USE_CTNT1," ).append("\n"); 
		query.append("		   D.RVIS_VOL_QTY                                          FTU_USE_CTNT2," ).append("\n"); 
		query.append("		   D.VOL_TR_UT_CD                                          FTU_USE_CTNT3," ).append("\n"); 
		query.append("		   NULL                                                    FTU_USE_CTNT4," ).append("\n"); 
		query.append("		   NULL                                                    FTU_USE_CNTR5," ).append("\n"); 
		query.append("		   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])                    CRE_DT," ).append("\n"); 
		query.append("		   @[cre_usr_id]                                                       CRE_USR_ID," ).append("\n"); 
		query.append("		   ''                                                      EAI_EVNT_DT" ).append("\n"); 
		query.append("	FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("	WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("	AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("	AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("	AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("	AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("	AND    H.TML_SO_SEQ          = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("--		    AND    ( D.CALC_COST_GRP_CD    = 'SP'" ).append("\n"); 
		query.append("	AND    ( D.CALC_COST_GRP_CD    IN ('SD','SP')   --수정(20080111)" ).append("\n"); 
		query.append("	OR       D.CALC_TP_CD          = 'M' )" ).append("\n"); 
		query.append("	AND    NVL(D.INV_AMT,0)      <> 0                         --추가(20070523)" ).append("\n"); 
		query.append("	GROUP BY TO_CHAR(D.TML_SO_DTL_SEQ), '', 'ITEM', D.ACCT_CD, @[inv_tax_cd], '01', H.COST_OFC_CD ," ).append("\n"); 
		query.append("			 H.TML_INV_TP_CD, D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD, H.VNDR_SEQ, H.INV_NO, H.ISS_DT," ).append("\n"); 
		query.append("			 SUBSTR(H.YD_CD,1,5), NVL(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD,D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("			 DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP','C','SV','C','T'), D.TML_CRR_CD, H.YD_CD, D.LGS_COST_CD, D.RVIS_VOL_QTY, D.VOL_TR_UT_CD," ).append("\n"); 
		query.append("--		             GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(), , H.CURR_CD" ).append("\n"); 
		query.append("			 GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), @[vndr_seq], H.CURR_CD, D.CALC_TP_CD  --(20080111)" ).append("\n"); 
		query.append("			 , H.AP_RVS_CNG_FLG" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT @[line_seq]                                                       LINE_SEQ," ).append("\n"); 
		query.append("		   ''                                                      LINE_NO," ).append("\n"); 
		query.append("		   ( SELECT DECODE(SUBSTR(LOC_CD,1,2),'KR','TAX','HQ','TAX','ITEM')" ).append("\n"); 
		query.append("		   FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		   WHERE  OFC_CD = H.COST_OFC_CD  )                         LINE_TP_LU_CD," ).append("\n"); 
		query.append("		   DECODE(H.CURR_CD,'JPY',ROUND(NVL(H.VAT_AMT,0)),'TWD',ROUND(NVL(H.VAT_AMT,0)),ROUND(NVL(H.VAT_AMT,0),2)) CSR_AMT,           --수정(20070523)" ).append("\n"); 
		query.append("		   H.INV_NO                                                INV_DESC," ).append("\n"); 
		query.append("		   @[inv_tax_cd]                                                       INV_TAX_CD," ).append("\n"); 
		query.append("		   '01'                                                    DTRB_COA_CO_CD," ).append("\n"); 
		query.append("		   ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("			 FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			 WHERE  OFC_CD = H.COST_OFC_CD  )                       DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("		   ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("			 FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			 WHERE  OFC_CD = H.COST_OFC_CD  )                       DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("		  ( SELECT DECODE(SUBSTR(LOC_CD,1,2),'KR','111811','HQ','111811','111821')" ).append("\n"); 
		query.append("			FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			WHERE  OFC_CD = H.COST_OFC_CD  )                        DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("		   '0000000000'                                            DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("		   ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("			 FROM   MDM_VENDOR" ).append("\n"); 
		query.append("			 WHERE  VNDR_SEQ = H.VNDR_SEQ )                        DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("		   '000000'                                                DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("		   '000000'                                                DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("		  ( SELECT DECODE(SUBSTR(LOC_CD,1,2),'KR','111811','HQ','111811','111821')" ).append("\n"); 
		query.append("			FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			WHERE  OFC_CD = H.COST_OFC_CD  )                        ATTR_CATE_NM," ).append("\n"); 
		query.append("		   H.INV_NO                                                ATTR_CTNT1," ).append("\n"); 
		query.append("		   TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS')               ATTR_CTNT2," ).append("\n"); 
		query.append("		   SUBSTR(H.YD_CD,1,5)                                     ATTR_CTNT3," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT4," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT5," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT6," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT7," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT8," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT9," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT10," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT11," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT12," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT13," ).append("\n"); 
		query.append("		   H.AP_RVS_CNG_FLG                                        ATTR_CTNT14," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT15," ).append("\n"); 
		query.append("		   NULL                                                    BKG_NO," ).append("\n"); 
		query.append("		   NULL                                                    CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		   NULL                                                    ACT_VVD_CD," ).append("\n"); 
		query.append("		   NULL                                                    PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("		   NULL                                                    SO_CRR_CD," ).append("\n"); 
		query.append("		   H.YD_CD                                                 YD_CD," ).append("\n"); 
		query.append("		   NULL                                                    FTU_USE_CTNT1," ).append("\n"); 
		query.append("		   NULL                                                    FTU_USE_CTNT2," ).append("\n"); 
		query.append("		   NULL                                                    FTU_USE_CTNT3," ).append("\n"); 
		query.append("		   NULL                                                    FTU_USE_CTNT4," ).append("\n"); 
		query.append("		   NULL                                                    FTU_USE_CNTR5," ).append("\n"); 
		query.append("		   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])                    CRE_DT," ).append("\n"); 
		query.append("		   @[cre_usr_id]                                                       CRE_USR_ID," ).append("\n"); 
		query.append("		   ''                                                      EAI_EVNT_DT" ).append("\n"); 
		query.append("	FROM   TES_TML_SO_HDR H" ).append("\n"); 
		query.append("	WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("	AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("	AND    H.VAT_AMT <> 0" ).append("\n"); 
		query.append("	AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("	AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("	AND    NVL(H.VAT_AMT,0)      <> 0         --추가(20070523)" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append(" SELECT DISTINCT" ).append("\n"); 
		query.append("		@[line_seq]                                                       LINE_SEQ," ).append("\n"); 
		query.append("		''                                                      LINE_NO," ).append("\n"); 
		query.append("		'ITEM'                                                  LINE_TP_LU_CD," ).append("\n"); 
		query.append("		DECODE(H.CURR_CD,'JPY',ROUND(-NVL(H.WHLD_TAX_AMT,0)),'TWD',ROUND(-NVL(H.WHLD_TAX_AMT,0)),                 --수정(20070523)" ).append("\n"); 
		query.append("		  ROUND(-NVL(H.WHLD_TAX_AMT,0),2))                      CSR_AMT,      --수정(20070523)" ).append("\n"); 
		query.append("		'WITHHOLDING TAX'                                       INV_DESC," ).append("\n"); 
		query.append("		@[inv_tax_cd]                                                       INV_TAX_CD," ).append("\n"); 
		query.append("		'01'                                                    DTRB_COA_CO_CD," ).append("\n"); 
		query.append("		( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("		  FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		  WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("		( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("		  FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		  WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("		'211691'                                                DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("		'0000000000'                                            DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("		( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("		  FROM   MDM_VENDOR" ).append("\n"); 
		query.append("		  WHERE  VNDR_SEQ = H.VNDR_SEQ )                        DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("		'000000'                                                DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("		'000000'                                                DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("		'211691'                                                ATTR_CATE_NM," ).append("\n"); 
		query.append("		H.INV_NO                                                ATTR_CTNT1," ).append("\n"); 
		query.append("		TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS')               ATTR_CTNT2," ).append("\n"); 
		query.append("		SUBSTR(H.YD_CD,1,5)                                     ATTR_CTNT3," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT4," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT5," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT6," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT7," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT8," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT9," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT10," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT11," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT12," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT13," ).append("\n"); 
		query.append("		H.AP_RVS_CNG_FLG                                        ATTR_CTNT14," ).append("\n"); 
		query.append("		NULL                                                    ATTR_CTNT15," ).append("\n"); 
		query.append("		NULL                                                    BKG_NO," ).append("\n"); 
		query.append("		NULL                                                    CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		NULL                                                    ACT_VVD_CD," ).append("\n"); 
		query.append("		NULL                                                    PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("		NULL                                                    SO_CRR_CD," ).append("\n"); 
		query.append("		H.YD_CD                                                 YD_CD," ).append("\n"); 
		query.append("		NULL                                                    FTU_USE_CTNT1," ).append("\n"); 
		query.append("		NULL                                                    FTU_USE_CTNT2," ).append("\n"); 
		query.append("		NULL                                                    FTU_USE_CTNT3," ).append("\n"); 
		query.append("		NULL                                                    FTU_USE_CTNT4," ).append("\n"); 
		query.append("		NULL                                                    FTU_USE_CNTR5," ).append("\n"); 
		query.append("		GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])                    CRE_DT," ).append("\n"); 
		query.append("		@[cre_usr_id]                                                       CRE_USR_ID," ).append("\n"); 
		query.append("		''                                                      EAI_EVNT_DT" ).append("\n"); 
		query.append(" FROM   TES_TML_SO_HDR H" ).append("\n"); 
		query.append(" WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append(" AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append(" AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append(" AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append(" AND    NVL(H.WHLD_TAX_AMT,0) <> 0             --추가(20070523)" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}