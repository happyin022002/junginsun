/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgStaffEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.24 
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

public class GeneralBookingReceiptDBDAOSearchBkgStaffEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBSearchBkgStaffEmlRSQL
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgStaffEmlRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgStaffEmlRSQL").append("\n"); 
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
		query.append("SELECT (BKG_JOIN_FNC(CURSOR(SELECT DISTINCT EML " ).append("\n"); 
		query.append("                              FROM (" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                                        SELECT CTRT_SREP_CD CD" ).append("\n"); 
		query.append("                                             , MDM.SREP_EML EML" ).append("\n"); 
		query.append("                                          FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append("                                             , MDM_SLS_REP  MDM" ).append("\n"); 
		query.append("                                         WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                           AND BK.CTRT_SREP_CD = MDM.SREP_CD" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        UNION ALL" ).append("\n"); 
		query.append("                                        SELECT OB_SREP_CD   CD" ).append("\n"); 
		query.append("                                             , MDM.SREP_EML EML" ).append("\n"); 
		query.append("                                          FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append("                                             , MDM_SLS_REP  MDM" ).append("\n"); 
		query.append("                                         WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                           AND BK.OB_SREP_CD = MDM.SREP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("                             WHERE EML IS NOT NULL" ).append("\n"); 
		query.append("                            ),';')" ).append("\n"); 
		query.append("        ) EML" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}