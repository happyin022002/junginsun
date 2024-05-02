/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchAlocStandbyReasonTruckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchAlocStandbyReasonTruckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation Stand by Reason 의 Truck VVD BKG Status vs. Allocation 을 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchAlocStandbyReasonTruckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchAlocStandbyReasonTruckRSQL").append("\n"); 
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
		query.append("WITH BKG AS ( " ).append("\n"); 
		query.append("    SELECT BB.BKG_NO" ).append("\n"); 
		query.append("           ,NVL(BAM.BKG_ALOC_SEQ,0) BKG_ALOC_SEQ" ).append("\n"); 
		query.append("           ,LVL.OFC_N3RD_LVL_CD, LVL.GSO, BB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("           ,BB.SLAN_CD, BB.VSL_CD, BB.SKD_VOY_NO, BB.SKD_DIR_CD" ).append("\n"); 
		query.append("           ,BV.POL_CD T_POL_CD, BV.POD_CD T_POD_CD" ).append("\n"); 
		query.append("           ,BAM.ALOC_SVC_CD" ).append("\n"); 
		query.append("           ,(SELECT BAMD.BKG_ALOC_SEQ FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPL' AND BAMD.SB_LOC_CD = BV.POL_CD AND ROWNUM = 1) T_POL_ALOC_SEQ" ).append("\n"); 
		query.append("           ,(SELECT BAMD.BKG_ALOC_SEQ FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPD' AND BAMD.SB_LOC_CD = BV.POD_CD AND ROWNUM = 1) T_POD_ALOC_SEQ           " ).append("\n"); 
		query.append("           ,BAM.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("           ,(SELECT CICD.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL CICD " ).append("\n"); 
		query.append("             WHERE CICD.INTG_CD_ID = 'CD03267' " ).append("\n"); 
		query.append("               AND CICD.INTG_CD_VAL_CTNT = 'T') ITEM" ).append("\n"); 
		query.append("    FROM SPC_BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("         ,BKG_BOOKING BB" ).append("\n"); 
		query.append("         ,BKG_VVD BV" ).append("\n"); 
		query.append("         ,BKG_OFC_LVL_V LVL " ).append("\n"); 
		query.append("    WHERE BAM.BKG_ALOC_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("    AND BAM.TRNK_SLAN_CD(+) = BB.SLAN_CD" ).append("\n"); 
		query.append("    AND NVL(BAM.TRNK_DIR_CD(+),BB.SKD_DIR_CD) =  BB.SKD_DIR_CD " ).append("\n"); 
		query.append("    AND NVL(BAM.VSL_CD(+),BB.VSL_CD) = BB.VSL_CD" ).append("\n"); 
		query.append("    AND NVL(BAM.SKD_VOY_NO(+),BB.SKD_VOY_NO) = BB.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND NVL(BAM.SKD_DIR_CD(+),BB.SKD_DIR_CD) = BB.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND BB.OB_SLS_OFC_CD = LVL.OFC_CD" ).append("\n"); 
		query.append("    AND BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("    AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND BAM.SLS_RHQ_CD(+) = 'NYCRA'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(", ALOC AS (" ).append("\n"); 
		query.append("    SELECT BKG.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("           ,SUM(ASGN_TTL_QTY)     AS L_RHQ_ALLOC" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BKG.GSO = A.SLS_OFC_CD THEN ASGN_TTL_QTY ELSE 0 END) AS L_OFC_ALLOC" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                     THEN ASGN_TTL_QTY ELSE 0 END)     AS L_RHQ_ALLOC_POL" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BKG.GSO = A.SLS_OFC_CD " ).append("\n"); 
		query.append("                     AND  SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                     THEN ASGN_TTL_QTY ELSE 0 END) AS L_OFC_ALLOC_POL" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                     THEN ASGN_TTL_QTY ELSE 0 END)     AS L_RHQ_ALLOC_POD" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BKG.GSO = A.SLS_OFC_CD " ).append("\n"); 
		query.append("                     AND  SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                     THEN ASGN_TTL_QTY ELSE 0 END) AS L_OFC_ALLOC_POD  " ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                          AND SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                     THEN ASGN_TTL_QTY ELSE 0 END)     AS L_RHQ_ALLOC_POL_POD" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BKG.GSO = A.SLS_OFC_CD " ).append("\n"); 
		query.append("                     AND  SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                          AND SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                                      AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                                      ) " ).append("\n"); 
		query.append("                     THEN ASGN_TTL_QTY ELSE 0 END) AS L_OFC_ALLOC_POL_POD                                                                                 " ).append("\n"); 
		query.append("      FROM BKG," ).append("\n"); 
		query.append("           SPC_ALOC_POL_POD  A," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD  PD," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD  PL" ).append("\n"); 
		query.append("     WHERE A.RLANE_CD    LIKE BKG.SLAN_CD||'%'     " ).append("\n"); 
		query.append("       AND A.IOC_CD      = 'O'   -- 변동없음" ).append("\n"); 
		query.append("       AND A.DIR_CD      = BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD      = BKG.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO  = BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD  = BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.SLS_RHQ_CD  = BKG.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD      = PL.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO  = PL.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD  = PL.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.POL_YD_CD   = PL.YD_CD" ).append("\n"); 
		query.append("       AND A.POL_IND_SEQ = PL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND NVL(PL.SKD_CNG_STS_CD,'N') != 'S'  " ).append("\n"); 
		query.append("       AND A.VSL_CD      = PD.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO  = PD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD  = PD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.POD_YD_CD   = PD.YD_CD" ).append("\n"); 
		query.append("       AND A.POD_IND_SEQ = PD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND NVL(PD.SKD_CNG_STS_CD,'N') != 'S' " ).append("\n"); 
		query.append("     GROUP BY BKG.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("     )    " ).append("\n"); 
		query.append(", BKG_TEU AS (" ).append("\n"); 
		query.append("     SELECT BKG.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("            ,NVL(SUM(DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2)),0) BKG_LRHQ_VOL" ).append("\n"); 
		query.append("            ,SUM(CASE WHEN BKG.GSO = LVL1.GSO THEN DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END) BKG_LOFC_VOL" ).append("\n"); 
		query.append("            ,SUM(CASE WHEN BV.POL_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     THEN DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END)     AS BKG_LRHQ_VOL_POL" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BKG.GSO = LVL1.GSO " ).append("\n"); 
		query.append("                     AND  BV.POL_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     THEN DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END) AS BKG_LOFC_VOL_POL" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BV.POD_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     THEN DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END)     AS BKG_LRHQ_VOL_POD" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BKG.GSO = LVL1.GSO " ).append("\n"); 
		query.append("                     AND  BV.POD_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     THEN DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END) AS BKG_LOFC_VOL_POD  " ).append("\n"); 
		query.append("                      ,SUM(CASE WHEN BV.POL_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     AND BV.POD_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     THEN DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END)     AS BKG_LRHQ_VOL_POL_POD" ).append("\n"); 
		query.append("           ,SUM(CASE WHEN BKG.GSO = LVL1.GSO " ).append("\n"); 
		query.append("                     AND  BV.POL_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     AND  BV.POD_CD IN (SELECT BAMD.SB_LOC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD" ).append("\n"); 
		query.append("                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ" ).append("\n"); 
		query.append("                                          AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'" ).append("\n"); 
		query.append("                                          ) " ).append("\n"); 
		query.append("                     THEN DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END) AS BKG_LOFC_VOL_POL_POD " ).append("\n"); 
		query.append("       FROM BKG" ).append("\n"); 
		query.append("            ,BKG_BOOKING BB1" ).append("\n"); 
		query.append("            ,BKG_VVD BV" ).append("\n"); 
		query.append("            ,BKG_QUANTITY BQ" ).append("\n"); 
		query.append("            ,BKG_OFC_LVL_V LVL1" ).append("\n"); 
		query.append("       WHERE BB1.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("       AND   BB1.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("       AND   BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("       AND   BB1.VSL_CD = BKG.VSL_CD" ).append("\n"); 
		query.append("       AND   BB1.SKD_VOY_NO = BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND   BB1.SKD_DIR_CD = BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND   BB1.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("       AND   BB1.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("       AND   (NVL(BB1.ALOC_STS_CD,'F') = 'F' OR BB1.BKG_NO = BKG.BKG_NO)" ).append("\n"); 
		query.append("       AND   BB1.OB_SLS_OFC_CD = LVL1.OFC_CD" ).append("\n"); 
		query.append("       AND   LVL1.OFC_N3RD_LVL_CD = BKG.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("       GROUP BY BKG.BKG_ALOC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT ITEM" ).append("\n"); 
		query.append("     , BKG.SLAN_CD TRNK_SLAN_CD" ).append("\n"); 
		query.append("     , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , BKG.OFC_N3RD_LVL_CD L_RHQ" ).append("\n"); 
		query.append("     , BKG.GSO OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , 'ALL' TYPE" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LOFC_VOL BKG_LOFC_VOL" ).append("\n"); 
		query.append("     , ALOC.L_OFC_ALLOC L_OFC_ALLOC" ).append("\n"); 
		query.append("     , BKG.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("     , BKG.ALOC_SVC_CD" ).append("\n"); 
		query.append("     , ALOC.L_RHQ_ALLOC" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LRHQ_VOL" ).append("\n"); 
		query.append("     , CASE WHEN L_OFC_ALLOC = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LOFC_VOL/L_OFC_ALLOC*100,1) " ).append("\n"); 
		query.append("            END OFC_RATIO" ).append("\n"); 
		query.append("     , CASE WHEN L_RHQ_ALLOC = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LRHQ_VOL/L_RHQ_ALLOC*100,1) " ).append("\n"); 
		query.append("            END RHQ_RATIO" ).append("\n"); 
		query.append("     ,'' OTHER_REMARK" ).append("\n"); 
		query.append("FROM BKG, ALOC, BKG_TEU" ).append("\n"); 
		query.append("WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ(+)" ).append("\n"); 
		query.append("AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POL_ALOC_SEQ,0) = 0" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POD_ALOC_SEQ,0) = 0" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ITEM" ).append("\n"); 
		query.append("     , BKG.SLAN_CD TRNK_SLAN_CD" ).append("\n"); 
		query.append("     , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , BKG.OFC_N3RD_LVL_CD L_RHQ" ).append("\n"); 
		query.append("     , BKG.GSO OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , 'Multi POL' TRUNK_TP" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LOFC_VOL_POL" ).append("\n"); 
		query.append("     , ALOC.L_OFC_ALLOC_POL" ).append("\n"); 
		query.append("     , BKG.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("     , BKG.ALOC_SVC_CD" ).append("\n"); 
		query.append("     , ALOC.L_RHQ_ALLOC_POL" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LRHQ_VOL_POL" ).append("\n"); 
		query.append("     , CASE WHEN L_OFC_ALLOC_POL = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LOFC_VOL_POL/L_OFC_ALLOC_POL*100,1) " ).append("\n"); 
		query.append("            END OFC_RATIO" ).append("\n"); 
		query.append("     , CASE WHEN L_RHQ_ALLOC_POL = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LRHQ_VOL_POL/L_RHQ_ALLOC_POL*100,1) " ).append("\n"); 
		query.append("            END RHQ_RATIO" ).append("\n"); 
		query.append("     ,(SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPL' ) OTHER_REMARK --POL->TPL" ).append("\n"); 
		query.append("FROM BKG, ALOC, BKG_TEU" ).append("\n"); 
		query.append("WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POL_ALOC_SEQ,0) <> 0" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POD_ALOC_SEQ,0) = 0" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ITEM" ).append("\n"); 
		query.append("     , BKG.SLAN_CD TRNK_SLAN_CD" ).append("\n"); 
		query.append("     , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , BKG.OFC_N3RD_LVL_CD L_RHQ" ).append("\n"); 
		query.append("     , BKG.GSO OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , 'Multi POD' TRUNK_TP" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LOFC_VOL_POD" ).append("\n"); 
		query.append("     , ALOC.L_OFC_ALLOC_POD" ).append("\n"); 
		query.append("     , BKG.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("     , BKG.ALOC_SVC_CD" ).append("\n"); 
		query.append("     , ALOC.L_RHQ_ALLOC_POD" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LRHQ_VOL_POD" ).append("\n"); 
		query.append("     , CASE WHEN L_OFC_ALLOC_POD = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LOFC_VOL_POD/L_OFC_ALLOC_POD*100,1) " ).append("\n"); 
		query.append("            END OFC_RATIO" ).append("\n"); 
		query.append("     , CASE WHEN L_RHQ_ALLOC_POD = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LRHQ_VOL_POD/L_RHQ_ALLOC_POD*100,1) " ).append("\n"); 
		query.append("            END RHQ_RATIO" ).append("\n"); 
		query.append("     ,(SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPD' ) OTHER_REMARK --POD->TPD" ).append("\n"); 
		query.append("FROM BKG, ALOC, BKG_TEU" ).append("\n"); 
		query.append("WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POL_ALOC_SEQ,0) = 0" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POD_ALOC_SEQ,0) <> 0" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ITEM" ).append("\n"); 
		query.append("     , BKG.SLAN_CD TRNK_SLAN_CD" ).append("\n"); 
		query.append("     , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , BKG.OFC_N3RD_LVL_CD L_RHQ" ).append("\n"); 
		query.append("     , BKG.GSO OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , 'Multi POL/POD' TRUNK_TP" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LOFC_VOL_POL_POD" ).append("\n"); 
		query.append("     , ALOC.L_OFC_ALLOC_POL_POD" ).append("\n"); 
		query.append("     , BKG.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("     , BKG.ALOC_SVC_CD" ).append("\n"); 
		query.append("     , ALOC.L_RHQ_ALLOC_POL_POD" ).append("\n"); 
		query.append("     , BKG_TEU.BKG_LRHQ_VOL_POL_POD" ).append("\n"); 
		query.append("     , CASE WHEN L_OFC_ALLOC_POL_POD = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LOFC_VOL_POL_POD/L_OFC_ALLOC_POL_POD*100,1) " ).append("\n"); 
		query.append("            END OFC_RATIO" ).append("\n"); 
		query.append("     , CASE WHEN L_RHQ_ALLOC_POL_POD = 0 THEN 0" ).append("\n"); 
		query.append("            ELSE ROUND(BKG_LRHQ_VOL_POL_POD/L_RHQ_ALLOC_POL_POD*100,1) " ).append("\n"); 
		query.append("            END RHQ_RATIO" ).append("\n"); 
		query.append("     ,(SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPL' )||" ).append("\n"); 
		query.append("      chr(13)||chr(10)||' / '||(SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPD' )  OTHER_REMARK  --POL->TPL, POD->TPD" ).append("\n"); 
		query.append("FROM BKG, ALOC, BKG_TEU" ).append("\n"); 
		query.append("WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POL_ALOC_SEQ,0) <> 0" ).append("\n"); 
		query.append("AND   NVL(BKG.T_POD_ALOC_SEQ,0) <> 0" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}