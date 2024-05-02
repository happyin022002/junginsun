/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchLaneSteStreetPoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.10.31 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchLaneSteStreetPoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * state, street/po validation에 해당하는 lane인지 조회한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchLaneSteStreetPoRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOsearchLaneSteStreetPoRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("  FROM BKG_VVD_HIS VVD, VSK_VSL_SKD VSL, BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append(" WHERE VVD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  FROM BKG_VVD VVD, VSK_VSL_SKD VSL, BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND HRD.HRD_CDG_ID = 'LANE_STE_STREET_PO'" ).append("\n"); 
		query.append("   AND VSL.VSL_SLAN_CD = HRD.ATTR_CTNT1" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}