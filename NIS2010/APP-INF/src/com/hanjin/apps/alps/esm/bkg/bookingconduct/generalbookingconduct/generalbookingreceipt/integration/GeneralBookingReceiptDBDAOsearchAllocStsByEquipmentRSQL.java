/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchAllocStsByEquipmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.25 
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

public class GeneralBookingReceiptDBDAOsearchAllocStsByEquipmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * equipment의 allocation Status를 조회한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchAllocStsByEquipmentRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOsearchAllocStsByEquipmentRSQL").append("\n"); 
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
		query.append("    SELECT BK.SLAN_CD TRNK_SLAN_CD" ).append("\n"); 
		query.append("         , BK.SKD_DIR_CD TRNK_DIR_CD" ).append("\n"); 
		query.append("         , BK.POR_CD                POR_LOC_CD" ).append("\n"); 
		query.append("         , BK.POR_NOD_CD            POR_NOD_CD " ).append("\n"); 
		query.append("         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD) POR_SCC_CD         " ).append("\n"); 
		query.append("         , BK.POL_CD                POL_LOC_CD" ).append("\n"); 
		query.append("         , BK.POL_NOD_CD            POL_NOD_CD          " ).append("\n"); 
		query.append("         , NVL(VVD.POL_CD,     'X') TS_POL_CD" ).append("\n"); 
		query.append("         , NVL(VVD.POD_CD,     'X') TS_POD_CD" ).append("\n"); 
		query.append("         , NVL(VVD.VSL_CD,     'X') TS_VSL_CD" ).append("\n"); 
		query.append("         , NVL(VVD.SKD_VOY_NO, 'X') TS_SKD_VOY_NO" ).append("\n"); 
		query.append("         , NVL(VVD.SKD_DIR_CD, 'X') TS_SKD_DIR_CD" ).append("\n"); 
		query.append("         , NVL((SELECT VSL_SLAN_CD FROM VSK_VSL_SKD SKD WHERE SKD.VSL_CD = VVD.VSL_CD AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD), 'X') TS_SLAN_CD         " ).append("\n"); 
		query.append("         , BK.POD_CD                POD_LOC_CD" ).append("\n"); 
		query.append("         , BK.POD_NOD_CD            POD_NOD_CD          " ).append("\n"); 
		query.append("         , BK.DEL_CD                DEL_LOC_CD" ).append("\n"); 
		query.append("         , BK.DEL_NOD_CD            DEL_NOD_CD " ).append("\n"); 
		query.append("         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) DEL_SCC_CD" ).append("\n"); 
		query.append("         , BK.OB_SLS_OFC_CD " ).append("\n"); 
		query.append("         , QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK, BKG_VVD VVD, BKG_QUANTITY QTY" ).append("\n"); 
		query.append("     WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = QTY.BKG_NO       " ).append("\n"); 
		query.append("       AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", G_SUM AS (" ).append("\n"); 
		query.append("    SELECT ALOC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , ALOC.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("         , ALOC.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("         , ALOC.ALOC_SVC_CD" ).append("\n"); 
		query.append("         , ALOC.BKG_ALOC_RMK " ).append("\n"); 
		query.append("      FROM BKG, BKG_ALOC_MGMT ALOC" ).append("\n"); 
		query.append("     WHERE DECODE(ALOC.CNTR_TPSZ_CD,'ALL','ALL',BKG.CNTR_TPSZ_CD)    = ALOC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND ALOC.BKG_ALOC_TP_CD = 'E'" ).append("\n"); 
		query.append("       AND ALOC.ALOC_USE_FLG   = 'Y'" ).append("\n"); 
		query.append("       AND BKG.TRNK_SLAN_CD  = NVL(ALOC.TRNK_SLAN_CD,      BKG.TRNK_SLAN_CD)" ).append("\n"); 
		query.append("       AND BKG.TRNK_DIR_CD   = NVL(ALOC.TRNK_DIR_CD,       BKG.TRNK_DIR_CD)" ).append("\n"); 
		query.append("       AND BKG.POR_LOC_CD    = NVL(ALOC.POR_CD,            BKG.POR_LOC_CD)" ).append("\n"); 
		query.append("       AND BKG.POR_NOD_CD    = NVL(ALOC.POR_NOD_CD,        BKG.POR_NOD_CD)" ).append("\n"); 
		query.append("       AND BKG.POR_SCC_CD    = NVL(ALOC.BKG_POR_SCC_CD,    BKG.POR_SCC_CD)" ).append("\n"); 
		query.append("       AND BKG.POL_LOC_CD    = NVL(ALOC.POL_CD,            BKG.POL_LOC_CD)" ).append("\n"); 
		query.append("       AND BKG.POL_NOD_CD    = NVL(ALOC.POL_NOD_CD,        BKG.POL_NOD_CD)" ).append("\n"); 
		query.append("       AND BKG.TS_POL_CD     = NVL(ALOC.N1ST_TS_POL_CD,    BKG.TS_POL_CD)" ).append("\n"); 
		query.append("       AND BKG.TS_POD_CD     = NVL(ALOC.N1ST_TS_POD_CD,    BKG.TS_POD_CD)" ).append("\n"); 
		query.append("       AND BKG.TS_SLAN_CD    = NVL(ALOC.N1ST_TS_SLAN_CD,   BKG.TS_SLAN_CD)" ).append("\n"); 
		query.append("       AND BKG.POD_LOC_CD    = NVL(ALOC.POD_CD,            BKG.POD_LOC_CD)" ).append("\n"); 
		query.append("       AND BKG.POD_NOD_CD    = NVL(ALOC.POD_NOD_CD,        BKG.POD_NOD_CD)" ).append("\n"); 
		query.append("       AND BKG.DEL_LOC_CD    = NVL(ALOC.DEL_CD,            BKG.DEL_LOC_CD)" ).append("\n"); 
		query.append("       AND BKG.DEL_NOD_CD    = NVL(ALOC.DEL_NOD_CD,        BKG.DEL_NOD_CD)" ).append("\n"); 
		query.append("       AND BKG.DEL_SCC_CD    = NVL(ALOC.BKG_DEL_SCC_CD,    BKG.DEL_SCC_CD)" ).append("\n"); 
		query.append("       AND BKG.OB_SLS_OFC_CD = NVL(ALOC.OB_SLS_OFC_CD,     BKG.OB_SLS_OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND BKG.TS_VSL_CD     = NVL(ALOC.VSL_CD,            BKG.TS_VSL_CD)" ).append("\n"); 
		query.append("       AND BKG.TS_SKD_VOY_NO = NVL(ALOC.SKD_VOY_NO,        BKG.TS_SKD_VOY_NO)" ).append("\n"); 
		query.append("       AND BKG.TS_SKD_DIR_CD = NVL(ALOC.SKD_DIR_CD,        BKG.TS_SKD_DIR_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND SUBSTR(BKG.POR_LOC_CD,1,2) = NVL(ALOC.BKG_POR_CNT_CD, SUBSTR(BKG.POR_LOC_CD,1,2))" ).append("\n"); 
		query.append("       AND SUBSTR(BKG.POL_LOC_CD,1,2) = NVL(ALOC.BKG_POL_CNT_CD, SUBSTR(BKG.POL_LOC_CD,1,2))" ).append("\n"); 
		query.append("       AND SUBSTR(BKG.POD_LOC_CD,1,2) = NVL(ALOC.BKG_POD_CNT_CD, SUBSTR(BKG.POD_LOC_CD,1,2))" ).append("\n"); 
		query.append("       AND SUBSTR(BKG.DEL_LOC_CD,1,2) = NVL(ALOC.BKG_DEL_CNT_CD, SUBSTR(BKG.DEL_LOC_CD,1,2))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 'S' ALOC_STS_CD, BKG_ALOC_TP_CD, ALOC_SVC_CD, BKG_ALOC_RMK" ).append("\n"); 
		query.append("  FROM G_SUM" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}