/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchMaxTroQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.11 
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

public class GeneralBookingReceiptDBDAOSearchMaxTroQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO_QTY 를 체크하여 BKG_QTY 가 그 보다 작아지지 않도록 한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchMaxTroQtyRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchMaxTroQtyRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , MAX(TRO_QTY) OB_TRO_QTY" ).append("\n"); 
		query.append("  FROM ( SELECT TRO.BKG_NO                  BKG_NO" ).append("\n"); 
		query.append("              , TRO.CNTR_TPSZ_CD            CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , SUM(NVL(TRO.TRO_QTY,0))     TRO_QTY" ).append("\n"); 
		query.append("           FROM BKG_TRO_DTL  TRO" ).append("\n"); 
		query.append("          WHERE TRO.RTN_TRO_FLG  = 'N'" ).append("\n"); 
		query.append("            AND TRO.CXL_FLG      = 'N'" ).append("\n"); 
		query.append("            AND TRO.IO_BND_CD    = 'O'" ).append("\n"); 
		query.append("            AND TRO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          GROUP BY TRO.BKG_NO, TRO.CNTR_TPSZ_CD          " ).append("\n"); 
		query.append("         UNION ALL          " ).append("\n"); 
		query.append("         SELECT TRO.BKG_NO                  BKG_NO" ).append("\n"); 
		query.append("              , TRO.CNTR_TPSZ_CD            CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , SUM(NVL(TRO.TRO_QTY,0))     TRO_QTY" ).append("\n"); 
		query.append("           FROM BKG_TRO_DTL  TRO" ).append("\n"); 
		query.append("          WHERE TRO.RTN_TRO_FLG  = 'N'" ).append("\n"); 
		query.append("            AND TRO.CXL_FLG      = 'N'" ).append("\n"); 
		query.append("            AND TRO.IO_BND_CD    = 'I'" ).append("\n"); 
		query.append("            AND TRO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          GROUP BY TRO.BKG_NO, TRO.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE NOT EXISTS (SELECT '1' -- BKG_VALIDATION 에 OFF 있으면 Null" ).append("\n"); 
		query.append("                     FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                    WHERE HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = 'MAX_TRO_QTY_CHK'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT2 = 'OFF')" ).append("\n"); 
		query.append(" GROUP BY BKG_NO, CNTR_TPSZ_CD" ).append("\n"); 

	}
}