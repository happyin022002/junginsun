/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchBkgReceiptTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17 
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

public class GeneralBookingSearchDBDAOsearchBkgReceiptTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgReceiptType
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchBkgReceiptTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchBkgReceiptTypeRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL((SELECT OFC.OFC_CD " ).append("\n"); 
		query.append("                    FROM COM_USER USR, MDM_ORGANIZATION OFC, MDM_LOCATION LOC" ).append("\n"); 
		query.append("                   WHERE USR.OFC_CD = OFC.OFC_CD" ).append("\n"); 
		query.append("                     AND OFC.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("                     AND LOC.RGN_CD IN ('CNS', 'HKG', 'CNN','TWN')" ).append("\n"); 
		query.append("                     AND USR.USR_ID = @[usr_id]), 'N'), 'N', 'Normal', 'China') RECEIPT_TYPE_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}