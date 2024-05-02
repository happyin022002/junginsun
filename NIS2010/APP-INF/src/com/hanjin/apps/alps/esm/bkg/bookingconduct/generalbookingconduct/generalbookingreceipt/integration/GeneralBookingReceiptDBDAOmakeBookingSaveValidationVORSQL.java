/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmakeBookingSaveValidationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.23 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmakeBookingSaveValidationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingSaveValidationVO를 만든다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmakeBookingSaveValidationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmakeBookingSaveValidationVORSQL").append("\n"); 
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
		query.append("SELECT  ' ' BL_MOVE_TP_NM" ).append("\n"); 
		query.append(", ' ' TRO_CFRM_FLG" ).append("\n"); 
		query.append(", ' ' SPCL_CGO_FLG" ).append("\n"); 
		query.append(", ' ' TRNK_LANE_CD" ).append("\n"); 
		query.append(", ' ' CHANGE_FIRST_VVD" ).append("\n"); 
		query.append(", ' ' CHANGE_VVD" ).append("\n"); 
		query.append("--	, ' ' PCTL_NO" ).append("\n"); 
		query.append(", ' ' IS_RATED" ).append("\n"); 
		query.append(", ' ' CA_NEW_CREATION_FLAG" ).append("\n"); 
		query.append(", ' ' CA_RSN_CD" ).append("\n"); 
		query.append(", ' ' CA_REMARK" ).append("\n"); 
		query.append(", ' ' TRUNK_VVD" ).append("\n"); 
		query.append(", ' ' ROUTE_MODIFY_FLAG" ).append("\n"); 
		query.append(", ' ' CUSTOMER_MODIFY_FLAG" ).append("\n"); 
		query.append(", ' ' CONTACT_MODIFY_FLAG" ).append("\n"); 
		query.append(", ' ' QTY_MODIFY_FLAG" ).append("\n"); 
		query.append(", ' ' MODIFY_FLAG" ).append("\n"); 
		query.append(", ' ' CLOSE_BKG_FLAG" ).append("\n"); 
		query.append(", ' ' CLOSE_BKG_MSG" ).append("\n"); 
		query.append(", ' ' SAVE_MSG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}