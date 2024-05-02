/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchUserBkgDefaultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.15 류대영
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

public class GeneralBookingReceiptDBDAOSearchUserBkgDefaultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingCreation화면에서 사용자별 Default 정보 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchUserBkgDefaultRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchUserBkgDefaultRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("RTN_CCT_DP_FLG" ).append("\n"); 
		query.append(",	TML_CCT_DP_FLG" ).append("\n"); 
		query.append(",	DOC_CCT_DP_FLG" ).append("\n"); 
		query.append(",	XPT_CSTMS_CCT_DP_FLG" ).append("\n"); 
		query.append(",	RAIL_CCT_DP_FLG" ).append("\n"); 
		query.append(",	PRN_BL_TP_CD" ).append("\n"); 
		query.append(",	PRN_CHG_TP_CD" ).append("\n"); 
		query.append(",	PRN_CNTR_TP_CD" ).append("\n"); 
		query.append(",	PRN_BL_FACE_KNT" ).append("\n"); 
		query.append(",	PRN_BL_RIDR_KNT" ).append("\n"); 
		query.append(",	DFLT_EML" ).append("\n"); 
		query.append(",	DFLT_PHN_NO" ).append("\n"); 
		query.append(",	DFLT_FAX_NO" ).append("\n"); 
		query.append(",	AN_PRN_RT_FLG" ).append("\n"); 
		query.append(",	AN_RMK" ).append("\n"); 
		query.append(",	DOT_PRN_FLG" ).append("\n"); 
		query.append(",	DRFT_BL_XCH_RT_DP_FLG" ).append("\n"); 
		query.append(",	DRFT_BL_CALL_SGN_DP_FLG" ).append("\n"); 
		query.append(",	DRFT_BL_MRN_NO_DP_FLG" ).append("\n"); 
		query.append(",	DRFT_BL_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	USR_ID" ).append("\n"); 
		query.append(",	TRNK_VSL_CD" ).append("\n"); 
		query.append(",	TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",	TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",	BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	FULL_RTN_YD_CD" ).append("\n"); 
		query.append(",	MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	MEAS_UT_CD" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	PRE_VSL_CD" ).append("\n"); 
		query.append(",	PRE_SKD_VOY_NO" ).append("\n"); 
		query.append(",	PRE_SKD_DIR_CD" ).append("\n"); 
		query.append(",	FWRD_FLG" ).append("\n"); 
		query.append(",   AUTO_EDI_HLD_FLG" ).append("\n"); 
		query.append("FROM BKG_USR_DFLT_SET" ).append("\n"); 
		query.append("WHERE	USR_ID = @[usr_id]" ).append("\n"); 

	}
}