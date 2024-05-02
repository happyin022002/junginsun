/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBkgInfoForHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBkgInfoForHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchBkgInfoForHistRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBkgInfoForHistRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBkgInfoForHistRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("        , BK.BL_NO||BK.BL_TP_CD BL_NO" ).append("\n"); 
		query.append("        , TO_CHAR(BK.PORT_CLZ_DT, 'YYYY-MM-DD') PORT_CLOSING" ).append("\n"); 
		query.append("        , TO_CHAR(BL.BDR_DT, 'YYYY-MM-DD') BDR_DT" ).append("\n"); 
		query.append("        , N1ST_VVD.VSL_CD||N1ST_VVD.SKD_VOY_NO||N1ST_VVD.SKD_DIR_CD N1ST_VVD" ).append("\n"); 
		query.append("        , N1ST_VVD.POL_CD N1ST_POL" ).append("\n"); 
		query.append("        , (SELECT TO_CHAR(SKD.VPS_ETB_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("             FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("            WHERE SKD.VSL_CD      = DECODE(N1ST_VVD.VSL_CD, 'COXX', 'X', 'COYY', 'X', 'COZZ', 'X', N1ST_VVD.VSL_CD)" ).append("\n"); 
		query.append("              AND SKD.SKD_VOY_NO  = N1ST_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND SKD.SKD_DIR_CD  = N1ST_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND SKD.VPS_PORT_CD = N1ST_VVD.POL_CD" ).append("\n"); 
		query.append("              AND SKD.CLPT_IND_SEQ= N1ST_VVD.POL_CLPT_IND_SEQ) N1ST_ETB" ).append("\n"); 
		query.append("        , (SELECT TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("             FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("            WHERE SKD.VSL_CD      = DECODE(N1ST_VVD.VSL_CD, 'COXX', 'X', 'COYY', 'X', 'COZZ', 'X', N1ST_VVD.VSL_CD)" ).append("\n"); 
		query.append("              AND SKD.SKD_VOY_NO  = N1ST_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND SKD.SKD_DIR_CD  = N1ST_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND SKD.VPS_PORT_CD = N1ST_VVD.POL_CD" ).append("\n"); 
		query.append("              AND SKD.CLPT_IND_SEQ= N1ST_VVD.POL_CLPT_IND_SEQ) N1ST_ETD" ).append("\n"); 
		query.append("        , TRNK_VVD.VSL_CD||TRNK_VVD.SKD_VOY_NO||TRNK_VVD.SKD_DIR_CD TRNK_VVD" ).append("\n"); 
		query.append("        , TRNK_VVD.POL_CD TRNK_POL" ).append("\n"); 
		query.append("        , (SELECT TO_CHAR(SKD.VPS_ETB_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("             FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("            WHERE SKD.VSL_CD      = DECODE(TRNK_VVD.VSL_CD, 'COXX', 'X', 'COYY', 'X', 'COZZ', 'X', TRNK_VVD.VSL_CD)" ).append("\n"); 
		query.append("              AND SKD.SKD_VOY_NO  = TRNK_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND SKD.SKD_DIR_CD  = TRNK_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND SKD.VPS_PORT_CD = TRNK_VVD.POL_CD" ).append("\n"); 
		query.append("              AND SKD.CLPT_IND_SEQ= TRNK_VVD.POL_CLPT_IND_SEQ) TRNK_ETB" ).append("\n"); 
		query.append("        , (SELECT TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD') " ).append("\n"); 
		query.append("             FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("            WHERE SKD.VSL_CD      = DECODE(TRNK_VVD.VSL_CD, 'COXX', 'X', 'COYY', 'X', 'COZZ', 'X', TRNK_VVD.VSL_CD)" ).append("\n"); 
		query.append("              AND SKD.SKD_VOY_NO  = TRNK_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND SKD.SKD_DIR_CD  = TRNK_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND SKD.VPS_PORT_CD = TRNK_VVD.POL_CD" ).append("\n"); 
		query.append("              AND SKD.CLPT_IND_SEQ= TRNK_VVD.POL_CLPT_IND_SEQ) TRNK_ETD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("        , BKG_BL_DOC BL" ).append("\n"); 
		query.append("        , BKG_VVD N1ST_VVD" ).append("\n"); 
		query.append("        , BKG_VVD TRNK_VVD" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = N1ST_VVD.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'S'       = N1ST_VVD.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("   AND 1         = N1ST_VVD.VSL_SEQ(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = TRNK_VVD.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'T'       = TRNK_VVD.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}