/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOcheckAkwardOverWgtFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.30 
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

public class GeneralBookingSearchDBDAOcheckAkwardOverWgtFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2017.11.17 iylee S/I이후, 
	  * Akward Cargo에 매칭된 Container Weight 와 Booking Container Weight 
	  * 가 한 건이라도 20% 이상 차이가 나는지 여부.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOcheckAkwardOverWgtFlgRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOcheckAkwardOverWgtFlgRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    'Y' AWK_OVER_WGT_FLG" ).append("\n"); 
		query.append("FROM (        " ).append("\n"); 
		query.append("        SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("               CNTR.CNTR_WGT," ).append("\n"); 
		query.append("               AWK.GRS_WGT," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("                   CASE" ).append("\n"); 
		query.append("                        WHEN CNTR.CNTR_WGT >= AWK.GRS_WGT THEN TRUNC(((NVL(CNTR.CNTR_WGT / DECODE(AWK.GRS_WGT, 0, NULL, AWK.GRS_WGT), 0)) - 1), 2)" ).append("\n"); 
		query.append("                        WHEN CNTR.CNTR_WGT < AWK.GRS_WGT THEN  TRUNC(((NVL(AWK.GRS_WGT / DECODE(CNTR.CNTR_WGT, 0, NULL, CNTR.CNTR_WGT), 0)) - 1), 2)" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                    END DIFF_WGT" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("             BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("             BKG_AWK_CGO AWK" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("          AND CNTR.BKG_NO = AWK.BKG_NO" ).append("\n"); 
		query.append("          AND CNTR.CNTR_NO = AWK.CNTR_NO" ).append("\n"); 
		query.append("          AND BKG.XTER_SI_REF_NO IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE DIFF_WGT > 0.2" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}