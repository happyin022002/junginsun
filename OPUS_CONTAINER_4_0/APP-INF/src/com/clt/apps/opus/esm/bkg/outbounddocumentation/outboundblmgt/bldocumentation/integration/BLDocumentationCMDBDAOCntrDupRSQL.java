/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCntrDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrDupRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_NL(A B) */" ).append("\n"); 
		query.append("       B.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    B.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("AND    B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD = @[t_vvd]" ).append("\n"); 
		query.append("AND    B.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append("AND    (B.BKG_STS_CD = 'W' OR B.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("AND    A.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("AND NOT EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("				 FROM BKG_BOOKING BK, BKG_CONTAINER BC" ).append("\n"); 
		query.append("				 WHERE BK.FM_BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				   AND BK.BL_NO_TP = '9'" ).append("\n"); 
		query.append("				   AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("				   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND BC.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("AND NOT EXISTS ( SELECT /*+ ORDERED USE_NL(BC BK) */ " ).append("\n"); 
		query.append("                       'X'" ).append("\n"); 
		query.append("                 FROM BKG_CONTAINER BC, BKG_BOOKING BK" ).append("\n"); 
		query.append("                 WHERE 1=1                                    " ).append("\n"); 
		query.append("                   AND BC.CNTR_PRT_FLG ='Y'" ).append("\n"); 
		query.append("                   AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND BK.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND BK.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND BK.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND BC.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("				   AND ROWNUM = 1 " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("AND " ).append("\n"); 
		query.append("(CASE WHEN (SELECT HRD.ATTR_CTNT5  " ).append("\n"); 
		query.append("            FROM   BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND HRD.HRD_CDG_ID ='OSCAR_MVMT_CHK'" ).append("\n"); 
		query.append("            ) = 'N' THEN 'Y'" ).append("\n"); 
		query.append("    ELSE " ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("(SELECT 'Y' FROM " ).append("\n"); 
		query.append("(SELECT /*+ ORDERED USE_NL(BK VVD1 VVD2 SKD1 SKD2 CNTR) */" ).append("\n"); 
		query.append("                                SKD1.VPS_PORT_CD POL_PORT," ).append("\n"); 
		query.append("                                SKD2.VPS_PORT_CD POD_PORT," ).append("\n"); 
		query.append("                                ROW_NUMBER() OVER( ORDER BY VVD1.VSL_PRE_PST_CD, VVD1.VSL_SEQ, SKD1.CLPT_SEQ) ROW_SEQ" ).append("\n"); 
		query.append("                                ,SKD1.CLPT_SEQ AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("                                ,SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("                                ,SKD1.VPS_ETD_DT" ).append("\n"); 
		query.append("                                ,SKD2.VPS_ETA_DT" ).append("\n"); 
		query.append("                         FROM                               " ).append("\n"); 
		query.append("                              BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("                              BKG_BOOKING BK," ).append("\n"); 
		query.append("                              BKG_VVD VVD1, " ).append("\n"); 
		query.append("                              BKG_VVD VVD2," ).append("\n"); 
		query.append("                              VSK_VSL_PORT_SKD SKD1," ).append("\n"); 
		query.append("                              VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND CNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                        AND CNTR.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("                        AND BK.VSL_CD = SUBSTR(@[t_vvd], 1, 4)" ).append("\n"); 
		query.append("                        AND BK.SKD_VOY_NO = SUBSTR(@[t_vvd], 5, 4)" ).append("\n"); 
		query.append("                        AND BK.SKD_DIR_CD = SUBSTR(@[t_vvd], 9, 1)" ).append("\n"); 
		query.append("                        AND BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("                        AND BK.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("                        AND BK.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("                        AND BK.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("                        AND VVD1.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD1.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD1.SKD_DIR_CD = BK.SKD_DIR_CD                        " ).append("\n"); 
		query.append("                        AND VVD2.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD2.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD2.SKD_DIR_CD = BK.SKD_DIR_CD                        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND VVD1.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD1.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD1.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND VVD1.POL_CD = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND VVD1.POL_CLPT_IND_SEQ  = SKD1.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                        AND VVD2.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD2.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD2.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND VVD2.POD_CD = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND VVD2.POD_CLPT_IND_SEQ  = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        AND NVL(SKD1.SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("                        AND NVL(SKD2.SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("                        ) A," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                         SELECT /*+ ORDERED USE_NL(BK VVD1 VVD2 SKD1 SKD2) */" ).append("\n"); 
		query.append("                                SKD1.VPS_PORT_CD POL_PORT," ).append("\n"); 
		query.append("                                SKD2.VPS_PORT_CD POD_PORT," ).append("\n"); 
		query.append("                                ROW_NUMBER() OVER( ORDER BY VVD1.VSL_PRE_PST_CD, VVD1.VSL_SEQ, SKD1.CLPT_SEQ) ROW_SEQ" ).append("\n"); 
		query.append("                                ,SKD1.CLPT_SEQ AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("                                ,SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("                                ,SKD1.VPS_ETD_DT" ).append("\n"); 
		query.append("                                ,SKD2.VPS_ETA_DT" ).append("\n"); 
		query.append("                         FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("                              BKG_VVD VVD1, " ).append("\n"); 
		query.append("                              BKG_VVD VVD2," ).append("\n"); 
		query.append("                              VSK_VSL_PORT_SKD SKD1," ).append("\n"); 
		query.append("                              VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND BK.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("                        AND BK.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("                        AND VVD1.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD1.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD1.SKD_DIR_CD = BK.SKD_DIR_CD                        " ).append("\n"); 
		query.append("                        AND VVD2.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD2.SKD_VOY_NO = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD2.SKD_DIR_CD = BK.SKD_DIR_CD                        " ).append("\n"); 
		query.append("                        AND VVD1.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD1.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD1.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND VVD1.POL_CD = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND VVD1.POL_CLPT_IND_SEQ  = SKD1.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                        AND VVD2.VSL_CD = SKD2.VSL_CD" ).append("\n"); 
		query.append("                        AND VVD2.SKD_VOY_NO = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND VVD2.SKD_DIR_CD = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND VVD2.POD_CD = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("                        AND VVD2.POD_CLPT_IND_SEQ  = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                        AND NVL(SKD1.SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("                        AND NVL(SKD2.SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("                        WHERE A.POL_CLPT_SEQ < B.POD_CLPT_SEQ" ).append("\n"); 
		query.append("                          AND A.POD_CLPT_SEQ > B.POL_CLPT_SEQ" ).append("\n"); 
		query.append("                          AND ROWNUM =1" ).append("\n"); 
		query.append("                          ) , 'N')" ).append("\n"); 
		query.append("END ) = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_NL(HRD A B) */" ).append("\n"); 
		query.append("       B.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_HRD_CDG_CTNT HRD, CTM_BKG_CNTR A, CTM_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    A.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("AND    B.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CNMV_CYC_NO IS NOT NULL" ).append("\n"); 
		query.append("AND    B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND    (B.BKG_STS_CD = 'W' OR B.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("AND    A.CNMV_STS_CD NOT IN ('ID','MT')" ).append("\n"); 
		query.append("AND    HRD.HRD_CDG_ID ='OSCAR_MVMT_CHK'" ).append("\n"); 
		query.append("AND     HRD.ATTR_CTNT1 = 'Y'" ).append("\n"); 
		query.append("AND    COALESCE((SELECT  /*+ INDEX_DESC(VPS XAK11VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                    VPS.VPS_ETA_DT " ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("             WHERE B.VSL_CD       = VPS.VSL_CD" ).append("\n"); 
		query.append("               AND B.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND B.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND B.POD_CD       = VPS.VPS_PORT_CD " ).append("\n"); 
		query.append("               AND ROWNUM = 1) , B.VPS_ETD_DT + NVL(( SELECT ROUND(MAX(PR.TZTM_HRS)/24, 5)" ).append("\n"); 
		query.append("                                                        FROM PRD_OCN_ROUT PR" ).append("\n"); 
		query.append("                                                       WHERE B.POL_CD       = PR.ORG_LOC_CD" ).append("\n"); 
		query.append("                                                         AND B.POD_CD       = PR.DEST_LOC_CD" ).append("\n"); 
		query.append("                                                         AND PR.UPD_IND_CD != 'D' ), 80)" ).append("\n"); 
		query.append("               , SYSDATE ) > SYSDATE - 60" ).append("\n"); 
		query.append("AND   (SELECT CASE WHEN SIGN(MC.CNMV_CYC_NO - A.CNMV_CYC_NO) IN (-1, 0) THEN 'CHK'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                       DECODE(MC.CNMV_CYC_NO - A.CNMV_CYC_NO, 1, 'CHK', 2, 'CHK', 'NOT')" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("         FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("          AND ROWNUM  = 1) = 'CHK'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'Y' FROM BKG_CONTAINER BCNTR, BKG_BOOKING BK" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND BCNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND BCNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                  AND BCNTR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                  AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND ROWNUM =1 " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'Y' " ).append("\n"); 
		query.append("                FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND BK.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                  AND BK.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND BK.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ) " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_NL(HRD A B) */" ).append("\n"); 
		query.append("       B.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_HRD_CDG_CTNT HRD, CTM_BKG_CNTR A, CTM_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    A.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("AND    B.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CNMV_CYC_NO IN ('9999','9998')" ).append("\n"); 
		query.append("AND    B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND    (B.BKG_STS_CD = 'W' OR B.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("AND HRD.HRD_CDG_ID ='OSCAR_MVMT_CHK'" ).append("\n"); 
		query.append("AND HRD.ATTR_CTNT2 = 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_NL(HRD A B) */" ).append("\n"); 
		query.append("       B.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_HRD_CDG_CTNT HRD, CTM_BKG_CNTR A, CTM_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    A.CRE_DT >= (SYSDATE - 90) /* 오래된 bkg_no과 연결된 cntr_no는 해당 없음 */" ).append("\n"); 
		query.append("AND    B.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("AND    B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND    (B.BKG_STS_CD = 'W' OR B.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("AND    A.CNMV_CYC_NO IS NOT NULL" ).append("\n"); 
		query.append("AND    A.CNMV_STS_CD NOT IN ('ID','MT')" ).append("\n"); 
		query.append("AND    COALESCE((SELECT  /*+ INDEX_DESC(VPS XAK11VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                    VPS.VPS_ETA_DT " ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("             WHERE B.VSL_CD       = VPS.VSL_CD" ).append("\n"); 
		query.append("               AND B.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND B.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND B.POD_CD       = VPS.VPS_PORT_CD " ).append("\n"); 
		query.append("               AND ROWNUM = 1) , B.VPS_ETD_DT + NVL(( SELECT ROUND(MAX(PR.TZTM_HRS)/24, 5)" ).append("\n"); 
		query.append("                                                        FROM PRD_OCN_ROUT PR" ).append("\n"); 
		query.append("                                                       WHERE B.POL_CD       = PR.ORG_LOC_CD" ).append("\n"); 
		query.append("                                                         AND B.POD_CD       = PR.DEST_LOC_CD" ).append("\n"); 
		query.append("                                                         AND PR.UPD_IND_CD != 'D' ), 80)" ).append("\n"); 
		query.append("               , SYSDATE ) > SYSDATE - 60" ).append("\n"); 
		query.append("AND   (SELECT CASE WHEN SIGN(MC.CNMV_CYC_NO - A.CNMV_CYC_NO) IN (-1, 0) THEN 'CHK'" ).append("\n"); 
		query.append("                   ELSE" ).append("\n"); 
		query.append("                       DECODE(MC.CNMV_CYC_NO - A.CNMV_CYC_NO, 1, 'CHK', 2, 'CHK', 'NOT')" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("         FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("          AND ROWNUM  = 1) = 'CHK'" ).append("\n"); 
		query.append("AND    EXISTS (SELECT 'Y' FROM COM_SYS_AREA_GRP_ID A1, BKG_BOOKING A2, MST_CONTAINER MST" ).append("\n"); 
		query.append("               WHERE  A2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND  A2.POL_CD LIKE A1.CNT_CD || '%'" ).append("\n"); 
		query.append("                 AND  A1.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                 AND  A1.SVR_USD_FLG = 'Y'" ).append("\n"); 
		query.append("                 AND  A1.SYS_AREA_GRP_ID <> MST.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                 AND  MST.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                 AND  A2.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                 AND  (A2.BKG_STS_CD = 'W' OR A2.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("				 AND  MST.BKG_NO <> A2.BKG_NO" ).append("\n"); 
		query.append("				 AND  MST.CNMV_STS_CD IN ('OP','OC')" ).append("\n"); 
		query.append("                 AND  ROWNUM =1 )" ).append("\n"); 
		query.append("AND HRD.HRD_CDG_ID ='OSCAR_MVMT_CHK'" ).append("\n"); 
		query.append("AND HRD.ATTR_CTNT3 = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_NL(HRD A) */" ).append("\n"); 
		query.append("       A.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_HRD_CDG_CTNT HRD, CTM_MOVEMENT A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND    A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    A.MVMT_STS_CD IN ('ID','MT')" ).append("\n"); 
		query.append("AND    EXISTS (SELECT COUNT(1) FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("               WHERE CTM.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("               AND   ROWNUM <= 2  -- 2개까지만 count하면 원하는 결과를 알수 있음." ).append("\n"); 
		query.append("               HAVING COUNT(1) = 1" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("AND    EXISTS (SELECT 'Y' FROM COM_SYS_AREA_GRP_ID A1, BKG_BOOKING A2, MST_CONTAINER MST" ).append("\n"); 
		query.append("               WHERE  A2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND  A2.POL_CD LIKE A1.CNT_CD || '%'" ).append("\n"); 
		query.append("                 AND  A1.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                 AND  A1.SVR_USD_FLG = 'Y'" ).append("\n"); 
		query.append("                 AND  A1.SYS_AREA_GRP_ID <> MST.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                 AND  MST.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                 AND  A2.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                 AND  (A2.BKG_STS_CD = 'W' OR A2.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("				 AND  MST.BKG_NO <> A2.BKG_NO" ).append("\n"); 
		query.append("				 AND  MST.CNMV_STS_CD IN ('OP','OC')" ).append("\n"); 
		query.append("                 AND  ROWNUM =1 )" ).append("\n"); 
		query.append("AND HRD.HRD_CDG_ID ='OSCAR_MVMT_CHK'" ).append("\n"); 
		query.append("AND HRD.ATTR_CTNT4 = 'Y'" ).append("\n"); 
		query.append("AND ROWNUM =1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}