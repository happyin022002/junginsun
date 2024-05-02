/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchAllocStsByTransshipmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchAllocStsByTransshipmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * jdkjd
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchAllocStsByTransshipmentRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchAllocStsByTransshipmentRSQL").append("\n"); 
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
		query.append("WITH BKG AS (" ).append("\n"); 
		query.append("       SELECT (SELECT INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("               WHERE INTG_CD_ID='CD01233'" ).append("\n"); 
		query.append("                 AND INTG_CD_VAL_CTNT = BV.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("                 AND ROWNUM = 1)||' '||BV.VSL_SEQ VVD_SEQ" ).append("\n"); 
		query.append("              ,BB.SLAN_CD TRUNK_SLAN_CD" ).append("\n"); 
		query.append("              ,BB.SKD_DIR_CD TRUNK_SKD_DIR_CD" ).append("\n"); 
		query.append("              ,BB.POR_CD" ).append("\n"); 
		query.append("              ,POR_SCC.SCC_CD POR_SCC_CD" ).append("\n"); 
		query.append("              ,BB.POR_NOD_CD" ).append("\n"); 
		query.append("              ,BB.POL_CD" ).append("\n"); 
		query.append("              ,BB.POL_NOD_CD" ).append("\n"); 
		query.append("              ,BB.POD_CD" ).append("\n"); 
		query.append("              ,BB.POD_NOD_CD" ).append("\n"); 
		query.append("              ,BB.DEL_CD" ).append("\n"); 
		query.append("              ,DEL_SCC.SCC_CD DEL_SCC_CD" ).append("\n"); 
		query.append("              ,BB.DEL_NOD_CD" ).append("\n"); 
		query.append("              ,BB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("              ,BB.SC_NO" ).append("\n"); 
		query.append("              ,BB.RFA_NO" ).append("\n"); 
		query.append("              ,BB.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,BB.CMDT_CD" ).append("\n"); 
		query.append("              ,BB.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("              ,BB.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("              ,BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("              ,BV.VSL_SEQ" ).append("\n"); 
		query.append("              ,BV.SLAN_CD VVD_SLAN_CD" ).append("\n"); 
		query.append("              ,BV.VSL_CD VVD_VSL_CD" ).append("\n"); 
		query.append("              ,BV.SKD_VOY_NO VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("              ,BV.SKD_DIR_CD VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("              ,BV.POL_CD VVD_POL_CD" ).append("\n"); 
		query.append("              ,BV.POD_CD VVD_POD_CD" ).append("\n"); 
		query.append("              ,BB.BKG_NO" ).append("\n"); 
		query.append("              ,LVL.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("       FROM BKG_VVD BV" ).append("\n"); 
		query.append("           ,BKG_BOOKING BB" ).append("\n"); 
		query.append("           ,BKG_OFC_LVL_V LVL " ).append("\n"); 
		query.append("           ,MDM_LOCATION POR_SCC" ).append("\n"); 
		query.append("           ,MDM_LOCATION DEL_SCC" ).append("\n"); 
		query.append("      WHERE   BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND   BV.VSL_PRE_PST_CD <> 'T'" ).append("\n"); 
		query.append("        AND   BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("        AND   BB.POR_CD = POR_SCC.LOC_CD" ).append("\n"); 
		query.append("        AND   BB.DEL_CD = DEL_SCC.LOC_CD" ).append("\n"); 
		query.append("        AND   BB.OB_SLS_OFC_CD = LVL.OFC_CD" ).append("\n"); 
		query.append("), ALOC AS (" ).append("\n"); 
		query.append("     SELECT BKG.VVD_SEQ" ).append("\n"); 
		query.append("            ,BKG.VVD_VSL_CD||BKG.VVD_SKD_VOY_NO||BKG.VVD_SKD_DIR_CD VVD" ).append("\n"); 
		query.append("            ,BKG.VVD_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("            ,BKG.OFC_N3RD_LVL_CD L_RHQ" ).append("\n"); 
		query.append("            ,BAM.ALOC_LOD_QTY" ).append("\n"); 
		query.append("            ,NVL(BAM.ALOC_LOD_QTY_RTO,100) ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("            ,BAM.BKG_ALOC_RMK OTHER_REMARK" ).append("\n"); 
		query.append("            ,(SELECT BAMD.BKG_ALOC_SEQ FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND BAMD.LOC_CD = BKG.VVD_POL_CD AND ROWNUM = 1) VVD_POL_CD_SEQ" ).append("\n"); 
		query.append("            ,(SELECT BAMD.BKG_ALOC_SEQ FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND BAMD.LOC_CD = BKG.VVD_POD_CD AND ROWNUM = 1) VVD_POD_CD_SEQ" ).append("\n"); 
		query.append("            ,(SELECT BAMD.BKG_ALOC_SEQ FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND ROWNUM = 1) ALOC_POL_CD_SEQ" ).append("\n"); 
		query.append("            ,(SELECT BAMD.BKG_ALOC_SEQ FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND ROWNUM = 1) ALOC_POD_CD_SEQ" ).append("\n"); 
		query.append("            ,BKG.BKG_NO" ).append("\n"); 
		query.append("            ,BAM.N1ST_TS_POL_CNT_CD" ).append("\n"); 
		query.append("            ,BAM.N1ST_TS_POD_CNT_CD" ).append("\n"); 
		query.append("            ,BAM.N1ST_TS_DIR_CD" ).append("\n"); 
		query.append("            ,BKG.VVD_SLAN_CD" ).append("\n"); 
		query.append("            ,BKG.VVD_VSL_CD" ).append("\n"); 
		query.append("            ,BKG.VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("            ,BKG.VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("            ,BKG.VVD_POL_CD" ).append("\n"); 
		query.append("            ,BKG.VVD_POD_CD " ).append("\n"); 
		query.append("            ,BAM.ALOC_SVC_CD" ).append("\n"); 
		query.append("            ,BAM.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("     FROM BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("          ,BKG" ).append("\n"); 
		query.append("     WHERE  BAM.BKG_ALOC_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("      AND   BAM.N1ST_TS_SLAN_CD(+) = BKG.VVD_SLAN_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.N1ST_TS_POL_CNT_CD(+),SUBSTR(BKG.VVD_POL_CD,1,2)) = SUBSTR(BKG.VVD_POL_CD,1,2)" ).append("\n"); 
		query.append("      AND   NVL(BAM.N1ST_TS_POD_CNT_CD(+),SUBSTR(BKG.VVD_POD_CD,1,2)) = SUBSTR(BKG.VVD_POD_CD,1,2)            " ).append("\n"); 
		query.append("      AND   NVL(BAM.N1ST_TS_DIR_CD(+),BKG.VVD_SKD_DIR_CD) = BKG.VVD_SKD_DIR_CD           " ).append("\n"); 
		query.append("      AND   NVL(BAM.POD_CD(+),BKG.POD_CD) = BKG.POD_CD         " ).append("\n"); 
		query.append("      AND   NVL(BAM.N1ST_TS_SLAN_CD(+),BKG.VVD_SLAN_CD) = BKG.VVD_SLAN_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.TRNK_SLAN_CD(+),BKG.TRUNK_SLAN_CD) = BKG.TRUNK_SLAN_CD      -- T.LANE" ).append("\n"); 
		query.append("      AND   NVL(BAM.TRNK_DIR_CD(+),BKG.TRUNK_SKD_DIR_CD) = BKG.TRUNK_SKD_DIR_CD -- BD" ).append("\n"); 
		query.append("      AND   NVL(BAM.POR_CD(+),BKG.POR_CD) = BKG.POR_CD         " ).append("\n"); 
		query.append("      AND   NVL(BAM.POR_NOD_CD(+),BKG.POR_NOD_CD) = BKG.POR_NOD_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.BKG_POR_SCC_CD(+),BKG.POR_SCC_CD) = BKG.POR_SCC_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.POL_CD(+),BKG.POL_CD) = BKG.POL_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.POD_CD(+),BKG.POD_CD) = BKG.POD_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.POD_NOD_CD(+),BKG.POD_NOD_CD) = BKG.POD_NOD_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.DEL_CD(+),BKG.DEL_CD) = BKG.DEL_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.DEL_NOD_CD(+),BKG.DEL_NOD_CD) = BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.BKG_DEL_SCC_CD(+),BKG.DEL_SCC_CD) = BKG.DEL_SCC_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.OB_SLS_OFC_CD(+),BKG.OB_SLS_OFC_CD) = BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.VSL_CD(+),BKG.VVD_VSL_CD) = BKG.VVD_VSL_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.SKD_VOY_NO(+),BKG.VVD_SKD_VOY_NO) = BKG.VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("      AND   NVL(BAM.SKD_DIR_CD(+),BKG.VVD_SKD_DIR_CD) = BKG.VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("      AND   NVL(BAM.BKG_POR_CNT_CD(+),SUBSTR(BKG.POR_CD,1,2)) = SUBSTR(BKG.POR_CD,1,2)" ).append("\n"); 
		query.append("      AND   NVL(BAM.BKG_POL_CNT_CD(+),SUBSTR(BKG.POL_CD,1,2)) = SUBSTR(BKG.POL_CD,1,2)" ).append("\n"); 
		query.append("      AND   NVL(BAM.BKG_POD_CNT_CD(+),SUBSTR(BKG.POD_CD,1,2)) = SUBSTR(BKG.POD_CD,1,2)" ).append("\n"); 
		query.append("      AND   NVL(BAM.BKG_DEL_CNT_CD(+),SUBSTR(BKG.DEL_CD,1,2)) = SUBSTR(BKG.DEL_CD,1,2) " ).append("\n"); 
		query.append("), G_SUM AS (" ).append("\n"); 
		query.append("SELECT TS.VVD_SEQ      " ).append("\n"); 
		query.append("     , TS.VVD          " ).append("\n"); 
		query.append("     , TS.SLAN_CD      " ).append("\n"); 
		query.append("     , TS.L_RHQ        " ).append("\n"); 
		query.append("     , TS.ALOC_LOD_QTY " ).append("\n"); 
		query.append("     , TS.TEU_TTL  " ).append("\n"); 
		query.append("     , TS.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("     , CASE WHEN TS.ALOC_LOD_QTY = 0 THEN 0 " ).append("\n"); 
		query.append("            ELSE ROUND(TS.TEU_TTL / TS.ALOC_LOD_QTY * 100,1) " ).append("\n"); 
		query.append("            END TS_RATIO" ).append("\n"); 
		query.append("     , TS.OTHER_REMARK BKG_ALOC_RMK" ).append("\n"); 
		query.append("     , TS.ALOC_SVC_CD" ).append("\n"); 
		query.append("     , TS.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT ALOC.*" ).append("\n"); 
		query.append("             ,(SELECT NVL(SUM(DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,-1),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2)),0) BKG_TEU" ).append("\n"); 
		query.append("                 FROM BKG_VVD BV1" ).append("\n"); 
		query.append("                      ,BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                      ,BKG_BOOKING BB1" ).append("\n"); 
		query.append("                WHERE BV1.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("                  AND BV1.BKG_NO = BB1.BKG_NO" ).append("\n"); 
		query.append("                  AND BV1.VSL_PRE_PST_CD <> 'T'" ).append("\n"); 
		query.append("                  AND BB1.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                  AND BB1.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                  AND (NVL(BB1.ALOC_STS_CD,'F') = 'F' OR BB1.BKG_NO = ALOC.BKG_NO)" ).append("\n"); 
		query.append("                  AND BV1.SLAN_CD = ALOC.VVD_SLAN_CD" ).append("\n"); 
		query.append("                  AND BV1.VSL_CD = ALOC.VVD_VSL_CD" ).append("\n"); 
		query.append("                  AND BV1.SKD_VOY_NO = ALOC.VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND BV1.SKD_DIR_CD = ALOC.VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND BV1.SKD_DIR_CD = NVL(ALOC.N1ST_TS_DIR_CD,BV1.SKD_DIR_CD)" ).append("\n"); 
		query.append("                  AND BV1.POL_CD IN (SELECT BAMD.LOC_CD FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = ALOC.VVD_POL_CD_SEQ AND BAMD.LOC_DIV_CD = 'POL' " ).append("\n"); 
		query.append("                                      UNION ALL SELECT BV1.POL_CD FROM DUAL WHERE VVD_POL_CD_SEQ IS NULL AND ALOC_POL_CD_SEQ IS NULL)" ).append("\n"); 
		query.append("                  AND BV1.POD_CD IN (SELECT BAMD.LOC_CD FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = ALOC.VVD_POD_CD_SEQ AND BAMD.LOC_DIV_CD = 'POD'" ).append("\n"); 
		query.append("                                      UNION ALL SELECT BV1.POD_CD FROM DUAL WHERE VVD_POD_CD_SEQ IS NULL AND ALOC_POD_CD_SEQ IS NULL)" ).append("\n"); 
		query.append("                  AND SUBSTR(BV1.POL_CD,1,2) = NVL(ALOC.N1ST_TS_POL_CNT_CD,SUBSTR(BV1.POL_CD,1,2))" ).append("\n"); 
		query.append("                  AND SUBSTR(BV1.POD_CD,1,2) = NVL(ALOC.N1ST_TS_POD_CNT_CD,SUBSTR(BV1.POD_CD,1,2))" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT 'X' FROM BKG_OFC_LVL_V LVL1 WHERE LVL1.OFC_N3RD_LVL_CD = ALOC.L_RHQ AND BB1.OB_SLS_OFC_CD = LVL1.OFC_CD) " ).append("\n"); 
		query.append("              ) TEU_TTL" ).append("\n"); 
		query.append("      FROM ALOC        " ).append("\n"); 
		query.append("      WHERE ALOC.VVD_POL_CD IN " ).append("\n"); 
		query.append("                        (SELECT BAMD.LOC_CD FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = ALOC.VVD_POL_CD_SEQ AND BAMD.LOC_DIV_CD = 'POL' " ).append("\n"); 
		query.append("                         UNION ALL SELECT ALOC.VVD_POL_CD FROM DUAL WHERE VVD_POL_CD_SEQ IS NULL AND ALOC_POL_CD_SEQ IS NULL)" ).append("\n"); 
		query.append("      AND ALOC.VVD_POD_CD IN " ).append("\n"); 
		query.append("                        (SELECT BAMD.LOC_CD FROM BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = ALOC.VVD_POD_CD_SEQ AND BAMD.LOC_DIV_CD = 'POD'" ).append("\n"); 
		query.append("                          UNION ALL SELECT ALOC.VVD_POD_CD FROM DUAL WHERE VVD_POD_CD_SEQ IS NULL AND ALOC_POD_CD_SEQ IS NULL)" ).append("\n"); 
		query.append(") TS " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT 'S' ALOC_STS_CD,BKG_ALOC_TP_CD,ALOC_SVC_CD,BKG_ALOC_RMK" ).append("\n"); 
		query.append("FROM G_SUM      " ).append("\n"); 
		query.append("WHERE  TS_RATIO > ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("AND ROWNUM = 1                  " ).append("\n"); 

	}
}