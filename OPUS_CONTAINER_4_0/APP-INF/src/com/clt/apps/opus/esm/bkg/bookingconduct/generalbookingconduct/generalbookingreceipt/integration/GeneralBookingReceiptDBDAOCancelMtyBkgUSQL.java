/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCancelMtyBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2011.03.02 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeIlMin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCancelMtyBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Cancel
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCancelMtyBkgUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCancelMtyBkgUSQL").append("\n"); 
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
		query.append("update bkg_booking" ).append("\n"); 
		query.append("   set bkg_sts_cd = 'X'" ).append("\n"); 
		query.append("	, BKG_CXL_DT  = GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),sysdate,BKG_COM_USER_LOC_FNC(@[usr_id]))" ).append("\n"); 
		query.append("	, BKG_CXL_GDT = GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), sysdate, 'GMT')" ).append("\n"); 
		query.append("    , UPD_USR_ID  = @[usr_id]" ).append("\n"); 
		query.append("    , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(" where bkg_no        = @[bkg_no]" ).append("\n"); 
		query.append("   and bkg_cgo_tp_cd = 'P'" ).append("\n"); 

	}
}