/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPriRqRtListHorizontalExcelForAddOnTariffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.31
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.31 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPriRqRtListHorizontalExcelForAddOnTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quotation Excel Download (Horizontal)
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPriRqRtListHorizontalExcelForAddOnTariffVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fic_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration ").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPriRqRtListHorizontalExcelForAddOnTariffVORSQL").append("\n"); 
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
		query.append("SELECT   A.CMDT_DP_SEQ" ).append("\n"); 
		query.append("	,B.ROUT_DP_SEQ" ).append("\n"); 
		query.append("	,A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("	,A.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("	,B.ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,B.ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("	,B.ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("	,B.ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("	,B.ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,B.DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("	,B.DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("	,B.DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("	,B.DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("	,B.DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,B.RATE_DRY20" ).append("\n"); 
		query.append("	,B.RATE_DRY40" ).append("\n"); 
		query.append("	,B.RATE_DRY40HC" ).append("\n"); 
		query.append("	,B.RATE_DRY45" ).append("\n"); 
		query.append("	,B.RATE_RD40HC" ).append("\n"); 
		query.append("	,B.RATE_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,B.ORG_RATE_FIC_DRY20" ).append("\n"); 
		query.append("	,B.ORG_RATE_FIC_DRY40" ).append("\n"); 
		query.append("	,B.ORG_RATE_FIC_DRY40HC" ).append("\n"); 
		query.append("	,B.ORG_RATE_FIC_DRY45" ).append("\n"); 
		query.append("	,B.ORG_RATE_FIC_RD40HC" ).append("\n"); 
		query.append("	,B.ORG_RATE_FIC_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,B.DEST_RATE_FIC_DRY20" ).append("\n"); 
		query.append("	,B.DEST_RATE_FIC_DRY40" ).append("\n"); 
		query.append("	,B.DEST_RATE_FIC_DRY40HC" ).append("\n"); 
		query.append("	,B.DEST_RATE_FIC_DRY45" ).append("\n"); 
		query.append("	,B.DEST_RATE_FIC_RD40HC" ).append("\n"); 
		query.append("	,B.DEST_RATE_FIC_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,B.RATE_BOF_DRY20  " ).append("\n"); 
		query.append("	,B.RATE_BOF_DRY40" ).append("\n"); 
		query.append("	,B.RATE_BOF_DRY40HC" ).append("\n"); 
		query.append("	,B.RATE_BOF_DRY45" ).append("\n"); 
		query.append("	,B.RATE_BOF_RD40HC" ).append("\n"); 
		query.append("	,B.RATE_BOF_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' ORG_BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("	,'' FIC_ORG_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("	,'' FIC_ORG_GLINE_RT_AMT_DRY20" ).append("\n"); 
		query.append("	,'' FIC_ORG_GLINE_RT_AMT_DRY40" ).append("\n"); 
		query.append("	,'' FIC_ORG_GLINE_RT_AMT_DRY40HC" ).append("\n"); 
		query.append("	,'' FIC_ORG_GLINE_RT_AMT_DRY45" ).append("\n"); 
		query.append("	,'' FIC_ORG_GLINE_RT_AMT_RF40HC" ).append("\n"); 
		query.append("	,'' FIC_ORG_GLINE_RT_AMT_RD40HC" ).append("\n"); 
		query.append("	,'' FIC_ORG_RT_USE_STS_CD_DRY20" ).append("\n"); 
		query.append("	,'' FIC_ORG_RT_USE_STS_CD_DRY40" ).append("\n"); 
		query.append("	,'' FIC_ORG_RT_USE_STS_CD_DRY40HC" ).append("\n"); 
		query.append("	,'' FIC_ORG_RT_USE_STS_CD_DRY45" ).append("\n"); 
		query.append("	,'' FIC_ORG_RT_USE_STS_CD_RF40HC" ).append("\n"); 
		query.append("	,'' FIC_ORG_RT_USE_STS_CD_RD40HC" ).append("\n"); 
		query.append("	,'' ORG_OPTM_TRSP_MOD_FLG_DRY20" ).append("\n"); 
		query.append("	,'' ORG_OPTM_TRSP_MOD_FLG_DRY40" ).append("\n"); 
		query.append("	,'' ORG_OPTM_TRSP_MOD_FLG_DRY40HC" ).append("\n"); 
		query.append("	,'' ORG_OPTM_TRSP_MOD_FLG_DRY45" ).append("\n"); 
		query.append("	,'' ORG_OPTM_TRSP_MOD_FLG_RF40HC" ).append("\n"); 
		query.append("	,'' ORG_OPTM_TRSP_MOD_FLG_RD40HC       " ).append("\n"); 
		query.append("	,'' DEST_BSE_PORT_LOC_CD      " ).append("\n"); 
		query.append("	,'' FIC_DEST_ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("	,'' FIC_DEST_GLINE_RT_AMT_DRY20" ).append("\n"); 
		query.append("	,'' FIC_DEST_GLINE_RT_AMT_DRY40" ).append("\n"); 
		query.append("	,'' FIC_DEST_GLINE_RT_AMT_DRY40HC" ).append("\n"); 
		query.append("	,'' FIC_DEST_GLINE_RT_AMT_DRY45" ).append("\n"); 
		query.append("	,'' FIC_DEST_GLINE_RT_AMT_RF40HC" ).append("\n"); 
		query.append("	,'' FIC_DEST_GLINE_RT_AMT_RD40HC" ).append("\n"); 
		query.append("	,'' FIC_DEST_RT_USE_STS_CD_DRY20" ).append("\n"); 
		query.append("	,'' FIC_DEST_RT_USE_STS_CD_DRY40" ).append("\n"); 
		query.append("	,'' FIC_DEST_RT_USE_STS_CD_DRY40HC" ).append("\n"); 
		query.append("	,'' FIC_DEST_RT_USE_STS_CD_DRY45" ).append("\n"); 
		query.append("	,'' FIC_DEST_RT_USE_STS_CD_RF40HC" ).append("\n"); 
		query.append("	,'' FIC_DEST_RT_USE_STS_CD_RD40HC" ).append("\n"); 
		query.append("	,'' DEST_OPTM_TRSP_MOD_FLG_DRY20" ).append("\n"); 
		query.append("	,'' DEST_OPTM_TRSP_MOD_FLG_DRY40" ).append("\n"); 
		query.append("	,'' DEST_OPTM_TRSP_MOD_FLG_DRY40HC" ).append("\n"); 
		query.append("	,'' DEST_OPTM_TRSP_MOD_FLG_DRY45" ).append("\n"); 
		query.append("	,'' DEST_OPTM_TRSP_MOD_FLG_RF40HC" ).append("\n"); 
		query.append("	,'' DEST_OPTM_TRSP_MOD_FLG_RD40HC" ).append("\n"); 
		query.append("	,'' ORG_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("	,'' DEST_CY_DOR_RT_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (SELECT S.CMDT_ROWKEY, A.CMDT_DP_SEQ, B.PRC_CMDT_DEF_CD, B.PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("          FROM (SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                       LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.CMDT_HDR_SEQ ORDER BY NULL), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_RQ_RT_CMDT T, PRI_RQ_RT_CMDT_HDR T1" ).append("\n"); 
		query.append("                 WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                   AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                   AND T.QTTN_NO = T1.QTTN_NO" ).append("\n"); 
		query.append("                   AND T.QTTN_VER_NO = T1.QTTN_VER_NO" ).append("\n"); 
		query.append("                   AND T.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                   AND NVL(T1.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G')" ).append("\n"); 
		query.append("               ) S" ).append("\n"); 
		query.append("              ,(SELECT ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO ORDER BY T.CMDT_HDR_SEQ) AS CMDT_DP_SEQ" ).append("\n"); 
		query.append("                      ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || '00001' AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_RQ_RT_CMDT_HDR T" ).append("\n"); 
		query.append("                  WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                    AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                    AND NVL(T.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G')" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                      ,T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                      ,DECODE(T.PRC_CMDT_TP_CD" ).append("\n"); 
		query.append("                             ,'G'" ).append("\n"); 
		query.append("                             ,(SELECT PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("                                FROM PRI_RQ_GRP_CMDT" ).append("\n"); 
		query.append("                               WHERE QTTN_NO = T.QTTN_NO" ).append("\n"); 
		query.append("                                 AND QTTN_VER_NO = T.QTTN_VER_NO" ).append("\n"); 
		query.append("                                 AND PRC_GRP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'R'" ).append("\n"); 
		query.append("                             ,(SELECT REP_CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                               WHERE REP_CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             ,'C'" ).append("\n"); 
		query.append("                             ,(SELECT CMDT_NM" ).append("\n"); 
		query.append("                                FROM MDM_COMMODITY" ).append("\n"); 
		query.append("                               WHERE CMDT_CD = T.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1)) AS PRC_CMDT_DEF_NM" ).append("\n"); 
		query.append("                       ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                        LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO" ).append("\n"); 
		query.append("                                ,T.CMDT_HDR_SEQ ORDER BY DECODE(T.PRC_CMDT_TP_CD, 'G', 1, 'R', 2, 'C', 3, 99)" ).append("\n"); 
		query.append("                                ,T.PRC_CMDT_DEF_CD)" ).append("\n"); 
		query.append("                                ,5" ).append("\n"); 
		query.append("                                ,'0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                  FROM PRI_RQ_RT_CMDT T, PRI_RQ_RT_CMDT_HDR T1" ).append("\n"); 
		query.append("                 WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                   AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                   AND T.QTTN_NO = T1.QTTN_NO" ).append("\n"); 
		query.append("                   AND T.QTTN_VER_NO = T1.QTTN_VER_NO" ).append("\n"); 
		query.append("                   AND T.CMDT_HDR_SEQ = T1.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                   AND NVL(T1.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G')" ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("         WHERE S.CMDT_ROWKEY = A.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("           AND S.CMDT_ROWKEY = B.CMDT_ROWKEY(+)" ).append("\n"); 
		query.append("         ORDER BY S.CMDT_ROWKEY) A" ).append("\n"); 
		query.append("  FULL OUTER JOIN (SELECT LPAD(S.CMDT_HDR_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                          LPAD(ROW_NUMBER() OVER(PARTITION BY S.CMDT_HDR_SEQ ORDER BY S.ROUT_ROWKEY), 5, '0') AS CMDT_ROWKEY" ).append("\n"); 
		query.append("                         ,A.ROUT_DP_SEQ" ).append("\n"); 
		query.append("                         ,B.ROUT_PNT_LOC_DEF_CD AS ORG_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                         ,B.ROUT_PNT_LOC_DEF_NM AS ORG_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                         ,B.RCV_DE_TERM_NM AS ORG_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                         ,B.PRC_TRSP_MOD_NM AS ORG_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                         ,B.BSE_PORT_LOC_CD AS ORG_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                         ,E.BSE_PORT_LOC_CD AS DEST_ROUT_VIA_PORT_DEF_CD" ).append("\n"); 
		query.append("                         ,E.ROUT_PNT_LOC_DEF_CD AS DEST_ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                         ,E.ROUT_PNT_LOC_DEF_NM AS DEST_ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                         ,E.RCV_DE_TERM_NM AS DEST_RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                         ,E.PRC_TRSP_MOD_NM AS DEST_PRC_TRSP_MOD_NM" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("			 			 ,F.RATE_DRY20" ).append("\n"); 
		query.append("                         ,F.RATE_DRY40" ).append("\n"); 
		query.append("                         ,F.RATE_DRY40HC" ).append("\n"); 
		query.append("                         ,F.RATE_DRY45" ).append("\n"); 
		query.append("                         ,F.RATE_RD40HC" ).append("\n"); 
		query.append("                         ,F.RATE_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ,F.ORG_RATE_FIC_DRY20" ).append("\n"); 
		query.append("                         ,F.ORG_RATE_FIC_DRY40" ).append("\n"); 
		query.append("                         ,F.ORG_RATE_FIC_DRY40HC" ).append("\n"); 
		query.append("                         ,F.ORG_RATE_FIC_DRY45" ).append("\n"); 
		query.append("                         ,F.ORG_RATE_FIC_RD40HC" ).append("\n"); 
		query.append("                         ,F.ORG_RATE_FIC_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         ,F.DEST_RATE_FIC_DRY20" ).append("\n"); 
		query.append("                         ,F.DEST_RATE_FIC_DRY40" ).append("\n"); 
		query.append("                         ,F.DEST_RATE_FIC_DRY40HC" ).append("\n"); 
		query.append("                         ,F.DEST_RATE_FIC_DRY45" ).append("\n"); 
		query.append("                         ,F.DEST_RATE_FIC_RD40HC" ).append("\n"); 
		query.append("                         ,F.DEST_RATE_FIC_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			 ,F.RATE_DRY20 - NVL(F.ORG_RATE_FIC_DRY20, 0) + NVL(F.DEST_RATE_FIC_DRY20, 0) AS RATE_BOF_DRY20  " ).append("\n"); 
		query.append("			 ,F.RATE_DRY40 - NVL(F.ORG_RATE_FIC_DRY40, 0) + NVL(F.DEST_RATE_FIC_DRY40, 0) AS RATE_BOF_DRY40" ).append("\n"); 
		query.append("			 ,F.RATE_DRY40HC - NVL(F.ORG_RATE_FIC_DRY40HC, 0) + NVL(F.DEST_RATE_FIC_DRY40HC, 0) AS RATE_BOF_DRY40HC" ).append("\n"); 
		query.append("			 ,F.RATE_DRY45 - NVL(F.ORG_RATE_FIC_DRY45, 0) + NVL(F.DEST_RATE_FIC_DRY45, 0) AS RATE_BOF_DRY45" ).append("\n"); 
		query.append("			 ,F.RATE_RD40HC - NVL(F.ORG_RATE_FIC_RD40HC, 0) + NVL(F.DEST_RATE_FIC_RD40HC, 0) AS RATE_BOF_RD40HC" ).append("\n"); 
		query.append("			 ,F.RATE_RF40HC - NVL(F.ORG_RATE_FIC_RF40HC, 0) + NVL(F.DEST_RATE_FIC_RF40HC, 0) AS RATE_BOF_RF40HC" ).append("\n"); 
		query.append("                     FROM (SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                           AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                           SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER()" ).append("\n"); 
		query.append("                                       OVER(PARTITION BY QTTN_NO, QTTN_VER_NO, CMDT_HDR_SEQ, ROUT_SEQ ORDER BY NULL)" ).append("\n"); 
		query.append("                                      ,5" ).append("\n"); 
		query.append("                                      ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RQ_RT_ROUT_PNT" ).append("\n"); 
		query.append("                            WHERE QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                           AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                          ) S" ).append("\n"); 
		query.append("                         ,(SELECT ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO, T.CMDT_HDR_SEQ ORDER BY T.ROUT_SEQ) AS ROUT_DP_SEQ" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RQ_RT_CMDT_ROUT T" ).append("\n"); 
		query.append("                            WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                           AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                          ) A" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,T.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                                 ,DECODE(T.ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("                                       'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("                                 (SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                          FROM PRI_RQ_GRP_LOC" ).append("\n"); 
		query.append("                                         WHERE QTTN_NO = T.QTTN_NO" ).append("\n"); 
		query.append("                                           AND QTTN_VER_NO = T.QTTN_VER_NO" ).append("\n"); 
		query.append("                       AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                       'R'," ).append("\n"); 
		query.append("                                       (SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("                                          FROM MDM_REGION" ).append("\n"); 
		query.append("                                         WHERE RGN_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                       'C',                                                 --COUNTRY" ).append("\n"); 
		query.append("                                       (SELECT CNT_NM" ).append("\n"); 
		query.append("                                          FROM MDM_COUNTRY" ).append("\n"); 
		query.append("                                         WHERE CNT_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                       'L',                                                 --LOCATION    " ).append("\n"); 
		query.append("                                       (SELECT LOC_NM" ).append("\n"); 
		query.append("                                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                         WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02071'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS PRC_TRSP_MOD_NM          " ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'C', 1, 'R', 2, 'G', 3, 'L', 4, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("                                           ,5" ).append("\n"); 
		query.append("                                           ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RQ_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                           AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'O'" ).append("\n"); 
		query.append("                          ) B" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                 ,T.BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("                                 ,DECODE(T.ROUT_PNT_LOC_TP_CD," ).append("\n"); 
		query.append("                                       'G',                                                 --GROUP LOCATION" ).append("\n"); 
		query.append("                                 (SELECT PRC_GRP_LOC_DESC" ).append("\n"); 
		query.append("                                          FROM PRI_RQ_GRP_LOC" ).append("\n"); 
		query.append("                                         WHERE QTTN_NO = T.QTTN_NO" ).append("\n"); 
		query.append("                                           AND QTTN_VER_NO = T.QTTN_VER_NO" ).append("\n"); 
		query.append("                                    AND PRC_GRP_LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                       'R'," ).append("\n"); 
		query.append("                                       (SELECT RGN_NM                                       --REGION" ).append("\n"); 
		query.append("                                          FROM MDM_REGION" ).append("\n"); 
		query.append("                                         WHERE RGN_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                       'C',                                                 --COUNTRY" ).append("\n"); 
		query.append("                                       (SELECT CNT_NM" ).append("\n"); 
		query.append("                                          FROM MDM_COUNTRY" ).append("\n"); 
		query.append("                                         WHERE CNT_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)," ).append("\n"); 
		query.append("                                       'L',                                                 --LOCATION    " ).append("\n"); 
		query.append("                                       (SELECT LOC_NM" ).append("\n"); 
		query.append("                                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                         WHERE LOC_CD = T.ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append("                                           AND ROWNUM = 1)) AS ROUT_PNT_LOC_DEF_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD02071'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.RCV_DE_TERM_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS RCV_DE_TERM_NM" ).append("\n"); 
		query.append("                                 ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                     FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                    WHERE INTG_CD_ID = 'CD01720'" ).append("\n"); 
		query.append("                                      AND INTG_CD_VAL_CTNT = T.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1) AS PRC_TRSP_MOD_NM          " ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' ||" ).append("\n"); 
		query.append("                                  LPAD(ROW_NUMBER() OVER(PARTITION BY T.QTTN_NO, T.QTTN_VER_NO" ).append("\n"); 
		query.append("                                           ,T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                           ,T.ROUT_SEQ ORDER BY DECODE(T.ROUT_PNT_LOC_TP_CD, 'C', 1, 'R', 2, 'G', 3, 'L', 4, 99)" ).append("\n"); 
		query.append("                                           ,T.ROUT_PNT_LOC_DEF_CD)" ).append("\n"); 
		query.append("                                           ,5" ).append("\n"); 
		query.append("                                           ,'0') AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RQ_RT_ROUT_PNT T" ).append("\n"); 
		query.append("                            WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                           AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                              AND T.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("                          ) E" ).append("\n"); 
		query.append("                         ,(SELECT T.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                 ,T.ROUT_SEQ" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' THEN T.QTTN_RT_AMT END) AS RATE_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' THEN T.QTTN_RT_AMT END) AS RATE_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.QTTN_RT_AMT END) AS RATE_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' THEN T.QTTN_RT_AMT END) AS RATE_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.QTTN_RT_AMT END) AS RATE_RD40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' THEN T.QTTN_RT_AMT END) AS RATE_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_ORG_QTTN_RT_AMT END) AS ORG_RATE_FIC_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_ORG_QTTN_RT_AMT END) AS ORG_RATE_FIC_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_ORG_QTTN_RT_AMT END) AS ORG_RATE_FIC_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_ORG_QTTN_RT_AMT END) AS ORG_RATE_FIC_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_ORG_QTTN_RT_AMT END) AS ORG_RATE_FIC_RD40HC " ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' THEN T.FIC_ORG_QTTN_RT_AMT END) AS ORG_RATE_FIC_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D2' OR T.RAT_UT_CD = '20') AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_DEST_QTTN_RT_AMT END) AS DEST_RATE_FIC_DRY20" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D4' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_DEST_QTTN_RT_AMT END) AS DEST_RATE_FIC_DRY40" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'D5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_DEST_QTTN_RT_AMT END) AS DEST_RATE_FIC_DRY40HC" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'D7' OR T.RAT_UT_CD = '45') AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_DEST_QTTN_RT_AMT END) AS DEST_RATE_FIC_DRY45" ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN T.RAT_UT_CD = 'R5' AND T.PRC_CGO_TP_CD = 'DR' THEN T.FIC_DEST_QTTN_RT_AMT END) AS DEST_RATE_FIC_RD40HC " ).append("\n"); 
		query.append("                                 ,SUM(CASE WHEN (T.RAT_UT_CD = 'R5' OR T.RAT_UT_CD = '40') AND T.PRC_CGO_TP_CD = 'RF' THEN T.FIC_DEST_QTTN_RT_AMT END) AS DEST_RATE_FIC_RF40HC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 ,LPAD(T.CMDT_HDR_SEQ, 5, '0') || '|' || LPAD(T.ROUT_SEQ, 5, '0') || '|' || '00001' AS ROUT_ROWKEY" ).append("\n"); 
		query.append("                             FROM PRI_RQ_RT T" ).append("\n"); 
		query.append("                            WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                           AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                            GROUP BY T.QTTN_NO, T.QTTN_VER_NO, T.CMDT_HDR_SEQ, T.ROUT_SEQ) F" ).append("\n"); 
		query.append("                          ,(SELECT CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                             FROM PRI_RQ_RT_CMDT_HDR T" ).append("\n"); 
		query.append("                             WHERE T.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("                                   AND T.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("                                   AND NVL(T.FIC_RT_TP_CD, 'G') = NVL(@[fic_rt_tp_cd], 'G')) G                               " ).append("\n"); 
		query.append("                    WHERE S.ROUT_ROWKEY = A.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = B.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = E.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.ROUT_ROWKEY = F.ROUT_ROWKEY(+)" ).append("\n"); 
		query.append("                      AND S.CMDT_HDR_SEQ = G.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                    ORDER BY S.ROUT_ROWKEY) B ON A.CMDT_ROWKEY = B.CMDT_ROWKEY" ).append("\n"); 
		query.append(" ORDER BY COALESCE(A.CMDT_ROWKEY, B.CMDT_ROWKEY)" ).append("\n"); 

	}
}