/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyNonDgChemForChinaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.06.13 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyNonDgChemForChinaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 북중국 Non DG Chemical Flag 업데이트
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyNonDgChemForChinaUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyNonDgChemForChinaUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET NON_DG_CHEM_FLG = 'Y'" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND OB_SLS_OFC_CD IN ( SELECT REP.OFC_CD " ).append("\n"); 
		query.append("                            FROM MDM_SLS_REP      REP" ).append("\n"); 
		query.append("                               , MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                               , MDM_LOCATION     LOC" ).append("\n"); 
		query.append("                           WHERE REP.OFC_CD  = ORG.OFC_CD" ).append("\n"); 
		query.append("                             AND ORG.OFC_TP_CD IN ('BS','BB')" ).append("\n"); 
		query.append("                             AND LOC.LOC_CD  = ORG.LOC_CD" ).append("\n"); 
		query.append("                             AND RGN_CD      = 'CNN' " ).append("\n"); 
		query.append("                        ) -- L.OFC 가 북중국 지역" ).append("\n"); 
		query.append("   AND CMDT_CD = '380036' --(CHEMICALS, NON-HAZARDOUS, NOS)  " ).append("\n"); 

	}
}