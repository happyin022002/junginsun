/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOchkSmsRequirementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.03.04 류대영
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

public class GeneralBookingReceiptDBDAOchkSmsRequirementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOchkSmsRequirementRSQL
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOchkSmsRequirementRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOchkSmsRequirementRSQL").append("\n"); 
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
		query.append("  FROM BKG_CSTMS_TML_EDI_SND_LOG A" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.FNL_EDI_SND_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.POL_CD IN ('KRPUS', 'KRKAN')" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING C" ).append("\n"); 
		query.append("                WHERE C.POL_CD IN ('KRPUS', 'KRKAN')" ).append("\n"); 
		query.append("                  AND C.BKG_NO = @[bkg_no]) " ).append("\n"); 
		query.append("   AND A.KR_CLL_TS_CD IS NULL" ).append("\n"); 

	}
}