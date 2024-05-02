/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCheckMissingLaneCode01RSQL.java
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

public class CARIssueTransferSlipManageDBDAOCheckMissingLaneCode01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckMissingLaneCode01
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCheckMissingLaneCode01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCheckMissingLaneCode01RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	CASE" ).append("\n"); 
		query.append("	WHEN (  SELECT NVL(COUNT(D.CALC_TP_CD),0) CNT" ).append("\n"); 
		query.append("			FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("			WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("			AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("			AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("			AND    H.TML_INV_TP_CD       = 'TM'" ).append("\n"); 
		query.append("			AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("			AND    D.CALC_TP_CD = 'A' ) > 0" ).append("\n"); 
		query.append("	THEN (" ).append("\n"); 
		query.append("		SELECT --RST_01, RST_02, RST_01 - RST_02 DIF," ).append("\n"); 
		query.append("		   CASE" ).append("\n"); 
		query.append("		   WHEN RST_01 IS NOT NULL AND RST_01 <> 0 AND RST_02 IS NOT NULL AND RST_02 <> 0 AND RST_01 = RST_02" ).append("\n"); 
		query.append("		   THEN 'Y'" ).append("\n"); 
		query.append("		   ELSE 'N'" ).append("\n"); 
		query.append("		   END LANE_CD_MATCH_CHK" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("		NVL (" ).append("\n"); 
		query.append("		(SELECT DECODE(@[cnt_cd],'KR',SUM(ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2)),SUM(DECODE(CURR,'JPY',ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2),'TWD',ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2),ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2,2))))" ).append("\n"); 
		query.append("		FROM ( SELECT CSR_AMT," ).append("\n"); 
		query.append("					  NVL(FTU_USE_CTNT2,1)                                    FTU_USE_CTNT2," ).append("\n"); 
		query.append("					  NVL(RATE,1)                                             RATE," ).append("\n"); 
		query.append("					  CURR" ).append("\n"); 
		query.append("			   FROM" ).append("\n"); 
		query.append("			   ( SELECT DISTINCT" ).append("\n"); 
		query.append("					  ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("						FROM   MDM_ACCOUNT" ).append("\n"); 
		query.append("						WHERE  ACCT_CD = D.ACCT_CD )                          INV_DESC," ).append("\n"); 
		query.append("					  ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("						FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("						WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("					  ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("						FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("						WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("					  D.ACCT_CD                                               DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("					  NVL(L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("						  '0000000000')                                       DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("					  ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("						FROM   MDM_VENDOR" ).append("\n"); 
		query.append("						WHERE  VNDR_SEQ = H.VNDR_SEQ )                        DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("					  D.ACCT_CD                                               ATTR_CATE_NM," ).append("\n"); 
		query.append("					  H.INV_NO                                                ATTR_CTNT1," ).append("\n"); 
		query.append("					  TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS')               ATTR_CTNT2," ).append("\n"); 
		query.append("					  SUBSTR(H.YD_CD,1,5)                                     ATTR_CTNT3," ).append("\n"); 
		query.append("					  L.BKG_NO                                                BKG_NO," ).append("\n"); 
		query.append("					  L.CNTR_TPSZ_CD                                          CNTR_TPSZ_CD," ).append("\n"); 
		query.append("					  DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						NVL(L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD,L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("						L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD) ACT_VVD_CD," ).append("\n"); 
		query.append("					  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'ET','T'," ).append("\n"); 
		query.append("						DECODE((SELECT YD_OSHP_CD FROM MDM_YARD WHERE YD_CD = H.YD_CD),'O'," ).append("\n"); 
		query.append("						DECODE(NVL(TRIM(D.TML_CRR_CD),'SML'),'SML','C','T'),'C')) PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("					  TRIM(D.TML_CRR_CD)                                        SO_CRR_CD," ).append("\n"); 
		query.append("					  H.YD_CD                                                 YD_CD," ).append("\n"); 
		query.append("					  D.LGS_COST_CD                                           FTU_USE_CTNT1," ).append("\n"); 
		query.append("					  COUNT(L.CNTR_NO)                                        FTU_USE_CTNT2," ).append("\n"); 
		query.append("					  D.VOL_TR_UT_CD                                          FTU_USE_CTNT3," ).append("\n"); 
		query.append("					  H.CURR_CD                                               CURR" ).append("\n"); 
		query.append("			   FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("			   WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("			   AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("			   AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("			   AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("			   AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			   AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("			   AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')   --수정(20080111)" ).append("\n"); 
		query.append("			   AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("			   AND    NVL(D.INV_AMT,0)      <> 0" ).append("\n"); 
		query.append("			   AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			   AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("			   AND    L.VRFY_RSLT_IND_CD       = 'CO'" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("							 'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							 'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							 'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("							 'ST','N') <> 'Y'" ).append("\n"); 
		query.append("			   AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("						'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("						'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("			   GROUP BY D.ACCT_CD,H.COST_OFC_CD,NVL(L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD,'0000000000')," ).append("\n"); 
		query.append("						H.VNDR_SEQ,H.INV_NO,TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS'),H.YD_CD," ).append("\n"); 
		query.append("						L.BKG_NO,L.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("						DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						NVL(L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD,L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("						L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD), D.LGS_COST_CD," ).append("\n"); 
		query.append("						D.TML_CRR_CD,D.VOL_TR_UT_CD,H.CURR_CD ) M," ).append("\n"); 
		query.append("			  ( SELECT D.LGS_COST_CD, D.CNTR_TPSZ_CD, SUM(NVL(D.INV_AMT,0)) CSR_AMT    --수정(20070723)" ).append("\n"); 
		query.append("				FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("				WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("				AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("				AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("				AND    NVL(H.DELT_FLG,'N')   <> 'Y'                  --추가(20070523)" ).append("\n"); 
		query.append("				AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')      --수정(20080111)" ).append("\n"); 
		query.append("				AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("				AND    NVL(D.INV_AMT,0)      <> 0                    --추가(20070523)" ).append("\n"); 
		query.append("				GROUP BY D.LGS_COST_CD, D.CNTR_TPSZ_CD ) A,                           --수정(20070723)" ).append("\n"); 
		query.append("			  ( SELECT D.LGS_COST_CD, D.CNTR_TPSZ_CD, COUNT(L.CNTR_NO) RATE           --수정(20070723)" ).append("\n"); 
		query.append("				FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("				WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("				AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("				AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("				AND    NVL(H.DELT_FLG,'N')   <> 'Y'                 --추가(20070523)" ).append("\n"); 
		query.append("				AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')    --수정(20080111)" ).append("\n"); 
		query.append("				AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("				AND    NVL(D.INV_AMT,0)      <> 0                   --추가(20070523)" ).append("\n"); 
		query.append("				AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND    L.VRFY_RSLT_IND_CD       = 'CO'" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("							  'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							  'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							  'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("							  'ST','N') <> 'Y'" ).append("\n"); 
		query.append("				AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("						 'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("						 'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("				GROUP BY D.LGS_COST_CD, D.CNTR_TPSZ_CD ) R                 --수정(20070723)" ).append("\n"); 
		query.append("				WHERE M.FTU_USE_CTNT1 = A.LGS_COST_CD" ).append("\n"); 
		query.append("				AND   M.CNTR_TPSZ_CD  = A.CNTR_TPSZ_CD                     --수정(20070723)" ).append("\n"); 
		query.append("				AND   M.FTU_USE_CTNT1 = R.LGS_COST_CD" ).append("\n"); 
		query.append("				AND   M.CNTR_TPSZ_CD  = R.CNTR_TPSZ_CD )),0) RST_01," ).append("\n"); 
		query.append("		NVL (" ).append("\n"); 
		query.append("		(SELECT DECODE(@[cnt_cd],'KR',SUM(ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2)),SUM(DECODE(CURR,'JPY',ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2),'TWD',ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2),ROUND((CSR_AMT/RATE)*FTU_USE_CTNT2,2))))" ).append("\n"); 
		query.append("		FROM ( SELECT CSR_AMT," ).append("\n"); 
		query.append("					  NVL(FTU_USE_CTNT2,1)                                    FTU_USE_CTNT2," ).append("\n"); 
		query.append("					  NVL(RATE,1)                                             RATE," ).append("\n"); 
		query.append("					  CURR" ).append("\n"); 
		query.append("			   FROM" ).append("\n"); 
		query.append("			   ( SELECT DISTINCT" ).append("\n"); 
		query.append("					  ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("						FROM   MDM_ACCOUNT" ).append("\n"); 
		query.append("						WHERE  ACCT_CD = D.ACCT_CD )                          INV_DESC," ).append("\n"); 
		query.append("					  ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("						FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("						WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("					  ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("						FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("						WHERE  OFC_CD = H.COST_OFC_CD )                        DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("					  D.ACCT_CD                                               DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("					  NVL(L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD," ).append("\n"); 
		query.append("						  '0000000000')                                       DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("					  ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("						FROM   MDM_VENDOR" ).append("\n"); 
		query.append("						WHERE  VNDR_SEQ = H.VNDR_SEQ )                        DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("					  D.ACCT_CD                                               ATTR_CATE_NM," ).append("\n"); 
		query.append("					  H.INV_NO                                                ATTR_CTNT1," ).append("\n"); 
		query.append("					  TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS')               ATTR_CTNT2," ).append("\n"); 
		query.append("					  SUBSTR(H.YD_CD,1,5)                                     ATTR_CTNT3," ).append("\n"); 
		query.append("					  L.BKG_NO                                                BKG_NO," ).append("\n"); 
		query.append("					  L.CNTR_TPSZ_CD                                          CNTR_TPSZ_CD," ).append("\n"); 
		query.append("					  DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						NVL(L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD,L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("						L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD) ACT_VVD_CD," ).append("\n"); 
		query.append("					  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'ET','T'," ).append("\n"); 
		query.append("						DECODE((SELECT YD_OSHP_CD FROM MDM_YARD WHERE YD_CD = H.YD_CD),'O'," ).append("\n"); 
		query.append("						DECODE(NVL(TRIM(D.TML_CRR_CD),'SML'),'SML','C','T'),'C')) PLN_SCTR_DIV_CD," ).append("\n"); 
		query.append("					  TRIM(D.TML_CRR_CD)                                        SO_CRR_CD," ).append("\n"); 
		query.append("					  H.YD_CD                                                 YD_CD," ).append("\n"); 
		query.append("					  D.LGS_COST_CD                                           FTU_USE_CTNT1," ).append("\n"); 
		query.append("					  COUNT(L.CNTR_NO)                                        FTU_USE_CTNT2," ).append("\n"); 
		query.append("					  D.VOL_TR_UT_CD                                          FTU_USE_CTNT3," ).append("\n"); 
		query.append("					  H.CURR_CD                                               CURR" ).append("\n"); 
		query.append("			   FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("			   WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("			   AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("			   AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("			   AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("			   AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			   AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("			   AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')   --수정(20080111)" ).append("\n"); 
		query.append("			   AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("			   AND    NVL(D.INV_AMT,0)      <> 0" ).append("\n"); 
		query.append("			   AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			   AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("			   AND    L.VRFY_RSLT_IND_CD       = 'CO'" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("							 'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							 'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							 'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("							 'ST','N') <> 'Y'" ).append("\n"); 
		query.append("			   AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   --AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   --       = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("						'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("						'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("			   AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("					  = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("			   GROUP BY D.ACCT_CD,H.COST_OFC_CD,NVL(L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD,'0000000000')," ).append("\n"); 
		query.append("						H.VNDR_SEQ,H.INV_NO,TO_CHAR(H.ISS_DT,'YYYY/MM/DD HH24:MI:SS'),H.YD_CD," ).append("\n"); 
		query.append("						L.BKG_NO,L.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("						DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						NVL(L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD,L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD)," ).append("\n"); 
		query.append("						L.FINC_VSL_CD||L.FINC_SKD_VOY_NO||L.FINC_SKD_DIR_CD), D.LGS_COST_CD," ).append("\n"); 
		query.append("						D.TML_CRR_CD,D.VOL_TR_UT_CD,H.CURR_CD ) M," ).append("\n"); 
		query.append("			  ( SELECT D.LGS_COST_CD, D.CNTR_TPSZ_CD, SUM(NVL(D.INV_AMT,0)) CSR_AMT    --수정(20070723)" ).append("\n"); 
		query.append("				FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("				WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("				AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("				AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("				AND    NVL(H.DELT_FLG,'N')   <> 'Y'                  --추가(20070523)" ).append("\n"); 
		query.append("				AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')      --수정(20080111)" ).append("\n"); 
		query.append("				AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("				AND    NVL(D.INV_AMT,0)      <> 0                    --추가(20070523)" ).append("\n"); 
		query.append("				GROUP BY D.LGS_COST_CD, D.CNTR_TPSZ_CD ) A,                           --수정(20070723)" ).append("\n"); 
		query.append("			  ( SELECT D.LGS_COST_CD, D.CNTR_TPSZ_CD, COUNT(L.CNTR_NO) RATE           --수정(20070723)" ).append("\n"); 
		query.append("				FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("				WHERE  H.INV_NO              = @[inv_no]" ).append("\n"); 
		query.append("				AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("				AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("				AND    NVL(H.DELT_FLG,'N')   <> 'Y'                 --추가(20070523)" ).append("\n"); 
		query.append("				AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND    D.CALC_COST_GRP_CD    NOT IN ('SD','SP')    --수정(20080111)" ).append("\n"); 
		query.append("				AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("				AND    NVL(D.INV_AMT,0)      <> 0                   --추가(20070523)" ).append("\n"); 
		query.append("				AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND    L.VRFY_RSLT_IND_CD       = 'CO'" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD," ).append("\n"); 
		query.append("							  'TM',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							  'ON',DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',NVL(L.RVIS_IND_FLG,'N'),'TM',NVL(L.TML_RVIS_IND_FLG,'N'),'SR',NVL(L.STO_RVIS_IND_FLG,'N'),'SV',NVL(L.STV_RVIS_IND_FLG,'N'),'CG',NVL(L.CGO_RVIS_IND_FLG,'N'))," ).append("\n"); 
		query.append("							  'OF',NVL(L.TML_RVIS_IND_FLG,'N')," ).append("\n"); 
		query.append("							  'ST','N') <> 'Y'" ).append("\n"); 
		query.append("				AND    NVL(L.CNTR_TPSZ_CD,'N')     = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				--AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				--       = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("						 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("						 'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("						 'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("				AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("					   = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("				GROUP BY D.LGS_COST_CD, D.CNTR_TPSZ_CD ) R                 --수정(20070723)" ).append("\n"); 
		query.append("				WHERE M.FTU_USE_CTNT1 = A.LGS_COST_CD" ).append("\n"); 
		query.append("				AND   M.CNTR_TPSZ_CD  = A.CNTR_TPSZ_CD                     --수정(20070723)" ).append("\n"); 
		query.append("				AND   M.FTU_USE_CTNT1 = R.LGS_COST_CD" ).append("\n"); 
		query.append("				AND   M.CNTR_TPSZ_CD  = R.CNTR_TPSZ_CD)),0) RST_02" ).append("\n"); 
		query.append("		FROM DUAL) X" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	ELSE 'M'" ).append("\n"); 
		query.append("	END LANE_CD_MATCH_CHK" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}