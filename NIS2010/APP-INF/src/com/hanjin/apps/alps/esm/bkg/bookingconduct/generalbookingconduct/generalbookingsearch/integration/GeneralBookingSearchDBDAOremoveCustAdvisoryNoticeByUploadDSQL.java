/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOremoveCustAdvisoryNoticeByUploadDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOremoveCustAdvisoryNoticeByUploadDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기존에 등록된 VVD별 Customer Advisory Notice 대상 정보를 삭제처리한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOremoveCustAdvisoryNoticeByUploadDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOremoveCustAdvisoryNoticeByUploadDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_CUST_AVC_NTC_BL" ).append("\n"); 
		query.append("WHERE BL_NO IN ( SELECT 	DISTINCT BK.BL_NO" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("                          BKG_VVD     BV" ).append("\n"); 
		query.append("                 WHERE BV.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("                 AND   BV.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("                 AND   BV.SKD_DIR_CD IN (${dir_sts_cd})" ).append("\n"); 
		query.append("                 AND   BK.BKG_NO     = BV.BKG_NO" ).append("\n"); 
		query.append("                 AND   BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("AND   SRC_DAT_TP_CD  = 'E'" ).append("\n"); 

	}
}