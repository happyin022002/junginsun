/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyCARollOvrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.09 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyCARollOvrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify last CA status as like fisrt time.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyCARollOvrUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyCARollOvrUSQL").append("\n"); 
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
		query.append("UPDATE BKG_ROLL_OVR" ).append("\n"); 
		query.append("   SET ( NEW_VSL_CD" ).append("\n"); 
		query.append("       , NEW_SKD_VOY_NO" ).append("\n"); 
		query.append("       , NEW_SKD_DIR_CD" ).append("\n"); 
		query.append("       , NEW_ETD_DT" ).append("\n"); 
		query.append("       , ROLL_OVR_RSN_CD" ).append("\n"); 
		query.append("       , DIFF_RMK" ).append("\n"); 
		query.append("       , EVNT_USR_ID" ).append("\n"); 
		query.append("       , EVNT_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("     = " ).append("\n"); 
		query.append("       (SELECT '' NEW_VSL_CD" ).append("\n"); 
		query.append("             , '' NEW_SKD_VOY_NO" ).append("\n"); 
		query.append("             , '' NEW_SKD_DIR_CD" ).append("\n"); 
		query.append("             , '' NEW_ETD_DT" ).append("\n"); 
		query.append("             , '' ROLL_OVR_RSN_CD" ).append("\n"); 
		query.append("             , '' DIFF_RMK" ).append("\n"); 
		query.append("             , CRE_USR_ID EVNT_USR_ID" ).append("\n"); 
		query.append("             , GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),CRE_DT,BKG_COM_USER_LOC_FNC(CRE_USR_ID))EVNT_DT" ).append("\n"); 
		query.append("             , CRE_USR_ID UPD_USR_ID" ).append("\n"); 
		query.append("             , CRE_DT UPD_DT" ).append("\n"); 
		query.append("          FROM( SELECT CRE_USR_ID " ).append("\n"); 
		query.append("                     , CRE_DT" ).append("\n"); 
		query.append("                     , RANK() OVER(ORDER BY UPD_DT DESC) RNK  " ).append("\n"); 
		query.append("                 FROM BKG_ROLL_OVR " ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				 AND ROLL_OVR_SEQ = (SELECT DECODE(MAX(ROLL_OVR_SEQ)-1,0,1,MAX(ROLL_OVR_SEQ)-1) FROM BKG_ROLL_OVR WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append(" AND ROLL_OVR_SEQ = (SELECT MAX(ROLL_OVR_SEQ) FROM BKG_ROLL_OVR WHERE BKG_NO = @[bkg_no])" ).append("\n"); 

	}
}