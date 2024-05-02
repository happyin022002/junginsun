/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAORemoveAfterBookingFileUploadDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAORemoveAfterBookingFileUploadDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAORemoveAfterBookingFileUpload
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAORemoveAfterBookingFileUploadDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_file_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_rmk_lvl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAORemoveAfterBookingFileUploadDSQL").append("\n"); 
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
		query.append("DELETE FROM DMT_AFT_BKG_FILE_RQST" ).append("\n"); 
		query.append("WHERE AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND 0 < DECODE(@[aft_bkg_rmk_lvl],'remove'," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("             SELECT COUNT(*)" ).append("\n"); 
		query.append("               FROM DMT_AFT_BKG_RSN_RMK_RQST" ).append("\n"); 
		query.append("              WHERE AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("                AND AFT_BKG_FILE_DIV_CD != @[aft_bkg_file_div_cd] ), 1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  FILE_SAV_ID   = DECODE(@[aft_bkg_rmk_lvl],'remove',FILE_SAV_ID,@[file_sav_id])" ).append("\n"); 

	}
}