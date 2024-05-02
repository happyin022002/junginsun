/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBEviCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOCreateApInvDTRBEviCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateApInvDTRBEvi
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOCreateApInvDTRBEviCSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOCreateApInvDTRBEviCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_DTRB (" ).append("\n"); 
		query.append("		CSR_NO, LINE_SEQ, LINE_NO, LINE_TP_LU_CD, INV_AMT," ).append("\n"); 
		query.append("		INV_DESC, INV_TAX_CD, DTRB_COA_CO_CD, DTRB_COA_RGN_CD, DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("		DTRB_COA_ACCT_CD, DTRB_COA_VVD_CD, DTRB_COA_INTER_CO_CD, DTRB_COA_FTU_N1ST_CD, DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("		ATTR_CATE_NM, ATTR_CTNT1, ATTR_CTNT2, ATTR_CTNT3, ATTR_CTNT4," ).append("\n"); 
		query.append("		ATTR_CTNT5, ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9," ).append("\n"); 
		query.append("		ATTR_CTNT10, ATTR_CTNT11, ATTR_CTNT12, ATTR_CTNT13, ATTR_CTNT14," ).append("\n"); 
		query.append("		ATTR_CTNT15, BKG_NO, CNTR_TPSZ_CD, ACT_VVD_CD," ).append("\n"); 
		query.append("		PLN_SCTR_DIV_CD, SO_CRR_CD, YD_CD, FTU_USE_CTNT1, FTU_USE_CTNT2," ).append("\n"); 
		query.append("		FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CTNT5, CRE_DT, CRE_USR_ID," ).append("\n"); 
		query.append("		EAI_EVNT_DT)" ).append("\n"); 
		query.append("  SELECT CSR_NO, (select nvl(max(LINE_SEQ),0)+1 from AP_INV_DTRB where csr_no = @[csr_no]) LINE_SEQ,  ROWNUM+(select nvl(max(LINE_NO),0) from AP_INV_DTRB where csr_no = @[csr_no]) LINE_NO, LINE_TP_LU_CD, CSR_AMT," ).append("\n"); 
		query.append("  INV_DESC, INV_TAX_CD, DTRB_COA_CO_CD, DTRB_COA_RGN_CD, DTRB_COA_CTR_CD, DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("  DTRB_COA_VVD_CD, DTRB_COA_INTER_CO_CD, DTRB_COA_FTU_N1ST_CD, DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("  ATTR_CATE_NM, ATTR_CTNT1, ATTR_CTNT2, ATTR_CTNT3, ATTR_CTNT4, ATTR_CTNT5," ).append("\n"); 
		query.append("  ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9, ATTR_CTNT10, ATTR_CTNT11," ).append("\n"); 
		query.append("  ATTR_CTNT12, ATTR_CTNT13, ATTR_CTNT14, ATTR_CTNT15, BKG_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD, ACT_VVD_CD, PLN_SCTR_DIV_CD, SO_CRR_CD, YD_CD, FTU_USE_CTNT1," ).append("\n"); 
		query.append("  FTU_USE_CTNT2, FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CNTR5, CRE_DT, CRE_USR_ID, EAI_EVNT_DT FROM	(" ).append("\n"); 
		query.append("  SELECT CSR_NO, LINE_SEQ, LINE_NO, LINE_TP_LU_CD, NVL(ROUND(SUM(CSR_AMT),2),0) CSR_AMT," ).append("\n"); 
		query.append("		 INV_DESC, INV_TAX_CD, DTRB_COA_CO_CD, DTRB_COA_RGN_CD, DTRB_COA_CTR_CD, DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("		 DTRB_COA_VVD_CD, DTRB_COA_INTER_CO_CD, DTRB_COA_FTU_N1ST_CD, DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("		 ATTR_CATE_NM, MAX(ATTR_CTNT1) ATTR_CTNT1, MAX(ATTR_CTNT2) ATTR_CTNT2, ATTR_CTNT3, ATTR_CTNT4, ATTR_CTNT5," ).append("\n"); 
		query.append("		 ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9, ATTR_CTNT10, ATTR_CTNT11," ).append("\n"); 
		query.append("		 ATTR_CTNT12, ATTR_CTNT13, ATTR_CTNT14, ATTR_CTNT15, BKG_NO, " ).append("\n"); 
		query.append("		 CNTR_TPSZ_CD, ACT_VVD_CD, PLN_SCTR_DIV_CD, SO_CRR_CD, YD_CD, FTU_USE_CTNT1," ).append("\n"); 
		query.append("		 FTU_USE_CTNT2, FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CNTR5, CRE_DT, CRE_USR_ID, EAI_EVNT_DT" ).append("\n"); 
		query.append("  FROM ( SELECT     DISTINCT @[csr_no]                             CSR_NO," ).append("\n"); 
		query.append("           ''                                                      LINE_SEQ," ).append("\n"); 
		query.append("		   ''                                                      LINE_NO," ).append("\n"); 
		query.append("		   ( SELECT DECODE(SUBSTR(LOC_CD,1,2),'JP','TAX','ITEM')" ).append("\n"); 
		query.append("		   FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("		   WHERE  OFC_CD = H.COST_OFC_CD  )                        LINE_TP_LU_CD," ).append("\n"); 
		query.append("		   DECODE(H.CURR_CD,'KRW',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'JPY',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'TWD',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'CLP',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'DJF',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'IDR',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'VND',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'VUV',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'XAF',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                            'XPF',ROUND(NVL(H.VAT_AMT,0))," ).append("\n"); 
		query.append("                                  ROUND(NVL(H.VAT_AMT,0),2)) CSR_AMT,           " ).append("\n"); 
		query.append("		   H.INV_NO                                                INV_DESC," ).append("\n"); 
		query.append("		   ( SELECT DECODE(SUBSTR(LOC_CD, 1, 2), 'JP', (SELECT SLD.LU_CD --||'('||SLD.LU_DESC||')' --, SLD.ATTR_CTNT1, SLD.ATTR_CTNT2" ).append("\n"); 
		query.append("                                                          FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("                                                         WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("                                                           AND SLH.LU_TP_CD = 'AP TAX CODE'" ).append("\n"); 
		query.append("                                                           AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                                           AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("                                                           AND SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("                                                           AND SLD.ATTR_CTNT2 = 'Y'), '')" ).append("\n"); 
		query.append("			FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("			WHERE  OFC_CD = H.COST_OFC_CD  )                        INV_TAX_CD," ).append("\n"); 
		query.append("		   '01'                                                     DTRB_COA_CO_CD," ).append("\n"); 
		query.append("		   ( SELECT FINC_RGN_CD" ).append("\n"); 
		query.append("			 FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			 WHERE  OFC_CD = H.COST_OFC_CD  )                       DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("		   ( SELECT AP_CTR_CD" ).append("\n"); 
		query.append("			 FROM   MDM_ORGANIZATION" ).append("\n"); 
		query.append("			 WHERE  OFC_CD = H.COST_OFC_CD  )                       DTRB_COA_CTR_CD," ).append("\n"); 
		query.append("		  ( SELECT DECODE(SUBSTR(LOC_CD, 1, 2), 'JP', (SELECT SLD.LU_CD --, SLD.LU_DESC" ).append("\n"); 
		query.append("												         FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("												        WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("												          AND SLH.LU_TP_CD = 'AP TAX ACCOUNT'" ).append("\n"); 
		query.append("												          AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("												          AND SLD.ATTR_CTNT1 = 'INTERNAL'" ).append("\n"); 
		query.append("												          AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("													      AND SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("												          AND ROWNUM = 1 )" ).append("\n"); 
		query.append("													, (SELECT SLD.LU_CD --, SLD.LU_DESC" ).append("\n"); 
		query.append("												         FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("											        	WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("												          AND SLH.LU_TP_CD = 'AP TAX ACCOUNT'" ).append("\n"); 
		query.append("											          	  AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("											          	AND SLD.ATTR_CTNT1 = 'EXTERNAL'" ).append("\n"); 
		query.append("											          	AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("											          	AND SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("											          	AND ROWNUM = 1))" ).append("\n"); 
		query.append("			FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("			WHERE  OFC_CD = H.COST_OFC_CD  )                       DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("		   '0000000000'                                            DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("		   ( SELECT NVL(SUBS_CO_CD,'00')" ).append("\n"); 
		query.append("			 FROM   MDM_VENDOR" ).append("\n"); 
		query.append("			 WHERE  VNDR_SEQ = H.VNDR_SEQ )                        DTRB_COA_INTER_CO_CD," ).append("\n"); 
		query.append("		   '000000'                                                DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("		   '000000'                                                DTRB_COA_FTU_N2ND_CD," ).append("\n"); 
		query.append("		  ( SELECT DECODE(SUBSTR(LOC_CD, 1, 2), 'JP', (SELECT SLD.LU_CD --, SLD.LU_DESC" ).append("\n"); 
		query.append("												         FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("												        WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("												          AND SLH.LU_TP_CD = 'AP TAX ACCOUNT'" ).append("\n"); 
		query.append("												          AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("												          AND SLD.ATTR_CTNT1 = 'INTERNAL'" ).append("\n"); 
		query.append("												          AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("													      AND SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("												          AND ROWNUM = 1 )" ).append("\n"); 
		query.append("													, (SELECT SLD.LU_CD --, SLD.LU_DESC" ).append("\n"); 
		query.append("												         FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("											        	WHERE SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("												          AND SLH.LU_TP_CD = 'AP TAX ACCOUNT'" ).append("\n"); 
		query.append("											          	  AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("											          	AND SLD.ATTR_CTNT1 = 'EXTERNAL'" ).append("\n"); 
		query.append("											          	AND NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("											          	AND SLH.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("											          	AND ROWNUM = 1))" ).append("\n"); 
		query.append("			FROM MDM_ORGANIZATION" ).append("\n"); 
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
		query.append("		   NVL(NVL((SELECT DISTINCT TO_CHAR(MAX(ATB_DT),'YYYYMMDD')" ).append("\n"); 
		query.append("           			  FROM TES_TML_SO_VVD_LIST" ).append("\n"); 
		query.append("			         WHERE TML_SO_OFC_CTY_CD = H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           			   AND TML_SO_SEQ = H.TML_SO_SEQ),H.TO_PRD_DT),H.WRK_DT) ATTR_CTNT11," ).append("\n"); 
		query.append("		   H.YD_CD                                                 ATTR_CTNT12," ).append("\n"); 
		query.append("		   NULL                                                    ATTR_CTNT13," ).append("\n"); 
		query.append("		   'COM'                                                   ATTR_CTNT14," ).append("\n"); 
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
		query.append("		   GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])                     CRE_DT," ).append("\n"); 
		query.append("		   @[cre_usr_id]                                                       CRE_USR_ID," ).append("\n"); 
		query.append("		   ''                                                      EAI_EVNT_DT" ).append("\n"); 
		query.append("		 FROM   TES_TML_SO_HDR H " ).append("\n"); 
		query.append("		 WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vel_inv_no} != '')" ).append("\n"); 
		query.append("	AND H.inv_no IN (" ).append("\n"); 
		query.append("	#foreach($vel_inv_no_num IN ${vel_inv_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $vel_inv_no.size())" ).append("\n"); 
		query.append("		'$vel_inv_no_num'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		'$vel_inv_no_num'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			 AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("			 AND    H.TML_INV_STS_CD      = 'C'" ).append("\n"); 
		query.append("			 AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("	  GROUP BY CSR_NO, LINE_SEQ, LINE_NO, LINE_TP_LU_CD, INV_DESC, INV_TAX_CD, DTRB_COA_CO_CD, DTRB_COA_RGN_CD," ).append("\n"); 
		query.append("			   DTRB_COA_CTR_CD, DTRB_COA_ACCT_CD, DTRB_COA_VVD_CD, DTRB_COA_INTER_CO_CD, DTRB_COA_FTU_N1ST_CD," ).append("\n"); 
		query.append("			   DTRB_COA_FTU_N2ND_CD, ATTR_CATE_NM, ATTR_CTNT3, ATTR_CTNT4, ATTR_CTNT5," ).append("\n"); 
		query.append("			   ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9, ATTR_CTNT10, ATTR_CTNT11, ATTR_CTNT12, ATTR_CTNT13," ).append("\n"); 
		query.append("			   ATTR_CTNT14, ATTR_CTNT15, BKG_NO, CNTR_TPSZ_CD, ACT_VVD_CD, PLN_SCTR_DIV_CD, SO_CRR_CD," ).append("\n"); 
		query.append("			   YD_CD, FTU_USE_CTNT1, FTU_USE_CTNT2, FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CNTR5, CRE_DT, CRE_USR_ID)" ).append("\n"); 

	}
}