/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearch03SubUSA404EDIStatusSendRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOSearch03SubUSA404EDIStatusSendRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Danger Cargo정보, Reefer Cargo 조회
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearch03SubUSA404EDIStatusSendRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dgEqNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dgBkgNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearch03SubUSA404EDIStatusSendRSQLRSQL").append("\n"); 
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
		query.append("SELECT STCC.STCC_CD DG_STCC" ).append("\n"); 
		query.append("      ,DG.IMDG_UN_NO DG_UN" ).append("\n"); 
		query.append("      ,DECODE(IMDG.CFR_FLG, 'Y', 'NA' || IMDG.IMDG_UN_NO) CFR_NBR" ).append("\n"); 
		query.append("      ,DG.PRP_SHP_NM DG_NAME" ).append("\n"); 
		query.append("      ,DG.HZD_DESC DG_TECH" ).append("\n"); 
		query.append("      ,DG.HZD_DESC DG_CONTENTS" ).append("\n"); 
		query.append("      ,DG.IMDG_CLSS_CD DG_CLASS" ).append("\n"); 
		query.append("      ,REGEXP_REPLACE((NVL2(DG.IMDG_SUBS_RSK_LBL_CD1, DG.IMDG_SUBS_RSK_LBL_CD1 || ',' , '' ) " ).append("\n"); 
		query.append("       || NVL2(DG.IMDG_SUBS_RSK_LBL_CD2, DG.IMDG_SUBS_RSK_LBL_CD2 || ',' , '' ) " ).append("\n"); 
		query.append("       || NVL2(DG.IMDG_SUBS_RSK_LBL_CD3, DG.IMDG_SUBS_RSK_LBL_CD3 || ',' , '' ) " ).append("\n"); 
		query.append("       || NVL2(DG.IMDG_SUBS_RSK_LBL_CD4, DG.IMDG_SUBS_RSK_LBL_CD4 || ',' , '' )), ',{1}$')  AS DG_CLASS2" ).append("\n"); 
		query.append("--      ,(SELECT LISTAGG(IMDG_SUBS_RSK_LBL_CD, ',') WITHIN GROUP(ORDER BY IMDG_SUBS_RSK_LBL_CD) FROM SCG_IMDG_SUBS_RSK_LBL  WHERE IMDG_UN_NO = DG.IMDG_UN_NO AND IMDG_UN_NO_SEQ = DG.IMDG_UN_NO_SEQ) AS DG_CLASS2" ).append("\n"); 
		query.append("      ,IMDG.CFR_PSN_INH_ZN_CD AS DG_ZONE" ).append("\n"); 
		query.append("      ,DG.RSD_FLG DG_RESIDUE" ).append("\n"); 
		query.append("      ,DG.ERAP_NO AS DG_ERAP_CD" ).append("\n"); 
		query.append("      ,DG.ERAP_CNTC_NO AS DG_ERAP_TEL" ).append("\n"); 
		query.append("      ,STCC.PCK_GRP_VAL_CD DG_PGRP" ).append("\n"); 
		query.append("      ,DG.PSA_NO DG_PSAGRP" ).append("\n"); 
		query.append("      ,DG.MRN_POLUT_FLG DG_MP" ).append("\n"); 
		query.append("      ,DG.FLSH_PNT_CDO_TEMP DG_FLSHTEMP" ).append("\n"); 
		query.append("      ,'C' DG_FLSHUNIT" ).append("\n"); 
		query.append("      ,NVL(DG.OUT_IMDG_PCK_QTY1, 0) DG_QTY" ).append("\n"); 
		query.append("      ,DG.OUT_IMDG_PCK_CD1 DG_QUNIT" ).append("\n"); 
		query.append("      ,NVL(DG.GRS_WGT, 0) DG_WEIGHT" ).append("\n"); 
		query.append("      ,NVL(DG.WGT_UT_CD, 'KGS') DG_WUNIT" ).append("\n"); 
		query.append("      ,'' DG_CLASS1NEW" ).append("\n"); 
		query.append("      ,'' DG_CLASS1NEWUNIT" ).append("\n"); 
		query.append("      ,DG.IMDG_LMT_QTY_FLG DG_LIMIT" ).append("\n"); 
		query.append("      ,IMDG.IMDG_LMT_QTY DG_LIMIT_QTY" ).append("\n"); 
		query.append("      ,DG.DOT_AUTH_NO" ).append("\n"); 
		query.append("      ,DG.DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append("      ,DG.DOT_EXP_NO" ).append("\n"); 
		query.append("      ,DG.EMER_CNTC_PHN_NO_CTNT AS DG_TEL" ).append("\n"); 
		query.append("      ,DG.EMER_CNTC_PSON_NM AS DG_CONTACT" ).append("\n"); 
		query.append("   	  ,(SELECT DE.DECL_NM FROM BKG_DG_DECL DE WHERE DE.BKG_NO = DG.BKG_NO AND DE.CNTR_NO = DG.CNTR_NO AND DE.DECL_NM IS NOT NULL AND ROWNUM = 1) AS DG_DECLARANT" ).append("\n"); 
		query.append("      ,DG.IMDG_UN_NO_SPCL_PROVI_CTNT AS DG_SPCL_PROVISION" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("      ,SCG_IMDG_UN_NO IMDG" ).append("\n"); 
		query.append("      ,(SELECT BKG_NO" ).append("\n"); 
		query.append("              ,DCGO_SEQ" ).append("\n"); 
		query.append("              ,STCC_CD" ).append("\n"); 
		query.append("              ,STCC_SEQ" ).append("\n"); 
		query.append("              ,PCK_GRP_VAL_CD" ).append("\n"); 
		query.append("          FROM (SELECT D.BKG_NO" ).append("\n"); 
		query.append("                      ,D.DCGO_SEQ" ).append("\n"); 
		query.append("                      ,STCC.STCC_CD" ).append("\n"); 
		query.append("                      ,STCC.STCC_SEQ" ).append("\n"); 
		query.append("                      ,STCC.PCK_GRP_VAL_CD" ).append("\n"); 
		query.append("                      ,ROW_NUMBER() OVER(PARTITION BY D.BKG_NO, D.DCGO_SEQ ORDER BY STCC.STCC_CD, STCC.STCC_SEQ) RN" ).append("\n"); 
		query.append("                  FROM BKG_DG_CGO            D" ).append("\n"); 
		query.append("                      ,TRS_STCC              STCC" ).append("\n"); 
		query.append("                      ,TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("                 WHERE SO.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                   AND SO.EQ_NO = D.CNTR_NO" ).append("\n"); 
		query.append("                   AND SO.EQ_TPSZ_CD = D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		           AND D.IMDG_UN_NO = NVL(STCC.UN_CMDT_CD, D.IMDG_UN_NO)" ).append("\n"); 
		query.append("		           AND D.IMDG_UN_NO_SEQ = NVL(STCC.IMDG_UN_NO_SEQ, D.IMDG_UN_NO_SEQ)" ).append("\n"); 
		query.append("		           AND D.IMDG_CLSS_CD = NVL(STCC.HZD_MTRL_CLSS_CD, D.IMDG_CLSS_CD)" ).append("\n"); 
		query.append("		           AND NVL(D.IMDG_PCK_GRP_CD, 'XX') = NVL2(D.IMDG_PCK_GRP_CD, NVL(STCC.PCK_GRP_CD, D.IMDG_PCK_GRP_CD), 'XX')" ).append("\n"); 
		query.append("		           AND UPPER(REPLACE(TRIM(D.PRP_SHP_NM), ' ', '')) = UPPER(REPLACE(TRIM(STCC.PRP_SHP_NM), ' ', ''))" ).append("\n"); 
		query.append("                   AND STCC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND D.BKG_NO = @[dgBkgNo]" ).append("\n"); 
		query.append("                   AND D.CNTR_NO = @[dgEqNo])" ).append("\n"); 
		query.append("         WHERE RN = 1) STCC" ).append("\n"); 
		query.append(" WHERE DG.IMDG_UN_NO = IMDG.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("   AND DG.IMDG_UN_NO_SEQ = IMDG.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("   AND DG.BKG_NO = STCC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND DG.DCGO_SEQ = STCC.DCGO_SEQ(+)" ).append("\n"); 
		query.append("   AND DG.BKG_NO = @[dgBkgNo]" ).append("\n"); 
		query.append("   AND DG.CNTR_NO = @[dgEqNo]" ).append("\n"); 
		query.append(" ORDER BY DG.CNTR_CGO_SEQ" ).append("\n"); 

	}
}