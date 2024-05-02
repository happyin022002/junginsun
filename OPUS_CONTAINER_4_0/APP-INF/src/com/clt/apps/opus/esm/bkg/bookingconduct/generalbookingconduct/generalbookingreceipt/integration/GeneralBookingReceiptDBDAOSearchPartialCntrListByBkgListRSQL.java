/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchPartialCntrListByBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.02 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchPartialCntrListByBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Booking에 속한 Container가 다른 Booking에 속해있는 Container 조회.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchPartialCntrListByBkgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchPartialCntrListByBkgListRSQL").append("\n"); 
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
		query.append("select distinct cntr_no" ).append("\n"); 
		query.append("from bkg_container" ).append("\n"); 
		query.append("WHERE BKG_NO IN (" ).append("\n"); 
		query.append("#if (${bkg_no} != \"\")" ).append("\n"); 
		query.append("#foreach($bkg_no_List IN ${bkg_no})" ).append("\n"); 
		query.append("'$bkg_no_List'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("''" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}