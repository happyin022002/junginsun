/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchVenderEdiBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchVenderEdiBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOsearchVenderEdiBkg
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchVenderEdiBkgRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchVenderEdiBkgRSQL").append("\n"); 
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
		query.append("SELECT 'Y' AS OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   , MDM_LOCATION ML   " ).append("\n"); 
		query.append("WHERE BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append(" AND BK.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append(" AND ((NOT EXISTS (SELECT 'X' FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO " ).append("\n"); 
		query.append("                                                 AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("                                                 AND NVL(DG.SPCL_CGO_APRO_CD,'N') IN ('N', 'R', 'P'))" ).append("\n"); 
		query.append("      AND CASE WHEN ML.CONTI_CD||BK.DCGO_FLG = 'EY' THEN (SELECT COUNT(*) FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO)" ).append("\n"); 
		query.append("          ELSE 1 END > 0" ).append("\n"); 
		query.append("      AND CASE WHEN ML.CONTI_CD||BK.DCGO_FLG = 'EY' THEN (SELECT COUNT(*) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = BK.BKG_NO) " ).append("\n"); 
		query.append("          ELSE 1 END > 0" ).append("\n"); 
		query.append("	  AND NOT EXISTS (SELECT 'X' FROM BKG_DG_CGO DG WHERE BK.BKG_NO = DG.BKG_NO " ).append("\n"); 
		query.append("                                                      AND ML.CONTI_CD = 'E' AND DG.CNTR_NO IS NULL) " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      OR EXISTS (SELECT 'X' FROM BKG_NTC_HIS BNH WHERE BNH.BKG_NO = BK.BKG_NO AND BNH.NTC_VIA_CD = 'E' AND BNH.NTC_KND_CD = 'BT')     " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append(" AND CASE WHEN ML.CONTI_CD||BK.RCV_TERM_CD = 'ED' THEN " ).append("\n"); 
		query.append("        (SELECT COUNT(*) FROM BKG_NTC_HIS BNH WHERE BNH.BKG_NO = BK.BKG_NO AND BNH.NTC_VIA_CD = 'E' AND BNH.NTC_KND_CD = 'BT')" ).append("\n"); 
		query.append("        +(SELECT COUNT(*) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("     ELSE 1 END > 0" ).append("\n"); 
		query.append("  AND BK.EDI_HLD_FLG ='N'" ).append("\n"); 
		query.append("  AND ROWNUM =1" ).append("\n"); 

	}
}