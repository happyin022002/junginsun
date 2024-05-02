/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgReceiptTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.17 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgReceiptTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgReceiptType
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgReceiptTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration ").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgReceiptTypeRSQL").append("\n"); 
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
		query.append("SELECT OFC.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION OFC, MDM_LOCATION LOC" ).append("\n"); 
		query.append("WHERE OFC.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND LOC.RGN_CD IN ('CNS', 'HKG', 'MAC')" ).append("\n"); 
		query.append("AND OFC.OFC_CD = @[usr_ofc_cd]" ).append("\n"); 

	}
}