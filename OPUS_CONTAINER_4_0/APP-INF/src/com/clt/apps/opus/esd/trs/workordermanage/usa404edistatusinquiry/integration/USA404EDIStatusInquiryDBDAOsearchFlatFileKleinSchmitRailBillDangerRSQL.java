/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.16
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.08.16 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFlatFileKleinSchmitRailBillDanger
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOsearchFlatFileKleinSchmitRailBillDangerRSQL").append("\n"); 
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
		query.append("#if(${f_type} == 'L')" ).append("\n"); 
		query.append("SELECT PKG_CD" ).append("\n"); 
		query.append("      ,PKG_QTY" ).append("\n"); 
		query.append("      ,UNBR" ).append("\n"); 
		query.append("      ,CFR_NBR" ).append("\n"); 
		query.append("      ,DG_STCC" ).append("\n"); 
		query.append("      ,GWGT" ).append("\n"); 
		query.append("      ,GWGT_UNIT" ).append("\n"); 
		query.append("      ,NWGT" ).append("\n"); 
		query.append("      ,NWGT_UNIT" ).append("\n"); 
		query.append("      ,CLASS" ).append("\n"); 
		query.append("      ,CLASS2" ).append("\n"); 
		query.append("      ,PKG_GRP" ).append("\n"); 
		query.append("      ,PROPER" ).append("\n"); 
		query.append("      ,PROPER_NOS" ).append("\n"); 
		query.append("      ,TECHNICAL" ).append("\n"); 
		query.append("      ,DECLARANT" ).append("\n"); 
		query.append("      ,SPCL_PROVISION" ).append("\n"); 
		query.append("      ,ERAP_CD" ).append("\n"); 
		query.append("      ,ERAP_CONTACT" ).append("\n"); 
		query.append("      ,FLASH" ).append("\n"); 
		query.append("      ,FLASH_UNIT" ).append("\n"); 
		query.append("      ,TEMP_CONTROL" ).append("\n"); 
		query.append("      ,TEMP_CONTROL_UNIT" ).append("\n"); 
		query.append("      ,TEMP_EMERENCY" ).append("\n"); 
		query.append("      ,TEMP_EMERENCY_UNIT" ).append("\n"); 
		query.append("      ,WGT_NE" ).append("\n"); 
		query.append("      ,WGT_NE_UNIT" ).append("\n"); 
		query.append("      ,PIOSON_ZONE" ).append("\n"); 
		query.append("      ,LIMIT" ).append("\n"); 
		query.append("      ,MAR_POLL" ).append("\n"); 
		query.append("      ,D13_IND" ).append("\n"); 
		query.append("      ,HOT_IND" ).append("\n"); 
		query.append("      ,INHALATION_IND" ).append("\n"); 
		query.append("      ,RESIDUE_IND" ).append("\n"); 
		query.append("      ,PIOSON_IND" ).append("\n"); 
		query.append("      ,RQ_IND" ).append("\n"); 
		query.append("      ,PIC_NM" ).append("\n"); 
		query.append("      ,PIC_TEL" ).append("\n"); 
		query.append("      ,DCGO_SEQ" ).append("\n"); 
		query.append("      ,DG_CNTR_SEQ" ).append("\n"); 
		query.append("      ,DOT_AUTH_NO" ).append("\n"); 
		query.append("      ,DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append("      ,DOT_EXP_NO" ).append("\n"); 
		query.append("      ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,EQ_TPSZ" ).append("\n"); 
		query.append("  FROM (SELECT P.OUT_IMDG_PCK_CD1 PKG_CD" ).append("\n"); 
		query.append("              ,NVL(P.OUT_IMDG_PCK_QTY1, 0) PKG_QTY" ).append("\n"); 
		query.append("              ,P.IMDG_UN_NO AS UNBR" ).append("\n"); 
		query.append("              ,DECODE(S.CFR_FLG, 'Y', 'NA' || S.IMDG_UN_NO) CFR_NBR" ).append("\n"); 
		query.append("              ,STCC.STCC_CD DG_STCC" ).append("\n"); 
		query.append("              ,NVL(P.GRS_WGT, 0) AS GWGT" ).append("\n"); 
		query.append("              ,'KGS' AS GWGT_UNIT" ).append("\n"); 
		query.append("              ,NVL(P.NET_WGT, 0) AS NWGT" ).append("\n"); 
		query.append("              ,'KGS' AS NWGT_UNIT" ).append("\n"); 
		query.append("              ,P.IMDG_CLSS_CD AS CLASS" ).append("\n"); 
		query.append("			  ,REGEXP_REPLACE((NVL2(P.IMDG_SUBS_RSK_LBL_CD1, P.IMDG_SUBS_RSK_LBL_CD1 || ',' , '' ) " ).append("\n"); 
		query.append("			   || NVL2(P.IMDG_SUBS_RSK_LBL_CD2, P.IMDG_SUBS_RSK_LBL_CD2 || ',' , '' ) " ).append("\n"); 
		query.append("			   || NVL2(P.IMDG_SUBS_RSK_LBL_CD3, P.IMDG_SUBS_RSK_LBL_CD3 || ',' , '' ) " ).append("\n"); 
		query.append("			   || NVL2(P.IMDG_SUBS_RSK_LBL_CD4, P.IMDG_SUBS_RSK_LBL_CD4 || ',' , '' )), ',{1}$')  AS CLASS2" ).append("\n"); 
		query.append("--              ,(SELECT LISTAGG(IMDG_SUBS_RSK_LBL_CD, ',') WITHIN GROUP(ORDER BY IMDG_SUBS_RSK_LBL_CD) FROM SCG_IMDG_SUBS_RSK_LBL WHERE IMDG_UN_NO = P.IMDG_UN_NO AND IMDG_UN_NO_SEQ = P.IMDG_UN_NO_SEQ) AS CLASS2" ).append("\n"); 
		query.append("              ,STCC.PCK_GRP_VAL_CD AS PKG_GRP" ).append("\n"); 
		query.append("              ,P.PRP_SHP_NM AS PROPER" ).append("\n"); 
		query.append("              ,DECODE(INSTR(P.PRP_SHP_NM, 'N.O.S', 1, 1), 0, '', 'NOS') AS PROPER_NOS" ).append("\n"); 
		query.append("              ,P.HZD_DESC AS TECHNICAL" ).append("\n"); 
		query.append("              ,(SELECT DE.DECL_NM FROM BKG_DG_DECL DE WHERE DE.BKG_NO = P.BKG_NO AND DE.DG_CNTR_SEQ = P.DG_CNTR_SEQ AND DE.DECL_NM IS NOT NULL AND ROWNUM = 1) AS DECLARANT" ).append("\n"); 
		query.append("              ,P.IMDG_UN_NO_SPCL_PROVI_CTNT AS SPCL_PROVISION" ).append("\n"); 
		query.append("              ,P.ERAP_NO AS ERAP_CD" ).append("\n"); 
		query.append("              ,P.ERAP_CNTC_NO AS ERAP_CONTACT" ).append("\n"); 
		query.append("              ,P.FLSH_PNT_CDO_TEMP AS FLASH" ).append("\n"); 
		query.append("              ,NVL2(P.FLSH_PNT_CDO_TEMP, 'CE', '') AS FLASH_UNIT" ).append("\n"); 
		query.append("              ,'' AS TEMP_CONTROL" ).append("\n"); 
		query.append("              ,'' AS TEMP_CONTROL_UNIT" ).append("\n"); 
		query.append("              ,'' AS TEMP_EMERENCY" ).append("\n"); 
		query.append("              ,'' AS TEMP_EMERENCY_UNIT" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(P.NET_EXPLO_WGT, 0) > 0 THEN TO_CHAR(P.NET_EXPLO_WGT) END AS WGT_NE" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(P.NET_EXPLO_WGT, 0) > 0 THEN 'KGS' END AS WGT_NE_UNIT" ).append("\n"); 
		query.append("              ,S.CFR_PSN_INH_ZN_CD AS PIOSON_ZONE" ).append("\n"); 
		query.append("              ,DECODE(P.IMDG_LMT_QTY_FLG, 'N', '', P.IMDG_LMT_QTY_FLG) AS LIMIT" ).append("\n"); 
		query.append("              ,P.MRN_POLUT_FLG AS MAR_POLL" ).append("\n"); 
		query.append("              ,'' AS D13_IND" ).append("\n"); 
		query.append("              ,'' AS HOT_IND" ).append("\n"); 
		query.append("              ,'' AS INHALATION_IND" ).append("\n"); 
		query.append("              ,DECODE(P.RSD_FLG, 'N', '', P.RSD_FLG) AS RESIDUE_IND" ).append("\n"); 
		query.append("              ,'' AS PIOSON_IND" ).append("\n"); 
		query.append("              ,DECODE(NVL(S.CFR_RPT_QTY, 0), 0, '', 'Y') AS RQ_IND" ).append("\n"); 
		query.append("              ,P.EMER_CNTC_PSON_NM AS PIC_NM" ).append("\n"); 
		query.append("              ,P.EMER_CNTC_PHN_NO_CTNT AS PIC_TEL" ).append("\n"); 
		query.append("              ,P.DCGO_SEQ" ).append("\n"); 
		query.append("              ,P.DG_CNTR_SEQ" ).append("\n"); 
		query.append("              ,P.DOT_AUTH_NO" ).append("\n"); 
		query.append("              ,P.DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append("              ,P.DOT_EXP_NO" ).append("\n"); 
		query.append("              ,A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,A.BKG_NO" ).append("\n"); 
		query.append("              ,P.CNTR_NO AS EQ_NO" ).append("\n"); 
		query.append("              ,P.CNTR_TPSZ_CD AS EQ_TPSZ" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("              ,BKG_CONTAINER D" ).append("\n"); 
		query.append("              ,BKG_DG_CGO P" ).append("\n"); 
		query.append("              ,SCG_IMDG_UN_NO S" ).append("\n"); 
		query.append("              ,(SELECT BKG_NO" ).append("\n"); 
		query.append("                      ,DCGO_SEQ" ).append("\n"); 
		query.append("                      ,STCC_CD" ).append("\n"); 
		query.append("                      ,STCC_SEQ" ).append("\n"); 
		query.append("                      ,PCK_GRP_VAL_CD" ).append("\n"); 
		query.append("                  FROM (SELECT DG.BKG_NO" ).append("\n"); 
		query.append("                              ,DG.DCGO_SEQ" ).append("\n"); 
		query.append("                              ,STCC.STCC_CD" ).append("\n"); 
		query.append("                              ,STCC.STCC_SEQ" ).append("\n"); 
		query.append("                              ,STCC.PCK_GRP_VAL_CD" ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(PARTITION BY DG.BKG_NO, DG.DCGO_SEQ ORDER BY STCC.STCC_CD, STCC.STCC_SEQ) RN" ).append("\n"); 
		query.append("                          FROM BKG_DG_CGO            DG" ).append("\n"); 
		query.append("                              ,TRS_STCC              STCC" ).append("\n"); 
		query.append("                              ,TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("                         WHERE SO.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("                           AND SO.EQ_NO = DG.CNTR_NO" ).append("\n"); 
		query.append("                           AND DG.IMDG_UN_NO = NVL(STCC.UN_CMDT_CD, DG.IMDG_UN_NO)" ).append("\n"); 
		query.append("                           AND DG.IMDG_UN_NO_SEQ = NVL(STCC.IMDG_UN_NO_SEQ, DG.IMDG_UN_NO_SEQ)" ).append("\n"); 
		query.append("                           AND DG.IMDG_CLSS_CD = NVL(STCC.HZD_MTRL_CLSS_CD, DG.IMDG_CLSS_CD)" ).append("\n"); 
		query.append("                           AND NVL(DG.IMDG_PCK_GRP_CD, 'XX') = NVL2(DG.IMDG_PCK_GRP_CD, NVL(STCC.PCK_GRP_CD, DG.IMDG_PCK_GRP_CD), 'XX')" ).append("\n"); 
		query.append("                           AND UPPER(REPLACE(TRIM(DG.PRP_SHP_NM), ' ', '')) = UPPER(REPLACE(TRIM(STCC.PRP_SHP_NM), ' ', ''))" ).append("\n"); 
		query.append("                           AND STCC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                           AND SO.TRSP_SO_SEQ = @[trsp_so_seq])" ).append("\n"); 
		query.append("                 WHERE RN = 1) STCC" ).append("\n"); 
		query.append("         WHERE A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("           AND A.EQ_NO = D.CNTR_NO" ).append("\n"); 
		query.append("           AND A.BKG_NO = P.BKG_NO" ).append("\n"); 
		query.append("           AND A.EQ_NO = P.CNTR_NO" ).append("\n"); 
		query.append("           AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND P.IMDG_UN_NO = S.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("           AND P.IMDG_UN_NO_SEQ = S.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("           AND P.BKG_NO = STCC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND P.DCGO_SEQ = STCC.DCGO_SEQ(+)" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#elseif(${f_type} == 'D')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	'' AS PKG_CD" ).append("\n"); 
		query.append("	,'' AS PKG_QTY" ).append("\n"); 
		query.append("	,'' AS UNBR   " ).append("\n"); 
		query.append("	,'' AS CFR_NBR         " ).append("\n"); 
		query.append("	,'' AS DG_STCC" ).append("\n"); 
		query.append("	,'' AS GWGT" ).append("\n"); 
		query.append("	,'' AS GWGT_UNIT" ).append("\n"); 
		query.append("	,'' AS NWGT" ).append("\n"); 
		query.append("	,'' AS NWGT_UNIT" ).append("\n"); 
		query.append("	,'' AS CLASS" ).append("\n"); 
		query.append("	,'' AS CLASS2" ).append("\n"); 
		query.append("	,'' AS PKG_GRP" ).append("\n"); 
		query.append("	,'' AS PROPER" ).append("\n"); 
		query.append("	,'' AS PROPER_NOS" ).append("\n"); 
		query.append("	,'' AS TECHNICAL" ).append("\n"); 
		query.append("	,'' AS DECLARANT" ).append("\n"); 
		query.append("	,'' AS SPCL_PROVISION" ).append("\n"); 
		query.append("	,'' AS ERAP_CD" ).append("\n"); 
		query.append("	,'' AS ERAP_CONTACT" ).append("\n"); 
		query.append("	,'' AS FLASH" ).append("\n"); 
		query.append("	,'' AS FLASH_UNIT" ).append("\n"); 
		query.append("	,'' AS TEMP_CONTROL" ).append("\n"); 
		query.append("	,'' AS TEMP_CONTROL_UNIT" ).append("\n"); 
		query.append("	,'' AS TEMP_EMERENCY" ).append("\n"); 
		query.append("	,'' AS TEMP_EMERENCY_UNIT" ).append("\n"); 
		query.append("	,'' AS WGT_NE" ).append("\n"); 
		query.append("	,'' AS WGT_NE_UNIT" ).append("\n"); 
		query.append("	,'' AS PIOSON_ZONE" ).append("\n"); 
		query.append("	,'' AS LIMIT" ).append("\n"); 
		query.append("	,'' AS MAR_POLL" ).append("\n"); 
		query.append("	,'' AS D13_IND" ).append("\n"); 
		query.append("	,'' AS HOT_IND" ).append("\n"); 
		query.append("	,'' AS INHALATION_IND" ).append("\n"); 
		query.append("	,'' AS RESIDUE_IND" ).append("\n"); 
		query.append("	,'' AS PIOSON_IND" ).append("\n"); 
		query.append("	,'' AS RQ_IND" ).append("\n"); 
		query.append("	,'' AS PIC_NM" ).append("\n"); 
		query.append("	,'' AS PIC_TEL" ).append("\n"); 
		query.append("	,'' AS DCGO_SEQ" ).append("\n"); 
		query.append("    ,'' AS DG_CNTR_SEQ" ).append("\n"); 
		query.append("	,'' AS DOT_AUTH_NO" ).append("\n"); 
		query.append("    ,'' AS DOT_SPCL_APRO_NO" ).append("\n"); 
		query.append("    ,'' AS DOT_EXP_NO	" ).append("\n"); 
		query.append("    ,'' AS TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    ,'' AS TRSP_SO_SEQ" ).append("\n"); 
		query.append("    ,'' AS BKG_NO" ).append("\n"); 
		query.append("    ,'' AS EQ_NO" ).append("\n"); 
		query.append("    ,'' AS EQ_TPSZ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}